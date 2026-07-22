package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.subtle.RewindableReadableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
final class ReadableByteChannelDecrypter implements ReadableByteChannel {
    byte[] associatedData;
    RewindableReadableByteChannel ciphertextChannel;
    ReadableByteChannel attemptingChannel = null;
    ReadableByteChannel matchingChannel = null;
    Deque<StreamingAead> remainingPrimitives = new ArrayDeque();

    public ReadableByteChannelDecrypter(PrimitiveSet<StreamingAead> primitiveSet, ReadableByteChannel readableByteChannel, byte[] bArr) {
        Iterator<PrimitiveSet.Entry<StreamingAead>> it = primitiveSet.getRawPrimitives().iterator();
        while (it.hasNext()) {
            this.remainingPrimitives.add(it.next().getPrimitive());
        }
        this.ciphertextChannel = new RewindableReadableByteChannel(readableByteChannel);
        this.associatedData = (byte[]) bArr.clone();
    }

    private synchronized ReadableByteChannel nextAttemptingChannel() {
        while (!this.remainingPrimitives.isEmpty()) {
            try {
            } catch (GeneralSecurityException unused) {
                this.ciphertextChannel.rewind();
            }
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
        return this.remainingPrimitives.removeFirst().newDecryptingChannel(this.ciphertextChannel, this.associatedData);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.ciphertextChannel.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() == 0) {
            return 0;
        }
        ReadableByteChannel readableByteChannel = this.matchingChannel;
        if (readableByteChannel != null) {
            return readableByteChannel.read(byteBuffer);
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
                this.ciphertextChannel.disableRewinding();
                return read;
            } catch (IOException unused) {
                this.ciphertextChannel.rewind();
                this.attemptingChannel = nextAttemptingChannel();
            }
            this.attemptingChannel = nextAttemptingChannel();
        }
    }
}
