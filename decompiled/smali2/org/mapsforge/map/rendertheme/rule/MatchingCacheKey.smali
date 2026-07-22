.class Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final closed:Lorg/mapsforge/map/rendertheme/rule/Closed;

.field private final tags:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;"
        }
    .end annotation
.end field

.field private final tagsWithoutName:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;"
        }
    .end annotation
.end field

.field private final zoomLevel:B


# direct methods
.method constructor <init>(Ljava/util/List;BLorg/mapsforge/map/rendertheme/rule/Closed;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;B",
            "Lorg/mapsforge/map/rendertheme/rule/Closed;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->tags:Ljava/util/List;

    iput-byte p2, p0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->zoomLevel:B

    iput-object p3, p0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->closed:Lorg/mapsforge/map/rendertheme/rule/Closed;

    new-instance p2, Ljava/util/HashSet;

    invoke-direct {p2}, Ljava/util/HashSet;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->tagsWithoutName:Ljava/util/Set;

    if-eqz p1, :cond_32

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_16
    :goto_16
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lorg/mapsforge/core/model/Tag;

    iget-object p3, p2, Lorg/mapsforge/core/model/Tag;->key:Ljava/lang/String;

    const-string v0, "name"

    invoke-virtual {v0, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p3

    if-nez p3, :cond_16

    iget-object p3, p0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->tagsWithoutName:Ljava/util/Set;

    invoke-interface {p3, p2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_16

    :cond_32
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->closed:Lorg/mapsforge/map/rendertheme/rule/Closed;

    iget-object v3, p1, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->closed:Lorg/mapsforge/map/rendertheme/rule/Closed;

    if-eq v1, v3, :cond_13

    return v2

    :cond_13
    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->tagsWithoutName:Ljava/util/Set;

    if-nez v1, :cond_1c

    iget-object v3, p1, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->tagsWithoutName:Ljava/util/Set;

    if-eqz v3, :cond_1c

    return v2

    :cond_1c
    iget-object v3, p1, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->tagsWithoutName:Ljava/util/Set;

    invoke-interface {v1, v3}, Ljava/util/Set;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_25

    return v2

    :cond_25
    iget-byte v1, p0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->zoomLevel:B

    iget-byte p1, p1, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->zoomLevel:B

    if-eq v1, p1, :cond_2c

    return v2

    :cond_2c
    return v0
.end method

.method public hashCode()I
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->closed:Lorg/mapsforge/map/rendertheme/rule/Closed;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_a

    :cond_6
    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    :goto_a
    const/16 v1, 0x1f

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->tagsWithoutName:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->hashCode()I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-byte v1, p0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;->zoomLevel:B

    add-int/2addr v0, v1

    return v0
.end method
