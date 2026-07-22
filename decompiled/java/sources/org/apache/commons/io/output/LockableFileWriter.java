package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

/* loaded from: /root/release/classes2.dex */
public class LockableFileWriter extends Writer {
    private static final String LCK = ".lck";
    private final File lockFile;
    private final Writer out;

    public LockableFileWriter(File file) {
        this(file, false, (String) null);
    }

    public LockableFileWriter(File file, String str) {
        this(file, str, false, (String) null);
    }

    public LockableFileWriter(File file, String str, boolean z3, String str2) {
        this(file, Charsets.toCharset(str), z3, str2);
    }

    public LockableFileWriter(File file, Charset charset) {
        this(file, charset, false, (String) null);
    }

    public LockableFileWriter(File file, Charset charset, boolean z3, String str) {
        File absoluteFile = file.getAbsoluteFile();
        if (absoluteFile.getParentFile() != null) {
            FileUtils.forceMkdir(absoluteFile.getParentFile());
        }
        if (absoluteFile.isDirectory()) {
            throw new IOException("File specified is a directory");
        }
        File file2 = new File(str == null ? System.getProperty("java.io.tmpdir") : str);
        FileUtils.forceMkdir(file2);
        testLockDir(file2);
        this.lockFile = new File(file2, absoluteFile.getName() + LCK);
        createLock();
        this.out = initWriter(absoluteFile, charset, z3);
    }

    public LockableFileWriter(File file, boolean z3) {
        this(file, z3, (String) null);
    }

    @Deprecated
    public LockableFileWriter(File file, boolean z3, String str) {
        this(file, Charset.defaultCharset(), z3, str);
    }

    public LockableFileWriter(String str) {
        this(str, false, (String) null);
    }

    public LockableFileWriter(String str, boolean z3) {
        this(str, z3, (String) null);
    }

    public LockableFileWriter(String str, boolean z3, String str2) {
        this(new File(str), z3, str2);
    }

    private void createLock() {
        synchronized (LockableFileWriter.class) {
            if (!this.lockFile.createNewFile()) {
                throw new IOException("Can't write file, lock " + this.lockFile.getAbsolutePath() + " exists");
            }
            this.lockFile.deleteOnExit();
        }
    }

    private Writer initWriter(File file, Charset charset, boolean z3) {
        boolean exists = file.exists();
        try {
            return new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath(), z3), Charsets.toCharset(charset));
        } catch (IOException | RuntimeException e3) {
            FileUtils.deleteQuietly(this.lockFile);
            if (!exists) {
                FileUtils.deleteQuietly(file);
            }
            throw e3;
        }
    }

    private void testLockDir(File file) {
        if (!file.exists()) {
            throw new IOException("Could not find lockDir: " + file.getAbsolutePath());
        }
        if (file.canWrite()) {
            return;
        }
        throw new IOException("Could not write to lockDir: " + file.getAbsolutePath());
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.out.close();
        } finally {
            this.lockFile.delete();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        this.out.flush();
    }

    @Override // java.io.Writer
    public void write(int i3) {
        this.out.write(i3);
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.out.write(str);
    }

    @Override // java.io.Writer
    public void write(String str, int i3, int i4) {
        this.out.write(str, i3, i4);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        this.out.write(cArr);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i4) {
        this.out.write(cArr, i3, i4);
    }
}
