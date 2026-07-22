package com.google.common.collect;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    final boolean inclusive;

    BoundType(boolean z3) {
        this.inclusive = z3;
    }

    static BoundType forBoolean(boolean z3) {
        return z3 ? CLOSED : OPEN;
    }
}
