.class public Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/labels/LabelStore;


# instance fields
.field final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field final renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

.field final standardRenderer:Lorg/mapsforge/map/layer/renderer/StandardRenderer;

.field final textScale:F


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;FLorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p3, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->textScale:F

    iput-object p2, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    new-instance p2, Lorg/mapsforge/map/layer/renderer/StandardRenderer;

    const/4 p3, 0x1

    invoke-direct {p2, p1, p5, p3}, Lorg/mapsforge/map/layer/renderer/StandardRenderer;-><init>(Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/core/graphics/GraphicFactory;Z)V

    iput-object p2, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->standardRenderer:Lorg/mapsforge/map/layer/renderer/StandardRenderer;

    iput-object p4, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    return-void
.end method


# virtual methods
.method public clear()V
    .registers 1

    return-void
.end method

.method public getVersion()I
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method public declared-synchronized getVisibleItems(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Ljava/util/List;
    .registers 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/core/model/Tile;",
            "Lorg/mapsforge/core/model/Tile;",
            ")",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/mapelements/MapElementContainer;",
            ">;"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    new-instance v8, Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v0, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->standardRenderer:Lorg/mapsforge/map/layer/renderer/StandardRenderer;

    iget-object v2, v0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    iget-object v3, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    iget-object v4, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget v5, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->textScale:F

    const/4 v6, 0x1

    const/4 v7, 0x1

    move-object v0, v8

    move-object v1, p1

    invoke-direct/range {v0 .. v7}, Lorg/mapsforge/map/layer/renderer/RendererJob;-><init>(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;Lorg/mapsforge/map/model/DisplayModel;FZZ)V

    new-instance v0, Lorg/mapsforge/map/rendertheme/RenderContext;

    new-instance v1, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    iget-object v2, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->standardRenderer:Lorg/mapsforge/map/layer/renderer/StandardRenderer;

    iget-object v2, v2, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-direct {v1, v2}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;)V

    invoke-direct {v0, v8, v1}, Lorg/mapsforge/map/rendertheme/RenderContext;-><init>(Lorg/mapsforge/map/layer/renderer/RendererJob;Lorg/mapsforge/map/layer/renderer/CanvasRasterer;)V

    iget-object v1, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->standardRenderer:Lorg/mapsforge/map/layer/renderer/StandardRenderer;

    iget-object v1, v1, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1, p1, p2}, Lorg/mapsforge/map/datastore/MapDataStore;->readLabels(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object v1

    if-nez v1, :cond_33

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V
    :try_end_31
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_31} :catch_94
    .catchall {:try_start_1 .. :try_end_31} :catchall_92

    monitor-exit p0

    return-object p1

    :cond_33
    :try_start_33
    iget-object v2, v1, Lorg/mapsforge/map/datastore/MapReadResult;->pointOfInterests:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_39
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_5a

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/map/datastore/PointOfInterest;

    iget-byte v4, v3, Lorg/mapsforge/map/datastore/PointOfInterest;->layer:B

    invoke-virtual {v0, v4}, Lorg/mapsforge/map/rendertheme/RenderContext;->setDrawingLayers(B)V

    iget-object v4, v0, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v4, v4, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    invoke-virtual {v4}, Ljava/util/concurrent/FutureTask;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    iget-object v5, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->standardRenderer:Lorg/mapsforge/map/layer/renderer/StandardRenderer;

    invoke-virtual {v4, v5, v0, v3}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->matchNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/PointOfInterest;)V

    goto :goto_39

    :cond_5a
    iget-object v1, v1, Lorg/mapsforge/map/datastore/MapReadResult;->ways:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_60
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_8e

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/datastore/Way;

    new-instance v3, Lorg/mapsforge/map/layer/renderer/PolylineContainer;

    invoke-direct {v3, v2, p1, p2}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;-><init>(Lorg/mapsforge/map/datastore/Way;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)V

    invoke-virtual {v3}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getLayer()B

    move-result v2

    invoke-virtual {v0, v2}, Lorg/mapsforge/map/rendertheme/RenderContext;->setDrawingLayers(B)V

    invoke-virtual {v3}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->isClosedWay()Z

    move-result v2

    if-eqz v2, :cond_86

    iget-object v2, v0, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    iget-object v4, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->standardRenderer:Lorg/mapsforge/map/layer/renderer/StandardRenderer;

    invoke-virtual {v2, v4, v0, v3}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->matchClosedWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    goto :goto_60

    :cond_86
    iget-object v2, v0, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    iget-object v4, p0, Lorg/mapsforge/map/layer/labels/MapDataStoreLabelStore;->standardRenderer:Lorg/mapsforge/map/layer/renderer/StandardRenderer;

    invoke-virtual {v2, v4, v0, v3}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->matchLinearWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    goto :goto_60

    :cond_8e
    iget-object p1, v0, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;
    :try_end_90
    .catch Ljava/lang/Exception; {:try_start_33 .. :try_end_90} :catch_94
    .catchall {:try_start_33 .. :try_end_90} :catchall_92

    monitor-exit p0

    return-object p1

    :catchall_92
    move-exception p1

    goto :goto_9b

    :catch_94
    :try_start_94
    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V
    :try_end_99
    .catchall {:try_start_94 .. :try_end_99} :catchall_92

    monitor-exit p0

    return-object p1

    :goto_9b
    monitor-exit p0

    throw p1
.end method
