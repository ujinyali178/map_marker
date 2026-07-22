package com.google.common.base;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface Predicate<T> {
    boolean apply(@ParametricNullness T t3);

    boolean equals(@CheckForNull Object obj);
}
