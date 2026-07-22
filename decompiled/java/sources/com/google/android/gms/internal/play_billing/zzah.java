package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* loaded from: /root/release/classes.dex */
public final class zzah {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzag zzc;

    public final zzah zza(Object obj, Object obj2) {
        int i3 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i4 = i3 + i3;
        if (i4 > length) {
            int i5 = length + (length >> 1) + 1;
            if (i5 < i4) {
                int highestOneBit = Integer.highestOneBit(i4 - 1);
                i5 = highestOneBit + highestOneBit;
            }
            if (i5 < 0) {
                i5 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i5);
        }
        zzaa.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i6 = this.zzb;
        int i7 = i6 + i6;
        objArr2[i7] = obj;
        objArr2[i7 + 1] = obj2;
        this.zzb = i6 + 1;
        return this;
    }

    public final zzai zzb() {
        zzag zzagVar = this.zzc;
        if (zzagVar != null) {
            throw zzagVar.zza();
        }
        zzaq zzf = zzaq.zzf(this.zzb, this.zza, this);
        zzag zzagVar2 = this.zzc;
        if (zzagVar2 == null) {
            return zzf;
        }
        throw zzagVar2.zza();
    }
}
