.class public Lorg/mapsforge/map/layer/overlay/Polygon;
.super Lorg/mapsforge/map/layer/Layer;
.source "SourceFile"


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

.field private paintFill:Lorg/mapsforge/core/graphics/Paint;

.field private paintStroke:Lorg/mapsforge/core/graphics/Paint;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 5

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lorg/mapsforge/map/layer/overlay/Polygon;-><init>(Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/GraphicFactory;Z)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/GraphicFactory;Z)V
    .registers 6

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->latLongs:Ljava/util/List;

    iput-boolean p4, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->keepAligned:Z

    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->paintFill:Lorg/mapsforge/core/graphics/Paint;

    iput-object p2, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    iput-object p3, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    return-void
.end method

.method private updatePoints()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->latLongs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_a

    const/4 v0, 0x0

    goto :goto_11

    :cond_a
    new-instance v0, Lorg/mapsforge/core/model/BoundingBox;

    iget-object v1, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->latLongs:Ljava/util/List;

    invoke-direct {v0, v1}, Lorg/mapsforge/core/model/BoundingBox;-><init>(Ljava/util/List;)V

    :goto_11
    iput-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    return-void
.end method


# virtual methods
.method public declared-synchronized addPoint(Lorg/mapsforge/core/model/LatLong;)V
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->latLongs:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-direct {p0}, Lorg/mapsforge/map/layer/overlay/Polygon;->updatePoints()V
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
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->latLongs:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    invoke-direct {p0}, Lorg/mapsforge/map/layer/overlay/Polygon;->updatePoints()V
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
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->latLongs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    invoke-direct {p0}, Lorg/mapsforge/map/layer/overlay/Polygon;->updatePoints()V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-void

    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized contains(Lorg/mapsforge/core/model/LatLong;)Z
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->latLongs:Ljava/util/List;

    invoke-static {v0, p1}, Lorg/mapsforge/core/util/LatLongUtils;->contains(Ljava/util/List;Lorg/mapsforge/core/model/LatLong;)Z

    move-result p1
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_9

    monitor-exit p0

    return p1

    :catchall_9
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    .registers 13

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->latLongs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x2

    if-lt v0, v1, :cond_99

    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    if-nez v0, :cond_14

    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->paintFill:Lorg/mapsforge/core/graphics/Paint;

    if-nez v0, :cond_14

    goto/16 :goto_99

    :cond_14
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    if-eqz v0, :cond_20

    invoke-virtual {v0, p1}, Lorg/mapsforge/core/model/BoundingBox;->intersects(Lorg/mapsforge/core/model/BoundingBox;)Z

    move-result p1
    :try_end_1c
    .catchall {:try_start_1 .. :try_end_1c} :catchall_9b

    if-nez p1, :cond_20

    monitor-exit p0

    return-void

    :cond_20
    :try_start_20
    iget-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->latLongs:Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPath()Lorg/mapsforge/core/graphics/Path;

    move-result-object v0

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/core/model/LatLong;

    iget-object v2, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v2

    invoke-static {p2, v2}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v2

    iget-wide v4, v1, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v4, v5, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v4

    iget-wide v6, p4, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v4, v6

    double-to-float p2, v4

    iget-wide v4, v1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v4, v5, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v4

    iget-wide v6, p4, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v4, v6

    double-to-float v1, v4

    invoke-interface {v0, p2, v1}, Lorg/mapsforge/core/graphics/Path;->moveTo(FF)V

    :goto_53
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_77

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lorg/mapsforge/core/model/LatLong;

    iget-wide v4, p2, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v4, v5, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v4

    iget-wide v6, p4, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v4, v6

    double-to-float v1, v4

    iget-wide v4, p2, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v4, v5, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v4

    iget-wide v6, p4, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v4, v6

    double-to-float p2, v4

    invoke-interface {v0, v1, p2}, Lorg/mapsforge/core/graphics/Path;->lineTo(FF)V

    goto :goto_53

    :cond_77
    iget-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    if-eqz p1, :cond_87

    iget-boolean p2, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->keepAligned:Z

    if-eqz p2, :cond_82

    invoke-interface {p1, p4}, Lorg/mapsforge/core/graphics/Paint;->setBitmapShaderShift(Lorg/mapsforge/core/model/Point;)V

    :cond_82
    iget-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->paintStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p3, v0, p1}, Lorg/mapsforge/core/graphics/GraphicContext;->drawPath(Lorg/mapsforge/core/graphics/Path;Lorg/mapsforge/core/graphics/Paint;)V

    :cond_87
    iget-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->paintFill:Lorg/mapsforge/core/graphics/Paint;

    if-eqz p1, :cond_97

    iget-boolean p2, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->keepAligned:Z

    if-eqz p2, :cond_92

    invoke-interface {p1, p4}, Lorg/mapsforge/core/graphics/Paint;->setBitmapShaderShift(Lorg/mapsforge/core/model/Point;)V

    :cond_92
    iget-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->paintFill:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p3, v0, p1}, Lorg/mapsforge/core/graphics/GraphicContext;->drawPath(Lorg/mapsforge/core/graphics/Path;Lorg/mapsforge/core/graphics/Paint;)V
    :try_end_97
    .catchall {:try_start_20 .. :try_end_97} :catchall_9b

    :cond_97
    monitor-exit p0

    return-void

    :cond_99
    :goto_99
    monitor-exit p0

    return-void

    :catchall_9b
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

    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->latLongs:Ljava/util/List;

    return-object v0
.end method

.method public declared-synchronized getPaintFill()Lorg/mapsforge/core/graphics/Paint;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->paintFill:Lorg/mapsforge/core/graphics/Paint;
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
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->paintStroke:Lorg/mapsforge/core/graphics/Paint;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public isKeepAligned()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->keepAligned:Z

    return v0
.end method

.method public declared-synchronized setPaintFill(Lorg/mapsforge/core/graphics/Paint;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->paintFill:Lorg/mapsforge/core/graphics/Paint;
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
    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->paintStroke:Lorg/mapsforge/core/graphics/Paint;
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
    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->latLongs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/overlay/Polygon;->latLongs:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    invoke-direct {p0}, Lorg/mapsforge/map/layer/overlay/Polygon;->updatePoints()V
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_10

    monitor-exit p0

    return-void

    :catchall_10
    move-exception p1

    monitor-exit p0

    throw p1
.end method
