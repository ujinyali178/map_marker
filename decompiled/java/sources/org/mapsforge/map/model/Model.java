package org.mapsforge.map.model;

import org.mapsforge.map.model.common.Persistable;
import org.mapsforge.map.model.common.PreferencesFacade;

/* loaded from: /root/release/classes2.dex */
public class Model implements Persistable {
    public final DisplayModel displayModel;
    public final FrameBufferModel frameBufferModel;
    public final MapViewDimension mapViewDimension;
    public final IMapViewPosition mapViewPosition;

    public Model() {
        DisplayModel displayModel = new DisplayModel();
        this.displayModel = displayModel;
        this.frameBufferModel = new FrameBufferModel();
        this.mapViewDimension = new MapViewDimension();
        this.mapViewPosition = new MapViewPosition(displayModel);
    }

    @Override // org.mapsforge.map.model.common.Persistable
    public void init(PreferencesFacade preferencesFacade) {
        this.mapViewPosition.init(preferencesFacade);
    }

    @Override // org.mapsforge.map.model.common.Persistable
    public void save(PreferencesFacade preferencesFacade) {
        this.mapViewPosition.save(preferencesFacade);
    }
}
