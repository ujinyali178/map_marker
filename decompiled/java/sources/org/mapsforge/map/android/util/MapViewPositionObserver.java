package org.mapsforge.map.android.util;

import org.mapsforge.map.model.IMapViewPosition;
import org.mapsforge.map.model.common.Observer;

/* loaded from: /root/release/classes2.dex */
public class MapViewPositionObserver implements Observer {
    private final IMapViewPosition observable;
    private final IMapViewPosition observer;

    public MapViewPositionObserver(IMapViewPosition iMapViewPosition, IMapViewPosition iMapViewPosition2) {
        this.observable = iMapViewPosition;
        this.observer = iMapViewPosition2;
        iMapViewPosition.addObserver(this);
    }

    @Override // org.mapsforge.map.model.common.Observer
    public void onChange() {
        setCenter();
        setZoom();
    }

    public void removeObserver() {
        this.observable.removeObserver(this);
    }

    protected void setCenter() {
        if (this.observable.getCenter().equals(this.observer.getCenter())) {
            return;
        }
        this.observer.setCenter(this.observable.getCenter());
    }

    protected void setZoom() {
        if (this.observable.getZoomLevel() != this.observer.getZoomLevel()) {
            this.observer.setZoomLevel(this.observable.getZoomLevel());
        }
    }
}
