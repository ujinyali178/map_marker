package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f758a;

    /* renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    static class C0016a {
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    static class b {
        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f758a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e3) {
                throw new IllegalStateException(e3);
            }
        }
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.c(b.a(b.b(locale)));
        }
        try {
            return C0016a.a((Locale) f758a.invoke(null, locale));
        } catch (IllegalAccessException | InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
            return C0016a.a(locale);
        }
    }
}
