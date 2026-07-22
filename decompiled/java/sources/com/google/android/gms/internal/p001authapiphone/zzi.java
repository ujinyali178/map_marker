package com.google.android.gms.internal.p001authapiphone;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: /root/release/classes.dex */
public abstract class zzi extends zzb implements zzj {
    public zzi() {
        super("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverResultCallback");
    }

    @Override // com.google.android.gms.internal.p001authapiphone.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        zzc.zzb(parcel);
        zzb(status);
        return true;
    }
}
