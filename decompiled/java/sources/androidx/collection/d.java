package androidx.collection;

import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes.dex */
public class d<E> implements Cloneable {

    /* renamed from: h, reason: collision with root package name */
    private static final Object f398h = new Object();

    /* renamed from: c, reason: collision with root package name */
    private boolean f399c;

    /* renamed from: d, reason: collision with root package name */
    private long[] f400d;

    /* renamed from: f, reason: collision with root package name */
    private Object[] f401f;

    /* renamed from: g, reason: collision with root package name */
    private int f402g;

    public d() {
        this(10);
    }

    public d(int i3) {
        this.f399c = false;
        if (i3 == 0) {
            this.f400d = c.f396b;
            this.f401f = c.f397c;
        } else {
            int f3 = c.f(i3);
            this.f400d = new long[f3];
            this.f401f = new Object[f3];
        }
    }

    private void b() {
        int i3 = this.f402g;
        long[] jArr = this.f400d;
        Object[] objArr = this.f401f;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[i5];
            if (obj != f398h) {
                if (i5 != i4) {
                    jArr[i4] = jArr[i5];
                    objArr[i4] = obj;
                    objArr[i5] = null;
                }
                i4++;
            }
        }
        this.f399c = false;
        this.f402g = i4;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f400d = (long[]) this.f400d.clone();
            dVar.f401f = (Object[]) this.f401f.clone();
            return dVar;
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    public E c(long j3) {
        return d(j3, null);
    }

    public E d(long j3, E e3) {
        E e4;
        int b4 = c.b(this.f400d, this.f402g, j3);
        return (b4 < 0 || (e4 = (E) this.f401f[b4]) == f398h) ? e3 : e4;
    }

    public long e(int i3) {
        if (this.f399c) {
            b();
        }
        return this.f400d[i3];
    }

    public void f(long j3, E e3) {
        int b4 = c.b(this.f400d, this.f402g, j3);
        if (b4 >= 0) {
            this.f401f[b4] = e3;
            return;
        }
        int i3 = ~b4;
        int i4 = this.f402g;
        if (i3 < i4) {
            Object[] objArr = this.f401f;
            if (objArr[i3] == f398h) {
                this.f400d[i3] = j3;
                objArr[i3] = e3;
                return;
            }
        }
        if (this.f399c && i4 >= this.f400d.length) {
            b();
            i3 = ~c.b(this.f400d, this.f402g, j3);
        }
        int i5 = this.f402g;
        if (i5 >= this.f400d.length) {
            int f3 = c.f(i5 + 1);
            long[] jArr = new long[f3];
            Object[] objArr2 = new Object[f3];
            long[] jArr2 = this.f400d;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f401f;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f400d = jArr;
            this.f401f = objArr2;
        }
        int i6 = this.f402g;
        if (i6 - i3 != 0) {
            long[] jArr3 = this.f400d;
            int i7 = i3 + 1;
            System.arraycopy(jArr3, i3, jArr3, i7, i6 - i3);
            Object[] objArr4 = this.f401f;
            System.arraycopy(objArr4, i3, objArr4, i7, this.f402g - i3);
        }
        this.f400d[i3] = j3;
        this.f401f[i3] = e3;
        this.f402g++;
    }

    public int g() {
        if (this.f399c) {
            b();
        }
        return this.f402g;
    }

    public E h(int i3) {
        if (this.f399c) {
            b();
        }
        return (E) this.f401f[i3];
    }

    public String toString() {
        if (g() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f402g * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f402g; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(e(i3));
            sb.append(Tag.KEY_VALUE_SEPARATOR);
            E h3 = h(i3);
            if (h3 != this) {
                sb.append(h3);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
