package io.flutter.embedding.engine;

import android.content.Context;
import i1.a;
import io.flutter.embedding.engine.a;
import io.flutter.plugin.platform.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    final List<io.flutter.embedding.engine.a> f2957a = new ArrayList();

    class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ io.flutter.embedding.engine.a f2958a;

        a(io.flutter.embedding.engine.a aVar) {
            this.f2958a = aVar;
        }

        @Override // io.flutter.embedding.engine.a.b
        public void a() {
            d.this.f2957a.remove(this.f2958a);
        }

        @Override // io.flutter.embedding.engine.a.b
        public void b() {
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Context f2960a;

        /* renamed from: b, reason: collision with root package name */
        private a.b f2961b;

        /* renamed from: c, reason: collision with root package name */
        private String f2962c;

        /* renamed from: d, reason: collision with root package name */
        private List<String> f2963d;

        /* renamed from: e, reason: collision with root package name */
        private y f2964e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f2965f = true;

        /* renamed from: g, reason: collision with root package name */
        private boolean f2966g = false;

        public b(Context context) {
            this.f2960a = context;
        }

        public boolean a() {
            return this.f2965f;
        }

        public Context b() {
            return this.f2960a;
        }

        public a.b c() {
            return this.f2961b;
        }

        public List<String> d() {
            return this.f2963d;
        }

        public String e() {
            return this.f2962c;
        }

        public y f() {
            return this.f2964e;
        }

        public boolean g() {
            return this.f2966g;
        }

        public b h(boolean z3) {
            this.f2965f = z3;
            return this;
        }

        public b i(a.b bVar) {
            this.f2961b = bVar;
            return this;
        }

        public b j(List<String> list) {
            this.f2963d = list;
            return this;
        }

        public b k(String str) {
            this.f2962c = str;
            return this;
        }

        public b l(boolean z3) {
            this.f2966g = z3;
            return this;
        }
    }

    public d(Context context, String[] strArr) {
        k1.d c3 = g1.a.e().c();
        if (c3.l()) {
            return;
        }
        c3.n(context.getApplicationContext());
        c3.f(context.getApplicationContext(), strArr);
    }

    public io.flutter.embedding.engine.a a(b bVar) {
        io.flutter.embedding.engine.a A;
        Context b4 = bVar.b();
        a.b c3 = bVar.c();
        String e3 = bVar.e();
        List<String> d3 = bVar.d();
        y f3 = bVar.f();
        if (f3 == null) {
            f3 = new y();
        }
        y yVar = f3;
        boolean a4 = bVar.a();
        boolean g3 = bVar.g();
        a.b a5 = c3 == null ? a.b.a() : c3;
        if (this.f2957a.size() == 0) {
            A = b(b4, yVar, a4, g3);
            if (e3 != null) {
                A.o().c(e3);
            }
            A.k().j(a5, d3);
        } else {
            A = this.f2957a.get(0).A(b4, a5, e3, d3, yVar, a4, g3);
        }
        this.f2957a.add(A);
        A.e(new a(A));
        return A;
    }

    io.flutter.embedding.engine.a b(Context context, y yVar, boolean z3, boolean z4) {
        return new io.flutter.embedding.engine.a(context, null, null, yVar, null, z3, z4, this);
    }
}
