package com.google.common.base;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Use an instance of one of the Finalizable*Reference classes")
@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface FinalizableReference {
    void finalizeReferent();
}
