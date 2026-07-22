package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzao extends com.google.android.gms.internal.maps.zzb implements zzap {
    public zzao() {
        super("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
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
