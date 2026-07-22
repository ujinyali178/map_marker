package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public final class zzak extends zza implements zzam {
    zzak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final float zzd() {
        Parcel zzJ = zzJ(13, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final float zze() {
        Parcel zzJ = zzJ(5, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final int zzf() {
        Parcel zzJ = zzJ(9, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final String zzg() {
        Parcel zzJ = zzJ(3, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final void zzh() {
        zzc(2, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final void zzi() {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final void zzj(boolean z3) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(10, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final void zzk(float f3) {
        Parcel zza = zza();
        zza.writeFloat(f3);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final void zzl(boolean z3) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final void zzm(float f3) {
        Parcel zza = zza();
        zza.writeFloat(f3);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final boolean zzn(zzam zzamVar) {
        Parcel zza = zza();
        zzc.zze(zza, zzamVar);
        Parcel zzJ = zzJ(8, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final boolean zzo() {
        Parcel zzJ = zzJ(11, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final boolean zzp() {
        Parcel zzJ = zzJ(7, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }
}
