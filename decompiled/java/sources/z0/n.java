package z0;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class n {

    class a implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f4786a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o f4787b;

        a(o oVar, i iVar) {
            this.f4787b = oVar;
            this.f4786a = iVar;
        }

        @Override // z0.j
        public int a() {
            return this.f4786a.f4764c;
        }

        @Override // z0.j
        public boolean b() {
            return this.f4786a.F();
        }
    }

    public static void a(o oVar, i iVar, Runnable runnable) {
        oVar.c(new k(iVar == null ? null : new a(oVar, iVar), runnable));
    }

    public static o b(String str, int i3, int i4) {
        return i3 == 1 ? new s(str, i4) : new q(str, i3, i4);
    }
}
