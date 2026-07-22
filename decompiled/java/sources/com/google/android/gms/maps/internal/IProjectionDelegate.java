package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* loaded from: /root/release/classes.dex */
public interface IProjectionDelegate extends IInterface {
    LatLng fromScreenLocation(IObjectWrapper iObjectWrapper);

    VisibleRegion getVisibleRegion();

    IObjectWrapper toScreenLocation(LatLng latLng);

    IObjectWrapper toScreenLocationWithAltitude(LatLng latLng, float f3);
}
