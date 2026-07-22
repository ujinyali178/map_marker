package androidx.window.java.layout;

import androidx.core.util.a;
import g2.l;
import g2.q;
import i2.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import p2.p;
import w2.g0;
import z2.b;
import z2.c;

@f(c = "androidx.window.java.layout.WindowInfoTrackerCallbackAdapter$addListener$1$1", f = "WindowInfoTrackerCallbackAdapter.kt", l = {96}, m = "invokeSuspend")
/* loaded from: /root/release/classes.dex */
final class WindowInfoTrackerCallbackAdapter$addListener$1$1 extends k implements p<g0, d<? super q>, Object> {
    final /* synthetic */ a<T> $consumer;
    final /* synthetic */ b<T> $flow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    WindowInfoTrackerCallbackAdapter$addListener$1$1(b<? extends T> bVar, a<T> aVar, d<? super WindowInfoTrackerCallbackAdapter$addListener$1$1> dVar) {
        super(2, dVar);
        this.$flow = bVar;
        this.$consumer = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d<q> create(Object obj, d<?> dVar) {
        return new WindowInfoTrackerCallbackAdapter$addListener$1$1(this.$flow, this.$consumer, dVar);
    }

    @Override // p2.p
    public final Object invoke(g0 g0Var, d<? super q> dVar) {
        return ((WindowInfoTrackerCallbackAdapter$addListener$1$1) create(g0Var, dVar)).invokeSuspend(q.f2555a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object c3;
        c3 = j2.d.c();
        int i3 = this.label;
        if (i3 == 0) {
            l.b(obj);
            b<T> bVar = this.$flow;
            final a<T> aVar = this.$consumer;
            Object obj2 = new c<T>() { // from class: androidx.window.java.layout.WindowInfoTrackerCallbackAdapter$addListener$1$1$invokeSuspend$$inlined$collect$1
                @Override // z2.c
                public Object emit(T t3, d<? super q> dVar) {
                    a.this.accept(t3);
                    return q.f2555a;
                }
            };
            this.label = 1;
            if (bVar.a(obj2, this) == c3) {
                return c3;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.b(obj);
        }
        return q.f2555a;
    }
}
