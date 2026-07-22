.class public final Lb3/a;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method private static final a(Li2/d;Ljava/lang/Throwable;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/d<",
            "*>;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    sget-object v0, Lg2/k;->c:Lg2/k$a;

    invoke-static {p1}, Lg2/l;->a(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p0, v0}, Li2/d;->resumeWith(Ljava/lang/Object;)V

    throw p1
.end method

.method public static final b(Li2/d;Li2/d;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/d<",
            "-",
            "Lg2/q;",
            ">;",
            "Li2/d<",
            "*>;)V"
        }
    .end annotation

    :try_start_0
    invoke-static {p0}, Lj2/b;->b(Li2/d;)Li2/d;

    move-result-object p0

    sget-object v0, Lg2/k;->c:Lg2/k$a;

    sget-object v0, Lg2/q;->a:Lg2/q;

    invoke-static {v0}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-static {p0, v0, v2, v1, v2}, Lkotlinx/coroutines/internal/g;->c(Li2/d;Ljava/lang/Object;Lp2/l;ILjava/lang/Object;)V
    :try_end_11
    .catchall {:try_start_0 .. :try_end_11} :catchall_12

    goto :goto_16

    :catchall_12
    move-exception p0

    invoke-static {p1, p0}, Lb3/a;->a(Li2/d;Ljava/lang/Throwable;)V

    :goto_16
    return-void
.end method

.method public static final c(Lp2/p;Ljava/lang/Object;Li2/d;Lp2/l;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<R:",
            "Ljava/lang/Object;",
            "T:",
            "Ljava/lang/Object;",
            ">(",
            "Lp2/p<",
            "-TR;-",
            "Li2/d<",
            "-TT;>;+",
            "Ljava/lang/Object;",
            ">;TR;",
            "Li2/d<",
            "-TT;>;",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;)V"
        }
    .end annotation

    :try_start_0
    invoke-static {p0, p1, p2}, Lj2/b;->a(Lp2/p;Ljava/lang/Object;Li2/d;)Li2/d;

    move-result-object p0

    invoke-static {p0}, Lj2/b;->b(Li2/d;)Li2/d;

    move-result-object p0

    sget-object p1, Lg2/k;->c:Lg2/k$a;

    sget-object p1, Lg2/q;->a:Lg2/q;

    invoke-static {p1}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    invoke-static {p0, p1, p3}, Lkotlinx/coroutines/internal/g;->b(Li2/d;Ljava/lang/Object;Lp2/l;)V
    :try_end_13
    .catchall {:try_start_0 .. :try_end_13} :catchall_14

    goto :goto_18

    :catchall_14
    move-exception p0

    invoke-static {p2, p0}, Lb3/a;->a(Li2/d;Ljava/lang/Throwable;)V

    :goto_18
    return-void
.end method

.method public static synthetic d(Lp2/p;Ljava/lang/Object;Li2/d;Lp2/l;ILjava/lang/Object;)V
    .registers 6

    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_5

    const/4 p3, 0x0

    :cond_5
    invoke-static {p0, p1, p2, p3}, Lb3/a;->c(Lp2/p;Ljava/lang/Object;Li2/d;Lp2/l;)V

    return-void
.end method
