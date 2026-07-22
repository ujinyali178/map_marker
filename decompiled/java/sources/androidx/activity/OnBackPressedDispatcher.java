package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: /root/release/classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f261a;

    /* renamed from: b, reason: collision with root package name */
    private final h2.e<l> f262b = new h2.e<>();

    /* renamed from: c, reason: collision with root package name */
    private p2.a<g2.q> f263c;

    /* renamed from: d, reason: collision with root package name */
    private OnBackInvokedCallback f264d;

    /* renamed from: e, reason: collision with root package name */
    private OnBackInvokedDispatcher f265e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f266f;

    private final class LifecycleOnBackPressedCancellable implements androidx.lifecycle.g, androidx.activity.a {

        /* renamed from: c, reason: collision with root package name */
        private final androidx.lifecycle.e f267c;

        /* renamed from: d, reason: collision with root package name */
        private final l f268d;

        /* renamed from: f, reason: collision with root package name */
        private androidx.activity.a f269f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f270g;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, androidx.lifecycle.e lifecycle, l onBackPressedCallback) {
            kotlin.jvm.internal.k.e(lifecycle, "lifecycle");
            kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
            this.f270g = onBackPressedDispatcher;
            this.f267c = lifecycle;
            this.f268d = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f267c.c(this);
            this.f268d.e(this);
            androidx.activity.a aVar = this.f269f;
            if (aVar != null) {
                aVar.cancel();
            }
            this.f269f = null;
        }

        @Override // androidx.lifecycle.g
        public void e(androidx.lifecycle.i source, e.a event) {
            kotlin.jvm.internal.k.e(source, "source");
            kotlin.jvm.internal.k.e(event, "event");
            if (event == e.a.ON_START) {
                this.f269f = this.f270g.c(this.f268d);
                return;
            }
            if (event != e.a.ON_STOP) {
                if (event == e.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar = this.f269f;
                if (aVar != null) {
                    aVar.cancel();
                }
            }
        }
    }

    static final class a extends kotlin.jvm.internal.l implements p2.a<g2.q> {
        a() {
            super(0);
        }

        public final void a() {
            OnBackPressedDispatcher.this.g();
        }

        @Override // p2.a
        public /* bridge */ /* synthetic */ g2.q invoke() {
            a();
            return g2.q.f2555a;
        }
    }

    static final class b extends kotlin.jvm.internal.l implements p2.a<g2.q> {
        b() {
            super(0);
        }

        public final void a() {
            OnBackPressedDispatcher.this.e();
        }

        @Override // p2.a
        public /* bridge */ /* synthetic */ g2.q invoke() {
            a();
            return g2.q.f2555a;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f273a = new c();

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(p2.a onBackInvoked) {
            kotlin.jvm.internal.k.e(onBackInvoked, "$onBackInvoked");
            onBackInvoked.invoke();
        }

        public final OnBackInvokedCallback b(final p2.a<g2.q> onBackInvoked) {
            kotlin.jvm.internal.k.e(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.m
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    OnBackPressedDispatcher.c.c(p2.a.this);
                }
            };
        }

        public final void d(Object dispatcher, int i3, Object callback) {
            kotlin.jvm.internal.k.e(dispatcher, "dispatcher");
            kotlin.jvm.internal.k.e(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i3, (OnBackInvokedCallback) callback);
        }

        public final void e(Object dispatcher, Object callback) {
            kotlin.jvm.internal.k.e(dispatcher, "dispatcher");
            kotlin.jvm.internal.k.e(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    private final class d implements androidx.activity.a {

        /* renamed from: c, reason: collision with root package name */
        private final l f274c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f275d;

        public d(OnBackPressedDispatcher onBackPressedDispatcher, l onBackPressedCallback) {
            kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
            this.f275d = onBackPressedDispatcher;
            this.f274c = onBackPressedCallback;
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f275d.f262b.remove(this.f274c);
            this.f274c.e(this);
            if (Build.VERSION.SDK_INT >= 33) {
                this.f274c.g(null);
                this.f275d.g();
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f261a = runnable;
        if (Build.VERSION.SDK_INT >= 33) {
            this.f263c = new a();
            this.f264d = c.f273a.b(new b());
        }
    }

    public final void b(androidx.lifecycle.i owner, l onBackPressedCallback) {
        kotlin.jvm.internal.k.e(owner, "owner");
        kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
        androidx.lifecycle.e lifecycle = owner.getLifecycle();
        if (lifecycle.b() == e.b.DESTROYED) {
            return;
        }
        onBackPressedCallback.a(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
        if (Build.VERSION.SDK_INT >= 33) {
            g();
            onBackPressedCallback.g(this.f263c);
        }
    }

    public final androidx.activity.a c(l onBackPressedCallback) {
        kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
        this.f262b.add(onBackPressedCallback);
        d dVar = new d(this, onBackPressedCallback);
        onBackPressedCallback.a(dVar);
        if (Build.VERSION.SDK_INT >= 33) {
            g();
            onBackPressedCallback.g(this.f263c);
        }
        return dVar;
    }

    public final boolean d() {
        h2.e<l> eVar = this.f262b;
        if ((eVar instanceof Collection) && eVar.isEmpty()) {
            return false;
        }
        Iterator<l> it = eVar.iterator();
        while (it.hasNext()) {
            if (it.next().c()) {
                return true;
            }
        }
        return false;
    }

    public final void e() {
        l lVar;
        h2.e<l> eVar = this.f262b;
        ListIterator<l> listIterator = eVar.listIterator(eVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                lVar = null;
                break;
            } else {
                lVar = listIterator.previous();
                if (lVar.c()) {
                    break;
                }
            }
        }
        l lVar2 = lVar;
        if (lVar2 != null) {
            lVar2.b();
            return;
        }
        Runnable runnable = this.f261a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void f(OnBackInvokedDispatcher invoker) {
        kotlin.jvm.internal.k.e(invoker, "invoker");
        this.f265e = invoker;
        g();
    }

    public final void g() {
        boolean d3 = d();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f265e;
        OnBackInvokedCallback onBackInvokedCallback = this.f264d;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (d3 && !this.f266f) {
            c.f273a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f266f = true;
        } else {
            if (d3 || !this.f266f) {
                return;
            }
            c.f273a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f266f = false;
        }
    }
}
