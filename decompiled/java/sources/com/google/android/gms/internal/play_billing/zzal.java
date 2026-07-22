package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
final class zzal extends zzaf {
    static final zzaf zza = new zzal(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzal(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.zzc = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzx.zza(i3, this.zzc, "index");
        Object obj = this.zzb[i3];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf, com.google.android.gms.internal.play_billing.zzac
    final int zza(Object[] objArr, int i3) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    final Object[] zzg() {
        return this.zzb;
    }
}
