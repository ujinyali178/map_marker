.class public abstract Landroidx/concurrent/futures/a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/common/util/concurrent/ListenableFuture;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/concurrent/futures/a$h;,
        Landroidx/concurrent/futures/a$f;,
        Landroidx/concurrent/futures/a$b;,
        Landroidx/concurrent/futures/a$g;,
        Landroidx/concurrent/futures/a$c;,
        Landroidx/concurrent/futures/a$d;,
        Landroidx/concurrent/futures/a$e;,
        Landroidx/concurrent/futures/a$i;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/google/common/util/concurrent/ListenableFuture<",
        "TV;>;"
    }
.end annotation


# static fields
.field static final g:Z

.field private static final h:Ljava/util/logging/Logger;

.field static final i:Landroidx/concurrent/futures/a$b;

.field private static final j:Ljava/lang/Object;


# instance fields
.field volatile c:Ljava/lang/Object;

.field volatile d:Landroidx/concurrent/futures/a$e;

.field volatile f:Landroidx/concurrent/futures/a$i;


# direct methods
.method static constructor <clinit>()V
    .registers 8

    const-class v0, Landroidx/concurrent/futures/a$i;

    const-string v1, "guava.concurrent.generate_cancellation_cause"

    const-string v2, "false"

    invoke-static {v1, v2}, Ljava/lang/System;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v1

    sput-boolean v1, Landroidx/concurrent/futures/a;->g:Z

    const-class v1, Landroidx/concurrent/futures/a;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v1

    sput-object v1, Landroidx/concurrent/futures/a;->h:Ljava/util/logging/Logger;

    :try_start_1c
    new-instance v1, Landroidx/concurrent/futures/a$f;

    const-class v2, Ljava/lang/Thread;

    const-string v3, "a"

    invoke-static {v0, v2, v3}, Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;->newUpdater(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    move-result-object v3

    const-string v2, "b"

    invoke-static {v0, v0, v2}, Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;->newUpdater(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    move-result-object v4

    const-class v2, Landroidx/concurrent/futures/a;

    const-string v5, "f"

    invoke-static {v2, v0, v5}, Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;->newUpdater(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    move-result-object v5

    const-class v0, Landroidx/concurrent/futures/a;

    const-class v2, Landroidx/concurrent/futures/a$e;

    const-string v6, "d"

    invoke-static {v0, v2, v6}, Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;->newUpdater(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    move-result-object v6

    const-class v0, Landroidx/concurrent/futures/a;

    const-class v2, Ljava/lang/Object;

    const-string v7, "c"

    invoke-static {v0, v2, v7}, Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;->newUpdater(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    move-result-object v7

    move-object v2, v1

    invoke-direct/range {v2 .. v7}, Landroidx/concurrent/futures/a$f;-><init>(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;)V
    :try_end_4c
    .catchall {:try_start_1c .. :try_end_4c} :catchall_4e

    const/4 v0, 0x0

    goto :goto_54

    :catchall_4e
    move-exception v0

    new-instance v1, Landroidx/concurrent/futures/a$h;

    invoke-direct {v1}, Landroidx/concurrent/futures/a$h;-><init>()V

    :goto_54
    sput-object v1, Landroidx/concurrent/futures/a;->i:Landroidx/concurrent/futures/a$b;

    const-class v1, Ljava/util/concurrent/locks/LockSupport;

    if-eqz v0, :cond_63

    sget-object v1, Landroidx/concurrent/futures/a;->h:Ljava/util/logging/Logger;

    sget-object v2, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    const-string v3, "SafeAtomicHelper is broken!"

    invoke-virtual {v1, v2, v3, v0}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_63
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroidx/concurrent/futures/a;->j:Ljava/lang/Object;

    return-void
.end method

.method protected constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a(Ljava/lang/StringBuilder;)V
    .registers 5

    const-string v0, "]"

    :try_start_2
    invoke-static {p0}, Landroidx/concurrent/futures/a;->j(Ljava/util/concurrent/Future;)Ljava/lang/Object;

    move-result-object v1

    const-string v2, "SUCCESS, result=["

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-direct {p0, v1}, Landroidx/concurrent/futures/a;->p(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_15
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_2 .. :try_end_15} :catch_29
    .catch Ljava/util/concurrent/CancellationException; {:try_start_2 .. :try_end_15} :catch_26
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_15} :catch_16

    goto :goto_39

    :catch_16
    move-exception v0

    const-string v1, "UNKNOWN, cause=["

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v0, " thrown from get()]"

    goto :goto_36

    :catch_26
    const-string v0, "CANCELLED"

    goto :goto_36

    :catch_29
    move-exception v1

    const-string v2, "FAILURE, cause=["

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    :goto_36
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :goto_39
    return-void
.end method

.method private static c(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/util/concurrent/CancellationException;
    .registers 3

    new-instance v0, Ljava/util/concurrent/CancellationException;

    invoke-direct {v0, p0}, Ljava/util/concurrent/CancellationException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/Throwable;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    return-object v0
.end method

.method static d(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)TT;"
        }
    .end annotation

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    return-object p0
.end method

.method private e(Landroidx/concurrent/futures/a$e;)Landroidx/concurrent/futures/a$e;
    .registers 6

    :cond_0
    iget-object v0, p0, Landroidx/concurrent/futures/a;->d:Landroidx/concurrent/futures/a$e;

    sget-object v1, Landroidx/concurrent/futures/a;->i:Landroidx/concurrent/futures/a$b;

    sget-object v2, Landroidx/concurrent/futures/a$e;->d:Landroidx/concurrent/futures/a$e;

    invoke-virtual {v1, p0, v0, v2}, Landroidx/concurrent/futures/a$b;->a(Landroidx/concurrent/futures/a;Landroidx/concurrent/futures/a$e;Landroidx/concurrent/futures/a$e;)Z

    move-result v1

    if-eqz v1, :cond_0

    move-object v3, v0

    move-object v0, p1

    move-object p1, v3

    :goto_f
    if-eqz p1, :cond_18

    iget-object v1, p1, Landroidx/concurrent/futures/a$e;->c:Landroidx/concurrent/futures/a$e;

    iput-object v0, p1, Landroidx/concurrent/futures/a$e;->c:Landroidx/concurrent/futures/a$e;

    move-object v0, p1

    move-object p1, v1

    goto :goto_f

    :cond_18
    return-object v0
.end method

.method static f(Landroidx/concurrent/futures/a;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/concurrent/futures/a<",
            "*>;)V"
        }
    .end annotation

    const/4 v0, 0x0

    :goto_1
    invoke-direct {p0}, Landroidx/concurrent/futures/a;->m()V

    invoke-virtual {p0}, Landroidx/concurrent/futures/a;->b()V

    invoke-direct {p0, v0}, Landroidx/concurrent/futures/a;->e(Landroidx/concurrent/futures/a$e;)Landroidx/concurrent/futures/a$e;

    move-result-object p0

    :goto_b
    if-eqz p0, :cond_33

    iget-object v0, p0, Landroidx/concurrent/futures/a$e;->c:Landroidx/concurrent/futures/a$e;

    iget-object v1, p0, Landroidx/concurrent/futures/a$e;->a:Ljava/lang/Runnable;

    instance-of v2, v1, Landroidx/concurrent/futures/a$g;

    if-eqz v2, :cond_2c

    check-cast v1, Landroidx/concurrent/futures/a$g;

    iget-object p0, v1, Landroidx/concurrent/futures/a$g;->c:Landroidx/concurrent/futures/a;

    iget-object v2, p0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    if-ne v2, v1, :cond_31

    iget-object v2, v1, Landroidx/concurrent/futures/a$g;->d:Lcom/google/common/util/concurrent/ListenableFuture;

    invoke-static {v2}, Landroidx/concurrent/futures/a;->i(Lcom/google/common/util/concurrent/ListenableFuture;)Ljava/lang/Object;

    move-result-object v2

    sget-object v3, Landroidx/concurrent/futures/a;->i:Landroidx/concurrent/futures/a$b;

    invoke-virtual {v3, p0, v1, v2}, Landroidx/concurrent/futures/a$b;->b(Landroidx/concurrent/futures/a;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_31

    goto :goto_1

    :cond_2c
    iget-object p0, p0, Landroidx/concurrent/futures/a$e;->b:Ljava/util/concurrent/Executor;

    invoke-static {v1, p0}, Landroidx/concurrent/futures/a;->g(Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V

    :cond_31
    move-object p0, v0

    goto :goto_b

    :cond_33
    return-void
.end method

.method private static g(Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V
    .registers 7

    :try_start_0
    invoke-interface {p1, p0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V
    :try_end_3
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_3} :catch_4

    goto :goto_25

    :catch_4
    move-exception v0

    sget-object v1, Landroidx/concurrent/futures/a;->h:Ljava/util/logging/Logger;

    sget-object v2, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "RuntimeException while executing runnable "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p0, " with executor "

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v1, v2, p0, v0}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V

    :goto_25
    return-void
.end method

.method private h(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")TV;"
        }
    .end annotation

    instance-of v0, p1, Landroidx/concurrent/futures/a$c;

    if-nez v0, :cond_18

    instance-of v0, p1, Landroidx/concurrent/futures/a$d;

    if-nez v0, :cond_e

    sget-object v0, Landroidx/concurrent/futures/a;->j:Ljava/lang/Object;

    if-ne p1, v0, :cond_d

    const/4 p1, 0x0

    :cond_d
    return-object p1

    :cond_e
    new-instance v0, Ljava/util/concurrent/ExecutionException;

    check-cast p1, Landroidx/concurrent/futures/a$d;

    iget-object p1, p1, Landroidx/concurrent/futures/a$d;->a:Ljava/lang/Throwable;

    invoke-direct {v0, p1}, Ljava/util/concurrent/ExecutionException;-><init>(Ljava/lang/Throwable;)V

    throw v0

    :cond_18
    check-cast p1, Landroidx/concurrent/futures/a$c;

    iget-object p1, p1, Landroidx/concurrent/futures/a$c;->b:Ljava/lang/Throwable;

    const-string v0, "Task was cancelled."

    invoke-static {v0, p1}, Landroidx/concurrent/futures/a;->c(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/util/concurrent/CancellationException;

    move-result-object p1

    throw p1
.end method

.method static i(Lcom/google/common/util/concurrent/ListenableFuture;)Ljava/lang/Object;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/common/util/concurrent/ListenableFuture<",
            "*>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    instance-of v0, p0, Landroidx/concurrent/futures/a;

    const/4 v1, 0x0

    if-eqz v0, :cond_23

    check-cast p0, Landroidx/concurrent/futures/a;

    iget-object p0, p0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    instance-of v0, p0, Landroidx/concurrent/futures/a$c;

    if-eqz v0, :cond_22

    move-object v0, p0

    check-cast v0, Landroidx/concurrent/futures/a$c;

    iget-boolean v2, v0, Landroidx/concurrent/futures/a$c;->a:Z

    if-eqz v2, :cond_22

    iget-object p0, v0, Landroidx/concurrent/futures/a$c;->b:Ljava/lang/Throwable;

    if-eqz p0, :cond_20

    new-instance p0, Landroidx/concurrent/futures/a$c;

    iget-object v0, v0, Landroidx/concurrent/futures/a$c;->b:Ljava/lang/Throwable;

    invoke-direct {p0, v1, v0}, Landroidx/concurrent/futures/a$c;-><init>(ZLjava/lang/Throwable;)V

    goto :goto_22

    :cond_20
    sget-object p0, Landroidx/concurrent/futures/a$c;->d:Landroidx/concurrent/futures/a$c;

    :cond_22
    :goto_22
    return-object p0

    :cond_23
    invoke-interface {p0}, Ljava/util/concurrent/Future;->isCancelled()Z

    move-result v0

    sget-boolean v2, Landroidx/concurrent/futures/a;->g:Z

    xor-int/lit8 v2, v2, 0x1

    and-int/2addr v2, v0

    if-eqz v2, :cond_31

    sget-object p0, Landroidx/concurrent/futures/a$c;->d:Landroidx/concurrent/futures/a$c;

    return-object p0

    :cond_31
    :try_start_31
    invoke-static {p0}, Landroidx/concurrent/futures/a;->j(Ljava/util/concurrent/Future;)Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_39

    sget-object v2, Landroidx/concurrent/futures/a;->j:Ljava/lang/Object;
    :try_end_39
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_31 .. :try_end_39} :catch_66
    .catch Ljava/util/concurrent/CancellationException; {:try_start_31 .. :try_end_39} :catch_41
    .catchall {:try_start_31 .. :try_end_39} :catchall_3a

    :cond_39
    return-object v2

    :catchall_3a
    move-exception p0

    new-instance v0, Landroidx/concurrent/futures/a$d;

    invoke-direct {v0, p0}, Landroidx/concurrent/futures/a$d;-><init>(Ljava/lang/Throwable;)V

    return-object v0

    :catch_41
    move-exception v2

    if-nez v0, :cond_60

    new-instance v0, Landroidx/concurrent/futures/a$d;

    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "get() threw CancellationException, despite reporting isCancelled() == false: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v1, p0, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-direct {v0, v1}, Landroidx/concurrent/futures/a$d;-><init>(Ljava/lang/Throwable;)V

    return-object v0

    :cond_60
    new-instance p0, Landroidx/concurrent/futures/a$c;

    invoke-direct {p0, v1, v2}, Landroidx/concurrent/futures/a$c;-><init>(ZLjava/lang/Throwable;)V

    return-object p0

    :catch_66
    move-exception p0

    new-instance v0, Landroidx/concurrent/futures/a$d;

    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object p0

    invoke-direct {v0, p0}, Landroidx/concurrent/futures/a$d;-><init>(Ljava/lang/Throwable;)V

    return-object v0
.end method

.method static j(Ljava/util/concurrent/Future;)Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<V:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/Future<",
            "TV;>;)TV;"
        }
    .end annotation

    const/4 v0, 0x0

    :goto_1
    :try_start_1
    invoke-interface {p0}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;

    move-result-object p0
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_5} :catch_1a
    .catchall {:try_start_1 .. :try_end_5} :catchall_f

    if-eqz v0, :cond_e

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    :cond_e
    return-object p0

    :catchall_f
    move-exception p0

    if-eqz v0, :cond_19

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    :cond_19
    throw p0

    :catch_1a
    const/4 v0, 0x1

    goto :goto_1
.end method

.method private m()V
    .registers 4

    :cond_0
    iget-object v0, p0, Landroidx/concurrent/futures/a;->f:Landroidx/concurrent/futures/a$i;

    sget-object v1, Landroidx/concurrent/futures/a;->i:Landroidx/concurrent/futures/a$b;

    sget-object v2, Landroidx/concurrent/futures/a$i;->c:Landroidx/concurrent/futures/a$i;

    invoke-virtual {v1, p0, v0, v2}, Landroidx/concurrent/futures/a$b;->c(Landroidx/concurrent/futures/a;Landroidx/concurrent/futures/a$i;Landroidx/concurrent/futures/a$i;)Z

    move-result v1

    if-eqz v1, :cond_0

    :goto_c
    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/concurrent/futures/a$i;->b()V

    iget-object v0, v0, Landroidx/concurrent/futures/a$i;->b:Landroidx/concurrent/futures/a$i;

    goto :goto_c

    :cond_14
    return-void
.end method

.method private n(Landroidx/concurrent/futures/a$i;)V
    .registers 6

    const/4 v0, 0x0

    iput-object v0, p1, Landroidx/concurrent/futures/a$i;->a:Ljava/lang/Thread;

    :goto_3
    iget-object p1, p0, Landroidx/concurrent/futures/a;->f:Landroidx/concurrent/futures/a$i;

    sget-object v1, Landroidx/concurrent/futures/a$i;->c:Landroidx/concurrent/futures/a$i;

    if-ne p1, v1, :cond_a

    return-void

    :cond_a
    move-object v1, v0

    :goto_b
    if-eqz p1, :cond_29

    iget-object v2, p1, Landroidx/concurrent/futures/a$i;->b:Landroidx/concurrent/futures/a$i;

    iget-object v3, p1, Landroidx/concurrent/futures/a$i;->a:Ljava/lang/Thread;

    if-eqz v3, :cond_15

    move-object v1, p1

    goto :goto_27

    :cond_15
    if-eqz v1, :cond_1e

    iput-object v2, v1, Landroidx/concurrent/futures/a$i;->b:Landroidx/concurrent/futures/a$i;

    iget-object p1, v1, Landroidx/concurrent/futures/a$i;->a:Ljava/lang/Thread;

    if-nez p1, :cond_27

    goto :goto_3

    :cond_1e
    sget-object v3, Landroidx/concurrent/futures/a;->i:Landroidx/concurrent/futures/a$b;

    invoke-virtual {v3, p0, p1, v2}, Landroidx/concurrent/futures/a$b;->c(Landroidx/concurrent/futures/a;Landroidx/concurrent/futures/a$i;Landroidx/concurrent/futures/a$i;)Z

    move-result p1

    if-nez p1, :cond_27

    goto :goto_3

    :cond_27
    :goto_27
    move-object p1, v2

    goto :goto_b

    :cond_29
    return-void
.end method

.method private p(Ljava/lang/Object;)Ljava/lang/String;
    .registers 2

    if-ne p1, p0, :cond_5

    const-string p1, "this future"

    return-object p1

    :cond_5
    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method


# virtual methods
.method public final addListener(Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V
    .registers 6

    invoke-static {p1}, Landroidx/concurrent/futures/a;->d(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {p2}, Landroidx/concurrent/futures/a;->d(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Landroidx/concurrent/futures/a;->d:Landroidx/concurrent/futures/a$e;

    sget-object v1, Landroidx/concurrent/futures/a$e;->d:Landroidx/concurrent/futures/a$e;

    if-eq v0, v1, :cond_22

    new-instance v1, Landroidx/concurrent/futures/a$e;

    invoke-direct {v1, p1, p2}, Landroidx/concurrent/futures/a$e;-><init>(Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V

    :cond_11
    iput-object v0, v1, Landroidx/concurrent/futures/a$e;->c:Landroidx/concurrent/futures/a$e;

    sget-object v2, Landroidx/concurrent/futures/a;->i:Landroidx/concurrent/futures/a$b;

    invoke-virtual {v2, p0, v0, v1}, Landroidx/concurrent/futures/a$b;->a(Landroidx/concurrent/futures/a;Landroidx/concurrent/futures/a$e;Landroidx/concurrent/futures/a$e;)Z

    move-result v0

    if-eqz v0, :cond_1c

    return-void

    :cond_1c
    iget-object v0, p0, Landroidx/concurrent/futures/a;->d:Landroidx/concurrent/futures/a$e;

    sget-object v2, Landroidx/concurrent/futures/a$e;->d:Landroidx/concurrent/futures/a$e;

    if-ne v0, v2, :cond_11

    :cond_22
    invoke-static {p1, p2}, Landroidx/concurrent/futures/a;->g(Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V

    return-void
.end method

.method protected b()V
    .registers 1

    return-void
.end method

.method public final cancel(Z)Z
    .registers 9

    iget-object v0, p0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-nez v0, :cond_8

    const/4 v3, 0x1

    goto :goto_9

    :cond_8
    const/4 v3, 0x0

    :goto_9
    instance-of v4, v0, Landroidx/concurrent/futures/a$g;

    or-int/2addr v3, v4

    if-eqz v3, :cond_63

    sget-boolean v3, Landroidx/concurrent/futures/a;->g:Z

    if-eqz v3, :cond_1f

    new-instance v3, Landroidx/concurrent/futures/a$c;

    new-instance v4, Ljava/util/concurrent/CancellationException;

    const-string v5, "Future.cancel() was called."

    invoke-direct {v4, v5}, Ljava/util/concurrent/CancellationException;-><init>(Ljava/lang/String;)V

    invoke-direct {v3, p1, v4}, Landroidx/concurrent/futures/a$c;-><init>(ZLjava/lang/Throwable;)V

    goto :goto_26

    :cond_1f
    if-eqz p1, :cond_24

    sget-object v3, Landroidx/concurrent/futures/a$c;->c:Landroidx/concurrent/futures/a$c;

    goto :goto_26

    :cond_24
    sget-object v3, Landroidx/concurrent/futures/a$c;->d:Landroidx/concurrent/futures/a$c;

    :goto_26
    const/4 v5, 0x0

    move-object v4, p0

    :cond_28
    :goto_28
    sget-object v6, Landroidx/concurrent/futures/a;->i:Landroidx/concurrent/futures/a$b;

    invoke-virtual {v6, v4, v0, v3}, Landroidx/concurrent/futures/a$b;->b(Landroidx/concurrent/futures/a;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5b

    if-eqz p1, :cond_35

    invoke-virtual {v4}, Landroidx/concurrent/futures/a;->k()V

    :cond_35
    invoke-static {v4}, Landroidx/concurrent/futures/a;->f(Landroidx/concurrent/futures/a;)V

    instance-of v4, v0, Landroidx/concurrent/futures/a$g;

    if-eqz v4, :cond_64

    check-cast v0, Landroidx/concurrent/futures/a$g;

    iget-object v0, v0, Landroidx/concurrent/futures/a$g;->d:Lcom/google/common/util/concurrent/ListenableFuture;

    instance-of v4, v0, Landroidx/concurrent/futures/a;

    if-eqz v4, :cond_57

    move-object v4, v0

    check-cast v4, Landroidx/concurrent/futures/a;

    iget-object v0, v4, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    if-nez v0, :cond_4e

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_4f

    :cond_4e
    const/4 v5, 0x0

    :goto_4f
    instance-of v6, v0, Landroidx/concurrent/futures/a$g;

    or-int/2addr v5, v6

    if-eqz v5, :cond_64

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_28

    :cond_57
    invoke-interface {v0, p1}, Ljava/util/concurrent/Future;->cancel(Z)Z

    goto :goto_64

    :cond_5b
    iget-object v0, v4, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    instance-of v6, v0, Landroidx/concurrent/futures/a$g;

    if-nez v6, :cond_28

    move v1, v5

    goto :goto_64

    :cond_63
    const/4 v1, 0x0

    :cond_64
    :goto_64
    return v1
.end method

.method public final get()Ljava/lang/Object;
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TV;"
        }
    .end annotation

    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    move-result v0

    if-nez v0, :cond_61

    iget-object v0, p0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_e

    const/4 v3, 0x1

    goto :goto_f

    :cond_e
    const/4 v3, 0x0

    :goto_f
    instance-of v4, v0, Landroidx/concurrent/futures/a$g;

    xor-int/2addr v4, v2

    and-int/2addr v3, v4

    if-eqz v3, :cond_1a

    invoke-direct {p0, v0}, Landroidx/concurrent/futures/a;->h(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_1a
    iget-object v0, p0, Landroidx/concurrent/futures/a;->f:Landroidx/concurrent/futures/a$i;

    sget-object v3, Landroidx/concurrent/futures/a$i;->c:Landroidx/concurrent/futures/a$i;

    if-eq v0, v3, :cond_5a

    new-instance v3, Landroidx/concurrent/futures/a$i;

    invoke-direct {v3}, Landroidx/concurrent/futures/a$i;-><init>()V

    :cond_25
    invoke-virtual {v3, v0}, Landroidx/concurrent/futures/a$i;->a(Landroidx/concurrent/futures/a$i;)V

    sget-object v4, Landroidx/concurrent/futures/a;->i:Landroidx/concurrent/futures/a$b;

    invoke-virtual {v4, p0, v0, v3}, Landroidx/concurrent/futures/a$b;->c(Landroidx/concurrent/futures/a;Landroidx/concurrent/futures/a$i;Landroidx/concurrent/futures/a$i;)Z

    move-result v0

    if-eqz v0, :cond_54

    :cond_30
    invoke-static {p0}, Ljava/util/concurrent/locks/LockSupport;->park(Ljava/lang/Object;)V

    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    move-result v0

    if-nez v0, :cond_4b

    iget-object v0, p0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    if-eqz v0, :cond_3f

    const/4 v4, 0x1

    goto :goto_40

    :cond_3f
    const/4 v4, 0x0

    :goto_40
    instance-of v5, v0, Landroidx/concurrent/futures/a$g;

    xor-int/2addr v5, v2

    and-int/2addr v4, v5

    if-eqz v4, :cond_30

    invoke-direct {p0, v0}, Landroidx/concurrent/futures/a;->h(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_4b
    invoke-direct {p0, v3}, Landroidx/concurrent/futures/a;->n(Landroidx/concurrent/futures/a$i;)V

    new-instance v0, Ljava/lang/InterruptedException;

    invoke-direct {v0}, Ljava/lang/InterruptedException;-><init>()V

    throw v0

    :cond_54
    iget-object v0, p0, Landroidx/concurrent/futures/a;->f:Landroidx/concurrent/futures/a$i;

    sget-object v4, Landroidx/concurrent/futures/a$i;->c:Landroidx/concurrent/futures/a$i;

    if-ne v0, v4, :cond_25

    :cond_5a
    iget-object v0, p0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    invoke-direct {p0, v0}, Landroidx/concurrent/futures/a;->h(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_61
    new-instance v0, Ljava/lang/InterruptedException;

    invoke-direct {v0}, Ljava/lang/InterruptedException;-><init>()V

    throw v0
.end method

.method public final get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    .registers 23
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/concurrent/TimeUnit;",
            ")TV;"
        }
    .end annotation

    move-object/from16 v0, p0

    move-wide/from16 v1, p1

    move-object/from16 v3, p3

    invoke-virtual {v3, v1, v2}, Ljava/util/concurrent/TimeUnit;->toNanos(J)J

    move-result-wide v4

    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    move-result v6

    if-nez v6, :cond_1ae

    iget-object v6, v0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    const/4 v8, 0x1

    if-eqz v6, :cond_17

    const/4 v9, 0x1

    goto :goto_18

    :cond_17
    const/4 v9, 0x0

    :goto_18
    instance-of v10, v6, Landroidx/concurrent/futures/a$g;

    xor-int/2addr v10, v8

    and-int/2addr v9, v10

    if-eqz v9, :cond_23

    invoke-direct {v0, v6}, Landroidx/concurrent/futures/a;->h(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    :cond_23
    const-wide/16 v9, 0x0

    cmp-long v6, v4, v9

    if-lez v6, :cond_2f

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v11

    add-long/2addr v11, v4

    goto :goto_30

    :cond_2f
    move-wide v11, v9

    :goto_30
    const-wide/16 v13, 0x3e8

    cmp-long v6, v4, v13

    if-ltz v6, :cond_8c

    iget-object v6, v0, Landroidx/concurrent/futures/a;->f:Landroidx/concurrent/futures/a$i;

    sget-object v15, Landroidx/concurrent/futures/a$i;->c:Landroidx/concurrent/futures/a$i;

    if-eq v6, v15, :cond_85

    new-instance v15, Landroidx/concurrent/futures/a$i;

    invoke-direct {v15}, Landroidx/concurrent/futures/a$i;-><init>()V

    :cond_41
    invoke-virtual {v15, v6}, Landroidx/concurrent/futures/a$i;->a(Landroidx/concurrent/futures/a$i;)V

    sget-object v7, Landroidx/concurrent/futures/a;->i:Landroidx/concurrent/futures/a$b;

    invoke-virtual {v7, v0, v6, v15}, Landroidx/concurrent/futures/a$b;->c(Landroidx/concurrent/futures/a;Landroidx/concurrent/futures/a$i;Landroidx/concurrent/futures/a$i;)Z

    move-result v6

    if-eqz v6, :cond_7f

    :cond_4c
    invoke-static {v0, v4, v5}, Ljava/util/concurrent/locks/LockSupport;->parkNanos(Ljava/lang/Object;J)V

    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    move-result v4

    if-nez v4, :cond_76

    iget-object v4, v0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    if-eqz v4, :cond_5c

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_5d

    :cond_5c
    const/4 v5, 0x0

    :goto_5d
    instance-of v6, v4, Landroidx/concurrent/futures/a$g;

    xor-int/2addr v6, v8

    and-int/2addr v5, v6

    if-eqz v5, :cond_68

    invoke-direct {v0, v4}, Landroidx/concurrent/futures/a;->h(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    :cond_68
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v4

    sub-long v4, v11, v4

    cmp-long v6, v4, v13

    if-gez v6, :cond_4c

    invoke-direct {v0, v15}, Landroidx/concurrent/futures/a;->n(Landroidx/concurrent/futures/a$i;)V

    goto :goto_8c

    :cond_76
    invoke-direct {v0, v15}, Landroidx/concurrent/futures/a;->n(Landroidx/concurrent/futures/a$i;)V

    new-instance v1, Ljava/lang/InterruptedException;

    invoke-direct {v1}, Ljava/lang/InterruptedException;-><init>()V

    throw v1

    :cond_7f
    iget-object v6, v0, Landroidx/concurrent/futures/a;->f:Landroidx/concurrent/futures/a$i;

    sget-object v7, Landroidx/concurrent/futures/a$i;->c:Landroidx/concurrent/futures/a$i;

    if-ne v6, v7, :cond_41

    :cond_85
    iget-object v1, v0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    invoke-direct {v0, v1}, Landroidx/concurrent/futures/a;->h(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    :cond_8c
    :goto_8c
    cmp-long v6, v4, v9

    if-lez v6, :cond_b6

    iget-object v4, v0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    if-eqz v4, :cond_97

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_98

    :cond_97
    const/4 v5, 0x0

    :goto_98
    instance-of v6, v4, Landroidx/concurrent/futures/a$g;

    xor-int/2addr v6, v8

    and-int/2addr v5, v6

    if-eqz v5, :cond_a3

    invoke-direct {v0, v4}, Landroidx/concurrent/futures/a;->h(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    :cond_a3
    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    move-result v4

    if-nez v4, :cond_b0

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v4

    sub-long v4, v11, v4

    goto :goto_8c

    :cond_b0
    new-instance v1, Ljava/lang/InterruptedException;

    invoke-direct {v1}, Ljava/lang/InterruptedException;-><init>()V

    throw v1

    :cond_b6
    invoke-virtual/range {p0 .. p0}, Landroidx/concurrent/futures/a;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual/range {p3 .. p3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    sget-object v11, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {v7, v11}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v7

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Waited "

    invoke-virtual {v12, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, " "

    invoke-virtual {v12, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual/range {p3 .. p3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v11}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v12, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    add-long v11, v4, v13

    cmp-long v15, v11, v9

    if-gez v15, :cond_177

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, " (plus "

    invoke-virtual {v11, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    neg-long v4, v4

    sget-object v11, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v3, v4, v5, v11}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v11

    invoke-virtual {v3, v11, v12}, Ljava/util/concurrent/TimeUnit;->toNanos(J)J

    move-result-wide v17

    sub-long v4, v4, v17

    cmp-long v3, v11, v9

    if-eqz v3, :cond_115

    cmp-long v9, v4, v13

    if-lez v9, :cond_112

    goto :goto_115

    :cond_112
    const/16 v16, 0x0

    goto :goto_117

    :cond_115
    :goto_115
    const/16 v16, 0x1

    :goto_117
    if-lez v3, :cond_150

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v11, v12}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    if-eqz v16, :cond_141

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ","

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :cond_141
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :cond_150
    if-eqz v16, :cond_166

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v2, " nanoseconds "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :cond_166
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "delay)"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :cond_177
    invoke-virtual/range {p0 .. p0}, Landroidx/concurrent/futures/a;->isDone()Z

    move-result v1

    if-eqz v1, :cond_194

    new-instance v1, Ljava/util/concurrent/TimeoutException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, " but future completed as timeout expired"

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/util/concurrent/TimeoutException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_194
    new-instance v1, Ljava/util/concurrent/TimeoutException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, " for "

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/util/concurrent/TimeoutException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1ae
    new-instance v1, Ljava/lang/InterruptedException;

    invoke-direct {v1}, Ljava/lang/InterruptedException;-><init>()V

    throw v1
.end method

.method public final isCancelled()Z
    .registers 2

    iget-object v0, p0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    instance-of v0, v0, Landroidx/concurrent/futures/a$c;

    return v0
.end method

.method public final isDone()Z
    .registers 4

    iget-object v0, p0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    const/4 v1, 0x1

    if-eqz v0, :cond_7

    const/4 v2, 0x1

    goto :goto_8

    :cond_7
    const/4 v2, 0x0

    :goto_8
    instance-of v0, v0, Landroidx/concurrent/futures/a$g;

    xor-int/2addr v0, v1

    and-int/2addr v0, v2

    return v0
.end method

.method protected k()V
    .registers 1

    return-void
.end method

.method protected l()Ljava/lang/String;
    .registers 4

    iget-object v0, p0, Landroidx/concurrent/futures/a;->c:Ljava/lang/Object;

    instance-of v1, v0, Landroidx/concurrent/futures/a$g;

    if-eqz v1, :cond_25

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "setFuture=["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    check-cast v0, Landroidx/concurrent/futures/a$g;

    iget-object v0, v0, Landroidx/concurrent/futures/a$g;->d:Lcom/google/common/util/concurrent/ListenableFuture;

    invoke-direct {p0, v0}, Landroidx/concurrent/futures/a;->p(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "]"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_25
    instance-of v0, p0, Ljava/util/concurrent/ScheduledFuture;

    if-eqz v0, :cond_49

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "remaining delay=["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-object v1, p0

    check-cast v1, Ljava/util/concurrent/ScheduledFuture;

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v1, v2}, Ljava/util/concurrent/Delayed;->getDelay(Ljava/util/concurrent/TimeUnit;)J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, " ms]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_49
    const/4 v0, 0x0

    return-object v0
.end method

.method protected o(Ljava/lang/Object;)Z
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TV;)Z"
        }
    .end annotation

    if-nez p1, :cond_4

    sget-object p1, Landroidx/concurrent/futures/a;->j:Ljava/lang/Object;

    :cond_4
    sget-object v0, Landroidx/concurrent/futures/a;->i:Landroidx/concurrent/futures/a$b;

    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1, p1}, Landroidx/concurrent/futures/a$b;->b(Landroidx/concurrent/futures/a;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_12

    invoke-static {p0}, Landroidx/concurrent/futures/a;->f(Landroidx/concurrent/futures/a;)V

    const/4 p1, 0x1

    return p1

    :cond_12
    const/4 p1, 0x0

    return p1
.end method

.method public toString()Ljava/lang/String;
    .registers 6

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "[status="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Landroidx/concurrent/futures/a;->isCancelled()Z

    move-result v1

    const-string v2, "]"

    if-eqz v1, :cond_1f

    const-string v1, "CANCELLED"

    :goto_1b
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_62

    :cond_1f
    invoke-virtual {p0}, Landroidx/concurrent/futures/a;->isDone()Z

    move-result v1

    if-eqz v1, :cond_29

    :goto_25
    invoke-direct {p0, v0}, Landroidx/concurrent/futures/a;->a(Ljava/lang/StringBuilder;)V

    goto :goto_62

    :cond_29
    :try_start_29
    invoke-virtual {p0}, Landroidx/concurrent/futures/a;->l()Ljava/lang/String;

    move-result-object v1
    :try_end_2d
    .catch Ljava/lang/RuntimeException; {:try_start_29 .. :try_end_2d} :catch_2e

    goto :goto_44

    :catch_2e
    move-exception v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Exception thrown from implementation: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_44
    if-eqz v1, :cond_58

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_58

    const-string v3, "PENDING, info=["

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_62

    :cond_58
    invoke-virtual {p0}, Landroidx/concurrent/futures/a;->isDone()Z

    move-result v1

    if-eqz v1, :cond_5f

    goto :goto_25

    :cond_5f
    const-string v1, "PENDING"

    goto :goto_1b

    :goto_62
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
