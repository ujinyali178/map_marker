package com.google.common.io;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;
import org.apache.commons.io.IOUtils;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Files {
    private static final SuccessorsFunction<File> FILE_TREE = new SuccessorsFunction<File>() { // from class: com.google.common.io.Files.2
        @Override // com.google.common.graph.SuccessorsFunction
        public Iterable<File> successors(File file) {
            File[] listFiles;
            return (!file.isDirectory() || (listFiles = file.listFiles()) == null) ? ImmutableList.of() : Collections.unmodifiableList(Arrays.asList(listFiles));
        }
    };

    private static final class FileByteSink extends ByteSink {
        private final File file;
        private final ImmutableSet<FileWriteMode> modes;

        private FileByteSink(File file, FileWriteMode... fileWriteModeArr) {
            this.file = (File) Preconditions.checkNotNull(file);
            this.modes = ImmutableSet.copyOf(fileWriteModeArr);
        }

        @Override // com.google.common.io.ByteSink
        public FileOutputStream openStream() {
            return new FileOutputStream(this.file, this.modes.contains(FileWriteMode.APPEND));
        }

        public String toString() {
            return "Files.asByteSink(" + this.file + ", " + this.modes + ")";
        }
    }

    private static final class FileByteSource extends ByteSource {
        private final File file;

        private FileByteSource(File file) {
            this.file = (File) Preconditions.checkNotNull(file);
        }

        @Override // com.google.common.io.ByteSource
        public FileInputStream openStream() {
            return new FileInputStream(this.file);
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() {
            try {
                FileInputStream fileInputStream = (FileInputStream) Closer.create().register(openStream());
                return ByteStreams.toByteArray(fileInputStream, fileInputStream.getChannel().size());
            } finally {
            }
        }

        @Override // com.google.common.io.ByteSource
        public long size() {
            if (this.file.isFile()) {
                return this.file.length();
            }
            throw new FileNotFoundException(this.file.toString());
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            return this.file.isFile() ? Optional.of(Long.valueOf(this.file.length())) : Optional.absent();
        }

        public String toString() {
            return "Files.asByteSource(" + this.file + ")";
        }
    }

    private enum FilePredicate implements Predicate<File> {
        IS_DIRECTORY { // from class: com.google.common.io.Files.FilePredicate.1
            @Override // com.google.common.base.Predicate
            public boolean apply(File file) {
                return file.isDirectory();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Files.isDirectory()";
            }
        },
        IS_FILE { // from class: com.google.common.io.Files.FilePredicate.2
            @Override // com.google.common.base.Predicate
            public boolean apply(File file) {
                return file.isFile();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Files.isFile()";
            }
        }
    }

    private Files() {
    }

    @Deprecated
    public static void append(CharSequence charSequence, File file, Charset charset) {
        asCharSink(file, charset, FileWriteMode.APPEND).write(charSequence);
    }

    public static ByteSink asByteSink(File file, FileWriteMode... fileWriteModeArr) {
        return new FileByteSink(file, fileWriteModeArr);
    }

    public static ByteSource asByteSource(File file) {
        return new FileByteSource(file);
    }

    public static CharSink asCharSink(File file, Charset charset, FileWriteMode... fileWriteModeArr) {
        return asByteSink(file, fileWriteModeArr).asCharSink(charset);
    }

    public static CharSource asCharSource(File file, Charset charset) {
        return asByteSource(file).asCharSource(charset);
    }

    public static void copy(File file, File file2) {
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        asByteSource(file).copyTo(asByteSink(file2, new FileWriteMode[0]));
    }

    public static void copy(File file, OutputStream outputStream) {
        asByteSource(file).copyTo(outputStream);
    }

    @Deprecated
    public static void copy(File file, Charset charset, Appendable appendable) {
        asCharSource(file, charset).copyTo(appendable);
    }

    public static void createParentDirs(File file) {
        Preconditions.checkNotNull(file);
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            return;
        }
        throw new IOException("Unable to create parent directories of " + file);
    }

    @Deprecated
    public static File createTempDir() {
        return TempFileCreator.INSTANCE.createTempDir();
    }

    public static boolean equal(File file, File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        if (file == file2 || file.equals(file2)) {
            return true;
        }
        long length = file.length();
        long length2 = file2.length();
        if (length == 0 || length2 == 0 || length == length2) {
            return asByteSource(file).contentEquals(asByteSource(file2));
        }
        return false;
    }

    public static Traverser<File> fileTraverser() {
        return Traverser.forTree(FILE_TREE);
    }

    public static String getFileExtension(String str) {
        Preconditions.checkNotNull(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1);
    }

    public static String getNameWithoutExtension(String str) {
        Preconditions.checkNotNull(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? name : name.substring(0, lastIndexOf);
    }

    @Deprecated
    public static HashCode hash(File file, HashFunction hashFunction) {
        return asByteSource(file).hash(hashFunction);
    }

    public static Predicate<File> isDirectory() {
        return FilePredicate.IS_DIRECTORY;
    }

    public static Predicate<File> isFile() {
        return FilePredicate.IS_FILE;
    }

    public static MappedByteBuffer map(File file) {
        Preconditions.checkNotNull(file);
        return map(file, FileChannel.MapMode.READ_ONLY);
    }

    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode) {
        return mapInternal(file, mapMode, -1L);
    }

    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode, long j3) {
        Preconditions.checkArgument(j3 >= 0, "size (%s) may not be negative", j3);
        return mapInternal(file, mapMode, j3);
    }

    private static MappedByteBuffer mapInternal(File file, FileChannel.MapMode mapMode, long j3) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(mapMode);
        Closer create = Closer.create();
        try {
            FileChannel fileChannel = (FileChannel) create.register(((RandomAccessFile) create.register(new RandomAccessFile(file, mapMode == FileChannel.MapMode.READ_ONLY ? "r" : "rw"))).getChannel());
            if (j3 == -1) {
                j3 = fileChannel.size();
            }
            return fileChannel.map(mapMode, 0L, j3);
        } finally {
        }
    }

    public static void move(File file, File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (file.renameTo(file2)) {
            return;
        }
        copy(file, file2);
        if (file.delete()) {
            return;
        }
        if (file2.delete()) {
            throw new IOException("Unable to delete " + file);
        }
        throw new IOException("Unable to delete " + file2);
    }

    public static BufferedReader newReader(File file, Charset charset) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
    }

    public static BufferedWriter newWriter(File file, Charset charset) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
    }

    @ParametricNullness
    @Deprecated
    public static <T> T readBytes(File file, ByteProcessor<T> byteProcessor) {
        return (T) asByteSource(file).read(byteProcessor);
    }

    @CheckForNull
    @Deprecated
    public static String readFirstLine(File file, Charset charset) {
        return asCharSource(file, charset).readFirstLine();
    }

    @ParametricNullness
    @Deprecated
    public static <T> T readLines(File file, Charset charset, LineProcessor<T> lineProcessor) {
        return (T) asCharSource(file, charset).readLines(lineProcessor);
    }

    public static List<String> readLines(File file, Charset charset) {
        return (List) asCharSource(file, charset).readLines(new LineProcessor<List<String>>() { // from class: com.google.common.io.Files.1
            final List<String> result = Lists.newArrayList();

            @Override // com.google.common.io.LineProcessor
            public List<String> getResult() {
                return this.result;
            }

            @Override // com.google.common.io.LineProcessor
            public boolean processLine(String str) {
                this.result.add(str);
                return true;
            }
        });
    }

    public static String simplifyPath(String str) {
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            return ".";
        }
        Iterable<String> split = Splitter.on(IOUtils.DIR_SEPARATOR_UNIX).omitEmptyStrings().split(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            str2.hashCode();
            if (!str2.equals(".")) {
                if (!str2.equals("..")) {
                    arrayList.add(str2);
                } else if (arrayList.size() <= 0 || ((String) arrayList.get(arrayList.size() - 1)).equals("..")) {
                    arrayList.add("..");
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        String join = Joiner.on(IOUtils.DIR_SEPARATOR_UNIX).join(arrayList);
        if (str.charAt(0) == '/') {
            join = "/" + join;
        }
        while (join.startsWith("/../")) {
            join = join.substring(3);
        }
        return join.equals("/..") ? "/" : "".equals(join) ? "." : join;
    }

    public static byte[] toByteArray(File file) {
        return asByteSource(file).read();
    }

    @Deprecated
    public static String toString(File file, Charset charset) {
        return asCharSource(file, charset).read();
    }

    public static void touch(File file) {
        Preconditions.checkNotNull(file);
        if (file.createNewFile() || file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to update modification time of " + file);
    }

    @Deprecated
    public static void write(CharSequence charSequence, File file, Charset charset) {
        asCharSink(file, charset, new FileWriteMode[0]).write(charSequence);
    }

    public static void write(byte[] bArr, File file) {
        asByteSink(file, new FileWriteMode[0]).write(bArr);
    }
}
