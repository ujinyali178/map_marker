package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;
import io.flutter.plugins.imagepicker.l;
import io.flutter.plugins.imagepicker.p;
import java.util.List;
import m1.a;
import u1.n;

/* loaded from: /root/release/classes.dex */
public class ImagePickerPlugin implements m1.a, n1.a, p.f {

    /* renamed from: c, reason: collision with root package name */
    private a.b f3352c;

    /* renamed from: d, reason: collision with root package name */
    b f3353d;

    private class LifeCycleObserver implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {

        /* renamed from: c, reason: collision with root package name */
        private final Activity f3354c;

        LifeCycleObserver(Activity activity) {
            this.f3354c = activity;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void c(androidx.lifecycle.i iVar) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void d(androidx.lifecycle.i iVar) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void f(androidx.lifecycle.i iVar) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void i(androidx.lifecycle.i iVar) {
            onActivityStopped(this.f3354c);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void m(androidx.lifecycle.i iVar) {
            onActivityDestroyed(this.f3354c);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f3354c != activity || activity.getApplicationContext() == null) {
                return;
            }
            ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (this.f3354c == activity) {
                ImagePickerPlugin.this.f3353d.b().V();
            }
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void q(androidx.lifecycle.i iVar) {
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3356a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f3357b;

        static {
            int[] iArr = new int[p.m.values().length];
            f3357b = iArr;
            try {
                iArr[p.m.GALLERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3357b[p.m.CAMERA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[p.k.values().length];
            f3356a = iArr2;
            try {
                iArr2[p.k.FRONT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3356a[p.k.REAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private class b {

        /* renamed from: a, reason: collision with root package name */
        private Application f3358a;

        /* renamed from: b, reason: collision with root package name */
        private Activity f3359b;

        /* renamed from: c, reason: collision with root package name */
        private l f3360c;

        /* renamed from: d, reason: collision with root package name */
        private LifeCycleObserver f3361d;

        /* renamed from: e, reason: collision with root package name */
        private n1.c f3362e;

        /* renamed from: f, reason: collision with root package name */
        private u1.d f3363f;

        /* renamed from: g, reason: collision with root package name */
        private androidx.lifecycle.e f3364g;

        b(Application application, Activity activity, u1.d dVar, p.f fVar, n.c cVar, n1.c cVar2) {
            this.f3358a = application;
            this.f3359b = activity;
            this.f3362e = cVar2;
            this.f3363f = dVar;
            this.f3360c = ImagePickerPlugin.this.k(activity);
            u.f(dVar, fVar);
            LifeCycleObserver lifeCycleObserver = ImagePickerPlugin.this.new LifeCycleObserver(activity);
            this.f3361d = lifeCycleObserver;
            if (cVar != null) {
                application.registerActivityLifecycleCallbacks(lifeCycleObserver);
                cVar.a(this.f3360c);
                cVar.b(this.f3360c);
            } else {
                cVar2.a(this.f3360c);
                cVar2.b(this.f3360c);
                androidx.lifecycle.e a4 = q1.a.a(cVar2);
                this.f3364g = a4;
                a4.a(this.f3361d);
            }
        }

        Activity a() {
            return this.f3359b;
        }

        l b() {
            return this.f3360c;
        }

        void c() {
            n1.c cVar = this.f3362e;
            if (cVar != null) {
                cVar.d(this.f3360c);
                this.f3362e.c(this.f3360c);
                this.f3362e = null;
            }
            androidx.lifecycle.e eVar = this.f3364g;
            if (eVar != null) {
                eVar.c(this.f3361d);
                this.f3364g = null;
            }
            u.f(this.f3363f, null);
            Application application = this.f3358a;
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(this.f3361d);
                this.f3358a = null;
            }
            this.f3359b = null;
            this.f3361d = null;
            this.f3360c = null;
        }
    }

    private l l() {
        b bVar = this.f3353d;
        if (bVar == null || bVar.a() == null) {
            return null;
        }
        return this.f3353d.b();
    }

    private void m(l lVar, p.l lVar2) {
        p.k b4 = lVar2.b();
        if (b4 != null) {
            lVar.W(a.f3356a[b4.ordinal()] != 1 ? l.c.REAR : l.c.FRONT);
        }
    }

    private void n(u1.d dVar, Application application, Activity activity, n.c cVar, n1.c cVar2) {
        this.f3353d = new b(application, activity, dVar, this, cVar, cVar2);
    }

    private void o() {
        b bVar = this.f3353d;
        if (bVar != null) {
            bVar.c();
            this.f3353d = null;
        }
    }

    @Override // io.flutter.plugins.imagepicker.p.f
    public void a(p.i iVar, p.e eVar, p.j<List<String>> jVar) {
        l l3 = l();
        if (l3 == null) {
            jVar.b(new p.d("no_activity", "image_picker plugin requires a foreground activity.", null));
        } else {
            l3.k(iVar, eVar, jVar);
        }
    }

    @Override // m1.a
    public void b(a.b bVar) {
        this.f3352c = bVar;
    }

    @Override // io.flutter.plugins.imagepicker.p.f
    public void c(p.l lVar, p.h hVar, p.e eVar, p.j<List<String>> jVar) {
        l l3 = l();
        if (l3 == null) {
            jVar.b(new p.d("no_activity", "image_picker plugin requires a foreground activity.", null));
            return;
        }
        m(l3, lVar);
        if (eVar.b().booleanValue()) {
            l3.l(hVar, eVar.c().booleanValue(), jVar);
            return;
        }
        int i3 = a.f3357b[lVar.c().ordinal()];
        if (i3 == 1) {
            l3.j(hVar, eVar.c().booleanValue(), jVar);
        } else {
            if (i3 != 2) {
                return;
            }
            l3.Y(hVar, jVar);
        }
    }

    @Override // n1.a
    public void d(n1.c cVar) {
        j(cVar);
    }

    @Override // m1.a
    public void e(a.b bVar) {
        this.f3352c = null;
    }

    @Override // io.flutter.plugins.imagepicker.p.f
    public void f(p.l lVar, p.n nVar, p.e eVar, p.j<List<String>> jVar) {
        l l3 = l();
        if (l3 == null) {
            jVar.b(new p.d("no_activity", "image_picker plugin requires a foreground activity.", null));
            return;
        }
        m(l3, lVar);
        if (eVar.b().booleanValue()) {
            jVar.b(new RuntimeException("Multi-video selection is not implemented"));
            return;
        }
        int i3 = a.f3357b[lVar.c().ordinal()];
        if (i3 == 1) {
            l3.m(nVar, eVar.c().booleanValue(), jVar);
        } else {
            if (i3 != 2) {
                return;
            }
            l3.Z(nVar, jVar);
        }
    }

    @Override // io.flutter.plugins.imagepicker.p.f
    public p.b g() {
        l l3 = l();
        if (l3 != null) {
            return l3.U();
        }
        throw new p.d("no_activity", "image_picker plugin requires a foreground activity.", null);
    }

    @Override // n1.a
    public void h() {
        i();
    }

    @Override // n1.a
    public void i() {
        o();
    }

    @Override // n1.a
    public void j(n1.c cVar) {
        n(this.f3352c.b(), (Application) this.f3352c.a(), cVar.i(), null, cVar);
    }

    final l k(Activity activity) {
        return new l(activity, new o(activity, new io.flutter.plugins.imagepicker.a()), new c(activity));
    }
}
