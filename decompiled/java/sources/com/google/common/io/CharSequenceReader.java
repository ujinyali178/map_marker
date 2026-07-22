package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class CharSequenceReader extends Reader {
    private int mark;
    private int pos;

    @CheckForNull
    private CharSequence seq;

    public CharSequenceReader(CharSequence charSequence) {
        this.seq = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    private void checkOpen() {
        if (this.seq == null) {
            throw new IOException("reader closed");
        }
    }

    private boolean hasRemaining() {
        return remaining() > 0;
    }

    private int remaining() {
        Objects.requireNonNull(this.seq);
        return this.seq.length() - this.pos;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.seq = null;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i3) {
        Preconditions.checkArgument(i3 >= 0, "readAheadLimit (%s) may not be negative", i3);
        checkOpen();
        this.mark = this.pos;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public synchronized int read() {
        char c3;
        checkOpen();
        Objects.requireNonNull(this.seq);
        if (hasRemaining()) {
            CharSequence charSequence = this.seq;
            int i3 = this.pos;
            this.pos = i3 + 1;
            c3 = charSequence.charAt(i3);
        } else {
            c3 = 65535;
        }
        return c3;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer charBuffer) {
        Preconditions.checkNotNull(charBuffer);
        checkOpen();
        Objects.requireNonNull(this.seq);
        if (!hasRemaining()) {
            return -1;
        }
        int min = Math.min(charBuffer.remaining(), remaining());
        for (int i3 = 0; i3 < min; i3++) {
            CharSequence charSequence = this.seq;
            int i4 = this.pos;
            this.pos = i4 + 1;
            charBuffer.put(charSequence.charAt(i4));
        }
        return min;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cArr, int i3, int i4) {
        Preconditions.checkPositionIndexes(i3, i3 + i4, cArr.length);
        checkOpen();
        Objects.requireNonNull(this.seq);
        if (!hasRemaining()) {
            return -1;
        }
        int min = Math.min(i4, remaining());
        for (int i5 = 0; i5 < min; i5++) {
            CharSequence charSequence = this.seq;
            int i6 = this.pos;
            this.pos = i6 + 1;
            cArr[i3 + i5] = charSequence.charAt(i6);
        }
        return min;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() {
        checkOpen();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() {
        checkOpen();
        this.pos = this.mark;
    }

    @Override // java.io.Reader
    public synchronized long skip(long j3) {
        int min;
        Preconditions.checkArgument(j3 >= 0, "n (%s) may not be negative", j3);
        checkOpen();
        min = (int) Math.min(remaining(), j3);
        this.pos += min;
        return min;
    }
}
