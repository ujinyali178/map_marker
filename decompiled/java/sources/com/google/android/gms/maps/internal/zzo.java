package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzo extends com.google.android.gms.internal.maps.zzb implements zzp {
    public zzo() {
        super("com.google.android.gms.maps.internal.IOnCameraIdleListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        zzb();
        parcel2.writeNoException();
        return true;
    }
}
