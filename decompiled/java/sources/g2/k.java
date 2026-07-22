package g2;

import java.io.Serializable;

/* loaded from: /root/release/classes.dex */
public final class k<T> implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final a f2549c = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class b implements Serializable {

        /* renamed from: c, reason: collision with root package name */
        public final Throwable f2550c;

        public b(Throwable exception) {
            kotlin.jvm.internal.k.e(exception, "exception");
            this.f2550c = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && kotlin.jvm.internal.k.a(this.f2550c, ((b) obj).f2550c);
        }

        public int hashCode() {
            return this.f2550c.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f2550c + ')';
        }
    }

    public static <T> Object a(Object obj) {
        return obj;
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f2550c;
        }
        return null;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }

    public static final boolean d(Object obj) {
        return !(obj instanceof b);
    }
}
