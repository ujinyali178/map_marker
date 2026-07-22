package org.mapsforge.map.layer.cache;

import java.io.File;
import java.util.Map;
import java.util.logging.Logger;
import org.mapsforge.core.util.WorkingSetCache;

/* loaded from: /root/release/classes2.dex */
class FileWorkingSetCache<T> extends WorkingSetCache<T, File> {
    private static final Logger LOGGER = Logger.getLogger(FileWorkingSetCache.class.getName());
    private static final long serialVersionUID = 1;

    FileWorkingSetCache(int i3) {
        super(i3);
    }

    @Override // org.mapsforge.core.util.LRUCache, java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<T, File> entry) {
        if (size() <= this.capacity) {
            return false;
        }
        File value = entry.getValue();
        if (value == null || !value.exists() || value.delete()) {
            return true;
        }
        LOGGER.severe("could not delete file: " + value);
        return true;
    }
}
