package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c, reason: collision with root package name */
    private final int f2289c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2290d;

    /* renamed from: k0, reason: collision with root package name */
    private final long f2291k0;

    /* renamed from: k1, reason: collision with root package name */
    private final long f2292k1;

    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b, reason: collision with root package name */
        private long f2293b;

        /* renamed from: c, reason: collision with root package name */
        private final int f2294c;

        /* renamed from: d, reason: collision with root package name */
        private final int f2295d;
        private long finalM;

        /* renamed from: v0, reason: collision with root package name */
        private long f2296v0;

        /* renamed from: v1, reason: collision with root package name */
        private long f2297v1;

        /* renamed from: v2, reason: collision with root package name */
        private long f2298v2;
        private long v3;

        SipHasher(int i3, int i4, long j3, long j4) {
            super(8);
            this.f2293b = 0L;
            this.finalM = 0L;
            this.f2294c = i3;
            this.f2295d = i4;
            this.f2296v0 = 8317987319222330741L ^ j3;
            this.f2297v1 = 7237128888997146477L ^ j4;
            this.f2298v2 = 7816392313619706465L ^ j3;
            this.v3 = 8387220255154660723L ^ j4;
        }

        private void processM(long j3) {
            this.v3 ^= j3;
            sipRound(this.f2294c);
            this.f2296v0 = j3 ^ this.f2296v0;
        }

        private void sipRound(int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                long j3 = this.f2296v0;
                long j4 = this.f2297v1;
                this.f2296v0 = j3 + j4;
                this.f2298v2 += this.v3;
                this.f2297v1 = Long.rotateLeft(j4, 13);
                long rotateLeft = Long.rotateLeft(this.v3, 16);
                long j5 = this.f2297v1;
                long j6 = this.f2296v0;
                this.f2297v1 = j5 ^ j6;
                this.v3 = rotateLeft ^ this.f2298v2;
                long rotateLeft2 = Long.rotateLeft(j6, 32);
                long j7 = this.f2298v2;
                long j8 = this.f2297v1;
                this.f2298v2 = j7 + j8;
                this.f2296v0 = rotateLeft2 + this.v3;
                this.f2297v1 = Long.rotateLeft(j8, 17);
                long rotateLeft3 = Long.rotateLeft(this.v3, 21);
                long j9 = this.f2297v1;
                long j10 = this.f2298v2;
                this.f2297v1 = j9 ^ j10;
                this.v3 = rotateLeft3 ^ this.f2296v0;
                this.f2298v2 = Long.rotateLeft(j10, 32);
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected HashCode makeHash() {
            long j3 = this.finalM ^ (this.f2293b << 56);
            this.finalM = j3;
            processM(j3);
            this.f2298v2 ^= 255;
            sipRound(this.f2295d);
            return HashCode.fromLong(((this.f2296v0 ^ this.f2297v1) ^ this.f2298v2) ^ this.v3);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer byteBuffer) {
            this.f2293b += 8;
            processM(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer byteBuffer) {
            this.f2293b += byteBuffer.remaining();
            int i3 = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (byteBuffer.get() & 255) << i3;
                i3 += 8;
            }
        }
    }

    SipHashFunction(int i3, int i4, long j3, long j4) {
        Preconditions.checkArgument(i3 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i3);
        Preconditions.checkArgument(i4 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i4);
        this.f2289c = i3;
        this.f2290d = i4;
        this.f2291k0 = j3;
        this.f2292k1 = j4;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        return this.f2289c == sipHashFunction.f2289c && this.f2290d == sipHashFunction.f2290d && this.f2291k0 == sipHashFunction.f2291k0 && this.f2292k1 == sipHashFunction.f2292k1;
    }

    public int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ this.f2289c) ^ this.f2290d) ^ this.f2291k0) ^ this.f2292k1);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f2289c, this.f2290d, this.f2291k0, this.f2292k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f2289c + "" + this.f2290d + "(" + this.f2291k0 + ", " + this.f2292k1 + ")";
    }
}
