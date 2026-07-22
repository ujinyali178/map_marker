package t1;

import java.util.HashMap;

/* loaded from: /root/release/classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public final u1.b<Object> f4284a;

    public r(i1.a aVar) {
        this.f4284a = new u1.b<>(aVar, "flutter/system", u1.g.f4370a);
    }

    public void a() {
        g1.b.f("SystemChannel", "Sending memory pressure warning to Flutter.");
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "memoryPressure");
        this.f4284a.c(hashMap);
    }
}
