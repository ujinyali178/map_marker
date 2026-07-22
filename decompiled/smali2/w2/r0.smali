.class public final Lw2/r0;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static final a(Lw2/q0;I)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lw2/q0<",
            "-TT;>;I)V"
        }
    .end annotation

    invoke-virtual {p0}, Lw2/q0;->c()Li2/d;

    move-result-object v0

    const/4 v1, 0x4

    if-ne p1, v1, :cond_9

    const/4 v1, 0x1

    goto :goto_a

    :cond_9
    const/4 v1, 0x0

    :goto_a
    if-nez v1, :cond_33

    instance-of v2, v0, Lkotlinx/coroutines/internal/f;

    if-eqz v2, :cond_33

    invoke-static {p1}, Lw2/r0;->b(I)Z

    move-result p1

    iget v2, p0, Lw2/q0;->f:I

    invoke-static {v2}, Lw2/r0;->b(I)Z

    move-result v2

    if-ne p1, v2, :cond_33

    move-object p1, v0

    check-cast p1, Lkotlinx/coroutines/internal/f;

    iget-object p1, p1, Lkotlinx/coroutines/internal/f;->g:Lw2/c0;

    invoke-interface {v0}, Li2/d;->getContext()Li2/g;

    move-result-object v0

    invoke-virtual {p1, v0}, Lw2/c0;->m(Li2/g;)Z

    move-result v1

    if-eqz v1, :cond_2f

    invoke-virtual {p1, v0, p0}, Lw2/c0;->g(Li2/g;Ljava/lang/Runnable;)V

    goto :goto_36

    :cond_2f
    invoke-static {p0}, Lw2/r0;->e(Lw2/q0;)V

    goto :goto_36

    :cond_33
    invoke-static {p0, v0, v1}, Lw2/r0;->d(Lw2/q0;Li2/d;Z)V

    :goto_36
    return-void
.end method

.method public static final b(I)Z
    .registers 3

    const/4 v0, 0x1

    if-eq p0, v0, :cond_8

    const/4 v1, 0x2

    if-ne p0, v1, :cond_7

    goto :goto_8

    :cond_7
    const/4 v0, 0x0

    :cond_8
    :goto_8
    return v0
.end method

.method public static final c(I)Z
    .registers 2

    const/4 v0, 0x2

    if-ne p0, v0, :cond_5

    const/4 p0, 0x1

    goto :goto_6

    :cond_5
    const/4 p0, 0x0

    :goto_6
    return p0
.end method

.method public static final d(Lw2/q0;Li2/d;Z)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lw2/q0<",
            "-TT;>;",
            "Li2/d<",
            "-TT;>;Z)V"
        }
    .end annotation

    invoke-virtual {p0}, Lw2/q0;->i()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p0, v0}, Lw2/q0;->d(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v1

    if-eqz v1, :cond_11

    sget-object p0, Lg2/k;->c:Lg2/k$a;

    invoke-static {v1}, Lg2/l;->a(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object p0

    goto :goto_17

    :cond_11
    sget-object v1, Lg2/k;->c:Lg2/k$a;

    invoke-virtual {p0, v0}, Lw2/q0;->f(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    :goto_17
    invoke-static {p0}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    if-eqz p2, :cond_55

    check-cast p1, Lkotlinx/coroutines/internal/f;

    iget-object p2, p1, Lkotlinx/coroutines/internal/f;->h:Li2/d;

    iget-object v0, p1, Lkotlinx/coroutines/internal/f;->j:Ljava/lang/Object;

    invoke-interface {p2}, Li2/d;->getContext()Li2/g;

    move-result-object v1

    invoke-static {v1, v0}, Lkotlinx/coroutines/internal/f0;->c(Li2/g;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    sget-object v2, Lkotlinx/coroutines/internal/f0;->a:Lkotlinx/coroutines/internal/b0;

    if-eq v0, v2, :cond_34

    invoke-static {p2, v1, v0}, Lw2/b0;->g(Li2/d;Li2/g;Ljava/lang/Object;)Lw2/e2;

    move-result-object p2

    goto :goto_35

    :cond_34
    const/4 p2, 0x0

    :goto_35
    :try_start_35
    iget-object p1, p1, Lkotlinx/coroutines/internal/f;->h:Li2/d;

    invoke-interface {p1, p0}, Li2/d;->resumeWith(Ljava/lang/Object;)V

    sget-object p0, Lg2/q;->a:Lg2/q;
    :try_end_3c
    .catchall {:try_start_35 .. :try_end_3c} :catchall_48

    if-eqz p2, :cond_44

    invoke-virtual {p2}, Lw2/e2;->D0()Z

    move-result p0

    if-eqz p0, :cond_58

    :cond_44
    invoke-static {v1, v0}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V

    goto :goto_58

    :catchall_48
    move-exception p0

    if-eqz p2, :cond_51

    invoke-virtual {p2}, Lw2/e2;->D0()Z

    move-result p1

    if-eqz p1, :cond_54

    :cond_51
    invoke-static {v1, v0}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V

    :cond_54
    throw p0

    :cond_55
    invoke-interface {p1, p0}, Li2/d;->resumeWith(Ljava/lang/Object;)V

    :cond_58
    :goto_58
    return-void
.end method

.method private static final e(Lw2/q0;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lw2/q0<",
            "*>;)V"
        }
    .end annotation

    sget-object v0, Lw2/c2;->a:Lw2/c2;

    invoke-virtual {v0}, Lw2/c2;->a()Lw2/w0;

    move-result-object v0

    invoke-virtual {v0}, Lw2/w0;->C()Z

    move-result v1

    if-eqz v1, :cond_10

    invoke-virtual {v0, p0}, Lw2/w0;->y(Lw2/q0;)V

    goto :goto_2a

    :cond_10
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lw2/w0;->A(Z)V

    :try_start_14
    invoke-virtual {p0}, Lw2/q0;->c()Li2/d;

    move-result-object v2

    invoke-static {p0, v2, v1}, Lw2/r0;->d(Lw2/q0;Li2/d;Z)V

    :cond_1b
    invoke-virtual {v0}, Lw2/w0;->E()Z

    move-result v2
    :try_end_1f
    .catchall {:try_start_14 .. :try_end_1f} :catchall_22

    if-nez v2, :cond_1b

    goto :goto_27

    :catchall_22
    move-exception v2

    const/4 v3, 0x0

    :try_start_24
    invoke-virtual {p0, v2, v3}, Lw2/q0;->h(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    :try_end_27
    .catchall {:try_start_24 .. :try_end_27} :catchall_2b

    :goto_27
    invoke-virtual {v0, v1}, Lw2/w0;->p(Z)V

    :goto_2a
    return-void

    :catchall_2b
    move-exception p0

    invoke-virtual {v0, v1}, Lw2/w0;->p(Z)V

    throw p0
.end method
