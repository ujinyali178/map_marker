package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /root/release/classes.dex */
public final class AesCtrHmacStreaming extends NonceBasedStreamingAead {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final int HMAC_KEY_SIZE_IN_BYTES = 32;
    private static final int NONCE_PREFIX_IN_BYTES = 7;
    private static final int NONCE_SIZE_IN_BYTES = 16;
    private final int ciphertextSegmentSize;
    private final int firstSegmentOffset;
    private final String hkdfAlgo;
    private final byte[] ikm;
    private final int keySizeInBytes;
    private final int plaintextSegmentSize;
    private final String tagAlgo;
    private final int tagSizeInBytes;

    class AesCtrHmacStreamDecrypter implements StreamSegmentDecrypter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Cipher cipher;
        private SecretKeySpec hmacKeySpec;
        private SecretKeySpec keySpec;
        private Mac mac;
        private byte[] noncePrefix;

        AesCtrHmacStreamDecrypter() {
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public synchronized void decryptSegment(ByteBuffer byteBuffer, int i3, boolean z3, ByteBuffer byteBuffer2) {
            int position = byteBuffer.position();
            byte[] nonceForSegment = AesCtrHmacStreaming.this.nonceForSegment(this.noncePrefix, i3, z3);
            int remaining = byteBuffer.remaining();
            if (remaining < AesCtrHmacStreaming.this.tagSizeInBytes) {
                throw new GeneralSecurityException("Ciphertext too short");
            }
            int i4 = position + (remaining - AesCtrHmacStreaming.this.tagSizeInBytes);
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.limit(i4);
            ByteBuffer duplicate2 = byteBuffer.duplicate();
            duplicate2.position(i4);
            this.mac.init(this.hmacKeySpec);
            this.mac.update(nonceForSegment);
            this.mac.update(duplicate);
            byte[] copyOf = Arrays.copyOf(this.mac.doFinal(), AesCtrHmacStreaming.this.tagSizeInBytes);
            byte[] bArr = new byte[AesCtrHmacStreaming.this.tagSizeInBytes];
            duplicate2.get(bArr);
            if (!Bytes.equal(bArr, copyOf)) {
                throw new GeneralSecurityException("Tag mismatch");
            }
            byteBuffer.limit(i4);
            this.cipher.init(1, this.keySpec, new IvParameterSpec(nonceForSegment));
            this.cipher.doFinal(byteBuffer, byteBuffer2);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public synchronized void init(ByteBuffer byteBuffer, byte[] bArr) {
            if (byteBuffer.remaining() != AesCtrHmacStreaming.this.getHeaderLength()) {
                throw new InvalidAlgorithmParameterException("Invalid header length");
            }
            if (byteBuffer.get() != AesCtrHmacStreaming.this.getHeaderLength()) {
                throw new GeneralSecurityException("Invalid ciphertext");
            }
            this.noncePrefix = new byte[7];
            byte[] bArr2 = new byte[AesCtrHmacStreaming.this.keySizeInBytes];
            byteBuffer.get(bArr2);
            byteBuffer.get(this.noncePrefix);
            byte[] deriveKeyMaterial = AesCtrHmacStreaming.this.deriveKeyMaterial(bArr2, bArr);
            this.keySpec = AesCtrHmacStreaming.this.deriveKeySpec(deriveKeyMaterial);
            this.hmacKeySpec = AesCtrHmacStreaming.this.deriveHmacKeySpec(deriveKeyMaterial);
            this.cipher = AesCtrHmacStreaming.cipherInstance();
            this.mac = AesCtrHmacStreaming.this.macInstance();
        }
    }

    class AesCtrHmacStreamEncrypter implements StreamSegmentEncrypter {
        private final Cipher cipher = AesCtrHmacStreaming.cipherInstance();
        private long encryptedSegments;
        private ByteBuffer header;
        private final SecretKeySpec hmacKeySpec;
        private final SecretKeySpec keySpec;
        private final Mac mac;
        private final byte[] noncePrefix;

        public AesCtrHmacStreamEncrypter(byte[] bArr) {
            this.encryptedSegments = 0L;
            this.mac = AesCtrHmacStreaming.this.macInstance();
            this.encryptedSegments = 0L;
            byte[] randomSalt = AesCtrHmacStreaming.this.randomSalt();
            byte[] randomNonce = AesCtrHmacStreaming.this.randomNonce();
            this.noncePrefix = randomNonce;
            ByteBuffer allocate = ByteBuffer.allocate(AesCtrHmacStreaming.this.getHeaderLength());
            this.header = allocate;
            allocate.put((byte) AesCtrHmacStreaming.this.getHeaderLength());
            this.header.put(randomSalt);
            this.header.put(randomNonce);
            this.header.flip();
            byte[] deriveKeyMaterial = AesCtrHmacStreaming.this.deriveKeyMaterial(randomSalt, bArr);
            this.keySpec = AesCtrHmacStreaming.this.deriveKeySpec(deriveKeyMaterial);
            this.hmacKeySpec = AesCtrHmacStreaming.this.deriveHmacKeySpec(deriveKeyMaterial);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z3, ByteBuffer byteBuffer3) {
            int position = byteBuffer3.position();
            byte[] nonceForSegment = AesCtrHmacStreaming.this.nonceForSegment(this.noncePrefix, this.encryptedSegments, z3);
            this.cipher.init(1, this.keySpec, new IvParameterSpec(nonceForSegment));
            this.encryptedSegments++;
            this.cipher.update(byteBuffer, byteBuffer3);
            this.cipher.doFinal(byteBuffer2, byteBuffer3);
            ByteBuffer duplicate = byteBuffer3.duplicate();
            duplicate.flip();
            duplicate.position(position);
            this.mac.init(this.hmacKeySpec);
            this.mac.update(nonceForSegment);
            this.mac.update(duplicate);
            byteBuffer3.put(this.mac.doFinal(), 0, AesCtrHmacStreaming.this.tagSizeInBytes);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer byteBuffer, boolean z3, ByteBuffer byteBuffer2) {
            int position = byteBuffer2.position();
            byte[] nonceForSegment = AesCtrHmacStreaming.this.nonceForSegment(this.noncePrefix, this.encryptedSegments, z3);
            this.cipher.init(1, this.keySpec, new IvParameterSpec(nonceForSegment));
            this.encryptedSegments++;
            this.cipher.doFinal(byteBuffer, byteBuffer2);
            ByteBuffer duplicate = byteBuffer2.duplicate();
            duplicate.flip();
            duplicate.position(position);
            this.mac.init(this.hmacKeySpec);
            this.mac.update(nonceForSegment);
            this.mac.update(duplicate);
            byteBuffer2.put(this.mac.doFinal(), 0, AesCtrHmacStreaming.this.tagSizeInBytes);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public ByteBuffer getHeader() {
            return this.header.asReadOnlyBuffer();
        }
    }

    public AesCtrHmacStreaming(byte[] bArr, String str, int i3, String str2, int i4, int i5, int i6) {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC streaming in FIPS-mode.");
        }
        validateParameters(bArr.length, i3, str2, i4, i5, i6);
        this.ikm = Arrays.copyOf(bArr, bArr.length);
        this.hkdfAlgo = str;
        this.keySizeInBytes = i3;
        this.tagAlgo = str2;
        this.tagSizeInBytes = i4;
        this.ciphertextSegmentSize = i5;
        this.firstSegmentOffset = i6;
        this.plaintextSegmentSize = i5 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher cipherInstance() {
        return EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec deriveHmacKeySpec(byte[] bArr) {
        return new SecretKeySpec(bArr, this.keySizeInBytes, 32, this.tagAlgo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] deriveKeyMaterial(byte[] bArr, byte[] bArr2) {
        return Hkdf.computeHkdf(this.hkdfAlgo, this.ikm, bArr, bArr2, this.keySizeInBytes + 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec deriveKeySpec(byte[] bArr) {
        return new SecretKeySpec(bArr, 0, this.keySizeInBytes, "AES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mac macInstance() {
        return EngineFactory.MAC.getInstance(this.tagAlgo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] nonceForSegment(byte[] bArr, long j3, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate(16);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.put(bArr);
        SubtleUtil.putAsUnsigedInt(allocate, j3);
        allocate.put(z3 ? (byte) 1 : (byte) 0);
        allocate.putInt(0);
        return allocate.array();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] randomNonce() {
        return Random.randBytes(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] randomSalt() {
        return Random.randBytes(this.keySizeInBytes);
    }

    private static void validateParameters(int i3, int i4, String str, int i5, int i6, int i7) {
        if (i3 < 16 || i3 < i4) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, i4));
        }
        Validators.validateAesKeySize(i4);
        if (i5 < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small " + i5);
        }
        if ((str.equals("HmacSha1") && i5 > 20) || ((str.equals("HmacSha256") && i5 > 32) || (str.equals("HmacSha512") && i5 > 64))) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        if (((((i6 - i7) - i5) - i4) - 7) - 1 <= 0) {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
    }

    public long expectedCiphertextSize(long j3) {
        long ciphertextOffset = j3 + getCiphertextOffset();
        int i3 = this.plaintextSegmentSize;
        long j4 = (ciphertextOffset / i3) * this.ciphertextSegmentSize;
        long j5 = ciphertextOffset % i3;
        return j5 > 0 ? j4 + j5 + this.tagSizeInBytes : j4;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOffset() {
        return getHeaderLength() + this.firstSegmentOffset;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOverhead() {
        return this.tagSizeInBytes;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize;
    }

    public int getFirstSegmentOffset() {
        return this.firstSegmentOffset;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getHeaderLength() {
        return this.keySizeInBytes + 1 + 7;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getPlaintextSegmentSize() {
        return this.plaintextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ ReadableByteChannel newDecryptingChannel(ReadableByteChannel readableByteChannel, byte[] bArr) {
        return super.newDecryptingChannel(readableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ InputStream newDecryptingStream(InputStream inputStream, byte[] bArr) {
        return super.newDecryptingStream(inputStream, bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ WritableByteChannel newEncryptingChannel(WritableByteChannel writableByteChannel, byte[] bArr) {
        return super.newEncryptingChannel(writableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ OutputStream newEncryptingStream(OutputStream outputStream, byte[] bArr) {
        return super.newEncryptingStream(outputStream, bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel seekableByteChannel, byte[] bArr) {
        return super.newSeekableDecryptingChannel(seekableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesCtrHmacStreamDecrypter newStreamSegmentDecrypter() {
        return new AesCtrHmacStreamDecrypter();
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesCtrHmacStreamEncrypter newStreamSegmentEncrypter(byte[] bArr) {
        return new AesCtrHmacStreamEncrypter(bArr);
    }
}
