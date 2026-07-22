package v2;

import h2.a0;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class n extends m {

    static final class a extends kotlin.jvm.internal.l implements p2.p<CharSequence, Integer, g2.j<? extends Integer, ? extends Integer>> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f4414c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f4415d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List<String> list, boolean z3) {
            super(2);
            this.f4414c = list;
            this.f4415d = z3;
        }

        public final g2.j<Integer, Integer> a(CharSequence $receiver, int i3) {
            kotlin.jvm.internal.k.e($receiver, "$this$$receiver");
            g2.j s3 = n.s($receiver, this.f4414c, i3, this.f4415d, false);
            if (s3 != null) {
                return g2.n.a(s3.c(), Integer.valueOf(((String) s3.d()).length()));
            }
            return null;
        }

        @Override // p2.p
        public /* bridge */ /* synthetic */ g2.j<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    static final class b extends kotlin.jvm.internal.l implements p2.l<s2.c, String> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CharSequence f4416c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CharSequence charSequence) {
            super(1);
            this.f4416c = charSequence;
        }

        @Override // p2.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(s2.c it) {
            kotlin.jvm.internal.k.e(it, "it");
            return n.P(this.f4416c, it);
        }
    }

    public static /* synthetic */ int A(CharSequence charSequence, String str, int i3, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return w(charSequence, str, i3, z3);
    }

    public static final int B(CharSequence charSequence, char[] chars, int i3, boolean z3) {
        int a4;
        boolean z4;
        char m3;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(chars, "chars");
        if (!z3 && chars.length == 1 && (charSequence instanceof String)) {
            m3 = h2.j.m(chars);
            return ((String) charSequence).indexOf(m3, i3);
        }
        a4 = s2.f.a(i3, 0);
        a0 it = new s2.c(a4, u(charSequence)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            char charAt = charSequence.charAt(nextInt);
            int length = chars.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    z4 = false;
                    break;
                }
                if (v2.b.d(chars[i4], charAt, z3)) {
                    z4 = true;
                    break;
                }
                i4++;
            }
            if (z4) {
                return nextInt;
            }
        }
        return -1;
    }

    public static final int C(CharSequence charSequence, char c3, int i3, boolean z3) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return (z3 || !(charSequence instanceof String)) ? G(charSequence, new char[]{c3}, i3, z3) : ((String) charSequence).lastIndexOf(c3, i3);
    }

    public static final int D(CharSequence charSequence, String string, int i3, boolean z3) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(string, "string");
        return (z3 || !(charSequence instanceof String)) ? x(charSequence, string, i3, 0, z3, true) : ((String) charSequence).lastIndexOf(string, i3);
    }

    public static /* synthetic */ int E(CharSequence charSequence, char c3, int i3, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = u(charSequence);
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return C(charSequence, c3, i3, z3);
    }

    public static /* synthetic */ int F(CharSequence charSequence, String str, int i3, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = u(charSequence);
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return D(charSequence, str, i3, z3);
    }

    public static final int G(CharSequence charSequence, char[] chars, int i3, boolean z3) {
        int c3;
        char m3;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(chars, "chars");
        if (!z3 && chars.length == 1 && (charSequence instanceof String)) {
            m3 = h2.j.m(chars);
            return ((String) charSequence).lastIndexOf(m3, i3);
        }
        for (c3 = s2.f.c(i3, u(charSequence)); -1 < c3; c3--) {
            char charAt = charSequence.charAt(c3);
            int length = chars.length;
            boolean z4 = false;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (v2.b.d(chars[i4], charAt, z3)) {
                    z4 = true;
                    break;
                }
                i4++;
            }
            if (z4) {
                return c3;
            }
        }
        return -1;
    }

    public static final u2.b<String> H(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return O(charSequence, new String[]{IOUtils.LINE_SEPARATOR_WINDOWS, IOUtils.LINE_SEPARATOR_UNIX, "\r"}, false, 0, 6, null);
    }

    public static final List<String> I(CharSequence charSequence) {
        List<String> e3;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        e3 = u2.h.e(H(charSequence));
        return e3;
    }

    private static final u2.b<s2.c> J(CharSequence charSequence, String[] strArr, int i3, boolean z3, int i4) {
        List b4;
        M(i4);
        b4 = h2.i.b(strArr);
        return new c(charSequence, i3, i4, new a(b4, z3));
    }

    static /* synthetic */ u2.b K(CharSequence charSequence, String[] strArr, int i3, boolean z3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return J(charSequence, strArr, i3, z3, i4);
    }

    public static final boolean L(CharSequence charSequence, int i3, CharSequence other, int i4, int i5, boolean z3) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        if (i4 < 0 || i3 < 0 || i3 > charSequence.length() - i5 || i4 > other.length() - i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!v2.b.d(charSequence.charAt(i3 + i6), other.charAt(i4 + i6), z3)) {
                return false;
            }
        }
        return true;
    }

    public static final void M(int i3) {
        if (i3 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3).toString());
    }

    public static final u2.b<String> N(CharSequence charSequence, String[] delimiters, boolean z3, int i3) {
        u2.b<String> c3;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(delimiters, "delimiters");
        c3 = u2.h.c(K(charSequence, delimiters, 0, z3, i3, 2, null), new b(charSequence));
        return c3;
    }

    public static /* synthetic */ u2.b O(CharSequence charSequence, String[] strArr, boolean z3, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        return N(charSequence, strArr, z3, i3);
    }

    public static final String P(CharSequence charSequence, s2.c range) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(range, "range");
        return charSequence.subSequence(range.h().intValue(), range.g().intValue() + 1).toString();
    }

    public static final String Q(String str, char c3, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int z3 = z(str, c3, 0, false, 6, null);
        if (z3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(z3 + 1, str.length());
        kotlin.jvm.internal.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String R(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(delimiter, "delimiter");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int A = A(str, delimiter, 0, false, 6, null);
        if (A == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(A + delimiter.length(), str.length());
        kotlin.jvm.internal.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String S(String str, char c3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        return Q(str, c3, str2);
    }

    public static /* synthetic */ String T(String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str3 = str;
        }
        return R(str, str2, str3);
    }

    public static final String U(String str, char c3, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int E = E(str, c3, 0, false, 6, null);
        if (E == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(E + 1, str.length());
        kotlin.jvm.internal.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String V(String str, char c3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        return U(str, c3, str2);
    }

    public static final String W(String str, char c3, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int z3 = z(str, c3, 0, false, 6, null);
        if (z3 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, z3);
        kotlin.jvm.internal.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String X(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(delimiter, "delimiter");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int A = A(str, delimiter, 0, false, 6, null);
        if (A == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, A);
        kotlin.jvm.internal.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String Y(String str, char c3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        return W(str, c3, str2);
    }

    public static /* synthetic */ String Z(String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str3 = str;
        }
        return X(str, str2, str3);
    }

    public static CharSequence a0(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length) {
            boolean c3 = v2.a.c(charSequence.charAt(!z3 ? i3 : length));
            if (z3) {
                if (!c3) {
                    break;
                }
                length--;
            } else if (c3) {
                i3++;
            } else {
                z3 = true;
            }
        }
        return charSequence.subSequence(i3, length + 1);
    }

    public static final boolean q(CharSequence charSequence, CharSequence other, boolean z3) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        if (other instanceof String) {
            if (A(charSequence, (String) other, 0, z3, 2, null) >= 0) {
                return true;
            }
        } else if (y(charSequence, other, 0, charSequence.length(), z3, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean r(CharSequence charSequence, CharSequence charSequence2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return q(charSequence, charSequence2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
    
        return g2.n.a(java.lang.Integer.valueOf(r12), r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final g2.j<java.lang.Integer, java.lang.String> s(java.lang.CharSequence r10, java.util.Collection<java.lang.String> r11, int r12, boolean r13, boolean r14) {
        /*
            r0 = 0
            if (r13 != 0) goto L2d
            int r1 = r11.size()
            r2 = 1
            if (r1 != r2) goto L2d
            java.lang.Object r11 = h2.l.t(r11)
            java.lang.String r11 = (java.lang.String) r11
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r10
            r2 = r11
            r3 = r12
            if (r14 != 0) goto L1d
            int r10 = v2.d.A(r1, r2, r3, r4, r5, r6)
            goto L21
        L1d:
            int r10 = v2.d.F(r1, r2, r3, r4, r5, r6)
        L21:
            if (r10 >= 0) goto L24
            goto L2c
        L24:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            g2.j r0 = g2.n.a(r10, r11)
        L2c:
            return r0
        L2d:
            r1 = 0
            if (r14 != 0) goto L3e
            s2.c r14 = new s2.c
            int r12 = s2.d.a(r12, r1)
            int r1 = r10.length()
            r14.<init>(r12, r1)
            goto L4a
        L3e:
            int r14 = u(r10)
            int r12 = s2.d.c(r12, r14)
            s2.a r14 = s2.d.f(r12, r1)
        L4a:
            boolean r12 = r10 instanceof java.lang.String
            if (r12 == 0) goto L96
            int r12 = r14.a()
            int r1 = r14.b()
            int r14 = r14.c()
            if (r14 <= 0) goto L5e
            if (r12 <= r1) goto L62
        L5e:
            if (r14 >= 0) goto Ld4
            if (r1 > r12) goto Ld4
        L62:
            java.util.Iterator r8 = r11.iterator()
        L66:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L84
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r2.length()
            r5 = r12
            r7 = r13
            boolean r2 = v2.m.k(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto L66
            goto L85
        L84:
            r9 = r0
        L85:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L92
        L89:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r12)
            g2.j r10 = g2.n.a(r10, r9)
            return r10
        L92:
            if (r12 == r1) goto Ld4
            int r12 = r12 + r14
            goto L62
        L96:
            int r12 = r14.a()
            int r1 = r14.b()
            int r14 = r14.c()
            if (r14 <= 0) goto La6
            if (r12 <= r1) goto Laa
        La6:
            if (r14 >= 0) goto Ld4
            if (r1 > r12) goto Ld4
        Laa:
            java.util.Iterator r8 = r11.iterator()
        Lae:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lca
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            int r6 = r2.length()
            r4 = r10
            r5 = r12
            r7 = r13
            boolean r2 = L(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto Lae
            goto Lcb
        Lca:
            r9 = r0
        Lcb:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto Ld0
            goto L89
        Ld0:
            if (r12 == r1) goto Ld4
            int r12 = r12 + r14
            goto Laa
        Ld4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.n.s(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):g2.j");
    }

    public static final s2.c t(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return new s2.c(0, charSequence.length() - 1);
    }

    public static final int u(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int v(CharSequence charSequence, char c3, int i3, boolean z3) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return (z3 || !(charSequence instanceof String)) ? B(charSequence, new char[]{c3}, i3, z3) : ((String) charSequence).indexOf(c3, i3);
    }

    public static final int w(CharSequence charSequence, String string, int i3, boolean z3) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(string, "string");
        return (z3 || !(charSequence instanceof String)) ? y(charSequence, string, i3, charSequence.length(), z3, false, 16, null) : ((String) charSequence).indexOf(string, i3);
    }

    private static final int x(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, boolean z3, boolean z4) {
        int c3;
        int a4;
        s2.a f3;
        int a5;
        int c4;
        if (z4) {
            c3 = s2.f.c(i3, u(charSequence));
            a4 = s2.f.a(i4, 0);
            f3 = s2.f.f(c3, a4);
        } else {
            a5 = s2.f.a(i3, 0);
            c4 = s2.f.c(i4, charSequence.length());
            f3 = new s2.c(a5, c4);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a6 = f3.a();
            int b4 = f3.b();
            int c5 = f3.c();
            if ((c5 <= 0 || a6 > b4) && (c5 >= 0 || b4 > a6)) {
                return -1;
            }
            while (!m.k((String) charSequence2, 0, (String) charSequence, a6, charSequence2.length(), z3)) {
                if (a6 == b4) {
                    return -1;
                }
                a6 += c5;
            }
            return a6;
        }
        int a7 = f3.a();
        int b5 = f3.b();
        int c6 = f3.c();
        if ((c6 <= 0 || a7 > b5) && (c6 >= 0 || b5 > a7)) {
            return -1;
        }
        while (!L(charSequence2, 0, charSequence, a7, charSequence2.length(), z3)) {
            if (a7 == b5) {
                return -1;
            }
            a7 += c6;
        }
        return a7;
    }

    static /* synthetic */ int y(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, boolean z3, boolean z4, int i5, Object obj) {
        return x(charSequence, charSequence2, i3, i4, z3, (i5 & 16) != 0 ? false : z4);
    }

    public static /* synthetic */ int z(CharSequence charSequence, char c3, int i3, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return v(charSequence, c3, i3, z3);
    }
}
