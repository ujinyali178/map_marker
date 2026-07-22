package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzj extends com.google.android.gms.internal.maps.zzb implements ILocationSourceDelegate {
    public zzj() {
        super("com.google.android.gms.maps.internal.ILocationSourceDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        zzaj zzaiVar;
        if (i3 == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzaiVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                zzaiVar = queryLocalInterface instanceof zzaj ? (zzaj) queryLocalInterface : new zzai(readStrongBinder);
            }
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            activate(zzaiVar);
        } else {
            if (i3 != 2) {
                return false;
            }
            deactivate();
        }
        parcel2.writeNoException();
        return true;
    }
}
