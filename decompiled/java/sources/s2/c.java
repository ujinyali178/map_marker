package s2;

import kotlin.jvm.internal.g;

/* loaded from: /root/release/classes.dex */
public final class c extends s2.a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f4113h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final c f4114i = new c(1, 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a() {
            return c.f4114i;
        }
    }

    public c(int i3, int i4) {
        super(i3, i4, 1);
    }

    @Override // s2.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || b() != cVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i3) {
        return a() <= i3 && i3 <= b();
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    public Integer h() {
        return Integer.valueOf(a());
    }

    @Override // s2.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // s2.a
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // s2.a
    public String toString() {
        return a() + ".." + b();
    }
}
