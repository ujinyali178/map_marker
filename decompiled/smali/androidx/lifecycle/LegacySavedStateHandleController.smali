.class public final Landroidx/lifecycle/LegacySavedStateHandleController;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/lifecycle/LegacySavedStateHandleController$a;
    }
.end annotation


# static fields
.field public static final a:Landroidx/lifecycle/LegacySavedStateHandleController;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Landroidx/lifecycle/LegacySavedStateHandleController;

    invoke-direct {v0}, Landroidx/lifecycle/LegacySavedStateHandleController;-><init>()V

    sput-object v0, Landroidx/lifecycle/LegacySavedStateHandleController;->a:Landroidx/lifecycle/LegacySavedStateHandleController;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final a(Landroidx/lifecycle/z;Landroidx/savedstate/a;Landroidx/lifecycle/e;)V
    .registers 4

    const-string v0, "viewModel"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "registry"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "lifecycle"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "androidx.lifecycle.savedstate.vm.tag"

    invoke-virtual {p0, v0}, Landroidx/lifecycle/z;->c(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Landroidx/lifecycle/SavedStateHandleController;

    if-eqz p0, :cond_27

    invoke-virtual {p0}, Landroidx/lifecycle/SavedStateHandleController;->g()Z

    move-result v0

    if-nez v0, :cond_27

    invoke-virtual {p0, p1, p2}, Landroidx/lifecycle/SavedStateHandleController;->a(Landroidx/savedstate/a;Landroidx/lifecycle/e;)V

    sget-object p0, Landroidx/lifecycle/LegacySavedStateHandleController;->a:Landroidx/lifecycle/LegacySavedStateHandleController;

    invoke-direct {p0, p1, p2}, Landroidx/lifecycle/LegacySavedStateHandleController;->c(Landroidx/savedstate/a;Landroidx/lifecycle/e;)V

    :cond_27
    return-void
.end method

.method public static final b(Landroidx/savedstate/a;Landroidx/lifecycle/e;Ljava/lang/String;Landroid/os/Bundle;)Landroidx/lifecycle/SavedStateHandleController;
    .registers 6

    const-string v0, "registry"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "lifecycle"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {p2}, Lkotlin/jvm/internal/k;->b(Ljava/lang/Object;)V

    invoke-virtual {p0, p2}, Landroidx/savedstate/a;->b(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    sget-object v1, Landroidx/lifecycle/t;->f:Landroidx/lifecycle/t$a;

    invoke-virtual {v1, v0, p3}, Landroidx/lifecycle/t$a;->a(Landroid/os/Bundle;Landroid/os/Bundle;)Landroidx/lifecycle/t;

    move-result-object p3

    new-instance v0, Landroidx/lifecycle/SavedStateHandleController;

    invoke-direct {v0, p2, p3}, Landroidx/lifecycle/SavedStateHandleController;-><init>(Ljava/lang/String;Landroidx/lifecycle/t;)V

    invoke-virtual {v0, p0, p1}, Landroidx/lifecycle/SavedStateHandleController;->a(Landroidx/savedstate/a;Landroidx/lifecycle/e;)V

    sget-object p2, Landroidx/lifecycle/LegacySavedStateHandleController;->a:Landroidx/lifecycle/LegacySavedStateHandleController;

    invoke-direct {p2, p0, p1}, Landroidx/lifecycle/LegacySavedStateHandleController;->c(Landroidx/savedstate/a;Landroidx/lifecycle/e;)V

    return-object v0
.end method

.method private final c(Landroidx/savedstate/a;Landroidx/lifecycle/e;)V
    .registers 5

    invoke-virtual {p2}, Landroidx/lifecycle/e;->b()Landroidx/lifecycle/e$b;

    move-result-object v0

    sget-object v1, Landroidx/lifecycle/e$b;->d:Landroidx/lifecycle/e$b;

    if-eq v0, v1, :cond_1a

    sget-object v1, Landroidx/lifecycle/e$b;->g:Landroidx/lifecycle/e$b;

    invoke-virtual {v0, v1}, Landroidx/lifecycle/e$b;->b(Landroidx/lifecycle/e$b;)Z

    move-result v0

    if-eqz v0, :cond_11

    goto :goto_1a

    :cond_11
    new-instance v0, Landroidx/lifecycle/LegacySavedStateHandleController$tryToAddRecreator$1;

    invoke-direct {v0, p2, p1}, Landroidx/lifecycle/LegacySavedStateHandleController$tryToAddRecreator$1;-><init>(Landroidx/lifecycle/e;Landroidx/savedstate/a;)V

    invoke-virtual {p2, v0}, Landroidx/lifecycle/e;->a(Landroidx/lifecycle/h;)V

    goto :goto_1f

    :cond_1a
    :goto_1a
    const-class p2, Landroidx/lifecycle/LegacySavedStateHandleController$a;

    invoke-virtual {p1, p2}, Landroidx/savedstate/a;->i(Ljava/lang/Class;)V

    :goto_1f
    return-void
.end method
