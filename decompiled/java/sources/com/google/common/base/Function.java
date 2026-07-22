package com.google.common.base;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface Function<F, T> {
    @ParametricNullness
    T apply(@ParametricNullness F f3);

    boolean equals(@CheckForNull Object obj);
}
