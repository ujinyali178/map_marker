.class public Lorg/mapsforge/map/layer/renderer/CanvasRasterer;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final canvas:Lorg/mapsforge/core/graphics/Canvas;

.field private final path:Lorg/mapsforge/core/graphics/Path;

.field private final symbolMatrix:Lorg/mapsforge/core/graphics/Matrix;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createCanvas()Lorg/mapsforge/core/graphics/Canvas;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPath()Lorg/mapsforge/core/graphics/Path;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->path:Lorg/mapsforge/core/graphics/Path;

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createMatrix()Lorg/mapsforge/core/graphics/Matrix;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->symbolMatrix:Lorg/mapsforge/core/graphics/Matrix;

    return-void
.end method

.method private drawCircleContainer(Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;)V
    .registers 8

    iget-object v0, p1, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;->shapeContainer:Lorg/mapsforge/map/layer/renderer/ShapeContainer;

    check-cast v0, Lorg/mapsforge/map/layer/renderer/CircleContainer;

    iget-object v1, v0, Lorg/mapsforge/map/layer/renderer/CircleContainer;->point:Lorg/mapsforge/core/model/Point;

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    iget-wide v3, v1, Lorg/mapsforge/core/model/Point;->x:D

    double-to-int v3, v3

    iget-wide v4, v1, Lorg/mapsforge/core/model/Point;->y:D

    double-to-int v1, v4

    iget v0, v0, Lorg/mapsforge/map/layer/renderer/CircleContainer;->radius:F

    float-to-int v0, v0

    iget-object p1, p1, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;->paint:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v2, v3, v1, v0, p1}, Lorg/mapsforge/core/graphics/GraphicContext;->drawCircle(IIILorg/mapsforge/core/graphics/Paint;)V

    return-void
.end method

.method private drawHillshading(Lorg/mapsforge/map/layer/renderer/HillshadingContainer;)V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    iget-object v1, p1, Lorg/mapsforge/map/layer/renderer/HillshadingContainer;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iget-object v2, p1, Lorg/mapsforge/map/layer/renderer/HillshadingContainer;->hillsRect:Lorg/mapsforge/core/model/Rectangle;

    iget-object v3, p1, Lorg/mapsforge/map/layer/renderer/HillshadingContainer;->tileRect:Lorg/mapsforge/core/model/Rectangle;

    iget p1, p1, Lorg/mapsforge/map/layer/renderer/HillshadingContainer;->magnitude:F

    invoke-interface {v0, v1, v2, v3, p1}, Lorg/mapsforge/core/graphics/GraphicContext;->shadeBitmap(Lorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/core/model/Rectangle;Lorg/mapsforge/core/model/Rectangle;F)V

    return-void
.end method

.method private drawPath(Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;[[Lorg/mapsforge/core/model/Point;F)V
    .registers 14

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->path:Lorg/mapsforge/core/graphics/Path;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Path;->clear()V

    array-length v0, p2

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_8
    if-ge v2, v0, :cond_40

    aget-object v3, p2, v2

    const/4 v4, 0x0

    cmpl-float v4, p3, v4

    if-eqz v4, :cond_16

    float-to-double v4, p3

    invoke-static {v3, v4, v5}, Lorg/mapsforge/map/layer/renderer/RendererUtils;->parallelPath([Lorg/mapsforge/core/model/Point;D)[Lorg/mapsforge/core/model/Point;

    move-result-object v3

    :cond_16
    array-length v4, v3

    const/4 v5, 0x2

    if-lt v4, v5, :cond_3d

    aget-object v4, v3, v1

    iget-object v5, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->path:Lorg/mapsforge/core/graphics/Path;

    iget-wide v6, v4, Lorg/mapsforge/core/model/Point;->x:D

    double-to-float v6, v6

    iget-wide v7, v4, Lorg/mapsforge/core/model/Point;->y:D

    double-to-float v4, v7

    invoke-interface {v5, v6, v4}, Lorg/mapsforge/core/graphics/Path;->moveTo(FF)V

    const/4 v4, 0x1

    :goto_28
    array-length v5, v3

    if-ge v4, v5, :cond_3d

    aget-object v5, v3, v4

    iget-object v6, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->path:Lorg/mapsforge/core/graphics/Path;

    iget-wide v7, v5, Lorg/mapsforge/core/model/Point;->x:D

    double-to-int v7, v7

    int-to-float v7, v7

    iget-wide v8, v5, Lorg/mapsforge/core/model/Point;->y:D

    double-to-int v5, v8

    int-to-float v5, v5

    invoke-interface {v6, v7, v5}, Lorg/mapsforge/core/graphics/Path;->lineTo(FF)V

    add-int/lit8 v4, v4, 0x1

    goto :goto_28

    :cond_3d
    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    :cond_40
    iget-object p2, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    iget-object p3, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->path:Lorg/mapsforge/core/graphics/Path;

    iget-object p1, p1, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;->paint:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p2, p3, p1}, Lorg/mapsforge/core/graphics/GraphicContext;->drawPath(Lorg/mapsforge/core/graphics/Path;Lorg/mapsforge/core/graphics/Paint;)V

    return-void
.end method

.method private drawShapePaintContainer(Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;)V
    .registers 5

    iget-object v0, p1, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;->shapeContainer:Lorg/mapsforge/map/layer/renderer/ShapeContainer;

    invoke-interface {v0}, Lorg/mapsforge/map/layer/renderer/ShapeContainer;->getShapeType()Lorg/mapsforge/map/layer/renderer/ShapeType;

    move-result-object v1

    sget-object v2, Lorg/mapsforge/map/layer/renderer/CanvasRasterer$1;->$SwitchMap$org$mapsforge$map$layer$renderer$ShapeType:[I

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v1, v2, v1

    const/4 v2, 0x1

    if-eq v1, v2, :cond_2a

    const/4 v2, 0x2

    if-eq v1, v2, :cond_24

    const/4 v2, 0x3

    if-eq v1, v2, :cond_18

    goto :goto_2d

    :cond_18
    check-cast v0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getCoordinatesRelativeToOrigin()[[Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iget v1, p1, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;->dy:F

    invoke-direct {p0, p1, v0, v1}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->drawPath(Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;[[Lorg/mapsforge/core/model/Point;F)V

    goto :goto_2d

    :cond_24
    check-cast v0, Lorg/mapsforge/map/layer/renderer/HillshadingContainer;

    invoke-direct {p0, v0}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->drawHillshading(Lorg/mapsforge/map/layer/renderer/HillshadingContainer;)V

    goto :goto_2d

    :cond_2a
    invoke-direct {p0, p1}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->drawCircleContainer(Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;)V

    :goto_2d
    return-void
.end method


# virtual methods
.method public destroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Canvas;->destroy()V

    return-void
.end method

.method drawMapElements(Ljava/util/Set;Lorg/mapsforge/core/model/Tile;)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set<",
            "Lorg/mapsforge/core/mapelements/MapElementContainer;",
            ">;",
            "Lorg/mapsforge/core/model/Tile;",
            ")V"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-static {v0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_c
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_26

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/core/mapelements/MapElementContainer;

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-virtual {p2}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v2

    iget-object v3, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->symbolMatrix:Lorg/mapsforge/core/graphics/Matrix;

    sget-object v4, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    invoke-virtual {v0, v1, v2, v3, v4}, Lorg/mapsforge/core/mapelements/MapElementContainer;->draw(Lorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Matrix;Lorg/mapsforge/core/graphics/Filter;)V

    goto :goto_c

    :cond_26
    return-void
.end method

.method drawWays(Lorg/mapsforge/map/rendertheme/RenderContext;)V
    .registers 11

    iget-object v0, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->ways:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v2, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->ways:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    const/4 v3, 0x0

    :goto_14
    if-ge v3, v2, :cond_41

    iget-object v4, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->ways:Ljava/util/List;

    invoke-interface {v4, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    const/4 v5, 0x0

    :goto_1f
    if-ge v5, v0, :cond_3e

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v7

    add-int/lit8 v7, v7, -0x1

    :goto_2d
    if-ltz v7, :cond_3b

    invoke-interface {v6, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;

    invoke-direct {p0, v8}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->drawShapePaintContainer(Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;)V

    add-int/lit8 v7, v7, -0x1

    goto :goto_2d

    :cond_3b
    add-int/lit8 v5, v5, 0x1

    goto :goto_1f

    :cond_3e
    add-int/lit8 v3, v3, 0x1

    goto :goto_14

    :cond_41
    return-void
.end method

.method fill(I)V
    .registers 3

    invoke-static {p1}, Lorg/mapsforge/core/graphics/GraphicUtils;->getAlpha(I)I

    move-result v0

    if-lez v0, :cond_b

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {v0, p1}, Lorg/mapsforge/core/graphics/GraphicContext;->fillColor(I)V

    :cond_b
    return-void
.end method

.method fillOutsideAreas(ILorg/mapsforge/core/model/Rectangle;)V
    .registers 9

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    iget-wide v1, p2, Lorg/mapsforge/core/model/Rectangle;->left:D

    double-to-int v1, v1

    iget-wide v2, p2, Lorg/mapsforge/core/model/Rectangle;->top:D

    double-to-int v2, v2

    invoke-virtual {p2}, Lorg/mapsforge/core/model/Rectangle;->getWidth()D

    move-result-wide v3

    double-to-int v3, v3

    invoke-virtual {p2}, Lorg/mapsforge/core/model/Rectangle;->getHeight()D

    move-result-wide v4

    double-to-int p2, v4

    invoke-interface {v0, v1, v2, v3, p2}, Lorg/mapsforge/core/graphics/GraphicContext;->setClipDifference(IIII)V

    iget-object p2, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {p2, p1}, Lorg/mapsforge/core/graphics/GraphicContext;->fillColor(I)V

    iget-object p1, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicContext;->resetClip()V

    return-void
.end method

.method fillOutsideAreas(Lorg/mapsforge/core/graphics/Color;Lorg/mapsforge/core/model/Rectangle;)V
    .registers 9

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    iget-wide v1, p2, Lorg/mapsforge/core/model/Rectangle;->left:D

    double-to-int v1, v1

    iget-wide v2, p2, Lorg/mapsforge/core/model/Rectangle;->top:D

    double-to-int v2, v2

    invoke-virtual {p2}, Lorg/mapsforge/core/model/Rectangle;->getWidth()D

    move-result-wide v3

    double-to-int v3, v3

    invoke-virtual {p2}, Lorg/mapsforge/core/model/Rectangle;->getHeight()D

    move-result-wide v4

    double-to-int p2, v4

    invoke-interface {v0, v1, v2, v3, p2}, Lorg/mapsforge/core/graphics/GraphicContext;->setClipDifference(IIII)V

    iget-object p2, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {p2, p1}, Lorg/mapsforge/core/graphics/GraphicContext;->fillColor(Lorg/mapsforge/core/graphics/Color;)V

    iget-object p1, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicContext;->resetClip()V

    return-void
.end method

.method setCanvasBitmap(Lorg/mapsforge/core/graphics/Bitmap;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->canvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {v0, p1}, Lorg/mapsforge/core/graphics/Canvas;->setBitmap(Lorg/mapsforge/core/graphics/Bitmap;)V

    return-void
.end method
