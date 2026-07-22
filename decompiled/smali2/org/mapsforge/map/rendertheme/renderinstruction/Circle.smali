.class public Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;
.super Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;
.source "SourceFile"


# instance fields
.field private final fill:Lorg/mapsforge/core/graphics/Paint;

.field private final fills:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Byte;",
            "Lorg/mapsforge/core/graphics/Paint;",
            ">;"
        }
    .end annotation
.end field

.field private final level:I

.field private radius:F

.field private renderRadius:F

.field private final renderRadiusScaled:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Byte;",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation
.end field

.field private scaleRadius:Z

.field private final stroke:Lorg/mapsforge/core/graphics/Paint;

.field private strokeWidth:F

.field private final strokes:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Byte;",
            "Lorg/mapsforge/core/graphics/Paint;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;I)V
    .registers 8

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V

    iput p5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->level:I

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p5

    iput-object p5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->fill:Lorg/mapsforge/core/graphics/Paint;

    sget-object v0, Lorg/mapsforge/core/graphics/Color;->TRANSPARENT:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {p5, v0}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object v1, Lorg/mapsforge/core/graphics/Style;->FILL:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {p5, v1}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    new-instance p5, Ljava/util/HashMap;

    invoke-direct {p5}, Ljava/util/HashMap;-><init>()V

    iput-object p5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->fills:Ljava/util/Map;

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p5

    iput-object p5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p5, v0}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object v0, Lorg/mapsforge/core/graphics/Style;->STROKE:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {p5, v0}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->strokes:Ljava/util/Map;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->renderRadiusScaled:Ljava/util/Map;

    invoke-direct {p0, p1, p2, p3, p4}, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->extractValues(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V

    iget-boolean p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->scaleRadius:Z

    if-nez p1, :cond_48

    iget p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->radius:F

    iput p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->renderRadius:F

    iget p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->strokeWidth:F

    invoke-interface {p5, p1}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    :cond_48
    return-void
.end method

.method private extractValues(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 9

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p4}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v1

    const-string v2, "radius"

    if-ge v0, v1, :cond_85

    invoke-interface {p4, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p4, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_75

    const-string v2, "r"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_20

    goto :goto_75

    :cond_20
    const-string v2, "cat"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2b

    iput-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->category:Ljava/lang/String;

    goto :goto_81

    :cond_2b
    const-string v2, "fill"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_41

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->fill:Lorg/mapsforge/core/graphics/Paint;

    :goto_35
    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getThemeCallback()Lorg/mapsforge/map/rendertheme/ThemeCallback;

    move-result-object v2

    invoke-static {p1, v3, v2, p0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->getColor(Lorg/mapsforge/core/graphics/GraphicFactory;Ljava/lang/String;Lorg/mapsforge/map/rendertheme/ThemeCallback;Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)I

    move-result v2

    invoke-interface {v1, v2}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    goto :goto_81

    :cond_41
    const-string v2, "scale-radius"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_50

    invoke-static {v3}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->scaleRadius:Z

    goto :goto_81

    :cond_50
    const-string v2, "stroke"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5b

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->stroke:Lorg/mapsforge/core/graphics/Paint;

    goto :goto_35

    :cond_5b
    const-string v2, "stroke-width"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_70

    invoke-static {v1, v3}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeFloat(Ljava/lang/String;Ljava/lang/String;)F

    move-result v1

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v1, v1, v2

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->strokeWidth:F

    goto :goto_81

    :cond_70
    invoke-static {p3, v1, v3, v0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->createXmlPullParserException(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lorg/xmlpull/v1/XmlPullParserException;

    move-result-object p1

    throw p1

    :cond_75
    :goto_75
    invoke-static {v1, v3}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeFloat(Ljava/lang/String;Ljava/lang/String;)F

    move-result v1

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v1, v1, v2

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->radius:F

    :goto_81
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    :cond_85
    iget p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->radius:F

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    invoke-static {p3, v2, p1}, Lorg/mapsforge/map/rendertheme/XmlUtils;->checkMandatoryAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private getFillPaint(B)Lorg/mapsforge/core/graphics/Paint;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->fills:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/core/graphics/Paint;

    if-nez p1, :cond_10

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->fill:Lorg/mapsforge/core/graphics/Paint;

    :cond_10
    return-object p1
.end method

.method private getRenderRadius(B)F
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->renderRadiusScaled:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Float;

    if-nez p1, :cond_14

    iget p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->renderRadius:F

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    :cond_14
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result p1

    return p1
.end method

.method private getStrokePaint(B)Lorg/mapsforge/core/graphics/Paint;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->strokes:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/core/graphics/Paint;

    if-nez p1, :cond_10

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->stroke:Lorg/mapsforge/core/graphics/Paint;

    :cond_10
    return-object p1
.end method


# virtual methods
.method public destroy()V
    .registers 1

    return-void
.end method

.method public renderNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/PointOfInterest;)V
    .registers 12

    iget-object v0, p2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v0, v0, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v0, v0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->getRenderRadius(B)F

    move-result v3

    iget-object v0, p2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v0, v0, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v0, v0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->getFillPaint(B)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v4

    iget-object v0, p2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v0, v0, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v0, v0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->getStrokePaint(B)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v5

    iget v6, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->level:I

    move-object v1, p1

    move-object v2, p2

    move-object v7, p3

    invoke-interface/range {v1 .. v7}, Lorg/mapsforge/map/rendertheme/RenderCallback;->renderPointOfInterestCircle(Lorg/mapsforge/map/rendertheme/RenderContext;FLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;ILorg/mapsforge/map/datastore/PointOfInterest;)V

    return-void
.end method

.method public renderWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 4

    return-void
.end method

.method public scaleStrokeWidth(FB)V
    .registers 6

    iget-boolean v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->scaleRadius:Z

    if-eqz v0, :cond_2f

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->renderRadiusScaled:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v1

    iget v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->radius:F

    mul-float v2, v2, p1

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->stroke:Lorg/mapsforge/core/graphics/Paint;

    if-eqz v0, :cond_2f

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-interface {v1, v0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint(Lorg/mapsforge/core/graphics/Paint;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->strokeWidth:F

    mul-float v1, v1, p1

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;->strokes:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p2

    invoke-interface {p1, p2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2f
    return-void
.end method

.method public scaleTextSize(FB)V
    .registers 3

    return-void
.end method
