package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public final class zzc extends com.google.android.gms.internal.auth.zza implements zze {
    zzc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zzd(zzb zzbVar, String str) {
        Parcel zza = zza();
        com.google.android.gms.internal.auth.zzc.zzd(zza, zzbVar);
        zza.writeString(str);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zze(zzb zzbVar, Account account) {
        Parcel zza = zza();
        com.google.android.gms.internal.auth.zzc.zzd(zza, zzbVar);
        com.google.android.gms.internal.auth.zzc.zzc(zza, account);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zzf(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.auth.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(1, zza);
    }
}
