.class public final Lb3/b;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static final a(Lp2/p;Ljava/lang/Object;Li2/d;)V
    .registers 6
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
            "-TT;>;)V"
        }
    .end annotation

    invoke-static {p2}, Lkotlin/coroutines/jvm/internal/h;->a(Li2/d;)Li2/d;

    move-result-object v0

    :try_start_4
    invoke-interface {p2}, Li2/d;->getContext()Li2/g;

    move-result-object p2

    const/4 v1, 0x0

    invoke-static {p2, v1}, Lkotlinx/coroutines/internal/f0;->c(Li2/g;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1
    :try_end_d
    .catchall {:try_start_4 .. :try_end_d} :catchall_27

    const/4 v2, 0x2

    :try_start_e
    invoke-static {p0, v2}, Lkotlin/jvm/internal/t;->a(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lp2/p;

    invoke-interface {p0, p1, v0}, Lp2/p;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0
    :try_end_18
    .catchall {:try_start_e .. :try_end_18} :catchall_22

    :try_start_18
    invoke-static {p2, v1}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V
    :try_end_1b
    .catchall {:try_start_18 .. :try_end_1b} :catchall_27

    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object p1

    if-eq p0, p1, :cond_35

    goto :goto_2e

    :catchall_22
    move-exception p0

    :try_start_23
    invoke-static {p2, v1}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V

    throw p0
    :try_end_27
    .catchall {:try_start_23 .. :try_end_27} :catchall_27

    :catchall_27
    move-exception p0

    sget-object p1, Lg2/k;->c:Lg2/k$a;

    invoke-static {p0}, Lg2/l;->a(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object p0

    :goto_2e
    invoke-static {p0}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    invoke-interface {v0, p0}, Li2/d;->resumeWith(Ljava/lang/Object;)V

    :cond_35
    return-void
.end method

.method public static final b(Lkotlinx/coroutines/internal/z;Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "R:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlinx/coroutines/internal/z<",
            "-TT;>;TR;",
            "Lp2/p<",
            "-TR;-",
            "Li2/d<",
            "-TT;>;+",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    const/4 v0, 0x2

    :try_start_1
    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->a(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lp2/p;

    invoke-interface {p2, p1, p0}, Lp2/p;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1
    :try_end_b
    .catchall {:try_start_1 .. :try_end_b} :catchall_c

    goto :goto_15

    :catchall_c
    move-exception p1

    new-instance p2, Lw2/v;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-direct {p2, p1, v1, v0, v2}, Lw2/v;-><init>(Ljava/lang/Throwable;ZILkotlin/jvm/internal/g;)V

    move-object p1, p2

    :goto_15
    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object p2

    if-ne p1, p2, :cond_20

    :goto_1b
    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object p0

    goto :goto_31

    :cond_20
    invoke-virtual {p0, p1}, Lw2/s1;->b0(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    sget-object p1, Lw2/t1;->b:Lkotlinx/coroutines/internal/b0;

    if-ne p0, p1, :cond_29

    goto :goto_1b

    :cond_29
    instance-of p1, p0, Lw2/v;

    if-nez p1, :cond_32

    invoke-static {p0}, Lw2/t1;->h(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    :goto_31
    return-object p0

    :cond_32
    check-cast p0, Lw2/v;

    iget-object p0, p0, Lw2/v;->a:Ljava/lang/Throwable;

    throw p0
.end method
