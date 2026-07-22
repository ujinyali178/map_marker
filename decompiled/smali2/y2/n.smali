.class public Ly2/n;
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

    return-void
.end method


# virtual methods
.method protected i(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    :cond_0
    invoke-super {p0, p1}, Ly2/c;->i(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Ly2/b;->b:Lkotlinx/coroutines/internal/b0;

    if-ne v0, v1, :cond_9

    return-object v1

    :cond_9
    sget-object v2, Ly2/b;->c:Lkotlinx/coroutines/internal/b0;

    if-ne v0, v2, :cond_19

    invoke-virtual {p0, p1}, Ly2/c;->k(Ljava/lang/Object;)Ly2/q;

    move-result-object v0

    if-nez v0, :cond_14

    return-object v1

    :cond_14
    instance-of v1, v0, Ly2/j;

    if-eqz v1, :cond_0

    return-object v0

    :cond_19
    instance-of p1, v0, Ly2/j;

    if-eqz p1, :cond_1e

    return-object v0

    :cond_1e
    new-instance p1, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid offerInternal result "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method protected final r()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method

.method protected final s()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method
