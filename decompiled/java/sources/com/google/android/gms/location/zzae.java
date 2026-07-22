package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: /root/release/classes.dex */
public final class zzae {
    public static int zza(int i3) {
        boolean z3;
        if (i3 != 100 && i3 != 102 && i3 != 104) {
            if (i3 != 105) {
                z3 = false;
                Preconditions.checkArgument(z3, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(i3));
                return i3;
            }
            i3 = 105;
        }
        z3 = true;
        Preconditions.checkArgument(z3, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(i3));
        return i3;
    }

    public static String zzb(int i3) {
        if (i3 == 100) {
            return "HIGH_ACCURACY";
        }
        if (i3 == 102) {
            return "BALANCED_POWER_ACCURACY";
        }
        if (i3 == 104) {
            return "LOW_POWER";
        }
        if (i3 == 105) {
            return "PASSIVE";
        }
        throw new IllegalArgumentException();
    }
}
