package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.a0;
import java.lang.reflect.Constructor;

/* loaded from: /root/release/classes.dex */
public final class x extends a0.d implements a0.b {

    /* renamed from: a, reason: collision with root package name */
    private Application f1334a;

    /* renamed from: b, reason: collision with root package name */
    private final a0.b f1335b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f1336c;

    /* renamed from: d, reason: collision with root package name */
    private e f1337d;

    /* renamed from: e, reason: collision with root package name */
    private androidx.savedstate.a f1338e;

    public x(Application application, q.d owner, Bundle bundle) {
        kotlin.jvm.internal.k.e(owner, "owner");
        this.f1338e = owner.getSavedStateRegistry();
        this.f1337d = owner.getLifecycle();
        this.f1336c = bundle;
        this.f1334a = application;
        this.f1335b = application != null ? a0.a.f1273e.a(application) : new a0.a();
    }

    @Override // androidx.lifecycle.a0.b
    public <T extends z> T a(Class<T> modelClass) {
        kotlin.jvm.internal.k.e(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) d(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.a0.b
    public <T extends z> T b(Class<T> modelClass, p.a extras) {
        kotlin.jvm.internal.k.e(modelClass, "modelClass");
        kotlin.jvm.internal.k.e(extras, "extras");
        String str = (String) extras.a(a0.c.f1280c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(u.f1324a) == null || extras.a(u.f1325b) == null) {
            if (this.f1337d != null) {
                return (T) d(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(a0.a.f1275g);
        boolean isAssignableFrom = a.class.isAssignableFrom(modelClass);
        Constructor c3 = y.c(modelClass, (!isAssignableFrom || application == null) ? y.f1340b : y.f1339a);
        return c3 == null ? (T) this.f1335b.b(modelClass, extras) : (!isAssignableFrom || application == null) ? (T) y.d(modelClass, c3, u.a(extras)) : (T) y.d(modelClass, c3, application, u.a(extras));
    }

    @Override // androidx.lifecycle.a0.d
    public void c(z viewModel) {
        kotlin.jvm.internal.k.e(viewModel, "viewModel");
        if (this.f1337d != null) {
            androidx.savedstate.a aVar = this.f1338e;
            kotlin.jvm.internal.k.b(aVar);
            e eVar = this.f1337d;
            kotlin.jvm.internal.k.b(eVar);
            LegacySavedStateHandleController.a(viewModel, aVar, eVar);
        }
    }

    public final <T extends z> T d(String key, Class<T> modelClass) {
        T t3;
        Application application;
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(modelClass, "modelClass");
        e eVar = this.f1337d;
        if (eVar == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean isAssignableFrom = a.class.isAssignableFrom(modelClass);
        Constructor c3 = y.c(modelClass, (!isAssignableFrom || this.f1334a == null) ? y.f1340b : y.f1339a);
        if (c3 == null) {
            return this.f1334a != null ? (T) this.f1335b.a(modelClass) : (T) a0.c.f1278a.a().a(modelClass);
        }
        androidx.savedstate.a aVar = this.f1338e;
        kotlin.jvm.internal.k.b(aVar);
        SavedStateHandleController b4 = LegacySavedStateHandleController.b(aVar, eVar, key, this.f1336c);
        if (!isAssignableFrom || (application = this.f1334a) == null) {
            t3 = (T) y.d(modelClass, c3, b4.b());
        } else {
            kotlin.jvm.internal.k.b(application);
            t3 = (T) y.d(modelClass, c3, application, b4.b());
        }
        t3.e("androidx.lifecycle.savedstate.vm.tag", b4);
        return t3;
    }
}
