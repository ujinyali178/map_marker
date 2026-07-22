.class public final Lx2/c;
.super Lx2/d;
.source "SourceFile"


# instance fields
.field private volatile _immediate:Lx2/c;

.field private final f:Landroid/os/Handler;

.field private final g:Ljava/lang/String;

.field private final h:Z

.field private final i:Lx2/c;


# direct methods
.method public constructor <init>(Landroid/os/Handler;Ljava/lang/String;)V
    .registers 4

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lx2/c;-><init>(Landroid/os/Handler;Ljava/lang/String;Z)V

    return-void
.end method

.method public synthetic constructor <init>(Landroid/os/Handler;Ljava/lang/String;ILkotlin/jvm/internal/g;)V
    .registers 5

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_5

    const/4 p2, 0x0

    :cond_5
    invoke-direct {p0, p1, p2}, Lx2/c;-><init>(Landroid/os/Handler;Ljava/lang/String;)V

    return-void
.end method

.method private constructor <init>(Landroid/os/Handler;Ljava/lang/String;Z)V
    .registers 5

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lx2/d;-><init>(Lkotlin/jvm/internal/g;)V

    iput-object p1, p0, Lx2/c;->f:Landroid/os/Handler;

    iput-object p2, p0, Lx2/c;->g:Ljava/lang/String;

    iput-boolean p3, p0, Lx2/c;->h:Z

    if-eqz p3, :cond_d

    move-object v0, p0

    :cond_d
    iput-object v0, p0, Lx2/c;->_immediate:Lx2/c;

    iget-object p3, p0, Lx2/c;->_immediate:Lx2/c;

    if-nez p3, :cond_1b

    new-instance p3, Lx2/c;

    const/4 v0, 0x1

    invoke-direct {p3, p1, p2, v0}, Lx2/c;-><init>(Landroid/os/Handler;Ljava/lang/String;Z)V

    iput-object p3, p0, Lx2/c;->_immediate:Lx2/c;

    :cond_1b
    iput-object p3, p0, Lx2/c;->i:Lx2/c;

    return-void
.end method

.method private final y(Li2/g;Ljava/lang/Runnable;)V
    .registers 6

    new-instance v0, Ljava/util/concurrent/CancellationException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "The task was rejected, the handler underlying the dispatcher \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, "\' was closed"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CancellationException;-><init>(Ljava/lang/String;)V

    invoke-static {p1, v0}, Lw2/p1;->c(Li2/g;Ljava/util/concurrent/CancellationException;)V

    invoke-static {}, Lw2/t0;->b()Lw2/c0;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lw2/c0;->g(Li2/g;Ljava/lang/Runnable;)V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 3

    instance-of v0, p1, Lx2/c;

    if-eqz v0, :cond_e

    check-cast p1, Lx2/c;

    iget-object p1, p1, Lx2/c;->f:Landroid/os/Handler;

    iget-object v0, p0, Lx2/c;->f:Landroid/os/Handler;

    if-ne p1, v0, :cond_e

    const/4 p1, 0x1

    goto :goto_f

    :cond_e
    const/4 p1, 0x0

    :goto_f
    return p1
.end method

.method public g(Li2/g;Ljava/lang/Runnable;)V
    .registers 4

    iget-object v0, p0, Lx2/c;->f:Landroid/os/Handler;

    invoke-virtual {v0, p2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    move-result v0

    if-nez v0, :cond_b

    invoke-direct {p0, p1, p2}, Lx2/c;->y(Li2/g;Ljava/lang/Runnable;)V

    :cond_b
    return-void
.end method

.method public hashCode()I
    .registers 2

    iget-object v0, p0, Lx2/c;->f:Landroid/os/Handler;

    invoke-static {v0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public m(Li2/g;)Z
    .registers 3

    iget-boolean p1, p0, Lx2/c;->h:Z

    if-eqz p1, :cond_17

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object p1

    iget-object v0, p0, Lx2/c;->f:Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_15

    goto :goto_17

    :cond_15
    const/4 p1, 0x0

    goto :goto_18

    :cond_17
    :goto_17
    const/4 p1, 0x1

    :goto_18
    return p1
.end method

.method public bridge synthetic p()Lw2/v1;
    .registers 2

    invoke-virtual {p0}, Lx2/c;->z()Lx2/c;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    invoke-virtual {p0}, Lw2/v1;->w()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_25

    iget-object v0, p0, Lx2/c;->g:Ljava/lang/String;

    if-nez v0, :cond_10

    iget-object v0, p0, Lx2/c;->f:Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/Handler;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_10
    iget-boolean v1, p0, Lx2/c;->h:Z

    if-eqz v1, :cond_25

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, ".immediate"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_25
    return-object v0
.end method

.method public z()Lx2/c;
    .registers 2

    iget-object v0, p0, Lx2/c;->i:Lx2/c;

    return-object v0
.end method
