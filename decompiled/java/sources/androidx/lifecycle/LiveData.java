package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: /root/release/classes.dex */
public abstract class LiveData<T> {

    /* renamed from: k, reason: collision with root package name */
    static final Object f1244k = new Object();

    /* renamed from: a, reason: collision with root package name */
    final Object f1245a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private d.b<o<? super T>, LiveData<T>.c> f1246b = new d.b<>();

    /* renamed from: c, reason: collision with root package name */
    int f1247c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1248d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Object f1249e;

    /* renamed from: f, reason: collision with root package name */
    volatile Object f1250f;

    /* renamed from: g, reason: collision with root package name */
    private int f1251g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1252h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1253i;

    /* renamed from: j, reason: collision with root package name */
    private final Runnable f1254j;

    class LifecycleBoundObserver extends LiveData<T>.c implements g {

        /* renamed from: h, reason: collision with root package name */
        final i f1255h;

        LifecycleBoundObserver(i iVar, o<? super T> oVar) {
            super(oVar);
            this.f1255h = iVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        void b() {
            this.f1255h.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.g
        public void e(i iVar, e.a aVar) {
            e.b b4 = this.f1255h.getLifecycle().b();
            if (b4 == e.b.DESTROYED) {
                LiveData.this.m(this.f1259c);
                return;
            }
            e.b bVar = null;
            while (bVar != b4) {
                a(h());
                bVar = b4;
                b4 = this.f1255h.getLifecycle().b();
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean g(i iVar) {
            return this.f1255h == iVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean h() {
            return this.f1255h.getLifecycle().b().b(e.b.STARTED);
        }
    }

    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f1245a) {
                obj = LiveData.this.f1250f;
                LiveData.this.f1250f = LiveData.f1244k;
            }
            LiveData.this.n(obj);
        }
    }

    private class b extends LiveData<T>.c {
        b(o<? super T> oVar) {
            super(oVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean h() {
            return true;
        }
    }

    private abstract class c {

        /* renamed from: c, reason: collision with root package name */
        final o<? super T> f1259c;

        /* renamed from: d, reason: collision with root package name */
        boolean f1260d;

        /* renamed from: f, reason: collision with root package name */
        int f1261f = -1;

        c(o<? super T> oVar) {
            this.f1259c = oVar;
        }

        void a(boolean z3) {
            if (z3 == this.f1260d) {
                return;
            }
            this.f1260d = z3;
            LiveData.this.c(z3 ? 1 : -1);
            if (this.f1260d) {
                LiveData.this.e(this);
            }
        }

        void b() {
        }

        boolean g(i iVar) {
            return false;
        }

        abstract boolean h();
    }

    public LiveData() {
        Object obj = f1244k;
        this.f1250f = obj;
        this.f1254j = new a();
        this.f1249e = obj;
        this.f1251g = -1;
    }

    static void b(String str) {
        if (c.c.f().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void d(LiveData<T>.c cVar) {
        if (cVar.f1260d) {
            if (!cVar.h()) {
                cVar.a(false);
                return;
            }
            int i3 = cVar.f1261f;
            int i4 = this.f1251g;
            if (i3 >= i4) {
                return;
            }
            cVar.f1261f = i4;
            cVar.f1259c.a((Object) this.f1249e);
        }
    }

    void c(int i3) {
        int i4 = this.f1247c;
        this.f1247c = i3 + i4;
        if (this.f1248d) {
            return;
        }
        this.f1248d = true;
        while (true) {
            try {
                int i5 = this.f1247c;
                if (i4 == i5) {
                    return;
                }
                boolean z3 = i4 == 0 && i5 > 0;
                boolean z4 = i4 > 0 && i5 == 0;
                if (z3) {
                    j();
                } else if (z4) {
                    k();
                }
                i4 = i5;
            } finally {
                this.f1248d = false;
            }
        }
    }

    void e(LiveData<T>.c cVar) {
        if (this.f1252h) {
            this.f1253i = true;
            return;
        }
        this.f1252h = true;
        do {
            this.f1253i = false;
            if (cVar != null) {
                d(cVar);
                cVar = null;
            } else {
                d.b<o<? super T>, LiveData<T>.c>.d c3 = this.f1246b.c();
                while (c3.hasNext()) {
                    d((c) c3.next().getValue());
                    if (this.f1253i) {
                        break;
                    }
                }
            }
        } while (this.f1253i);
        this.f1252h = false;
    }

    public T f() {
        T t3 = (T) this.f1249e;
        if (t3 != f1244k) {
            return t3;
        }
        return null;
    }

    public boolean g() {
        return this.f1247c > 0;
    }

    public void h(i iVar, o<? super T> oVar) {
        b("observe");
        if (iVar.getLifecycle().b() == e.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(iVar, oVar);
        LiveData<T>.c f3 = this.f1246b.f(oVar, lifecycleBoundObserver);
        if (f3 != null && !f3.g(iVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (f3 != null) {
            return;
        }
        iVar.getLifecycle().a(lifecycleBoundObserver);
    }

    public void i(o<? super T> oVar) {
        b("observeForever");
        b bVar = new b(oVar);
        LiveData<T>.c f3 = this.f1246b.f(oVar, bVar);
        if (f3 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (f3 != null) {
            return;
        }
        bVar.a(true);
    }

    protected void j() {
    }

    protected void k() {
    }

    protected void l(T t3) {
        boolean z3;
        synchronized (this.f1245a) {
            z3 = this.f1250f == f1244k;
            this.f1250f = t3;
        }
        if (z3) {
            c.c.f().c(this.f1254j);
        }
    }

    public void m(o<? super T> oVar) {
        b("removeObserver");
        LiveData<T>.c g3 = this.f1246b.g(oVar);
        if (g3 == null) {
            return;
        }
        g3.b();
        g3.a(false);
    }

    protected void n(T t3) {
        b("setValue");
        this.f1251g++;
        this.f1249e = t3;
        e(null);
    }
}
