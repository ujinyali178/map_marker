.class public final Landroidx/lifecycle/LifecycleCoroutineScopeImpl;
.super Landroidx/lifecycle/f;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/g;


# instance fields
.field private final c:Landroidx/lifecycle/e;

.field private final d:Li2/g;


# virtual methods
.method public a()Landroidx/lifecycle/e;
    .registers 2

    iget-object v0, p0, Landroidx/lifecycle/LifecycleCoroutineScopeImpl;->c:Landroidx/lifecycle/e;

    return-object v0
.end method

.method public e(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 4

    const-string v0, "source"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "event"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0}, Landroidx/lifecycle/LifecycleCoroutineScopeImpl;->a()Landroidx/lifecycle/e;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/lifecycle/e;->b()Landroidx/lifecycle/e$b;

    move-result-object p1

    sget-object p2, Landroidx/lifecycle/e$b;->c:Landroidx/lifecycle/e$b;

    invoke-virtual {p1, p2}, Ljava/lang/Enum;->compareTo(Ljava/lang/Enum;)I

    move-result p1

    if-gtz p1, :cond_2a

    invoke-virtual {p0}, Landroidx/lifecycle/LifecycleCoroutineScopeImpl;->a()Landroidx/lifecycle/e;

    move-result-object p1

    invoke-virtual {p1, p0}, Landroidx/lifecycle/e;->c(Landroidx/lifecycle/h;)V

    invoke-virtual {p0}, Landroidx/lifecycle/LifecycleCoroutineScopeImpl;->p()Li2/g;

    move-result-object p1

    const/4 p2, 0x1

    const/4 v0, 0x0

    invoke-static {p1, v0, p2, v0}, Lw2/p1;->d(Li2/g;Ljava/util/concurrent/CancellationException;ILjava/lang/Object;)V

    :cond_2a
    return-void
.end method

.method public p()Li2/g;
    .registers 2

    iget-object v0, p0, Landroidx/lifecycle/LifecycleCoroutineScopeImpl;->d:Li2/g;

    return-object v0
.end method
