package com.google.maps.android.clustering.algo;

import androidx.collection.e;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /root/release/classes.dex */
public class PreCachingAlgorithmDecorator<T extends ClusterItem> extends AbstractAlgorithm<T> {
    private final Algorithm<T> mAlgorithm;
    private final e<Integer, Set<? extends Cluster<T>>> mCache = new e<>(5);
    private final ReadWriteLock mCacheLock = new ReentrantReadWriteLock();
    private final Executor mExecutor = Executors.newCachedThreadPool();

    private class PrecacheRunnable implements Runnable {
        private final int mZoom;

        public PrecacheRunnable(int i3) {
            this.mZoom = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep((long) ((Math.random() * 500.0d) + 500.0d));
            } catch (InterruptedException unused) {
            }
            PreCachingAlgorithmDecorator.this.getClustersInternal(this.mZoom);
        }
    }

    public PreCachingAlgorithmDecorator(Algorithm<T> algorithm) {
        this.mAlgorithm = algorithm;
    }

    private void clearCache() {
        this.mCache.evictAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<? extends Cluster<T>> getClustersInternal(int i3) {
        this.mCacheLock.readLock().lock();
        Set<? extends Cluster<T>> set = this.mCache.get(Integer.valueOf(i3));
        this.mCacheLock.readLock().unlock();
        if (set == null) {
            this.mCacheLock.writeLock().lock();
            set = this.mCache.get(Integer.valueOf(i3));
            if (set == null) {
                set = this.mAlgorithm.getClusters(i3);
                this.mCache.put(Integer.valueOf(i3), set);
            }
            this.mCacheLock.writeLock().unlock();
        }
        return set;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItem(T t3) {
        boolean addItem = this.mAlgorithm.addItem(t3);
        if (addItem) {
            clearCache();
        }
        return addItem;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItems(Collection<T> collection) {
        boolean addItems = this.mAlgorithm.addItems(collection);
        if (addItems) {
            clearCache();
        }
        return addItems;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        this.mAlgorithm.clearItems();
        clearCache();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(float f3) {
        int i3 = (int) f3;
        Set<? extends Cluster<T>> clustersInternal = getClustersInternal(i3);
        int i4 = i3 + 1;
        if (this.mCache.get(Integer.valueOf(i4)) == null) {
            this.mExecutor.execute(new PrecacheRunnable(i4));
        }
        int i5 = i3 - 1;
        if (this.mCache.get(Integer.valueOf(i5)) == null) {
            this.mExecutor.execute(new PrecacheRunnable(i5));
        }
        return clustersInternal;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Collection<T> getItems() {
        return this.mAlgorithm.getItems();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public int getMaxDistanceBetweenClusteredItems() {
        return this.mAlgorithm.getMaxDistanceBetweenClusteredItems();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItem(T t3) {
        boolean removeItem = this.mAlgorithm.removeItem(t3);
        if (removeItem) {
            clearCache();
        }
        return removeItem;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItems(Collection<T> collection) {
        boolean removeItems = this.mAlgorithm.removeItems(collection);
        if (removeItems) {
            clearCache();
        }
        return removeItems;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void setMaxDistanceBetweenClusteredItems(int i3) {
        this.mAlgorithm.setMaxDistanceBetweenClusteredItems(i3);
        clearCache();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean updateItem(T t3) {
        boolean updateItem = this.mAlgorithm.updateItem(t3);
        if (updateItem) {
            clearCache();
        }
        return updateItem;
    }
}
