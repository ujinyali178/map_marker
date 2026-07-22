.class public final Lkotlinx/coroutines/internal/v;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static final a(Lp2/l;Ljava/lang/Object;Li2/g;)Lp2/l;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Lp2/l<",
            "-TE;",
            "Lg2/q;",
            ">;TE;",
            "Li2/g;",
            ")",
            "Lp2/l<",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;"
        }
    .end annotation

    new-instance v0, Lkotlinx/coroutines/internal/v$a;

    invoke-direct {v0, p0, p1, p2}, Lkotlinx/coroutines/internal/v$a;-><init>(Lp2/l;Ljava/lang/Object;Li2/g;)V

    return-object v0
.end method

.method public static final b(Lp2/l;Ljava/lang/Object;Li2/g;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Lp2/l<",
            "-TE;",
            "Lg2/q;",
            ">;TE;",
            "Li2/g;",
            ")V"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lkotlinx/coroutines/internal/v;->c(Lp2/l;Ljava/lang/Object;Lkotlinx/coroutines/internal/j0;)Lkotlinx/coroutines/internal/j0;

    move-result-object p0

    if-eqz p0, :cond_a

    invoke-static {p2, p0}, Lw2/f0;->a(Li2/g;Ljava/lang/Throwable;)V

    :cond_a
    return-void
.end method

.method public static final c(Lp2/l;Ljava/lang/Object;Lkotlinx/coroutines/internal/j0;)Lkotlinx/coroutines/internal/j0;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Lp2/l<",
            "-TE;",
            "Lg2/q;",
            ">;TE;",
            "Lkotlinx/coroutines/internal/j0;",
            ")",
            "Lkotlinx/coroutines/internal/j0;"
        }
    .end annotation

    :try_start_0
    invoke-interface {p0, p1}, Lp2/l;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_3
    .catchall {:try_start_0 .. :try_end_3} :catchall_4

    goto :goto_10

    :catchall_4
    move-exception p0

    if-eqz p2, :cond_11

    invoke-virtual {p2}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    if-eq v0, p0, :cond_11

    invoke-static {p2, p0}, Lg2/a;->a(Ljava/lang/Throwable;Ljava/lang/Throwable;)V

    :goto_10
    return-object p2

    :cond_11
    new-instance p2, Lkotlinx/coroutines/internal/j0;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Exception in undelivered element handler for "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1, p0}, Lkotlinx/coroutines/internal/j0;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    return-object p2
.end method

.method public static synthetic d(Lp2/l;Ljava/lang/Object;Lkotlinx/coroutines/internal/j0;ILjava/lang/Object;)Lkotlinx/coroutines/internal/j0;
    .registers 5

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_5

    const/4 p2, 0x0

    :cond_5
    invoke-static {p0, p1, p2}, Lkotlinx/coroutines/internal/v;->c(Lp2/l;Ljava/lang/Object;Lkotlinx/coroutines/internal/j0;)Lkotlinx/coroutines/internal/j0;

    move-result-object p0

    return-object p0
.end method
