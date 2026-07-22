package org.mapsforge.map.layer.renderer;

import com.google.common.base.Ascii;
import java.util.Collections;
import java.util.Iterator;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Position;
import org.mapsforge.core.mapelements.SymbolContainer;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Tag;
import org.mapsforge.core.model.Tile;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.datastore.MapReadResult;
import org.mapsforge.map.datastore.PointOfInterest;
import org.mapsforge.map.datastore.Way;
import org.mapsforge.map.layer.hills.HillsRenderConfig;
import org.mapsforge.map.rendertheme.RenderCallback;
import org.mapsforge.map.rendertheme.RenderContext;

/* loaded from: /root/release/classes2.dex */
public class StandardRenderer implements RenderCallback {
    private static final Byte DEFAULT_START_ZOOM_LEVEL = Byte.valueOf(Ascii.FF);
    private static final Tag TAG_NATURAL_WATER = new Tag("natural", "water");
    private static final byte ZOOM_MAX = 22;
    public final GraphicFactory graphicFactory;
    public final HillsRenderConfig hillsRenderConfig;
    public final MapDataStore mapDataStore;
    private final boolean renderLabels;

    public StandardRenderer(MapDataStore mapDataStore, GraphicFactory graphicFactory, boolean z3) {
        this(mapDataStore, graphicFactory, z3, null);
    }

    public StandardRenderer(MapDataStore mapDataStore, GraphicFactory graphicFactory, boolean z3, HillsRenderConfig hillsRenderConfig) {
        this.mapDataStore = mapDataStore;
        this.graphicFactory = graphicFactory;
        this.renderLabels = z3;
        this.hillsRenderConfig = hillsRenderConfig;
    }

    private static Point[] getTilePixelCoordinates(int i3) {
        Point[] pointArr = new Point[5];
        pointArr[0] = new Point(0.0d, 0.0d);
        double d3 = i3;
        pointArr[1] = new Point(d3, 0.0d);
        pointArr[2] = new Point(d3, d3);
        pointArr[3] = new Point(0.0d, d3);
        pointArr[4] = pointArr[0];
        return pointArr;
    }

    public LatLong getStartPosition() {
        MapDataStore mapDataStore = this.mapDataStore;
        if (mapDataStore != null) {
            return mapDataStore.startPosition();
        }
        return null;
    }

    public Byte getStartZoomLevel() {
        MapDataStore mapDataStore = this.mapDataStore;
        return (mapDataStore == null || mapDataStore.startZoomLevel() == null) ? DEFAULT_START_ZOOM_LEVEL : this.mapDataStore.startZoomLevel();
    }

    public byte getZoomLevelMax() {
        return (byte) 22;
    }

    protected void processReadMapData(RenderContext renderContext, MapReadResult mapReadResult) {
        if (mapReadResult == null) {
            return;
        }
        Iterator<PointOfInterest> it = mapReadResult.pointOfInterests.iterator();
        while (it.hasNext()) {
            renderPointOfInterest(renderContext, it.next());
        }
        for (Way way : mapReadResult.ways) {
            Tile tile = renderContext.rendererJob.tile;
            renderWay(renderContext, new PolylineContainer(way, tile, tile));
        }
        if (mapReadResult.isWater) {
            renderWaterBackground(renderContext);
        }
    }

    @Override // org.mapsforge.map.rendertheme.RenderCallback
    public void renderArea(RenderContext renderContext, Paint paint, Paint paint2, int i3, PolylineContainer polylineContainer) {
        renderContext.addToCurrentDrawingLayer(i3, new ShapePaintContainer(polylineContainer, paint2));
        renderContext.addToCurrentDrawingLayer(i3, new ShapePaintContainer(polylineContainer, paint));
    }

    @Override // org.mapsforge.map.rendertheme.RenderCallback
    public void renderAreaCaption(RenderContext renderContext, Display display, int i3, String str, float f3, float f4, Paint paint, Paint paint2, Position position, int i4, PolylineContainer polylineContainer) {
        if (this.renderLabels) {
            renderContext.labels.add(this.graphicFactory.createPointTextContainer(polylineContainer.getCenterAbsolute().offset(f3, f4), display, i3, str, paint, paint2, null, position, i4));
        }
    }

    @Override // org.mapsforge.map.rendertheme.RenderCallback
    public void renderAreaSymbol(RenderContext renderContext, Display display, int i3, Bitmap bitmap, PolylineContainer polylineContainer) {
        if (this.renderLabels) {
            renderContext.labels.add(new SymbolContainer(polylineContainer.getCenterAbsolute(), display, i3, bitmap));
        }
    }

    boolean renderBitmap(RenderContext renderContext) {
        return !renderContext.renderTheme.hasMapBackgroundOutside() || this.mapDataStore.supportsTile(renderContext.rendererJob.tile);
    }

    protected void renderPointOfInterest(RenderContext renderContext, PointOfInterest pointOfInterest) {
        renderContext.setDrawingLayers(pointOfInterest.layer);
        renderContext.renderTheme.matchNode(this, renderContext, pointOfInterest);
    }

    @Override // org.mapsforge.map.rendertheme.RenderCallback
    public void renderPointOfInterestCaption(RenderContext renderContext, Display display, int i3, String str, float f3, float f4, Paint paint, Paint paint2, Position position, int i4, PointOfInterest pointOfInterest) {
        if (this.renderLabels) {
            renderContext.labels.add(this.graphicFactory.createPointTextContainer(MercatorProjection.getPixelAbsolute(pointOfInterest.position, renderContext.rendererJob.tile.mapSize).offset(f3, f4), display, i3, str, paint, paint2, null, position, i4));
        }
    }

    @Override // org.mapsforge.map.rendertheme.RenderCallback
    public void renderPointOfInterestCircle(RenderContext renderContext, float f3, Paint paint, Paint paint2, int i3, PointOfInterest pointOfInterest) {
        Point pixelRelativeToTile = MercatorProjection.getPixelRelativeToTile(pointOfInterest.position, renderContext.rendererJob.tile);
        renderContext.addToCurrentDrawingLayer(i3, new ShapePaintContainer(new CircleContainer(pixelRelativeToTile, f3), paint2));
        renderContext.addToCurrentDrawingLayer(i3, new ShapePaintContainer(new CircleContainer(pixelRelativeToTile, f3), paint));
    }

    @Override // org.mapsforge.map.rendertheme.RenderCallback
    public void renderPointOfInterestSymbol(RenderContext renderContext, Display display, int i3, Bitmap bitmap, PointOfInterest pointOfInterest) {
        if (this.renderLabels) {
            renderContext.labels.add(new SymbolContainer(MercatorProjection.getPixelAbsolute(pointOfInterest.position, renderContext.rendererJob.tile.mapSize), display, i3, bitmap));
        }
    }

    protected void renderWaterBackground(RenderContext renderContext) {
        renderContext.setDrawingLayers((byte) 0);
        Point[] tilePixelCoordinates = getTilePixelCoordinates(renderContext.rendererJob.tile.tileSize);
        Point origin = renderContext.rendererJob.tile.getOrigin();
        for (int i3 = 0; i3 < tilePixelCoordinates.length; i3++) {
            tilePixelCoordinates[i3] = tilePixelCoordinates[i3].offset(origin.f4076x, origin.f4077y);
        }
        Tile tile = renderContext.rendererJob.tile;
        renderContext.renderTheme.matchClosedWay(this, renderContext, new PolylineContainer(tilePixelCoordinates, tile, tile, Collections.singletonList(TAG_NATURAL_WATER)));
    }

    @Override // org.mapsforge.map.rendertheme.RenderCallback
    public void renderWay(RenderContext renderContext, Paint paint, float f3, int i3, PolylineContainer polylineContainer) {
        renderContext.addToCurrentDrawingLayer(i3, new ShapePaintContainer(polylineContainer, paint, f3));
    }

    protected void renderWay(RenderContext renderContext, PolylineContainer polylineContainer) {
        renderContext.setDrawingLayers(polylineContainer.getLayer());
        if (polylineContainer.isClosedWay()) {
            renderContext.renderTheme.matchClosedWay(this, renderContext, polylineContainer);
        } else {
            renderContext.renderTheme.matchLinearWay(this, renderContext, polylineContainer);
        }
    }

    @Override // org.mapsforge.map.rendertheme.RenderCallback
    public void renderWaySymbol(RenderContext renderContext, Display display, int i3, Bitmap bitmap, float f3, boolean z3, boolean z4, float f4, float f5, boolean z5, PolylineContainer polylineContainer) {
        if (this.renderLabels) {
            WayDecorator.renderSymbol(bitmap, display, i3, f3, z3, z4, f4, f5, z5, polylineContainer.getCoordinatesAbsolute(), renderContext.labels);
        }
    }

    @Override // org.mapsforge.map.rendertheme.RenderCallback
    public void renderWayText(RenderContext renderContext, Display display, int i3, String str, float f3, Paint paint, Paint paint2, boolean z3, float f4, float f5, boolean z4, PolylineContainer polylineContainer) {
        if (this.renderLabels) {
            WayDecorator.renderText(this.graphicFactory, polylineContainer.getUpperLeft(), polylineContainer.getLowerRight(), str, display, i3, f3, paint, paint2, z3, f4, f5, z4, polylineContainer.getCoordinatesAbsolute(), renderContext.labels);
        }
    }
}
