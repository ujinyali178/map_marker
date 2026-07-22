package com.google.android.gms.location;

/* loaded from: /root/release/classes.dex */
public final class zzai {
    public static String zza(int i3) {
        if (i3 == 0) {
            return "THROTTLE_BACKGROUND";
        }
        if (i3 == 1) {
            return "THROTTLE_ALWAYS";
        }
        if (i3 == 2) {
            return "THROTTLE_NEVER";
        }
        throw new IllegalArgumentException();
    }
}
