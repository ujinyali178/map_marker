package com.google.android.gms.internal.play_billing;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: /root/release/classes.dex */
public final class zzcz {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzdd zzb;

    static {
        zzdd zzdeVar;
        int i3 = 0;
        while (true) {
            if (i3 >= 2) {
                zzdeVar = new zzde();
                break;
            }
            try {
                zzdeVar = (zzdd) Class.forName(zza[i3]).asSubclass(zzdd.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused) {
                zzdeVar = null;
            }
            if (zzdeVar != null) {
                break;
            } else {
                i3++;
            }
        }
        zzb = zzdeVar;
    }

    @NullableDecl
    public static StackTraceElement zza(Class cls, int i3) {
        zzda.zza(cls, "target");
        return zzb.zza(cls, 2);
    }
}
