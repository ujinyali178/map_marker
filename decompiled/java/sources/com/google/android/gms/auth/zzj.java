package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zzby;

/* loaded from: /root/release/classes.dex */
final class zzj implements zzk {
    final /* synthetic */ String zza;
    final /* synthetic */ Context zzb;

    zzj(String str, Context context) {
        this.zza = str;
        this.zzb = context;
    }

    @Override // com.google.android.gms.auth.zzk
    public final /* bridge */ /* synthetic */ Object zza(IBinder iBinder) {
        Bundle zzg = com.google.android.gms.internal.auth.zze.zzb(iBinder).zzg(this.zza);
        zzl.zzc(zzg);
        String string = zzg.getString("Error");
        Intent intent = (Intent) zzg.getParcelable("userRecoveryIntent");
        PendingIntent pendingIntent = (PendingIntent) zzg.getParcelable("userRecoveryPendingIntent");
        if (zzby.SUCCESS.equals(zzby.zza(string))) {
            return Boolean.TRUE;
        }
        zzl.zzn(this.zzb, "requestGoogleAccountsAccess", string, intent, pendingIntent);
        throw new GoogleAuthException("Invalid state. Shouldn't happen");
    }
}
