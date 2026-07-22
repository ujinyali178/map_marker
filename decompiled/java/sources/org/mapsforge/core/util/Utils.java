package org.mapsforge.core.util;

/* loaded from: /root/release/classes2.dex */
public final class Utils {
    private Utils() {
        throw new IllegalStateException();
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
