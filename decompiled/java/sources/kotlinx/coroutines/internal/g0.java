package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlinx.coroutines.internal.h0;

/* loaded from: /root/release/classes2.dex */
public class g0<T extends h0 & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: a, reason: collision with root package name */
    private T[] f3797a;

    private final T[] f() {
        T[] tArr = this.f3797a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new h0[4];
            this.f3797a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
        kotlin.jvm.internal.k.d(copyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((h0[]) copyOf);
        this.f3797a = tArr3;
        return tArr3;
    }

    private final void j(int i3) {
        this._size = i3;
    }

    private final void k(int i3) {
        while (true) {
            int i4 = (i3 * 2) + 1;
            if (i4 >= c()) {
                return;
            }
            T[] tArr = this.f3797a;
            kotlin.jvm.internal.k.b(tArr);
            int i5 = i4 + 1;
            if (i5 < c()) {
                T t3 = tArr[i5];
                kotlin.jvm.internal.k.b(t3);
                T t4 = tArr[i4];
                kotlin.jvm.internal.k.b(t4);
                if (((Comparable) t3).compareTo(t4) < 0) {
                    i4 = i5;
                }
            }
            T t5 = tArr[i3];
            kotlin.jvm.internal.k.b(t5);
            T t6 = tArr[i4];
            kotlin.jvm.internal.k.b(t6);
            if (((Comparable) t5).compareTo(t6) <= 0) {
                return;
            }
            m(i3, i4);
            i3 = i4;
        }
    }

    private final void l(int i3) {
        while (i3 > 0) {
            T[] tArr = this.f3797a;
            kotlin.jvm.internal.k.b(tArr);
            int i4 = (i3 - 1) / 2;
            T t3 = tArr[i4];
            kotlin.jvm.internal.k.b(t3);
            T t4 = tArr[i3];
            kotlin.jvm.internal.k.b(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            m(i3, i4);
            i3 = i4;
        }
    }

    private final void m(int i3, int i4) {
        T[] tArr = this.f3797a;
        kotlin.jvm.internal.k.b(tArr);
        T t3 = tArr[i4];
        kotlin.jvm.internal.k.b(t3);
        T t4 = tArr[i3];
        kotlin.jvm.internal.k.b(t4);
        tArr[i3] = t3;
        tArr[i4] = t4;
        t3.setIndex(i3);
        t4.setIndex(i4);
    }

    public final void a(T t3) {
        t3.b(this);
        T[] f3 = f();
        int c3 = c();
        j(c3 + 1);
        f3[c3] = t3;
        t3.setIndex(c3);
        l(c3);
    }

    public final T b() {
        T[] tArr = this.f3797a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T b4;
        synchronized (this) {
            b4 = b();
        }
        return b4;
    }

    public final boolean g(T t3) {
        boolean z3;
        synchronized (this) {
            if (t3.c() == null) {
                z3 = false;
            } else {
                h(t3.getIndex());
                z3 = true;
            }
        }
        return z3;
    }

    public final T h(int i3) {
        T[] tArr = this.f3797a;
        kotlin.jvm.internal.k.b(tArr);
        j(c() - 1);
        if (i3 < c()) {
            m(i3, c());
            int i4 = (i3 - 1) / 2;
            if (i3 > 0) {
                T t3 = tArr[i3];
                kotlin.jvm.internal.k.b(t3);
                T t4 = tArr[i4];
                kotlin.jvm.internal.k.b(t4);
                if (((Comparable) t3).compareTo(t4) < 0) {
                    m(i3, i4);
                    l(i4);
                }
            }
            k(i3);
        }
        T t5 = tArr[c()];
        kotlin.jvm.internal.k.b(t5);
        t5.b(null);
        t5.setIndex(-1);
        tArr[c()] = null;
        return t5;
    }

    public final T i() {
        T h3;
        synchronized (this) {
            h3 = c() > 0 ? h(0) : null;
        }
        return h3;
    }
}
