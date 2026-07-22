package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
final class zzfu implements zzgn {
    private static final zzga zza = new zzfs();
    private final zzga zzb;

    public zzfu() {
        zzga zzgaVar;
        zzga[] zzgaVarArr = new zzga[2];
        zzgaVarArr[0] = zzes.zza();
        try {
            zzgaVar = (zzga) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzgaVar = zza;
        }
        zzgaVarArr[1] = zzgaVar;
        zzft zzftVar = new zzft(zzgaVarArr);
        byte[] bArr = zzfd.zzd;
        this.zzb = zzftVar;
    }

    private static boolean zzb(zzfz zzfzVar) {
        return zzfzVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgn
    public final zzgm zza(Class cls) {
        zzgh zza2;
        zzfq zzc;
        zzhd zzm;
        zzek zza3;
        zzfx zza4;
        zzhd zzm2;
        zzek zza5;
        zzgo.zzq(cls);
        zzfz zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzex.class.isAssignableFrom(cls)) {
                zzm2 = zzgo.zzn();
                zza5 = zzem.zzb();
            } else {
                zzm2 = zzgo.zzm();
                zza5 = zzem.zza();
            }
            return zzgg.zzc(zzm2, zza5, zzb.zza());
        }
        if (zzex.class.isAssignableFrom(cls)) {
            boolean zzb2 = zzb(zzb);
            zza2 = zzgi.zzb();
            zzc = zzfq.zzd();
            zzm = zzgo.zzn();
            zza3 = zzb2 ? zzem.zzb() : null;
            zza4 = zzfy.zzb();
        } else {
            boolean zzb3 = zzb(zzb);
            zza2 = zzgi.zza();
            zzc = zzfq.zzc();
            zzm = zzgo.zzm();
            zza3 = zzb3 ? zzem.zza() : null;
            zza4 = zzfy.zza();
        }
        return zzgf.zzl(cls, zzb, zza2, zzc, zzm, zza3, zza4);
    }
}
