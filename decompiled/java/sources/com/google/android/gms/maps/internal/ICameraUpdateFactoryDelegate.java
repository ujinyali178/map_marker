package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: /root/release/classes.dex */
public interface ICameraUpdateFactoryDelegate extends IInterface {
    IObjectWrapper newCameraPosition(CameraPosition cameraPosition);

    IObjectWrapper newLatLng(LatLng latLng);

    IObjectWrapper newLatLngBounds(LatLngBounds latLngBounds, int i3);

    IObjectWrapper newLatLngBoundsWithSize(LatLngBounds latLngBounds, int i3, int i4, int i5);

    IObjectWrapper newLatLngZoom(LatLng latLng, float f3);

    IObjectWrapper scrollBy(float f3, float f4);

    IObjectWrapper zoomBy(float f3);

    IObjectWrapper zoomByWithFocus(float f3, int i3, int i4);

    IObjectWrapper zoomIn();

    IObjectWrapper zoomOut();

    IObjectWrapper zoomTo(float f3);
}
