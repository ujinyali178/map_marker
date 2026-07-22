package org.mapsforge.map.model;

import org.mapsforge.core.model.Dimension;
import org.mapsforge.map.model.common.Observable;

/* loaded from: /root/release/classes2.dex */
public class MapViewDimension extends Observable {
    private Dimension dimension;

    public synchronized Dimension getDimension() {
        return this.dimension;
    }

    public void setDimension(Dimension dimension) {
        synchronized (this) {
            this.dimension = dimension;
        }
        notifyObservers();
    }
}
