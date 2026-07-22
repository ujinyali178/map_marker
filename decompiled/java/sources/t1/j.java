package t1;

import java.util.HashMap;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final u1.l f4156a;

    /* renamed from: b, reason: collision with root package name */
    private final l.c f4157b;

    class a implements l.c {
        a() {
        }

        @Override // u1.l.c
        public void n(u1.k kVar, l.d dVar) {
            dVar.a(null);
        }
    }

    public j(i1.a aVar) {
        a aVar2 = new a();
        this.f4157b = aVar2;
        u1.l lVar = new u1.l(aVar, "flutter/navigation", u1.h.f4371a);
        this.f4156a = lVar;
        lVar.e(aVar2);
    }

    public void a() {
        g1.b.f("NavigationChannel", "Sending message to pop route.");
        this.f4156a.c("popRoute", null);
    }

    public void b(String str) {
        g1.b.f("NavigationChannel", "Sending message to push route information '" + str + "'");
        HashMap hashMap = new HashMap();
        hashMap.put("location", str);
        this.f4156a.c("pushRouteInformation", hashMap);
    }

    public void c(String str) {
        g1.b.f("NavigationChannel", "Sending message to set initial route to '" + str + "'");
        this.f4156a.c("setInitialRoute", str);
    }
}
