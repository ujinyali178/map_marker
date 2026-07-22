.class Landroidx/fragment/app/FragmentActivity$a;
.super Landroidx/fragment/app/o;
.source "SourceFile"

# interfaces
.implements Landroidx/core/content/l;
.implements Landroidx/core/content/m;
.implements Landroidx/core/app/a1;
.implements Landroidx/core/app/b1;
.implements Landroidx/lifecycle/e0;
.implements Landroidx/activity/n;
.implements Landroidx/activity/result/d;
.implements Lq/d;
.implements Landroidx/fragment/app/a0;
.implements Landroidx/core/view/d;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/fragment/app/FragmentActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/fragment/app/o<",
        "Landroidx/fragment/app/FragmentActivity;",
        ">;",
        "Landroidx/core/content/l;",
        "Landroidx/core/content/m;",
        "Landroidx/core/app/a1;",
        "Landroidx/core/app/b1;",
        "Landroidx/lifecycle/e0;",
        "Landroidx/activity/n;",
        "Landroidx/activity/result/d;",
        "Lq/d;",
        "Landroidx/fragment/app/a0;",
        "Landroidx/core/view/d;"
    }
.end annotation


# instance fields
.field final synthetic i:Landroidx/fragment/app/FragmentActivity;


# direct methods
.method public constructor <init>(Landroidx/fragment/app/FragmentActivity;)V
    .registers 2

    iput-object p1, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-direct {p0, p1}, Landroidx/fragment/app/o;-><init>(Landroidx/fragment/app/FragmentActivity;)V

    return-void
.end method


# virtual methods
.method public a(Landroidx/fragment/app/w;Landroidx/fragment/app/Fragment;)V
    .registers 3

    iget-object p1, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {p1, p2}, Landroidx/fragment/app/FragmentActivity;->onAttachFragment(Landroidx/fragment/app/Fragment;)V

    return-void
.end method

.method public addMenuProvider(Landroidx/core/view/h;)V
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, p1}, Landroidx/activity/ComponentActivity;->addMenuProvider(Landroidx/core/view/h;)V

    return-void
.end method

.method public addOnConfigurationChangedListener(Landroidx/core/util/a;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/core/util/a<",
            "Landroid/content/res/Configuration;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, p1}, Landroidx/activity/ComponentActivity;->addOnConfigurationChangedListener(Landroidx/core/util/a;)V

    return-void
.end method

.method public addOnMultiWindowModeChangedListener(Landroidx/core/util/a;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/core/util/a<",
            "Landroidx/core/app/q;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, p1}, Landroidx/activity/ComponentActivity;->addOnMultiWindowModeChangedListener(Landroidx/core/util/a;)V

    return-void
.end method

.method public addOnPictureInPictureModeChangedListener(Landroidx/core/util/a;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/core/util/a<",
            "Landroidx/core/app/d1;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, p1}, Landroidx/activity/ComponentActivity;->addOnPictureInPictureModeChangedListener(Landroidx/core/util/a;)V

    return-void
.end method

.method public addOnTrimMemoryListener(Landroidx/core/util/a;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/core/util/a<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, p1}, Landroidx/activity/ComponentActivity;->addOnTrimMemoryListener(Landroidx/core/util/a;)V

    return-void
.end method

.method public c(I)Landroid/view/View;
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, p1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object p1

    return-object p1
.end method

.method public d()Z
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    if-eqz v0, :cond_10

    invoke-virtual {v0}, Landroid/view/Window;->peekDecorView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_10

    const/4 v0, 0x1

    goto :goto_11

    :cond_10
    const/4 v0, 0x0

    :goto_11
    return v0
.end method

.method public getActivityResultRegistry()Landroidx/activity/result/ActivityResultRegistry;
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0}, Landroidx/activity/ComponentActivity;->getActivityResultRegistry()Landroidx/activity/result/ActivityResultRegistry;

    move-result-object v0

    return-object v0
.end method

.method public getLifecycle()Landroidx/lifecycle/e;
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    iget-object v0, v0, Landroidx/fragment/app/FragmentActivity;->mFragmentLifecycleRegistry:Landroidx/lifecycle/j;

    return-object v0
.end method

.method public getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0}, Landroidx/activity/ComponentActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;

    move-result-object v0

    return-object v0
.end method

.method public getSavedStateRegistry()Landroidx/savedstate/a;
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0}, Landroidx/activity/ComponentActivity;->getSavedStateRegistry()Landroidx/savedstate/a;

    move-result-object v0

    return-object v0
.end method

.method public getViewModelStore()Landroidx/lifecycle/d0;
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0}, Landroidx/activity/ComponentActivity;->getViewModelStore()Landroidx/lifecycle/d0;

    move-result-object v0

    return-object v0
.end method

.method public h(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .registers 6

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroidx/fragment/app/FragmentActivity;->dump(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    return-void
.end method

.method public bridge synthetic i()Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0}, Landroidx/fragment/app/FragmentActivity$a;->q()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    return-object v0
.end method

.method public j()Landroid/view/LayoutInflater;
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iget-object v1, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, v1}, Landroid/view/LayoutInflater;->cloneInContext(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    return-object v0
.end method

.method public l(Ljava/lang/String;)Z
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-static {v0, p1}, Landroidx/core/app/a;->f(Landroid/app/Activity;Ljava/lang/String;)Z

    move-result p1

    return p1
.end method

.method public o()V
    .registers 1

    invoke-virtual {p0}, Landroidx/fragment/app/FragmentActivity$a;->p()V

    return-void
.end method

.method public p()V
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0}, Landroidx/activity/ComponentActivity;->invalidateMenu()V

    return-void
.end method

.method public q()Landroidx/fragment/app/FragmentActivity;
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    return-object v0
.end method

.method public removeMenuProvider(Landroidx/core/view/h;)V
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, p1}, Landroidx/activity/ComponentActivity;->removeMenuProvider(Landroidx/core/view/h;)V

    return-void
.end method

.method public removeOnConfigurationChangedListener(Landroidx/core/util/a;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/core/util/a<",
            "Landroid/content/res/Configuration;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, p1}, Landroidx/activity/ComponentActivity;->removeOnConfigurationChangedListener(Landroidx/core/util/a;)V

    return-void
.end method

.method public removeOnMultiWindowModeChangedListener(Landroidx/core/util/a;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/core/util/a<",
            "Landroidx/core/app/q;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, p1}, Landroidx/activity/ComponentActivity;->removeOnMultiWindowModeChangedListener(Landroidx/core/util/a;)V

    return-void
.end method

.method public removeOnPictureInPictureModeChangedListener(Landroidx/core/util/a;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/core/util/a<",
            "Landroidx/core/app/d1;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, p1}, Landroidx/activity/ComponentActivity;->removeOnPictureInPictureModeChangedListener(Landroidx/core/util/a;)V

    return-void
.end method

.method public removeOnTrimMemoryListener(Landroidx/core/util/a;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/core/util/a<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/fragment/app/FragmentActivity$a;->i:Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {v0, p1}, Landroidx/activity/ComponentActivity;->removeOnTrimMemoryListener(Landroidx/core/util/a;)V

    return-void
.end method
