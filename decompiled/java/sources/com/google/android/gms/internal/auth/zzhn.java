package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;

/* loaded from: /root/release/classes.dex */
final class zzhn {
    public static final /* synthetic */ int zza = 0;
    private static final zzhl zzb;

    static {
        if (zzhj.zzu() && zzhj.zzv()) {
            int i3 = zzds.zza;
        }
        zzb = new zzhm();
    }

    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i3, int i4) {
        int i5 = i4 - i3;
        byte b4 = bArr[i3 - 1];
        if (i5 != 0) {
            if (i5 == 1) {
                byte b5 = bArr[i3];
                if (b4 <= -12 && b5 <= -65) {
                    return b4 ^ (b5 << 8);
                }
            } else {
                if (i5 != 2) {
                    throw new AssertionError();
                }
                byte b6 = bArr[i3];
                byte b7 = bArr[i3 + 1];
                if (b4 <= -12 && b6 <= -65 && b7 <= -65) {
                    return ((b6 << 8) ^ b4) ^ (b7 << Ascii.DLE);
                }
            }
        } else if (b4 <= -12) {
            return b4;
        }
        return -1;
    }

    static boolean zzb(byte[] bArr) {
        return zzb.zzb(bArr, 0, bArr.length);
    }

    static boolean zzc(byte[] bArr, int i3, int i4) {
        return zzb.zzb(bArr, i3, i4);
    }
}
