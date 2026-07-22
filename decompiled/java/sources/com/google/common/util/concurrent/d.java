package com.google.common.util.concurrent;

import sun.misc.Unsafe;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class d {
    public static /* synthetic */ boolean a(Unsafe unsafe, Object obj, long j3, Object obj2, Object obj3) {
        while (!unsafe.compareAndSwapObject(obj, j3, obj2, obj3)) {
            if (unsafe.getObject(obj, j3) != obj2) {
                return false;
            }
        }
        return true;
    }
}
