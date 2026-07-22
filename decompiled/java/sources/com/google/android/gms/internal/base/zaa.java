package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public class zaa implements IInterface {
    private final IBinder zaa;
    private final String zab;

    protected zaa(IBinder iBinder, String str) {
        this.zaa = iBinder;
        this.zab = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zaa;
    }

    protected final Parcel zaa() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zab);
        return obtain;
    }

    protected final Parcel zab(int i3, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.zaa.transact(2, parcel, obtain, 0);
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

    protected final void zac(int i3, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.zaa.transact(i3, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    protected final void zad(int i3, Parcel parcel) {
        try {
            this.zaa.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
