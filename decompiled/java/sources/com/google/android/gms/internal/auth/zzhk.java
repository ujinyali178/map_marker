package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;

/* loaded from: /root/release/classes.dex */
final class zzhk {
    static /* bridge */ /* synthetic */ void zza(byte b4, byte b5, byte b6, byte b7, char[] cArr, int i3) {
        if (zze(b5) || (((b4 << Ascii.FS) + (b5 + 112)) >> 30) != 0 || zze(b6) || zze(b7)) {
            throw zzfb.zzb();
        }
        int i4 = ((b4 & 7) << 18) | ((b5 & 63) << 12) | ((b6 & 63) << 6) | (b7 & 63);
        cArr[i3] = (char) ((i4 >>> 10) + 55232);
        cArr[i3 + 1] = (char) ((i4 & 1023) + 56320);
    }

    static /* bridge */ /* synthetic */ void zzb(byte b4, byte b5, byte b6, char[] cArr, int i3) {
        if (!zze(b5)) {
            if (b4 == -32) {
                if (b5 >= -96) {
                    b4 = -32;
                }
            }
            if (b4 == -19) {
                if (b5 < -96) {
                    b4 = -19;
                }
            }
            if (!zze(b6)) {
                cArr[i3] = (char) (((b4 & Ascii.SI) << 12) | ((b5 & 63) << 6) | (b6 & 63));
                return;
            }
        }
        throw zzfb.zzb();
    }

    static /* bridge */ /* synthetic */ void zzc(byte b4, byte b5, char[] cArr, int i3) {
        if (b4 < -62 || zze(b5)) {
            throw zzfb.zzb();
        }
        cArr[i3] = (char) (((b4 & Ascii.US) << 6) | (b5 & 63));
    }

    static /* bridge */ /* synthetic */ boolean zzd(byte b4) {
        return b4 >= 0;
    }

    private static boolean zze(byte b4) {
        return b4 > -65;
    }
}
