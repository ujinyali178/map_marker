package kotlin.jvm.internal;

/* loaded from: /root/release/classes.dex */
public abstract class p extends c implements t2.g {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f3767c;

    public p() {
        this.f3767c = false;
    }

    public p(Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.f3767c = (i3 & 2) == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t2.g getReflected() {
        if (this.f3767c) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
        }
        return (t2.g) super.getReflected();
    }

    @Override // kotlin.jvm.internal.c
    public t2.b compute() {
        return this.f3767c ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return getOwner().equals(pVar.getOwner()) && getName().equals(pVar.getName()) && getSignature().equals(pVar.getSignature()) && k.a(getBoundReceiver(), pVar.getBoundReceiver());
        }
        if (obj instanceof t2.g) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        t2.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
