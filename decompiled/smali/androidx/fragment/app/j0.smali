.class Landroidx/fragment/app/j0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/d;
.implements Lq/d;
.implements Landroidx/lifecycle/e0;


# instance fields
.field private final c:Landroidx/fragment/app/Fragment;

.field private final d:Landroidx/lifecycle/d0;

.field private f:Landroidx/lifecycle/j;

.field private g:Lq/c;


# direct methods
.method constructor <init>(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/d0;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/fragment/app/j0;->f:Landroidx/lifecycle/j;

    iput-object v0, p0, Landroidx/fragment/app/j0;->g:Lq/c;

    iput-object p1, p0, Landroidx/fragment/app/j0;->c:Landroidx/fragment/app/Fragment;

    iput-object p2, p0, Landroidx/fragment/app/j0;->d:Landroidx/lifecycle/d0;

    return-void
.end method


# virtual methods
.method a(Landroidx/lifecycle/e$a;)V
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/j0;->f:Landroidx/lifecycle/j;

    invoke-virtual {v0, p1}, Landroidx/lifecycle/j;->h(Landroidx/lifecycle/e$a;)V

    return-void
.end method

.method b()V
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/j0;->f:Landroidx/lifecycle/j;

    if-nez v0, :cond_14

    new-instance v0, Landroidx/lifecycle/j;

    invoke-direct {v0, p0}, Landroidx/lifecycle/j;-><init>(Landroidx/lifecycle/i;)V

    iput-object v0, p0, Landroidx/fragment/app/j0;->f:Landroidx/lifecycle/j;

    invoke-static {p0}, Lq/c;->a(Lq/d;)Lq/c;

    move-result-object v0

    iput-object v0, p0, Landroidx/fragment/app/j0;->g:Lq/c;

    invoke-virtual {v0}, Lq/c;->c()V

    :cond_14
    return-void
.end method

.method c()Z
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/j0;->f:Landroidx/lifecycle/j;

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    goto :goto_7

    :cond_6
    const/4 v0, 0x0

    :goto_7
    return v0
.end method

.method d(Landroid/os/Bundle;)V
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/j0;->g:Lq/c;

    invoke-virtual {v0, p1}, Lq/c;->d(Landroid/os/Bundle;)V

    return-void
.end method

.method e(Landroid/os/Bundle;)V
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/j0;->g:Lq/c;

    invoke-virtual {v0, p1}, Lq/c;->e(Landroid/os/Bundle;)V

    return-void
.end method

.method f(Landroidx/lifecycle/e$b;)V
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/j0;->f:Landroidx/lifecycle/j;

    invoke-virtual {v0, p1}, Landroidx/lifecycle/j;->n(Landroidx/lifecycle/e$b;)V

    return-void
.end method

.method public getDefaultViewModelCreationExtras()Lp/a;
    .registers 4

    iget-object v0, p0, Landroidx/fragment/app/j0;->c:Landroidx/fragment/app/Fragment;

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    :goto_a
    instance-of v1, v0, Landroid/content/ContextWrapper;

    if-eqz v1, :cond_1c

    instance-of v1, v0, Landroid/app/Application;

    if-eqz v1, :cond_15

    check-cast v0, Landroid/app/Application;

    goto :goto_1d

    :cond_15
    check-cast v0, Landroid/content/ContextWrapper;

    invoke-virtual {v0}, Landroid/content/ContextWrapper;->getBaseContext()Landroid/content/Context;

    move-result-object v0

    goto :goto_a

    :cond_1c
    const/4 v0, 0x0

    :goto_1d
    new-instance v1, Lp/d;

    invoke-direct {v1}, Lp/d;-><init>()V

    if-eqz v0, :cond_29

    sget-object v2, Landroidx/lifecycle/a0$a;->g:Lp/a$b;

    invoke-virtual {v1, v2, v0}, Lp/d;->c(Lp/a$b;Ljava/lang/Object;)V

    :cond_29
    sget-object v0, Landroidx/lifecycle/u;->a:Lp/a$b;

    iget-object v2, p0, Landroidx/fragment/app/j0;->c:Landroidx/fragment/app/Fragment;

    invoke-virtual {v1, v0, v2}, Lp/d;->c(Lp/a$b;Ljava/lang/Object;)V

    sget-object v0, Landroidx/lifecycle/u;->b:Lp/a$b;

    invoke-virtual {v1, v0, p0}, Lp/d;->c(Lp/a$b;Ljava/lang/Object;)V

    iget-object v0, p0, Landroidx/fragment/app/j0;->c:Landroidx/fragment/app/Fragment;

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_48

    sget-object v0, Landroidx/lifecycle/u;->c:Lp/a$b;

    iget-object v2, p0, Landroidx/fragment/app/j0;->c:Landroidx/fragment/app/Fragment;

    invoke-virtual {v2}, Landroidx/fragment/app/Fragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lp/d;->c(Lp/a$b;Ljava/lang/Object;)V

    :cond_48
    return-object v1
.end method

.method public getLifecycle()Landroidx/lifecycle/e;
    .registers 2

    invoke-virtual {p0}, Landroidx/fragment/app/j0;->b()V

    iget-object v0, p0, Landroidx/fragment/app/j0;->f:Landroidx/lifecycle/j;

    return-object v0
.end method

.method public getSavedStateRegistry()Landroidx/savedstate/a;
    .registers 2

    invoke-virtual {p0}, Landroidx/fragment/app/j0;->b()V

    iget-object v0, p0, Landroidx/fragment/app/j0;->g:Lq/c;

    invoke-virtual {v0}, Lq/c;->b()Landroidx/savedstate/a;

    move-result-object v0

    return-object v0
.end method

.method public getViewModelStore()Landroidx/lifecycle/d0;
    .registers 2

    invoke-virtual {p0}, Landroidx/fragment/app/j0;->b()V

    iget-object v0, p0, Landroidx/fragment/app/j0;->d:Landroidx/lifecycle/d0;

    return-object v0
.end method
