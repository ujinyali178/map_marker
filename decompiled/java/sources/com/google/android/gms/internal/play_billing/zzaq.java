package com.google.android.gms.internal.play_billing;

import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* loaded from: /root/release/classes.dex */
final class zzaq extends zzai {
    static final zzai zza = new zzaq(null, new Object[0], 0);
    final transient Object[] zzb;

    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzaq(@CheckForNull Object obj, Object[] objArr, int i3) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v4, types: [int[]] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object[]] */
    static zzaq zzf(int i3, Object[] objArr, zzah zzahVar) {
        short[] sArr;
        Object[] objArr2;
        int i4 = i3;
        Object[] objArr3 = objArr;
        if (i4 == 0) {
            return (zzaq) zza;
        }
        Object obj = null;
        if (i4 == 1) {
            Object obj2 = objArr3[0];
            obj2.getClass();
            Object obj3 = objArr3[1];
            obj3.getClass();
            zzaa.zza(obj2, obj3);
            return new zzaq(null, objArr3, 1);
        }
        zzx.zzb(i4, objArr3.length >> 1, "index");
        char c3 = 2;
        int max = Math.max(i4, 2);
        int i5 = Ints.MAX_POWER_OF_TWO;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            i5 = highestOneBit + highestOneBit;
            while (i5 * 0.7d < max) {
                i5 += i5;
            }
        } else if (max >= 1073741824) {
            throw new IllegalArgumentException("collection too large");
        }
        if (i4 == 1) {
            Object obj4 = objArr3[0];
            obj4.getClass();
            Object obj5 = objArr3[1];
            obj5.getClass();
            zzaa.zza(obj4, obj5);
            i4 = 1;
        } else {
            int i6 = i5 - 1;
            char c4 = 65535;
            if (i5 <= 128) {
                byte[] bArr = new byte[i5];
                Arrays.fill(bArr, (byte) -1);
                int i7 = 0;
                for (int i8 = 0; i8 < i4; i8++) {
                    int i9 = i7 + i7;
                    int i10 = i8 + i8;
                    Object obj6 = objArr3[i10];
                    obj6.getClass();
                    Object obj7 = objArr3[i10 ^ 1];
                    obj7.getClass();
                    zzaa.zza(obj6, obj7);
                    int zza2 = zzab.zza(obj6.hashCode());
                    while (true) {
                        int i11 = zza2 & i6;
                        int i12 = bArr[i11] & UnsignedBytes.MAX_VALUE;
                        if (i12 == 255) {
                            bArr[i11] = (byte) i9;
                            if (i7 < i8) {
                                objArr3[i9] = obj6;
                                objArr3[i9 ^ 1] = obj7;
                            }
                            i7++;
                        } else {
                            if (obj6.equals(objArr3[i12])) {
                                int i13 = i12 ^ 1;
                                Object obj8 = objArr3[i13];
                                obj8.getClass();
                                zzag zzagVar = new zzag(obj6, obj7, obj8);
                                objArr3[i13] = obj7;
                                obj = zzagVar;
                                break;
                            }
                            zza2 = i11 + 1;
                        }
                    }
                }
                if (i7 == i4) {
                    obj = bArr;
                    c3 = 2;
                } else {
                    sArr = new Object[]{bArr, Integer.valueOf(i7), obj};
                }
            } else if (i5 <= 32768) {
                sArr = new short[i5];
                Arrays.fill(sArr, (short) -1);
                int i14 = 0;
                for (int i15 = 0; i15 < i4; i15++) {
                    int i16 = i14 + i14;
                    int i17 = i15 + i15;
                    Object obj9 = objArr3[i17];
                    obj9.getClass();
                    Object obj10 = objArr3[i17 ^ 1];
                    obj10.getClass();
                    zzaa.zza(obj9, obj10);
                    int zza3 = zzab.zza(obj9.hashCode());
                    while (true) {
                        int i18 = zza3 & i6;
                        char c5 = (char) sArr[i18];
                        if (c5 == 65535) {
                            sArr[i18] = (short) i16;
                            if (i14 < i15) {
                                objArr3[i16] = obj9;
                                objArr3[i16 ^ 1] = obj10;
                            }
                            i14++;
                        } else {
                            if (obj9.equals(objArr3[c5])) {
                                int i19 = c5 ^ 1;
                                Object obj11 = objArr3[i19];
                                obj11.getClass();
                                zzag zzagVar2 = new zzag(obj9, obj10, obj11);
                                objArr3[i19] = obj10;
                                obj = zzagVar2;
                                break;
                            }
                            zza3 = i18 + 1;
                        }
                    }
                }
                if (i14 != i4) {
                    c3 = 2;
                    objArr2 = new Object[]{sArr, Integer.valueOf(i14), obj};
                    obj = objArr2;
                }
            } else {
                sArr = new int[i5];
                Arrays.fill((int[]) sArr, -1);
                int i20 = 0;
                int i21 = 0;
                while (i20 < i4) {
                    int i22 = i21 + i21;
                    int i23 = i20 + i20;
                    Object obj12 = objArr3[i23];
                    obj12.getClass();
                    Object obj13 = objArr3[i23 ^ 1];
                    obj13.getClass();
                    zzaa.zza(obj12, obj13);
                    int zza4 = zzab.zza(obj12.hashCode());
                    while (true) {
                        int i24 = zza4 & i6;
                        ?? r15 = sArr[i24];
                        if (r15 == c4) {
                            sArr[i24] = i22;
                            if (i21 < i20) {
                                objArr3[i22] = obj12;
                                objArr3[i22 ^ 1] = obj13;
                            }
                            i21++;
                        } else {
                            if (obj12.equals(objArr3[r15])) {
                                int i25 = r15 ^ 1;
                                Object obj14 = objArr3[i25];
                                obj14.getClass();
                                zzag zzagVar3 = new zzag(obj12, obj13, obj14);
                                objArr3[i25] = obj13;
                                obj = zzagVar3;
                                break;
                            }
                            zza4 = i24 + 1;
                            c4 = 65535;
                        }
                    }
                    i20++;
                    c4 = 65535;
                }
                if (i21 != i4) {
                    c3 = 2;
                    objArr2 = new Object[]{sArr, Integer.valueOf(i21), obj};
                    obj = objArr2;
                }
            }
            obj = sArr;
            c3 = 2;
        }
        boolean z3 = obj instanceof Object[];
        Object obj15 = obj;
        if (z3) {
            Object[] objArr4 = (Object[]) obj;
            zzahVar.zzc = (zzag) objArr4[c3];
            Object obj16 = objArr4[0];
            int intValue = ((Integer) objArr4[1]).intValue();
            objArr3 = Arrays.copyOf(objArr3, intValue + intValue);
            obj15 = obj16;
            i4 = intValue;
        }
        return new zzaq(obj15, objArr3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x009f A[RETURN] */
    @Override // com.google.android.gms.internal.play_billing.zzai, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L6
        L3:
            r10 = r0
            goto L9c
        L6:
            int r1 = r9.zzd
            java.lang.Object[] r2 = r9.zzb
            r3 = 1
            if (r1 != r3) goto L20
            r1 = 0
            r1 = r2[r1]
            r1.getClass()
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L3
            r10 = r2[r3]
            r10.getClass()
            goto L9c
        L20:
            java.lang.Object r1 = r9.zzc
            if (r1 != 0) goto L25
            goto L3
        L25:
            boolean r4 = r1 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L51
            r4 = r1
            byte[] r4 = (byte[]) r4
            int r1 = r4.length
            int r6 = r1 + (-1)
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.play_billing.zzab.zza(r1)
        L38:
            r1 = r1 & r6
            r5 = r4[r1]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L41
            goto L3
        L41:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L4e
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9c
        L4e:
            int r1 = r1 + 1
            goto L38
        L51:
            boolean r4 = r1 instanceof short[]
            if (r4 == 0) goto L7d
            r4 = r1
            short[] r4 = (short[]) r4
            int r1 = r4.length
            int r6 = r1 + (-1)
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.play_billing.zzab.zza(r1)
        L63:
            r1 = r1 & r6
            short r5 = r4[r1]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6d
            goto L3
        L6d:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7a
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9c
        L7a:
            int r1 = r1 + 1
            goto L63
        L7d:
            int[] r1 = (int[]) r1
            int r4 = r1.length
            int r4 = r4 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.play_billing.zzab.zza(r6)
        L89:
            r6 = r6 & r4
            r7 = r1[r6]
            if (r7 != r5) goto L90
            goto L3
        L90:
            r8 = r2[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La0
            r10 = r7 ^ 1
            r10 = r2[r10]
        L9c:
            if (r10 != 0) goto L9f
            return r0
        L9f:
            return r10
        La0:
            int r6 = r6 + 1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzaq.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzai
    final zzac zza() {
        return new zzap(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzai
    final zzaj zzc() {
        return new zzan(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzai
    final zzaj zzd() {
        return new zzao(this, new zzap(this.zzb, 0, this.zzd));
    }
}
