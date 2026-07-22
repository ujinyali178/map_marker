package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzaa extends com.google.android.gms.internal.maps.zzb implements zzab {
    public zzaa() {
        super("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            zzb();
        } else {
            if (i3 != 2) {
                return false;
            }
            com.google.android.gms.internal.maps.zzu zzb = com.google.android.gms.internal.maps.zzt.zzb(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzc(zzb);
        }
        parcel2.writeNoException();
        return true;
    }
}
