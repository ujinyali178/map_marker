package com.google.maps.android.projection;

import com.google.android.gms.maps.model.LatLng;

/* loaded from: /root/release/classes.dex */
public class SphericalMercatorProjection {
    final double mWorldWidth;

    public SphericalMercatorProjection(double d3) {
        this.mWorldWidth = d3;
    }

    public LatLng toLatLng(com.google.maps.android.geometry.Point point) {
        double d3 = point.f2375x;
        double d4 = this.mWorldWidth;
        return new LatLng(90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (point.f2376y / d4))) * 2.0d) * 3.141592653589793d)) * 2.0d), ((d3 / d4) - 0.5d) * 360.0d);
    }

    public Point toPoint(LatLng latLng) {
        double d3 = (latLng.longitude / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        double log = ((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d;
        double d4 = this.mWorldWidth;
        return new Point(d3 * d4, log * d4);
    }
}
