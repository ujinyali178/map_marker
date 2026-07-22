.class public final Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;
    }
.end annotation


# static fields
.field private static final ELEMENT_NAME_RULE:Ljava/lang/String; = "rule"

.field private static final LOGGER:Ljava/util/logging/Logger;

.field private static final UNEXPECTED_ELEMENT:Ljava/lang/String; = "unexpected element: "

.field private static xmlPullParserFactory:Lorg/xmlpull/v1/XmlPullParserFactory;


# instance fields
.field private categories:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private currentLayer:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

.field private currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

.field private final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field private final elementStack:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack<",
            "Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;",
            ">;"
        }
    .end annotation
.end field

.field private final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field private level:I

.field private final pullParser:Lorg/xmlpull/v1/XmlPullParser;

.field private qName:Ljava/lang/String;

.field private final relativePathPrefix:Ljava/lang/String;

.field private renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

.field private renderThemeStyleMenu:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;

.field private final ruleStack:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack<",
            "Lorg/mapsforge/map/rendertheme/rule/Rule;",
            ">;"
        }
    .end annotation
.end field

.field private symbols:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;",
            ">;"
        }
    .end annotation
.end field

.field private final xmlRenderTheme:Lorg/mapsforge/map/rendertheme/XmlRenderTheme;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->LOGGER:Ljava/util/logging/Logger;

    const/4 v0, 0x0

    sput-object v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->xmlPullParserFactory:Lorg/xmlpull/v1/XmlPullParserFactory;

    return-void
.end method

.method private constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/mapsforge/map/rendertheme/XmlRenderTheme;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 7

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->elementStack:Ljava/util/Stack;

    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->ruleStack:Ljava/util/Stack;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->symbols:Ljava/util/Map;

    iput-object p5, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iput-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iput-object p3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->relativePathPrefix:Ljava/lang/String;

    iput-object p4, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->xmlRenderTheme:Lorg/mapsforge/map/rendertheme/XmlRenderTheme;

    return-void
.end method

.method private checkElement(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V
    .registers 6

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$1;->$SwitchMap$org$mapsforge$map$rendertheme$rule$RenderThemeHandler$Element:[I

    invoke-virtual {p2}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    const-string v2, "unexpected element: "

    if-eq v0, v1, :cond_75

    const/4 v1, 0x2

    if-eq v0, v1, :cond_4e

    const/4 v1, 0x3

    if-eq v0, v1, :cond_2e

    const/4 p1, 0x4

    if-ne v0, p1, :cond_17

    return-void

    :cond_17
    new-instance p1, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "unknown enum value: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_2e
    iget-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->elementStack:Ljava/util/Stack;

    invoke-virtual {p2}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object p2

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RULE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    if-ne p2, v0, :cond_39

    return-void

    :cond_39
    new-instance p2, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw p2

    :cond_4e
    iget-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->elementStack:Ljava/util/Stack;

    invoke-virtual {p2}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDER_THEME:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    if-eq p2, v0, :cond_74

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RULE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    if-ne p2, v0, :cond_5f

    goto :goto_74

    :cond_5f
    new-instance p2, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw p2

    :cond_74
    :goto_74
    return-void

    :cond_75
    iget-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->elementStack:Ljava/util/Stack;

    invoke-virtual {p2}, Ljava/util/Stack;->empty()Z

    move-result p2

    if-eqz p2, :cond_7e

    return-void

    :cond_7e
    new-instance p2, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw p2
.end method

.method private checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V
    .registers 3

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkElement(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->elementStack:Ljava/util/Stack;

    invoke-virtual {p1, p2}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private endDocument()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    if-eqz v0, :cond_f

    iget v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->level:I

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->setLevels(I)V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v0}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->complete()V

    return-void

    :cond_f
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "missing element: rules"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private endElement()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->elementStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    const-string v1, "rule"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3f

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->ruleStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->ruleStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->empty()Z

    move-result v0

    if-eqz v0, :cond_34

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->isVisible(Lorg/mapsforge/map/rendertheme/rule/Rule;)Z

    move-result v0

    if-eqz v0, :cond_5f

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->addRule(Lorg/mapsforge/map/rendertheme/rule/Rule;)V

    goto :goto_5f

    :cond_34
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->ruleStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/map/rendertheme/rule/Rule;

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

    goto :goto_5f

    :cond_3f
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    const-string v1, "stylemenu"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5f

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->xmlRenderTheme:Lorg/mapsforge/map/rendertheme/XmlRenderTheme;

    invoke-interface {v0}, Lorg/mapsforge/map/rendertheme/XmlRenderTheme;->getMenuCallback()Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;

    move-result-object v0

    if-eqz v0, :cond_5f

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->xmlRenderTheme:Lorg/mapsforge/map/rendertheme/XmlRenderTheme;

    invoke-interface {v0}, Lorg/mapsforge/map/rendertheme/XmlRenderTheme;->getMenuCallback()Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;

    move-result-object v0

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->renderThemeStyleMenu:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;

    invoke-interface {v0, v1}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;->getCategories(Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->categories:Ljava/util/Set;

    :cond_5f
    :goto_5f
    return-void
.end method

.method public static getRenderTheme(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/map/rendertheme/XmlRenderTheme;)Lorg/mapsforge/map/rendertheme/rule/RenderTheme;
    .registers 12

    invoke-static {}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getXmlPullParserFactory()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v0

    invoke-virtual {v0}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v0

    new-instance v7, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;

    invoke-interface {p2}, Lorg/mapsforge/map/rendertheme/XmlRenderTheme;->getRelativePathPrefix()Ljava/lang/String;

    move-result-object v4

    move-object v1, v7

    move-object v2, p0

    move-object v3, p1

    move-object v5, p2

    move-object v6, v0

    invoke-direct/range {v1 .. v6}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/mapsforge/map/rendertheme/XmlRenderTheme;Lorg/xmlpull/v1/XmlPullParser;)V

    const/4 p0, 0x0

    :try_start_17
    invoke-interface {p2}, Lorg/mapsforge/map/rendertheme/XmlRenderTheme;->getRenderThemeAsStream()Ljava/io/InputStream;

    move-result-object p1
    :try_end_1b
    .catchall {:try_start_17 .. :try_end_1b} :catchall_29

    :try_start_1b
    invoke-interface {v0, p1, p0}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-virtual {v7}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->processRenderTheme()V

    iget-object p0, v7, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;
    :try_end_23
    .catchall {:try_start_1b .. :try_end_23} :catchall_27

    invoke-static {p1}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    return-object p0

    :catchall_27
    move-exception p0

    goto :goto_2d

    :catchall_29
    move-exception p1

    move-object v8, p1

    move-object p1, p0

    move-object p0, v8

    :goto_2d
    invoke-static {p1}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    throw p0
.end method

.method private getStringAttribute(Ljava/lang/String;)Ljava/lang/String;
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v0

    const/4 v1, 0x0

    :goto_7
    if-ge v1, v0, :cond_1f

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v2, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1c

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {p1, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_1c
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_1f
    const/4 p1, 0x0

    return-object p1
.end method

.method public static getXmlPullParserFactory()Lorg/xmlpull/v1/XmlPullParserFactory;
    .registers 1

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->xmlPullParserFactory:Lorg/xmlpull/v1/XmlPullParserFactory;

    if-nez v0, :cond_a

    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->xmlPullParserFactory:Lorg/xmlpull/v1/XmlPullParserFactory;

    :cond_a
    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->xmlPullParserFactory:Lorg/xmlpull/v1/XmlPullParserFactory;

    return-object v0
.end method

.method private isVisible(Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)Z
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->categories:Ljava/util/Set;

    if-eqz v0, :cond_19

    invoke-virtual {p1}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->getCategory()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_19

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->categories:Ljava/util/Set;

    invoke-virtual {p1}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->getCategory()Ljava/lang/String;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_17

    goto :goto_19

    :cond_17
    const/4 p1, 0x0

    goto :goto_1a

    :cond_19
    :goto_19
    const/4 p1, 0x1

    :goto_1a
    return p1
.end method

.method private isVisible(Lorg/mapsforge/map/rendertheme/rule/Rule;)Z
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->categories:Ljava/util/Set;

    if-eqz v0, :cond_11

    iget-object p1, p1, Lorg/mapsforge/map/rendertheme/rule/Rule;->cat:Ljava/lang/String;

    if-eqz p1, :cond_11

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_f

    goto :goto_11

    :cond_f
    const/4 p1, 0x0

    goto :goto_12

    :cond_11
    :goto_11
    const/4 p1, 0x1

    :goto_12
    return p1
.end method

.method public static setXmlPullParserFactory(Lorg/xmlpull/v1/XmlPullParserFactory;)V
    .registers 1

    sput-object p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->xmlPullParserFactory:Lorg/xmlpull/v1/XmlPullParserFactory;

    return-void
.end method

.method private startElement()V
    .registers 16

    const-string v0, "magnitude"

    const-string v1, "zoom-max"

    const-string v2, "zoom-min"

    const-string v3, "enabled"

    const-string v4, "cat"

    const-string v5, "layer"

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    :try_start_14
    const-string v7, "rendertheme"

    invoke-virtual {v7, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_38

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDER_THEME:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    new-instance v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    iget-object v4, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-direct {v0, v1, v2, v3, v4}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V

    invoke-virtual {v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->build()Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    goto/16 :goto_3a6

    :cond_38
    const-string v6, "rule"

    iget-object v7, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_74

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RULE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    new-instance v0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->ruleStack:Ljava/util/Stack;

    invoke-direct {v0, v1, v2, v3}, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;-><init>(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Stack;)V

    invoke-virtual {v0}, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->build()Lorg/mapsforge/map/rendertheme/rule/Rule;

    move-result-object v0

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->ruleStack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->empty()Z

    move-result v1

    if-nez v1, :cond_6b

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->isVisible(Lorg/mapsforge/map/rendertheme/rule/Rule;)Z

    move-result v1

    if-eqz v1, :cond_6b

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/rendertheme/rule/Rule;->addSubRule(Lorg/mapsforge/map/rendertheme/rule/Rule;)V

    :cond_6b
    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->ruleStack:Ljava/util/Stack;

    invoke-virtual {v1, v0}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_3a6

    :cond_74
    const-string v6, "area"

    iget-object v7, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_a8

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_INSTRUCTION:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    new-instance v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v4, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget-object v5, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    iget v7, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->level:I

    add-int/lit8 v1, v7, 0x1

    iput v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->level:I

    iget-object v8, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->relativePathPrefix:Ljava/lang/String;

    move-object v2, v0

    invoke-direct/range {v2 .. v8}, Lorg/mapsforge/map/rendertheme/renderinstruction/Area;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;ILjava/lang/String;)V

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->isVisible(Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)Z

    move-result v1

    if-eqz v1, :cond_3a6

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

    :goto_a3
    invoke-virtual {v1, v0}, Lorg/mapsforge/map/rendertheme/rule/Rule;->addRenderingInstruction(Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)V

    goto/16 :goto_3a6

    :cond_a8
    const-string v6, "caption"

    iget-object v7, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_d2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_INSTRUCTION:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    new-instance v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v4, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget-object v5, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    iget-object v7, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->symbols:Ljava/util/Map;

    move-object v2, v0

    invoke-direct/range {v2 .. v7}, Lorg/mapsforge/map/rendertheme/renderinstruction/Caption;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;)V

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->isVisible(Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)Z

    move-result v1

    if-eqz v1, :cond_3a6

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

    goto :goto_a3

    :cond_d2
    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v4, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6
    :try_end_d8
    .catch Ljava/io/IOException; {:try_start_14 .. :try_end_d8} :catch_38b

    const-string v7, "id"

    if-eqz v6, :cond_ee

    :try_start_dc
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_STYLE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentLayer:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

    invoke-direct {p0, v7}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getStringAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->addCategory(Ljava/lang/String;)V

    goto/16 :goto_3a6

    :cond_ee
    const-string v6, "circle"

    iget-object v8, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_11c

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_INSTRUCTION:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    new-instance v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v4, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget-object v5, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    iget v7, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->level:I

    add-int/lit8 v1, v7, 0x1

    iput v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->level:I

    move-object v2, v0

    invoke-direct/range {v2 .. v7}, Lorg/mapsforge/map/rendertheme/renderinstruction/Circle;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;I)V

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->isVisible(Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)Z

    move-result v1

    if-eqz v1, :cond_3a6

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

    goto :goto_a3

    :cond_11c
    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    const/4 v8, 0x0

    if-eqz v6, :cond_19c

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_STYLE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    invoke-direct {p0, v3}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getStringAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_13e

    invoke-direct {p0, v3}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getStringAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    :cond_13e
    const-string v0, "visible"

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getStringAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->renderThemeStyleMenu:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;

    invoke-direct {p0, v7}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getStringAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0, v8}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->createLayer(Ljava/lang/String;ZZ)Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentLayer:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

    const-string v0, "parent"

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getStringAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3a6

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->renderThemeStyleMenu:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->getLayer(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

    move-result-object v0

    if-eqz v0, :cond_3a6

    invoke-virtual {v0}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->getCategories()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_170
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_182

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentLayer:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

    invoke-virtual {v3, v2}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->addCategory(Ljava/lang/String;)V

    goto :goto_170

    :cond_182
    invoke-virtual {v0}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->getOverlays()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_18a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3a6

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentLayer:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

    invoke-virtual {v2, v1}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->addOverlay(Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;)V

    goto :goto_18a

    :cond_19c
    const-string v3, "line"

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1cd

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_INSTRUCTION:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    new-instance v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v4, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget-object v5, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    iget v7, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->level:I

    add-int/lit8 v1, v7, 0x1

    iput v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->level:I

    iget-object v8, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->relativePathPrefix:Ljava/lang/String;

    move-object v2, v0

    invoke-direct/range {v2 .. v8}, Lorg/mapsforge/map/rendertheme/renderinstruction/Line;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;ILjava/lang/String;)V

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->isVisible(Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)Z

    move-result v1

    if-eqz v1, :cond_3a6

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

    goto/16 :goto_a3

    :cond_1cd
    const-string v3, "lineSymbol"

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1f8

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_INSTRUCTION:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    new-instance v0, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v4, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget-object v5, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    iget-object v7, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->relativePathPrefix:Ljava/lang/String;

    move-object v2, v0

    invoke-direct/range {v2 .. v7}, Lorg/mapsforge/map/rendertheme/renderinstruction/LineSymbol;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->isVisible(Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)Z

    move-result v1

    if-eqz v1, :cond_3a6

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

    goto/16 :goto_a3

    :cond_1f8
    const-string v3, "name"

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_21c

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_STYLE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentLayer:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

    const-string v1, "lang"

    invoke-direct {p0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getStringAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "value"

    invoke-direct {p0, v2}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getStringAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->addTranslation(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_3a6

    :cond_21c
    const-string v3, "overlay"

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_240

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_STYLE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->renderThemeStyleMenu:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;

    invoke-direct {p0, v7}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getStringAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->getLayer(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

    move-result-object v0

    if-eqz v0, :cond_3a6

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentLayer:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->addOverlay(Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;)V

    goto/16 :goto_3a6

    :cond_240
    const-string v3, "pathText"

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_268

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_INSTRUCTION:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    new-instance v0, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    iget-object v4, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-direct {v0, v1, v2, v3, v4}, Lorg/mapsforge/map/rendertheme/renderinstruction/PathText;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->isVisible(Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)Z

    move-result v1

    if-eqz v1, :cond_3a6

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

    goto/16 :goto_a3

    :cond_268
    const-string v3, "stylemenu"

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_292

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_STYLE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    new-instance v0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;

    invoke-direct {p0, v7}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getStringAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "defaultlang"

    invoke-direct {p0, v2}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getStringAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "defaultvalue"

    invoke-direct {p0, v3}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getStringAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->renderThemeStyleMenu:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;

    goto/16 :goto_3a6

    :cond_292
    const-string v3, "symbol"

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2cb

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_INSTRUCTION:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    new-instance v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v4, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget-object v5, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    iget-object v7, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->relativePathPrefix:Ljava/lang/String;

    move-object v2, v0

    invoke-direct/range {v2 .. v7}, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->isVisible(Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)Z

    move-result v1

    if-eqz v1, :cond_2be

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->currentRule:Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/rendertheme/rule/Rule;->addRenderingInstruction(Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)V

    :cond_2be
    invoke-virtual {v0}, Lorg/mapsforge/map/rendertheme/renderinstruction/Symbol;->getId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3a6

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->symbols:Ljava/util/Map;

    invoke-interface {v2, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_3a6

    :cond_2cb
    const-string v3, "hillshading"

    iget-object v6, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_372

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    sget-object v6, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RULE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-direct {p0, v3, v6}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->checkState(Ljava/lang/String;Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;)V

    const/4 v3, 0x0

    const/16 v6, 0x11

    const/16 v7, 0x40

    const/4 v9, 0x5

    const/4 v6, 0x0

    const/4 v7, 0x5

    const/16 v8, 0x11

    const/16 v9, 0x40

    const/4 v10, 0x5

    const/4 v11, 0x0

    :goto_2ea
    iget-object v12, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v12}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v12

    if-ge v6, v12, :cond_352

    iget-object v12, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v12, v6}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v12

    iget-object v13, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v13, v6}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v4, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_306

    move-object v3, v13

    goto :goto_34f

    :cond_306
    invoke-virtual {v2, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_311

    invoke-static {v2, v13}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeByte(Ljava/lang/String;Ljava/lang/String;)B

    move-result v7

    goto :goto_34f

    :cond_311
    invoke-virtual {v1, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_31c

    invoke-static {v1, v13}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeByte(Ljava/lang/String;Ljava/lang/String;)B

    move-result v8

    goto :goto_34f

    :cond_31c
    invoke-virtual {v0, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_334

    invoke-static {v0, v13}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeInteger(Ljava/lang/String;Ljava/lang/String;)I

    move-result v9

    int-to-short v9, v9

    const/16 v12, 0xff

    if-gt v9, v12, :cond_32c

    goto :goto_34f

    :cond_32c
    new-instance v0, Lorg/xmlpull/v1/XmlPullParserException;

    const-string v1, "Attribute \'magnitude\' must not be > 255"

    invoke-direct {v0, v1}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_334
    const-string v14, "always"

    invoke-virtual {v14, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_345

    invoke-static {v13}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v11

    goto :goto_34f

    :cond_345
    invoke-virtual {v5, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_34f

    invoke-static {v5, v13}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeByte(Ljava/lang/String;Ljava/lang/String;)B

    move-result v10

    :cond_34f
    :goto_34f
    add-int/lit8 v6, v6, 0x1

    goto :goto_2ea

    :cond_352
    iget v12, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->level:I

    add-int/lit8 v0, v12, 0x1

    iput v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->level:I

    new-instance v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;

    iget-object v13, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    move-object v6, v0

    invoke-direct/range {v6 .. v13}, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;-><init>(BBSBZILorg/mapsforge/core/graphics/GraphicFactory;)V

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->categories:Ljava/util/Set;

    if-eqz v1, :cond_36c

    if-eqz v3, :cond_36c

    invoke-interface {v1, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3a6

    :cond_36c
    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->addHillShadings(Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;)V

    goto :goto_3a6

    :cond_372
    new-instance v0, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown element: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->qName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_38b
    .catch Ljava/io/IOException; {:try_start_dc .. :try_end_38b} :catch_38b

    :catch_38b
    move-exception v0

    sget-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->LOGGER:Ljava/util/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Rendertheme missing or invalid resource "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    :cond_3a6
    :goto_3a6
    return-void
.end method


# virtual methods
.method public processRenderTheme()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    :cond_6
    if-nez v0, :cond_9

    goto :goto_16

    :cond_9
    const/4 v1, 0x2

    if-ne v0, v1, :cond_10

    invoke-direct {p0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->startElement()V

    goto :goto_16

    :cond_10
    const/4 v1, 0x3

    if-ne v0, v1, :cond_16

    invoke-direct {p0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->endElement()V

    :cond_16
    :goto_16
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->pullParser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_6

    invoke-direct {p0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->endDocument()V

    return-void
.end method
