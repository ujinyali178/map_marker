package kotlinx.coroutines.internal;

import w2.n0;
import w2.v1;

/* loaded from: /root/release/classes2.dex */
final class u extends v1 implements n0 {

    /* renamed from: f, reason: collision with root package name */
    private final Throwable f3830f;

    /* renamed from: g, reason: collision with root package name */
    private final String f3831g;

    public u(Throwable th, String str) {
        this.f3830f = th;
        this.f3831g = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r1 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Void z() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f3830f
            if (r0 == 0) goto L36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f3831g
            if (r1 == 0) goto L25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L27
        L25:
            java.lang.String r1 = ""
        L27:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f3830f
            r1.<init>(r0, r2)
            throw r1
        L36:
            kotlinx.coroutines.internal.t.d()
            g2.d r0 = new g2.d
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.u.z():java.lang.Void");
    }

    @Override // w2.c0
    public boolean m(i2.g gVar) {
        z();
        throw new g2.d();
    }

    @Override // w2.v1
    public v1 p() {
        return this;
    }

    @Override // w2.v1, w2.c0
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f3830f != null) {
            str = ", cause=" + this.f3830f;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    @Override // w2.c0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public Void g(i2.g gVar, Runnable runnable) {
        z();
        throw new g2.d();
    }
}
