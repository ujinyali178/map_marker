.class public final Ly2/j;
.super Ly2/s;
.source "SourceFile"

# interfaces
.implements Ly2/q;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ly2/s;",
        "Ly2/q<",
        "TE;>;"
    }
.end annotation


# instance fields
.field public final g:Ljava/lang/Throwable;


# virtual methods
.method public B()Ly2/j;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ly2/j<",
            "TE;>;"
        }
    .end annotation

    return-object p0
.end method

.method public C()Ly2/j;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ly2/j<",
            "TE;>;"
        }
    .end annotation

    return-object p0
.end method

.method public final D()Ljava/lang/Throwable;
    .registers 3

    iget-object v0, p0, Ly2/j;->g:Ljava/lang/Throwable;

    if-nez v0, :cond_b

    new-instance v0, Ly2/k;

    const-string v1, "Channel was closed"

    invoke-direct {v0, v1}, Ly2/k;-><init>(Ljava/lang/String;)V

    :cond_b
    return-object v0
.end method

.method public final E()Ljava/lang/Throwable;
    .registers 3

    iget-object v0, p0, Ly2/j;->g:Ljava/lang/Throwable;

    if-nez v0, :cond_b

    new-instance v0, Ly2/l;

    const-string v1, "Channel was closed"

    invoke-direct {v0, v1}, Ly2/l;-><init>(Ljava/lang/String;)V

    :cond_b
    return-object v0
.end method

.method public bridge synthetic b()Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0}, Ly2/j;->B()Ly2/j;

    move-result-object v0

    return-object v0
.end method

.method public f(Ljava/lang/Object;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)V"
        }
    .end annotation

    return-void
.end method

.method public g(Ljava/lang/Object;Lkotlinx/coroutines/internal/o$b;)Lkotlinx/coroutines/internal/b0;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;",
            "Lkotlinx/coroutines/internal/o$b;",
            ")",
            "Lkotlinx/coroutines/internal/b0;"
        }
    .end annotation

    sget-object p1, Lw2/m;->a:Lkotlinx/coroutines/internal/b0;

    return-object p1
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Closed@"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p0}, Lw2/k0;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x5b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget-object v1, p0, Ly2/j;->g:Ljava/lang/Throwable;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public x()V
    .registers 1

    return-void
.end method

.method public bridge synthetic y()Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0}, Ly2/j;->C()Ly2/j;

    move-result-object v0

    return-object v0
.end method

.method public z(Lkotlinx/coroutines/internal/o$b;)Lkotlinx/coroutines/internal/b0;
    .registers 2

    sget-object p1, Lw2/m;->a:Lkotlinx/coroutines/internal/b0;

    return-object p1
.end method
