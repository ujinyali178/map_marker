.class final Lkotlinx/coroutines/internal/u;
.super Lw2/v1;
.source "SourceFile"

# interfaces
.implements Lw2/n0;


# instance fields
.field private final f:Ljava/lang/Throwable;

.field private final g:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/Throwable;Ljava/lang/String;)V
    .registers 3

    invoke-direct {p0}, Lw2/v1;-><init>()V

    iput-object p1, p0, Lkotlinx/coroutines/internal/u;->f:Ljava/lang/Throwable;

    iput-object p2, p0, Lkotlinx/coroutines/internal/u;->g:Ljava/lang/String;

    return-void
.end method

.method private final z()Ljava/lang/Void;
    .registers 5

    iget-object v0, p0, Lkotlinx/coroutines/internal/u;->f:Ljava/lang/Throwable;

    if-eqz v0, :cond_36

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Module with the Main dispatcher had failed to initialize"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lkotlinx/coroutines/internal/u;->g:Ljava/lang/String;

    if-eqz v1, :cond_25

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ". "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_27

    :cond_25
    const-string v1, ""

    :cond_27
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/IllegalStateException;

    iget-object v2, p0, Lkotlinx/coroutines/internal/u;->f:Ljava/lang/Throwable;

    invoke-direct {v1, v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    :cond_36
    invoke-static {}, Lkotlinx/coroutines/internal/t;->d()Ljava/lang/Void;

    new-instance v0, Lg2/d;

    invoke-direct {v0}, Lg2/d;-><init>()V

    throw v0
.end method


# virtual methods
.method public bridge synthetic g(Li2/g;Ljava/lang/Runnable;)V
    .registers 3

    invoke-virtual {p0, p1, p2}, Lkotlinx/coroutines/internal/u;->y(Li2/g;Ljava/lang/Runnable;)Ljava/lang/Void;

    return-void
.end method

.method public m(Li2/g;)Z
    .registers 2

    invoke-direct {p0}, Lkotlinx/coroutines/internal/u;->z()Ljava/lang/Void;

    new-instance p1, Lg2/d;

    invoke-direct {p1}, Lg2/d;-><init>()V

    throw p1
.end method

.method public p()Lw2/v1;
    .registers 1

    return-object p0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Dispatchers.Main[missing"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lkotlinx/coroutines/internal/u;->f:Ljava/lang/Throwable;

    if-eqz v1, :cond_22

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ", cause="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lkotlinx/coroutines/internal/u;->f:Ljava/lang/Throwable;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_24

    :cond_22
    const-string v1, ""

    :goto_24
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public y(Li2/g;Ljava/lang/Runnable;)Ljava/lang/Void;
    .registers 3

    invoke-direct {p0}, Lkotlinx/coroutines/internal/u;->z()Ljava/lang/Void;

    new-instance p1, Lg2/d;

    invoke-direct {p1}, Lg2/d;-><init>()V

    throw p1
.end method
