package c0;

import android.util.Log;
import c0.g;
import c0.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private f f1599a;

    /* renamed from: b, reason: collision with root package name */
    private u f1600b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1601c = false;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1602a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1603b;

        static {
            int[] iArr = new int[j.values().length];
            f1603b = iArr;
            try {
                iArr[j.first_child.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1603b[j.last_child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1603b[j.only_child.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1603b[j.first_of_type.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1603b[j.last_of_type.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1603b[j.only_of_type.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1603b[j.root.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1603b[j.empty.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1603b[j.nth_child.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1603b[j.nth_last_child.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1603b[j.nth_of_type.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1603b[j.nth_last_of_type.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1603b[j.not.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1603b[j.target.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1603b[j.lang.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1603b[j.link.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f1603b[j.visited.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f1603b[j.hover.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f1603b[j.active.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f1603b[j.focus.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f1603b[j.enabled.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f1603b[j.disabled.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f1603b[j.checked.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f1603b[j.indeterminate.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr2 = new int[c.values().length];
            f1602a = iArr2;
            try {
                iArr2[c.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f1602a[c.INCLUDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f1602a[c.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* renamed from: c0.b$b, reason: collision with other inner class name */
    private static class C0042b {

        /* renamed from: a, reason: collision with root package name */
        public final String f1604a;

        /* renamed from: b, reason: collision with root package name */
        final c f1605b;

        /* renamed from: c, reason: collision with root package name */
        public final String f1606c;

        C0042b(String str, c cVar, String str2) {
            this.f1604a = str;
            this.f1605b = cVar;
            this.f1606c = str2;
        }
    }

    private enum c {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    private static class d extends k.i {

        private static class a {

            /* renamed from: a, reason: collision with root package name */
            public int f1612a;

            /* renamed from: b, reason: collision with root package name */
            public int f1613b;

            a(int i3, int i4) {
                this.f1612a = i3;
                this.f1613b = i4;
            }
        }

        d(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        private int C(int i3) {
            if (i3 >= 48 && i3 <= 57) {
                return i3 - 48;
            }
            int i4 = 65;
            if (i3 < 65 || i3 > 70) {
                i4 = 97;
                if (i3 < 97 || i3 > 102) {
                    return -1;
                }
            }
            return (i3 - i4) + 10;
        }

        private a D() {
            c0.c cVar;
            a aVar;
            if (h()) {
                return null;
            }
            int i3 = this.f2065b;
            if (!f('(')) {
                return null;
            }
            A();
            int i4 = 1;
            if (g("odd")) {
                aVar = new a(2, 1);
            } else {
                if (g("even")) {
                    aVar = new a(2, 0);
                } else {
                    int i5 = (!f('+') && f('-')) ? -1 : 1;
                    c0.c c3 = c0.c.c(this.f2064a, this.f2065b, this.f2066c, false);
                    if (c3 != null) {
                        this.f2065b = c3.a();
                    }
                    if (f('n') || f('N')) {
                        if (c3 == null) {
                            c3 = new c0.c(1L, this.f2065b);
                        }
                        A();
                        boolean f3 = f('+');
                        if (!f3 && (f3 = f('-'))) {
                            i4 = -1;
                        }
                        if (f3) {
                            A();
                            cVar = c0.c.c(this.f2064a, this.f2065b, this.f2066c, false);
                            if (cVar == null) {
                                this.f2065b = i3;
                                return null;
                            }
                            this.f2065b = cVar.a();
                        } else {
                            cVar = null;
                        }
                        int i6 = i4;
                        i4 = i5;
                        i5 = i6;
                    } else {
                        cVar = c3;
                        c3 = null;
                    }
                    aVar = new a(c3 == null ? 0 : i4 * c3.d(), cVar != null ? i5 * cVar.d() : 0);
                }
            }
            A();
            if (f(')')) {
                return aVar;
            }
            this.f2065b = i3;
            return null;
        }

        private String E() {
            if (h()) {
                return null;
            }
            String q3 = q();
            return q3 != null ? q3 : H();
        }

        private List<String> G() {
            if (h()) {
                return null;
            }
            int i3 = this.f2065b;
            if (!f('(')) {
                return null;
            }
            A();
            ArrayList arrayList = null;
            do {
                String H = H();
                if (H == null) {
                    this.f2065b = i3;
                    return null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(H);
                A();
            } while (z());
            if (f(')')) {
                return arrayList;
            }
            this.f2065b = i3;
            return null;
        }

        private List<s> K() {
            List<t> list;
            List<g> list2;
            if (h()) {
                return null;
            }
            int i3 = this.f2065b;
            if (!f('(')) {
                return null;
            }
            A();
            List<s> L = L();
            if (L == null) {
                this.f2065b = i3;
                return null;
            }
            if (!f(')')) {
                this.f2065b = i3;
                return null;
            }
            Iterator<s> it = L.iterator();
            while (it.hasNext() && (list = it.next().f1667a) != null) {
                Iterator<t> it2 = list.iterator();
                while (it2.hasNext() && (list2 = it2.next().f1672d) != null) {
                    Iterator<g> it3 = list2.iterator();
                    while (it3.hasNext()) {
                        if (it3.next() instanceof k) {
                            return null;
                        }
                    }
                }
            }
            return L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<s> L() {
            a aVar = null;
            if (h()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            s sVar = new s(aVar);
            while (!h() && M(sVar)) {
                if (z()) {
                    arrayList.add(sVar);
                    sVar = new s(aVar);
                }
            }
            if (!sVar.f()) {
                arrayList.add(sVar);
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void O(s sVar, t tVar) {
            g hVar;
            h hVar2;
            String H = H();
            if (H == null) {
                throw new c0.a("Invalid pseudo class");
            }
            j a4 = j.a(H);
            a aVar = null;
            switch (a.f1603b[a4.ordinal()]) {
                case 1:
                    hVar = new h(0, 1, true, false, null);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 2:
                    hVar = new h(0, 1, false, false, null);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 3:
                    hVar = new m(false, null);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 4:
                    hVar = new h(0, 1, true, true, tVar.f1670b);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 5:
                    hVar = new h(0, 1, false, true, tVar.f1670b);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 6:
                    hVar = new m(true, tVar.f1670b);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 7:
                    hVar = new n(aVar);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 8:
                    hVar = new i(aVar);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 9:
                case 10:
                case 11:
                case 12:
                    boolean z3 = a4 == j.nth_child || a4 == j.nth_of_type;
                    boolean z4 = a4 == j.nth_of_type || a4 == j.nth_last_of_type;
                    a D = D();
                    if (D == null) {
                        throw new c0.a("Invalid or missing parameter section for pseudo class: " + H);
                    }
                    h hVar3 = new h(D.f1612a, D.f1613b, z3, z4, tVar.f1670b);
                    sVar.b();
                    hVar2 = hVar3;
                    hVar = hVar2;
                    tVar.b(hVar);
                    return;
                case 13:
                    List<s> K = K();
                    if (K == null) {
                        throw new c0.a("Invalid or missing parameter section for pseudo class: " + H);
                    }
                    k kVar = new k(K);
                    sVar.f1668b = kVar.b();
                    hVar2 = kVar;
                    hVar = hVar2;
                    tVar.b(hVar);
                    return;
                case 14:
                    hVar = new o(aVar);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 15:
                    G();
                    hVar = new l(H);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    hVar = new l(H);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                default:
                    throw new c0.a("Unsupported pseudo class: " + H);
            }
        }

        private int P() {
            int i3;
            if (h()) {
                return this.f2065b;
            }
            int i4 = this.f2065b;
            int charAt = this.f2064a.charAt(i4);
            if (charAt == 45) {
                charAt = a();
            }
            if ((charAt < 65 || charAt > 90) && ((charAt < 97 || charAt > 122) && charAt != 95)) {
                i3 = i4;
            } else {
                while (true) {
                    int a4 = a();
                    if (a4 < 65 || a4 > 90) {
                        if (a4 < 97 || a4 > 122) {
                            if (a4 < 48 || a4 > 57) {
                                if (a4 != 45 && a4 != 95) {
                                    break;
                                }
                            }
                        }
                    }
                }
                i3 = this.f2065b;
            }
            this.f2065b = i4;
            return i3;
        }

        String F() {
            int C;
            if (h()) {
                return null;
            }
            char charAt = this.f2064a.charAt(this.f2065b);
            if (charAt != '\'' && charAt != '\"') {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.f2065b++;
            loop0: while (true) {
                int intValue = l().intValue();
                while (intValue != -1 && intValue != charAt) {
                    if (intValue == 92) {
                        intValue = l().intValue();
                        if (intValue != -1) {
                            if (intValue != 10 && intValue != 13 && intValue != 12) {
                                int C2 = C(intValue);
                                if (C2 != -1) {
                                    for (int i3 = 1; i3 <= 5 && (C = C((intValue = l().intValue()))) != -1; i3++) {
                                        C2 = (C2 * 16) + C;
                                    }
                                    sb.append((char) C2);
                                }
                            }
                        }
                    }
                    sb.append((char) intValue);
                }
            }
            return sb.toString();
        }

        String H() {
            int P = P();
            int i3 = this.f2065b;
            if (P == i3) {
                return null;
            }
            String substring = this.f2064a.substring(i3, P);
            this.f2065b = P;
            return substring;
        }

        String I() {
            char charAt;
            char c3;
            int C;
            StringBuilder sb = new StringBuilder();
            while (!h() && (charAt = this.f2064a.charAt(this.f2065b)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !k(charAt) && !Character.isISOControl((int) charAt)) {
                this.f2065b++;
                if (charAt == '\\') {
                    if (!h()) {
                        String str = this.f2064a;
                        int i3 = this.f2065b;
                        this.f2065b = i3 + 1;
                        charAt = str.charAt(i3);
                        if (charAt != '\n' && charAt != '\r' && charAt != '\f') {
                            int C2 = C(charAt);
                            if (C2 != -1) {
                                for (int i4 = 1; i4 <= 5 && !h() && (C = C(this.f2064a.charAt(this.f2065b))) != -1; i4++) {
                                    this.f2065b++;
                                    C2 = (C2 * 16) + C;
                                }
                                c3 = (char) C2;
                                sb.append(c3);
                            }
                        }
                    }
                }
                c3 = charAt;
                sb.append(c3);
            }
            if (sb.length() == 0) {
                return null;
            }
            return sb.toString();
        }

        String J() {
            if (h()) {
                return null;
            }
            int i3 = this.f2065b;
            int charAt = this.f2064a.charAt(i3);
            int i4 = i3;
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !j(charAt)) {
                if (!k(charAt)) {
                    i4 = this.f2065b + 1;
                }
                charAt = a();
            }
            if (this.f2065b > i3) {
                return this.f2064a.substring(i3, i4);
            }
            this.f2065b = i3;
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0039  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        boolean M(c0.b.s r11) {
            /*
                Method dump skipped, instructions count: 304
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: c0.b.d.M(c0.b$s):boolean");
        }

        String N() {
            if (h()) {
                return null;
            }
            int i3 = this.f2065b;
            if (!g("url(")) {
                return null;
            }
            A();
            String F = F();
            if (F == null) {
                F = I();
            }
            if (F == null) {
                this.f2065b = i3;
                return null;
            }
            A();
            if (h() || g(")")) {
                return F;
            }
            this.f2065b = i3;
            return null;
        }
    }

    private enum e {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    enum f {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    private interface g {
        boolean a(q qVar, g.l0 l0Var);
    }

    private static class h implements g {

        /* renamed from: a, reason: collision with root package name */
        private int f1630a;

        /* renamed from: b, reason: collision with root package name */
        private int f1631b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f1632c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1633d;

        /* renamed from: e, reason: collision with root package name */
        private String f1634e;

        h(int i3, int i4, boolean z3, boolean z4, String str) {
            this.f1630a = i3;
            this.f1631b = i4;
            this.f1632c = z3;
            this.f1633d = z4;
            this.f1634e = str;
        }

        @Override // c0.b.g
        public boolean a(q qVar, g.l0 l0Var) {
            int i3;
            int i4;
            String n3 = (this.f1633d && this.f1634e == null) ? l0Var.n() : this.f1634e;
            g.j0 j0Var = l0Var.f1864b;
            if (j0Var != null) {
                Iterator<g.n0> it = j0Var.a().iterator();
                i3 = 0;
                i4 = 0;
                while (it.hasNext()) {
                    g.l0 l0Var2 = (g.l0) it.next();
                    if (l0Var2 == l0Var) {
                        i3 = i4;
                    }
                    if (n3 == null || l0Var2.n().equals(n3)) {
                        i4++;
                    }
                }
            } else {
                i3 = 0;
                i4 = 1;
            }
            int i5 = this.f1632c ? i3 + 1 : i4 - i3;
            int i6 = this.f1630a;
            if (i6 == 0) {
                return i5 == this.f1631b;
            }
            int i7 = this.f1631b;
            if ((i5 - i7) % i6 == 0) {
                return Integer.signum(i5 - i7) == 0 || Integer.signum(i5 - this.f1631b) == Integer.signum(this.f1630a);
            }
            return false;
        }

        public String toString() {
            String str = this.f1632c ? "" : "last-";
            return this.f1633d ? String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.f1630a), Integer.valueOf(this.f1631b), this.f1634e) : String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.f1630a), Integer.valueOf(this.f1631b));
        }
    }

    private static class i implements g {
        private i() {
        }

        /* synthetic */ i(a aVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c0.b.g
        public boolean a(q qVar, g.l0 l0Var) {
            return !(l0Var instanceof g.j0) || ((g.j0) l0Var).a().size() == 0;
        }

        public String toString() {
            return "empty";
        }
    }

    private enum j {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;

        private static final Map<String, j> C = new HashMap();

        static {
            for (j jVar : values()) {
                if (jVar != UNSUPPORTED) {
                    C.put(jVar.name().replace('_', '-'), jVar);
                }
            }
        }

        public static j a(String str) {
            j jVar = C.get(str);
            return jVar != null ? jVar : UNSUPPORTED;
        }
    }

    private static class k implements g {

        /* renamed from: a, reason: collision with root package name */
        private List<s> f1658a;

        k(List<s> list) {
            this.f1658a = list;
        }

        @Override // c0.b.g
        public boolean a(q qVar, g.l0 l0Var) {
            Iterator<s> it = this.f1658a.iterator();
            while (it.hasNext()) {
                if (b.l(qVar, it.next(), l0Var)) {
                    return false;
                }
            }
            return true;
        }

        int b() {
            Iterator<s> it = this.f1658a.iterator();
            int i3 = Integer.MIN_VALUE;
            while (it.hasNext()) {
                int i4 = it.next().f1668b;
                if (i4 > i3) {
                    i3 = i4;
                }
            }
            return i3;
        }

        public String toString() {
            return "not(" + this.f1658a + ")";
        }
    }

    private static class l implements g {

        /* renamed from: a, reason: collision with root package name */
        private String f1659a;

        l(String str) {
            this.f1659a = str;
        }

        @Override // c0.b.g
        public boolean a(q qVar, g.l0 l0Var) {
            return false;
        }

        public String toString() {
            return this.f1659a;
        }
    }

    private static class m implements g {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1660a;

        /* renamed from: b, reason: collision with root package name */
        private String f1661b;

        public m(boolean z3, String str) {
            this.f1660a = z3;
            this.f1661b = str;
        }

        @Override // c0.b.g
        public boolean a(q qVar, g.l0 l0Var) {
            int i3;
            String n3 = (this.f1660a && this.f1661b == null) ? l0Var.n() : this.f1661b;
            g.j0 j0Var = l0Var.f1864b;
            if (j0Var != null) {
                Iterator<g.n0> it = j0Var.a().iterator();
                i3 = 0;
                while (it.hasNext()) {
                    g.l0 l0Var2 = (g.l0) it.next();
                    if (n3 == null || l0Var2.n().equals(n3)) {
                        i3++;
                    }
                }
            } else {
                i3 = 1;
            }
            return i3 == 1;
        }

        public String toString() {
            return this.f1660a ? String.format("only-of-type <%s>", this.f1661b) : String.format("only-child", new Object[0]);
        }
    }

    private static class n implements g {
        private n() {
        }

        /* synthetic */ n(a aVar) {
            this();
        }

        @Override // c0.b.g
        public boolean a(q qVar, g.l0 l0Var) {
            return l0Var.f1864b == null;
        }

        public String toString() {
            return "root";
        }
    }

    private static class o implements g {
        private o() {
        }

        /* synthetic */ o(a aVar) {
            this();
        }

        @Override // c0.b.g
        public boolean a(q qVar, g.l0 l0Var) {
            return qVar != null && l0Var == qVar.f1665a;
        }

        public String toString() {
            return "target";
        }
    }

    static class p {

        /* renamed from: a, reason: collision with root package name */
        s f1662a;

        /* renamed from: b, reason: collision with root package name */
        g.e0 f1663b;

        /* renamed from: c, reason: collision with root package name */
        u f1664c;

        p(s sVar, g.e0 e0Var, u uVar) {
            this.f1662a = sVar;
            this.f1663b = e0Var;
            this.f1664c = uVar;
        }

        public String toString() {
            return String.valueOf(this.f1662a) + " {...} (src=" + this.f1664c + ")";
        }
    }

    static class q {

        /* renamed from: a, reason: collision with root package name */
        g.l0 f1665a;

        q() {
        }

        public String toString() {
            g.l0 l0Var = this.f1665a;
            return l0Var != null ? String.format("<%s id=\"%s\">", l0Var.n(), this.f1665a.f1853c) : "";
        }
    }

    static class r {

        /* renamed from: a, reason: collision with root package name */
        private List<p> f1666a = null;

        r() {
        }

        void a(p pVar) {
            if (this.f1666a == null) {
                this.f1666a = new ArrayList();
            }
            for (int i3 = 0; i3 < this.f1666a.size(); i3++) {
                if (this.f1666a.get(i3).f1662a.f1668b > pVar.f1662a.f1668b) {
                    this.f1666a.add(i3, pVar);
                    return;
                }
            }
            this.f1666a.add(pVar);
        }

        void b(r rVar) {
            if (rVar.f1666a == null) {
                return;
            }
            if (this.f1666a == null) {
                this.f1666a = new ArrayList(rVar.f1666a.size());
            }
            Iterator<p> it = rVar.f1666a.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }

        List<p> c() {
            return this.f1666a;
        }

        boolean d() {
            List<p> list = this.f1666a;
            return list == null || list.isEmpty();
        }

        void e(u uVar) {
            List<p> list = this.f1666a;
            if (list == null) {
                return;
            }
            Iterator<p> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().f1664c == uVar) {
                    it.remove();
                }
            }
        }

        int f() {
            List<p> list = this.f1666a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public String toString() {
            if (this.f1666a == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<p> it = this.f1666a.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class s {

        /* renamed from: a, reason: collision with root package name */
        List<t> f1667a;

        /* renamed from: b, reason: collision with root package name */
        int f1668b;

        private s() {
            this.f1667a = null;
            this.f1668b = 0;
        }

        /* synthetic */ s(a aVar) {
            this();
        }

        void a(t tVar) {
            if (this.f1667a == null) {
                this.f1667a = new ArrayList();
            }
            this.f1667a.add(tVar);
        }

        void b() {
            this.f1668b += 1000;
        }

        void c() {
            this.f1668b++;
        }

        void d() {
            this.f1668b += 1000000;
        }

        t e(int i3) {
            return this.f1667a.get(i3);
        }

        boolean f() {
            List<t> list = this.f1667a;
            return list == null || list.isEmpty();
        }

        int g() {
            List<t> list = this.f1667a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<t> it = this.f1667a.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(' ');
            }
            sb.append('[');
            sb.append(this.f1668b);
            sb.append(']');
            return sb.toString();
        }
    }

    private static class t {

        /* renamed from: a, reason: collision with root package name */
        e f1669a;

        /* renamed from: b, reason: collision with root package name */
        String f1670b;

        /* renamed from: c, reason: collision with root package name */
        List<C0042b> f1671c = null;

        /* renamed from: d, reason: collision with root package name */
        List<g> f1672d = null;

        t(e eVar, String str) {
            this.f1669a = null;
            this.f1670b = null;
            this.f1669a = eVar == null ? e.DESCENDANT : eVar;
            this.f1670b = str;
        }

        void a(String str, c cVar, String str2) {
            if (this.f1671c == null) {
                this.f1671c = new ArrayList();
            }
            this.f1671c.add(new C0042b(str, cVar, str2));
        }

        void b(g gVar) {
            if (this.f1672d == null) {
                this.f1672d = new ArrayList();
            }
            this.f1672d.add(gVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                r5 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                c0.b$e r1 = r5.f1669a
                c0.b$e r2 = c0.b.e.CHILD
                if (r1 != r2) goto L11
                java.lang.String r1 = "> "
            Ld:
                r0.append(r1)
                goto L18
            L11:
                c0.b$e r2 = c0.b.e.FOLLOWS
                if (r1 != r2) goto L18
                java.lang.String r1 = "+ "
                goto Ld
            L18:
                java.lang.String r1 = r5.f1670b
                if (r1 != 0) goto L1e
                java.lang.String r1 = "*"
            L1e:
                r0.append(r1)
                java.util.List<c0.b$b> r1 = r5.f1671c
                if (r1 == 0) goto L6c
                java.util.Iterator r1 = r1.iterator()
            L29:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L6c
                java.lang.Object r2 = r1.next()
                c0.b$b r2 = (c0.b.C0042b) r2
                r3 = 91
                r0.append(r3)
                java.lang.String r3 = r2.f1604a
                r0.append(r3)
                int[] r3 = c0.b.a.f1602a
                c0.b$c r4 = r2.f1605b
                int r4 = r4.ordinal()
                r3 = r3[r4]
                r4 = 1
                if (r3 == r4) goto L5c
                r4 = 2
                if (r3 == r4) goto L56
                r4 = 3
                if (r3 == r4) goto L53
                goto L66
            L53:
                java.lang.String r3 = "|="
                goto L58
            L56:
                java.lang.String r3 = "~="
            L58:
                r0.append(r3)
                goto L61
            L5c:
                r3 = 61
                r0.append(r3)
            L61:
                java.lang.String r2 = r2.f1606c
                r0.append(r2)
            L66:
                r2 = 93
                r0.append(r2)
                goto L29
            L6c:
                java.util.List<c0.b$g> r1 = r5.f1672d
                if (r1 == 0) goto L89
                java.util.Iterator r1 = r1.iterator()
            L74:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L89
                java.lang.Object r2 = r1.next()
                c0.b$g r2 = (c0.b.g) r2
                r3 = 58
                r0.append(r3)
                r0.append(r2)
                goto L74
            L89:
                java.lang.String r0 = r0.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: c0.b.t.toString():java.lang.String");
        }
    }

    enum u {
        Document,
        RenderOptions
    }

    b(f fVar, u uVar) {
        this.f1599a = fVar;
        this.f1600b = uVar;
    }

    private static int a(List<g.j0> list, int i3, g.l0 l0Var) {
        int i4 = 0;
        if (i3 < 0) {
            return 0;
        }
        g.j0 j0Var = list.get(i3);
        g.j0 j0Var2 = l0Var.f1864b;
        if (j0Var != j0Var2) {
            return -1;
        }
        Iterator<g.n0> it = j0Var2.a().iterator();
        while (it.hasNext()) {
            if (it.next() == l0Var) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    static boolean b(String str, f fVar) {
        d dVar = new d(str);
        dVar.A();
        return c(h(dVar), fVar);
    }

    private static boolean c(List<f> list, f fVar) {
        for (f fVar2 : list) {
            if (fVar2 == f.all || fVar2 == fVar) {
                return true;
            }
        }
        return false;
    }

    private void e(r rVar, d dVar) {
        String H = dVar.H();
        dVar.A();
        if (H == null) {
            throw new c0.a("Invalid '@' rule");
        }
        if (!this.f1601c && H.equals("media")) {
            List<f> h3 = h(dVar);
            if (!dVar.f('{')) {
                throw new c0.a("Invalid @media rule: missing rule set");
            }
            dVar.A();
            if (c(h3, this.f1599a)) {
                this.f1601c = true;
                rVar.b(j(dVar));
                this.f1601c = false;
            } else {
                j(dVar);
            }
            if (!dVar.h() && !dVar.f('}')) {
                throw new c0.a("Invalid @media rule: expected '}' at end of rule set");
            }
        } else if (this.f1601c || !H.equals("import")) {
            p("Ignoring @%s rule", H);
            o(dVar);
        } else {
            String N = dVar.N();
            if (N == null) {
                N = dVar.F();
            }
            if (N == null) {
                throw new c0.a("Invalid @import rule: expected string or url()");
            }
            dVar.A();
            h(dVar);
            if (!dVar.h() && !dVar.f(';')) {
                throw new c0.a("Invalid @media rule: expected '}' at end of rule set");
            }
            c0.g.g();
        }
        dVar.A();
    }

    public static List<String> f(String str) {
        d dVar = new d(str);
        ArrayList arrayList = null;
        while (!dVar.h()) {
            String r3 = dVar.r();
            if (r3 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(r3);
                dVar.A();
            }
        }
        return arrayList;
    }

    private g.e0 g(d dVar) {
        g.e0 e0Var = new g.e0();
        do {
            String H = dVar.H();
            dVar.A();
            if (!dVar.f(':')) {
                throw new c0.a("Expected ':'");
            }
            dVar.A();
            String J = dVar.J();
            if (J == null) {
                throw new c0.a("Expected property value");
            }
            dVar.A();
            if (dVar.f('!')) {
                dVar.A();
                if (!dVar.g("important")) {
                    throw new c0.a("Malformed rule set: found unexpected '!'");
                }
                dVar.A();
            }
            dVar.f(';');
            c0.k.S0(e0Var, H, J);
            dVar.A();
            if (dVar.h()) {
                break;
            }
        } while (!dVar.f('}'));
        return e0Var;
    }

    private static List<f> h(d dVar) {
        String w3;
        ArrayList arrayList = new ArrayList();
        while (!dVar.h() && (w3 = dVar.w()) != null) {
            try {
                arrayList.add(f.valueOf(w3));
            } catch (IllegalArgumentException unused) {
            }
            if (!dVar.z()) {
                break;
            }
        }
        return arrayList;
    }

    private boolean i(r rVar, d dVar) {
        List L = dVar.L();
        if (L == null || L.isEmpty()) {
            return false;
        }
        if (!dVar.f('{')) {
            throw new c0.a("Malformed rule block: expected '{'");
        }
        dVar.A();
        g.e0 g3 = g(dVar);
        dVar.A();
        Iterator it = L.iterator();
        while (it.hasNext()) {
            rVar.a(new p((s) it.next(), g3, this.f1600b));
        }
        return true;
    }

    private r j(d dVar) {
        r rVar = new r();
        while (!dVar.h()) {
            try {
                if (!dVar.g("<!--") && !dVar.g("-->")) {
                    if (!dVar.f('@')) {
                        if (!i(rVar, dVar)) {
                            break;
                        }
                    } else {
                        e(rVar, dVar);
                    }
                }
            } catch (c0.a e3) {
                Log.e("CSSParser", "CSS parser terminated early due to error: " + e3.getMessage());
            }
        }
        return rVar;
    }

    private static boolean k(q qVar, s sVar, int i3, List<g.j0> list, int i4, g.l0 l0Var) {
        t e3 = sVar.e(i3);
        if (!n(qVar, e3, list, i4, l0Var)) {
            return false;
        }
        e eVar = e3.f1669a;
        if (eVar == e.DESCENDANT) {
            if (i3 == 0) {
                return true;
            }
            while (i4 >= 0) {
                if (m(qVar, sVar, i3 - 1, list, i4)) {
                    return true;
                }
                i4--;
            }
            return false;
        }
        if (eVar == e.CHILD) {
            return m(qVar, sVar, i3 - 1, list, i4);
        }
        int a4 = a(list, i4, l0Var);
        if (a4 <= 0) {
            return false;
        }
        return k(qVar, sVar, i3 - 1, list, i4, (g.l0) l0Var.f1864b.a().get(a4 - 1));
    }

    static boolean l(q qVar, s sVar, g.l0 l0Var) {
        ArrayList arrayList = new ArrayList();
        for (Object obj = l0Var.f1864b; obj != null; obj = ((g.n0) obj).f1864b) {
            arrayList.add(0, obj);
        }
        int size = arrayList.size() - 1;
        return sVar.g() == 1 ? n(qVar, sVar.e(0), arrayList, size, l0Var) : k(qVar, sVar, sVar.g() - 1, arrayList, size, l0Var);
    }

    private static boolean m(q qVar, s sVar, int i3, List<g.j0> list, int i4) {
        t e3 = sVar.e(i3);
        g.l0 l0Var = (g.l0) list.get(i4);
        if (!n(qVar, e3, list, i4, l0Var)) {
            return false;
        }
        e eVar = e3.f1669a;
        if (eVar == e.DESCENDANT) {
            if (i3 == 0) {
                return true;
            }
            while (i4 > 0) {
                i4--;
                if (m(qVar, sVar, i3 - 1, list, i4)) {
                    return true;
                }
            }
            return false;
        }
        if (eVar == e.CHILD) {
            return m(qVar, sVar, i3 - 1, list, i4 - 1);
        }
        int a4 = a(list, i4, l0Var);
        if (a4 <= 0) {
            return false;
        }
        return k(qVar, sVar, i3 - 1, list, i4, (g.l0) l0Var.f1864b.a().get(a4 - 1));
    }

    private static boolean n(q qVar, t tVar, List<g.j0> list, int i3, g.l0 l0Var) {
        List<String> list2;
        String str = tVar.f1670b;
        if (str != null && !str.equals(l0Var.n().toLowerCase(Locale.US))) {
            return false;
        }
        List<C0042b> list3 = tVar.f1671c;
        if (list3 != null) {
            for (C0042b c0042b : list3) {
                String str2 = c0042b.f1604a;
                str2.hashCode();
                if (str2.equals("id")) {
                    if (!c0042b.f1606c.equals(l0Var.f1853c)) {
                        return false;
                    }
                } else if (!str2.equals("class") || (list2 = l0Var.f1857g) == null || !list2.contains(c0042b.f1606c)) {
                    return false;
                }
            }
        }
        List<g> list4 = tVar.f1672d;
        if (list4 == null) {
            return true;
        }
        Iterator<g> it = list4.iterator();
        while (it.hasNext()) {
            if (!it.next().a(qVar, l0Var)) {
                return false;
            }
        }
        return true;
    }

    private void o(d dVar) {
        int i3 = 0;
        while (!dVar.h()) {
            int intValue = dVar.l().intValue();
            if (intValue == 59 && i3 == 0) {
                return;
            }
            if (intValue == 123) {
                i3++;
            } else if (intValue == 125 && i3 > 0 && i3 - 1 == 0) {
                return;
            }
        }
    }

    private static void p(String str, Object... objArr) {
        Log.w("CSSParser", String.format(str, objArr));
    }

    r d(String str) {
        d dVar = new d(str);
        dVar.A();
        return j(dVar);
    }
}
