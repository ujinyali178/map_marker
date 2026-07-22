package org.mapsforge.map.controller;

import org.mapsforge.core.model.Dimension;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.MapPosition;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.core.util.Parameters;
import org.mapsforge.map.model.Model;
import org.mapsforge.map.model.common.Observer;
import org.mapsforge.map.view.FrameBuffer;

/* loaded from: /root/release/classes2.dex */
public final class FrameBufferController implements Observer {
    private final FrameBuffer frameBuffer;
    private Dimension lastMapViewDimension;
    private double lastOverdrawFactor;
    private final Model model;

    private FrameBufferController(FrameBuffer frameBuffer, Model model) {
        this.frameBuffer = frameBuffer;
        this.model = model;
    }

    private void adjustFrameBufferMatrix(MapPosition mapPosition, Dimension dimension, double d3, LatLong latLong) {
        double d4;
        MapPosition mapPosition2 = this.model.mapViewPosition.getMapPosition();
        long mapSize = MercatorProjection.getMapSize(mapPosition.zoomLevel, this.model.displayModel.getTileSize());
        Point pixel = MercatorProjection.getPixel(mapPosition.latLong, mapSize);
        Point pixel2 = MercatorProjection.getPixel(mapPosition2.latLong, mapSize);
        double d5 = pixel.f4076x - pixel2.f4076x;
        double d6 = pixel.f4077y - pixel2.f4077y;
        double d7 = 0.0d;
        if (latLong != null) {
            Point pixel3 = MercatorProjection.getPixel(latLong, mapSize);
            d7 = pixel3.f4076x - pixel.f4076x;
            d4 = pixel3.f4077y - pixel.f4077y;
        } else {
            d4 = 0.0d;
        }
        this.frameBuffer.adjustMatrix((float) d5, (float) d6, (float) (d3 / Math.pow(2.0d, mapPosition.zoomLevel)), dimension, (float) d7, (float) d4);
    }

    public static Dimension calculateFrameBufferDimension(Dimension dimension, double d3) {
        int i3 = (int) (dimension.width * d3);
        int i4 = (int) (dimension.height * d3);
        if (Parameters.SQUARE_FRAME_BUFFER) {
            i3 = Math.max(i3, i4);
            i4 = i3;
        }
        return new Dimension(i3, i4);
    }

    public static FrameBufferController create(FrameBuffer frameBuffer, Model model) {
        FrameBufferController frameBufferController = new FrameBufferController(frameBuffer, model);
        model.frameBufferModel.addObserver(frameBufferController);
        model.mapViewDimension.addObserver(frameBufferController);
        model.mapViewPosition.addObserver(frameBufferController);
        model.displayModel.addObserver(frameBufferController);
        return frameBufferController;
    }

    private boolean dimensionChangeNeeded(Dimension dimension, double d3) {
        return (Double.compare(d3, this.lastOverdrawFactor) == 0 && dimension.equals(this.lastMapViewDimension)) ? false : true;
    }

    public void destroy() {
        this.model.displayModel.removeObserver(this);
        this.model.mapViewPosition.removeObserver(this);
        this.model.mapViewDimension.removeObserver(this);
        this.model.frameBufferModel.removeObserver(this);
    }

    @Override // org.mapsforge.map.model.common.Observer
    public void onChange() {
        Dimension dimension = this.model.mapViewDimension.getDimension();
        if (dimension == null) {
            return;
        }
        double overdrawFactor = this.model.frameBufferModel.getOverdrawFactor();
        if (dimensionChangeNeeded(dimension, overdrawFactor)) {
            Dimension calculateFrameBufferDimension = calculateFrameBufferDimension(dimension, overdrawFactor);
            if (!Parameters.SQUARE_FRAME_BUFFER || this.frameBuffer.getDimension() == null || calculateFrameBufferDimension.width > this.frameBuffer.getDimension().width || calculateFrameBufferDimension.height > this.frameBuffer.getDimension().height) {
                this.frameBuffer.setDimension(calculateFrameBufferDimension);
            }
            this.lastMapViewDimension = dimension;
            this.lastOverdrawFactor = overdrawFactor;
        }
        synchronized (this.model.mapViewPosition) {
            synchronized (this.frameBuffer) {
                MapPosition mapPosition = this.model.frameBufferModel.getMapPosition();
                if (mapPosition != null) {
                    adjustFrameBufferMatrix(mapPosition, dimension, this.model.mapViewPosition.getScaleFactor(), this.model.mapViewPosition.getPivot());
                }
            }
        }
    }
}
