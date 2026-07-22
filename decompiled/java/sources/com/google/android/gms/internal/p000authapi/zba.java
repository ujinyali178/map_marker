package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public class zba implements IInterface {
    private final IBinder zba;
    private final String zbb;

    protected zba(IBinder iBinder, String str) {
        this.zba = iBinder;
        this.zbb = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zba;
    }

    protected final Parcel zba() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zbb);
        return obtain;
    }

    protected final void zbb(int i3, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.zba.transact(i3, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
