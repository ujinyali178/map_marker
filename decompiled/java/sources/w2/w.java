package w2;

/* loaded from: /root/release/classes2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4527a;

    /* renamed from: b, reason: collision with root package name */
    public final p2.l<Throwable, g2.q> f4528b;

    /* JADX WARN: Multi-variable type inference failed */
    public w(Object obj, p2.l<? super Throwable, g2.q> lVar) {
        this.f4527a = obj;
        this.f4528b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return kotlin.jvm.internal.k.a(this.f4527a, wVar.f4527a) && kotlin.jvm.internal.k.a(this.f4528b, wVar.f4528b);
    }

    public int hashCode() {
        Object obj = this.f4527a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f4528b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f4527a + ", onCancellation=" + this.f4528b + ')';
    }
}
