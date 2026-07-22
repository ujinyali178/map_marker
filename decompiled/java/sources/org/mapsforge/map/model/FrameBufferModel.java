package org.mapsforge.map.model;

import org.mapsforge.core.model.Dimension;
import org.mapsforge.core.model.MapPosition;
import org.mapsforge.map.model.common.Observable;

/* loaded from: /root/release/classes2.dex */
public class FrameBufferModel extends Observable {
    private Dimension dimension;
    private MapPosition mapPosition;
    private double overdrawFactor = 1.2d;

    public synchronized Dimension getDimension() {
        return this.dimension;
    }

    public synchronized MapPosition getMapPosition() {
        return this.mapPosition;
    }

    public synchronized double getOverdrawFactor() {
        return this.overdrawFactor;
    }

    public void setDimension(Dimension dimension) {
        synchronized (this) {
            this.dimension = dimension;
        }
        notifyObservers();
    }

    public void setMapPosition(MapPosition mapPosition) {
        synchronized (this) {
            this.mapPosition = mapPosition;
        }
        notifyObservers();
    }

    public void setOverdrawFactor(double d3) {
        if (d3 > 0.0d) {
            synchronized (this) {
                this.overdrawFactor = d3;
            }
            notifyObservers();
        } else {
            throw new IllegalArgumentException("overdrawFactor must be > 0: " + d3);
        }
    }
}
