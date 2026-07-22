.class public abstract Lw2/q0;
.super Lkotlinx/coroutines/scheduling/h;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lkotlinx/coroutines/scheduling/h;"
    }
.end annotation


# instance fields
.field public f:I


# direct methods
.method public constructor <init>(I)V
    .registers 2

    invoke-direct {p0}, Lkotlinx/coroutines/scheduling/h;-><init>()V

    iput p1, p0, Lw2/q0;->f:I

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Object;Ljava/lang/Throwable;)V
    .registers 3

    return-void
.end method

.method public abstract c()Li2/d;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Li2/d<",
            "TT;>;"
        }
    .end annotation
.end method

.method public d(Ljava/lang/Object;)Ljava/lang/Throwable;
    .registers 4

    instance-of v0, p1, Lw2/v;

    const/4 v1, 0x0

    if-eqz v0, :cond_8

    check-cast p1, Lw2/v;

    goto :goto_9

    :cond_8
    move-object p1, v1

    :goto_9
    if-eqz p1, :cond_d

    iget-object v1, p1, Lw2/v;->a:Ljava/lang/Throwable;

    :cond_d
    return-object v1
.end method

.method public f(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            ")TT;"
        }
    .end annotation

    return-object p1
.end method

.method public final h(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    .registers 5

    if-nez p1, :cond_5

    if-nez p2, :cond_5

    return-void

    :cond_5
    if-eqz p1, :cond_c

    if-eqz p2, :cond_c

    invoke-static {p1, p2}, Lg2/a;->a(Ljava/lang/Throwable;Ljava/lang/Throwable;)V

    :cond_c
    if-nez p1, :cond_f

    move-object p1, p2

    :cond_f
    new-instance p2, Lw2/j0;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Fatal exception in coroutines machinery for "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ". Please read KDoc to \'handleFatalException\' method and report this incident to maintainers"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1}, Lkotlin/jvm/internal/k;->b(Ljava/lang/Object;)V

    invoke-direct {p2, v0, p1}, Lw2/j0;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-virtual {p0}, Lw2/q0;->c()Li2/d;

    move-result-object p1

    invoke-interface {p1}, Li2/d;->getContext()Li2/g;

    move-result-object p1

    invoke-static {p1, p2}, Lw2/f0;->a(Li2/g;Ljava/lang/Throwable;)V

    return-void
.end method

.method public abstract i()Ljava/lang/Object;
.end method

.method public final run()V
    .registers 11

    iget-object v0, p0, Lkotlinx/coroutines/scheduling/h;->d:Lkotlinx/coroutines/scheduling/i;

    :try_start_2
    invoke-virtual {p0}, Lw2/q0;->c()Li2/d;

    move-result-object v1

    check-cast v1, Lkotlinx/coroutines/internal/f;

    iget-object v2, v1, Lkotlinx/coroutines/internal/f;->h:Li2/d;

    iget-object v1, v1, Lkotlinx/coroutines/internal/f;->j:Ljava/lang/Object;

    invoke-interface {v2}, Li2/d;->getContext()Li2/g;

    move-result-object v3

    invoke-static {v3, v1}, Lkotlinx/coroutines/internal/f0;->c(Li2/g;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    sget-object v4, Lkotlinx/coroutines/internal/f0;->a:Lkotlinx/coroutines/internal/b0;

    const/4 v5, 0x0

    if-eq v1, v4, :cond_1e

    invoke-static {v2, v3, v1}, Lw2/b0;->g(Li2/d;Li2/g;Ljava/lang/Object;)Lw2/e2;

    move-result-object v4
    :try_end_1d
    .catchall {:try_start_2 .. :try_end_1d} :catchall_ab

    goto :goto_1f

    :cond_1e
    move-object v4, v5

    :goto_1f
    :try_start_1f
    invoke-interface {v2}, Li2/d;->getContext()Li2/g;

    move-result-object v6

    invoke-virtual {p0}, Lw2/q0;->i()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {p0, v7}, Lw2/q0;->d(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v8

    if-nez v8, :cond_3e

    iget v9, p0, Lw2/q0;->f:I

    invoke-static {v9}, Lw2/r0;->b(I)Z

    move-result v9

    if-eqz v9, :cond_3e

    sget-object v9, Lw2/l1;->e:Lw2/l1$b;

    invoke-interface {v6, v9}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object v6

    check-cast v6, Lw2/l1;

    goto :goto_3f

    :cond_3e
    move-object v6, v5

    :goto_3f
    if-eqz v6, :cond_5c

    invoke-interface {v6}, Lw2/l1;->isActive()Z

    move-result v9

    if-nez v9, :cond_5c

    invoke-interface {v6}, Lw2/l1;->h()Ljava/util/concurrent/CancellationException;

    move-result-object v6

    invoke-virtual {p0, v7, v6}, Lw2/q0;->a(Ljava/lang/Object;Ljava/lang/Throwable;)V

    sget-object v7, Lg2/k;->c:Lg2/k$a;

    invoke-static {v6}, Lg2/l;->a(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v6

    invoke-static {v6}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    :goto_58
    invoke-interface {v2, v6}, Li2/d;->resumeWith(Ljava/lang/Object;)V

    goto :goto_74

    :cond_5c
    if-eqz v8, :cond_69

    sget-object v6, Lg2/k;->c:Lg2/k$a;

    invoke-static {v8}, Lg2/l;->a(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v6

    invoke-static {v6}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    goto :goto_58

    :cond_69
    sget-object v6, Lg2/k;->c:Lg2/k$a;

    invoke-virtual {p0, v7}, Lw2/q0;->f(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-static {v6}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    goto :goto_58

    :goto_74
    sget-object v2, Lg2/q;->a:Lg2/q;
    :try_end_76
    .catchall {:try_start_1f .. :try_end_76} :catchall_9e

    if-eqz v4, :cond_7e

    :try_start_78
    invoke-virtual {v4}, Lw2/e2;->D0()Z

    move-result v2

    if-eqz v2, :cond_81

    :cond_7e
    invoke-static {v3, v1}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V
    :try_end_81
    .catchall {:try_start_78 .. :try_end_81} :catchall_ab

    :cond_81
    :try_start_81
    invoke-interface {v0}, Lkotlinx/coroutines/scheduling/i;->a()V

    sget-object v0, Lg2/q;->a:Lg2/q;

    invoke-static {v0}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_8a
    .catchall {:try_start_81 .. :try_end_8a} :catchall_8b

    goto :goto_96

    :catchall_8b
    move-exception v0

    sget-object v1, Lg2/k;->c:Lg2/k$a;

    invoke-static {v0}, Lg2/l;->a(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_96
    invoke-static {v0}, Lg2/k;->b(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v0

    invoke-virtual {p0, v5, v0}, Lw2/q0;->h(Ljava/lang/Throwable;Ljava/lang/Throwable;)V

    goto :goto_ca

    :catchall_9e
    move-exception v2

    if-eqz v4, :cond_a7

    :try_start_a1
    invoke-virtual {v4}, Lw2/e2;->D0()Z

    move-result v4

    if-eqz v4, :cond_aa

    :cond_a7
    invoke-static {v3, v1}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V

    :cond_aa
    throw v2
    :try_end_ab
    .catchall {:try_start_a1 .. :try_end_ab} :catchall_ab

    :catchall_ab
    move-exception v1

    :try_start_ac
    sget-object v2, Lg2/k;->c:Lg2/k$a;

    invoke-interface {v0}, Lkotlinx/coroutines/scheduling/i;->a()V

    sget-object v0, Lg2/q;->a:Lg2/q;

    invoke-static {v0}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_b7
    .catchall {:try_start_ac .. :try_end_b7} :catchall_b8

    goto :goto_c3

    :catchall_b8
    move-exception v0

    sget-object v2, Lg2/k;->c:Lg2/k$a;

    invoke-static {v0}, Lg2/l;->a(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_c3
    invoke-static {v0}, Lg2/k;->b(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v0

    invoke-virtual {p0, v1, v0}, Lw2/q0;->h(Ljava/lang/Throwable;Ljava/lang/Throwable;)V

    :goto_ca
    return-void
.end method
