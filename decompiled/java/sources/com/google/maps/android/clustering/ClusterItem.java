package com.google.maps.android.clustering;

import com.google.android.gms.maps.model.LatLng;

/* loaded from: /root/release/classes.dex */
public interface ClusterItem {
    LatLng getPosition();

    String getSnippet();

    String getTitle();

    Float getZIndex();
}
