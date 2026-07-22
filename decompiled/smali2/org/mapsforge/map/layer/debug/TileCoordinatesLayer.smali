.class public Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;
.super Lorg/mapsforge/map/layer/Layer;
.source "SourceFile"


# instance fields
.field private final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field private drawSimple:Z

.field private final paintBack:Lorg/mapsforge/core/graphics/Paint;

.field private final paintFront:Lorg/mapsforge/core/graphics/Paint;

.field private final stringBuilder:Ljava/lang/StringBuilder;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 4

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    iput-object p2, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-static {p1, p2}, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->createPaintBack(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {p1, p2}, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->createPaintFront(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;)V
    .registers 5

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    iput-object p1, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iput-object p2, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    iput-object p3, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    return-void
.end method

.method private static createPaintBack(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;
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

    const/high16 v0, 0x40000000    # 2.0f

    mul-float p1, p1, v0

    invoke-interface {p0, p1}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    sget-object p1, Lorg/mapsforge/core/graphics/Style;->STROKE:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {p0, p1}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    return-object p0
.end method

.method private static createPaintFront(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;
    .registers 4

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p0

    sget-object v0, Lorg/mapsforge/core/graphics/Color;->RED:Lorg/mapsforge/core/graphics/Color;

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

.method private drawTileCoordinates(Lorg/mapsforge/map/layer/TilePosition;Lorg/mapsforge/core/graphics/Canvas;)V
    .registers 11

    iget-object v0, p1, Lorg/mapsforge/map/layer/TilePosition;->tile:Lorg/mapsforge/core/model/Tile;

    iget-boolean v1, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->drawSimple:Z

    const/4 v2, 0x0

    if-eqz v1, :cond_5b

    iget-object v1, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->setLength(I)V

    iget-object v1, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    iget-byte v2, v0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v2, " / "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v3, v0, Lorg/mapsforge/core/model/Tile;->tileX:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v2, v0, Lorg/mapsforge/core/model/Tile;->tileY:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p1, Lorg/mapsforge/map/layer/TilePosition;->point:Lorg/mapsforge/core/model/Point;

    iget-wide v2, v2, Lorg/mapsforge/core/model/Point;->x:D

    iget v4, v0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    iget-object v5, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v5, v1}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result v5

    sub-int/2addr v4, v5

    div-int/lit8 v4, v4, 0x2

    int-to-double v4, v4

    add-double/2addr v2, v4

    double-to-int v2, v2

    iget-object p1, p1, Lorg/mapsforge/map/layer/TilePosition;->point:Lorg/mapsforge/core/model/Point;

    iget-wide v3, p1, Lorg/mapsforge/core/model/Point;->y:D

    iget p1, v0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    iget-object v0, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->getTextHeight(Ljava/lang/String;)I

    move-result v0

    add-int/2addr p1, v0

    div-int/lit8 p1, p1, 0x2

    int-to-double v5, p1

    add-double/2addr v3, v5

    double-to-int p1, v3

    iget-object v0, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p2, v1, v2, p1, v0}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p2, v1, v2, p1, v0}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    goto/16 :goto_111

    :cond_5b
    iget-object v1, p1, Lorg/mapsforge/map/layer/TilePosition;->point:Lorg/mapsforge/core/model/Point;

    iget-wide v3, v1, Lorg/mapsforge/core/model/Point;->x:D

    const/high16 v1, 0x41000000    # 8.0f

    iget-object v5, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v5}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v5

    mul-float v5, v5, v1

    float-to-double v5, v5

    add-double/2addr v3, v5

    double-to-int v1, v3

    iget-object p1, p1, Lorg/mapsforge/map/layer/TilePosition;->point:Lorg/mapsforge/core/model/Point;

    iget-wide v3, p1, Lorg/mapsforge/core/model/Point;->y:D

    iget-object p1, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {p1}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result p1

    const/high16 v5, 0x41c00000    # 24.0f

    mul-float p1, p1, v5

    float-to-double v6, p1

    add-double/2addr v3, v6

    double-to-int p1, v3

    iget-object v3, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->setLength(I)V

    iget-object v3, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    const-string v4, "X: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    iget v4, v0, Lorg/mapsforge/core/model/Tile;->tileX:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p2, v3, v1, p1, v4}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    iget-object v4, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p2, v3, v1, p1, v4}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    iget-object v3, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->setLength(I)V

    iget-object v3, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    const-string v4, "Y: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    iget v4, v0, Lorg/mapsforge/core/model/Tile;->tileY:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    int-to-float p1, p1

    iget-object v4, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v4}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v4

    mul-float v4, v4, v5

    add-float/2addr v4, p1

    float-to-int v4, v4

    iget-object v6, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p2, v3, v1, v4, v6}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    iget-object v4, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v4}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v4

    mul-float v4, v4, v5

    add-float/2addr v4, p1

    float-to-int v4, v4

    iget-object v5, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p2, v3, v1, v4, v5}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    iget-object v3, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->setLength(I)V

    iget-object v2, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    const-string v3, "Z: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    iget-byte v0, v0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    iget-object v0, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->stringBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    const/high16 v3, 0x42400000    # 48.0f

    mul-float v2, v2, v3

    add-float/2addr v2, p1

    float-to-int v2, v2

    iget-object v4, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p2, v0, v1, v2, v4}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    iget-object v2, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v2, v2, v3

    add-float/2addr p1, v2

    float-to-int p1, p1

    iget-object v2, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p2, v0, v1, p1, v2}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    :goto_111
    return-void
.end method


# virtual methods
.method public draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v0

    invoke-static {p1, p2, p4, v0}, Lorg/mapsforge/map/util/LayerUtil;->getTilePositions(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/model/Point;I)Ljava/util/List;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result p2

    add-int/lit8 p2, p2, -0x1

    :goto_10
    if-ltz p2, :cond_1e

    invoke-interface {p1, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p4

    check-cast p4, Lorg/mapsforge/map/layer/TilePosition;

    invoke-direct {p0, p4, p3}, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->drawTileCoordinates(Lorg/mapsforge/map/layer/TilePosition;Lorg/mapsforge/core/graphics/Canvas;)V

    add-int/lit8 p2, p2, -0x1

    goto :goto_10

    :cond_1e
    return-void
.end method

.method public isDrawSimple()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->drawSimple:Z

    return v0
.end method

.method public setDrawSimple(Z)V
    .registers 2

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/debug/TileCoordinatesLayer;->drawSimple:Z

    return-void
.end method
