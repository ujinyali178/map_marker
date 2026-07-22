package i1;

import i1.c;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import u1.d;

/* loaded from: /root/release/classes.dex */
class c implements u1.d, i1.f {

    /* renamed from: c, reason: collision with root package name */
    private final FlutterJNI f2658c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, f> f2659d;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, List<b>> f2660f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f2661g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f2662h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<Integer, d.b> f2663i;

    /* renamed from: j, reason: collision with root package name */
    private int f2664j;

    /* renamed from: k, reason: collision with root package name */
    private final d f2665k;

    /* renamed from: l, reason: collision with root package name */
    private WeakHashMap<d.c, d> f2666l;

    /* renamed from: m, reason: collision with root package name */
    private i f2667m;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f2668a;

        /* renamed from: b, reason: collision with root package name */
        int f2669b;

        /* renamed from: c, reason: collision with root package name */
        long f2670c;

        b(ByteBuffer byteBuffer, int i3, long j3) {
            this.f2668a = byteBuffer;
            this.f2669b = i3;
            this.f2670c = j3;
        }
    }

    /* renamed from: i1.c$c, reason: collision with other inner class name */
    static class C0082c implements d {

        /* renamed from: a, reason: collision with root package name */
        private final ExecutorService f2671a;

        C0082c(ExecutorService executorService) {
            this.f2671a = executorService;
        }

        @Override // i1.c.d
        public void a(Runnable runnable) {
            this.f2671a.execute(runnable);
        }
    }

    interface d {
        void a(Runnable runnable);
    }

    private static class e implements i {

        /* renamed from: a, reason: collision with root package name */
        ExecutorService f2672a = g1.a.e().b();

        e() {
        }

        @Override // i1.c.i
        public d a(d.C0107d c0107d) {
            return c0107d.a() ? new h(this.f2672a) : new C0082c(this.f2672a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class f {

        /* renamed from: a, reason: collision with root package name */
        public final d.a f2673a;

        /* renamed from: b, reason: collision with root package name */
        public final d f2674b;

        f(d.a aVar, d dVar) {
            this.f2673a = aVar;
            this.f2674b = dVar;
        }
    }

    static class g implements d.b {

        /* renamed from: a, reason: collision with root package name */
        private final FlutterJNI f2675a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2676b;

        /* renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f2677c = new AtomicBoolean(false);

        g(FlutterJNI flutterJNI, int i3) {
            this.f2675a = flutterJNI;
            this.f2676b = i3;
        }

        @Override // u1.d.b
        public void a(ByteBuffer byteBuffer) {
            if (this.f2677c.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.f2675a.invokePlatformMessageEmptyResponseCallback(this.f2676b);
            } else {
                this.f2675a.invokePlatformMessageResponseCallback(this.f2676b, byteBuffer, byteBuffer.position());
            }
        }
    }

    static class h implements d {

        /* renamed from: a, reason: collision with root package name */
        private final ExecutorService f2678a;

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue<Runnable> f2679b = new ConcurrentLinkedQueue<>();

        /* renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f2680c = new AtomicBoolean(false);

        h(ExecutorService executorService) {
            this.f2678a = executorService;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public void f() {
            if (this.f2680c.compareAndSet(false, true)) {
                try {
                    Runnable poll = this.f2679b.poll();
                    if (poll != null) {
                        poll.run();
                    }
                } finally {
                    this.f2680c.set(false);
                    if (!this.f2679b.isEmpty()) {
                        this.f2678a.execute(new Runnable() { // from class: i1.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                c.h.this.f();
                            }
                        });
                    }
                }
            }
        }

        @Override // i1.c.d
        public void a(Runnable runnable) {
            this.f2679b.add(runnable);
            this.f2678a.execute(new Runnable() { // from class: i1.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.h.this.e();
                }
            });
        }
    }

    interface i {
        d a(d.C0107d c0107d);
    }

    private static class j implements d.c {
        private j() {
        }
    }

    c(FlutterJNI flutterJNI) {
        this(flutterJNI, new e());
    }

    c(FlutterJNI flutterJNI, i iVar) {
        this.f2659d = new HashMap();
        this.f2660f = new HashMap();
        this.f2661g = new Object();
        this.f2662h = new AtomicBoolean(false);
        this.f2663i = new HashMap();
        this.f2664j = 1;
        this.f2665k = new i1.g();
        this.f2666l = new WeakHashMap<>();
        this.f2658c = flutterJNI;
        this.f2667m = iVar;
    }

    private void j(final String str, final f fVar, final ByteBuffer byteBuffer, final int i3, final long j3) {
        d dVar = fVar != null ? fVar.f2674b : null;
        e2.e.b("PlatformChannel ScheduleHandler on " + str, i3);
        Runnable runnable = new Runnable() { // from class: i1.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.m(str, i3, fVar, byteBuffer, j3);
            }
        };
        if (dVar == null) {
            dVar = this.f2665k;
        }
        dVar.a(runnable);
    }

    private static void k(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() == null) {
            throw error;
        }
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
    }

    private void l(f fVar, ByteBuffer byteBuffer, int i3) {
        if (fVar != null) {
            try {
                g1.b.f("DartMessenger", "Deferring to registered handler to process message.");
                fVar.f2673a.a(byteBuffer, new g(this.f2658c, i3));
                return;
            } catch (Error e3) {
                k(e3);
                return;
            } catch (Exception e4) {
                g1.b.c("DartMessenger", "Uncaught exception in binary message listener", e4);
            }
        } else {
            g1.b.f("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
        }
        this.f2658c.invokePlatformMessageEmptyResponseCallback(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(String str, int i3, f fVar, ByteBuffer byteBuffer, long j3) {
        e2.e.e("PlatformChannel ScheduleHandler on " + str, i3);
        try {
            e2.e f3 = e2.e.f("DartMessenger#handleMessageFromDart on " + str);
            try {
                l(fVar, byteBuffer, i3);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
                if (f3 != null) {
                    f3.close();
                }
            } finally {
            }
        } finally {
            this.f2658c.cleanupMessageData(j3);
        }
    }

    @Override // u1.d
    public d.c a(d.C0107d c0107d) {
        d a4 = this.f2667m.a(c0107d);
        j jVar = new j();
        this.f2666l.put(jVar, a4);
        return jVar;
    }

    @Override // u1.d
    public /* synthetic */ d.c b() {
        return u1.c.a(this);
    }

    @Override // i1.f
    public void c(int i3, ByteBuffer byteBuffer) {
        g1.b.f("DartMessenger", "Received message reply from Dart.");
        d.b remove = this.f2663i.remove(Integer.valueOf(i3));
        if (remove != null) {
            try {
                g1.b.f("DartMessenger", "Invoking registered callback for reply from Dart.");
                remove.a(byteBuffer);
                if (byteBuffer == null || !byteBuffer.isDirect()) {
                    return;
                }
                byteBuffer.limit(0);
            } catch (Error e3) {
                k(e3);
            } catch (Exception e4) {
                g1.b.c("DartMessenger", "Uncaught exception in binary message reply handler", e4);
            }
        }
    }

    @Override // u1.d
    public void d(String str, d.a aVar) {
        e(str, aVar, null);
    }

    @Override // u1.d
    public void e(String str, d.a aVar, d.c cVar) {
        if (aVar == null) {
            g1.b.f("DartMessenger", "Removing handler for channel '" + str + "'");
            synchronized (this.f2661g) {
                this.f2659d.remove(str);
            }
            return;
        }
        d dVar = null;
        if (cVar != null && (dVar = this.f2666l.get(cVar)) == null) {
            throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
        }
        g1.b.f("DartMessenger", "Setting handler for channel '" + str + "'");
        synchronized (this.f2661g) {
            this.f2659d.put(str, new f(aVar, dVar));
            List<b> remove = this.f2660f.remove(str);
            if (remove == null) {
                return;
            }
            for (b bVar : remove) {
                j(str, this.f2659d.get(str), bVar.f2668a, bVar.f2669b, bVar.f2670c);
            }
        }
    }

    @Override // u1.d
    public void f(String str, ByteBuffer byteBuffer) {
        g1.b.f("DartMessenger", "Sending message over channel '" + str + "'");
        i(str, byteBuffer, null);
    }

    @Override // i1.f
    public void g(String str, ByteBuffer byteBuffer, int i3, long j3) {
        f fVar;
        boolean z3;
        g1.b.f("DartMessenger", "Received message from Dart over channel '" + str + "'");
        synchronized (this.f2661g) {
            fVar = this.f2659d.get(str);
            z3 = this.f2662h.get() && fVar == null;
            if (z3) {
                if (!this.f2660f.containsKey(str)) {
                    this.f2660f.put(str, new LinkedList());
                }
                this.f2660f.get(str).add(new b(byteBuffer, i3, j3));
            }
        }
        if (z3) {
            return;
        }
        j(str, fVar, byteBuffer, i3, j3);
    }

    @Override // u1.d
    public void i(String str, ByteBuffer byteBuffer, d.b bVar) {
        e2.e f3 = e2.e.f("DartMessenger#send on " + str);
        try {
            g1.b.f("DartMessenger", "Sending message with callback over channel '" + str + "'");
            int i3 = this.f2664j;
            this.f2664j = i3 + 1;
            if (bVar != null) {
                this.f2663i.put(Integer.valueOf(i3), bVar);
            }
            if (byteBuffer == null) {
                this.f2658c.dispatchEmptyPlatformMessage(str, i3);
            } else {
                this.f2658c.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i3);
            }
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
}
