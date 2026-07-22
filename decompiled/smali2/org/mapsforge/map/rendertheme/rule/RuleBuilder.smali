.class public Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final CAT:Ljava/lang/String; = "cat"

.field private static final CLOSED:Ljava/lang/String; = "closed"

.field private static final E:Ljava/lang/String; = "e"

.field private static final K:Ljava/lang/String; = "k"

.field private static final SPLIT_PATTERN:Ljava/util/regex/Pattern;

.field private static final STRING_NEGATION:Ljava/lang/String; = "~"

.field private static final STRING_WILDCARD:Ljava/lang/String; = "*"

.field private static final V:Ljava/lang/String; = "v"

.field private static final ZOOM_MAX:Ljava/lang/String; = "zoom-max"

.field private static final ZOOM_MIN:Ljava/lang/String; = "zoom-min"


# instance fields
.field cat:Ljava/lang/String;

.field private closed:Lorg/mapsforge/map/rendertheme/rule/Closed;

.field closedMatcher:Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;

.field private element:Lorg/mapsforge/map/rendertheme/rule/Element;

.field elementMatcher:Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

.field private keyList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private keys:Ljava/lang/String;

.field private final ruleStack:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack<",
            "Lorg/mapsforge/map/rendertheme/rule/Rule;",
            ">;"
        }
    .end annotation
.end field

.field private valueList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private values:Ljava/lang/String;

.field zoomMax:B

.field zoomMin:B


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-string v0, "\\|"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->SPLIT_PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Stack;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lorg/xmlpull/v1/XmlPullParser;",
            "Ljava/util/Stack<",
            "Lorg/mapsforge/map/rendertheme/rule/Rule;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p3, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->ruleStack:Ljava/util/Stack;

    sget-object p3, Lorg/mapsforge/map/rendertheme/rule/Closed;->ANY:Lorg/mapsforge/map/rendertheme/rule/Closed;

    iput-object p3, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->closed:Lorg/mapsforge/map/rendertheme/rule/Closed;

    const/4 p3, 0x0

    iput-byte p3, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->zoomMin:B

    const/16 p3, 0x7f

    iput-byte p3, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->zoomMax:B

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->extractValues(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V

    return-void
.end method

.method private extractValues(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v1

    if-ge v0, v1, :cond_73

    invoke-interface {p2, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p2, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "e"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1e

    invoke-static {v2}, Lorg/mapsforge/map/rendertheme/rule/Element;->fromString(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/rule/Element;

    move-result-object v1

    iput-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->element:Lorg/mapsforge/map/rendertheme/rule/Element;

    goto :goto_6b

    :cond_1e
    const-string v3, "k"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_29

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->keys:Ljava/lang/String;

    goto :goto_6b

    :cond_29
    const-string v3, "v"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_34

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->values:Ljava/lang/String;

    goto :goto_6b

    :cond_34
    const-string v3, "cat"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3f

    iput-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->cat:Ljava/lang/String;

    goto :goto_6b

    :cond_3f
    const-string v3, "closed"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4e

    invoke-static {v2}, Lorg/mapsforge/map/rendertheme/rule/Closed;->fromString(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/rule/Closed;

    move-result-object v1

    iput-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->closed:Lorg/mapsforge/map/rendertheme/rule/Closed;

    goto :goto_6b

    :cond_4e
    const-string v3, "zoom-min"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5d

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeByte(Ljava/lang/String;Ljava/lang/String;)B

    move-result v1

    iput-byte v1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->zoomMin:B

    goto :goto_6b

    :cond_5d
    const-string v3, "zoom-max"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6e

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/XmlUtils;->parseNonNegativeByte(Ljava/lang/String;Ljava/lang/String;)B

    move-result v1

    iput-byte v1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->zoomMax:B

    :goto_6b
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_6e
    invoke-static {p1, v1, v2, v0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->createXmlPullParserException(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lorg/xmlpull/v1/XmlPullParserException;

    move-result-object p1

    throw p1

    :cond_73
    invoke-direct {p0, p1}, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->validate(Ljava/lang/String;)V

    new-instance p1, Ljava/util/ArrayList;

    sget-object p2, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->SPLIT_PATTERN:Ljava/util/regex/Pattern;

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->keys:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/util/regex/Pattern;->split(Ljava/lang/CharSequence;)[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p1, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->keyList:Ljava/util/List;

    new-instance p1, Ljava/util/ArrayList;

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->values:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/util/regex/Pattern;->split(Ljava/lang/CharSequence;)[Ljava/lang/String;

    move-result-object p2

    invoke-static {p2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->valueList:Ljava/util/List;

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->element:Lorg/mapsforge/map/rendertheme/rule/Element;

    invoke-static {p1}, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->getElementMatcher(Lorg/mapsforge/map/rendertheme/rule/Element;)Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->elementMatcher:Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->closed:Lorg/mapsforge/map/rendertheme/rule/Closed;

    invoke-static {p1}, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->getClosedMatcher(Lorg/mapsforge/map/rendertheme/rule/Closed;)Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->closedMatcher:Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->elementMatcher:Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

    iget-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->ruleStack:Ljava/util/Stack;

    invoke-static {p1, p2}, Lorg/mapsforge/map/rendertheme/rule/RuleOptimizer;->optimize(Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;Ljava/util/Stack;)Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->elementMatcher:Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->closedMatcher:Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;

    iget-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->ruleStack:Ljava/util/Stack;

    invoke-static {p1, p2}, Lorg/mapsforge/map/rendertheme/rule/RuleOptimizer;->optimize(Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;Ljava/util/Stack;)Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->closedMatcher:Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;

    return-void
.end method

.method private static getClosedMatcher(Lorg/mapsforge/map/rendertheme/rule/Closed;)Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;
    .registers 4

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder$1;->$SwitchMap$org$mapsforge$map$rendertheme$rule$Closed:[I

    invoke-virtual {p0}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_2e

    const/4 v1, 0x2

    if-eq v0, v1, :cond_2b

    const/4 v1, 0x3

    if-ne v0, v1, :cond_14

    sget-object p0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    return-object p0

    :cond_14
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown closed value: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2b
    sget-object p0, Lorg/mapsforge/map/rendertheme/rule/LinearWayMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/LinearWayMatcher;

    return-object p0

    :cond_2e
    sget-object p0, Lorg/mapsforge/map/rendertheme/rule/ClosedWayMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/ClosedWayMatcher;

    return-object p0
.end method

.method private static getElementMatcher(Lorg/mapsforge/map/rendertheme/rule/Element;)Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;
    .registers 4

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder$1;->$SwitchMap$org$mapsforge$map$rendertheme$rule$Element:[I

    invoke-virtual {p0}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_2e

    const/4 v1, 0x2

    if-eq v0, v1, :cond_2b

    const/4 v1, 0x3

    if-ne v0, v1, :cond_14

    sget-object p0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    return-object p0

    :cond_14
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown element value: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2b
    sget-object p0, Lorg/mapsforge/map/rendertheme/rule/ElementWayMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/ElementWayMatcher;

    return-object p0

    :cond_2e
    sget-object p0, Lorg/mapsforge/map/rendertheme/rule/ElementNodeMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/ElementNodeMatcher;

    return-object p0
.end method

.method private static getKeyMatcher(Ljava/util/List;)Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)",
            "Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    const-string v1, "*"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    sget-object p0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    return-object p0

    :cond_10
    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/Rule;->MATCHERS_CACHE_KEY:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    if-nez v1, :cond_22

    new-instance v1, Lorg/mapsforge/map/rendertheme/rule/KeyMatcher;

    invoke-direct {v1, p0}, Lorg/mapsforge/map/rendertheme/rule/KeyMatcher;-><init>(Ljava/util/List;)V

    invoke-interface {v0, p0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_22
    return-object v1
.end method

.method private static getValueMatcher(Ljava/util/List;)Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)",
            "Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    const-string v1, "*"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    sget-object p0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    return-object p0

    :cond_10
    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/Rule;->MATCHERS_CACHE_VALUE:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    if-nez v1, :cond_22

    new-instance v1, Lorg/mapsforge/map/rendertheme/rule/ValueMatcher;

    invoke-direct {v1, p0}, Lorg/mapsforge/map/rendertheme/rule/ValueMatcher;-><init>(Ljava/util/List;)V

    invoke-interface {v0, p0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_22
    return-object v1
.end method

.method private validate(Ljava/lang/String;)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->element:Lorg/mapsforge/map/rendertheme/rule/Element;

    const-string v1, "e"

    invoke-static {p1, v1, v0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->checkMandatoryAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->keys:Ljava/lang/String;

    const-string v1, "k"

    invoke-static {p1, v1, v0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->checkMandatoryAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->values:Ljava/lang/String;

    const-string v1, "v"

    invoke-static {p1, v1, v0}, Lorg/mapsforge/map/rendertheme/XmlUtils;->checkMandatoryAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    iget-byte p1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->zoomMin:B

    iget-byte v0, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->zoomMax:B

    if-gt p1, v0, :cond_1c

    return-void

    :cond_1c
    new-instance p1, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "\'zoom-min\' > \'zoom-max\': "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-byte v1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->zoomMin:B

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget-byte v1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->zoomMax:B

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw p1
.end method


# virtual methods
.method public build()Lorg/mapsforge/map/rendertheme/rule/Rule;
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->valueList:Ljava/util/List;

    const-string v1, "~"

    invoke-interface {v0, v1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    new-instance v0, Lorg/mapsforge/map/rendertheme/rule/NegativeMatcher;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->keyList:Ljava/util/List;

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->valueList:Ljava/util/List;

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/map/rendertheme/rule/NegativeMatcher;-><init>(Ljava/util/List;Ljava/util/List;)V

    new-instance v1, Lorg/mapsforge/map/rendertheme/rule/NegativeRule;

    invoke-direct {v1, p0, v0}, Lorg/mapsforge/map/rendertheme/rule/NegativeRule;-><init>(Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;)V

    return-object v1

    :cond_19
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->keyList:Ljava/util/List;

    invoke-static {v0}, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->getKeyMatcher(Ljava/util/List;)Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    move-result-object v0

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->valueList:Ljava/util/List;

    invoke-static {v1}, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->getValueMatcher(Ljava/util/List;)Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    move-result-object v1

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->ruleStack:Ljava/util/Stack;

    invoke-static {v0, v2}, Lorg/mapsforge/map/rendertheme/rule/RuleOptimizer;->optimize(Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;Ljava/util/Stack;)Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    move-result-object v0

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->ruleStack:Ljava/util/Stack;

    invoke-static {v1, v2}, Lorg/mapsforge/map/rendertheme/rule/RuleOptimizer;->optimize(Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;Ljava/util/Stack;)Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    move-result-object v1

    new-instance v2, Lorg/mapsforge/map/rendertheme/rule/PositiveRule;

    invoke-direct {v2, p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/PositiveRule;-><init>(Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;)V

    return-object v2
.end method
