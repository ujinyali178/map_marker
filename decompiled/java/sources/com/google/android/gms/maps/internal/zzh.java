package com.google.android.gms.maps.internal;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: /root/release/classes.dex */
public abstract class zzh extends com.google.android.gms.internal.maps.zzb implements zzi {
    public zzh() {
        super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        IObjectWrapper zzc;
        if (i3 == 1) {
            com.google.android.gms.internal.maps.zzad zzb = com.google.android.gms.internal.maps.zzac.zzb(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzc = zzc(zzb);
        } else {
            if (i3 != 2) {
                return false;
            }
            com.google.android.gms.internal.maps.zzad zzb2 = com.google.android.gms.internal.maps.zzac.zzb(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzc = zzb(zzb2);
        }
        parcel2.writeNoException();
        com.google.android.gms.internal.maps.zzc.zze(parcel2, zzc);
        return true;
    }
}
