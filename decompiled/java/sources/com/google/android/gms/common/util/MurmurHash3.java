package com.google.android.gms.common.util;

/* loaded from: /root/release/classes.dex */
public class MurmurHash3 {
    private MurmurHash3() {
    }

    public static int murmurhash3_x86_32(byte[] bArr, int i3, int i4, int i5) {
        int i6;
        int i7 = i3;
        while (true) {
            i6 = (i4 & (-4)) + i3;
            if (i7 >= i6) {
                break;
            }
            int i8 = ((bArr[i7] & 255) | ((bArr[i7 + 1] & 255) << 8) | ((bArr[i7 + 2] & 255) << 16) | (bArr[i7 + 3] << 24)) * (-862048943);
            int i9 = i5 ^ (((i8 >>> 17) | (i8 << 15)) * 461845907);
            i5 = (((i9 >>> 19) | (i9 << 13)) * 5) - 430675100;
            i7 += 4;
        }
        int i10 = i4 & 3;
        if (i10 != 1) {
            if (i10 != 2) {
                r0 = i10 == 3 ? (bArr[i6 + 2] & 255) << 16 : 0;
                int i11 = i5 ^ i4;
                int i12 = (i11 ^ (i11 >>> 16)) * (-2048144789);
                int i13 = (i12 ^ (i12 >>> 13)) * (-1028477387);
                return i13 ^ (i13 >>> 16);
            }
            r0 |= (bArr[i6 + 1] & 255) << 8;
        }
        int i14 = ((bArr[i6] & 255) | r0) * (-862048943);
        i5 ^= ((i14 >>> 17) | (i14 << 15)) * 461845907;
        int i112 = i5 ^ i4;
        int i122 = (i112 ^ (i112 >>> 16)) * (-2048144789);
        int i132 = (i122 ^ (i122 >>> 13)) * (-1028477387);
        return i132 ^ (i132 >>> 16);
    }
}
