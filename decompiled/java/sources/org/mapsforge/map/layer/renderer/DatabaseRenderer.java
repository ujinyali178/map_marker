package org.mapsforge.map.layer.renderer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.TileBitmap;
import org.mapsforge.core.mapelements.MapElementContainer;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.hills.HillsRenderConfig;
import org.mapsforge.map.layer.labels.TileBasedLabelStore;
import org.mapsforge.map.rendertheme.RenderContext;
import org.mapsforge.map.util.LayerUtil;

/* loaded from: /root/release/classes2.dex */
public class DatabaseRenderer extends StandardRenderer {
    private static final Logger LOGGER = Logger.getLogger(DatabaseRenderer.class.getName());
    private final TileBasedLabelStore labelStore;
    private final boolean renderLabels;
    private final TileCache tileCache;
    private final TileDependencies tileDependencies;

    public DatabaseRenderer(MapDataStore mapDataStore, GraphicFactory graphicFactory, TileCache tileCache, TileBasedLabelStore tileBasedLabelStore, boolean z3, boolean z4, HillsRenderConfig hillsRenderConfig) {
        super(mapDataStore, graphicFactory, z3 || z4, hillsRenderConfig);
        this.tileCache = tileCache;
        this.labelStore = tileBasedLabelStore;
        this.renderLabels = z3;
        this.tileDependencies = !z3 ? null : new TileDependencies();
    }

    private TileBitmap createBackgroundBitmap(RenderContext renderContext) {
        GraphicFactory graphicFactory = this.graphicFactory;
        RendererJob rendererJob = renderContext.rendererJob;
        TileBitmap createTileBitmap = graphicFactory.createTileBitmap(rendererJob.tile.tileSize, rendererJob.hasAlpha);
        renderContext.canvasRasterer.setCanvasBitmap(createTileBitmap);
        if (!renderContext.rendererJob.hasAlpha) {
            renderContext.canvasRasterer.fill(renderContext.renderTheme.getMapBackgroundOutside());
        }
        return createTileBitmap;
    }

    private Set<MapElementContainer> processLabels(RenderContext renderContext) {
        HashSet<MapElementContainer> hashSet = new HashSet();
        synchronized (this.tileDependencies) {
            Set<Tile> neighbours = renderContext.rendererJob.tile.getNeighbours();
            Iterator<Tile> it = neighbours.iterator();
            HashSet hashSet2 = new HashSet();
            this.tileDependencies.addTileInProgress(renderContext.rendererJob.tile);
            while (it.hasNext()) {
                Tile next = it.next();
                if (!this.tileDependencies.isTileInProgress(next) && !this.tileCache.containsKey(renderContext.rendererJob.otherTile(next))) {
                    this.tileDependencies.removeTileData(next);
                }
                hashSet.addAll(this.tileDependencies.getOverlappingElements(next, renderContext.rendererJob.tile));
                for (MapElementContainer mapElementContainer : renderContext.labels) {
                    if (mapElementContainer.intersects(next.getBoundaryAbsolute())) {
                        hashSet2.add(mapElementContainer);
                    }
                }
                it.remove();
            }
            renderContext.labels.removeAll(hashSet2);
            List<MapElementContainer> collisionFreeOrdered = LayerUtil.collisionFreeOrdered(renderContext.labels);
            Iterator<MapElementContainer> it2 = collisionFreeOrdered.iterator();
            while (it2.hasNext()) {
                MapElementContainer next2 = it2.next();
                Iterator it3 = hashSet.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    if (((MapElementContainer) it3.next()).clashesWith(next2)) {
                        it2.remove();
                        break;
                    }
                }
            }
            hashSet.addAll(collisionFreeOrdered);
            for (Tile tile : neighbours) {
                this.tileDependencies.removeTileData(renderContext.rendererJob.tile, tile);
                for (MapElementContainer mapElementContainer2 : hashSet) {
                    if (mapElementContainer2.intersects(tile.getBoundaryAbsolute())) {
                        this.tileDependencies.addOverlappingElement(renderContext.rendererJob.tile, tile, mapElementContainer2);
                    }
                }
            }
        }
        return hashSet;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00e5: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:46:0x00e5 */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.mapsforge.core.graphics.TileBitmap executeJob(org.mapsforge.map.layer.renderer.RendererJob r7) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mapsforge.map.layer.renderer.DatabaseRenderer.executeJob(org.mapsforge.map.layer.renderer.RendererJob):org.mapsforge.core.graphics.TileBitmap");
    }

    public MapDataStore getMapDatabase() {
        return this.mapDataStore;
    }

    void removeTileInProgress(Tile tile) {
        TileDependencies tileDependencies = this.tileDependencies;
        if (tileDependencies != null) {
            tileDependencies.removeTileInProgress(tile);
        }
    }
}
