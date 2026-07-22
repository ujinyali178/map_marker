package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

/* loaded from: /root/release/classes.dex */
public final class zzbh extends zza {
    zzbh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.internal.IAuthService");
    }

    public final void zzd(zzbg zzbgVar) {
        Parcel zza = zza();
        zzc.zzd(zza, zzbgVar);
        zzc(3, zza);
    }

    public final void zze(zzbg zzbgVar, ProxyRequest proxyRequest) {
        Parcel zza = zza();
        zzc.zzd(zza, zzbgVar);
        zzc.zzc(zza, proxyRequest);
        zzc(1, zza);
    }
}
