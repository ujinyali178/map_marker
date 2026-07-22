package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public final class zzar {
    static int zza(Set set) {
        Iterator it = set.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i3 += next != null ? next.hashCode() : 0;
        }
        return i3;
    }
}
