package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;

/* loaded from: /root/release/classes.dex */
final class zzhm extends zzhl {
    zzhm() {
    }

    @Override // com.google.android.gms.internal.auth.zzhl
    final int zza(int i3, byte[] bArr, int i4, int i5) {
        while (i4 < i5 && bArr[i4] >= 0) {
            i4++;
        }
        if (i4 >= i5) {
            return 0;
        }
        while (i4 < i5) {
            int i6 = i4 + 1;
            byte b4 = bArr[i4];
            if (b4 < 0) {
                if (b4 < -32) {
                    if (i6 >= i5) {
                        return b4;
                    }
                    if (b4 >= -62) {
                        i4 = i6 + 1;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return -1;
                }
                if (b4 >= -16) {
                    if (i6 >= i5 - 2) {
                        return zzhn.zza(bArr, i6, i5);
                    }
                    int i7 = i6 + 1;
                    byte b5 = bArr[i6];
                    if (b5 <= -65 && (((b4 << Ascii.FS) + (b5 + 112)) >> 30) == 0) {
                        int i8 = i7 + 1;
                        if (bArr[i7] <= -65) {
                            i6 = i8 + 1;
                            if (bArr[i8] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i6 >= i5 - 1) {
                    return zzhn.zza(bArr, i6, i5);
                }
                int i9 = i6 + 1;
                byte b6 = bArr[i6];
                if (b6 <= -65 && ((b4 != -32 || b6 >= -96) && (b4 != -19 || b6 < -96))) {
                    i4 = i9 + 1;
                    if (bArr[i9] > -65) {
                    }
                }
                return -1;
            }
            i4 = i6;
        }
        return 0;
    }
}
