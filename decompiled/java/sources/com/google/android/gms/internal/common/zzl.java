package com.google.android.gms.internal.common;

import org.apache.commons.io.IOUtils;

/* loaded from: /root/release/classes.dex */
final class zzl extends zzk {
    private final char zza;

    zzl(char c3) {
        this.zza = c3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CharMatcher.is('");
        int i3 = this.zza;
        char[] cArr = {IOUtils.DIR_SEPARATOR_WINDOWS, 'u', 0, 0, 0, 0};
        for (int i4 = 0; i4 < 4; i4++) {
            cArr[5 - i4] = "0123456789ABCDEF".charAt(i3 & 15);
            i3 >>= 4;
        }
        sb.append(String.copyValueOf(cArr));
        sb.append("')");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.common.zzo
    public final boolean zza(char c3) {
        return c3 == this.zza;
    }
}
