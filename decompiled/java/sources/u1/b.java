package u1;

import java.nio.ByteBuffer;
import u1.d;

/* loaded from: /root/release/classes.dex */
public final class b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final u1.d f4348a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4349b;

    /* renamed from: c, reason: collision with root package name */
    private final j<T> f4350c;

    /* renamed from: d, reason: collision with root package name */
    private final d.c f4351d;

    /* renamed from: u1.b$b, reason: collision with other inner class name */
    private final class C0106b implements d.a {

        /* renamed from: a, reason: collision with root package name */
        private final d<T> f4352a;

        /* renamed from: u1.b$b$a */
        class a implements e<T> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.b f4354a;

            a(d.b bVar) {
                this.f4354a = bVar;
            }

            @Override // u1.b.e
            public void a(T t3) {
                this.f4354a.a(b.this.f4350c.a(t3));
            }
        }

        private C0106b(d<T> dVar) {
            this.f4352a = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u1.d.a
        public void a(ByteBuffer byteBuffer, d.b bVar) {
            try {
                this.f4352a.a(b.this.f4350c.b(byteBuffer), new a(bVar));
            } catch (RuntimeException e3) {
                g1.b.c("BasicMessageChannel#" + b.this.f4349b, "Failed to handle message", e3);
                bVar.a(null);
            }
        }
    }

    private final class c implements d.b {

        /* renamed from: a, reason: collision with root package name */
        private final e<T> f4356a;

        private c(e<T> eVar) {
            this.f4356a = eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u1.d.b
        public void a(ByteBuffer byteBuffer) {
            try {
                this.f4356a.a(b.this.f4350c.b(byteBuffer));
            } catch (RuntimeException e3) {
                g1.b.c("BasicMessageChannel#" + b.this.f4349b, "Failed to handle message reply", e3);
            }
        }
    }

    public interface d<T> {
        void a(T t3, e<T> eVar);
    }

    public interface e<T> {
        void a(T t3);
    }

    public b(u1.d dVar, String str, j<T> jVar) {
        this(dVar, str, jVar, null);
    }

    public b(u1.d dVar, String str, j<T> jVar, d.c cVar) {
        this.f4348a = dVar;
        this.f4349b = str;
        this.f4350c = jVar;
        this.f4351d = cVar;
    }

    public void c(T t3) {
        d(t3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d(T t3, e<T> eVar) {
        this.f4348a.i(this.f4349b, this.f4350c.a(t3), eVar != null ? new c(eVar) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [u1.d] */
    /* JADX WARN: Type inference failed for: r1v0, types: [u1.b$a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [u1.d$a] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public void e(d<T> dVar) {
        if (this.f4351d != null) {
            this.f4348a.e(this.f4349b, dVar != null ? new C0106b(dVar) : null, this.f4351d);
        } else {
            this.f4348a.d(this.f4349b, dVar != null ? new C0106b(dVar) : 0);
        }
    }
}
