.class Lorg/mapsforge/map/layer/download/TileDownloader;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

.field private final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;


# direct methods
.method constructor <init>(Lorg/mapsforge/map/layer/download/DownloadJob;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-eqz p1, :cond_14

    if-eqz p2, :cond_c

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

    iput-object p2, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    return-void

    :cond_c
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "graphicFactory must not be null"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_14
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "downloadJob must not be null"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private static getInputStream(Ljava/net/URLConnection;)Ljava/io/InputStream;
    .registers 3

    invoke-virtual {p0}, Ljava/net/URLConnection;->getContentEncoding()Ljava/lang/String;

    move-result-object v0

    const-string v1, "gzip"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    new-instance v0, Ljava/util/zip/GZIPInputStream;

    invoke-virtual {p0}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V

    return-object v0

    :cond_16
    invoke-virtual {p0}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method downloadImage()Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

    iget-object v1, v0, Lorg/mapsforge/map/layer/download/DownloadJob;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    iget-object v0, v0, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-interface {v1, v0}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getTileUrl(Lorg/mapsforge/core/model/Tile;)Ljava/net/URL;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/download/DownloadJob;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {v1}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getTimeoutConnect()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/net/URLConnection;->setConnectTimeout(I)V

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/download/DownloadJob;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {v1}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getTimeoutRead()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/net/URLConnection;->setReadTimeout(I)V

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/download/DownloadJob;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {v1}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getUserAgent()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3b

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/download/DownloadJob;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {v1}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getUserAgent()Ljava/lang/String;

    move-result-object v1

    const-string v2, "User-Agent"

    invoke-virtual {v0, v2, v1}, Ljava/net/URLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    :cond_3b
    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/download/DownloadJob;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {v1}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getReferer()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_52

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/download/DownloadJob;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {v1}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getReferer()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Referer"

    invoke-virtual {v0, v2, v1}, Ljava/net/URLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    :cond_52
    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/download/DownloadJob;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {v1}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getAuthorization()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_69

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/download/DownloadJob;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {v1}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getAuthorization()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Authorization"

    invoke-virtual {v0, v2, v1}, Ljava/net/URLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    :cond_69
    instance-of v1, v0, Ljava/net/HttpURLConnection;

    if-eqz v1, :cond_7b

    move-object v1, v0

    check-cast v1, Ljava/net/HttpURLConnection;

    iget-object v2, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

    iget-object v2, v2, Lorg/mapsforge/map/layer/download/DownloadJob;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {v2}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->isFollowRedirects()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    :cond_7b
    invoke-static {v0}, Lorg/mapsforge/map/layer/download/TileDownloader;->getInputStream(Ljava/net/URLConnection;)Ljava/io/InputStream;

    move-result-object v1

    :try_start_7f
    iget-object v2, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v3, p0, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadJob:Lorg/mapsforge/map/layer/download/DownloadJob;

    iget-object v4, v3, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget v4, v4, Lorg/mapsforge/core/model/Tile;->tileSize:I

    iget-boolean v3, v3, Lorg/mapsforge/map/layer/queue/Job;->hasAlpha:Z

    invoke-interface {v2, v1, v4, v3}, Lorg/mapsforge/core/graphics/GraphicFactory;->createTileBitmap(Ljava/io/InputStream;IZ)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object v2

    invoke-virtual {v0}, Ljava/net/URLConnection;->getExpiration()J

    move-result-wide v3

    invoke-interface {v2, v3, v4}, Lorg/mapsforge/core/graphics/TileBitmap;->setExpiration(J)V
    :try_end_94
    .catch Lorg/mapsforge/core/graphics/CorruptedInputStreamException; {:try_start_7f .. :try_end_94} :catch_9d
    .catchall {:try_start_7f .. :try_end_94} :catchall_98

    invoke-static {v1}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    return-object v2

    :catchall_98
    move-exception v0

    invoke-static {v1}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    throw v0

    :catch_9d
    const/4 v0, 0x0

    invoke-static {v1}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    return-object v0
.end method
