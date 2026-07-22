package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
/* loaded from: /root/release/classes.dex */
final class zzai extends zzag {
    static final zzag zza = new zzai(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzai(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.zzc = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzs.zza(i3, this.zzc, "index");
        Object obj = this.zzb[i3];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.common.zzag, com.google.android.gms.internal.common.zzac
    final int zza(Object[] objArr, int i3) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final Object[] zzg() {
        return this.zzb;
    }
}
