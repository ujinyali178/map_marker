package org.mapsforge.map.controller;

import org.mapsforge.map.layer.LayerManager;
import org.mapsforge.map.model.Model;
import org.mapsforge.map.model.common.Observer;

/* loaded from: /root/release/classes2.dex */
public final class LayerManagerController implements Observer {
    private final LayerManager layerManager;

    private LayerManagerController(LayerManager layerManager) {
        this.layerManager = layerManager;
    }

    public static LayerManagerController create(LayerManager layerManager, Model model) {
        LayerManagerController layerManagerController = new LayerManagerController(layerManager);
        model.mapViewDimension.addObserver(layerManagerController);
        model.mapViewPosition.addObserver(layerManagerController);
        return layerManagerController;
    }

    @Override // org.mapsforge.map.model.common.Observer
    public void onChange() {
        this.layerManager.redrawLayers();
    }
}
