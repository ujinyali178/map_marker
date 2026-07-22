package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: /root/release/classes.dex */
public final class zzab extends zza implements zzad {
    zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzA(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzB(boolean z3) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(14, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzC(float f3) {
        Parcel zza = zza();
        zza.writeFloat(f3);
        zzc(27, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzD() {
        zzc(11, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzE(zzad zzadVar) {
        Parcel zza = zza();
        zzc.zze(zza, zzadVar);
        Parcel zzJ = zzJ(16, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzF() {
        Parcel zzJ = zzJ(10, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzG() {
        Parcel zzJ = zzJ(21, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzH() {
        Parcel zzJ = zzJ(13, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzI() {
        Parcel zzJ = zzJ(15, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zzd() {
        Parcel zzJ = zzJ(26, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zze() {
        Parcel zzJ = zzJ(23, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zzf() {
        Parcel zzJ = zzJ(28, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final int zzg() {
        Parcel zzJ = zzJ(17, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final IObjectWrapper zzh() {
        Parcel zzJ = zzJ(34, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final IObjectWrapper zzi() {
        Parcel zzJ = zzJ(30, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final LatLng zzj() {
        Parcel zzJ = zzJ(4, zza());
        LatLng latLng = (LatLng) zzc.zza(zzJ, LatLng.CREATOR);
        zzJ.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzk() {
        Parcel zzJ = zzJ(2, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzl() {
        Parcel zzJ = zzJ(8, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzm() {
        Parcel zzJ = zzJ(6, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzn() {
        zzc(12, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzo() {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzp(float f3) {
        Parcel zza = zza();
        zza.writeFloat(f3);
        zzc(25, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzq(float f3, float f4) {
        Parcel zza = zza();
        zza.writeFloat(f3);
        zza.writeFloat(f4);
        zzc(19, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzr(boolean z3) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(9, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzs(boolean z3) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(20, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzt(IObjectWrapper iObjectWrapper) {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(18, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzu(IObjectWrapper iObjectWrapper) {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(33, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzv(float f3, float f4) {
        Parcel zza = zza();
        zza.writeFloat(f3);
        zza.writeFloat(f4);
        zzc(24, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzw(LatLng latLng) {
        Parcel zza = zza();
        zzc.zzd(zza, latLng);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzx(float f3) {
        Parcel zza = zza();
        zza.writeFloat(f3);
        zzc(22, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzy(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(7, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzz(IObjectWrapper iObjectWrapper) {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(29, zza);
    }
}
