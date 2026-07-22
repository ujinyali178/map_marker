package org.apache.commons.io.input;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* loaded from: /root/release/classes2.dex */
public class CharSequenceInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private static final int NO_MARK = -1;
    private final ByteBuffer bbuf;
    private final CharBuffer cbuf;
    private final CharsetEncoder encoder;
    private int mark_bbuf;
    private int mark_cbuf;

    public CharSequenceInputStream(CharSequence charSequence, String str) {
        this(charSequence, str, BUFFER_SIZE);
    }

    public CharSequenceInputStream(CharSequence charSequence, String str, int i3) {
        this(charSequence, Charset.forName(str), i3);
    }

    public CharSequenceInputStream(CharSequence charSequence, Charset charset) {
        this(charSequence, charset, BUFFER_SIZE);
    }

    public CharSequenceInputStream(CharSequence charSequence, Charset charset, int i3) {
        CharsetEncoder onUnmappableCharacter = charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        this.encoder = onUnmappableCharacter;
        float maxBytesPerChar = onUnmappableCharacter.maxBytesPerChar();
        if (i3 < maxBytesPerChar) {
            throw new IllegalArgumentException("Buffer size " + i3 + " is less than maxBytesPerChar " + maxBytesPerChar);
        }
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        this.bbuf = allocate;
        allocate.flip();
        this.cbuf = CharBuffer.wrap(charSequence);
        this.mark_cbuf = -1;
        this.mark_bbuf = -1;
    }

    private void fillBuffer() {
        this.bbuf.compact();
        CoderResult encode = this.encoder.encode(this.cbuf, this.bbuf, true);
        if (encode.isError()) {
            encode.throwException();
        }
        this.bbuf.flip();
    }

    @Override // java.io.InputStream
    public int available() {
        return this.bbuf.remaining() + this.cbuf.remaining();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i3) {
        this.mark_cbuf = this.cbuf.position();
        this.mark_bbuf = this.bbuf.position();
        this.cbuf.mark();
        this.bbuf.mark();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        while (!this.bbuf.hasRemaining()) {
            fillBuffer();
            if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
                return -1;
            }
        }
        return this.bbuf.get() & UnsignedBytes.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        if (bArr == null) {
            throw new NullPointerException("Byte array is null");
        }
        if (i4 < 0 || i3 + i4 > bArr.length) {
            throw new IndexOutOfBoundsException("Array Size=" + bArr.length + ", offset=" + i3 + ", length=" + i4);
        }
        int i5 = 0;
        if (i4 == 0) {
            return 0;
        }
        if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
            return -1;
        }
        while (i4 > 0) {
            if (!this.bbuf.hasRemaining()) {
                fillBuffer();
                if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
                    break;
                }
            } else {
                int min = Math.min(this.bbuf.remaining(), i4);
                this.bbuf.get(bArr, i3, min);
                i3 += min;
                i4 -= min;
                i5 += min;
            }
        }
        if (i5 != 0 || this.cbuf.hasRemaining()) {
            return i5;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        if (this.mark_cbuf != -1) {
            if (this.cbuf.position() != 0) {
                this.encoder.reset();
                this.cbuf.rewind();
                this.bbuf.rewind();
                this.bbuf.limit(0);
                while (this.cbuf.position() < this.mark_cbuf) {
                    this.bbuf.rewind();
                    this.bbuf.limit(0);
                    fillBuffer();
                }
            }
            if (this.cbuf.position() != this.mark_cbuf) {
                throw new IllegalStateException("Unexpected CharBuffer postion: actual=" + this.cbuf.position() + " expected=" + this.mark_cbuf);
            }
            this.bbuf.position(this.mark_bbuf);
            this.mark_cbuf = -1;
            this.mark_bbuf = -1;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j3) {
        long j4 = 0;
        while (j3 > 0 && available() > 0) {
            read();
            j3--;
            j4++;
        }
        return j4;
    }
}
