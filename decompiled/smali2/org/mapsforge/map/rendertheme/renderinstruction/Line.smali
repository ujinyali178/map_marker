.class public Lorg/mapsforge/map/rendertheme/renderinstruction/Line;
.super Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;
.source "SourceFile"


# static fields
.field private static final SPLIT_PATTERN:Ljava/util/regex/Pattern;


# instance fields
.field private bitmapCreated:Z

.field private dy:F

.field private final dyScaled:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Byte;",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation
.end field

.field private final level:I

.field private final relativePathPrefix:Ljava/lang/String;

.field private scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

.field private shaderBitmap:Lorg/mapsforge/core/graphics/Bitmap;

.field private src:Ljava/lang/String;

.field private final stroke:Lorg/mapsforge/core/graphics/Paint;

.field private strokeDasharray:[F

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
.method static constructor <clinit>()V
    .registers 1

    const-string v0, ","

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->SPLIT_PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;ILjava/lang/String;)V
    .registers 8

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V

    sget-object v0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;->STROKE:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    iput p5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->level:I

    iput-object p6, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->relativePathPrefix:Ljava/lang/String;

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p5

    iput-object p5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->stroke:Lorg/mapsforge/core/graphics/Paint;

    sget-object p6, Lorg/mapsforge/core/graphics/Color;->BLACK:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {p5, p6}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object p6, Lorg/mapsforge/core/graphics/Style;->STROKE:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {p5, p6}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    sget-object p6, Lorg/mapsforge/core/graphics/Cap;->ROUND:Lorg/mapsforge/core/graphics/Cap;

    invoke-interface {p5, p6}, Lorg/mapsforge/core/graphics/Paint;->setStrokeCap(Lorg/mapsforge/core/graphics/Cap;)V

    sget-object p6, Lorg/mapsforge/core/graphics/Join;->ROUND:Lorg/mapsforge/core/graphics/Join;

    invoke-interface {p5, p6}, Lorg/mapsforge/core/graphics/Paint;->setStrokeJoin(Lorg/mapsforge/core/graphics/Join;)V

    new-instance p5, Ljava/util/HashMap;

    invoke-direct {p5}, Ljava/util/HashMap;-><init>()V

    iput-object p5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->strokes:Ljava/util/Map;

    new-instance p5, Ljava/util/HashMap;

    invoke-direct {p5}, Ljava/util/HashMap;-><init>()V

    iput-object p5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->dyScaled:Ljava/util/Map;

    invoke-direct {p0, p1, p2, p3, p4}, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->extractValues(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V

    return-void
.end method

.method private extractValues(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 11

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    invoke-interface {p4}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v2

    if-ge v1, v2, :cond_112

    invoke-interface {p4, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p4, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v3

    const-string v4, "src"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1c

    iput-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->src:Ljava/lang/String;

    goto/16 :goto_109

    :cond_1c
    const-string v4, "cat"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_28

    iput-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->category:Ljava/lang/String;

    goto/16 :goto_109

    :cond_28
    const-string v4, "dy"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3e

    invoke-static {v3}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v2

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v3

    mul-float v2, v2, v3

    iput v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->dy:F

    goto/16 :goto_109

    :cond_3e
    const-string v4, "scale"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4e

    invoke-virtual {p0, v3}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->scaleFromValue(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    move-result-object v2

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    goto/16 :goto_109

    :cond_4e
    const-string v4, "stroke"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_65

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getThemeCallback()Lorg/mapsforge/map/rendertheme/ThemeCallback;

    move-result-object v4

    invoke-static {p1, v3, v4, p0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->getColor(Lorg/mapsforge/core/graphics/GraphicFactory;Ljava/lang/String;Lorg/mapsforge/map/rendertheme/ThemeCallback;Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)I

    move-result v3

    invoke-interface {v2, v3}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    goto/16 :goto_109

    :cond_65
    const-string v4, "stroke-dasharray"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8d

    invoke-static {v2, v3}, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->parseFloatArray(Ljava/lang/String;Ljava/lang/String;)[F

    move-result-object v2

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->strokeDasharray:[F

    const/4 v2, 0x0

    :goto_74
    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->strokeDasharray:[F

    array-length v4, v3

    if-ge v2, v4, :cond_86

    aget v4, v3, v2

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v5

    mul-float v4, v4, v5

    aput v4, v3, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_74

    :cond_86
    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v2, v3}, Lorg/mapsforge/core/graphics/Paint;->setDashPathEffect([F)V

    goto/16 :goto_109

    :cond_8d
    const-string v4, "stroke-linecap"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_9f

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {v3}, Lorg/mapsforge/core/graphics/Cap;->fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Cap;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/mapsforge/core/graphics/Paint;->setStrokeCap(Lorg/mapsforge/core/graphics/Cap;)V

    goto :goto_109

    :cond_9f
    const-string v4, "stroke-linejoin"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_b1

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {v3}, Lorg/mapsforge/core/graphics/Join;->fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Join;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/mapsforge/core/graphics/Paint;->setStrokeJoin(Lorg/mapsforge/core/graphics/Join;)V

    goto :goto_109

    :cond_b1
    const-string v4, "stroke-width"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_c6

    invoke-static {v2, v3}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeFloat(Ljava/lang/String;Ljava/lang/String;)F

    move-result v2

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v3

    mul-float v2, v2, v3

    iput v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->strokeWidth:F

    goto :goto_109

    :cond_c6
    const-string v4, "symbol-height"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_dc

    invoke-static {v2, v3}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v3

    mul-float v2, v2, v3

    iput v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->height:F

    goto :goto_109

    :cond_dc
    const-string v4, "symbol-percent"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_eb

    invoke-static {v2, v3}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->percent:I

    goto :goto_109

    :cond_eb
    const-string v4, "symbol-scaling"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_f4

    goto :goto_109

    :cond_f4
    const-string v4, "symbol-width"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_10d

    invoke-static {v2, v3}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v3

    mul-float v2, v2, v3

    iput v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->width:F

    :goto_109
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_2

    :cond_10d
    invoke-static {p3, v2, v3, v1}, Lorg/mapsforge/map/rendertheme/XmlUtils;->createXmlPullParserException(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lorg/xmlpull/v1/XmlPullParserException;

    move-result-object p1

    throw p1

    :cond_112
    return-void
.end method

.method private getStrokePaint(B)Lorg/mapsforge/core/graphics/Paint;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->strokes:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/core/graphics/Paint;

    if-nez p1, :cond_10

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->stroke:Lorg/mapsforge/core/graphics/Paint;

    :cond_10
    return-object p1
.end method

.method private static parseFloatArray(Ljava/lang/String;Ljava/lang/String;)[F
    .registers 5

    sget-object v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->SPLIT_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p1}, Ljava/util/regex/Pattern;->split(Ljava/lang/CharSequence;)[Ljava/lang/String;

    move-result-object p1

    array-length v0, p1

    new-array v0, v0, [F

    const/4 v1, 0x0

    :goto_a
    array-length v2, p1

    if-ge v1, v2, :cond_18

    aget-object v2, p1, v1

    invoke-static {p0, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeFloat(Ljava/lang/String;Ljava/lang/String;)F

    move-result v2

    aput v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_a

    :cond_18
    return-object v0
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

.method public declared-synchronized renderWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 11

    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->bitmapCreated:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_56

    if-nez v0, :cond_12

    :try_start_5
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->relativePathPrefix:Ljava/lang/String;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->src:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->createBitmap(Ljava/lang/String;Ljava/lang/String;)Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->shaderBitmap:Lorg/mapsforge/core/graphics/Bitmap;
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_f} :catch_f
    .catchall {:try_start_5 .. :try_end_f} :catchall_56

    :catch_f
    const/4 v0, 0x1

    :try_start_10
    iput-boolean v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->bitmapCreated:Z

    :cond_12
    iget-object v0, p2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v0, v0, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v0, v0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->getStrokePaint(B)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->shaderBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v0, :cond_2e

    invoke-interface {v3, v0}, Lorg/mapsforge/core/graphics/Paint;->setBitmapShader(Lorg/mapsforge/core/graphics/Bitmap;)V

    invoke-virtual {p3}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getUpperLeft()Lorg/mapsforge/core/model/Tile;

    move-result-object v0

    invoke-virtual {v0}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v0

    invoke-interface {v3, v0}, Lorg/mapsforge/core/graphics/Paint;->setBitmapShaderShift(Lorg/mapsforge/core/model/Point;)V

    :cond_2e
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->dyScaled:Ljava/util/Map;

    iget-object v1, p2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v1, v1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    if-nez v0, :cond_48

    iget v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->dy:F

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    :cond_48
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v4

    iget v5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->level:I

    move-object v1, p1

    move-object v2, p2

    move-object v6, p3

    invoke-interface/range {v1 .. v6}, Lorg/mapsforge/map/rendertheme/RenderCallback;->renderWay(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Paint;FILorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    :try_end_54
    .catchall {:try_start_10 .. :try_end_54} :catchall_56

    monitor-exit p0

    return-void

    :catchall_56
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public scaleStrokeWidth(FB)V
    .registers 8

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    sget-object v1, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;->NONE:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    if-ne v0, v1, :cond_8

    const/high16 p1, 0x3f800000    # 1.0f

    :cond_8
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->stroke:Lorg/mapsforge/core/graphics/Paint;

    if-eqz v0, :cond_3f

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-interface {v1, v0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint(Lorg/mapsforge/core/graphics/Paint;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->strokeWidth:F

    mul-float v1, v1, p1

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    sget-object v2, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;->ALL:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    if-ne v1, v2, :cond_36

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->strokeDasharray:[F

    array-length v1, v1

    new-array v1, v1, [F

    const/4 v2, 0x0

    :goto_25
    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->strokeDasharray:[F

    array-length v4, v3

    if-ge v2, v4, :cond_33

    aget v3, v3, v2

    mul-float v3, v3, p1

    aput v3, v1, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_25

    :cond_33
    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setDashPathEffect([F)V

    :cond_36
    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->strokes:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3f
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->dyScaled:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p2

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;->dy:F

    mul-float v1, v1, p1

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    invoke-interface {v0, p2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public scaleTextSize(FB)V
    .registers 3

    return-void
.end method
