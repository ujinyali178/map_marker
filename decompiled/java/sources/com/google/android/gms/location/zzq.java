package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzq extends com.google.android.gms.internal.location.zzb implements zzr {
    public zzq() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzr zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof zzr ? (zzr) queryLocalInterface : new zzp(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            LocationResult locationResult = (LocationResult) com.google.android.gms.internal.location.zzc.zza(parcel, LocationResult.CREATOR);
            com.google.android.gms.internal.location.zzc.zzb(parcel);
            zze(locationResult);
        } else if (i3 == 2) {
            LocationAvailability locationAvailability = (LocationAvailability) com.google.android.gms.internal.location.zzc.zza(parcel, LocationAvailability.CREATOR);
            com.google.android.gms.internal.location.zzc.zzb(parcel);
            zzd(locationAvailability);
        } else {
            if (i3 != 3) {
                return false;
            }
            zzf();
        }
        return true;
    }
}
