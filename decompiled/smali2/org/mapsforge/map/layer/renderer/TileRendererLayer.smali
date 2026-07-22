.class public Lorg/mapsforge/map/layer/renderer/TileRendererLayer;
.super Lorg/mapsforge/map/layer/TileLayer;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/model/common/Observer;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/mapsforge/map/layer/TileLayer<",
        "Lorg/mapsforge/map/layer/renderer/RendererJob;",
        ">;",
        "Lorg/mapsforge/map/model/common/Observer;"
    }
.end annotation


# instance fields
.field private final databaseRenderer:Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;

.field private final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field private final mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

.field private mapWorkerPool:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

.field private renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

.field private textScale:F

.field private final tileBasedLabelStore:Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;

.field private xmlRenderTheme:Lorg/mapsforge/map/rendertheme/XmlRenderTheme;


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 13

    const/4 v4, 0x0

    const/4 v5, 0x1

    const/4 v5, 0x1

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v7, p4

    invoke-direct/range {v0 .. v7}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;-><init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/model/IMapViewPosition;ZZZLorg/mapsforge/core/graphics/GraphicFactory;)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/model/IMapViewPosition;ZZZLorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 17

    const/4 v8, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    move v5, p5

    move v6, p6

    move-object/from16 v7, p7

    invoke-direct/range {v0 .. v8}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;-><init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/model/IMapViewPosition;ZZZLorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/layer/hills/HillsRenderConfig;)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/model/IMapViewPosition;ZZZLorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/layer/hills/HillsRenderConfig;)V
    .registers 20

    move-object v0, p0

    invoke-interface/range {p7 .. p7}, Lorg/mapsforge/core/graphics/GraphicFactory;->createMatrix()Lorg/mapsforge/core/graphics/Matrix;

    move-result-object v1

    move-object v5, p1

    move-object v2, p3

    move v3, p4

    invoke-direct {p0, p1, p3, v1, p4}, Lorg/mapsforge/map/layer/TileLayer;-><init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/core/graphics/Matrix;Z)V

    move-object/from16 v1, p7

    iput-object v1, v0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    move-object v3, p2

    iput-object v3, v0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    if-eqz p6, :cond_1e

    new-instance v2, Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;

    invoke-interface {p1}, Lorg/mapsforge/map/layer/cache/TileCache;->getCapacityFirstLevel()I

    move-result v4

    invoke-direct {v2, v4}, Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;-><init>(I)V

    goto :goto_1f

    :cond_1e
    const/4 v2, 0x0

    :goto_1f
    iput-object v2, v0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->tileBasedLabelStore:Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;

    new-instance v10, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;

    iget-object v6, v0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->tileBasedLabelStore:Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;

    move-object v2, v10

    move-object v3, p2

    move-object/from16 v4, p7

    move-object v5, p1

    move/from16 v7, p5

    move/from16 v8, p6

    move-object/from16 v9, p8

    invoke-direct/range {v2 .. v9}, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;-><init>(Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;ZZLorg/mapsforge/map/layer/hills/HillsRenderConfig;)V

    iput-object v10, v0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->databaseRenderer:Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;

    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, v0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->textScale:F

    return-void
.end method


# virtual methods
.method protected compileRenderTheme()V
    .registers 5

    new-instance v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->xmlRenderTheme:Lorg/mapsforge/map/rendertheme/XmlRenderTheme;

    iget-object v3, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-direct {v0, v1, v2, v3}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/rendertheme/XmlRenderTheme;Lorg/mapsforge/map/model/DisplayModel;)V

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    new-instance v0, Ljava/lang/Thread;

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    return-void
.end method

.method protected bridge synthetic createJob(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/queue/Job;
    .registers 2

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->createJob(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/renderer/RendererJob;

    move-result-object p1

    return-object p1
.end method

.method protected createJob(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/renderer/RendererJob;
    .registers 11

    new-instance v8, Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    iget-object v3, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    iget-object v4, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget v5, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->textScale:F

    iget-boolean v6, p0, Lorg/mapsforge/map/layer/TileLayer;->isTransparent:Z

    const/4 v7, 0x0

    move-object v0, v8

    move-object v1, p1

    invoke-direct/range {v0 .. v7}, Lorg/mapsforge/map/layer/renderer/RendererJob;-><init>(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;Lorg/mapsforge/map/model/DisplayModel;FZZ)V

    return-object v8
.end method

.method public getLabelStore()Lorg/mapsforge/map/layer/labels/LabelStore;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->tileBasedLabelStore:Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;

    return-object v0
.end method

.method public getMapDataStore()Lorg/mapsforge/map/datastore/MapDataStore;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    return-object v0
.end method

.method public getRenderThemeFuture()Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    return-object v0
.end method

.method public getTextScale()F
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->textScale:F

    return v0
.end method

.method protected isTileStale(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/graphics/TileBitmap;)Z
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->getDataTimestamp(Lorg/mapsforge/core/model/Tile;)J

    move-result-wide v0

    invoke-interface {p2}, Lorg/mapsforge/core/graphics/TileBitmap;->getTimestamp()J

    move-result-wide p1

    cmp-long v2, v0, p1

    if-lez v2, :cond_10

    const/4 p1, 0x1

    goto :goto_11

    :cond_10
    const/4 p1, 0x0

    :goto_11
    return p1
.end method

.method protected onAdd()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->mapWorkerPool:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->start()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/TileLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    if-eqz v0, :cond_c

    invoke-interface {v0, p0}, Lorg/mapsforge/map/model/common/ObservableInterface;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    :cond_c
    invoke-super {p0}, Lorg/mapsforge/map/layer/Layer;->onAdd()V

    return-void
.end method

.method public onChange()V
    .registers 1

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/Layer;->requestRedraw()V

    return-void
.end method

.method public onDestroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    if-eqz v0, :cond_7

    invoke-virtual {v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;->decrementRefCount()V

    :cond_7
    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v0}, Lorg/mapsforge/map/datastore/MapDataStore;->close()V

    invoke-super {p0}, Lorg/mapsforge/map/layer/Layer;->onDestroy()V

    return-void
.end method

.method protected onRemove()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->mapWorkerPool:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->stop()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/TileLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    if-eqz v0, :cond_c

    invoke-interface {v0, p0}, Lorg/mapsforge/map/model/common/ObservableInterface;->removeObserver(Lorg/mapsforge/map/model/common/Observer;)V

    :cond_c
    invoke-super {p0}, Lorg/mapsforge/map/layer/Layer;->onRemove()V

    return-void
.end method

.method protected bridge synthetic retrieveLabelsOnly(Lorg/mapsforge/map/layer/queue/Job;)V
    .registers 2

    check-cast p1, Lorg/mapsforge/map/layer/renderer/RendererJob;

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->retrieveLabelsOnly(Lorg/mapsforge/map/layer/renderer/RendererJob;)V

    return-void
.end method

.method protected retrieveLabelsOnly(Lorg/mapsforge/map/layer/renderer/RendererJob;)V
    .registers 4

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/TileLayer;->hasJobQueue:Z

    if-eqz v0, :cond_18

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->tileBasedLabelStore:Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;

    if-eqz v0, :cond_18

    iget-object v1, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/layer/labels/TileBasedLabelStore;->requiresTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v0

    if-eqz v0, :cond_18

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/renderer/RendererJob;->setRetrieveLabelsOnly()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/TileLayer;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/layer/queue/JobQueue;->add(Lorg/mapsforge/map/layer/queue/Job;)V

    :cond_18
    return-void
.end method

.method public declared-synchronized setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 5

    monitor-enter p0

    :try_start_1
    invoke-super {p0, p1}, Lorg/mapsforge/map/layer/TileLayer;->setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V

    if-eqz p1, :cond_20

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->compileRenderTheme()V

    iget-object p1, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->mapWorkerPool:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    if-nez p1, :cond_1a

    new-instance p1, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    iget-object v0, p0, Lorg/mapsforge/map/layer/TileLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    iget-object v1, p0, Lorg/mapsforge/map/layer/TileLayer;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->databaseRenderer:Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;

    invoke-direct {p1, v0, v1, v2, p0}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;-><init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/layer/queue/JobQueue;Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;Lorg/mapsforge/map/layer/Layer;)V

    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->mapWorkerPool:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    :cond_1a
    iget-object p1, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->mapWorkerPool:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->start()V

    goto :goto_27

    :cond_20
    iget-object p1, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->mapWorkerPool:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    if-eqz p1, :cond_27

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->stop()V
    :try_end_27
    .catchall {:try_start_1 .. :try_end_27} :catchall_29

    :cond_27
    :goto_27
    monitor-exit p0

    return-void

    :catchall_29
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public setTextScale(F)V
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->textScale:F

    return-void
.end method

.method public setXmlRenderTheme(Lorg/mapsforge/map/rendertheme/XmlRenderTheme;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->xmlRenderTheme:Lorg/mapsforge/map/rendertheme/XmlRenderTheme;

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->compileRenderTheme()V

    return-void
.end method
