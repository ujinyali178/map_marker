package com.google.android.gms.internal.fido;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: /root/release/classes.dex */
public abstract class zzl extends zzb implements zzm {
    public zzl() {
        super("com.google.android.gms.fido.fido2.internal.privileged.IFido2PrivilegedCallbacks");
    }

    @Override // com.google.android.gms.internal.fido.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        PendingIntent pendingIntent = (PendingIntent) zzc.zza(parcel, PendingIntent.CREATOR);
        zzc.zzc(parcel);
        zzb(status, pendingIntent);
        return true;
    }
}
