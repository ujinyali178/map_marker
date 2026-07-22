package kotlinx.coroutines.internal;

import w2.b2;

/* loaded from: /root/release/classes2.dex */
final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final i2.g f3800a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f3801b;

    /* renamed from: c, reason: collision with root package name */
    private final b2<Object>[] f3802c;

    /* renamed from: d, reason: collision with root package name */
    private int f3803d;

    public i0(i2.g gVar, int i3) {
        this.f3800a = gVar;
        this.f3801b = new Object[i3];
        this.f3802c = new b2[i3];
    }

    public final void a(b2<?> b2Var, Object obj) {
        Object[] objArr = this.f3801b;
        int i3 = this.f3803d;
        objArr[i3] = obj;
        b2<Object>[] b2VarArr = this.f3802c;
        this.f3803d = i3 + 1;
        b2VarArr[i3] = b2Var;
    }

    public final void b(i2.g gVar) {
        int length = this.f3802c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i3 = length - 1;
            b2<Object> b2Var = this.f3802c[length];
            kotlin.jvm.internal.k.b(b2Var);
            b2Var.o(gVar, this.f3801b[length]);
            if (i3 < 0) {
                return;
            } else {
                length = i3;
            }
        }
    }
}
