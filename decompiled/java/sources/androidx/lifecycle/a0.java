package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import p.a;

/* loaded from: /root/release/classes.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f1270a;

    /* renamed from: b, reason: collision with root package name */
    private final b f1271b;

    /* renamed from: c, reason: collision with root package name */
    private final p.a f1272c;

    public static class a extends c {

        /* renamed from: f, reason: collision with root package name */
        private static a f1274f;

        /* renamed from: d, reason: collision with root package name */
        private final Application f1276d;

        /* renamed from: e, reason: collision with root package name */
        public static final C0022a f1273e = new C0022a(null);

        /* renamed from: g, reason: collision with root package name */
        public static final a.b<Application> f1275g = C0022a.C0023a.f1277a;

        /* renamed from: androidx.lifecycle.a0$a$a, reason: collision with other inner class name */
        public static final class C0022a {

            /* renamed from: androidx.lifecycle.a0$a$a$a, reason: collision with other inner class name */
            private static final class C0023a implements a.b<Application> {

                /* renamed from: a, reason: collision with root package name */
                public static final C0023a f1277a = new C0023a();

                private C0023a() {
                }
            }

            private C0022a() {
            }

            public /* synthetic */ C0022a(kotlin.jvm.internal.g gVar) {
                this();
            }

            public final a a(Application application) {
                kotlin.jvm.internal.k.e(application, "application");
                if (a.f1274f == null) {
                    a.f1274f = new a(application);
                }
                a aVar = a.f1274f;
                kotlin.jvm.internal.k.b(aVar);
                return aVar;
            }
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            kotlin.jvm.internal.k.e(application, "application");
        }

        private a(Application application, int i3) {
            this.f1276d = application;
        }

        private final <T extends z> T g(Class<T> cls, Application application) {
            if (!androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                return (T) super.a(cls);
            }
            try {
                T newInstance = cls.getConstructor(Application.class).newInstance(application);
                kotlin.jvm.internal.k.d(newInstance, "{\n                try {\n…          }\n            }");
                return newInstance;
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            }
        }

        @Override // androidx.lifecycle.a0.c, androidx.lifecycle.a0.b
        public <T extends z> T a(Class<T> modelClass) {
            kotlin.jvm.internal.k.e(modelClass, "modelClass");
            Application application = this.f1276d;
            if (application != null) {
                return (T) g(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.a0.c, androidx.lifecycle.a0.b
        public <T extends z> T b(Class<T> modelClass, p.a extras) {
            kotlin.jvm.internal.k.e(modelClass, "modelClass");
            kotlin.jvm.internal.k.e(extras, "extras");
            if (this.f1276d != null) {
                return (T) a(modelClass);
            }
            Application application = (Application) extras.a(f1275g);
            if (application != null) {
                return (T) g(modelClass, application);
            }
            if (androidx.lifecycle.a.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return (T) super.a(modelClass);
        }
    }

    public interface b {
        <T extends z> T a(Class<T> cls);

        <T extends z> T b(Class<T> cls, p.a aVar);
    }

    public static class c implements b {

        /* renamed from: b, reason: collision with root package name */
        private static c f1279b;

        /* renamed from: a, reason: collision with root package name */
        public static final a f1278a = new a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final a.b<String> f1280c = a.C0024a.f1281a;

        public static final class a {

            /* renamed from: androidx.lifecycle.a0$c$a$a, reason: collision with other inner class name */
            private static final class C0024a implements a.b<String> {

                /* renamed from: a, reason: collision with root package name */
                public static final C0024a f1281a = new C0024a();

                private C0024a() {
                }
            }

            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }

            public final c a() {
                if (c.f1279b == null) {
                    c.f1279b = new c();
                }
                c cVar = c.f1279b;
                kotlin.jvm.internal.k.b(cVar);
                return cVar;
            }
        }

        @Override // androidx.lifecycle.a0.b
        public <T extends z> T a(Class<T> modelClass) {
            kotlin.jvm.internal.k.e(modelClass, "modelClass");
            try {
                T newInstance = modelClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                kotlin.jvm.internal.k.d(newInstance, "{\n                modelC…wInstance()\n            }");
                return newInstance;
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e5);
            }
        }

        @Override // androidx.lifecycle.a0.b
        public /* synthetic */ z b(Class cls, p.a aVar) {
            return b0.b(this, cls, aVar);
        }
    }

    public static class d {
        public void c(z viewModel) {
            kotlin.jvm.internal.k.e(viewModel, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(d0 store, b factory) {
        this(store, factory, null, 4, null);
        kotlin.jvm.internal.k.e(store, "store");
        kotlin.jvm.internal.k.e(factory, "factory");
    }

    public a0(d0 store, b factory, p.a defaultCreationExtras) {
        kotlin.jvm.internal.k.e(store, "store");
        kotlin.jvm.internal.k.e(factory, "factory");
        kotlin.jvm.internal.k.e(defaultCreationExtras, "defaultCreationExtras");
        this.f1270a = store;
        this.f1271b = factory;
        this.f1272c = defaultCreationExtras;
    }

    public /* synthetic */ a0(d0 d0Var, b bVar, p.a aVar, int i3, kotlin.jvm.internal.g gVar) {
        this(d0Var, bVar, (i3 & 4) != 0 ? a.C0101a.f4080b : aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(e0 owner, b factory) {
        this(owner.getViewModelStore(), factory, c0.a(owner));
        kotlin.jvm.internal.k.e(owner, "owner");
        kotlin.jvm.internal.k.e(factory, "factory");
    }

    public <T extends z> T a(Class<T> modelClass) {
        kotlin.jvm.internal.k.e(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    public <T extends z> T b(String key, Class<T> modelClass) {
        T t3;
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(modelClass, "modelClass");
        T t4 = (T) this.f1270a.b(key);
        if (!modelClass.isInstance(t4)) {
            p.d dVar = new p.d(this.f1272c);
            dVar.c(c.f1280c, key);
            try {
                t3 = (T) this.f1271b.b(modelClass, dVar);
            } catch (AbstractMethodError unused) {
                t3 = (T) this.f1271b.a(modelClass);
            }
            this.f1270a.d(key, t3);
            return t3;
        }
        Object obj = this.f1271b;
        d dVar2 = obj instanceof d ? (d) obj : null;
        if (dVar2 != null) {
            kotlin.jvm.internal.k.b(t4);
            dVar2.c(t4);
        }
        kotlin.jvm.internal.k.c(t4, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return t4;
    }
}
