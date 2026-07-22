package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzc extends com.google.android.gms.internal.maps.zzb implements zzd {
    public zzc() {
        super("com.google.android.gms.maps.internal.ICancelableCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            zzc();
        } else {
            if (i3 != 2) {
                return false;
            }
            zzb();
        }
        parcel2.writeNoException();
        return true;
    }
}
