package org.mapsforge.map.rendertheme.rule;

/* loaded from: /root/release/classes2.dex */
enum Closed {
    ANY,
    NO,
    YES;

    public static Closed fromString(String str) {
        if ("any".equals(str)) {
            return ANY;
        }
        if ("no".equals(str)) {
            return NO;
        }
        if ("yes".equals(str)) {
            return YES;
        }
        throw new IllegalArgumentException("Invalid value for Closed: " + str);
    }
}
