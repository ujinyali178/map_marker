package com.google.android.gms.maps.internal;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: /root/release/classes.dex */
public abstract class zzba extends com.google.android.gms.internal.maps.zzb implements zzbb {
    public zzba() {
        super("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        com.google.android.gms.internal.maps.zzc.zzc(parcel);
        zzb(asInterface);
        parcel2.writeNoException();
        return true;
    }
}
