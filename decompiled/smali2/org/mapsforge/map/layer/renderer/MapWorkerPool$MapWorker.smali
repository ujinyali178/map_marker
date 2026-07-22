.class Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/layer/renderer/MapWorkerPool;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MapWorker"
.end annotation


# instance fields
.field private final rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

.field final synthetic this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;


# direct methods
.method constructor <init>(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;Lorg/mapsforge/map/layer/renderer/RendererJob;)V
    .registers 3

    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object p1, p2, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    invoke-virtual {p1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;->incrementRefCount()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 11

    const/4 v0, 0x0

    :try_start_1
    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->inShutdown:Z
    invoke-static {v1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$000(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Z

    move-result v1
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_10f

    if-eqz v1, :cond_1c

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v0, v0, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    invoke-virtual {v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;->decrementRefCount()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;
    invoke-static {v0}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$800(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Lorg/mapsforge/map/layer/queue/JobQueue;

    move-result-object v0

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/layer/queue/JobQueue;->remove(Lorg/mapsforge/map/layer/queue/Job;)V

    return-void

    :cond_1c
    :try_start_1c
    sget-boolean v1, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->DEBUG_TIMING:Z

    const-wide/16 v2, 0x0

    if-eqz v1, :cond_49

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->LOGGER:Ljava/util/logging/Logger;
    invoke-static {}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$200()Ljava/util/logging/Logger;

    move-result-object v1

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "ConcurrentJobs "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v7, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->concurrentJobs:Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-static {v7}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$100(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Ljava/util/logging/Logger;->info(Ljava/lang/String;)V

    goto :goto_4a

    :cond_49
    move-wide v4, v2

    :goto_4a
    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->databaseRenderer:Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;
    invoke-static {v1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$300(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;

    move-result-object v1

    iget-object v6, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    invoke-virtual {v1, v6}, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->executeJob(Lorg/mapsforge/map/layer/renderer/RendererJob;)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object v0

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->inShutdown:Z
    invoke-static {v1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$000(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Z

    move-result v1
    :try_end_5c
    .catchall {:try_start_1c .. :try_end_5c} :catchall_10f

    if-eqz v1, :cond_76

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    invoke-virtual {v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;->decrementRefCount()V

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;
    invoke-static {v1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$800(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Lorg/mapsforge/map/layer/queue/JobQueue;

    move-result-object v1

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    invoke-virtual {v1, v2}, Lorg/mapsforge/map/layer/queue/JobQueue;->remove(Lorg/mapsforge/map/layer/queue/Job;)V

    if-eqz v0, :cond_75

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    :cond_75
    return-void

    :cond_76
    :try_start_76
    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-boolean v1, v1, Lorg/mapsforge/map/layer/renderer/RendererJob;->labelsOnly:Z

    if-nez v1, :cond_96

    if-eqz v0, :cond_96

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;
    invoke-static {v1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$400(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Lorg/mapsforge/map/layer/cache/TileCache;

    move-result-object v1

    iget-object v6, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    invoke-interface {v1, v6, v0}, Lorg/mapsforge/map/layer/cache/TileCache;->put(Lorg/mapsforge/map/layer/queue/Job;Lorg/mapsforge/core/graphics/TileBitmap;)V

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->databaseRenderer:Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;
    invoke-static {v1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$300(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;

    move-result-object v1

    iget-object v6, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v6, v6, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v1, v6}, Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;->removeTileInProgress(Lorg/mapsforge/core/model/Tile;)V

    :cond_96
    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->layer:Lorg/mapsforge/map/layer/Layer;
    invoke-static {v1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$500(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Lorg/mapsforge/map/layer/Layer;

    move-result-object v1

    invoke-virtual {v1}, Lorg/mapsforge/map/layer/Layer;->requestRedraw()V

    sget-boolean v1, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->DEBUG_TIMING:Z

    if-eqz v1, :cond_f7

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->totalExecutions:Ljava/util/concurrent/atomic/AtomicLong;
    invoke-static {v1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$600(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Ljava/util/concurrent/atomic/AtomicLong;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicLong;->incrementAndGet()J

    move-result-wide v8

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->totalTime:Ljava/util/concurrent/atomic/AtomicLong;
    invoke-static {v1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$700(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Ljava/util/concurrent/atomic/AtomicLong;

    move-result-object v1

    sub-long/2addr v6, v4

    invoke-virtual {v1, v6, v7}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    move-result-wide v4

    const-wide/16 v6, 0xa

    rem-long v6, v8, v6

    cmp-long v1, v6, v2

    if-nez v1, :cond_ee

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->LOGGER:Ljava/util/logging/Logger;
    invoke-static {}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$200()Ljava/util/logging/Logger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "TIMING "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    div-long/2addr v4, v8

    long-to-double v3, v4

    invoke-static {v3, v4}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/logging/Logger;->info(Ljava/lang/String;)V

    :cond_ee
    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->concurrentJobs:Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-static {v1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$100(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I
    :try_end_f7
    .catchall {:try_start_76 .. :try_end_f7} :catchall_10f

    :cond_f7
    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    invoke-virtual {v1}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;->decrementRefCount()V

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;
    invoke-static {v1}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$800(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Lorg/mapsforge/map/layer/queue/JobQueue;

    move-result-object v1

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    invoke-virtual {v1, v2}, Lorg/mapsforge/map/layer/queue/JobQueue;->remove(Lorg/mapsforge/map/layer/queue/Job;)V

    if-eqz v0, :cond_10e

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    :cond_10e
    return-void

    :catchall_10f
    move-exception v1

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v2, v2, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    invoke-virtual {v2}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;->decrementRefCount()V

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->this$0:Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    # getter for: Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;
    invoke-static {v2}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->access$800(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Lorg/mapsforge/map/layer/queue/JobQueue;

    move-result-object v2

    iget-object v3, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    invoke-virtual {v2, v3}, Lorg/mapsforge/map/layer/queue/JobQueue;->remove(Lorg/mapsforge/map/layer/queue/Job;)V

    if-eqz v0, :cond_127

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    :cond_127
    throw v1
.end method
