package com.google.common.base;

import java.nio.Buffer;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class Java8Compatibility {
    private Java8Compatibility() {
    }

    static void clear(Buffer buffer) {
        buffer.clear();
    }

    static void flip(Buffer buffer) {
        buffer.flip();
    }

    static void limit(Buffer buffer, int i3) {
        buffer.limit(i3);
    }

    static void position(Buffer buffer, int i3) {
        buffer.position(i3);
    }
}
