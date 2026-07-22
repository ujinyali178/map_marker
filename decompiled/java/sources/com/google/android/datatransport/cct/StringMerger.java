package com.google.android.datatransport.cct;

/* loaded from: /root/release/classes.dex */
public final class StringMerger {
    static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i3 = 0; i3 < str.length(); i3++) {
            sb.append(str.charAt(i3));
            if (str2.length() > i3) {
                sb.append(str2.charAt(i3));
            }
        }
        return sb.toString();
    }
}
