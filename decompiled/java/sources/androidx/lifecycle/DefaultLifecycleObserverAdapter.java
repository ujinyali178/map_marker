package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: /root/release/classes.dex */
public final class DefaultLifecycleObserverAdapter implements g {

    /* renamed from: c, reason: collision with root package name */
    private final DefaultLifecycleObserver f1236c;

    /* renamed from: d, reason: collision with root package name */
    private final g f1237d;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1238a;

        static {
            int[] iArr = new int[e.a.values().length];
            try {
                iArr[e.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[e.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[e.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[e.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[e.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[e.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[e.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f1238a = iArr;
        }
    }

    public DefaultLifecycleObserverAdapter(DefaultLifecycleObserver defaultLifecycleObserver, g gVar) {
        kotlin.jvm.internal.k.e(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f1236c = defaultLifecycleObserver;
        this.f1237d = gVar;
    }

    @Override // androidx.lifecycle.g
    public void e(i source, e.a event) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(event, "event");
        switch (a.f1238a[event.ordinal()]) {
            case 1:
                this.f1236c.d(source);
                break;
            case 2:
                this.f1236c.q(source);
                break;
            case 3:
                this.f1236c.c(source);
                break;
            case 4:
                this.f1236c.f(source);
                break;
            case 5:
                this.f1236c.i(source);
                break;
            case 6:
                this.f1236c.m(source);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        g gVar = this.f1237d;
        if (gVar != null) {
            gVar.e(source, event);
        }
    }
}
