.class Lorg/mapsforge/map/reader/QueryParameters;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field fromBaseTileX:J

.field fromBaseTileY:J

.field fromBlockX:J

.field fromBlockY:J

.field queryTileBitmask:I

.field queryZoomLevel:I

.field toBaseTileX:J

.field toBaseTileY:J

.field toBlockX:J

.field toBlockY:J

.field useTileBitmask:Z


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public calculateBaseTiles(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/reader/header/SubFileParameter;)V
    .registers 9

    iget-byte v0, p1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget-byte p3, p3, Lorg/mapsforge/map/reader/header/SubFileParameter;->baseZoomLevel:B

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-ge v0, p3, :cond_2a

    sub-int/2addr p3, v0

    iget v0, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    shl-int/2addr v0, p3

    int-to-long v3, v0

    iput-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileX:J

    iget p1, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    shl-int/2addr p1, p3

    int-to-long v3, p1

    iput-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileY:J

    iget p1, p2, Lorg/mapsforge/core/model/Tile;->tileX:I

    shl-int/2addr p1, p3

    shl-int v0, v2, p3

    add-int/2addr p1, v0

    sub-int/2addr p1, v2

    int-to-long v3, p1

    iput-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileX:J

    iget p1, p2, Lorg/mapsforge/core/model/Tile;->tileY:I

    shl-int/2addr p1, p3

    add-int/2addr p1, v0

    sub-int/2addr p1, v2

    :goto_24
    int-to-long p1, p1

    iput-wide p1, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileY:J

    iput-boolean v1, p0, Lorg/mapsforge/map/reader/QueryParameters;->useTileBitmask:Z

    goto :goto_60

    :cond_2a
    if-le v0, p3, :cond_4e

    sub-int/2addr v0, p3

    iget p3, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    ushr-int/2addr p3, v0

    int-to-long v3, p3

    iput-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileX:J

    iget p3, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    ushr-int/2addr p3, v0

    int-to-long v3, p3

    iput-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileY:J

    iget p3, p2, Lorg/mapsforge/core/model/Tile;->tileX:I

    ushr-int/2addr p3, v0

    int-to-long v3, p3

    iput-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileX:J

    iget p3, p2, Lorg/mapsforge/core/model/Tile;->tileY:I

    ushr-int/2addr p3, v0

    int-to-long v3, p3

    iput-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileY:J

    iput-boolean v2, p0, Lorg/mapsforge/map/reader/QueryParameters;->useTileBitmask:Z

    invoke-static {p1, p2, v0}, Lorg/mapsforge/map/reader/QueryCalculations;->calculateTileBitmask(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;I)I

    move-result p1

    iput p1, p0, Lorg/mapsforge/map/reader/QueryParameters;->queryTileBitmask:I

    goto :goto_60

    :cond_4e
    iget p3, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    int-to-long v2, p3

    iput-wide v2, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileX:J

    iget p1, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    int-to-long v2, p1

    iput-wide v2, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileY:J

    iget p1, p2, Lorg/mapsforge/core/model/Tile;->tileX:I

    int-to-long v2, p1

    iput-wide v2, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileX:J

    iget p1, p2, Lorg/mapsforge/core/model/Tile;->tileY:I

    goto :goto_24

    :goto_60
    return-void
.end method

.method public calculateBaseTiles(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/reader/header/SubFileParameter;)V
    .registers 12

    iget-byte v0, p1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget-byte p2, p2, Lorg/mapsforge/map/reader/header/SubFileParameter;->baseZoomLevel:B

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-ge v0, p2, :cond_25

    sub-int/2addr p2, v0

    iget v0, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    shl-int/2addr v0, p2

    int-to-long v3, v0

    iput-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileX:J

    iget p1, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    shl-int/2addr p1, p2

    int-to-long v5, p1

    iput-wide v5, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileY:J

    shl-int p1, v2, p2

    int-to-long p1, p1

    add-long/2addr v3, p1

    const-wide/16 v7, 0x1

    sub-long/2addr v3, v7

    iput-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileX:J

    add-long/2addr v5, p1

    sub-long/2addr v5, v7

    iput-wide v5, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileY:J

    :goto_22
    iput-boolean v1, p0, Lorg/mapsforge/map/reader/QueryParameters;->useTileBitmask:Z

    goto :goto_50

    :cond_25
    if-le v0, p2, :cond_41

    sub-int/2addr v0, p2

    iget p2, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    ushr-int/2addr p2, v0

    int-to-long v3, p2

    iput-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileX:J

    iget p2, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    ushr-int/2addr p2, v0

    int-to-long v5, p2

    iput-wide v5, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileY:J

    iput-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileX:J

    iput-wide v5, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileY:J

    iput-boolean v2, p0, Lorg/mapsforge/map/reader/QueryParameters;->useTileBitmask:Z

    invoke-static {p1, v0}, Lorg/mapsforge/map/reader/QueryCalculations;->calculateTileBitmask(Lorg/mapsforge/core/model/Tile;I)I

    move-result p1

    iput p1, p0, Lorg/mapsforge/map/reader/QueryParameters;->queryTileBitmask:I

    goto :goto_50

    :cond_41
    iget p2, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    int-to-long v2, p2

    iput-wide v2, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileX:J

    iget p1, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    int-to-long p1, p1

    iput-wide p1, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileY:J

    iput-wide v2, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileX:J

    iput-wide p1, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileY:J

    goto :goto_22

    :goto_50
    return-void
.end method

.method public calculateBlocks(Lorg/mapsforge/map/reader/header/SubFileParameter;)V
    .registers 8

    iget-wide v0, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileX:J

    iget-wide v2, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->boundaryTileLeft:J

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x0

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBlockX:J

    iget-wide v0, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileY:J

    iget-wide v4, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->boundaryTileTop:J

    sub-long/2addr v0, v4

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBlockY:J

    iget-wide v0, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileX:J

    iget-wide v2, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->boundaryTileLeft:J

    sub-long/2addr v0, v2

    iget-wide v2, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->blocksWidth:J

    const-wide/16 v4, 0x1

    sub-long/2addr v2, v4

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBlockX:J

    iget-wide v0, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileY:J

    iget-wide v2, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->boundaryTileTop:J

    sub-long/2addr v0, v2

    iget-wide v2, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->blocksHeight:J

    sub-long/2addr v2, v4

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBlockY:J

    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 9

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/map/reader/QueryParameters;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/map/reader/QueryParameters;

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileX:J

    iget-wide v5, p1, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileX:J

    cmp-long v1, v3, v5

    if-nez v1, :cond_5f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBlockX:J

    iget-wide v5, p1, Lorg/mapsforge/map/reader/QueryParameters;->fromBlockX:J

    cmp-long v1, v3, v5

    if-nez v1, :cond_5f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileY:J

    iget-wide v5, p1, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileY:J

    cmp-long v1, v3, v5

    if-nez v1, :cond_5f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBlockY:J

    iget-wide v5, p1, Lorg/mapsforge/map/reader/QueryParameters;->fromBlockY:J

    cmp-long v1, v3, v5

    if-nez v1, :cond_5f

    iget v1, p0, Lorg/mapsforge/map/reader/QueryParameters;->queryTileBitmask:I

    iget v3, p1, Lorg/mapsforge/map/reader/QueryParameters;->queryTileBitmask:I

    if-ne v1, v3, :cond_5f

    iget v1, p0, Lorg/mapsforge/map/reader/QueryParameters;->queryZoomLevel:I

    iget v3, p1, Lorg/mapsforge/map/reader/QueryParameters;->queryZoomLevel:I

    if-ne v1, v3, :cond_5f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileX:J

    iget-wide v5, p1, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileX:J

    cmp-long v1, v3, v5

    if-nez v1, :cond_5f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileY:J

    iget-wide v5, p1, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileY:J

    cmp-long v1, v3, v5

    if-nez v1, :cond_5f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBlockX:J

    iget-wide v5, p1, Lorg/mapsforge/map/reader/QueryParameters;->toBlockX:J

    cmp-long v1, v3, v5

    if-nez v1, :cond_5f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBlockY:J

    iget-wide v5, p1, Lorg/mapsforge/map/reader/QueryParameters;->toBlockY:J

    cmp-long v1, v3, v5

    if-nez v1, :cond_5f

    iget-boolean v1, p0, Lorg/mapsforge/map/reader/QueryParameters;->useTileBitmask:Z

    iget-boolean p1, p1, Lorg/mapsforge/map/reader/QueryParameters;->useTileBitmask:Z

    if-ne v1, p1, :cond_5f

    goto :goto_60

    :cond_5f
    const/4 v0, 0x0

    :goto_60
    return v0
.end method

.method public hashCode()I
    .registers 8

    iget-wide v0, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileX:J

    const/16 v2, 0x10

    ushr-long v3, v0, v2

    xor-long/2addr v0, v3

    long-to-int v1, v0

    const/16 v0, 0xd9

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBaseTileY:J

    ushr-long v5, v3, v2

    xor-long/2addr v3, v5

    long-to-int v1, v3

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileX:J

    ushr-long v5, v3, v2

    xor-long/2addr v3, v5

    long-to-int v1, v3

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBaseTileY:J

    ushr-long v5, v3, v2

    xor-long/2addr v3, v5

    long-to-int v1, v3

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBlockX:J

    ushr-long v5, v3, v2

    xor-long/2addr v3, v5

    long-to-int v1, v3

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->fromBlockY:J

    ushr-long v5, v3, v2

    xor-long/2addr v3, v5

    long-to-int v1, v3

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBlockX:J

    ushr-long v5, v3, v2

    xor-long/2addr v3, v5

    long-to-int v1, v3

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/QueryParameters;->toBlockY:J

    ushr-long v1, v3, v2

    xor-long/2addr v1, v3

    long-to-int v2, v1

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v1, p0, Lorg/mapsforge/map/reader/QueryParameters;->queryZoomLevel:I

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget v1, p0, Lorg/mapsforge/map/reader/QueryParameters;->queryTileBitmask:I

    add-int/2addr v0, v1

    return v0
.end method
