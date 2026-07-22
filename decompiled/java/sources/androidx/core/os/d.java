package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;

/* loaded from: /root/release/classes.dex */
public final class d {

    static class a {
        static IBinder a(Bundle bundle, String str) {
            return bundle.getBinder(str);
        }

        static void b(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }
    }

    public static void a(Bundle bundle, String str, IBinder iBinder) {
        a.b(bundle, str, iBinder);
    }
}
