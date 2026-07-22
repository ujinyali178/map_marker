.class public Lorg/mapsforge/map/layer/download/TileDownloadLayer;
.super Lorg/mapsforge/map/layer/TileLayer;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/model/common/Observer;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/mapsforge/map/layer/TileLayer<",
        "Lorg/mapsforge/map/layer/download/DownloadJob;",
        ">;",
        "Lorg/mapsforge/map/model/common/Observer;"
    }
.end annotation


# static fields
.field private static final DOWNLOAD_THREADS_MAX:I = 0x8


# instance fields
.field private cacheTimeToLive:J

.field private final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field private started:Z

.field private final tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

.field private tileDownloadThreads:[Lorg/mapsforge/map/layer/download/TileDownloadThread;

.field private final tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/layer/download/tilesource/TileSource;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 7

    invoke-interface {p4}, Lorg/mapsforge/core/graphics/GraphicFactory;->createMatrix()Lorg/mapsforge/core/graphics/Matrix;

    move-result-object v0

    invoke-interface {p3}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->hasAlpha()Z

    move-result v1

    invoke-direct {p0, p1, p2, v0, v1}, Lorg/mapsforge/map/layer/TileLayer;-><init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/core/graphics/Matrix;Z)V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->cacheTimeToLive:J

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    iput-object p3, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {p3}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getDefaultTimeToLive()J

    move-result-wide p1

    iput-wide p1, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->cacheTimeToLive:J

    iput-object p4, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    return-void
.end method


# virtual methods
.method protected createJob(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/download/DownloadJob;
    .registers 4

    new-instance v0, Lorg/mapsforge/map/layer/download/DownloadJob;

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-direct {v0, p1, v1}, Lorg/mapsforge/map/layer/download/DownloadJob;-><init>(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/layer/download/tilesource/TileSource;)V

    return-object v0
.end method

.method protected bridge synthetic createJob(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/queue/Job;
    .registers 2

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->createJob(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/download/DownloadJob;

    move-result-object p1

    return-object p1
.end method

.method public draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {v0}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getZoomLevelMin()B

    move-result v0

    if-lt p2, v0, :cond_14

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {v0}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getZoomLevelMax()B

    move-result v0

    if-le p2, v0, :cond_11

    goto :goto_14

    :cond_11
    invoke-super {p0, p1, p2, p3, p4}, Lorg/mapsforge/map/layer/TileLayer;->draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V

    :cond_14
    :goto_14
    return-void
.end method

.method public getCacheTimeToLive()J
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->cacheTimeToLive:J

    return-wide v0
.end method

.method protected isTileStale(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/graphics/TileBitmap;)Z
    .registers 8

    invoke-interface {p2}, Lorg/mapsforge/core/graphics/TileBitmap;->isExpired()Z

    move-result p1

    const/4 v0, 0x1

    if-eqz p1, :cond_8

    return v0

    :cond_8
    iget-wide v1, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->cacheTimeToLive:J

    const-wide/16 v3, 0x0

    cmp-long p1, v1, v3

    if-eqz p1, :cond_20

    invoke-interface {p2}, Lorg/mapsforge/core/graphics/TileBitmap;->getTimestamp()J

    move-result-wide p1

    iget-wide v1, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->cacheTimeToLive:J

    add-long/2addr p1, v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    cmp-long v3, p1, v1

    if-gez v3, :cond_20

    goto :goto_21

    :cond_20
    const/4 v0, 0x0

    :goto_21
    return v0
.end method

.method protected onAdd()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    if-eqz v0, :cond_7

    invoke-interface {v0, p0}, Lorg/mapsforge/map/model/common/ObservableInterface;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    :cond_7
    invoke-super {p0}, Lorg/mapsforge/map/layer/Layer;->onAdd()V

    return-void
.end method

.method public onChange()V
    .registers 1

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/Layer;->requestRedraw()V

    return-void
.end method

.method public onDestroy()V
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileDownloadThreads:[Lorg/mapsforge/map/layer/download/TileDownloadThread;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_4
    if-ge v2, v1, :cond_e

    aget-object v3, v0, v2

    invoke-virtual {v3}, Lorg/mapsforge/map/util/PausableThread;->finish()V

    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    :cond_e
    invoke-super {p0}, Lorg/mapsforge/map/layer/Layer;->onDestroy()V

    return-void
.end method

.method public onPause()V
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileDownloadThreads:[Lorg/mapsforge/map/layer/download/TileDownloadThread;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_4
    if-ge v2, v1, :cond_e

    aget-object v3, v0, v2

    invoke-virtual {v3}, Lorg/mapsforge/map/util/PausableThread;->pause()V

    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    :cond_e
    return-void
.end method

.method protected onRemove()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    if-eqz v0, :cond_7

    invoke-interface {v0, p0}, Lorg/mapsforge/map/model/common/ObservableInterface;->removeObserver(Lorg/mapsforge/map/model/common/Observer;)V

    :cond_7
    invoke-super {p0}, Lorg/mapsforge/map/layer/Layer;->onRemove()V

    return-void
.end method

.method public onResume()V
    .registers 5

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->started:Z

    if-nez v0, :cond_7

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->start()V

    :cond_7
    iget-object v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileDownloadThreads:[Lorg/mapsforge/map/layer/download/TileDownloadThread;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_b
    if-ge v2, v1, :cond_15

    aget-object v3, v0, v2

    invoke-virtual {v3}, Lorg/mapsforge/map/util/PausableThread;->proceed()V

    add-int/lit8 v2, v2, 0x1

    goto :goto_b

    :cond_15
    return-void
.end method

.method public setCacheTimeToLive(J)V
    .registers 3

    iput-wide p1, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->cacheTimeToLive:J

    return-void
.end method

.method public declared-synchronized setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 11

    monitor-enter p0

    :try_start_1
    invoke-super {p0, p1}, Lorg/mapsforge/map/layer/TileLayer;->setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V

    iget-object p1, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileSource:Lorg/mapsforge/map/layer/download/tilesource/TileSource;

    invoke-interface {p1}, Lorg/mapsforge/map/layer/download/tilesource/TileSource;->getParallelRequestsLimit()I

    move-result p1

    const/16 v0, 0x8

    invoke-static {p1, v0}, Ljava/lang/Math;->min(II)I

    move-result p1

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    const/4 v1, 0x0

    if-eqz v0, :cond_31

    new-array v0, p1, [Lorg/mapsforge/map/layer/download/TileDownloadThread;

    iput-object v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileDownloadThreads:[Lorg/mapsforge/map/layer/download/TileDownloadThread;

    :goto_19
    if-ge v1, p1, :cond_40

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileDownloadThreads:[Lorg/mapsforge/map/layer/download/TileDownloadThread;

    new-instance v8, Lorg/mapsforge/map/layer/download/TileDownloadThread;

    iget-object v3, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    iget-object v4, p0, Lorg/mapsforge/map/layer/TileLayer;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    iget-object v6, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v7, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    move-object v2, v8

    move-object v5, p0

    invoke-direct/range {v2 .. v7}, Lorg/mapsforge/map/layer/download/TileDownloadThread;-><init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/layer/queue/JobQueue;Lorg/mapsforge/map/layer/Layer;Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V

    aput-object v8, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_19

    :cond_31
    iget-object p1, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileDownloadThreads:[Lorg/mapsforge/map/layer/download/TileDownloadThread;

    if-eqz p1, :cond_40

    array-length v0, p1

    :goto_36
    if-ge v1, v0, :cond_40

    aget-object v2, p1, v1

    invoke-virtual {v2}, Lorg/mapsforge/map/util/PausableThread;->finish()V
    :try_end_3d
    .catchall {:try_start_1 .. :try_end_3d} :catchall_42

    add-int/lit8 v1, v1, 0x1

    goto :goto_36

    :cond_40
    monitor-exit p0

    return-void

    :catchall_42
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public start()V
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->tileDownloadThreads:[Lorg/mapsforge/map/layer/download/TileDownloadThread;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_4
    if-ge v2, v1, :cond_e

    aget-object v3, v0, v2

    invoke-virtual {v3}, Ljava/lang/Thread;->start()V

    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    :cond_e
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadLayer;->started:Z

    return-void
.end method
