package p;

import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.z;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class b implements a0.b {

    /* renamed from: a, reason: collision with root package name */
    private final f<?>[] f4081a;

    public b(f<?>... initializers) {
        k.e(initializers, "initializers");
        this.f4081a = initializers;
    }

    @Override // androidx.lifecycle.a0.b
    public /* synthetic */ z a(Class cls) {
        return b0.a(this, cls);
    }

    @Override // androidx.lifecycle.a0.b
    public <T extends z> T b(Class<T> modelClass, a extras) {
        k.e(modelClass, "modelClass");
        k.e(extras, "extras");
        T t3 = null;
        for (f<?> fVar : this.f4081a) {
            if (k.a(fVar.a(), modelClass)) {
                Object invoke = fVar.b().invoke(extras);
                t3 = invoke instanceof z ? (T) invoke : null;
            }
        }
        if (t3 != null) {
            return t3;
        }
        throw new IllegalArgumentException("No initializer set for given class " + modelClass.getName());
    }
}
