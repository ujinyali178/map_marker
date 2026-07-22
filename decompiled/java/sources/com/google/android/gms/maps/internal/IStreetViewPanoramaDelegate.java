package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
public interface IStreetViewPanoramaDelegate extends IInterface {
    void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j3);

    void enablePanning(boolean z3);

    void enableStreetNames(boolean z3);

    void enableUserNavigation(boolean z3);

    void enableZoom(boolean z3);

    StreetViewPanoramaCamera getPanoramaCamera();

    StreetViewPanoramaLocation getStreetViewPanoramaLocation();

    boolean isPanningGesturesEnabled();

    boolean isStreetNamesEnabled();

    boolean isUserNavigationEnabled();

    boolean isZoomGesturesEnabled();

    IObjectWrapper orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation);

    StreetViewPanoramaOrientation pointToOrientation(IObjectWrapper iObjectWrapper);

    void setOnStreetViewPanoramaCameraChangeListener(@Nullable zzbl zzblVar);

    void setOnStreetViewPanoramaChangeListener(@Nullable zzbn zzbnVar);

    void setOnStreetViewPanoramaClickListener(@Nullable zzbp zzbpVar);

    void setOnStreetViewPanoramaLongClickListener(@Nullable zzbr zzbrVar);

    void setPosition(LatLng latLng);

    void setPositionWithID(String str);

    void setPositionWithRadius(LatLng latLng, int i3);

    void setPositionWithRadiusAndSource(LatLng latLng, int i3, @Nullable StreetViewSource streetViewSource);

    void setPositionWithSource(LatLng latLng, @Nullable StreetViewSource streetViewSource);
}
