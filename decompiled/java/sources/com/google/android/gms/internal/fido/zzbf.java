package com.google.android.gms.internal.fido;

import java.io.IOException;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes.dex */
public abstract class zzbf {
    private static final zzbf zza;
    private static final zzbf zzb;
    private static final zzbf zzc;
    private static final zzbf zzd;
    private static final zzbf zze;

    static {
        Character valueOf = Character.valueOf(Tag.KEY_VALUE_SEPARATOR);
        zza = new zzbd("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        zzb = new zzbd("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        zzc = new zzbe("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        zzd = new zzbe("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
        zze = new zzbc("base16()", "0123456789ABCDEF");
    }

    zzbf() {
    }

    public static zzbf zzd() {
        return zze;
    }

    abstract void zza(Appendable appendable, byte[] bArr, int i3, int i4);

    abstract int zzb(int i3);

    public final String zze(byte[] bArr, int i3, int i4) {
        zzam.zze(0, i4, bArr.length);
        StringBuilder sb = new StringBuilder(zzb(i4));
        try {
            zza(sb, bArr, 0, i4);
            return sb.toString();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }
}
