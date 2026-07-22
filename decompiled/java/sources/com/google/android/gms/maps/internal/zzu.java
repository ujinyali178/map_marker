package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzu extends com.google.android.gms.internal.maps.zzb implements zzv {
    public zzu() {
        super("com.google.android.gms.maps.internal.IOnCameraMoveStartedListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        int readInt = parcel.readInt();
        com.google.android.gms.internal.maps.zzc.zzc(parcel);
        zzb(readInt);
        parcel2.writeNoException();
        return true;
    }
}
