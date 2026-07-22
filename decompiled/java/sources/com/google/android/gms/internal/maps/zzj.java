package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public final class zzj extends zza implements zzl {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ICircleDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final boolean zzA() {
        Parcel zzJ = zzJ(16, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final double zzd() {
        Parcel zzJ = zzJ(6, zza());
        double readDouble = zzJ.readDouble();
        zzJ.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final float zze() {
        Parcel zzJ = zzJ(8, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final float zzf() {
        Parcel zzJ = zzJ(14, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final int zzg() {
        Parcel zzJ = zzJ(12, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final int zzh() {
        Parcel zzJ = zzJ(10, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final int zzi() {
        Parcel zzJ = zzJ(18, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final IObjectWrapper zzj() {
        Parcel zzJ = zzJ(24, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final LatLng zzk() {
        Parcel zzJ = zzJ(4, zza());
        LatLng latLng = (LatLng) zzc.zza(zzJ, LatLng.CREATOR);
        zzJ.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final String zzl() {
        Parcel zzJ = zzJ(2, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final List zzm() {
        Parcel zzJ = zzJ(22, zza());
        ArrayList createTypedArrayList = zzJ.createTypedArrayList(PatternItem.CREATOR);
        zzJ.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzn() {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzo(LatLng latLng) {
        Parcel zza = zza();
        zzc.zzd(zza, latLng);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzp(boolean z3) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(19, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzq(int i3) {
        Parcel zza = zza();
        zza.writeInt(i3);
        zzc(11, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzr(double d3) {
        Parcel zza = zza();
        zza.writeDouble(d3);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzs(int i3) {
        Parcel zza = zza();
        zza.writeInt(i3);
        zzc(9, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzt(List list) {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzc(21, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzu(float f3) {
        Parcel zza = zza();
        zza.writeFloat(f3);
        zzc(7, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzv(IObjectWrapper iObjectWrapper) {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(23, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzw(boolean z3) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(15, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzx(float f3) {
        Parcel zza = zza();
        zza.writeFloat(f3);
        zzc(13, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final boolean zzy(zzl zzlVar) {
        Parcel zza = zza();
        zzc.zze(zza, zzlVar);
        Parcel zzJ = zzJ(17, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final boolean zzz() {
        Parcel zzJ = zzJ(20, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }
}
