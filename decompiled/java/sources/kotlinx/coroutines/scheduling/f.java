package kotlinx.coroutines.scheduling;

import w2.c1;

/* loaded from: /root/release/classes2.dex */
public class f extends c1 {

    /* renamed from: g, reason: collision with root package name */
    private final int f3868g;

    /* renamed from: h, reason: collision with root package name */
    private final int f3869h;

    /* renamed from: i, reason: collision with root package name */
    private final long f3870i;

    /* renamed from: j, reason: collision with root package name */
    private final String f3871j;

    /* renamed from: k, reason: collision with root package name */
    private a f3872k = p();

    public f(int i3, int i4, long j3, String str) {
        this.f3868g = i3;
        this.f3869h = i4;
        this.f3870i = j3;
        this.f3871j = str;
    }

    private final a p() {
        return new a(this.f3868g, this.f3869h, this.f3870i, this.f3871j);
    }

    @Override // w2.c0
    public void g(i2.g gVar, Runnable runnable) {
        a.h(this.f3872k, runnable, null, false, 6, null);
    }

    public final void w(Runnable runnable, i iVar, boolean z3) {
        this.f3872k.g(runnable, iVar, z3);
    }
}
