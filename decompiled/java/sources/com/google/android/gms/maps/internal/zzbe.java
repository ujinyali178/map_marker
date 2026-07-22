package com.google.android.gms.maps.internal;

import android.os.Parcel;
import com.google.android.gms.maps.model.PointOfInterest;

/* loaded from: /root/release/classes.dex */
public abstract class zzbe extends com.google.android.gms.internal.maps.zzb implements zzbf {
    public zzbe() {
        super("com.google.android.gms.maps.internal.IOnPoiClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        PointOfInterest pointOfInterest = (PointOfInterest) com.google.android.gms.internal.maps.zzc.zza(parcel, PointOfInterest.CREATOR);
        com.google.android.gms.internal.maps.zzc.zzc(parcel);
        zzb(pointOfInterest);
        parcel2.writeNoException();
        return true;
    }
}
