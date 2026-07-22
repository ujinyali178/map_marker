.class public Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;
.super Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;
.source "SourceFile"


# instance fields
.field private alpha:Z

.field private baseUrl:Ljava/lang/String;

.field private extension:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private parallelRequestsLimit:I

.field private protocol:Ljava/lang/String;

.field private tileSize:I

.field private zoomLevelMax:B

.field private zoomLevelMin:B


# direct methods
.method public constructor <init>([Ljava/lang/String;I)V
    .registers 3

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;-><init>([Ljava/lang/String;I)V

    const/4 p1, 0x0

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->alpha:Z

    const-string p2, "/"

    iput-object p2, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->baseUrl:Ljava/lang/String;

    const-string p2, "png"

    iput-object p2, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->extension:Ljava/lang/String;

    const/16 p2, 0x8

    iput p2, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->parallelRequestsLimit:I

    const-string p2, "http"

    iput-object p2, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->protocol:Ljava/lang/String;

    const/16 p2, 0x100

    iput p2, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->tileSize:I

    const/16 p2, 0x12

    iput-byte p2, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->zoomLevelMax:B

    iput-byte p1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->zoomLevelMin:B

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 4

    invoke-super {p0, p1}, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->equals(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_8

    return v1

    :cond_8
    instance-of v0, p1, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;

    if-nez v0, :cond_d

    return v1

    :cond_d
    check-cast p1, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->baseUrl:Ljava/lang/String;

    iget-object p1, p1, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->baseUrl:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_1a

    return v1

    :cond_1a
    const/4 p1, 0x1

    return p1
.end method

.method public getBaseUrl()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->baseUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getExtension()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->extension:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getParallelRequestsLimit()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->parallelRequestsLimit:I

    return v0
.end method

.method public getProtocol()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->protocol:Ljava/lang/String;

    return-object v0
.end method

.method public getTileSize()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->tileSize:I

    return v0
.end method

.method public getTileUrl(Lorg/mapsforge/core/model/Tile;)Ljava/net/URL;
    .registers 6

    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x20

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->baseUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-byte v1, p1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const/16 v1, 0x2f

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget v2, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget p1, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const/16 p1, 0x2e

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->extension:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->apiKey:Ljava/lang/String;

    if-eqz p1, :cond_45

    const/16 p1, 0x3f

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->keyName:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, "="

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->apiKey:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_45
    new-instance p1, Ljava/net/URL;

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->protocol:Ljava/lang/String;

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->getHostName()Ljava/lang/String;

    move-result-object v2

    iget v3, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->port:I

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v1, v2, v3, v0}, Ljava/net/URL;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    return-object p1
.end method

.method public getZoomLevelMax()B
    .registers 2

    iget-byte v0, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->zoomLevelMax:B

    return v0
.end method

.method public getZoomLevelMin()B
    .registers 2

    iget-byte v0, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->zoomLevelMin:B

    return v0
.end method

.method public hasAlpha()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->alpha:Z

    return v0
.end method

.method public hashCode()I
    .registers 3

    invoke-super {p0}, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->hashCode()I

    move-result v0

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->baseUrl:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public setAlpha(Z)Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;
    .registers 2

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->alpha:Z

    return-object p0
.end method

.method public setBaseUrl(Ljava/lang/String;)Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->baseUrl:Ljava/lang/String;

    return-object p0
.end method

.method public setExtension(Ljava/lang/String;)Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->extension:Ljava/lang/String;

    return-object p0
.end method

.method public setName(Ljava/lang/String;)Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->name:Ljava/lang/String;

    return-object p0
.end method

.method public setParallelRequestsLimit(I)Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->parallelRequestsLimit:I

    return-object p0
.end method

.method public setProtocol(Ljava/lang/String;)Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->protocol:Ljava/lang/String;

    return-object p0
.end method

.method public setTileSize(I)Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->tileSize:I

    return-object p0
.end method

.method public setZoomLevelMax(B)Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;
    .registers 2

    iput-byte p1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->zoomLevelMax:B

    return-object p0
.end method

.method public setZoomLevelMin(B)Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;
    .registers 2

    iput-byte p1, p0, Lorg/mapsforge/map/layer/download/tilesource/OnlineTileSource;->zoomLevelMin:B

    return-object p0
.end method
