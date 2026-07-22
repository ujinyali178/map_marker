package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
public final class zzis extends zzex implements zzgd {
    private static final zzis zzb;
    private int zzd;
    private int zze;

    static {
        zzis zzisVar = new zzis();
        zzb = zzisVar;
        zzex.zzp(zzis.class, zzisVar);
    }

    private zzis() {
    }

    public static zziq zzv() {
        return (zziq) zzb.zzg();
    }

    static /* synthetic */ void zzx(zzis zzisVar, int i3) {
        zzisVar.zze = i3 - 1;
        zzisVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzex
    protected final Object zzu(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzex.zzm(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzir.zza});
        }
        if (i4 == 3) {
            return new zzis();
        }
        zzip zzipVar = null;
        if (i4 == 4) {
            return new zziq(zzipVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
