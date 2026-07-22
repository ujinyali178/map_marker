.class final Lorg/mapsforge/map/rendertheme/rule/LinearWayMatcher;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;


# static fields
.field static final INSTANCE:Lorg/mapsforge/map/rendertheme/rule/LinearWayMatcher;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lorg/mapsforge/map/rendertheme/rule/LinearWayMatcher;

    invoke-direct {v0}, Lorg/mapsforge/map/rendertheme/rule/LinearWayMatcher;-><init>()V

    sput-object v0, Lorg/mapsforge/map/rendertheme/rule/LinearWayMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/LinearWayMatcher;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public isCoveredBy(Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;)Z
    .registers 3

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/Closed;->NO:Lorg/mapsforge/map/rendertheme/rule/Closed;

    invoke-interface {p1, v0}, Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;->matches(Lorg/mapsforge/map/rendertheme/rule/Closed;)Z

    move-result p1

    return p1
.end method

.method public matches(Lorg/mapsforge/map/rendertheme/rule/Closed;)Z
    .registers 3

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/Closed;->NO:Lorg/mapsforge/map/rendertheme/rule/Closed;

    if-ne p1, v0, :cond_6

    const/4 p1, 0x1

    goto :goto_7

    :cond_6
    const/4 p1, 0x0

    :goto_7
    return p1
.end method
