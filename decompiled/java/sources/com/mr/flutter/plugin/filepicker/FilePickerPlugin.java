package com.mr.flutter.plugin.filepicker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.e;
import androidx.lifecycle.i;
import java.util.ArrayList;
import java.util.HashMap;
import m1.a;
import u1.d;
import u1.e;
import u1.k;
import u1.l;
import u1.n;

/* loaded from: /root/release/classes.dex */
public class FilePickerPlugin implements l.c, m1.a, n1.a {

    /* renamed from: l, reason: collision with root package name */
    private static String f2379l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f2380m;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f2381n;

    /* renamed from: o, reason: collision with root package name */
    private static int f2382o;

    /* renamed from: c, reason: collision with root package name */
    private n1.c f2383c;

    /* renamed from: d, reason: collision with root package name */
    private com.mr.flutter.plugin.filepicker.b f2384d;

    /* renamed from: f, reason: collision with root package name */
    private Application f2385f;

    /* renamed from: g, reason: collision with root package name */
    private a.b f2386g;

    /* renamed from: h, reason: collision with root package name */
    private e f2387h;

    /* renamed from: i, reason: collision with root package name */
    private LifeCycleObserver f2388i;

    /* renamed from: j, reason: collision with root package name */
    private Activity f2389j;

    /* renamed from: k, reason: collision with root package name */
    private l f2390k;

    private class LifeCycleObserver implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {

        /* renamed from: c, reason: collision with root package name */
        private final Activity f2391c;

        LifeCycleObserver(Activity activity) {
            this.f2391c = activity;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void c(i iVar) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void d(i iVar) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void f(i iVar) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void i(i iVar) {
            onActivityStopped(this.f2391c);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void m(i iVar) {
            onActivityDestroyed(this.f2391c);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f2391c != activity || activity.getApplicationContext() == null) {
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
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void q(i iVar) {
        }
    }

    class a implements e.d {
        a() {
        }

        @Override // u1.e.d
        public void a(Object obj) {
            FilePickerPlugin.this.f2384d.q(null);
        }

        @Override // u1.e.d
        public void c(Object obj, e.b bVar) {
            FilePickerPlugin.this.f2384d.q(bVar);
        }
    }

    private static class b implements l.d {

        /* renamed from: a, reason: collision with root package name */
        private final l.d f2394a;

        /* renamed from: b, reason: collision with root package name */
        private final Handler f2395b = new Handler(Looper.getMainLooper());

        class a implements Runnable {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Object f2396c;

            a(Object obj) {
                this.f2396c = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f2394a.a(this.f2396c);
            }
        }

        /* renamed from: com.mr.flutter.plugin.filepicker.FilePickerPlugin$b$b, reason: collision with other inner class name */
        class RunnableC0067b implements Runnable {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f2398c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f2399d;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Object f2400f;

            RunnableC0067b(String str, String str2, Object obj) {
                this.f2398c = str;
                this.f2399d = str2;
                this.f2400f = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f2394a.b(this.f2398c, this.f2399d, this.f2400f);
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f2394a.c();
            }
        }

        b(l.d dVar) {
            this.f2394a = dVar;
        }

        @Override // u1.l.d
        public void a(Object obj) {
            this.f2395b.post(new a(obj));
        }

        @Override // u1.l.d
        public void b(String str, String str2, Object obj) {
            this.f2395b.post(new RunnableC0067b(str, str2, obj));
        }

        @Override // u1.l.d
        public void c() {
            this.f2395b.post(new c());
        }
    }

    private static String c(String str) {
        str.hashCode();
        switch (str) {
            case "custom":
            case "any":
                return "*/*";
            case "dir":
                return "dir";
            case "audio":
                return "audio/*";
            case "image":
                return "image/*";
            case "media":
                return "image/*,video/*";
            case "video":
                return "video/*";
            default:
                return null;
        }
    }

    private void f(d dVar, Application application, Activity activity, n.c cVar, n1.c cVar2) {
        this.f2389j = activity;
        this.f2385f = application;
        this.f2384d = new com.mr.flutter.plugin.filepicker.b(activity);
        l lVar = new l(dVar, "miguelruivo.flutter.plugins.filepicker");
        this.f2390k = lVar;
        lVar.e(this);
        new u1.e(dVar, "miguelruivo.flutter.plugins.filepickerevent").d(new a());
        LifeCycleObserver lifeCycleObserver = new LifeCycleObserver(activity);
        this.f2388i = lifeCycleObserver;
        if (cVar != null) {
            application.registerActivityLifecycleCallbacks(lifeCycleObserver);
            cVar.a(this.f2384d);
            cVar.b(this.f2384d);
        } else {
            cVar2.a(this.f2384d);
            cVar2.b(this.f2384d);
            androidx.lifecycle.e a4 = q1.a.a(cVar2);
            this.f2387h = a4;
            a4.a(this.f2388i);
        }
    }

    private void g() {
        this.f2383c.d(this.f2384d);
        this.f2383c.c(this.f2384d);
        this.f2383c = null;
        LifeCycleObserver lifeCycleObserver = this.f2388i;
        if (lifeCycleObserver != null) {
            this.f2387h.c(lifeCycleObserver);
            this.f2385f.unregisterActivityLifecycleCallbacks(this.f2388i);
        }
        this.f2387h = null;
        this.f2384d.q(null);
        this.f2384d = null;
        this.f2390k.e(null);
        this.f2390k = null;
        this.f2385f = null;
    }

    @Override // m1.a
    public void b(a.b bVar) {
        this.f2386g = bVar;
    }

    @Override // n1.a
    public void d(n1.c cVar) {
        j(cVar);
    }

    @Override // m1.a
    public void e(a.b bVar) {
        this.f2386g = null;
    }

    @Override // n1.a
    public void h() {
        i();
    }

    @Override // n1.a
    public void i() {
        g();
    }

    @Override // n1.a
    public void j(n1.c cVar) {
        this.f2383c = cVar;
        f(this.f2386g.b(), (Application) this.f2386g.a(), this.f2383c.i(), null, this.f2383c);
    }

    @Override // u1.l.c
    public void n(k kVar, l.d dVar) {
        String[] h3;
        String str;
        if (this.f2389j == null) {
            dVar.b("no_activity", "file picker plugin requires a foreground activity", null);
            return;
        }
        b bVar = new b(dVar);
        HashMap hashMap = (HashMap) kVar.f4373b;
        String str2 = kVar.f4372a;
        if (str2 != null && str2.equals("clear")) {
            bVar.a(Boolean.valueOf(c.a(this.f2389j.getApplicationContext())));
            return;
        }
        String str3 = kVar.f4372a;
        if (str3 != null && str3.equals("save")) {
            this.f2384d.p((String) hashMap.get("fileName"), c((String) hashMap.get("fileType")), (String) hashMap.get("initialDirectory"), c.h((ArrayList) hashMap.get("allowedExtensions")), (byte[]) hashMap.get("bytes"), bVar);
            return;
        }
        String c3 = c(kVar.f4372a);
        f2379l = c3;
        if (c3 == null) {
            bVar.c();
        } else if (c3 != "dir") {
            f2380m = ((Boolean) hashMap.get("allowMultipleSelection")).booleanValue();
            f2381n = ((Boolean) hashMap.get("withData")).booleanValue();
            f2382o = ((Integer) hashMap.get("compressionQuality")).intValue();
            h3 = c.h((ArrayList) hashMap.get("allowedExtensions"));
            str = kVar.f4372a;
            if (str == null && str.equals("custom") && (h3 == null || h3.length == 0)) {
                bVar.b("FilePicker", "Unsupported filter. Make sure that you are only using the extension without the dot, (ie., jpg instead of .jpg). This could also have happened because you are using an unsupported file extension.  If the problem persists, you may want to consider using FileType.any instead.", null);
                return;
            } else {
                this.f2384d.t(f2379l, f2380m, f2381n, h3, f2382o, bVar);
            }
        }
        h3 = null;
        str = kVar.f4372a;
        if (str == null) {
        }
        this.f2384d.t(f2379l, f2380m, f2381n, h3, f2382o, bVar);
    }
}
