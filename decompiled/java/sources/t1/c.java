package t1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final u1.l f4123a;

    /* renamed from: b, reason: collision with root package name */
    private j1.a f4124b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, List<l.d>> f4125c;

    /* renamed from: d, reason: collision with root package name */
    final l.c f4126d;

    class a implements l.c {
        a() {
        }

        @Override // u1.l.c
        public void n(u1.k kVar, l.d dVar) {
            int intValue;
            String str;
            String str2;
            if (c.this.f4124b == null) {
                return;
            }
            String str3 = kVar.f4372a;
            Map map = (Map) kVar.b();
            g1.b.f("DeferredComponentChannel", "Received '" + str3 + "' message.");
            intValue = ((Integer) map.get("loadingUnitId")).intValue();
            str = (String) map.get("componentName");
            str3.hashCode();
            switch (str3) {
                case "uninstallDeferredComponent":
                    c.this.f4124b.c(intValue, str);
                    str2 = null;
                    break;
                case "getDeferredComponentInstallState":
                    str2 = c.this.f4124b.b(intValue, str);
                    break;
                case "installDeferredComponent":
                    c.this.f4124b.a(intValue, str);
                    if (!c.this.f4125c.containsKey(str)) {
                        c.this.f4125c.put(str, new ArrayList());
                    }
                    ((List) c.this.f4125c.get(str)).add(dVar);
                    return;
                default:
                    dVar.c();
                    return;
            }
            dVar.a(str2);
        }
    }

    public c(i1.a aVar) {
        a aVar2 = new a();
        this.f4126d = aVar2;
        u1.l lVar = new u1.l(aVar, "flutter/deferredcomponent", u1.p.f4387b);
        this.f4123a = lVar;
        lVar.e(aVar2);
        this.f4124b = g1.a.e().a();
        this.f4125c = new HashMap();
    }

    public void c(j1.a aVar) {
        this.f4124b = aVar;
    }
}
