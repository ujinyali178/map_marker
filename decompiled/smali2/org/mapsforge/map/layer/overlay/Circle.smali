.class public Lorg/mapsforge/map/layer/overlay/Circle;
.super Lorg/mapsforge/map/layer/Layer;
.source "SourceFile"


# instance fields
.field private final keepAligned:Z

.field private latLong:Lorg/mapsforge/core/model/LatLong;

.field private paintFill:Lorg/mapsforge/core/graphics/Paint;

.field private paintStroke:Lorg/mapsforge/core/graphics/Paint;

.field private radius:F


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/model/LatLong;FLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;)V
    .registers 11

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v5}, Lorg/mapsforge/map/layer/overlay/Circle;-><init>(Lorg/mapsforge/core/model/LatLong;FLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Z)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/core/model/LatLong;FLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Z)V
    .registers 6

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    iput-boolean p5, p0, Lorg/mapsforge/map/layer/overlay/Circle;->keepAligned:Z

    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Circle;->latLong:Lorg/mapsforge/core/model/LatLong;

    invoke-direct {p0, p2}, Lorg/mapsforge/map/layer/overlay/Circle;->setRadiusInternal(F)V

    iput-object p3, p0, Lorg/mapsforge/map/layer/overlay/Circle;->paintFill:Lorg/mapsforge/core/graphics/Paint;

    iput-object p4, p0, Lorg/mapsforge/map/layer/overlay/Circle;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    return-void
.end method

.method private setRadiusInternal(F)V
    .registers 5

    const/4 v0, 0x0

    cmpg-float v0, p1, v0

    if-ltz v0, :cond_e

    invoke-static {p1}, Ljava/lang/Float;->isNaN(F)Z

    move-result v0

    if-nez v0, :cond_e

    iput p1, p0, Lorg/mapsforge/map/layer/overlay/Circle;->radius:F

    return-void

    :cond_e
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid radius: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public declared-synchronized contains(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;DB)Z
    .registers 8

    monitor-enter p0

    const/high16 v0, 0x41200000    # 10.0f

    :try_start_3
    iget-object v1, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v1

    mul-float v1, v1, v0

    invoke-virtual {p0, p3, p4, p5}, Lorg/mapsforge/map/layer/overlay/Circle;->getRadiusInPixels(DB)I

    move-result p3

    int-to-float p3, p3

    invoke-static {v1, p3}, Ljava/lang/Math;->max(FF)F

    move-result p3

    float-to-double p3, p3

    invoke-virtual {p1, p2}, Lorg/mapsforge/core/model/Point;->distance(Lorg/mapsforge/core/model/Point;)D

    move-result-wide p1
    :try_end_19
    .catchall {:try_start_3 .. :try_end_19} :catchall_22

    cmpg-double p5, p1, p3

    if-gez p5, :cond_1f

    const/4 p1, 0x1

    goto :goto_20

    :cond_1f
    const/4 p1, 0x0

    :goto_20
    monitor-exit p0

    return p1

    :catchall_22
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    .registers 22

    move-object/from16 v1, p0

    move/from16 v0, p2

    move-object/from16 v2, p3

    move-object/from16 v3, p4

    monitor-enter p0

    :try_start_9
    iget-object v4, v1, Lorg/mapsforge/map/layer/overlay/Circle;->latLong:Lorg/mapsforge/core/model/LatLong;

    if-eqz v4, :cond_7b

    iget-object v5, v1, Lorg/mapsforge/map/layer/overlay/Circle;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    if-nez v5, :cond_16

    iget-object v5, v1, Lorg/mapsforge/map/layer/overlay/Circle;->paintFill:Lorg/mapsforge/core/graphics/Paint;

    if-nez v5, :cond_16

    goto :goto_7b

    :cond_16
    iget-wide v5, v4, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v7, v4, Lorg/mapsforge/core/model/LatLong;->longitude:D

    iget-object v4, v1, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v4}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v4

    invoke-static {v0, v4}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v9

    invoke-static {v7, v8, v9, v10}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v7

    iget-wide v11, v3, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v7, v11

    double-to-int v4, v7

    invoke-static {v5, v6, v9, v10}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v7

    iget-wide v9, v3, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v7, v9

    double-to-int v7, v7

    invoke-virtual {v1, v5, v6, v0}, Lorg/mapsforge/map/layer/overlay/Circle;->getRadiusInPixels(DB)I

    move-result v0

    new-instance v5, Lorg/mapsforge/core/model/Rectangle;

    const-wide/16 v9, 0x0

    invoke-interface/range {p3 .. p3}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v6

    int-to-double v13, v6

    invoke-interface/range {p3 .. p3}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v6

    int-to-double v11, v6

    move-object v8, v5

    move-wide v15, v11

    const-wide/16 v11, 0x0

    invoke-direct/range {v8 .. v16}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    int-to-double v9, v4

    int-to-double v11, v7

    int-to-double v13, v0

    move-object v8, v5

    invoke-virtual/range {v8 .. v14}, Lorg/mapsforge/core/model/Rectangle;->intersectsCircle(DDD)Z

    move-result v5
    :try_end_55
    .catchall {:try_start_9 .. :try_end_55} :catchall_7d

    if-nez v5, :cond_59

    monitor-exit p0

    return-void

    :cond_59
    :try_start_59
    iget-object v5, v1, Lorg/mapsforge/map/layer/overlay/Circle;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    if-eqz v5, :cond_69

    iget-boolean v6, v1, Lorg/mapsforge/map/layer/overlay/Circle;->keepAligned:Z

    if-eqz v6, :cond_64

    invoke-interface {v5, v3}, Lorg/mapsforge/core/graphics/Paint;->setBitmapShaderShift(Lorg/mapsforge/core/model/Point;)V

    :cond_64
    iget-object v5, v1, Lorg/mapsforge/map/layer/overlay/Circle;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v2, v4, v7, v0, v5}, Lorg/mapsforge/core/graphics/GraphicContext;->drawCircle(IIILorg/mapsforge/core/graphics/Paint;)V

    :cond_69
    iget-object v5, v1, Lorg/mapsforge/map/layer/overlay/Circle;->paintFill:Lorg/mapsforge/core/graphics/Paint;

    if-eqz v5, :cond_79

    iget-boolean v6, v1, Lorg/mapsforge/map/layer/overlay/Circle;->keepAligned:Z

    if-eqz v6, :cond_74

    invoke-interface {v5, v3}, Lorg/mapsforge/core/graphics/Paint;->setBitmapShaderShift(Lorg/mapsforge/core/model/Point;)V

    :cond_74
    iget-object v3, v1, Lorg/mapsforge/map/layer/overlay/Circle;->paintFill:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v2, v4, v7, v0, v3}, Lorg/mapsforge/core/graphics/GraphicContext;->drawCircle(IIILorg/mapsforge/core/graphics/Paint;)V
    :try_end_79
    .catchall {:try_start_59 .. :try_end_79} :catchall_7d

    :cond_79
    monitor-exit p0

    return-void

    :cond_7b
    :goto_7b
    monitor-exit p0

    return-void

    :catchall_7d
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPaintFill()Lorg/mapsforge/core/graphics/Paint;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Circle;->paintFill:Lorg/mapsforge/core/graphics/Paint;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPaintStroke()Lorg/mapsforge/core/graphics/Paint;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Circle;->paintStroke:Lorg/mapsforge/core/graphics/Paint;
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
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Circle;->latLong:Lorg/mapsforge/core/model/LatLong;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getRadius()F
    .registers 2

    monitor-enter p0

    :try_start_1
    iget v0, p0, Lorg/mapsforge/map/layer/overlay/Circle;->radius:F
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected getRadiusInPixels(DB)I
    .registers 7

    iget v0, p0, Lorg/mapsforge/map/layer/overlay/Circle;->radius:F

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v1

    invoke-static {p3, v1}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v1

    invoke-static {v0, p1, p2, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->metersToPixels(FDJ)D

    move-result-wide p1

    double-to-int p1, p1

    return p1
.end method

.method public isKeepAligned()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/overlay/Circle;->keepAligned:Z

    return v0
.end method

.method public declared-synchronized setLatLong(Lorg/mapsforge/core/model/LatLong;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Circle;->latLong:Lorg/mapsforge/core/model/LatLong;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setPaintFill(Lorg/mapsforge/core/graphics/Paint;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Circle;->paintFill:Lorg/mapsforge/core/graphics/Paint;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setPaintStroke(Lorg/mapsforge/core/graphics/Paint;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Circle;->paintStroke:Lorg/mapsforge/core/graphics/Paint;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setRadius(F)V
    .registers 2

    monitor-enter p0

    :try_start_1
    invoke-direct {p0, p1}, Lorg/mapsforge/map/layer/overlay/Circle;->setRadiusInternal(F)V
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_6

    monitor-exit p0

    return-void

    :catchall_6
    move-exception p1

    monitor-exit p0

    throw p1
.end method
