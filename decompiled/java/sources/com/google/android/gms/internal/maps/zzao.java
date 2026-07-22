package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;

/* loaded from: /root/release/classes.dex */
public abstract class zzao extends zzb implements zzap {
    public zzao() {
        super("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    public static zzap zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        return queryLocalInterface instanceof zzap ? (zzap) queryLocalInterface : new zzan(iBinder);
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        zzc.zzc(parcel);
        Tile zzb = zzb(readInt, readInt2, readInt3);
        parcel2.writeNoException();
        if (zzb == null) {
            parcel2.writeInt(0);
        } else {
            parcel2.writeInt(1);
            zzb.writeToParcel(parcel2, 1);
        }
        return true;
    }
}
