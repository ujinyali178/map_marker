.class public final Lw2/b0;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method private static final a(Li2/g;Li2/g;Z)Li2/g;
    .registers 6

    invoke-static {p0}, Lw2/b0;->c(Li2/g;)Z

    move-result v0

    invoke-static {p1}, Lw2/b0;->c(Li2/g;)Z

    move-result v1

    if-nez v0, :cond_11

    if-nez v1, :cond_11

    invoke-interface {p0, p1}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object p0

    return-object p0

    :cond_11
    new-instance v0, Lkotlin/jvm/internal/q;

    invoke-direct {v0}, Lkotlin/jvm/internal/q;-><init>()V

    iput-object p1, v0, Lkotlin/jvm/internal/q;->c:Ljava/lang/Object;

    sget-object p1, Li2/h;->c:Li2/h;

    new-instance v2, Lw2/b0$b;

    invoke-direct {v2, v0, p2}, Lw2/b0$b;-><init>(Lkotlin/jvm/internal/q;Z)V

    invoke-interface {p0, p1, v2}, Li2/g;->x(Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Li2/g;

    if-eqz v1, :cond_33

    iget-object p2, v0, Lkotlin/jvm/internal/q;->c:Ljava/lang/Object;

    check-cast p2, Li2/g;

    sget-object v1, Lw2/b0$a;->c:Lw2/b0$a;

    invoke-interface {p2, p1, v1}, Li2/g;->x(Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;

    move-result-object p1

    iput-object p1, v0, Lkotlin/jvm/internal/q;->c:Ljava/lang/Object;

    :cond_33
    iget-object p1, v0, Lkotlin/jvm/internal/q;->c:Ljava/lang/Object;

    check-cast p1, Li2/g;

    invoke-interface {p0, p1}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object p0

    return-object p0
.end method

.method public static final b(Li2/g;)Ljava/lang/String;
    .registers 1

    const/4 p0, 0x0

    return-object p0
.end method

.method private static final c(Li2/g;)Z
    .registers 3

    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    sget-object v1, Lw2/b0$c;->c:Lw2/b0$c;

    invoke-interface {p0, v0, v1}, Li2/g;->x(Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Boolean;

    invoke-virtual {p0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p0

    return p0
.end method

.method public static final d(Li2/g;Li2/g;)Li2/g;
    .registers 3

    invoke-static {p1}, Lw2/b0;->c(Li2/g;)Z

    move-result v0

    if-nez v0, :cond_b

    invoke-interface {p0, p1}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object p0

    return-object p0

    :cond_b
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lw2/b0;->a(Li2/g;Li2/g;Z)Li2/g;

    move-result-object p0

    return-object p0
.end method

.method public static final e(Lw2/g0;Li2/g;)Li2/g;
    .registers 3

    invoke-interface {p0}, Lw2/g0;->p()Li2/g;

    move-result-object p0

    const/4 v0, 0x1

    invoke-static {p0, p1, v0}, Lw2/b0;->a(Li2/g;Li2/g;Z)Li2/g;

    move-result-object p0

    invoke-static {}, Lw2/t0;->a()Lw2/c0;

    move-result-object p1

    if-eq p0, p1, :cond_1f

    sget-object p1, Li2/e;->a:Li2/e$b;

    invoke-interface {p0, p1}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object p1

    if-nez p1, :cond_1f

    invoke-static {}, Lw2/t0;->a()Lw2/c0;

    move-result-object p1

    invoke-interface {p0, p1}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object p0

    :cond_1f
    return-object p0
.end method

.method public static final f(Lkotlin/coroutines/jvm/internal/e;)Lw2/e2;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/coroutines/jvm/internal/e;",
            ")",
            "Lw2/e2<",
            "*>;"
        }
    .end annotation

    :cond_0
    instance-of v0, p0, Lw2/p0;

    const/4 v1, 0x0

    if-eqz v0, :cond_6

    return-object v1

    :cond_6
    invoke-interface {p0}, Lkotlin/coroutines/jvm/internal/e;->getCallerFrame()Lkotlin/coroutines/jvm/internal/e;

    move-result-object p0

    if-nez p0, :cond_d

    return-object v1

    :cond_d
    instance-of v0, p0, Lw2/e2;

    if-eqz v0, :cond_0

    check-cast p0, Lw2/e2;

    return-object p0
.end method

.method public static final g(Li2/d;Li2/g;Ljava/lang/Object;)Lw2/e2;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/d<",
            "*>;",
            "Li2/g;",
            "Ljava/lang/Object;",
            ")",
            "Lw2/e2<",
            "*>;"
        }
    .end annotation

    instance-of v0, p0, Lkotlin/coroutines/jvm/internal/e;

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return-object v1

    :cond_6
    sget-object v0, Lw2/f2;->c:Lw2/f2;

    invoke-interface {p1, v0}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object v0

    if-eqz v0, :cond_10

    const/4 v0, 0x1

    goto :goto_11

    :cond_10
    const/4 v0, 0x0

    :goto_11
    if-nez v0, :cond_14

    return-object v1

    :cond_14
    check-cast p0, Lkotlin/coroutines/jvm/internal/e;

    invoke-static {p0}, Lw2/b0;->f(Lkotlin/coroutines/jvm/internal/e;)Lw2/e2;

    move-result-object p0

    if-eqz p0, :cond_1f

    invoke-virtual {p0, p1, p2}, Lw2/e2;->E0(Li2/g;Ljava/lang/Object;)V

    :cond_1f
    return-object p0
.end method
