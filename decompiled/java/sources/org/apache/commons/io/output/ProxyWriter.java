package org.apache.commons.io.output;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: /root/release/classes2.dex */
public class ProxyWriter extends FilterWriter {
    public ProxyWriter(Writer writer) {
        super(writer);
    }

    protected void afterWrite(int i3) {
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c3) {
        try {
            beforeWrite(1);
            ((FilterWriter) this).out.append(c3);
            afterWrite(1);
        } catch (IOException e3) {
            handleIOException(e3);
        }
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        int i3 = 0;
        if (charSequence != null) {
            try {
                i3 = charSequence.length();
            } catch (IOException e3) {
                handleIOException(e3);
            }
        }
        beforeWrite(i3);
        ((FilterWriter) this).out.append(charSequence);
        afterWrite(i3);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i3, int i4) {
        int i5 = i4 - i3;
        try {
            beforeWrite(i5);
            ((FilterWriter) this).out.append(charSequence, i3, i4);
            afterWrite(i5);
        } catch (IOException e3) {
            handleIOException(e3);
        }
        return this;
    }

    protected void beforeWrite(int i3) {
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            ((FilterWriter) this).out.close();
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Flushable
    public void flush() {
        try {
            ((FilterWriter) this).out.flush();
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }

    protected void handleIOException(IOException iOException) {
        throw iOException;
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(int i3) {
        try {
            beforeWrite(1);
            ((FilterWriter) this).out.write(i3);
            afterWrite(1);
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }

    @Override // java.io.Writer
    public void write(String str) {
        int i3 = 0;
        if (str != null) {
            try {
                i3 = str.length();
            } catch (IOException e3) {
                handleIOException(e3);
                return;
            }
        }
        beforeWrite(i3);
        ((FilterWriter) this).out.write(str);
        afterWrite(i3);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(String str, int i3, int i4) {
        try {
            beforeWrite(i4);
            ((FilterWriter) this).out.write(str, i3, i4);
            afterWrite(i4);
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        int i3 = 0;
        if (cArr != null) {
            try {
                i3 = cArr.length;
            } catch (IOException e3) {
                handleIOException(e3);
                return;
            }
        }
        beforeWrite(i3);
        ((FilterWriter) this).out.write(cArr);
        afterWrite(i3);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i3, int i4) {
        try {
            beforeWrite(i4);
            ((FilterWriter) this).out.write(cArr, i3, i4);
            afterWrite(i4);
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }
}
