package com.google.crypto.tink.subtle;

import com.google.common.primitives.UnsignedBytes;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

/* loaded from: /root/release/classes.dex */
class StreamingAeadDecryptingStream extends FilterInputStream {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] aad;
    private final ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private final StreamSegmentDecrypter decrypter;
    private boolean decryptionErrorOccured;
    private boolean endOfCiphertext;
    private boolean endOfPlaintext;
    private final int firstCiphertextSegmentSize;
    private final int headerLength;
    private boolean headerRead;
    private final ByteBuffer plaintextSegment;
    private int segmentNr;

    public StreamingAeadDecryptingStream(NonceBasedStreamingAead nonceBasedStreamingAead, InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.decrypter = nonceBasedStreamingAead.newStreamSegmentDecrypter();
        this.headerLength = nonceBasedStreamingAead.getHeaderLength();
        this.aad = Arrays.copyOf(bArr, bArr.length);
        int ciphertextSegmentSize = nonceBasedStreamingAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        ByteBuffer allocate = ByteBuffer.allocate(ciphertextSegmentSize + 1);
        this.ciphertextSegment = allocate;
        allocate.limit(0);
        this.firstCiphertextSegmentSize = ciphertextSegmentSize - nonceBasedStreamingAead.getCiphertextOffset();
        ByteBuffer allocate2 = ByteBuffer.allocate(nonceBasedStreamingAead.getPlaintextSegmentSize() + 16);
        this.plaintextSegment = allocate2;
        allocate2.limit(0);
        this.headerRead = false;
        this.endOfCiphertext = false;
        this.endOfPlaintext = false;
        this.segmentNr = 0;
        this.decryptionErrorOccured = false;
    }

    private void loadSegment() {
        while (!this.endOfCiphertext && this.ciphertextSegment.remaining() > 0) {
            int read = ((FilterInputStream) this).in.read(this.ciphertextSegment.array(), this.ciphertextSegment.position(), this.ciphertextSegment.remaining());
            if (read > 0) {
                ByteBuffer byteBuffer = this.ciphertextSegment;
                byteBuffer.position(byteBuffer.position() + read);
            } else if (read == -1) {
                this.endOfCiphertext = true;
            } else if (read == 0) {
                throw new IOException("Could not read bytes from the ciphertext stream");
            }
        }
        byte b4 = 0;
        if (!this.endOfCiphertext) {
            ByteBuffer byteBuffer2 = this.ciphertextSegment;
            b4 = byteBuffer2.get(byteBuffer2.position() - 1);
            ByteBuffer byteBuffer3 = this.ciphertextSegment;
            byteBuffer3.position(byteBuffer3.position() - 1);
        }
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        try {
            this.decrypter.decryptSegment(this.ciphertextSegment, this.segmentNr, this.endOfCiphertext, this.plaintextSegment);
            this.segmentNr++;
            this.plaintextSegment.flip();
            this.ciphertextSegment.clear();
            if (this.endOfCiphertext) {
                return;
            }
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(this.ciphertextSegmentSize + 1);
            this.ciphertextSegment.put(b4);
        } catch (GeneralSecurityException e3) {
            setDecryptionErrorOccured();
            throw new IOException(e3.getMessage() + IOUtils.LINE_SEPARATOR_UNIX + toString() + "\nsegmentNr:" + this.segmentNr + " endOfCiphertext:" + this.endOfCiphertext, e3);
        }
    }

    private void readHeader() {
        if (this.headerRead) {
            setDecryptionErrorOccured();
            throw new IOException("Decryption failed.");
        }
        ByteBuffer allocate = ByteBuffer.allocate(this.headerLength);
        while (allocate.remaining() > 0) {
            int read = ((FilterInputStream) this).in.read(allocate.array(), allocate.position(), allocate.remaining());
            if (read == -1) {
                setDecryptionErrorOccured();
                throw new IOException("Ciphertext is too short");
            }
            if (read == 0) {
                throw new IOException("Could not read bytes from the ciphertext stream");
            }
            allocate.position(allocate.position() + read);
        }
        allocate.flip();
        try {
            this.decrypter.init(allocate, this.aad);
            this.headerRead = true;
        } catch (GeneralSecurityException e3) {
            throw new IOException(e3);
        }
    }

    private void setDecryptionErrorOccured() {
        this.decryptionErrorOccured = true;
        this.plaintextSegment.limit(0);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return this.plaintextSegment.remaining();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        if (read == 1) {
            return bArr[0] & UnsignedBytes.MAX_VALUE;
        }
        if (read == -1) {
            return read;
        }
        throw new IOException("Reading failed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i3, int i4) {
        if (this.decryptionErrorOccured) {
            throw new IOException("Decryption failed.");
        }
        if (!this.headerRead) {
            readHeader();
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(this.firstCiphertextSegmentSize + 1);
        }
        if (this.endOfPlaintext) {
            return -1;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            if (this.plaintextSegment.remaining() == 0) {
                if (this.endOfCiphertext) {
                    this.endOfPlaintext = true;
                    break;
                }
                loadSegment();
            }
            int min = Math.min(this.plaintextSegment.remaining(), i4 - i5);
            this.plaintextSegment.get(bArr, i5 + i3, min);
            i5 += min;
        }
        if (i5 == 0 && this.endOfPlaintext) {
            return -1;
        }
        return i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) {
        int read;
        long j4 = this.ciphertextSegmentSize;
        if (j3 <= 0) {
            return 0L;
        }
        int min = (int) Math.min(j4, j3);
        byte[] bArr = new byte[min];
        long j5 = j3;
        while (j5 > 0 && (read = read(bArr, 0, (int) Math.min(min, j5))) > 0) {
            j5 -= read;
        }
        return j3 - j5;
    }

    public synchronized String toString() {
        return "StreamingAeadDecryptingStream\nsegmentNr:" + this.segmentNr + "\nciphertextSegmentSize:" + this.ciphertextSegmentSize + "\nheaderRead:" + this.headerRead + "\nendOfCiphertext:" + this.endOfCiphertext + "\nendOfPlaintext:" + this.endOfPlaintext + "\ndecryptionErrorOccured:" + this.decryptionErrorOccured + "\nciphertextSgement position:" + this.ciphertextSegment.position() + " limit:" + this.ciphertextSegment.limit() + "\nplaintextSegment position:" + this.plaintextSegment.position() + " limit:" + this.plaintextSegment.limit();
    }
}
