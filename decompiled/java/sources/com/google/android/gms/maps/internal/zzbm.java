package com.google.android.gms.maps.internal;

import android.os.Parcel;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

/* loaded from: /root/release/classes.dex */
public abstract class zzbm extends com.google.android.gms.internal.maps.zzb implements zzbn {
    public zzbm() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) com.google.android.gms.internal.maps.zzc.zza(parcel, StreetViewPanoramaLocation.CREATOR);
        com.google.android.gms.internal.maps.zzc.zzc(parcel);
        zzb(streetViewPanoramaLocation);
        parcel2.writeNoException();
        return true;
    }
}
