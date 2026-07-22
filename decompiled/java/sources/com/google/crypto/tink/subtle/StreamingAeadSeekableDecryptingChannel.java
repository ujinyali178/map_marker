package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /root/release/classes.dex */
class StreamingAeadSeekableDecryptingChannel implements SeekableByteChannel {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] aad;
    private final SeekableByteChannel ciphertextChannel;
    private final long ciphertextChannelSize;
    private final int ciphertextOffset;
    private final ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private int currentSegmentNr;
    private final StreamSegmentDecrypter decrypter;
    private final int firstSegmentOffset;
    private final ByteBuffer header;
    private boolean headerRead;
    private boolean isCurrentSegmentDecrypted;
    private boolean isopen;
    private final int lastCiphertextSegmentSize;
    private final int numberOfSegments;
    private long plaintextPosition;
    private final ByteBuffer plaintextSegment;
    private final int plaintextSegmentSize;
    private long plaintextSize;

    public StreamingAeadSeekableDecryptingChannel(NonceBasedStreamingAead nonceBasedStreamingAead, SeekableByteChannel seekableByteChannel, byte[] bArr) {
        this.decrypter = nonceBasedStreamingAead.newStreamSegmentDecrypter();
        this.ciphertextChannel = seekableByteChannel;
        this.header = ByteBuffer.allocate(nonceBasedStreamingAead.getHeaderLength());
        int ciphertextSegmentSize = nonceBasedStreamingAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        this.ciphertextSegment = ByteBuffer.allocate(ciphertextSegmentSize);
        int plaintextSegmentSize = nonceBasedStreamingAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        this.plaintextSegment = ByteBuffer.allocate(plaintextSegmentSize + 16);
        this.plaintextPosition = 0L;
        this.headerRead = false;
        this.currentSegmentNr = -1;
        this.isCurrentSegmentDecrypted = false;
        long size = seekableByteChannel.size();
        this.ciphertextChannelSize = size;
        this.aad = Arrays.copyOf(bArr, bArr.length);
        this.isopen = seekableByteChannel.isOpen();
        int i3 = (int) (size / ciphertextSegmentSize);
        int i4 = (int) (size % ciphertextSegmentSize);
        int ciphertextOverhead = nonceBasedStreamingAead.getCiphertextOverhead();
        if (i4 > 0) {
            this.numberOfSegments = i3 + 1;
            if (i4 < ciphertextOverhead) {
                throw new IOException("Invalid ciphertext size");
            }
            this.lastCiphertextSegmentSize = i4;
        } else {
            this.numberOfSegments = i3;
            this.lastCiphertextSegmentSize = ciphertextSegmentSize;
        }
        int ciphertextOffset = nonceBasedStreamingAead.getCiphertextOffset();
        this.ciphertextOffset = ciphertextOffset;
        int headerLength = ciphertextOffset - nonceBasedStreamingAead.getHeaderLength();
        this.firstSegmentOffset = headerLength;
        if (headerLength < 0) {
            throw new IOException("Invalid ciphertext offset or header length");
        }
        long j3 = (this.numberOfSegments * ciphertextOverhead) + ciphertextOffset;
        if (j3 > size) {
            throw new IOException("Ciphertext is too short");
        }
        this.plaintextSize = size - j3;
    }

    private int getSegmentNr(long j3) {
        return (int) ((j3 + this.ciphertextOffset) / this.plaintextSegmentSize);
    }

    private boolean reachedEnd() {
        return this.isCurrentSegmentDecrypted && this.currentSegmentNr == this.numberOfSegments - 1 && this.plaintextSegment.remaining() == 0;
    }

    private boolean tryLoadSegment(int i3) {
        int i4;
        if (i3 < 0 || i3 >= (i4 = this.numberOfSegments)) {
            throw new IOException("Invalid position");
        }
        boolean z3 = i3 == i4 - 1;
        if (i3 != this.currentSegmentNr) {
            int i5 = this.ciphertextSegmentSize;
            long j3 = i3 * i5;
            if (z3) {
                i5 = this.lastCiphertextSegmentSize;
            }
            if (i3 == 0) {
                int i6 = this.ciphertextOffset;
                i5 -= i6;
                j3 = i6;
            }
            this.ciphertextChannel.position(j3);
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(i5);
            this.currentSegmentNr = i3;
            this.isCurrentSegmentDecrypted = false;
        } else if (this.isCurrentSegmentDecrypted) {
            return true;
        }
        if (this.ciphertextSegment.remaining() > 0) {
            this.ciphertextChannel.read(this.ciphertextSegment);
        }
        if (this.ciphertextSegment.remaining() > 0) {
            return false;
        }
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        try {
            this.decrypter.decryptSegment(this.ciphertextSegment, i3, z3, this.plaintextSegment);
            this.plaintextSegment.flip();
            this.isCurrentSegmentDecrypted = true;
            return true;
        } catch (GeneralSecurityException e3) {
            this.currentSegmentNr = -1;
            throw new IOException("Failed to decrypt", e3);
        }
    }

    private boolean tryReadHeader() {
        this.ciphertextChannel.position(this.header.position() + this.firstSegmentOffset);
        this.ciphertextChannel.read(this.header);
        if (this.header.remaining() > 0) {
            return false;
        }
        this.header.flip();
        try {
            this.decrypter.init(this.header, this.aad);
            this.headerRead = true;
            return true;
        } catch (GeneralSecurityException e3) {
            throw new IOException(e3);
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.ciphertextChannel.close();
        this.isopen = false;
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.isopen;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long position() {
        return this.plaintextPosition;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long j3) {
        this.plaintextPosition = j3;
        return this;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        int i3;
        if (!this.isopen) {
            throw new ClosedChannelException();
        }
        if (this.headerRead || tryReadHeader()) {
            int position = byteBuffer.position();
            while (byteBuffer.remaining() > 0) {
                long j3 = this.plaintextPosition;
                if (j3 < this.plaintextSize) {
                    int segmentNr = getSegmentNr(j3);
                    int i4 = (int) (segmentNr == 0 ? this.plaintextPosition : (this.plaintextPosition + this.ciphertextOffset) % this.plaintextSegmentSize);
                    if (!tryLoadSegment(segmentNr)) {
                        break;
                    }
                    this.plaintextSegment.position(i4);
                    if (this.plaintextSegment.remaining() <= byteBuffer.remaining()) {
                        this.plaintextPosition += this.plaintextSegment.remaining();
                        byteBuffer.put(this.plaintextSegment);
                    } else {
                        int remaining = byteBuffer.remaining();
                        ByteBuffer duplicate = this.plaintextSegment.duplicate();
                        duplicate.limit(duplicate.position() + remaining);
                        byteBuffer.put(duplicate);
                        this.plaintextPosition += remaining;
                        ByteBuffer byteBuffer2 = this.plaintextSegment;
                        byteBuffer2.position(byteBuffer2.position() + remaining);
                    }
                } else {
                    break;
                }
            }
            int position2 = byteBuffer.position() - position;
            if (position2 != 0 || !reachedEnd()) {
                return position2;
            }
            i3 = -1;
        } else {
            i3 = 0;
        }
        return i3;
    }

    public synchronized int read(ByteBuffer byteBuffer, long j3) {
        long position = position();
        try {
            position(j3);
        } finally {
            position(position);
        }
        return read(byteBuffer);
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() {
        return this.plaintextSize;
    }

    public synchronized String toString() {
        StringBuilder sb;
        String str;
        sb = new StringBuilder();
        try {
            str = "position:" + this.ciphertextChannel.position();
        } catch (IOException unused) {
            str = "position: n/a";
        }
        sb.append("StreamingAeadSeekableDecryptingChannel");
        sb.append("\nciphertextChannel");
        sb.append(str);
        sb.append("\nciphertextChannelSize:");
        sb.append(this.ciphertextChannelSize);
        sb.append("\nplaintextSize:");
        sb.append(this.plaintextSize);
        sb.append("\nciphertextSegmentSize:");
        sb.append(this.ciphertextSegmentSize);
        sb.append("\nnumberOfSegments:");
        sb.append(this.numberOfSegments);
        sb.append("\nheaderRead:");
        sb.append(this.headerRead);
        sb.append("\nplaintextPosition:");
        sb.append(this.plaintextPosition);
        sb.append("\nHeader");
        sb.append(" position:");
        sb.append(this.header.position());
        sb.append(" limit:");
        sb.append(this.header.position());
        sb.append("\ncurrentSegmentNr:");
        sb.append(this.currentSegmentNr);
        sb.append("\nciphertextSgement");
        sb.append(" position:");
        sb.append(this.ciphertextSegment.position());
        sb.append(" limit:");
        sb.append(this.ciphertextSegment.limit());
        sb.append("\nisCurrentSegmentDecrypted:");
        sb.append(this.isCurrentSegmentDecrypted);
        sb.append("\nplaintextSegment");
        sb.append(" position:");
        sb.append(this.plaintextSegment.position());
        sb.append(" limit:");
        sb.append(this.plaintextSegment.limit());
        return sb.toString();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long j3) {
        throw new NonWritableChannelException();
    }

    public synchronized long verifiedSize() {
        if (!tryLoadSegment(this.numberOfSegments - 1)) {
            throw new IOException("could not verify the size");
        }
        return this.plaintextSize;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        throw new NonWritableChannelException();
    }
}
