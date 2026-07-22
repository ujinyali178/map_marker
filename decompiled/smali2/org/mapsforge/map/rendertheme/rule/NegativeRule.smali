.class Lorg/mapsforge/map/rendertheme/rule/NegativeRule;
.super Lorg/mapsforge/map/rendertheme/rule/Rule;
.source "SourceFile"


# instance fields
.field private final attributeMatcher:Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;


# direct methods
.method constructor <init>(Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;)V
    .registers 3

    invoke-direct {p0, p1}, Lorg/mapsforge/map/rendertheme/rule/Rule;-><init>(Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;)V

    iput-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/NegativeRule;->attributeMatcher:Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    return-void
.end method


# virtual methods
.method matchesNode(Ljava/util/List;B)Z
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;B)Z"
        }
    .end annotation

    iget-byte v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->zoomMin:B

    if-gt v0, p2, :cond_1c

    iget-byte v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->zoomMax:B

    if-lt v0, p2, :cond_1c

    iget-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->elementMatcher:Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/Element;->NODE:Lorg/mapsforge/map/rendertheme/rule/Element;

    invoke-interface {p2, v0}, Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;->matches(Lorg/mapsforge/map/rendertheme/rule/Element;)Z

    move-result p2

    if-eqz p2, :cond_1c

    iget-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/NegativeRule;->attributeMatcher:Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    invoke-interface {p2, p1}, Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;->matches(Ljava/util/List;)Z

    move-result p1

    if-eqz p1, :cond_1c

    const/4 p1, 0x1

    goto :goto_1d

    :cond_1c
    const/4 p1, 0x0

    :goto_1d
    return p1
.end method

.method matchesWay(Ljava/util/List;BLorg/mapsforge/map/rendertheme/rule/Closed;)Z
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;B",
            "Lorg/mapsforge/map/rendertheme/rule/Closed;",
            ")Z"
        }
    .end annotation

    iget-byte v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->zoomMin:B

    if-gt v0, p2, :cond_24

    iget-byte v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->zoomMax:B

    if-lt v0, p2, :cond_24

    iget-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->elementMatcher:Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/Element;->WAY:Lorg/mapsforge/map/rendertheme/rule/Element;

    invoke-interface {p2, v0}, Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;->matches(Lorg/mapsforge/map/rendertheme/rule/Element;)Z

    move-result p2

    if-eqz p2, :cond_24

    iget-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->closedMatcher:Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;

    invoke-interface {p2, p3}, Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;->matches(Lorg/mapsforge/map/rendertheme/rule/Closed;)Z

    move-result p2

    if-eqz p2, :cond_24

    iget-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/NegativeRule;->attributeMatcher:Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    invoke-interface {p2, p1}, Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;->matches(Ljava/util/List;)Z

    move-result p1

    if-eqz p1, :cond_24

    const/4 p1, 0x1

    goto :goto_25

    :cond_24
    const/4 p1, 0x0

    :goto_25
    return p1
.end method
