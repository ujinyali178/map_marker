package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;

/* loaded from: /root/release/classes.dex */
final class zzhs {
    public static final /* synthetic */ int zza = 0;
    private static final zzhp zzb;

    static {
        if (zzhn.zzx() && zzhn.zzy()) {
            int i3 = zzdi.zza;
        }
        zzb = new zzhq();
    }

    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i3, int i4) {
        int i5 = i4 - i3;
        byte b4 = bArr[i3 - 1];
        if (i5 == 0) {
            if (b4 <= -12) {
                return b4;
            }
            return -1;
        }
        if (i5 == 1) {
            byte b5 = bArr[i3];
            if (b4 > -12 || b5 > -65) {
                return -1;
            }
            return (b5 << 8) ^ b4;
        }
        if (i5 != 2) {
            throw new AssertionError();
        }
        byte b6 = bArr[i3];
        byte b7 = bArr[i3 + 1];
        if (b4 > -12 || b6 > -65 || b7 > -65) {
            return -1;
        }
        return (b7 << Ascii.DLE) ^ ((b6 << 8) ^ b4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0101, code lost:
    
        return r10 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int zzb(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzhs.zzb(java.lang.CharSequence, byte[], int, int):int");
    }

    static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = 0;
        while (i4 < length && charSequence.charAt(i4) < 128) {
            i4++;
        }
        int i5 = length;
        while (true) {
            if (i4 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i4);
            if (charAt < 2048) {
                i5 += (127 - charAt) >>> 31;
                i4++;
            } else {
                int length2 = charSequence.length();
                while (i4 < length2) {
                    char charAt2 = charSequence.charAt(i4);
                    if (charAt2 < 2048) {
                        i3 += (127 - charAt2) >>> 31;
                    } else {
                        i3 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i4) < 65536) {
                                throw new zzhr(i4, length2);
                            }
                            i4++;
                        }
                    }
                    i4++;
                }
                i5 += i3;
            }
        }
        if (i5 >= length) {
            return i5;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i5 + 4294967296L));
    }

    static boolean zzd(byte[] bArr) {
        return zzb.zzb(bArr, 0, bArr.length);
    }

    static boolean zze(byte[] bArr, int i3, int i4) {
        return zzb.zzb(bArr, i3, i4);
    }
}
