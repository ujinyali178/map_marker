package org.mapsforge.core.graphics;

/* loaded from: /root/release/classes2.dex */
public enum Join {
    BEVEL,
    MITER,
    ROUND;

    public static Join fromString(String str) {
        if ("bevel".equals(str)) {
            return BEVEL;
        }
        if ("round".equals(str)) {
            return ROUND;
        }
        if ("miter".equals(str)) {
            return MITER;
        }
        throw new IllegalArgumentException("Invalid value for Join: " + str);
    }
}
