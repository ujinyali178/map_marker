.class final synthetic Lw2/h;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static final a(Lw2/g0;Li2/g;Lw2/i0;Lp2/p;)Lw2/l1;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lw2/g0;",
            "Li2/g;",
            "Lw2/i0;",
            "Lp2/p<",
            "-",
            "Lw2/g0;",
            "-",
            "Li2/d<",
            "-",
            "Lg2/q;",
            ">;+",
            "Ljava/lang/Object;",
            ">;)",
            "Lw2/l1;"
        }
    .end annotation

    invoke-static {p0, p1}, Lw2/b0;->e(Lw2/g0;Li2/g;)Li2/g;

    move-result-object p0

    invoke-virtual {p2}, Lw2/i0;->c()Z

    move-result p1

    if-eqz p1, :cond_10

    new-instance p1, Lw2/u1;

    invoke-direct {p1, p0, p3}, Lw2/u1;-><init>(Li2/g;Lp2/p;)V

    goto :goto_16

    :cond_10
    new-instance p1, Lw2/a2;

    const/4 v0, 0x1

    invoke-direct {p1, p0, v0}, Lw2/a2;-><init>(Li2/g;Z)V

    :goto_16
    invoke-virtual {p1, p2, p1, p3}, Lw2/a;->B0(Lw2/i0;Ljava/lang/Object;Lp2/p;)V

    return-object p1
.end method

.method public static synthetic b(Lw2/g0;Li2/g;Lw2/i0;Lp2/p;ILjava/lang/Object;)Lw2/l1;
    .registers 6

    and-int/lit8 p5, p4, 0x1

    if-eqz p5, :cond_6

    sget-object p1, Li2/h;->c:Li2/h;

    :cond_6
    and-int/lit8 p4, p4, 0x2

    if-eqz p4, :cond_c

    sget-object p2, Lw2/i0;->c:Lw2/i0;

    :cond_c
    invoke-static {p0, p1, p2, p3}, Lw2/g;->a(Lw2/g0;Li2/g;Lw2/i0;Lp2/p;)Lw2/l1;

    move-result-object p0

    return-object p0
.end method

.method public static final c(Li2/g;Lp2/p;Li2/d;)Ljava/lang/Object;
    .registers 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Li2/g;",
            "Lp2/p<",
            "-",
            "Lw2/g0;",
            "-",
            "Li2/d<",
            "-TT;>;+",
            "Ljava/lang/Object;",
            ">;",
            "Li2/d<",
            "-TT;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    invoke-interface {p2}, Li2/d;->getContext()Li2/g;

    move-result-object v0

    invoke-static {v0, p0}, Lw2/b0;->d(Li2/g;Li2/g;)Li2/g;

    move-result-object p0

    invoke-static {p0}, Lw2/p1;->e(Li2/g;)V

    if-ne p0, v0, :cond_17

    new-instance v0, Lkotlinx/coroutines/internal/z;

    invoke-direct {v0, p0, p2}, Lkotlinx/coroutines/internal/z;-><init>(Li2/g;Li2/d;)V

    invoke-static {v0, v0, p1}, Lb3/b;->b(Lkotlinx/coroutines/internal/z;Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;

    move-result-object p0

    goto :goto_51

    :cond_17
    sget-object v1, Li2/e;->a:Li2/e$b;

    invoke-interface {p0, v1}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object v2

    invoke-interface {v0, v1}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object v0

    invoke-static {v2, v0}, Lkotlin/jvm/internal/k;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3f

    new-instance v0, Lw2/e2;

    invoke-direct {v0, p0, p2}, Lw2/e2;-><init>(Li2/g;Li2/d;)V

    const/4 v1, 0x0

    invoke-static {p0, v1}, Lkotlinx/coroutines/internal/f0;->c(Li2/g;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    :try_start_31
    invoke-static {v0, v0, p1}, Lb3/b;->b(Lkotlinx/coroutines/internal/z;Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;

    move-result-object p1
    :try_end_35
    .catchall {:try_start_31 .. :try_end_35} :catchall_3a

    invoke-static {p0, v1}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V

    move-object p0, p1

    goto :goto_51

    :catchall_3a
    move-exception p1

    invoke-static {p0, v1}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V

    throw p1

    :cond_3f
    new-instance v0, Lw2/p0;

    invoke-direct {v0, p0, p2}, Lw2/p0;-><init>(Li2/g;Li2/d;)V

    const/4 v5, 0x0

    const/4 v6, 0x4

    const/4 v7, 0x0

    move-object v2, p1

    move-object v3, v0

    move-object v4, v0

    invoke-static/range {v2 .. v7}, Lb3/a;->d(Lp2/p;Ljava/lang/Object;Li2/d;Lp2/l;ILjava/lang/Object;)V

    invoke-virtual {v0}, Lw2/p0;->D0()Ljava/lang/Object;

    move-result-object p0

    :goto_51
    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object p1

    if-ne p0, p1, :cond_5a

    invoke-static {p2}, Lkotlin/coroutines/jvm/internal/h;->c(Li2/d;)V

    :cond_5a
    return-object p0
.end method
