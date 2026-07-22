package t1;

import java.util.ArrayList;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final u1.l f4280a;

    /* renamed from: b, reason: collision with root package name */
    private b f4281b;

    /* renamed from: c, reason: collision with root package name */
    public final l.c f4282c;

    class a implements l.c {
        a() {
        }

        @Override // u1.l.c
        public void n(u1.k kVar, l.d dVar) {
            if (q.this.f4281b == null) {
                g1.b.f("SpellCheckChannel", "No SpellCheckeMethodHandler registered, call not forwarded to spell check API.");
                return;
            }
            String str = kVar.f4372a;
            Object obj = kVar.f4373b;
            g1.b.f("SpellCheckChannel", "Received '" + str + "' message.");
            str.hashCode();
            if (!str.equals("SpellCheck.initiateSpellCheck")) {
                dVar.c();
                return;
            }
            try {
                ArrayList arrayList = (ArrayList) obj;
                q.this.f4281b.a((String) arrayList.get(0), (String) arrayList.get(1), dVar);
            } catch (IllegalStateException e3) {
                dVar.b("error", e3.getMessage(), null);
            }
        }
    }

    public interface b {
        void a(String str, String str2, l.d dVar);
    }

    public q(i1.a aVar) {
        a aVar2 = new a();
        this.f4282c = aVar2;
        u1.l lVar = new u1.l(aVar, "flutter/spellcheck", u1.p.f4387b);
        this.f4280a = lVar;
        lVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f4281b = bVar;
    }
}
