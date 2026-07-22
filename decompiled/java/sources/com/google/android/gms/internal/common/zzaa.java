package com.google.android.gms.internal.common;

import java.util.Arrays;

/* loaded from: /root/release/classes.dex */
class zzaa extends zzab {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    zzaa(int i3) {
    }

    public final zzaa zza(Object obj) {
        obj.getClass();
        int i3 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length >= i3) {
            if (this.zzc) {
                this.zza = (Object[]) objArr.clone();
            }
            Object[] objArr2 = this.zza;
            int i4 = this.zzb;
            this.zzb = i4 + 1;
            objArr2[i4] = obj;
            return this;
        }
        int i5 = length + (length >> 1) + 1;
        if (i5 < i3) {
            int highestOneBit = Integer.highestOneBit(i3 - 1);
            i5 = highestOneBit + highestOneBit;
        }
        if (i5 < 0) {
            i5 = Integer.MAX_VALUE;
        }
        this.zza = Arrays.copyOf(objArr, i5);
        this.zzc = false;
        Object[] objArr22 = this.zza;
        int i42 = this.zzb;
        this.zzb = i42 + 1;
        objArr22[i42] = obj;
        return this;
    }
}
