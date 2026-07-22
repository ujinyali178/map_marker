package kotlin.coroutines.jvm.internal;

import i2.g;

/* loaded from: /root/release/classes.dex */
public abstract class d extends a {
    private final i2.g _context;
    private transient i2.d<Object> intercepted;

    public d(i2.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }

    public d(i2.d<Object> dVar, i2.g gVar) {
        super(dVar);
        this._context = gVar;
    }

    @Override // i2.d
    public i2.g getContext() {
        i2.g gVar = this._context;
        kotlin.jvm.internal.k.b(gVar);
        return gVar;
    }

    public final i2.d<Object> intercepted() {
        i2.d<Object> dVar = this.intercepted;
        if (dVar == null) {
            i2.e eVar = (i2.e) getContext().a(i2.e.f2690a);
            if (eVar == null || (dVar = eVar.i(this)) == null) {
                dVar = this;
            }
            this.intercepted = dVar;
        }
        return dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    protected void releaseIntercepted() {
        i2.d<?> dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            g.b a4 = getContext().a(i2.e.f2690a);
            kotlin.jvm.internal.k.b(a4);
            ((i2.e) a4).c(dVar);
        }
        this.intercepted = c.f3747c;
    }
}
