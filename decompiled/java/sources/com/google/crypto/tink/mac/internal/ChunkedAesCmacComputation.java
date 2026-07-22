package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.AesCmacParameters;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /root/release/classes.dex */
final class ChunkedAesCmacComputation implements ChunkedMacComputation {
    private static final byte[] FORMAT_VERSION = {0};
    private final Cipher aes;
    private boolean finalized = false;
    private final AesCmacKey key;
    private final ByteBuffer localStash;
    private final byte[] subKey1;
    private final byte[] subKey2;

    /* renamed from: x, reason: collision with root package name */
    private final ByteBuffer f2352x;

    /* renamed from: y, reason: collision with root package name */
    private final ByteBuffer f2353y;

    ChunkedAesCmacComputation(AesCmacKey aesCmacKey) {
        this.key = aesCmacKey;
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        this.aes = engineFactory;
        engineFactory.init(1, new SecretKeySpec(aesCmacKey.getAesKey().toByteArray(InsecureSecretKeyAccess.get()), "AES"));
        byte[] dbl = AesUtil.dbl(engineFactory.doFinal(new byte[16]));
        this.subKey1 = dbl;
        this.subKey2 = AesUtil.dbl(dbl);
        this.localStash = ByteBuffer.allocate(16);
        this.f2352x = ByteBuffer.allocate(16);
        this.f2353y = ByteBuffer.allocate(16);
    }

    private void munch(ByteBuffer byteBuffer) {
        this.f2353y.rewind();
        this.f2352x.rewind();
        Bytes.xor(this.f2353y, this.f2352x, byteBuffer, 16);
        this.f2353y.rewind();
        this.f2352x.rewind();
        this.aes.doFinal(this.f2353y, this.f2352x);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacComputation
    public byte[] computeMac() {
        if (this.finalized) {
            throw new IllegalStateException("Can not compute after computing the MAC tag. Please create a new object.");
        }
        if (this.key.getParameters().getVariant() == AesCmacParameters.Variant.LEGACY) {
            update(ByteBuffer.wrap(FORMAT_VERSION));
        }
        this.finalized = true;
        return Bytes.concat(this.key.getOutputPrefix().toByteArray(), Arrays.copyOf(this.aes.doFinal(Bytes.xor(this.localStash.remaining() > 0 ? Bytes.xor(AesUtil.cmacPad(Arrays.copyOf(this.localStash.array(), this.localStash.position())), this.subKey2) : Bytes.xor(this.localStash.array(), 0, this.subKey1, 0, 16), this.f2352x.array())), this.key.getParameters().getCryptographicTagSizeBytes()));
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacComputation
    public void update(ByteBuffer byteBuffer) {
        if (this.finalized) {
            throw new IllegalStateException("Can not update after computing the MAC tag. Please create a new object.");
        }
        if (this.localStash.remaining() != 16) {
            int min = Math.min(this.localStash.remaining(), byteBuffer.remaining());
            for (int i3 = 0; i3 < min; i3++) {
                this.localStash.put(byteBuffer.get());
            }
        }
        if (this.localStash.remaining() == 0 && byteBuffer.remaining() > 0) {
            this.localStash.rewind();
            munch(this.localStash);
            this.localStash.rewind();
        }
        while (byteBuffer.remaining() > 16) {
            munch(byteBuffer);
        }
        this.localStash.put(byteBuffer);
    }
}
