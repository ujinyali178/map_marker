package z0;

/* loaded from: /root/release/classes.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    private final j f4776a;

    /* renamed from: b, reason: collision with root package name */
    final Runnable f4777b;

    k(j jVar, Runnable runnable) {
        this.f4776a = jVar;
        this.f4777b = runnable;
    }

    public Integer a() {
        j jVar = this.f4776a;
        if (jVar != null) {
            return Integer.valueOf(jVar.a());
        }
        return null;
    }

    public boolean b() {
        j jVar = this.f4776a;
        return jVar != null && jVar.b();
    }
}
