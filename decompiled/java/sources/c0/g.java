package c0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import c0.b;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.IOUtils;

/* loaded from: /root/release/classes.dex */
public class g {

    /* renamed from: g, reason: collision with root package name */
    private static boolean f1712g = true;

    /* renamed from: a, reason: collision with root package name */
    private f0 f1713a = null;

    /* renamed from: b, reason: collision with root package name */
    private String f1714b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f1715c = "";

    /* renamed from: d, reason: collision with root package name */
    private float f1716d = 96.0f;

    /* renamed from: e, reason: collision with root package name */
    private b.r f1717e = new b.r();

    /* renamed from: f, reason: collision with root package name */
    private Map<String, l0> f1718f = new HashMap();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1719a;

        static {
            int[] iArr = new int[d1.values().length];
            f1719a = iArr;
            try {
                iArr[d1.px.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1719a[d1.em.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1719a[d1.ex.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1719a[d1.in.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1719a[d1.cm.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1719a[d1.mm.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1719a[d1.pt.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1719a[d1.pc.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1719a[d1.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    static class a0 extends z {
        a0() {
        }

        @Override // c0.g.z, c0.g.n0
        String n() {
            return "polygon";
        }
    }

    static abstract class a1 extends y0 {

        /* renamed from: o, reason: collision with root package name */
        List<p> f1720o;

        /* renamed from: p, reason: collision with root package name */
        List<p> f1721p;

        /* renamed from: q, reason: collision with root package name */
        List<p> f1722q;

        /* renamed from: r, reason: collision with root package name */
        List<p> f1723r;

        a1() {
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        float f1724a;

        /* renamed from: b, reason: collision with root package name */
        float f1725b;

        /* renamed from: c, reason: collision with root package name */
        float f1726c;

        /* renamed from: d, reason: collision with root package name */
        float f1727d;

        b(float f3, float f4, float f5, float f6) {
            this.f1724a = f3;
            this.f1725b = f4;
            this.f1726c = f5;
            this.f1727d = f6;
        }

        b(b bVar) {
            this.f1724a = bVar.f1724a;
            this.f1725b = bVar.f1725b;
            this.f1726c = bVar.f1726c;
            this.f1727d = bVar.f1727d;
        }

        static b a(float f3, float f4, float f5, float f6) {
            return new b(f3, f4, f5 - f3, f6 - f4);
        }

        float b() {
            return this.f1724a + this.f1726c;
        }

        float c() {
            return this.f1725b + this.f1727d;
        }

        void d(b bVar) {
            float f3 = bVar.f1724a;
            if (f3 < this.f1724a) {
                this.f1724a = f3;
            }
            float f4 = bVar.f1725b;
            if (f4 < this.f1725b) {
                this.f1725b = f4;
            }
            if (bVar.b() > b()) {
                this.f1726c = bVar.b() - this.f1724a;
            }
            if (bVar.c() > c()) {
                this.f1727d = bVar.c() - this.f1725b;
            }
        }

        public String toString() {
            return "[" + this.f1724a + " " + this.f1725b + " " + this.f1726c + " " + this.f1727d + "]";
        }
    }

    static class b0 extends l {

        /* renamed from: o, reason: collision with root package name */
        p f1728o;

        /* renamed from: p, reason: collision with root package name */
        p f1729p;

        /* renamed from: q, reason: collision with root package name */
        p f1730q;

        /* renamed from: r, reason: collision with root package name */
        p f1731r;

        /* renamed from: s, reason: collision with root package name */
        p f1732s;

        /* renamed from: t, reason: collision with root package name */
        p f1733t;

        b0() {
        }

        @Override // c0.g.n0
        String n() {
            return "rect";
        }
    }

    interface b1 {
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        p f1734a;

        /* renamed from: b, reason: collision with root package name */
        p f1735b;

        /* renamed from: c, reason: collision with root package name */
        p f1736c;

        /* renamed from: d, reason: collision with root package name */
        p f1737d;

        c(p pVar, p pVar2, p pVar3, p pVar4) {
            this.f1734a = pVar;
            this.f1735b = pVar2;
            this.f1736c = pVar3;
            this.f1737d = pVar4;
        }
    }

    static class c0 extends l0 implements j0 {
        c0() {
        }

        @Override // c0.g.j0
        public List<n0> a() {
            return Collections.emptyList();
        }

        @Override // c0.g.j0
        public void i(n0 n0Var) {
        }

        @Override // c0.g.n0
        String n() {
            return "solidColor";
        }
    }

    static class c1 extends n0 implements x0 {

        /* renamed from: c, reason: collision with root package name */
        String f1738c;

        /* renamed from: d, reason: collision with root package name */
        private b1 f1739d;

        c1(String str) {
            this.f1738c = str;
        }

        @Override // c0.g.x0
        public b1 f() {
            return this.f1739d;
        }

        public String toString() {
            return "TextChild: '" + this.f1738c + "'";
        }
    }

    static class d extends l {

        /* renamed from: o, reason: collision with root package name */
        p f1740o;

        /* renamed from: p, reason: collision with root package name */
        p f1741p;

        /* renamed from: q, reason: collision with root package name */
        p f1742q;

        d() {
        }

        @Override // c0.g.n0
        String n() {
            return "circle";
        }
    }

    static class d0 extends l0 implements j0 {

        /* renamed from: h, reason: collision with root package name */
        Float f1743h;

        d0() {
        }

        @Override // c0.g.j0
        public List<n0> a() {
            return Collections.emptyList();
        }

        @Override // c0.g.j0
        public void i(n0 n0Var) {
        }

        @Override // c0.g.n0
        String n() {
            return "stop";
        }
    }

    enum d1 {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    static class e extends m implements t {

        /* renamed from: p, reason: collision with root package name */
        Boolean f1754p;

        e() {
        }

        @Override // c0.g.m, c0.g.n0
        String n() {
            return "clipPath";
        }
    }

    static class e0 implements Cloneable {
        String A;
        String B;
        String C;
        Boolean D;
        Boolean E;
        o0 F;
        Float G;
        String H;
        a I;
        String J;
        o0 K;
        Float L;
        o0 M;
        Float N;
        i O;
        e P;

        /* renamed from: c, reason: collision with root package name */
        long f1755c = 0;

        /* renamed from: d, reason: collision with root package name */
        o0 f1756d;

        /* renamed from: f, reason: collision with root package name */
        a f1757f;

        /* renamed from: g, reason: collision with root package name */
        Float f1758g;

        /* renamed from: h, reason: collision with root package name */
        o0 f1759h;

        /* renamed from: i, reason: collision with root package name */
        Float f1760i;

        /* renamed from: j, reason: collision with root package name */
        p f1761j;

        /* renamed from: k, reason: collision with root package name */
        c f1762k;

        /* renamed from: l, reason: collision with root package name */
        d f1763l;

        /* renamed from: m, reason: collision with root package name */
        Float f1764m;

        /* renamed from: n, reason: collision with root package name */
        p[] f1765n;

        /* renamed from: o, reason: collision with root package name */
        p f1766o;

        /* renamed from: p, reason: collision with root package name */
        Float f1767p;

        /* renamed from: q, reason: collision with root package name */
        f f1768q;

        /* renamed from: r, reason: collision with root package name */
        List<String> f1769r;

        /* renamed from: s, reason: collision with root package name */
        p f1770s;

        /* renamed from: t, reason: collision with root package name */
        Integer f1771t;

        /* renamed from: u, reason: collision with root package name */
        b f1772u;

        /* renamed from: v, reason: collision with root package name */
        EnumC0043g f1773v;

        /* renamed from: w, reason: collision with root package name */
        h f1774w;

        /* renamed from: x, reason: collision with root package name */
        f f1775x;

        /* renamed from: y, reason: collision with root package name */
        Boolean f1776y;

        /* renamed from: z, reason: collision with root package name */
        c f1777z;

        public enum a {
            NonZero,
            EvenOdd
        }

        public enum b {
            Normal,
            Italic,
            Oblique
        }

        public enum c {
            Butt,
            Round,
            Square
        }

        public enum d {
            Miter,
            Round,
            Bevel
        }

        public enum e {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        public enum f {
            Start,
            Middle,
            End
        }

        /* renamed from: c0.g$e0$g, reason: collision with other inner class name */
        public enum EnumC0043g {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        public enum h {
            LTR,
            RTL
        }

        public enum i {
            None,
            NonScalingStroke
        }

        e0() {
        }

        static e0 a() {
            e0 e0Var = new e0();
            e0Var.f1755c = -1L;
            f fVar = f.f1818d;
            e0Var.f1756d = fVar;
            a aVar = a.NonZero;
            e0Var.f1757f = aVar;
            Float valueOf = Float.valueOf(1.0f);
            e0Var.f1758g = valueOf;
            e0Var.f1759h = null;
            e0Var.f1760i = valueOf;
            e0Var.f1761j = new p(1.0f);
            e0Var.f1762k = c.Butt;
            e0Var.f1763l = d.Miter;
            e0Var.f1764m = Float.valueOf(4.0f);
            e0Var.f1765n = null;
            e0Var.f1766o = new p(BitmapDescriptorFactory.HUE_RED);
            e0Var.f1767p = valueOf;
            e0Var.f1768q = fVar;
            e0Var.f1769r = null;
            e0Var.f1770s = new p(12.0f, d1.pt);
            e0Var.f1771t = 400;
            e0Var.f1772u = b.Normal;
            e0Var.f1773v = EnumC0043g.None;
            e0Var.f1774w = h.LTR;
            e0Var.f1775x = f.Start;
            Boolean bool = Boolean.TRUE;
            e0Var.f1776y = bool;
            e0Var.f1777z = null;
            e0Var.A = null;
            e0Var.B = null;
            e0Var.C = null;
            e0Var.D = bool;
            e0Var.E = bool;
            e0Var.F = fVar;
            e0Var.G = valueOf;
            e0Var.H = null;
            e0Var.I = aVar;
            e0Var.J = null;
            e0Var.K = null;
            e0Var.L = valueOf;
            e0Var.M = null;
            e0Var.N = valueOf;
            e0Var.O = i.None;
            e0Var.P = e.auto;
            return e0Var;
        }

        void b(boolean z3) {
            Boolean bool = Boolean.TRUE;
            this.D = bool;
            if (!z3) {
                bool = Boolean.FALSE;
            }
            this.f1776y = bool;
            this.f1777z = null;
            this.H = null;
            this.f1767p = Float.valueOf(1.0f);
            this.F = f.f1818d;
            this.G = Float.valueOf(1.0f);
            this.J = null;
            this.K = null;
            this.L = Float.valueOf(1.0f);
            this.M = null;
            this.N = Float.valueOf(1.0f);
            this.O = i.None;
        }

        protected Object clone() {
            e0 e0Var = (e0) super.clone();
            p[] pVarArr = this.f1765n;
            if (pVarArr != null) {
                e0Var.f1765n = (p[]) pVarArr.clone();
            }
            return e0Var;
        }
    }

    static class e1 extends m {

        /* renamed from: p, reason: collision with root package name */
        String f1813p;

        /* renamed from: q, reason: collision with root package name */
        p f1814q;

        /* renamed from: r, reason: collision with root package name */
        p f1815r;

        /* renamed from: s, reason: collision with root package name */
        p f1816s;

        /* renamed from: t, reason: collision with root package name */
        p f1817t;

        e1() {
        }

        @Override // c0.g.m, c0.g.n0
        String n() {
            return "use";
        }
    }

    static class f extends o0 {

        /* renamed from: d, reason: collision with root package name */
        static final f f1818d = new f(-16777216);

        /* renamed from: f, reason: collision with root package name */
        static final f f1819f = new f(0);

        /* renamed from: c, reason: collision with root package name */
        int f1820c;

        f(int i3) {
            this.f1820c = i3;
        }

        public String toString() {
            return String.format("#%08x", Integer.valueOf(this.f1820c));
        }
    }

    static class f0 extends r0 {

        /* renamed from: q, reason: collision with root package name */
        p f1821q;

        /* renamed from: r, reason: collision with root package name */
        p f1822r;

        /* renamed from: s, reason: collision with root package name */
        p f1823s;

        /* renamed from: t, reason: collision with root package name */
        p f1824t;

        /* renamed from: u, reason: collision with root package name */
        public String f1825u;

        f0() {
        }

        @Override // c0.g.n0
        String n() {
            return "svg";
        }
    }

    static class f1 extends r0 implements t {
        f1() {
        }

        @Override // c0.g.n0
        String n() {
            return "view";
        }
    }

    /* renamed from: c0.g$g, reason: collision with other inner class name */
    static class C0044g extends o0 {

        /* renamed from: c, reason: collision with root package name */
        private static C0044g f1826c = new C0044g();

        private C0044g() {
        }

        static C0044g a() {
            return f1826c;
        }
    }

    interface g0 {
        Set<String> b();

        void c(Set<String> set);

        String d();

        void e(Set<String> set);

        void g(Set<String> set);

        Set<String> getRequiredFeatures();

        void h(String str);

        void k(Set<String> set);

        Set<String> l();

        Set<String> m();
    }

    static class h extends m implements t {
        h() {
        }

        @Override // c0.g.m, c0.g.n0
        String n() {
            return "defs";
        }
    }

    static abstract class h0 extends k0 implements j0, g0 {

        /* renamed from: i, reason: collision with root package name */
        List<n0> f1827i = new ArrayList();

        /* renamed from: j, reason: collision with root package name */
        Set<String> f1828j = null;

        /* renamed from: k, reason: collision with root package name */
        String f1829k = null;

        /* renamed from: l, reason: collision with root package name */
        Set<String> f1830l = null;

        /* renamed from: m, reason: collision with root package name */
        Set<String> f1831m = null;

        /* renamed from: n, reason: collision with root package name */
        Set<String> f1832n = null;

        h0() {
        }

        @Override // c0.g.j0
        public List<n0> a() {
            return this.f1827i;
        }

        @Override // c0.g.g0
        public Set<String> b() {
            return null;
        }

        @Override // c0.g.g0
        public void c(Set<String> set) {
            this.f1831m = set;
        }

        @Override // c0.g.g0
        public String d() {
            return this.f1829k;
        }

        @Override // c0.g.g0
        public void e(Set<String> set) {
            this.f1832n = set;
        }

        @Override // c0.g.g0
        public void g(Set<String> set) {
            this.f1828j = set;
        }

        @Override // c0.g.g0
        public Set<String> getRequiredFeatures() {
            return this.f1828j;
        }

        @Override // c0.g.g0
        public void h(String str) {
            this.f1829k = str;
        }

        @Override // c0.g.j0
        public void i(n0 n0Var) {
            this.f1827i.add(n0Var);
        }

        @Override // c0.g.g0
        public void k(Set<String> set) {
            this.f1830l = set;
        }

        @Override // c0.g.g0
        public Set<String> l() {
            return this.f1831m;
        }

        @Override // c0.g.g0
        public Set<String> m() {
            return this.f1832n;
        }
    }

    static class i extends l {

        /* renamed from: o, reason: collision with root package name */
        p f1833o;

        /* renamed from: p, reason: collision with root package name */
        p f1834p;

        /* renamed from: q, reason: collision with root package name */
        p f1835q;

        /* renamed from: r, reason: collision with root package name */
        p f1836r;

        i() {
        }

        @Override // c0.g.n0
        String n() {
            return "ellipse";
        }
    }

    static abstract class i0 extends k0 implements g0 {

        /* renamed from: i, reason: collision with root package name */
        Set<String> f1837i = null;

        /* renamed from: j, reason: collision with root package name */
        String f1838j = null;

        /* renamed from: k, reason: collision with root package name */
        Set<String> f1839k = null;

        /* renamed from: l, reason: collision with root package name */
        Set<String> f1840l = null;

        /* renamed from: m, reason: collision with root package name */
        Set<String> f1841m = null;

        i0() {
        }

        @Override // c0.g.g0
        public Set<String> b() {
            return this.f1839k;
        }

        @Override // c0.g.g0
        public void c(Set<String> set) {
            this.f1840l = set;
        }

        @Override // c0.g.g0
        public String d() {
            return this.f1838j;
        }

        @Override // c0.g.g0
        public void e(Set<String> set) {
            this.f1841m = set;
        }

        @Override // c0.g.g0
        public void g(Set<String> set) {
            this.f1837i = set;
        }

        @Override // c0.g.g0
        public Set<String> getRequiredFeatures() {
            return this.f1837i;
        }

        @Override // c0.g.g0
        public void h(String str) {
            this.f1838j = str;
        }

        @Override // c0.g.g0
        public void k(Set<String> set) {
            this.f1839k = set;
        }

        @Override // c0.g.g0
        public Set<String> l() {
            return this.f1840l;
        }

        @Override // c0.g.g0
        public Set<String> m() {
            return this.f1841m;
        }
    }

    static abstract class j extends l0 implements j0 {

        /* renamed from: h, reason: collision with root package name */
        List<n0> f1842h = new ArrayList();

        /* renamed from: i, reason: collision with root package name */
        Boolean f1843i;

        /* renamed from: j, reason: collision with root package name */
        Matrix f1844j;

        /* renamed from: k, reason: collision with root package name */
        k f1845k;

        /* renamed from: l, reason: collision with root package name */
        String f1846l;

        j() {
        }

        @Override // c0.g.j0
        public List<n0> a() {
            return this.f1842h;
        }

        @Override // c0.g.j0
        public void i(n0 n0Var) {
            if (n0Var instanceof d0) {
                this.f1842h.add(n0Var);
                return;
            }
            throw new c0.j("Gradient elements cannot contain " + n0Var + " elements.");
        }
    }

    interface j0 {
        List<n0> a();

        void i(n0 n0Var);
    }

    enum k {
        pad,
        reflect,
        repeat
    }

    static abstract class k0 extends l0 {

        /* renamed from: h, reason: collision with root package name */
        b f1851h = null;

        k0() {
        }
    }

    static abstract class l extends i0 implements n {

        /* renamed from: n, reason: collision with root package name */
        Matrix f1852n;

        l() {
        }

        @Override // c0.g.n
        public void j(Matrix matrix) {
            this.f1852n = matrix;
        }
    }

    static abstract class l0 extends n0 {

        /* renamed from: c, reason: collision with root package name */
        String f1853c = null;

        /* renamed from: d, reason: collision with root package name */
        Boolean f1854d = null;

        /* renamed from: e, reason: collision with root package name */
        e0 f1855e = null;

        /* renamed from: f, reason: collision with root package name */
        e0 f1856f = null;

        /* renamed from: g, reason: collision with root package name */
        List<String> f1857g = null;

        l0() {
        }

        public String toString() {
            return n();
        }
    }

    static class m extends h0 implements n {

        /* renamed from: o, reason: collision with root package name */
        Matrix f1858o;

        m() {
        }

        @Override // c0.g.n
        public void j(Matrix matrix) {
            this.f1858o = matrix;
        }

        @Override // c0.g.n0
        String n() {
            return "group";
        }
    }

    static class m0 extends j {

        /* renamed from: m, reason: collision with root package name */
        p f1859m;

        /* renamed from: n, reason: collision with root package name */
        p f1860n;

        /* renamed from: o, reason: collision with root package name */
        p f1861o;

        /* renamed from: p, reason: collision with root package name */
        p f1862p;

        m0() {
        }

        @Override // c0.g.n0
        String n() {
            return "linearGradient";
        }
    }

    interface n {
        void j(Matrix matrix);
    }

    static class n0 {

        /* renamed from: a, reason: collision with root package name */
        g f1863a;

        /* renamed from: b, reason: collision with root package name */
        j0 f1864b;

        n0() {
        }

        String n() {
            return "";
        }
    }

    static class o extends p0 implements n {

        /* renamed from: p, reason: collision with root package name */
        String f1865p;

        /* renamed from: q, reason: collision with root package name */
        p f1866q;

        /* renamed from: r, reason: collision with root package name */
        p f1867r;

        /* renamed from: s, reason: collision with root package name */
        p f1868s;

        /* renamed from: t, reason: collision with root package name */
        p f1869t;

        /* renamed from: u, reason: collision with root package name */
        Matrix f1870u;

        o() {
        }

        @Override // c0.g.n
        public void j(Matrix matrix) {
            this.f1870u = matrix;
        }

        @Override // c0.g.n0
        String n() {
            return "image";
        }
    }

    static abstract class o0 implements Cloneable {
        o0() {
        }
    }

    static class p implements Cloneable {

        /* renamed from: c, reason: collision with root package name */
        float f1871c;

        /* renamed from: d, reason: collision with root package name */
        d1 f1872d;

        p(float f3) {
            this.f1871c = f3;
            this.f1872d = d1.px;
        }

        p(float f3, d1 d1Var) {
            this.f1871c = f3;
            this.f1872d = d1Var;
        }

        float a() {
            return this.f1871c;
        }

        float b(float f3) {
            int i3 = a.f1719a[this.f1872d.ordinal()];
            if (i3 == 1) {
                return this.f1871c;
            }
            switch (i3) {
                case 4:
                    return this.f1871c * f3;
                case 5:
                    return (this.f1871c * f3) / 2.54f;
                case 6:
                    return (this.f1871c * f3) / 25.4f;
                case 7:
                    return (this.f1871c * f3) / 72.0f;
                case 8:
                    return (this.f1871c * f3) / 6.0f;
                default:
                    return this.f1871c;
            }
        }

        float c(c0.h hVar) {
            if (this.f1872d != d1.percent) {
                return e(hVar);
            }
            b S = hVar.S();
            if (S == null) {
                return this.f1871c;
            }
            float f3 = S.f1726c;
            if (f3 == S.f1727d) {
                return (this.f1871c * f3) / 100.0f;
            }
            return (this.f1871c * ((float) (Math.sqrt((f3 * f3) + (r7 * r7)) / 1.414213562373095d))) / 100.0f;
        }

        float d(c0.h hVar, float f3) {
            return this.f1872d == d1.percent ? (this.f1871c * f3) / 100.0f : e(hVar);
        }

        float e(c0.h hVar) {
            switch (a.f1719a[this.f1872d.ordinal()]) {
                case 9:
                    b S = hVar.S();
                    if (S != null) {
                        break;
                    } else {
                        break;
                    }
            }
            return this.f1871c;
        }

        float f(c0.h hVar) {
            if (this.f1872d != d1.percent) {
                return e(hVar);
            }
            b S = hVar.S();
            return S == null ? this.f1871c : (this.f1871c * S.f1727d) / 100.0f;
        }

        boolean g() {
            return this.f1871c < BitmapDescriptorFactory.HUE_RED;
        }

        boolean h() {
            return this.f1871c == BitmapDescriptorFactory.HUE_RED;
        }

        public String toString() {
            return String.valueOf(this.f1871c) + this.f1872d;
        }
    }

    static abstract class p0 extends h0 {

        /* renamed from: o, reason: collision with root package name */
        c0.e f1873o = null;

        p0() {
        }
    }

    static class q extends l {

        /* renamed from: o, reason: collision with root package name */
        p f1874o;

        /* renamed from: p, reason: collision with root package name */
        p f1875p;

        /* renamed from: q, reason: collision with root package name */
        p f1876q;

        /* renamed from: r, reason: collision with root package name */
        p f1877r;

        q() {
        }

        @Override // c0.g.n0
        String n() {
            return "line";
        }
    }

    static class q0 extends j {

        /* renamed from: m, reason: collision with root package name */
        p f1878m;

        /* renamed from: n, reason: collision with root package name */
        p f1879n;

        /* renamed from: o, reason: collision with root package name */
        p f1880o;

        /* renamed from: p, reason: collision with root package name */
        p f1881p;

        /* renamed from: q, reason: collision with root package name */
        p f1882q;

        q0() {
        }

        @Override // c0.g.n0
        String n() {
            return "radialGradient";
        }
    }

    static class r extends r0 implements t {

        /* renamed from: q, reason: collision with root package name */
        boolean f1883q;

        /* renamed from: r, reason: collision with root package name */
        p f1884r;

        /* renamed from: s, reason: collision with root package name */
        p f1885s;

        /* renamed from: t, reason: collision with root package name */
        p f1886t;

        /* renamed from: u, reason: collision with root package name */
        p f1887u;

        /* renamed from: v, reason: collision with root package name */
        Float f1888v;

        r() {
        }

        @Override // c0.g.n0
        String n() {
            return "marker";
        }
    }

    static abstract class r0 extends p0 {

        /* renamed from: p, reason: collision with root package name */
        b f1889p;

        r0() {
        }
    }

    static class s extends h0 implements t {

        /* renamed from: o, reason: collision with root package name */
        Boolean f1890o;

        /* renamed from: p, reason: collision with root package name */
        Boolean f1891p;

        /* renamed from: q, reason: collision with root package name */
        p f1892q;

        /* renamed from: r, reason: collision with root package name */
        p f1893r;

        /* renamed from: s, reason: collision with root package name */
        p f1894s;

        /* renamed from: t, reason: collision with root package name */
        p f1895t;

        s() {
        }

        @Override // c0.g.n0
        String n() {
            return "mask";
        }
    }

    static class s0 extends m {
        s0() {
        }

        @Override // c0.g.m, c0.g.n0
        String n() {
            return "switch";
        }
    }

    interface t {
    }

    static class t0 extends r0 implements t {
        t0() {
        }

        @Override // c0.g.n0
        String n() {
            return "symbol";
        }
    }

    static class u extends o0 {

        /* renamed from: c, reason: collision with root package name */
        String f1896c;

        /* renamed from: d, reason: collision with root package name */
        o0 f1897d;

        u(String str, o0 o0Var) {
            this.f1896c = str;
            this.f1897d = o0Var;
        }

        public String toString() {
            return this.f1896c + " " + this.f1897d;
        }
    }

    static class u0 extends y0 implements x0 {

        /* renamed from: o, reason: collision with root package name */
        String f1898o;

        /* renamed from: p, reason: collision with root package name */
        private b1 f1899p;

        u0() {
        }

        @Override // c0.g.x0
        public b1 f() {
            return this.f1899p;
        }

        @Override // c0.g.n0
        String n() {
            return "tref";
        }

        public void o(b1 b1Var) {
            this.f1899p = b1Var;
        }
    }

    static class v extends l {

        /* renamed from: o, reason: collision with root package name */
        w f1900o;

        /* renamed from: p, reason: collision with root package name */
        Float f1901p;

        v() {
        }

        @Override // c0.g.n0
        String n() {
            return "path";
        }
    }

    static class v0 extends a1 implements x0 {

        /* renamed from: s, reason: collision with root package name */
        private b1 f1902s;

        v0() {
        }

        @Override // c0.g.x0
        public b1 f() {
            return this.f1902s;
        }

        @Override // c0.g.n0
        String n() {
            return "tspan";
        }

        public void o(b1 b1Var) {
            this.f1902s = b1Var;
        }
    }

    static class w implements x {

        /* renamed from: b, reason: collision with root package name */
        private int f1904b = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f1906d = 0;

        /* renamed from: a, reason: collision with root package name */
        private byte[] f1903a = new byte[8];

        /* renamed from: c, reason: collision with root package name */
        private float[] f1905c = new float[16];

        w() {
        }

        private void d(byte b4) {
            int i3 = this.f1904b;
            byte[] bArr = this.f1903a;
            if (i3 == bArr.length) {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.f1903a = bArr2;
            }
            byte[] bArr3 = this.f1903a;
            int i4 = this.f1904b;
            this.f1904b = i4 + 1;
            bArr3[i4] = b4;
        }

        private void e(int i3) {
            float[] fArr = this.f1905c;
            if (fArr.length < this.f1906d + i3) {
                float[] fArr2 = new float[fArr.length * 2];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.f1905c = fArr2;
            }
        }

        @Override // c0.g.x
        public void a(float f3, float f4, float f5, float f6) {
            d((byte) 3);
            e(4);
            float[] fArr = this.f1905c;
            int i3 = this.f1906d;
            int i4 = i3 + 1;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            fArr[i4] = f4;
            int i6 = i5 + 1;
            fArr[i5] = f5;
            this.f1906d = i6 + 1;
            fArr[i6] = f6;
        }

        @Override // c0.g.x
        public void b(float f3, float f4, float f5, float f6, float f7, float f8) {
            d((byte) 2);
            e(6);
            float[] fArr = this.f1905c;
            int i3 = this.f1906d;
            int i4 = i3 + 1;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            fArr[i4] = f4;
            int i6 = i5 + 1;
            fArr[i5] = f5;
            int i7 = i6 + 1;
            fArr[i6] = f6;
            int i8 = i7 + 1;
            fArr[i7] = f7;
            this.f1906d = i8 + 1;
            fArr[i8] = f8;
        }

        @Override // c0.g.x
        public void c(float f3, float f4, float f5, boolean z3, boolean z4, float f6, float f7) {
            d((byte) ((z3 ? 2 : 0) | 4 | (z4 ? 1 : 0)));
            e(5);
            float[] fArr = this.f1905c;
            int i3 = this.f1906d;
            int i4 = i3 + 1;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            fArr[i4] = f4;
            int i6 = i5 + 1;
            fArr[i5] = f5;
            int i7 = i6 + 1;
            fArr[i6] = f6;
            this.f1906d = i7 + 1;
            fArr[i7] = f7;
        }

        @Override // c0.g.x
        public void close() {
            d((byte) 8);
        }

        void f(x xVar) {
            int i3;
            int i4 = 0;
            for (int i5 = 0; i5 < this.f1904b; i5++) {
                byte b4 = this.f1903a[i5];
                if (b4 == 0) {
                    float[] fArr = this.f1905c;
                    int i6 = i4 + 1;
                    i3 = i6 + 1;
                    xVar.moveTo(fArr[i4], fArr[i6]);
                } else if (b4 != 1) {
                    if (b4 == 2) {
                        float[] fArr2 = this.f1905c;
                        int i7 = i4 + 1;
                        float f3 = fArr2[i4];
                        int i8 = i7 + 1;
                        float f4 = fArr2[i7];
                        int i9 = i8 + 1;
                        float f5 = fArr2[i8];
                        int i10 = i9 + 1;
                        float f6 = fArr2[i9];
                        int i11 = i10 + 1;
                        float f7 = fArr2[i10];
                        i4 = i11 + 1;
                        xVar.b(f3, f4, f5, f6, f7, fArr2[i11]);
                    } else if (b4 == 3) {
                        float[] fArr3 = this.f1905c;
                        int i12 = i4 + 1;
                        int i13 = i12 + 1;
                        int i14 = i13 + 1;
                        xVar.a(fArr3[i4], fArr3[i12], fArr3[i13], fArr3[i14]);
                        i4 = i14 + 1;
                    } else if (b4 != 8) {
                        boolean z3 = (b4 & 2) != 0;
                        boolean z4 = (b4 & 1) != 0;
                        float[] fArr4 = this.f1905c;
                        int i15 = i4 + 1;
                        float f8 = fArr4[i4];
                        int i16 = i15 + 1;
                        float f9 = fArr4[i15];
                        int i17 = i16 + 1;
                        float f10 = fArr4[i16];
                        int i18 = i17 + 1;
                        xVar.c(f8, f9, f10, z3, z4, fArr4[i17], fArr4[i18]);
                        i4 = i18 + 1;
                    } else {
                        xVar.close();
                    }
                } else {
                    float[] fArr5 = this.f1905c;
                    int i19 = i4 + 1;
                    i3 = i19 + 1;
                    xVar.lineTo(fArr5[i4], fArr5[i19]);
                }
                i4 = i3;
            }
        }

        boolean g() {
            return this.f1904b == 0;
        }

        @Override // c0.g.x
        public void lineTo(float f3, float f4) {
            d((byte) 1);
            e(2);
            float[] fArr = this.f1905c;
            int i3 = this.f1906d;
            int i4 = i3 + 1;
            fArr[i3] = f3;
            this.f1906d = i4 + 1;
            fArr[i4] = f4;
        }

        @Override // c0.g.x
        public void moveTo(float f3, float f4) {
            d((byte) 0);
            e(2);
            float[] fArr = this.f1905c;
            int i3 = this.f1906d;
            int i4 = i3 + 1;
            fArr[i3] = f3;
            this.f1906d = i4 + 1;
            fArr[i4] = f4;
        }
    }

    static class w0 extends a1 implements b1, n {

        /* renamed from: s, reason: collision with root package name */
        Matrix f1907s;

        w0() {
        }

        @Override // c0.g.n
        public void j(Matrix matrix) {
            this.f1907s = matrix;
        }

        @Override // c0.g.n0
        String n() {
            return "text";
        }
    }

    interface x {
        void a(float f3, float f4, float f5, float f6);

        void b(float f3, float f4, float f5, float f6, float f7, float f8);

        void c(float f3, float f4, float f5, boolean z3, boolean z4, float f6, float f7);

        void close();

        void lineTo(float f3, float f4);

        void moveTo(float f3, float f4);
    }

    interface x0 {
        b1 f();
    }

    static class y extends r0 implements t {

        /* renamed from: q, reason: collision with root package name */
        Boolean f1908q;

        /* renamed from: r, reason: collision with root package name */
        Boolean f1909r;

        /* renamed from: s, reason: collision with root package name */
        Matrix f1910s;

        /* renamed from: t, reason: collision with root package name */
        p f1911t;

        /* renamed from: u, reason: collision with root package name */
        p f1912u;

        /* renamed from: v, reason: collision with root package name */
        p f1913v;

        /* renamed from: w, reason: collision with root package name */
        p f1914w;

        /* renamed from: x, reason: collision with root package name */
        String f1915x;

        y() {
        }

        @Override // c0.g.n0
        String n() {
            return "pattern";
        }
    }

    static abstract class y0 extends h0 {
        y0() {
        }

        @Override // c0.g.h0, c0.g.j0
        public void i(n0 n0Var) {
            if (n0Var instanceof x0) {
                this.f1827i.add(n0Var);
                return;
            }
            throw new c0.j("Text content elements cannot contain " + n0Var + " elements.");
        }
    }

    static class z extends l {

        /* renamed from: o, reason: collision with root package name */
        float[] f1916o;

        z() {
        }

        @Override // c0.g.n0
        String n() {
            return "polyline";
        }
    }

    static class z0 extends y0 implements x0 {

        /* renamed from: o, reason: collision with root package name */
        String f1917o;

        /* renamed from: p, reason: collision with root package name */
        p f1918p;

        /* renamed from: q, reason: collision with root package name */
        private b1 f1919q;

        z0() {
        }

        @Override // c0.g.x0
        public b1 f() {
            return this.f1919q;
        }

        @Override // c0.g.n0
        String n() {
            return "textPath";
        }

        public void o(b1 b1Var) {
            this.f1919q = b1Var;
        }
    }

    g() {
    }

    private String c(String str) {
        String substring;
        String str2;
        String str3 = "\"";
        if (!str.startsWith("\"") || !str.endsWith("\"")) {
            str3 = "'";
            if (str.startsWith("'") && str.endsWith("'")) {
                substring = str.substring(1, str.length() - 1);
                str2 = "\\'";
            }
            return str.replace("\\\n", "").replace("\\A", IOUtils.LINE_SEPARATOR_UNIX);
        }
        substring = str.substring(1, str.length() - 1);
        str2 = "\\\"";
        str = substring.replace(str2, str3);
        return str.replace("\\\n", "").replace("\\A", IOUtils.LINE_SEPARATOR_UNIX);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private l0 e(j0 j0Var, String str) {
        l0 e3;
        l0 l0Var = (l0) j0Var;
        if (str.equals(l0Var.f1853c)) {
            return l0Var;
        }
        for (Object obj : j0Var.a()) {
            if (obj instanceof l0) {
                l0 l0Var2 = (l0) obj;
                if (str.equals(l0Var2.f1853c)) {
                    return l0Var2;
                }
                if ((obj instanceof j0) && (e3 = e((j0) obj, str)) != null) {
                    return e3;
                }
            }
        }
        return null;
    }

    static c0.i g() {
        return null;
    }

    public static g h(InputStream inputStream) {
        return new c0.k().z(inputStream, f1712g);
    }

    void a(b.r rVar) {
        this.f1717e.b(rVar);
    }

    void b() {
        this.f1717e.e(b.u.RenderOptions);
    }

    List<b.p> d() {
        return this.f1717e.c();
    }

    l0 f(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.f1713a.f1853c)) {
            return this.f1713a;
        }
        if (this.f1718f.containsKey(str)) {
            return this.f1718f.get(str);
        }
        l0 e3 = e(this.f1713a, str);
        this.f1718f.put(str, e3);
        return e3;
    }

    f0 i() {
        return this.f1713a;
    }

    boolean j() {
        return !this.f1717e.d();
    }

    public Picture k() {
        return m(null);
    }

    public Picture l(int i3, int i4, c0.f fVar) {
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i3, i4);
        if (fVar == null || fVar.f1711f == null) {
            fVar = fVar == null ? new c0.f() : new c0.f(fVar);
            fVar.g(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, i3, i4);
        }
        new c0.h(beginRecording, this.f1716d).G0(this, fVar);
        picture.endRecording();
        return picture;
    }

    public Picture m(c0.f fVar) {
        p pVar;
        b bVar = (fVar == null || !fVar.e()) ? this.f1713a.f1889p : fVar.f1709d;
        if (fVar != null && fVar.f()) {
            return l((int) Math.ceil(fVar.f1711f.b()), (int) Math.ceil(fVar.f1711f.c()), fVar);
        }
        f0 f0Var = this.f1713a;
        p pVar2 = f0Var.f1823s;
        if (pVar2 != null) {
            d1 d1Var = pVar2.f1872d;
            d1 d1Var2 = d1.percent;
            if (d1Var != d1Var2 && (pVar = f0Var.f1824t) != null && pVar.f1872d != d1Var2) {
                return l((int) Math.ceil(pVar2.b(this.f1716d)), (int) Math.ceil(this.f1713a.f1824t.b(this.f1716d)), fVar);
            }
        }
        if (pVar2 != null && bVar != null) {
            return l((int) Math.ceil(pVar2.b(this.f1716d)), (int) Math.ceil((bVar.f1727d * r1) / bVar.f1726c), fVar);
        }
        p pVar3 = f0Var.f1824t;
        if (pVar3 == null || bVar == null) {
            return l(UserVerificationMethods.USER_VERIFY_NONE, UserVerificationMethods.USER_VERIFY_NONE, fVar);
        }
        return l((int) Math.ceil((bVar.f1726c * r1) / bVar.f1727d), (int) Math.ceil(pVar3.b(this.f1716d)), fVar);
    }

    n0 n(String str) {
        if (str == null) {
            return null;
        }
        String c3 = c(str);
        if (c3.length() <= 1 || !c3.startsWith("#")) {
            return null;
        }
        return f(c3.substring(1));
    }

    void o(String str) {
        this.f1715c = str;
    }

    void p(f0 f0Var) {
        this.f1713a = f0Var;
    }

    void q(String str) {
        this.f1714b = str;
    }
}
