package org.apache.commons.io.input;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* loaded from: /root/release/classes2.dex */
public class ReaderInputStream extends InputStream {
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private final CharsetEncoder encoder;
    private final CharBuffer encoderIn;
    private final ByteBuffer encoderOut;
    private boolean endOfInput;
    private CoderResult lastCoderResult;
    private final Reader reader;

    @Deprecated
    public ReaderInputStream(Reader reader) {
        this(reader, Charset.defaultCharset());
    }

    public ReaderInputStream(Reader reader, String str) {
        this(reader, str, 1024);
    }

    public ReaderInputStream(Reader reader, String str, int i3) {
        this(reader, Charset.forName(str), i3);
    }

    public ReaderInputStream(Reader reader, Charset charset) {
        this(reader, charset, 1024);
    }

    public ReaderInputStream(Reader reader, Charset charset, int i3) {
        this(reader, charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), i3);
    }

    public ReaderInputStream(Reader reader, CharsetEncoder charsetEncoder) {
        this(reader, charsetEncoder, 1024);
    }

    public ReaderInputStream(Reader reader, CharsetEncoder charsetEncoder, int i3) {
        this.reader = reader;
        this.encoder = charsetEncoder;
        CharBuffer allocate = CharBuffer.allocate(i3);
        this.encoderIn = allocate;
        allocate.flip();
        ByteBuffer allocate2 = ByteBuffer.allocate(128);
        this.encoderOut = allocate2;
        allocate2.flip();
    }

    private void fillBuffer() {
        CoderResult coderResult;
        if (!this.endOfInput && ((coderResult = this.lastCoderResult) == null || coderResult.isUnderflow())) {
            this.encoderIn.compact();
            int position = this.encoderIn.position();
            int read = this.reader.read(this.encoderIn.array(), position, this.encoderIn.remaining());
            if (read == -1) {
                this.endOfInput = true;
            } else {
                this.encoderIn.position(position + read);
            }
            this.encoderIn.flip();
        }
        this.encoderOut.compact();
        this.lastCoderResult = this.encoder.encode(this.encoderIn, this.encoderOut, this.endOfInput);
        this.encoderOut.flip();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.reader.close();
    }

    @Override // java.io.InputStream
    public int read() {
        while (!this.encoderOut.hasRemaining()) {
            fillBuffer();
            if (this.endOfInput && !this.encoderOut.hasRemaining()) {
                return -1;
            }
        }
        return this.encoderOut.get() & UnsignedBytes.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        if (bArr == null) {
            throw new NullPointerException("Byte array must not be null");
        }
        if (i4 < 0 || i3 < 0 || i3 + i4 > bArr.length) {
            throw new IndexOutOfBoundsException("Array Size=" + bArr.length + ", offset=" + i3 + ", length=" + i4);
        }
        int i5 = 0;
        if (i4 == 0) {
            return 0;
        }
        while (i4 > 0) {
            if (!this.encoderOut.hasRemaining()) {
                fillBuffer();
                if (this.endOfInput && !this.encoderOut.hasRemaining()) {
                    break;
                }
            } else {
                int min = Math.min(this.encoderOut.remaining(), i4);
                this.encoderOut.get(bArr, i3, min);
                i3 += min;
                i4 -= min;
                i5 += min;
            }
        }
        if (i5 == 0 && this.endOfInput) {
            return -1;
        }
        return i5;
    }
}
