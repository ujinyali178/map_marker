package kotlinx.coroutines.internal;

/* loaded from: /root/release/classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3809a = new b0("CONDITION_FALSE");

    /* renamed from: b, reason: collision with root package name */
    private static final Object f3810b = new b0("LIST_EMPTY");

    public static final Object a() {
        return f3809a;
    }

    public static final o b(Object obj) {
        o oVar;
        x xVar = obj instanceof x ? (x) obj : null;
        return (xVar == null || (oVar = xVar.f3835a) == null) ? (o) obj : oVar;
    }
}
