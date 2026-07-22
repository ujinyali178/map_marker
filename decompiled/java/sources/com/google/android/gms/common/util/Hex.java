package com.google.android.gms.common.util;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* loaded from: /root/release/classes.dex */
public class Hex {
    private static final char[] zza = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] zzb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String bytesToStringLowercase(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i3 = 0;
        for (byte b4 : bArr) {
            int i4 = b4 & UnsignedBytes.MAX_VALUE;
            int i5 = i3 + 1;
            char[] cArr2 = zzb;
            cArr[i3] = cArr2[i4 >>> 4];
            cArr[i5] = cArr2[i4 & 15];
            i3 = i5 + 1;
        }
        return new String(cArr);
    }

    public static String bytesToStringUppercase(byte[] bArr) {
        return bytesToStringUppercase(bArr, false);
    }

    public static String bytesToStringUppercase(byte[] bArr, boolean z3) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i3 = 0; i3 < length && (!z3 || i3 != length - 1 || (bArr[i3] & UnsignedBytes.MAX_VALUE) != 0); i3++) {
            char[] cArr = zza;
            sb.append(cArr[(bArr[i3] & 240) >>> 4]);
            sb.append(cArr[bArr[i3] & Ascii.SI]);
        }
        return sb.toString();
    }

    public static byte[] stringToBytes(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Hex string has odd number of characters");
        }
        byte[] bArr = new byte[length / 2];
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 2;
            bArr[i3 / 2] = (byte) Integer.parseInt(str.substring(i3, i4), 16);
            i3 = i4;
        }
        return bArr;
    }
}
