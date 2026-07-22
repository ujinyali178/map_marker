.class public Lorg/mapsforge/map/layer/LayerManager;
.super Lorg/mapsforge/map/util/PausableThread;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/Redrawer;


# static fields
.field private static final MILLISECONDS_PER_FRAME:I = 0x1e


# instance fields
.field private final drawingCanvas:Lorg/mapsforge/core/graphics/Canvas;

.field private final layers:Lorg/mapsforge/map/layer/Layers;

.field private final mapView:Lorg/mapsforge/map/view/MapView;

.field private final mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

.field private redrawNeeded:Z


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/view/MapView;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 4

    invoke-direct {p0}, Lorg/mapsforge/map/util/PausableThread;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/LayerManager;->mapView:Lorg/mapsforge/map/view/MapView;

    iput-object p2, p0, Lorg/mapsforge/map/layer/LayerManager;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {p3}, Lorg/mapsforge/core/graphics/GraphicFactory;->createCanvas()Lorg/mapsforge/core/graphics/Canvas;

    move-result-object p2

    iput-object p2, p0, Lorg/mapsforge/map/layer/LayerManager;->drawingCanvas:Lorg/mapsforge/core/graphics/Canvas;

    new-instance p2, Lorg/mapsforge/map/layer/Layers;

    invoke-interface {p1}, Lorg/mapsforge/map/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object p1

    iget-object p1, p1, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-direct {p2, p0, p1}, Lorg/mapsforge/map/layer/Layers;-><init>(Lorg/mapsforge/map/layer/Redrawer;Lorg/mapsforge/map/model/DisplayModel;)V

    iput-object p2, p0, Lorg/mapsforge/map/layer/LayerManager;->layers:Lorg/mapsforge/map/layer/Layers;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/util/PausableThread;->waitForWork:Z

    return-void
.end method


# virtual methods
.method protected afterRun()V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/layer/LayerManager;->layers:Lorg/mapsforge/map/layer/Layers;

    monitor-enter v0

    :try_start_3
    iget-object v1, p0, Lorg/mapsforge/map/layer/LayerManager;->layers:Lorg/mapsforge/map/layer/Layers;

    invoke-virtual {v1}, Lorg/mapsforge/map/layer/Layers;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_9
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_19

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/layer/Layer;

    invoke-virtual {v2}, Lorg/mapsforge/map/layer/Layer;->onDestroy()V

    goto :goto_9

    :cond_19
    monitor-exit v0
    :try_end_1a
    .catchall {:try_start_3 .. :try_end_1a} :catchall_20

    iget-object v0, p0, Lorg/mapsforge/map/layer/LayerManager;->drawingCanvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Canvas;->destroy()V

    return-void

    :catchall_20
    move-exception v1

    :try_start_21
    monitor-exit v0
    :try_end_22
    .catchall {:try_start_21 .. :try_end_22} :catchall_20

    throw v1
.end method

.method protected doWork()V
    .registers 12

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    const/4 v2, 0x0

    iput-boolean v2, p0, Lorg/mapsforge/map/layer/LayerManager;->redrawNeeded:Z

    iget-object v2, p0, Lorg/mapsforge/map/layer/LayerManager;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v2}, Lorg/mapsforge/map/view/MapView;->getFrameBuffer()Lorg/mapsforge/map/view/FrameBuffer;

    move-result-object v2

    invoke-virtual {v2}, Lorg/mapsforge/map/view/FrameBuffer;->getDrawingBitmap()Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v3

    if-eqz v3, :cond_74

    iget-object v4, p0, Lorg/mapsforge/map/layer/LayerManager;->drawingCanvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {v4, v3}, Lorg/mapsforge/core/graphics/Canvas;->setBitmap(Lorg/mapsforge/core/graphics/Bitmap;)V

    iget-object v3, p0, Lorg/mapsforge/map/layer/LayerManager;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v3}, Lorg/mapsforge/map/model/IMapViewPosition;->getMapPosition()Lorg/mapsforge/core/model/MapPosition;

    move-result-object v3

    iget-object v4, p0, Lorg/mapsforge/map/layer/LayerManager;->drawingCanvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {v4}, Lorg/mapsforge/core/graphics/Canvas;->getDimension()Lorg/mapsforge/core/model/Dimension;

    move-result-object v4

    iget-object v5, p0, Lorg/mapsforge/map/layer/LayerManager;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v5}, Lorg/mapsforge/map/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v5

    iget-object v5, v5, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v5}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v5

    invoke-static {v3, v4, v5}, Lorg/mapsforge/map/util/MapPositionUtil;->getBoundingBox(Lorg/mapsforge/core/model/MapPosition;Lorg/mapsforge/core/model/Dimension;I)Lorg/mapsforge/core/model/BoundingBox;

    move-result-object v6

    invoke-static {v3, v4, v5}, Lorg/mapsforge/map/util/MapPositionUtil;->getTopLeftPoint(Lorg/mapsforge/core/model/MapPosition;Lorg/mapsforge/core/model/Dimension;I)Lorg/mapsforge/core/model/Point;

    move-result-object v4

    iget-object v5, p0, Lorg/mapsforge/map/layer/LayerManager;->layers:Lorg/mapsforge/map/layer/Layers;

    monitor-enter v5

    :try_start_3b
    iget-object v7, p0, Lorg/mapsforge/map/layer/LayerManager;->layers:Lorg/mapsforge/map/layer/Layers;

    invoke-virtual {v7}, Lorg/mapsforge/map/layer/Layers;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_41
    :goto_41
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_5b

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lorg/mapsforge/map/layer/Layer;

    invoke-virtual {v8}, Lorg/mapsforge/map/layer/Layer;->isVisible()Z

    move-result v9

    if-eqz v9, :cond_41

    iget-byte v9, v3, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    iget-object v10, p0, Lorg/mapsforge/map/layer/LayerManager;->drawingCanvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-virtual {v8, v6, v9, v10, v4}, Lorg/mapsforge/map/layer/Layer;->draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V

    goto :goto_41

    :cond_5b
    monitor-exit v5
    :try_end_5c
    .catchall {:try_start_3b .. :try_end_5c} :catchall_71

    iget-object v4, p0, Lorg/mapsforge/map/layer/LayerManager;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v4}, Lorg/mapsforge/map/model/IMapViewPosition;->animationInProgress()Z

    move-result v4

    if-nez v4, :cond_6d

    invoke-virtual {v2, v3}, Lorg/mapsforge/map/view/FrameBuffer;->frameFinished(Lorg/mapsforge/core/model/MapPosition;)V

    iget-object v2, p0, Lorg/mapsforge/map/layer/LayerManager;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v2}, Lorg/mapsforge/map/view/MapView;->repaint()V

    goto :goto_74

    :cond_6d
    const/4 v2, 0x1

    iput-boolean v2, p0, Lorg/mapsforge/map/layer/LayerManager;->redrawNeeded:Z

    goto :goto_74

    :catchall_71
    move-exception v0

    :try_start_72
    monitor-exit v5
    :try_end_73
    .catchall {:try_start_72 .. :try_end_73} :catchall_71

    throw v0

    :cond_74
    :goto_74
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    sub-long/2addr v2, v0

    const-wide/32 v0, 0xf4240

    div-long/2addr v2, v0

    const-wide/16 v0, 0x1e

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x1

    cmp-long v4, v0, v2

    if-lez v4, :cond_8f

    invoke-virtual {p0}, Ljava/lang/Thread;->isInterrupted()Z

    move-result v2

    if-nez v2, :cond_8f

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V

    :cond_8f
    return-void
.end method

.method public getLayers()Lorg/mapsforge/map/layer/Layers;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/LayerManager;->layers:Lorg/mapsforge/map/layer/Layers;

    return-object v0
.end method

.method protected getThreadPriority()Lorg/mapsforge/map/util/PausableThread$ThreadPriority;
    .registers 2

    sget-object v0, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->NORMAL:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    return-object v0
.end method

.method protected hasWork()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/LayerManager;->redrawNeeded:Z

    return v0
.end method

.method public redrawLayers()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/layer/LayerManager;->redrawNeeded:Z

    monitor-enter p0

    :try_start_4
    invoke-virtual {p0}, Ljava/lang/Object;->notify()V

    monitor-exit p0

    return-void

    :catchall_9
    move-exception v0

    monitor-exit p0
    :try_end_b
    .catchall {:try_start_4 .. :try_end_b} :catchall_9

    throw v0
.end method
