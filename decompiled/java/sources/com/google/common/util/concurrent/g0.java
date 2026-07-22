package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class g0 {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i3, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i3, obj, obj2)) {
            if (atomicReferenceArray.get(i3) != obj) {
                return false;
            }
        }
        return true;
    }
}
