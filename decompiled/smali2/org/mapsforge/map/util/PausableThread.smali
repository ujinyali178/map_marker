.class public abstract Lorg/mapsforge/map/util/PausableThread;
.super Ljava/lang/Thread;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/util/PausableThread$ThreadPriority;
    }
.end annotation


# instance fields
.field private pausing:Z

.field private shouldPause:Z

.field private shouldStop:Z

.field protected waitForWork:Z


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method protected afterRun()V
    .registers 1

    return-void
.end method

.method public final awaitPausing()V
    .registers 3

    monitor-enter p0

    :goto_1
    :try_start_1
    invoke-virtual {p0}, Ljava/lang/Thread;->isInterrupted()Z

    move-result v0

    if-nez v0, :cond_1b

    invoke-virtual {p0}, Lorg/mapsforge/map/util/PausableThread;->isPausing()Z

    move-result v0
    :try_end_b
    .catchall {:try_start_1 .. :try_end_b} :catchall_1d

    if-nez v0, :cond_1b

    const-wide/16 v0, 0x64

    :try_start_f
    invoke-virtual {p0, v0, v1}, Ljava/lang/Object;->wait(J)V
    :try_end_12
    .catch Ljava/lang/InterruptedException; {:try_start_f .. :try_end_12} :catch_13
    .catchall {:try_start_f .. :try_end_12} :catchall_1d

    goto :goto_1

    :catch_13
    :try_start_13
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    goto :goto_1

    :cond_1b
    monitor-exit p0

    return-void

    :catchall_1d
    move-exception v0

    monitor-exit p0
    :try_end_1f
    .catchall {:try_start_13 .. :try_end_1f} :catchall_1d

    throw v0
.end method

.method protected abstract doWork()V
.end method

.method public final declared-synchronized finish()V
    .registers 2

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    iput-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->shouldStop:Z

    invoke-virtual {p0}, Lorg/mapsforge/map/util/PausableThread;->interrupt()V
    :try_end_7
    .catchall {:try_start_2 .. :try_end_7} :catchall_9

    monitor-exit p0

    return-void

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected abstract getThreadPriority()Lorg/mapsforge/map/util/PausableThread$ThreadPriority;
.end method

.method protected abstract hasWork()Z
.end method

.method public interrupt()V
    .registers 2

    monitor-enter p0

    :try_start_1
    invoke-super {p0}, Ljava/lang/Thread;->interrupt()V

    monitor-exit p0

    return-void

    :catchall_6
    move-exception v0

    monitor-exit p0
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_6

    throw v0
.end method

.method public final declared-synchronized isPausing()Z
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->pausing:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized pause()V
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->shouldPause:Z

    if-nez v0, :cond_b

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->shouldPause:Z

    invoke-virtual {p0}, Ljava/lang/Object;->notify()V
    :try_end_b
    .catchall {:try_start_1 .. :try_end_b} :catchall_d

    :cond_b
    monitor-exit p0

    return-void

    :catchall_d
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized proceed()V
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->shouldPause:Z

    if-eqz v0, :cond_d

    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->shouldPause:Z

    iput-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->pausing:Z

    invoke-virtual {p0}, Ljava/lang/Object;->notify()V
    :try_end_d
    .catchall {:try_start_1 .. :try_end_d} :catchall_f

    :cond_d
    monitor-exit p0

    return-void

    :catchall_f
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final run()V
    .registers 2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Ljava/lang/Thread;->setName(Ljava/lang/String;)V

    invoke-virtual {p0}, Lorg/mapsforge/map/util/PausableThread;->getThreadPriority()Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    move-result-object v0

    iget v0, v0, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->priority:I

    invoke-virtual {p0, v0}, Ljava/lang/Thread;->setPriority(I)V

    :goto_14
    iget-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->shouldStop:Z

    if-nez v0, :cond_1e

    invoke-virtual {p0}, Ljava/lang/Thread;->isInterrupted()Z

    move-result v0

    if-eqz v0, :cond_28

    :cond_1e
    iget-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->waitForWork:Z

    if-eqz v0, :cond_6d

    invoke-virtual {p0}, Lorg/mapsforge/map/util/PausableThread;->hasWork()Z

    move-result v0

    if-eqz v0, :cond_6d

    :cond_28
    monitor-enter p0

    :goto_29
    :try_start_29
    iget-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->shouldStop:Z

    if-nez v0, :cond_4c

    invoke-virtual {p0}, Ljava/lang/Thread;->isInterrupted()Z

    move-result v0

    if-nez v0, :cond_4c

    iget-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->shouldPause:Z

    if-nez v0, :cond_3d

    invoke-virtual {p0}, Lorg/mapsforge/map/util/PausableThread;->hasWork()Z

    move-result v0
    :try_end_3b
    .catchall {:try_start_29 .. :try_end_3b} :catchall_6a

    if-nez v0, :cond_4c

    :cond_3d
    :try_start_3d
    iget-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->shouldPause:Z

    if-eqz v0, :cond_44

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->pausing:Z

    :cond_44
    invoke-virtual {p0}, Ljava/lang/Object;->wait()V
    :try_end_47
    .catch Ljava/lang/InterruptedException; {:try_start_3d .. :try_end_47} :catch_48
    .catchall {:try_start_3d .. :try_end_47} :catchall_6a

    goto :goto_29

    :catch_48
    :try_start_48
    invoke-virtual {p0}, Lorg/mapsforge/map/util/PausableThread;->interrupt()V

    goto :goto_29

    :cond_4c
    monitor-exit p0
    :try_end_4d
    .catchall {:try_start_48 .. :try_end_4d} :catchall_6a

    iget-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->shouldStop:Z

    if-nez v0, :cond_57

    invoke-virtual {p0}, Ljava/lang/Thread;->isInterrupted()Z

    move-result v0

    if-eqz v0, :cond_62

    :cond_57
    iget-boolean v0, p0, Lorg/mapsforge/map/util/PausableThread;->waitForWork:Z

    if-eqz v0, :cond_6d

    invoke-virtual {p0}, Lorg/mapsforge/map/util/PausableThread;->hasWork()Z

    move-result v0

    if-nez v0, :cond_62

    goto :goto_6d

    :cond_62
    :try_start_62
    invoke-virtual {p0}, Lorg/mapsforge/map/util/PausableThread;->doWork()V
    :try_end_65
    .catch Ljava/lang/InterruptedException; {:try_start_62 .. :try_end_65} :catch_66

    goto :goto_14

    :catch_66
    invoke-virtual {p0}, Lorg/mapsforge/map/util/PausableThread;->interrupt()V

    goto :goto_14

    :catchall_6a
    move-exception v0

    :try_start_6b
    monitor-exit p0
    :try_end_6c
    .catchall {:try_start_6b .. :try_end_6c} :catchall_6a

    throw v0

    :cond_6d
    :goto_6d
    invoke-virtual {p0}, Lorg/mapsforge/map/util/PausableThread;->afterRun()V

    return-void
.end method
