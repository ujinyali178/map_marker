package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: /root/release/classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    private final e f820a;

    private static class a extends e {

        /* renamed from: a, reason: collision with root package name */
        protected final Window f821a;

        /* renamed from: b, reason: collision with root package name */
        private final l f822b;

        a(Window window, l lVar) {
            this.f821a = window;
            this.f822b = lVar;
        }

        protected void c(int i3) {
            View decorView = this.f821a.getDecorView();
            decorView.setSystemUiVisibility(i3 | decorView.getSystemUiVisibility());
        }

        protected void d(int i3) {
            this.f821a.addFlags(i3);
        }

        protected void e(int i3) {
            View decorView = this.f821a.getDecorView();
            decorView.setSystemUiVisibility((~i3) & decorView.getSystemUiVisibility());
        }

        protected void f(int i3) {
            this.f821a.clearFlags(i3);
        }
    }

    private static class b extends a {
        b(Window window, l lVar) {
            super(window, lVar);
        }

        @Override // androidx.core.view.l0.e
        public void b(boolean z3) {
            if (!z3) {
                e(8192);
                return;
            }
            f(67108864);
            d(Integer.MIN_VALUE);
            c(8192);
        }
    }

    private static class c extends b {
        c(Window window, l lVar) {
            super(window, lVar);
        }

        @Override // androidx.core.view.l0.e
        public void a(boolean z3) {
            if (!z3) {
                e(16);
                return;
            }
            f(134217728);
            d(Integer.MIN_VALUE);
            c(16);
        }
    }

    private static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        final l0 f823a;

        /* renamed from: b, reason: collision with root package name */
        final WindowInsetsController f824b;

        /* renamed from: c, reason: collision with root package name */
        final l f825c;

        /* renamed from: d, reason: collision with root package name */
        private final androidx.collection.g<Object, WindowInsetsController.OnControllableInsetsChangedListener> f826d;

        /* renamed from: e, reason: collision with root package name */
        protected Window f827e;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        d(android.view.Window r2, androidx.core.view.l0 r3, androidx.core.view.l r4) {
            /*
                r1 = this;
                android.view.WindowInsetsController r0 = androidx.core.view.m0.a(r2)
                r1.<init>(r0, r3, r4)
                r1.f827e = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.l0.d.<init>(android.view.Window, androidx.core.view.l0, androidx.core.view.l):void");
        }

        d(WindowInsetsController windowInsetsController, l0 l0Var, l lVar) {
            this.f826d = new androidx.collection.g<>();
            this.f824b = windowInsetsController;
            this.f823a = l0Var;
            this.f825c = lVar;
        }

        @Override // androidx.core.view.l0.e
        public void a(boolean z3) {
            if (z3) {
                if (this.f827e != null) {
                    c(16);
                }
                this.f824b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f827e != null) {
                    d(16);
                }
                this.f824b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.l0.e
        public void b(boolean z3) {
            if (z3) {
                if (this.f827e != null) {
                    c(8192);
                }
                this.f824b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f827e != null) {
                    d(8192);
                }
                this.f824b.setSystemBarsAppearance(0, 8);
            }
        }

        protected void c(int i3) {
            View decorView = this.f827e.getDecorView();
            decorView.setSystemUiVisibility(i3 | decorView.getSystemUiVisibility());
        }

        protected void d(int i3) {
            View decorView = this.f827e.getDecorView();
            decorView.setSystemUiVisibility((~i3) & decorView.getSystemUiVisibility());
        }
    }

    private static class e {
        e() {
        }

        public void a(boolean z3) {
        }

        public void b(boolean z3) {
        }
    }

    public l0(Window window, View view) {
        l lVar = new l(view);
        int i3 = Build.VERSION.SDK_INT;
        this.f820a = i3 >= 30 ? new d(window, this, lVar) : i3 >= 26 ? new c(window, lVar) : i3 >= 23 ? new b(window, lVar) : new a(window, lVar);
    }

    public void a(boolean z3) {
        this.f820a.a(z3);
    }

    public void b(boolean z3) {
        this.f820a.b(z3);
    }
}
