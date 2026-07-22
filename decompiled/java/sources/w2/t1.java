package w2;

/* loaded from: /root/release/classes2.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.b0 f4511a = new kotlinx.coroutines.internal.b0("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f4512b = new kotlinx.coroutines.internal.b0("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.b0 f4513c = new kotlinx.coroutines.internal.b0("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.b0 f4514d = new kotlinx.coroutines.internal.b0("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.b0 f4515e = new kotlinx.coroutines.internal.b0("SEALED");

    /* renamed from: f, reason: collision with root package name */
    private static final v0 f4516f = new v0(false);

    /* renamed from: g, reason: collision with root package name */
    private static final v0 f4517g = new v0(true);

    public static final Object g(Object obj) {
        return obj instanceof g1 ? new h1((g1) obj) : obj;
    }

    public static final Object h(Object obj) {
        g1 g1Var;
        h1 h1Var = obj instanceof h1 ? (h1) obj : null;
        return (h1Var == null || (g1Var = h1Var.f4466a) == null) ? obj : g1Var;
    }
}
