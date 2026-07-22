package com.google.common.base;

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
}
