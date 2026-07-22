package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzbs extends com.google.android.gms.internal.maps.zzb implements zzbt {
    public zzbs() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        IStreetViewPanoramaDelegate zzbxVar;
        if (i3 != 1) {
            return false;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzbxVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            zzbxVar = queryLocalInterface instanceof IStreetViewPanoramaDelegate ? (IStreetViewPanoramaDelegate) queryLocalInterface : new zzbx(readStrongBinder);
        }
        com.google.android.gms.internal.maps.zzc.zzc(parcel);
        zzb(zzbxVar);
        parcel2.writeNoException();
        return true;
    }
}
