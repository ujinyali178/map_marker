package com.google.android.gms.internal.maps;

/* loaded from: /root/release/classes.dex */
final class zzbc extends zzaz {
    static final zzaz zza = new zzbc(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzbc(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.zzc = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzas.zza(i3, this.zzc, "index");
        Object obj = this.zzb[i3];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.maps.zzaz, com.google.android.gms.internal.maps.zzaw
    final int zza(Object[] objArr, int i3) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    final Object[] zze() {
        return this.zzb;
    }
}
