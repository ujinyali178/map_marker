package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.EOFException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class CharStreams {
    private static final int DEFAULT_BUF_SIZE = 2048;

    private static final class NullWriter extends Writer {
        private static final NullWriter INSTANCE = new NullWriter();

        private NullWriter() {
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c3) {
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(@CheckForNull CharSequence charSequence) {
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(@CheckForNull CharSequence charSequence, int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4, charSequence == null ? 4 : charSequence.length());
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(int i3) {
        }

        @Override // java.io.Writer
        public void write(String str) {
            Preconditions.checkNotNull(str);
        }

        @Override // java.io.Writer
        public void write(String str, int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4 + i3, str.length());
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            Preconditions.checkNotNull(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4 + i3, cArr.length);
        }
    }

    private CharStreams() {
    }

    public static Writer asWriter(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }

    public static long copy(Readable readable, Appendable appendable) {
        if (readable instanceof Reader) {
            Reader reader = (Reader) readable;
            return appendable instanceof StringBuilder ? copyReaderToBuilder(reader, (StringBuilder) appendable) : copyReaderToWriter(reader, asWriter(appendable));
        }
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(appendable);
        long j3 = 0;
        CharBuffer createBuffer = createBuffer();
        while (readable.read(createBuffer) != -1) {
            Java8Compatibility.flip(createBuffer);
            appendable.append(createBuffer);
            j3 += createBuffer.remaining();
            Java8Compatibility.clear(createBuffer);
        }
        return j3;
    }

    static long copyReaderToBuilder(Reader reader, StringBuilder sb) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(sb);
        char[] cArr = new char[DEFAULT_BUF_SIZE];
        long j3 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j3;
            }
            sb.append(cArr, 0, read);
            j3 += read;
        }
    }

    static long copyReaderToWriter(Reader reader, Writer writer) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(writer);
        char[] cArr = new char[DEFAULT_BUF_SIZE];
        long j3 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j3;
            }
            writer.write(cArr, 0, read);
            j3 += read;
        }
    }

    static CharBuffer createBuffer() {
        return CharBuffer.allocate(DEFAULT_BUF_SIZE);
    }

    public static long exhaust(Readable readable) {
        CharBuffer createBuffer = createBuffer();
        long j3 = 0;
        while (true) {
            long read = readable.read(createBuffer);
            if (read == -1) {
                return j3;
            }
            j3 += read;
            Java8Compatibility.clear(createBuffer);
        }
    }

    public static Writer nullWriter() {
        return NullWriter.INSTANCE;
    }

    @ParametricNullness
    public static <T> T readLines(Readable readable, LineProcessor<T> lineProcessor) {
        String readLine;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            readLine = lineReader.readLine();
            if (readLine == null) {
                break;
            }
        } while (lineProcessor.processLine(readLine));
        return lineProcessor.getResult();
    }

    public static List<String> readLines(Readable readable) {
        ArrayList arrayList = new ArrayList();
        LineReader lineReader = new LineReader(readable);
        while (true) {
            String readLine = lineReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public static void skipFully(Reader reader, long j3) {
        Preconditions.checkNotNull(reader);
        while (j3 > 0) {
            long skip = reader.skip(j3);
            if (skip == 0) {
                throw new EOFException();
            }
            j3 -= skip;
        }
    }

    public static String toString(Readable readable) {
        return toStringBuilder(readable).toString();
    }

    private static StringBuilder toStringBuilder(Readable readable) {
        StringBuilder sb = new StringBuilder();
        if (readable instanceof Reader) {
            copyReaderToBuilder((Reader) readable, sb);
        } else {
            copy(readable, sb);
        }
        return sb;
    }
}
