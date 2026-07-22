package com.google.common.base;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
interface PatternCompiler {
    CommonPattern compile(String str);

    boolean isPcreLike();
}
