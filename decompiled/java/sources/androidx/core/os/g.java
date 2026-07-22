package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

/* loaded from: /root/release/classes.dex */
public final class g {

    static class a {
        static void a(Configuration configuration, k kVar) {
            if (kVar.f()) {
                return;
            }
            configuration.setLocale(kVar.d(0));
        }
    }

    static class b {
        static LocaleList a(Configuration configuration) {
            LocaleList locales;
            locales = configuration.getLocales();
            return locales;
        }

        static void b(Configuration configuration, k kVar) {
            configuration.setLocales((LocaleList) kVar.g());
        }
    }

    public static k a(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? k.h(b.a(configuration)) : k.a(configuration.locale);
    }

    public static void b(Configuration configuration, k kVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            b.b(configuration, kVar);
        } else {
            a.a(configuration, kVar);
        }
    }
}
