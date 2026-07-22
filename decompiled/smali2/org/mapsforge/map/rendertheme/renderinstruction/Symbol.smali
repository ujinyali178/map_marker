.class public Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;
.super Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;
.source "SourceFile"


# instance fields
.field private bitmap:Lorg/mapsforge/core/graphics/Bitmap;

.field private bitmapInvalid:Z

.field private display:Lorg/mapsforge/core/graphics/Display;

.field private id:Ljava/lang/String;

.field private priority:I

.field private final relativePathPrefix:Ljava/lang/String;

.field private src:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V
    .registers 6

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V

    iput-object p5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->relativePathPrefix:Ljava/lang/String;

    sget-object p1, Lorg/mapsforge/core/graphics/Display;->IFSPACE:Lorg/mapsforge/core/graphics/Display;

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->display:Lorg/mapsforge/core/graphics/Display;

    invoke-direct {p0, p3, p4}, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->extractValues(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V

    return-void
.end method

.method private extractValues(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v1

    if-ge v0, v1, :cond_a0

    invoke-interface {p2, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p2, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "src"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1b

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->src:Ljava/lang/String;

    goto/16 :goto_97

    :cond_1b
    const-string v3, "cat"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_27

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->category:Ljava/lang/String;

    goto/16 :goto_97

    :cond_27
    const-string v3, "display"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_36

    invoke-static {v2}, Lorg/mapsforge/core/graphics/Display;->fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Display;

    move-result-object v1

    iput-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->display:Lorg/mapsforge/core/graphics/Display;

    goto :goto_97

    :cond_36
    const-string v3, "id"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_41

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->id:Ljava/lang/String;

    goto :goto_97

    :cond_41
    const-string v3, "priority"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_50

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->priority:I

    goto :goto_97

    :cond_50
    const-string v3, "symbol-height"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_68

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    int-to-float v1, v1

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v1, v1, v2

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->height:F

    goto :goto_97

    :cond_68
    const-string v3, "symbol-percent"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_77

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->percent:I

    goto :goto_97

    :cond_77
    const-string v3, "symbol-scaling"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_80

    goto :goto_97

    :cond_80
    const-string v3, "symbol-width"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_9b

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    int-to-float v1, v1

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v1, v1, v2

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->width:F

    :goto_97
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    :cond_9b
    invoke-static {p1, v1, v2, v0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->createXmlPullParserException(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lorg/xmlpull/v1/XmlPullParserException;

    move-result-object p1

    throw p1

    :cond_a0
    return-void
.end method


# virtual methods
.method public destroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v0, :cond_7

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    :cond_7
    return-void
.end method

.method public getBitmap()Lorg/mapsforge/core/graphics/Bitmap;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-nez v0, :cond_16

    iget-boolean v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->bitmapInvalid:Z

    if-nez v0, :cond_16

    :try_start_8
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->relativePathPrefix:Ljava/lang/String;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->src:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->createBitmap(Ljava/lang/String;Ljava/lang/String;)Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;
    :try_end_12
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_12} :catch_13

    goto :goto_16

    :catch_13
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->bitmapInvalid:Z

    :cond_16
    :goto_16
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->id:Ljava/lang/String;

    return-object v0
.end method

.method public renderNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/PointOfInterest;)V
    .registers 11

    sget-object v0, Lorg/mapsforge/core/graphics/Display;->NEVER:Lorg/mapsforge/core/graphics/Display;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->display:Lorg/mapsforge/core/graphics/Display;

    if-ne v0, v1, :cond_7

    return-void

    :cond_7
    invoke-virtual {p0}, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->getBitmap()Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_19

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->display:Lorg/mapsforge/core/graphics/Display;

    iget v4, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->priority:I

    iget-object v5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    move-object v1, p1

    move-object v2, p2

    move-object v6, p3

    invoke-interface/range {v1 .. v6}, Lorg/mapsforge/map/rendertheme/RenderCallback;->renderPointOfInterestSymbol(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Display;ILorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/map/datastore/PointOfInterest;)V

    :cond_19
    return-void
.end method

.method public renderWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 11

    sget-object v0, Lorg/mapsforge/core/graphics/Display;->NEVER:Lorg/mapsforge/core/graphics/Display;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->display:Lorg/mapsforge/core/graphics/Display;

    if-ne v0, v1, :cond_7

    return-void

    :cond_7
    invoke-virtual {p0}, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->getBitmap()Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_19

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->display:Lorg/mapsforge/core/graphics/Display;

    iget v4, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->priority:I

    iget-object v5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    move-object v1, p1

    move-object v2, p2

    move-object v6, p3

    invoke-interface/range {v1 .. v6}, Lorg/mapsforge/map/rendertheme/RenderCallback;->renderAreaSymbol(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Display;ILorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    :cond_19
    return-void
.end method

.method public scaleStrokeWidth(FB)V
    .registers 3

    return-void
.end method

.method public scaleTextSize(FB)V
    .registers 3

    return-void
.end method
