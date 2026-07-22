package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
final class zzhf extends zzhd {
    zzhf() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzhd
    final /* synthetic */ int zza(Object obj) {
        return ((zzhe) obj).zza();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhd
    final /* synthetic */ int zzb(Object obj) {
        return ((zzhe) obj).zzb();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhd
    final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzex zzexVar = (zzex) obj;
        zzhe zzheVar = zzexVar.zzc;
        if (zzheVar != zzhe.zzc()) {
            return zzheVar;
        }
        zzhe zzf = zzhe.zzf();
        zzexVar.zzc = zzf;
        return zzf;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhd
    final /* synthetic */ Object zzd(Object obj) {
        return ((zzex) obj).zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhd
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzhe.zzc().equals(obj2)) {
            return obj;
        }
        zzhe zzheVar = (zzhe) obj2;
        if (zzhe.zzc().equals(obj)) {
            return zzhe.zze((zzhe) obj, zzheVar);
        }
        ((zzhe) obj).zzd(zzheVar);
        return obj;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhd
    final /* bridge */ /* synthetic */ void zzf(Object obj, int i3, long j3) {
        ((zzhe) obj).zzj(i3 << 3, Long.valueOf(j3));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhd
    final void zzg(Object obj) {
        ((zzex) obj).zzc.zzh();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhd
    final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzex) obj).zzc = (zzhe) obj2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhd
    final /* synthetic */ void zzi(Object obj, zzhv zzhvVar) {
        ((zzhe) obj).zzk(zzhvVar);
    }
}
