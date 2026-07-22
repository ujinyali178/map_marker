.class public Lorg/mapsforge/map/view/FrameBufferHA2;
.super Lorg/mapsforge/map/view/FrameBuffer;
.source "SourceFile"


# instance fields
.field private final allowSwap:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

.field private final lmBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

.field private lmMapPosition:Lorg/mapsforge/core/model/MapPosition;

.field private final odBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/model/FrameBufferModel;Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 4

    invoke-direct {p0, p1, p2, p3}, Lorg/mapsforge/map/view/FrameBuffer;-><init>(Lorg/mapsforge/map/model/FrameBufferModel;Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/core/graphics/GraphicFactory;)V

    new-instance p1, Lorg/mapsforge/map/view/FrameBufferBitmap;

    invoke-direct {p1}, Lorg/mapsforge/map/view/FrameBufferBitmap;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->lmBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

    new-instance p1, Lorg/mapsforge/map/view/FrameBufferBitmap;

    invoke-direct {p1}, Lorg/mapsforge/map/view/FrameBufferBitmap;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->odBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

    new-instance p1, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    invoke-direct {p1}, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->allowSwap:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    invoke-virtual {p1}, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->disable()V

    return-void
.end method

.method private swapBitmaps()V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->allowSwap:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    monitor-enter v0

    :try_start_3
    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->allowSwap:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    invoke-virtual {v1}, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_1e

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->odBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

    iget-object v2, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->lmBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

    invoke-static {v1, v2}, Lorg/mapsforge/map/view/FrameBufferBitmap;->swap(Lorg/mapsforge/map/view/FrameBufferBitmap;Lorg/mapsforge/map/view/FrameBufferBitmap;)V

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

    iget-object v2, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->lmMapPosition:Lorg/mapsforge/core/model/MapPosition;

    invoke-virtual {v1, v2}, Lorg/mapsforge/map/model/FrameBufferModel;->setMapPosition(Lorg/mapsforge/core/model/MapPosition;)V

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->allowSwap:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    invoke-virtual {v1}, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->disable()V

    :cond_1e
    monitor-exit v0

    return-void

    :catchall_20
    move-exception v1

    monitor-exit v0
    :try_end_22
    .catchall {:try_start_3 .. :try_end_22} :catchall_20

    throw v1
.end method


# virtual methods
.method public adjustMatrix(FFFLorg/mapsforge/core/model/Dimension;FF)V
    .registers 9

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    monitor-enter v0

    :try_start_3
    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->dimension:Lorg/mapsforge/core/model/Dimension;

    if-nez v1, :cond_9

    monitor-exit v0

    return-void

    :cond_9
    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    invoke-interface {v1}, Lorg/mapsforge/core/graphics/Matrix;->reset()V

    invoke-virtual {p0, p4}, Lorg/mapsforge/map/view/FrameBuffer;->centerFrameBufferToMapView(Lorg/mapsforge/core/model/Dimension;)V

    const/4 p4, 0x0

    cmpl-float v1, p5, p4

    if-nez v1, :cond_1f

    cmpl-float p4, p6, p4

    if-nez p4, :cond_1f

    iget-object p4, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    invoke-interface {p4, p1, p2}, Lorg/mapsforge/core/graphics/Matrix;->translate(FF)V

    :cond_1f
    invoke-virtual {p0, p3, p5, p6}, Lorg/mapsforge/map/view/FrameBuffer;->scale(FFF)V

    monitor-exit v0

    return-void

    :catchall_24
    move-exception p1

    monitor-exit v0
    :try_end_26
    .catchall {:try_start_3 .. :try_end_26} :catchall_24

    throw p1
.end method

.method public declared-synchronized destroy()V
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->odBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

    invoke-virtual {v0}, Lorg/mapsforge/map/view/FrameBufferBitmap;->destroy()V

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->lmBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

    invoke-virtual {v0}, Lorg/mapsforge/map/view/FrameBufferBitmap;->destroy()V
    :try_end_b
    .catchall {:try_start_1 .. :try_end_b} :catchall_d

    monitor-exit p0

    return-void

    :catchall_d
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public draw(Lorg/mapsforge/core/graphics/GraphicContext;)V
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/DisplayModel;->getBackgroundColor()I

    move-result v0

    invoke-interface {p1, v0}, Lorg/mapsforge/core/graphics/GraphicContext;->fillColor(I)V

    invoke-direct {p0}, Lorg/mapsforge/map/view/FrameBufferHA2;->swapBitmaps()V

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    monitor-enter v0

    :try_start_f
    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->odBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

    invoke-virtual {v1}, Lorg/mapsforge/map/view/FrameBufferBitmap;->lock()Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v1

    if-eqz v1, :cond_1c

    iget-object v2, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    invoke-interface {p1, v1, v2}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/core/graphics/Matrix;)V

    :cond_1c
    monitor-exit v0
    :try_end_1d
    .catchall {:try_start_f .. :try_end_1d} :catchall_23

    iget-object p1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->odBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

    invoke-virtual {p1}, Lorg/mapsforge/map/view/FrameBufferBitmap;->release()V

    return-void

    :catchall_23
    move-exception p1

    :try_start_24
    monitor-exit v0
    :try_end_25
    .catchall {:try_start_24 .. :try_end_25} :catchall_23

    throw p1
.end method

.method public frameFinished(Lorg/mapsforge/core/model/MapPosition;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->allowSwap:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    monitor-enter v0

    :try_start_3
    iput-object p1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->lmMapPosition:Lorg/mapsforge/core/model/MapPosition;

    iget-object p1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->lmBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

    invoke-virtual {p1}, Lorg/mapsforge/map/view/FrameBufferBitmap;->release()V

    iget-object p1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->allowSwap:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    invoke-virtual {p1}, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->enable()V

    monitor-exit v0

    return-void

    :catchall_11
    move-exception p1

    monitor-exit v0
    :try_end_13
    .catchall {:try_start_3 .. :try_end_13} :catchall_11

    throw p1
.end method

.method public getDrawingBitmap()Lorg/mapsforge/core/graphics/Bitmap;
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->allowSwap:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    monitor-enter v0

    :try_start_3
    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->allowSwap:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    invoke-virtual {v1}, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->waitDisabled()V

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->lmBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

    invoke-virtual {v1}, Lorg/mapsforge/map/view/FrameBufferBitmap;->lock()Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v1

    if-eqz v1, :cond_19

    iget-object v2, p0, Lorg/mapsforge/map/view/FrameBuffer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getBackgroundColor()I

    move-result v2

    invoke-interface {v1, v2}, Lorg/mapsforge/core/graphics/Bitmap;->setBackgroundColor(I)V

    :cond_19
    monitor-exit v0

    return-object v1

    :catchall_1b
    move-exception v1

    monitor-exit v0
    :try_end_1d
    .catchall {:try_start_3 .. :try_end_1d} :catchall_1b

    throw v1
.end method

.method public setDimension(Lorg/mapsforge/core/model/Dimension;)V
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    monitor-enter v0

    :try_start_3
    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->dimension:Lorg/mapsforge/core/model/Dimension;

    if-eqz v1, :cond_f

    invoke-virtual {v1, p1}, Lorg/mapsforge/core/model/Dimension;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_f

    monitor-exit v0

    return-void

    :cond_f
    iput-object p1, p0, Lorg/mapsforge/map/view/FrameBuffer;->dimension:Lorg/mapsforge/core/model/Dimension;

    monitor-exit v0
    :try_end_12
    .catchall {:try_start_3 .. :try_end_12} :catchall_35

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->allowSwap:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    monitor-enter v1

    :try_start_15
    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->odBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

    iget-object v2, p0, Lorg/mapsforge/map/view/FrameBuffer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v3, p0, Lorg/mapsforge/map/view/FrameBuffer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v3}, Lorg/mapsforge/map/model/DisplayModel;->getBackgroundColor()I

    move-result v3

    const/4 v4, 0x0

    invoke-virtual {v0, v2, p1, v3, v4}, Lorg/mapsforge/map/view/FrameBufferBitmap;->create(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/core/model/Dimension;IZ)V

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferHA2;->lmBitmap:Lorg/mapsforge/map/view/FrameBufferBitmap;

    iget-object v2, p0, Lorg/mapsforge/map/view/FrameBuffer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v3, p0, Lorg/mapsforge/map/view/FrameBuffer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v3}, Lorg/mapsforge/map/model/DisplayModel;->getBackgroundColor()I

    move-result v3

    invoke-virtual {v0, v2, p1, v3, v4}, Lorg/mapsforge/map/view/FrameBufferBitmap;->create(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/core/model/Dimension;IZ)V

    monitor-exit v1

    return-void

    :catchall_32
    move-exception p1

    monitor-exit v1
    :try_end_34
    .catchall {:try_start_15 .. :try_end_34} :catchall_32

    throw p1

    :catchall_35
    move-exception p1

    :try_start_36
    monitor-exit v0
    :try_end_37
    .catchall {:try_start_36 .. :try_end_37} :catchall_35

    throw p1
.end method
