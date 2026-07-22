.class public final Lw2/d1;
.super Lw2/c1;
.source "SourceFile"

# interfaces
.implements Lw2/n0;


# instance fields
.field private final g:Ljava/util/concurrent/Executor;


# direct methods
.method public constructor <init>(Ljava/util/concurrent/Executor;)V
    .registers 2

    invoke-direct {p0}, Lw2/c1;-><init>()V

    iput-object p1, p0, Lw2/d1;->g:Ljava/util/concurrent/Executor;

    invoke-virtual {p0}, Lw2/d1;->w()Ljava/util/concurrent/Executor;

    move-result-object p1

    invoke-static {p1}, Lkotlinx/coroutines/internal/d;->a(Ljava/util/concurrent/Executor;)Z

    return-void
.end method

.method private final p(Li2/g;Ljava/util/concurrent/RejectedExecutionException;)V
    .registers 4

    const-string v0, "The task was rejected"

    invoke-static {v0, p2}, Lw2/b1;->a(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/util/concurrent/CancellationException;

    move-result-object p2

    invoke-static {p1, p2}, Lw2/p1;->c(Li2/g;Ljava/util/concurrent/CancellationException;)V

    return-void
.end method


# virtual methods
.method public close()V
    .registers 3

    invoke-virtual {p0}, Lw2/d1;->w()Ljava/util/concurrent/Executor;

    move-result-object v0

    instance-of v1, v0, Ljava/util/concurrent/ExecutorService;

    if-eqz v1, :cond_b

    check-cast v0, Ljava/util/concurrent/ExecutorService;

    goto :goto_c

    :cond_b
    const/4 v0, 0x0

    :goto_c
    if-eqz v0, :cond_11

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->shutdown()V

    :cond_11
    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 3

    instance-of v0, p1, Lw2/d1;

    if-eqz v0, :cond_12

    check-cast p1, Lw2/d1;

    invoke-virtual {p1}, Lw2/d1;->w()Ljava/util/concurrent/Executor;

    move-result-object p1

    invoke-virtual {p0}, Lw2/d1;->w()Ljava/util/concurrent/Executor;

    move-result-object v0

    if-ne p1, v0, :cond_12

    const/4 p1, 0x1

    goto :goto_13

    :cond_12
    const/4 p1, 0x0

    :goto_13
    return p1
.end method

.method public g(Li2/g;Ljava/lang/Runnable;)V
    .registers 4

    :try_start_0
    invoke-virtual {p0}, Lw2/d1;->w()Ljava/util/concurrent/Executor;

    move-result-object v0

    invoke-static {}, Lw2/c;->a()Lw2/b;

    invoke-interface {v0, p2}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V
    :try_end_a
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_0 .. :try_end_a} :catch_b

    goto :goto_19

    :catch_b
    move-exception v0

    invoke-static {}, Lw2/c;->a()Lw2/b;

    invoke-direct {p0, p1, v0}, Lw2/d1;->p(Li2/g;Ljava/util/concurrent/RejectedExecutionException;)V

    invoke-static {}, Lw2/t0;->b()Lw2/c0;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lw2/c0;->g(Li2/g;Ljava/lang/Runnable;)V

    :goto_19
    return-void
.end method

.method public hashCode()I
    .registers 2

    invoke-virtual {p0}, Lw2/d1;->w()Ljava/util/concurrent/Executor;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    invoke-virtual {p0}, Lw2/d1;->w()Ljava/util/concurrent/Executor;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public w()Ljava/util/concurrent/Executor;
    .registers 2

    iget-object v0, p0, Lw2/d1;->g:Ljava/util/concurrent/Executor;

    return-object v0
.end method
