.class public Lorg/mapsforge/map/datastore/MultiMapDataStore;
.super Lorg/mapsforge/map/datastore/MapDataStore;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;
    }
.end annotation


# instance fields
.field private boundingBox:Lorg/mapsforge/core/model/BoundingBox;

.field private final dataPolicy:Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

.field private final mapDatabases:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/map/datastore/MapDataStore;",
            ">;"
        }
    .end annotation
.end field

.field private startPosition:Lorg/mapsforge/core/model/LatLong;

.field private startZoomLevel:B


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;)V
    .registers 2

    invoke-direct {p0}, Lorg/mapsforge/map/datastore/MapDataStore;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->dataPolicy:Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    return-void
.end method

.method private readLabels(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 9

    new-instance v0, Lorg/mapsforge/map/datastore/MapReadResult;

    invoke-direct {v0}, Lorg/mapsforge/map/datastore/MapReadResult;-><init>()V

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_b
    :goto_b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2f

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v2, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v3

    if-eqz v3, :cond_b

    invoke-virtual {v2, p1, p2}, Lorg/mapsforge/map/datastore/MapDataStore;->readLabels(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object v2

    if-nez v2, :cond_24

    goto :goto_b

    :cond_24
    iget-boolean v3, v0, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    iget-boolean v4, v2, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    and-int/2addr v3, v4

    iput-boolean v3, v0, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    invoke-virtual {v0, v2, p3}, Lorg/mapsforge/map/datastore/MapReadResult;->add(Lorg/mapsforge/map/datastore/MapReadResult;Z)V

    goto :goto_b

    :cond_2f
    return-object v0
.end method

.method private readLabels(Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 8

    new-instance v0, Lorg/mapsforge/map/datastore/MapReadResult;

    invoke-direct {v0}, Lorg/mapsforge/map/datastore/MapReadResult;-><init>()V

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_b
    :goto_b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2f

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v2, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v3

    if-eqz v3, :cond_b

    invoke-virtual {v2, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->readLabels(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object v2

    if-nez v2, :cond_24

    goto :goto_b

    :cond_24
    iget-boolean v3, v0, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    iget-boolean v4, v2, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    and-int/2addr v3, v4

    iput-boolean v3, v0, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    invoke-virtual {v0, v2, p2}, Lorg/mapsforge/map/datastore/MapReadResult;->add(Lorg/mapsforge/map/datastore/MapReadResult;Z)V

    goto :goto_b

    :cond_2f
    return-object v0
.end method

.method private readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 9

    new-instance v0, Lorg/mapsforge/map/datastore/MapReadResult;

    invoke-direct {v0}, Lorg/mapsforge/map/datastore/MapReadResult;-><init>()V

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_b
    :goto_b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2f

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v2, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v3

    if-eqz v3, :cond_b

    invoke-virtual {v2, p1, p2}, Lorg/mapsforge/map/datastore/MapDataStore;->readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object v2

    if-nez v2, :cond_24

    goto :goto_b

    :cond_24
    iget-boolean v3, v0, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    iget-boolean v4, v2, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    and-int/2addr v3, v4

    iput-boolean v3, v0, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    invoke-virtual {v0, v2, p3}, Lorg/mapsforge/map/datastore/MapReadResult;->add(Lorg/mapsforge/map/datastore/MapReadResult;Z)V

    goto :goto_b

    :cond_2f
    return-object v0
.end method

.method private readMapData(Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 8

    new-instance v0, Lorg/mapsforge/map/datastore/MapReadResult;

    invoke-direct {v0}, Lorg/mapsforge/map/datastore/MapReadResult;-><init>()V

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_b
    :goto_b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2f

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v2, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v3

    if-eqz v3, :cond_b

    invoke-virtual {v2, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->readMapData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object v2

    if-nez v2, :cond_24

    goto :goto_b

    :cond_24
    iget-boolean v3, v0, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    iget-boolean v4, v2, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    and-int/2addr v3, v4

    iput-boolean v3, v0, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    invoke-virtual {v0, v2, p2}, Lorg/mapsforge/map/datastore/MapReadResult;->add(Lorg/mapsforge/map/datastore/MapReadResult;Z)V

    goto :goto_b

    :cond_2f
    return-object v0
.end method

.method private readPoiData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 9

    new-instance v0, Lorg/mapsforge/map/datastore/MapReadResult;

    invoke-direct {v0}, Lorg/mapsforge/map/datastore/MapReadResult;-><init>()V

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_b
    :goto_b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2f

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v2, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v3

    if-eqz v3, :cond_b

    invoke-virtual {v2, p1, p2}, Lorg/mapsforge/map/datastore/MapDataStore;->readPoiData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object v2

    if-nez v2, :cond_24

    goto :goto_b

    :cond_24
    iget-boolean v3, v0, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    iget-boolean v4, v2, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    and-int/2addr v3, v4

    iput-boolean v3, v0, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    invoke-virtual {v0, v2, p3}, Lorg/mapsforge/map/datastore/MapReadResult;->add(Lorg/mapsforge/map/datastore/MapReadResult;Z)V

    goto :goto_b

    :cond_2f
    return-object v0
.end method

.method private readPoiData(Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 8

    new-instance v0, Lorg/mapsforge/map/datastore/MapReadResult;

    invoke-direct {v0}, Lorg/mapsforge/map/datastore/MapReadResult;-><init>()V

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_b
    :goto_b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2f

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v2, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v3

    if-eqz v3, :cond_b

    invoke-virtual {v2, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->readPoiData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object v2

    if-nez v2, :cond_24

    goto :goto_b

    :cond_24
    iget-boolean v3, v0, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    iget-boolean v4, v2, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    and-int/2addr v3, v4

    iput-boolean v3, v0, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    invoke-virtual {v0, v2, p2}, Lorg/mapsforge/map/datastore/MapReadResult;->add(Lorg/mapsforge/map/datastore/MapReadResult;Z)V

    goto :goto_b

    :cond_2f
    return-object v0
.end method


# virtual methods
.method public addMapDataStore(Lorg/mapsforge/map/datastore/MapDataStore;ZZ)V
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_31

    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    if-eqz p2, :cond_19

    invoke-virtual {p1}, Lorg/mapsforge/map/datastore/MapDataStore;->startZoomLevel()Ljava/lang/Byte;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/Byte;->byteValue()B

    move-result p2

    iput-byte p2, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->startZoomLevel:B

    :cond_19
    if-eqz p3, :cond_21

    invoke-virtual {p1}, Lorg/mapsforge/map/datastore/MapDataStore;->startPosition()Lorg/mapsforge/core/model/LatLong;

    move-result-object p2

    iput-object p2, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->startPosition:Lorg/mapsforge/core/model/LatLong;

    :cond_21
    iget-object p2, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    invoke-virtual {p1}, Lorg/mapsforge/map/datastore/MapDataStore;->boundingBox()Lorg/mapsforge/core/model/BoundingBox;

    move-result-object p1

    if-nez p2, :cond_2a

    goto :goto_2e

    :cond_2a
    invoke-virtual {p2, p1}, Lorg/mapsforge/core/model/BoundingBox;->extendBoundingBox(Lorg/mapsforge/core/model/BoundingBox;)Lorg/mapsforge/core/model/BoundingBox;

    move-result-object p1

    :goto_2e
    iput-object p1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    return-void

    :cond_31
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "Duplicate map database"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public boundingBox()Lorg/mapsforge/core/model/BoundingBox;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    return-object v0
.end method

.method public close()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1}, Lorg/mapsforge/map/datastore/MapDataStore;->close()V

    goto :goto_6

    :cond_16
    return-void
.end method

.method public getDataTimestamp(Lorg/mapsforge/core/model/Tile;)J
    .registers 8

    sget-object v0, Lorg/mapsforge/map/datastore/MultiMapDataStore$1;->$SwitchMap$org$mapsforge$map$datastore$MultiMapDataStore$DataPolicy:[I

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->dataPolicy:Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    const-wide/16 v2, 0x0

    if-eq v0, v1, :cond_41

    const/4 v1, 0x2

    if-eq v0, v1, :cond_1e

    const/4 v1, 0x3

    if-ne v0, v1, :cond_16

    goto :goto_1e

    :cond_16
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "Invalid data policy for multi map database"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_1e
    :goto_1e
    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_24
    :goto_24
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_40

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v4

    if-eqz v4, :cond_24

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->getDataTimestamp(Lorg/mapsforge/core/model/Tile;)J

    move-result-wide v4

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v1

    move-wide v2, v1

    goto :goto_24

    :cond_40
    return-wide v2

    :cond_41
    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_47
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_5e

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v4

    if-eqz v4, :cond_47

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->getDataTimestamp(Lorg/mapsforge/core/model/Tile;)J

    move-result-wide v0

    return-wide v0

    :cond_5e
    return-wide v2
.end method

.method public readLabels(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 5

    sget-object v0, Lorg/mapsforge/map/datastore/MultiMapDataStore$1;->$SwitchMap$org$mapsforge$map$datastore$MultiMapDataStore$DataPolicy:[I

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->dataPolicy:Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_26

    const/4 v2, 0x2

    if-eq v0, v2, :cond_20

    const/4 v2, 0x3

    if-ne v0, v2, :cond_18

    invoke-direct {p0, p1, v1}, Lorg/mapsforge/map/datastore/MultiMapDataStore;->readLabels(Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_18
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "Invalid data policy for multi map database"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_20
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lorg/mapsforge/map/datastore/MultiMapDataStore;->readLabels(Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_26
    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_43

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v2

    if-eqz v2, :cond_2c

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->readLabels(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_43
    const/4 p1, 0x0

    return-object p1
.end method

.method public readLabels(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 6

    sget-object v0, Lorg/mapsforge/map/datastore/MultiMapDataStore$1;->$SwitchMap$org$mapsforge$map$datastore$MultiMapDataStore$DataPolicy:[I

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->dataPolicy:Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_26

    const/4 v2, 0x2

    if-eq v0, v2, :cond_20

    const/4 v2, 0x3

    if-ne v0, v2, :cond_18

    invoke-direct {p0, p1, p2, v1}, Lorg/mapsforge/map/datastore/MultiMapDataStore;->readLabels(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_18
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "Invalid data policy for multi map database"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_20
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lorg/mapsforge/map/datastore/MultiMapDataStore;->readLabels(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_26
    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_43

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v2

    if-eqz v2, :cond_2c

    invoke-virtual {v1, p1, p2}, Lorg/mapsforge/map/datastore/MapDataStore;->readLabels(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_43
    const/4 p1, 0x0

    return-object p1
.end method

.method public readMapData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 5

    sget-object v0, Lorg/mapsforge/map/datastore/MultiMapDataStore$1;->$SwitchMap$org$mapsforge$map$datastore$MultiMapDataStore$DataPolicy:[I

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->dataPolicy:Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_26

    const/4 v2, 0x2

    if-eq v0, v2, :cond_20

    const/4 v2, 0x3

    if-ne v0, v2, :cond_18

    invoke-direct {p0, p1, v1}, Lorg/mapsforge/map/datastore/MultiMapDataStore;->readMapData(Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_18
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "Invalid data policy for multi map database"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_20
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lorg/mapsforge/map/datastore/MultiMapDataStore;->readMapData(Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_26
    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_43

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v2

    if-eqz v2, :cond_2c

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->readMapData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_43
    const/4 p1, 0x0

    return-object p1
.end method

.method public readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 6

    sget-object v0, Lorg/mapsforge/map/datastore/MultiMapDataStore$1;->$SwitchMap$org$mapsforge$map$datastore$MultiMapDataStore$DataPolicy:[I

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->dataPolicy:Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_26

    const/4 v2, 0x2

    if-eq v0, v2, :cond_20

    const/4 v2, 0x3

    if-ne v0, v2, :cond_18

    invoke-direct {p0, p1, p2, v1}, Lorg/mapsforge/map/datastore/MultiMapDataStore;->readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_18
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "Invalid data policy for multi map database"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_20
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lorg/mapsforge/map/datastore/MultiMapDataStore;->readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_26
    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_43

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v2

    if-eqz v2, :cond_2c

    invoke-virtual {v1, p1, p2}, Lorg/mapsforge/map/datastore/MapDataStore;->readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_43
    const/4 p1, 0x0

    return-object p1
.end method

.method public readPoiData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 5

    sget-object v0, Lorg/mapsforge/map/datastore/MultiMapDataStore$1;->$SwitchMap$org$mapsforge$map$datastore$MultiMapDataStore$DataPolicy:[I

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->dataPolicy:Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_26

    const/4 v2, 0x2

    if-eq v0, v2, :cond_20

    const/4 v2, 0x3

    if-ne v0, v2, :cond_18

    invoke-direct {p0, p1, v1}, Lorg/mapsforge/map/datastore/MultiMapDataStore;->readPoiData(Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_18
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "Invalid data policy for multi map database"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_20
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lorg/mapsforge/map/datastore/MultiMapDataStore;->readPoiData(Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_26
    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_43

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v2

    if-eqz v2, :cond_2c

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->readPoiData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_43
    const/4 p1, 0x0

    return-object p1
.end method

.method public readPoiData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 6

    sget-object v0, Lorg/mapsforge/map/datastore/MultiMapDataStore$1;->$SwitchMap$org$mapsforge$map$datastore$MultiMapDataStore$DataPolicy:[I

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->dataPolicy:Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_26

    const/4 v2, 0x2

    if-eq v0, v2, :cond_20

    const/4 v2, 0x3

    if-ne v0, v2, :cond_18

    invoke-direct {p0, p1, p2, v1}, Lorg/mapsforge/map/datastore/MultiMapDataStore;->readPoiData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_18
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "Invalid data policy for multi map database"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_20
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lorg/mapsforge/map/datastore/MultiMapDataStore;->readPoiData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Z)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_26
    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_43

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v2

    if-eqz v2, :cond_2c

    invoke-virtual {v1, p1, p2}, Lorg/mapsforge/map/datastore/MapDataStore;->readPoiData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1

    :cond_43
    const/4 p1, 0x0

    return-object p1
.end method

.method public setStartPosition(Lorg/mapsforge/core/model/LatLong;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->startPosition:Lorg/mapsforge/core/model/LatLong;

    return-void
.end method

.method public setStartZoomLevel(B)V
    .registers 2

    iput-byte p1, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->startZoomLevel:B

    return-void
.end method

.method public startPosition()Lorg/mapsforge/core/model/LatLong;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->startPosition:Lorg/mapsforge/core/model/LatLong;

    if-eqz v0, :cond_5

    return-object v0

    :cond_5
    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    if-eqz v0, :cond_e

    invoke-virtual {v0}, Lorg/mapsforge/core/model/BoundingBox;->getCenterPoint()Lorg/mapsforge/core/model/LatLong;

    move-result-object v0

    return-object v0

    :cond_e
    const/4 v0, 0x0

    return-object v0
.end method

.method public startZoomLevel()Ljava/lang/Byte;
    .registers 2

    iget-byte v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->startZoomLevel:B

    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    return-object v0
.end method

.method public supportsTile(Lorg/mapsforge/core/model/Tile;)Z
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/datastore/MultiMapDataStore;->mapDatabases:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result v1

    if-eqz v1, :cond_6

    const/4 p1, 0x1

    return p1

    :cond_1a
    const/4 p1, 0x0

    return p1
.end method
