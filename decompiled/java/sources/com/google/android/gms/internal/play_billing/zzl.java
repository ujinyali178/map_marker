package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: /root/release/classes.dex */
public abstract class zzl extends zzq implements zzm {
    public static zzm zzr(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
        return queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzk(iBinder);
    }
}
