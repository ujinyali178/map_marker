.class public Lorg/mapsforge/map/layer/renderer/MapWorkerPool;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;
    }
.end annotation


# static fields
.field public static DEBUG_TIMING:Z

.field private static final LOGGER:Ljava/util/logging/Logger;


# instance fields
.field private final concurrentJobs:Ljava/util/concurrent/atomic/AtomicInteger;

.field private final databaseRenderer:Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;

.field private inShutdown:Z

.field private isRunning:Z

.field private final jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/mapsforge/map/layer/queue/JobQueue<",
            "Lorg/mapsforge/map/layer/renderer/RendererJob;",
            ">;"
        }
    .end annotation
.end field

.field private final layer:Lorg/mapsforge/map/layer/Layer;

.field private self:Ljava/util/concurrent/ExecutorService;

.field private final tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

.field private final totalExecutions:Ljava/util/concurrent/atomic/AtomicLong;

.field private final totalTime:Ljava/util/concurrent/atomic/AtomicLong;

.field private workers:Ljava/util/concurrent/ExecutorService;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->LOGGER:Ljava/util/logging/Logger;

    const/4 v0, 0x0

    sput-boolean v0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->DEBUG_TIMING:Z

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/layer/queue/JobQueue;Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;Lorg/mapsforge/map/layer/Layer;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/layer/cache/TileCache;",
            "Lorg/mapsforge/map/layer/queue/JobQueue<",
            "Lorg/mapsforge/map/layer/renderer/RendererJob;",
            ">;",
            "Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;",
            "Lorg/mapsforge/map/layer/Layer;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->concurrentJobs:Ljava/util/concurrent/atomic/AtomicInteger;

    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->totalExecutions:Ljava/util/concurrent/atomic/AtomicLong;

    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->totalTime:Ljava/util/concurrent/atomic/AtomicLong;

    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    iput-object p2, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    iput-object p3, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->databaseRenderer:Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;

    iput-object p4, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->layer:Lorg/mapsforge/map/layer/Layer;

    const/4 p1, 0x0

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->inShutdown:Z

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->isRunning:Z

    return-void
.end method

.method static synthetic access$000(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Z
    .registers 1

    iget-boolean p0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->inShutdown:Z

    return p0
.end method

.method static synthetic access$100(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Ljava/util/concurrent/atomic/AtomicInteger;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->concurrentJobs:Ljava/util/concurrent/atomic/AtomicInteger;

    return-object p0
.end method

.method static synthetic access$200()Ljava/util/logging/Logger;
    .registers 1

    sget-object v0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->LOGGER:Ljava/util/logging/Logger;

    return-object v0
.end method

.method static synthetic access$300(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->databaseRenderer:Lorg/mapsforge/map/layer/renderer/DatabaseRenderer;

    return-object p0
.end method

.method static synthetic access$400(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Lorg/mapsforge/map/layer/cache/TileCache;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    return-object p0
.end method

.method static synthetic access$500(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Lorg/mapsforge/map/layer/Layer;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->layer:Lorg/mapsforge/map/layer/Layer;

    return-object p0
.end method

.method static synthetic access$600(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Ljava/util/concurrent/atomic/AtomicLong;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->totalExecutions:Ljava/util/concurrent/atomic/AtomicLong;

    return-object p0
.end method

.method static synthetic access$700(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Ljava/util/concurrent/atomic/AtomicLong;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->totalTime:Ljava/util/concurrent/atomic/AtomicLong;

    return-object p0
.end method

.method static synthetic access$800(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;)Lorg/mapsforge/map/layer/queue/JobQueue;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    return-object p0
.end method


# virtual methods
.method public run()V
    .registers 5

    :goto_0
    :try_start_0
    iget-boolean v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->inShutdown:Z

    if-nez v0, :cond_41

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    sget v1, Lorg/mapsforge/core/util/Parameters;->NUMBER_OF_THREADS:I

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/layer/queue/JobQueue;->get(I)Lorg/mapsforge/map/layer/queue/Job;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/map/layer/renderer/RendererJob;

    if-nez v0, :cond_11

    goto :goto_0

    :cond_11
    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v1, v0}, Lorg/mapsforge/map/layer/cache/TileCache;->containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z

    move-result v1

    if-eqz v1, :cond_24

    iget-boolean v1, v0, Lorg/mapsforge/map/layer/renderer/RendererJob;->labelsOnly:Z

    if-eqz v1, :cond_1e

    goto :goto_24

    :cond_1e
    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/layer/queue/JobQueue;->remove(Lorg/mapsforge/map/layer/queue/Job;)V

    goto :goto_0

    :cond_24
    :goto_24
    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->workers:Ljava/util/concurrent/ExecutorService;

    new-instance v2, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;

    invoke-direct {v2, p0, v0}, Lorg/mapsforge/map/layer/renderer/MapWorkerPool$MapWorker;-><init>(Lorg/mapsforge/map/layer/renderer/MapWorkerPool;Lorg/mapsforge/map/layer/renderer/RendererJob;)V

    invoke-interface {v1, v2}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V
    :try_end_2e
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_2e} :catch_37
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_0 .. :try_end_2e} :catch_2f

    goto :goto_0

    :catch_2f
    move-exception v0

    sget-object v1, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->LOGGER:Ljava/util/logging/Logger;

    sget-object v2, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    const-string v3, "MapWorkerPool rejected"

    goto :goto_3e

    :catch_37
    move-exception v0

    sget-object v1, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->LOGGER:Ljava/util/logging/Logger;

    sget-object v2, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    const-string v3, "MapWorkerPool interrupted"

    :goto_3e
    invoke-virtual {v1, v2, v3, v0}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_41
    return-void
.end method

.method public declared-synchronized start()V
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->isRunning:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_22

    if-eqz v0, :cond_7

    monitor-exit p0

    return-void

    :cond_7
    const/4 v0, 0x0

    :try_start_8
    iput-boolean v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->inShutdown:Z

    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->self:Ljava/util/concurrent/ExecutorService;

    sget v0, Lorg/mapsforge/core/util/Parameters;->NUMBER_OF_THREADS:I

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->workers:Ljava/util/concurrent/ExecutorService;

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->self:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0, p0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->isRunning:Z
    :try_end_20
    .catchall {:try_start_8 .. :try_end_20} :catchall_22

    monitor-exit p0

    return-void

    :catchall_22
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized stop()V
    .registers 7

    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->isRunning:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_72

    if-nez v0, :cond_7

    monitor-exit p0

    return-void

    :cond_7
    const/4 v0, 0x1

    :try_start_8
    iput-boolean v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->inShutdown:Z

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/queue/JobQueue;->interrupt()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->self:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->shutdown()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->workers:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->shutdown()V
    :try_end_19
    .catchall {:try_start_8 .. :try_end_19} :catchall_72

    const-wide/16 v0, 0x64

    :try_start_1b
    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->self:Ljava/util/concurrent/ExecutorService;

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v2, v0, v1, v3}, Ljava/util/concurrent/ExecutorService;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v2

    if-nez v2, :cond_44

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->self:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v2}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->self:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v2, v0, v1, v3}, Ljava/util/concurrent/ExecutorService;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v2

    if-nez v2, :cond_44

    sget-object v2, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->LOGGER:Ljava/util/logging/Logger;

    const-string v3, "Shutdown self executor failed"

    invoke-virtual {v2, v3}, Ljava/util/logging/Logger;->fine(Ljava/lang/String;)V
    :try_end_39
    .catch Ljava/lang/InterruptedException; {:try_start_1b .. :try_end_39} :catch_3a
    .catchall {:try_start_1b .. :try_end_39} :catchall_72

    goto :goto_44

    :catch_3a
    move-exception v2

    :try_start_3b
    sget-object v3, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->LOGGER:Ljava/util/logging/Logger;

    sget-object v4, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    const-string v5, "Shutdown self executor interrupted"

    invoke-virtual {v3, v4, v5, v2}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_44
    .catchall {:try_start_3b .. :try_end_44} :catchall_72

    :cond_44
    :goto_44
    :try_start_44
    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->workers:Ljava/util/concurrent/ExecutorService;

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v2, v0, v1, v3}, Ljava/util/concurrent/ExecutorService;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v2

    if-nez v2, :cond_6d

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->workers:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v2}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->workers:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v2, v0, v1, v3}, Ljava/util/concurrent/ExecutorService;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-nez v0, :cond_6d

    sget-object v0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->LOGGER:Ljava/util/logging/Logger;

    const-string v1, "Shutdown workers executor failed"

    invoke-virtual {v0, v1}, Ljava/util/logging/Logger;->fine(Ljava/lang/String;)V
    :try_end_62
    .catch Ljava/lang/InterruptedException; {:try_start_44 .. :try_end_62} :catch_63
    .catchall {:try_start_44 .. :try_end_62} :catchall_72

    goto :goto_6d

    :catch_63
    move-exception v0

    :try_start_64
    sget-object v1, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->LOGGER:Ljava/util/logging/Logger;

    sget-object v2, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    const-string v3, "Shutdown workers executor interrupted"

    invoke-virtual {v1, v2, v3, v0}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_6d
    :goto_6d
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/mapsforge/map/layer/renderer/MapWorkerPool;->isRunning:Z
    :try_end_70
    .catchall {:try_start_64 .. :try_end_70} :catchall_72

    monitor-exit p0

    return-void

    :catchall_72
    move-exception v0

    monitor-exit p0

    throw v0
.end method
