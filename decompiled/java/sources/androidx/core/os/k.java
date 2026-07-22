package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* loaded from: /root/release/classes.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    private static final k f748b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    private final m f749a;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Locale[] f750a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale locale2 : f750a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        static boolean c(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String a4 = androidx.core.text.a.a(locale);
            if (!a4.isEmpty()) {
                return a4.equals(androidx.core.text.a.a(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    static class b {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private k(m mVar) {
        this.f749a = mVar;
    }

    public static k a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? h(b.a(localeArr)) : new k(new l(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static k c(String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i3 = 0; i3 < length; i3++) {
            localeArr[i3] = a.a(split[i3]);
        }
        return a(localeArr);
    }

    public static k e() {
        return f748b;
    }

    public static k h(LocaleList localeList) {
        return new k(new n(localeList));
    }

    public Locale d(int i3) {
        return this.f749a.get(i3);
    }

    public boolean equals(Object obj) {
        return (obj instanceof k) && this.f749a.equals(((k) obj).f749a);
    }

    public boolean f() {
        return this.f749a.isEmpty();
    }

    public Object g() {
        return this.f749a.a();
    }

    public int hashCode() {
        return this.f749a.hashCode();
    }

    public String toString() {
        return this.f749a.toString();
    }
}
