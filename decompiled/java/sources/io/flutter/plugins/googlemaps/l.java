package io.flutter.plugins.googlemaps;

import m1.a;

/* loaded from: /root/release/classes.dex */
public class l implements m1.a, n1.a {

    /* renamed from: c, reason: collision with root package name */
    androidx.lifecycle.e f3312c;

    class a implements m {
        a() {
        }

        @Override // io.flutter.plugins.googlemaps.m
        public androidx.lifecycle.e getLifecycle() {
            return l.this.f3312c;
        }
    }

    @Override // m1.a
    public void b(a.b bVar) {
        bVar.d().a("plugins.flutter.dev/google_maps_android", new h(bVar.b(), bVar.a(), new a()));
    }

    @Override // n1.a
    public void d(n1.c cVar) {
        j(cVar);
    }

    @Override // m1.a
    public void e(a.b bVar) {
    }

    @Override // n1.a
    public void h() {
        i();
    }

    @Override // n1.a
    public void i() {
        this.f3312c = null;
    }

    @Override // n1.a
    public void j(n1.c cVar) {
        this.f3312c = q1.a.a(cVar);
    }
}
