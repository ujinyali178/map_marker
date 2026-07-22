.class public final Landroidx/activity/OnBackPressedDispatcher;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/activity/OnBackPressedDispatcher$c;,
        Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;,
        Landroidx/activity/OnBackPressedDispatcher$d;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/Runnable;

.field private final b:Lh2/e;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lh2/e<",
            "Landroidx/activity/l;",
            ">;"
        }
    .end annotation
.end field

.field private c:Lp2/a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lp2/a<",
            "Lg2/q;",
            ">;"
        }
    .end annotation
.end field

.field private d:Landroid/window/OnBackInvokedCallback;

.field private e:Landroid/window/OnBackInvokedDispatcher;

.field private f:Z


# direct methods
.method public constructor <init>(Ljava/lang/Runnable;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/activity/OnBackPressedDispatcher;->a:Ljava/lang/Runnable;

    new-instance p1, Lh2/e;

    invoke-direct {p1}, Lh2/e;-><init>()V

    iput-object p1, p0, Landroidx/activity/OnBackPressedDispatcher;->b:Lh2/e;

    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v0, 0x21

    if-lt p1, v0, :cond_26

    new-instance p1, Landroidx/activity/OnBackPressedDispatcher$a;

    invoke-direct {p1, p0}, Landroidx/activity/OnBackPressedDispatcher$a;-><init>(Landroidx/activity/OnBackPressedDispatcher;)V

    iput-object p1, p0, Landroidx/activity/OnBackPressedDispatcher;->c:Lp2/a;

    sget-object p1, Landroidx/activity/OnBackPressedDispatcher$c;->a:Landroidx/activity/OnBackPressedDispatcher$c;

    new-instance v0, Landroidx/activity/OnBackPressedDispatcher$b;

    invoke-direct {v0, p0}, Landroidx/activity/OnBackPressedDispatcher$b;-><init>(Landroidx/activity/OnBackPressedDispatcher;)V

    invoke-virtual {p1, v0}, Landroidx/activity/OnBackPressedDispatcher$c;->b(Lp2/a;)Landroid/window/OnBackInvokedCallback;

    move-result-object p1

    iput-object p1, p0, Landroidx/activity/OnBackPressedDispatcher;->d:Landroid/window/OnBackInvokedCallback;

    :cond_26
    return-void
.end method

.method public static final synthetic a(Landroidx/activity/OnBackPressedDispatcher;)Lh2/e;
    .registers 1

    iget-object p0, p0, Landroidx/activity/OnBackPressedDispatcher;->b:Lh2/e;

    return-object p0
.end method


# virtual methods
.method public final b(Landroidx/lifecycle/i;Landroidx/activity/l;)V
    .registers 5

    const-string v0, "owner"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "onBackPressedCallback"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-interface {p1}, Landroidx/lifecycle/i;->getLifecycle()Landroidx/lifecycle/e;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/lifecycle/e;->b()Landroidx/lifecycle/e$b;

    move-result-object v0

    sget-object v1, Landroidx/lifecycle/e$b;->c:Landroidx/lifecycle/e$b;

    if-ne v0, v1, :cond_17

    return-void

    :cond_17
    new-instance v0, Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;

    invoke-direct {v0, p0, p1, p2}, Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;-><init>(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/e;Landroidx/activity/l;)V

    invoke-virtual {p2, v0}, Landroidx/activity/l;->a(Landroidx/activity/a;)V

    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v0, 0x21

    if-lt p1, v0, :cond_2d

    invoke-virtual {p0}, Landroidx/activity/OnBackPressedDispatcher;->g()V

    iget-object p1, p0, Landroidx/activity/OnBackPressedDispatcher;->c:Lp2/a;

    invoke-virtual {p2, p1}, Landroidx/activity/l;->g(Lp2/a;)V

    :cond_2d
    return-void
.end method

.method public final c(Landroidx/activity/l;)Landroidx/activity/a;
    .registers 5

    const-string v0, "onBackPressedCallback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v0, p0, Landroidx/activity/OnBackPressedDispatcher;->b:Lh2/e;

    invoke-virtual {v0, p1}, Lh2/e;->add(Ljava/lang/Object;)Z

    new-instance v0, Landroidx/activity/OnBackPressedDispatcher$d;

    invoke-direct {v0, p0, p1}, Landroidx/activity/OnBackPressedDispatcher$d;-><init>(Landroidx/activity/OnBackPressedDispatcher;Landroidx/activity/l;)V

    invoke-virtual {p1, v0}, Landroidx/activity/l;->a(Landroidx/activity/a;)V

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x21

    if-lt v1, v2, :cond_20

    invoke-virtual {p0}, Landroidx/activity/OnBackPressedDispatcher;->g()V

    iget-object v1, p0, Landroidx/activity/OnBackPressedDispatcher;->c:Lp2/a;

    invoke-virtual {p1, v1}, Landroidx/activity/l;->g(Lp2/a;)V

    :cond_20
    return-object v0
.end method

.method public final d()Z
    .registers 4

    iget-object v0, p0, Landroidx/activity/OnBackPressedDispatcher;->b:Lh2/e;

    instance-of v1, v0, Ljava/util/Collection;

    const/4 v2, 0x0

    if-eqz v1, :cond_e

    invoke-interface {v0}, Ljava/util/Collection;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_e

    goto :goto_25

    :cond_e
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_12
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_25

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/activity/l;

    invoke-virtual {v1}, Landroidx/activity/l;->c()Z

    move-result v1

    if-eqz v1, :cond_12

    const/4 v2, 0x1

    :cond_25
    :goto_25
    return v2
.end method

.method public final e()V
    .registers 4

    iget-object v0, p0, Landroidx/activity/OnBackPressedDispatcher;->b:Lh2/e;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    invoke-interface {v0, v1}, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v0

    :cond_a
    invoke-interface {v0}, Ljava/util/ListIterator;->hasPrevious()Z

    move-result v1

    if-eqz v1, :cond_1e

    invoke-interface {v0}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    move-result-object v1

    move-object v2, v1

    check-cast v2, Landroidx/activity/l;

    invoke-virtual {v2}, Landroidx/activity/l;->c()Z

    move-result v2

    if-eqz v2, :cond_a

    goto :goto_1f

    :cond_1e
    const/4 v1, 0x0

    :goto_1f
    check-cast v1, Landroidx/activity/l;

    if-eqz v1, :cond_27

    invoke-virtual {v1}, Landroidx/activity/l;->b()V

    return-void

    :cond_27
    iget-object v0, p0, Landroidx/activity/OnBackPressedDispatcher;->a:Ljava/lang/Runnable;

    if-eqz v0, :cond_2e

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    :cond_2e
    return-void
.end method

.method public final f(Landroid/window/OnBackInvokedDispatcher;)V
    .registers 3

    const-string v0, "invoker"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Landroidx/activity/OnBackPressedDispatcher;->e:Landroid/window/OnBackInvokedDispatcher;

    invoke-virtual {p0}, Landroidx/activity/OnBackPressedDispatcher;->g()V

    return-void
.end method

.method public final g()V
    .registers 6

    invoke-virtual {p0}, Landroidx/activity/OnBackPressedDispatcher;->d()Z

    move-result v0

    iget-object v1, p0, Landroidx/activity/OnBackPressedDispatcher;->e:Landroid/window/OnBackInvokedDispatcher;

    iget-object v2, p0, Landroidx/activity/OnBackPressedDispatcher;->d:Landroid/window/OnBackInvokedCallback;

    if-eqz v1, :cond_29

    if-eqz v2, :cond_29

    const/4 v3, 0x0

    if-eqz v0, :cond_1c

    iget-boolean v4, p0, Landroidx/activity/OnBackPressedDispatcher;->f:Z

    if-nez v4, :cond_1c

    sget-object v0, Landroidx/activity/OnBackPressedDispatcher$c;->a:Landroidx/activity/OnBackPressedDispatcher$c;

    invoke-virtual {v0, v1, v3, v2}, Landroidx/activity/OnBackPressedDispatcher$c;->d(Ljava/lang/Object;ILjava/lang/Object;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/activity/OnBackPressedDispatcher;->f:Z

    goto :goto_29

    :cond_1c
    if-nez v0, :cond_29

    iget-boolean v0, p0, Landroidx/activity/OnBackPressedDispatcher;->f:Z

    if-eqz v0, :cond_29

    sget-object v0, Landroidx/activity/OnBackPressedDispatcher$c;->a:Landroidx/activity/OnBackPressedDispatcher$c;

    invoke-virtual {v0, v1, v2}, Landroidx/activity/OnBackPressedDispatcher$c;->e(Ljava/lang/Object;Ljava/lang/Object;)V

    iput-boolean v3, p0, Landroidx/activity/OnBackPressedDispatcher;->f:Z

    :cond_29
    :goto_29
    return-void
.end method
