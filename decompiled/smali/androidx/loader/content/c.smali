.class abstract Landroidx/loader/content/c;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/loader/content/c$e;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Result:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field private static h:Landroid/os/Handler;


# instance fields
.field private final c:Ljava/util/concurrent/FutureTask;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/FutureTask<",
            "TResult;>;"
        }
    .end annotation
.end field

.field private volatile d:Landroidx/loader/content/c$e;

.field final f:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final g:Ljava/util/concurrent/atomic/AtomicBoolean;


# direct methods
.method constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Landroidx/loader/content/c$e;->c:Landroidx/loader/content/c$e;

    iput-object v0, p0, Landroidx/loader/content/c;->d:Landroidx/loader/content/c$e;

    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object v0, p0, Landroidx/loader/content/c;->f:Ljava/util/concurrent/atomic/AtomicBoolean;

    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object v0, p0, Landroidx/loader/content/c;->g:Ljava/util/concurrent/atomic/AtomicBoolean;

    new-instance v0, Landroidx/loader/content/c$a;

    invoke-direct {v0, p0}, Landroidx/loader/content/c$a;-><init>(Landroidx/loader/content/c;)V

    new-instance v1, Landroidx/loader/content/c$b;

    invoke-direct {v1, p0, v0}, Landroidx/loader/content/c$b;-><init>(Landroidx/loader/content/c;Ljava/util/concurrent/Callable;)V

    iput-object v1, p0, Landroidx/loader/content/c;->c:Ljava/util/concurrent/FutureTask;

    return-void
.end method

.method private static e()Landroid/os/Handler;
    .registers 3

    const-class v0, Landroidx/loader/content/c;

    monitor-enter v0

    :try_start_3
    sget-object v1, Landroidx/loader/content/c;->h:Landroid/os/Handler;

    if-nez v1, :cond_12

    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v1, Landroidx/loader/content/c;->h:Landroid/os/Handler;

    :cond_12
    sget-object v1, Landroidx/loader/content/c;->h:Landroid/os/Handler;

    monitor-exit v0

    return-object v1

    :catchall_16
    move-exception v1

    monitor-exit v0
    :try_end_18
    .catchall {:try_start_3 .. :try_end_18} :catchall_16

    throw v1
.end method


# virtual methods
.method public final a(Z)Z
    .registers 4

    iget-object v0, p0, Landroidx/loader/content/c;->f:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    iget-object v0, p0, Landroidx/loader/content/c;->c:Ljava/util/concurrent/FutureTask;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/FutureTask;->cancel(Z)Z

    move-result p1

    return p1
.end method

.method protected abstract b()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TResult;"
        }
    .end annotation
.end method

.method public final c(Ljava/util/concurrent/Executor;)V
    .registers 4

    iget-object v0, p0, Landroidx/loader/content/c;->d:Landroidx/loader/content/c$e;

    sget-object v1, Landroidx/loader/content/c$e;->c:Landroidx/loader/content/c$e;

    if-eq v0, v1, :cond_2e

    sget-object p1, Landroidx/loader/content/c$d;->a:[I

    iget-object v0, p0, Landroidx/loader/content/c;->d:Landroidx/loader/content/c$e;

    invoke-virtual {v0}, Ljava/lang/Enum;->ordinal()I

    move-result v0

    aget p1, p1, v0

    const/4 v0, 0x1

    if-eq p1, v0, :cond_26

    const/4 v0, 0x2

    if-eq p1, v0, :cond_1e

    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "We should never reach this state"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_1e
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "Cannot execute task: the task has already been executed (a task can be executed only once)"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_26
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "Cannot execute task: the task is already running."

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_2e
    sget-object v0, Landroidx/loader/content/c$e;->d:Landroidx/loader/content/c$e;

    iput-object v0, p0, Landroidx/loader/content/c;->d:Landroidx/loader/content/c$e;

    iget-object v0, p0, Landroidx/loader/content/c;->c:Ljava/util/concurrent/FutureTask;

    invoke-interface {p1, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    return-void
.end method

.method d(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TResult;)V"
        }
    .end annotation

    invoke-virtual {p0}, Landroidx/loader/content/c;->f()Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-virtual {p0, p1}, Landroidx/loader/content/c;->g(Ljava/lang/Object;)V

    goto :goto_d

    :cond_a
    invoke-virtual {p0, p1}, Landroidx/loader/content/c;->h(Ljava/lang/Object;)V

    :goto_d
    sget-object p1, Landroidx/loader/content/c$e;->f:Landroidx/loader/content/c$e;

    iput-object p1, p0, Landroidx/loader/content/c;->d:Landroidx/loader/content/c$e;

    return-void
.end method

.method public final f()Z
    .registers 2

    iget-object v0, p0, Landroidx/loader/content/c;->f:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method protected g(Ljava/lang/Object;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TResult;)V"
        }
    .end annotation

    return-void
.end method

.method protected h(Ljava/lang/Object;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TResult;)V"
        }
    .end annotation

    return-void
.end method

.method i(Ljava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TResult;)V"
        }
    .end annotation

    invoke-static {}, Landroidx/loader/content/c;->e()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Landroidx/loader/content/c$c;

    invoke-direct {v1, p0, p1}, Landroidx/loader/content/c$c;-><init>(Landroidx/loader/content/c;Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method j(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TResult;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/loader/content/c;->g:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_b

    invoke-virtual {p0, p1}, Landroidx/loader/content/c;->i(Ljava/lang/Object;)V

    :cond_b
    return-void
.end method
