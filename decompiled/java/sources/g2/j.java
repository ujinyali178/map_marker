package g2;

import java.io.Serializable;

/* loaded from: /root/release/classes.dex */
public final class j<A, B> implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    private final A f2547c;

    /* renamed from: d, reason: collision with root package name */
    private final B f2548d;

    public j(A a4, B b4) {
        this.f2547c = a4;
        this.f2548d = b4;
    }

    public final A a() {
        return this.f2547c;
    }

    public final B b() {
        return this.f2548d;
    }

    public final A c() {
        return this.f2547c;
    }

    public final B d() {
        return this.f2548d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return kotlin.jvm.internal.k.a(this.f2547c, jVar.f2547c) && kotlin.jvm.internal.k.a(this.f2548d, jVar.f2548d);
    }

    public int hashCode() {
        A a4 = this.f2547c;
        int hashCode = (a4 == null ? 0 : a4.hashCode()) * 31;
        B b4 = this.f2548d;
        return hashCode + (b4 != null ? b4.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f2547c + ", " + this.f2548d + ')';
    }
}
