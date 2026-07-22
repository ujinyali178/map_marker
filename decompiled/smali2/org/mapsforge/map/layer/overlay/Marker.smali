.class public Lorg/mapsforge/map/layer/overlay/Marker;
.super Lorg/mapsforge/map/layer/Layer;
.source "SourceFile"


# instance fields
.field private bitmap:Lorg/mapsforge/core/graphics/Bitmap;

.field private horizontalOffset:I

.field private latLong:Lorg/mapsforge/core/model/LatLong;

.field private verticalOffset:I


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/graphics/Bitmap;II)V
    .registers 5

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Marker;->latLong:Lorg/mapsforge/core/model/LatLong;

    iput-object p2, p0, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iput p3, p0, Lorg/mapsforge/map/layer/overlay/Marker;->horizontalOffset:I

    iput p4, p0, Lorg/mapsforge/map/layer/overlay/Marker;->verticalOffset:I

    return-void
.end method


# virtual methods
.method public declared-synchronized contains(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)Z
    .registers 21

    move-object/from16 v1, p0

    move-object/from16 v0, p1

    monitor-enter p0

    :try_start_5
    iget-object v2, v1, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    const/high16 v3, 0x41a00000    # 20.0f

    mul-float v2, v2, v3

    iget-object v4, v1, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v4}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result v4

    int-to-float v4, v4

    invoke-static {v2, v4}, Ljava/lang/Math;->max(FF)F

    move-result v2

    float-to-double v4, v2

    iget-object v2, v1, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v2, v2, v3

    iget-object v3, v1, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v3}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result v3

    int-to-float v3, v3

    invoke-static {v2, v3}, Ljava/lang/Math;->max(FF)F

    move-result v2

    float-to-double v2, v2

    new-instance v15, Lorg/mapsforge/core/model/Rectangle;

    iget-wide v6, v0, Lorg/mapsforge/core/model/Point;->x:D

    const-wide/high16 v8, 0x4000000000000000L    # 2.0

    div-double/2addr v4, v8

    sub-double v10, v6, v4

    iget v12, v1, Lorg/mapsforge/map/layer/overlay/Marker;->horizontalOffset:I

    int-to-double v13, v12

    add-double/2addr v10, v13

    iget-wide v13, v0, Lorg/mapsforge/core/model/Point;->y:D

    div-double/2addr v2, v8

    sub-double v8, v13, v2

    iget v0, v1, Lorg/mapsforge/map/layer/overlay/Marker;->verticalOffset:I

    move-wide/from16 v16, v10

    int-to-double v10, v0

    add-double v9, v8, v10

    add-double/2addr v6, v4

    int-to-double v4, v12

    add-double v11, v6, v4

    add-double/2addr v13, v2

    int-to-double v2, v0

    add-double/2addr v13, v2

    move-object v6, v15

    move-wide/from16 v7, v16

    invoke-direct/range {v6 .. v14}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    move-object/from16 v0, p2

    invoke-virtual {v15, v0}, Lorg/mapsforge/core/model/Rectangle;->contains(Lorg/mapsforge/core/model/Point;)Z

    move-result v0
    :try_end_5b
    .catchall {:try_start_5 .. :try_end_5b} :catchall_5d

    monitor-exit p0

    return v0

    :catchall_5d
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    .registers 29

    move-object/from16 v1, p0

    move-object/from16 v0, p4

    monitor-enter p0

    :try_start_5
    iget-object v2, v1, Lorg/mapsforge/map/layer/overlay/Marker;->latLong:Lorg/mapsforge/core/model/LatLong;

    if-eqz v2, :cond_96

    iget-object v2, v1, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v2, :cond_96

    invoke-interface {v2}, Lorg/mapsforge/core/graphics/Bitmap;->isDestroyed()Z

    move-result v2

    if-eqz v2, :cond_15

    goto/16 :goto_96

    :cond_15
    iget-object v2, v1, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v2

    move/from16 v3, p2

    invoke-static {v3, v2}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v2

    iget-object v4, v1, Lorg/mapsforge/map/layer/overlay/Marker;->latLong:Lorg/mapsforge/core/model/LatLong;

    iget-wide v4, v4, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v4, v5, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v4

    iget-object v6, v1, Lorg/mapsforge/map/layer/overlay/Marker;->latLong:Lorg/mapsforge/core/model/LatLong;

    iget-wide v6, v6, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v6, v7, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v2

    iget-object v6, v1, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v6}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result v6

    div-int/lit8 v6, v6, 0x2

    iget-object v7, v1, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v7}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    iget-wide v8, v0, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v4, v8

    int-to-double v8, v6

    sub-double/2addr v4, v8

    iget v6, v1, Lorg/mapsforge/map/layer/overlay/Marker;->horizontalOffset:I

    int-to-double v8, v6

    add-double/2addr v4, v8

    double-to-int v4, v4

    iget-wide v5, v0, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v2, v5

    int-to-double v5, v7

    sub-double/2addr v2, v5

    iget v0, v1, Lorg/mapsforge/map/layer/overlay/Marker;->verticalOffset:I

    int-to-double v5, v0

    add-double/2addr v2, v5

    double-to-int v0, v2

    iget-object v2, v1, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v2}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result v2

    add-int/2addr v2, v4

    iget-object v3, v1, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v3}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result v3

    add-int/2addr v3, v0

    new-instance v14, Lorg/mapsforge/core/model/Rectangle;

    int-to-double v6, v4

    int-to-double v8, v0

    int-to-double v10, v2

    int-to-double v12, v3

    move-object v5, v14

    invoke-direct/range {v5 .. v13}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    new-instance v2, Lorg/mapsforge/core/model/Rectangle;

    const-wide/16 v16, 0x0

    const-wide/16 v18, 0x0

    invoke-interface/range {p3 .. p3}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v3

    int-to-double v5, v3

    invoke-interface/range {p3 .. p3}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v3

    int-to-double v7, v3

    move-object v15, v2

    move-wide/from16 v20, v5

    move-wide/from16 v22, v7

    invoke-direct/range {v15 .. v23}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    invoke-virtual {v2, v14}, Lorg/mapsforge/core/model/Rectangle;->intersects(Lorg/mapsforge/core/model/Rectangle;)Z

    move-result v2
    :try_end_89
    .catchall {:try_start_5 .. :try_end_89} :catchall_98

    if-nez v2, :cond_8d

    monitor-exit p0

    return-void

    :cond_8d
    :try_start_8d
    iget-object v2, v1, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    move-object/from16 v3, p3

    invoke-interface {v3, v2, v4, v0}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;II)V
    :try_end_94
    .catchall {:try_start_8d .. :try_end_94} :catchall_98

    monitor-exit p0

    return-void

    :cond_96
    :goto_96
    monitor-exit p0

    return-void

    :catchall_98
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getBitmap()Lorg/mapsforge/core/graphics/Bitmap;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getHorizontalOffset()I
    .registers 2

    monitor-enter p0

    :try_start_1
    iget v0, p0, Lorg/mapsforge/map/layer/overlay/Marker;->horizontalOffset:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLatLong()Lorg/mapsforge/core/model/LatLong;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Marker;->latLong:Lorg/mapsforge/core/model/LatLong;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPosition()Lorg/mapsforge/core/model/LatLong;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Marker;->latLong:Lorg/mapsforge/core/model/LatLong;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getVerticalOffset()I
    .registers 2

    monitor-enter p0

    :try_start_1
    iget v0, p0, Lorg/mapsforge/map/layer/overlay/Marker;->verticalOffset:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onDestroy()V
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v0, :cond_8

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_a

    :cond_8
    monitor-exit p0

    return-void

    :catchall_a
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setBitmap(Lorg/mapsforge/core/graphics/Bitmap;)V
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v0, :cond_d

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_18

    if-eqz v0, :cond_d

    monitor-exit p0

    return-void

    :cond_d
    :try_start_d
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v0, :cond_14

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    :cond_14
    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Marker;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;
    :try_end_16
    .catchall {:try_start_d .. :try_end_16} :catchall_18

    monitor-exit p0

    return-void

    :catchall_18
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setHorizontalOffset(I)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput p1, p0, Lorg/mapsforge/map/layer/overlay/Marker;->horizontalOffset:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setLatLong(Lorg/mapsforge/core/model/LatLong;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Marker;->latLong:Lorg/mapsforge/core/model/LatLong;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setVerticalOffset(I)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput p1, p0, Lorg/mapsforge/map/layer/overlay/Marker;->verticalOffset:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method
