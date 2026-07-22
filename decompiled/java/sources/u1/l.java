package u1;

import java.nio.ByteBuffer;
import u1.d;

/* loaded from: /root/release/classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final u1.d f4374a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4375b;

    /* renamed from: c, reason: collision with root package name */
    private final m f4376c;

    /* renamed from: d, reason: collision with root package name */
    private final d.c f4377d;

    private final class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        private final c f4378a;

        /* renamed from: u1.l$a$a, reason: collision with other inner class name */
        class C0108a implements d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.b f4380a;

            C0108a(d.b bVar) {
                this.f4380a = bVar;
            }

            @Override // u1.l.d
            public void a(Object obj) {
                this.f4380a.a(l.this.f4376c.c(obj));
            }

            @Override // u1.l.d
            public void b(String str, String str2, Object obj) {
                this.f4380a.a(l.this.f4376c.e(str, str2, obj));
            }

            @Override // u1.l.d
            public void c() {
                this.f4380a.a(null);
            }
        }

        a(c cVar) {
            this.f4378a = cVar;
        }

        @Override // u1.d.a
        public void a(ByteBuffer byteBuffer, d.b bVar) {
            try {
                this.f4378a.n(l.this.f4376c.a(byteBuffer), new C0108a(bVar));
            } catch (RuntimeException e3) {
                g1.b.c("MethodChannel#" + l.this.f4375b, "Failed to handle method call", e3);
                bVar.a(l.this.f4376c.d("error", e3.getMessage(), null, g1.b.d(e3)));
            }
        }
    }

    private final class b implements d.b {

        /* renamed from: a, reason: collision with root package name */
        private final d f4382a;

        b(d dVar) {
            this.f4382a = dVar;
        }

        @Override // u1.d.b
        public void a(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer == null) {
                    this.f4382a.c();
                } else {
                    try {
                        this.f4382a.a(l.this.f4376c.f(byteBuffer));
                    } catch (f e3) {
                        this.f4382a.b(e3.f4368c, e3.getMessage(), e3.f4369d);
                    }
                }
            } catch (RuntimeException e4) {
                g1.b.c("MethodChannel#" + l.this.f4375b, "Failed to handle method call result", e4);
            }
        }
    }

    public interface c {
        void n(k kVar, d dVar);
    }

    public interface d {
        void a(Object obj);

        void b(String str, String str2, Object obj);

        void c();
    }

    public l(u1.d dVar, String str) {
        this(dVar, str, p.f4387b);
    }

    public l(u1.d dVar, String str, m mVar) {
        this(dVar, str, mVar, null);
    }

    public l(u1.d dVar, String str, m mVar, d.c cVar) {
        this.f4374a = dVar;
        this.f4375b = str;
        this.f4376c = mVar;
        this.f4377d = cVar;
    }

    public void c(String str, Object obj) {
        d(str, obj, null);
    }

    public void d(String str, Object obj, d dVar) {
        this.f4374a.i(this.f4375b, this.f4376c.b(new k(str, obj)), dVar == null ? null : new b(dVar));
    }

    public void e(c cVar) {
        if (this.f4377d != null) {
            this.f4374a.e(this.f4375b, cVar != null ? new a(cVar) : null, this.f4377d);
        } else {
            this.f4374a.d(this.f4375b, cVar != null ? new a(cVar) : null);
        }
    }
}
