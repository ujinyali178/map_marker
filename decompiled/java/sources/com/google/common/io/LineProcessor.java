package com.google.common.io;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface LineProcessor<T> {
    @ParametricNullness
    T getResult();

    boolean processLine(String str);
}
