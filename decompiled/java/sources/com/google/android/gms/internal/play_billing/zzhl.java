package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* loaded from: /root/release/classes.dex */
final class zzhl extends zzhm {
    zzhl(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final double zza(Object obj, long j3) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j3));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final float zzb(Object obj, long j3) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j3));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final void zzc(Object obj, long j3, boolean z3) {
        if (zzhn.zzb) {
            zzhn.zzD(obj, j3, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzhn.zzE(obj, j3, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final void zzd(Object obj, long j3, byte b4) {
        if (zzhn.zzb) {
            zzhn.zzD(obj, j3, b4);
        } else {
            zzhn.zzE(obj, j3, b4);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final void zze(Object obj, long j3, double d3) {
        this.zza.putLong(obj, j3, Double.doubleToLongBits(d3));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final void zzf(Object obj, long j3, float f3) {
        this.zza.putInt(obj, j3, Float.floatToIntBits(f3));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final boolean zzg(Object obj, long j3) {
        return zzhn.zzb ? zzhn.zzt(obj, j3) : zzhn.zzu(obj, j3);
    }
}
