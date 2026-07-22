.class public Lorg/mapsforge/map/view/FrameBufferHA;
.super Lorg/mapsforge/map/view/FrameBuffer;
.source "SourceFile"


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;


# instance fields
.field private allowBitmapSwap:Z

.field private final lmBitmapLock:Ljava/lang/Object;

.field private lmMapPosition:Lorg/mapsforge/core/model/MapPosition;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/view/FrameBufferHA;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/view/FrameBufferHA;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/model/FrameBufferModel;Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 4

    invoke-direct {p0, p1, p2, p3}, Lorg/mapsforge/map/view/FrameBuffer;-><init>(Lorg/mapsforge/map/model/FrameBufferModel;Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/core/graphics/GraphicFactory;)V

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/view/FrameBufferHA;->allowBitmapSwap:Z

    new-instance p1, Ljava/lang/Object;

    invoke-direct {p1}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/view/FrameBufferHA;->lmBitmapLock:Ljava/lang/Object;

    return-void
.end method

.method private freeLmBitmap(Lorg/mapsforge/core/model/MapPosition;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferHA;->lmBitmapLock:Ljava/lang/Object;

    monitor-enter v0

    :try_start_3
    iput-object p1, p0, Lorg/mapsforge/map/view/FrameBufferHA;->lmMapPosition:Lorg/mapsforge/core/model/MapPosition;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/view/FrameBufferHA;->allowBitmapSwap:Z

    monitor-exit v0

    return-void

    :catchall_a
    move-exception p1

    monitor-exit v0
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_a

    throw p1
.end method

.method private lockLmBitmap()V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferHA;->lmBitmapLock:Ljava/lang/Object;

    monitor-enter v0

    :try_start_3
    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->lmBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v1, :cond_18

    iget-boolean v1, p0, Lorg/mapsforge/map/view/FrameBufferHA;->allowBitmapSwap:Z
    :try_end_9
    .catchall {:try_start_3 .. :try_end_9} :catchall_1d

    if-eqz v1, :cond_18

    :try_start_b
    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferHA;->lmBitmapLock:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->wait()V
    :try_end_10
    .catch Ljava/lang/InterruptedException; {:try_start_b .. :try_end_10} :catch_11
    .catchall {:try_start_b .. :try_end_10} :catchall_1d

    goto :goto_18

    :catch_11
    :try_start_11
    sget-object v1, Lorg/mapsforge/map/view/FrameBufferHA;->LOGGER:Ljava/util/logging/Logger;

    const-string v2, "FrameBufferHA interrupted"

    invoke-virtual {v1, v2}, Ljava/util/logging/Logger;->fine(Ljava/lang/String;)V

    :cond_18
    :goto_18
    const/4 v1, 0x0

    iput-boolean v1, p0, Lorg/mapsforge/map/view/FrameBufferHA;->allowBitmapSwap:Z

    monitor-exit v0

    return-void

    :catchall_1d
    move-exception v1

    monitor-exit v0
    :try_end_1f
    .catchall {:try_start_11 .. :try_end_1f} :catchall_1d

    throw v1
.end method

.method private swapBitmaps()V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferHA;->lmBitmapLock:Ljava/lang/Object;

    monitor-enter v0

    :try_start_3
    iget-boolean v1, p0, Lorg/mapsforge/map/view/FrameBufferHA;->allowBitmapSwap:Z

    if-eqz v1, :cond_1e

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->odBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iget-object v2, p0, Lorg/mapsforge/map/view/FrameBuffer;->lmBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iput-object v2, p0, Lorg/mapsforge/map/view/FrameBuffer;->odBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iput-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->lmBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

    iget-object v2, p0, Lorg/mapsforge/map/view/FrameBufferHA;->lmMapPosition:Lorg/mapsforge/core/model/MapPosition;

    invoke-virtual {v1, v2}, Lorg/mapsforge/map/model/FrameBufferModel;->setMapPosition(Lorg/mapsforge/core/model/MapPosition;)V

    const/4 v1, 0x0

    iput-boolean v1, p0, Lorg/mapsforge/map/view/FrameBufferHA;->allowBitmapSwap:Z

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferHA;->lmBitmapLock:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notify()V

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
.method public draw(Lorg/mapsforge/core/graphics/GraphicContext;)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/DisplayModel;->getBackgroundColor()I

    move-result v0

    invoke-interface {p1, v0}, Lorg/mapsforge/core/graphics/GraphicContext;->fillColor(I)V

    invoke-direct {p0}, Lorg/mapsforge/map/view/FrameBufferHA;->swapBitmaps()V

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->odBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v0, :cond_15

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    invoke-interface {p1, v0, v1}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/core/graphics/Matrix;)V

    :cond_15
    return-void
.end method

.method public frameFinished(Lorg/mapsforge/core/model/MapPosition;)V
    .registers 2

    invoke-direct {p0, p1}, Lorg/mapsforge/map/view/FrameBufferHA;->freeLmBitmap(Lorg/mapsforge/core/model/MapPosition;)V

    return-void
.end method

.method public getDrawingBitmap()Lorg/mapsforge/core/graphics/Bitmap;
    .registers 2

    invoke-direct {p0}, Lorg/mapsforge/map/view/FrameBufferHA;->lockLmBitmap()V

    invoke-super {p0}, Lorg/mapsforge/map/view/FrameBuffer;->getDrawingBitmap()Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method
