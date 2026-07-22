package a3;

import i2.g;
import kotlin.jvm.internal.l;
import kotlinx.coroutines.internal.z;
import p2.p;
import w2.l1;

/* loaded from: /root/release/classes2.dex */
public final class e {

    static final class a extends l implements p<Integer, g.b, Integer> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ c<?> f238c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c<?> cVar) {
            super(2);
            this.f238c = cVar;
        }

        public final Integer a(int i3, g.b bVar) {
            g.c<?> key = bVar.getKey();
            g.b a4 = this.f238c.f231d.a(key);
            if (key != l1.f4484e) {
                return Integer.valueOf(bVar != a4 ? Integer.MIN_VALUE : i3 + 1);
            }
            l1 l1Var = (l1) a4;
            l1 b4 = e.b((l1) bVar, l1Var);
            if (b4 == l1Var) {
                if (l1Var != null) {
                    i3++;
                }
                return Integer.valueOf(i3);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b4 + ", expected child of " + l1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // p2.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, g.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    public static final void a(c<?> cVar, g gVar) {
        if (((Number) gVar.x(0, new a(cVar))).intValue() == cVar.f232f) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + cVar.f231d + ",\n\t\tbut emission happened in " + gVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final l1 b(l1 l1Var, l1 l1Var2) {
        while (l1Var != null) {
            if (l1Var == l1Var2 || !(l1Var instanceof z)) {
                return l1Var;
            }
            l1Var = ((z) l1Var).C0();
        }
        return null;
    }
}
