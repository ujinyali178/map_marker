package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
public final class zzda {
    public static Object zza(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str.concat(" must not be null"));
    }

    public static String zzb(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("identifier must not be empty");
        }
        if (!zzc(str.charAt(0))) {
            throw new IllegalArgumentException("identifier must start with an ASCII letter: ".concat(str));
        }
        for (int i3 = 1; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (!zzc(charAt) && ((charAt < '0' || charAt > '9') && charAt != '_')) {
                throw new IllegalArgumentException("identifier must contain only ASCII letters, digits or underscore: ".concat(str));
            }
        }
        return str;
    }

    private static boolean zzc(char c3) {
        if (c3 < 'a' || c3 > 'z') {
            return c3 >= 'A' && c3 <= 'Z';
        }
        return true;
    }
}
