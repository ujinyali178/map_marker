package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes.dex */
public class g<K, V> {

    /* renamed from: g, reason: collision with root package name */
    static Object[] f418g;

    /* renamed from: h, reason: collision with root package name */
    static int f419h;

    /* renamed from: i, reason: collision with root package name */
    static Object[] f420i;

    /* renamed from: j, reason: collision with root package name */
    static int f421j;

    /* renamed from: c, reason: collision with root package name */
    int[] f422c;

    /* renamed from: d, reason: collision with root package name */
    Object[] f423d;

    /* renamed from: f, reason: collision with root package name */
    int f424f;

    public g() {
        this.f422c = c.f395a;
        this.f423d = c.f397c;
        this.f424f = 0;
    }

    public g(int i3) {
        if (i3 == 0) {
            this.f422c = c.f395a;
            this.f423d = c.f397c;
        } else {
            a(i3);
        }
        this.f424f = 0;
    }

    private void a(int i3) {
        if (i3 == 8) {
            synchronized (g.class) {
                Object[] objArr = f420i;
                if (objArr != null) {
                    this.f423d = objArr;
                    f420i = (Object[]) objArr[0];
                    this.f422c = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f421j--;
                    return;
                }
            }
        } else if (i3 == 4) {
            synchronized (g.class) {
                Object[] objArr2 = f418g;
                if (objArr2 != null) {
                    this.f423d = objArr2;
                    f418g = (Object[]) objArr2[0];
                    this.f422c = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f419h--;
                    return;
                }
            }
        }
        this.f422c = new int[i3];
        this.f423d = new Object[i3 << 1];
    }

    private static int b(int[] iArr, int i3, int i4) {
        try {
            return c.a(iArr, i3, i4);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (f421j < 10) {
                    objArr[0] = f420i;
                    objArr[1] = iArr;
                    for (int i4 = (i3 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f420i = objArr;
                    f421j++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                if (f419h < 10) {
                    objArr[0] = f418g;
                    objArr[1] = iArr;
                    for (int i5 = (i3 << 1) - 1; i5 >= 2; i5--) {
                        objArr[i5] = null;
                    }
                    f418g = objArr;
                    f419h++;
                }
            }
        }
    }

    public void c(int i3) {
        int i4 = this.f424f;
        int[] iArr = this.f422c;
        if (iArr.length < i3) {
            Object[] objArr = this.f423d;
            a(i3);
            if (this.f424f > 0) {
                System.arraycopy(iArr, 0, this.f422c, 0, i4);
                System.arraycopy(objArr, 0, this.f423d, 0, i4 << 1);
            }
            d(iArr, objArr, i4);
        }
        if (this.f424f != i4) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i3 = this.f424f;
        if (i3 > 0) {
            int[] iArr = this.f422c;
            Object[] objArr = this.f423d;
            this.f422c = c.f395a;
            this.f423d = c.f397c;
            this.f424f = 0;
            d(iArr, objArr, i3);
        }
        if (this.f424f > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i3) {
        int i4 = this.f424f;
        if (i4 == 0) {
            return -1;
        }
        int b4 = b(this.f422c, i4, i3);
        if (b4 < 0 || obj.equals(this.f423d[b4 << 1])) {
            return b4;
        }
        int i5 = b4 + 1;
        while (i5 < i4 && this.f422c[i5] == i3) {
            if (obj.equals(this.f423d[i5 << 1])) {
                return i5;
            }
            i5++;
        }
        for (int i6 = b4 - 1; i6 >= 0 && this.f422c[i6] == i3; i6--) {
            if (obj.equals(this.f423d[i6 << 1])) {
                return i6;
            }
        }
        return ~i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f424f; i3++) {
                try {
                    K i4 = i(i3);
                    V l3 = l(i3);
                    Object obj2 = gVar.get(i4);
                    if (l3 == null) {
                        if (obj2 != null || !gVar.containsKey(i4)) {
                            return false;
                        }
                    } else if (!l3.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.f424f; i5++) {
                try {
                    K i6 = i(i5);
                    V l4 = l(i5);
                    Object obj3 = map.get(i6);
                    if (l4 == null) {
                        if (obj3 != null || !map.containsKey(i6)) {
                            return false;
                        }
                    } else if (!l4.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i3 = this.f424f;
        if (i3 == 0) {
            return -1;
        }
        int b4 = b(this.f422c, i3, 0);
        if (b4 < 0 || this.f423d[b4 << 1] == null) {
            return b4;
        }
        int i4 = b4 + 1;
        while (i4 < i3 && this.f422c[i4] == 0) {
            if (this.f423d[i4 << 1] == null) {
                return i4;
            }
            i4++;
        }
        for (int i5 = b4 - 1; i5 >= 0 && this.f422c[i5] == 0; i5--) {
            if (this.f423d[i5 << 1] == null) {
                return i5;
            }
        }
        return ~i4;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v3) {
        int f3 = f(obj);
        return f3 >= 0 ? (V) this.f423d[(f3 << 1) + 1] : v3;
    }

    int h(Object obj) {
        int i3 = this.f424f * 2;
        Object[] objArr = this.f423d;
        if (obj == null) {
            for (int i4 = 1; i4 < i3; i4 += 2) {
                if (objArr[i4] == null) {
                    return i4 >> 1;
                }
            }
            return -1;
        }
        for (int i5 = 1; i5 < i3; i5 += 2) {
            if (obj.equals(objArr[i5])) {
                return i5 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f422c;
        Object[] objArr = this.f423d;
        int i3 = this.f424f;
        int i4 = 1;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            Object obj = objArr[i4];
            i6 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i5];
            i5++;
            i4 += 2;
        }
        return i6;
    }

    public K i(int i3) {
        return (K) this.f423d[i3 << 1];
    }

    public boolean isEmpty() {
        return this.f424f <= 0;
    }

    public V j(int i3) {
        Object[] objArr = this.f423d;
        int i4 = i3 << 1;
        V v3 = (V) objArr[i4 + 1];
        int i5 = this.f424f;
        int i6 = 0;
        if (i5 <= 1) {
            d(this.f422c, objArr, i5);
            this.f422c = c.f395a;
            this.f423d = c.f397c;
        } else {
            int i7 = i5 - 1;
            int[] iArr = this.f422c;
            if (iArr.length <= 8 || i5 >= iArr.length / 3) {
                if (i3 < i7) {
                    int i8 = i3 + 1;
                    int i9 = i7 - i3;
                    System.arraycopy(iArr, i8, iArr, i3, i9);
                    Object[] objArr2 = this.f423d;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i4, i9 << 1);
                }
                Object[] objArr3 = this.f423d;
                int i10 = i7 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            } else {
                a(i5 > 8 ? i5 + (i5 >> 1) : 8);
                if (i5 != this.f424f) {
                    throw new ConcurrentModificationException();
                }
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.f422c, 0, i3);
                    System.arraycopy(objArr, 0, this.f423d, 0, i4);
                }
                if (i3 < i7) {
                    int i11 = i3 + 1;
                    int i12 = i7 - i3;
                    System.arraycopy(iArr, i11, this.f422c, i3, i12);
                    System.arraycopy(objArr, i11 << 1, this.f423d, i4, i12 << 1);
                }
            }
            i6 = i7;
        }
        if (i5 != this.f424f) {
            throw new ConcurrentModificationException();
        }
        this.f424f = i6;
        return v3;
    }

    public V k(int i3, V v3) {
        int i4 = (i3 << 1) + 1;
        Object[] objArr = this.f423d;
        V v4 = (V) objArr[i4];
        objArr[i4] = v3;
        return v4;
    }

    public V l(int i3) {
        return (V) this.f423d[(i3 << 1) + 1];
    }

    public V put(K k3, V v3) {
        int i3;
        int e3;
        int i4 = this.f424f;
        if (k3 == null) {
            e3 = g();
            i3 = 0;
        } else {
            int hashCode = k3.hashCode();
            i3 = hashCode;
            e3 = e(k3, hashCode);
        }
        if (e3 >= 0) {
            int i5 = (e3 << 1) + 1;
            Object[] objArr = this.f423d;
            V v4 = (V) objArr[i5];
            objArr[i5] = v3;
            return v4;
        }
        int i6 = ~e3;
        int[] iArr = this.f422c;
        if (i4 >= iArr.length) {
            int i7 = 4;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i7 = 8;
            }
            Object[] objArr2 = this.f423d;
            a(i7);
            if (i4 != this.f424f) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f422c;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f423d, 0, objArr2.length);
            }
            d(iArr, objArr2, i4);
        }
        if (i6 < i4) {
            int[] iArr3 = this.f422c;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr3 = this.f423d;
            System.arraycopy(objArr3, i6 << 1, objArr3, i8 << 1, (this.f424f - i6) << 1);
        }
        int i9 = this.f424f;
        if (i4 == i9) {
            int[] iArr4 = this.f422c;
            if (i6 < iArr4.length) {
                iArr4[i6] = i3;
                Object[] objArr4 = this.f423d;
                int i10 = i6 << 1;
                objArr4[i10] = k3;
                objArr4[i10 + 1] = v3;
                this.f424f = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k3, V v3) {
        V v4 = get(k3);
        return v4 == null ? put(k3, v3) : v4;
    }

    public V remove(Object obj) {
        int f3 = f(obj);
        if (f3 >= 0) {
            return j(f3);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int f3 = f(obj);
        if (f3 < 0) {
            return false;
        }
        V l3 = l(f3);
        if (obj2 != l3 && (obj2 == null || !obj2.equals(l3))) {
            return false;
        }
        j(f3);
        return true;
    }

    public V replace(K k3, V v3) {
        int f3 = f(k3);
        if (f3 >= 0) {
            return k(f3, v3);
        }
        return null;
    }

    public boolean replace(K k3, V v3, V v4) {
        int f3 = f(k3);
        if (f3 < 0) {
            return false;
        }
        V l3 = l(f3);
        if (l3 != v3 && (v3 == null || !v3.equals(l3))) {
            return false;
        }
        k(f3, v4);
        return true;
    }

    public int size() {
        return this.f424f;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f424f * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f424f; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            K i4 = i(i3);
            if (i4 != this) {
                sb.append(i4);
            } else {
                sb.append("(this Map)");
            }
            sb.append(Tag.KEY_VALUE_SEPARATOR);
            V l3 = l(i3);
            if (l3 != this) {
                sb.append(l3);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
