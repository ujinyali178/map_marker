package com.google.crypto.tink.subtle;

import com.google.common.primitives.UnsignedBytes;

/* loaded from: /root/release/classes.dex */
public final class Hex {
    private Hex() {
    }

    public static byte[] decode(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Expected a string of even length");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 2;
            int digit = Character.digit(str.charAt(i4), 16);
            int digit2 = Character.digit(str.charAt(i4 + 1), 16);
            if (digit == -1 || digit2 == -1) {
                throw new IllegalArgumentException("input is not hexadecimal");
            }
            bArr[i3] = (byte) ((digit * 16) + digit2);
        }
        return bArr;
    }

    public static String encode(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            int i3 = b4 & UnsignedBytes.MAX_VALUE;
            sb.append("0123456789abcdef".charAt(i3 / 16));
            sb.append("0123456789abcdef".charAt(i3 % 16));
        }
        return sb.toString();
    }
}
