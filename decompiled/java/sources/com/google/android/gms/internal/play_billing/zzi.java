package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zzi extends zzq implements zzj {
    public zzi() {
        super("com.android.vending.billing.IInAppBillingIsAlternativeBillingOnlyAvailableCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.zzq
    protected final boolean zzb(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        Bundle bundle = (Bundle) zzr.zza(parcel, Bundle.CREATOR);
        zzr.zzb(parcel);
        zza(bundle);
        return true;
    }
}
