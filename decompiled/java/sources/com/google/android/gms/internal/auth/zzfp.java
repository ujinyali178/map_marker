package com.google.android.gms.internal.auth;

/* loaded from: /root/release/classes.dex */
final class zzfp implements zzgj {
    private static final zzfv zza = new zzfn();
    private final zzfv zzb;

    public zzfp() {
        zzfv zzfvVar;
        zzfv[] zzfvVarArr = new zzfv[2];
        zzfvVarArr[0] = zzes.zza();
        try {
            zzfvVar = (zzfv) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzfvVar = zza;
        }
        zzfvVarArr[1] = zzfvVar;
        zzfo zzfoVar = new zzfo(zzfvVarArr);
        byte[] bArr = zzfa.zzd;
        this.zzb = zzfoVar;
    }

    private static boolean zzb(zzfu zzfuVar) {
        return zzfuVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.auth.zzgj
    public final zzgi zza(Class cls) {
        zzgc zza2;
        zzfl zzc;
        zzgz zza3;
        zzem zza4;
        zzfs zza5;
        zzgz zza6;
        zzem zza7;
        zzgk.zze(cls);
        zzfu zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzev.class.isAssignableFrom(cls)) {
                zza6 = zzgk.zzb();
                zza7 = zzeo.zzb();
            } else {
                zza6 = zzgk.zza();
                zza7 = zzeo.zza();
            }
            return zzgb.zzb(zza6, zza7, zzb.zza());
        }
        if (zzev.class.isAssignableFrom(cls)) {
            boolean zzb2 = zzb(zzb);
            zza2 = zzgd.zzb();
            zzc = zzfl.zzd();
            zza3 = zzgk.zzb();
            zza4 = zzb2 ? zzeo.zzb() : null;
            zza5 = zzft.zzb();
        } else {
            boolean zzb3 = zzb(zzb);
            zza2 = zzgd.zza();
            zzc = zzfl.zzc();
            zza3 = zzgk.zza();
            zza4 = zzb3 ? zzeo.zza() : null;
            zza5 = zzft.zza();
        }
        return zzga.zzj(cls, zzb, zza2, zzc, zza3, zza4, zza5);
    }
}
