.class public abstract Lorg/mapsforge/map/datastore/MapDataStore;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field protected preferredLanguage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 2

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/mapsforge/map/datastore/MapDataStore;-><init>(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/datastore/MapDataStore;->preferredLanguage:Ljava/lang/String;

    return-void
.end method

.method public static extract(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 10

    const/4 v0, 0x0

    if-eqz p0, :cond_7a

    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_f

    goto/16 :goto_7a

    :cond_f
    const-string v1, "\r"

    invoke-virtual {p0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object p0

    const/4 v1, 0x0

    if-eqz p1, :cond_77

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_23

    goto :goto_77

    :cond_23
    const/4 v2, 0x1

    const/4 v3, 0x1

    :goto_25
    array-length v4, p0

    if-ge v3, v4, :cond_71

    aget-object v4, p0, v3

    const-string v5, "\u0008"

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    array-length v5, v4

    const/4 v6, 0x2

    if-eq v5, v6, :cond_35

    goto :goto_6e

    :cond_35
    aget-object v5, v4, v1

    invoke-virtual {v5, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_40

    aget-object p0, v4, v2

    return-object p0

    :cond_40
    if-nez v0, :cond_6e

    aget-object v5, v4, v1

    const-string v6, "-"

    invoke-virtual {v5, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_6e

    invoke-virtual {p1, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_5a

    const-string v5, "_"

    invoke-virtual {p1, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_6e

    :cond_5a
    sget-object v5, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {p1, v5}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v6

    aget-object v7, v4, v1

    invoke-virtual {v7, v5}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_6e

    aget-object v0, v4, v2

    :cond_6e
    :goto_6e
    add-int/lit8 v3, v3, 0x1

    goto :goto_25

    :cond_71
    if-eqz v0, :cond_74

    goto :goto_76

    :cond_74
    aget-object v0, p0, v1

    :goto_76
    return-object v0

    :cond_77
    :goto_77
    aget-object p0, p0, v1

    return-object p0

    :cond_7a
    :goto_7a
    return-object v0
.end method


# virtual methods
.method public abstract boundingBox()Lorg/mapsforge/core/model/BoundingBox;
.end method

.method public abstract close()V
.end method

.method protected extractLocalized(Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/datastore/MapDataStore;->preferredLanguage:Ljava/lang/String;

    invoke-static {p1, v0}, Lorg/mapsforge/map/datastore/MapDataStore;->extract(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public abstract getDataTimestamp(Lorg/mapsforge/core/model/Tile;)J
.end method

.method public readLabels(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 2

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->readMapData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1
.end method

.method public readLabels(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 9

    iget v0, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    iget v1, p2, Lorg/mapsforge/core/model/Tile;->tileX:I

    if-gt v0, v1, :cond_c

    iget v0, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    iget v1, p2, Lorg/mapsforge/core/model/Tile;->tileY:I

    if-le v0, v1, :cond_13

    :cond_c
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "upperLeft tile must be above and left of lowerRight tile"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    :cond_13
    new-instance v0, Lorg/mapsforge/map/datastore/MapReadResult;

    invoke-direct {v0}, Lorg/mapsforge/map/datastore/MapReadResult;-><init>()V

    iget v1, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    :goto_1a
    iget v2, p2, Lorg/mapsforge/core/model/Tile;->tileX:I

    if-gt v1, v2, :cond_3b

    iget v2, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    :goto_20
    iget v3, p2, Lorg/mapsforge/core/model/Tile;->tileY:I

    if-gt v2, v3, :cond_38

    new-instance v3, Lorg/mapsforge/core/model/Tile;

    iget-byte v4, p1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v5, p1, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v3, v1, v2, v4, v5}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    invoke-virtual {p0, v3}, Lorg/mapsforge/map/datastore/MapDataStore;->readLabels(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Lorg/mapsforge/map/datastore/MapReadResult;->add(Lorg/mapsforge/map/datastore/MapReadResult;Z)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_20

    :cond_38
    add-int/lit8 v1, v1, 0x1

    goto :goto_1a

    :cond_3b
    return-object v0
.end method

.method public abstract readMapData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
.end method

.method public readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 9

    iget v0, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    iget v1, p2, Lorg/mapsforge/core/model/Tile;->tileX:I

    if-gt v0, v1, :cond_c

    iget v0, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    iget v1, p2, Lorg/mapsforge/core/model/Tile;->tileY:I

    if-le v0, v1, :cond_13

    :cond_c
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "upperLeft tile must be above and left of lowerRight tile"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    :cond_13
    new-instance v0, Lorg/mapsforge/map/datastore/MapReadResult;

    invoke-direct {v0}, Lorg/mapsforge/map/datastore/MapReadResult;-><init>()V

    iget v1, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    :goto_1a
    iget v2, p2, Lorg/mapsforge/core/model/Tile;->tileX:I

    if-gt v1, v2, :cond_3b

    iget v2, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    :goto_20
    iget v3, p2, Lorg/mapsforge/core/model/Tile;->tileY:I

    if-gt v2, v3, :cond_38

    new-instance v3, Lorg/mapsforge/core/model/Tile;

    iget-byte v4, p1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v5, p1, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v3, v1, v2, v4, v5}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    invoke-virtual {p0, v3}, Lorg/mapsforge/map/datastore/MapDataStore;->readMapData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Lorg/mapsforge/map/datastore/MapReadResult;->add(Lorg/mapsforge/map/datastore/MapReadResult;Z)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_20

    :cond_38
    add-int/lit8 v1, v1, 0x1

    goto :goto_1a

    :cond_3b
    return-object v0
.end method

.method public abstract readPoiData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
.end method

.method public readPoiData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 9

    iget v0, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    iget v1, p2, Lorg/mapsforge/core/model/Tile;->tileX:I

    if-gt v0, v1, :cond_c

    iget v0, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    iget v1, p2, Lorg/mapsforge/core/model/Tile;->tileY:I

    if-le v0, v1, :cond_13

    :cond_c
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "upperLeft tile must be above and left of lowerRight tile"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    :cond_13
    new-instance v0, Lorg/mapsforge/map/datastore/MapReadResult;

    invoke-direct {v0}, Lorg/mapsforge/map/datastore/MapReadResult;-><init>()V

    iget v1, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    :goto_1a
    iget v2, p2, Lorg/mapsforge/core/model/Tile;->tileX:I

    if-gt v1, v2, :cond_3b

    iget v2, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    :goto_20
    iget v3, p2, Lorg/mapsforge/core/model/Tile;->tileY:I

    if-gt v2, v3, :cond_38

    new-instance v3, Lorg/mapsforge/core/model/Tile;

    iget-byte v4, p1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v5, p1, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v3, v1, v2, v4, v5}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    invoke-virtual {p0, v3}, Lorg/mapsforge/map/datastore/MapDataStore;->readPoiData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Lorg/mapsforge/map/datastore/MapReadResult;->add(Lorg/mapsforge/map/datastore/MapReadResult;Z)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_20

    :cond_38
    add-int/lit8 v1, v1, 0x1

    goto :goto_1a

    :cond_3b
    return-object v0
.end method

.method public abstract startPosition()Lorg/mapsforge/core/model/LatLong;
.end method

.method public abstract startZoomLevel()Ljava/lang/Byte;
.end method

.method public abstract supportsTile(Lorg/mapsforge/core/model/Tile;)Z
.end method

.method public wayAsLabelTagFilter(Ljava/util/List;)Z
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;)Z"
        }
    .end annotation

    const/4 p1, 0x0

    return p1
.end method
