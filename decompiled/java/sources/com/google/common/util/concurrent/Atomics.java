package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Atomics {
    private Atomics() {
    }

    public static <V> AtomicReference<V> newReference() {
        return new AtomicReference<>();
    }

    public static <V> AtomicReference<V> newReference(@ParametricNullness V v3) {
        return new AtomicReference<>(v3);
    }

    public static <E> AtomicReferenceArray<E> newReferenceArray(int i3) {
        return new AtomicReferenceArray<>(i3);
    }

    public static <E> AtomicReferenceArray<E> newReferenceArray(E[] eArr) {
        return new AtomicReferenceArray<>(eArr);
    }
}
