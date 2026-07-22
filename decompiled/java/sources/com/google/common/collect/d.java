package com.google.common.collect;

import com.google.common.base.Function;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class d implements Function {
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return ((Iterable) obj).iterator();
    }
}
