package b1;

import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class d extends b1.a {

    /* renamed from: a, reason: collision with root package name */
    public final a f1559a;

    /* renamed from: b, reason: collision with root package name */
    final k f1560b;

    class a implements f {

        /* renamed from: a, reason: collision with root package name */
        final l.d f1561a;

        a(l.d dVar) {
            this.f1561a = dVar;
        }

        @Override // b1.f
        public void a(Object obj) {
            this.f1561a.a(obj);
        }

        @Override // b1.f
        public void b(String str, String str2, Object obj) {
            this.f1561a.b(str, str2, obj);
        }
    }

    public d(k kVar, l.d dVar) {
        this.f1560b = kVar;
        this.f1559a = new a(dVar);
    }

    @Override // b1.e
    public <T> T c(String str) {
        return (T) this.f1560b.a(str);
    }

    @Override // b1.e
    public String getMethod() {
        return this.f1560b.f4372a;
    }

    @Override // b1.e
    public boolean h(String str) {
        return this.f1560b.c(str);
    }

    @Override // b1.a
    public f n() {
        return this.f1559a;
    }
}
