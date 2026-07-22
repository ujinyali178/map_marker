package org.apache.commons.io.input;

import java.io.Reader;

/* loaded from: /root/release/classes2.dex */
public class BoundedReader extends Reader {
    private static final int INVALID = -1;
    private int charsRead = 0;
    private int markedAt = -1;
    private final int maxCharsFromTargetReader;
    private int readAheadLimit;
    private final Reader target;

    public BoundedReader(Reader reader, int i3) {
        this.target = reader;
        this.maxCharsFromTargetReader = i3;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.target.close();
    }

    @Override // java.io.Reader
    public void mark(int i3) {
        int i4 = this.charsRead;
        this.readAheadLimit = i3 - i4;
        this.markedAt = i4;
        this.target.mark(i3);
    }

    @Override // java.io.Reader
    public int read() {
        int i3 = this.charsRead;
        if (i3 >= this.maxCharsFromTargetReader) {
            return -1;
        }
        int i4 = this.markedAt;
        if (i4 >= 0 && i3 - i4 >= this.readAheadLimit) {
            return -1;
        }
        this.charsRead = i3 + 1;
        return this.target.read();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int read = read();
            if (read == -1) {
                if (i5 == 0) {
                    return -1;
                }
                return i5;
            }
            cArr[i3 + i5] = (char) read;
        }
        return i4;
    }

    @Override // java.io.Reader
    public void reset() {
        this.charsRead = this.markedAt;
        this.target.reset();
    }
}
