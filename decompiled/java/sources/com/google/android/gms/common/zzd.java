package com.google.android.gms.common;

/* loaded from: /root/release/classes.dex */
public final class zzd {
    static int zza(int i3) {
        int[] iArr = {1, 2, 3};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr[i4];
            int i6 = i5 - 1;
            if (i5 == 0) {
                throw null;
            }
            if (i6 == i3) {
                return i5;
            }
        }
        return 1;
    }
}
