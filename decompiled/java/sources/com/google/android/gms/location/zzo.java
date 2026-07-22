package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: /root/release/classes.dex */
public final class zzo {
    public static int zza(int i3) {
        boolean z3;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2) {
                z3 = false;
                Preconditions.checkArgument(z3, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i3));
                return i3;
            }
            i3 = 2;
        }
        z3 = true;
        Preconditions.checkArgument(z3, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i3));
        return i3;
    }

    public static String zzb(int i3) {
        if (i3 == 0) {
            return "GRANULARITY_PERMISSION_LEVEL";
        }
        if (i3 == 1) {
            return "GRANULARITY_COARSE";
        }
        if (i3 == 2) {
            return "GRANULARITY_FINE";
        }
        throw new IllegalArgumentException();
    }
}
