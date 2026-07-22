.class public Lorg/mapsforge/map/datastore/PointOfInterest;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final layer:B

.field public final position:Lorg/mapsforge/core/model/LatLong;

.field public final tags:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(BLjava/util/List;Lorg/mapsforge/core/model/LatLong;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(B",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;",
            "Lorg/mapsforge/core/model/LatLong;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-byte p1, p0, Lorg/mapsforge/map/datastore/PointOfInterest;->layer:B

    iput-object p2, p0, Lorg/mapsforge/map/datastore/PointOfInterest;->tags:Ljava/util/List;

    iput-object p3, p0, Lorg/mapsforge/map/datastore/PointOfInterest;->position:Lorg/mapsforge/core/model/LatLong;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/map/datastore/PointOfInterest;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/map/datastore/PointOfInterest;

    iget-byte v1, p0, Lorg/mapsforge/map/datastore/PointOfInterest;->layer:B

    iget-byte v3, p1, Lorg/mapsforge/map/datastore/PointOfInterest;->layer:B

    if-eq v1, v3, :cond_13

    return v2

    :cond_13
    iget-object v1, p0, Lorg/mapsforge/map/datastore/PointOfInterest;->tags:Ljava/util/List;

    iget-object v3, p1, Lorg/mapsforge/map/datastore/PointOfInterest;->tags:Ljava/util/List;

    invoke-interface {v1, v3}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1e

    return v2

    :cond_1e
    iget-object v1, p0, Lorg/mapsforge/map/datastore/PointOfInterest;->position:Lorg/mapsforge/core/model/LatLong;

    iget-object p1, p1, Lorg/mapsforge/map/datastore/PointOfInterest;->position:Lorg/mapsforge/core/model/LatLong;

    invoke-virtual {v1, p1}, Lorg/mapsforge/core/model/LatLong;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_29

    return v2

    :cond_29
    return v0
.end method

.method public hashCode()I
    .registers 4

    iget-byte v0, p0, Lorg/mapsforge/map/datastore/PointOfInterest;->layer:B

    const/16 v1, 0x1f

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lorg/mapsforge/map/datastore/PointOfInterest;->tags:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lorg/mapsforge/map/datastore/PointOfInterest;->position:Lorg/mapsforge/core/model/LatLong;

    invoke-virtual {v1}, Lorg/mapsforge/core/model/LatLong;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method
