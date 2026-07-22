package i;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import org.apache.commons.io.FilenameUtils;

/* loaded from: /root/release/classes.dex */
public interface a extends IInterface {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2634a = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', FilenameUtils.EXTENSION_SEPARATOR);

    /* renamed from: i.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0078a extends Binder implements a {

        /* renamed from: i.a$a$a, reason: collision with other inner class name */
        private static class C0079a implements a {

            /* renamed from: c, reason: collision with root package name */
            private IBinder f2635c;

            C0079a(IBinder iBinder) {
                this.f2635c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2635c;
            }
        }

        public static a b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f2634a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0079a(iBinder) : (a) queryLocalInterface;
        }
    }
}
