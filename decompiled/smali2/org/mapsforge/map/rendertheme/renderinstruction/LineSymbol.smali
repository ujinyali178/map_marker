.class public Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;
.super Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;
.source "SourceFile"


# static fields
.field private static final REPEAT_GAP_DEFAULT:F = 200.0f

.field private static final REPEAT_START_DEFAULT:F = 30.0f


# instance fields
.field private alignCenter:Z

.field private bitmap:Lorg/mapsforge/core/graphics/Bitmap;

.field private bitmapInvalid:Z

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

.field private priority:I

.field private final relativePathPrefix:Ljava/lang/String;

.field private repeat:Z

.field private repeatGap:F

.field private repeatStart:F

.field private rotate:Z

.field private scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

.field private src:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V
    .registers 6

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V

    sget-object p1, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;->STROKE:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    sget-object p1, Lorg/mapsforge/core/graphics/Display;->IFSPACE:Lorg/mapsforge/core/graphics/Display;

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->display:Lorg/mapsforge/core/graphics/Display;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->rotate:Z

    iput-object p5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->relativePathPrefix:Ljava/lang/String;

    new-instance p1, Ljava/util/HashMap;

    invoke-direct {p1}, Ljava/util/HashMap;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->dyScaled:Ljava/util/Map;

    invoke-direct {p0, p3, p4}, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->extractValues(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V

    return-void
.end method

.method private extractValues(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v0

    const/high16 v1, 0x43480000    # 200.0f

    mul-float v0, v0, v1

    iput v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->repeatGap:F

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v0

    const/high16 v1, 0x41f00000    # 30.0f

    mul-float v0, v0, v1

    iput v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->repeatStart:F

    const/4 v0, 0x0

    :goto_19
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v1

    if-ge v0, v1, :cond_134

    invoke-interface {p2, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p2, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "src"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_33

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->src:Ljava/lang/String;

    goto/16 :goto_12b

    :cond_33
    const-string v3, "align-center"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_43

    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->alignCenter:Z

    goto/16 :goto_12b

    :cond_43
    const-string v3, "cat"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4f

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->category:Ljava/lang/String;

    goto/16 :goto_12b

    :cond_4f
    const-string v3, "display"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5f

    invoke-static {v2}, Lorg/mapsforge/core/graphics/Display;->fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Display;

    move-result-object v1

    iput-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->display:Lorg/mapsforge/core/graphics/Display;

    goto/16 :goto_12b

    :cond_5f
    const-string v3, "dy"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_77

    invoke-static {v2}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v1

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v1, v1, v2

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->dy:F

    goto/16 :goto_12b

    :cond_77
    const-string v3, "priority"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_87

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->priority:I

    goto/16 :goto_12b

    :cond_87
    const-string v3, "repeat"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_97

    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->repeat:Z

    goto/16 :goto_12b

    :cond_97
    const-string v3, "repeat-gap"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_af

    invoke-static {v2}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v1

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v1, v1, v2

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->repeatGap:F

    goto/16 :goto_12b

    :cond_af
    const-string v3, "repeat-start"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_c6

    invoke-static {v2}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v1

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v1, v1, v2

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->repeatStart:F

    goto :goto_12b

    :cond_c6
    const-string v3, "rotate"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_d5

    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->rotate:Z

    goto :goto_12b

    :cond_d5
    const-string v3, "scale"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_e4

    invoke-virtual {p0, v2}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->scaleFromValue(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    move-result-object v1

    iput-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    goto :goto_12b

    :cond_e4
    const-string v3, "symbol-height"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_fc

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    int-to-float v1, v1

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v1, v1, v2

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->height:F

    goto :goto_12b

    :cond_fc
    const-string v3, "symbol-percent"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_10b

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->percent:I

    goto :goto_12b

    :cond_10b
    const-string v3, "symbol-scaling"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_114

    goto :goto_12b

    :cond_114
    const-string v3, "symbol-width"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_12f

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    int-to-float v1, v1

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v1, v1, v2

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->width:F

    :goto_12b
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_19

    :cond_12f
    invoke-static {p1, v1, v2, v0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->createXmlPullParserException(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lorg/xmlpull/v1/XmlPullParserException;

    move-result-object p1

    throw p1

    :cond_134
    return-void
.end method


# virtual methods
.method public destroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v0, :cond_7

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    :cond_7
    return-void
.end method

.method public renderNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/PointOfInterest;)V
    .registers 4

    return-void
.end method

.method public renderWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 18

    move-object v0, p0

    sget-object v1, Lorg/mapsforge/core/graphics/Display;->NEVER:Lorg/mapsforge/core/graphics/Display;

    iget-object v2, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->display:Lorg/mapsforge/core/graphics/Display;

    if-ne v1, v2, :cond_8

    return-void

    :cond_8
    iget-object v1, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-nez v1, :cond_1e

    iget-boolean v1, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->bitmapInvalid:Z

    if-nez v1, :cond_1e

    :try_start_10
    iget-object v1, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->relativePathPrefix:Ljava/lang/String;

    iget-object v2, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->src:Ljava/lang/String;

    invoke-virtual {p0, v1, v2}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->createBitmap(Ljava/lang/String;Ljava/lang/String;)Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v1

    iput-object v1, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;
    :try_end_1a
    .catch Ljava/io/IOException; {:try_start_10 .. :try_end_1a} :catch_1b

    goto :goto_1e

    :catch_1b
    const/4 v1, 0x1

    iput-boolean v1, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->bitmapInvalid:Z

    :cond_1e
    :goto_1e
    iget-object v1, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->dyScaled:Ljava/util/Map;

    move-object/from16 v3, p2

    iget-object v2, v3, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v2, v2, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v2, v2, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Float;

    if-nez v1, :cond_3a

    iget v1, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->dy:F

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    :cond_3a
    iget-object v6, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v6, :cond_58

    iget-object v4, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->display:Lorg/mapsforge/core/graphics/Display;

    iget v5, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->priority:I

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v7

    iget-boolean v8, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->alignCenter:Z

    iget-boolean v9, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->repeat:Z

    iget v10, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->repeatGap:F

    iget v11, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->repeatStart:F

    iget-boolean v12, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->rotate:Z

    move-object v2, p1

    move-object/from16 v3, p2

    move-object/from16 v13, p3

    invoke-interface/range {v2 .. v13}, Lorg/mapsforge/map/rendertheme/RenderCallback;->renderWaySymbol(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Display;ILorg/mapsforge/core/graphics/Bitmap;FZZFFZLorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    :cond_58
    return-void
.end method

.method public scaleStrokeWidth(FB)V
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->scale:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    sget-object v1, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;->NONE:Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction$Scale;

    if-ne v0, v1, :cond_8

    const/high16 p1, 0x3f800000    # 1.0f

    :cond_8
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->dyScaled:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p2

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;->dy:F

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
