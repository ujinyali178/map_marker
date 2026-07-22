package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
final class SeekableByteChannelDecrypter implements SeekableByteChannel {
    byte[] associatedData;
    long cachedPosition;
    SeekableByteChannel ciphertextChannel;
    long startingPosition;
    SeekableByteChannel attemptingChannel = null;
    SeekableByteChannel matchingChannel = null;
    Deque<StreamingAead> remainingPrimitives = new ArrayDeque();

    public SeekableByteChannelDecrypter(PrimitiveSet<StreamingAead> primitiveSet, SeekableByteChannel seekableByteChannel, byte[] bArr) {
        Iterator<PrimitiveSet.Entry<StreamingAead>> it = primitiveSet.getRawPrimitives().iterator();
        while (it.hasNext()) {
            this.remainingPrimitives.add(it.next().getPrimitive());
        }
        this.ciphertextChannel = seekableByteChannel;
        this.cachedPosition = -1L;
        this.startingPosition = seekableByteChannel.position();
        this.associatedData = (byte[]) bArr.clone();
    }

    private synchronized SeekableByteChannel nextAttemptingChannel() {
        SeekableByteChannel newSeekableDecryptingChannel;
        while (!this.remainingPrimitives.isEmpty()) {
            this.ciphertextChannel.position(this.startingPosition);
            try {
                newSeekableDecryptingChannel = this.remainingPrimitives.removeFirst().newSeekableDecryptingChannel(this.ciphertextChannel, this.associatedData);
                long j3 = this.cachedPosition;
                if (j3 >= 0) {
                    newSeekableDecryptingChannel.position(j3);
                }
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
        return newSeekableDecryptingChannel;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.ciphertextChannel.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long position() {
        SeekableByteChannel seekableByteChannel = this.matchingChannel;
        if (seekableByteChannel != null) {
            return seekableByteChannel.position();
        }
        return this.cachedPosition;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0013, code lost:
    
        if (r0 != null) goto L5;
     */
    @Override // java.nio.channels.SeekableByteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.nio.channels.SeekableByteChannel position(long r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.nio.channels.SeekableByteChannel r0 = r3.matchingChannel     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L9
        L5:
            r0.position(r4)     // Catch: java.lang.Throwable -> L20
            goto L16
        L9:
            r0 = 0
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 < 0) goto L18
            r3.cachedPosition = r4     // Catch: java.lang.Throwable -> L20
            java.nio.channels.SeekableByteChannel r0 = r3.attemptingChannel     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L16
            goto L5
        L16:
            monitor-exit(r3)
            return r3
        L18:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L20
            java.lang.String r5 = "Position must be non-negative"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L20
            throw r4     // Catch: java.lang.Throwable -> L20
        L20:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.SeekableByteChannelDecrypter.position(long):java.nio.channels.SeekableByteChannel");
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() == 0) {
            return 0;
        }
        SeekableByteChannel seekableByteChannel = this.matchingChannel;
        if (seekableByteChannel != null) {
            return seekableByteChannel.read(byteBuffer);
        }
        if (this.attemptingChannel == null) {
            this.attemptingChannel = nextAttemptingChannel();
        }
        while (true) {
            try {
                int read = this.attemptingChannel.read(byteBuffer);
                if (read == 0) {
                    return 0;
                }
                this.matchingChannel = this.attemptingChannel;
                this.attemptingChannel = null;
                return read;
            } catch (IOException unused) {
                this.attemptingChannel = nextAttemptingChannel();
            }
            this.attemptingChannel = nextAttemptingChannel();
        }
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long size() {
        SeekableByteChannel seekableByteChannel;
        seekableByteChannel = this.matchingChannel;
        if (seekableByteChannel == null) {
            throw new IOException("Cannot determine size before first read()-call.");
        }
        return seekableByteChannel.size();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long j3) {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        throw new NonWritableChannelException();
    }
}
