package com.google.android.gms.internal.location;

import java.util.List;
import javax.annotation.CheckForNull;

/* loaded from: /root/release/classes.dex */
final class zzdr extends zzds {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzds zzc;

    zzdr(zzds zzdsVar, int i3, int i4) {
        this.zzc = zzdsVar;
        this.zza = i3;
        this.zzb = i4;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzdm.zza(i3, this.zzb, "index");
        return this.zzc.get(i3 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.location.zzds, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i3, int i4) {
        return subList(i3, i4);
    }

    @Override // com.google.android.gms.internal.location.zzdp
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    @CheckForNull
    final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.location.zzds
    /* renamed from: zzh */
    public final zzds subList(int i3, int i4) {
        zzdm.zzc(i3, i4, this.zzb);
        zzds zzdsVar = this.zzc;
        int i5 = this.zza;
        return zzdsVar.subList(i3 + i5, i4 + i5);
    }
}
