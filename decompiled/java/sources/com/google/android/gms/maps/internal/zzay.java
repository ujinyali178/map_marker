package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzay extends com.google.android.gms.internal.maps.zzb implements zzaz {
    public zzay() {
        super("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        boolean zzb = zzb();
        parcel2.writeNoException();
        int i5 = com.google.android.gms.internal.maps.zzc.zza;
        parcel2.writeInt(zzb ? 1 : 0);
        return true;
    }
}
