package com.google.common.base;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface Supplier<T> {
    @ParametricNullness
    T get();
}
