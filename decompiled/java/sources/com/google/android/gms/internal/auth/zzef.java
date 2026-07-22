package com.google.android.gms.internal.auth;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: /root/release/classes.dex */
public abstract class zzef implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzef zzb = new zzec(zzfa.zzd);
    private static final zzee zzd;
    private int zzc = 0;

    static {
        int i3 = zzds.zza;
        zzd = new zzee(null);
        zza = new zzdx();
    }

    zzef() {
    }

    static int zzi(int i3, int i4, int i5) {
        int i6 = i4 - i3;
        if ((i3 | i4 | i6 | (i5 - i4)) >= 0) {
            return i6;
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i3 + " < 0");
        }
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i3 + ", " + i4);
        }
        throw new IndexOutOfBoundsException("End index: " + i4 + " >= " + i5);
    }

    public static zzef zzk(byte[] bArr, int i3, int i4) {
        zzi(i3, i3 + i4, bArr.length);
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i3, bArr2, 0, i4);
        return new zzec(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i3 = this.zzc;
        if (i3 == 0) {
            int zzd2 = zzd();
            i3 = zze(zzd2, 0, zzd2);
            if (i3 == 0) {
                i3 = 1;
            }
            this.zzc = i3;
        }
        return i3;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzdw(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        objArr[2] = zzd() <= 50 ? zzgx.zza(this) : zzgx.zza(zzf(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i3);

    abstract byte zzb(int i3);

    public abstract int zzd();

    protected abstract int zze(int i3, int i4, int i5);

    public abstract zzef zzf(int i3, int i4);

    protected abstract String zzg(Charset charset);

    public abstract boolean zzh();

    protected final int zzj() {
        return this.zzc;
    }

    public final String zzl(Charset charset) {
        return zzd() == 0 ? "" : zzg(charset);
    }
}
