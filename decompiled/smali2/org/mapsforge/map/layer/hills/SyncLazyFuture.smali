.class public abstract Lorg/mapsforge/map/layer/hills/SyncLazyFuture;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/concurrent/Future;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/layer/hills/SyncLazyFuture$DummyExecutionException;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<X:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Future<",
        "TX;>;"
    }
.end annotation


# static fields
.field private static final CANCELLED:Ljava/util/concurrent/ExecutionException;

.field private static final DONE:Ljava/util/concurrent/ExecutionException;

.field private static final STARTED:Ljava/util/concurrent/ExecutionException;


# instance fields
.field private volatile result:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TX;"
        }
    .end annotation
.end field

.field private volatile state:Ljava/util/concurrent/ExecutionException;

.field private volatile thread:Ljava/lang/Thread;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture$DummyExecutionException;

    const-string v1, "started"

    invoke-direct {v0, v1}, Lorg/mapsforge/map/layer/hills/SyncLazyFuture$DummyExecutionException;-><init>(Ljava/lang/String;)V

    sput-object v0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    new-instance v0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture$DummyExecutionException;

    const-string v1, "cancelled"

    invoke-direct {v0, v1}, Lorg/mapsforge/map/layer/hills/SyncLazyFuture$DummyExecutionException;-><init>(Ljava/lang/String;)V

    sput-object v0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->CANCELLED:Ljava/util/concurrent/ExecutionException;

    new-instance v0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture$DummyExecutionException;

    const-string v1, "done"

    invoke-direct {v0, v1}, Lorg/mapsforge/map/layer/hills/SyncLazyFuture$DummyExecutionException;-><init>(Ljava/lang/String;)V

    sput-object v0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->DONE:Ljava/util/concurrent/ExecutionException;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    return-void
.end method

.method static synthetic access$000(Lorg/mapsforge/map/layer/hills/SyncLazyFuture;)V
    .registers 1

    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->internalCalc()V

    return-void
.end method

.method private internalCalc()V
    .registers 4

    sget-object v0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    const/4 v0, 0x0

    :try_start_5
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    iput-object v1, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->thread:Ljava/lang/Thread;

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->calculate()Ljava/lang/Object;

    move-result-object v1

    iput-object v1, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->result:Ljava/lang/Object;

    sget-object v1, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->DONE:Ljava/util/concurrent/ExecutionException;

    iput-object v1, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;
    :try_end_15
    .catch Ljava/lang/RuntimeException; {:try_start_5 .. :try_end_15} :catch_1e
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_5 .. :try_end_15} :catch_18
    .catchall {:try_start_5 .. :try_end_15} :catchall_16

    goto :goto_1b

    :catchall_16
    move-exception v1

    goto :goto_28

    :catch_18
    move-exception v1

    :try_start_19
    iput-object v1, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;
    :try_end_1b
    .catchall {:try_start_19 .. :try_end_1b} :catchall_16

    :goto_1b
    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->thread:Ljava/lang/Thread;

    goto :goto_27

    :catch_1e
    move-exception v1

    :try_start_1f
    new-instance v2, Ljava/util/concurrent/ExecutionException;

    invoke-direct {v2, v1}, Ljava/util/concurrent/ExecutionException;-><init>(Ljava/lang/Throwable;)V

    iput-object v2, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;
    :try_end_26
    .catchall {:try_start_1f .. :try_end_26} :catchall_16

    goto :goto_1b

    :goto_27
    return-void

    :goto_28
    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->thread:Ljava/lang/Thread;

    throw v1
.end method

.method private throwIfException()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    if-eqz v0, :cond_a

    instance-of v1, v0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture$DummyExecutionException;

    if-eqz v1, :cond_9

    goto :goto_a

    :cond_9
    throw v0

    :cond_a
    :goto_a
    return-void
.end method


# virtual methods
.method protected abstract calculate()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TX;"
        }
    .end annotation
.end method

.method public cancel(Z)Z
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    sget-object v1, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->CANCELLED:Ljava/util/concurrent/ExecutionException;

    const/4 v2, 0x1

    if-ne v0, v1, :cond_8

    return v2

    :cond_8
    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    sget-object v3, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->DONE:Ljava/util/concurrent/ExecutionException;

    const/4 v4, 0x0

    if-ne v0, v3, :cond_10

    return v4

    :cond_10
    if-eqz p1, :cond_22

    iget-object p1, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->thread:Ljava/lang/Thread;

    if-eqz p1, :cond_22

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    sget-object v3, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    if-ne v0, v3, :cond_22

    iput-object v1, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    invoke-virtual {p1}, Ljava/lang/Thread;->interrupt()V

    return v2

    :cond_22
    iget-object p1, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    if-nez p1, :cond_27

    goto :goto_28

    :cond_27
    const/4 v2, 0x0

    :goto_28
    iput-object v1, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    return v2
.end method

.method public get()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TX;"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    if-nez v0, :cond_c

    sget-object v0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->internalCalc()V

    :cond_c
    monitor-exit p0
    :try_end_d
    .catchall {:try_start_1 .. :try_end_d} :catchall_13

    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->throwIfException()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->result:Ljava/lang/Object;

    return-object v0

    :catchall_13
    move-exception v0

    :try_start_14
    monitor-exit p0
    :try_end_15
    .catchall {:try_start_14 .. :try_end_15} :catchall_13

    throw v0
.end method

.method public get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/concurrent/TimeUnit;",
            ")TX;"
        }
    .end annotation

    invoke-virtual {p0}, Ljava/lang/Object;->wait()V

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->get()Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public isCancelled()Z
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    sget-object v1, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->CANCELLED:Ljava/util/concurrent/ExecutionException;

    if-ne v0, v1, :cond_8

    const/4 v0, 0x1

    goto :goto_9

    :cond_8
    const/4 v0, 0x0

    :goto_9
    return v0
.end method

.method public isDone()Z
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    if-eqz v0, :cond_c

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    sget-object v1, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    if-eq v0, v1, :cond_c

    const/4 v0, 0x1

    goto :goto_d

    :cond_c
    const/4 v0, 0x0

    :goto_d
    return v0
.end method

.method public withRunningThread()Lorg/mapsforge/map/layer/hills/SyncLazyFuture;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lorg/mapsforge/map/layer/hills/SyncLazyFuture<",
            "TX;>;"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture;->state:Ljava/util/concurrent/ExecutionException;

    if-eqz v0, :cond_5

    return-object p0

    :cond_5
    new-instance v0, Lorg/mapsforge/map/layer/hills/SyncLazyFuture$1;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ".withRunningThread"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lorg/mapsforge/map/layer/hills/SyncLazyFuture$1;-><init>(Lorg/mapsforge/map/layer/hills/SyncLazyFuture;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    return-object p0
.end method
