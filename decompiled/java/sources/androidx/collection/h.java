package androidx.collection;

import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes.dex */
public class h<E> implements Cloneable {

    /* renamed from: h, reason: collision with root package name */
    private static final Object f425h = new Object();

    /* renamed from: c, reason: collision with root package name */
    private boolean f426c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f427d;

    /* renamed from: f, reason: collision with root package name */
    private Object[] f428f;

    /* renamed from: g, reason: collision with root package name */
    private int f429g;

    public h() {
        this(10);
    }

    public h(int i3) {
        this.f426c = false;
        if (i3 == 0) {
            this.f427d = c.f395a;
            this.f428f = c.f397c;
        } else {
            int e3 = c.e(i3);
            this.f427d = new int[e3];
            this.f428f = new Object[e3];
        }
    }

    private void c() {
        int i3 = this.f429g;
        int[] iArr = this.f427d;
        Object[] objArr = this.f428f;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[i5];
            if (obj != f425h) {
                if (i5 != i4) {
                    iArr[i4] = iArr[i5];
                    objArr[i4] = obj;
                    objArr[i5] = null;
                }
                i4++;
            }
        }
        this.f426c = false;
        this.f429g = i4;
    }

    public void a() {
        int i3 = this.f429g;
        Object[] objArr = this.f428f;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        this.f429g = 0;
        this.f426c = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f427d = (int[]) this.f427d.clone();
            hVar.f428f = (Object[]) this.f428f.clone();
            return hVar;
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    public E d(int i3) {
        return e(i3, null);
    }

    public E e(int i3, E e3) {
        E e4;
        int a4 = c.a(this.f427d, this.f429g, i3);
        return (a4 < 0 || (e4 = (E) this.f428f[a4]) == f425h) ? e3 : e4;
    }

    public int f(int i3) {
        if (this.f426c) {
            c();
        }
        return this.f427d[i3];
    }

    public void g(int i3, E e3) {
        int a4 = c.a(this.f427d, this.f429g, i3);
        if (a4 >= 0) {
            this.f428f[a4] = e3;
            return;
        }
        int i4 = ~a4;
        int i5 = this.f429g;
        if (i4 < i5) {
            Object[] objArr = this.f428f;
            if (objArr[i4] == f425h) {
                this.f427d[i4] = i3;
                objArr[i4] = e3;
                return;
            }
        }
        if (this.f426c && i5 >= this.f427d.length) {
            c();
            i4 = ~c.a(this.f427d, this.f429g, i3);
        }
        int i6 = this.f429g;
        if (i6 >= this.f427d.length) {
            int e4 = c.e(i6 + 1);
            int[] iArr = new int[e4];
            Object[] objArr2 = new Object[e4];
            int[] iArr2 = this.f427d;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f428f;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f427d = iArr;
            this.f428f = objArr2;
        }
        int i7 = this.f429g;
        if (i7 - i4 != 0) {
            int[] iArr3 = this.f427d;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr4 = this.f428f;
            System.arraycopy(objArr4, i4, objArr4, i8, this.f429g - i4);
        }
        this.f427d[i4] = i3;
        this.f428f[i4] = e3;
        this.f429g++;
    }

    public int h() {
        if (this.f426c) {
            c();
        }
        return this.f429g;
    }

    public E i(int i3) {
        if (this.f426c) {
            c();
        }
        return (E) this.f428f[i3];
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f429g * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f429g; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(f(i3));
            sb.append(Tag.KEY_VALUE_SEPARATOR);
            E i4 = i(i3);
            if (i4 != this) {
                sb.append(i4);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
