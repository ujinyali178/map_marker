.class public Lorg/mapsforge/map/layer/queue/JobQueue;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lorg/mapsforge/map/layer/queue/Job;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field private static final QUEUE_CAPACITY:I = 0x80


# instance fields
.field private final assignedJobs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation
.end field

.field private final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field private isInterrupted:Z

.field private final mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

.field private final queueItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/map/layer/queue/QueueItem<",
            "TT;>;>;"
        }
    .end annotation
.end field

.field private scheduleNeeded:Z


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->assignedJobs:Ljava/util/List;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->queueItems:Ljava/util/List;

    iput-object p1, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    iput-object p2, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    return-void
.end method

.method private schedule(I)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->queueItems:Ljava/util/List;

    iget-object v1, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v1}, Lorg/mapsforge/map/model/IMapViewPosition;->getMapPosition()Lorg/mapsforge/core/model/MapPosition;

    move-result-object v1

    invoke-static {v0, v1, p1}, Lorg/mapsforge/map/layer/queue/QueueItemScheduler;->schedule(Ljava/util/Collection;Lorg/mapsforge/core/model/MapPosition;I)V

    iget-object p1, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->queueItems:Ljava/util/List;

    sget-object v0, Lorg/mapsforge/map/layer/queue/QueueItemComparator;->INSTANCE:Lorg/mapsforge/map/layer/queue/QueueItemComparator;

    invoke-static {p1, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    invoke-direct {p0}, Lorg/mapsforge/map/layer/queue/JobQueue;->trimToSize()V

    return-void
.end method

.method private trimToSize()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->queueItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    :goto_6
    const/16 v1, 0x80

    if-le v0, v1, :cond_12

    iget-object v1, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->queueItems:Ljava/util/List;

    add-int/lit8 v0, v0, -0x1

    invoke-interface {v1, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    goto :goto_6

    :cond_12
    return-void
.end method


# virtual methods
.method public declared-synchronized add(Lorg/mapsforge/map/layer/queue/Job;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->assignedJobs:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_21

    new-instance v0, Lorg/mapsforge/map/layer/queue/QueueItem;

    invoke-direct {v0, p1}, Lorg/mapsforge/map/layer/queue/QueueItem;-><init>(Lorg/mapsforge/map/layer/queue/Job;)V

    iget-object p1, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->queueItems:Ljava/util/List;

    invoke-interface {p1, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_21

    iget-object p1, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->queueItems:Ljava/util/List;

    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->scheduleNeeded:Z

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/queue/JobQueue;->notifyWorkers()V
    :try_end_21
    .catchall {:try_start_1 .. :try_end_21} :catchall_23

    :cond_21
    monitor-exit p0

    return-void

    :catchall_23
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized get()Lorg/mapsforge/map/layer/queue/Job;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    monitor-enter p0

    const v0, 0x7fffffff

    :try_start_4
    invoke-virtual {p0, v0}, Lorg/mapsforge/map/layer/queue/JobQueue;->get(I)Lorg/mapsforge/map/layer/queue/Job;

    move-result-object v0
    :try_end_8
    .catchall {:try_start_4 .. :try_end_8} :catchall_a

    monitor-exit p0

    return-object v0

    :catchall_a
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized get(I)Lorg/mapsforge/map/layer/queue/Job;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TT;"
        }
    .end annotation

    monitor-enter p0

    :cond_1
    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->queueItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_33

    iget-object v0, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->assignedJobs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lt v0, p1, :cond_13

    goto :goto_33

    :cond_13
    iget-boolean p1, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->scheduleNeeded:Z

    if-eqz p1, :cond_22

    iput-boolean v1, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->scheduleNeeded:Z

    iget-object p1, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {p1}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result p1

    invoke-direct {p0, p1}, Lorg/mapsforge/map/layer/queue/JobQueue;->schedule(I)V

    :cond_22
    iget-object p1, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->queueItems:Ljava/util/List;

    invoke-interface {p1, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/map/layer/queue/QueueItem;

    iget-object p1, p1, Lorg/mapsforge/map/layer/queue/QueueItem;->object:Lorg/mapsforge/map/layer/queue/Job;

    iget-object v0, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->assignedJobs:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_31
    .catchall {:try_start_1 .. :try_end_31} :catchall_41

    monitor-exit p0

    return-object p1

    :cond_33
    :goto_33
    const-wide/16 v2, 0xc8

    :try_start_35
    invoke-virtual {p0, v2, v3}, Ljava/lang/Object;->wait(J)V

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->isInterrupted:Z

    if-eqz v0, :cond_1

    iput-boolean v1, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->isInterrupted:Z
    :try_end_3e
    .catchall {:try_start_35 .. :try_end_3e} :catchall_41

    const/4 p1, 0x0

    monitor-exit p0

    return-object p1

    :catchall_41
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized interrupt()V
    .registers 2

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    iput-boolean v0, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->isInterrupted:Z

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/queue/JobQueue;->notifyWorkers()V
    :try_end_7
    .catchall {:try_start_2 .. :try_end_7} :catchall_9

    monitor-exit p0

    return-void

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized notifyWorkers()V
    .registers 2

    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_6

    monitor-exit p0

    return-void

    :catchall_6
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized remove(Lorg/mapsforge/map/layer/queue/Job;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->assignedJobs:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/queue/JobQueue;->notifyWorkers()V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-void

    :catchall_b
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized size()I
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/queue/JobQueue;->queueItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_9

    monitor-exit p0

    return v0

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method
