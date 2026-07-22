package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /root/release/classes.dex */
public abstract class a<V> implements ListenableFuture<V> {

    /* renamed from: g, reason: collision with root package name */
    static final boolean f430g = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: h, reason: collision with root package name */
    private static final Logger f431h = Logger.getLogger(a.class.getName());

    /* renamed from: i, reason: collision with root package name */
    static final b f432i;

    /* renamed from: j, reason: collision with root package name */
    private static final Object f433j;

    /* renamed from: c, reason: collision with root package name */
    volatile Object f434c;

    /* renamed from: d, reason: collision with root package name */
    volatile e f435d;

    /* renamed from: f, reason: collision with root package name */
    volatile i f436f;

    private static abstract class b {
        private b() {
        }

        abstract boolean a(a<?> aVar, e eVar, e eVar2);

        abstract boolean b(a<?> aVar, Object obj, Object obj2);

        abstract boolean c(a<?> aVar, i iVar, i iVar2);

        abstract void d(i iVar, i iVar2);

        abstract void e(i iVar, Thread thread);
    }

    private static final class c {

        /* renamed from: c, reason: collision with root package name */
        static final c f437c;

        /* renamed from: d, reason: collision with root package name */
        static final c f438d;

        /* renamed from: a, reason: collision with root package name */
        final boolean f439a;

        /* renamed from: b, reason: collision with root package name */
        final Throwable f440b;

        static {
            if (a.f430g) {
                f438d = null;
                f437c = null;
            } else {
                f438d = new c(false, null);
                f437c = new c(true, null);
            }
        }

        c(boolean z3, Throwable th) {
            this.f439a = z3;
            this.f440b = th;
        }
    }

    private static final class d {

        /* renamed from: b, reason: collision with root package name */
        static final d f441b = new d(new C0008a("Failure occurred while trying to finish a future."));

        /* renamed from: a, reason: collision with root package name */
        final Throwable f442a;

        /* renamed from: androidx.concurrent.futures.a$d$a, reason: collision with other inner class name */
        class C0008a extends Throwable {
            C0008a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.f442a = (Throwable) a.d(th);
        }
    }

    private static final class e {

        /* renamed from: d, reason: collision with root package name */
        static final e f443d = new e(null, null);

        /* renamed from: a, reason: collision with root package name */
        final Runnable f444a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f445b;

        /* renamed from: c, reason: collision with root package name */
        e f446c;

        e(Runnable runnable, Executor executor) {
            this.f444a = runnable;
            this.f445b = executor;
        }
    }

    private static final class f extends b {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, Thread> f447a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, i> f448b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, i> f449c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, e> f450d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f451e;

        f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f447a = atomicReferenceFieldUpdater;
            this.f448b = atomicReferenceFieldUpdater2;
            this.f449c = atomicReferenceFieldUpdater3;
            this.f450d = atomicReferenceFieldUpdater4;
            this.f451e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.b.a(this.f450d, aVar, eVar, eVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.f451e, aVar, obj, obj2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            return androidx.concurrent.futures.b.a(this.f449c, aVar, iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void d(i iVar, i iVar2) {
            this.f448b.lazySet(iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void e(i iVar, Thread thread) {
            this.f447a.lazySet(iVar, thread);
        }
    }

    private static final class g<V> implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final a<V> f452c;

        /* renamed from: d, reason: collision with root package name */
        final ListenableFuture<? extends V> f453d;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f452c.f434c != this) {
                return;
            }
            if (a.f432i.b(this.f452c, this, a.i(this.f453d))) {
                a.f(this.f452c);
            }
        }
    }

    private static final class h extends b {
        h() {
            super();
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f435d != eVar) {
                    return false;
                }
                aVar.f435d = eVar2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f434c != obj) {
                    return false;
                }
                aVar.f434c = obj2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f436f != iVar) {
                    return false;
                }
                aVar.f436f = iVar2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.a.b
        void d(i iVar, i iVar2) {
            iVar.f456b = iVar2;
        }

        @Override // androidx.concurrent.futures.a.b
        void e(i iVar, Thread thread) {
            iVar.f455a = thread;
        }
    }

    private static final class i {

        /* renamed from: c, reason: collision with root package name */
        static final i f454c = new i(false);

        /* renamed from: a, reason: collision with root package name */
        volatile Thread f455a;

        /* renamed from: b, reason: collision with root package name */
        volatile i f456b;

        i() {
            a.f432i.e(this, Thread.currentThread());
        }

        i(boolean z3) {
        }

        void a(i iVar) {
            a.f432i.d(this, iVar);
        }

        void b() {
            Thread thread = this.f455a;
            if (thread != null) {
                this.f455a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "f"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "d"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "c"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        f432i = hVar;
        if (th != null) {
            f431h.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f433j = new Object();
    }

    protected a() {
    }

    private void a(StringBuilder sb) {
        String str = "]";
        try {
            Object j3 = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(p(j3));
            sb.append("]");
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (ExecutionException e4) {
            sb.append("FAILURE, cause=[");
            sb.append(e4.getCause());
            sb.append(str);
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T d(T t3) {
        t3.getClass();
        return t3;
    }

    private e e(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f435d;
        } while (!f432i.a(this, eVar2, e.f443d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f446c;
            eVar4.f446c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    static void f(a<?> aVar) {
        e eVar = null;
        while (true) {
            aVar.m();
            aVar.b();
            e e3 = aVar.e(eVar);
            while (e3 != null) {
                eVar = e3.f446c;
                Runnable runnable = e3.f444a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f452c;
                    if (aVar.f434c == gVar) {
                        if (f432i.b(aVar, gVar, i(gVar.f453d))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    g(runnable, e3.f445b);
                }
                e3 = eVar;
            }
            return;
        }
    }

    private static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e3) {
            f431h.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V h(Object obj) {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f440b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f442a);
        }
        if (obj == f433j) {
            return null;
        }
        return obj;
    }

    static Object i(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof a) {
            Object obj = ((a) listenableFuture).f434c;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f439a ? cVar.f440b != null ? new c(false, cVar.f440b) : c.f438d : obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f430g) && isCancelled) {
            return c.f438d;
        }
        try {
            Object j3 = j(listenableFuture);
            return j3 == null ? f433j : j3;
        } catch (CancellationException e3) {
            if (isCancelled) {
                return new c(false, e3);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e3));
        } catch (ExecutionException e4) {
            return new d(e4.getCause());
        } catch (Throwable th) {
            return new d(th);
        }
    }

    static <V> V j(Future<V> future) {
        V v3;
        boolean z3 = false;
        while (true) {
            try {
                v3 = future.get();
                break;
            } catch (InterruptedException unused) {
                z3 = true;
            } catch (Throwable th) {
                if (z3) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
        return v3;
    }

    private void m() {
        i iVar;
        do {
            iVar = this.f436f;
        } while (!f432i.c(this, iVar, i.f454c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f456b;
        }
    }

    private void n(i iVar) {
        iVar.f455a = null;
        while (true) {
            i iVar2 = this.f436f;
            if (iVar2 == i.f454c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f456b;
                if (iVar2.f455a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f456b = iVar4;
                    if (iVar3.f455a == null) {
                        break;
                    }
                } else if (!f432i.c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    private String p(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        e eVar = this.f435d;
        if (eVar != e.f443d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f446c = eVar;
                if (f432i.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f435d;
                }
            } while (eVar != e.f443d);
        }
        g(runnable, executor);
    }

    protected void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z3) {
        Object obj = this.f434c;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f430g ? new c(z3, new CancellationException("Future.cancel() was called.")) : z3 ? c.f437c : c.f438d;
        boolean z4 = false;
        a<V> aVar = this;
        while (true) {
            if (f432i.b(aVar, obj, cVar)) {
                if (z3) {
                    aVar.k();
                }
                f(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((g) obj).f453d;
                if (!(listenableFuture instanceof a)) {
                    listenableFuture.cancel(z3);
                    return true;
                }
                aVar = (a) listenableFuture;
                obj = aVar.f434c;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z4 = true;
            } else {
                obj = aVar.f434c;
                if (!(obj instanceof g)) {
                    return z4;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f434c;
        if ((obj2 != null) && (!(obj2 instanceof g))) {
            return h(obj2);
        }
        i iVar = this.f436f;
        if (iVar != i.f454c) {
            i iVar2 = new i();
            do {
                iVar2.a(iVar);
                if (f432i.c(this, iVar, iVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            n(iVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f434c;
                    } while (!((obj != null) & (!(obj instanceof g))));
                    return h(obj);
                }
                iVar = this.f436f;
            } while (iVar != i.f454c);
        }
        return h(this.f434c);
    }

    @Override // java.util.concurrent.Future
    public final V get(long j3, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j3);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f434c;
        if ((obj != null) && (!(obj instanceof g))) {
            return h(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.f436f;
            if (iVar != i.f454c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f432i.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                n(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f434c;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return h(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        n(iVar2);
                    } else {
                        iVar = this.f436f;
                    }
                } while (iVar != i.f454c);
            }
            return h(this.f434c);
        }
        while (nanos > 0) {
            Object obj3 = this.f434c;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return h(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String aVar = toString();
        String obj4 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj4.toLowerCase(locale);
        String str = "Waited " + j3 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j4 = -nanos;
            long convert = timeUnit.convert(j4, TimeUnit.NANOSECONDS);
            long nanos2 = j4 - timeUnit.toNanos(convert);
            boolean z3 = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str3 = str2 + convert + " " + lowerCase;
                if (z3) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z3) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + aVar);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f434c instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof g)) & (this.f434c != null);
    }

    protected void k() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String l() {
        Object obj = this.f434c;
        if (obj instanceof g) {
            return "setFuture=[" + p(((g) obj).f453d) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean o(V v3) {
        if (v3 == null) {
            v3 = (V) f433j;
        }
        if (!f432i.b(this, null, v3)) {
            return false;
        }
        f(this);
        return true;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (!isCancelled()) {
            if (!isDone()) {
                try {
                    str = l();
                } catch (RuntimeException e3) {
                    str = "Exception thrown from implementation: " + e3.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str);
                    sb.append("]");
                    sb.append("]");
                    return sb.toString();
                }
                str2 = isDone() ? "CANCELLED" : "PENDING";
            }
            a(sb);
            sb.append("]");
            return sb.toString();
        }
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}
