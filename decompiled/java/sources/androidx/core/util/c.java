package androidx.core.util;

/* loaded from: /root/release/classes.dex */
public class c<F, S> {

    /* renamed from: a, reason: collision with root package name */
    public final F f759a;

    /* renamed from: b, reason: collision with root package name */
    public final S f760b;

    public c(F f3, S s3) {
        this.f759a = f3;
        this.f760b = s3;
    }

    public static <A, B> c<A, B> a(A a4, B b4) {
        return new c<>(a4, b4);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return b.a(cVar.f759a, this.f759a) && b.a(cVar.f760b, this.f760b);
    }

    public int hashCode() {
        F f3 = this.f759a;
        int hashCode = f3 == null ? 0 : f3.hashCode();
        S s3 = this.f760b;
        return hashCode ^ (s3 != null ? s3.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f759a + " " + this.f760b + "}";
    }
}
