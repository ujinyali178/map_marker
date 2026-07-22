package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;

/* loaded from: /root/release/classes.dex */
public final class p {

    static class a {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static LocaleList b(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }

    public static androidx.core.os.k a(Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return androidx.core.os.k.c(f.a(context));
        }
        Object b4 = b(context);
        return b4 != null ? androidx.core.os.k.h(a.a(b4)) : androidx.core.os.k.e();
    }

    private static Object b(Context context) {
        return context.getSystemService("locale");
    }
}
