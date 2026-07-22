package w2;

/* loaded from: /root/release/classes2.dex */
final class u {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4518a;

    /* renamed from: b, reason: collision with root package name */
    public final i f4519b;

    /* renamed from: c, reason: collision with root package name */
    public final p2.l<Throwable, g2.q> f4520c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f4521d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f4522e;

    /* JADX WARN: Multi-variable type inference failed */
    public u(Object obj, i iVar, p2.l<? super Throwable, g2.q> lVar, Object obj2, Throwable th) {
        this.f4518a = obj;
        this.f4519b = iVar;
        this.f4520c = lVar;
        this.f4521d = obj2;
        this.f4522e = th;
    }

    public /* synthetic */ u(Object obj, i iVar, p2.l lVar, Object obj2, Throwable th, int i3, kotlin.jvm.internal.g gVar) {
        this(obj, (i3 & 2) != 0 ? null : iVar, (i3 & 4) != 0 ? null : lVar, (i3 & 8) != 0 ? null : obj2, (i3 & 16) != 0 ? null : th);
    }

    public static /* synthetic */ u b(u uVar, Object obj, i iVar, p2.l lVar, Object obj2, Throwable th, int i3, Object obj3) {
        if ((i3 & 1) != 0) {
            obj = uVar.f4518a;
        }
        if ((i3 & 2) != 0) {
            iVar = uVar.f4519b;
        }
        i iVar2 = iVar;
        if ((i3 & 4) != 0) {
            lVar = uVar.f4520c;
        }
        p2.l lVar2 = lVar;
        if ((i3 & 8) != 0) {
            obj2 = uVar.f4521d;
        }
        Object obj4 = obj2;
        if ((i3 & 16) != 0) {
            th = uVar.f4522e;
        }
        return uVar.a(obj, iVar2, lVar2, obj4, th);
    }

    public final u a(Object obj, i iVar, p2.l<? super Throwable, g2.q> lVar, Object obj2, Throwable th) {
        return new u(obj, iVar, lVar, obj2, th);
    }

    public final boolean c() {
        return this.f4522e != null;
    }

    public final void d(l<?> lVar, Throwable th) {
        i iVar = this.f4519b;
        if (iVar != null) {
            lVar.l(iVar, th);
        }
        p2.l<Throwable, g2.q> lVar2 = this.f4520c;
        if (lVar2 != null) {
            lVar.o(lVar2, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return kotlin.jvm.internal.k.a(this.f4518a, uVar.f4518a) && kotlin.jvm.internal.k.a(this.f4519b, uVar.f4519b) && kotlin.jvm.internal.k.a(this.f4520c, uVar.f4520c) && kotlin.jvm.internal.k.a(this.f4521d, uVar.f4521d) && kotlin.jvm.internal.k.a(this.f4522e, uVar.f4522e);
    }

    public int hashCode() {
        Object obj = this.f4518a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        i iVar = this.f4519b;
        int hashCode2 = (hashCode + (iVar == null ? 0 : iVar.hashCode())) * 31;
        p2.l<Throwable, g2.q> lVar = this.f4520c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f4521d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f4522e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f4518a + ", cancelHandler=" + this.f4519b + ", onCancellation=" + this.f4520c + ", idempotentResume=" + this.f4521d + ", cancelCause=" + this.f4522e + ')';
    }
}
