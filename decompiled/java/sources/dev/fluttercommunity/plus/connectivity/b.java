package dev.fluttercommunity.plus.connectivity;

import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
class b implements l.c {

    /* renamed from: c, reason: collision with root package name */
    private final a f2473c;

    b(a aVar) {
        this.f2473c = aVar;
    }

    @Override // u1.l.c
    public void n(k kVar, l.d dVar) {
        if ("check".equals(kVar.f4372a)) {
            dVar.a(this.f2473c.d());
        } else {
            dVar.c();
        }
    }
}
