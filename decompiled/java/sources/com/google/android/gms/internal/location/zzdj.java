package com.google.android.gms.internal.location;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: /root/release/classes.dex */
public final class zzdj {
    private static final SimpleDateFormat zza;
    private static final SimpleDateFormat zzb;
    private static final StringBuilder zzc;

    static {
        Locale locale = Locale.ROOT;
        zza = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        zzb = new SimpleDateFormat("MM-dd HH:mm:ss", locale);
        zzc = new StringBuilder(33);
    }

    public static String zza(long j3) {
        String sb;
        StringBuilder sb2 = zzc;
        synchronized (sb2) {
            sb2.setLength(0);
            zzb(j3, sb2);
            sb = sb2.toString();
        }
        return sb;
    }

    public static void zzb(long j3, StringBuilder sb) {
        String str;
        if (j3 == 0) {
            str = "0s";
        } else {
            sb.ensureCapacity(sb.length() + 27);
            boolean z3 = false;
            if (j3 < 0) {
                sb.append("-");
                if (j3 != Long.MIN_VALUE) {
                    j3 = -j3;
                } else {
                    j3 = Long.MAX_VALUE;
                    z3 = true;
                }
            }
            if (j3 >= 86400000) {
                sb.append(j3 / 86400000);
                sb.append("d");
                j3 %= 86400000;
            }
            if (true == z3) {
                j3 = 25975808;
            }
            if (j3 >= 3600000) {
                sb.append(j3 / 3600000);
                sb.append("h");
                j3 %= 3600000;
            }
            if (j3 >= 60000) {
                sb.append(j3 / 60000);
                sb.append("m");
                j3 %= 60000;
            }
            if (j3 >= 1000) {
                sb.append(j3 / 1000);
                sb.append("s");
                j3 %= 1000;
            }
            if (j3 <= 0) {
                return;
            }
            sb.append(j3);
            str = "ms";
        }
        sb.append(str);
    }
}
