.class public final Lkotlinx/coroutines/internal/g;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Lkotlinx/coroutines/internal/b0;

.field public static final b:Lkotlinx/coroutines/internal/b0;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lkotlinx/coroutines/internal/b0;

    const-string v1, "UNDEFINED"

    invoke-direct {v0, v1}, Lkotlinx/coroutines/internal/b0;-><init>(Ljava/lang/String;)V

    sput-object v0, Lkotlinx/coroutines/internal/g;->a:Lkotlinx/coroutines/internal/b0;

    new-instance v0, Lkotlinx/coroutines/internal/b0;

    const-string v1, "REUSABLE_CLAIMED"

    invoke-direct {v0, v1}, Lkotlinx/coroutines/internal/b0;-><init>(Ljava/lang/String;)V

    sput-object v0, Lkotlinx/coroutines/internal/g;->b:Lkotlinx/coroutines/internal/b0;

    return-void
.end method

.method public static final synthetic a()Lkotlinx/coroutines/internal/b0;
    .registers 1

    sget-object v0, Lkotlinx/coroutines/internal/g;->a:Lkotlinx/coroutines/internal/b0;

    return-object v0
.end method

.method public static final b(Li2/d;Ljava/lang/Object;Lp2/l;)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Li2/d<",
            "-TT;>;",
            "Ljava/lang/Object;",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;)V"
        }
    .end annotation

    instance-of v0, p0, Lkotlinx/coroutines/internal/f;

    if-eqz v0, :cond_b6

    check-cast p0, Lkotlinx/coroutines/internal/f;

    invoke-static {p1, p2}, Lw2/z;->b(Ljava/lang/Object;Lp2/l;)Ljava/lang/Object;

    move-result-object p2

    iget-object v0, p0, Lkotlinx/coroutines/internal/f;->g:Lw2/c0;

    invoke-virtual {p0}, Lkotlinx/coroutines/internal/f;->getContext()Li2/g;

    move-result-object v1

    invoke-virtual {v0, v1}, Lw2/c0;->m(Li2/g;)Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_26

    iput-object p2, p0, Lkotlinx/coroutines/internal/f;->i:Ljava/lang/Object;

    iput v1, p0, Lw2/q0;->f:I

    iget-object p1, p0, Lkotlinx/coroutines/internal/f;->g:Lw2/c0;

    invoke-virtual {p0}, Lkotlinx/coroutines/internal/f;->getContext()Li2/g;

    move-result-object p2

    invoke-virtual {p1, p2, p0}, Lw2/c0;->g(Li2/g;Ljava/lang/Runnable;)V

    goto/16 :goto_b9

    :cond_26
    sget-object v0, Lw2/c2;->a:Lw2/c2;

    invoke-virtual {v0}, Lw2/c2;->a()Lw2/w0;

    move-result-object v0

    invoke-virtual {v0}, Lw2/w0;->C()Z

    move-result v2

    if-eqz v2, :cond_3b

    iput-object p2, p0, Lkotlinx/coroutines/internal/f;->i:Ljava/lang/Object;

    iput v1, p0, Lw2/q0;->f:I

    invoke-virtual {v0, p0}, Lw2/w0;->y(Lw2/q0;)V

    goto/16 :goto_b9

    :cond_3b
    invoke-virtual {v0, v1}, Lw2/w0;->A(Z)V

    const/4 v2, 0x0

    :try_start_3f
    invoke-virtual {p0}, Lkotlinx/coroutines/internal/f;->getContext()Li2/g;

    move-result-object v3

    sget-object v4, Lw2/l1;->e:Lw2/l1$b;

    invoke-interface {v3, v4}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object v3

    check-cast v3, Lw2/l1;

    if-eqz v3, :cond_69

    invoke-interface {v3}, Lw2/l1;->isActive()Z

    move-result v4

    if-nez v4, :cond_69

    invoke-interface {v3}, Lw2/l1;->h()Ljava/util/concurrent/CancellationException;

    move-result-object v3

    invoke-virtual {p0, p2, v3}, Lkotlinx/coroutines/internal/f;->a(Ljava/lang/Object;Ljava/lang/Throwable;)V

    sget-object p2, Lg2/k;->c:Lg2/k$a;

    invoke-static {v3}, Lg2/l;->a(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object p2

    invoke-static {p2}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    invoke-interface {p0, p2}, Li2/d;->resumeWith(Ljava/lang/Object;)V

    const/4 p2, 0x1

    goto :goto_6a

    :cond_69
    const/4 p2, 0x0

    :goto_6a
    if-nez p2, :cond_a2

    iget-object p2, p0, Lkotlinx/coroutines/internal/f;->h:Li2/d;

    iget-object v3, p0, Lkotlinx/coroutines/internal/f;->j:Ljava/lang/Object;

    invoke-interface {p2}, Li2/d;->getContext()Li2/g;

    move-result-object v4

    invoke-static {v4, v3}, Lkotlinx/coroutines/internal/f0;->c(Li2/g;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    sget-object v5, Lkotlinx/coroutines/internal/f0;->a:Lkotlinx/coroutines/internal/b0;

    if-eq v3, v5, :cond_81

    invoke-static {p2, v4, v3}, Lw2/b0;->g(Li2/d;Li2/g;Ljava/lang/Object;)Lw2/e2;

    move-result-object p2
    :try_end_80
    .catchall {:try_start_3f .. :try_end_80} :catchall_a9

    goto :goto_82

    :cond_81
    move-object p2, v2

    :goto_82
    :try_start_82
    iget-object v5, p0, Lkotlinx/coroutines/internal/f;->h:Li2/d;

    invoke-interface {v5, p1}, Li2/d;->resumeWith(Ljava/lang/Object;)V

    sget-object p1, Lg2/q;->a:Lg2/q;
    :try_end_89
    .catchall {:try_start_82 .. :try_end_89} :catchall_95

    if-eqz p2, :cond_91

    :try_start_8b
    invoke-virtual {p2}, Lw2/e2;->D0()Z

    move-result p1

    if-eqz p1, :cond_a2

    :cond_91
    invoke-static {v4, v3}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V

    goto :goto_a2

    :catchall_95
    move-exception p1

    if-eqz p2, :cond_9e

    invoke-virtual {p2}, Lw2/e2;->D0()Z

    move-result p2

    if-eqz p2, :cond_a1

    :cond_9e
    invoke-static {v4, v3}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V

    :cond_a1
    throw p1

    :cond_a2
    :goto_a2
    invoke-virtual {v0}, Lw2/w0;->E()Z

    move-result p1
    :try_end_a6
    .catchall {:try_start_8b .. :try_end_a6} :catchall_a9

    if-nez p1, :cond_a2

    goto :goto_ad

    :catchall_a9
    move-exception p1

    :try_start_aa
    invoke-virtual {p0, p1, v2}, Lw2/q0;->h(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    :try_end_ad
    .catchall {:try_start_aa .. :try_end_ad} :catchall_b1

    :goto_ad
    invoke-virtual {v0, v1}, Lw2/w0;->p(Z)V

    goto :goto_b9

    :catchall_b1
    move-exception p0

    invoke-virtual {v0, v1}, Lw2/w0;->p(Z)V

    throw p0

    :cond_b6
    invoke-interface {p0, p1}, Li2/d;->resumeWith(Ljava/lang/Object;)V

    :goto_b9
    return-void
.end method

.method public static synthetic c(Li2/d;Ljava/lang/Object;Lp2/l;ILjava/lang/Object;)V
    .registers 5

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_5

    const/4 p2, 0x0

    :cond_5
    invoke-static {p0, p1, p2}, Lkotlinx/coroutines/internal/g;->b(Li2/d;Ljava/lang/Object;Lp2/l;)V

    return-void
.end method
