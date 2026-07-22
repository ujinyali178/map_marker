.class public Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final BASE_STROKE_WIDTH:Ljava/lang/String; = "base-stroke-width"

.field private static final BASE_TEXT_SIZE:Ljava/lang/String; = "base-text-size"

.field private static final MAP_BACKGROUND:Ljava/lang/String; = "map-background"

.field private static final MAP_BACKGROUND_OUTSIDE:Ljava/lang/String; = "map-background-outside"

.field private static final RENDER_THEME_VERSION:I = 0x6

.field private static final VERSION:Ljava/lang/String; = "version"

.field private static final XMLNS:Ljava/lang/String; = "xmlns"

.field private static final XMLNS_XSI:Ljava/lang/String; = "xmlns:xsi"

.field private static final XSI_SCHEMALOCATION:Ljava/lang/String; = "xsi:schemaLocation"


# instance fields
.field baseStrokeWidth:F

.field baseTextSize:F

.field private final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field hasBackgroundOutside:Z

.field mapBackground:I

.field mapBackgroundOutside:I

.field private version:Ljava/lang/Integer;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    const/high16 p2, 0x3f800000    # 1.0f

    iput p2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->baseStrokeWidth:F

    iput p2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->baseTextSize:F

    sget-object p2, Lorg/mapsforge/core/graphics/Color;->WHITE:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {p1, p2}, Lorg/mapsforge/core/graphics/GraphicFactory;->createColor(Lorg/mapsforge/core/graphics/Color;)I

    move-result p2

    iput p2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->mapBackground:I

    invoke-direct {p0, p1, p3, p4}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->extractValues(Lorg/mapsforge/core/graphics/GraphicFactory;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V

    return-void
.end method

.method private extractValues(Lorg/mapsforge/core/graphics/GraphicFactory;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 9

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p3}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v1

    if-ge v0, v1, :cond_92

    invoke-interface {p3, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p3, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "xmlns"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_19

    goto/16 :goto_89

    :cond_19
    const-string v3, "xmlns:xsi"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_22

    goto :goto_89

    :cond_22
    const-string v3, "xsi:schemaLocation"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2b

    goto :goto_89

    :cond_2b
    const-string v3, "version"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3e

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->version:Ljava/lang/Integer;

    goto :goto_89

    :cond_3e
    const-string v3, "map-background"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    const/4 v4, 0x0

    if-eqz v3, :cond_54

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getThemeCallback()Lorg/mapsforge/map/rendertheme/ThemeCallback;

    move-result-object v1

    invoke-static {p1, v2, v1, v4}, Lorg/mapsforge/map/rendertheme/XmlUtils;->getColor(Lorg/mapsforge/core/graphics/GraphicFactory;Ljava/lang/String;Lorg/mapsforge/map/rendertheme/ThemeCallback;Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)I

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->mapBackground:I

    goto :goto_89

    :cond_54
    const-string v3, "map-background-outside"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6c

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getThemeCallback()Lorg/mapsforge/map/rendertheme/ThemeCallback;

    move-result-object v1

    invoke-static {p1, v2, v1, v4}, Lorg/mapsforge/map/rendertheme/XmlUtils;->getColor(Lorg/mapsforge/core/graphics/GraphicFactory;Ljava/lang/String;Lorg/mapsforge/map/rendertheme/ThemeCallback;Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)I

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->mapBackgroundOutside:I

    const/4 v1, 0x1

    iput-boolean v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->hasBackgroundOutside:Z

    goto :goto_89

    :cond_6c
    const-string v3, "base-stroke-width"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7b

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeFloat(Ljava/lang/String;Ljava/lang/String;)F

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->baseStrokeWidth:F

    goto :goto_89

    :cond_7b
    const-string v3, "base-text-size"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8d

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeFloat(Ljava/lang/String;Ljava/lang/String;)F

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->baseTextSize:F

    :goto_89
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    :cond_8d
    invoke-static {p2, v1, v2, v0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->createXmlPullParserException(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lorg/xmlpull/v1/XmlPullParserException;

    move-result-object p1

    throw p1

    :cond_92
    invoke-direct {p0, p2}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->validate(Ljava/lang/String;)V

    return-void
.end method

.method private validate(Ljava/lang/String;)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->version:Ljava/lang/Integer;

    const-string v1, "version"

    invoke-static {p1, v1, v0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->checkMandatoryAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->version:Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    const/4 v0, 0x6

    if-gt p1, v0, :cond_11

    return-void

    :cond_11
    new-instance p1, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "unsupported render theme version: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->version:Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw p1
.end method


# virtual methods
.method public build()Lorg/mapsforge/map/rendertheme/rule/RenderTheme;
    .registers 2

    new-instance v0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-direct {v0, p0}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;-><init>(Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;)V

    return-object v0
.end method
