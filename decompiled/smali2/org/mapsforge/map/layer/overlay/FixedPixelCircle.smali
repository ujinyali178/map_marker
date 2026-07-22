.class public Lorg/mapsforge/map/layer/overlay/FixedPixelCircle;
.super Lorg/mapsforge/map/layer/overlay/Circle;
.source "SourceFile"


# instance fields
.field private scaleRadius:Z


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/model/LatLong;FLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;)V
    .registers 11

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v5}, Lorg/mapsforge/map/layer/overlay/FixedPixelCircle;-><init>(Lorg/mapsforge/core/model/LatLong;FLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Z)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/core/model/LatLong;FLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Z)V
    .registers 6

    invoke-direct/range {p0 .. p5}, Lorg/mapsforge/map/layer/overlay/Circle;-><init>(Lorg/mapsforge/core/model/LatLong;FLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Z)V

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/overlay/FixedPixelCircle;->scaleRadius:Z

    return-void
.end method


# virtual methods
.method public declared-synchronized contains(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)Z
    .registers 6

    monitor-enter p0

    const/high16 v0, 0x41200000    # 10.0f

    :try_start_3
    iget-object v1, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v1

    mul-float v1, v1, v0

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/overlay/Circle;->getRadius()F

    move-result v0

    iget-boolean v2, p0, Lorg/mapsforge/map/layer/overlay/FixedPixelCircle;->scaleRadius:Z

    if-eqz v2, :cond_1a

    iget-object v2, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    goto :goto_1c

    :cond_1a
    const/high16 v2, 0x3f800000    # 1.0f

    :goto_1c
    mul-float v0, v0, v2

    invoke-static {v1, v0}, Ljava/lang/Math;->max(FF)F

    move-result v0

    float-to-double v0, v0

    invoke-virtual {p1, p2}, Lorg/mapsforge/core/model/Point;->distance(Lorg/mapsforge/core/model/Point;)D

    move-result-wide p1
    :try_end_27
    .catchall {:try_start_3 .. :try_end_27} :catchall_30

    cmpg-double v2, p1, v0

    if-gez v2, :cond_2d

    const/4 p1, 0x1

    goto :goto_2e

    :cond_2d
    const/4 p1, 0x0

    :goto_2e
    monitor-exit p0

    return p1

    :catchall_30
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method protected getRadiusInPixels(DB)I
    .registers 4

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/overlay/Circle;->getRadius()F

    move-result p1

    iget-boolean p2, p0, Lorg/mapsforge/map/layer/overlay/FixedPixelCircle;->scaleRadius:Z

    if-eqz p2, :cond_f

    iget-object p2, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result p2

    goto :goto_11

    :cond_f
    const/high16 p2, 0x3f800000    # 1.0f

    :goto_11
    mul-float p1, p1, p2

    float-to-int p1, p1

    return p1
.end method

.method public isScaleRadius()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/overlay/FixedPixelCircle;->scaleRadius:Z

    return v0
.end method

.method public setScaleRadius(Z)V
    .registers 2

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/overlay/FixedPixelCircle;->scaleRadius:Z

    return-void
.end method
