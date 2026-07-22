package org.mapsforge.map.util;

import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.MapPosition;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.map.view.MapView;

/* loaded from: /root/release/classes2.dex */
public class MapViewProjection {
    private static final String INVALID_MAP_VIEW_DIMENSIONS = "invalid MapView dimensions";
    private final MapView mapView;

    public MapViewProjection(MapView mapView) {
        this.mapView = mapView;
    }

    public LatLong fromPixels(double d3, double d4) {
        MapPosition mapPosition;
        if (this.mapView.getWidth() <= 0 || this.mapView.getHeight() <= 0 || (mapPosition = this.mapView.getModel().frameBufferModel.getMapPosition()) == null) {
            return null;
        }
        LatLong latLong = mapPosition.latLong;
        long mapSize = MercatorProjection.getMapSize(mapPosition.zoomLevel, this.mapView.getModel().displayModel.getTileSize());
        try {
            return new LatLong(MercatorProjection.pixelYToLatitude((MercatorProjection.latitudeToPixelY(latLong.latitude, mapSize) - (this.mapView.getHeight() >> 1)) + d4, mapSize), MercatorProjection.pixelXToLongitude((MercatorProjection.longitudeToPixelX(latLong.longitude, mapSize) - (this.mapView.getWidth() >> 1)) + d3, mapSize));
        } catch (Exception unused) {
            return null;
        }
    }

    public double getLatitudeSpan() {
        if (this.mapView.getWidth() <= 0 || this.mapView.getHeight() <= 0) {
            throw new IllegalStateException(INVALID_MAP_VIEW_DIMENSIONS);
        }
        return Math.abs(fromPixels(0.0d, 0.0d).latitude - fromPixels(0.0d, this.mapView.getHeight()).latitude);
    }

    public double getLongitudeSpan() {
        if (this.mapView.getWidth() <= 0 || this.mapView.getHeight() <= 0) {
            throw new IllegalStateException(INVALID_MAP_VIEW_DIMENSIONS);
        }
        return Math.abs(fromPixels(0.0d, 0.0d).longitude - fromPixels(this.mapView.getWidth(), 0.0d).longitude);
    }

    public Point toPixels(LatLong latLong) {
        MapPosition mapPosition;
        if (latLong == null || this.mapView.getWidth() <= 0 || this.mapView.getHeight() <= 0 || (mapPosition = this.mapView.getModel().mapViewPosition.getMapPosition()) == null) {
            return null;
        }
        LatLong latLong2 = mapPosition.latLong;
        long mapSize = MercatorProjection.getMapSize(mapPosition.zoomLevel, this.mapView.getModel().displayModel.getTileSize());
        return new Point((int) (MercatorProjection.longitudeToPixelX(latLong.longitude, mapSize) - (MercatorProjection.longitudeToPixelX(latLong2.longitude, mapSize) - (this.mapView.getWidth() >> 1))), (int) (MercatorProjection.latitudeToPixelY(latLong.latitude, mapSize) - (MercatorProjection.latitudeToPixelY(latLong2.latitude, mapSize) - (this.mapView.getHeight() >> 1))));
    }
}
