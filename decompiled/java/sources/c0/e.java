package c0;

/* loaded from: /root/release/classes.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f1681c = new e(null, null);

    /* renamed from: d, reason: collision with root package name */
    public static final e f1682d = new e(a.none, null);

    /* renamed from: e, reason: collision with root package name */
    public static final e f1683e;

    /* renamed from: f, reason: collision with root package name */
    public static final e f1684f;

    /* renamed from: g, reason: collision with root package name */
    public static final e f1685g;

    /* renamed from: h, reason: collision with root package name */
    public static final e f1686h;

    /* renamed from: i, reason: collision with root package name */
    public static final e f1687i;

    /* renamed from: j, reason: collision with root package name */
    public static final e f1688j;

    /* renamed from: k, reason: collision with root package name */
    public static final e f1689k;

    /* renamed from: a, reason: collision with root package name */
    private a f1690a;

    /* renamed from: b, reason: collision with root package name */
    private b f1691b;

    public enum a {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax
    }

    public enum b {
        meet,
        slice
    }

    static {
        a aVar = a.xMidYMid;
        b bVar = b.meet;
        f1683e = new e(aVar, bVar);
        a aVar2 = a.xMinYMin;
        f1684f = new e(aVar2, bVar);
        f1685g = new e(a.xMaxYMax, bVar);
        f1686h = new e(a.xMidYMin, bVar);
        f1687i = new e(a.xMidYMax, bVar);
        b bVar2 = b.slice;
        f1688j = new e(aVar, bVar2);
        f1689k = new e(aVar2, bVar2);
    }

    e(a aVar, b bVar) {
        this.f1690a = aVar;
        this.f1691b = bVar;
    }

    public a a() {
        return this.f1690a;
    }

    public b b() {
        return this.f1691b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f1690a == eVar.f1690a && this.f1691b == eVar.f1691b;
    }

    public String toString() {
        return this.f1690a + " " + this.f1691b;
    }
}
