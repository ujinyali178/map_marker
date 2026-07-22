.class public final Landroidx/lifecycle/SavedStateHandleController;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/g;


# instance fields
.field private final c:Ljava/lang/String;

.field private final d:Landroidx/lifecycle/t;

.field private f:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroidx/lifecycle/t;)V
    .registers 4

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "handle"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/lifecycle/SavedStateHandleController;->c:Ljava/lang/String;

    iput-object p2, p0, Landroidx/lifecycle/SavedStateHandleController;->d:Landroidx/lifecycle/t;

    return-void
.end method


# virtual methods
.method public final a(Landroidx/savedstate/a;Landroidx/lifecycle/e;)V
    .registers 5

    const-string v0, "registry"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "lifecycle"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    iget-boolean v0, p0, Landroidx/lifecycle/SavedStateHandleController;->f:Z

    const/4 v1, 0x1

    xor-int/2addr v0, v1

    if-eqz v0, :cond_21

    iput-boolean v1, p0, Landroidx/lifecycle/SavedStateHandleController;->f:Z

    invoke-virtual {p2, p0}, Landroidx/lifecycle/e;->a(Landroidx/lifecycle/h;)V

    iget-object p2, p0, Landroidx/lifecycle/SavedStateHandleController;->c:Ljava/lang/String;

    iget-object v0, p0, Landroidx/lifecycle/SavedStateHandleController;->d:Landroidx/lifecycle/t;

    invoke-virtual {v0}, Landroidx/lifecycle/t;->c()Landroidx/savedstate/a$c;

    move-result-object v0

    invoke-virtual {p1, p2, v0}, Landroidx/savedstate/a;->h(Ljava/lang/String;Landroidx/savedstate/a$c;)V

    return-void

    :cond_21
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "Already attached to lifecycleOwner"

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public final b()Landroidx/lifecycle/t;
    .registers 2

    iget-object v0, p0, Landroidx/lifecycle/SavedStateHandleController;->d:Landroidx/lifecycle/t;

    return-object v0
.end method

.method public e(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 4

    const-string v0, "source"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "event"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v0, Landroidx/lifecycle/e$a;->ON_DESTROY:Landroidx/lifecycle/e$a;

    if-ne p2, v0, :cond_18

    const/4 p2, 0x0

    iput-boolean p2, p0, Landroidx/lifecycle/SavedStateHandleController;->f:Z

    invoke-interface {p1}, Landroidx/lifecycle/i;->getLifecycle()Landroidx/lifecycle/e;

    move-result-object p1

    invoke-virtual {p1, p0}, Landroidx/lifecycle/e;->c(Landroidx/lifecycle/h;)V

    :cond_18
    return-void
.end method

.method public final g()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/lifecycle/SavedStateHandleController;->f:Z

    return v0
.end method
