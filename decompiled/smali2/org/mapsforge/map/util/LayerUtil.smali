.class public final Lorg/mapsforge/map/util/LayerUtil;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method public static collisionFreeOrdered(Ljava/util/List;)Ljava/util/List;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/mapelements/MapElementContainer;",
            ">;)",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/mapelements/MapElementContainer;",
            ">;"
        }
    .end annotation

    invoke-static {}, Ljava/util/Collections;->reverseOrder()Ljava/util/Comparator;

    move-result-object v0

    invoke-static {p0, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_10
    :goto_10
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3a

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/core/mapelements/MapElementContainer;

    const/4 v2, 0x1

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_21
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_34

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/mapsforge/core/mapelements/MapElementContainer;

    invoke-virtual {v4, v1}, Lorg/mapsforge/core/mapelements/MapElementContainer;->clashesWith(Lorg/mapsforge/core/mapelements/MapElementContainer;)Z

    move-result v4

    if-eqz v4, :cond_21

    const/4 v2, 0x0

    :cond_34
    if-eqz v2, :cond_10

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_10

    :cond_3a
    return-object v0
.end method

.method public static getLowerRight(Lorg/mapsforge/core/model/BoundingBox;BI)Lorg/mapsforge/core/model/Tile;
    .registers 6

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-static {v0, v1, p1}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToTileX(DB)I

    move-result v0

    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {v1, v2, p1}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToTileY(DB)I

    move-result p0

    new-instance v1, Lorg/mapsforge/core/model/Tile;

    invoke-direct {v1, v0, p0, p1, p2}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    return-object v1
.end method

.method public static getTilePositions(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/model/Point;I)Ljava/util/List;
    .registers 16
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/core/model/BoundingBox;",
            "B",
            "Lorg/mapsforge/core/model/Point;",
            "I)",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/layer/TilePosition;",
            ">;"
        }
    .end annotation

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-static {v0, v1, p1}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToTileX(DB)I

    move-result v0

    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {v1, v2, p1}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToTileY(DB)I

    move-result v1

    iget-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-static {v2, v3, p1}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToTileX(DB)I

    move-result v2

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {v3, v4, p1}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToTileY(DB)I

    move-result p0

    sub-int v3, v2, v0

    add-int/lit8 v3, v3, 0x1

    sub-int v4, p0, v1

    add-int/lit8 v4, v4, 0x1

    mul-int v3, v3, v4

    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4, v3}, Ljava/util/ArrayList;-><init>(I)V

    :goto_27
    if-gt v1, p0, :cond_56

    move v3, v0

    :goto_2a
    if-gt v3, v2, :cond_53

    int-to-long v5, v3

    invoke-static {v5, v6, p3}, Lorg/mapsforge/core/util/MercatorProjection;->tileToPixel(JI)J

    move-result-wide v5

    long-to-double v5, v5

    iget-wide v7, p2, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v5, v7

    int-to-long v7, v1

    invoke-static {v7, v8, p3}, Lorg/mapsforge/core/util/MercatorProjection;->tileToPixel(JI)J

    move-result-wide v7

    long-to-double v7, v7

    iget-wide v9, p2, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v7, v9

    new-instance v9, Lorg/mapsforge/map/layer/TilePosition;

    new-instance v10, Lorg/mapsforge/core/model/Tile;

    invoke-direct {v10, v3, v1, p1, p3}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    new-instance v11, Lorg/mapsforge/core/model/Point;

    invoke-direct {v11, v5, v6, v7, v8}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    invoke-direct {v9, v10, v11}, Lorg/mapsforge/map/layer/TilePosition;-><init>(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Point;)V

    invoke-interface {v4, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v3, v3, 0x1

    goto :goto_2a

    :cond_53
    add-int/lit8 v1, v1, 0x1

    goto :goto_27

    :cond_56
    return-object v4
.end method

.method public static getTiles(Lorg/mapsforge/core/model/BoundingBox;BI)Ljava/util/Set;
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/core/model/BoundingBox;",
            "BI)",
            "Ljava/util/Set<",
            "Lorg/mapsforge/core/model/Tile;",
            ">;"
        }
    .end annotation

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-static {v0, v1, p1}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToTileX(DB)I

    move-result v0

    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {v1, v2, p1}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToTileY(DB)I

    move-result v1

    iget-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-static {v2, v3, p1}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToTileX(DB)I

    move-result v2

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {v3, v4, p1}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToTileY(DB)I

    move-result p0

    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    :goto_1d
    if-gt v1, p0, :cond_30

    move v4, v0

    :goto_20
    if-gt v4, v2, :cond_2d

    new-instance v5, Lorg/mapsforge/core/model/Tile;

    invoke-direct {v5, v4, v1, p1, p2}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    invoke-interface {v3, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    add-int/lit8 v4, v4, 0x1

    goto :goto_20

    :cond_2d
    add-int/lit8 v1, v1, 0x1

    goto :goto_1d

    :cond_30
    return-object v3
.end method

.method public static getTiles(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Ljava/util/Set;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/core/model/Tile;",
            "Lorg/mapsforge/core/model/Tile;",
            ")",
            "Ljava/util/Set<",
            "Lorg/mapsforge/core/model/Tile;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    :goto_7
    iget v2, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    if-gt v1, v2, :cond_23

    iget v2, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    :goto_d
    iget v3, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    if-gt v2, v3, :cond_20

    new-instance v3, Lorg/mapsforge/core/model/Tile;

    iget-byte v4, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v5, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v3, v2, v1, v4, v5}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    invoke-interface {v0, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_d

    :cond_20
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_23
    return-object v0
.end method

.method public static getUpperLeft(Lorg/mapsforge/core/model/BoundingBox;BI)Lorg/mapsforge/core/model/Tile;
    .registers 6

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-static {v0, v1, p1}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToTileX(DB)I

    move-result v0

    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {v1, v2, p1}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToTileY(DB)I

    move-result p0

    new-instance v1, Lorg/mapsforge/core/model/Tile;

    invoke-direct {v1, v0, p0, p1, p2}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    return-object v1
.end method
