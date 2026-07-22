package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
public final class zzak {
    public static Object zza(Iterable iterable, Object obj) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }
}
