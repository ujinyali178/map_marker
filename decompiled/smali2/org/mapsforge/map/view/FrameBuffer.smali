.class public Lorg/mapsforge/map/view/FrameBuffer;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static final IS_TRANSPARENT:Z


# instance fields
.field dimension:Lorg/mapsforge/core/model/Dimension;

.field final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field final frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

.field final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field lmBitmap:Lorg/mapsforge/core/graphics/Bitmap;

.field final matrix:Lorg/mapsforge/core/graphics/Matrix;

.field odBitmap:Lorg/mapsforge/core/graphics/Bitmap;


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/model/FrameBufferModel;Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/view/FrameBuffer;->frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

    iput-object p2, p0, Lorg/mapsforge/map/view/FrameBuffer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iput-object p3, p0, Lorg/mapsforge/map/view/FrameBuffer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-interface {p3}, Lorg/mapsforge/core/graphics/GraphicFactory;->createMatrix()Lorg/mapsforge/core/graphics/Matrix;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    return-void
.end method

.method private destroyBitmaps()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->odBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    const/4 v1, 0x0

    if-eqz v0, :cond_a

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    iput-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->odBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    :cond_a
    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->lmBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v0, :cond_13

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    iput-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->lmBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    :cond_13
    return-void
.end method


# virtual methods
.method public declared-synchronized adjustMatrix(FFFLorg/mapsforge/core/model/Dimension;FF)V
    .registers 8

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->dimension:Lorg/mapsforge/core/model/Dimension;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_22

    if-nez v0, :cond_7

    monitor-exit p0

    return-void

    :cond_7
    :try_start_7
    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Matrix;->reset()V

    invoke-virtual {p0, p4}, Lorg/mapsforge/map/view/FrameBuffer;->centerFrameBufferToMapView(Lorg/mapsforge/core/model/Dimension;)V

    const/4 p4, 0x0

    cmpl-float v0, p5, p4

    if-nez v0, :cond_1d

    cmpl-float p4, p6, p4

    if-nez p4, :cond_1d

    iget-object p4, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    invoke-interface {p4, p1, p2}, Lorg/mapsforge/core/graphics/Matrix;->translate(FF)V

    :cond_1d
    invoke-virtual {p0, p3, p5, p6}, Lorg/mapsforge/map/view/FrameBuffer;->scale(FFF)V
    :try_end_20
    .catchall {:try_start_7 .. :try_end_20} :catchall_22

    monitor-exit p0

    return-void

    :catchall_22
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method centerFrameBufferToMapView(Lorg/mapsforge/core/model/Dimension;)V
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->dimension:Lorg/mapsforge/core/model/Dimension;

    iget v1, v0, Lorg/mapsforge/core/model/Dimension;->width:I

    iget v2, p1, Lorg/mapsforge/core/model/Dimension;->width:I

    sub-int/2addr v1, v2

    int-to-float v1, v1

    const/high16 v2, -0x40000000    # -2.0f

    div-float/2addr v1, v2

    iget v0, v0, Lorg/mapsforge/core/model/Dimension;->height:I

    iget p1, p1, Lorg/mapsforge/core/model/Dimension;->height:I

    sub-int/2addr v0, p1

    int-to-float p1, v0

    div-float/2addr p1, v2

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    invoke-interface {v0, v1, p1}, Lorg/mapsforge/core/graphics/Matrix;->translate(FF)V

    return-void
.end method

.method public declared-synchronized destroy()V
    .registers 2

    monitor-enter p0

    :try_start_1
    invoke-direct {p0}, Lorg/mapsforge/map/view/FrameBuffer;->destroyBitmaps()V
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_6

    monitor-exit p0

    return-void

    :catchall_6
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized draw(Lorg/mapsforge/core/graphics/GraphicContext;)V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/DisplayModel;->getBackgroundColor()I

    move-result v0

    invoke-interface {p1, v0}, Lorg/mapsforge/core/graphics/GraphicContext;->fillColor(I)V

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->odBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v0, :cond_13

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    invoke-interface {p1, v0, v1}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/core/graphics/Matrix;)V
    :try_end_13
    .catchall {:try_start_1 .. :try_end_13} :catchall_15

    :cond_13
    monitor-exit p0

    return-void

    :catchall_15
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public frameFinished(Lorg/mapsforge/core/model/MapPosition;)V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->odBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->lmBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iput-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->odBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iput-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->lmBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    monitor-exit p0
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_10

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/model/FrameBufferModel;->setMapPosition(Lorg/mapsforge/core/model/MapPosition;)V

    return-void

    :catchall_10
    move-exception p1

    :try_start_11
    monitor-exit p0
    :try_end_12
    .catchall {:try_start_11 .. :try_end_12} :catchall_10

    throw p1
.end method

.method public declared-synchronized getDimension()Lorg/mapsforge/core/model/Dimension;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->dimension:Lorg/mapsforge/core/model/Dimension;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDrawingBitmap()Lorg/mapsforge/core/graphics/Bitmap;
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->lmBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v0, :cond_e

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBuffer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getBackgroundColor()I

    move-result v1

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Bitmap;->setBackgroundColor(I)V

    :cond_e
    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->lmBitmap:Lorg/mapsforge/core/graphics/Bitmap;
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_12

    monitor-exit p0

    return-object v0

    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method scale(FFF)V
    .registers 9

    const/high16 v0, 0x3f800000    # 1.0f

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_1b

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->dimension:Lorg/mapsforge/core/model/Dimension;

    invoke-virtual {v0}, Lorg/mapsforge/core/model/Dimension;->getCenter()Lorg/mapsforge/core/model/Point;

    move-result-object v0

    float-to-double v1, p2

    iget-wide v3, v0, Lorg/mapsforge/core/model/Point;->x:D

    add-double/2addr v1, v3

    double-to-float p2, v1

    float-to-double v1, p3

    iget-wide v3, v0, Lorg/mapsforge/core/model/Point;->y:D

    add-double/2addr v1, v3

    double-to-float p3, v1

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    invoke-interface {v0, p1, p1, p2, p3}, Lorg/mapsforge/core/graphics/Matrix;->scale(FFFF)V

    :cond_1b
    return-void
.end method

.method public declared-synchronized setDimension(Lorg/mapsforge/core/model/Dimension;)V
    .registers 6

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->dimension:Lorg/mapsforge/core/model/Dimension;

    if-eqz v0, :cond_d

    invoke-virtual {v0, p1}, Lorg/mapsforge/core/model/Dimension;->equals(Ljava/lang/Object;)Z

    move-result v0
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_31

    if-eqz v0, :cond_d

    monitor-exit p0

    return-void

    :cond_d
    :try_start_d
    iput-object p1, p0, Lorg/mapsforge/map/view/FrameBuffer;->dimension:Lorg/mapsforge/core/model/Dimension;

    invoke-direct {p0}, Lorg/mapsforge/map/view/FrameBuffer;->destroyBitmaps()V

    iget v0, p1, Lorg/mapsforge/core/model/Dimension;->width:I

    if-lez v0, :cond_2f

    iget v1, p1, Lorg/mapsforge/core/model/Dimension;->height:I

    if-lez v1, :cond_2f

    iget-object v2, p0, Lorg/mapsforge/map/view/FrameBuffer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    const/4 v3, 0x0

    invoke-interface {v2, v0, v1, v3}, Lorg/mapsforge/core/graphics/GraphicFactory;->createBitmap(IIZ)Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->odBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBuffer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget v1, p1, Lorg/mapsforge/core/model/Dimension;->width:I

    iget p1, p1, Lorg/mapsforge/core/model/Dimension;->height:I

    invoke-interface {v0, v1, p1, v3}, Lorg/mapsforge/core/graphics/GraphicFactory;->createBitmap(IIZ)Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/view/FrameBuffer;->lmBitmap:Lorg/mapsforge/core/graphics/Bitmap;
    :try_end_2f
    .catchall {:try_start_d .. :try_end_2f} :catchall_31

    :cond_2f
    monitor-exit p0

    return-void

    :catchall_31
    move-exception p1

    monitor-exit p0

    throw p1
.end method
