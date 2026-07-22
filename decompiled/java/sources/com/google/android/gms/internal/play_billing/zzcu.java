package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /root/release/classes.dex */
final class zzcu implements Iterator {
    final /* synthetic */ zzcv zza;
    private int zzb = 0;

    zzcu(zzcv zzcvVar) {
        this.zza = zzcvVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i3 = this.zzb;
        zzcv zzcvVar = this.zza;
        return i3 < zzcvVar.zza() - zzcvVar.zzb();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object[] objArr;
        int i3 = this.zzb;
        zzcv zzcvVar = this.zza;
        if (i3 >= zzcvVar.zza() - zzcvVar.zzb()) {
            throw new NoSuchElementException();
        }
        zzcv zzcvVar2 = this.zza;
        objArr = zzcvVar2.zzb.zzb;
        Object obj = objArr[zzcvVar2.zzb() + i3];
        this.zzb = i3 + 1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
