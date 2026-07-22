package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.projection.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.quadtree.PointQuadTree;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: /root/release/classes.dex */
public class NonHierarchicalViewBasedAlgorithm<T extends ClusterItem> extends NonHierarchicalDistanceBasedAlgorithm<T> implements ScreenBasedAlgorithm<T> {
    private static final SphericalMercatorProjection PROJECTION = new SphericalMercatorProjection(1.0d);
    private LatLng mMapCenter;
    private int mViewHeight;
    private int mViewWidth;

    public NonHierarchicalViewBasedAlgorithm(int i3, int i4) {
        this.mViewWidth = i3;
        this.mViewHeight = i4;
    }

    private Bounds getVisibleBounds(float f3) {
        LatLng latLng = this.mMapCenter;
        if (latLng == null) {
            return new Bounds(0.0d, 0.0d, 0.0d, 0.0d);
        }
        Point point = PROJECTION.toPoint(latLng);
        double d3 = f3;
        double pow = ((this.mViewWidth / Math.pow(2.0d, d3)) / 256.0d) / 2.0d;
        double pow2 = ((this.mViewHeight / Math.pow(2.0d, d3)) / 256.0d) / 2.0d;
        double d4 = point.f2375x;
        double d5 = point.f2376y;
        return new Bounds(d4 - pow, d4 + pow, d5 - pow2, d5 + pow2);
    }

    @Override // com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm
    protected Collection<NonHierarchicalDistanceBasedAlgorithm.QuadItem<T>> getClusteringItems(PointQuadTree<NonHierarchicalDistanceBasedAlgorithm.QuadItem<T>> pointQuadTree, float f3) {
        Bounds visibleBounds = getVisibleBounds(f3);
        ArrayList arrayList = new ArrayList();
        double d3 = visibleBounds.minX;
        if (d3 < 0.0d) {
            arrayList.addAll(pointQuadTree.search(new Bounds(d3 + 1.0d, 1.0d, visibleBounds.minY, visibleBounds.maxY)));
            visibleBounds = new Bounds(0.0d, visibleBounds.maxX, visibleBounds.minY, visibleBounds.maxY);
        }
        double d4 = visibleBounds.maxX;
        if (d4 > 1.0d) {
            arrayList.addAll(pointQuadTree.search(new Bounds(0.0d, d4 - 1.0d, visibleBounds.minY, visibleBounds.maxY)));
            visibleBounds = new Bounds(visibleBounds.minX, 1.0d, visibleBounds.minY, visibleBounds.maxY);
        }
        arrayList.addAll(pointQuadTree.search(visibleBounds));
        return arrayList;
    }

    @Override // com.google.maps.android.clustering.algo.ScreenBasedAlgorithm
    public void onCameraChange(CameraPosition cameraPosition) {
        this.mMapCenter = cameraPosition.target;
    }

    @Override // com.google.maps.android.clustering.algo.ScreenBasedAlgorithm
    public boolean shouldReclusterOnMapMovement() {
        return true;
    }

    public void updateViewSize(int i3, int i4) {
        this.mViewWidth = i3;
        this.mViewHeight = i4;
    }
}
