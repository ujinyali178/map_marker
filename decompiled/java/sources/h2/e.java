package h2;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /root/release/classes.dex */
public final class e<E> extends c<E> {

    /* renamed from: g, reason: collision with root package name */
    public static final a f2625g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private static final Object[] f2626h = new Object[0];

    /* renamed from: c, reason: collision with root package name */
    private int f2627c;

    /* renamed from: d, reason: collision with root package name */
    private Object[] f2628d = f2626h;

    /* renamed from: f, reason: collision with root package name */
    private int f2629f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final int a(int i3, int i4) {
            int i5 = i3 + (i3 >> 1);
            if (i5 - i4 < 0) {
                i5 = i4;
            }
            return i5 - 2147483639 > 0 ? i4 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i5;
        }
    }

    private final void c(int i3, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f2628d.length;
        while (i3 < length && it.hasNext()) {
            this.f2628d[i3] = it.next();
            i3++;
        }
        int i4 = this.f2627c;
        for (int i5 = 0; i5 < i4 && it.hasNext(); i5++) {
            this.f2628d[i5] = it.next();
        }
        this.f2629f = size() + collection.size();
    }

    private final void d(int i3) {
        Object[] objArr = new Object[i3];
        Object[] objArr2 = this.f2628d;
        i.d(objArr2, objArr, 0, this.f2627c, objArr2.length);
        Object[] objArr3 = this.f2628d;
        int length = objArr3.length;
        int i4 = this.f2627c;
        i.d(objArr3, objArr, length - i4, 0, i4);
        this.f2627c = 0;
        this.f2628d = objArr;
    }

    private final int e(int i3) {
        return i3 == 0 ? j.k(this.f2628d) : i3 - 1;
    }

    private final void f(int i3) {
        int a4;
        if (i3 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f2628d;
        if (i3 <= objArr.length) {
            return;
        }
        if (objArr != f2626h) {
            d(f2625g.a(objArr.length, i3));
        } else {
            a4 = s2.f.a(i3, 10);
            this.f2628d = new Object[a4];
        }
    }

    private final int g(int i3) {
        if (i3 == j.k(this.f2628d)) {
            return 0;
        }
        return i3 + 1;
    }

    private final int h(int i3) {
        return i3 < 0 ? i3 + this.f2628d.length : i3;
    }

    private final int i(int i3) {
        Object[] objArr = this.f2628d;
        return i3 >= objArr.length ? i3 - objArr.length : i3;
    }

    @Override // h2.c
    public int a() {
        return this.f2629f;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i3, E e3) {
        b.f2622c.b(i3, size());
        if (i3 == size()) {
            addLast(e3);
            return;
        }
        if (i3 == 0) {
            addFirst(e3);
            return;
        }
        f(size() + 1);
        int i4 = i(this.f2627c + i3);
        if (i3 < ((size() + 1) >> 1)) {
            int e4 = e(i4);
            int e5 = e(this.f2627c);
            int i5 = this.f2627c;
            if (e4 >= i5) {
                Object[] objArr = this.f2628d;
                objArr[e5] = objArr[i5];
                i.d(objArr, objArr, i5, i5 + 1, e4 + 1);
            } else {
                Object[] objArr2 = this.f2628d;
                i.d(objArr2, objArr2, i5 - 1, i5, objArr2.length);
                Object[] objArr3 = this.f2628d;
                objArr3[objArr3.length - 1] = objArr3[0];
                i.d(objArr3, objArr3, 0, 1, e4 + 1);
            }
            this.f2628d[e4] = e3;
            this.f2627c = e5;
        } else {
            int i6 = i(this.f2627c + size());
            Object[] objArr4 = this.f2628d;
            if (i4 < i6) {
                i.d(objArr4, objArr4, i4 + 1, i4, i6);
            } else {
                i.d(objArr4, objArr4, 1, 0, i6);
                Object[] objArr5 = this.f2628d;
                objArr5[0] = objArr5[objArr5.length - 1];
                i.d(objArr5, objArr5, i4 + 1, i4, objArr5.length - 1);
            }
            this.f2628d[i4] = e3;
        }
        this.f2629f = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e3) {
        addLast(e3);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection<? extends E> elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        b.f2622c.b(i3, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i3 == size()) {
            return addAll(elements);
        }
        f(size() + elements.size());
        int i4 = i(this.f2627c + size());
        int i5 = i(this.f2627c + i3);
        int size = elements.size();
        if (i3 < ((size() + 1) >> 1)) {
            int i6 = this.f2627c;
            int i7 = i6 - size;
            if (i5 < i6) {
                Object[] objArr = this.f2628d;
                i.d(objArr, objArr, i7, i6, objArr.length);
                Object[] objArr2 = this.f2628d;
                if (size >= i5) {
                    i.d(objArr2, objArr2, objArr2.length - size, 0, i5);
                } else {
                    i.d(objArr2, objArr2, objArr2.length - size, 0, size);
                    Object[] objArr3 = this.f2628d;
                    i.d(objArr3, objArr3, 0, size, i5);
                }
            } else if (i7 >= 0) {
                Object[] objArr4 = this.f2628d;
                i.d(objArr4, objArr4, i7, i6, i5);
            } else {
                Object[] objArr5 = this.f2628d;
                i7 += objArr5.length;
                int i8 = i5 - i6;
                int length = objArr5.length - i7;
                if (length >= i8) {
                    i.d(objArr5, objArr5, i7, i6, i5);
                } else {
                    i.d(objArr5, objArr5, i7, i6, i6 + length);
                    Object[] objArr6 = this.f2628d;
                    i.d(objArr6, objArr6, 0, this.f2627c + length, i5);
                }
            }
            this.f2627c = i7;
            c(h(i5 - size), elements);
        } else {
            int i9 = i5 + size;
            if (i5 < i4) {
                int i10 = size + i4;
                Object[] objArr7 = this.f2628d;
                if (i10 > objArr7.length) {
                    if (i9 >= objArr7.length) {
                        i9 -= objArr7.length;
                    } else {
                        int length2 = i4 - (i10 - objArr7.length);
                        i.d(objArr7, objArr7, 0, length2, i4);
                        Object[] objArr8 = this.f2628d;
                        i.d(objArr8, objArr8, i9, i5, length2);
                    }
                }
                i.d(objArr7, objArr7, i9, i5, i4);
            } else {
                Object[] objArr9 = this.f2628d;
                i.d(objArr9, objArr9, size, 0, i4);
                Object[] objArr10 = this.f2628d;
                if (i9 >= objArr10.length) {
                    i.d(objArr10, objArr10, i9 - objArr10.length, i5, objArr10.length);
                } else {
                    i.d(objArr10, objArr10, 0, objArr10.length - size, objArr10.length);
                    Object[] objArr11 = this.f2628d;
                    i.d(objArr11, objArr11, i9, i5, objArr11.length - size);
                }
            }
            c(i5, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        f(size() + elements.size());
        c(i(this.f2627c + size()), elements);
        return true;
    }

    public final void addFirst(E e3) {
        f(size() + 1);
        int e4 = e(this.f2627c);
        this.f2627c = e4;
        this.f2628d[e4] = e3;
        this.f2629f = size() + 1;
    }

    public final void addLast(E e3) {
        f(size() + 1);
        this.f2628d[i(this.f2627c + size())] = e3;
        this.f2629f = size() + 1;
    }

    @Override // h2.c
    public E b(int i3) {
        int e3;
        int e4;
        b.f2622c.a(i3, size());
        e3 = n.e(this);
        if (i3 == e3) {
            return removeLast();
        }
        if (i3 == 0) {
            return removeFirst();
        }
        int i4 = i(this.f2627c + i3);
        E e5 = (E) this.f2628d[i4];
        if (i3 < (size() >> 1)) {
            int i5 = this.f2627c;
            if (i4 >= i5) {
                Object[] objArr = this.f2628d;
                i.d(objArr, objArr, i5 + 1, i5, i4);
            } else {
                Object[] objArr2 = this.f2628d;
                i.d(objArr2, objArr2, 1, 0, i4);
                Object[] objArr3 = this.f2628d;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i6 = this.f2627c;
                i.d(objArr3, objArr3, i6 + 1, i6, objArr3.length - 1);
            }
            Object[] objArr4 = this.f2628d;
            int i7 = this.f2627c;
            objArr4[i7] = null;
            this.f2627c = g(i7);
        } else {
            int i8 = this.f2627c;
            e4 = n.e(this);
            int i9 = i(i8 + e4);
            Object[] objArr5 = this.f2628d;
            if (i4 <= i9) {
                i.d(objArr5, objArr5, i4, i4 + 1, i9 + 1);
            } else {
                i.d(objArr5, objArr5, i4, i4 + 1, objArr5.length);
                Object[] objArr6 = this.f2628d;
                objArr6[objArr6.length - 1] = objArr6[0];
                i.d(objArr6, objArr6, 0, 1, i9 + 1);
            }
            this.f2628d[i9] = null;
        }
        this.f2629f = size() - 1;
        return e5;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int i3 = i(this.f2627c + size());
        int i4 = this.f2627c;
        if (i4 < i3) {
            i.f(this.f2628d, null, i4, i3);
        } else if (!isEmpty()) {
            Object[] objArr = this.f2628d;
            i.f(objArr, null, this.f2627c, objArr.length);
            i.f(this.f2628d, null, 0, i3);
        }
        this.f2627c = 0;
        this.f2629f = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i3) {
        b.f2622c.a(i3, size());
        return (E) this.f2628d[i(this.f2627c + i3)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i3 = i(this.f2627c + size());
        int i4 = this.f2627c;
        if (i4 < i3) {
            while (i4 < i3) {
                if (!kotlin.jvm.internal.k.a(obj, this.f2628d[i4])) {
                    i4++;
                }
            }
            return -1;
        }
        if (i4 < i3) {
            return -1;
        }
        int length = this.f2628d.length;
        while (true) {
            if (i4 >= length) {
                for (int i5 = 0; i5 < i3; i5++) {
                    if (kotlin.jvm.internal.k.a(obj, this.f2628d[i5])) {
                        i4 = i5 + this.f2628d.length;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.k.a(obj, this.f2628d[i4])) {
                break;
            }
            i4++;
        }
        return i4 - this.f2627c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int k3;
        int i3 = i(this.f2627c + size());
        int i4 = this.f2627c;
        if (i4 < i3) {
            k3 = i3 - 1;
            if (i4 <= k3) {
                while (!kotlin.jvm.internal.k.a(obj, this.f2628d[k3])) {
                    if (k3 != i4) {
                        k3--;
                    }
                }
                return k3 - this.f2627c;
            }
            return -1;
        }
        if (i4 > i3) {
            int i5 = i3 - 1;
            while (true) {
                if (-1 >= i5) {
                    k3 = j.k(this.f2628d);
                    int i6 = this.f2627c;
                    if (i6 <= k3) {
                        while (!kotlin.jvm.internal.k.a(obj, this.f2628d[k3])) {
                            if (k3 != i6) {
                                k3--;
                            }
                        }
                    }
                } else {
                    if (kotlin.jvm.internal.k.a(obj, this.f2628d[i5])) {
                        k3 = i5 + this.f2628d.length;
                        break;
                    }
                    i5--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        int i3;
        kotlin.jvm.internal.k.e(elements, "elements");
        boolean z3 = false;
        z3 = false;
        z3 = false;
        if (!isEmpty()) {
            if (!(this.f2628d.length == 0)) {
                int i4 = i(this.f2627c + size());
                int i5 = this.f2627c;
                if (i5 < i4) {
                    i3 = i5;
                    while (i5 < i4) {
                        Object obj = this.f2628d[i5];
                        if (!elements.contains(obj)) {
                            this.f2628d[i3] = obj;
                            i3++;
                        } else {
                            z3 = true;
                        }
                        i5++;
                    }
                    i.f(this.f2628d, null, i3, i4);
                } else {
                    int length = this.f2628d.length;
                    int i6 = i5;
                    boolean z4 = false;
                    while (i5 < length) {
                        Object[] objArr = this.f2628d;
                        Object obj2 = objArr[i5];
                        objArr[i5] = null;
                        if (!elements.contains(obj2)) {
                            this.f2628d[i6] = obj2;
                            i6++;
                        } else {
                            z4 = true;
                        }
                        i5++;
                    }
                    i3 = i(i6);
                    for (int i7 = 0; i7 < i4; i7++) {
                        Object[] objArr2 = this.f2628d;
                        Object obj3 = objArr2[i7];
                        objArr2[i7] = null;
                        if (!elements.contains(obj3)) {
                            this.f2628d[i3] = obj3;
                            i3 = g(i3);
                        } else {
                            z4 = true;
                        }
                    }
                    z3 = z4;
                }
                if (z3) {
                    this.f2629f = h(i3 - this.f2627c);
                }
            }
        }
        return z3;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f2628d;
        int i3 = this.f2627c;
        E e3 = (E) objArr[i3];
        objArr[i3] = null;
        this.f2627c = g(i3);
        this.f2629f = size() - 1;
        return e3;
    }

    public final E removeLast() {
        int e3;
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int i3 = this.f2627c;
        e3 = n.e(this);
        int i4 = i(i3 + e3);
        Object[] objArr = this.f2628d;
        E e4 = (E) objArr[i4];
        objArr[i4] = null;
        this.f2629f = size() - 1;
        return e4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        int i3;
        kotlin.jvm.internal.k.e(elements, "elements");
        boolean z3 = false;
        z3 = false;
        z3 = false;
        if (!isEmpty()) {
            if (!(this.f2628d.length == 0)) {
                int i4 = i(this.f2627c + size());
                int i5 = this.f2627c;
                if (i5 < i4) {
                    i3 = i5;
                    while (i5 < i4) {
                        Object obj = this.f2628d[i5];
                        if (elements.contains(obj)) {
                            this.f2628d[i3] = obj;
                            i3++;
                        } else {
                            z3 = true;
                        }
                        i5++;
                    }
                    i.f(this.f2628d, null, i3, i4);
                } else {
                    int length = this.f2628d.length;
                    int i6 = i5;
                    boolean z4 = false;
                    while (i5 < length) {
                        Object[] objArr = this.f2628d;
                        Object obj2 = objArr[i5];
                        objArr[i5] = null;
                        if (elements.contains(obj2)) {
                            this.f2628d[i6] = obj2;
                            i6++;
                        } else {
                            z4 = true;
                        }
                        i5++;
                    }
                    i3 = i(i6);
                    for (int i7 = 0; i7 < i4; i7++) {
                        Object[] objArr2 = this.f2628d;
                        Object obj3 = objArr2[i7];
                        objArr2[i7] = null;
                        if (elements.contains(obj3)) {
                            this.f2628d[i3] = obj3;
                            i3 = g(i3);
                        } else {
                            z4 = true;
                        }
                    }
                    z3 = z4;
                }
                if (z3) {
                    this.f2629f = h(i3 - this.f2627c);
                }
            }
        }
        return z3;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i3, E e3) {
        b.f2622c.a(i3, size());
        int i4 = i(this.f2627c + i3);
        Object[] objArr = this.f2628d;
        E e4 = (E) objArr[i4];
        objArr[i4] = e3;
        return e4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.k.e(array, "array");
        if (array.length < size()) {
            array = (T[]) g.a(array, size());
        }
        int i3 = i(this.f2627c + size());
        int i4 = this.f2627c;
        if (i4 < i3) {
            i.e(this.f2628d, array, 0, i4, i3, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f2628d;
            i.d(objArr, array, 0, this.f2627c, objArr.length);
            Object[] objArr2 = this.f2628d;
            i.d(objArr2, array, objArr2.length - this.f2627c, 0, i3);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }
}
