package org.mapsforge.map.layer.cache;

import java.util.Map;
import org.mapsforge.core.graphics.TileBitmap;
import org.mapsforge.core.util.WorkingSetCache;
import org.mapsforge.map.layer.queue.Job;

/* loaded from: /root/release/classes2.dex */
class BitmapLRUCache extends WorkingSetCache<Job, TileBitmap> {
    private static final long serialVersionUID = 1;

    public BitmapLRUCache(int i3) {
        super(i3);
    }

    @Override // org.mapsforge.core.util.LRUCache, java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<Job, TileBitmap> entry) {
        if (size() <= this.capacity) {
            return false;
        }
        TileBitmap value = entry.getValue();
        if (value == null) {
            return true;
        }
        value.decrementRefCount();
        return true;
    }
}
