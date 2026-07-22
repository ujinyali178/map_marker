.class Lorg/mapsforge/map/layer/download/TileDownloadThread;
.super Lorg/mapsforge/map/util/PausableThread;
.source "SourceFile"


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;


# instance fields
.field private final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field private final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field private jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/mapsforge/map/layer/queue/JobQueue<",
            "Lorg/mapsforge/map/layer/download/DownloadJob;",
            ">;"
        }
    .end annotation
.end field

.field private final layer:Lorg/mapsforge/map/layer/Layer;

.field private final tileCache:Lorg/mapsforge/map/layer/cache/TileCache;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/layer/download/TileDownloadThread;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method constructor <init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/layer/queue/JobQueue;Lorg/mapsforge/map/layer/Layer;Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/layer/cache/TileCache;",
            "Lorg/mapsforge/map/layer/queue/JobQueue<",
            "Lorg/mapsforge/map/layer/download/DownloadJob;",
            ">;",
            "Lorg/mapsforge/map/layer/Layer;",
            "Lorg/mapsforge/core/graphics/GraphicFactory;",
            "Lorg/mapsforge/map/model/DisplayModel;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Lorg/mapsforge/map/util/PausableThread;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    iput-object p2, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    iput-object p3, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->layer:Lorg/mapsforge/map/layer/Layer;

    iput-object p4, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iput-object p5, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    return-void
.end method

.method private downloadTile(Lorg/mapsforge/map/layer/download/DownloadJob;)V
    .registers 5

    new-instance v0, Lorg/mapsforge/map/layer/download/TileDownloader;

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-direct {v0, p1, v1}, Lorg/mapsforge/map/layer/download/TileDownloader;-><init>(Lorg/mapsforge/map/layer/download/DownloadJob;Lorg/mapsforge/core/graphics/GraphicFactory;)V

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/download/TileDownloader;->downloadImage()Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Thread;->isInterrupted()Z

    move-result v1

    if-nez v1, :cond_2c

    if-eqz v0, :cond_2c

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v1

    iget-object v2, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v2

    invoke-interface {v0, v1, v2}, Lorg/mapsforge/core/graphics/Bitmap;->scaleTo(II)V

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v1, p1, v0}, Lorg/mapsforge/map/layer/cache/TileCache;->put(Lorg/mapsforge/map/layer/queue/Job;Lorg/mapsforge/core/graphics/TileBitmap;)V

    iget-object p1, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->layer:Lorg/mapsforge/map/layer/Layer;

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/Layer;->requestRedraw()V

    :cond_2c
    return-void
.end method


# virtual methods
.method protected doWork()V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/queue/JobQueue;->get()Lorg/mapsforge/map/layer/queue/Job;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/map/layer/download/DownloadJob;

    :try_start_8
    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v1, v0}, Lorg/mapsforge/map/layer/cache/TileCache;->containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z

    move-result v1

    if-nez v1, :cond_13

    invoke-direct {p0, v0}, Lorg/mapsforge/map/layer/download/TileDownloadThread;->downloadTile(Lorg/mapsforge/map/layer/download/DownloadJob;)V
    :try_end_13
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_13} :catch_1b
    .catchall {:try_start_8 .. :try_end_13} :catchall_19

    :cond_13
    :goto_13
    iget-object v1, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/layer/queue/JobQueue;->remove(Lorg/mapsforge/map/layer/queue/Job;)V

    goto :goto_28

    :catchall_19
    move-exception v1

    goto :goto_29

    :catch_1b
    move-exception v1

    :try_start_1c
    sget-object v2, Lorg/mapsforge/map/layer/download/TileDownloadThread;->LOGGER:Ljava/util/logging/Logger;

    sget-object v3, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    invoke-virtual {v1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4, v1}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_27
    .catchall {:try_start_1c .. :try_end_27} :catchall_19

    goto :goto_13

    :goto_28
    return-void

    :goto_29
    iget-object v2, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    invoke-virtual {v2, v0}, Lorg/mapsforge/map/layer/queue/JobQueue;->remove(Lorg/mapsforge/map/layer/queue/Job;)V

    throw v1
.end method

.method protected getThreadPriority()Lorg/mapsforge/map/util/PausableThread$ThreadPriority;
    .registers 2

    sget-object v0, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->BELOW_NORMAL:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    return-object v0
.end method

.method protected hasWork()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method

.method public setJobQueue(Lorg/mapsforge/map/layer/queue/JobQueue;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/layer/queue/JobQueue<",
            "Lorg/mapsforge/map/layer/download/DownloadJob;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/TileDownloadThread;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    return-void
.end method
