package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: /root/release/classes2.dex */
public final class y<T> {
    private volatile AtomicReferenceArray<T> array;

    public y(int i3) {
        this.array = new AtomicReferenceArray<>(i3);
    }

    public final int a() {
        return this.array.length();
    }

    public final T b(int i3) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        if (i3 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i3);
        }
        return null;
    }

    public final void c(int i3, T t3) {
        int a4;
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i3 < length) {
            atomicReferenceArray.set(i3, t3);
            return;
        }
        a4 = s2.f.a(i3 + 1, length * 2);
        AtomicReferenceArray<T> atomicReferenceArray2 = new AtomicReferenceArray<>(a4);
        for (int i4 = 0; i4 < length; i4++) {
            atomicReferenceArray2.set(i4, atomicReferenceArray.get(i4));
        }
        atomicReferenceArray2.set(i3, t3);
        this.array = atomicReferenceArray2;
    }
}
