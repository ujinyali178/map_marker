package com.google.android.gms.internal.location;

/* loaded from: /root/release/classes.dex */
final class zzdt extends zzds {
    static final zzds zza = new zzdt(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzdt(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.zzc = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzdm.zza(i3, this.zzc, "index");
        Object obj = this.zzb[i3];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.location.zzds, com.google.android.gms.internal.location.zzdp
    final int zza(Object[] objArr, int i3) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    final Object[] zzg() {
        return this.zzb;
    }
}
