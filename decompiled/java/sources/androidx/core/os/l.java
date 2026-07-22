package androidx.core.os;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: /root/release/classes.dex */
final class l implements m {

    /* renamed from: c, reason: collision with root package name */
    private static final Locale[] f751c = new Locale[0];

    /* renamed from: d, reason: collision with root package name */
    private static final Locale f752d = new Locale("en", "XA");

    /* renamed from: e, reason: collision with root package name */
    private static final Locale f753e = new Locale("ar", "XB");

    /* renamed from: f, reason: collision with root package name */
    private static final Locale f754f = k.b("en-Latn");

    /* renamed from: a, reason: collision with root package name */
    private final Locale[] f755a;

    /* renamed from: b, reason: collision with root package name */
    private final String f756b;

    l(Locale... localeArr) {
        String sb;
        if (localeArr.length == 0) {
            this.f755a = f751c;
            sb = "";
        } else {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            StringBuilder sb2 = new StringBuilder();
            for (int i3 = 0; i3 < localeArr.length; i3++) {
                Locale locale = localeArr[i3];
                if (locale == null) {
                    throw new NullPointerException("list[" + i3 + "] is null");
                }
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    b(sb2, locale2);
                    if (i3 < localeArr.length - 1) {
                        sb2.append(',');
                    }
                    hashSet.add(locale2);
                }
            }
            this.f755a = (Locale[]) arrayList.toArray(new Locale[0]);
            sb = sb2.toString();
        }
        this.f756b = sb;
    }

    static void b(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }

    @Override // androidx.core.os.m
    public Object a() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        Locale[] localeArr = ((l) obj).f755a;
        if (this.f755a.length != localeArr.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            Locale[] localeArr2 = this.f755a;
            if (i3 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i3].equals(localeArr[i3])) {
                return false;
            }
            i3++;
        }
    }

    @Override // androidx.core.os.m
    public Locale get(int i3) {
        if (i3 >= 0) {
            Locale[] localeArr = this.f755a;
            if (i3 < localeArr.length) {
                return localeArr[i3];
            }
        }
        return null;
    }

    public int hashCode() {
        int i3 = 1;
        for (Locale locale : this.f755a) {
            i3 = (i3 * 31) + locale.hashCode();
        }
        return i3;
    }

    @Override // androidx.core.os.m
    public boolean isEmpty() {
        return this.f755a.length == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i3 = 0;
        while (true) {
            Locale[] localeArr = this.f755a;
            if (i3 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i3]);
            if (i3 < this.f755a.length - 1) {
                sb.append(',');
            }
            i3++;
        }
    }
}
