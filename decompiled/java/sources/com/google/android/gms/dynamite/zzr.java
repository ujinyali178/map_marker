package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: /root/release/classes.dex */
public final class zzr extends com.google.android.gms.internal.common.zza {
    zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, String str, int i3, IObjectWrapper iObjectWrapper2) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i3);
        com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper2);
        Parcel zzB = zzB(2, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
        zzB.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzf(IObjectWrapper iObjectWrapper, String str, int i3, IObjectWrapper iObjectWrapper2) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i3);
        com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper2);
        Parcel zzB = zzB(3, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
        zzB.recycle();
        return asInterface;
    }
}
