package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {
    private static final long serialVersionUID = 0;
    final HashFunction[] functions;

    AbstractCompositeHashFunction(HashFunction... hashFunctionArr) {
        for (HashFunction hashFunction : hashFunctionArr) {
            Preconditions.checkNotNull(hashFunction);
        }
        this.functions = hashFunctionArr;
    }

    private Hasher fromHashers(final Hasher[] hasherArr) {
        return new Hasher() { // from class: com.google.common.hash.AbstractCompositeHashFunction.1
            @Override // com.google.common.hash.Hasher
            public HashCode hash() {
                return AbstractCompositeHashFunction.this.makeHash(hasherArr);
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putBoolean(boolean z3) {
                for (Hasher hasher : hasherArr) {
                    hasher.putBoolean(z3);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putByte(byte b4) {
                for (Hasher hasher : hasherArr) {
                    hasher.putByte(b4);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putBytes(ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                for (Hasher hasher : hasherArr) {
                    Java8Compatibility.position(byteBuffer, position);
                    hasher.putBytes(byteBuffer);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putBytes(byte[] bArr) {
                for (Hasher hasher : hasherArr) {
                    hasher.putBytes(bArr);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putBytes(byte[] bArr, int i3, int i4) {
                for (Hasher hasher : hasherArr) {
                    hasher.putBytes(bArr, i3, i4);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putChar(char c3) {
                for (Hasher hasher : hasherArr) {
                    hasher.putChar(c3);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putDouble(double d3) {
                for (Hasher hasher : hasherArr) {
                    hasher.putDouble(d3);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putFloat(float f3) {
                for (Hasher hasher : hasherArr) {
                    hasher.putFloat(f3);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putInt(int i3) {
                for (Hasher hasher : hasherArr) {
                    hasher.putInt(i3);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putLong(long j3) {
                for (Hasher hasher : hasherArr) {
                    hasher.putLong(j3);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher
            public <T> Hasher putObject(@ParametricNullness T t3, Funnel<? super T> funnel) {
                for (Hasher hasher : hasherArr) {
                    hasher.putObject(t3, funnel);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putShort(short s3) {
                for (Hasher hasher : hasherArr) {
                    hasher.putShort(s3);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putString(CharSequence charSequence, Charset charset) {
                for (Hasher hasher : hasherArr) {
                    hasher.putString(charSequence, charset);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putUnencodedChars(CharSequence charSequence) {
                for (Hasher hasher : hasherArr) {
                    hasher.putUnencodedChars(charSequence);
                }
                return this;
            }
        };
    }

    abstract HashCode makeHash(Hasher[] hasherArr);

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        int length = this.functions.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i3 = 0; i3 < length; i3++) {
            hasherArr[i3] = this.functions[i3].newHasher();
        }
        return fromHashers(hasherArr);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public Hasher newHasher(int i3) {
        Preconditions.checkArgument(i3 >= 0);
        int length = this.functions.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i4 = 0; i4 < length; i4++) {
            hasherArr[i4] = this.functions[i4].newHasher(i3);
        }
        return fromHashers(hasherArr);
    }
}
