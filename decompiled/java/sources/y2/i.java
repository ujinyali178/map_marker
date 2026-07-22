package y2;

/* loaded from: /root/release/classes2.dex */
public final class i<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final b f4706a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final c f4707b = new c();

    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f4708a;

        public a(Throwable th) {
            this.f4708a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.k.a(this.f4708a, ((a) obj).f4708a);
        }

        public int hashCode() {
            Throwable th = this.f4708a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // y2.i.c
        public String toString() {
            return "Closed(" + this.f4708a + ')';
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final <E> Object a(Throwable th) {
            return i.b(new a(th));
        }

        public final <E> Object b() {
            return i.b(i.f4707b);
        }

        public final <E> Object c(E e3) {
            return i.b(e3);
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public static <T> Object b(Object obj) {
        return obj;
    }
}
