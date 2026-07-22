package com.google.android.gms.maps.internal;

/* loaded from: /root/release/classes.dex */
public final class zza {
    public static byte zza(Boolean bool) {
        if (bool != null) {
            return !bool.booleanValue() ? (byte) 0 : (byte) 1;
        }
        return (byte) -1;
    }

    public static Boolean zzb(byte b4) {
        if (b4 == 0) {
            return Boolean.FALSE;
        }
        if (b4 != 1) {
            return null;
        }
        return Boolean.TRUE;
    }
}
