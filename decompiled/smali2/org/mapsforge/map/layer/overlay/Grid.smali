.class public Lorg/mapsforge/map/layer/overlay/Grid;
.super Lorg/mapsforge/map/layer/Layer;
.source "SourceFile"


# instance fields
.field private final lineBack:Lorg/mapsforge/core/graphics/Paint;

.field private final lineFront:Lorg/mapsforge/core/graphics/Paint;

.field private final spacingConfig:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Byte;",
            "Ljava/lang/Double;",
            ">;"
        }
    .end annotation
.end field

.field private final textBack:Lorg/mapsforge/core/graphics/Paint;

.field private final textFront:Lorg/mapsforge/core/graphics/Paint;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/util/Map;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/core/graphics/GraphicFactory;",
            "Lorg/mapsforge/map/model/DisplayModel;",
            "Ljava/util/Map<",
            "Ljava/lang/Byte;",
            "Ljava/lang/Double;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iput-object p3, p0, Lorg/mapsforge/map/layer/overlay/Grid;->spacingConfig:Ljava/util/Map;

    invoke-static {p1, p2}, Lorg/mapsforge/map/layer/overlay/Grid;->createLineBack(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object p3

    iput-object p3, p0, Lorg/mapsforge/map/layer/overlay/Grid;->lineBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {p1, p2}, Lorg/mapsforge/map/layer/overlay/Grid;->createLineFront(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object p3

    iput-object p3, p0, Lorg/mapsforge/map/layer/overlay/Grid;->lineFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {p1, p2}, Lorg/mapsforge/map/layer/overlay/Grid;->createTextBack(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object p3

    iput-object p3, p0, Lorg/mapsforge/map/layer/overlay/Grid;->textBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {p1, p2}, Lorg/mapsforge/map/layer/overlay/Grid;->createTextFront(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/layer/overlay/Grid;->textFront:Lorg/mapsforge/core/graphics/Paint;

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/model/DisplayModel;Ljava/util/Map;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/model/DisplayModel;",
            "Ljava/util/Map<",
            "Ljava/lang/Byte;",
            "Ljava/lang/Double;",
            ">;",
            "Lorg/mapsforge/core/graphics/Paint;",
            "Lorg/mapsforge/core/graphics/Paint;",
            "Lorg/mapsforge/core/graphics/Paint;",
            "Lorg/mapsforge/core/graphics/Paint;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iput-object p2, p0, Lorg/mapsforge/map/layer/overlay/Grid;->spacingConfig:Ljava/util/Map;

    iput-object p3, p0, Lorg/mapsforge/map/layer/overlay/Grid;->lineBack:Lorg/mapsforge/core/graphics/Paint;

    iput-object p4, p0, Lorg/mapsforge/map/layer/overlay/Grid;->lineFront:Lorg/mapsforge/core/graphics/Paint;

    iput-object p5, p0, Lorg/mapsforge/map/layer/overlay/Grid;->textBack:Lorg/mapsforge/core/graphics/Paint;

    iput-object p6, p0, Lorg/mapsforge/map/layer/overlay/Grid;->textFront:Lorg/mapsforge/core/graphics/Paint;

    return-void
.end method

.method private static convertCoordinate(D)Ljava/lang/String;
    .registers 9

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-wide/16 v1, 0x0

    cmpg-double v3, p0, v1

    if-gez v3, :cond_11

    const/16 v1, 0x2d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    neg-double p0, p0

    :cond_11
    new-instance v1, Ljava/text/DecimalFormat;

    const-string v2, "00"

    invoke-direct {v1, v2}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    invoke-static {p0, p1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    double-to-int v2, v2

    int-to-long v3, v2

    invoke-virtual {v1, v3, v4}, Ljava/text/NumberFormat;->format(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v3, 0xb0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    int-to-double v2, v2

    sub-double/2addr p0, v2

    const-wide/high16 v2, 0x404e000000000000L    # 60.0

    mul-double p0, p0, v2

    invoke-static {p0, p1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    double-to-int v4, v4

    int-to-long v5, v4

    invoke-virtual {v1, v5, v6}, Ljava/text/NumberFormat;->format(J)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v5, 0x2032

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    int-to-double v4, v4

    sub-double/2addr p0, v4

    mul-double p0, p0, v2

    invoke-virtual {v1, p0, p1}, Ljava/text/NumberFormat;->format(D)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 p0, 0x2033

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static createLineBack(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;
    .registers 3

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p0

    sget-object v0, Lorg/mapsforge/core/graphics/Color;->WHITE:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {p0, v0}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    invoke-virtual {p1}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result p1

    const/high16 v0, 0x40800000    # 4.0f

    mul-float p1, p1, v0

    invoke-interface {p0, p1}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    sget-object p1, Lorg/mapsforge/core/graphics/Style;->STROKE:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {p0, p1}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    return-object p0
.end method

.method private static createLineFront(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;
    .registers 3

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p0

    sget-object v0, Lorg/mapsforge/core/graphics/Color;->BLUE:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {p0, v0}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    invoke-virtual {p1}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result p1

    const/high16 v0, 0x40000000    # 2.0f

    mul-float p1, p1, v0

    invoke-interface {p0, p1}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    sget-object p1, Lorg/mapsforge/core/graphics/Style;->STROKE:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {p0, p1}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    return-object p0
.end method

.method private static createTextBack(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;
    .registers 4

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p0

    sget-object v0, Lorg/mapsforge/core/graphics/Color;->WHITE:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {p0, v0}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object v0, Lorg/mapsforge/core/graphics/FontFamily;->DEFAULT:Lorg/mapsforge/core/graphics/FontFamily;

    sget-object v1, Lorg/mapsforge/core/graphics/FontStyle;->BOLD:Lorg/mapsforge/core/graphics/FontStyle;

    invoke-interface {p0, v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setTypeface(Lorg/mapsforge/core/graphics/FontFamily;Lorg/mapsforge/core/graphics/FontStyle;)V

    invoke-virtual {p1}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v0

    const/high16 v1, 0x41400000    # 12.0f

    mul-float v0, v0, v1

    invoke-interface {p0, v0}, Lorg/mapsforge/core/graphics/Paint;->setTextSize(F)V

    invoke-virtual {p1}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result p1

    const/high16 v0, 0x40800000    # 4.0f

    mul-float p1, p1, v0

    invoke-interface {p0, p1}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    sget-object p1, Lorg/mapsforge/core/graphics/Style;->STROKE:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {p0, p1}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    return-object p0
.end method

.method private static createTextFront(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;
    .registers 4

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p0

    sget-object v0, Lorg/mapsforge/core/graphics/Color;->BLUE:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {p0, v0}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object v0, Lorg/mapsforge/core/graphics/FontFamily;->DEFAULT:Lorg/mapsforge/core/graphics/FontFamily;

    sget-object v1, Lorg/mapsforge/core/graphics/FontStyle;->BOLD:Lorg/mapsforge/core/graphics/FontStyle;

    invoke-interface {p0, v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setTypeface(Lorg/mapsforge/core/graphics/FontFamily;Lorg/mapsforge/core/graphics/FontStyle;)V

    invoke-virtual {p1}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result p1

    const/high16 v0, 0x41400000    # 12.0f

    mul-float p1, p1, v0

    invoke-interface {p0, p1}, Lorg/mapsforge/core/graphics/Paint;->setTextSize(F)V

    return-object p0
.end method


# virtual methods
.method public draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    .registers 34

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v7, p3

    move-object/from16 v8, p4

    iget-object v2, v0, Lorg/mapsforge/map/layer/overlay/Grid;->spacingConfig:Ljava/util/Map;

    invoke-static/range {p2 .. p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_184

    iget-object v2, v0, Lorg/mapsforge/map/layer/overlay/Grid;->spacingConfig:Ljava/util/Map;

    invoke-static/range {p2 .. p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Double;

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v9

    iget-wide v2, v1, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    div-double/2addr v2, v9

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    mul-double v11, v9, v2

    iget-wide v2, v1, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    div-double/2addr v2, v9

    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    mul-double v13, v9, v2

    iget-wide v2, v1, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    div-double/2addr v2, v9

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    mul-double v5, v9, v2

    iget-wide v1, v1, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    div-double/2addr v1, v9

    invoke-static {v1, v2}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v1

    mul-double v3, v9, v1

    iget-object v1, v0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v1

    move/from16 v2, p2

    invoke-static {v2, v1}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v1

    invoke-static {v5, v6, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v15

    move-wide/from16 v17, v5

    iget-wide v5, v8, Lorg/mapsforge/core/model/Point;->y:D

    sub-double v5, v15, v5

    double-to-int v15, v5

    invoke-static {v3, v4, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v5

    move-wide/from16 v19, v9

    iget-wide v9, v8, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v5, v9

    double-to-int v9, v5

    invoke-static {v11, v12, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v5

    move-wide/from16 v21, v11

    iget-wide v10, v8, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v5, v10

    double-to-int v10, v5

    invoke-static {v13, v14, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v5

    iget-wide v11, v8, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v5, v11

    double-to-int v11, v5

    move-wide/from16 v5, v17

    :goto_7d
    cmpg-double v12, v5, v3

    if-gtz v12, :cond_ab

    invoke-static {v5, v6, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v23

    move-wide/from16 p1, v1

    iget-wide v1, v8, Lorg/mapsforge/core/model/Point;->y:D

    sub-double v1, v23, v1

    double-to-int v12, v1

    iget-object v2, v0, Lorg/mapsforge/map/layer/overlay/Grid;->lineBack:Lorg/mapsforge/core/graphics/Paint;

    move-wide/from16 v7, p1

    move-object/from16 v1, p3

    move-object/from16 v16, v2

    move v2, v10

    move-wide/from16 v23, v3

    move v3, v12

    move v4, v11

    move-wide/from16 v25, v5

    move v5, v12

    move-object/from16 v6, v16

    invoke-interface/range {v1 .. v6}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    add-double v5, v25, v19

    move-wide v1, v7

    move-wide/from16 v3, v23

    move-object/from16 v7, p3

    move-object/from16 v8, p4

    goto :goto_7d

    :cond_ab
    move-wide v7, v1

    move-wide/from16 v23, v3

    move-wide/from16 v5, v21

    :goto_b0
    cmpg-double v1, v5, v13

    if-gtz v1, :cond_d7

    invoke-static {v5, v6, v7, v8}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v1

    move-wide/from16 p1, v7

    move-object/from16 v7, p4

    iget-wide v3, v7, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v1, v3

    double-to-int v4, v1

    iget-object v8, v0, Lorg/mapsforge/map/layer/overlay/Grid;->lineBack:Lorg/mapsforge/core/graphics/Paint;

    move-object/from16 v1, p3

    move v2, v4

    move-wide/from16 v25, v13

    move-wide/from16 v12, p1

    move v3, v15

    move-wide/from16 v27, v5

    move v5, v9

    move-object v6, v8

    invoke-interface/range {v1 .. v6}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    add-double v5, v27, v19

    move-wide v7, v12

    move-wide/from16 v13, v25

    goto :goto_b0

    :cond_d7
    move-wide/from16 v25, v13

    move-wide v12, v7

    move-object/from16 v7, p4

    move-wide/from16 v5, v17

    :goto_de
    cmpg-double v1, v5, v23

    if-gtz v1, :cond_fb

    invoke-static {v5, v6, v12, v13}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v1

    iget-wide v3, v7, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v1, v3

    double-to-int v8, v1

    iget-object v14, v0, Lorg/mapsforge/map/layer/overlay/Grid;->lineFront:Lorg/mapsforge/core/graphics/Paint;

    move-object/from16 v1, p3

    move v2, v10

    move v3, v8

    move v4, v11

    move-wide/from16 v27, v5

    move v5, v8

    move-object v6, v14

    invoke-interface/range {v1 .. v6}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    add-double v5, v27, v19

    goto :goto_de

    :cond_fb
    move-wide/from16 v10, v21

    :goto_fd
    cmpg-double v1, v10, v25

    if-gtz v1, :cond_116

    invoke-static {v10, v11, v12, v13}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v1

    iget-wide v3, v7, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v1, v3

    double-to-int v4, v1

    iget-object v6, v0, Lorg/mapsforge/map/layer/overlay/Grid;->lineFront:Lorg/mapsforge/core/graphics/Paint;

    move-object/from16 v1, p3

    move v2, v4

    move v3, v15

    move v5, v9

    invoke-interface/range {v1 .. v6}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    add-double v10, v10, v19

    goto :goto_fd

    :cond_116
    move-wide/from16 v5, v17

    :goto_118
    cmpg-double v1, v5, v23

    if-gtz v1, :cond_14d

    invoke-static {v5, v6}, Lorg/mapsforge/map/layer/overlay/Grid;->convertCoordinate(D)Ljava/lang/String;

    move-result-object v1

    invoke-interface/range {p3 .. p3}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v2

    iget-object v3, v0, Lorg/mapsforge/map/layer/overlay/Grid;->textFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v3, v1}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result v3

    sub-int/2addr v2, v3

    div-int/lit8 v2, v2, 0x2

    invoke-static {v5, v6, v12, v13}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v3

    iget-wide v8, v7, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v3, v8

    double-to-int v3, v3

    iget-object v4, v0, Lorg/mapsforge/map/layer/overlay/Grid;->textFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v4, v1}, Lorg/mapsforge/core/graphics/Paint;->getTextHeight(Ljava/lang/String;)I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    add-int/2addr v3, v4

    iget-object v4, v0, Lorg/mapsforge/map/layer/overlay/Grid;->textBack:Lorg/mapsforge/core/graphics/Paint;

    move-object/from16 v8, p3

    invoke-interface {v8, v1, v2, v3, v4}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    iget-object v4, v0, Lorg/mapsforge/map/layer/overlay/Grid;->textFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v8, v1, v2, v3, v4}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    add-double v5, v5, v19

    goto :goto_118

    :cond_14d
    move-object/from16 v8, p3

    move-wide/from16 v1, v21

    :goto_151
    cmpg-double v3, v1, v25

    if-gtz v3, :cond_184

    invoke-static {v1, v2}, Lorg/mapsforge/map/layer/overlay/Grid;->convertCoordinate(D)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v2, v12, v13}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v4

    iget-wide v9, v7, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v4, v9

    double-to-int v4, v4

    iget-object v5, v0, Lorg/mapsforge/map/layer/overlay/Grid;->textFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v5, v3}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result v5

    div-int/lit8 v5, v5, 0x2

    sub-int/2addr v4, v5

    invoke-interface/range {p3 .. p3}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v5

    iget-object v6, v0, Lorg/mapsforge/map/layer/overlay/Grid;->textFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v6, v3}, Lorg/mapsforge/core/graphics/Paint;->getTextHeight(Ljava/lang/String;)I

    move-result v6

    add-int/2addr v5, v6

    div-int/lit8 v5, v5, 0x2

    iget-object v6, v0, Lorg/mapsforge/map/layer/overlay/Grid;->textBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v8, v3, v4, v5, v6}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    iget-object v6, v0, Lorg/mapsforge/map/layer/overlay/Grid;->textFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v8, v3, v4, v5, v6}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    add-double v1, v1, v19

    goto :goto_151

    :cond_184
    return-void
.end method
