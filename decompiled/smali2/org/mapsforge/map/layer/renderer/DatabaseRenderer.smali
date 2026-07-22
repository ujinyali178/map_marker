.class public Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;
.super Lorg/mapsforge/map/layer/renderer/StandardRenderer;
.source "SourceFile"


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;


# instance fields
.field private final labelStore:Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;

.field private final renderLabels:Z

.field private final tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

.field private final tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;ZZLorg/mapsforge/map/layer/hills/HillsRenderConfig;)V
    .registers 8

    if-nez p5, :cond_7

    if-eqz p6, :cond_5

    goto :goto_7

    :cond_5
    const/4 p6, 0x0

    goto :goto_8

    :cond_7
    :goto_7
    const/4 p6, 0x1

    :goto_8
    invoke-direct {p0, p1, p2, p6, p7}, Lorg/mapsforge/map/layer/renderer/StandardRenderer;-><init>(Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/core/graphics/GraphicFactory;ZLorg/mapsforge/map/layer/hills/HillsRenderConfig;)V

    iput-object p3, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    iput-object p4, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->labelStore:Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;

    iput-boolean p5, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->renderLabels:Z

    if-nez p5, :cond_15

    const/4 p1, 0x0

    goto :goto_1a

    :cond_15
    new-instance p1, Lorg/mapsforge/map/layer/renderer/TileDependencies;

    invoke-direct {p1}, Lorg/mapsforge/map/layer/renderer/TileDependencies;-><init>()V

    :goto_1a
    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    return-void
.end method

.method private createBackgroundBitmap(Lorg/mapsforge/map/rendertheme/RenderContext;)Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v1, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v2, v1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget v2, v2, Lorg/mapsforge/core/model/Tile;->tileSize:I

    iget-boolean v1, v1, Lorg/mapsforge/map/layer/queue/Job;->hasAlpha:Z

    invoke-interface {v0, v2, v1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createTileBitmap(IZ)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object v0

    iget-object v1, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->setCanvasBitmap(Lorg/mapsforge/core/graphics/Bitmap;)V

    iget-object v1, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-boolean v1, v1, Lorg/mapsforge/map/layer/queue/Job;->hasAlpha:Z

    if-nez v1, :cond_24

    iget-object v1, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    iget-object p1, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {p1}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->getMapBackgroundOutside()I

    move-result p1

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->fill(I)V

    :cond_24
    return-object v0
.end method

.method private processLabels(Lorg/mapsforge/map/rendertheme/RenderContext;)Ljava/util/Set;
    .registers 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/rendertheme/RenderContext;",
            ")",
            "Ljava/util/Set<",
            "Lorg/mapsforge/core/mapelements/MapElementContainer;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    monitor-enter v1

    :try_start_8
    iget-object v2, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v2, v2, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v2}, Lorg/mapsforge/core/model/Tile;->getNeighbours()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4}, Ljava/util/HashSet;-><init>()V

    iget-object v5, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    iget-object v6, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v6, v6, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v5, v6}, Lorg/mapsforge/map/layer/renderer/TileDependencies;->addTileInProgress(Lorg/mapsforge/core/model/Tile;)V

    :goto_22
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_7c

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lorg/mapsforge/core/model/Tile;

    iget-object v6, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    invoke-virtual {v6, v5}, Lorg/mapsforge/map/layer/renderer/TileDependencies;->isTileInProgress(Lorg/mapsforge/core/model/Tile;)Z

    move-result v6

    if-nez v6, :cond_4b

    iget-object v6, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    iget-object v7, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    invoke-virtual {v7, v5}, Lorg/mapsforge/map/layer/renderer/RendererJob;->otherTile(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/renderer/RendererJob;

    move-result-object v7

    invoke-interface {v6, v7}, Lorg/mapsforge/map/layer/cache/TileCache;->containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z

    move-result v6

    if-eqz v6, :cond_45

    goto :goto_4b

    :cond_45
    iget-object v6, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    invoke-virtual {v6, v5}, Lorg/mapsforge/map/layer/renderer/TileDependencies;->removeTileData(Lorg/mapsforge/core/model/Tile;)V

    goto :goto_22

    :cond_4b
    :goto_4b
    iget-object v6, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    iget-object v7, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v7, v7, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v6, v5, v7}, Lorg/mapsforge/map/layer/renderer/TileDependencies;->getOverlappingElements(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Ljava/util/Set;

    move-result-object v6

    invoke-interface {v0, v6}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    iget-object v6, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_5e
    :goto_5e
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_78

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lorg/mapsforge/core/mapelements/MapElementContainer;

    invoke-virtual {v5}, Lorg/mapsforge/core/model/Tile;->getBoundaryAbsolute()Lorg/mapsforge/core/model/Rectangle;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/mapsforge/core/mapelements/MapElementContainer;->intersects(Lorg/mapsforge/core/model/Rectangle;)Z

    move-result v8

    if-eqz v8, :cond_5e

    invoke-interface {v4, v7}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_5e

    :cond_78
    invoke-interface {v3}, Ljava/util/Iterator;->remove()V

    goto :goto_22

    :cond_7c
    iget-object v3, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    iget-object v3, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;

    invoke-static {v3}, Lorg/mapsforge/map/util/LayerUtil;->collisionFreeOrdered(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_8b
    :goto_8b
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_b1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lorg/mapsforge/core/mapelements/MapElementContainer;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_9b
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_8b

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lorg/mapsforge/core/mapelements/MapElementContainer;

    invoke-virtual {v7, v5}, Lorg/mapsforge/core/mapelements/MapElementContainer;->clashesWith(Lorg/mapsforge/core/mapelements/MapElementContainer;)Z

    move-result v7

    if-eqz v7, :cond_9b

    invoke-interface {v4}, Ljava/util/Iterator;->remove()V

    goto :goto_8b

    :cond_b1
    invoke-interface {v0, v3}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_b8
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_f1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/core/model/Tile;

    iget-object v4, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    iget-object v5, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v5, v5, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v4, v5, v3}, Lorg/mapsforge/map/layer/renderer/TileDependencies;->removeTileData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)V

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_d1
    :goto_d1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_b8

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lorg/mapsforge/core/mapelements/MapElementContainer;

    invoke-virtual {v3}, Lorg/mapsforge/core/model/Tile;->getBoundaryAbsolute()Lorg/mapsforge/core/model/Rectangle;

    move-result-object v6

    invoke-virtual {v5, v6}, Lorg/mapsforge/core/mapelements/MapElementContainer;->intersects(Lorg/mapsforge/core/model/Rectangle;)Z

    move-result v6

    if-eqz v6, :cond_d1

    iget-object v6, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    iget-object v7, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v7, v7, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v6, v7, v3, v5}, Lorg/mapsforge/map/layer/renderer/TileDependencies;->addOverlappingElement(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/mapelements/MapElementContainer;)V

    goto :goto_d1

    :cond_f1
    monitor-exit v1

    return-object v0

    :catchall_f3
    move-exception p1

    monitor-exit v1
    :try_end_f5
    .catchall {:try_start_8 .. :try_end_f5} :catchall_f3

    throw p1
.end method


# virtual methods
.method public executeJob(Lorg/mapsforge/map/layer/renderer/RendererJob;)Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 8

    const/4 v0, 0x0

    :try_start_1
    new-instance v1, Lorg/mapsforge/map/rendertheme/RenderContext;

    new-instance v2, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    iget-object v3, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-direct {v2, v3}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;)V

    invoke-direct {v1, p1, v2}, Lorg/mapsforge/map/rendertheme/RenderContext;-><init>(Lorg/mapsforge/map/layer/renderer/RendererJob;Lorg/mapsforge/map/layer/renderer/CanvasRasterer;)V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_d} :catch_c2
    .catchall {:try_start_1 .. :try_end_d} :catchall_c0

    :try_start_d
    invoke-virtual {p0, v1}, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->renderBitmap(Lorg/mapsforge/map/rendertheme/RenderContext;)Z

    move-result v2

    if-eqz v2, :cond_b6

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    if-eqz v2, :cond_20

    iget-object v3, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v2, v3}, Lorg/mapsforge/map/datastore/MapDataStore;->readMapData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->processReadMapData(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/MapReadResult;)V

    :cond_20
    iget-boolean v2, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->labelsOnly:Z

    if-nez v2, :cond_68

    iget-object v2, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v2, p0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->matchHillShadings(Lorg/mapsforge/map/layer/renderer/StandardRenderer;Lorg/mapsforge/map/rendertheme/RenderContext;)V

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v3, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget v3, v3, Lorg/mapsforge/core/model/Tile;->tileSize:I

    iget-boolean v4, p1, Lorg/mapsforge/map/layer/queue/Job;->hasAlpha:Z

    invoke-interface {v2, v3, v4}, Lorg/mapsforge/core/graphics/GraphicFactory;->createTileBitmap(IZ)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object v2

    iget-object v3, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    iget-object v4, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v3, v4}, Lorg/mapsforge/map/datastore/MapDataStore;->getDataTimestamp(Lorg/mapsforge/core/model/Tile;)J

    move-result-wide v3

    invoke-interface {v2, v3, v4}, Lorg/mapsforge/core/graphics/TileBitmap;->setTimestamp(J)V

    iget-object v3, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    invoke-virtual {v3, v2}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->setCanvasBitmap(Lorg/mapsforge/core/graphics/Bitmap;)V

    iget-boolean v3, p1, Lorg/mapsforge/map/layer/queue/Job;->hasAlpha:Z

    if-nez v3, :cond_62

    iget-object v3, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v3}, Lorg/mapsforge/map/model/DisplayModel;->getBackgroundColor()I

    move-result v3

    iget-object v4, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v4}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->getMapBackground()I

    move-result v4

    if-eq v3, v4, :cond_62

    iget-object v3, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    iget-object v4, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v4}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->getMapBackground()I

    move-result v4

    invoke-virtual {v3, v4}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->fill(I)V

    :cond_62
    iget-object v3, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    invoke-virtual {v3, v1}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->drawWays(Lorg/mapsforge/map/rendertheme/RenderContext;)V

    goto :goto_69

    :cond_68
    move-object v2, v0

    :goto_69
    iget-boolean v3, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->renderLabels:Z

    if-eqz v3, :cond_78

    invoke-direct {p0, v1}, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->processLabels(Lorg/mapsforge/map/rendertheme/RenderContext;)Ljava/util/Set;

    move-result-object v3

    iget-object v4, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    iget-object v5, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v4, v3, v5}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->drawMapElements(Ljava/util/Set;Lorg/mapsforge/core/model/Tile;)V

    :cond_78
    iget-object v3, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->labelStore:Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;

    if-eqz v3, :cond_83

    iget-object v4, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-object v5, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;

    invoke-virtual {v3, v4, v5}, Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;->storeMapItems(Lorg/mapsforge/core/model/Tile;Ljava/util/List;)V

    :cond_83
    iget-boolean v3, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->labelsOnly:Z

    if-nez v3, :cond_b2

    iget-object v3, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v3}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->hasMapBackgroundOutside()Z

    move-result v3

    if-eqz v3, :cond_b2

    iget-object v3, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v3}, Lorg/mapsforge/map/datastore/MapDataStore;->boundingBox()Lorg/mapsforge/core/model/BoundingBox;

    move-result-object v3

    iget-object v4, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v3, v4}, Lorg/mapsforge/core/model/BoundingBox;->getPositionRelativeToTile(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/core/model/Rectangle;

    move-result-object v3

    iget-boolean p1, p1, Lorg/mapsforge/map/layer/queue/Job;->hasAlpha:Z

    if-nez p1, :cond_ab

    iget-object p1, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    iget-object v4, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v4}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->getMapBackgroundOutside()I

    move-result v4

    invoke-virtual {p1, v4, v3}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->fillOutsideAreas(ILorg/mapsforge/core/model/Rectangle;)V

    goto :goto_b2

    :cond_ab
    iget-object p1, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    sget-object v4, Lorg/mapsforge/core/graphics/Color;->TRANSPARENT:Lorg/mapsforge/core/graphics/Color;

    invoke-virtual {p1, v4, v3}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->fillOutsideAreas(Lorg/mapsforge/core/graphics/Color;Lorg/mapsforge/core/model/Rectangle;)V
    :try_end_b2
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_b2} :catch_be
    .catchall {:try_start_d .. :try_end_b2} :catchall_e4

    :cond_b2
    :goto_b2
    invoke-virtual {v1}, Lorg/mapsforge/map/rendertheme/RenderContext;->destroy()V

    return-object v2

    :cond_b6
    :try_start_b6
    invoke-direct {p0, v1}, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->createBackgroundBitmap(Lorg/mapsforge/map/rendertheme/RenderContext;)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object p1
    :try_end_ba
    .catch Ljava/lang/Exception; {:try_start_b6 .. :try_end_ba} :catch_be
    .catchall {:try_start_b6 .. :try_end_ba} :catchall_e4

    invoke-virtual {v1}, Lorg/mapsforge/map/rendertheme/RenderContext;->destroy()V

    return-object p1

    :catch_be
    move-exception p1

    goto :goto_c4

    :catchall_c0
    move-exception p1

    goto :goto_e6

    :catch_c2
    move-exception p1

    move-object v1, v0

    :goto_c4
    :try_start_c4
    sget-object v2, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->LOGGER:Ljava/util/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Exception: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v2, p1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V
    :try_end_de
    .catchall {:try_start_c4 .. :try_end_de} :catchall_e4

    if-eqz v1, :cond_e3

    invoke-virtual {v1}, Lorg/mapsforge/map/rendertheme/RenderContext;->destroy()V

    :cond_e3
    return-object v0

    :catchall_e4
    move-exception p1

    move-object v0, v1

    :goto_e6
    if-eqz v0, :cond_eb

    invoke-virtual {v0}, Lorg/mapsforge/map/rendertheme/RenderContext;->destroy()V

    :cond_eb
    throw p1
.end method

.method public getMapDatabase()Lorg/mapsforge/map/datastore/MapDataStore;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    return-object v0
.end method

.method removeTileInProgress(Lorg/mapsforge/core/model/Tile;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    if-eqz v0, :cond_7

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/layer/renderer/TileDependencies;->removeTileInProgress(Lorg/mapsforge/core/model/Tile;)V

    :cond_7
    return-void
.end method
