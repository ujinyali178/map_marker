.class public Lorg/mapsforge/map/reader/header/SubFileParameter;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final BYTES_PER_INDEX_ENTRY:B = 0x5t


# instance fields
.field public final baseZoomLevel:B

.field public final blocksHeight:J

.field public final blocksWidth:J

.field public final boundaryTileBottom:J

.field public final boundaryTileLeft:J

.field public final boundaryTileRight:J

.field public final boundaryTileTop:J

.field private final hashCodeValue:I

.field public final indexEndAddress:J

.field public final indexStartAddress:J

.field public final numberOfBlocks:J

.field public final startAddress:J

.field public final subFileSize:J

.field public final zoomLevelMax:B

.field public final zoomLevelMin:B


# direct methods
.method constructor <init>(Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;)V
    .registers 13

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iget-wide v0, p1, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->startAddress:J

    iput-wide v0, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->startAddress:J

    iget-wide v0, p1, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->indexStartAddress:J

    iput-wide v0, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->indexStartAddress:J

    iget-wide v2, p1, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->subFileSize:J

    iput-wide v2, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->subFileSize:J

    iget-byte v2, p1, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->baseZoomLevel:B

    iput-byte v2, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->baseZoomLevel:B

    iget-byte v3, p1, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->zoomLevelMin:B

    iput-byte v3, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->zoomLevelMin:B

    iget-byte v3, p1, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->zoomLevelMax:B

    iput-byte v3, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->zoomLevelMax:B

    invoke-direct {p0}, Lorg/mapsforge/map/reader/header/SubFileParameter;->calculateHashCode()I

    move-result v3

    iput v3, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->hashCodeValue:I

    iget-object v3, p1, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    iget-wide v3, v3, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {v3, v4, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToTileY(DB)I

    move-result v3

    int-to-long v3, v3

    iput-wide v3, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->boundaryTileBottom:J

    iget-object v5, p1, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    iget-wide v5, v5, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-static {v5, v6, v2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToTileX(DB)I

    move-result v5

    int-to-long v5, v5

    iput-wide v5, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->boundaryTileLeft:J

    iget-object v7, p1, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    iget-wide v7, v7, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {v7, v8, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToTileY(DB)I

    move-result v7

    int-to-long v7, v7

    iput-wide v7, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->boundaryTileTop:J

    iget-object p1, p1, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    iget-wide v9, p1, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-static {v9, v10, v2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToTileX(DB)I

    move-result p1

    int-to-long v9, p1

    iput-wide v9, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->boundaryTileRight:J

    sub-long/2addr v9, v5

    const-wide/16 v5, 0x1

    add-long/2addr v9, v5

    iput-wide v9, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->blocksWidth:J

    sub-long/2addr v3, v7

    add-long/2addr v3, v5

    iput-wide v3, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->blocksHeight:J

    mul-long v9, v9, v3

    iput-wide v9, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->numberOfBlocks:J

    const-wide/16 v2, 0x5

    mul-long v9, v9, v2

    add-long/2addr v0, v9

    iput-wide v0, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->indexEndAddress:J

    return-void
.end method

.method private calculateHashCode()I
    .registers 6

    iget-wide v0, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->startAddress:J

    const/16 v2, 0x20

    ushr-long v3, v0, v2

    xor-long/2addr v0, v3

    long-to-int v1, v0

    const/16 v0, 0xd9

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-wide v3, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->subFileSize:J

    ushr-long v1, v3, v2

    xor-long/2addr v1, v3

    long-to-int v2, v1

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-byte v1, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->baseZoomLevel:B

    add-int/2addr v0, v1

    return v0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 9

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/map/reader/header/SubFileParameter;

    iget-wide v3, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->startAddress:J

    iget-wide v5, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->startAddress:J

    cmp-long v1, v3, v5

    if-eqz v1, :cond_15

    return v2

    :cond_15
    iget-wide v3, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->subFileSize:J

    iget-wide v5, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->subFileSize:J

    cmp-long v1, v3, v5

    if-eqz v1, :cond_1e

    return v2

    :cond_1e
    iget-byte v1, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->baseZoomLevel:B

    iget-byte p1, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->baseZoomLevel:B

    if-eq v1, p1, :cond_25

    return v2

    :cond_25
    return v0
.end method

.method public hashCode()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/reader/header/SubFileParameter;->hashCodeValue:I

    return v0
.end method
