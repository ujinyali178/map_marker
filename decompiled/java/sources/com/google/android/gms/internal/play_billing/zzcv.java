package com.google.android.gms.internal.play_billing;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
final class zzcv extends AbstractSet {
    final int zza = -1;
    final /* synthetic */ zzcw zzb;

    zzcv(zzcw zzcwVar, int i3) {
        this.zzb = zzcwVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Object[] objArr;
        int i3 = this.zza;
        objArr = this.zzb.zzb;
        return Arrays.binarySearch(objArr, zzb(), zza(), obj, i3 == -1 ? zzcw.zza : zzcy.zza) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzcu(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zza() - zzb();
    }

    final int zza() {
        int[] iArr;
        int i3 = this.zza;
        iArr = this.zzb.zzc;
        return iArr[i3 + 1];
    }

    final int zzb() {
        int[] iArr;
        if (this.zza == -1) {
            return 0;
        }
        iArr = this.zzb.zzc;
        return iArr[0];
    }
}
