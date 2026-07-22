package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import java.util.Collection;
import java.util.LinkedHashSet;

/* loaded from: /root/release/classes.dex */
public class StaticCluster<T extends ClusterItem> implements Cluster<T> {
    private final LatLng mCenter;
    private final Collection<T> mItems = new LinkedHashSet();

    public StaticCluster(LatLng latLng) {
        this.mCenter = latLng;
    }

    public boolean add(T t3) {
        return this.mItems.add(t3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StaticCluster)) {
            return false;
        }
        StaticCluster staticCluster = (StaticCluster) obj;
        return staticCluster.mCenter.equals(this.mCenter) && staticCluster.mItems.equals(this.mItems);
    }

    @Override // com.google.maps.android.clustering.Cluster
    public Collection<T> getItems() {
        return this.mItems;
    }

    @Override // com.google.maps.android.clustering.Cluster
    public LatLng getPosition() {
        return this.mCenter;
    }

    @Override // com.google.maps.android.clustering.Cluster
    public int getSize() {
        return this.mItems.size();
    }

    public int hashCode() {
        return this.mCenter.hashCode() + this.mItems.hashCode();
    }

    public boolean remove(T t3) {
        return this.mItems.remove(t3);
    }

    public String toString() {
        return "StaticCluster{mCenter=" + this.mCenter + ", mItems.size=" + this.mItems.size() + '}';
    }
}
