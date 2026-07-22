package i;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import i.a;
import org.apache.commons.io.FilenameUtils;

/* loaded from: /root/release/classes.dex */
public interface b extends IInterface {

    /* renamed from: b, reason: collision with root package name */
    public static final String f2636b = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', FilenameUtils.EXTENSION_SEPARATOR);

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, b.f2636b);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = b.f2636b;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i3 != 1) {
                return super.onTransact(i3, parcel, parcel2, i4);
            }
            a(a.AbstractBinderC0078a.b(parcel.readStrongBinder()));
            return true;
        }
    }

    void a(i.a aVar);
}
