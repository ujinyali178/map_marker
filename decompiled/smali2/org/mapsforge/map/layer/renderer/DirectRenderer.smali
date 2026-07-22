.class public Lorg/mapsforge/map/layer/renderer/DirectRenderer;
.super Lorg/mapsforge/map/layer/renderer/StandardRenderer;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/layer/renderer/DirectRenderer$TileRefresher;
    }
.end annotation


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;


# instance fields
.field private final renderLabels:Z

.field private final tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

.field private final tileRefreshers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/map/layer/renderer/DirectRenderer$TileRefresher;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/core/graphics/GraphicFactory;ZLorg/mapsforge/map/layer/hills/HillsRenderConfig;)V
    .registers 5

    invoke-direct {p0, p1, p2, p3, p4}, Lorg/mapsforge/map/layer/renderer/StandardRenderer;-><init>(Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/core/graphics/GraphicFactory;ZLorg/mapsforge/map/layer/hills/HillsRenderConfig;)V

    iput-boolean p3, p0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->renderLabels:Z

    new-instance p1, Lorg/mapsforge/map/layer/renderer/TileDependencies;

    invoke-direct {p1}, Lorg/mapsforge/map/layer/renderer/TileDependencies;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->tileRefreshers:Ljava/util/List;

    return-void
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

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    monitor-enter v0

    :try_start_3
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    iget-object v2, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v2, v2, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v2}, Lorg/mapsforge/core/model/Tile;->getNeighbours()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_14
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2e

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/mapsforge/core/model/Tile;

    iget-object v5, p0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    iget-object v6, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v6, v6, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v5, v4, v6}, Lorg/mapsforge/map/layer/renderer/TileDependencies;->getOverlappingElements(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Ljava/util/Set;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    goto :goto_14

    :cond_2e
    iget-object v3, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;

    invoke-static {v3}, Lorg/mapsforge/map/util/LayerUtil;->collisionFreeOrdered(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_38
    :goto_38
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_5e

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lorg/mapsforge/core/mapelements/MapElementContainer;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_48
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_38

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lorg/mapsforge/core/mapelements/MapElementContainer;

    invoke-virtual {v7, v5}, Lorg/mapsforge/core/mapelements/MapElementContainer;->clashesWith(Lorg/mapsforge/core/mapelements/MapElementContainer;)Z

    move-result v7

    if-eqz v7, :cond_48

    invoke-interface {v4}, Ljava/util/Iterator;->remove()V

    goto :goto_38

    :cond_5e
    invoke-interface {v1, v3}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_65
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_dd

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/core/model/Tile;

    iget-object v4, p0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    iget-object v5, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v5, v5, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v4, v5, v3}, Lorg/mapsforge/map/layer/renderer/TileDependencies;->getOverlappingElements(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Ljava/util/Set;

    move-result-object v4

    new-instance v5, Ljava/util/HashSet;

    invoke-direct {v5}, Ljava/util/HashSet;-><init>()V

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_84
    :goto_84
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_9e

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lorg/mapsforge/core/mapelements/MapElementContainer;

    invoke-virtual {v3}, Lorg/mapsforge/core/model/Tile;->getBoundaryAbsolute()Lorg/mapsforge/core/model/Rectangle;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/mapsforge/core/mapelements/MapElementContainer;->intersects(Lorg/mapsforge/core/model/Rectangle;)Z

    move-result v8

    if-eqz v8, :cond_84

    invoke-interface {v5, v7}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_84

    :cond_9e
    invoke-interface {v4, v5}, Ljava/util/Set;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_65

    iget-object v4, p0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    iget-object v6, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v6, v6, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v4, v6, v3}, Lorg/mapsforge/map/layer/renderer/TileDependencies;->removeTileData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)V

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_b1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_c7

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lorg/mapsforge/core/mapelements/MapElementContainer;

    iget-object v6, p0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->tileDependencies:Lorg/mapsforge/map/layer/renderer/TileDependencies;

    iget-object v7, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v7, v7, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v6, v7, v3, v5}, Lorg/mapsforge/map/layer/renderer/TileDependencies;->addOverlappingElement(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/mapelements/MapElementContainer;)V

    goto :goto_b1

    :cond_c7
    iget-object v4, p0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->tileRefreshers:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_cd
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_65

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lorg/mapsforge/map/layer/renderer/DirectRenderer$TileRefresher;

    invoke-interface {v5, v3}, Lorg/mapsforge/map/layer/renderer/DirectRenderer$TileRefresher;->refresh(Lorg/mapsforge/core/model/Tile;)V

    goto :goto_cd

    :cond_dd
    monitor-exit v0

    return-object v1

    :catchall_df
    move-exception p1

    monitor-exit v0
    :try_end_e1
    .catchall {:try_start_3 .. :try_end_e1} :catchall_df

    throw p1
.end method


# virtual methods
.method public addTileRefresher(Lorg/mapsforge/map/layer/renderer/DirectRenderer$TileRefresher;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->tileRefreshers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

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
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_d} :catch_b3
    .catchall {:try_start_1 .. :try_end_d} :catchall_b1

    :try_start_d
    invoke-virtual {p0, v1}, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->renderBitmap(Lorg/mapsforge/map/rendertheme/RenderContext;)Z

    move-result v2

    if-eqz v2, :cond_ab

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
    iget-boolean v3, p0, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->renderLabels:Z

    if-eqz v3, :cond_78

    invoke-direct {p0, v1}, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->processLabels(Lorg/mapsforge/map/rendertheme/RenderContext;)Ljava/util/Set;

    move-result-object v3

    iget-object v4, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    iget-object v5, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v4, v3, v5}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->drawMapElements(Ljava/util/Set;Lorg/mapsforge/core/model/Tile;)V

    :cond_78
    iget-boolean v3, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->labelsOnly:Z

    if-nez v3, :cond_a7

    iget-object v3, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v3}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->hasMapBackgroundOutside()Z

    move-result v3

    if-eqz v3, :cond_a7

    iget-object v3, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v3}, Lorg/mapsforge/map/datastore/MapDataStore;->boundingBox()Lorg/mapsforge/core/model/BoundingBox;

    move-result-object v3

    iget-object v4, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v3, v4}, Lorg/mapsforge/core/model/BoundingBox;->getPositionRelativeToTile(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/core/model/Rectangle;

    move-result-object v3

    iget-boolean p1, p1, Lorg/mapsforge/map/layer/queue/Job;->hasAlpha:Z

    if-nez p1, :cond_a0

    iget-object p1, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    iget-object v4, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v4}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->getMapBackgroundOutside()I

    move-result v4

    invoke-virtual {p1, v4, v3}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->fillOutsideAreas(ILorg/mapsforge/core/model/Rectangle;)V

    goto :goto_a7

    :cond_a0
    iget-object p1, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    sget-object v4, Lorg/mapsforge/core/graphics/Color;->TRANSPARENT:Lorg/mapsforge/core/graphics/Color;

    invoke-virtual {p1, v4, v3}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->fillOutsideAreas(Lorg/mapsforge/core/graphics/Color;Lorg/mapsforge/core/model/Rectangle;)V
    :try_end_a7
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_a7} :catch_af
    .catchall {:try_start_d .. :try_end_a7} :catchall_d5

    :cond_a7
    :goto_a7
    invoke-virtual {v1}, Lorg/mapsforge/map/rendertheme/RenderContext;->destroy()V

    return-object v2

    :cond_ab
    invoke-virtual {v1}, Lorg/mapsforge/map/rendertheme/RenderContext;->destroy()V

    return-object v0

    :catch_af
    move-exception p1

    goto :goto_b5

    :catchall_b1
    move-exception p1

    goto :goto_d7

    :catch_b3
    move-exception p1

    move-object v1, v0

    :goto_b5
    :try_start_b5
    sget-object v2, Lorg/mapsforge/map/layer/renderer/DirectRenderer;->LOGGER:Ljava/util/logging/Logger;

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
    :try_end_cf
    .catchall {:try_start_b5 .. :try_end_cf} :catchall_d5

    if-eqz v1, :cond_d4

    invoke-virtual {v1}, Lorg/mapsforge/map/rendertheme/RenderContext;->destroy()V

    :cond_d4
    return-object v0

    :catchall_d5
    move-exception p1

    move-object v0, v1

    :goto_d7
    if-eqz v0, :cond_dc

    invoke-virtual {v0}, Lorg/mapsforge/map/rendertheme/RenderContext;->destroy()V

    :cond_dc
    throw p1
.end method
