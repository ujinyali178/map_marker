package w2;

import g2.k;
import java.util.concurrent.CancellationException;

/* loaded from: /root/release/classes2.dex */
public abstract class q0<T> extends kotlinx.coroutines.scheduling.h {

    /* renamed from: f, reason: collision with root package name */
    public int f4495f;

    public q0(int i3) {
        this.f4495f = i3;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract i2.d<T> c();

    public Throwable d(Object obj) {
        v vVar = obj instanceof v ? (v) obj : null;
        if (vVar != null) {
            return vVar.f4525a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(Object obj) {
        return obj;
    }

    public final void h(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            g2.b.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.k.b(th);
        f0.a(c().getContext(), new j0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() {
        Object a4;
        Object a5;
        Object a6;
        kotlinx.coroutines.scheduling.i iVar = this.f3874d;
        try {
            kotlinx.coroutines.internal.f fVar = (kotlinx.coroutines.internal.f) c();
            i2.d<T> dVar = fVar.f3785h;
            Object obj = fVar.f3787j;
            i2.g context = dVar.getContext();
            Object c3 = kotlinx.coroutines.internal.f0.c(context, obj);
            e2<?> g3 = c3 != kotlinx.coroutines.internal.f0.f3788a ? b0.g(dVar, context, c3) : null;
            try {
                i2.g context2 = dVar.getContext();
                Object i3 = i();
                Throwable d3 = d(i3);
                l1 l1Var = (d3 == null && r0.b(this.f4495f)) ? (l1) context2.a(l1.f4484e) : null;
                if (l1Var != null && !l1Var.isActive()) {
                    CancellationException h3 = l1Var.h();
                    a(i3, h3);
                    k.a aVar = g2.k.f2549c;
                    a5 = g2.k.a(g2.l.a(h3));
                } else if (d3 != null) {
                    k.a aVar2 = g2.k.f2549c;
                    a5 = g2.k.a(g2.l.a(d3));
                } else {
                    k.a aVar3 = g2.k.f2549c;
                    a5 = g2.k.a(f(i3));
                }
                dVar.resumeWith(a5);
                g2.q qVar = g2.q.f2555a;
                try {
                    iVar.a();
                    a6 = g2.k.a(g2.q.f2555a);
                } catch (Throwable th) {
                    k.a aVar4 = g2.k.f2549c;
                    a6 = g2.k.a(g2.l.a(th));
                }
                h(null, g2.k.b(a6));
            } finally {
                if (g3 == null || g3.D0()) {
                    kotlinx.coroutines.internal.f0.a(context, c3);
                }
            }
        } catch (Throwable th2) {
            try {
                k.a aVar5 = g2.k.f2549c;
                iVar.a();
                a4 = g2.k.a(g2.q.f2555a);
            } catch (Throwable th3) {
                k.a aVar6 = g2.k.f2549c;
                a4 = g2.k.a(g2.l.a(th3));
            }
            h(th2, g2.k.b(a4));
        }
    }
}
