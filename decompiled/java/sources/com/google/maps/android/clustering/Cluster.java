package com.google.maps.android.clustering;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;
import java.util.Collection;

/* loaded from: /root/release/classes.dex */
public interface Cluster<T extends ClusterItem> {
    Collection<T> getItems();

    LatLng getPosition();

    int getSize();
}
