.class public final Lorg/mapsforge/map/controller/FrameBufferController;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/model/common/Observer;


# instance fields
.field private final frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

.field private lastMapViewDimension:Lorg/mapsforge/core/model/Dimension;

.field private lastOverdrawFactor:D

.field private final model:Lorg/mapsforge/map/model/Model;


# direct methods
.method private constructor <init>(Lorg/mapsforge/map/view/FrameBuffer;Lorg/mapsforge/map/model/Model;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/controller/FrameBufferController;->frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

    iput-object p2, p0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    return-void
.end method

.method private adjustFrameBufferMatrix(Lorg/mapsforge/core/model/MapPosition;Lorg/mapsforge/core/model/Dimension;DLorg/mapsforge/core/model/LatLong;)V
    .registers 26

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p5

    iget-object v3, v0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    iget-object v3, v3, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v3}, Lorg/mapsforge/map/model/IMapViewPosition;->getMapPosition()Lorg/mapsforge/core/model/MapPosition;

    move-result-object v3

    iget-byte v4, v1, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    iget-object v5, v0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    iget-object v5, v5, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v5}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v5

    invoke-static {v4, v5}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v4

    iget-object v6, v1, Lorg/mapsforge/core/model/MapPosition;->latLong:Lorg/mapsforge/core/model/LatLong;

    invoke-static {v6, v4, v5}, Lorg/mapsforge/core/util/MercatorProjection;->getPixel(Lorg/mapsforge/core/model/LatLong;J)Lorg/mapsforge/core/model/Point;

    move-result-object v6

    iget-object v3, v3, Lorg/mapsforge/core/model/MapPosition;->latLong:Lorg/mapsforge/core/model/LatLong;

    invoke-static {v3, v4, v5}, Lorg/mapsforge/core/util/MercatorProjection;->getPixel(Lorg/mapsforge/core/model/LatLong;J)Lorg/mapsforge/core/model/Point;

    move-result-object v3

    iget-wide v7, v6, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v9, v3, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v7, v9

    iget-wide v9, v6, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v11, v3, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v9, v11

    const-wide/16 v11, 0x0

    if-eqz v2, :cond_46

    invoke-static {v2, v4, v5}, Lorg/mapsforge/core/util/MercatorProjection;->getPixel(Lorg/mapsforge/core/model/LatLong;J)Lorg/mapsforge/core/model/Point;

    move-result-object v2

    iget-wide v3, v2, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v11, v6, Lorg/mapsforge/core/model/Point;->x:D

    sub-double v11, v3, v11

    iget-wide v2, v2, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v4, v6, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v2, v4

    goto :goto_47

    :cond_46
    move-wide v2, v11

    :goto_47
    const-wide/high16 v4, 0x4000000000000000L    # 2.0

    iget-byte v1, v1, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    int-to-double v13, v1

    invoke-static {v4, v5, v13, v14}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v4

    div-double v4, p3, v4

    double-to-float v1, v4

    iget-object v13, v0, Lorg/mapsforge/map/controller/FrameBufferController;->frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

    double-to-float v14, v7

    double-to-float v15, v9

    double-to-float v4, v11

    double-to-float v2, v2

    move/from16 v16, v1

    move-object/from16 v17, p2

    move/from16 v18, v4

    move/from16 v19, v2

    invoke-virtual/range {v13 .. v19}, Lorg/mapsforge/map/view/FrameBuffer;->adjustMatrix(FFFLorg/mapsforge/core/model/Dimension;FF)V

    return-void
.end method

.method public static calculateFrameBufferDimension(Lorg/mapsforge/core/model/Dimension;D)Lorg/mapsforge/core/model/Dimension;
    .registers 6

    iget v0, p0, Lorg/mapsforge/core/model/Dimension;->width:I

    int-to-double v0, v0

    mul-double v0, v0, p1

    double-to-int v0, v0

    iget p0, p0, Lorg/mapsforge/core/model/Dimension;->height:I

    int-to-double v1, p0

    mul-double v1, v1, p1

    double-to-int p0, v1

    sget-boolean p1, Lorg/mapsforge/core/util/Parameters;->SQUARE_FRAME_BUFFER:Z

    if-eqz p1, :cond_15

    invoke-static {v0, p0}, Ljava/lang/Math;->max(II)I

    move-result v0

    move p0, v0

    :cond_15
    new-instance p1, Lorg/mapsforge/core/model/Dimension;

    invoke-direct {p1, v0, p0}, Lorg/mapsforge/core/model/Dimension;-><init>(II)V

    return-object p1
.end method

.method public static create(Lorg/mapsforge/map/view/FrameBuffer;Lorg/mapsforge/map/model/Model;)Lorg/mapsforge/map/controller/FrameBufferController;
    .registers 3

    new-instance v0, Lorg/mapsforge/map/controller/FrameBufferController;

    invoke-direct {v0, p0, p1}, Lorg/mapsforge/map/controller/FrameBufferController;-><init>(Lorg/mapsforge/map/view/FrameBuffer;Lorg/mapsforge/map/model/Model;)V

    iget-object p0, p1, Lorg/mapsforge/map/model/Model;->frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/model/common/Observable;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    iget-object p0, p1, Lorg/mapsforge/map/model/Model;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/model/common/Observable;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    iget-object p0, p1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {p0, v0}, Lorg/mapsforge/map/model/IMapViewPosition;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    iget-object p0, p1, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/model/common/Observable;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-object v0
.end method

.method private dimensionChangeNeeded(Lorg/mapsforge/core/model/Dimension;D)Z
    .registers 6

    iget-wide v0, p0, Lorg/mapsforge/map/controller/FrameBufferController;->lastOverdrawFactor:D

    invoke-static {p2, p3, v0, v1}, Ljava/lang/Double;->compare(DD)I

    move-result p2

    const/4 p3, 0x1

    if-eqz p2, :cond_a

    return p3

    :cond_a
    iget-object p2, p0, Lorg/mapsforge/map/controller/FrameBufferController;->lastMapViewDimension:Lorg/mapsforge/core/model/Dimension;

    invoke-virtual {p1, p2}, Lorg/mapsforge/core/model/Dimension;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_13

    return p3

    :cond_13
    const/4 p1, 0x0

    return p1
.end method


# virtual methods
.method public destroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v0, p0}, Lorg/mapsforge/map/model/common/Observable;->removeObserver(Lorg/mapsforge/map/model/common/Observer;)V

    iget-object v0, p0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0, p0}, Lorg/mapsforge/map/model/IMapViewPosition;->removeObserver(Lorg/mapsforge/map/model/common/Observer;)V

    iget-object v0, p0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    invoke-virtual {v0, p0}, Lorg/mapsforge/map/model/common/Observable;->removeObserver(Lorg/mapsforge/map/model/common/Observer;)V

    iget-object v0, p0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

    invoke-virtual {v0, p0}, Lorg/mapsforge/map/model/common/Observable;->removeObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-void
.end method

.method public onChange()V
    .registers 9

    iget-object v0, p0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/MapViewDimension;->getDimension()Lorg/mapsforge/core/model/Dimension;

    move-result-object v3

    if-nez v3, :cond_b

    return-void

    :cond_b
    iget-object v0, p0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/FrameBufferModel;->getOverdrawFactor()D

    move-result-wide v0

    invoke-direct {p0, v3, v0, v1}, Lorg/mapsforge/map/controller/FrameBufferController;->dimensionChangeNeeded(Lorg/mapsforge/core/model/Dimension;D)Z

    move-result v2

    if-eqz v2, :cond_4a

    invoke-static {v3, v0, v1}, Lorg/mapsforge/map/controller/FrameBufferController;->calculateFrameBufferDimension(Lorg/mapsforge/core/model/Dimension;D)Lorg/mapsforge/core/model/Dimension;

    move-result-object v2

    sget-boolean v4, Lorg/mapsforge/core/util/Parameters;->SQUARE_FRAME_BUFFER:Z

    if-eqz v4, :cond_41

    iget-object v4, p0, Lorg/mapsforge/map/controller/FrameBufferController;->frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

    invoke-virtual {v4}, Lorg/mapsforge/map/view/FrameBuffer;->getDimension()Lorg/mapsforge/core/model/Dimension;

    move-result-object v4

    if-eqz v4, :cond_41

    iget v4, v2, Lorg/mapsforge/core/model/Dimension;->width:I

    iget-object v5, p0, Lorg/mapsforge/map/controller/FrameBufferController;->frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

    invoke-virtual {v5}, Lorg/mapsforge/map/view/FrameBuffer;->getDimension()Lorg/mapsforge/core/model/Dimension;

    move-result-object v5

    iget v5, v5, Lorg/mapsforge/core/model/Dimension;->width:I

    if-gt v4, v5, :cond_41

    iget v4, v2, Lorg/mapsforge/core/model/Dimension;->height:I

    iget-object v5, p0, Lorg/mapsforge/map/controller/FrameBufferController;->frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

    invoke-virtual {v5}, Lorg/mapsforge/map/view/FrameBuffer;->getDimension()Lorg/mapsforge/core/model/Dimension;

    move-result-object v5

    iget v5, v5, Lorg/mapsforge/core/model/Dimension;->height:I

    if-le v4, v5, :cond_46

    :cond_41
    iget-object v4, p0, Lorg/mapsforge/map/controller/FrameBufferController;->frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

    invoke-virtual {v4, v2}, Lorg/mapsforge/map/view/FrameBuffer;->setDimension(Lorg/mapsforge/core/model/Dimension;)V

    :cond_46
    iput-object v3, p0, Lorg/mapsforge/map/controller/FrameBufferController;->lastMapViewDimension:Lorg/mapsforge/core/model/Dimension;

    iput-wide v0, p0, Lorg/mapsforge/map/controller/FrameBufferController;->lastOverdrawFactor:D

    :cond_4a
    iget-object v0, p0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    monitor-enter v0

    :try_start_4f
    iget-object v7, p0, Lorg/mapsforge/map/controller/FrameBufferController;->frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

    monitor-enter v7
    :try_end_52
    .catchall {:try_start_4f .. :try_end_52} :catchall_76

    :try_start_52
    iget-object v1, p0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    iget-object v1, v1, Lorg/mapsforge/map/model/Model;->frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/FrameBufferModel;->getMapPosition()Lorg/mapsforge/core/model/MapPosition;

    move-result-object v2

    if-eqz v2, :cond_70

    iget-object v1, p0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    iget-object v1, v1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v1}, Lorg/mapsforge/map/model/IMapViewPosition;->getScaleFactor()D

    move-result-wide v4

    iget-object v1, p0, Lorg/mapsforge/map/controller/FrameBufferController;->model:Lorg/mapsforge/map/model/Model;

    iget-object v1, v1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v1}, Lorg/mapsforge/map/model/IMapViewPosition;->getPivot()Lorg/mapsforge/core/model/LatLong;

    move-result-object v6

    move-object v1, p0

    invoke-direct/range {v1 .. v6}, Lorg/mapsforge/map/controller/FrameBufferController;->adjustFrameBufferMatrix(Lorg/mapsforge/core/model/MapPosition;Lorg/mapsforge/core/model/Dimension;DLorg/mapsforge/core/model/LatLong;)V

    :cond_70
    monitor-exit v7
    :try_end_71
    .catchall {:try_start_52 .. :try_end_71} :catchall_73

    :try_start_71
    monitor-exit v0
    :try_end_72
    .catchall {:try_start_71 .. :try_end_72} :catchall_76

    return-void

    :catchall_73
    move-exception v1

    :try_start_74
    monitor-exit v7
    :try_end_75
    .catchall {:try_start_74 .. :try_end_75} :catchall_73

    :try_start_75
    throw v1

    :catchall_76
    move-exception v1

    monitor-exit v0
    :try_end_78
    .catchall {:try_start_75 .. :try_end_78} :catchall_76

    throw v1
.end method
