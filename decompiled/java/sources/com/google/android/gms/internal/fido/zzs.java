package com.google.android.gms.internal.fido;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRequestOptions;

/* loaded from: /root/release/classes.dex */
public final class zzs extends zza {
    zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fido.fido2.internal.regular.IFido2AppService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzc(zzr zzrVar, PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeStrongBinder(zzrVar);
        zzc.zzd(zza, publicKeyCredentialCreationOptions);
        zzb(1, zza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzd(zzr zzrVar, PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeStrongBinder(zzrVar);
        zzc.zzd(zza, publicKeyCredentialRequestOptions);
        zzb(2, zza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zze(zze zzeVar) {
        Parcel zza = zza();
        int i3 = zzc.zza;
        zza.writeStrongBinder(zzeVar);
        zzb(3, zza);
    }
}
