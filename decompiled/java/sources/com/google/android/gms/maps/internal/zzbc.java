package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzbc extends com.google.android.gms.internal.maps.zzb implements zzbd {
    public zzbc() {
        super("com.google.android.gms.maps.internal.IOnMyLocationClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        Location location = (Location) com.google.android.gms.internal.maps.zzc.zza(parcel, Location.CREATOR);
        com.google.android.gms.internal.maps.zzc.zzc(parcel);
        zzb(location);
        parcel2.writeNoException();
        return true;
    }
}
