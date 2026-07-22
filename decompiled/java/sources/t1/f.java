package t1;

import java.util.HashMap;
import java.util.Map;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final u1.l f4132a;

    /* renamed from: b, reason: collision with root package name */
    private b f4133b;

    /* renamed from: c, reason: collision with root package name */
    public final l.c f4134c;

    class a implements l.c {

        /* renamed from: c, reason: collision with root package name */
        Map<Long, Long> f4135c = new HashMap();

        a() {
        }

        @Override // u1.l.c
        public void n(u1.k kVar, l.d dVar) {
            if (f.this.f4133b != null) {
                String str = kVar.f4372a;
                str.hashCode();
                if (!str.equals("getKeyboardState")) {
                    dVar.c();
                    return;
                } else {
                    try {
                        this.f4135c = f.this.f4133b.b();
                    } catch (IllegalStateException e3) {
                        dVar.b("error", e3.getMessage(), null);
                    }
                }
            }
            dVar.a(this.f4135c);
        }
    }

    public interface b {
        Map<Long, Long> b();
    }

    public f(u1.d dVar) {
        a aVar = new a();
        this.f4134c = aVar;
        u1.l lVar = new u1.l(dVar, "flutter/keyboard", u1.p.f4387b);
        this.f4132a = lVar;
        lVar.e(aVar);
    }

    public void b(b bVar) {
        this.f4133b = bVar;
    }
}
