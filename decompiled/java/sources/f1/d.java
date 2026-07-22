package f1;

import android.content.Context;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import m1.a;
import u1.l;

/* loaded from: /root/release/classes.dex */
public final class d implements m1.a, n1.a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f2517g = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private c f2518c;

    /* renamed from: d, reason: collision with root package name */
    private e f2519d;

    /* renamed from: f, reason: collision with root package name */
    private l f2520f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Override // m1.a
    public void b(a.b binding) {
        k.e(binding, "binding");
        this.f2520f = new l(binding.b(), "dev.fluttercommunity.plus/share");
        Context a4 = binding.a();
        k.d(a4, "binding.applicationContext");
        this.f2519d = new e(a4);
        Context a5 = binding.a();
        k.d(a5, "binding.applicationContext");
        e eVar = this.f2519d;
        l lVar = null;
        if (eVar == null) {
            k.o("manager");
            eVar = null;
        }
        c cVar = new c(a5, null, eVar);
        this.f2518c = cVar;
        e eVar2 = this.f2519d;
        if (eVar2 == null) {
            k.o("manager");
            eVar2 = null;
        }
        f1.a aVar = new f1.a(cVar, eVar2);
        l lVar2 = this.f2520f;
        if (lVar2 == null) {
            k.o("methodChannel");
        } else {
            lVar = lVar2;
        }
        lVar.e(aVar);
    }

    @Override // n1.a
    public void d(n1.c binding) {
        k.e(binding, "binding");
        j(binding);
    }

    @Override // m1.a
    public void e(a.b binding) {
        k.e(binding, "binding");
        l lVar = this.f2520f;
        if (lVar == null) {
            k.o("methodChannel");
            lVar = null;
        }
        lVar.e(null);
    }

    @Override // n1.a
    public void h() {
        i();
    }

    @Override // n1.a
    public void i() {
        c cVar = this.f2518c;
        if (cVar == null) {
            k.o("share");
            cVar = null;
        }
        cVar.l(null);
    }

    @Override // n1.a
    public void j(n1.c binding) {
        k.e(binding, "binding");
        e eVar = this.f2519d;
        c cVar = null;
        if (eVar == null) {
            k.o("manager");
            eVar = null;
        }
        binding.a(eVar);
        c cVar2 = this.f2518c;
        if (cVar2 == null) {
            k.o("share");
        } else {
            cVar = cVar2;
        }
        cVar.l(binding.i());
    }
}
