package w2;

/* loaded from: /root/release/classes2.dex */
final class v0 implements g1 {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f4526c;

    public v0(boolean z3) {
        this.f4526c = z3;
    }

    @Override // w2.g1
    public w1 e() {
        return null;
    }

    @Override // w2.g1
    public boolean isActive() {
        return this.f4526c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
