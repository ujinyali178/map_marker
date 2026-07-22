package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.h;
import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.i;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.z;
import androidx.loader.app.a;
import androidx.loader.content.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* loaded from: /root/release/classes.dex */
class b extends androidx.loader.app.a {

    /* renamed from: c, reason: collision with root package name */
    static boolean f1344c;

    /* renamed from: a, reason: collision with root package name */
    private final i f1345a;

    /* renamed from: b, reason: collision with root package name */
    private final c f1346b;

    public static class a<D> extends n<D> implements b.InterfaceC0031b<D> {

        /* renamed from: l, reason: collision with root package name */
        private final int f1347l;

        /* renamed from: m, reason: collision with root package name */
        private final Bundle f1348m;

        /* renamed from: n, reason: collision with root package name */
        private final androidx.loader.content.b<D> f1349n;

        /* renamed from: o, reason: collision with root package name */
        private i f1350o;

        /* renamed from: p, reason: collision with root package name */
        private C0029b<D> f1351p;

        /* renamed from: q, reason: collision with root package name */
        private androidx.loader.content.b<D> f1352q;

        a(int i3, Bundle bundle, androidx.loader.content.b<D> bVar, androidx.loader.content.b<D> bVar2) {
            this.f1347l = i3;
            this.f1348m = bundle;
            this.f1349n = bVar;
            this.f1352q = bVar2;
            bVar.registerListener(i3, this);
        }

        @Override // androidx.loader.content.b.InterfaceC0031b
        public void a(androidx.loader.content.b<D> bVar, D d3) {
            if (b.f1344c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                n(d3);
                return;
            }
            if (b.f1344c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            l(d3);
        }

        @Override // androidx.lifecycle.LiveData
        protected void j() {
            if (b.f1344c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f1349n.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        protected void k() {
            if (b.f1344c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f1349n.stopLoading();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void m(o<? super D> oVar) {
            super.m(oVar);
            this.f1350o = null;
            this.f1351p = null;
        }

        @Override // androidx.lifecycle.n, androidx.lifecycle.LiveData
        public void n(D d3) {
            super.n(d3);
            androidx.loader.content.b<D> bVar = this.f1352q;
            if (bVar != null) {
                bVar.reset();
                this.f1352q = null;
            }
        }

        androidx.loader.content.b<D> o(boolean z3) {
            if (b.f1344c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f1349n.cancelLoad();
            this.f1349n.abandon();
            C0029b<D> c0029b = this.f1351p;
            if (c0029b != null) {
                m(c0029b);
                if (z3) {
                    c0029b.d();
                }
            }
            this.f1349n.unregisterListener(this);
            if ((c0029b == null || c0029b.c()) && !z3) {
                return this.f1349n;
            }
            this.f1349n.reset();
            return this.f1352q;
        }

        public void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f1347l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f1348m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f1349n);
            this.f1349n.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f1351p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f1351p);
                this.f1351p.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(q().dataToString(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(g());
        }

        androidx.loader.content.b<D> q() {
            return this.f1349n;
        }

        void r() {
            i iVar = this.f1350o;
            C0029b<D> c0029b = this.f1351p;
            if (iVar == null || c0029b == null) {
                return;
            }
            super.m(c0029b);
            h(iVar, c0029b);
        }

        androidx.loader.content.b<D> s(i iVar, a.InterfaceC0028a<D> interfaceC0028a) {
            C0029b<D> c0029b = new C0029b<>(this.f1349n, interfaceC0028a);
            h(iVar, c0029b);
            C0029b<D> c0029b2 = this.f1351p;
            if (c0029b2 != null) {
                m(c0029b2);
            }
            this.f1350o = iVar;
            this.f1351p = c0029b;
            return this.f1349n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f1347l);
            sb.append(" : ");
            Class<?> cls = this.f1349n.getClass();
            sb.append(cls.getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(cls)));
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: androidx.loader.app.b$b, reason: collision with other inner class name */
    static class C0029b<D> implements o<D> {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.loader.content.b<D> f1353a;

        /* renamed from: b, reason: collision with root package name */
        private final a.InterfaceC0028a<D> f1354b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f1355c = false;

        C0029b(androidx.loader.content.b<D> bVar, a.InterfaceC0028a<D> interfaceC0028a) {
            this.f1353a = bVar;
            this.f1354b = interfaceC0028a;
        }

        @Override // androidx.lifecycle.o
        public void a(D d3) {
            if (b.f1344c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f1353a + ": " + this.f1353a.dataToString(d3));
            }
            this.f1355c = true;
            this.f1354b.onLoadFinished(this.f1353a, d3);
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f1355c);
        }

        boolean c() {
            return this.f1355c;
        }

        void d() {
            if (this.f1355c) {
                if (b.f1344c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f1353a);
                }
                this.f1354b.onLoaderReset(this.f1353a);
            }
        }

        public String toString() {
            return this.f1354b.toString();
        }
    }

    static class c extends z {

        /* renamed from: f, reason: collision with root package name */
        private static final a0.b f1356f = new a();

        /* renamed from: d, reason: collision with root package name */
        private h<a> f1357d = new h<>();

        /* renamed from: e, reason: collision with root package name */
        private boolean f1358e = false;

        static class a implements a0.b {
            a() {
            }

            @Override // androidx.lifecycle.a0.b
            public <T extends z> T a(Class<T> cls) {
                return new c();
            }

            @Override // androidx.lifecycle.a0.b
            public /* synthetic */ z b(Class cls, p.a aVar) {
                return b0.b(this, cls, aVar);
            }
        }

        c() {
        }

        static c h(d0 d0Var) {
            return (c) new a0(d0Var, f1356f).a(c.class);
        }

        @Override // androidx.lifecycle.z
        protected void d() {
            super.d();
            int h3 = this.f1357d.h();
            for (int i3 = 0; i3 < h3; i3++) {
                this.f1357d.i(i3).o(true);
            }
            this.f1357d.a();
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f1357d.h() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i3 = 0; i3 < this.f1357d.h(); i3++) {
                    a i4 = this.f1357d.i(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f1357d.f(i3));
                    printWriter.print(": ");
                    printWriter.println(i4.toString());
                    i4.p(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void g() {
            this.f1358e = false;
        }

        <D> a<D> i(int i3) {
            return this.f1357d.d(i3);
        }

        boolean j() {
            return this.f1358e;
        }

        void k() {
            int h3 = this.f1357d.h();
            for (int i3 = 0; i3 < h3; i3++) {
                this.f1357d.i(i3).r();
            }
        }

        void l(int i3, a aVar) {
            this.f1357d.g(i3, aVar);
        }

        void m() {
            this.f1358e = true;
        }
    }

    b(i iVar, d0 d0Var) {
        this.f1345a = iVar;
        this.f1346b = c.h(d0Var);
    }

    private <D> androidx.loader.content.b<D> e(int i3, Bundle bundle, a.InterfaceC0028a<D> interfaceC0028a, androidx.loader.content.b<D> bVar) {
        try {
            this.f1346b.m();
            androidx.loader.content.b<D> onCreateLoader = interfaceC0028a.onCreateLoader(i3, bundle);
            if (onCreateLoader == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
            }
            a aVar = new a(i3, bundle, onCreateLoader, bVar);
            if (f1344c) {
                Log.v("LoaderManager", "  Created new loader " + aVar);
            }
            this.f1346b.l(i3, aVar);
            this.f1346b.g();
            return aVar.s(this.f1345a, interfaceC0028a);
        } catch (Throwable th) {
            this.f1346b.g();
            throw th;
        }
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f1346b.f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public <D> androidx.loader.content.b<D> c(int i3, Bundle bundle, a.InterfaceC0028a<D> interfaceC0028a) {
        if (this.f1346b.j()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a<D> i4 = this.f1346b.i(i3);
        if (f1344c) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (i4 == null) {
            return e(i3, bundle, interfaceC0028a, null);
        }
        if (f1344c) {
            Log.v("LoaderManager", "  Re-using existing loader " + i4);
        }
        return i4.s(this.f1345a, interfaceC0028a);
    }

    @Override // androidx.loader.app.a
    public void d() {
        this.f1346b.k();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Class<?> cls = this.f1345a.getClass();
        sb.append(cls.getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(cls)));
        sb.append("}}");
        return sb.toString();
    }
}
