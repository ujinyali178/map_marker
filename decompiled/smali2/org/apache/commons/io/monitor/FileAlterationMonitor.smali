.class public final Lorg/apache/commons/io/monitor/FileAlterationMonitor;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final interval:J

.field private final observers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/apache/commons/io/monitor/FileAlterationObserver;",
            ">;"
        }
    .end annotation
.end field

.field private volatile running:Z

.field private thread:Ljava/lang/Thread;

.field private threadFactory:Ljava/util/concurrent/ThreadFactory;


# direct methods
.method public constructor <init>()V
    .registers 3

    const-wide/16 v0, 0x2710

    invoke-direct {p0, v0, v1}, Lorg/apache/commons/io/monitor/FileAlterationMonitor;-><init>(J)V

    return-void
.end method

.method public constructor <init>(J)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->observers:Ljava/util/List;

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->thread:Ljava/lang/Thread;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->running:Z

    iput-wide p1, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->interval:J

    return-void
.end method

.method public varargs constructor <init>(J[Lorg/apache/commons/io/monitor/FileAlterationObserver;)V
    .registers 5

    invoke-direct {p0, p1, p2}, Lorg/apache/commons/io/monitor/FileAlterationMonitor;-><init>(J)V

    if-eqz p3, :cond_11

    array-length p1, p3

    const/4 p2, 0x0

    :goto_7
    if-ge p2, p1, :cond_11

    aget-object v0, p3, p2

    invoke-virtual {p0, v0}, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->addObserver(Lorg/apache/commons/io/monitor/FileAlterationObserver;)V

    add-int/lit8 p2, p2, 0x1

    goto :goto_7

    :cond_11
    return-void
.end method


# virtual methods
.method public addObserver(Lorg/apache/commons/io/monitor/FileAlterationObserver;)V
    .registers 3

    if-eqz p1, :cond_7

    iget-object v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->observers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_7
    return-void
.end method

.method public getInterval()J
    .registers 3

    iget-wide v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->interval:J

    return-wide v0
.end method

.method public getObservers()Ljava/lang/Iterable;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Iterable<",
            "Lorg/apache/commons/io/monitor/FileAlterationObserver;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->observers:Ljava/util/List;

    return-object v0
.end method

.method public removeObserver(Lorg/apache/commons/io/monitor/FileAlterationObserver;)V
    .registers 3

    if-eqz p1, :cond_b

    :goto_2
    iget-object v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->observers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    goto :goto_2

    :cond_b
    return-void
.end method

.method public run()V
    .registers 3

    :goto_0
    iget-boolean v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->running:Z

    if-eqz v0, :cond_27

    iget-object v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->observers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/apache/commons/io/monitor/FileAlterationObserver;

    invoke-virtual {v1}, Lorg/apache/commons/io/monitor/FileAlterationObserver;->checkAndNotify()V

    goto :goto_a

    :cond_1a
    iget-boolean v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->running:Z

    if-nez v0, :cond_1f

    goto :goto_27

    :cond_1f
    :try_start_1f
    iget-wide v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->interval:J

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_24
    .catch Ljava/lang/InterruptedException; {:try_start_1f .. :try_end_24} :catch_25

    goto :goto_0

    :catch_25
    nop

    goto :goto_0

    :cond_27
    :goto_27
    return-void
.end method

.method public declared-synchronized setThreadFactory(Ljava/util/concurrent/ThreadFactory;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->threadFactory:Ljava/util/concurrent/ThreadFactory;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized start()V
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->running:Z

    if-nez v0, :cond_36

    iget-object v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->observers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1b

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/apache/commons/io/monitor/FileAlterationObserver;

    invoke-virtual {v1}, Lorg/apache/commons/io/monitor/FileAlterationObserver;->initialize()V

    goto :goto_b

    :cond_1b
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->running:Z

    iget-object v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->threadFactory:Ljava/util/concurrent/ThreadFactory;

    if-eqz v0, :cond_29

    invoke-interface {v0, p0}, Ljava/util/concurrent/ThreadFactory;->newThread(Ljava/lang/Runnable;)Ljava/lang/Thread;

    move-result-object v0

    :goto_26
    iput-object v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->thread:Ljava/lang/Thread;

    goto :goto_2f

    :cond_29
    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, p0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    goto :goto_26

    :goto_2f
    iget-object v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->thread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V
    :try_end_34
    .catchall {:try_start_1 .. :try_end_34} :catchall_3e

    monitor-exit p0

    return-void

    :cond_36
    :try_start_36
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Monitor is already running"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_3e
    .catchall {:try_start_36 .. :try_end_3e} :catchall_3e

    :catchall_3e
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized stop()V
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-wide v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->interval:J

    invoke-virtual {p0, v0, v1}, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->stop(J)V
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    monitor-exit p0

    return-void

    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized stop(J)V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->running:Z

    if-eqz v0, :cond_2d

    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->running:Z
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_35

    :try_start_8
    iget-object v0, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->thread:Ljava/lang/Thread;

    invoke-virtual {v0, p1, p2}, Ljava/lang/Thread;->join(J)V
    :try_end_d
    .catch Ljava/lang/InterruptedException; {:try_start_8 .. :try_end_d} :catch_e
    .catchall {:try_start_8 .. :try_end_d} :catchall_35

    goto :goto_15

    :catch_e
    :try_start_e
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Thread;->interrupt()V

    :goto_15
    iget-object p1, p0, Lorg/apache/commons/io/monitor/FileAlterationMonitor;->observers:Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1b
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_2b

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lorg/apache/commons/io/monitor/FileAlterationObserver;

    invoke-virtual {p2}, Lorg/apache/commons/io/monitor/FileAlterationObserver;->destroy()V
    :try_end_2a
    .catchall {:try_start_e .. :try_end_2a} :catchall_35

    goto :goto_1b

    :cond_2b
    monitor-exit p0

    return-void

    :cond_2d
    :try_start_2d
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "Monitor is not running"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
    :try_end_35
    .catchall {:try_start_2d .. :try_end_35} :catchall_35

    :catchall_35
    move-exception p1

    monitor-exit p0

    throw p1
.end method
