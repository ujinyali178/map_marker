package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public final class zzv extends zza implements zzx {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final int zzd() {
        Parcel zzJ = zzJ(5, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final String zze() {
        Parcel zzJ = zzJ(1, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final String zzf() {
        Parcel zzJ = zzJ(2, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final void zzg() {
        zzc(3, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final boolean zzh(zzx zzxVar) {
        Parcel zza = zza();
        zzc.zze(zza, zzxVar);
        Parcel zzJ = zzJ(4, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }
}
