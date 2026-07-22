package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/* loaded from: /root/release/classes.dex */
public final class RewindableReadableByteChannel implements ReadableByteChannel {
    final ReadableByteChannel baseChannel;
    ByteBuffer buffer = null;
    boolean canRewind = true;
    boolean directRead = false;

    public RewindableReadableByteChannel(ReadableByteChannel readableByteChannel) {
        this.baseChannel = readableByteChannel;
    }

    private synchronized void setBufferLimit(int i3) {
        if (this.buffer.capacity() < i3) {
            int position = this.buffer.position();
            ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.buffer.capacity() * 2, i3));
            this.buffer.rewind();
            allocate.put(this.buffer);
            allocate.position(position);
            this.buffer = allocate;
        }
        this.buffer.limit(i3);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.canRewind = false;
        this.directRead = true;
        this.baseChannel.close();
    }

    public synchronized void disableRewinding() {
        this.canRewind = false;
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.baseChannel.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        int i3;
        if (this.directRead) {
            return this.baseChannel.read(byteBuffer);
        }
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            i3 = 0;
        } else {
            ByteBuffer byteBuffer2 = this.buffer;
            if (byteBuffer2 == null) {
                if (!this.canRewind) {
                    this.directRead = true;
                    return this.baseChannel.read(byteBuffer);
                }
                ByteBuffer allocate = ByteBuffer.allocate(remaining);
                this.buffer = allocate;
                int read = this.baseChannel.read(allocate);
                this.buffer.flip();
                if (read > 0) {
                    byteBuffer.put(this.buffer);
                }
                return read;
            }
            if (byteBuffer2.remaining() >= remaining) {
                int limit = this.buffer.limit();
                ByteBuffer byteBuffer3 = this.buffer;
                byteBuffer3.limit(byteBuffer3.position() + remaining);
                byteBuffer.put(this.buffer);
                this.buffer.limit(limit);
                if (!this.canRewind && !this.buffer.hasRemaining()) {
                    this.buffer = null;
                    this.directRead = true;
                }
                return remaining;
            }
            int remaining2 = this.buffer.remaining();
            int position = this.buffer.position();
            int limit2 = this.buffer.limit();
            setBufferLimit((remaining - remaining2) + limit2);
            this.buffer.position(limit2);
            int read2 = this.baseChannel.read(this.buffer);
            this.buffer.flip();
            this.buffer.position(position);
            byteBuffer.put(this.buffer);
            if (remaining2 != 0 || read2 >= 0) {
                int position2 = this.buffer.position() - position;
                if (!this.canRewind && !this.buffer.hasRemaining()) {
                    this.buffer = null;
                    this.directRead = true;
                }
                return position2;
            }
            i3 = -1;
        }
        return i3;
    }

    public synchronized void rewind() {
        if (!this.canRewind) {
            throw new IOException("Cannot rewind anymore.");
        }
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer != null) {
            byteBuffer.position(0);
        }
    }
}
