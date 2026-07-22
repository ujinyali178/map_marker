.class public final Lw2/n;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static final a(Li2/d;)Lw2/l;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Li2/d<",
            "-TT;>;)",
            "Lw2/l<",
            "TT;>;"
        }
    .end annotation

    instance-of v0, p0, Lkotlinx/coroutines/internal/f;

    if-nez v0, :cond_b

    new-instance v0, Lw2/l;

    const/4 v1, 0x1

    invoke-direct {v0, p0, v1}, Lw2/l;-><init>(Li2/d;I)V

    return-object v0

    :cond_b
    move-object v0, p0

    check-cast v0, Lkotlinx/coroutines/internal/f;

    invoke-virtual {v0}, Lkotlinx/coroutines/internal/f;->k()Lw2/l;

    move-result-object v0

    if-eqz v0, :cond_20

    invoke-virtual {v0}, Lw2/l;->G()Z

    move-result v1

    if-eqz v1, :cond_1b

    goto :goto_1c

    :cond_1b
    const/4 v0, 0x0

    :goto_1c
    if-nez v0, :cond_1f

    goto :goto_20

    :cond_1f
    return-object v0

    :cond_20
    :goto_20
    new-instance v0, Lw2/l;

    const/4 v1, 0x2

    invoke-direct {v0, p0, v1}, Lw2/l;-><init>(Li2/d;I)V

    return-object v0
.end method
