.class public Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;
.super Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;
.source "SourceFile"


# static fields
.field public static final DEFAULT_GAP:F = 5.0f


# instance fields
.field private bitmap:Lorg/mapsforge/core/graphics/Bitmap;

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

.field private final gap:F

.field private final maxTextWidth:I

.field private position:Lorg/mapsforge/core/graphics/Position;

.field private priority:I

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

.field private symbolId:Ljava/lang/String;

.field private textKey:Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;)V
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/core/graphics/GraphicFactory;",
            "Lorg/mapsforge/map/model/DisplayModel;",
            "Ljava/lang/String;",
            "Lorg/xmlpull/v1/XmlPullParser;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->fill:Lorg/mapsforge/core/graphics/Paint;

    sget-object v1, Lorg/mapsforge/core/graphics/Color;->BLACK:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object v2, Lorg/mapsforge/core/graphics/Style;->FILL:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {v0, v2}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->fills:Ljava/util/Map;

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object v2

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v2, v1}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object v1, Lorg/mapsforge/core/graphics/Style;->STROKE:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {v2, v1}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->strokes:Ljava/util/Map;

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->dyScaled:Ljava/util/Map;

    sget-object v1, Lorg/mapsforge/core/graphics/Display;->IFSPACE:Lorg/mapsforge/core/graphics/Display;

    iput-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->display:Lorg/mapsforge/core/graphics/Display;

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v1

    const/high16 v3, 0x40a00000    # 5.0f

    mul-float v1, v1, v3

    iput v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->gap:F

    invoke-direct {p0, p1, p2, p3, p4}, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->extractValues(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->symbolId:Ljava/lang/String;

    if-eqz p1, :cond_59

    invoke-interface {p5, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;

    if-eqz p1, :cond_59

    invoke-virtual {p1}, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->getBitmap()Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    :cond_59
    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->position:Lorg/mapsforge/core/graphics/Position;

    if-nez p1, :cond_68

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-nez p1, :cond_64

    sget-object p1, Lorg/mapsforge/core/graphics/Position;->CENTER:Lorg/mapsforge/core/graphics/Position;

    goto :goto_66

    :cond_64
    sget-object p1, Lorg/mapsforge/core/graphics/Position;->BELOW:Lorg/mapsforge/core/graphics/Position;

    :goto_66
    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->position:Lorg/mapsforge/core/graphics/Position;

    :cond_68
    sget-object p1, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption$1;->$SwitchMap$org$mapsforge$core$graphics$Position:[I

    iget-object p3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->position:Lorg/mapsforge/core/graphics/Position;

    invoke-virtual {p3}, Ljava/lang/Enum;->ordinal()I

    move-result p3

    aget p1, p1, p3

    packed-switch p1, :pswitch_data_92

    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "Position invalid"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_7d
    sget-object p1, Lorg/mapsforge/core/graphics/Align;->LEFT:Lorg/mapsforge/core/graphics/Align;

    goto :goto_85

    :pswitch_80
    sget-object p1, Lorg/mapsforge/core/graphics/Align;->RIGHT:Lorg/mapsforge/core/graphics/Align;

    goto :goto_85

    :pswitch_83
    sget-object p1, Lorg/mapsforge/core/graphics/Align;->CENTER:Lorg/mapsforge/core/graphics/Align;

    :goto_85
    invoke-interface {v2, p1}, Lorg/mapsforge/core/graphics/Paint;->setTextAlign(Lorg/mapsforge/core/graphics/Align;)V

    invoke-interface {v0, p1}, Lorg/mapsforge/core/graphics/Paint;->setTextAlign(Lorg/mapsforge/core/graphics/Align;)V

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getMaxTextWidth()I

    move-result p1

    iput p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->maxTextWidth:I

    return-void

    :pswitch_data_92
    .packed-switch 0x1
        :pswitch_83
        :pswitch_83
        :pswitch_83
        :pswitch_80
        :pswitch_80
        :pswitch_80
        :pswitch_7d
        :pswitch_7d
        :pswitch_7d
    .end packed-switch
.end method

.method private computeHorizontalOffset()F
    .registers 4

    sget-object v0, Lorg/mapsforge/core/graphics/Position;->RIGHT:Lorg/mapsforge/core/graphics/Position;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->position:Lorg/mapsforge/core/graphics/Position;

    if-eq v0, v1, :cond_1d

    sget-object v0, Lorg/mapsforge/core/graphics/Position;->LEFT:Lorg/mapsforge/core/graphics/Position;

    if-eq v0, v1, :cond_1d

    sget-object v0, Lorg/mapsforge/core/graphics/Position;->BELOW_RIGHT:Lorg/mapsforge/core/graphics/Position;

    if-eq v0, v1, :cond_1d

    sget-object v0, Lorg/mapsforge/core/graphics/Position;->BELOW_LEFT:Lorg/mapsforge/core/graphics/Position;

    if-eq v0, v1, :cond_1d

    sget-object v0, Lorg/mapsforge/core/graphics/Position;->ABOVE_RIGHT:Lorg/mapsforge/core/graphics/Position;

    if-eq v0, v1, :cond_1d

    sget-object v0, Lorg/mapsforge/core/graphics/Position;->ABOVE_LEFT:Lorg/mapsforge/core/graphics/Position;

    if-ne v0, v1, :cond_1b

    goto :goto_1d

    :cond_1b
    const/4 v0, 0x0

    return v0

    :cond_1d
    :goto_1d
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result v0

    int-to-float v0, v0

    const/high16 v1, 0x40000000    # 2.0f

    div-float/2addr v0, v1

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->gap:F

    add-float/2addr v0, v1

    sget-object v1, Lorg/mapsforge/core/graphics/Position;->LEFT:Lorg/mapsforge/core/graphics/Position;

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->position:Lorg/mapsforge/core/graphics/Position;

    if-eq v1, v2, :cond_38

    sget-object v1, Lorg/mapsforge/core/graphics/Position;->BELOW_LEFT:Lorg/mapsforge/core/graphics/Position;

    if-eq v1, v2, :cond_38

    sget-object v1, Lorg/mapsforge/core/graphics/Position;->ABOVE_LEFT:Lorg/mapsforge/core/graphics/Position;

    if-ne v1, v2, :cond_3c

    :cond_38
    const/high16 v1, -0x40800000    # -1.0f

    mul-float v0, v0, v1

    :cond_3c
    return v0
.end method

.method private computeVerticalOffset(B)F
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->dyScaled:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Float;

    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result p1

    sget-object v0, Lorg/mapsforge/core/graphics/Position;->ABOVE:Lorg/mapsforge/core/graphics/Position;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->position:Lorg/mapsforge/core/graphics/Position;

    const/high16 v2, 0x40000000    # 2.0f

    if-eq v0, v1, :cond_3a

    sget-object v0, Lorg/mapsforge/core/graphics/Position;->ABOVE_LEFT:Lorg/mapsforge/core/graphics/Position;

    if-eq v0, v1, :cond_3a

    sget-object v0, Lorg/mapsforge/core/graphics/Position;->ABOVE_RIGHT:Lorg/mapsforge/core/graphics/Position;

    if-ne v0, v1, :cond_21

    goto :goto_3a

    :cond_21
    sget-object v0, Lorg/mapsforge/core/graphics/Position;->BELOW:Lorg/mapsforge/core/graphics/Position;

    if-eq v0, v1, :cond_2d

    sget-object v0, Lorg/mapsforge/core/graphics/Position;->BELOW_LEFT:Lorg/mapsforge/core/graphics/Position;

    if-eq v0, v1, :cond_2d

    sget-object v0, Lorg/mapsforge/core/graphics/Position;->BELOW_RIGHT:Lorg/mapsforge/core/graphics/Position;

    if-ne v0, v1, :cond_46

    :cond_2d
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result v0

    int-to-float v0, v0

    div-float/2addr v0, v2

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->gap:F

    add-float/2addr v0, v1

    add-float/2addr p1, v0

    goto :goto_46

    :cond_3a
    :goto_3a
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result v0

    int-to-float v0, v0

    div-float/2addr v0, v2

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->gap:F

    add-float/2addr v0, v1

    sub-float/2addr p1, v0

    :cond_46
    :goto_46
    return p1
.end method

.method private extractValues(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 11

    sget-object v0, Lorg/mapsforge/core/graphics/FontFamily;->DEFAULT:Lorg/mapsforge/core/graphics/FontFamily;

    sget-object v1, Lorg/mapsforge/core/graphics/FontStyle;->NORMAL:Lorg/mapsforge/core/graphics/FontStyle;

    const/4 v2, 0x0

    :goto_5
    invoke-interface {p4}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v3

    const-string v4, "k"

    if-ge v2, v3, :cond_f0

    invoke-interface {p4, v2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {p4, v2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_23

    invoke-static {v5}, Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;->getInstance(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;

    move-result-object v3

    iput-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->textKey:Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;

    goto/16 :goto_e7

    :cond_23
    const-string v4, "cat"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2f

    iput-object v5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->category:Ljava/lang/String;

    goto/16 :goto_e7

    :cond_2f
    const-string v4, "display"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3f

    invoke-static {v5}, Lorg/mapsforge/core/graphics/Display;->fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Display;

    move-result-object v3

    iput-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->display:Lorg/mapsforge/core/graphics/Display;

    goto/16 :goto_e7

    :cond_3f
    const-string v4, "dy"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_55

    invoke-static {v5}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v3

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v4

    mul-float v3, v3, v4

    iput v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->dy:F

    goto/16 :goto_e7

    :cond_55
    const-string v4, "fill"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6c

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->fill:Lorg/mapsforge/core/graphics/Paint;

    :goto_5f
    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getThemeCallback()Lorg/mapsforge/map/rendertheme/ThemeCallback;

    move-result-object v4

    invoke-static {p1, v5, v4, p0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->getColor(Lorg/mapsforge/core/graphics/GraphicFactory;Ljava/lang/String;Lorg/mapsforge/map/rendertheme/ThemeCallback;Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)I

    move-result v4

    invoke-interface {v3, v4}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    goto/16 :goto_e7

    :cond_6c
    const-string v4, "font-family"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7a

    invoke-static {v5}, Lorg/mapsforge/core/graphics/FontFamily;->fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/FontFamily;

    move-result-object v0

    goto/16 :goto_e7

    :cond_7a
    const-string v4, "font-size"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8f

    invoke-static {v3, v5}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeFloat(Ljava/lang/String;Ljava/lang/String;)F

    move-result v3

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v4

    mul-float v3, v3, v4

    iput v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->fontSize:F

    goto :goto_e7

    :cond_8f
    const-string v4, "font-style"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_9c

    invoke-static {v5}, Lorg/mapsforge/core/graphics/FontStyle;->fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/FontStyle;

    move-result-object v1

    goto :goto_e7

    :cond_9c
    const-string v4, "position"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_ab

    invoke-static {v5}, Lorg/mapsforge/core/graphics/Position;->fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Position;

    move-result-object v3

    iput-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->position:Lorg/mapsforge/core/graphics/Position;

    goto :goto_e7

    :cond_ab
    const-string v4, "priority"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_ba

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    iput v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->priority:I

    goto :goto_e7

    :cond_ba
    const-string v4, "stroke"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_c5

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->stroke:Lorg/mapsforge/core/graphics/Paint;

    goto :goto_5f

    :cond_c5
    const-string v4, "stroke-width"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_dd

    iget-object v4, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {v3, v5}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeFloat(Ljava/lang/String;Ljava/lang/String;)F

    move-result v3

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v5

    mul-float v3, v3, v5

    invoke-interface {v4, v3}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    goto :goto_e7

    :cond_dd
    const-string v4, "symbol-id"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_eb

    iput-object v5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->symbolId:Ljava/lang/String;

    :goto_e7
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_5

    :cond_eb
    invoke-static {p3, v3, v5, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->createXmlPullParserException(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lorg/xmlpull/v1/XmlPullParserException;

    move-result-object p1

    throw p1

    :cond_f0
    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->fill:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1, v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setTypeface(Lorg/mapsforge/core/graphics/FontFamily;Lorg/mapsforge/core/graphics/FontStyle;)V

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1, v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setTypeface(Lorg/mapsforge/core/graphics/FontFamily;Lorg/mapsforge/core/graphics/FontStyle;)V

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->textKey:Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;

    invoke-static {p3, v4, p1}, Lorg/mapsforge/map/rendertheme/XmlUtils;->checkMandatoryAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private getFillPaint(B)Lorg/mapsforge/core/graphics/Paint;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->fills:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/core/graphics/Paint;

    if-nez p1, :cond_10

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->fill:Lorg/mapsforge/core/graphics/Paint;

    :cond_10
    return-object p1
.end method

.method private getStrokePaint(B)Lorg/mapsforge/core/graphics/Paint;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->strokes:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/core/graphics/Paint;

    if-nez p1, :cond_10

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->stroke:Lorg/mapsforge/core/graphics/Paint;

    :cond_10
    return-object p1
.end method


# virtual methods
.method public destroy()V
    .registers 1

    return-void
.end method

.method public renderNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/PointOfInterest;)V
    .registers 18

    move-object v0, p0

    move-object/from16 v2, p2

    sget-object v1, Lorg/mapsforge/core/graphics/Display;->NEVER:Lorg/mapsforge/core/graphics/Display;

    iget-object v3, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->display:Lorg/mapsforge/core/graphics/Display;

    if-ne v1, v3, :cond_a

    return-void

    :cond_a
    iget-object v1, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->textKey:Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;

    move-object/from16 v12, p3

    iget-object v3, v12, Lorg/mapsforge/map/datastore/PointOfInterest;->tags:Ljava/util/List;

    invoke-virtual {v1, v3}, Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;->getValue(Ljava/util/List;)Ljava/lang/String;

    move-result-object v5

    if-nez v5, :cond_17

    return-void

    :cond_17
    const/4 v1, 0x0

    iget-object v3, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->dyScaled:Ljava/util/Map;

    iget-object v4, v2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v4, v4, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v4, v4, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v4}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    if-nez v3, :cond_32

    iget v3, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->dy:F

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    :cond_32
    iget-object v4, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v4, :cond_4a

    invoke-direct {p0}, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->computeHorizontalOffset()F

    move-result v1

    iget-object v3, v2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v3, v3, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v3, v3, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v3}, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->computeVerticalOffset(B)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    move v6, v1

    goto :goto_4b

    :cond_4a
    const/4 v6, 0x0

    :goto_4b
    iget-object v4, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->display:Lorg/mapsforge/core/graphics/Display;

    iget v7, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->priority:I

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v8

    iget-object v1, v2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v1, v1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v1}, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->getFillPaint(B)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v9

    iget-object v1, v2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v1, v1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v1}, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->getStrokePaint(B)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v10

    iget-object v11, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->position:Lorg/mapsforge/core/graphics/Position;

    iget v13, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->maxTextWidth:I

    move-object v1, p1

    move-object/from16 v2, p2

    move-object v3, v4

    move v4, v7

    move v7, v8

    move-object v8, v9

    move-object v9, v10

    move-object v10, v11

    move v11, v13

    move-object/from16 v12, p3

    invoke-interface/range {v1 .. v12}, Lorg/mapsforge/map/rendertheme/RenderCallback;->renderPointOfInterestCaption(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;FFLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Position;ILorg/mapsforge/map/datastore/PointOfInterest;)V

    return-void
.end method

.method public renderWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 17

    move-object v0, p0

    move-object v2, p2

    sget-object v1, Lorg/mapsforge/core/graphics/Display;->NEVER:Lorg/mapsforge/core/graphics/Display;

    iget-object v3, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->display:Lorg/mapsforge/core/graphics/Display;

    if-ne v1, v3, :cond_9

    return-void

    :cond_9
    iget-object v1, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->textKey:Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;

    invoke-virtual/range {p3 .. p3}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getTags()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v1, v3}, Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;->getValue(Ljava/util/List;)Ljava/lang/String;

    move-result-object v5

    if-nez v5, :cond_16

    return-void

    :cond_16
    const/4 v1, 0x0

    iget-object v3, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->dyScaled:Ljava/util/Map;

    iget-object v4, v2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v4, v4, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v4, v4, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v4}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    if-nez v3, :cond_31

    iget v3, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->dy:F

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    :cond_31
    iget-object v4, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v4, :cond_49

    invoke-direct {p0}, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->computeHorizontalOffset()F

    move-result v1

    iget-object v3, v2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v3, v3, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v3, v3, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v3}, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->computeVerticalOffset(B)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    move v6, v1

    goto :goto_4a

    :cond_49
    const/4 v6, 0x0

    :goto_4a
    iget-object v4, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->display:Lorg/mapsforge/core/graphics/Display;

    iget v7, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->priority:I

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v8

    iget-object v1, v2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v1, v1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v1}, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->getFillPaint(B)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v9

    iget-object v1, v2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v1, v1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, v1}, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->getStrokePaint(B)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v10

    iget-object v11, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->position:Lorg/mapsforge/core/graphics/Position;

    iget v12, v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->maxTextWidth:I

    move-object v1, p1

    move-object v2, p2

    move-object v3, v4

    move v4, v7

    move v7, v8

    move-object v8, v9

    move-object v9, v10

    move-object v10, v11

    move v11, v12

    move-object/from16 v12, p3

    invoke-interface/range {v1 .. v12}, Lorg/mapsforge/map/rendertheme/RenderCallback;->renderAreaCaption(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;FFLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Position;ILorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    return-void
.end method

.method public scaleStrokeWidth(FB)V
    .registers 3

    return-void
.end method

.method public scaleTextSize(FB)V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->fill:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint(Lorg/mapsforge/core/graphics/Paint;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->fontSize:F

    mul-float v1, v1, p1

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setTextSize(F)V

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->fills:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->stroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint(Lorg/mapsforge/core/graphics/Paint;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->fontSize:F

    mul-float v1, v1, p1

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setTextSize(F)V

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->strokes:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->dyScaled:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p2

    iget v1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;->dy:F

    mul-float v1, v1, p1

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    invoke-interface {v0, p2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method
