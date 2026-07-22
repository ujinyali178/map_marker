package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* loaded from: /root/release/classes2.dex */
public class WriterOutputStream extends OutputStream {
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private final CharsetDecoder decoder;
    private final ByteBuffer decoderIn;
    private final CharBuffer decoderOut;
    private final boolean writeImmediately;
    private final Writer writer;

    @Deprecated
    public WriterOutputStream(Writer writer) {
        this(writer, Charset.defaultCharset(), 1024, false);
    }

    public WriterOutputStream(Writer writer, String str) {
        this(writer, str, 1024, false);
    }

    public WriterOutputStream(Writer writer, String str, int i3, boolean z3) {
        this(writer, Charset.forName(str), i3, z3);
    }

    public WriterOutputStream(Writer writer, Charset charset) {
        this(writer, charset, 1024, false);
    }

    public WriterOutputStream(Writer writer, Charset charset, int i3, boolean z3) {
        this(writer, charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith("?"), i3, z3);
    }

    public WriterOutputStream(Writer writer, CharsetDecoder charsetDecoder) {
        this(writer, charsetDecoder, 1024, false);
    }

    public WriterOutputStream(Writer writer, CharsetDecoder charsetDecoder, int i3, boolean z3) {
        this.decoderIn = ByteBuffer.allocate(128);
        checkIbmJdkWithBrokenUTF16(charsetDecoder.charset());
        this.writer = writer;
        this.decoder = charsetDecoder;
        this.writeImmediately = z3;
        this.decoderOut = CharBuffer.allocate(i3);
    }

    private static void checkIbmJdkWithBrokenUTF16(Charset charset) {
        if ("UTF-16".equals(charset.name())) {
            byte[] bytes = "vés".getBytes(charset);
            CharsetDecoder newDecoder = charset.newDecoder();
            ByteBuffer allocate = ByteBuffer.allocate(16);
            CharBuffer allocate2 = CharBuffer.allocate(3);
            int length = bytes.length;
            int i3 = 0;
            while (i3 < length) {
                allocate.put(bytes[i3]);
                allocate.flip();
                try {
                    newDecoder.decode(allocate, allocate2, i3 == length + (-1));
                    allocate.compact();
                    i3++;
                } catch (IllegalArgumentException unused) {
                    throw new UnsupportedOperationException("UTF-16 requested when runninng on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
                }
            }
            allocate2.rewind();
            if (!"vés".equals(allocate2.toString())) {
                throw new UnsupportedOperationException("UTF-16 requested when runninng on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
            }
        }
    }

    private void flushOutput() {
        if (this.decoderOut.position() > 0) {
            this.writer.write(this.decoderOut.array(), 0, this.decoderOut.position());
            this.decoderOut.rewind();
        }
    }

    private void processInput(boolean z3) {
        CoderResult decode;
        this.decoderIn.flip();
        while (true) {
            decode = this.decoder.decode(this.decoderIn, this.decoderOut, z3);
            if (!decode.isOverflow()) {
                break;
            } else {
                flushOutput();
            }
        }
        if (!decode.isUnderflow()) {
            throw new IOException("Unexpected coder result");
        }
        this.decoderIn.compact();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        processInput(true);
        flushOutput();
        this.writer.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        flushOutput();
        this.writer.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i3) {
        write(new byte[]{(byte) i3}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) {
        while (i4 > 0) {
            int min = Math.min(i4, this.decoderIn.remaining());
            this.decoderIn.put(bArr, i3, min);
            processInput(false);
            i4 -= min;
            i3 += min;
        }
        if (this.writeImmediately) {
            flushOutput();
        }
    }
}
