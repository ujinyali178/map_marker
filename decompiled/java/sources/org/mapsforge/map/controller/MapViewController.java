package org.mapsforge.map.controller;

import org.mapsforge.map.model.Model;
import org.mapsforge.map.model.common.Observer;
import org.mapsforge.map.view.MapView;

/* loaded from: /root/release/classes2.dex */
public final class MapViewController implements Observer {
    private final MapView mapView;

    private MapViewController(MapView mapView) {
        this.mapView = mapView;
    }

    public static MapViewController create(MapView mapView, Model model) {
        MapViewController mapViewController = new MapViewController(mapView);
        model.mapViewPosition.addObserver(mapViewController);
        return mapViewController;
    }

    @Override // org.mapsforge.map.model.common.Observer
    public void onChange() {
        this.mapView.repaint();
    }
}
