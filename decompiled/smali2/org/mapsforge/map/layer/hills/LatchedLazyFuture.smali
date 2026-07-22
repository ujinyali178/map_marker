.class public abstract Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/concurrent/Future;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$DummyExecutionException;
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
.field private final latch:Ljava/util/concurrent/CountDownLatch;

.field private volatile result:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TX;"
        }
    .end annotation
.end field

.field private final state:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Ljava/util/concurrent/ExecutionException;",
            ">;"
        }
    .end annotation
.end field

.field private volatile thread:Ljava/lang/Thread;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$DummyExecutionException;

    const-string v1, "started"

    invoke-direct {v0, v1}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$DummyExecutionException;-><init>(Ljava/lang/String;)V

    sput-object v0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    new-instance v0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$DummyExecutionException;

    const-string v1, "cancelled"

    invoke-direct {v0, v1}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$DummyExecutionException;-><init>(Ljava/lang/String;)V

    sput-object v0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->CANCELLED:Ljava/util/concurrent/ExecutionException;

    new-instance v0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$DummyExecutionException;

    const-string v1, "done"

    invoke-direct {v0, v1}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$DummyExecutionException;-><init>(Ljava/lang/String;)V

    sput-object v0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->DONE:Ljava/util/concurrent/ExecutionException;

    return-void
.end method

.method public constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->latch:Ljava/util/concurrent/CountDownLatch;

    return-void
.end method

.method static synthetic access$000(Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;)V
    .registers 1

    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->internalCalc()V

    return-void
.end method

.method private internalCalc()V
    .registers 6

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->thread:Ljava/lang/Thread;

    const/4 v0, 0x0

    :try_start_7
    invoke-virtual {p0}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->calculate()Ljava/lang/Object;

    move-result-object v1

    iput-object v1, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->result:Ljava/lang/Object;

    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v2, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    sget-object v3, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->DONE:Ljava/util/concurrent/ExecutionException;

    invoke-static {v1, v2, v3}, Lcom/google/android/gms/common/api/internal/a;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z
    :try_end_16
    .catch Ljava/lang/RuntimeException; {:try_start_7 .. :try_end_16} :catch_29
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_7 .. :try_end_16} :catch_19
    .catchall {:try_start_7 .. :try_end_16} :catchall_17

    goto :goto_21

    :catchall_17
    move-exception v1

    goto :goto_38

    :catch_19
    move-exception v1

    :try_start_1a
    iget-object v2, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v3, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    invoke-static {v2, v3, v1}, Lcom/google/android/gms/common/api/internal/a;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z
    :try_end_21
    .catchall {:try_start_1a .. :try_end_21} :catchall_17

    :goto_21
    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->thread:Ljava/lang/Thread;

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_37

    :catch_29
    move-exception v1

    :try_start_2a
    iget-object v2, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v3, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    new-instance v4, Ljava/util/concurrent/ExecutionException;

    invoke-direct {v4, v1}, Ljava/util/concurrent/ExecutionException;-><init>(Ljava/lang/Throwable;)V

    invoke-static {v2, v3, v4}, Lcom/google/android/gms/common/api/internal/a;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z
    :try_end_36
    .catchall {:try_start_2a .. :try_end_36} :catchall_17

    goto :goto_21

    :goto_37
    return-void

    :goto_38
    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->thread:Ljava/lang/Thread;

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v1
.end method

.method private throwIfException()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/ExecutionException;

    if-eqz v0, :cond_10

    instance-of v1, v0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$DummyExecutionException;

    if-eqz v1, :cond_f

    goto :goto_10

    :cond_f
    throw v0

    :cond_10
    :goto_10
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
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->CANCELLED:Ljava/util/concurrent/ExecutionException;

    const/4 v2, 0x1

    if-ne v0, v1, :cond_c

    return v2

    :cond_c
    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v3, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->DONE:Ljava/util/concurrent/ExecutionException;

    if-ne v0, v3, :cond_18

    const/4 p1, 0x0

    return p1

    :cond_18
    if-eqz p1, :cond_2c

    iget-object p1, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->thread:Ljava/lang/Thread;

    if-eqz p1, :cond_2c

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v3, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    invoke-static {v0, v3, v1}, Lcom/google/android/gms/common/api/internal/a;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2c

    invoke-virtual {p1}, Ljava/lang/Thread;->interrupt()V

    return v2

    :cond_2c
    iget-object p1, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v0, 0x0

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/common/api/internal/a;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public get()Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TX;"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    const/4 v2, 0x0

    invoke-static {v0, v2, v1}, Lcom/google/android/gms/common/api/internal/a;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->internalCalc()V

    goto :goto_14

    :cond_f
    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->await()V

    :goto_14
    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->throwIfException()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->result:Ljava/lang/Object;

    return-object v0
.end method

.method public get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/concurrent/TimeUnit;",
            ")TX;"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    sget-object v1, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    const/4 v2, 0x0

    invoke-static {v0, v2, v1}, Lcom/google/android/gms/common/api/internal/a;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->internalCalc()V

    goto :goto_14

    :cond_f
    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0, p1, p2, p3}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    :goto_14
    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->throwIfException()V

    iget-object p1, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->result:Ljava/lang/Object;

    return-object p1
.end method

.method public isCancelled()Z
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->CANCELLED:Ljava/util/concurrent/ExecutionException;

    if-ne v0, v1, :cond_c

    const/4 v0, 0x1

    goto :goto_d

    :cond_c
    const/4 v0, 0x0

    :goto_d
    return v0
.end method

.method public isDone()Z
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/ExecutionException;

    if-eqz v0, :cond_10

    sget-object v1, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    if-eq v0, v1, :cond_10

    const/4 v0, 0x1

    goto :goto_11

    :cond_10
    const/4 v0, 0x0

    :goto_11
    return v0
.end method

.method public withRunningThread()Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lorg/mapsforge/map/layer/hills/LatchedLazyFuture<",
            "TX;>;"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->DONE:Ljava/util/concurrent/ExecutionException;

    if-ne v0, v1, :cond_b

    return-object p0

    :cond_b
    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->state:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v1, 0x0

    sget-object v2, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->STARTED:Ljava/util/concurrent/ExecutionException;

    invoke-static {v0, v1, v2}, Lcom/google/android/gms/common/api/internal/a;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_37

    new-instance v0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$1;

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

    invoke-direct {v0, p0, v1}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$1;-><init>(Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    :cond_37
    return-object p0
.end method
