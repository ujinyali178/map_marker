package com.google.android.gms.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes.dex */
public final class CookieUtil {
    private CookieUtil() {
    }

    public static String getCookieUrl(String str, Boolean bool) {
        Preconditions.checkNotEmpty(str);
        return (true != zza(bool) ? "http" : "https") + "://" + str;
    }

    public static String getCookieValue(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Long l3) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append(Tag.KEY_VALUE_SEPARATOR);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (zza(bool)) {
            sb.append(";HttpOnly");
        }
        if (zza(bool2)) {
            sb.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(";Domain=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(";Path=");
            sb.append(str4);
        }
        if (l3 != null && l3.longValue() > 0) {
            sb.append(";Max-Age=");
            sb.append(l3);
        }
        if (!TextUtils.isEmpty(null)) {
            sb.append(";Priority=null");
        }
        if (!TextUtils.isEmpty(null)) {
            sb.append(";SameSite=null");
        }
        if (zza(null)) {
            sb.append(";SameParty");
        }
        return sb.toString();
    }

    private static boolean zza(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
