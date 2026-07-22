.class public Lorg/mapsforge/map/layer/download/tilesource/OpenStreetMapMapnik;
.super Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;
.source "SourceFile"


# static fields
.field public static final INSTANCE:Lorg/mapsforge/map/layer/download/tilesource/OpenStreetMapMapnik;

.field private static final PARALLEL_REQUESTS_LIMIT:I = 0x8

.field private static final PROTOCOL:Ljava/lang/String; = "https"

.field private static final ZOOM_LEVEL_MAX:I = 0x12

.field private static final ZOOM_LEVEL_MIN:I


# direct methods
.method static constructor <clinit>()V
    .registers 4

    new-instance v0, Lorg/mapsforge/map/layer/download/tilesource/OpenStreetMapMapnik;

    const-string v1, "a.tile.openstreetmap.org"

    const-string v2, "b.tile.openstreetmap.org"

    const-string v3, "c.tile.openstreetmap.org"

    filled-new-array {v1, v2, v3}, [Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x1bb

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/map/layer/download/tilesource/OpenStreetMapMapnik;-><init>([Ljava/lang/String;I)V

    sput-object v0, Lorg/mapsforge/map/layer/download/tilesource/OpenStreetMapMapnik;->INSTANCE:Lorg/mapsforge/map/layer/download/tilesource/OpenStreetMapMapnik;

    return-void
.end method

.method public constructor <init>([Ljava/lang/String;I)V
    .registers 3

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;-><init>([Ljava/lang/String;I)V

    const-wide/32 p1, 0x7e53d8

    iput-wide p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->defaultTimeToLive:J

    return-void
.end method


# virtual methods
.method public getParallelRequestsLimit()I
    .registers 2

    const/16 v0, 0x8

    return v0
.end method

.method public getTileUrl(Lorg/mapsforge/core/model/Tile;)Ljava/net/URL;
    .registers 8

    new-instance v0, Ljava/net/URL;

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->getHostName()Ljava/lang/String;

    move-result-object v1

    iget v2, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->port:I

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-byte v4, p1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const/16 v4, 0x2f

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget v5, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget p1, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, ".png"

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v3, "https"

    invoke-direct {v0, v3, v1, v2, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    return-object v0
.end method

.method public getZoomLevelMax()B
    .registers 2

    const/16 v0, 0x12

    return v0
.end method

.method public getZoomLevelMin()B
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method public hasAlpha()Z
    .registers 2

    const/4 v0, 0x0

    return v0
.end method
