package x0;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.google.maps.android.BuildConfig;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import m1.a;
import u1.k;
import u1.l;
import x0.e;

/* loaded from: /root/release/classes.dex */
public class e implements l.c, m1.a {

    /* renamed from: c, reason: collision with root package name */
    private l f4563c;

    /* renamed from: d, reason: collision with root package name */
    private x0.a f4564d;

    /* renamed from: f, reason: collision with root package name */
    private HandlerThread f4565f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f4566g;

    static class a implements l.d {

        /* renamed from: a, reason: collision with root package name */
        private final l.d f4567a;

        /* renamed from: b, reason: collision with root package name */
        private final Handler f4568b = new Handler(Looper.getMainLooper());

        a(l.d dVar) {
            this.f4567a = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String str, String str2, Object obj) {
            this.f4567a.b(str, str2, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(Object obj) {
            this.f4567a.a(obj);
        }

        @Override // u1.l.d
        public void a(final Object obj) {
            this.f4568b.post(new Runnable() { // from class: x0.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.this.g(obj);
                }
            });
        }

        @Override // u1.l.d
        public void b(final String str, final String str2, final Object obj) {
            this.f4568b.post(new Runnable() { // from class: x0.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.this.f(str, str2, obj);
                }
            });
        }

        @Override // u1.l.d
        public void c() {
            Handler handler = this.f4568b;
            final l.d dVar = this.f4567a;
            Objects.requireNonNull(dVar);
            handler.post(new Runnable() { // from class: x0.b
                @Override // java.lang.Runnable
                public final void run() {
                    l.d.this.c();
                }
            });
        }
    }

    class b implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        private final k f4569c;

        /* renamed from: d, reason: collision with root package name */
        private final l.d f4570d;

        b(k kVar, l.d dVar) {
            this.f4569c = kVar;
            this.f4570d = dVar;
        }

        private void a(Exception exc) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            this.f4570d.b("Exception encountered", this.f4569c.f4372a, stringWriter.toString());
        }

        @Override // java.lang.Runnable
        public void run() {
            Exception e3;
            boolean z3;
            l.d dVar;
            Object n3;
            l.d dVar2;
            char c3 = 0;
            try {
                try {
                    e.this.f4564d.f4550e = (Map) ((Map) this.f4569c.f4373b).get("options");
                    e.this.f4564d.h();
                    z3 = e.this.f4564d.i();
                } catch (FileNotFoundException e4) {
                    Log.i("Creating sharedPrefs", e4.getLocalizedMessage());
                    return;
                }
            } catch (Exception e5) {
                e3 = e5;
                z3 = false;
            }
            try {
                String str = this.f4569c.f4372a;
                switch (str.hashCode()) {
                    case -1335458389:
                        if (str.equals("delete")) {
                            c3 = 4;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case -358737930:
                        if (str.equals("deleteAll")) {
                            c3 = 5;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 3496342:
                        if (str.equals("read")) {
                            c3 = 1;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 113399775:
                        if (str.equals("write")) {
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 208013248:
                        if (str.equals("containsKey")) {
                            c3 = 3;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1080375339:
                        if (str.equals("readAll")) {
                            c3 = 2;
                            break;
                        }
                        c3 = 65535;
                        break;
                    default:
                        c3 = 65535;
                        break;
                }
                Map<String, String> map = null;
                if (c3 == 0) {
                    String f3 = e.this.f(this.f4569c);
                    String g3 = e.this.g(this.f4569c);
                    if (g3 == null) {
                        this.f4570d.b(BuildConfig.TRAVIS, null, null);
                        return;
                    } else {
                        e.this.f4564d.p(f3, g3);
                        dVar = this.f4570d;
                    }
                } else if (c3 == 1) {
                    String f4 = e.this.f(this.f4569c);
                    if (e.this.f4564d.c(f4)) {
                        n3 = e.this.f4564d.n(f4);
                        dVar2 = this.f4570d;
                        dVar2.a(n3);
                        return;
                    }
                    dVar = this.f4570d;
                } else if (c3 == 2) {
                    dVar = this.f4570d;
                    map = e.this.f4564d.o();
                } else {
                    if (c3 == 3) {
                        boolean c4 = e.this.f4564d.c(e.this.f(this.f4569c));
                        dVar2 = this.f4570d;
                        n3 = Boolean.valueOf(c4);
                        dVar2.a(n3);
                        return;
                    }
                    if (c3 == 4) {
                        e.this.f4564d.e(e.this.f(this.f4569c));
                        dVar = this.f4570d;
                    } else if (c3 != 5) {
                        this.f4570d.c();
                        return;
                    } else {
                        e.this.f4564d.f();
                        dVar = this.f4570d;
                    }
                }
                dVar.a(map);
            } catch (Exception e6) {
                e3 = e6;
                if (z3) {
                    try {
                        e.this.f4564d.f();
                        this.f4570d.a("Data has been reset");
                        return;
                    } catch (Exception e7) {
                        e3 = e7;
                        a(e3);
                    }
                }
                a(e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(k kVar) {
        return this.f4564d.a((String) ((Map) kVar.f4373b).get("key"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g(k kVar) {
        return (String) ((Map) kVar.f4373b).get("value");
    }

    @Override // m1.a
    public void b(a.b bVar) {
        h(bVar.b(), bVar.a());
    }

    @Override // m1.a
    public void e(a.b bVar) {
        if (this.f4563c != null) {
            this.f4565f.quitSafely();
            this.f4565f = null;
            this.f4563c.e(null);
            this.f4563c = null;
        }
        this.f4564d = null;
    }

    public void h(u1.d dVar, Context context) {
        try {
            this.f4564d = new x0.a(context, new HashMap());
            HandlerThread handlerThread = new HandlerThread("com.it_nomads.fluttersecurestorage.worker");
            this.f4565f = handlerThread;
            handlerThread.start();
            this.f4566g = new Handler(this.f4565f.getLooper());
            l lVar = new l(dVar, "plugins.it_nomads.com/flutter_secure_storage");
            this.f4563c = lVar;
            lVar.e(this);
        } catch (Exception e3) {
            Log.e("FlutterSecureStoragePl", "Registration failed", e3);
        }
    }

    @Override // u1.l.c
    public void n(k kVar, l.d dVar) {
        this.f4566g.post(new b(kVar, new a(dVar)));
    }
}
