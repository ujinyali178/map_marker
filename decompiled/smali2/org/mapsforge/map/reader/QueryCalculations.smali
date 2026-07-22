.class final Lorg/mapsforge/map/reader/QueryCalculations;
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

.method static calculateTileBitmask(Lorg/mapsforge/core/model/Tile;I)I
    .registers 16

    const/4 v0, 0x1

    if-ne p1, v0, :cond_8

    invoke-static {p0}, Lorg/mapsforge/map/reader/QueryCalculations;->getFirstLevelTileBitmask(Lorg/mapsforge/core/model/Tile;)I

    move-result p0

    return p0

    :cond_8
    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    add-int/lit8 p1, p1, -0x2

    ushr-int/2addr v1, p1

    int-to-long v1, v1

    iget p0, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    ushr-int/2addr p0, p1

    int-to-long p0, p0

    ushr-long v3, v1, v0

    ushr-long v5, p0, v0

    const-wide/16 v7, 0x2

    rem-long/2addr v3, v7

    const-wide/16 v9, 0x0

    cmp-long v0, v3, v9

    if-nez v0, :cond_2a

    rem-long v11, v5, v7

    cmp-long v13, v11, v9

    if-nez v13, :cond_2a

    invoke-static {v1, v2, p0, p1}, Lorg/mapsforge/map/reader/QueryCalculations;->getSecondLevelTileBitmaskUpperLeft(JJ)I

    move-result p0

    return p0

    :cond_2a
    const-wide/16 v11, 0x1

    cmp-long v13, v3, v11

    if-nez v13, :cond_3b

    rem-long v3, v5, v7

    cmp-long v13, v3, v9

    if-nez v13, :cond_3b

    invoke-static {v1, v2, p0, p1}, Lorg/mapsforge/map/reader/QueryCalculations;->getSecondLevelTileBitmaskUpperRight(JJ)I

    move-result p0

    return p0

    :cond_3b
    if-nez v0, :cond_47

    rem-long/2addr v5, v7

    cmp-long v0, v5, v11

    if-nez v0, :cond_47

    invoke-static {v1, v2, p0, p1}, Lorg/mapsforge/map/reader/QueryCalculations;->getSecondLevelTileBitmaskLowerLeft(JJ)I

    move-result p0

    return p0

    :cond_47
    invoke-static {v1, v2, p0, p1}, Lorg/mapsforge/map/reader/QueryCalculations;->getSecondLevelTileBitmaskLowerRight(JJ)I

    move-result p0

    return p0
.end method

.method static calculateTileBitmask(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;I)I
    .registers 9

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    const/4 v1, 0x0

    :goto_3
    iget v2, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    if-gt v0, v2, :cond_21

    iget v2, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    :goto_9
    iget v3, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    if-gt v2, v3, :cond_1e

    new-instance v3, Lorg/mapsforge/core/model/Tile;

    iget-byte v4, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget v5, p0, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-direct {v3, v0, v2, v4, v5}, Lorg/mapsforge/core/model/Tile;-><init>(IIBI)V

    invoke-static {v3, p2}, Lorg/mapsforge/map/reader/QueryCalculations;->calculateTileBitmask(Lorg/mapsforge/core/model/Tile;I)I

    move-result v3

    or-int/2addr v1, v3

    add-int/lit8 v2, v2, 0x1

    goto :goto_9

    :cond_1e
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    :cond_21
    return v1
.end method

.method private static getFirstLevelTileBitmask(Lorg/mapsforge/core/model/Tile;)I
    .registers 4

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    rem-int/lit8 v1, v0, 0x2

    if-nez v1, :cond_10

    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    rem-int/lit8 v1, v1, 0x2

    if-nez v1, :cond_10

    const p0, 0xcc00

    return p0

    :cond_10
    rem-int/lit8 v1, v0, 0x2

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1e

    iget v1, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    rem-int/lit8 v1, v1, 0x2

    if-nez v1, :cond_1e

    const/16 p0, 0x3300

    return p0

    :cond_1e
    rem-int/lit8 v0, v0, 0x2

    if-nez v0, :cond_2b

    iget p0, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    rem-int/lit8 p0, p0, 0x2

    if-ne p0, v2, :cond_2b

    const/16 p0, 0xcc

    return p0

    :cond_2b
    const/16 p0, 0x33

    return p0
.end method

.method private static getSecondLevelTileBitmaskLowerLeft(JJ)I
    .registers 12

    const-wide/16 v0, 0x2

    rem-long/2addr p0, v0

    const-wide/16 v2, 0x0

    cmp-long v4, p0, v2

    if-nez v4, :cond_12

    rem-long v5, p2, v0

    cmp-long v7, v5, v2

    if-nez v7, :cond_12

    const/16 p0, 0x80

    return p0

    :cond_12
    const-wide/16 v5, 0x1

    cmp-long v7, p0, v5

    if-nez v7, :cond_21

    rem-long p0, p2, v0

    cmp-long v7, p0, v2

    if-nez v7, :cond_21

    const/16 p0, 0x40

    return p0

    :cond_21
    if-nez v4, :cond_2b

    rem-long/2addr p2, v0

    cmp-long p0, p2, v5

    if-nez p0, :cond_2b

    const/16 p0, 0x8

    return p0

    :cond_2b
    const/4 p0, 0x4

    return p0
.end method

.method private static getSecondLevelTileBitmaskLowerRight(JJ)I
    .registers 12

    const-wide/16 v0, 0x2

    rem-long/2addr p0, v0

    const-wide/16 v2, 0x0

    cmp-long v4, p0, v2

    if-nez v4, :cond_12

    rem-long v5, p2, v0

    cmp-long v7, v5, v2

    if-nez v7, :cond_12

    const/16 p0, 0x20

    return p0

    :cond_12
    const-wide/16 v5, 0x1

    cmp-long v7, p0, v5

    if-nez v7, :cond_21

    rem-long p0, p2, v0

    cmp-long v7, p0, v2

    if-nez v7, :cond_21

    const/16 p0, 0x10

    return p0

    :cond_21
    if-nez v4, :cond_2a

    rem-long/2addr p2, v0

    cmp-long p0, p2, v5

    if-nez p0, :cond_2a

    const/4 p0, 0x2

    return p0

    :cond_2a
    const/4 p0, 0x1

    return p0
.end method

.method private static getSecondLevelTileBitmaskUpperLeft(JJ)I
    .registers 12

    const-wide/16 v0, 0x2

    rem-long/2addr p0, v0

    const-wide/16 v2, 0x0

    cmp-long v4, p0, v2

    if-nez v4, :cond_13

    rem-long v5, p2, v0

    cmp-long v7, v5, v2

    if-nez v7, :cond_13

    const p0, 0x8000

    return p0

    :cond_13
    const-wide/16 v5, 0x1

    cmp-long v7, p0, v5

    if-nez v7, :cond_22

    rem-long p0, p2, v0

    cmp-long v7, p0, v2

    if-nez v7, :cond_22

    const/16 p0, 0x4000

    return p0

    :cond_22
    if-nez v4, :cond_2c

    rem-long/2addr p2, v0

    cmp-long p0, p2, v5

    if-nez p0, :cond_2c

    const/16 p0, 0x800

    return p0

    :cond_2c
    const/16 p0, 0x400

    return p0
.end method

.method private static getSecondLevelTileBitmaskUpperRight(JJ)I
    .registers 12

    const-wide/16 v0, 0x2

    rem-long/2addr p0, v0

    const-wide/16 v2, 0x0

    cmp-long v4, p0, v2

    if-nez v4, :cond_12

    rem-long v5, p2, v0

    cmp-long v7, v5, v2

    if-nez v7, :cond_12

    const/16 p0, 0x2000

    return p0

    :cond_12
    const-wide/16 v5, 0x1

    cmp-long v7, p0, v5

    if-nez v7, :cond_21

    rem-long p0, p2, v0

    cmp-long v7, p0, v2

    if-nez v7, :cond_21

    const/16 p0, 0x1000

    return p0

    :cond_21
    if-nez v4, :cond_2b

    rem-long/2addr p2, v0

    cmp-long p0, p2, v5

    if-nez p0, :cond_2b

    const/16 p0, 0x200

    return p0

    :cond_2b
    const/16 p0, 0x100

    return p0
.end method
