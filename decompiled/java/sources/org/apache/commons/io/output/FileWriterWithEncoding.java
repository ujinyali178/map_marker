package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.io.FileUtils;

/* loaded from: /root/release/classes2.dex */
public class FileWriterWithEncoding extends Writer {
    private final Writer out;

    public FileWriterWithEncoding(File file, String str) {
        this(file, str, false);
    }

    public FileWriterWithEncoding(File file, String str, boolean z3) {
        this.out = initWriter(file, str, z3);
    }

    public FileWriterWithEncoding(File file, Charset charset) {
        this(file, charset, false);
    }

    public FileWriterWithEncoding(File file, Charset charset, boolean z3) {
        this.out = initWriter(file, charset, z3);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder) {
        this(file, charsetEncoder, false);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder, boolean z3) {
        this.out = initWriter(file, charsetEncoder, z3);
    }

    public FileWriterWithEncoding(String str, String str2) {
        this(new File(str), str2, false);
    }

    public FileWriterWithEncoding(String str, String str2, boolean z3) {
        this(new File(str), str2, z3);
    }

    public FileWriterWithEncoding(String str, Charset charset) {
        this(new File(str), charset, false);
    }

    public FileWriterWithEncoding(String str, Charset charset, boolean z3) {
        this(new File(str), charset, z3);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder) {
        this(new File(str), charsetEncoder, false);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder, boolean z3) {
        this(new File(str), charsetEncoder, z3);
    }

    private static Writer initWriter(File file, Object obj, boolean z3) {
        FileOutputStream fileOutputStream;
        if (file == null) {
            throw new NullPointerException("File is missing");
        }
        if (obj == null) {
            throw new NullPointerException("Encoding is missing");
        }
        FileOutputStream fileOutputStream2 = null;
        boolean exists = file.exists();
        try {
            fileOutputStream = new FileOutputStream(file, z3);
        } catch (IOException e3) {
            e = e3;
        } catch (RuntimeException e4) {
            e = e4;
        }
        try {
            return obj instanceof Charset ? new OutputStreamWriter(fileOutputStream, (Charset) obj) : obj instanceof CharsetEncoder ? new OutputStreamWriter(fileOutputStream, (CharsetEncoder) obj) : new OutputStreamWriter(fileOutputStream, (String) obj);
        } catch (IOException | RuntimeException e5) {
            e = e5;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e6) {
                    e.addSuppressed(e6);
                }
            }
            if (exists) {
                throw e;
            }
            FileUtils.deleteQuietly(file);
            throw e;
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
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
