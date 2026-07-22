package v2;

import h2.a0;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class m extends l {
    public static final boolean h(String str, String suffix, boolean z3) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(suffix, "suffix");
        return !z3 ? str.endsWith(suffix) : k(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean i(String str, String str2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return h(str, str2, z3);
    }

    public static boolean j(CharSequence charSequence) {
        boolean z3;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable t3 = n.t(charSequence);
            if (!(t3 instanceof Collection) || !((Collection) t3).isEmpty()) {
                Iterator it = t3.iterator();
                while (it.hasNext()) {
                    if (!a.c(charSequence.charAt(((a0) it).nextInt()))) {
                        z3 = false;
                        break;
                    }
                }
            }
            z3 = true;
            if (!z3) {
                return false;
            }
        }
        return true;
    }

    public static final boolean k(String str, int i3, String other, int i4, int i5, boolean z3) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        return !z3 ? str.regionMatches(i3, other, i4, i5) : str.regionMatches(z3, i3, other, i4, i5);
    }

    public static final String l(String str, String oldValue, String newValue, boolean z3) {
        int a4;
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(oldValue, "oldValue");
        kotlin.jvm.internal.k.e(newValue, "newValue");
        int i3 = 0;
        int w3 = n.w(str, oldValue, 0, z3);
        if (w3 < 0) {
            return str;
        }
        int length = oldValue.length();
        a4 = s2.f.a(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i3, w3);
            sb.append(newValue);
            i3 = w3 + length;
            if (w3 >= str.length()) {
                break;
            }
            w3 = n.w(str, oldValue, w3 + a4, z3);
        } while (w3 > 0);
        sb.append((CharSequence) str, i3, str.length());
        String sb2 = sb.toString();
        kotlin.jvm.internal.k.d(sb2, "stringBuilder.append(this, i, length).toString()");
        return sb2;
    }

    public static /* synthetic */ String m(String str, String str2, String str3, boolean z3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        return l(str, str2, str3, z3);
    }

    public static final boolean n(String str, String prefix, boolean z3) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        return !z3 ? str.startsWith(prefix) : k(str, 0, prefix, 0, prefix.length(), z3);
    }

    public static /* synthetic */ boolean o(String str, String str2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return n(str, str2, z3);
    }
}
