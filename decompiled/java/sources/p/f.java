package p;

import androidx.lifecycle.z;
import kotlin.jvm.internal.k;
import p2.l;

/* loaded from: /root/release/classes.dex */
public final class f<T extends z> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<T> f4084a;

    /* renamed from: b, reason: collision with root package name */
    private final l<a, T> f4085b;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Class<T> clazz, l<? super a, ? extends T> initializer) {
        k.e(clazz, "clazz");
        k.e(initializer, "initializer");
        this.f4084a = clazz;
        this.f4085b = initializer;
    }

    public final Class<T> a() {
        return this.f4084a;
    }

    public final l<a, T> b() {
        return this.f4085b;
    }
}
