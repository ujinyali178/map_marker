.class public Landroidx/core/view/g;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/view/g$a;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/Runnable;

.field private final b:Ljava/util/concurrent/CopyOnWriteArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArrayList<",
            "Landroidx/core/view/h;",
            ">;"
        }
    .end annotation
.end field

.field private final c:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Landroidx/core/view/h;",
            "Landroidx/core/view/g$a;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Runnable;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Landroidx/core/view/g;->b:Ljava/util/concurrent/CopyOnWriteArrayList;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/core/view/g;->c:Ljava/util/Map;

    iput-object p1, p0, Landroidx/core/view/g;->a:Ljava/lang/Runnable;

    return-void
.end method

.method public static synthetic a(Landroidx/core/view/g;Landroidx/lifecycle/e$b;Landroidx/core/view/h;Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 5

    invoke-direct {p0, p1, p2, p3, p4}, Landroidx/core/view/g;->g(Landroidx/lifecycle/e$b;Landroidx/core/view/h;Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V

    return-void
.end method

.method public static synthetic b(Landroidx/core/view/g;Landroidx/core/view/h;Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 4

    invoke-direct {p0, p1, p2, p3}, Landroidx/core/view/g;->f(Landroidx/core/view/h;Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V

    return-void
.end method

.method private synthetic f(Landroidx/core/view/h;Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 4

    sget-object p2, Landroidx/lifecycle/e$a;->ON_DESTROY:Landroidx/lifecycle/e$a;

    if-ne p3, p2, :cond_7

    invoke-virtual {p0, p1}, Landroidx/core/view/g;->l(Landroidx/core/view/h;)V

    :cond_7
    return-void
.end method

.method private synthetic g(Landroidx/lifecycle/e$b;Landroidx/core/view/h;Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 5

    invoke-static {p1}, Landroidx/lifecycle/e$a;->d(Landroidx/lifecycle/e$b;)Landroidx/lifecycle/e$a;

    move-result-object p3

    if-ne p4, p3, :cond_a

    invoke-virtual {p0, p2}, Landroidx/core/view/g;->c(Landroidx/core/view/h;)V

    goto :goto_22

    :cond_a
    sget-object p3, Landroidx/lifecycle/e$a;->ON_DESTROY:Landroidx/lifecycle/e$a;

    if-ne p4, p3, :cond_12

    invoke-virtual {p0, p2}, Landroidx/core/view/g;->l(Landroidx/core/view/h;)V

    goto :goto_22

    :cond_12
    invoke-static {p1}, Landroidx/lifecycle/e$a;->b(Landroidx/lifecycle/e$b;)Landroidx/lifecycle/e$a;

    move-result-object p1

    if-ne p4, p1, :cond_22

    iget-object p1, p0, Landroidx/core/view/g;->b:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1, p2}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    iget-object p1, p0, Landroidx/core/view/g;->a:Ljava/lang/Runnable;

    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    :cond_22
    :goto_22
    return-void
.end method


# virtual methods
.method public c(Landroidx/core/view/h;)V
    .registers 3

    iget-object v0, p0, Landroidx/core/view/g;->b:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z

    iget-object p1, p0, Landroidx/core/view/g;->a:Ljava/lang/Runnable;

    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    return-void
.end method

.method public d(Landroidx/core/view/h;Landroidx/lifecycle/i;)V
    .registers 6

    invoke-virtual {p0, p1}, Landroidx/core/view/g;->c(Landroidx/core/view/h;)V

    invoke-interface {p2}, Landroidx/lifecycle/i;->getLifecycle()Landroidx/lifecycle/e;

    move-result-object p2

    iget-object v0, p0, Landroidx/core/view/g;->c:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/core/view/g$a;

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/core/view/g$a;->a()V

    :cond_14
    new-instance v0, Landroidx/core/view/e;

    invoke-direct {v0, p0, p1}, Landroidx/core/view/e;-><init>(Landroidx/core/view/g;Landroidx/core/view/h;)V

    iget-object v1, p0, Landroidx/core/view/g;->c:Ljava/util/Map;

    new-instance v2, Landroidx/core/view/g$a;

    invoke-direct {v2, p2, v0}, Landroidx/core/view/g$a;-><init>(Landroidx/lifecycle/e;Landroidx/lifecycle/g;)V

    invoke-interface {v1, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public e(Landroidx/core/view/h;Landroidx/lifecycle/i;Landroidx/lifecycle/e$b;)V
    .registers 6

    invoke-interface {p2}, Landroidx/lifecycle/i;->getLifecycle()Landroidx/lifecycle/e;

    move-result-object p2

    iget-object v0, p0, Landroidx/core/view/g;->c:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/core/view/g$a;

    if-eqz v0, :cond_11

    invoke-virtual {v0}, Landroidx/core/view/g$a;->a()V

    :cond_11
    new-instance v0, Landroidx/core/view/f;

    invoke-direct {v0, p0, p3, p1}, Landroidx/core/view/f;-><init>(Landroidx/core/view/g;Landroidx/lifecycle/e$b;Landroidx/core/view/h;)V

    iget-object p3, p0, Landroidx/core/view/g;->c:Ljava/util/Map;

    new-instance v1, Landroidx/core/view/g$a;

    invoke-direct {v1, p2, v0}, Landroidx/core/view/g$a;-><init>(Landroidx/lifecycle/e;Landroidx/lifecycle/g;)V

    invoke-interface {p3, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public h(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .registers 5

    iget-object v0, p0, Landroidx/core/view/g;->b:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/core/view/h;

    invoke-interface {v1, p1, p2}, Landroidx/core/view/h;->c(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    goto :goto_6

    :cond_16
    return-void
.end method

.method public i(Landroid/view/Menu;)V
    .registers 4

    iget-object v0, p0, Landroidx/core/view/g;->b:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/core/view/h;

    invoke-interface {v1, p1}, Landroidx/core/view/h;->b(Landroid/view/Menu;)V

    goto :goto_6

    :cond_16
    return-void
.end method

.method public j(Landroid/view/MenuItem;)Z
    .registers 4

    iget-object v0, p0, Landroidx/core/view/g;->b:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/core/view/h;

    invoke-interface {v1, p1}, Landroidx/core/view/h;->a(Landroid/view/MenuItem;)Z

    move-result v1

    if-eqz v1, :cond_6

    const/4 p1, 0x1

    return p1

    :cond_1a
    const/4 p1, 0x0

    return p1
.end method

.method public k(Landroid/view/Menu;)V
    .registers 4

    iget-object v0, p0, Landroidx/core/view/g;->b:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/core/view/h;

    invoke-interface {v1, p1}, Landroidx/core/view/h;->d(Landroid/view/Menu;)V

    goto :goto_6

    :cond_16
    return-void
.end method

.method public l(Landroidx/core/view/h;)V
    .registers 3

    iget-object v0, p0, Landroidx/core/view/g;->b:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/core/view/g;->c:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/core/view/g$a;

    if-eqz p1, :cond_12

    invoke-virtual {p1}, Landroidx/core/view/g$a;->a()V

    :cond_12
    iget-object p1, p0, Landroidx/core/view/g;->a:Ljava/lang/Runnable;

    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    return-void
.end method
