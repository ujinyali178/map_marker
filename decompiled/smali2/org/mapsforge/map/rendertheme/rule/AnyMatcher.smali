.class final Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;
.implements Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;
.implements Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;


# static fields
.field static final INSTANCE:Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    invoke-direct {v0}, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;-><init>()V

    sput-object v0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public isCoveredBy(Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;)Z
    .registers 2

    if-ne p1, p0, :cond_4

    const/4 p1, 0x1

    goto :goto_5

    :cond_4
    const/4 p1, 0x0

    :goto_5
    return p1
.end method

.method public isCoveredBy(Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;)Z
    .registers 2

    if-ne p1, p0, :cond_4

    const/4 p1, 0x1

    goto :goto_5

    :cond_4
    const/4 p1, 0x0

    :goto_5
    return p1
.end method

.method public isCoveredBy(Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;)Z
    .registers 2

    if-ne p1, p0, :cond_4

    const/4 p1, 0x1

    goto :goto_5

    :cond_4
    const/4 p1, 0x0

    :goto_5
    return p1
.end method

.method public matches(Ljava/util/List;)Z
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;)Z"
        }
    .end annotation

    const/4 p1, 0x1

    return p1
.end method

.method public matches(Lorg/mapsforge/map/rendertheme/rule/Closed;)Z
    .registers 2

    const/4 p1, 0x1

    return p1
.end method

.method public matches(Lorg/mapsforge/map/rendertheme/rule/Element;)Z
    .registers 2

    const/4 p1, 0x1

    return p1
.end method
