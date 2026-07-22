package w2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: /root/release/classes2.dex */
public class v {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f4524b = AtomicIntegerFieldUpdater.newUpdater(v.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f4525a;

    public v(Throwable th, boolean z3) {
        this.f4525a = th;
        this._handled = z3 ? 1 : 0;
    }

    public /* synthetic */ v(Throwable th, boolean z3, int i3, kotlin.jvm.internal.g gVar) {
        this(th, (i3 & 2) != 0 ? false : z3);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f4524b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return k0.a(this) + '[' + this.f4525a + ']';
    }
}
