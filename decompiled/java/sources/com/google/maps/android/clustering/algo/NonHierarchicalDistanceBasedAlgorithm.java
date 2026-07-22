package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.quadtree.PointQuadTree;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public class NonHierarchicalDistanceBasedAlgorithm<T extends ClusterItem> extends AbstractAlgorithm<T> {
    private static final int DEFAULT_MAX_DISTANCE_AT_ZOOM = 100;
    private static final SphericalMercatorProjection PROJECTION = new SphericalMercatorProjection(1.0d);
    private int mMaxDistance = 100;
    private final Collection<QuadItem<T>> mItems = new LinkedHashSet();
    private final PointQuadTree<QuadItem<T>> mQuadTree = new PointQuadTree<>(0.0d, 1.0d, 0.0d, 1.0d);

    protected static class QuadItem<T extends ClusterItem> implements PointQuadTree.Item, Cluster<T> {
        private final T mClusterItem;
        private final Point mPoint;
        private final LatLng mPosition;
        private Set<T> singletonSet;

        private QuadItem(T t3) {
            this.mClusterItem = t3;
            LatLng position = t3.getPosition();
            this.mPosition = position;
            this.mPoint = NonHierarchicalDistanceBasedAlgorithm.PROJECTION.toPoint(position);
            this.singletonSet = Collections.singleton(t3);
        }

        public boolean equals(Object obj) {
            if (obj instanceof QuadItem) {
                return ((QuadItem) obj).mClusterItem.equals(this.mClusterItem);
            }
            return false;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public Set<T> getItems() {
            return this.singletonSet;
        }

        @Override // com.google.maps.android.quadtree.PointQuadTree.Item
        public Point getPoint() {
            return this.mPoint;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public LatLng getPosition() {
            return this.mPosition;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public int getSize() {
            return 1;
        }

        public int hashCode() {
            return this.mClusterItem.hashCode();
        }
    }

    private Bounds createBoundsFromSpan(Point point, double d3) {
        double d4 = d3 / 2.0d;
        double d5 = point.f2375x;
        double d6 = d5 - d4;
        double d7 = d5 + d4;
        double d8 = point.f2376y;
        return new Bounds(d6, d7, d8 - d4, d8 + d4);
    }

    private double distanceSquared(Point point, Point point2) {
        double d3 = point.f2375x;
        double d4 = point2.f2375x;
        double d5 = (d3 - d4) * (d3 - d4);
        double d6 = point.f2376y;
        double d7 = point2.f2376y;
        return d5 + ((d6 - d7) * (d6 - d7));
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItem(T t3) {
        boolean add;
        QuadItem<T> quadItem = new QuadItem<>(t3);
        synchronized (this.mQuadTree) {
            add = this.mItems.add(quadItem);
            if (add) {
                this.mQuadTree.add(quadItem);
            }
        }
        return add;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItems(Collection<T> collection) {
        Iterator<T> it = collection.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            if (addItem(it.next())) {
                z3 = true;
            }
        }
        return z3;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        synchronized (this.mQuadTree) {
            this.mItems.clear();
            this.mQuadTree.clear();
        }
    }

    protected Collection<QuadItem<T>> getClusteringItems(PointQuadTree<QuadItem<T>> pointQuadTree, float f3) {
        return this.mItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(float f3) {
        double pow = (this.mMaxDistance / Math.pow(2.0d, (int) f3)) / 256.0d;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.mQuadTree) {
            Iterator<QuadItem<T>> it = getClusteringItems(this.mQuadTree, f3).iterator();
            while (it.hasNext()) {
                QuadItem<T> next = it.next();
                if (!hashSet.contains(next)) {
                    Collection<QuadItem<T>> search = this.mQuadTree.search(createBoundsFromSpan(next.getPoint(), pow));
                    if (search.size() == 1) {
                        hashSet2.add(next);
                        hashSet.add(next);
                        hashMap.put(next, Double.valueOf(0.0d));
                    } else {
                        StaticCluster staticCluster = new StaticCluster(((QuadItem) next).mClusterItem.getPosition());
                        hashSet2.add(staticCluster);
                        for (QuadItem<T> quadItem : search) {
                            Double d3 = (Double) hashMap.get(quadItem);
                            Iterator<QuadItem<T>> it2 = it;
                            double distanceSquared = distanceSquared(quadItem.getPoint(), next.getPoint());
                            if (d3 != null) {
                                if (d3.doubleValue() < distanceSquared) {
                                    it = it2;
                                } else {
                                    ((StaticCluster) hashMap2.get(quadItem)).remove(((QuadItem) quadItem).mClusterItem);
                                }
                            }
                            hashMap.put(quadItem, Double.valueOf(distanceSquared));
                            staticCluster.add(((QuadItem) quadItem).mClusterItem);
                            hashMap2.put(quadItem, staticCluster);
                            it = it2;
                        }
                        hashSet.addAll(search);
                        it = it;
                    }
                }
            }
        }
        return hashSet2;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Collection<T> getItems() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (this.mQuadTree) {
            Iterator<QuadItem<T>> it = this.mItems.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(((QuadItem) it.next()).mClusterItem);
            }
        }
        return linkedHashSet;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public int getMaxDistanceBetweenClusteredItems() {
        return this.mMaxDistance;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItem(T t3) {
        boolean remove;
        QuadItem<T> quadItem = new QuadItem<>(t3);
        synchronized (this.mQuadTree) {
            remove = this.mItems.remove(quadItem);
            if (remove) {
                this.mQuadTree.remove(quadItem);
            }
        }
        return remove;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItems(Collection<T> collection) {
        boolean z3;
        synchronized (this.mQuadTree) {
            Iterator<T> it = collection.iterator();
            z3 = false;
            while (it.hasNext()) {
                QuadItem<T> quadItem = new QuadItem<>(it.next());
                if (this.mItems.remove(quadItem)) {
                    this.mQuadTree.remove(quadItem);
                    z3 = true;
                }
            }
        }
        return z3;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void setMaxDistanceBetweenClusteredItems(int i3) {
        this.mMaxDistance = i3;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean updateItem(T t3) {
        boolean removeItem;
        synchronized (this.mQuadTree) {
            removeItem = removeItem(t3);
            if (removeItem) {
                removeItem = addItem(t3);
            }
        }
        return removeItem;
    }
}
