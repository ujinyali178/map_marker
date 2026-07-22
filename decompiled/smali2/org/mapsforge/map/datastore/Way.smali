.class public Lorg/mapsforge/map/datastore/Way;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final labelPosition:Lorg/mapsforge/core/model/LatLong;

.field public final latLongs:[[Lorg/mapsforge/core/model/LatLong;

.field public final layer:B

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
.method public constructor <init>(BLjava/util/List;[[Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/LatLong;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(B",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;[[",
            "Lorg/mapsforge/core/model/LatLong;",
            "Lorg/mapsforge/core/model/LatLong;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-byte p1, p0, Lorg/mapsforge/map/datastore/Way;->layer:B

    iput-object p2, p0, Lorg/mapsforge/map/datastore/Way;->tags:Ljava/util/List;

    iput-object p3, p0, Lorg/mapsforge/map/datastore/Way;->latLongs:[[Lorg/mapsforge/core/model/LatLong;

    iput-object p4, p0, Lorg/mapsforge/map/datastore/Way;->labelPosition:Lorg/mapsforge/core/model/LatLong;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 8

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/map/datastore/Way;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/map/datastore/Way;

    iget-byte v1, p0, Lorg/mapsforge/map/datastore/Way;->layer:B

    iget-byte v3, p1, Lorg/mapsforge/map/datastore/Way;->layer:B

    if-eq v1, v3, :cond_13

    return v2

    :cond_13
    iget-object v1, p0, Lorg/mapsforge/map/datastore/Way;->tags:Ljava/util/List;

    iget-object v3, p1, Lorg/mapsforge/map/datastore/Way;->tags:Ljava/util/List;

    invoke-interface {v1, v3}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1e

    return v2

    :cond_1e
    iget-object v1, p0, Lorg/mapsforge/map/datastore/Way;->labelPosition:Lorg/mapsforge/core/model/LatLong;

    if-nez v1, :cond_27

    iget-object v3, p1, Lorg/mapsforge/map/datastore/Way;->labelPosition:Lorg/mapsforge/core/model/LatLong;

    if-eqz v3, :cond_27

    return v2

    :cond_27
    if-eqz v1, :cond_32

    iget-object v3, p1, Lorg/mapsforge/map/datastore/Way;->labelPosition:Lorg/mapsforge/core/model/LatLong;

    invoke-virtual {v1, v3}, Lorg/mapsforge/core/model/LatLong;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_32

    return v2

    :cond_32
    iget-object v1, p0, Lorg/mapsforge/map/datastore/Way;->latLongs:[[Lorg/mapsforge/core/model/LatLong;

    array-length v1, v1

    iget-object v3, p1, Lorg/mapsforge/map/datastore/Way;->latLongs:[[Lorg/mapsforge/core/model/LatLong;

    array-length v3, v3

    if-eq v1, v3, :cond_3b

    return v2

    :cond_3b
    const/4 v1, 0x0

    :goto_3c
    iget-object v3, p0, Lorg/mapsforge/map/datastore/Way;->latLongs:[[Lorg/mapsforge/core/model/LatLong;

    array-length v4, v3

    if-ge v1, v4, :cond_69

    aget-object v3, v3, v1

    array-length v3, v3

    iget-object v4, p1, Lorg/mapsforge/map/datastore/Way;->latLongs:[[Lorg/mapsforge/core/model/LatLong;

    aget-object v4, v4, v1

    array-length v4, v4

    if-eq v3, v4, :cond_4c

    return v2

    :cond_4c
    const/4 v3, 0x0

    :goto_4d
    iget-object v4, p0, Lorg/mapsforge/map/datastore/Way;->latLongs:[[Lorg/mapsforge/core/model/LatLong;

    aget-object v4, v4, v1

    array-length v5, v4

    if-ge v3, v5, :cond_66

    aget-object v4, v4, v3

    iget-object v5, p1, Lorg/mapsforge/map/datastore/Way;->latLongs:[[Lorg/mapsforge/core/model/LatLong;

    aget-object v5, v5, v1

    aget-object v5, v5, v3

    invoke-virtual {v4, v5}, Lorg/mapsforge/core/model/LatLong;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_63

    return v2

    :cond_63
    add-int/lit8 v3, v3, 0x1

    goto :goto_4d

    :cond_66
    add-int/lit8 v1, v1, 0x1

    goto :goto_3c

    :cond_69
    return v0
.end method

.method public hashCode()I
    .registers 4

    iget-byte v0, p0, Lorg/mapsforge/map/datastore/Way;->layer:B

    const/16 v1, 0x1f

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lorg/mapsforge/map/datastore/Way;->tags:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lorg/mapsforge/map/datastore/Way;->latLongs:[[Lorg/mapsforge/core/model/LatLong;

    invoke-static {v1}, Ljava/util/Arrays;->deepHashCode([Ljava/lang/Object;)I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Lorg/mapsforge/map/datastore/Way;->labelPosition:Lorg/mapsforge/core/model/LatLong;

    if-eqz v1, :cond_22

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {v1}, Lorg/mapsforge/core/model/LatLong;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    :cond_22
    return v0
.end method
