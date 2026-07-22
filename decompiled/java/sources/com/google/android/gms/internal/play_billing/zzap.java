package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
final class zzap extends zzaf {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzap(Object[] objArr, int i3, int i4) {
        this.zza = objArr;
        this.zzb = i3;
        this.zzc = i4;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzx.zza(i3, this.zzc, "index");
        Object obj = this.zza[i3 + i3 + this.zzb];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    final boolean zzf() {
        return true;
    }
}
