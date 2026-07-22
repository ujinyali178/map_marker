package t1;

import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Map;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final u1.l f4248a;

    /* renamed from: b, reason: collision with root package name */
    public final PackageManager f4249b;

    /* renamed from: c, reason: collision with root package name */
    private b f4250c;

    /* renamed from: d, reason: collision with root package name */
    public final l.c f4251d;

    class a implements l.c {
        a() {
        }

        @Override // u1.l.c
        public void n(u1.k kVar, l.d dVar) {
            if (n.this.f4250c == null) {
                return;
            }
            String str = kVar.f4372a;
            Object obj = kVar.f4373b;
            str.hashCode();
            try {
                if (str.equals("ProcessText.processTextAction")) {
                    ArrayList arrayList = (ArrayList) obj;
                    n.this.f4250c.c((String) arrayList.get(0), (String) arrayList.get(1), ((Boolean) arrayList.get(2)).booleanValue(), dVar);
                } else {
                    if (!str.equals("ProcessText.queryTextActions")) {
                        dVar.c();
                        return;
                    }
                    dVar.a(n.this.f4250c.f());
                }
            } catch (IllegalStateException e3) {
                dVar.b("error", e3.getMessage(), null);
            }
        }
    }

    public interface b {
        void c(String str, String str2, boolean z3, l.d dVar);

        Map<String, String> f();
    }

    public n(i1.a aVar, PackageManager packageManager) {
        a aVar2 = new a();
        this.f4251d = aVar2;
        this.f4249b = packageManager;
        u1.l lVar = new u1.l(aVar, "flutter/processtext", u1.p.f4387b);
        this.f4248a = lVar;
        lVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f4250c = bVar;
    }
}
