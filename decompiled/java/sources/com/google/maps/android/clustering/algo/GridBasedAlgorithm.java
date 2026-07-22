package com.google.maps.android.clustering.algo;

import androidx.collection.d;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.projection.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public class GridBasedAlgorithm<T extends ClusterItem> extends AbstractAlgorithm<T> {
    private static final int DEFAULT_GRID_SIZE = 100;
    private int mGridSize = 100;
    private final Set<T> mItems = Collections.synchronizedSet(new HashSet());

    private static long getCoord(long j3, double d3, double d4) {
        return (long) ((j3 * Math.floor(d3)) + Math.floor(d4));
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItem(T t3) {
        return this.mItems.add(t3);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItems(Collection<T> collection) {
        return this.mItems.addAll(collection);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        this.mItems.clear();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(float f3) {
        long j3;
        long ceil = (long) Math.ceil((Math.pow(2.0d, f3) * 256.0d) / this.mGridSize);
        SphericalMercatorProjection sphericalMercatorProjection = new SphericalMercatorProjection(ceil);
        HashSet hashSet = new HashSet();
        d dVar = new d();
        synchronized (this.mItems) {
            for (T t3 : this.mItems) {
                Point point = sphericalMercatorProjection.toPoint(t3.getPosition());
                long coord = getCoord(ceil, point.f2375x, point.f2376y);
                StaticCluster staticCluster = (StaticCluster) dVar.c(coord);
                if (staticCluster == null) {
                    j3 = ceil;
                    staticCluster = new StaticCluster(sphericalMercatorProjection.toLatLng(new com.google.maps.android.geometry.Point(Math.floor(point.f2375x) + 0.5d, Math.floor(point.f2376y) + 0.5d)));
                    dVar.f(coord, staticCluster);
                    hashSet.add(staticCluster);
                } else {
                    j3 = ceil;
                }
                staticCluster.add(t3);
                ceil = j3;
            }
        }
        return hashSet;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Collection<T> getItems() {
        return this.mItems;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public int getMaxDistanceBetweenClusteredItems() {
        return this.mGridSize;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItem(T t3) {
        return this.mItems.remove(t3);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItems(Collection<T> collection) {
        return this.mItems.removeAll(collection);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void setMaxDistanceBetweenClusteredItems(int i3) {
        this.mGridSize = i3;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean updateItem(T t3) {
        boolean removeItem;
        synchronized (this.mItems) {
            removeItem = removeItem(t3);
            if (removeItem) {
                removeItem = addItem(t3);
            }
        }
        return removeItem;
    }
}
