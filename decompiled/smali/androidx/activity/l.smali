.class public abstract Landroidx/activity/l;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Z

.field private final b:Ljava/util/concurrent/CopyOnWriteArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArrayList<",
            "Landroidx/activity/a;",
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


# direct methods
.method public constructor <init>(Z)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean p1, p0, Landroidx/activity/l;->a:Z

    new-instance p1, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object p1, p0, Landroidx/activity/l;->b:Ljava/util/concurrent/CopyOnWriteArrayList;

    return-void
.end method


# virtual methods
.method public final a(Landroidx/activity/a;)V
    .registers 3

    const-string v0, "cancellable"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v0, p0, Landroidx/activity/l;->b:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public abstract b()V
.end method

.method public final c()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/activity/l;->a:Z

    return v0
.end method

.method public final d()V
    .registers 3

    iget-object v0, p0, Landroidx/activity/l;->b:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/activity/a;

    invoke-interface {v1}, Landroidx/activity/a;->cancel()V

    goto :goto_6

    :cond_16
    return-void
.end method

.method public final e(Landroidx/activity/a;)V
    .registers 3

    const-string v0, "cancellable"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v0, p0, Landroidx/activity/l;->b:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public final f(Z)V
    .registers 2

    iput-boolean p1, p0, Landroidx/activity/l;->a:Z

    iget-object p1, p0, Landroidx/activity/l;->c:Lp2/a;

    if-eqz p1, :cond_9

    invoke-interface {p1}, Lp2/a;->invoke()Ljava/lang/Object;

    :cond_9
    return-void
.end method

.method public final g(Lp2/a;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lp2/a<",
            "Lg2/q;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Landroidx/activity/l;->c:Lp2/a;

    return-void
.end method
