package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* loaded from: /root/release/classes.dex */
public final class zzp extends zza {
    zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.data.IGoogleAuthService");
    }

    public final void zzd(IStatusCallback iStatusCallback, zzbw zzbwVar) {
        Parcel zza = zza();
        zzc.zzd(zza, iStatusCallback);
        zzc.zzc(zza, zzbwVar);
        zzc(2, zza);
    }

    public final void zze(zzm zzmVar, AccountChangeEventsRequest accountChangeEventsRequest) {
        Parcel zza = zza();
        zzc.zzd(zza, zzmVar);
        zzc.zzc(zza, accountChangeEventsRequest);
        zzc(4, zza);
    }

    public final void zzf(zzo zzoVar, Account account, String str, Bundle bundle) {
        Parcel zza = zza();
        zzc.zzd(zza, zzoVar);
        zzc.zzc(zza, account);
        zza.writeString(str);
        zzc.zzc(zza, bundle);
        zzc(1, zza);
    }

    public final void zzg(zzk zzkVar, Account account) {
        Parcel zza = zza();
        zzc.zzd(zza, zzkVar);
        zzc.zzc(zza, account);
        zzc(6, zza);
    }

    public final void zzh(zzk zzkVar, String str) {
        Parcel zza = zza();
        zzc.zzd(zza, zzkVar);
        zza.writeString(str);
        zzc(3, zza);
    }
}
