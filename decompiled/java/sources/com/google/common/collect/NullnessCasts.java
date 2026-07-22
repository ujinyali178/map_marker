package com.google.common.collect;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class NullnessCasts {
    private NullnessCasts() {
    }

    @ParametricNullness
    static <T> T uncheckedCastNullableTToT(@CheckForNull T t3) {
        return t3;
    }

    @ParametricNullness
    static <T> T unsafeNull() {
        return null;
    }
}
