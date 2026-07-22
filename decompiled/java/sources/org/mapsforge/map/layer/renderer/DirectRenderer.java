package org.mapsforge.map.layer.renderer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.mapelements.MapElementContainer;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.layer.hills.HillsRenderConfig;
import org.mapsforge.map.rendertheme.RenderContext;
import org.mapsforge.map.util.LayerUtil;

/* loaded from: /root/release/classes2.dex */
public class DirectRenderer extends StandardRenderer {
    private static final Logger LOGGER = Logger.getLogger(DirectRenderer.class.getName());
    private final boolean renderLabels;
    private final TileDependencies tileDependencies;
    private final List<TileRefresher> tileRefreshers;

    public interface TileRefresher {
        void refresh(Tile tile);
    }

    public DirectRenderer(MapDataStore mapDataStore, GraphicFactory graphicFactory, boolean z3, HillsRenderConfig hillsRenderConfig) {
        super(mapDataStore, graphicFactory, z3, hillsRenderConfig);
        this.renderLabels = z3;
        this.tileDependencies = new TileDependencies();
        this.tileRefreshers = new ArrayList();
    }

    private Set<MapElementContainer> processLabels(RenderContext renderContext) {
        HashSet<MapElementContainer> hashSet;
        synchronized (this.tileDependencies) {
            hashSet = new HashSet();
            Set<Tile> neighbours = renderContext.rendererJob.tile.getNeighbours();
            Iterator<Tile> it = neighbours.iterator();
            while (it.hasNext()) {
                hashSet.addAll(this.tileDependencies.getOverlappingElements(it.next(), renderContext.rendererJob.tile));
            }
            List<MapElementContainer> collisionFreeOrdered = LayerUtil.collisionFreeOrdered(renderContext.labels);
            Iterator<MapElementContainer> it2 = collisionFreeOrdered.iterator();
            while (it2.hasNext()) {
                MapElementContainer next = it2.next();
                Iterator it3 = hashSet.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    if (((MapElementContainer) it3.next()).clashesWith(next)) {
                        it2.remove();
                        break;
                    }
                }
            }
            hashSet.addAll(collisionFreeOrdered);
            for (Tile tile : neighbours) {
                Set<MapElementContainer> overlappingElements = this.tileDependencies.getOverlappingElements(renderContext.rendererJob.tile, tile);
                HashSet hashSet2 = new HashSet();
                for (MapElementContainer mapElementContainer : hashSet) {
                    if (mapElementContainer.intersects(tile.getBoundaryAbsolute())) {
                        hashSet2.add(mapElementContainer);
                    }
                }
                if (!overlappingElements.equals(hashSet2)) {
                    this.tileDependencies.removeTileData(renderContext.rendererJob.tile, tile);
                    Iterator it4 = hashSet2.iterator();
                    while (it4.hasNext()) {
                        this.tileDependencies.addOverlappingElement(renderContext.rendererJob.tile, tile, (MapElementContainer) it4.next());
                    }
                    Iterator<TileRefresher> it5 = this.tileRefreshers.iterator();
                    while (it5.hasNext()) {
                        it5.next().refresh(tile);
                    }
                }
            }
        }
        return hashSet;
    }

    public void addTileRefresher(TileRefresher tileRefresher) {
        this.tileRefreshers.add(tileRefresher);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00d6: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:42:0x00d6 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.mapsforge.core.graphics.TileBitmap executeJob(org.mapsforge.map.layer.renderer.RendererJob r7) {
        /*
            r6 = this;
            r0 = 0
            org.mapsforge.map.rendertheme.RenderContext r1 = new org.mapsforge.map.rendertheme.RenderContext     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb3
            org.mapsforge.map.layer.renderer.CanvasRasterer r2 = new org.mapsforge.map.layer.renderer.CanvasRasterer     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb3
            org.mapsforge.core.graphics.GraphicFactory r3 = r6.graphicFactory     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb3
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb3
            r1.<init>(r7, r2)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb3
            boolean r2 = r6.renderBitmap(r1)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            if (r2 == 0) goto Lab
            org.mapsforge.map.datastore.MapDataStore r2 = r6.mapDataStore     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            if (r2 == 0) goto L20
            org.mapsforge.core.model.Tile r3 = r7.tile     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.map.datastore.MapReadResult r2 = r2.readMapData(r3)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            r6.processReadMapData(r1, r2)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
        L20:
            boolean r2 = r7.labelsOnly     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            if (r2 != 0) goto L68
            org.mapsforge.map.rendertheme.rule.RenderTheme r2 = r1.renderTheme     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            r2.matchHillShadings(r6, r1)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.core.graphics.GraphicFactory r2 = r6.graphicFactory     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.core.model.Tile r3 = r7.tile     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            int r3 = r3.tileSize     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            boolean r4 = r7.hasAlpha     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.core.graphics.TileBitmap r2 = r2.createTileBitmap(r3, r4)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.map.datastore.MapDataStore r3 = r7.mapDataStore     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.core.model.Tile r4 = r7.tile     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            long r3 = r3.getDataTimestamp(r4)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            r2.setTimestamp(r3)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.map.layer.renderer.CanvasRasterer r3 = r1.canvasRasterer     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            r3.setCanvasBitmap(r2)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            boolean r3 = r7.hasAlpha     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            if (r3 != 0) goto L62
            org.mapsforge.map.model.DisplayModel r3 = r7.displayModel     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            int r3 = r3.getBackgroundColor()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.map.rendertheme.rule.RenderTheme r4 = r1.renderTheme     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            int r4 = r4.getMapBackground()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            if (r3 == r4) goto L62
            org.mapsforge.map.layer.renderer.CanvasRasterer r3 = r1.canvasRasterer     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.map.rendertheme.rule.RenderTheme r4 = r1.renderTheme     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            int r4 = r4.getMapBackground()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            r3.fill(r4)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
        L62:
            org.mapsforge.map.layer.renderer.CanvasRasterer r3 = r1.canvasRasterer     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            r3.drawWays(r1)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            goto L69
        L68:
            r2 = r0
        L69:
            boolean r3 = r6.renderLabels     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            if (r3 == 0) goto L78
            java.util.Set r3 = r6.processLabels(r1)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.map.layer.renderer.CanvasRasterer r4 = r1.canvasRasterer     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.core.model.Tile r5 = r7.tile     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            r4.drawMapElements(r3, r5)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
        L78:
            boolean r3 = r7.labelsOnly     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            if (r3 != 0) goto La7
            org.mapsforge.map.rendertheme.rule.RenderTheme r3 = r1.renderTheme     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            boolean r3 = r3.hasMapBackgroundOutside()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            if (r3 == 0) goto La7
            org.mapsforge.map.datastore.MapDataStore r3 = r6.mapDataStore     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.core.model.BoundingBox r3 = r3.boundingBox()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.core.model.Tile r4 = r7.tile     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.core.model.Rectangle r3 = r3.getPositionRelativeToTile(r4)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            boolean r7 = r7.hasAlpha     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            if (r7 != 0) goto La0
            org.mapsforge.map.layer.renderer.CanvasRasterer r7 = r1.canvasRasterer     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.map.rendertheme.rule.RenderTheme r4 = r1.renderTheme     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            int r4 = r4.getMapBackgroundOutside()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            r7.fillOutsideAreas(r4, r3)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            goto La7
        La0:
            org.mapsforge.map.layer.renderer.CanvasRasterer r7 = r1.canvasRasterer     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            org.mapsforge.core.graphics.Color r4 = org.mapsforge.core.graphics.Color.TRANSPARENT     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
            r7.fillOutsideAreas(r4, r3)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Ld5
        La7:
            r1.destroy()
            return r2
        Lab:
            r1.destroy()
            return r0
        Laf:
            r7 = move-exception
            goto Lb5
        Lb1:
            r7 = move-exception
            goto Ld7
        Lb3:
            r7 = move-exception
            r1 = r0
        Lb5:
            java.util.logging.Logger r2 = org.mapsforge.map.layer.renderer.DirectRenderer.LOGGER     // Catch: java.lang.Throwable -> Ld5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld5
            r3.<init>()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = "Exception: "
            r3.append(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> Ld5
            r3.append(r7)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> Ld5
            r2.warning(r7)     // Catch: java.lang.Throwable -> Ld5
            if (r1 == 0) goto Ld4
            r1.destroy()
        Ld4:
            return r0
        Ld5:
            r7 = move-exception
            r0 = r1
        Ld7:
            if (r0 == 0) goto Ldc
            r0.destroy()
        Ldc:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mapsforge.map.layer.renderer.DirectRenderer.executeJob(org.mapsforge.map.layer.renderer.RendererJob):org.mapsforge.core.graphics.TileBitmap");
    }
}
