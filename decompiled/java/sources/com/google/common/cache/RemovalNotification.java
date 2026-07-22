package com.google.common.cache;

import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    private RemovalNotification(@CheckForNull K k3, @CheckForNull V v3, RemovalCause removalCause) {
        super(k3, v3);
        this.cause = (RemovalCause) Preconditions.checkNotNull(removalCause);
    }

    public static <K, V> RemovalNotification<K, V> create(@CheckForNull K k3, @CheckForNull V v3, RemovalCause removalCause) {
        return new RemovalNotification<>(k3, v3, removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
