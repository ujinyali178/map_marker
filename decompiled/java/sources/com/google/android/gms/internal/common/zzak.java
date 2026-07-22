package com.google.android.gms.internal.common;

import java.util.ListIterator;
import org.jspecify.nullness.NullMarked;

@NullMarked
/* loaded from: /root/release/classes.dex */
public abstract class zzak extends zzaj implements ListIterator {
    protected zzak() {
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
