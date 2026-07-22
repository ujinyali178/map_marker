package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets$Builder;
import android.view.WindowInsets$Type;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: /root/release/classes.dex */
public class e0 {

    /* renamed from: b, reason: collision with root package name */
    public static final e0 f773b;

    /* renamed from: a, reason: collision with root package name */
    private final l f774a;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Field f775a;

        /* renamed from: b, reason: collision with root package name */
        private static Field f776b;

        /* renamed from: c, reason: collision with root package name */
        private static Field f777c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f778d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f775a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f776b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f777c = declaredField3;
                declaredField3.setAccessible(true);
                f778d = true;
            } catch (ReflectiveOperationException e3) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e3.getMessage(), e3);
            }
        }

        public static e0 a(View view) {
            if (f778d && view.isAttachedToWindow()) {
                try {
                    Object obj = f775a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f776b.get(obj);
                        Rect rect2 = (Rect) f777c.get(obj);
                        if (rect != null && rect2 != null) {
                            e0 a4 = new b().b(androidx.core.graphics.b.c(rect)).c(androidx.core.graphics.b.c(rect2)).a();
                            a4.k(a4);
                            a4.d(view.getRootView());
                            return a4;
                        }
                    }
                } catch (IllegalAccessException e3) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e3.getMessage(), e3);
                }
            }
            return null;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final f f779a;

        public b() {
            int i3 = Build.VERSION.SDK_INT;
            this.f779a = i3 >= 30 ? new e() : i3 >= 29 ? new d() : new c();
        }

        public e0 a() {
            return this.f779a.b();
        }

        @Deprecated
        public b b(androidx.core.graphics.b bVar) {
            this.f779a.d(bVar);
            return this;
        }

        @Deprecated
        public b c(androidx.core.graphics.b bVar) {
            this.f779a.f(bVar);
            return this;
        }
    }

    private static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private static Field f780e;

        /* renamed from: f, reason: collision with root package name */
        private static boolean f781f;

        /* renamed from: g, reason: collision with root package name */
        private static Constructor<WindowInsets> f782g;

        /* renamed from: h, reason: collision with root package name */
        private static boolean f783h;

        /* renamed from: c, reason: collision with root package name */
        private WindowInsets f784c = h();

        /* renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.b f785d;

        c() {
        }

        private static WindowInsets h() {
            if (!f781f) {
                try {
                    f780e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e3);
                }
                f781f = true;
            }
            Field field = f780e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e4);
                }
            }
            if (!f783h) {
                try {
                    f782g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e5);
                }
                f783h = true;
            }
            Constructor<WindowInsets> constructor = f782g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e6) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e6);
                }
            }
            return null;
        }

        @Override // androidx.core.view.e0.f
        e0 b() {
            a();
            e0 n3 = e0.n(this.f784c);
            n3.i(this.f788b);
            n3.l(this.f785d);
            return n3;
        }

        @Override // androidx.core.view.e0.f
        void d(androidx.core.graphics.b bVar) {
            this.f785d = bVar;
        }

        @Override // androidx.core.view.e0.f
        void f(androidx.core.graphics.b bVar) {
            WindowInsets windowInsets = this.f784c;
            if (windowInsets != null) {
                this.f784c = windowInsets.replaceSystemWindowInsets(bVar.f663a, bVar.f664b, bVar.f665c, bVar.f666d);
            }
        }
    }

    private static class d extends f {

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets$Builder f786c = new WindowInsets$Builder();

        d() {
        }

        @Override // androidx.core.view.e0.f
        e0 b() {
            a();
            e0 n3 = e0.n(this.f786c.build());
            n3.i(this.f788b);
            return n3;
        }

        @Override // androidx.core.view.e0.f
        void c(androidx.core.graphics.b bVar) {
            this.f786c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.e0.f
        void d(androidx.core.graphics.b bVar) {
            this.f786c.setStableInsets(bVar.e());
        }

        @Override // androidx.core.view.e0.f
        void e(androidx.core.graphics.b bVar) {
            this.f786c.setSystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.e0.f
        void f(androidx.core.graphics.b bVar) {
            this.f786c.setSystemWindowInsets(bVar.e());
        }

        @Override // androidx.core.view.e0.f
        void g(androidx.core.graphics.b bVar) {
            this.f786c.setTappableElementInsets(bVar.e());
        }
    }

    private static class e extends d {
        e() {
        }
    }

    private static class f {

        /* renamed from: a, reason: collision with root package name */
        private final e0 f787a;

        /* renamed from: b, reason: collision with root package name */
        androidx.core.graphics.b[] f788b;

        f() {
            this(new e0((e0) null));
        }

        f(e0 e0Var) {
            this.f787a = e0Var;
        }

        protected final void a() {
            androidx.core.graphics.b[] bVarArr = this.f788b;
            if (bVarArr != null) {
                androidx.core.graphics.b bVar = bVarArr[m.a(1)];
                androidx.core.graphics.b bVar2 = this.f788b[m.a(2)];
                if (bVar2 == null) {
                    bVar2 = this.f787a.f(2);
                }
                if (bVar == null) {
                    bVar = this.f787a.f(1);
                }
                f(androidx.core.graphics.b.a(bVar, bVar2));
                androidx.core.graphics.b bVar3 = this.f788b[m.a(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                androidx.core.graphics.b bVar4 = this.f788b[m.a(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                androidx.core.graphics.b bVar5 = this.f788b[m.a(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        e0 b() {
            throw null;
        }

        void c(androidx.core.graphics.b bVar) {
        }

        void d(androidx.core.graphics.b bVar) {
            throw null;
        }

        void e(androidx.core.graphics.b bVar) {
        }

        void f(androidx.core.graphics.b bVar) {
            throw null;
        }

        void g(androidx.core.graphics.b bVar) {
        }
    }

    private static class g extends l {

        /* renamed from: h, reason: collision with root package name */
        private static boolean f789h;

        /* renamed from: i, reason: collision with root package name */
        private static Method f790i;

        /* renamed from: j, reason: collision with root package name */
        private static Class<?> f791j;

        /* renamed from: k, reason: collision with root package name */
        private static Field f792k;

        /* renamed from: l, reason: collision with root package name */
        private static Field f793l;

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets f794c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.b[] f795d;

        /* renamed from: e, reason: collision with root package name */
        private androidx.core.graphics.b f796e;

        /* renamed from: f, reason: collision with root package name */
        private e0 f797f;

        /* renamed from: g, reason: collision with root package name */
        androidx.core.graphics.b f798g;

        g(e0 e0Var, WindowInsets windowInsets) {
            super(e0Var);
            this.f796e = null;
            this.f794c = windowInsets;
        }

        g(e0 e0Var, g gVar) {
            this(e0Var, new WindowInsets(gVar.f794c));
        }

        private androidx.core.graphics.b s(int i3, boolean z3) {
            androidx.core.graphics.b bVar = androidx.core.graphics.b.f662e;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) != 0) {
                    bVar = androidx.core.graphics.b.a(bVar, t(i4, z3));
                }
            }
            return bVar;
        }

        private androidx.core.graphics.b u() {
            e0 e0Var = this.f797f;
            return e0Var != null ? e0Var.g() : androidx.core.graphics.b.f662e;
        }

        private androidx.core.graphics.b v(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f789h) {
                w();
            }
            Method method = f790i;
            if (method != null && f791j != null && f792k != null) {
                try {
                    Object invoke = method.invoke(view, new Object[0]);
                    if (invoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f792k.get(f793l.get(invoke));
                    if (rect != null) {
                        return androidx.core.graphics.b.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e3) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e3.getMessage(), e3);
                }
            }
            return null;
        }

        private static void w() {
            try {
                f790i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f791j = cls;
                f792k = cls.getDeclaredField("mVisibleInsets");
                f793l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f792k.setAccessible(true);
                f793l.setAccessible(true);
            } catch (ReflectiveOperationException e3) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e3.getMessage(), e3);
            }
            f789h = true;
        }

        @Override // androidx.core.view.e0.l
        void d(View view) {
            androidx.core.graphics.b v3 = v(view);
            if (v3 == null) {
                v3 = androidx.core.graphics.b.f662e;
            }
            p(v3);
        }

        @Override // androidx.core.view.e0.l
        void e(e0 e0Var) {
            e0Var.k(this.f797f);
            e0Var.j(this.f798g);
        }

        @Override // androidx.core.view.e0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f798g, ((g) obj).f798g);
            }
            return false;
        }

        @Override // androidx.core.view.e0.l
        public androidx.core.graphics.b g(int i3) {
            return s(i3, false);
        }

        @Override // androidx.core.view.e0.l
        final androidx.core.graphics.b k() {
            if (this.f796e == null) {
                this.f796e = androidx.core.graphics.b.b(this.f794c.getSystemWindowInsetLeft(), this.f794c.getSystemWindowInsetTop(), this.f794c.getSystemWindowInsetRight(), this.f794c.getSystemWindowInsetBottom());
            }
            return this.f796e;
        }

        @Override // androidx.core.view.e0.l
        boolean n() {
            return this.f794c.isRound();
        }

        @Override // androidx.core.view.e0.l
        public void o(androidx.core.graphics.b[] bVarArr) {
            this.f795d = bVarArr;
        }

        @Override // androidx.core.view.e0.l
        void p(androidx.core.graphics.b bVar) {
            this.f798g = bVar;
        }

        @Override // androidx.core.view.e0.l
        void q(e0 e0Var) {
            this.f797f = e0Var;
        }

        protected androidx.core.graphics.b t(int i3, boolean z3) {
            androidx.core.graphics.b g3;
            int i4;
            if (i3 == 1) {
                return z3 ? androidx.core.graphics.b.b(0, Math.max(u().f664b, k().f664b), 0, 0) : androidx.core.graphics.b.b(0, k().f664b, 0, 0);
            }
            if (i3 == 2) {
                if (z3) {
                    androidx.core.graphics.b u3 = u();
                    androidx.core.graphics.b i5 = i();
                    return androidx.core.graphics.b.b(Math.max(u3.f663a, i5.f663a), 0, Math.max(u3.f665c, i5.f665c), Math.max(u3.f666d, i5.f666d));
                }
                androidx.core.graphics.b k3 = k();
                e0 e0Var = this.f797f;
                g3 = e0Var != null ? e0Var.g() : null;
                int i6 = k3.f666d;
                if (g3 != null) {
                    i6 = Math.min(i6, g3.f666d);
                }
                return androidx.core.graphics.b.b(k3.f663a, 0, k3.f665c, i6);
            }
            if (i3 != 8) {
                if (i3 == 16) {
                    return j();
                }
                if (i3 == 32) {
                    return h();
                }
                if (i3 == 64) {
                    return l();
                }
                if (i3 != 128) {
                    return androidx.core.graphics.b.f662e;
                }
                e0 e0Var2 = this.f797f;
                androidx.core.view.a e3 = e0Var2 != null ? e0Var2.e() : f();
                return e3 != null ? androidx.core.graphics.b.b(e3.b(), e3.d(), e3.c(), e3.a()) : androidx.core.graphics.b.f662e;
            }
            androidx.core.graphics.b[] bVarArr = this.f795d;
            g3 = bVarArr != null ? bVarArr[m.a(8)] : null;
            if (g3 != null) {
                return g3;
            }
            androidx.core.graphics.b k4 = k();
            androidx.core.graphics.b u4 = u();
            int i7 = k4.f666d;
            if (i7 > u4.f666d) {
                return androidx.core.graphics.b.b(0, 0, 0, i7);
            }
            androidx.core.graphics.b bVar = this.f798g;
            return (bVar == null || bVar.equals(androidx.core.graphics.b.f662e) || (i4 = this.f798g.f666d) <= u4.f666d) ? androidx.core.graphics.b.f662e : androidx.core.graphics.b.b(0, 0, 0, i4);
        }
    }

    private static class h extends g {

        /* renamed from: m, reason: collision with root package name */
        private androidx.core.graphics.b f799m;

        h(e0 e0Var, WindowInsets windowInsets) {
            super(e0Var, windowInsets);
            this.f799m = null;
        }

        h(e0 e0Var, h hVar) {
            super(e0Var, hVar);
            this.f799m = null;
            this.f799m = hVar.f799m;
        }

        @Override // androidx.core.view.e0.l
        e0 b() {
            return e0.n(this.f794c.consumeStableInsets());
        }

        @Override // androidx.core.view.e0.l
        e0 c() {
            return e0.n(this.f794c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.e0.l
        final androidx.core.graphics.b i() {
            if (this.f799m == null) {
                this.f799m = androidx.core.graphics.b.b(this.f794c.getStableInsetLeft(), this.f794c.getStableInsetTop(), this.f794c.getStableInsetRight(), this.f794c.getStableInsetBottom());
            }
            return this.f799m;
        }

        @Override // androidx.core.view.e0.l
        boolean m() {
            return this.f794c.isConsumed();
        }

        @Override // androidx.core.view.e0.l
        public void r(androidx.core.graphics.b bVar) {
            this.f799m = bVar;
        }
    }

    private static class i extends h {
        i(e0 e0Var, WindowInsets windowInsets) {
            super(e0Var, windowInsets);
        }

        i(e0 e0Var, i iVar) {
            super(e0Var, iVar);
        }

        @Override // androidx.core.view.e0.l
        e0 a() {
            WindowInsets consumeDisplayCutout;
            consumeDisplayCutout = this.f794c.consumeDisplayCutout();
            return e0.n(consumeDisplayCutout);
        }

        @Override // androidx.core.view.e0.g, androidx.core.view.e0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f794c, iVar.f794c) && Objects.equals(this.f798g, iVar.f798g);
        }

        @Override // androidx.core.view.e0.l
        androidx.core.view.a f() {
            DisplayCutout displayCutout;
            displayCutout = this.f794c.getDisplayCutout();
            return androidx.core.view.a.e(displayCutout);
        }

        @Override // androidx.core.view.e0.l
        public int hashCode() {
            return this.f794c.hashCode();
        }
    }

    private static class j extends i {

        /* renamed from: n, reason: collision with root package name */
        private androidx.core.graphics.b f800n;

        /* renamed from: o, reason: collision with root package name */
        private androidx.core.graphics.b f801o;

        /* renamed from: p, reason: collision with root package name */
        private androidx.core.graphics.b f802p;

        j(e0 e0Var, WindowInsets windowInsets) {
            super(e0Var, windowInsets);
            this.f800n = null;
            this.f801o = null;
            this.f802p = null;
        }

        j(e0 e0Var, j jVar) {
            super(e0Var, jVar);
            this.f800n = null;
            this.f801o = null;
            this.f802p = null;
        }

        @Override // androidx.core.view.e0.l
        androidx.core.graphics.b h() {
            Insets mandatorySystemGestureInsets;
            if (this.f801o == null) {
                mandatorySystemGestureInsets = this.f794c.getMandatorySystemGestureInsets();
                this.f801o = androidx.core.graphics.b.d(mandatorySystemGestureInsets);
            }
            return this.f801o;
        }

        @Override // androidx.core.view.e0.l
        androidx.core.graphics.b j() {
            Insets systemGestureInsets;
            if (this.f800n == null) {
                systemGestureInsets = this.f794c.getSystemGestureInsets();
                this.f800n = androidx.core.graphics.b.d(systemGestureInsets);
            }
            return this.f800n;
        }

        @Override // androidx.core.view.e0.l
        androidx.core.graphics.b l() {
            Insets tappableElementInsets;
            if (this.f802p == null) {
                tappableElementInsets = this.f794c.getTappableElementInsets();
                this.f802p = androidx.core.graphics.b.d(tappableElementInsets);
            }
            return this.f802p;
        }

        @Override // androidx.core.view.e0.h, androidx.core.view.e0.l
        public void r(androidx.core.graphics.b bVar) {
        }
    }

    private static class k extends j {

        /* renamed from: q, reason: collision with root package name */
        static final e0 f803q = e0.n(WindowInsets.CONSUMED);

        k(e0 e0Var, WindowInsets windowInsets) {
            super(e0Var, windowInsets);
        }

        k(e0 e0Var, k kVar) {
            super(e0Var, kVar);
        }

        @Override // androidx.core.view.e0.g, androidx.core.view.e0.l
        final void d(View view) {
        }

        @Override // androidx.core.view.e0.g, androidx.core.view.e0.l
        public androidx.core.graphics.b g(int i3) {
            Insets insets;
            insets = this.f794c.getInsets(n.a(i3));
            return androidx.core.graphics.b.d(insets);
        }
    }

    private static class l {

        /* renamed from: b, reason: collision with root package name */
        static final e0 f804b = new b().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        final e0 f805a;

        l(e0 e0Var) {
            this.f805a = e0Var;
        }

        e0 a() {
            return this.f805a;
        }

        e0 b() {
            return this.f805a;
        }

        e0 c() {
            return this.f805a;
        }

        void d(View view) {
        }

        void e(e0 e0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return n() == lVar.n() && m() == lVar.m() && androidx.core.util.b.a(k(), lVar.k()) && androidx.core.util.b.a(i(), lVar.i()) && androidx.core.util.b.a(f(), lVar.f());
        }

        androidx.core.view.a f() {
            return null;
        }

        androidx.core.graphics.b g(int i3) {
            return androidx.core.graphics.b.f662e;
        }

        androidx.core.graphics.b h() {
            return k();
        }

        public int hashCode() {
            return androidx.core.util.b.b(Boolean.valueOf(n()), Boolean.valueOf(m()), k(), i(), f());
        }

        androidx.core.graphics.b i() {
            return androidx.core.graphics.b.f662e;
        }

        androidx.core.graphics.b j() {
            return k();
        }

        androidx.core.graphics.b k() {
            return androidx.core.graphics.b.f662e;
        }

        androidx.core.graphics.b l() {
            return k();
        }

        boolean m() {
            return false;
        }

        boolean n() {
            return false;
        }

        public void o(androidx.core.graphics.b[] bVarArr) {
        }

        void p(androidx.core.graphics.b bVar) {
        }

        void q(e0 e0Var) {
        }

        public void r(androidx.core.graphics.b bVar) {
        }
    }

    public static final class m {
        static int a(int i3) {
            if (i3 == 1) {
                return 0;
            }
            if (i3 == 2) {
                return 1;
            }
            if (i3 == 4) {
                return 2;
            }
            if (i3 == 8) {
                return 3;
            }
            if (i3 == 16) {
                return 4;
            }
            if (i3 == 32) {
                return 5;
            }
            if (i3 == 64) {
                return 6;
            }
            if (i3 == 128) {
                return 7;
            }
            if (i3 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i3);
        }
    }

    private static final class n {
        static int a(int i3) {
            int statusBars;
            int i4 = 0;
            for (int i5 = 1; i5 <= 256; i5 <<= 1) {
                if ((i3 & i5) != 0) {
                    if (i5 == 1) {
                        statusBars = WindowInsets$Type.statusBars();
                    } else if (i5 == 2) {
                        statusBars = WindowInsets$Type.navigationBars();
                    } else if (i5 == 4) {
                        statusBars = WindowInsets$Type.captionBar();
                    } else if (i5 == 8) {
                        statusBars = WindowInsets$Type.ime();
                    } else if (i5 == 16) {
                        statusBars = WindowInsets$Type.systemGestures();
                    } else if (i5 == 32) {
                        statusBars = WindowInsets$Type.mandatorySystemGestures();
                    } else if (i5 == 64) {
                        statusBars = WindowInsets$Type.tappableElement();
                    } else if (i5 == 128) {
                        statusBars = WindowInsets$Type.displayCutout();
                    }
                    i4 |= statusBars;
                }
            }
            return i4;
        }
    }

    static {
        f773b = Build.VERSION.SDK_INT >= 30 ? k.f803q : l.f804b;
    }

    private e0(WindowInsets windowInsets) {
        int i3 = Build.VERSION.SDK_INT;
        this.f774a = i3 >= 30 ? new k(this, windowInsets) : i3 >= 29 ? new j(this, windowInsets) : i3 >= 28 ? new i(this, windowInsets) : new h(this, windowInsets);
    }

    public e0(e0 e0Var) {
        if (e0Var == null) {
            this.f774a = new l(this);
            return;
        }
        l lVar = e0Var.f774a;
        int i3 = Build.VERSION.SDK_INT;
        this.f774a = (i3 < 30 || !(lVar instanceof k)) ? (i3 < 29 || !(lVar instanceof j)) ? (i3 < 28 || !(lVar instanceof i)) ? lVar instanceof h ? new h(this, (h) lVar) : lVar instanceof g ? new g(this, (g) lVar) : new l(this) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
        lVar.e(this);
    }

    public static e0 n(WindowInsets windowInsets) {
        return o(windowInsets, null);
    }

    public static e0 o(WindowInsets windowInsets, View view) {
        e0 e0Var = new e0((WindowInsets) androidx.core.util.d.e(windowInsets));
        if (view != null && androidx.core.view.n.i(view)) {
            e0Var.k(androidx.core.view.n.g(view));
            e0Var.d(view.getRootView());
        }
        return e0Var;
    }

    @Deprecated
    public e0 a() {
        return this.f774a.a();
    }

    @Deprecated
    public e0 b() {
        return this.f774a.b();
    }

    @Deprecated
    public e0 c() {
        return this.f774a.c();
    }

    void d(View view) {
        this.f774a.d(view);
    }

    public androidx.core.view.a e() {
        return this.f774a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e0) {
            return androidx.core.util.b.a(this.f774a, ((e0) obj).f774a);
        }
        return false;
    }

    public androidx.core.graphics.b f(int i3) {
        return this.f774a.g(i3);
    }

    @Deprecated
    public androidx.core.graphics.b g() {
        return this.f774a.i();
    }

    public boolean h() {
        return this.f774a.m();
    }

    public int hashCode() {
        l lVar = this.f774a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    void i(androidx.core.graphics.b[] bVarArr) {
        this.f774a.o(bVarArr);
    }

    void j(androidx.core.graphics.b bVar) {
        this.f774a.p(bVar);
    }

    void k(e0 e0Var) {
        this.f774a.q(e0Var);
    }

    void l(androidx.core.graphics.b bVar) {
        this.f774a.r(bVar);
    }

    public WindowInsets m() {
        l lVar = this.f774a;
        if (lVar instanceof g) {
            return ((g) lVar).f794c;
        }
        return null;
    }
}
