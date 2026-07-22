package kotlin.coroutines.jvm.internal;

import g2.k;
import g2.l;
import g2.q;
import java.io.Serializable;

/* loaded from: /root/release/classes.dex */
public abstract class a implements i2.d<Object>, e, Serializable {
    private final i2.d<Object> completion;

    public a(i2.d<Object> dVar) {
        this.completion = dVar;
    }

    public i2.d<q> create(i2.d<?> completion) {
        kotlin.jvm.internal.k.e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public i2.d<q> create(Object obj, i2.d<?> completion) {
        kotlin.jvm.internal.k.e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public e getCallerFrame() {
        i2.d<Object> dVar = this.completion;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public final i2.d<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i2.d
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        Object c3;
        i2.d dVar = this;
        while (true) {
            h.b(dVar);
            a aVar = (a) dVar;
            i2.d dVar2 = aVar.completion;
            kotlin.jvm.internal.k.b(dVar2);
            try {
                invokeSuspend = aVar.invokeSuspend(obj);
                c3 = j2.d.c();
            } catch (Throwable th) {
                k.a aVar2 = g2.k.f2549c;
                obj = g2.k.a(l.a(th));
            }
            if (invokeSuspend == c3) {
                return;
            }
            obj = g2.k.a(invokeSuspend);
            aVar.releaseIntercepted();
            if (!(dVar2 instanceof a)) {
                dVar2.resumeWith(obj);
                return;
            }
            dVar = dVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }
}
