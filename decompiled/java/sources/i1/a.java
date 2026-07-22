package i1;

import android.content.res.AssetManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.List;
import u1.d;
import u1.q;

/* loaded from: /root/release/classes.dex */
public class a implements u1.d {

    /* renamed from: c, reason: collision with root package name */
    private final FlutterJNI f2639c;

    /* renamed from: d, reason: collision with root package name */
    private final AssetManager f2640d;

    /* renamed from: f, reason: collision with root package name */
    private final i1.c f2641f;

    /* renamed from: g, reason: collision with root package name */
    private final u1.d f2642g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2643h;

    /* renamed from: i, reason: collision with root package name */
    private String f2644i;

    /* renamed from: j, reason: collision with root package name */
    private d f2645j;

    /* renamed from: k, reason: collision with root package name */
    private final d.a f2646k;

    /* renamed from: i1.a$a, reason: collision with other inner class name */
    class C0081a implements d.a {
        C0081a() {
        }

        @Override // u1.d.a
        public void a(ByteBuffer byteBuffer, d.b bVar) {
            a.this.f2644i = q.f4390b.b(byteBuffer);
            if (a.this.f2645j != null) {
                a.this.f2645j.a(a.this.f2644i);
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f2648a;

        /* renamed from: b, reason: collision with root package name */
        public final String f2649b;

        /* renamed from: c, reason: collision with root package name */
        public final String f2650c;

        public b(String str, String str2) {
            this.f2648a = str;
            this.f2649b = null;
            this.f2650c = str2;
        }

        public b(String str, String str2, String str3) {
            this.f2648a = str;
            this.f2649b = str2;
            this.f2650c = str3;
        }

        public static b a() {
            k1.d c3 = g1.a.e().c();
            if (c3.l()) {
                return new b(c3.g(), "main");
            }
            throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f2648a.equals(bVar.f2648a)) {
                return this.f2650c.equals(bVar.f2650c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f2648a.hashCode() * 31) + this.f2650c.hashCode();
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.f2648a + ", function: " + this.f2650c + " )";
        }
    }

    private static class c implements u1.d {

        /* renamed from: c, reason: collision with root package name */
        private final i1.c f2651c;

        private c(i1.c cVar) {
            this.f2651c = cVar;
        }

        /* synthetic */ c(i1.c cVar, C0081a c0081a) {
            this(cVar);
        }

        @Override // u1.d
        public d.c a(d.C0107d c0107d) {
            return this.f2651c.a(c0107d);
        }

        @Override // u1.d
        public /* synthetic */ d.c b() {
            return u1.c.a(this);
        }

        @Override // u1.d
        public void d(String str, d.a aVar) {
            this.f2651c.d(str, aVar);
        }

        @Override // u1.d
        public void e(String str, d.a aVar, d.c cVar) {
            this.f2651c.e(str, aVar, cVar);
        }

        @Override // u1.d
        public void f(String str, ByteBuffer byteBuffer) {
            this.f2651c.i(str, byteBuffer, null);
        }

        @Override // u1.d
        public void i(String str, ByteBuffer byteBuffer, d.b bVar) {
            this.f2651c.i(str, byteBuffer, bVar);
        }
    }

    public interface d {
        void a(String str);
    }

    public a(FlutterJNI flutterJNI, AssetManager assetManager) {
        this.f2643h = false;
        C0081a c0081a = new C0081a();
        this.f2646k = c0081a;
        this.f2639c = flutterJNI;
        this.f2640d = assetManager;
        i1.c cVar = new i1.c(flutterJNI);
        this.f2641f = cVar;
        cVar.d("flutter/isolate", c0081a);
        this.f2642g = new c(cVar, null);
        if (flutterJNI.isAttached()) {
            this.f2643h = true;
        }
    }

    @Override // u1.d
    @Deprecated
    public d.c a(d.C0107d c0107d) {
        return this.f2642g.a(c0107d);
    }

    @Override // u1.d
    public /* synthetic */ d.c b() {
        return u1.c.a(this);
    }

    @Override // u1.d
    @Deprecated
    public void d(String str, d.a aVar) {
        this.f2642g.d(str, aVar);
    }

    @Override // u1.d
    @Deprecated
    public void e(String str, d.a aVar, d.c cVar) {
        this.f2642g.e(str, aVar, cVar);
    }

    @Override // u1.d
    @Deprecated
    public void f(String str, ByteBuffer byteBuffer) {
        this.f2642g.f(str, byteBuffer);
    }

    @Override // u1.d
    @Deprecated
    public void i(String str, ByteBuffer byteBuffer, d.b bVar) {
        this.f2642g.i(str, byteBuffer, bVar);
    }

    public void j(b bVar, List<String> list) {
        if (this.f2643h) {
            g1.b.g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        e2.e f3 = e2.e.f("DartExecutor#executeDartEntrypoint");
        try {
            g1.b.f("DartExecutor", "Executing Dart entrypoint: " + bVar);
            this.f2639c.runBundleAndSnapshotFromLibrary(bVar.f2648a, bVar.f2650c, bVar.f2649b, this.f2640d, list);
            this.f2643h = true;
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public u1.d k() {
        return this.f2642g;
    }

    public boolean l() {
        return this.f2643h;
    }

    public void m() {
        if (this.f2639c.isAttached()) {
            this.f2639c.notifyLowMemoryWarning();
        }
    }

    public void n() {
        g1.b.f("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.f2639c.setPlatformMessageHandler(this.f2641f);
    }

    public void o() {
        g1.b.f("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.f2639c.setPlatformMessageHandler(null);
    }
}
