package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /root/release/classes.dex */
public interface ITrustedWebActivityCallback extends IInterface {
    public static final String DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityCallback";

    public static class Default implements ITrustedWebActivityCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityCallback
        public void onExtraCallback(String str, Bundle bundle) {
        }
    }

    public static abstract class Stub extends Binder implements ITrustedWebActivityCallback {
        static final int TRANSACTION_onExtraCallback = 2;

        private static class Proxy implements ITrustedWebActivityCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITrustedWebActivityCallback.DESCRIPTOR;
            }

            @Override // android.support.customtabs.trusted.ITrustedWebActivityCallback
            public void onExtraCallback(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITrustedWebActivityCallback.DESCRIPTOR);
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITrustedWebActivityCallback.DESCRIPTOR);
        }

        public static ITrustedWebActivityCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ITrustedWebActivityCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITrustedWebActivityCallback)) ? new Proxy(iBinder) : (ITrustedWebActivityCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(ITrustedWebActivityCallback.DESCRIPTOR);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(ITrustedWebActivityCallback.DESCRIPTOR);
                return true;
            }
            if (i3 != 2) {
                return super.onTransact(i3, parcel, parcel2, i4);
            }
            onExtraCallback(parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            return true;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t3, int i3) {
            if (t3 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t3.writeToParcel(parcel, i3);
            }
        }
    }

    void onExtraCallback(String str, Bundle bundle);
}
