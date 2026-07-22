package com.google.common.cache;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface RemovalListener<K, V> {
    void onRemoval(RemovalNotification<K, V> removalNotification);
}
