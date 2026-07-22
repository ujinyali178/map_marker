package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

/* loaded from: /root/release/classes.dex */
public final class zzbx extends com.google.android.gms.internal.maps.zza implements IStreetViewPanoramaDelegate {
    zzbx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j3) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, streetViewPanoramaCamera);
        zza.writeLong(j3);
        zzc(9, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void enablePanning(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void enableStreetNames(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void enableUserNavigation(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void enableZoom(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final StreetViewPanoramaCamera getPanoramaCamera() {
        Parcel zzJ = zzJ(10, zza());
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) com.google.android.gms.internal.maps.zzc.zza(zzJ, StreetViewPanoramaCamera.CREATOR);
        zzJ.recycle();
        return streetViewPanoramaCamera;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final StreetViewPanoramaLocation getStreetViewPanoramaLocation() {
        Parcel zzJ = zzJ(14, zza());
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) com.google.android.gms.internal.maps.zzc.zza(zzJ, StreetViewPanoramaLocation.CREATOR);
        zzJ.recycle();
        return streetViewPanoramaLocation;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final boolean isPanningGesturesEnabled() {
        Parcel zzJ = zzJ(6, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final boolean isStreetNamesEnabled() {
        Parcel zzJ = zzJ(8, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final boolean isUserNavigationEnabled() {
        Parcel zzJ = zzJ(7, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final boolean isZoomGesturesEnabled() {
        Parcel zzJ = zzJ(5, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final IObjectWrapper orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, streetViewPanoramaOrientation);
        Parcel zzJ = zzJ(19, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final StreetViewPanoramaOrientation pointToOrientation(IObjectWrapper iObjectWrapper) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        Parcel zzJ = zzJ(18, zza);
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) com.google.android.gms.internal.maps.zzc.zza(zzJ, StreetViewPanoramaOrientation.CREATOR);
        zzJ.recycle();
        return streetViewPanoramaOrientation;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setOnStreetViewPanoramaCameraChangeListener(zzbl zzblVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzblVar);
        zzc(16, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setOnStreetViewPanoramaChangeListener(zzbn zzbnVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzbnVar);
        zzc(15, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setOnStreetViewPanoramaClickListener(zzbp zzbpVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzbpVar);
        zzc(17, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setOnStreetViewPanoramaLongClickListener(zzbr zzbrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, zzbrVar);
        zzc(20, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setPosition(LatLng latLng) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, latLng);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setPositionWithID(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(11, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setPositionWithRadius(LatLng latLng, int i3) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, latLng);
        zza.writeInt(i3);
        zzc(13, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setPositionWithRadiusAndSource(LatLng latLng, int i3, StreetViewSource streetViewSource) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, latLng);
        zza.writeInt(i3);
        com.google.android.gms.internal.maps.zzc.zzd(zza, streetViewSource);
        zzc(22, zza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setPositionWithSource(LatLng latLng, StreetViewSource streetViewSource) {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zzd(zza, latLng);
        com.google.android.gms.internal.maps.zzc.zzd(zza, streetViewSource);
        zzc(21, zza);
    }
}
