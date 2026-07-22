package org.mapsforge.map.rendertheme;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.mapsforge.core.mapelements.MapElementContainer;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.layer.renderer.CanvasRasterer;
import org.mapsforge.map.layer.renderer.RendererJob;
import org.mapsforge.map.layer.renderer.ShapePaintContainer;
import org.mapsforge.map.rendertheme.rule.RenderTheme;

/* loaded from: /root/release/classes2.dex */
public class RenderContext {
    private static final byte LAYERS = 11;
    private static final double STROKE_INCREASE = 1.5d;
    private static final byte STROKE_MIN_ZOOM_LEVEL = 12;
    public final CanvasRasterer canvasRasterer;
    private List<List<ShapePaintContainer>> drawingLayers;
    public final List<MapElementContainer> labels = new LinkedList();
    public final RenderTheme renderTheme;
    public final RendererJob rendererJob;
    public final List<List<List<ShapePaintContainer>>> ways;

    public RenderContext(RendererJob rendererJob, CanvasRasterer canvasRasterer) {
        this.rendererJob = rendererJob;
        this.canvasRasterer = canvasRasterer;
        RenderTheme renderTheme = rendererJob.renderThemeFuture.get();
        this.renderTheme = renderTheme;
        renderTheme.scaleTextSize(rendererJob.textScale, rendererJob.tile.zoomLevel);
        this.ways = createWayLists();
        setScaleStrokeWidth(rendererJob.tile.zoomLevel);
    }

    private List<List<List<ShapePaintContainer>>> createWayLists() {
        ArrayList arrayList = new ArrayList(11);
        int levels = this.renderTheme.getLevels();
        for (byte b4 = 10; b4 >= 0; b4 = (byte) (b4 - 1)) {
            ArrayList arrayList2 = new ArrayList(levels);
            for (int i3 = levels - 1; i3 >= 0; i3--) {
                arrayList2.add(new ArrayList(0));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    private void setScaleStrokeWidth(byte b4) {
        this.renderTheme.scaleStrokeWidth((float) Math.pow(STROKE_INCREASE, Math.max(b4 - 12, 0)), this.rendererJob.tile.zoomLevel);
    }

    public void addToCurrentDrawingLayer(int i3, ShapePaintContainer shapePaintContainer) {
        this.drawingLayers.get(i3).add(shapePaintContainer);
    }

    public void destroy() {
        this.canvasRasterer.destroy();
    }

    public RendererJob otherTile(Tile tile) {
        RendererJob rendererJob = this.rendererJob;
        return new RendererJob(tile, rendererJob.mapDataStore, rendererJob.renderThemeFuture, rendererJob.displayModel, rendererJob.textScale, rendererJob.hasAlpha, rendererJob.labelsOnly);
    }

    public void setDrawingLayers(byte b4) {
        if (b4 < 0) {
            b4 = 0;
        } else if (b4 >= 11) {
            b4 = 10;
        }
        this.drawingLayers = this.ways.get(b4);
    }
}
