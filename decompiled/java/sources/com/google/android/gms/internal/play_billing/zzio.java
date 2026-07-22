package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
public final class zzio extends zzex implements zzgd {
    private static final zzio zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzio zzioVar = new zzio();
        zzb = zzioVar;
        zzex.zzp(zzio.class, zzioVar);
    }

    private zzio() {
    }

    public static zzin zzv() {
        return (zzin) zzb.zzg();
    }

    static /* synthetic */ void zzx(zzio zzioVar, String str) {
        str.getClass();
        zzioVar.zzd |= 1;
        zzioVar.zze = str;
    }

    static /* synthetic */ void zzy(zzio zzioVar, String str) {
        str.getClass();
        zzioVar.zzd |= 2;
        zzioVar.zzf = str;
    }

    @Override // com.google.android.gms.internal.play_billing.zzex
    protected final Object zzu(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzex.zzm(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzio();
        }
        zzim zzimVar = null;
        if (i4 == 4) {
            return new zzin(zzimVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
