package com.google.crypto.tink.shaded.protobuf;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
class IterableByteBufferInputStream extends InputStream {
    private long currentAddress;
    private byte[] currentArray;
    private int currentArrayOffset;
    private ByteBuffer currentByteBuffer;
    private int currentByteBufferPos;
    private int currentIndex;
    private int dataSize = 0;
    private boolean hasArray;
    private Iterator<ByteBuffer> iterator;

    IterableByteBufferInputStream(Iterable<ByteBuffer> iterable) {
        this.iterator = iterable.iterator();
        for (ByteBuffer byteBuffer : iterable) {
            this.dataSize++;
        }
        this.currentIndex = -1;
        if (getNextByteBuffer()) {
            return;
        }
        this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
        this.currentIndex = 0;
        this.currentByteBufferPos = 0;
        this.currentAddress = 0L;
    }

    private boolean getNextByteBuffer() {
        this.currentIndex++;
        if (!this.iterator.hasNext()) {
            return false;
        }
        ByteBuffer next = this.iterator.next();
        this.currentByteBuffer = next;
        this.currentByteBufferPos = next.position();
        if (this.currentByteBuffer.hasArray()) {
            this.hasArray = true;
            this.currentArray = this.currentByteBuffer.array();
            this.currentArrayOffset = this.currentByteBuffer.arrayOffset();
        } else {
            this.hasArray = false;
            this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentArray = null;
        }
        return true;
    }

    private void updateCurrentByteBufferPos(int i3) {
        int i4 = this.currentByteBufferPos + i3;
        this.currentByteBufferPos = i4;
        if (i4 == this.currentByteBuffer.limit()) {
            getNextByteBuffer();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.currentIndex == this.dataSize) {
            return -1;
        }
        int i3 = (this.hasArray ? this.currentArray[this.currentByteBufferPos + this.currentArrayOffset] : UnsafeUtil.getByte(this.currentByteBufferPos + this.currentAddress)) & UnsignedBytes.MAX_VALUE;
        updateCurrentByteBufferPos(1);
        return i3;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        if (this.currentIndex == this.dataSize) {
            return -1;
        }
        int limit = this.currentByteBuffer.limit();
        int i5 = this.currentByteBufferPos;
        int i6 = limit - i5;
        if (i4 > i6) {
            i4 = i6;
        }
        if (this.hasArray) {
            System.arraycopy(this.currentArray, i5 + this.currentArrayOffset, bArr, i3, i4);
        } else {
            int position = this.currentByteBuffer.position();
            this.currentByteBuffer.position(this.currentByteBufferPos);
            this.currentByteBuffer.get(bArr, i3, i4);
            this.currentByteBuffer.position(position);
        }
        updateCurrentByteBufferPos(i4);
        return i4;
    }
}
