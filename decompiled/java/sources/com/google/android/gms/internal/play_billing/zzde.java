package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
final class zzde implements zzdd {
    zzde() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzdd
    public final StackTraceElement zza(Class cls, int i3) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String name = cls.getName();
        int i4 = 3;
        boolean z3 = false;
        while (true) {
            if (i4 >= stackTrace.length) {
                i4 = -1;
                break;
            }
            if (stackTrace[i4].getClassName().equals(name)) {
                z3 = true;
            } else {
                if (z3) {
                    break;
                }
                z3 = false;
            }
            i4++;
        }
        if (i4 != -1) {
            return stackTrace[i4];
        }
        return null;
    }
}
