package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
public final class zzic extends zzex implements zzgd {
    private static final zzic zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;

    static {
        zzic zzicVar = new zzic();
        zzb = zzicVar;
        zzex.zzp(zzic.class, zzicVar);
    }

    private zzic() {
    }

    public static zzib zzv() {
        return (zzib) zzb.zzg();
    }

    static /* synthetic */ void zzx(zzic zzicVar, zzis zzisVar) {
        zzisVar.getClass();
        zzicVar.zzf = zzisVar;
        zzicVar.zze = 2;
    }

    static /* synthetic */ void zzy(zzic zzicVar, int i3) {
        zzicVar.zzg = i3 - 1;
        zzicVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzex
    protected final Object zzu(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzex.zzm(zzb, "\u0001\u0002\u0001\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzhz.zza, zzis.class});
        }
        if (i4 == 3) {
            return new zzic();
        }
        zzia zziaVar = null;
        if (i4 == 4) {
            return new zzib(zziaVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
