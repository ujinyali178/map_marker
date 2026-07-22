package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzy extends com.google.android.gms.internal.maps.zzb implements zzz {
    public zzy() {
        super("com.google.android.gms.maps.internal.IOnGroundOverlayClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        com.google.android.gms.internal.maps.zzr zzb = com.google.android.gms.internal.maps.zzq.zzb(parcel.readStrongBinder());
        com.google.android.gms.internal.maps.zzc.zzc(parcel);
        zzb(zzb);
        parcel2.writeNoException();
        return true;
    }
}
