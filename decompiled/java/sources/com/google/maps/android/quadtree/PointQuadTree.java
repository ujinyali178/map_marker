package com.google.maps.android.quadtree;

import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.quadtree.PointQuadTree.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public class PointQuadTree<T extends Item> {
    private static final int MAX_DEPTH = 40;
    private static final int MAX_ELEMENTS = 50;
    private final Bounds mBounds;
    private List<PointQuadTree<T>> mChildren;
    private final int mDepth;
    private Set<T> mItems;

    public interface Item {
        Point getPoint();
    }

    public PointQuadTree(double d3, double d4, double d5, double d6) {
        this(new Bounds(d3, d4, d5, d6));
    }

    private PointQuadTree(double d3, double d4, double d5, double d6, int i3) {
        this(new Bounds(d3, d4, d5, d6), i3);
    }

    public PointQuadTree(Bounds bounds) {
        this(bounds, 0);
    }

    private PointQuadTree(Bounds bounds, int i3) {
        this.mChildren = null;
        this.mBounds = bounds;
        this.mDepth = i3;
    }

    private void insert(double d3, double d4, T t3) {
        List<PointQuadTree<T>> list = this.mChildren;
        if (list != null) {
            Bounds bounds = this.mBounds;
            double d5 = bounds.midY;
            double d6 = bounds.midX;
            list.get(d4 < d5 ? d3 < d6 ? 0 : 1 : d3 < d6 ? 2 : 3).insert(d3, d4, t3);
            return;
        }
        if (this.mItems == null) {
            this.mItems = new LinkedHashSet();
        }
        this.mItems.add(t3);
        if (this.mItems.size() <= MAX_ELEMENTS || this.mDepth >= MAX_DEPTH) {
            return;
        }
        split();
    }

    private boolean remove(double d3, double d4, T t3) {
        List<PointQuadTree<T>> list = this.mChildren;
        int i3 = 0;
        if (list == null) {
            Set<T> set = this.mItems;
            if (set == null) {
                return false;
            }
            return set.remove(t3);
        }
        Bounds bounds = this.mBounds;
        if (d4 >= bounds.midY) {
            i3 = d3 < bounds.midX ? 2 : 3;
        } else if (d3 >= bounds.midX) {
            i3 = 1;
        }
        return list.get(i3).remove(d3, d4, t3);
    }

    private void search(Bounds bounds, Collection<T> collection) {
        if (this.mBounds.intersects(bounds)) {
            List<PointQuadTree<T>> list = this.mChildren;
            if (list != null) {
                Iterator<PointQuadTree<T>> it = list.iterator();
                while (it.hasNext()) {
                    it.next().search(bounds, collection);
                }
            } else if (this.mItems != null) {
                if (bounds.contains(this.mBounds)) {
                    collection.addAll(this.mItems);
                    return;
                }
                for (T t3 : this.mItems) {
                    if (bounds.contains(t3.getPoint())) {
                        collection.add(t3);
                    }
                }
            }
        }
    }

    private void split() {
        ArrayList arrayList = new ArrayList(4);
        this.mChildren = arrayList;
        Bounds bounds = this.mBounds;
        arrayList.add(new PointQuadTree(bounds.minX, bounds.midX, bounds.minY, bounds.midY, this.mDepth + 1));
        List<PointQuadTree<T>> list = this.mChildren;
        Bounds bounds2 = this.mBounds;
        list.add(new PointQuadTree<>(bounds2.midX, bounds2.maxX, bounds2.minY, bounds2.midY, this.mDepth + 1));
        List<PointQuadTree<T>> list2 = this.mChildren;
        Bounds bounds3 = this.mBounds;
        list2.add(new PointQuadTree<>(bounds3.minX, bounds3.midX, bounds3.midY, bounds3.maxY, this.mDepth + 1));
        List<PointQuadTree<T>> list3 = this.mChildren;
        Bounds bounds4 = this.mBounds;
        list3.add(new PointQuadTree<>(bounds4.midX, bounds4.maxX, bounds4.midY, bounds4.maxY, this.mDepth + 1));
        Set<T> set = this.mItems;
        this.mItems = null;
        for (T t3 : set) {
            insert(t3.getPoint().f2375x, t3.getPoint().f2376y, t3);
        }
    }

    public void add(T t3) {
        Point point = t3.getPoint();
        if (this.mBounds.contains(point.f2375x, point.f2376y)) {
            insert(point.f2375x, point.f2376y, t3);
        }
    }

    public void clear() {
        this.mChildren = null;
        Set<T> set = this.mItems;
        if (set != null) {
            set.clear();
        }
    }

    public boolean remove(T t3) {
        Point point = t3.getPoint();
        if (this.mBounds.contains(point.f2375x, point.f2376y)) {
            return remove(point.f2375x, point.f2376y, t3);
        }
        return false;
    }

    public Collection<T> search(Bounds bounds) {
        ArrayList arrayList = new ArrayList();
        search(bounds, arrayList);
        return arrayList;
    }
}
