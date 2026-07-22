.class final Lorg/mapsforge/map/layer/renderer/GeometryUtils;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method static calculateCenterOfBoundingBox([Lorg/mapsforge/core/model/Point;)Lorg/mapsforge/core/model/Point;
    .registers 15

    const/4 v0, 0x0

    aget-object v1, p0, v0

    iget-wide v2, v1, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v4, v1, Lorg/mapsforge/core/model/Point;->y:D

    array-length v1, p0

    move-wide v6, v4

    move-wide v8, v6

    move-wide v4, v2

    :goto_b
    if-ge v0, v1, :cond_2c

    aget-object v10, p0, v0

    iget-wide v11, v10, Lorg/mapsforge/core/model/Point;->x:D

    cmpg-double v13, v11, v2

    if-gez v13, :cond_17

    move-wide v2, v11

    goto :goto_1c

    :cond_17
    cmpl-double v13, v11, v4

    if-lez v13, :cond_1c

    move-wide v4, v11

    :cond_1c
    :goto_1c
    iget-wide v10, v10, Lorg/mapsforge/core/model/Point;->y:D

    cmpg-double v12, v10, v8

    if-gez v12, :cond_24

    move-wide v8, v10

    goto :goto_29

    :cond_24
    cmpl-double v12, v10, v6

    if-lez v12, :cond_29

    move-wide v6, v10

    :cond_29
    :goto_29
    add-int/lit8 v0, v0, 0x1

    goto :goto_b

    :cond_2c
    new-instance p0, Lorg/mapsforge/core/model/Point;

    add-double/2addr v2, v4

    const-wide/high16 v0, 0x4000000000000000L    # 2.0

    div-double/2addr v2, v0

    add-double/2addr v6, v8

    div-double/2addr v6, v0

    invoke-direct {p0, v2, v3, v6, v7}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object p0
.end method
