package com.google.common.collect;

import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class CollectPreconditions {
    CollectPreconditions() {
    }

    static void checkEntryNotNull(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    static int checkNonnegative(int i3, String str) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i3);
    }

    static long checkNonnegative(long j3, String str) {
        if (j3 >= 0) {
            return j3;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j3);
    }

    static void checkPositive(int i3, String str) {
        if (i3 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be positive but was: " + i3);
    }

    static void checkRemove(boolean z3) {
        Preconditions.checkState(z3, "no calls to next() since the last call to remove()");
    }
}
