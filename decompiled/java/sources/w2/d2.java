package w2;

/* loaded from: /root/release/classes2.dex */
public final class d2 extends c0 {

    /* renamed from: f, reason: collision with root package name */
    public static final d2 f4458f = new d2();

    private d2() {
    }

    @Override // w2.c0
    public void g(i2.g gVar, Runnable runnable) {
        g2 g2Var = (g2) gVar.a(g2.f4464f);
        if (g2Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        g2Var.f4465d = true;
    }

    @Override // w2.c0
    public boolean m(i2.g gVar) {
        return false;
    }

    @Override // w2.c0
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
