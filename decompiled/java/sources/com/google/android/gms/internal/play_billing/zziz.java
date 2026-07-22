package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
public final class zziz extends zzex implements zzgd {
    private static final zziz zzb;
    private int zzd;
    private int zze;

    static {
        zziz zzizVar = new zziz();
        zzb = zzizVar;
        zzex.zzp(zziz.class, zzizVar);
    }

    private zziz() {
    }

    public static zziz zzw() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzex
    protected final Object zzu(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzex.zzm(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zziy.zza});
        }
        if (i4 == 3) {
            return new zziz();
        }
        zziw zziwVar = null;
        if (i4 == 4) {
            return new zzix(zziwVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
