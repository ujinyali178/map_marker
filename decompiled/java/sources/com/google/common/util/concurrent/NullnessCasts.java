package com.google.common.util.concurrent;

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
    static <T> T uncheckedNull() {
        return null;
    }
}
