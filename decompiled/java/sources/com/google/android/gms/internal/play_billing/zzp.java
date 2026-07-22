package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public class zzp implements IInterface {
    private final IBinder zza;
    private final String zzb = "com.android.vending.billing.IInAppBillingService";

    protected zzp(IBinder iBinder, String str) {
        this.zza = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }

    protected final Parcel zzr() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        return obtain;
    }

    protected final Parcel zzs(int i3, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.zza.transact(i3, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e3) {
                obtain.recycle();
                throw e3;
            }
        } finally {
            parcel.recycle();
        }
    }

    protected final void zzt(int i3, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(i3, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    protected final void zzu(int i3, Parcel parcel) {
        try {
            this.zza.transact(i3, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
