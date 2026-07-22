package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
public class zzba {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;

    protected zzba(String str, Class cls, boolean z3) {
        this(str, cls, z3, true);
    }

    private zzba(String str, Class cls, boolean z3, boolean z4) {
        zzda.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z3;
        System.identityHashCode(this);
        for (int i3 = 0; i3 < 5; i3++) {
        }
    }

    public static zzba zza(String str, Class cls) {
        return new zzba(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        return getClass().getName() + "/" + this.zza + "[" + cls.getName() + "]";
    }

    public final boolean zzb() {
        return this.zzc;
    }
}
