.class Landroidx/fragment/app/q;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/fragment/app/q$a;
    }
.end annotation


# instance fields
.field private final a:Ljava/util/concurrent/CopyOnWriteArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArrayList<",
            "Landroidx/fragment/app/q$a;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Landroidx/fragment/app/w;


# direct methods
.method constructor <init>(Landroidx/fragment/app/w;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    iput-object p1, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    return-void
.end method


# virtual methods
.method a(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V
    .registers 6

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, p2, v1}, Landroidx/fragment/app/q;->a(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V

    :cond_14
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroidx/fragment/app/q$a;

    if-eqz p3, :cond_2d

    iget-boolean v0, p2, Landroidx/fragment/app/q$a;->a:Z

    if-nez v0, :cond_2d

    goto :goto_1a

    :cond_2d
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_32
    return-void
.end method

.method b(Landroidx/fragment/app/Fragment;Z)V
    .registers 5

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->v0()Landroidx/fragment/app/o;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/o;->f()Landroid/content/Context;

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_1d

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroidx/fragment/app/q;->b(Landroidx/fragment/app/Fragment;Z)V

    :cond_1d
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_23
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3b

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/fragment/app/q$a;

    if-eqz p2, :cond_36

    iget-boolean v1, v0, Landroidx/fragment/app/q$a;->a:Z

    if-nez v1, :cond_36

    goto :goto_23

    :cond_36
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_3b
    return-void
.end method

.method c(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V
    .registers 6

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, p2, v1}, Landroidx/fragment/app/q;->c(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V

    :cond_14
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroidx/fragment/app/q$a;

    if-eqz p3, :cond_2d

    iget-boolean v0, p2, Landroidx/fragment/app/q$a;->a:Z

    if-nez v0, :cond_2d

    goto :goto_1a

    :cond_2d
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_32
    return-void
.end method

.method d(Landroidx/fragment/app/Fragment;Z)V
    .registers 5

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroidx/fragment/app/q;->d(Landroidx/fragment/app/Fragment;Z)V

    :cond_14
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/fragment/app/q$a;

    if-eqz p2, :cond_2d

    iget-boolean v1, v0, Landroidx/fragment/app/q$a;->a:Z

    if-nez v1, :cond_2d

    goto :goto_1a

    :cond_2d
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_32
    return-void
.end method

.method e(Landroidx/fragment/app/Fragment;Z)V
    .registers 5

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroidx/fragment/app/q;->e(Landroidx/fragment/app/Fragment;Z)V

    :cond_14
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/fragment/app/q$a;

    if-eqz p2, :cond_2d

    iget-boolean v1, v0, Landroidx/fragment/app/q$a;->a:Z

    if-nez v1, :cond_2d

    goto :goto_1a

    :cond_2d
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_32
    return-void
.end method

.method f(Landroidx/fragment/app/Fragment;Z)V
    .registers 5

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroidx/fragment/app/q;->f(Landroidx/fragment/app/Fragment;Z)V

    :cond_14
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/fragment/app/q$a;

    if-eqz p2, :cond_2d

    iget-boolean v1, v0, Landroidx/fragment/app/q$a;->a:Z

    if-nez v1, :cond_2d

    goto :goto_1a

    :cond_2d
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_32
    return-void
.end method

.method g(Landroidx/fragment/app/Fragment;Z)V
    .registers 5

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->v0()Landroidx/fragment/app/o;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/o;->f()Landroid/content/Context;

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_1d

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroidx/fragment/app/q;->g(Landroidx/fragment/app/Fragment;Z)V

    :cond_1d
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_23
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3b

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/fragment/app/q$a;

    if-eqz p2, :cond_36

    iget-boolean v1, v0, Landroidx/fragment/app/q$a;->a:Z

    if-nez v1, :cond_36

    goto :goto_23

    :cond_36
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_3b
    return-void
.end method

.method h(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V
    .registers 6

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, p2, v1}, Landroidx/fragment/app/q;->h(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V

    :cond_14
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroidx/fragment/app/q$a;

    if-eqz p3, :cond_2d

    iget-boolean v0, p2, Landroidx/fragment/app/q$a;->a:Z

    if-nez v0, :cond_2d

    goto :goto_1a

    :cond_2d
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_32
    return-void
.end method

.method i(Landroidx/fragment/app/Fragment;Z)V
    .registers 5

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroidx/fragment/app/q;->i(Landroidx/fragment/app/Fragment;Z)V

    :cond_14
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/fragment/app/q$a;

    if-eqz p2, :cond_2d

    iget-boolean v1, v0, Landroidx/fragment/app/q$a;->a:Z

    if-nez v1, :cond_2d

    goto :goto_1a

    :cond_2d
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_32
    return-void
.end method

.method j(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V
    .registers 6

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, p2, v1}, Landroidx/fragment/app/q;->j(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V

    :cond_14
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroidx/fragment/app/q$a;

    if-eqz p3, :cond_2d

    iget-boolean v0, p2, Landroidx/fragment/app/q$a;->a:Z

    if-nez v0, :cond_2d

    goto :goto_1a

    :cond_2d
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_32
    return-void
.end method

.method k(Landroidx/fragment/app/Fragment;Z)V
    .registers 5

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroidx/fragment/app/q;->k(Landroidx/fragment/app/Fragment;Z)V

    :cond_14
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/fragment/app/q$a;

    if-eqz p2, :cond_2d

    iget-boolean v1, v0, Landroidx/fragment/app/q$a;->a:Z

    if-nez v1, :cond_2d

    goto :goto_1a

    :cond_2d
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_32
    return-void
.end method

.method l(Landroidx/fragment/app/Fragment;Z)V
    .registers 5

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroidx/fragment/app/q;->l(Landroidx/fragment/app/Fragment;Z)V

    :cond_14
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/fragment/app/q$a;

    if-eqz p2, :cond_2d

    iget-boolean v1, v0, Landroidx/fragment/app/q$a;->a:Z

    if-nez v1, :cond_2d

    goto :goto_1a

    :cond_2d
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_32
    return-void
.end method

.method m(Landroidx/fragment/app/Fragment;Landroid/view/View;Landroid/os/Bundle;Z)V
    .registers 7

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, p2, p3, v1}, Landroidx/fragment/app/q;->m(Landroidx/fragment/app/Fragment;Landroid/view/View;Landroid/os/Bundle;Z)V

    :cond_14
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroidx/fragment/app/q$a;

    if-eqz p4, :cond_2d

    iget-boolean p3, p2, Landroidx/fragment/app/q$a;->a:Z

    if-nez p3, :cond_2d

    goto :goto_1a

    :cond_2d
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_32
    return-void
.end method

.method n(Landroidx/fragment/app/Fragment;Z)V
    .registers 5

    iget-object v0, p0, Landroidx/fragment/app/q;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->y0()Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->x0()Landroidx/fragment/app/q;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroidx/fragment/app/q;->n(Landroidx/fragment/app/Fragment;Z)V

    :cond_14
    iget-object p1, p0, Landroidx/fragment/app/q;->a:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_32

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/fragment/app/q$a;

    if-eqz p2, :cond_2d

    iget-boolean v1, v0, Landroidx/fragment/app/q$a;->a:Z

    if-nez v1, :cond_2d

    goto :goto_1a

    :cond_2d
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 p1, 0x0

    throw p1

    :cond_32
    return-void
.end method
