package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzg extends zzq implements zzh {
    public zzg() {
        super("com.android.vending.billing.IInAppBillingGetBillingConfigCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.zzq
    protected final boolean zzb(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        Bundle bundle = (Bundle) zzr.zza(parcel, Bundle.CREATOR);
        zzr.zzb(parcel);
        zza(bundle);
        parcel2.writeNoException();
        return true;
    }
}
