package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
/* loaded from: /root/release/classes.dex */
public final class zzah {
    static Object[] zza(Object[] objArr, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (objArr[i4] == null) {
                throw new NullPointerException("at index " + i4);
            }
        }
        return objArr;
    }
}
