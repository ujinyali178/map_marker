package org.apache.commons.io.output;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.input.ClosedInputStream;

/* loaded from: /root/release/classes2.dex */
public class ByteArrayOutputStream extends OutputStream {
    static final int DEFAULT_SIZE = 1024;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final List<byte[]> buffers;
    private int count;
    private byte[] currentBuffer;
    private int currentBufferIndex;
    private int filledBufferSum;
    private boolean reuseBuffers;

    public ByteArrayOutputStream() {
        this(1024);
    }

    public ByteArrayOutputStream(int i3) {
        this.buffers = new ArrayList();
        this.reuseBuffers = true;
        if (i3 >= 0) {
            synchronized (this) {
                needNewBuffer(i3);
            }
        } else {
            throw new IllegalArgumentException("Negative initial size: " + i3);
        }
    }

    private void needNewBuffer(int i3) {
        int length;
        if (this.currentBufferIndex < this.buffers.size() - 1) {
            this.filledBufferSum += this.currentBuffer.length;
            int i4 = this.currentBufferIndex + 1;
            this.currentBufferIndex = i4;
            this.currentBuffer = this.buffers.get(i4);
            return;
        }
        byte[] bArr = this.currentBuffer;
        if (bArr == null) {
            length = 0;
        } else {
            i3 = Math.max(bArr.length << 1, i3 - this.filledBufferSum);
            length = this.filledBufferSum + this.currentBuffer.length;
        }
        this.filledBufferSum = length;
        this.currentBufferIndex++;
        byte[] bArr2 = new byte[i3];
        this.currentBuffer = bArr2;
        this.buffers.add(bArr2);
    }

    public static InputStream toBufferedInputStream(InputStream inputStream) {
        return toBufferedInputStream(inputStream, 1024);
    }

    public static InputStream toBufferedInputStream(InputStream inputStream, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        byteArrayOutputStream.write(inputStream);
        return byteArrayOutputStream.toInputStream();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public synchronized void reset() {
        this.count = 0;
        this.filledBufferSum = 0;
        this.currentBufferIndex = 0;
        if (this.reuseBuffers) {
            this.currentBuffer = this.buffers.get(0);
        } else {
            this.currentBuffer = null;
            int length = this.buffers.get(0).length;
            this.buffers.clear();
            needNewBuffer(length);
            this.reuseBuffers = true;
        }
    }

    public synchronized int size() {
        return this.count;
    }

    public synchronized byte[] toByteArray() {
        int i3 = this.count;
        if (i3 == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[i3];
        int i4 = 0;
        for (byte[] bArr2 : this.buffers) {
            int min = Math.min(bArr2.length, i3);
            System.arraycopy(bArr2, 0, bArr, i4, min);
            i4 += min;
            i3 -= min;
            if (i3 == 0) {
                break;
            }
        }
        return bArr;
    }

    public synchronized InputStream toInputStream() {
        int i3 = this.count;
        if (i3 == 0) {
            return new ClosedInputStream();
        }
        ArrayList arrayList = new ArrayList(this.buffers.size());
        for (byte[] bArr : this.buffers) {
            int min = Math.min(bArr.length, i3);
            arrayList.add(new ByteArrayInputStream(bArr, 0, min));
            i3 -= min;
            if (i3 == 0) {
                break;
            }
        }
        this.reuseBuffers = false;
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    @Deprecated
    public String toString() {
        return new String(toByteArray(), Charset.defaultCharset());
    }

    public String toString(String str) {
        return new String(toByteArray(), str);
    }

    public String toString(Charset charset) {
        return new String(toByteArray(), charset);
    }

    public synchronized int write(InputStream inputStream) {
        int i3;
        int i4 = this.count - this.filledBufferSum;
        byte[] bArr = this.currentBuffer;
        int read = inputStream.read(bArr, i4, bArr.length - i4);
        i3 = 0;
        while (read != -1) {
            i3 += read;
            i4 += read;
            this.count += read;
            byte[] bArr2 = this.currentBuffer;
            if (i4 == bArr2.length) {
                needNewBuffer(bArr2.length);
                i4 = 0;
            }
            byte[] bArr3 = this.currentBuffer;
            read = inputStream.read(bArr3, i4, bArr3.length - i4);
        }
        return i3;
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i3) {
        int i4 = this.count;
        int i5 = i4 - this.filledBufferSum;
        if (i5 == this.currentBuffer.length) {
            needNewBuffer(i4 + 1);
            i5 = 0;
        }
        this.currentBuffer[i5] = (byte) i3;
        this.count++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) {
        int i5;
        if (i3 < 0 || i3 > bArr.length || i4 < 0 || (i5 = i3 + i4) > bArr.length || i5 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i4 == 0) {
            return;
        }
        synchronized (this) {
            int i6 = this.count;
            int i7 = i6 + i4;
            int i8 = i6 - this.filledBufferSum;
            while (i4 > 0) {
                int min = Math.min(i4, this.currentBuffer.length - i8);
                System.arraycopy(bArr, i5 - i4, this.currentBuffer, i8, min);
                i4 -= min;
                if (i4 > 0) {
                    needNewBuffer(i7);
                    i8 = 0;
                }
            }
            this.count = i7;
        }
    }

    public synchronized void writeTo(OutputStream outputStream) {
        int i3 = this.count;
        for (byte[] bArr : this.buffers) {
            int min = Math.min(bArr.length, i3);
            outputStream.write(bArr, 0, min);
            i3 -= min;
            if (i3 == 0) {
                break;
            }
        }
    }
}
