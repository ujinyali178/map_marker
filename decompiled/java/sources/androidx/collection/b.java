package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f384h = new int[0];

    /* renamed from: i, reason: collision with root package name */
    private static final Object[] f385i = new Object[0];

    /* renamed from: j, reason: collision with root package name */
    private static Object[] f386j;

    /* renamed from: k, reason: collision with root package name */
    private static int f387k;

    /* renamed from: l, reason: collision with root package name */
    private static Object[] f388l;

    /* renamed from: m, reason: collision with root package name */
    private static int f389m;

    /* renamed from: c, reason: collision with root package name */
    private int[] f390c;

    /* renamed from: d, reason: collision with root package name */
    Object[] f391d;

    /* renamed from: f, reason: collision with root package name */
    int f392f;

    /* renamed from: g, reason: collision with root package name */
    private f<E, E> f393g;

    class a extends f<E, E> {
        a() {
        }

        @Override // androidx.collection.f
        protected void a() {
            b.this.clear();
        }

        @Override // androidx.collection.f
        protected Object b(int i3, int i4) {
            return b.this.f391d[i3];
        }

        @Override // androidx.collection.f
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // androidx.collection.f
        protected int d() {
            return b.this.f392f;
        }

        @Override // androidx.collection.f
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.f
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.f
        protected void g(E e3, E e4) {
            b.this.add(e3);
        }

        @Override // androidx.collection.f
        protected void h(int i3) {
            b.this.g(i3);
        }

        @Override // androidx.collection.f
        protected E i(int i3, E e3) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public b(int i3) {
        if (i3 == 0) {
            this.f390c = f384h;
            this.f391d = f385i;
        } else {
            a(i3);
        }
        this.f392f = 0;
    }

    private void a(int i3) {
        if (i3 == 8) {
            synchronized (b.class) {
                Object[] objArr = f388l;
                if (objArr != null) {
                    this.f391d = objArr;
                    f388l = (Object[]) objArr[0];
                    this.f390c = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f389m--;
                    return;
                }
            }
        } else if (i3 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f386j;
                if (objArr2 != null) {
                    this.f391d = objArr2;
                    f386j = (Object[]) objArr2[0];
                    this.f390c = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f387k--;
                    return;
                }
            }
        }
        this.f390c = new int[i3];
        this.f391d = new Object[i3];
    }

    private static void c(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f389m < 10) {
                    objArr[0] = f388l;
                    objArr[1] = iArr;
                    for (int i4 = i3 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f388l = objArr;
                    f389m++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (f387k < 10) {
                    objArr[0] = f386j;
                    objArr[1] = iArr;
                    for (int i5 = i3 - 1; i5 >= 2; i5--) {
                        objArr[i5] = null;
                    }
                    f386j = objArr;
                    f387k++;
                }
            }
        }
    }

    private f<E, E> d() {
        if (this.f393g == null) {
            this.f393g = new a();
        }
        return this.f393g;
    }

    private int e(Object obj, int i3) {
        int i4 = this.f392f;
        if (i4 == 0) {
            return -1;
        }
        int a4 = c.a(this.f390c, i4, i3);
        if (a4 < 0 || obj.equals(this.f391d[a4])) {
            return a4;
        }
        int i5 = a4 + 1;
        while (i5 < i4 && this.f390c[i5] == i3) {
            if (obj.equals(this.f391d[i5])) {
                return i5;
            }
            i5++;
        }
        for (int i6 = a4 - 1; i6 >= 0 && this.f390c[i6] == i3; i6--) {
            if (obj.equals(this.f391d[i6])) {
                return i6;
            }
        }
        return ~i5;
    }

    private int f() {
        int i3 = this.f392f;
        if (i3 == 0) {
            return -1;
        }
        int a4 = c.a(this.f390c, i3, 0);
        if (a4 < 0 || this.f391d[a4] == null) {
            return a4;
        }
        int i4 = a4 + 1;
        while (i4 < i3 && this.f390c[i4] == 0) {
            if (this.f391d[i4] == null) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a4 - 1; i5 >= 0 && this.f390c[i5] == 0; i5--) {
            if (this.f391d[i5] == null) {
                return i5;
            }
        }
        return ~i4;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e3) {
        int i3;
        int e4;
        if (e3 == null) {
            e4 = f();
            i3 = 0;
        } else {
            int hashCode = e3.hashCode();
            i3 = hashCode;
            e4 = e(e3, hashCode);
        }
        if (e4 >= 0) {
            return false;
        }
        int i4 = ~e4;
        int i5 = this.f392f;
        int[] iArr = this.f390c;
        if (i5 >= iArr.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            Object[] objArr = this.f391d;
            a(i6);
            int[] iArr2 = this.f390c;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f391d, 0, objArr.length);
            }
            c(iArr, objArr, this.f392f);
        }
        int i7 = this.f392f;
        if (i4 < i7) {
            int[] iArr3 = this.f390c;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f391d;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f392f - i4);
        }
        this.f390c[i4] = i3;
        this.f391d[i4] = e3;
        this.f392f++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.f392f + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= add(it.next());
        }
        return z3;
    }

    public void b(int i3) {
        int[] iArr = this.f390c;
        if (iArr.length < i3) {
            Object[] objArr = this.f391d;
            a(i3);
            int i4 = this.f392f;
            if (i4 > 0) {
                System.arraycopy(iArr, 0, this.f390c, 0, i4);
                System.arraycopy(objArr, 0, this.f391d, 0, this.f392f);
            }
            c(iArr, objArr, this.f392f);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i3 = this.f392f;
        if (i3 != 0) {
            c(this.f390c, this.f391d, i3);
            this.f390c = f384h;
            this.f391d = f385i;
            this.f392f = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f392f; i3++) {
                try {
                    if (!set.contains(h(i3))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E g(int i3) {
        Object[] objArr = this.f391d;
        E e3 = (E) objArr[i3];
        int i4 = this.f392f;
        if (i4 <= 1) {
            c(this.f390c, objArr, i4);
            this.f390c = f384h;
            this.f391d = f385i;
            this.f392f = 0;
        } else {
            int[] iArr = this.f390c;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                int i5 = i4 - 1;
                this.f392f = i5;
                if (i3 < i5) {
                    int i6 = i3 + 1;
                    System.arraycopy(iArr, i6, iArr, i3, i5 - i3);
                    Object[] objArr2 = this.f391d;
                    System.arraycopy(objArr2, i6, objArr2, i3, this.f392f - i3);
                }
                this.f391d[this.f392f] = null;
            } else {
                a(i4 > 8 ? i4 + (i4 >> 1) : 8);
                this.f392f--;
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.f390c, 0, i3);
                    System.arraycopy(objArr, 0, this.f391d, 0, i3);
                }
                int i7 = this.f392f;
                if (i3 < i7) {
                    int i8 = i3 + 1;
                    System.arraycopy(iArr, i8, this.f390c, i3, i7 - i3);
                    System.arraycopy(objArr, i8, this.f391d, i3, this.f392f - i3);
                }
            }
        }
        return e3;
    }

    public E h(int i3) {
        return (E) this.f391d[i3];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f390c;
        int i3 = this.f392f;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            i4 += iArr[i5];
        }
        return i4;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f392f <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        g(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= remove(it.next());
        }
        return z3;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z3 = false;
        for (int i3 = this.f392f - 1; i3 >= 0; i3--) {
            if (!collection.contains(this.f391d[i3])) {
                g(i3);
                z3 = true;
            }
        }
        return z3;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f392f;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i3 = this.f392f;
        Object[] objArr = new Object[i3];
        System.arraycopy(this.f391d, 0, objArr, 0, i3);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f392f) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f392f));
        }
        System.arraycopy(this.f391d, 0, tArr, 0, this.f392f);
        int length = tArr.length;
        int i3 = this.f392f;
        if (length > i3) {
            tArr[i3] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f392f * 14);
        sb.append('{');
        for (int i3 = 0; i3 < this.f392f; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            E h3 = h(i3);
            if (h3 != this) {
                sb.append(h3);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
