package com.google.android.gms.internal.maps;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.PinConfig;

/* loaded from: /root/release/classes.dex */
public final class zzg extends zza implements zzi {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzd() {
        Parcel zzJ = zzJ(4, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zze(float f3) {
        Parcel zza = zza();
        zza.writeFloat(f3);
        Parcel zzJ = zzJ(5, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzf(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzJ = zzJ(2, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzg(Bitmap bitmap) {
        Parcel zza = zza();
        zzc.zzd(zza, bitmap);
        Parcel zzJ = zzJ(6, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzh(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzJ = zzJ(3, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzi(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzJ = zzJ(7, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzj(PinConfig pinConfig) {
        Parcel zza = zza();
        zzc.zzd(zza, pinConfig);
        Parcel zzJ = zzJ(8, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzk(int i3) {
        Parcel zza = zza();
        zza.writeInt(i3);
        Parcel zzJ = zzJ(1, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }
}
