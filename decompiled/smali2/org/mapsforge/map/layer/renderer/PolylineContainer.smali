.class public Lorg/mapsforge/map/layer/renderer/PolylineContainer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/renderer/ShapeContainer;


# instance fields
.field private center:Lorg/mapsforge/core/model/Point;

.field private coordinatesAbsolute:[[Lorg/mapsforge/core/model/Point;

.field private coordinatesRelativeToTile:[[Lorg/mapsforge/core/model/Point;

.field private final isClosedWay:Z

.field private final layer:B

.field private final lowerRight:Lorg/mapsforge/core/model/Tile;

.field private final tags:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;"
        }
    .end annotation
.end field

.field private final upperLeft:Lorg/mapsforge/core/model/Tile;

.field private way:Lorg/mapsforge/map/datastore/Way;


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/datastore/Way;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesAbsolute:[[Lorg/mapsforge/core/model/Point;

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesRelativeToTile:[[Lorg/mapsforge/core/model/Point;

    iget-object v0, p1, Lorg/mapsforge/map/datastore/Way;->tags:Ljava/util/List;

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->tags:Ljava/util/List;

    iput-object p2, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->upperLeft:Lorg/mapsforge/core/model/Tile;

    iput-object p3, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->lowerRight:Lorg/mapsforge/core/model/Tile;

    iget-byte p3, p1, Lorg/mapsforge/map/datastore/Way;->layer:B

    iput-byte p3, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->layer:B

    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->way:Lorg/mapsforge/map/datastore/Way;

    iget-object p1, p1, Lorg/mapsforge/map/datastore/Way;->latLongs:[[Lorg/mapsforge/core/model/LatLong;

    const/4 p3, 0x0

    aget-object p1, p1, p3

    invoke-static {p1}, Lorg/mapsforge/core/util/LatLongUtils;->isClosedWay([Lorg/mapsforge/core/model/LatLong;)Z

    move-result p1

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->isClosedWay:Z

    iget-object p1, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->way:Lorg/mapsforge/map/datastore/Way;

    iget-object p1, p1, Lorg/mapsforge/map/datastore/Way;->labelPosition:Lorg/mapsforge/core/model/LatLong;

    if-eqz p1, :cond_2f

    iget-wide p2, p2, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-static {p1, p2, p3}, Lorg/mapsforge/core/util/MercatorProjection;->getPixelAbsolute(Lorg/mapsforge/core/model/LatLong;J)Lorg/mapsforge/core/model/Point;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->center:Lorg/mapsforge/core/model/Point;

    :cond_2f
    return-void
.end method

.method public constructor <init>([Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Ljava/util/List;)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lorg/mapsforge/core/model/Point;",
            "Lorg/mapsforge/core/model/Tile;",
            "Lorg/mapsforge/core/model/Tile;",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    new-array v1, v0, [[Lorg/mapsforge/core/model/Point;

    iput-object v1, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesAbsolute:[[Lorg/mapsforge/core/model/Point;

    const/4 v2, 0x0

    iput-object v2, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesRelativeToTile:[[Lorg/mapsforge/core/model/Point;

    array-length v2, p1

    new-array v2, v2, [Lorg/mapsforge/core/model/Point;

    const/4 v3, 0x0

    aput-object v2, v1, v3

    array-length v1, p1

    invoke-static {p1, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object p4, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->tags:Ljava/util/List;

    iput-object p2, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->upperLeft:Lorg/mapsforge/core/model/Tile;

    iput-object p3, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->lowerRight:Lorg/mapsforge/core/model/Tile;

    iput-byte v3, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->layer:B

    aget-object p2, p1, v3

    array-length p3, p1

    sub-int/2addr p3, v0

    aget-object p1, p1, p3

    invoke-virtual {p2, p1}, Lorg/mapsforge/core/model/Point;->equals(Ljava/lang/Object;)Z

    move-result p1

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->isClosedWay:Z

    return-void
.end method


# virtual methods
.method public getCenterAbsolute()Lorg/mapsforge/core/model/Point;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->center:Lorg/mapsforge/core/model/Point;

    if-nez v0, :cond_11

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getCoordinatesAbsolute()[[Lorg/mapsforge/core/model/Point;

    move-result-object v0

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-static {v0}, Lorg/mapsforge/map/layer/renderer/GeometryUtils;->calculateCenterOfBoundingBox([Lorg/mapsforge/core/model/Point;)Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->center:Lorg/mapsforge/core/model/Point;

    :cond_11
    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->center:Lorg/mapsforge/core/model/Point;

    return-object v0
.end method

.method public getCoordinatesAbsolute()[[Lorg/mapsforge/core/model/Point;
    .registers 8

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesAbsolute:[[Lorg/mapsforge/core/model/Point;

    if-nez v0, :cond_42

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->way:Lorg/mapsforge/map/datastore/Way;

    iget-object v0, v0, Lorg/mapsforge/map/datastore/Way;->latLongs:[[Lorg/mapsforge/core/model/LatLong;

    array-length v0, v0

    new-array v0, v0, [[Lorg/mapsforge/core/model/Point;

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesAbsolute:[[Lorg/mapsforge/core/model/Point;

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_f
    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->way:Lorg/mapsforge/map/datastore/Way;

    iget-object v2, v2, Lorg/mapsforge/map/datastore/Way;->latLongs:[[Lorg/mapsforge/core/model/LatLong;

    array-length v3, v2

    if-ge v1, v3, :cond_3f

    iget-object v3, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesAbsolute:[[Lorg/mapsforge/core/model/Point;

    aget-object v2, v2, v1

    array-length v2, v2

    new-array v2, v2, [Lorg/mapsforge/core/model/Point;

    aput-object v2, v3, v1

    const/4 v2, 0x0

    :goto_20
    iget-object v3, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->way:Lorg/mapsforge/map/datastore/Way;

    iget-object v3, v3, Lorg/mapsforge/map/datastore/Way;->latLongs:[[Lorg/mapsforge/core/model/LatLong;

    aget-object v3, v3, v1

    array-length v4, v3

    if-ge v2, v4, :cond_3c

    iget-object v4, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesAbsolute:[[Lorg/mapsforge/core/model/Point;

    aget-object v4, v4, v1

    aget-object v3, v3, v2

    iget-object v5, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->upperLeft:Lorg/mapsforge/core/model/Tile;

    iget-wide v5, v5, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-static {v3, v5, v6}, Lorg/mapsforge/core/util/MercatorProjection;->getPixelAbsolute(Lorg/mapsforge/core/model/LatLong;J)Lorg/mapsforge/core/model/Point;

    move-result-object v3

    aput-object v3, v4, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_20

    :cond_3c
    add-int/lit8 v1, v1, 0x1

    goto :goto_f

    :cond_3f
    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->way:Lorg/mapsforge/map/datastore/Way;

    :cond_42
    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesAbsolute:[[Lorg/mapsforge/core/model/Point;

    return-object v0
.end method

.method public getCoordinatesRelativeToOrigin()[[Lorg/mapsforge/core/model/Point;
    .registers 11

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesRelativeToTile:[[Lorg/mapsforge/core/model/Point;

    if-nez v0, :cond_43

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->upperLeft:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v0}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v0

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getCoordinatesAbsolute()[[Lorg/mapsforge/core/model/Point;

    move-result-object v1

    array-length v1, v1

    new-array v1, v1, [[Lorg/mapsforge/core/model/Point;

    iput-object v1, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesRelativeToTile:[[Lorg/mapsforge/core/model/Point;

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_15
    iget-object v3, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesRelativeToTile:[[Lorg/mapsforge/core/model/Point;

    array-length v4, v3

    if-ge v2, v4, :cond_43

    iget-object v4, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesAbsolute:[[Lorg/mapsforge/core/model/Point;

    aget-object v4, v4, v2

    array-length v4, v4

    new-array v4, v4, [Lorg/mapsforge/core/model/Point;

    aput-object v4, v3, v2

    const/4 v3, 0x0

    :goto_24
    iget-object v4, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesRelativeToTile:[[Lorg/mapsforge/core/model/Point;

    aget-object v4, v4, v2

    array-length v5, v4

    if-ge v3, v5, :cond_40

    iget-object v5, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesAbsolute:[[Lorg/mapsforge/core/model/Point;

    aget-object v5, v5, v2

    aget-object v5, v5, v3

    iget-wide v6, v0, Lorg/mapsforge/core/model/Point;->x:D

    neg-double v6, v6

    iget-wide v8, v0, Lorg/mapsforge/core/model/Point;->y:D

    neg-double v8, v8

    invoke-virtual {v5, v6, v7, v8, v9}, Lorg/mapsforge/core/model/Point;->offset(DD)Lorg/mapsforge/core/model/Point;

    move-result-object v5

    aput-object v5, v4, v3

    add-int/lit8 v3, v3, 0x1

    goto :goto_24

    :cond_40
    add-int/lit8 v2, v2, 0x1

    goto :goto_15

    :cond_43
    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->coordinatesRelativeToTile:[[Lorg/mapsforge/core/model/Point;

    return-object v0
.end method

.method public getLayer()B
    .registers 2

    iget-byte v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->layer:B

    return v0
.end method

.method public getLowerRight()Lorg/mapsforge/core/model/Tile;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->lowerRight:Lorg/mapsforge/core/model/Tile;

    return-object v0
.end method

.method public getShapeType()Lorg/mapsforge/map/layer/renderer/ShapeType;
    .registers 2

    sget-object v0, Lorg/mapsforge/map/layer/renderer/ShapeType;->POLYLINE:Lorg/mapsforge/map/layer/renderer/ShapeType;

    return-object v0
.end method

.method public getTags()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->tags:Ljava/util/List;

    return-object v0
.end method

.method public getUpperLeft()Lorg/mapsforge/core/model/Tile;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->upperLeft:Lorg/mapsforge/core/model/Tile;

    return-object v0
.end method

.method public isClosedWay()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->isClosedWay:Z

    return v0
.end method
