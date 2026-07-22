package s2;

import h2.a0;
import kotlin.jvm.internal.g;

/* loaded from: /root/release/classes.dex */
public class a implements Iterable<Integer> {

    /* renamed from: g, reason: collision with root package name */
    public static final C0102a f4105g = new C0102a(null);

    /* renamed from: c, reason: collision with root package name */
    private final int f4106c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4107d;

    /* renamed from: f, reason: collision with root package name */
    private final int f4108f;

    /* renamed from: s2.a$a, reason: collision with other inner class name */
    public static final class C0102a {
        private C0102a() {
        }

        public /* synthetic */ C0102a(g gVar) {
            this();
        }

        public final a a(int i3, int i4, int i5) {
            return new a(i3, i4, i5);
        }
    }

    public a(int i3, int i4, int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i5 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f4106c = i3;
        this.f4107d = k2.c.b(i3, i4, i5);
        this.f4108f = i5;
    }

    public final int a() {
        return this.f4106c;
    }

    public final int b() {
        return this.f4107d;
    }

    public final int c() {
        return this.f4108f;
    }

    @Override // java.lang.Iterable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a0 iterator() {
        return new b(this.f4106c, this.f4107d, this.f4108f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f4106c != aVar.f4106c || this.f4107d != aVar.f4107d || this.f4108f != aVar.f4108f) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f4106c * 31) + this.f4107d) * 31) + this.f4108f;
    }

    public boolean isEmpty() {
        if (this.f4108f > 0) {
            if (this.f4106c > this.f4107d) {
                return true;
            }
        } else if (this.f4106c < this.f4107d) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i3;
        if (this.f4108f > 0) {
            sb = new StringBuilder();
            sb.append(this.f4106c);
            sb.append("..");
            sb.append(this.f4107d);
            sb.append(" step ");
            i3 = this.f4108f;
        } else {
            sb = new StringBuilder();
            sb.append(this.f4106c);
            sb.append(" downTo ");
            sb.append(this.f4107d);
            sb.append(" step ");
            i3 = -this.f4108f;
        }
        sb.append(i3);
        return sb.toString();
    }
}
