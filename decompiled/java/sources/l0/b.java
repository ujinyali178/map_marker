package l0;

/* loaded from: /root/release/classes.dex */
public class b<T1, T2> {

    /* renamed from: a, reason: collision with root package name */
    private T1 f3908a;

    /* renamed from: b, reason: collision with root package name */
    private T2 f3909b;

    public b(T1 t12, T2 t22) {
        this.f3908a = t12;
        this.f3909b = t22;
    }

    public T1 a() {
        return this.f3908a;
    }

    public T2 b() {
        return this.f3909b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return d.e(this.f3908a, bVar.f3908a) && d.e(this.f3909b, bVar.f3909b);
    }

    public int hashCode() {
        T1 t12 = this.f3908a;
        int hashCode = t12 == null ? 0 : t12.hashCode();
        T2 t22 = this.f3909b;
        return hashCode + (t22 != null ? t22.hashCode() : 0);
    }
}
