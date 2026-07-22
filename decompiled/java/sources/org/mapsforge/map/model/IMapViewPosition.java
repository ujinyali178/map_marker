package org.mapsforge.map.model;

import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.MapPosition;
import org.mapsforge.map.model.common.Observer;
import org.mapsforge.map.model.common.PreferencesFacade;

/* loaded from: /root/release/classes2.dex */
public interface IMapViewPosition {
    void addObserver(Observer observer);

    void animateTo(LatLong latLong);

    boolean animationInProgress();

    void destroy();

    LatLong getCenter();

    BoundingBox getMapLimit();

    MapPosition getMapPosition();

    LatLong getPivot();

    double getScaleFactor();

    byte getZoomLevel();

    byte getZoomLevelMax();

    byte getZoomLevelMin();

    void init(PreferencesFacade preferencesFacade);

    void moveCenter(double d3, double d4);

    void moveCenter(double d3, double d4, boolean z3);

    void moveCenterAndZoom(double d3, double d4, byte b4);

    void removeObserver(Observer observer);

    void save(PreferencesFacade preferencesFacade);

    void setCenter(LatLong latLong);

    void setMapLimit(BoundingBox boundingBox);

    void setMapPosition(MapPosition mapPosition);

    void setMapPosition(MapPosition mapPosition, boolean z3);

    void setPivot(LatLong latLong);

    void setScaleFactorAdjustment(double d3);

    void setZoomLevel(byte b4);

    void setZoomLevel(byte b4, boolean z3);

    void setZoomLevelMax(byte b4);

    void setZoomLevelMin(byte b4);

    void zoom(byte b4);

    void zoomIn();

    void zoomOut();
}
