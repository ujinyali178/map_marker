.class public Landroidx/activity/h;
.super Landroid/app/Dialog;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/i;
.implements Landroidx/activity/n;
.implements Lq/d;


# instance fields
.field private c:Landroidx/lifecycle/j;

.field private final d:Lq/c;

.field private final f:Landroidx/activity/OnBackPressedDispatcher;


# direct methods
.method public constructor <init>(Landroid/content/Context;I)V
    .registers 4

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    sget-object p1, Lq/c;->d:Lq/c$a;

    invoke-virtual {p1, p0}, Lq/c$a;->a(Lq/d;)Lq/c;

    move-result-object p1

    iput-object p1, p0, Landroidx/activity/h;->d:Lq/c;

    new-instance p1, Landroidx/activity/OnBackPressedDispatcher;

    new-instance p2, Landroidx/activity/g;

    invoke-direct {p2, p0}, Landroidx/activity/g;-><init>(Landroidx/activity/h;)V

    invoke-direct {p1, p2}, Landroidx/activity/OnBackPressedDispatcher;-><init>(Ljava/lang/Runnable;)V

    iput-object p1, p0, Landroidx/activity/h;->f:Landroidx/activity/OnBackPressedDispatcher;

    return-void
.end method

.method public static synthetic a(Landroidx/activity/h;)V
    .registers 1

    invoke-static {p0}, Landroidx/activity/h;->d(Landroidx/activity/h;)V

    return-void
.end method

.method private final b()Landroidx/lifecycle/j;
    .registers 2

    iget-object v0, p0, Landroidx/activity/h;->c:Landroidx/lifecycle/j;

    if-nez v0, :cond_b

    new-instance v0, Landroidx/lifecycle/j;

    invoke-direct {v0, p0}, Landroidx/lifecycle/j;-><init>(Landroidx/lifecycle/i;)V

    iput-object v0, p0, Landroidx/activity/h;->c:Landroidx/lifecycle/j;

    :cond_b
    return-object v0
.end method

.method private final c()V
    .registers 3

    invoke-virtual {p0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-static {v0}, Lkotlin/jvm/internal/k;->b(Ljava/lang/Object;)V

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    const-string v1, "window!!.decorView"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0, p0}, Landroidx/lifecycle/f0;->a(Landroid/view/View;Landroidx/lifecycle/i;)V

    invoke-virtual {p0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-static {v0}, Lkotlin/jvm/internal/k;->b(Ljava/lang/Object;)V

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-static {v0, v1}, Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0, p0}, Landroidx/activity/q;->a(Landroid/view/View;Landroidx/activity/n;)V

    invoke-virtual {p0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-static {v0}, Lkotlin/jvm/internal/k;->b(Ljava/lang/Object;)V

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-static {v0, v1}, Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0, p0}, Lq/e;->a(Landroid/view/View;Lq/d;)V

    return-void
.end method

.method private static final d(Landroidx/activity/h;)V
    .registers 2

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-super {p0}, Landroid/app/Dialog;->onBackPressed()V

    return-void
.end method


# virtual methods
.method public addContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .registers 4

    const-string v0, "view"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Landroidx/activity/h;->c()V

    invoke-super {p0, p1, p2}, Landroid/app/Dialog;->addContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    return-void
.end method

.method public getLifecycle()Landroidx/lifecycle/e;
    .registers 2

    invoke-direct {p0}, Landroidx/activity/h;->b()Landroidx/lifecycle/j;

    move-result-object v0

    return-object v0
.end method

.method public final getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    .registers 2

    iget-object v0, p0, Landroidx/activity/h;->f:Landroidx/activity/OnBackPressedDispatcher;

    return-object v0
.end method

.method public getSavedStateRegistry()Landroidx/savedstate/a;
    .registers 2

    iget-object v0, p0, Landroidx/activity/h;->d:Lq/c;

    invoke-virtual {v0}, Lq/c;->b()Landroidx/savedstate/a;

    move-result-object v0

    return-object v0
.end method

.method public onBackPressed()V
    .registers 2

    iget-object v0, p0, Landroidx/activity/h;->f:Landroidx/activity/OnBackPressedDispatcher;

    invoke-virtual {v0}, Landroidx/activity/OnBackPressedDispatcher;->e()V

    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .registers 5

    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x21

    if-lt v0, v1, :cond_17

    iget-object v0, p0, Landroidx/activity/h;->f:Landroidx/activity/OnBackPressedDispatcher;

    invoke-virtual {p0}, Landroid/app/Dialog;->getOnBackInvokedDispatcher()Landroid/window/OnBackInvokedDispatcher;

    move-result-object v1

    const-string v2, "onBackInvokedDispatcher"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroidx/activity/OnBackPressedDispatcher;->f(Landroid/window/OnBackInvokedDispatcher;)V

    :cond_17
    iget-object v0, p0, Landroidx/activity/h;->d:Lq/c;

    invoke-virtual {v0, p1}, Lq/c;->d(Landroid/os/Bundle;)V

    invoke-direct {p0}, Landroidx/activity/h;->b()Landroidx/lifecycle/j;

    move-result-object p1

    sget-object v0, Landroidx/lifecycle/e$a;->ON_CREATE:Landroidx/lifecycle/e$a;

    invoke-virtual {p1, v0}, Landroidx/lifecycle/j;->h(Landroidx/lifecycle/e$a;)V

    return-void
.end method

.method public onSaveInstanceState()Landroid/os/Bundle;
    .registers 3

    invoke-super {p0}, Landroid/app/Dialog;->onSaveInstanceState()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "super.onSaveInstanceState()"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v1, p0, Landroidx/activity/h;->d:Lq/c;

    invoke-virtual {v1, v0}, Lq/c;->e(Landroid/os/Bundle;)V

    return-object v0
.end method

.method protected onStart()V
    .registers 3

    invoke-super {p0}, Landroid/app/Dialog;->onStart()V

    invoke-direct {p0}, Landroidx/activity/h;->b()Landroidx/lifecycle/j;

    move-result-object v0

    sget-object v1, Landroidx/lifecycle/e$a;->ON_RESUME:Landroidx/lifecycle/e$a;

    invoke-virtual {v0, v1}, Landroidx/lifecycle/j;->h(Landroidx/lifecycle/e$a;)V

    return-void
.end method

.method protected onStop()V
    .registers 3

    invoke-direct {p0}, Landroidx/activity/h;->b()Landroidx/lifecycle/j;

    move-result-object v0

    sget-object v1, Landroidx/lifecycle/e$a;->ON_DESTROY:Landroidx/lifecycle/e$a;

    invoke-virtual {v0, v1}, Landroidx/lifecycle/j;->h(Landroidx/lifecycle/e$a;)V

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/activity/h;->c:Landroidx/lifecycle/j;

    invoke-super {p0}, Landroid/app/Dialog;->onStop()V

    return-void
.end method

.method public setContentView(I)V
    .registers 2

    invoke-direct {p0}, Landroidx/activity/h;->c()V

    invoke-super {p0, p1}, Landroid/app/Dialog;->setContentView(I)V

    return-void
.end method

.method public setContentView(Landroid/view/View;)V
    .registers 3

    const-string v0, "view"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Landroidx/activity/h;->c()V

    invoke-super {p0, p1}, Landroid/app/Dialog;->setContentView(Landroid/view/View;)V

    return-void
.end method

.method public setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .registers 4

    const-string v0, "view"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Landroidx/activity/h;->c()V

    invoke-super {p0, p1, p2}, Landroid/app/Dialog;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    return-void
.end method
