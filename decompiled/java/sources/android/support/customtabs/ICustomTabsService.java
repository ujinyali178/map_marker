package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.customtabs.ICustomTabsCallback;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public interface ICustomTabsService extends IInterface {
    public static final String DESCRIPTOR = "android.support.customtabs.ICustomTabsService";

    public static class Default implements ICustomTabsService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(String str, Bundle bundle) {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSessionWithExtras(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            return 0;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean receiveFile(ICustomTabsCallback iCustomTabsCallback, Uri uri, int i3, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i3, Uri uri, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean warmup(long j3) {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICustomTabsService {
        static final int TRANSACTION_extraCommand = 5;
        static final int TRANSACTION_mayLaunchUrl = 4;
        static final int TRANSACTION_newSession = 3;
        static final int TRANSACTION_newSessionWithExtras = 10;
        static final int TRANSACTION_postMessage = 8;
        static final int TRANSACTION_receiveFile = 12;
        static final int TRANSACTION_requestPostMessageChannel = 7;
        static final int TRANSACTION_requestPostMessageChannelWithExtras = 11;
        static final int TRANSACTION_updateVisuals = 6;
        static final int TRANSACTION_validateRelationship = 9;
        static final int TRANSACTION_warmup = 2;

        private static class Proxy implements ICustomTabsService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.customtabs.ICustomTabsService
            public Bundle extraCommand(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ICustomTabsService.DESCRIPTOR;
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    obtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.writeTypedObject(obtain, uri, 0);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    obtain.writeTypedList(list);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    obtain.writeStrongInterface(iCustomTabsCallback);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean newSessionWithExtras(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    obtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    obtain.writeStrongInterface(iCustomTabsCallback);
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean receiveFile(ICustomTabsCallback iCustomTabsCallback, Uri uri, int i3, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    obtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.writeTypedObject(obtain, uri, 0);
                    obtain.writeInt(i3);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    obtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.writeTypedObject(obtain, uri, 0);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    obtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.writeTypedObject(obtain, uri, 0);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    obtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i3, Uri uri, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    obtain.writeStrongInterface(iCustomTabsCallback);
                    obtain.writeInt(i3);
                    _Parcel.writeTypedObject(obtain, uri, 0);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean warmup(long j3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    obtain.writeLong(j3);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ICustomTabsService.DESCRIPTOR);
        }

        public static ICustomTabsService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ICustomTabsService.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ICustomTabsService)) ? new Proxy(iBinder) : (ICustomTabsService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            int i5;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(ICustomTabsService.DESCRIPTOR);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(ICustomTabsService.DESCRIPTOR);
                return true;
            }
            switch (i3) {
                case 2:
                    i5 = warmup(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(i5);
                    return true;
                case 3:
                    i5 = newSession(ICustomTabsCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(i5);
                    return true;
                case 4:
                    ICustomTabsCallback asInterface = ICustomTabsCallback.Stub.asInterface(parcel.readStrongBinder());
                    Uri uri = (Uri) _Parcel.readTypedObject(parcel, Uri.CREATOR);
                    Parcelable.Creator creator = Bundle.CREATOR;
                    i5 = mayLaunchUrl(asInterface, uri, (Bundle) _Parcel.readTypedObject(parcel, creator), parcel.createTypedArrayList(creator));
                    parcel2.writeNoException();
                    parcel2.writeInt(i5);
                    return true;
                case 5:
                    Bundle extraCommand = extraCommand(parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, extraCommand, 1);
                    return true;
                case 6:
                    i5 = updateVisuals(ICustomTabsCallback.Stub.asInterface(parcel.readStrongBinder()), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(i5);
                    return true;
                case 7:
                    i5 = requestPostMessageChannel(ICustomTabsCallback.Stub.asInterface(parcel.readStrongBinder()), (Uri) _Parcel.readTypedObject(parcel, Uri.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(i5);
                    return true;
                case 8:
                    i5 = postMessage(ICustomTabsCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(i5);
                    return true;
                case 9:
                    i5 = validateRelationship(ICustomTabsCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Uri) _Parcel.readTypedObject(parcel, Uri.CREATOR), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(i5);
                    return true;
                case 10:
                    i5 = newSessionWithExtras(ICustomTabsCallback.Stub.asInterface(parcel.readStrongBinder()), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(i5);
                    return true;
                case 11:
                    i5 = requestPostMessageChannelWithExtras(ICustomTabsCallback.Stub.asInterface(parcel.readStrongBinder()), (Uri) _Parcel.readTypedObject(parcel, Uri.CREATOR), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(i5);
                    return true;
                case 12:
                    i5 = receiveFile(ICustomTabsCallback.Stub.asInterface(parcel.readStrongBinder()), (Uri) _Parcel.readTypedObject(parcel, Uri.CREATOR), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(i5);
                    return true;
                default:
                    return super.onTransact(i3, parcel, parcel2, i4);
            }
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

    Bundle extraCommand(String str, Bundle bundle);

    boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list);

    boolean newSession(ICustomTabsCallback iCustomTabsCallback);

    boolean newSessionWithExtras(ICustomTabsCallback iCustomTabsCallback, Bundle bundle);

    int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle);

    boolean receiveFile(ICustomTabsCallback iCustomTabsCallback, Uri uri, int i3, Bundle bundle);

    boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri);

    boolean requestPostMessageChannelWithExtras(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle);

    boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle);

    boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i3, Uri uri, Bundle bundle);

    boolean warmup(long j3);
}
