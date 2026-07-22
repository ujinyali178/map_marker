package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: /root/release/classes.dex */
public abstract class zzbv extends com.google.android.gms.internal.maps.zzb implements zzbw {
    public zzbv() {
        super("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            Bitmap bitmap = (Bitmap) com.google.android.gms.internal.maps.zzc.zza(parcel, Bitmap.CREATOR);
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzb(bitmap);
        } else {
            if (i3 != 2) {
                return false;
            }
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzc(asInterface);
        }
        parcel2.writeNoException();
        return true;
    }
}
