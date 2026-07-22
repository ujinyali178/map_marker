.class Lorg/mapsforge/map/layer/renderer/RendererUtils;
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

.method static parallelPath([Lorg/mapsforge/core/model/Point;D)[Lorg/mapsforge/core/model/Point;
    .registers 21

    move-object/from16 v0, p0

    array-length v1, v0

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    new-array v3, v1, [Lorg/mapsforge/core/model/Point;

    array-length v4, v0

    new-array v4, v4, [Lorg/mapsforge/core/model/Point;

    const/4 v5, 0x0

    const/4 v6, 0x0

    :goto_c
    if-ge v6, v1, :cond_44

    add-int/lit8 v7, v6, 0x1

    aget-object v8, v0, v7

    iget-wide v9, v8, Lorg/mapsforge/core/model/Point;->x:D

    aget-object v11, v0, v6

    iget-wide v12, v11, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v9, v12

    iget-wide v12, v8, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v14, v11, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v12, v14

    mul-double v14, v9, v9

    mul-double v16, v12, v12

    add-double v14, v14, v16

    invoke-static {v14, v15}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v14

    move-object v11, v3

    const-wide/16 v2, 0x0

    cmpl-double v16, v14, v2

    if-nez v16, :cond_37

    new-instance v9, Lorg/mapsforge/core/model/Point;

    invoke-direct {v9, v2, v3, v2, v3}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    aput-object v9, v11, v6

    goto :goto_40

    :cond_37
    new-instance v2, Lorg/mapsforge/core/model/Point;

    div-double/2addr v9, v14

    div-double/2addr v12, v14

    invoke-direct {v2, v9, v10, v12, v13}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    aput-object v2, v11, v6

    :goto_40
    move v6, v7

    move-object v3, v11

    const/4 v2, 0x1

    goto :goto_c

    :cond_44
    move-object v11, v3

    new-instance v2, Lorg/mapsforge/core/model/Point;

    aget-object v3, v0, v5

    iget-wide v6, v3, Lorg/mapsforge/core/model/Point;->x:D

    aget-object v9, v11, v5

    iget-wide v12, v9, Lorg/mapsforge/core/model/Point;->y:D

    mul-double v12, v12, p1

    sub-double/2addr v6, v12

    iget-wide v12, v3, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v9, v9, Lorg/mapsforge/core/model/Point;->x:D

    mul-double v9, v9, p1

    add-double/2addr v12, v9

    invoke-direct {v2, v6, v7, v12, v13}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    aput-object v2, v4, v5

    const/4 v2, 0x1

    :goto_5f
    if-ge v2, v1, :cond_9c

    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    aget-object v3, v11, v2

    iget-wide v7, v3, Lorg/mapsforge/core/model/Point;->x:D

    add-int/lit8 v9, v2, -0x1

    aget-object v9, v11, v9

    iget-wide v12, v9, Lorg/mapsforge/core/model/Point;->x:D

    mul-double v14, v7, v12

    add-double/2addr v14, v5

    iget-wide v5, v3, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v9, v9, Lorg/mapsforge/core/model/Point;->y:D

    mul-double v16, v5, v9

    add-double v14, v14, v16

    div-double v14, p1, v14

    new-instance v3, Lorg/mapsforge/core/model/Point;

    move-object/from16 v16, v11

    aget-object v11, v0, v2

    move/from16 v17, v1

    iget-wide v0, v11, Lorg/mapsforge/core/model/Point;->x:D

    add-double/2addr v5, v9

    mul-double v5, v5, v14

    sub-double/2addr v0, v5

    iget-wide v5, v11, Lorg/mapsforge/core/model/Point;->y:D

    add-double/2addr v7, v12

    mul-double v14, v14, v7

    add-double/2addr v5, v14

    invoke-direct {v3, v0, v1, v5, v6}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    aput-object v3, v4, v2

    add-int/lit8 v2, v2, 0x1

    move-object/from16 v0, p0

    move-object/from16 v11, v16

    move/from16 v1, v17

    goto :goto_5f

    :cond_9c
    move/from16 v17, v1

    move-object/from16 v16, v11

    new-instance v0, Lorg/mapsforge/core/model/Point;

    aget-object v1, p0, v17

    iget-wide v2, v1, Lorg/mapsforge/core/model/Point;->x:D

    add-int/lit8 v5, v17, -0x1

    aget-object v5, v16, v5

    iget-wide v6, v5, Lorg/mapsforge/core/model/Point;->y:D

    mul-double v6, v6, p1

    sub-double/2addr v2, v6

    iget-wide v6, v1, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v8, v5, Lorg/mapsforge/core/model/Point;->x:D

    mul-double v8, v8, p1

    add-double/2addr v6, v8

    invoke-direct {v0, v2, v3, v6, v7}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    aput-object v0, v4, v17

    return-object v4
.end method
