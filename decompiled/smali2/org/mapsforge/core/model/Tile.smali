.class public Lorg/mapsforge/core/model/Tile;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private boundingBox:Lorg/mapsforge/core/model/BoundingBox;

.field public final mapSize:J

.field private origin:Lorg/mapsforge/core/model/Point;

.field public final tileSize:I

.field public final tileX:I

.field public final tileY:I

.field public final zoomLevel:B


# direct methods
.method public constructor <init>(IIBI)V
    .registers 11

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-ltz p1, :cond_91

    if-ltz p2, :cond_7a

    if-ltz p3, :cond_63

    invoke-static {p3}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v0

    int-to-long v0, v0

    int-to-long v2, p1

    const-string v4, ": "

    cmp-long v5, v2, v0

    if-gtz v5, :cond_46

    int-to-long v2, p2

    cmp-long v5, v2, v0

    if-gtz v5, :cond_29

    iput p4, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    iput p1, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    iput p2, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    iput-byte p3, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {p3, p4}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide p1

    iput-wide p1, p0, Lorg/mapsforge/core/model/Tile;->mapSize:J

    return-void

    :cond_29
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance p4, Ljava/lang/StringBuilder;

    invoke-direct {p4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "invalid tileY number on zoom level "

    invoke-virtual {p4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p4, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p4, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p4, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_46
    new-instance p2, Ljava/lang/IllegalArgumentException;

    new-instance p4, Ljava/lang/StringBuilder;

    invoke-direct {p4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "invalid tileX number on zoom level "

    invoke-virtual {p4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p4, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p4, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p4, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p2

    :cond_63
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p4, "zoomLevel must not be negative: "

    invoke-virtual {p2, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_7a
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance p3, Ljava/lang/StringBuilder;

    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    const-string p4, "tileY must not be negative: "

    invoke-virtual {p3, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_91
    new-instance p2, Ljava/lang/IllegalArgumentException;

    new-instance p3, Ljava/lang/StringBuilder;

    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    const-string p4, "tileX must not be negative: "

    invoke-virtual {p3, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p2
.end method

.method public static getBoundaryAbsolute(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/core/model/Rectangle;
    .registers 12

    new-instance v9, Lorg/mapsforge/core/model/Rectangle;

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iget-wide v1, v0, Lorg/mapsforge/core/model/Point;->x:D

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iget-wide v3, v0, Lorg/mapsforge/core/model/Point;->y:D

    invoke-virtual {p1}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iget-wide v5, v0, Lorg/mapsforge/core/model/Point;->x:D

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    int-to-double v7, v0

    add-double/2addr v5, v7

    invoke-virtual {p1}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object p1

    iget-wide v7, p1, Lorg/mapsforge/core/model/Point;->y:D

    iget p0, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    int-to-double p0, p0

    add-double/2addr v7, p0

    move-object v0, v9

    invoke-direct/range {v0 .. v8}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    return-object v9
.end method

.method public static getBoundingBox(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/core/model/BoundingBox;
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getBoundingBox()Lorg/mapsforge/core/model/BoundingBox;

    move-result-object p0

    invoke-virtual {p1}, Lorg/mapsforge/core/model/Tile;->getBoundingBox()Lorg/mapsforge/core/model/BoundingBox;

    move-result-object p1

    invoke-virtual {p0, p1}, Lorg/mapsforge/core/model/BoundingBox;->extendBoundingBox(Lorg/mapsforge/core/model/BoundingBox;)Lorg/mapsforge/core/model/BoundingBox;

    move-result-object p0

    return-object p0
.end method

.method public static getMaxTileNumber(B)I
    .registers 4

    if-ltz p0, :cond_e

    if-nez p0, :cond_6

    const/4 p0, 0x0

    return p0

    :cond_6
    const/4 v0, 0x2

    add-int/lit8 p0, p0, -0x1

    shl-int p0, v0, p0

    add-int/lit8 p0, p0, -0x1

    return p0

    :cond_e
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "zoomLevel must not be negative: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static tileAreasOverlap(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Z
    .registers 6

    iget-byte v0, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget-byte v1, p2, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    if-eq v0, v1, :cond_8

    const/4 p0, 0x0

    return p0

    :cond_8
    invoke-virtual {p0, p2}, Lorg/mapsforge/core/model/Tile;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    invoke-virtual {p1, p3}, Lorg/mapsforge/core/model/Tile;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    const/4 p0, 0x1

    return p0

    :cond_16
    invoke-static {p0, p1}, Lorg/mapsforge/core/model/Tile;->getBoundaryAbsolute(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/core/model/Rectangle;

    move-result-object p0

    invoke-static {p2, p3}, Lorg/mapsforge/core/model/Tile;->getBoundaryAbsolute(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/core/model/Rectangle;

    move-result-object p1

    invoke-virtual {p0, p1}, Lorg/mapsforge/core/model/Rectangle;->intersects(Lorg/mapsforge/core/model/Rectangle;)Z

    move-result p0

    return p0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/core/model/Tile;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/core/model/Tile;

    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    iget v3, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    if-eq v1, v3, :cond_13

    return v2

    :cond_13
    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    iget v3, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    if-eq v1, v3, :cond_1a

    return v2

    :cond_1a
    iget-byte v1, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget-byte v3, p1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    if-eq v1, v3, :cond_21

    return v2

    :cond_21
    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    iget p1, p1, Lorg/mapsforge/core/model/Tile;->tileSize:I

    if-eq v1, p1, :cond_28

    return v2

    :cond_28
    return v0
.end method

.method public getAbove()Lorg/mapsforge/core/model/Tile;
    .registers 6

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    add-int/lit8 v0, v0, -0x1

    if-gez v0, :cond_c

    iget-byte v0, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v0}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v0

    :cond_c
    new-instance v1, Lorg/mapsforge/core/model/Tile;

    iget v2, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    iget-byte v3, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v4, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v1, v2, v0, v3, v4}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    return-object v1
.end method

.method public getAboveLeft()Lorg/mapsforge/core/model/Tile;
    .registers 6

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    add-int/lit8 v0, v0, -0x1

    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    add-int/lit8 v1, v1, -0x1

    if-gez v0, :cond_10

    iget-byte v0, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v0}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v0

    :cond_10
    if-gez v1, :cond_18

    iget-byte v1, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v1}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v1

    :cond_18
    new-instance v2, Lorg/mapsforge/core/model/Tile;

    iget-byte v3, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v4, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v2, v1, v0, v3, v4}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    return-object v2
.end method

.method public getAboveRight()Lorg/mapsforge/core/model/Tile;
    .registers 6

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    add-int/lit8 v0, v0, -0x1

    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    add-int/lit8 v1, v1, 0x1

    if-gez v0, :cond_10

    iget-byte v0, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v0}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v0

    :cond_10
    iget-byte v2, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v2}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v2

    if-le v1, v2, :cond_19

    const/4 v1, 0x0

    :cond_19
    new-instance v2, Lorg/mapsforge/core/model/Tile;

    iget-byte v3, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v4, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v2, v1, v0, v3, v4}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    return-object v2
.end method

.method public getBelow()Lorg/mapsforge/core/model/Tile;
    .registers 6

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    add-int/lit8 v0, v0, 0x1

    iget-byte v1, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v1}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v1

    if-le v0, v1, :cond_d

    const/4 v0, 0x0

    :cond_d
    new-instance v1, Lorg/mapsforge/core/model/Tile;

    iget v2, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    iget-byte v3, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v4, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v1, v2, v0, v3, v4}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    return-object v1
.end method

.method public getBelowLeft()Lorg/mapsforge/core/model/Tile;
    .registers 6

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    add-int/lit8 v0, v0, 0x1

    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    add-int/lit8 v1, v1, -0x1

    iget-byte v2, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v2}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v2

    if-le v0, v2, :cond_11

    const/4 v0, 0x0

    :cond_11
    if-gez v1, :cond_19

    iget-byte v1, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v1}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v1

    :cond_19
    new-instance v2, Lorg/mapsforge/core/model/Tile;

    iget-byte v3, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v4, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v2, v1, v0, v3, v4}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    return-object v2
.end method

.method public getBelowRight()Lorg/mapsforge/core/model/Tile;
    .registers 6

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    add-int/lit8 v0, v0, 0x1

    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    add-int/lit8 v1, v1, 0x1

    iget-byte v2, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v2}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v2

    const/4 v3, 0x0

    if-le v0, v2, :cond_12

    const/4 v0, 0x0

    :cond_12
    iget-byte v2, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v2}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v2

    if-le v1, v2, :cond_1b

    const/4 v1, 0x0

    :cond_1b
    new-instance v2, Lorg/mapsforge/core/model/Tile;

    iget-byte v3, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v4, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v2, v1, v0, v3, v4}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    return-object v2
.end method

.method public getBoundaryAbsolute()Lorg/mapsforge/core/model/Rectangle;
    .registers 13

    new-instance v9, Lorg/mapsforge/core/model/Rectangle;

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iget-wide v1, v0, Lorg/mapsforge/core/model/Point;->x:D

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iget-wide v3, v0, Lorg/mapsforge/core/model/Point;->y:D

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iget-wide v5, v0, Lorg/mapsforge/core/model/Point;->x:D

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    int-to-double v7, v0

    add-double/2addr v5, v7

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iget-wide v7, v0, Lorg/mapsforge/core/model/Point;->y:D

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    int-to-double v10, v0

    add-double/2addr v7, v10

    move-object v0, v9

    invoke-direct/range {v0 .. v8}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    return-object v9
.end method

.method public getBoundaryRelative()Lorg/mapsforge/core/model/Rectangle;
    .registers 11

    new-instance v9, Lorg/mapsforge/core/model/Rectangle;

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    int-to-double v5, v0

    int-to-double v7, v0

    const-wide/16 v1, 0x0

    const-wide/16 v3, 0x0

    move-object v0, v9

    invoke-direct/range {v0 .. v8}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    return-object v9
.end method

.method public getBoundingBox()Lorg/mapsforge/core/model/BoundingBox;
    .registers 14

    iget-object v0, p0, Lorg/mapsforge/core/model/Tile;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    if-nez v0, :cond_5e

    const-wide v0, -0x3faabcba4e5ab62aL    # -85.05112877980659

    iget v2, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    add-int/lit8 v2, v2, 0x1

    int-to-long v2, v2

    iget-byte v4, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v2, v3, v4}, Lorg/mapsforge/core/util/MercatorProjection;->tileYToLatitude(JB)D

    move-result-wide v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->max(DD)D

    move-result-wide v5

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    int-to-long v0, v0

    iget-byte v2, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v0, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->tileXToLongitude(JB)D

    move-result-wide v0

    const-wide v2, -0x3f99800000000000L    # -180.0

    invoke-static {v2, v3, v0, v1}, Ljava/lang/Math;->max(DD)D

    move-result-wide v7

    const-wide v0, 0x40554345b1a549d6L    # 85.05112877980659

    iget v4, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    int-to-long v9, v4

    iget-byte v4, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v9, v10, v4}, Lorg/mapsforge/core/util/MercatorProjection;->tileYToLatitude(JB)D

    move-result-wide v9

    invoke-static {v0, v1, v9, v10}, Ljava/lang/Math;->min(DD)D

    move-result-wide v9

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    add-int/lit8 v0, v0, 0x1

    int-to-long v0, v0

    iget-byte v4, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v0, v1, v4}, Lorg/mapsforge/core/util/MercatorProjection;->tileXToLongitude(JB)D

    move-result-wide v0

    const-wide v11, 0x4066800000000000L    # 180.0

    invoke-static {v11, v12, v0, v1}, Ljava/lang/Math;->min(DD)D

    move-result-wide v0

    cmpl-double v4, v0, v2

    if-nez v4, :cond_55

    goto :goto_56

    :cond_55
    move-wide v11, v0

    :goto_56
    new-instance v0, Lorg/mapsforge/core/model/BoundingBox;

    move-object v4, v0

    invoke-direct/range {v4 .. v12}, Lorg/mapsforge/core/model/BoundingBox;-><init>(DDDD)V

    iput-object v0, p0, Lorg/mapsforge/core/model/Tile;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    :cond_5e
    iget-object v0, p0, Lorg/mapsforge/core/model/Tile;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    return-object v0
.end method

.method public getLeft()Lorg/mapsforge/core/model/Tile;
    .registers 6

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    add-int/lit8 v0, v0, -0x1

    if-gez v0, :cond_c

    iget-byte v0, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v0}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v0

    :cond_c
    new-instance v1, Lorg/mapsforge/core/model/Tile;

    iget v2, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    iget-byte v3, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v4, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v1, v0, v2, v3, v4}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    return-object v1
.end method

.method public getNeighbours()Ljava/util/Set;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "Lorg/mapsforge/core/model/Tile;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/HashSet;

    const/16 v1, 0x8

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getLeft()Lorg/mapsforge/core/model/Tile;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getAboveLeft()Lorg/mapsforge/core/model/Tile;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getAbove()Lorg/mapsforge/core/model/Tile;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getAboveRight()Lorg/mapsforge/core/model/Tile;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getRight()Lorg/mapsforge/core/model/Tile;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getBelowRight()Lorg/mapsforge/core/model/Tile;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getBelow()Lorg/mapsforge/core/model/Tile;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getBelowLeft()Lorg/mapsforge/core/model/Tile;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    return-object v0
.end method

.method public getOrigin()Lorg/mapsforge/core/model/Point;
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/core/model/Tile;->origin:Lorg/mapsforge/core/model/Point;

    if-nez v0, :cond_1f

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    int-to-long v0, v0

    iget v2, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-static {v0, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->tileToPixel(JI)J

    move-result-wide v0

    long-to-double v0, v0

    iget v2, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    int-to-long v2, v2

    iget v4, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-static {v2, v3, v4}, Lorg/mapsforge/core/util/MercatorProjection;->tileToPixel(JI)J

    move-result-wide v2

    long-to-double v2, v2

    new-instance v4, Lorg/mapsforge/core/model/Point;

    invoke-direct {v4, v0, v1, v2, v3}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    iput-object v4, p0, Lorg/mapsforge/core/model/Tile;->origin:Lorg/mapsforge/core/model/Point;

    :cond_1f
    iget-object v0, p0, Lorg/mapsforge/core/model/Tile;->origin:Lorg/mapsforge/core/model/Point;

    return-object v0
.end method

.method public getParent()Lorg/mapsforge/core/model/Tile;
    .registers 6

    iget-byte v0, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    if-nez v0, :cond_6

    const/4 v0, 0x0

    return-object v0

    :cond_6
    new-instance v1, Lorg/mapsforge/core/model/Tile;

    iget v2, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    div-int/lit8 v2, v2, 0x2

    iget v3, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    div-int/lit8 v3, v3, 0x2

    add-int/lit8 v0, v0, -0x1

    int-to-byte v0, v0

    iget v4, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v1, v2, v3, v0, v4}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    return-object v1
.end method

.method public getRight()Lorg/mapsforge/core/model/Tile;
    .registers 6

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    add-int/lit8 v0, v0, 0x1

    iget-byte v1, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v1}, Lorg/mapsforge/core/model/Tile;->getMaxTileNumber(B)I

    move-result v1

    if-le v0, v1, :cond_d

    const/4 v0, 0x0

    :cond_d
    new-instance v1, Lorg/mapsforge/core/model/Tile;

    iget v2, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    iget-byte v3, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v4, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v1, v0, v2, v3, v4}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    return-object v1
.end method

.method public getShiftX(Lorg/mapsforge/core/model/Tile;)I
    .registers 4

    invoke-virtual {p0, p1}, Lorg/mapsforge/core/model/Tile;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    const/4 p1, 0x0

    return p1

    :cond_8
    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    rem-int/lit8 v0, v0, 0x2

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getParent()Lorg/mapsforge/core/model/Tile;

    move-result-object v1

    invoke-virtual {v1, p1}, Lorg/mapsforge/core/model/Tile;->getShiftX(Lorg/mapsforge/core/model/Tile;)I

    move-result p1

    mul-int/lit8 p1, p1, 0x2

    add-int/2addr v0, p1

    return v0
.end method

.method public getShiftY(Lorg/mapsforge/core/model/Tile;)I
    .registers 4

    invoke-virtual {p0, p1}, Lorg/mapsforge/core/model/Tile;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    const/4 p1, 0x0

    return p1

    :cond_8
    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    rem-int/lit8 v0, v0, 0x2

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Tile;->getParent()Lorg/mapsforge/core/model/Tile;

    move-result-object v1

    invoke-virtual {v1, p1}, Lorg/mapsforge/core/model/Tile;->getShiftY(Lorg/mapsforge/core/model/Tile;)I

    move-result p1

    mul-int/lit8 p1, p1, 0x2

    add-int/2addr v0, p1

    return v0
.end method

.method public hashCode()I
    .registers 4

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    ushr-int/lit8 v1, v0, 0x10

    xor-int/2addr v0, v1

    const/16 v1, 0xd9

    add-int/2addr v1, v0

    mul-int/lit8 v1, v1, 0x1f

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    ushr-int/lit8 v2, v0, 0x10

    xor-int/2addr v0, v2

    add-int/2addr v1, v0

    mul-int/lit8 v1, v1, 0x1f

    iget-byte v0, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    add-int/2addr v1, v0

    mul-int/lit8 v1, v1, 0x1f

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    add-int/2addr v1, v0

    return v1
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "x="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ", y="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ", z="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-byte v1, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
