package org.mapsforge.map.layer.cache;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import org.mapsforge.core.graphics.TileBitmap;
import org.mapsforge.map.layer.queue.Job;
import org.mapsforge.map.model.common.Observable;
import org.mapsforge.map.model.common.Observer;

/* loaded from: /root/release/classes2.dex */
public class InMemoryTileCache implements TileCache {
    private static final Logger LOGGER = Logger.getLogger(InMemoryTileCache.class.getName());
    private BitmapLRUCache lruCache;
    private Observable observable = new Observable();

    public InMemoryTileCache(int i3) {
        this.lruCache = new BitmapLRUCache(i3);
    }

    @Override // org.mapsforge.map.model.common.ObservableInterface
    public void addObserver(Observer observer) {
        this.observable.addObserver(observer);
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized boolean containsKey(Job job) {
        return this.lruCache.containsKey(job);
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized void destroy() {
        purge();
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized TileBitmap get(Job job) {
        TileBitmap tileBitmap;
        tileBitmap = this.lruCache.get(job);
        if (tileBitmap != null) {
            tileBitmap.incrementRefCount();
        }
        return tileBitmap;
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized int getCapacity() {
        return this.lruCache.capacity;
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public int getCapacityFirstLevel() {
        return getCapacity();
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public TileBitmap getImmediately(Job job) {
        return get(job);
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public void purge() {
        Iterator<TileBitmap> it = this.lruCache.values().iterator();
        while (it.hasNext()) {
            it.next().decrementRefCount();
        }
        this.lruCache.clear();
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized void put(Job job, TileBitmap tileBitmap) {
        if (job == null) {
            throw new IllegalArgumentException("key must not be null");
        }
        if (tileBitmap == null) {
            throw new IllegalArgumentException("bitmap must not be null");
        }
        TileBitmap tileBitmap2 = this.lruCache.get(job);
        if (tileBitmap2 != null) {
            tileBitmap2.decrementRefCount();
        }
        if (this.lruCache.put(job, tileBitmap) != null) {
            LOGGER.warning("overwriting cached entry: " + job);
        }
        tileBitmap.incrementRefCount();
        this.observable.notifyObservers();
    }

    @Override // org.mapsforge.map.model.common.ObservableInterface
    public void removeObserver(Observer observer) {
        this.observable.removeObserver(observer);
    }

    public synchronized void setCapacity(int i3) {
        BitmapLRUCache bitmapLRUCache = new BitmapLRUCache(i3);
        bitmapLRUCache.putAll(this.lruCache);
        this.lruCache = bitmapLRUCache;
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized void setWorkingSet(Set<Job> set) {
        this.lruCache.setWorkingSet(set);
    }
}
