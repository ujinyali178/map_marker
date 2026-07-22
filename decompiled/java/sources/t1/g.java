package t1;

import java.util.Locale;

/* loaded from: /root/release/classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private b f4137a;

    /* renamed from: b, reason: collision with root package name */
    private b f4138b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4139c;

    /* renamed from: d, reason: collision with root package name */
    private final u1.b<String> f4140d;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4141a;

        static {
            int[] iArr = new int[b.values().length];
            f4141a = iArr;
            try {
                iArr[b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4141a[b.INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4141a[b.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4141a[b.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4141a[b.DETACHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private enum b {
        DETACHED,
        RESUMED,
        INACTIVE,
        HIDDEN,
        PAUSED
    }

    public g(i1.a aVar) {
        this((u1.b<String>) new u1.b(aVar, "flutter/lifecycle", u1.q.f4390b));
    }

    public g(u1.b<String> bVar) {
        this.f4137a = null;
        this.f4138b = null;
        this.f4139c = true;
        this.f4140d = bVar;
    }

    private void g(b bVar, boolean z3) {
        b bVar2 = this.f4137a;
        if (bVar2 == bVar && z3 == this.f4139c) {
            return;
        }
        if (bVar == null && bVar2 == null) {
            this.f4139c = z3;
            return;
        }
        b bVar3 = null;
        int i3 = a.f4141a[bVar.ordinal()];
        if (i3 == 1) {
            bVar3 = z3 ? b.RESUMED : b.INACTIVE;
        } else if (i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) {
            bVar3 = bVar;
        }
        this.f4137a = bVar;
        this.f4139c = z3;
        if (bVar3 == this.f4138b) {
            return;
        }
        String str = "AppLifecycleState." + bVar3.name().toLowerCase(Locale.ROOT);
        g1.b.f("LifecycleChannel", "Sending " + str + " message.");
        this.f4140d.c(str);
        this.f4138b = bVar3;
    }

    public void a() {
        g(this.f4137a, true);
    }

    public void b() {
        g(b.DETACHED, this.f4139c);
    }

    public void c() {
        g(b.INACTIVE, this.f4139c);
    }

    public void d() {
        g(b.PAUSED, this.f4139c);
    }

    public void e() {
        g(b.RESUMED, this.f4139c);
    }

    public void f() {
        g(this.f4137a, false);
    }
}
