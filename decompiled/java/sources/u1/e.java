package u1;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import u1.d;

/* loaded from: /root/release/classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final u1.d f4359a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4360b;

    /* renamed from: c, reason: collision with root package name */
    private final m f4361c;

    /* renamed from: d, reason: collision with root package name */
    private final d.c f4362d;

    public interface b {
        void a(Object obj);

        void b(String str, String str2, Object obj);
    }

    private final class c implements d.a {

        /* renamed from: a, reason: collision with root package name */
        private final d f4363a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicReference<b> f4364b = new AtomicReference<>(null);

        private final class a implements b {

            /* renamed from: a, reason: collision with root package name */
            final AtomicBoolean f4366a;

            private a() {
                this.f4366a = new AtomicBoolean(false);
            }

            @Override // u1.e.b
            public void a(Object obj) {
                if (this.f4366a.get() || c.this.f4364b.get() != this) {
                    return;
                }
                e.this.f4359a.f(e.this.f4360b, e.this.f4361c.c(obj));
            }

            @Override // u1.e.b
            public void b(String str, String str2, Object obj) {
                if (this.f4366a.get() || c.this.f4364b.get() != this) {
                    return;
                }
                e.this.f4359a.f(e.this.f4360b, e.this.f4361c.e(str, str2, obj));
            }
        }

        c(d dVar) {
            this.f4363a = dVar;
        }

        private void c(Object obj, d.b bVar) {
            ByteBuffer e3;
            if (this.f4364b.getAndSet(null) != null) {
                try {
                    this.f4363a.a(obj);
                    bVar.a(e.this.f4361c.c(null));
                    return;
                } catch (RuntimeException e4) {
                    g1.b.c("EventChannel#" + e.this.f4360b, "Failed to close event stream", e4);
                    e3 = e.this.f4361c.e("error", e4.getMessage(), null);
                }
            } else {
                e3 = e.this.f4361c.e("error", "No active stream to cancel", null);
            }
            bVar.a(e3);
        }

        private void d(Object obj, d.b bVar) {
            a aVar = new a();
            if (this.f4364b.getAndSet(aVar) != null) {
                try {
                    this.f4363a.a(null);
                } catch (RuntimeException e3) {
                    g1.b.c("EventChannel#" + e.this.f4360b, "Failed to close existing event stream", e3);
                }
            }
            try {
                this.f4363a.c(obj, aVar);
                bVar.a(e.this.f4361c.c(null));
            } catch (RuntimeException e4) {
                this.f4364b.set(null);
                g1.b.c("EventChannel#" + e.this.f4360b, "Failed to open event stream", e4);
                bVar.a(e.this.f4361c.e("error", e4.getMessage(), null));
            }
        }

        @Override // u1.d.a
        public void a(ByteBuffer byteBuffer, d.b bVar) {
            k a4 = e.this.f4361c.a(byteBuffer);
            if (a4.f4372a.equals("listen")) {
                d(a4.f4373b, bVar);
            } else if (a4.f4372a.equals("cancel")) {
                c(a4.f4373b, bVar);
            } else {
                bVar.a(null);
            }
        }
    }

    public interface d {
        void a(Object obj);

        void c(Object obj, b bVar);
    }

    public e(u1.d dVar, String str) {
        this(dVar, str, p.f4387b);
    }

    public e(u1.d dVar, String str, m mVar) {
        this(dVar, str, mVar, null);
    }

    public e(u1.d dVar, String str, m mVar, d.c cVar) {
        this.f4359a = dVar;
        this.f4360b = str;
        this.f4361c = mVar;
        this.f4362d = cVar;
    }

    public void d(d dVar) {
        if (this.f4362d != null) {
            this.f4359a.e(this.f4360b, dVar != null ? new c(dVar) : null, this.f4362d);
        } else {
            this.f4359a.d(this.f4360b, dVar != null ? new c(dVar) : null);
        }
    }
}
