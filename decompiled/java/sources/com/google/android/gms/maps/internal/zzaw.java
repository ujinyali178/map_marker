package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzaw extends com.google.android.gms.internal.maps.zzb implements zzax {
    public zzaw() {
        super("com.google.android.gms.maps.internal.IOnMarkerDragListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            com.google.android.gms.internal.maps.zzad zzb = com.google.android.gms.internal.maps.zzac.zzb(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzd(zzb);
        } else if (i3 == 2) {
            com.google.android.gms.internal.maps.zzad zzb2 = com.google.android.gms.internal.maps.zzac.zzb(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzb(zzb2);
        } else {
            if (i3 != 3) {
                return false;
            }
            com.google.android.gms.internal.maps.zzad zzb3 = com.google.android.gms.internal.maps.zzac.zzb(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzc(zzb3);
        }
        parcel2.writeNoException();
        return true;
    }
}
