package com.google.android.gms.internal.auth;

/* loaded from: /root/release/classes.dex */
final class zzhb extends zzgz {
    zzhb() {
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zzev zzevVar = (zzev) obj;
        zzha zzhaVar = zzevVar.zzc;
        if (zzhaVar != zzha.zza()) {
            return zzhaVar;
        }
        zzha zzd = zzha.zzd();
        zzevVar.zzc = zzd;
        return zzd;
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    final /* synthetic */ Object zzb(Object obj) {
        return ((zzev) obj).zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    final /* bridge */ /* synthetic */ Object zzc(Object obj, Object obj2) {
        if (zzha.zza().equals(obj2)) {
            return obj;
        }
        zzha zzhaVar = (zzha) obj2;
        if (zzha.zza().equals(obj)) {
            return zzha.zzc((zzha) obj, zzhaVar);
        }
        ((zzha) obj).zzb(zzhaVar);
        return obj;
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    final /* bridge */ /* synthetic */ void zzd(Object obj, int i3, long j3) {
        ((zzha) obj).zzh(i3 << 3, Long.valueOf(j3));
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    final void zze(Object obj) {
        ((zzev) obj).zzc.zzf();
    }

    @Override // com.google.android.gms.internal.auth.zzgz
    final /* synthetic */ void zzf(Object obj, Object obj2) {
        ((zzev) obj).zzc = (zzha) obj2;
    }
}
