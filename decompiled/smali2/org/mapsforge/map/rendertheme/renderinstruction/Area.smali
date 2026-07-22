.class public Lorg/mapsforge/map/rendertheme/renderinstruction/Area;
.super Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;
.source "SourceFile"


# instance fields
.field private bitmapInvalid:Z

.field private final fill:Lorg/mapsforge/core/graphics/Paint;

.field private final level:I

.field private final relativePathPrefix:Ljava/lang/String;

.field private scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

.field private shaderBitmap:Lorg/mapsforge/core/graphics/Bitmap;

.field private src:Ljava/lang/String;

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
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;ILjava/lang/String;)V
    .registers 7

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V

    sget-object p2, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;->STROKE:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    iput-object p2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    iput p5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->level:I

    iput-object p6, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->relativePathPrefix:Ljava/lang/String;

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p2

    iput-object p2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->fill:Lorg/mapsforge/core/graphics/Paint;

    sget-object p5, Lorg/mapsforge/core/graphics/Color;->TRANSPARENT:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {p2, p5}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object p6, Lorg/mapsforge/core/graphics/Style;->FILL:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {p2, p6}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    sget-object p6, Lorg/mapsforge/core/graphics/Cap;->ROUND:Lorg/mapsforge/core/graphics/Cap;

    invoke-interface {p2, p6}, Lorg/mapsforge/core/graphics/Paint;->setStrokeCap(Lorg/mapsforge/core/graphics/Cap;)V

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1, p5}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object p2, Lorg/mapsforge/core/graphics/Style;->STROKE:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {p1, p2}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    invoke-interface {p1, p6}, Lorg/mapsforge/core/graphics/Paint;->setStrokeCap(Lorg/mapsforge/core/graphics/Cap;)V

    new-instance p1, Ljava/util/HashMap;

    invoke-direct {p1}, Ljava/util/HashMap;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->strokes:Ljava/util/Map;

    invoke-direct {p0, p3, p4}, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->extractValues(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V

    return-void
.end method

.method private extractValues(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 8

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v1

    if-ge v0, v1, :cond_c3

    invoke-interface {p2, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p2, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "src"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1b

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->src:Ljava/lang/String;

    goto/16 :goto_ba

    :cond_1b
    const-string v3, "cat"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_27

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->category:Ljava/lang/String;

    goto/16 :goto_ba

    :cond_27
    const-string v3, "fill"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_42

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->fill:Lorg/mapsforge/core/graphics/Paint;

    :goto_31
    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v4, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v4}, Lorg/mapsforge/map/model/DisplayModel;->getThemeCallback()Lorg/mapsforge/map/rendertheme/ThemeCallback;

    move-result-object v4

    invoke-static {v3, v2, v4, p0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->getColor(Lorg/mapsforge/core/graphics/GraphicFactory;Ljava/lang/String;Lorg/mapsforge/map/rendertheme/ThemeCallback;Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)I

    move-result v2

    invoke-interface {v1, v2}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    goto/16 :goto_ba

    :cond_42
    const-string v3, "scale"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_51

    invoke-virtual {p0, v2}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->scaleFromValue(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    move-result-object v1

    iput-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    goto :goto_ba

    :cond_51
    const-string v3, "stroke"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5c

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->stroke:Lorg/mapsforge/core/graphics/Paint;

    goto :goto_31

    :cond_5c
    const-string v3, "stroke-width"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_73

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeFloat(Ljava/lang/String;Ljava/lang/String;)F

    move-result v1

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v1, v1, v2

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->strokeWidth:F

    goto :goto_ba

    :cond_73
    const-string v3, "symbol-height"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8b

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    int-to-float v1, v1

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v1, v1, v2

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->height:F

    goto :goto_ba

    :cond_8b
    const-string v3, "symbol-percent"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_9a

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->percent:I

    goto :goto_ba

    :cond_9a
    const-string v3, "symbol-scaling"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_a3

    goto :goto_ba

    :cond_a3
    const-string v3, "symbol-width"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_be

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    int-to-float v1, v1

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v1, v1, v2

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->width:F

    :goto_ba
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    :cond_be
    invoke-static {p1, v1, v2, v0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->createXmlPullParserException(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lorg/xmlpull/v1/XmlPullParserException;

    move-result-object p1

    throw p1

    :cond_c3
    return-void
.end method

.method private getFillPaint()Lorg/mapsforge/core/graphics/Paint;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->fill:Lorg/mapsforge/core/graphics/Paint;

    return-object v0
.end method

.method private getStrokePaint(B)Lorg/mapsforge/core/graphics/Paint;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->strokes:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/core/graphics/Paint;

    if-nez p1, :cond_10

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->stroke:Lorg/mapsforge/core/graphics/Paint;

    :cond_10
    return-object p1
.end method


# virtual methods
.method public destroy()V
    .registers 1

    return-void
.end method

.method public renderNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/PointOfInterest;)V
    .registers 4

    return-void
.end method

.method public renderWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 10

    monitor-enter p0

    :try_start_1
    invoke-direct {p0}, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->getFillPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object v2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->shaderBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-nez v0, :cond_25

    iget-boolean v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->bitmapInvalid:Z
    :try_end_b
    .catchall {:try_start_1 .. :try_end_b} :catchall_44

    if-nez v0, :cond_25

    :try_start_d
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->relativePathPrefix:Ljava/lang/String;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->src:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->createBitmap(Ljava/lang/String;Ljava/lang/String;)Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->shaderBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v0, :cond_25

    invoke-interface {v2, v0}, Lorg/mapsforge/core/graphics/Paint;->setBitmapShader(Lorg/mapsforge/core/graphics/Bitmap;)V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->shaderBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V
    :try_end_21
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_21} :catch_22
    .catchall {:try_start_d .. :try_end_21} :catchall_44

    goto :goto_25

    :catch_22
    const/4 v0, 0x1

    :try_start_23
    iput-boolean v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->bitmapInvalid:Z

    :cond_25
    :goto_25
    invoke-virtual {p3}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getUpperLeft()Lorg/mapsforge/core/model/Tile;

    move-result-object v0

    invoke-virtual {v0}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v0

    invoke-interface {v2, v0}, Lorg/mapsforge/core/graphics/Paint;->setBitmapShaderShift(Lorg/mapsforge/core/model/Point;)V

    iget-object v0, p2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v0, v0, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v0, v0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->getStrokePaint(B)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v3

    iget v4, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->level:I

    move-object v0, p1

    move-object v1, p2

    move-object v5, p3

    invoke-interface/range {v0 .. v5}, Lorg/mapsforge/map/rendertheme/RenderCallback;->renderArea(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;ILorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    monitor-exit p0

    return-void

    :catchall_44
    move-exception p1

    monitor-exit p0
    :try_end_46
    .catchall {:try_start_23 .. :try_end_46} :catchall_44

    throw p1
.end method

.method public scaleStrokeWidth(FB)V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->stroke:Lorg/mapsforge/core/graphics/Paint;

    if-eqz v0, :cond_22

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    sget-object v2, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;->NONE:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    if-ne v1, v2, :cond_c

    const/high16 p1, 0x3f800000    # 1.0f

    :cond_c
    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-interface {v1, v0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint(Lorg/mapsforge/core/graphics/Paint;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->strokeWidth:F

    mul-float v1, v1, p1

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;->strokes:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p2

    invoke-interface {p1, p2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_22
    return-void
.end method

.method public scaleTextSize(FB)V
    .registers 3

    return-void
.end method
