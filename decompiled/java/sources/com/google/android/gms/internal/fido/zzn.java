package com.google.android.gms.internal.fido;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.fido.fido2.api.common.BrowserPublicKeyCredentialCreationOptions;
import com.google.android.gms.fido.fido2.api.common.BrowserPublicKeyCredentialRequestOptions;

/* loaded from: /root/release/classes.dex */
public final class zzn extends zza {
    zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fido.fido2.internal.privileged.IFido2PrivilegedService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzc(zzg zzgVar, String str) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeStrongBinder(zzgVar);
        zza.writeString(str);
        zzb(4, zza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzd(zzm zzmVar, BrowserPublicKeyCredentialCreationOptions browserPublicKeyCredentialCreationOptions) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeStrongBinder(zzmVar);
        zzc.zzd(zza, browserPublicKeyCredentialCreationOptions);
        zzb(1, zza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zze(zzm zzmVar, BrowserPublicKeyCredentialRequestOptions browserPublicKeyCredentialRequestOptions) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeStrongBinder(zzmVar);
        zzc.zzd(zza, browserPublicKeyCredentialRequestOptions);
        zzb(2, zza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzf(zze zzeVar) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeStrongBinder(zzeVar);
        zzb(3, zza);
    }
}
