package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

/* loaded from: /root/release/classes.dex */
public final class zzby extends com.google.android.gms.internal.maps.zza implements IStreetViewPanoramaFragmentDelegate {
    zzby(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final IStreetViewPanoramaDelegate getStreetViewPanorama() {
        IStreetViewPanoramaDelegate zzbxVar;
        Parcel zzJ = zzJ(1, zza());
        IBinder readStrongBinder = zzJ.readStrongBinder();
        if (readStrongBinder == null) {
            zzbxVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            zzbxVar = queryLocalInterface instanceof IStreetViewPanoramaDelegate ? (IStreetViewPanoramaDelegate) queryLocalInterface : new zzbx(readStrongBinder);
        }
        zzJ.recycle();
        return zzbxVar;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void getStreetViewPanoramaAsync(zzbt zzbtVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzbtVar);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final boolean isReady() {
        Parcel zzJ = zzJ(11, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onCreate(Bundle bundle) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, bundle);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final IObjectWrapper onCreateView(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, Bundle bundle) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper2);
        com.google.android.gms.internal.maps.zzc.zzd(zza, bundle);
        Parcel zzJ = zzJ(4, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onDestroy() {
        zzc(8, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onDestroyView() {
        zzc(7, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onInflate(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions, Bundle bundle) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        com.google.android.gms.internal.maps.zzc.zzd(zza, streetViewPanoramaOptions);
        com.google.android.gms.internal.maps.zzc.zzd(zza, bundle);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onLowMemory() {
        zzc(9, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onPause() {
        zzc(6, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onResume() {
        zzc(5, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onSaveInstanceState(Bundle bundle) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, bundle);
        Parcel zzJ = zzJ(10, zza);
        if (zzJ.readInt() != 0) {
            bundle.readFromParcel(zzJ);
        }
        zzJ.recycle();
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onStart() {
        zzc(13, zza());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onStop() {
        zzc(14, zza());
    }
}
