.class final synthetic Lw2/q1;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static final a(Lw2/l1;)Lw2/t;
    .registers 2

    new-instance v0, Lw2/o1;

    invoke-direct {v0, p0}, Lw2/o1;-><init>(Lw2/l1;)V

    return-object v0
.end method

.method public static synthetic b(Lw2/l1;ILjava/lang/Object;)Lw2/t;
    .registers 3

    and-int/lit8 p1, p1, 0x1

    if-eqz p1, :cond_5

    const/4 p0, 0x0

    :cond_5
    invoke-static {p0}, Lw2/p1;->a(Lw2/l1;)Lw2/t;

    move-result-object p0

    return-object p0
.end method

.method public static final c(Li2/g;Ljava/util/concurrent/CancellationException;)V
    .registers 3

    sget-object v0, Lw2/l1;->e:Lw2/l1$b;

    invoke-interface {p0, v0}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object p0

    check-cast p0, Lw2/l1;

    if-eqz p0, :cond_d

    invoke-interface {p0, p1}, Lw2/l1;->t(Ljava/util/concurrent/CancellationException;)V

    :cond_d
    return-void
.end method

.method public static synthetic d(Li2/g;Ljava/util/concurrent/CancellationException;ILjava/lang/Object;)V
    .registers 4

    and-int/lit8 p2, p2, 0x1

    if-eqz p2, :cond_5

    const/4 p1, 0x0

    :cond_5
    invoke-static {p0, p1}, Lw2/p1;->c(Li2/g;Ljava/util/concurrent/CancellationException;)V

    return-void
.end method

.method public static final e(Li2/g;)V
    .registers 2

    sget-object v0, Lw2/l1;->e:Lw2/l1$b;

    invoke-interface {p0, v0}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object p0

    check-cast p0, Lw2/l1;

    if-eqz p0, :cond_d

    invoke-static {p0}, Lw2/p1;->f(Lw2/l1;)V

    :cond_d
    return-void
.end method

.method public static final f(Lw2/l1;)V
    .registers 2

    invoke-interface {p0}, Lw2/l1;->isActive()Z

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    invoke-interface {p0}, Lw2/l1;->h()Ljava/util/concurrent/CancellationException;

    move-result-object p0

    throw p0
.end method
