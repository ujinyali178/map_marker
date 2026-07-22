package com.google.android.gms.internal.play_billing;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /root/release/classes.dex */
public abstract class zzee extends zzdm {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzee.class.getName());
    private static final boolean zzd = zzhn.zzx();
    zzef zza;

    private zzee() {
    }

    /* synthetic */ zzee(zzed zzedVar) {
    }

    @Deprecated
    static int zzt(int i3, zzgc zzgcVar, zzgm zzgmVar) {
        int zza = ((zzdg) zzgcVar).zza(zzgmVar);
        int zzx = zzx(i3 << 3);
        return zzx + zzx + zza;
    }

    public static int zzu(int i3) {
        if (i3 >= 0) {
            return zzx(i3);
        }
        return 10;
    }

    static int zzv(zzgc zzgcVar, zzgm zzgmVar) {
        int zza = ((zzdg) zzgcVar).zza(zzgmVar);
        return zzx(zza) + zza;
    }

    public static int zzw(String str) {
        int length;
        try {
            length = zzhs.zzc(str);
        } catch (zzhr unused) {
            length = str.getBytes(zzfd.zzb).length;
        }
        return zzx(length) + length;
    }

    public static int zzx(int i3) {
        if ((i3 & (-128)) == 0) {
            return 1;
        }
        if ((i3 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i3) == 0) {
            return 3;
        }
        return (i3 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzy(long j3) {
        int i3;
        if (((-128) & j3) == 0) {
            return 1;
        }
        if (j3 < 0) {
            return 10;
        }
        if (((-34359738368L) & j3) != 0) {
            i3 = 6;
            j3 >>>= 28;
        } else {
            i3 = 2;
        }
        if (((-2097152) & j3) != 0) {
            j3 >>>= 14;
            i3 += 2;
        }
        return (j3 & (-16384)) != 0 ? i3 + 1 : i3;
    }

    public static zzee zzz(byte[] bArr, int i3, int i4) {
        return new zzeb(bArr, 0, i4);
    }

    public final void zzA() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zzB(String str, zzhr zzhrVar) {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhrVar);
        byte[] bytes = str.getBytes(zzfd.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzec(e3);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b4);

    public abstract void zzd(int i3, boolean z3);

    public abstract void zze(int i3, zzdw zzdwVar);

    public abstract void zzf(int i3, int i4);

    public abstract void zzg(int i3);

    public abstract void zzh(int i3, long j3);

    public abstract void zzi(long j3);

    public abstract void zzj(int i3, int i4);

    public abstract void zzk(int i3);

    public abstract void zzl(byte[] bArr, int i3, int i4);

    public abstract void zzm(int i3, String str);

    public abstract void zzo(int i3, int i4);

    public abstract void zzp(int i3, int i4);

    public abstract void zzq(int i3);

    public abstract void zzr(int i3, long j3);

    public abstract void zzs(long j3);
}
