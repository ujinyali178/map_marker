package org.mapsforge.core.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /root/release/classes2.dex */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final float LOAD_FACTOR = 0.6f;
    private static final long serialVersionUID = 1;
    public final int capacity;

    public LRUCache(int i3) {
        super(calculateInitialCapacity(i3), LOAD_FACTOR, true);
        this.capacity = i3;
    }

    private static int calculateInitialCapacity(int i3) {
        if (i3 >= 0) {
            return ((int) (i3 / LOAD_FACTOR)) + 2;
        }
        throw new IllegalArgumentException("capacity must not be negative: " + i3);
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.capacity;
    }
}
