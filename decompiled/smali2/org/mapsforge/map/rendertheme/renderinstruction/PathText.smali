.class public Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;
.super Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;
.source "SourceFile"


# static fields
.field private static final REPEAT_GAP_DEFAULT:F = 100.0f

.field private static final REPEAT_START_DEFAULT:F = 10.0f


# instance fields
.field private display:Lorg/mapsforge/core/graphics/Display;

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

.field private fontSize:F

.field private priority:I

.field private repeat:Z

.field private repeatGap:F

.field private repeatStart:F

.field private rotate:Z

.field private scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

.field private final stroke:Lorg/mapsforge/core/graphics/Paint;

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

.field private textKey:Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 8

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V

    sget-object v0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;->STROKE:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->fill:Lorg/mapsforge/core/graphics/Paint;

    sget-object v1, Lorg/mapsforge/core/graphics/Color;->BLACK:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object v2, Lorg/mapsforge/core/graphics/Style;->FILL:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {v0, v2}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    sget-object v2, Lorg/mapsforge/core/graphics/Align;->CENTER:Lorg/mapsforge/core/graphics/Align;

    invoke-interface {v0, v2}, Lorg/mapsforge/core/graphics/Paint;->setTextAlign(Lorg/mapsforge/core/graphics/Align;)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->fills:Ljava/util/Map;

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->rotate:Z

    iput-boolean v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->repeat:Z

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object v1, Lorg/mapsforge/core/graphics/Style;->STROKE:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    invoke-interface {v0, v2}, Lorg/mapsforge/core/graphics/Paint;->setTextAlign(Lorg/mapsforge/core/graphics/Align;)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->strokes:Ljava/util/Map;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->dyScaled:Ljava/util/Map;

    sget-object v0, Lorg/mapsforge/core/graphics/Display;->IFSPACE:Lorg/mapsforge/core/graphics/Display;

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->display:Lorg/mapsforge/core/graphics/Display;

    invoke-direct {p0, p1, p2, p3, p4}, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->extractValues(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V

    return-void
.end method

.method private extractValues(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 11

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v0

    const/high16 v1, 0x42c80000    # 100.0f

    mul-float v0, v0, v1

    iput v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->repeatGap:F

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v0

    const/high16 v1, 0x41200000    # 10.0f

    mul-float v0, v0, v1

    iput v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->repeatStart:F

    sget-object v0, Lorg/mapsforge/core/graphics/FontFamily;->DEFAULT:Lorg/mapsforge/core/graphics/FontFamily;

    sget-object v1, Lorg/mapsforge/core/graphics/FontStyle;->NORMAL:Lorg/mapsforge/core/graphics/FontStyle;

    const/4 v2, 0x0

    :goto_19
    invoke-interface {p4}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v3

    const-string v4, "k"

    if-ge v2, v3, :cond_145

    invoke-interface {p4, v2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {p4, v2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_37

    invoke-static {v5}, Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;->getInstance(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;

    move-result-object v3

    iput-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->textKey:Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;

    goto/16 :goto_13c

    :cond_37
    const-string v4, "cat"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_43

    iput-object v5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->category:Ljava/lang/String;

    goto/16 :goto_13c

    :cond_43
    const-string v4, "display"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_53

    invoke-static {v5}, Lorg/mapsforge/core/graphics/Display;->fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Display;

    move-result-object v3

    iput-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->display:Lorg/mapsforge/core/graphics/Display;

    goto/16 :goto_13c

    :cond_53
    const-string v4, "dy"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_69

    invoke-static {v5}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v3

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v4

    mul-float v3, v3, v4

    iput v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->dy:F

    goto/16 :goto_13c

    :cond_69
    const-string v4, "fill"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_80

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->fill:Lorg/mapsforge/core/graphics/Paint;

    :goto_73
    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getThemeCallback()Lorg/mapsforge/map/rendertheme/ThemeCallback;

    move-result-object v4

    invoke-static {p1, v5, v4, p0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->getColor(Lorg/mapsforge/core/graphics/GraphicFactory;Ljava/lang/String;Lorg/mapsforge/map/rendertheme/ThemeCallback;Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)I

    move-result v4

    invoke-interface {v3, v4}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    goto/16 :goto_13c

    :cond_80
    const-string v4, "font-family"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8e

    invoke-static {v5}, Lorg/mapsforge/core/graphics/FontFamily;->fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/FontFamily;

    move-result-object v0

    goto/16 :goto_13c

    :cond_8e
    const-string v4, "font-size"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_a4

    invoke-static {v3, v5}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeFloat(Ljava/lang/String;Ljava/lang/String;)F

    move-result v3

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v4

    mul-float v3, v3, v4

    iput v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->fontSize:F

    goto/16 :goto_13c

    :cond_a4
    const-string v4, "font-style"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_b2

    invoke-static {v5}, Lorg/mapsforge/core/graphics/FontStyle;->fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/FontStyle;

    move-result-object v1

    goto/16 :goto_13c

    :cond_b2
    const-string v4, "repeat"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_c2

    invoke-static {v5}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->repeat:Z

    goto/16 :goto_13c

    :cond_c2
    const-string v4, "repeat-gap"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_d7

    invoke-static {v5}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v3

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v4

    mul-float v3, v3, v4

    iput v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->repeatGap:F

    goto :goto_13c

    :cond_d7
    const-string v4, "repeat-start"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_ec

    invoke-static {v5}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v3

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v4

    mul-float v3, v3, v4

    iput v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->repeatStart:F

    goto :goto_13c

    :cond_ec
    const-string v4, "rotate"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_fb

    invoke-static {v5}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->rotate:Z

    goto :goto_13c

    :cond_fb
    const-string v4, "priority"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_10a

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    iput v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->priority:I

    goto :goto_13c

    :cond_10a
    const-string v4, "scale"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_119

    invoke-virtual {p0, v5}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->scaleFromValue(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    move-result-object v3

    iput-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    goto :goto_13c

    :cond_119
    const-string v4, "stroke"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_125

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->stroke:Lorg/mapsforge/core/graphics/Paint;

    goto/16 :goto_73

    :cond_125
    const-string v4, "stroke-width"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_140

    iget-object v4, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {v3, v5}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeFloat(Ljava/lang/String;Ljava/lang/String;)F

    move-result v3

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v5

    mul-float v3, v3, v5

    invoke-interface {v4, v3}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    :goto_13c
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_19

    :cond_140
    invoke-static {p3, v3, v5, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->createXmlPullParserException(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lorg/xmlpull/v1/XmlPullParserException;

    move-result-object p1

    throw p1

    :cond_145
    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->fill:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1, v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setTypeface(Lorg/mapsforge/core/graphics/FontFamily;Lorg/mapsforge/core/graphics/FontStyle;)V

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1, v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setTypeface(Lorg/mapsforge/core/graphics/FontFamily;Lorg/mapsforge/core/graphics/FontStyle;)V

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->textKey:Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;

    invoke-static {p3, v4, p1}, Lorg/mapsforge/map/rendertheme/XmlUtils;->checkMandatoryAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private getFillPaint(B)Lorg/mapsforge/core/graphics/Paint;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->fills:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/core/graphics/Paint;

    if-nez p1, :cond_10

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->fill:Lorg/mapsforge/core/graphics/Paint;

    :cond_10
    return-object p1
.end method

.method private getStrokePaint(B)Lorg/mapsforge/core/graphics/Paint;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->strokes:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/core/graphics/Paint;

    if-nez p1, :cond_10

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->stroke:Lorg/mapsforge/core/graphics/Paint;

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
    .registers 18

    move-object v0, p0

    move-object/from16 v2, p2

    sget-object v1, Lorg/mapsforge/core/graphics/Display;->NEVER:Lorg/mapsforge/core/graphics/Display;

    iget-object v3, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->display:Lorg/mapsforge/core/graphics/Display;

    if-ne v1, v3, :cond_a

    return-void

    :cond_a
    iget-object v1, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->textKey:Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;

    invoke-virtual/range {p3 .. p3}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getTags()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v1, v3}, Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;->getValue(Ljava/util/List;)Ljava/lang/String;

    move-result-object v5

    if-nez v5, :cond_17

    return-void

    :cond_17
    iget-object v1, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->dyScaled:Ljava/util/Map;

    iget-object v3, v2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v3, v3, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v3, v3, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v3}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Float;

    if-nez v1, :cond_31

    iget v1, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->dy:F

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    :cond_31
    iget-object v3, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->display:Lorg/mapsforge/core/graphics/Display;

    iget v4, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->priority:I

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v6

    iget-object v1, v2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v1, v1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v1}, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->getFillPaint(B)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v7

    iget-object v1, v2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v1, v1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v1}, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->getStrokePaint(B)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v8

    iget-boolean v9, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->repeat:Z

    iget v10, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->repeatGap:F

    iget v11, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->repeatStart:F

    iget-boolean v12, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->rotate:Z

    move-object v1, p1

    move-object/from16 v2, p2

    move-object/from16 v13, p3

    invoke-interface/range {v1 .. v13}, Lorg/mapsforge/map/rendertheme/RenderCallback;->renderWayText(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;FLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;ZFFZLorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    return-void
.end method

.method public scaleStrokeWidth(FB)V
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    sget-object v1, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;->NONE:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    if-ne v0, v1, :cond_8

    const/high16 p1, 0x3f800000    # 1.0f

    :cond_8
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->dyScaled:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p2

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->dy:F

    mul-float v1, v1, p1

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    invoke-interface {v0, p2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public scaleTextSize(FB)V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->fill:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint(Lorg/mapsforge/core/graphics/Paint;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->fontSize:F

    mul-float v1, v1, p1

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setTextSize(F)V

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->fills:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint(Lorg/mapsforge/core/graphics/Paint;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->fontSize:F

    mul-float v1, v1, p1

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setTextSize(F)V

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;->strokes:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p2

    invoke-interface {p1, p2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method
