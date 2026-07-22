package com.google.android.gms.internal.auth;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: /root/release/classes.dex */
public final class zzfa {
    static final Charset zza = Charset.forName("US-ASCII");
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzej zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i3 = zzej.zza;
        zzeh zzehVar = new zzeh(bArr, 0, 0, false, null);
        try {
            zzehVar.zza(0);
            zzf = zzehVar;
        } catch (zzfb e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public static int zza(boolean z3) {
        return z3 ? 1231 : 1237;
    }

    static int zzb(int i3, byte[] bArr, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            i3 = (i3 * 31) + bArr[i6];
        }
        return i3;
    }

    static Object zzc(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zzb);
    }
}
