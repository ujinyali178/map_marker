package com.google.common.primitives;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class ParseRequest {
    final int radix;
    final String rawValue;

    private ParseRequest(String str, int i3) {
        this.rawValue = str;
        this.radix = i3;
    }

    static ParseRequest fromString(String str) {
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        char charAt = str.charAt(0);
        int i3 = 16;
        if (str.startsWith("0x") || str.startsWith("0X")) {
            str = str.substring(2);
        } else if (charAt == '#') {
            str = str.substring(1);
        } else if (charAt != '0' || str.length() <= 1) {
            i3 = 10;
        } else {
            str = str.substring(1);
            i3 = 8;
        }
        return new ParseRequest(str, i3);
    }
}
