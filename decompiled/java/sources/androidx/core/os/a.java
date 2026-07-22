package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f735a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final int f736b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f737c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f738d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f739e;

    /* renamed from: androidx.core.os.a$a, reason: collision with other inner class name */
    private static final class C0015a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0015a f740a = new C0015a();

        private C0015a() {
        }

        public final int a(int i3) {
            return SdkExtensions.getExtensionVersion(i3);
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        f736b = i3 >= 30 ? C0015a.f740a.a(30) : 0;
        f737c = i3 >= 30 ? C0015a.f740a.a(31) : 0;
        f738d = i3 >= 30 ? C0015a.f740a.a(33) : 0;
        f739e = i3 >= 30 ? C0015a.f740a.a(1000000) : 0;
    }

    private a() {
    }

    public static final boolean a(String codename, String buildCodename) {
        kotlin.jvm.internal.k.e(codename, "codename");
        kotlin.jvm.internal.k.e(buildCodename, "buildCodename");
        if (kotlin.jvm.internal.k.a("REL", buildCodename)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = buildCodename.toUpperCase(locale);
        kotlin.jvm.internal.k.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = codename.toUpperCase(locale);
        kotlin.jvm.internal.k.d(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    public static final boolean b() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 33) {
            if (i3 >= 32) {
                String CODENAME = Build.VERSION.CODENAME;
                kotlin.jvm.internal.k.d(CODENAME, "CODENAME");
                if (a("Tiramisu", CODENAME)) {
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean c() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 34) {
            if (i3 >= 33) {
                String CODENAME = Build.VERSION.CODENAME;
                kotlin.jvm.internal.k.d(CODENAME, "CODENAME");
                if (a("UpsideDownCake", CODENAME)) {
                }
            }
            return false;
        }
        return true;
    }
}
