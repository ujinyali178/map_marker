package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: /root/release/classes.dex */
public final class zzl extends com.google.android.gms.internal.maps.zza implements IMapViewDelegate {
    zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IMapViewDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final IGoogleMapDelegate getMap() {
        IGoogleMapDelegate zzgVar;
        Parcel zzJ = zzJ(1, zza());
        IBinder readStrongBinder = zzJ.readStrongBinder();
        if (readStrongBinder == null) {
            zzgVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            zzgVar = queryLocalInterface instanceof IGoogleMapDelegate ? (IGoogleMapDelegate) queryLocalInterface : new zzg(readStrongBinder);
        }
        zzJ.recycle();
        return zzgVar;
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void getMapAsync(zzat zzatVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzatVar);
        zzc(9, zza);
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final IObjectWrapper getView() {
        Parcel zzJ = zzJ(8, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onCreate(Bundle bundle) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, bundle);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onDestroy() {
        zzc(5, zza());
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onEnterAmbient(Bundle bundle) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, bundle);
        zzc(10, zza);
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onExitAmbient() {
        zzc(11, zza());
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onLowMemory() {
        zzc(6, zza());
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onPause() {
        zzc(4, zza());
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onResume() {
        zzc(3, zza());
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onSaveInstanceState(Bundle bundle) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, bundle);
        Parcel zzJ = zzJ(7, zza);
        if (zzJ.readInt() != 0) {
            bundle.readFromParcel(zzJ);
        }
        zzJ.recycle();
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onStart() {
        zzc(12, zza());
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onStop() {
        zzc(13, zza());
    }
}
