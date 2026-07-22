package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private static final List<Class<?>> f1339a;

    /* renamed from: b, reason: collision with root package name */
    private static final List<Class<?>> f1340b;

    static {
        List<Class<?>> f3;
        f3 = h2.n.f(Application.class, t.class);
        f1339a = f3;
        f1340b = h2.m.b(t.class);
    }

    public static final <T> Constructor<T> c(Class<T> modelClass, List<? extends Class<?>> signature) {
        List o3;
        kotlin.jvm.internal.k.e(modelClass, "modelClass");
        kotlin.jvm.internal.k.e(signature, "signature");
        Object[] constructors = modelClass.getConstructors();
        kotlin.jvm.internal.k.d(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            kotlin.jvm.internal.k.d(parameterTypes, "constructor.parameterTypes");
            o3 = h2.j.o(parameterTypes);
            if (kotlin.jvm.internal.k.a(signature, o3)) {
                kotlin.jvm.internal.k.c(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (signature.size() == o3.size() && o3.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final <T extends z> T d(Class<T> modelClass, Constructor<T> constructor, Object... params) {
        kotlin.jvm.internal.k.e(modelClass, "modelClass");
        kotlin.jvm.internal.k.e(constructor, "constructor");
        kotlin.jvm.internal.k.e(params, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Failed to access " + modelClass, e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e5.getCause());
        }
    }
}
