package g2;

import java.io.Serializable;

/* loaded from: /root/release/classes.dex */
final class m<T> implements e<T>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    private p2.a<? extends T> f2551c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Object f2552d;

    /* renamed from: f, reason: collision with root package name */
    private final Object f2553f;

    public m(p2.a<? extends T> initializer, Object obj) {
        kotlin.jvm.internal.k.e(initializer, "initializer");
        this.f2551c = initializer;
        this.f2552d = o.f2554a;
        this.f2553f = obj == null ? this : obj;
    }

    public /* synthetic */ m(p2.a aVar, Object obj, int i3, kotlin.jvm.internal.g gVar) {
        this(aVar, (i3 & 2) != 0 ? null : obj);
    }

    public boolean a() {
        return this.f2552d != o.f2554a;
    }

    @Override // g2.e
    public T getValue() {
        T t3;
        T t4 = (T) this.f2552d;
        o oVar = o.f2554a;
        if (t4 != oVar) {
            return t4;
        }
        synchronized (this.f2553f) {
            t3 = (T) this.f2552d;
            if (t3 == oVar) {
                p2.a<? extends T> aVar = this.f2551c;
                kotlin.jvm.internal.k.b(aVar);
                t3 = aVar.invoke();
                this.f2552d = t3;
                this.f2551c = null;
            }
        }
        return t3;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
