package com.google.maps.android.data.kml;

/* loaded from: /root/release/classes.dex */
public class KmlBoolean {
    public static boolean parseBoolean(String str) {
        return "1".equals(str) || "true".equals(str);
    }
}
