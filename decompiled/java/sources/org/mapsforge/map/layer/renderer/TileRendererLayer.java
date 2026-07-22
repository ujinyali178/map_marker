package org.mapsforge.map.layer.renderer;

import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.TileBitmap;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.layer.TileLayer;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.hills.HillsRenderConfig;
import org.mapsforge.map.layer.labels.LabelStore;
import org.mapsforge.map.layer.labels.TileBasedLabelStore;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.model.IMapViewPosition;
import org.mapsforge.map.model.common.Observer;
import org.mapsforge.map.rendertheme.XmlRenderTheme;
import org.mapsforge.map.rendertheme.rule.RenderThemeFuture;

/* loaded from: /root/release/classes2.dex */
public class TileRendererLayer extends TileLayer<RendererJob> implements Observer {
    private final DatabaseRenderer databaseRenderer;
    private final GraphicFactory graphicFactory;
    private final MapDataStore mapDataStore;
    private MapWorkerPool mapWorkerPool;
    private RenderThemeFuture renderThemeFuture;
    private float textScale;
    private final TileBasedLabelStore tileBasedLabelStore;
    private XmlRenderTheme xmlRenderTheme;

    public TileRendererLayer(TileCache tileCache, MapDataStore mapDataStore, IMapViewPosition iMapViewPosition, GraphicFactory graphicFactory) {
        this(tileCache, mapDataStore, iMapViewPosition, false, true, false, graphicFactory);
    }

    public TileRendererLayer(TileCache tileCache, MapDataStore mapDataStore, IMapViewPosition iMapViewPosition, boolean z3, boolean z4, boolean z5, GraphicFactory graphicFactory) {
        this(tileCache, mapDataStore, iMapViewPosition, z3, z4, z5, graphicFactory, null);
    }

    public TileRendererLayer(TileCache tileCache, MapDataStore mapDataStore, IMapViewPosition iMapViewPosition, boolean z3, boolean z4, boolean z5, GraphicFactory graphicFactory, HillsRenderConfig hillsRenderConfig) {
        super(tileCache, iMapViewPosition, graphicFactory.createMatrix(), z3);
        this.graphicFactory = graphicFactory;
        this.mapDataStore = mapDataStore;
        this.tileBasedLabelStore = z5 ? new TileBasedLabelStore(tileCache.getCapacityFirstLevel()) : null;
        this.databaseRenderer = new DatabaseRenderer(mapDataStore, graphicFactory, tileCache, this.tileBasedLabelStore, z4, z5, hillsRenderConfig);
        this.textScale = 1.0f;
    }

    protected void compileRenderTheme() {
        this.renderThemeFuture = new RenderThemeFuture(this.graphicFactory, this.xmlRenderTheme, this.displayModel);
        new Thread(this.renderThemeFuture).start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mapsforge.map.layer.TileLayer
    public RendererJob createJob(Tile tile) {
        return new RendererJob(tile, this.mapDataStore, this.renderThemeFuture, this.displayModel, this.textScale, this.isTransparent, false);
    }

    public LabelStore getLabelStore() {
        return this.tileBasedLabelStore;
    }

    public MapDataStore getMapDataStore() {
        return this.mapDataStore;
    }

    public RenderThemeFuture getRenderThemeFuture() {
        return this.renderThemeFuture;
    }

    public float getTextScale() {
        return this.textScale;
    }

    @Override // org.mapsforge.map.layer.TileLayer
    protected boolean isTileStale(Tile tile, TileBitmap tileBitmap) {
        return this.mapDataStore.getDataTimestamp(tile) > tileBitmap.getTimestamp();
    }

    @Override // org.mapsforge.map.layer.Layer
    protected void onAdd() {
        this.mapWorkerPool.start();
        TileCache tileCache = this.tileCache;
        if (tileCache != null) {
            tileCache.addObserver(this);
        }
        super.onAdd();
    }

    @Override // org.mapsforge.map.model.common.Observer
    public void onChange() {
        requestRedraw();
    }

    @Override // org.mapsforge.map.layer.Layer
    public void onDestroy() {
        RenderThemeFuture renderThemeFuture = this.renderThemeFuture;
        if (renderThemeFuture != null) {
            renderThemeFuture.decrementRefCount();
        }
        this.mapDataStore.close();
        super.onDestroy();
    }

    @Override // org.mapsforge.map.layer.Layer
    protected void onRemove() {
        this.mapWorkerPool.stop();
        TileCache tileCache = this.tileCache;
        if (tileCache != null) {
            tileCache.removeObserver(this);
        }
        super.onRemove();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mapsforge.map.layer.TileLayer
    public void retrieveLabelsOnly(RendererJob rendererJob) {
        TileBasedLabelStore tileBasedLabelStore;
        if (this.hasJobQueue && (tileBasedLabelStore = this.tileBasedLabelStore) != null && tileBasedLabelStore.requiresTile(rendererJob.tile)) {
            rendererJob.setRetrieveLabelsOnly();
            this.jobQueue.add(rendererJob);
        }
    }

    @Override // org.mapsforge.map.layer.TileLayer, org.mapsforge.map.layer.Layer
    public synchronized void setDisplayModel(DisplayModel displayModel) {
        super.setDisplayModel(displayModel);
        if (displayModel != null) {
            compileRenderTheme();
            if (this.mapWorkerPool == null) {
                this.mapWorkerPool = new MapWorkerPool(this.tileCache, this.jobQueue, this.databaseRenderer, this);
            }
            this.mapWorkerPool.start();
        } else {
            MapWorkerPool mapWorkerPool = this.mapWorkerPool;
            if (mapWorkerPool != null) {
                mapWorkerPool.stop();
            }
        }
    }

    public void setTextScale(float f3) {
        this.textScale = f3;
    }

    public void setXmlRenderTheme(XmlRenderTheme xmlRenderTheme) {
        this.xmlRenderTheme = xmlRenderTheme;
        compileRenderTheme();
    }
}
