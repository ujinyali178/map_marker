.class final Lorg/mapsforge/map/layer/renderer/WayDecorator;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final MAX_LABEL_CORNER_ANGLE:D = 45.0


# direct methods
.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method static renderSymbol(Lorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/core/graphics/Display;IFZZFFZ[[Lorg/mapsforge/core/model/Point;Ljava/util/List;)V
    .registers 38
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/core/graphics/Bitmap;",
            "Lorg/mapsforge/core/graphics/Display;",
            "IFZZFFZ[[",
            "Lorg/mapsforge/core/model/Point;",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/mapelements/MapElementContainer;",
            ">;)V"
        }
    .end annotation

    move/from16 v0, p3

    move/from16 v1, p7

    float-to-int v2, v1

    const/4 v3, 0x0

    const/4 v4, 0x0

    cmpl-float v5, v0, v3

    if-nez v5, :cond_e

    aget-object v0, p9, v4

    goto :goto_15

    :cond_e
    aget-object v5, p9, v4

    float-to-double v6, v0

    invoke-static {v5, v6, v7}, Lorg/mapsforge/map/layer/renderer/RendererUtils;->parallelPath([Lorg/mapsforge/core/model/Point;D)[Lorg/mapsforge/core/model/Point;

    move-result-object v0

    :goto_15
    aget-object v4, v0, v4

    iget-wide v5, v4, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v7, v4, Lorg/mapsforge/core/model/Point;->y:D

    const/4 v4, 0x1

    move v9, v2

    :goto_1d
    array-length v10, v0

    if-ge v4, v10, :cond_a5

    aget-object v10, v0, v4

    iget-wide v11, v10, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v13, v10, Lorg/mapsforge/core/model/Point;->y:D

    sub-double v15, v11, v5

    sub-double v17, v13, v7

    mul-double v19, v15, v15

    mul-double v21, v17, v17

    add-double v19, v19, v21

    move v10, v2

    move/from16 p3, v3

    invoke-static/range {v19 .. v20}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v2

    double-to-float v2, v2

    move/from16 v3, p3

    :goto_3a
    int-to-float v9, v9

    sub-float v19, v2, v9

    cmpl-float v20, v19, v1

    if-lez v20, :cond_8a

    div-float/2addr v9, v2

    move/from16 p3, v3

    float-to-double v2, v9

    mul-double v15, v15, v2

    add-double/2addr v5, v15

    mul-double v17, v17, v2

    add-double v7, v7, v17

    if-eqz p8, :cond_5a

    sub-double v2, v13, v7

    move/from16 p9, v10

    sub-double v9, v11, v5

    invoke-static {v2, v3, v9, v10}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide v2

    double-to-float v3, v2

    goto :goto_5e

    :cond_5a
    move/from16 p9, v10

    move/from16 v3, p3

    :goto_5e
    new-instance v2, Lorg/mapsforge/core/model/Point;

    invoke-direct {v2, v5, v6, v7, v8}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    new-instance v9, Lorg/mapsforge/core/mapelements/SymbolContainer;

    move-object/from16 v20, v9

    move-object/from16 v21, v2

    move-object/from16 v22, p1

    move/from16 v23, p2

    move-object/from16 v24, p0

    move/from16 v25, v3

    move/from16 v26, p4

    invoke-direct/range {v20 .. v26}, Lorg/mapsforge/core/mapelements/SymbolContainer;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILorg/mapsforge/core/graphics/Bitmap;FZ)V

    move-object/from16 v10, p10

    invoke-interface {v10, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    if-nez p5, :cond_7e

    return-void

    :cond_7e
    sub-double v15, v11, v5

    sub-double v17, v13, v7

    move/from16 v2, p6

    float-to-int v9, v2

    move/from16 v10, p9

    move/from16 v2, v19

    goto :goto_3a

    :cond_8a
    move/from16 p3, v3

    move/from16 p9, v10

    move-object/from16 v10, p10

    sub-float/2addr v9, v2

    float-to-int v2, v9

    int-to-float v3, v2

    cmpg-float v3, v3, v1

    if-gez v3, :cond_9a

    move/from16 v9, p9

    goto :goto_9b

    :cond_9a
    move v9, v2

    :goto_9b
    add-int/lit8 v4, v4, 0x1

    move/from16 v3, p3

    move/from16 v2, p9

    move-wide v5, v11

    move-wide v7, v13

    goto/16 :goto_1d

    :cond_a5
    return-void
.end method

.method static renderText(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Ljava/lang/String;Lorg/mapsforge/core/graphics/Display;IFLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;ZFFZ[[Lorg/mapsforge/core/model/Point;Ljava/util/List;)V
    .registers 39
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/core/graphics/GraphicFactory;",
            "Lorg/mapsforge/core/model/Tile;",
            "Lorg/mapsforge/core/model/Tile;",
            "Ljava/lang/String;",
            "Lorg/mapsforge/core/graphics/Display;",
            "IF",
            "Lorg/mapsforge/core/graphics/Paint;",
            "Lorg/mapsforge/core/graphics/Paint;",
            "ZFFZ[[",
            "Lorg/mapsforge/core/model/Point;",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/mapelements/MapElementContainer;",
            ">;)V"
        }
    .end annotation

    move-object/from16 v10, p3

    move/from16 v0, p6

    move-object/from16 v11, p7

    move-object/from16 v12, p8

    move-object/from16 v1, p13

    array-length v2, v1

    if-nez v2, :cond_e

    return-void

    :cond_e
    const/4 v2, 0x0

    const/4 v13, 0x0

    cmpl-float v2, v0, v2

    if-nez v2, :cond_17

    aget-object v0, v1, v13

    goto :goto_1e

    :cond_17
    aget-object v1, v1, v13

    float-to-double v2, v0

    invoke-static {v1, v2, v3}, Lorg/mapsforge/map/layer/renderer/RendererUtils;->parallelPath([Lorg/mapsforge/core/model/Point;D)[Lorg/mapsforge/core/model/Point;

    move-result-object v0

    :goto_1e
    array-length v1, v0

    const/4 v2, 0x2

    if-ge v1, v2, :cond_23

    return-void

    :cond_23
    new-instance v14, Lorg/mapsforge/core/model/LineString;

    invoke-direct {v14}, Lorg/mapsforge/core/model/LineString;-><init>()V

    const/4 v15, 0x1

    const/4 v1, 0x1

    :goto_2a
    array-length v2, v0

    if-ge v1, v2, :cond_40

    new-instance v2, Lorg/mapsforge/core/model/LineSegment;

    add-int/lit8 v3, v1, -0x1

    aget-object v3, v0, v3

    aget-object v4, v0, v1

    invoke-direct {v2, v3, v4}, Lorg/mapsforge/core/model/LineSegment;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)V

    iget-object v3, v14, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_2a

    :cond_40
    if-nez v12, :cond_47

    invoke-interface {v11, v10}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result v0

    goto :goto_4b

    :cond_47
    invoke-interface {v12, v10}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result v0

    :goto_4b
    move v8, v0

    if-nez v12, :cond_53

    invoke-interface {v11, v10}, Lorg/mapsforge/core/graphics/Paint;->getTextHeight(Ljava/lang/String;)I

    move-result v0

    goto :goto_57

    :cond_53
    invoke-interface {v12, v10}, Lorg/mapsforge/core/graphics/Paint;->getTextHeight(Ljava/lang/String;)I

    move-result v0

    :goto_57
    move v9, v0

    invoke-virtual {v14}, Lorg/mapsforge/core/model/LineString;->length()D

    move-result-wide v16

    move/from16 v7, p11

    :goto_5e
    int-to-float v6, v8

    add-float v0, v7, v6

    float-to-double v0, v0

    cmpg-double v2, v0, v16

    if-gez v2, :cond_d9

    float-to-double v2, v7

    invoke-virtual {v14, v2, v3, v0, v1}, Lorg/mapsforge/core/model/LineString;->extractPart(DD)Lorg/mapsforge/core/model/LineString;

    move-result-object v2

    const/4 v0, 0x1

    :goto_6c
    iget-object v1, v2, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_9c

    iget-object v1, v2, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    add-int/lit8 v3, v0, -0x1

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/core/model/LineSegment;

    iget-object v3, v2, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/core/model/LineSegment;

    invoke-virtual {v1, v3}, Lorg/mapsforge/core/model/LineSegment;->angleTo(Lorg/mapsforge/core/model/LineSegment;)D

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Math;->abs(D)D

    move-result-wide v3

    const-wide v18, 0x4046800000000000L    # 45.0

    cmpl-double v1, v3, v18

    if-lez v1, :cond_99

    const/4 v0, 0x1

    goto :goto_9d

    :cond_99
    add-int/lit8 v0, v0, 0x1

    goto :goto_6c

    :cond_9c
    const/4 v0, 0x0

    :goto_9d
    if-eqz v0, :cond_aa

    move-object/from16 v0, p14

    move/from16 v20, v6

    move/from16 v21, v7

    move/from16 v22, v8

    move/from16 v23, v9

    goto :goto_cf

    :cond_aa
    new-instance v5, Lorg/mapsforge/core/mapelements/WayTextContainer;

    int-to-double v3, v9

    move-object v0, v5

    move-object/from16 v1, p0

    move-wide/from16 v18, v3

    move-object/from16 v3, p4

    move/from16 v4, p5

    move-object v13, v5

    move-object/from16 v5, p3

    move/from16 v20, v6

    move-object/from16 v6, p7

    move/from16 v21, v7

    move-object/from16 v7, p8

    move/from16 v22, v8

    move/from16 v23, v9

    move-wide/from16 v8, v18

    invoke-direct/range {v0 .. v9}, Lorg/mapsforge/core/mapelements/WayTextContainer;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/core/model/LineString;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;D)V

    move-object/from16 v0, p14

    invoke-interface {v0, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :goto_cf
    add-float v1, p10, v20

    add-float v7, v21, v1

    move/from16 v8, v22

    move/from16 v9, v23

    const/4 v13, 0x0

    goto :goto_5e

    :cond_d9
    return-void
.end method
