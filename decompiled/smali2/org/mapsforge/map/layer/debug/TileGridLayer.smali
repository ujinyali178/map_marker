.class public Lorg/mapsforge/map/layer/debug/TileGridLayer;
.super Lorg/mapsforge/map/layer/Layer;
.source "SourceFile"


# instance fields
.field private final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field private final paintBack:Lorg/mapsforge/core/graphics/Paint;

.field private final paintFront:Lorg/mapsforge/core/graphics/Paint;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 4

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/layer/debug/TileGridLayer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-static {p1, p2}, Lorg/mapsforge/map/layer/debug/TileGridLayer;->createPaintBack(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/layer/debug/TileGridLayer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {p1, p2}, Lorg/mapsforge/map/layer/debug/TileGridLayer;->createPaintFront(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/layer/debug/TileGridLayer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;)V
    .registers 4

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/debug/TileGridLayer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iput-object p2, p0, Lorg/mapsforge/map/layer/debug/TileGridLayer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    iput-object p3, p0, Lorg/mapsforge/map/layer/debug/TileGridLayer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    return-void
.end method

.method private static createPaintBack(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;
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

.method private static createPaintFront(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;
    .registers 3

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p0

    sget-object v0, Lorg/mapsforge/core/graphics/Color;->RED:Lorg/mapsforge/core/graphics/Color;

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


# virtual methods
.method public draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    .registers 22

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, p2

    move-object/from16 v3, p4

    iget-wide v4, v1, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-static {v4, v5, v2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToTileX(DB)I

    move-result v4

    int-to-long v4, v4

    iget-wide v6, v1, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {v6, v7, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToTileY(DB)I

    move-result v6

    int-to-long v6, v6

    iget-wide v8, v1, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-static {v8, v9, v2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToTileX(DB)I

    move-result v8

    int-to-long v8, v8

    iget-wide v10, v1, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {v10, v11, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToTileY(DB)I

    move-result v1

    int-to-long v1, v1

    iget-object v10, v0, Lorg/mapsforge/map/layer/debug/TileGridLayer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v10}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v10

    invoke-static {v4, v5, v10}, Lorg/mapsforge/core/util/MercatorProjection;->tileToPixel(JI)J

    move-result-wide v4

    long-to-double v4, v4

    iget-wide v11, v3, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v4, v11

    double-to-int v4, v4

    invoke-static {v6, v7, v10}, Lorg/mapsforge/core/util/MercatorProjection;->tileToPixel(JI)J

    move-result-wide v5

    long-to-double v5, v5

    iget-wide v11, v3, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v5, v11

    double-to-int v5, v5

    invoke-static {v8, v9, v10}, Lorg/mapsforge/core/util/MercatorProjection;->tileToPixel(JI)J

    move-result-wide v6

    long-to-double v6, v6

    iget-wide v8, v3, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v6, v8

    int-to-double v8, v10

    add-double/2addr v6, v8

    double-to-int v6, v6

    invoke-static {v1, v2, v10}, Lorg/mapsforge/core/util/MercatorProjection;->tileToPixel(JI)J

    move-result-wide v1

    long-to-double v1, v1

    iget-wide v11, v3, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v1, v11

    add-double/2addr v1, v8

    double-to-int v1, v1

    move v2, v4

    :goto_52
    add-int/lit8 v3, v6, 0x1

    if-gt v2, v3, :cond_65

    iget-object v3, v0, Lorg/mapsforge/map/layer/debug/TileGridLayer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    move-object/from16 v11, p3

    move v12, v2

    move v13, v5

    move v14, v2

    move v15, v1

    move-object/from16 v16, v3

    invoke-interface/range {v11 .. v16}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    add-int/2addr v2, v10

    goto :goto_52

    :cond_65
    move v2, v5

    :goto_66
    add-int/lit8 v7, v1, 0x1

    if-gt v2, v7, :cond_79

    iget-object v7, v0, Lorg/mapsforge/map/layer/debug/TileGridLayer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    move-object/from16 v11, p3

    move v12, v4

    move v13, v2

    move v14, v6

    move v15, v2

    move-object/from16 v16, v7

    invoke-interface/range {v11 .. v16}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    add-int/2addr v2, v10

    goto :goto_66

    :cond_79
    move v2, v4

    :goto_7a
    if-gt v2, v3, :cond_8b

    iget-object v8, v0, Lorg/mapsforge/map/layer/debug/TileGridLayer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    move-object/from16 v11, p3

    move v12, v2

    move v13, v5

    move v14, v2

    move v15, v1

    move-object/from16 v16, v8

    invoke-interface/range {v11 .. v16}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    add-int/2addr v2, v10

    goto :goto_7a

    :cond_8b
    :goto_8b
    if-gt v5, v7, :cond_9c

    iget-object v1, v0, Lorg/mapsforge/map/layer/debug/TileGridLayer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    move-object/from16 v11, p3

    move v12, v4

    move v13, v5

    move v14, v6

    move v15, v5

    move-object/from16 v16, v1

    invoke-interface/range {v11 .. v16}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    add-int/2addr v5, v10

    goto :goto_8b

    :cond_9c
    return-void
.end method
