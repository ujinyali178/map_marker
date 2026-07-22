.class public final Lw2/e2;
.super Lkotlinx/coroutines/internal/z;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lkotlinx/coroutines/internal/z<",
        "TT;>;"
    }
.end annotation


# instance fields
.field private g:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal<",
            "Lg2/j<",
            "Li2/g;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Li2/g;Li2/d;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/g;",
            "Li2/d<",
            "-TT;>;)V"
        }
    .end annotation

    sget-object v0, Lw2/f2;->c:Lw2/f2;

    invoke-interface {p1, v0}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object v1

    if-nez v1, :cond_d

    invoke-interface {p1, v0}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object v0

    goto :goto_e

    :cond_d
    move-object v0, p1

    :goto_e
    invoke-direct {p0, v0, p2}, Lkotlinx/coroutines/internal/z;-><init>(Li2/g;Li2/d;)V

    new-instance v0, Ljava/lang/ThreadLocal;

    invoke-direct {v0}, Ljava/lang/ThreadLocal;-><init>()V

    iput-object v0, p0, Lw2/e2;->g:Ljava/lang/ThreadLocal;

    invoke-interface {p2}, Li2/d;->getContext()Li2/g;

    move-result-object p2

    sget-object v0, Li2/e;->a:Li2/e$b;

    invoke-interface {p2, v0}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object p2

    instance-of p2, p2, Lw2/c0;

    if-nez p2, :cond_31

    const/4 p2, 0x0

    invoke-static {p1, p2}, Lkotlinx/coroutines/internal/f0;->c(Li2/g;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    invoke-static {p1, p2}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V

    invoke-virtual {p0, p1, p2}, Lw2/e2;->E0(Li2/g;Ljava/lang/Object;)V

    :cond_31
    return-void
.end method


# virtual methods
.method public final D0()Z
    .registers 3

    iget-object v0, p0, Lw2/e2;->g:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_a

    const/4 v0, 0x0

    return v0

    :cond_a
    iget-object v0, p0, Lw2/e2;->g:Ljava/lang/ThreadLocal;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V

    const/4 v0, 0x1

    return v0
.end method

.method public final E0(Li2/g;Ljava/lang/Object;)V
    .registers 4

    iget-object v0, p0, Lw2/e2;->g:Ljava/lang/ThreadLocal;

    invoke-static {p1, p2}, Lg2/n;->a(Ljava/lang/Object;Ljava/lang/Object;)Lg2/j;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V

    return-void
.end method

.method protected y0(Ljava/lang/Object;)V
    .registers 7

    iget-object v0, p0, Lw2/e2;->g:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lg2/j;

    const/4 v1, 0x0

    if-eqz v0, :cond_1d

    invoke-virtual {v0}, Lg2/j;->a()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Li2/g;

    invoke-virtual {v0}, Lg2/j;->b()Ljava/lang/Object;

    move-result-object v0

    invoke-static {v2, v0}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V

    iget-object v0, p0, Lw2/e2;->g:Ljava/lang/ThreadLocal;

    invoke-virtual {v0, v1}, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V

    :cond_1d
    iget-object v0, p0, Lkotlinx/coroutines/internal/z;->f:Li2/d;

    invoke-static {p1, v0}, Lw2/z;->a(Ljava/lang/Object;Li2/d;)Ljava/lang/Object;

    move-result-object p1

    iget-object v0, p0, Lkotlinx/coroutines/internal/z;->f:Li2/d;

    invoke-interface {v0}, Li2/d;->getContext()Li2/g;

    move-result-object v2

    invoke-static {v2, v1}, Lkotlinx/coroutines/internal/f0;->c(Li2/g;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    sget-object v4, Lkotlinx/coroutines/internal/f0;->a:Lkotlinx/coroutines/internal/b0;

    if-eq v3, v4, :cond_35

    invoke-static {v0, v2, v3}, Lw2/b0;->g(Li2/d;Li2/g;Ljava/lang/Object;)Lw2/e2;

    move-result-object v1

    :cond_35
    :try_start_35
    iget-object v0, p0, Lkotlinx/coroutines/internal/z;->f:Li2/d;

    invoke-interface {v0, p1}, Li2/d;->resumeWith(Ljava/lang/Object;)V

    sget-object p1, Lg2/q;->a:Lg2/q;
    :try_end_3c
    .catchall {:try_start_35 .. :try_end_3c} :catchall_48

    if-eqz v1, :cond_44

    invoke-virtual {v1}, Lw2/e2;->D0()Z

    move-result p1

    if-eqz p1, :cond_47

    :cond_44
    invoke-static {v2, v3}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V

    :cond_47
    return-void

    :catchall_48
    move-exception p1

    if-eqz v1, :cond_51

    invoke-virtual {v1}, Lw2/e2;->D0()Z

    move-result v0

    if-eqz v0, :cond_54

    :cond_51
    invoke-static {v2, v3}, Lkotlinx/coroutines/internal/f0;->a(Li2/g;Ljava/lang/Object;)V

    :cond_54
    throw p1
.end method
