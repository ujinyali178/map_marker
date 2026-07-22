.class public Lorg/mapsforge/map/layer/overlay/Polyline;
.super Lorg/mapsforge/map/layer/Layer;
.source "SourceFile"


# static fields
.field private static final STROKE_MIN_ZOOM:B = 0xct


# instance fields
.field private boundingBox:Lorg/mapsforge/core/model/BoundingBox;

.field private final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field private final keepAligned:Z

.field private final latLongs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/LatLong;",
            ">;"
        }
    .end annotation
.end field

.field private paintStroke:Lorg/mapsforge/core/graphics/Paint;

.field private strokeIncrease:D


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 4

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lorg/mapsforge/map/layer/overlay/Polyline;-><init>(Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/GraphicFactory;Z)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/GraphicFactory;Z)V
    .registers 6

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    iput-wide v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->strokeIncrease:D

    iput-boolean p3, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->keepAligned:Z

    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    iput-object p2, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    return-void
.end method

.method private updatePoints()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_a

    const/4 v0, 0x0

    goto :goto_11

    :cond_a
    new-instance v0, Lorg/mapsforge/core/model/BoundingBox;

    iget-object v1, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    invoke-direct {v0, v1}, Lorg/mapsforge/core/model/BoundingBox;-><init>(Ljava/util/List;)V

    :goto_11
    iput-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    return-void
.end method


# virtual methods
.method public declared-synchronized addPoint(Lorg/mapsforge/core/model/LatLong;)V
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-direct {p0}, Lorg/mapsforge/map/layer/overlay/Polyline;->updatePoints()V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-void

    :catchall_b
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addPoints(Ljava/util/List;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/LatLong;",
            ">;)V"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    invoke-direct {p0}, Lorg/mapsforge/map/layer/overlay/Polyline;->updatePoints()V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-void

    :catchall_b
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized clear()V
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    invoke-direct {p0}, Lorg/mapsforge/map/layer/overlay/Polyline;->updatePoints()V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-void

    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized contains(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/map/util/MapViewProjection;)Z
    .registers 26

    move-object/from16 v1, p0

    move-object/from16 v0, p1

    move-object/from16 v2, p2

    monitor-enter p0

    const/high16 v3, 0x41200000    # 10.0f

    :try_start_9
    iget-object v4, v1, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v4}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v4

    mul-float v4, v4, v3

    iget-object v3, v1, Lorg/mapsforge/map/layer/overlay/Polyline;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v3}, Lorg/mapsforge/core/graphics/Paint;->getStrokeWidth()F

    move-result v3

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v3, v5

    invoke-static {v4, v3}, Ljava/lang/Math;->max(FF)F

    move-result v3

    float-to-double v3, v3

    const/4 v5, 0x0

    const/4 v7, 0x0

    :goto_21
    iget-object v8, v1, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v8

    const/4 v9, 0x1

    sub-int/2addr v8, v9

    if-ge v7, v8, :cond_6e

    if-nez v7, :cond_39

    iget-object v5, v1, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    invoke-interface {v5, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lorg/mapsforge/core/model/LatLong;

    invoke-virtual {v2, v5}, Lorg/mapsforge/map/util/MapViewProjection;->toPixels(Lorg/mapsforge/core/model/LatLong;)Lorg/mapsforge/core/model/Point;

    move-result-object v5

    :cond_39
    iget-object v8, v1, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    add-int/lit8 v7, v7, 0x1

    invoke-interface {v8, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lorg/mapsforge/core/model/LatLong;

    invoke-virtual {v2, v8}, Lorg/mapsforge/map/util/MapViewProjection;->toPixels(Lorg/mapsforge/core/model/LatLong;)Lorg/mapsforge/core/model/Point;

    move-result-object v8

    iget-wide v10, v5, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v12, v5, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v14, v8, Lorg/mapsforge/core/model/Point;->x:D

    move/from16 v22, v7

    iget-wide v6, v8, Lorg/mapsforge/core/model/Point;->y:D

    move-wide/from16 v16, v6

    iget-wide v5, v0, Lorg/mapsforge/core/model/Point;->x:D

    move-wide/from16 v18, v10

    iget-wide v9, v0, Lorg/mapsforge/core/model/Point;->y:D

    move-wide/from16 v20, v9

    move-wide/from16 v10, v18

    move-wide/from16 v18, v5

    invoke-static/range {v10 .. v21}, Lorg/mapsforge/core/util/LatLongUtils;->distanceSegmentPoint(DDDDDD)D

    move-result-wide v5
    :try_end_63
    .catchall {:try_start_9 .. :try_end_63} :catchall_71

    cmpg-double v9, v5, v3

    if-gtz v9, :cond_6a

    monitor-exit p0

    const/4 v0, 0x1

    return v0

    :cond_6a
    move-object v5, v8

    move/from16 v7, v22

    goto :goto_21

    :cond_6e
    monitor-exit p0

    const/4 v0, 0x0

    return v0

    :catchall_71
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    .registers 14

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_b1

    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    if-nez v0, :cond_f

    goto/16 :goto_b1

    :cond_f
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    if-eqz v0, :cond_1b

    invoke-virtual {v0, p1}, Lorg/mapsforge/core/model/BoundingBox;->intersects(Lorg/mapsforge/core/model/BoundingBox;)Z

    move-result p1
    :try_end_17
    .catchall {:try_start_1 .. :try_end_17} :catchall_b3

    if-nez p1, :cond_1b

    monitor-exit p0

    return-void

    :cond_1b
    :try_start_1b
    iget-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0
    :try_end_25
    .catchall {:try_start_1b .. :try_end_25} :catchall_b3

    if-nez v0, :cond_29

    monitor-exit p0

    return-void

    :cond_29
    :try_start_29
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/core/model/LatLong;

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v1

    invoke-static {p2, v1}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v1

    iget-wide v3, v0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v3, v4, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v3

    iget-wide v5, p4, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v3, v5

    double-to-float v3, v3

    iget-wide v4, v0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v4, v5, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v4

    iget-wide v6, p4, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v4, v6

    double-to-float v0, v4

    iget-object v4, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-interface {v4}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPath()Lorg/mapsforge/core/graphics/Path;

    move-result-object v4

    invoke-interface {v4, v3, v0}, Lorg/mapsforge/core/graphics/Path;->moveTo(FF)V

    :goto_56
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7a

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/core/model/LatLong;

    iget-wide v5, v0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v5, v6, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v5

    iget-wide v7, p4, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v5, v7

    double-to-float v3, v5

    iget-wide v5, v0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v5, v6, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v5

    iget-wide v7, p4, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v5, v7

    double-to-float v0, v5

    invoke-interface {v4, v3, v0}, Lorg/mapsforge/core/graphics/Path;->lineTo(FF)V

    goto :goto_56

    :cond_7a
    iget-boolean p1, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->keepAligned:Z

    if-eqz p1, :cond_83

    iget-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1, p4}, Lorg/mapsforge/core/graphics/Paint;->setBitmapShaderShift(Lorg/mapsforge/core/model/Point;)V

    :cond_83
    iget-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Paint;->getStrokeWidth()F

    move-result p1

    iget-wide v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->strokeIncrease:D

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    cmpl-double p4, v0, v2

    if-lez p4, :cond_a5

    add-int/lit8 p2, p2, -0xc

    const/4 p4, 0x0

    invoke-static {p2, p4}, Ljava/lang/Math;->max(II)I

    move-result p2

    int-to-double v2, p2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    double-to-float p2, v0

    iget-object p4, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    mul-float p2, p2, p1

    invoke-interface {p4, p2}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    :cond_a5
    iget-object p2, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p3, v4, p2}, Lorg/mapsforge/core/graphics/GraphicContext;->drawPath(Lorg/mapsforge/core/graphics/Path;Lorg/mapsforge/core/graphics/Paint;)V

    iget-object p2, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p2, p1}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V
    :try_end_af
    .catchall {:try_start_29 .. :try_end_af} :catchall_b3

    monitor-exit p0

    return-void

    :cond_b1
    :goto_b1
    monitor-exit p0

    return-void

    :catchall_b3
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public getLatLongs()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/LatLong;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    return-object v0
.end method

.method public declared-synchronized getPaintStroke()Lorg/mapsforge/core/graphics/Paint;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->paintStroke:Lorg/mapsforge/core/graphics/Paint;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getStrokeIncrease()D
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-wide v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->strokeIncrease:D
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-wide v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public isKeepAligned()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->keepAligned:Z

    return v0
.end method

.method public declared-synchronized setPaintStroke(Lorg/mapsforge/core/graphics/Paint;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->paintStroke:Lorg/mapsforge/core/graphics/Paint;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setPoints(Ljava/util/List;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/LatLong;",
            ">;)V"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->latLongs:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    invoke-direct {p0}, Lorg/mapsforge/map/layer/overlay/Polyline;->updatePoints()V
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_10

    monitor-exit p0

    return-void

    :catchall_10
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setStrokeIncrease(D)V
    .registers 3

    monitor-enter p0

    :try_start_1
    iput-wide p1, p0, Lorg/mapsforge/map/layer/overlay/Polyline;->strokeIncrease:D
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method
