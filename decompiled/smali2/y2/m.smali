.class public Ly2/m;
.super Ly2/a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ly2/a<",
        "TE;>;"
    }
.end annotation


# instance fields
.field private final e:Ljava/util/concurrent/locks/ReentrantLock;

.field private f:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Lp2/l;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lp2/l<",
            "-TE;",
            "Lg2/q;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p1}, Ly2/a;-><init>(Lp2/l;)V

    new-instance p1, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {p1}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object p1, p0, Ly2/m;->e:Ljava/util/concurrent/locks/ReentrantLock;

    sget-object p1, Ly2/b;->a:Lkotlinx/coroutines/internal/b0;

    iput-object p1, p0, Ly2/m;->f:Ljava/lang/Object;

    return-void
.end method

.method private final x(Ljava/lang/Object;)Lkotlinx/coroutines/internal/j0;
    .registers 6

    iget-object v0, p0, Ly2/m;->f:Ljava/lang/Object;

    sget-object v1, Ly2/b;->a:Lkotlinx/coroutines/internal/b0;

    const/4 v2, 0x0

    if-ne v0, v1, :cond_8

    goto :goto_11

    :cond_8
    iget-object v1, p0, Ly2/c;->b:Lp2/l;

    if-eqz v1, :cond_11

    const/4 v3, 0x2

    invoke-static {v1, v0, v2, v3, v2}, Lkotlinx/coroutines/internal/v;->d(Lp2/l;Ljava/lang/Object;Lkotlinx/coroutines/internal/j0;ILjava/lang/Object;)Lkotlinx/coroutines/internal/j0;

    move-result-object v2

    :cond_11
    :goto_11
    iput-object p1, p0, Ly2/m;->f:Ljava/lang/Object;

    return-object v2
.end method


# virtual methods
.method protected c()Ljava/lang/String;
    .registers 4

    iget-object v0, p0, Ly2/m;->e:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_5
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "(value="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Ly2/m;->f:Ljava/lang/Object;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const/16 v2, 0x29

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1
    :try_end_1d
    .catchall {:try_start_5 .. :try_end_1d} :catchall_21

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-object v1

    :catchall_21
    move-exception v1

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v1
.end method

.method protected i(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    iget-object v0, p0, Ly2/m;->e:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_5
    invoke-virtual {p0}, Ly2/c;->d()Ly2/j;

    move-result-object v1
    :try_end_9
    .catchall {:try_start_5 .. :try_end_9} :catchall_48

    if-eqz v1, :cond_f

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-object v1

    :cond_f
    :try_start_f
    iget-object v1, p0, Ly2/m;->f:Ljava/lang/Object;

    sget-object v2, Ly2/b;->a:Lkotlinx/coroutines/internal/b0;

    if-ne v1, v2, :cond_3b

    :cond_15
    invoke-virtual {p0}, Ly2/a;->l()Ly2/q;

    move-result-object v1

    if-nez v1, :cond_1c

    goto :goto_3b

    :cond_1c
    instance-of v2, v1, Ly2/j;
    :try_end_1e
    .catchall {:try_start_f .. :try_end_1e} :catchall_48

    if-eqz v2, :cond_24

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-object v1

    :cond_24
    :try_start_24
    invoke-static {v1}, Lkotlin/jvm/internal/k;->b(Ljava/lang/Object;)V

    const/4 v2, 0x0

    invoke-interface {v1, p1, v2}, Ly2/q;->g(Ljava/lang/Object;Lkotlinx/coroutines/internal/o$b;)Lkotlinx/coroutines/internal/b0;

    move-result-object v2

    if-eqz v2, :cond_15

    sget-object v2, Lg2/q;->a:Lg2/q;
    :try_end_30
    .catchall {:try_start_24 .. :try_end_30} :catchall_48

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    invoke-interface {v1, p1}, Ly2/q;->f(Ljava/lang/Object;)V

    invoke-interface {v1}, Ly2/q;->b()Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_3b
    :goto_3b
    :try_start_3b
    invoke-direct {p0, p1}, Ly2/m;->x(Ljava/lang/Object;)Lkotlinx/coroutines/internal/j0;

    move-result-object p1

    if-nez p1, :cond_47

    sget-object p1, Ly2/b;->b:Lkotlinx/coroutines/internal/b0;
    :try_end_43
    .catchall {:try_start_3b .. :try_end_43} :catchall_48

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-object p1

    :cond_47
    :try_start_47
    throw p1
    :try_end_48
    .catchall {:try_start_47 .. :try_end_48} :catchall_48

    :catchall_48
    move-exception p1

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw p1
.end method

.method protected q(Ly2/o;)Z
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ly2/o<",
            "-TE;>;)Z"
        }
    .end annotation

    iget-object v0, p0, Ly2/m;->e:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_5
    invoke-super {p0, p1}, Ly2/a;->q(Ly2/o;)Z

    move-result p1
    :try_end_9
    .catchall {:try_start_5 .. :try_end_9} :catchall_d

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return p1

    :catchall_d
    move-exception p1

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw p1
.end method

.method protected final r()Z
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method protected final s()Z
    .registers 4

    iget-object v0, p0, Ly2/m;->e:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_5
    iget-object v1, p0, Ly2/m;->f:Ljava/lang/Object;

    sget-object v2, Ly2/b;->a:Lkotlinx/coroutines/internal/b0;
    :try_end_9
    .catchall {:try_start_5 .. :try_end_9} :catchall_12

    if-ne v1, v2, :cond_d

    const/4 v1, 0x1

    goto :goto_e

    :cond_d
    const/4 v1, 0x0

    :goto_e
    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return v1

    :catchall_12
    move-exception v1

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v1
.end method

.method protected v()Ljava/lang/Object;
    .registers 4

    iget-object v0, p0, Ly2/m;->e:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_5
    iget-object v1, p0, Ly2/m;->f:Ljava/lang/Object;

    sget-object v2, Ly2/b;->a:Lkotlinx/coroutines/internal/b0;

    if-ne v1, v2, :cond_17

    invoke-virtual {p0}, Ly2/c;->d()Ly2/j;

    move-result-object v1

    if-nez v1, :cond_13

    sget-object v1, Ly2/b;->d:Lkotlinx/coroutines/internal/b0;
    :try_end_13
    .catchall {:try_start_5 .. :try_end_13} :catchall_1f

    :cond_13
    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-object v1

    :cond_17
    :try_start_17
    iput-object v2, p0, Ly2/m;->f:Ljava/lang/Object;

    sget-object v2, Lg2/q;->a:Lg2/q;
    :try_end_1b
    .catchall {:try_start_17 .. :try_end_1b} :catchall_1f

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-object v1

    :catchall_1f
    move-exception v1

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v1
.end method
