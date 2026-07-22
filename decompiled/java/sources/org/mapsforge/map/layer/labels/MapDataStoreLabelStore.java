package org.mapsforge.map.layer.labels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.mapelements.MapElementContainer;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.datastore.MapReadResult;
import org.mapsforge.map.datastore.PointOfInterest;
import org.mapsforge.map.datastore.Way;
import org.mapsforge.map.layer.renderer.CanvasRasterer;
import org.mapsforge.map.layer.renderer.PolylineContainer;
import org.mapsforge.map.layer.renderer.RendererJob;
import org.mapsforge.map.layer.renderer.StandardRenderer;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.rendertheme.RenderContext;
import org.mapsforge.map.rendertheme.rule.RenderThemeFuture;

/* loaded from: /root/release/classes2.dex */
public class MapDataStoreLabelStore implements LabelStore {
    final DisplayModel displayModel;
    final RenderThemeFuture renderThemeFuture;
    final StandardRenderer standardRenderer;
    final float textScale;

    public MapDataStoreLabelStore(MapDataStore mapDataStore, RenderThemeFuture renderThemeFuture, float f3, DisplayModel displayModel, GraphicFactory graphicFactory) {
        this.textScale = f3;
        this.renderThemeFuture = renderThemeFuture;
        this.standardRenderer = new StandardRenderer(mapDataStore, graphicFactory, true);
        this.displayModel = displayModel;
    }

    @Override // org.mapsforge.map.layer.labels.LabelStore
    public void clear() {
    }

    @Override // org.mapsforge.map.layer.labels.LabelStore
    public int getVersion() {
        return 0;
    }

    @Override // org.mapsforge.map.layer.labels.LabelStore
    public synchronized List<MapElementContainer> getVisibleItems(Tile tile, Tile tile2) {
        try {
            RenderContext renderContext = new RenderContext(new RendererJob(tile, this.standardRenderer.mapDataStore, this.renderThemeFuture, this.displayModel, this.textScale, true, true), new CanvasRasterer(this.standardRenderer.graphicFactory));
            MapReadResult readLabels = this.standardRenderer.mapDataStore.readLabels(tile, tile2);
            if (readLabels == null) {
                return new ArrayList();
            }
            for (PointOfInterest pointOfInterest : readLabels.pointOfInterests) {
                renderContext.setDrawingLayers(pointOfInterest.layer);
                renderContext.rendererJob.renderThemeFuture.get().matchNode(this.standardRenderer, renderContext, pointOfInterest);
            }
            Iterator<Way> it = readLabels.ways.iterator();
            while (it.hasNext()) {
                PolylineContainer polylineContainer = new PolylineContainer(it.next(), tile, tile2);
                renderContext.setDrawingLayers(polylineContainer.getLayer());
                if (polylineContainer.isClosedWay()) {
                    renderContext.renderTheme.matchClosedWay(this.standardRenderer, renderContext, polylineContainer);
                } else {
                    renderContext.renderTheme.matchLinearWay(this.standardRenderer, renderContext, polylineContainer);
                }
            }
            return renderContext.labels;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }
}
