package c0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.Log;
import c0.b;
import c0.e;
import c0.g;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import org.apache.commons.io.FileUtils;
import org.kxml2.wap.Wbxml;

/* loaded from: /root/release/classes.dex */
class h {

    /* renamed from: i, reason: collision with root package name */
    private static HashSet<String> f1920i;

    /* renamed from: a, reason: collision with root package name */
    private Canvas f1921a;

    /* renamed from: b, reason: collision with root package name */
    private float f1922b;

    /* renamed from: c, reason: collision with root package name */
    private c0.g f1923c;

    /* renamed from: d, reason: collision with root package name */
    private C0045h f1924d;

    /* renamed from: e, reason: collision with root package name */
    private Stack<C0045h> f1925e;

    /* renamed from: f, reason: collision with root package name */
    private Stack<g.j0> f1926f;

    /* renamed from: g, reason: collision with root package name */
    private Stack<Matrix> f1927g;

    /* renamed from: h, reason: collision with root package name */
    private b.q f1928h = null;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1929a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1930b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f1931c;

        static {
            int[] iArr = new int[g.e0.d.values().length];
            f1931c = iArr;
            try {
                iArr[g.e0.d.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1931c[g.e0.d.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1931c[g.e0.d.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[g.e0.c.values().length];
            f1930b = iArr2;
            try {
                iArr2[g.e0.c.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1930b[g.e0.c.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1930b[g.e0.c.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[e.a.values().length];
            f1929a = iArr3;
            try {
                iArr3[e.a.xMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1929a[e.a.xMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1929a[e.a.xMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1929a[e.a.xMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1929a[e.a.xMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1929a[e.a.xMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1929a[e.a.xMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1929a[e.a.xMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    private class b implements g.x {

        /* renamed from: b, reason: collision with root package name */
        private float f1933b;

        /* renamed from: c, reason: collision with root package name */
        private float f1934c;

        /* renamed from: h, reason: collision with root package name */
        private boolean f1939h;

        /* renamed from: a, reason: collision with root package name */
        private List<c> f1932a = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private c f1935d = null;

        /* renamed from: e, reason: collision with root package name */
        private boolean f1936e = false;

        /* renamed from: f, reason: collision with root package name */
        private boolean f1937f = true;

        /* renamed from: g, reason: collision with root package name */
        private int f1938g = -1;

        b(g.w wVar) {
            if (wVar == null) {
                return;
            }
            wVar.f(this);
            if (this.f1939h) {
                this.f1935d.b(this.f1932a.get(this.f1938g));
                this.f1932a.set(this.f1938g, this.f1935d);
                this.f1939h = false;
            }
            c cVar = this.f1935d;
            if (cVar != null) {
                this.f1932a.add(cVar);
            }
        }

        @Override // c0.g.x
        public void a(float f3, float f4, float f5, float f6) {
            this.f1935d.a(f3, f4);
            this.f1932a.add(this.f1935d);
            this.f1935d = h.this.new c(f5, f6, f5 - f3, f6 - f4);
            this.f1939h = false;
        }

        @Override // c0.g.x
        public void b(float f3, float f4, float f5, float f6, float f7, float f8) {
            if (this.f1937f || this.f1936e) {
                this.f1935d.a(f3, f4);
                this.f1932a.add(this.f1935d);
                this.f1936e = false;
            }
            this.f1935d = h.this.new c(f7, f8, f7 - f5, f8 - f6);
            this.f1939h = false;
        }

        @Override // c0.g.x
        public void c(float f3, float f4, float f5, boolean z3, boolean z4, float f6, float f7) {
            this.f1936e = true;
            this.f1937f = false;
            c cVar = this.f1935d;
            h.h(cVar.f1941a, cVar.f1942b, f3, f4, f5, z3, z4, f6, f7, this);
            this.f1937f = true;
            this.f1939h = false;
        }

        @Override // c0.g.x
        public void close() {
            this.f1932a.add(this.f1935d);
            lineTo(this.f1933b, this.f1934c);
            this.f1939h = true;
        }

        List<c> d() {
            return this.f1932a;
        }

        @Override // c0.g.x
        public void lineTo(float f3, float f4) {
            this.f1935d.a(f3, f4);
            this.f1932a.add(this.f1935d);
            h hVar = h.this;
            c cVar = this.f1935d;
            this.f1935d = hVar.new c(f3, f4, f3 - cVar.f1941a, f4 - cVar.f1942b);
            this.f1939h = false;
        }

        @Override // c0.g.x
        public void moveTo(float f3, float f4) {
            if (this.f1939h) {
                this.f1935d.b(this.f1932a.get(this.f1938g));
                this.f1932a.set(this.f1938g, this.f1935d);
                this.f1939h = false;
            }
            c cVar = this.f1935d;
            if (cVar != null) {
                this.f1932a.add(cVar);
            }
            this.f1933b = f3;
            this.f1934c = f4;
            this.f1935d = h.this.new c(f3, f4, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            this.f1938g = this.f1932a.size();
        }
    }

    private class c {

        /* renamed from: a, reason: collision with root package name */
        float f1941a;

        /* renamed from: b, reason: collision with root package name */
        float f1942b;

        /* renamed from: c, reason: collision with root package name */
        float f1943c;

        /* renamed from: d, reason: collision with root package name */
        float f1944d;

        /* renamed from: e, reason: collision with root package name */
        boolean f1945e = false;

        c(float f3, float f4, float f5, float f6) {
            this.f1943c = BitmapDescriptorFactory.HUE_RED;
            this.f1944d = BitmapDescriptorFactory.HUE_RED;
            this.f1941a = f3;
            this.f1942b = f4;
            double sqrt = Math.sqrt((f5 * f5) + (f6 * f6));
            if (sqrt != 0.0d) {
                this.f1943c = (float) (f5 / sqrt);
                this.f1944d = (float) (f6 / sqrt);
            }
        }

        void a(float f3, float f4) {
            float f5 = f3 - this.f1941a;
            float f6 = f4 - this.f1942b;
            double sqrt = Math.sqrt((f5 * f5) + (f6 * f6));
            if (sqrt != 0.0d) {
                f5 = (float) (f5 / sqrt);
                f6 = (float) (f6 / sqrt);
            }
            float f7 = this.f1943c;
            if (f5 == (-f7) && f6 == (-this.f1944d)) {
                this.f1945e = true;
                this.f1943c = -f6;
            } else {
                this.f1943c = f7 + f5;
                f5 = this.f1944d + f6;
            }
            this.f1944d = f5;
        }

        void b(c cVar) {
            float f3 = cVar.f1943c;
            float f4 = this.f1943c;
            if (f3 == (-f4)) {
                float f5 = cVar.f1944d;
                if (f5 == (-this.f1944d)) {
                    this.f1945e = true;
                    this.f1943c = -f5;
                    this.f1944d = cVar.f1943c;
                    return;
                }
            }
            this.f1943c = f4 + f3;
            this.f1944d += cVar.f1944d;
        }

        public String toString() {
            return "(" + this.f1941a + "," + this.f1942b + " " + this.f1943c + "," + this.f1944d + ")";
        }
    }

    private class d implements g.x {

        /* renamed from: a, reason: collision with root package name */
        Path f1947a = new Path();

        /* renamed from: b, reason: collision with root package name */
        float f1948b;

        /* renamed from: c, reason: collision with root package name */
        float f1949c;

        d(g.w wVar) {
            if (wVar == null) {
                return;
            }
            wVar.f(this);
        }

        @Override // c0.g.x
        public void a(float f3, float f4, float f5, float f6) {
            this.f1947a.quadTo(f3, f4, f5, f6);
            this.f1948b = f5;
            this.f1949c = f6;
        }

        @Override // c0.g.x
        public void b(float f3, float f4, float f5, float f6, float f7, float f8) {
            this.f1947a.cubicTo(f3, f4, f5, f6, f7, f8);
            this.f1948b = f7;
            this.f1949c = f8;
        }

        @Override // c0.g.x
        public void c(float f3, float f4, float f5, boolean z3, boolean z4, float f6, float f7) {
            h.h(this.f1948b, this.f1949c, f3, f4, f5, z3, z4, f6, f7, this);
            this.f1948b = f6;
            this.f1949c = f7;
        }

        @Override // c0.g.x
        public void close() {
            this.f1947a.close();
        }

        Path d() {
            return this.f1947a;
        }

        @Override // c0.g.x
        public void lineTo(float f3, float f4) {
            this.f1947a.lineTo(f3, f4);
            this.f1948b = f3;
            this.f1949c = f4;
        }

        @Override // c0.g.x
        public void moveTo(float f3, float f4) {
            this.f1947a.moveTo(f3, f4);
            this.f1948b = f3;
            this.f1949c = f4;
        }
    }

    private class e extends f {

        /* renamed from: e, reason: collision with root package name */
        private Path f1951e;

        e(Path path, float f3, float f4) {
            super(f3, f4);
            this.f1951e = path;
        }

        @Override // c0.h.f, c0.h.j
        public void b(String str) {
            if (h.this.Y0()) {
                if (h.this.f1924d.f1961b) {
                    h.this.f1921a.drawTextOnPath(str, this.f1951e, this.f1953b, this.f1954c, h.this.f1924d.f1963d);
                }
                if (h.this.f1924d.f1962c) {
                    h.this.f1921a.drawTextOnPath(str, this.f1951e, this.f1953b, this.f1954c, h.this.f1924d.f1964e);
                }
            }
            this.f1953b += h.this.f1924d.f1963d.measureText(str);
        }
    }

    private class f extends j {

        /* renamed from: b, reason: collision with root package name */
        float f1953b;

        /* renamed from: c, reason: collision with root package name */
        float f1954c;

        f(float f3, float f4) {
            super(h.this, null);
            this.f1953b = f3;
            this.f1954c = f4;
        }

        @Override // c0.h.j
        public void b(String str) {
            h.y("TextSequence render", new Object[0]);
            if (h.this.Y0()) {
                if (h.this.f1924d.f1961b) {
                    h.this.f1921a.drawText(str, this.f1953b, this.f1954c, h.this.f1924d.f1963d);
                }
                if (h.this.f1924d.f1962c) {
                    h.this.f1921a.drawText(str, this.f1953b, this.f1954c, h.this.f1924d.f1964e);
                }
            }
            this.f1953b += h.this.f1924d.f1963d.measureText(str);
        }
    }

    private class g extends j {

        /* renamed from: b, reason: collision with root package name */
        float f1956b;

        /* renamed from: c, reason: collision with root package name */
        float f1957c;

        /* renamed from: d, reason: collision with root package name */
        Path f1958d;

        g(float f3, float f4, Path path) {
            super(h.this, null);
            this.f1956b = f3;
            this.f1957c = f4;
            this.f1958d = path;
        }

        @Override // c0.h.j
        public boolean a(g.y0 y0Var) {
            if (!(y0Var instanceof g.z0)) {
                return true;
            }
            h.Z0("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        @Override // c0.h.j
        public void b(String str) {
            if (h.this.Y0()) {
                Path path = new Path();
                h.this.f1924d.f1963d.getTextPath(str, 0, str.length(), this.f1956b, this.f1957c, path);
                this.f1958d.addPath(path);
            }
            this.f1956b += h.this.f1924d.f1963d.measureText(str);
        }
    }

    /* renamed from: c0.h$h, reason: collision with other inner class name */
    private class C0045h {

        /* renamed from: a, reason: collision with root package name */
        g.e0 f1960a;

        /* renamed from: b, reason: collision with root package name */
        boolean f1961b;

        /* renamed from: c, reason: collision with root package name */
        boolean f1962c;

        /* renamed from: d, reason: collision with root package name */
        Paint f1963d;

        /* renamed from: e, reason: collision with root package name */
        Paint f1964e;

        /* renamed from: f, reason: collision with root package name */
        g.b f1965f;

        /* renamed from: g, reason: collision with root package name */
        g.b f1966g;

        /* renamed from: h, reason: collision with root package name */
        boolean f1967h;

        C0045h() {
            Paint paint = new Paint();
            this.f1963d = paint;
            paint.setFlags(Wbxml.EXT_1);
            this.f1963d.setHinting(0);
            this.f1963d.setStyle(Paint.Style.FILL);
            this.f1963d.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.f1964e = paint2;
            paint2.setFlags(Wbxml.EXT_1);
            this.f1964e.setHinting(0);
            this.f1964e.setStyle(Paint.Style.STROKE);
            this.f1964e.setTypeface(Typeface.DEFAULT);
            this.f1960a = g.e0.a();
        }

        C0045h(C0045h c0045h) {
            this.f1961b = c0045h.f1961b;
            this.f1962c = c0045h.f1962c;
            this.f1963d = new Paint(c0045h.f1963d);
            this.f1964e = new Paint(c0045h.f1964e);
            g.b bVar = c0045h.f1965f;
            if (bVar != null) {
                this.f1965f = new g.b(bVar);
            }
            g.b bVar2 = c0045h.f1966g;
            if (bVar2 != null) {
                this.f1966g = new g.b(bVar2);
            }
            this.f1967h = c0045h.f1967h;
            try {
                this.f1960a = (g.e0) c0045h.f1960a.clone();
            } catch (CloneNotSupportedException e3) {
                Log.e("SVGAndroidRenderer", "Unexpected clone error", e3);
                this.f1960a = g.e0.a();
            }
        }
    }

    private class i extends j {

        /* renamed from: b, reason: collision with root package name */
        float f1969b;

        /* renamed from: c, reason: collision with root package name */
        float f1970c;

        /* renamed from: d, reason: collision with root package name */
        RectF f1971d;

        i(float f3, float f4) {
            super(h.this, null);
            this.f1971d = new RectF();
            this.f1969b = f3;
            this.f1970c = f4;
        }

        @Override // c0.h.j
        public boolean a(g.y0 y0Var) {
            if (!(y0Var instanceof g.z0)) {
                return true;
            }
            g.z0 z0Var = (g.z0) y0Var;
            g.n0 n3 = y0Var.f1863a.n(z0Var.f1917o);
            if (n3 == null) {
                h.F("TextPath path reference '%s' not found", z0Var.f1917o);
                return false;
            }
            g.v vVar = (g.v) n3;
            Path d3 = h.this.new d(vVar.f1900o).d();
            Matrix matrix = vVar.f1852n;
            if (matrix != null) {
                d3.transform(matrix);
            }
            RectF rectF = new RectF();
            d3.computeBounds(rectF, true);
            this.f1971d.union(rectF);
            return false;
        }

        @Override // c0.h.j
        public void b(String str) {
            if (h.this.Y0()) {
                Rect rect = new Rect();
                h.this.f1924d.f1963d.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.f1969b, this.f1970c);
                this.f1971d.union(rectF);
            }
            this.f1969b += h.this.f1924d.f1963d.measureText(str);
        }
    }

    private abstract class j {
        private j() {
        }

        /* synthetic */ j(h hVar, a aVar) {
            this();
        }

        public boolean a(g.y0 y0Var) {
            return true;
        }

        public abstract void b(String str);
    }

    private class k extends j {

        /* renamed from: b, reason: collision with root package name */
        float f1974b;

        private k() {
            super(h.this, null);
            this.f1974b = BitmapDescriptorFactory.HUE_RED;
        }

        /* synthetic */ k(h hVar, a aVar) {
            this();
        }

        @Override // c0.h.j
        public void b(String str) {
            this.f1974b += h.this.f1924d.f1963d.measureText(str);
        }
    }

    h(Canvas canvas, float f3) {
        this.f1921a = canvas;
        this.f1922b = f3;
    }

    private boolean A() {
        Boolean bool = this.f1924d.f1960a.D;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private void A0(g.n0 n0Var) {
        if (n0Var instanceof g.t) {
            return;
        }
        S0();
        u(n0Var);
        if (n0Var instanceof g.f0) {
            x0((g.f0) n0Var);
        } else if (n0Var instanceof g.e1) {
            E0((g.e1) n0Var);
        } else if (n0Var instanceof g.s0) {
            B0((g.s0) n0Var);
        } else if (n0Var instanceof g.m) {
            q0((g.m) n0Var);
        } else if (n0Var instanceof g.o) {
            r0((g.o) n0Var);
        } else if (n0Var instanceof g.v) {
            t0((g.v) n0Var);
        } else if (n0Var instanceof g.b0) {
            w0((g.b0) n0Var);
        } else if (n0Var instanceof g.d) {
            o0((g.d) n0Var);
        } else if (n0Var instanceof g.i) {
            p0((g.i) n0Var);
        } else if (n0Var instanceof g.q) {
            s0((g.q) n0Var);
        } else if (n0Var instanceof g.a0) {
            v0((g.a0) n0Var);
        } else if (n0Var instanceof g.z) {
            u0((g.z) n0Var);
        } else if (n0Var instanceof g.w0) {
            D0((g.w0) n0Var);
        }
        R0();
    }

    private void B(g.k0 k0Var, Path path) {
        g.o0 o0Var = this.f1924d.f1960a.f1756d;
        if (o0Var instanceof g.u) {
            g.n0 n3 = this.f1923c.n(((g.u) o0Var).f1896c);
            if (n3 instanceof g.y) {
                L(k0Var, path, (g.y) n3);
                return;
            }
        }
        this.f1921a.drawPath(path, this.f1924d.f1963d);
    }

    private void B0(g.s0 s0Var) {
        y("Switch render", new Object[0]);
        W0(this.f1924d, s0Var);
        if (A()) {
            Matrix matrix = s0Var.f1858o;
            if (matrix != null) {
                this.f1921a.concat(matrix);
            }
            p(s0Var);
            boolean m02 = m0();
            K0(s0Var);
            if (m02) {
                j0(s0Var);
            }
            U0(s0Var);
        }
    }

    private void C(Path path) {
        C0045h c0045h = this.f1924d;
        if (c0045h.f1960a.O != g.e0.i.NonScalingStroke) {
            this.f1921a.drawPath(path, c0045h.f1964e);
            return;
        }
        Matrix matrix = this.f1921a.getMatrix();
        Path path2 = new Path();
        path.transform(matrix, path2);
        this.f1921a.setMatrix(new Matrix());
        Shader shader = this.f1924d.f1964e.getShader();
        Matrix matrix2 = new Matrix();
        if (shader != null) {
            shader.getLocalMatrix(matrix2);
            Matrix matrix3 = new Matrix(matrix2);
            matrix3.postConcat(matrix);
            shader.setLocalMatrix(matrix3);
        }
        this.f1921a.drawPath(path2, this.f1924d.f1964e);
        this.f1921a.setMatrix(matrix);
        if (shader != null) {
            shader.setLocalMatrix(matrix2);
        }
    }

    private void C0(g.t0 t0Var, g.b bVar) {
        y("Symbol render", new Object[0]);
        if (bVar.f1726c == BitmapDescriptorFactory.HUE_RED || bVar.f1727d == BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        c0.e eVar = t0Var.f1873o;
        if (eVar == null) {
            eVar = c0.e.f1683e;
        }
        W0(this.f1924d, t0Var);
        C0045h c0045h = this.f1924d;
        c0045h.f1965f = bVar;
        if (!c0045h.f1960a.f1776y.booleanValue()) {
            g.b bVar2 = this.f1924d.f1965f;
            O0(bVar2.f1724a, bVar2.f1725b, bVar2.f1726c, bVar2.f1727d);
        }
        g.b bVar3 = t0Var.f1889p;
        if (bVar3 != null) {
            this.f1921a.concat(o(this.f1924d.f1965f, bVar3, eVar));
            this.f1924d.f1966g = t0Var.f1889p;
        } else {
            Canvas canvas = this.f1921a;
            g.b bVar4 = this.f1924d.f1965f;
            canvas.translate(bVar4.f1724a, bVar4.f1725b);
        }
        boolean m02 = m0();
        F0(t0Var, true);
        if (m02) {
            j0(t0Var);
        }
        U0(t0Var);
    }

    private float D(float f3, float f4, float f5, float f6) {
        return (f3 * f5) + (f4 * f6);
    }

    private void D0(g.w0 w0Var) {
        y("Text render", new Object[0]);
        W0(this.f1924d, w0Var);
        if (A()) {
            Matrix matrix = w0Var.f1907s;
            if (matrix != null) {
                this.f1921a.concat(matrix);
            }
            List<g.p> list = w0Var.f1720o;
            float f3 = BitmapDescriptorFactory.HUE_RED;
            float e3 = (list == null || list.size() == 0) ? BitmapDescriptorFactory.HUE_RED : w0Var.f1720o.get(0).e(this);
            List<g.p> list2 = w0Var.f1721p;
            float f4 = (list2 == null || list2.size() == 0) ? BitmapDescriptorFactory.HUE_RED : w0Var.f1721p.get(0).f(this);
            List<g.p> list3 = w0Var.f1722q;
            float e4 = (list3 == null || list3.size() == 0) ? BitmapDescriptorFactory.HUE_RED : w0Var.f1722q.get(0).e(this);
            List<g.p> list4 = w0Var.f1723r;
            if (list4 != null && list4.size() != 0) {
                f3 = w0Var.f1723r.get(0).f(this);
            }
            g.e0.f O = O();
            if (O != g.e0.f.Start) {
                float n3 = n(w0Var);
                if (O == g.e0.f.Middle) {
                    n3 /= 2.0f;
                }
                e3 -= n3;
            }
            if (w0Var.f1851h == null) {
                i iVar = new i(e3, f4);
                E(w0Var, iVar);
                RectF rectF = iVar.f1971d;
                w0Var.f1851h = new g.b(rectF.left, rectF.top, rectF.width(), iVar.f1971d.height());
            }
            U0(w0Var);
            r(w0Var);
            p(w0Var);
            boolean m02 = m0();
            E(w0Var, new f(e3 + e4, f4 + f3));
            if (m02) {
                j0(w0Var);
            }
        }
    }

    private void E(g.y0 y0Var, j jVar) {
        if (A()) {
            Iterator<g.n0> it = y0Var.f1827i.iterator();
            boolean z3 = true;
            while (it.hasNext()) {
                g.n0 next = it.next();
                if (next instanceof g.c1) {
                    jVar.b(T0(((g.c1) next).f1738c, z3, !it.hasNext()));
                } else {
                    l0(next, jVar);
                }
                z3 = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void E0(c0.g.e1 r8) {
        /*
            r7 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "Use render"
            y(r2, r1)
            c0.g$p r1 = r8.f1816s
            if (r1 == 0) goto L12
            boolean r1 = r1.h()
            if (r1 != 0) goto L1c
        L12:
            c0.g$p r1 = r8.f1817t
            if (r1 == 0) goto L1d
            boolean r1 = r1.h()
            if (r1 == 0) goto L1d
        L1c:
            return
        L1d:
            c0.h$h r1 = r7.f1924d
            r7.W0(r1, r8)
            boolean r1 = r7.A()
            if (r1 != 0) goto L29
            return
        L29:
            c0.g r1 = r8.f1863a
            java.lang.String r2 = r8.f1813p
            c0.g$n0 r1 = r1.n(r2)
            if (r1 != 0) goto L40
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r8 = r8.f1813p
            r1[r0] = r8
            java.lang.String r8 = "Use reference '%s' not found"
            F(r8, r1)
            return
        L40:
            android.graphics.Matrix r0 = r8.f1858o
            if (r0 == 0) goto L49
            android.graphics.Canvas r2 = r7.f1921a
            r2.concat(r0)
        L49:
            c0.g$p r0 = r8.f1814q
            r2 = 0
            if (r0 == 0) goto L53
            float r0 = r0.e(r7)
            goto L54
        L53:
            r0 = 0
        L54:
            c0.g$p r3 = r8.f1815r
            if (r3 == 0) goto L5c
            float r2 = r3.f(r7)
        L5c:
            android.graphics.Canvas r3 = r7.f1921a
            r3.translate(r0, r2)
            r7.p(r8)
            boolean r0 = r7.m0()
            r7.i0(r8)
            boolean r2 = r1 instanceof c0.g.f0
            r3 = 0
            if (r2 == 0) goto L84
            c0.g$f0 r1 = (c0.g.f0) r1
            c0.g$p r2 = r8.f1816s
            c0.g$p r4 = r8.f1817t
            c0.g$b r2 = r7.f0(r3, r3, r2, r4)
            r7.S0()
            r7.y0(r1, r2)
        L80:
            r7.R0()
            goto Lb2
        L84:
            boolean r2 = r1 instanceof c0.g.t0
            if (r2 == 0) goto Laf
            c0.g$p r2 = r8.f1816s
            r4 = 1120403456(0x42c80000, float:100.0)
            if (r2 == 0) goto L8f
            goto L96
        L8f:
            c0.g$p r2 = new c0.g$p
            c0.g$d1 r5 = c0.g.d1.percent
            r2.<init>(r4, r5)
        L96:
            c0.g$p r5 = r8.f1817t
            if (r5 == 0) goto L9b
            goto La2
        L9b:
            c0.g$p r5 = new c0.g$p
            c0.g$d1 r6 = c0.g.d1.percent
            r5.<init>(r4, r6)
        La2:
            c0.g$b r2 = r7.f0(r3, r3, r2, r5)
            r7.S0()
            c0.g$t0 r1 = (c0.g.t0) r1
            r7.C0(r1, r2)
            goto L80
        Laf:
            r7.A0(r1)
        Lb2:
            r7.h0()
            if (r0 == 0) goto Lba
            r7.j0(r8)
        Lba:
            r7.U0(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.h.E0(c0.g$e1):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(String str, Object... objArr) {
        Log.e("SVGAndroidRenderer", String.format(str, objArr));
    }

    private void F0(g.j0 j0Var, boolean z3) {
        if (z3) {
            i0(j0Var);
        }
        Iterator<g.n0> it = j0Var.a().iterator();
        while (it.hasNext()) {
            A0(it.next());
        }
        if (z3) {
            h0();
        }
    }

    private void G(g.y0 y0Var, StringBuilder sb) {
        Iterator<g.n0> it = y0Var.f1827i.iterator();
        boolean z3 = true;
        while (it.hasNext()) {
            g.n0 next = it.next();
            if (next instanceof g.y0) {
                G((g.y0) next, sb);
            } else if (next instanceof g.c1) {
                sb.append(T0(((g.c1) next).f1738c, z3, !it.hasNext()));
            }
            z3 = false;
        }
    }

    private void H(g.j jVar, String str) {
        g.n0 n3 = jVar.f1863a.n(str);
        if (n3 == null) {
            Z0("Gradient reference '%s' not found", str);
            return;
        }
        if (!(n3 instanceof g.j)) {
            F("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (n3 == jVar) {
            F("Circular reference in gradient href attribute '%s'", str);
            return;
        }
        g.j jVar2 = (g.j) n3;
        if (jVar.f1843i == null) {
            jVar.f1843i = jVar2.f1843i;
        }
        if (jVar.f1844j == null) {
            jVar.f1844j = jVar2.f1844j;
        }
        if (jVar.f1845k == null) {
            jVar.f1845k = jVar2.f1845k;
        }
        if (jVar.f1842h.isEmpty()) {
            jVar.f1842h = jVar2.f1842h;
        }
        try {
            if (jVar instanceof g.m0) {
                I((g.m0) jVar, (g.m0) n3);
            } else {
                J((g.q0) jVar, (g.q0) n3);
            }
        } catch (ClassCastException unused) {
        }
        String str2 = jVar2.f1846l;
        if (str2 != null) {
            H(jVar, str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0104, code lost:
    
        if (r7 != 8) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void H0(c0.g.r r12, c0.h.c r13) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.h.H0(c0.g$r, c0.h$c):void");
    }

    private void I(g.m0 m0Var, g.m0 m0Var2) {
        if (m0Var.f1859m == null) {
            m0Var.f1859m = m0Var2.f1859m;
        }
        if (m0Var.f1860n == null) {
            m0Var.f1860n = m0Var2.f1860n;
        }
        if (m0Var.f1861o == null) {
            m0Var.f1861o = m0Var2.f1861o;
        }
        if (m0Var.f1862p == null) {
            m0Var.f1862p = m0Var2.f1862p;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void I0(c0.g.l r10) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.h.I0(c0.g$l):void");
    }

    private void J(g.q0 q0Var, g.q0 q0Var2) {
        if (q0Var.f1878m == null) {
            q0Var.f1878m = q0Var2.f1878m;
        }
        if (q0Var.f1879n == null) {
            q0Var.f1879n = q0Var2.f1879n;
        }
        if (q0Var.f1880o == null) {
            q0Var.f1880o = q0Var2.f1880o;
        }
        if (q0Var.f1881p == null) {
            q0Var.f1881p = q0Var2.f1881p;
        }
        if (q0Var.f1882q == null) {
            q0Var.f1882q = q0Var2.f1882q;
        }
    }

    private void J0(g.s sVar, g.k0 k0Var, g.b bVar) {
        float f3;
        float f4;
        y("Mask render", new Object[0]);
        Boolean bool = sVar.f1890o;
        boolean z3 = true;
        if (bool != null && bool.booleanValue()) {
            g.p pVar = sVar.f1894s;
            f3 = pVar != null ? pVar.e(this) : bVar.f1726c;
            g.p pVar2 = sVar.f1895t;
            f4 = pVar2 != null ? pVar2.f(this) : bVar.f1727d;
        } else {
            g.p pVar3 = sVar.f1894s;
            float d3 = pVar3 != null ? pVar3.d(this, 1.0f) : 1.2f;
            g.p pVar4 = sVar.f1895t;
            float d4 = pVar4 != null ? pVar4.d(this, 1.0f) : 1.2f;
            f3 = d3 * bVar.f1726c;
            f4 = d4 * bVar.f1727d;
        }
        if (f3 == BitmapDescriptorFactory.HUE_RED || f4 == BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        S0();
        C0045h M = M(sVar);
        this.f1924d = M;
        M.f1960a.f1767p = Float.valueOf(1.0f);
        boolean m02 = m0();
        this.f1921a.save();
        Boolean bool2 = sVar.f1891p;
        if (bool2 != null && !bool2.booleanValue()) {
            z3 = false;
        }
        if (!z3) {
            this.f1921a.translate(bVar.f1724a, bVar.f1725b);
            this.f1921a.scale(bVar.f1726c, bVar.f1727d);
        }
        F0(sVar, false);
        this.f1921a.restore();
        if (m02) {
            k0(k0Var, bVar);
        }
        R0();
    }

    private void K(g.y yVar, String str) {
        g.n0 n3 = yVar.f1863a.n(str);
        if (n3 == null) {
            Z0("Pattern reference '%s' not found", str);
            return;
        }
        if (!(n3 instanceof g.y)) {
            F("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (n3 == yVar) {
            F("Circular reference in pattern href attribute '%s'", str);
            return;
        }
        g.y yVar2 = (g.y) n3;
        if (yVar.f1908q == null) {
            yVar.f1908q = yVar2.f1908q;
        }
        if (yVar.f1909r == null) {
            yVar.f1909r = yVar2.f1909r;
        }
        if (yVar.f1910s == null) {
            yVar.f1910s = yVar2.f1910s;
        }
        if (yVar.f1911t == null) {
            yVar.f1911t = yVar2.f1911t;
        }
        if (yVar.f1912u == null) {
            yVar.f1912u = yVar2.f1912u;
        }
        if (yVar.f1913v == null) {
            yVar.f1913v = yVar2.f1913v;
        }
        if (yVar.f1914w == null) {
            yVar.f1914w = yVar2.f1914w;
        }
        if (yVar.f1827i.isEmpty()) {
            yVar.f1827i = yVar2.f1827i;
        }
        if (yVar.f1889p == null) {
            yVar.f1889p = yVar2.f1889p;
        }
        if (yVar.f1873o == null) {
            yVar.f1873o = yVar2.f1873o;
        }
        String str2 = yVar2.f1915x;
        if (str2 != null) {
            K(yVar, str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void K0(g.s0 s0Var) {
        Set<String> b4;
        String language = Locale.getDefault().getLanguage();
        c0.g.g();
        for (g.n0 n0Var : s0Var.a()) {
            if (n0Var instanceof g.g0) {
                g.g0 g0Var = (g.g0) n0Var;
                if (g0Var.d() == null && ((b4 = g0Var.b()) == null || (!b4.isEmpty() && b4.contains(language)))) {
                    Set<String> requiredFeatures = g0Var.getRequiredFeatures();
                    if (requiredFeatures != null) {
                        if (f1920i == null) {
                            V();
                        }
                        if (!requiredFeatures.isEmpty() && f1920i.containsAll(requiredFeatures)) {
                        }
                    }
                    Set<String> l3 = g0Var.l();
                    if (l3 != null) {
                        l3.isEmpty();
                    } else {
                        Set<String> m3 = g0Var.m();
                        if (m3 == null) {
                            A0(n0Var);
                            return;
                        }
                        m3.isEmpty();
                    }
                }
            }
        }
    }

    private void L(g.k0 k0Var, Path path, g.y yVar) {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        Boolean bool = yVar.f1908q;
        boolean z3 = bool != null && bool.booleanValue();
        String str = yVar.f1915x;
        if (str != null) {
            K(yVar, str);
        }
        if (z3) {
            g.p pVar = yVar.f1911t;
            f3 = pVar != null ? pVar.e(this) : BitmapDescriptorFactory.HUE_RED;
            g.p pVar2 = yVar.f1912u;
            f5 = pVar2 != null ? pVar2.f(this) : BitmapDescriptorFactory.HUE_RED;
            g.p pVar3 = yVar.f1913v;
            f6 = pVar3 != null ? pVar3.e(this) : BitmapDescriptorFactory.HUE_RED;
            g.p pVar4 = yVar.f1914w;
            f4 = pVar4 != null ? pVar4.f(this) : BitmapDescriptorFactory.HUE_RED;
        } else {
            g.p pVar5 = yVar.f1911t;
            float d3 = pVar5 != null ? pVar5.d(this, 1.0f) : BitmapDescriptorFactory.HUE_RED;
            g.p pVar6 = yVar.f1912u;
            float d4 = pVar6 != null ? pVar6.d(this, 1.0f) : BitmapDescriptorFactory.HUE_RED;
            g.p pVar7 = yVar.f1913v;
            float d5 = pVar7 != null ? pVar7.d(this, 1.0f) : BitmapDescriptorFactory.HUE_RED;
            g.p pVar8 = yVar.f1914w;
            float d6 = pVar8 != null ? pVar8.d(this, 1.0f) : BitmapDescriptorFactory.HUE_RED;
            g.b bVar = k0Var.f1851h;
            float f8 = bVar.f1724a;
            float f9 = bVar.f1726c;
            f3 = (d3 * f9) + f8;
            float f10 = bVar.f1725b;
            float f11 = bVar.f1727d;
            float f12 = d5 * f9;
            f4 = d6 * f11;
            f5 = (d4 * f11) + f10;
            f6 = f12;
        }
        if (f6 == BitmapDescriptorFactory.HUE_RED || f4 == BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        c0.e eVar = yVar.f1873o;
        if (eVar == null) {
            eVar = c0.e.f1683e;
        }
        S0();
        this.f1921a.clipPath(path);
        C0045h c0045h = new C0045h();
        V0(c0045h, g.e0.a());
        c0045h.f1960a.f1776y = Boolean.FALSE;
        this.f1924d = N(yVar, c0045h);
        g.b bVar2 = k0Var.f1851h;
        Matrix matrix = yVar.f1910s;
        if (matrix != null) {
            this.f1921a.concat(matrix);
            Matrix matrix2 = new Matrix();
            if (yVar.f1910s.invert(matrix2)) {
                g.b bVar3 = k0Var.f1851h;
                g.b bVar4 = k0Var.f1851h;
                g.b bVar5 = k0Var.f1851h;
                float[] fArr = {bVar3.f1724a, bVar3.f1725b, bVar3.b(), bVar4.f1725b, bVar4.b(), k0Var.f1851h.c(), bVar5.f1724a, bVar5.c()};
                matrix2.mapPoints(fArr);
                float f13 = fArr[0];
                float f14 = fArr[1];
                RectF rectF = new RectF(f13, f14, f13, f14);
                for (int i3 = 2; i3 <= 6; i3 += 2) {
                    float f15 = fArr[i3];
                    if (f15 < rectF.left) {
                        rectF.left = f15;
                    }
                    if (f15 > rectF.right) {
                        rectF.right = f15;
                    }
                    float f16 = fArr[i3 + 1];
                    if (f16 < rectF.top) {
                        rectF.top = f16;
                    }
                    if (f16 > rectF.bottom) {
                        rectF.bottom = f16;
                    }
                }
                float f17 = rectF.left;
                float f18 = rectF.top;
                bVar2 = new g.b(f17, f18, rectF.right - f17, rectF.bottom - f18);
            }
        }
        float floor = f3 + (((float) Math.floor((bVar2.f1724a - f3) / f6)) * f6);
        float b4 = bVar2.b();
        float c3 = bVar2.c();
        g.b bVar6 = new g.b(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f6, f4);
        boolean m02 = m0();
        for (float floor2 = f5 + (((float) Math.floor((bVar2.f1725b - f5) / f4)) * f4); floor2 < c3; floor2 += f4) {
            float f19 = floor;
            while (f19 < b4) {
                bVar6.f1724a = f19;
                bVar6.f1725b = floor2;
                S0();
                if (this.f1924d.f1960a.f1776y.booleanValue()) {
                    f7 = floor;
                } else {
                    f7 = floor;
                    O0(bVar6.f1724a, bVar6.f1725b, bVar6.f1726c, bVar6.f1727d);
                }
                g.b bVar7 = yVar.f1889p;
                if (bVar7 != null) {
                    this.f1921a.concat(o(bVar6, bVar7, eVar));
                } else {
                    Boolean bool2 = yVar.f1909r;
                    boolean z4 = bool2 == null || bool2.booleanValue();
                    this.f1921a.translate(f19, floor2);
                    if (!z4) {
                        Canvas canvas = this.f1921a;
                        g.b bVar8 = k0Var.f1851h;
                        canvas.scale(bVar8.f1726c, bVar8.f1727d);
                    }
                }
                Iterator<g.n0> it = yVar.f1827i.iterator();
                while (it.hasNext()) {
                    A0(it.next());
                }
                R0();
                f19 += f6;
                floor = f7;
            }
        }
        if (m02) {
            j0(yVar);
        }
        R0();
    }

    private void L0(g.z0 z0Var) {
        y("TextPath render", new Object[0]);
        W0(this.f1924d, z0Var);
        if (A() && Y0()) {
            g.n0 n3 = z0Var.f1863a.n(z0Var.f1917o);
            if (n3 == null) {
                F("TextPath reference '%s' not found", z0Var.f1917o);
                return;
            }
            g.v vVar = (g.v) n3;
            Path d3 = new d(vVar.f1900o).d();
            Matrix matrix = vVar.f1852n;
            if (matrix != null) {
                d3.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(d3, false);
            g.p pVar = z0Var.f1918p;
            float d4 = pVar != null ? pVar.d(this, pathMeasure.getLength()) : BitmapDescriptorFactory.HUE_RED;
            g.e0.f O = O();
            if (O != g.e0.f.Start) {
                float n4 = n(z0Var);
                if (O == g.e0.f.Middle) {
                    n4 /= 2.0f;
                }
                d4 -= n4;
            }
            r((g.k0) z0Var.f());
            boolean m02 = m0();
            E(z0Var, new e(d3, d4, BitmapDescriptorFactory.HUE_RED));
            if (m02) {
                j0(z0Var);
            }
        }
    }

    private C0045h M(g.n0 n0Var) {
        C0045h c0045h = new C0045h();
        V0(c0045h, g.e0.a());
        return N(n0Var, c0045h);
    }

    private boolean M0() {
        return this.f1924d.f1960a.f1767p.floatValue() < 1.0f || this.f1924d.f1960a.J != null;
    }

    private C0045h N(g.n0 n0Var, C0045h c0045h) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (n0Var instanceof g.l0) {
                arrayList.add(0, (g.l0) n0Var);
            }
            Object obj = n0Var.f1864b;
            if (obj == null) {
                break;
            }
            n0Var = (g.n0) obj;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            W0(c0045h, (g.l0) it.next());
        }
        C0045h c0045h2 = this.f1924d;
        c0045h.f1966g = c0045h2.f1966g;
        c0045h.f1965f = c0045h2.f1965f;
        return c0045h;
    }

    private void N0() {
        this.f1924d = new C0045h();
        this.f1925e = new Stack<>();
        V0(this.f1924d, g.e0.a());
        C0045h c0045h = this.f1924d;
        c0045h.f1965f = null;
        c0045h.f1967h = false;
        this.f1925e.push(new C0045h(c0045h));
        this.f1927g = new Stack<>();
        this.f1926f = new Stack<>();
    }

    private g.e0.f O() {
        g.e0.f fVar;
        g.e0 e0Var = this.f1924d.f1960a;
        if (e0Var.f1774w == g.e0.h.LTR || (fVar = e0Var.f1775x) == g.e0.f.Middle) {
            return e0Var.f1775x;
        }
        g.e0.f fVar2 = g.e0.f.Start;
        return fVar == fVar2 ? g.e0.f.End : fVar2;
    }

    private void O0(float f3, float f4, float f5, float f6) {
        float f7 = f5 + f3;
        float f8 = f6 + f4;
        g.c cVar = this.f1924d.f1960a.f1777z;
        if (cVar != null) {
            f3 += cVar.f1737d.e(this);
            f4 += this.f1924d.f1960a.f1777z.f1734a.f(this);
            f7 -= this.f1924d.f1960a.f1777z.f1735b.e(this);
            f8 -= this.f1924d.f1960a.f1777z.f1736c.f(this);
        }
        this.f1921a.clipRect(f3, f4, f7, f8);
    }

    private Path.FillType P() {
        g.e0.a aVar = this.f1924d.f1960a.I;
        return (aVar == null || aVar != g.e0.a.EvenOdd) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    private void P0(C0045h c0045h, boolean z3, g.o0 o0Var) {
        g.f fVar;
        g.e0 e0Var = c0045h.f1960a;
        float floatValue = (z3 ? e0Var.f1758g : e0Var.f1760i).floatValue();
        if (o0Var instanceof g.f) {
            fVar = (g.f) o0Var;
        } else if (!(o0Var instanceof g.C0044g)) {
            return;
        } else {
            fVar = c0045h.f1960a.f1768q;
        }
        (z3 ? c0045h.f1963d : c0045h.f1964e).setColor(x(fVar.f1820c, floatValue));
    }

    private void Q0(boolean z3, g.c0 c0Var) {
        C0045h c0045h;
        g.o0 o0Var;
        boolean W = W(c0Var.f1855e, 2147483648L);
        if (z3) {
            if (W) {
                C0045h c0045h2 = this.f1924d;
                g.e0 e0Var = c0045h2.f1960a;
                g.o0 o0Var2 = c0Var.f1855e.K;
                e0Var.f1756d = o0Var2;
                c0045h2.f1961b = o0Var2 != null;
            }
            if (W(c0Var.f1855e, 4294967296L)) {
                this.f1924d.f1960a.f1758g = c0Var.f1855e.L;
            }
            if (!W(c0Var.f1855e, 6442450944L)) {
                return;
            }
            c0045h = this.f1924d;
            o0Var = c0045h.f1960a.f1756d;
        } else {
            if (W) {
                C0045h c0045h3 = this.f1924d;
                g.e0 e0Var2 = c0045h3.f1960a;
                g.o0 o0Var3 = c0Var.f1855e.K;
                e0Var2.f1759h = o0Var3;
                c0045h3.f1962c = o0Var3 != null;
            }
            if (W(c0Var.f1855e, 4294967296L)) {
                this.f1924d.f1960a.f1760i = c0Var.f1855e.L;
            }
            if (!W(c0Var.f1855e, 6442450944L)) {
                return;
            }
            c0045h = this.f1924d;
            o0Var = c0045h.f1960a.f1759h;
        }
        P0(c0045h, z3, o0Var);
    }

    private void R0() {
        this.f1921a.restore();
        this.f1924d = this.f1925e.pop();
    }

    private void S0() {
        this.f1921a.save();
        this.f1925e.push(this.f1924d);
        this.f1924d = new C0045h(this.f1924d);
    }

    private String T0(String str, boolean z3, boolean z4) {
        String str2;
        if (this.f1924d.f1967h) {
            str2 = "[\\n\\t]";
        } else {
            str = str.replaceAll("\\n", "").replaceAll("\\t", " ");
            if (z3) {
                str = str.replaceAll("^\\s+", "");
            }
            if (z4) {
                str = str.replaceAll("\\s+$", "");
            }
            str2 = "\\s{2,}";
        }
        return str.replaceAll(str2, " ");
    }

    private Path.FillType U() {
        g.e0.a aVar = this.f1924d.f1960a.f1757f;
        return (aVar == null || aVar != g.e0.a.EvenOdd) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    private void U0(g.k0 k0Var) {
        if (k0Var.f1864b == null || k0Var.f1851h == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.f1927g.peek().invert(matrix)) {
            g.b bVar = k0Var.f1851h;
            g.b bVar2 = k0Var.f1851h;
            g.b bVar3 = k0Var.f1851h;
            float[] fArr = {bVar.f1724a, bVar.f1725b, bVar.b(), bVar2.f1725b, bVar2.b(), k0Var.f1851h.c(), bVar3.f1724a, bVar3.c()};
            matrix.preConcat(this.f1921a.getMatrix());
            matrix.mapPoints(fArr);
            float f3 = fArr[0];
            float f4 = fArr[1];
            RectF rectF = new RectF(f3, f4, f3, f4);
            for (int i3 = 2; i3 <= 6; i3 += 2) {
                float f5 = fArr[i3];
                if (f5 < rectF.left) {
                    rectF.left = f5;
                }
                if (f5 > rectF.right) {
                    rectF.right = f5;
                }
                float f6 = fArr[i3 + 1];
                if (f6 < rectF.top) {
                    rectF.top = f6;
                }
                if (f6 > rectF.bottom) {
                    rectF.bottom = f6;
                }
            }
            g.k0 k0Var2 = (g.k0) this.f1926f.peek();
            g.b bVar4 = k0Var2.f1851h;
            if (bVar4 == null) {
                k0Var2.f1851h = g.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                bVar4.d(g.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    private static synchronized void V() {
        synchronized (h.class) {
            HashSet<String> hashSet = new HashSet<>();
            f1920i = hashSet;
            hashSet.add("Structure");
            f1920i.add("BasicStructure");
            f1920i.add("ConditionalProcessing");
            f1920i.add("Image");
            f1920i.add("Style");
            f1920i.add("ViewportAttribute");
            f1920i.add("Shape");
            f1920i.add("BasicText");
            f1920i.add("PaintAttribute");
            f1920i.add("BasicPaintAttribute");
            f1920i.add("OpacityAttribute");
            f1920i.add("BasicGraphicsAttribute");
            f1920i.add("Marker");
            f1920i.add("Gradient");
            f1920i.add("Pattern");
            f1920i.add("Clip");
            f1920i.add("BasicClip");
            f1920i.add("Mask");
            f1920i.add("View");
        }
    }

    private void V0(C0045h c0045h, g.e0 e0Var) {
        g.e0 e0Var2;
        Integer num;
        int intValue;
        Paint paint;
        Paint.Join join;
        Paint paint2;
        Paint.Cap cap;
        if (W(e0Var, 4096L)) {
            c0045h.f1960a.f1768q = e0Var.f1768q;
        }
        if (W(e0Var, 2048L)) {
            c0045h.f1960a.f1767p = e0Var.f1767p;
        }
        if (W(e0Var, 1L)) {
            c0045h.f1960a.f1756d = e0Var.f1756d;
            g.o0 o0Var = e0Var.f1756d;
            c0045h.f1961b = (o0Var == null || o0Var == g.f.f1819f) ? false : true;
        }
        if (W(e0Var, 4L)) {
            c0045h.f1960a.f1758g = e0Var.f1758g;
        }
        if (W(e0Var, 6149L)) {
            P0(c0045h, true, c0045h.f1960a.f1756d);
        }
        if (W(e0Var, 2L)) {
            c0045h.f1960a.f1757f = e0Var.f1757f;
        }
        if (W(e0Var, 8L)) {
            c0045h.f1960a.f1759h = e0Var.f1759h;
            g.o0 o0Var2 = e0Var.f1759h;
            c0045h.f1962c = (o0Var2 == null || o0Var2 == g.f.f1819f) ? false : true;
        }
        if (W(e0Var, 16L)) {
            c0045h.f1960a.f1760i = e0Var.f1760i;
        }
        if (W(e0Var, 6168L)) {
            P0(c0045h, false, c0045h.f1960a.f1759h);
        }
        if (W(e0Var, 34359738368L)) {
            c0045h.f1960a.O = e0Var.O;
        }
        if (W(e0Var, 32L)) {
            g.e0 e0Var3 = c0045h.f1960a;
            g.p pVar = e0Var.f1761j;
            e0Var3.f1761j = pVar;
            c0045h.f1964e.setStrokeWidth(pVar.c(this));
        }
        if (W(e0Var, 64L)) {
            c0045h.f1960a.f1762k = e0Var.f1762k;
            int i3 = a.f1930b[e0Var.f1762k.ordinal()];
            if (i3 == 1) {
                paint2 = c0045h.f1964e;
                cap = Paint.Cap.BUTT;
            } else if (i3 == 2) {
                paint2 = c0045h.f1964e;
                cap = Paint.Cap.ROUND;
            } else if (i3 == 3) {
                paint2 = c0045h.f1964e;
                cap = Paint.Cap.SQUARE;
            }
            paint2.setStrokeCap(cap);
        }
        if (W(e0Var, 128L)) {
            c0045h.f1960a.f1763l = e0Var.f1763l;
            int i4 = a.f1931c[e0Var.f1763l.ordinal()];
            if (i4 == 1) {
                paint = c0045h.f1964e;
                join = Paint.Join.MITER;
            } else if (i4 == 2) {
                paint = c0045h.f1964e;
                join = Paint.Join.ROUND;
            } else if (i4 == 3) {
                paint = c0045h.f1964e;
                join = Paint.Join.BEVEL;
            }
            paint.setStrokeJoin(join);
        }
        if (W(e0Var, 256L)) {
            c0045h.f1960a.f1764m = e0Var.f1764m;
            c0045h.f1964e.setStrokeMiter(e0Var.f1764m.floatValue());
        }
        if (W(e0Var, 512L)) {
            c0045h.f1960a.f1765n = e0Var.f1765n;
        }
        if (W(e0Var, FileUtils.ONE_KB)) {
            c0045h.f1960a.f1766o = e0Var.f1766o;
        }
        Typeface typeface = null;
        if (W(e0Var, 1536L)) {
            g.p[] pVarArr = c0045h.f1960a.f1765n;
            if (pVarArr != null) {
                int length = pVarArr.length;
                int i5 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i5];
                float f3 = BitmapDescriptorFactory.HUE_RED;
                for (int i6 = 0; i6 < i5; i6++) {
                    float c3 = c0045h.f1960a.f1765n[i6 % length].c(this);
                    fArr[i6] = c3;
                    f3 += c3;
                }
                if (f3 != BitmapDescriptorFactory.HUE_RED) {
                    float c4 = c0045h.f1960a.f1766o.c(this);
                    if (c4 < BitmapDescriptorFactory.HUE_RED) {
                        c4 = (c4 % f3) + f3;
                    }
                    c0045h.f1964e.setPathEffect(new DashPathEffect(fArr, c4));
                }
            }
            c0045h.f1964e.setPathEffect(null);
        }
        if (W(e0Var, 16384L)) {
            float Q = Q();
            c0045h.f1960a.f1770s = e0Var.f1770s;
            c0045h.f1963d.setTextSize(e0Var.f1770s.d(this, Q));
            c0045h.f1964e.setTextSize(e0Var.f1770s.d(this, Q));
        }
        if (W(e0Var, 8192L)) {
            c0045h.f1960a.f1769r = e0Var.f1769r;
        }
        if (W(e0Var, 32768L)) {
            if (e0Var.f1771t.intValue() == -1 && c0045h.f1960a.f1771t.intValue() > 100) {
                e0Var2 = c0045h.f1960a;
                intValue = e0Var2.f1771t.intValue() - 100;
            } else if (e0Var.f1771t.intValue() != 1 || c0045h.f1960a.f1771t.intValue() >= 900) {
                e0Var2 = c0045h.f1960a;
                num = e0Var.f1771t;
                e0Var2.f1771t = num;
            } else {
                e0Var2 = c0045h.f1960a;
                intValue = e0Var2.f1771t.intValue() + 100;
            }
            num = Integer.valueOf(intValue);
            e0Var2.f1771t = num;
        }
        if (W(e0Var, 65536L)) {
            c0045h.f1960a.f1772u = e0Var.f1772u;
        }
        if (W(e0Var, 106496L)) {
            if (c0045h.f1960a.f1769r != null && this.f1923c != null) {
                c0.g.g();
                for (String str : c0045h.f1960a.f1769r) {
                    g.e0 e0Var4 = c0045h.f1960a;
                    typeface = t(str, e0Var4.f1771t, e0Var4.f1772u);
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                g.e0 e0Var5 = c0045h.f1960a;
                typeface = t("serif", e0Var5.f1771t, e0Var5.f1772u);
            }
            c0045h.f1963d.setTypeface(typeface);
            c0045h.f1964e.setTypeface(typeface);
        }
        if (W(e0Var, 131072L)) {
            c0045h.f1960a.f1773v = e0Var.f1773v;
            Paint paint3 = c0045h.f1963d;
            g.e0.EnumC0043g enumC0043g = e0Var.f1773v;
            g.e0.EnumC0043g enumC0043g2 = g.e0.EnumC0043g.LineThrough;
            paint3.setStrikeThruText(enumC0043g == enumC0043g2);
            Paint paint4 = c0045h.f1963d;
            g.e0.EnumC0043g enumC0043g3 = e0Var.f1773v;
            g.e0.EnumC0043g enumC0043g4 = g.e0.EnumC0043g.Underline;
            paint4.setUnderlineText(enumC0043g3 == enumC0043g4);
            c0045h.f1964e.setStrikeThruText(e0Var.f1773v == enumC0043g2);
            c0045h.f1964e.setUnderlineText(e0Var.f1773v == enumC0043g4);
        }
        if (W(e0Var, 68719476736L)) {
            c0045h.f1960a.f1774w = e0Var.f1774w;
        }
        if (W(e0Var, 262144L)) {
            c0045h.f1960a.f1775x = e0Var.f1775x;
        }
        if (W(e0Var, 524288L)) {
            c0045h.f1960a.f1776y = e0Var.f1776y;
        }
        if (W(e0Var, 2097152L)) {
            c0045h.f1960a.A = e0Var.A;
        }
        if (W(e0Var, 4194304L)) {
            c0045h.f1960a.B = e0Var.B;
        }
        if (W(e0Var, 8388608L)) {
            c0045h.f1960a.C = e0Var.C;
        }
        if (W(e0Var, 16777216L)) {
            c0045h.f1960a.D = e0Var.D;
        }
        if (W(e0Var, 33554432L)) {
            c0045h.f1960a.E = e0Var.E;
        }
        if (W(e0Var, FileUtils.ONE_MB)) {
            c0045h.f1960a.f1777z = e0Var.f1777z;
        }
        if (W(e0Var, 268435456L)) {
            c0045h.f1960a.H = e0Var.H;
        }
        if (W(e0Var, 536870912L)) {
            c0045h.f1960a.I = e0Var.I;
        }
        if (W(e0Var, FileUtils.ONE_GB)) {
            c0045h.f1960a.J = e0Var.J;
        }
        if (W(e0Var, 67108864L)) {
            c0045h.f1960a.F = e0Var.F;
        }
        if (W(e0Var, 134217728L)) {
            c0045h.f1960a.G = e0Var.G;
        }
        if (W(e0Var, 8589934592L)) {
            c0045h.f1960a.M = e0Var.M;
        }
        if (W(e0Var, 17179869184L)) {
            c0045h.f1960a.N = e0Var.N;
        }
        if (W(e0Var, 137438953472L)) {
            c0045h.f1960a.P = e0Var.P;
        }
    }

    private boolean W(g.e0 e0Var, long j3) {
        return (e0Var.f1755c & j3) != 0;
    }

    private void W0(C0045h c0045h, g.l0 l0Var) {
        c0045h.f1960a.b(l0Var.f1864b == null);
        g.e0 e0Var = l0Var.f1855e;
        if (e0Var != null) {
            V0(c0045h, e0Var);
        }
        if (this.f1923c.j()) {
            for (b.p pVar : this.f1923c.d()) {
                if (c0.b.l(this.f1928h, pVar.f1662a, l0Var)) {
                    V0(c0045h, pVar.f1663b);
                }
            }
        }
        g.e0 e0Var2 = l0Var.f1856f;
        if (e0Var2 != null) {
            V0(c0045h, e0Var2);
        }
    }

    private void X(boolean z3, g.b bVar, g.m0 m0Var) {
        float f3;
        float d3;
        float f4;
        float f5;
        String str = m0Var.f1846l;
        if (str != null) {
            H(m0Var, str);
        }
        Boolean bool = m0Var.f1843i;
        int i3 = 0;
        boolean z4 = bool != null && bool.booleanValue();
        C0045h c0045h = this.f1924d;
        Paint paint = z3 ? c0045h.f1963d : c0045h.f1964e;
        if (z4) {
            g.b S = S();
            g.p pVar = m0Var.f1859m;
            float e3 = pVar != null ? pVar.e(this) : BitmapDescriptorFactory.HUE_RED;
            g.p pVar2 = m0Var.f1860n;
            float f6 = pVar2 != null ? pVar2.f(this) : BitmapDescriptorFactory.HUE_RED;
            g.p pVar3 = m0Var.f1861o;
            float e4 = pVar3 != null ? pVar3.e(this) : S.f1726c;
            g.p pVar4 = m0Var.f1862p;
            f5 = e4;
            f3 = e3;
            f4 = f6;
            d3 = pVar4 != null ? pVar4.f(this) : BitmapDescriptorFactory.HUE_RED;
        } else {
            g.p pVar5 = m0Var.f1859m;
            float d4 = pVar5 != null ? pVar5.d(this, 1.0f) : BitmapDescriptorFactory.HUE_RED;
            g.p pVar6 = m0Var.f1860n;
            float d5 = pVar6 != null ? pVar6.d(this, 1.0f) : BitmapDescriptorFactory.HUE_RED;
            g.p pVar7 = m0Var.f1861o;
            float d6 = pVar7 != null ? pVar7.d(this, 1.0f) : 1.0f;
            g.p pVar8 = m0Var.f1862p;
            f3 = d4;
            d3 = pVar8 != null ? pVar8.d(this, 1.0f) : BitmapDescriptorFactory.HUE_RED;
            f4 = d5;
            f5 = d6;
        }
        S0();
        this.f1924d = M(m0Var);
        Matrix matrix = new Matrix();
        if (!z4) {
            matrix.preTranslate(bVar.f1724a, bVar.f1725b);
            matrix.preScale(bVar.f1726c, bVar.f1727d);
        }
        Matrix matrix2 = m0Var.f1844j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = m0Var.f1842h.size();
        if (size == 0) {
            R0();
            C0045h c0045h2 = this.f1924d;
            if (z3) {
                c0045h2.f1961b = false;
                return;
            } else {
                c0045h2.f1962c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        float f7 = -1.0f;
        Iterator<g.n0> it = m0Var.f1842h.iterator();
        while (it.hasNext()) {
            g.d0 d0Var = (g.d0) it.next();
            Float f8 = d0Var.f1743h;
            float floatValue = f8 != null ? f8.floatValue() : BitmapDescriptorFactory.HUE_RED;
            if (i3 == 0 || floatValue >= f7) {
                fArr[i3] = floatValue;
                f7 = floatValue;
            } else {
                fArr[i3] = f7;
            }
            S0();
            W0(this.f1924d, d0Var);
            g.e0 e0Var = this.f1924d.f1960a;
            g.f fVar = (g.f) e0Var.F;
            if (fVar == null) {
                fVar = g.f.f1818d;
            }
            iArr[i3] = x(fVar.f1820c, e0Var.G.floatValue());
            i3++;
            R0();
        }
        if ((f3 == f5 && f4 == d3) || size == 1) {
            R0();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        g.k kVar = m0Var.f1845k;
        if (kVar != null) {
            if (kVar == g.k.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (kVar == g.k.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        R0();
        LinearGradient linearGradient = new LinearGradient(f3, f4, f5, d3, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setAlpha(w(this.f1924d.f1960a.f1758g.floatValue()));
    }

    private void X0() {
        g.f fVar;
        g.e0 e0Var = this.f1924d.f1960a;
        g.o0 o0Var = e0Var.M;
        if (o0Var instanceof g.f) {
            fVar = (g.f) o0Var;
        } else if (!(o0Var instanceof g.C0044g)) {
            return;
        } else {
            fVar = e0Var.f1768q;
        }
        int i3 = fVar.f1820c;
        Float f3 = e0Var.N;
        if (f3 != null) {
            i3 = x(i3, f3.floatValue());
        }
        this.f1921a.drawColor(i3);
    }

    private Path Y(g.d dVar) {
        g.p pVar = dVar.f1740o;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float e3 = pVar != null ? pVar.e(this) : BitmapDescriptorFactory.HUE_RED;
        g.p pVar2 = dVar.f1741p;
        if (pVar2 != null) {
            f3 = pVar2.f(this);
        }
        float c3 = dVar.f1742q.c(this);
        float f4 = e3 - c3;
        float f5 = f3 - c3;
        float f6 = e3 + c3;
        float f7 = f3 + c3;
        if (dVar.f1851h == null) {
            float f8 = 2.0f * c3;
            dVar.f1851h = new g.b(f4, f5, f8, f8);
        }
        float f9 = 0.5522848f * c3;
        Path path = new Path();
        path.moveTo(e3, f5);
        float f10 = e3 + f9;
        float f11 = f3 - f9;
        path.cubicTo(f10, f5, f6, f11, f6, f3);
        float f12 = f3 + f9;
        path.cubicTo(f6, f12, f10, f7, e3, f7);
        float f13 = e3 - f9;
        path.cubicTo(f13, f7, f4, f12, f4, f3);
        path.cubicTo(f4, f11, f13, f5, e3, f5);
        path.close();
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y0() {
        Boolean bool = this.f1924d.f1960a.E;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private Path Z(g.i iVar) {
        g.p pVar = iVar.f1833o;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float e3 = pVar != null ? pVar.e(this) : BitmapDescriptorFactory.HUE_RED;
        g.p pVar2 = iVar.f1834p;
        if (pVar2 != null) {
            f3 = pVar2.f(this);
        }
        float e4 = iVar.f1835q.e(this);
        float f4 = iVar.f1836r.f(this);
        float f5 = e3 - e4;
        float f6 = f3 - f4;
        float f7 = e3 + e4;
        float f8 = f3 + f4;
        if (iVar.f1851h == null) {
            iVar.f1851h = new g.b(f5, f6, e4 * 2.0f, 2.0f * f4);
        }
        float f9 = e4 * 0.5522848f;
        float f10 = 0.5522848f * f4;
        Path path = new Path();
        path.moveTo(e3, f6);
        float f11 = e3 + f9;
        float f12 = f3 - f10;
        path.cubicTo(f11, f6, f7, f12, f7, f3);
        float f13 = f10 + f3;
        path.cubicTo(f7, f13, f11, f8, e3, f8);
        float f14 = e3 - f9;
        path.cubicTo(f14, f8, f5, f13, f5, f3);
        path.cubicTo(f5, f12, f14, f6, e3, f6);
        path.close();
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Z0(String str, Object... objArr) {
        Log.w("SVGAndroidRenderer", String.format(str, objArr));
    }

    private Path a0(g.q qVar) {
        g.p pVar = qVar.f1874o;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float e3 = pVar == null ? BitmapDescriptorFactory.HUE_RED : pVar.e(this);
        g.p pVar2 = qVar.f1875p;
        float f4 = pVar2 == null ? BitmapDescriptorFactory.HUE_RED : pVar2.f(this);
        g.p pVar3 = qVar.f1876q;
        float e4 = pVar3 == null ? BitmapDescriptorFactory.HUE_RED : pVar3.e(this);
        g.p pVar4 = qVar.f1877r;
        if (pVar4 != null) {
            f3 = pVar4.f(this);
        }
        if (qVar.f1851h == null) {
            qVar.f1851h = new g.b(Math.min(e3, e4), Math.min(f4, f3), Math.abs(e4 - e3), Math.abs(f3 - f4));
        }
        Path path = new Path();
        path.moveTo(e3, f4);
        path.lineTo(e4, f3);
        return path;
    }

    private Path b0(g.z zVar) {
        Path path = new Path();
        float[] fArr = zVar.f1916o;
        path.moveTo(fArr[0], fArr[1]);
        int i3 = 2;
        while (true) {
            float[] fArr2 = zVar.f1916o;
            if (i3 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i3], fArr2[i3 + 1]);
            i3 += 2;
        }
        if (zVar instanceof g.a0) {
            path.close();
        }
        if (zVar.f1851h == null) {
            zVar.f1851h = m(path);
        }
        return path;
    }

    private Path c0(g.b0 b0Var) {
        float e3;
        float f3;
        Path path;
        g.p pVar = b0Var.f1732s;
        if (pVar == null && b0Var.f1733t == null) {
            e3 = BitmapDescriptorFactory.HUE_RED;
            f3 = BitmapDescriptorFactory.HUE_RED;
        } else {
            if (pVar == null) {
                e3 = b0Var.f1733t.f(this);
            } else {
                g.p pVar2 = b0Var.f1733t;
                e3 = pVar.e(this);
                if (pVar2 != null) {
                    f3 = b0Var.f1733t.f(this);
                }
            }
            f3 = e3;
        }
        float min = Math.min(e3, b0Var.f1730q.e(this) / 2.0f);
        float min2 = Math.min(f3, b0Var.f1731r.f(this) / 2.0f);
        g.p pVar3 = b0Var.f1728o;
        float e4 = pVar3 != null ? pVar3.e(this) : BitmapDescriptorFactory.HUE_RED;
        g.p pVar4 = b0Var.f1729p;
        float f4 = pVar4 != null ? pVar4.f(this) : BitmapDescriptorFactory.HUE_RED;
        float e5 = b0Var.f1730q.e(this);
        float f5 = b0Var.f1731r.f(this);
        if (b0Var.f1851h == null) {
            b0Var.f1851h = new g.b(e4, f4, e5, f5);
        }
        float f6 = e4 + e5;
        float f7 = f4 + f5;
        Path path2 = new Path();
        if (min == BitmapDescriptorFactory.HUE_RED || min2 == BitmapDescriptorFactory.HUE_RED) {
            path = path2;
            path.moveTo(e4, f4);
            path.lineTo(f6, f4);
            path.lineTo(f6, f7);
            path.lineTo(e4, f7);
        } else {
            float f8 = min * 0.5522848f;
            float f9 = 0.5522848f * min2;
            float f10 = f4 + min2;
            path2.moveTo(e4, f10);
            float f11 = f10 - f9;
            float f12 = e4 + min;
            float f13 = f12 - f8;
            path2.cubicTo(e4, f11, f13, f4, f12, f4);
            float f14 = f6 - min;
            path2.lineTo(f14, f4);
            float f15 = f14 + f8;
            float f16 = f4;
            f4 = f10;
            path2.cubicTo(f15, f16, f6, f11, f6, f4);
            float f17 = f7 - min2;
            path2.lineTo(f6, f17);
            float f18 = f17 + f9;
            path = path2;
            path2.cubicTo(f6, f18, f15, f7, f14, f7);
            path.lineTo(f12, f7);
            path.cubicTo(f13, f7, e4, f18, e4, f17);
        }
        path.lineTo(e4, f4);
        path.close();
        return path;
    }

    private Path d0(g.w0 w0Var) {
        List<g.p> list = w0Var.f1720o;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float e3 = (list == null || list.size() == 0) ? BitmapDescriptorFactory.HUE_RED : w0Var.f1720o.get(0).e(this);
        List<g.p> list2 = w0Var.f1721p;
        float f4 = (list2 == null || list2.size() == 0) ? BitmapDescriptorFactory.HUE_RED : w0Var.f1721p.get(0).f(this);
        List<g.p> list3 = w0Var.f1722q;
        float e4 = (list3 == null || list3.size() == 0) ? BitmapDescriptorFactory.HUE_RED : w0Var.f1722q.get(0).e(this);
        List<g.p> list4 = w0Var.f1723r;
        if (list4 != null && list4.size() != 0) {
            f3 = w0Var.f1723r.get(0).f(this);
        }
        if (this.f1924d.f1960a.f1775x != g.e0.f.Start) {
            float n3 = n(w0Var);
            if (this.f1924d.f1960a.f1775x == g.e0.f.Middle) {
                n3 /= 2.0f;
            }
            e3 -= n3;
        }
        if (w0Var.f1851h == null) {
            i iVar = new i(e3, f4);
            E(w0Var, iVar);
            RectF rectF = iVar.f1971d;
            w0Var.f1851h = new g.b(rectF.left, rectF.top, rectF.width(), iVar.f1971d.height());
        }
        Path path = new Path();
        E(w0Var, new g(e3 + e4, f4 + f3, path));
        return path;
    }

    private void e0(boolean z3, g.b bVar, g.q0 q0Var) {
        float f3;
        float d3;
        float f4;
        String str = q0Var.f1846l;
        if (str != null) {
            H(q0Var, str);
        }
        Boolean bool = q0Var.f1843i;
        int i3 = 0;
        boolean z4 = bool != null && bool.booleanValue();
        C0045h c0045h = this.f1924d;
        Paint paint = z3 ? c0045h.f1963d : c0045h.f1964e;
        if (z4) {
            g.p pVar = new g.p(50.0f, g.d1.percent);
            g.p pVar2 = q0Var.f1878m;
            float e3 = pVar2 != null ? pVar2.e(this) : pVar.e(this);
            g.p pVar3 = q0Var.f1879n;
            float f5 = pVar3 != null ? pVar3.f(this) : pVar.f(this);
            g.p pVar4 = q0Var.f1880o;
            d3 = pVar4 != null ? pVar4.c(this) : pVar.c(this);
            f3 = e3;
            f4 = f5;
        } else {
            g.p pVar5 = q0Var.f1878m;
            float d4 = pVar5 != null ? pVar5.d(this, 1.0f) : 0.5f;
            g.p pVar6 = q0Var.f1879n;
            float d5 = pVar6 != null ? pVar6.d(this, 1.0f) : 0.5f;
            g.p pVar7 = q0Var.f1880o;
            f3 = d4;
            d3 = pVar7 != null ? pVar7.d(this, 1.0f) : 0.5f;
            f4 = d5;
        }
        S0();
        this.f1924d = M(q0Var);
        Matrix matrix = new Matrix();
        if (!z4) {
            matrix.preTranslate(bVar.f1724a, bVar.f1725b);
            matrix.preScale(bVar.f1726c, bVar.f1727d);
        }
        Matrix matrix2 = q0Var.f1844j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = q0Var.f1842h.size();
        if (size == 0) {
            R0();
            C0045h c0045h2 = this.f1924d;
            if (z3) {
                c0045h2.f1961b = false;
                return;
            } else {
                c0045h2.f1962c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        float f6 = -1.0f;
        Iterator<g.n0> it = q0Var.f1842h.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            float f7 = BitmapDescriptorFactory.HUE_RED;
            if (!hasNext) {
                break;
            }
            g.d0 d0Var = (g.d0) it.next();
            Float f8 = d0Var.f1743h;
            if (f8 != null) {
                f7 = f8.floatValue();
            }
            if (i3 == 0 || f7 >= f6) {
                fArr[i3] = f7;
                f6 = f7;
            } else {
                fArr[i3] = f6;
            }
            S0();
            W0(this.f1924d, d0Var);
            g.e0 e0Var = this.f1924d.f1960a;
            g.f fVar = (g.f) e0Var.F;
            if (fVar == null) {
                fVar = g.f.f1818d;
            }
            iArr[i3] = x(fVar.f1820c, e0Var.G.floatValue());
            i3++;
            R0();
        }
        if (d3 == BitmapDescriptorFactory.HUE_RED || size == 1) {
            R0();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        g.k kVar = q0Var.f1845k;
        if (kVar != null) {
            if (kVar == g.k.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (kVar == g.k.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        R0();
        RadialGradient radialGradient = new RadialGradient(f3, f4, d3, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
        paint.setAlpha(w(this.f1924d.f1960a.f1758g.floatValue()));
    }

    private g.b f0(g.p pVar, g.p pVar2, g.p pVar3, g.p pVar4) {
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float e3 = pVar != null ? pVar.e(this) : BitmapDescriptorFactory.HUE_RED;
        if (pVar2 != null) {
            f3 = pVar2.f(this);
        }
        g.b S = S();
        return new g.b(e3, f3, pVar3 != null ? pVar3.e(this) : S.f1726c, pVar4 != null ? pVar4.f(this) : S.f1727d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e3, code lost:
    
        if (r7 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fb, code lost:
    
        r0.setFillType(P());
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f8, code lost:
    
        r0.transform(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f6, code lost:
    
        if (r7 != null) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Path g0(c0.g.k0 r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.h.g0(c0.g$k0, boolean):android.graphics.Path");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(float f3, float f4, float f5, float f6, float f7, boolean z3, boolean z4, float f8, float f9, g.x xVar) {
        float f10;
        g.x xVar2;
        if (f3 == f8 && f4 == f9) {
            return;
        }
        if (f5 == BitmapDescriptorFactory.HUE_RED) {
            f10 = f8;
            xVar2 = xVar;
        } else {
            if (f6 != BitmapDescriptorFactory.HUE_RED) {
                float abs = Math.abs(f5);
                float abs2 = Math.abs(f6);
                double radians = Math.toRadians(f7 % 360.0d);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d3 = (f3 - f8) / 2.0d;
                double d4 = (f4 - f9) / 2.0d;
                double d5 = (cos * d3) + (sin * d4);
                double d6 = ((-sin) * d3) + (d4 * cos);
                double d7 = abs * abs;
                double d8 = abs2 * abs2;
                double d9 = d5 * d5;
                double d10 = d6 * d6;
                double d11 = (d9 / d7) + (d10 / d8);
                if (d11 > 0.99999d) {
                    double sqrt = Math.sqrt(d11) * 1.00001d;
                    abs = (float) (abs * sqrt);
                    abs2 = (float) (sqrt * abs2);
                    d7 = abs * abs;
                    d8 = abs2 * abs2;
                }
                double d12 = z3 == z4 ? -1.0d : 1.0d;
                double d13 = d7 * d8;
                double d14 = d7 * d10;
                double d15 = d8 * d9;
                double d16 = ((d13 - d14) - d15) / (d14 + d15);
                if (d16 < 0.0d) {
                    d16 = 0.0d;
                }
                double sqrt2 = d12 * Math.sqrt(d16);
                double d17 = abs;
                double d18 = abs2;
                double d19 = ((d17 * d6) / d18) * sqrt2;
                float f11 = abs;
                float f12 = abs2;
                double d20 = sqrt2 * (-((d18 * d5) / d17));
                double d21 = ((f3 + f8) / 2.0d) + ((cos * d19) - (sin * d20));
                double d22 = ((f4 + f9) / 2.0d) + (sin * d19) + (cos * d20);
                double d23 = (d5 - d19) / d17;
                double d24 = (d6 - d20) / d18;
                double d25 = ((-d5) - d19) / d17;
                double d26 = ((-d6) - d20) / d18;
                double d27 = (d23 * d23) + (d24 * d24);
                double acos = (d24 < 0.0d ? -1.0d : 1.0d) * Math.acos(d23 / Math.sqrt(d27));
                double v3 = ((d23 * d26) - (d24 * d25) >= 0.0d ? 1.0d : -1.0d) * v(((d23 * d25) + (d24 * d26)) / Math.sqrt(d27 * ((d25 * d25) + (d26 * d26))));
                if (!z4 && v3 > 0.0d) {
                    v3 -= 6.283185307179586d;
                } else if (z4 && v3 < 0.0d) {
                    v3 += 6.283185307179586d;
                }
                float[] i3 = i(acos % 6.283185307179586d, v3 % 6.283185307179586d);
                Matrix matrix = new Matrix();
                matrix.postScale(f11, f12);
                matrix.postRotate(f7);
                matrix.postTranslate((float) d21, (float) d22);
                matrix.mapPoints(i3);
                i3[i3.length - 2] = f8;
                i3[i3.length - 1] = f9;
                for (int i4 = 0; i4 < i3.length; i4 += 6) {
                    xVar.b(i3[i4], i3[i4 + 1], i3[i4 + 2], i3[i4 + 3], i3[i4 + 4], i3[i4 + 5]);
                }
                return;
            }
            xVar2 = xVar;
            f10 = f8;
        }
        xVar2.lineTo(f10, f9);
    }

    private void h0() {
        this.f1926f.pop();
        this.f1927g.pop();
    }

    private static float[] i(double d3, double d4) {
        int ceil = (int) Math.ceil((Math.abs(d4) * 2.0d) / 3.141592653589793d);
        double d5 = d4 / ceil;
        double d6 = d5 / 2.0d;
        double sin = (Math.sin(d6) * 1.3333333333333333d) / (Math.cos(d6) + 1.0d);
        float[] fArr = new float[ceil * 6];
        int i3 = 0;
        for (int i4 = 0; i4 < ceil; i4++) {
            double d7 = d3 + (i4 * d5);
            double cos = Math.cos(d7);
            double sin2 = Math.sin(d7);
            int i5 = i3 + 1;
            fArr[i3] = (float) (cos - (sin * sin2));
            int i6 = i5 + 1;
            fArr[i5] = (float) (sin2 + (cos * sin));
            d5 = d5;
            double d8 = d7 + d5;
            double cos2 = Math.cos(d8);
            double sin3 = Math.sin(d8);
            int i7 = i6 + 1;
            fArr[i6] = (float) ((sin * sin3) + cos2);
            int i8 = i7 + 1;
            fArr[i7] = (float) (sin3 - (sin * cos2));
            int i9 = i8 + 1;
            fArr[i8] = (float) cos2;
            i3 = i9 + 1;
            fArr[i9] = (float) sin3;
        }
        return fArr;
    }

    private void i0(g.j0 j0Var) {
        this.f1926f.push(j0Var);
        this.f1927g.push(this.f1921a.getMatrix());
    }

    private Path j(g.k0 k0Var, g.b bVar) {
        Path g02;
        g.n0 n3 = k0Var.f1863a.n(this.f1924d.f1960a.H);
        if (n3 == null) {
            F("ClipPath reference '%s' not found", this.f1924d.f1960a.H);
            return null;
        }
        g.e eVar = (g.e) n3;
        this.f1925e.push(this.f1924d);
        this.f1924d = M(eVar);
        Boolean bool = eVar.f1754p;
        boolean z3 = bool == null || bool.booleanValue();
        Matrix matrix = new Matrix();
        if (!z3) {
            matrix.preTranslate(bVar.f1724a, bVar.f1725b);
            matrix.preScale(bVar.f1726c, bVar.f1727d);
        }
        Matrix matrix2 = eVar.f1858o;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (g.n0 n0Var : eVar.f1827i) {
            if ((n0Var instanceof g.k0) && (g02 = g0((g.k0) n0Var, true)) != null) {
                path.op(g02, Path.Op.UNION);
            }
        }
        if (this.f1924d.f1960a.H != null) {
            if (eVar.f1851h == null) {
                eVar.f1851h = m(path);
            }
            Path j3 = j(eVar, eVar.f1851h);
            if (j3 != null) {
                path.op(j3, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.f1924d = this.f1925e.pop();
        return path;
    }

    private void j0(g.k0 k0Var) {
        k0(k0Var, k0Var.f1851h);
    }

    private List<c> k(g.q qVar) {
        g.p pVar = qVar.f1874o;
        float e3 = pVar != null ? pVar.e(this) : BitmapDescriptorFactory.HUE_RED;
        g.p pVar2 = qVar.f1875p;
        float f3 = pVar2 != null ? pVar2.f(this) : BitmapDescriptorFactory.HUE_RED;
        g.p pVar3 = qVar.f1876q;
        float e4 = pVar3 != null ? pVar3.e(this) : BitmapDescriptorFactory.HUE_RED;
        g.p pVar4 = qVar.f1877r;
        float f4 = pVar4 != null ? pVar4.f(this) : BitmapDescriptorFactory.HUE_RED;
        ArrayList arrayList = new ArrayList(2);
        float f5 = e4 - e3;
        float f6 = f4 - f3;
        arrayList.add(new c(e3, f3, f5, f6));
        arrayList.add(new c(e4, f4, f5, f6));
        return arrayList;
    }

    private void k0(g.k0 k0Var, g.b bVar) {
        if (this.f1924d.f1960a.J != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f1921a.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0.2127f, 0.7151f, 0.0722f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED})));
            this.f1921a.saveLayer(null, paint2, 31);
            g.s sVar = (g.s) this.f1923c.n(this.f1924d.f1960a.J);
            J0(sVar, k0Var, bVar);
            this.f1921a.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f1921a.saveLayer(null, paint3, 31);
            J0(sVar, k0Var, bVar);
            this.f1921a.restore();
            this.f1921a.restore();
        }
        R0();
    }

    private List<c> l(g.z zVar) {
        int length = zVar.f1916o.length;
        int i3 = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = zVar.f1916o;
        c cVar = new c(fArr[0], fArr[1], BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float f4 = BitmapDescriptorFactory.HUE_RED;
        while (i3 < length) {
            float[] fArr2 = zVar.f1916o;
            float f5 = fArr2[i3];
            float f6 = fArr2[i3 + 1];
            cVar.a(f5, f6);
            arrayList.add(cVar);
            i3 += 2;
            cVar = new c(f5, f6, f5 - cVar.f1941a, f6 - cVar.f1942b);
            f4 = f6;
            f3 = f5;
        }
        if (zVar instanceof g.a0) {
            float[] fArr3 = zVar.f1916o;
            float f7 = fArr3[0];
            if (f3 != f7) {
                float f8 = fArr3[1];
                if (f4 != f8) {
                    cVar.a(f7, f8);
                    arrayList.add(cVar);
                    c cVar2 = new c(f7, f8, f7 - cVar.f1941a, f8 - cVar.f1942b);
                    cVar2.b((c) arrayList.get(0));
                    arrayList.add(cVar2);
                    arrayList.set(0, cVar2);
                }
            }
        } else {
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private void l0(g.n0 n0Var, j jVar) {
        float f3;
        float f4;
        float f5;
        g.e0.f O;
        if (jVar.a((g.y0) n0Var)) {
            if (n0Var instanceof g.z0) {
                S0();
                L0((g.z0) n0Var);
            } else {
                if (n0Var instanceof g.v0) {
                    y("TSpan render", new Object[0]);
                    S0();
                    g.v0 v0Var = (g.v0) n0Var;
                    W0(this.f1924d, v0Var);
                    if (A()) {
                        List<g.p> list = v0Var.f1720o;
                        boolean z3 = list != null && list.size() > 0;
                        boolean z4 = jVar instanceof f;
                        float f6 = BitmapDescriptorFactory.HUE_RED;
                        if (z4) {
                            float e3 = !z3 ? ((f) jVar).f1953b : v0Var.f1720o.get(0).e(this);
                            List<g.p> list2 = v0Var.f1721p;
                            f4 = (list2 == null || list2.size() == 0) ? ((f) jVar).f1954c : v0Var.f1721p.get(0).f(this);
                            List<g.p> list3 = v0Var.f1722q;
                            f5 = (list3 == null || list3.size() == 0) ? BitmapDescriptorFactory.HUE_RED : v0Var.f1722q.get(0).e(this);
                            List<g.p> list4 = v0Var.f1723r;
                            if (list4 != null && list4.size() != 0) {
                                f6 = v0Var.f1723r.get(0).f(this);
                            }
                            f3 = f6;
                            f6 = e3;
                        } else {
                            f3 = BitmapDescriptorFactory.HUE_RED;
                            f4 = BitmapDescriptorFactory.HUE_RED;
                            f5 = BitmapDescriptorFactory.HUE_RED;
                        }
                        if (z3 && (O = O()) != g.e0.f.Start) {
                            float n3 = n(v0Var);
                            if (O == g.e0.f.Middle) {
                                n3 /= 2.0f;
                            }
                            f6 -= n3;
                        }
                        r((g.k0) v0Var.f());
                        if (z4) {
                            f fVar = (f) jVar;
                            fVar.f1953b = f6 + f5;
                            fVar.f1954c = f4 + f3;
                        }
                        boolean m02 = m0();
                        E(v0Var, jVar);
                        if (m02) {
                            j0(v0Var);
                        }
                    }
                } else {
                    if (!(n0Var instanceof g.u0)) {
                        return;
                    }
                    S0();
                    g.u0 u0Var = (g.u0) n0Var;
                    W0(this.f1924d, u0Var);
                    if (A()) {
                        r((g.k0) u0Var.f());
                        g.n0 n4 = n0Var.f1863a.n(u0Var.f1898o);
                        if (n4 == null || !(n4 instanceof g.y0)) {
                            F("Tref reference '%s' not found", u0Var.f1898o);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            G((g.y0) n4, sb);
                            if (sb.length() > 0) {
                                jVar.b(sb.toString());
                            }
                        }
                    }
                }
            }
            R0();
        }
    }

    private g.b m(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new g.b(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private boolean m0() {
        g.n0 n3;
        if (!M0()) {
            return false;
        }
        this.f1921a.saveLayerAlpha(null, w(this.f1924d.f1960a.f1767p.floatValue()), 31);
        this.f1925e.push(this.f1924d);
        C0045h c0045h = new C0045h(this.f1924d);
        this.f1924d = c0045h;
        String str = c0045h.f1960a.J;
        if (str != null && ((n3 = this.f1923c.n(str)) == null || !(n3 instanceof g.s))) {
            F("Mask reference '%s' not found", this.f1924d.f1960a.J);
            this.f1924d.f1960a.J = null;
        }
        return true;
    }

    private float n(g.y0 y0Var) {
        k kVar = new k(this, null);
        E(y0Var, kVar);
        return kVar.f1974b;
    }

    private c n0(c cVar, c cVar2, c cVar3) {
        float D = D(cVar2.f1943c, cVar2.f1944d, cVar2.f1941a - cVar.f1941a, cVar2.f1942b - cVar.f1942b);
        if (D == BitmapDescriptorFactory.HUE_RED) {
            D = D(cVar2.f1943c, cVar2.f1944d, cVar3.f1941a - cVar2.f1941a, cVar3.f1942b - cVar2.f1942b);
        }
        if (D > BitmapDescriptorFactory.HUE_RED) {
            return cVar2;
        }
        if (D == BitmapDescriptorFactory.HUE_RED && (cVar2.f1943c > BitmapDescriptorFactory.HUE_RED || cVar2.f1944d >= BitmapDescriptorFactory.HUE_RED)) {
            return cVar2;
        }
        cVar2.f1943c = -cVar2.f1943c;
        cVar2.f1944d = -cVar2.f1944d;
        return cVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
    
        if (r12 != 8) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Matrix o(c0.g.b r10, c0.g.b r11, c0.e r12) {
        /*
            r9 = this;
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            if (r12 == 0) goto L99
            c0.e$a r1 = r12.a()
            if (r1 != 0) goto Lf
            goto L99
        Lf:
            float r1 = r10.f1726c
            float r2 = r11.f1726c
            float r1 = r1 / r2
            float r2 = r10.f1727d
            float r3 = r11.f1727d
            float r2 = r2 / r3
            float r3 = r11.f1724a
            float r3 = -r3
            float r4 = r11.f1725b
            float r4 = -r4
            c0.e r5 = c0.e.f1682d
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L35
            float r11 = r10.f1724a
            float r10 = r10.f1725b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r2)
        L31:
            r0.preTranslate(r3, r4)
            return r0
        L35:
            c0.e$b r5 = r12.b()
            c0.e$b r6 = c0.e.b.slice
            if (r5 != r6) goto L42
            float r1 = java.lang.Math.max(r1, r2)
            goto L46
        L42:
            float r1 = java.lang.Math.min(r1, r2)
        L46:
            float r2 = r10.f1726c
            float r2 = r2 / r1
            float r5 = r10.f1727d
            float r5 = r5 / r1
            int[] r6 = c0.h.a.f1929a
            c0.e$a r7 = r12.a()
            int r7 = r7.ordinal()
            r7 = r6[r7]
            r8 = 1073741824(0x40000000, float:2.0)
            switch(r7) {
                case 1: goto L62;
                case 2: goto L62;
                case 3: goto L62;
                case 4: goto L5e;
                case 5: goto L5e;
                case 6: goto L5e;
                default: goto L5d;
            }
        L5d:
            goto L67
        L5e:
            float r7 = r11.f1726c
            float r7 = r7 - r2
            goto L66
        L62:
            float r7 = r11.f1726c
            float r7 = r7 - r2
            float r7 = r7 / r8
        L66:
            float r3 = r3 - r7
        L67:
            c0.e$a r12 = r12.a()
            int r12 = r12.ordinal()
            r12 = r6[r12]
            r2 = 2
            if (r12 == r2) goto L89
            r2 = 3
            if (r12 == r2) goto L85
            r2 = 5
            if (r12 == r2) goto L89
            r2 = 6
            if (r12 == r2) goto L85
            r2 = 7
            if (r12 == r2) goto L89
            r2 = 8
            if (r12 == r2) goto L85
            goto L8e
        L85:
            float r11 = r11.f1727d
            float r11 = r11 - r5
            goto L8d
        L89:
            float r11 = r11.f1727d
            float r11 = r11 - r5
            float r11 = r11 / r8
        L8d:
            float r4 = r4 - r11
        L8e:
            float r11 = r10.f1724a
            float r10 = r10.f1725b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r1)
            goto L31
        L99:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.h.o(c0.g$b, c0.g$b, c0.e):android.graphics.Matrix");
    }

    private void o0(g.d dVar) {
        y("Circle render", new Object[0]);
        g.p pVar = dVar.f1742q;
        if (pVar == null || pVar.h()) {
            return;
        }
        W0(this.f1924d, dVar);
        if (A() && Y0()) {
            Matrix matrix = dVar.f1852n;
            if (matrix != null) {
                this.f1921a.concat(matrix);
            }
            Path Y = Y(dVar);
            U0(dVar);
            r(dVar);
            p(dVar);
            boolean m02 = m0();
            if (this.f1924d.f1961b) {
                B(dVar, Y);
            }
            if (this.f1924d.f1962c) {
                C(Y);
            }
            if (m02) {
                j0(dVar);
            }
        }
    }

    private void p(g.k0 k0Var) {
        q(k0Var, k0Var.f1851h);
    }

    private void p0(g.i iVar) {
        y("Ellipse render", new Object[0]);
        g.p pVar = iVar.f1835q;
        if (pVar == null || iVar.f1836r == null || pVar.h() || iVar.f1836r.h()) {
            return;
        }
        W0(this.f1924d, iVar);
        if (A() && Y0()) {
            Matrix matrix = iVar.f1852n;
            if (matrix != null) {
                this.f1921a.concat(matrix);
            }
            Path Z = Z(iVar);
            U0(iVar);
            r(iVar);
            p(iVar);
            boolean m02 = m0();
            if (this.f1924d.f1961b) {
                B(iVar, Z);
            }
            if (this.f1924d.f1962c) {
                C(Z);
            }
            if (m02) {
                j0(iVar);
            }
        }
    }

    private void q(g.k0 k0Var, g.b bVar) {
        Path j3;
        if (this.f1924d.f1960a.H == null || (j3 = j(k0Var, bVar)) == null) {
            return;
        }
        this.f1921a.clipPath(j3);
    }

    private void q0(g.m mVar) {
        y("Group render", new Object[0]);
        W0(this.f1924d, mVar);
        if (A()) {
            Matrix matrix = mVar.f1858o;
            if (matrix != null) {
                this.f1921a.concat(matrix);
            }
            p(mVar);
            boolean m02 = m0();
            F0(mVar, true);
            if (m02) {
                j0(mVar);
            }
            U0(mVar);
        }
    }

    private void r(g.k0 k0Var) {
        g.o0 o0Var = this.f1924d.f1960a.f1756d;
        if (o0Var instanceof g.u) {
            z(true, k0Var.f1851h, (g.u) o0Var);
        }
        g.o0 o0Var2 = this.f1924d.f1960a.f1759h;
        if (o0Var2 instanceof g.u) {
            z(false, k0Var.f1851h, (g.u) o0Var2);
        }
    }

    private void r0(g.o oVar) {
        g.p pVar;
        String str;
        y("Image render", new Object[0]);
        g.p pVar2 = oVar.f1868s;
        if (pVar2 == null || pVar2.h() || (pVar = oVar.f1869t) == null || pVar.h() || (str = oVar.f1865p) == null) {
            return;
        }
        c0.e eVar = oVar.f1873o;
        if (eVar == null) {
            eVar = c0.e.f1683e;
        }
        Bitmap s3 = s(str);
        if (s3 == null) {
            c0.g.g();
            return;
        }
        g.b bVar = new g.b(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, s3.getWidth(), s3.getHeight());
        W0(this.f1924d, oVar);
        if (A() && Y0()) {
            Matrix matrix = oVar.f1870u;
            if (matrix != null) {
                this.f1921a.concat(matrix);
            }
            g.p pVar3 = oVar.f1866q;
            float e3 = pVar3 != null ? pVar3.e(this) : BitmapDescriptorFactory.HUE_RED;
            g.p pVar4 = oVar.f1867r;
            this.f1924d.f1965f = new g.b(e3, pVar4 != null ? pVar4.f(this) : BitmapDescriptorFactory.HUE_RED, oVar.f1868s.e(this), oVar.f1869t.e(this));
            if (!this.f1924d.f1960a.f1776y.booleanValue()) {
                g.b bVar2 = this.f1924d.f1965f;
                O0(bVar2.f1724a, bVar2.f1725b, bVar2.f1726c, bVar2.f1727d);
            }
            oVar.f1851h = this.f1924d.f1965f;
            U0(oVar);
            p(oVar);
            boolean m02 = m0();
            X0();
            this.f1921a.save();
            this.f1921a.concat(o(this.f1924d.f1965f, bVar, eVar));
            this.f1921a.drawBitmap(s3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, new Paint(this.f1924d.f1960a.P != g.e0.e.optimizeSpeed ? 2 : 0));
            this.f1921a.restore();
            if (m02) {
                j0(oVar);
            }
        }
    }

    private Bitmap s(String str) {
        int indexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (indexOf = str.indexOf(44)) < 12 || !";base64".equals(str.substring(indexOf - 7, indexOf))) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e3) {
            Log.e("SVGAndroidRenderer", "Could not decode bad Data URL", e3);
            return null;
        }
    }

    private void s0(g.q qVar) {
        y("Line render", new Object[0]);
        W0(this.f1924d, qVar);
        if (A() && Y0() && this.f1924d.f1962c) {
            Matrix matrix = qVar.f1852n;
            if (matrix != null) {
                this.f1921a.concat(matrix);
            }
            Path a02 = a0(qVar);
            U0(qVar);
            r(qVar);
            p(qVar);
            boolean m02 = m0();
            C(a02);
            I0(qVar);
            if (m02) {
                j0(qVar);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
    
        if (r6.equals("monospace") == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Typeface t(java.lang.String r6, java.lang.Integer r7, c0.g.e0.b r8) {
        /*
            r5 = this;
            c0.g$e0$b r0 = c0.g.e0.b.Italic
            r1 = 1
            r2 = 0
            if (r8 != r0) goto L8
            r8 = 1
            goto L9
        L8:
            r8 = 0
        L9:
            int r7 = r7.intValue()
            r0 = 500(0x1f4, float:7.0E-43)
            r3 = 3
            r4 = 2
            if (r7 <= r0) goto L19
            if (r8 == 0) goto L17
            r7 = 3
            goto L1e
        L17:
            r7 = 1
            goto L1e
        L19:
            if (r8 == 0) goto L1d
            r7 = 2
            goto L1e
        L1d:
            r7 = 0
        L1e:
            r6.hashCode()
            r8 = -1
            int r0 = r6.hashCode()
            switch(r0) {
                case -1536685117: goto L55;
                case -1431958525: goto L4c;
                case -1081737434: goto L41;
                case 109326717: goto L36;
                case 1126973893: goto L2b;
                default: goto L29;
            }
        L29:
            r1 = -1
            goto L5f
        L2b:
            java.lang.String r0 = "cursive"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L34
            goto L29
        L34:
            r1 = 4
            goto L5f
        L36:
            java.lang.String r0 = "serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L3f
            goto L29
        L3f:
            r1 = 3
            goto L5f
        L41:
            java.lang.String r0 = "fantasy"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L4a
            goto L29
        L4a:
            r1 = 2
            goto L5f
        L4c:
            java.lang.String r0 = "monospace"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L5f
            goto L29
        L55:
            java.lang.String r0 = "sans-serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L5e
            goto L29
        L5e:
            r1 = 0
        L5f:
            switch(r1) {
                case 0: goto L6e;
                case 1: goto L6b;
                case 2: goto L6e;
                case 3: goto L64;
                case 4: goto L6e;
                default: goto L62;
            }
        L62:
            r6 = 0
            goto L71
        L64:
            android.graphics.Typeface r6 = android.graphics.Typeface.SERIF
        L66:
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L71
        L6b:
            android.graphics.Typeface r6 = android.graphics.Typeface.MONOSPACE
            goto L66
        L6e:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            goto L66
        L71:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.h.t(java.lang.String, java.lang.Integer, c0.g$e0$b):android.graphics.Typeface");
    }

    private void t0(g.v vVar) {
        y("Path render", new Object[0]);
        if (vVar.f1900o == null) {
            return;
        }
        W0(this.f1924d, vVar);
        if (A() && Y0()) {
            C0045h c0045h = this.f1924d;
            if (c0045h.f1962c || c0045h.f1961b) {
                Matrix matrix = vVar.f1852n;
                if (matrix != null) {
                    this.f1921a.concat(matrix);
                }
                Path d3 = new d(vVar.f1900o).d();
                if (vVar.f1851h == null) {
                    vVar.f1851h = m(d3);
                }
                U0(vVar);
                r(vVar);
                p(vVar);
                boolean m02 = m0();
                if (this.f1924d.f1961b) {
                    d3.setFillType(U());
                    B(vVar, d3);
                }
                if (this.f1924d.f1962c) {
                    C(d3);
                }
                I0(vVar);
                if (m02) {
                    j0(vVar);
                }
            }
        }
    }

    private void u(g.n0 n0Var) {
        Boolean bool;
        if ((n0Var instanceof g.l0) && (bool = ((g.l0) n0Var).f1854d) != null) {
            this.f1924d.f1967h = bool.booleanValue();
        }
    }

    private void u0(g.z zVar) {
        y("PolyLine render", new Object[0]);
        W0(this.f1924d, zVar);
        if (A() && Y0()) {
            C0045h c0045h = this.f1924d;
            if (c0045h.f1962c || c0045h.f1961b) {
                Matrix matrix = zVar.f1852n;
                if (matrix != null) {
                    this.f1921a.concat(matrix);
                }
                if (zVar.f1916o.length < 2) {
                    return;
                }
                Path b02 = b0(zVar);
                U0(zVar);
                b02.setFillType(U());
                r(zVar);
                p(zVar);
                boolean m02 = m0();
                if (this.f1924d.f1961b) {
                    B(zVar, b02);
                }
                if (this.f1924d.f1962c) {
                    C(b02);
                }
                I0(zVar);
                if (m02) {
                    j0(zVar);
                }
            }
        }
    }

    private static double v(double d3) {
        if (d3 < -1.0d) {
            return 3.141592653589793d;
        }
        if (d3 > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d3);
    }

    private void v0(g.a0 a0Var) {
        y("Polygon render", new Object[0]);
        W0(this.f1924d, a0Var);
        if (A() && Y0()) {
            C0045h c0045h = this.f1924d;
            if (c0045h.f1962c || c0045h.f1961b) {
                Matrix matrix = a0Var.f1852n;
                if (matrix != null) {
                    this.f1921a.concat(matrix);
                }
                if (a0Var.f1916o.length < 2) {
                    return;
                }
                Path b02 = b0(a0Var);
                U0(a0Var);
                r(a0Var);
                p(a0Var);
                boolean m02 = m0();
                if (this.f1924d.f1961b) {
                    B(a0Var, b02);
                }
                if (this.f1924d.f1962c) {
                    C(b02);
                }
                I0(a0Var);
                if (m02) {
                    j0(a0Var);
                }
            }
        }
    }

    private static int w(float f3) {
        int i3 = (int) (f3 * 256.0f);
        if (i3 < 0) {
            return 0;
        }
        if (i3 > 255) {
            return 255;
        }
        return i3;
    }

    private void w0(g.b0 b0Var) {
        y("Rect render", new Object[0]);
        g.p pVar = b0Var.f1730q;
        if (pVar == null || b0Var.f1731r == null || pVar.h() || b0Var.f1731r.h()) {
            return;
        }
        W0(this.f1924d, b0Var);
        if (A() && Y0()) {
            Matrix matrix = b0Var.f1852n;
            if (matrix != null) {
                this.f1921a.concat(matrix);
            }
            Path c02 = c0(b0Var);
            U0(b0Var);
            r(b0Var);
            p(b0Var);
            boolean m02 = m0();
            if (this.f1924d.f1961b) {
                B(b0Var, c02);
            }
            if (this.f1924d.f1962c) {
                C(c02);
            }
            if (m02) {
                j0(b0Var);
            }
        }
    }

    private static int x(int i3, float f3) {
        int i4 = 255;
        int round = Math.round(((i3 >> 24) & 255) * f3);
        if (round < 0) {
            i4 = 0;
        } else if (round <= 255) {
            i4 = round;
        }
        return (i3 & 16777215) | (i4 << 24);
    }

    private void x0(g.f0 f0Var) {
        z0(f0Var, f0(f0Var.f1821q, f0Var.f1822r, f0Var.f1823s, f0Var.f1824t), f0Var.f1889p, f0Var.f1873o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(String str, Object... objArr) {
    }

    private void y0(g.f0 f0Var, g.b bVar) {
        z0(f0Var, bVar, f0Var.f1889p, f0Var.f1873o);
    }

    private void z(boolean z3, g.b bVar, g.u uVar) {
        g.n0 n3 = this.f1923c.n(uVar.f1896c);
        if (n3 != null) {
            if (n3 instanceof g.m0) {
                X(z3, bVar, (g.m0) n3);
                return;
            } else if (n3 instanceof g.q0) {
                e0(z3, bVar, (g.q0) n3);
                return;
            } else {
                if (n3 instanceof g.c0) {
                    Q0(z3, (g.c0) n3);
                    return;
                }
                return;
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = z3 ? "Fill" : "Stroke";
        objArr[1] = uVar.f1896c;
        F("%s reference '%s' not found", objArr);
        g.o0 o0Var = uVar.f1897d;
        if (o0Var != null) {
            P0(this.f1924d, z3, o0Var);
        } else if (z3) {
            this.f1924d.f1961b = false;
        } else {
            this.f1924d.f1962c = false;
        }
    }

    private void z0(g.f0 f0Var, g.b bVar, g.b bVar2, c0.e eVar) {
        y("Svg render", new Object[0]);
        if (bVar.f1726c == BitmapDescriptorFactory.HUE_RED || bVar.f1727d == BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        if (eVar == null && (eVar = f0Var.f1873o) == null) {
            eVar = c0.e.f1683e;
        }
        W0(this.f1924d, f0Var);
        if (A()) {
            C0045h c0045h = this.f1924d;
            c0045h.f1965f = bVar;
            if (!c0045h.f1960a.f1776y.booleanValue()) {
                g.b bVar3 = this.f1924d.f1965f;
                O0(bVar3.f1724a, bVar3.f1725b, bVar3.f1726c, bVar3.f1727d);
            }
            q(f0Var, this.f1924d.f1965f);
            Canvas canvas = this.f1921a;
            if (bVar2 != null) {
                canvas.concat(o(this.f1924d.f1965f, bVar2, eVar));
                this.f1924d.f1966g = f0Var.f1889p;
            } else {
                g.b bVar4 = this.f1924d.f1965f;
                canvas.translate(bVar4.f1724a, bVar4.f1725b);
            }
            boolean m02 = m0();
            X0();
            F0(f0Var, true);
            if (m02) {
                j0(f0Var);
            }
            U0(f0Var);
        }
    }

    void G0(c0.g gVar, c0.f fVar) {
        g.b bVar;
        c0.e eVar;
        if (fVar == null) {
            throw new NullPointerException("renderOptions shouldn't be null");
        }
        this.f1923c = gVar;
        g.f0 i3 = gVar.i();
        if (i3 == null) {
            Z0("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (fVar.d()) {
            g.l0 f3 = this.f1923c.f(fVar.f1710e);
            if (f3 == null || !(f3 instanceof g.f1)) {
                Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" not found.", fVar.f1710e));
                return;
            }
            g.f1 f1Var = (g.f1) f3;
            bVar = f1Var.f1889p;
            if (bVar == null) {
                Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" is missing a viewBox attribute.", fVar.f1710e));
                return;
            }
            eVar = f1Var.f1873o;
        } else {
            bVar = fVar.e() ? fVar.f1709d : i3.f1889p;
            eVar = fVar.b() ? fVar.f1707b : i3.f1873o;
        }
        if (fVar.a()) {
            gVar.a(fVar.f1706a);
        }
        if (fVar.c()) {
            b.q qVar = new b.q();
            this.f1928h = qVar;
            qVar.f1665a = gVar.f(fVar.f1708c);
        }
        N0();
        u(i3);
        S0();
        g.b bVar2 = new g.b(fVar.f1711f);
        g.p pVar = i3.f1823s;
        if (pVar != null) {
            bVar2.f1726c = pVar.d(this, bVar2.f1726c);
        }
        g.p pVar2 = i3.f1824t;
        if (pVar2 != null) {
            bVar2.f1727d = pVar2.d(this, bVar2.f1727d);
        }
        z0(i3, bVar2, bVar, eVar);
        R0();
        if (fVar.a()) {
            gVar.b();
        }
    }

    float Q() {
        return this.f1924d.f1963d.getTextSize();
    }

    float R() {
        return this.f1924d.f1963d.getTextSize() / 2.0f;
    }

    g.b S() {
        C0045h c0045h = this.f1924d;
        g.b bVar = c0045h.f1966g;
        return bVar != null ? bVar : c0045h.f1965f;
    }

    float T() {
        return this.f1922b;
    }
}
