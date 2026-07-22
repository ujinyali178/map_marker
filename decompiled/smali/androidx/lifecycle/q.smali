.class public Landroidx/lifecycle/q;
.super Landroid/app/Fragment;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/lifecycle/q$a;,
        Landroidx/lifecycle/q$b;,
        Landroidx/lifecycle/q$c;
    }
.end annotation


# static fields
.field public static final d:Landroidx/lifecycle/q$b;


# instance fields
.field private c:Landroidx/lifecycle/q$a;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Landroidx/lifecycle/q$b;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroidx/lifecycle/q$b;-><init>(Lkotlin/jvm/internal/g;)V

    sput-object v0, Landroidx/lifecycle/q;->d:Landroidx/lifecycle/q$b;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method

.method private final a(Landroidx/lifecycle/e$a;)V
    .registers 5

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1d

    if-ge v0, v1, :cond_14

    sget-object v0, Landroidx/lifecycle/q;->d:Landroidx/lifecycle/q$b;

    invoke-virtual {p0}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-string v2, "activity"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v1, p1}, Landroidx/lifecycle/q$b;->a(Landroid/app/Activity;Landroidx/lifecycle/e$a;)V

    :cond_14
    return-void
.end method

.method private final b(Landroidx/lifecycle/q$a;)V
    .registers 2

    if-eqz p1, :cond_5

    invoke-interface {p1}, Landroidx/lifecycle/q$a;->a()V

    :cond_5
    return-void
.end method

.method private final c(Landroidx/lifecycle/q$a;)V
    .registers 2

    if-eqz p1, :cond_5

    invoke-interface {p1}, Landroidx/lifecycle/q$a;->onResume()V

    :cond_5
    return-void
.end method

.method private final d(Landroidx/lifecycle/q$a;)V
    .registers 2

    if-eqz p1, :cond_5

    invoke-interface {p1}, Landroidx/lifecycle/q$a;->onStart()V

    :cond_5
    return-void
.end method

.method public static final e(Landroid/app/Activity;)V
    .registers 2

    sget-object v0, Landroidx/lifecycle/q;->d:Landroidx/lifecycle/q$b;

    invoke-virtual {v0, p0}, Landroidx/lifecycle/q$b;->b(Landroid/app/Activity;)V

    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .registers 2

    invoke-super {p0, p1}, Landroid/app/Fragment;->onActivityCreated(Landroid/os/Bundle;)V

    iget-object p1, p0, Landroidx/lifecycle/q;->c:Landroidx/lifecycle/q$a;

    invoke-direct {p0, p1}, Landroidx/lifecycle/q;->b(Landroidx/lifecycle/q$a;)V

    sget-object p1, Landroidx/lifecycle/e$a;->ON_CREATE:Landroidx/lifecycle/e$a;

    invoke-direct {p0, p1}, Landroidx/lifecycle/q;->a(Landroidx/lifecycle/e$a;)V

    return-void
.end method

.method public onDestroy()V
    .registers 2

    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    sget-object v0, Landroidx/lifecycle/e$a;->ON_DESTROY:Landroidx/lifecycle/e$a;

    invoke-direct {p0, v0}, Landroidx/lifecycle/q;->a(Landroidx/lifecycle/e$a;)V

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/lifecycle/q;->c:Landroidx/lifecycle/q$a;

    return-void
.end method

.method public onPause()V
    .registers 2

    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    sget-object v0, Landroidx/lifecycle/e$a;->ON_PAUSE:Landroidx/lifecycle/e$a;

    invoke-direct {p0, v0}, Landroidx/lifecycle/q;->a(Landroidx/lifecycle/e$a;)V

    return-void
.end method

.method public onResume()V
    .registers 2

    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    iget-object v0, p0, Landroidx/lifecycle/q;->c:Landroidx/lifecycle/q$a;

    invoke-direct {p0, v0}, Landroidx/lifecycle/q;->c(Landroidx/lifecycle/q$a;)V

    sget-object v0, Landroidx/lifecycle/e$a;->ON_RESUME:Landroidx/lifecycle/e$a;

    invoke-direct {p0, v0}, Landroidx/lifecycle/q;->a(Landroidx/lifecycle/e$a;)V

    return-void
.end method

.method public onStart()V
    .registers 2

    invoke-super {p0}, Landroid/app/Fragment;->onStart()V

    iget-object v0, p0, Landroidx/lifecycle/q;->c:Landroidx/lifecycle/q$a;

    invoke-direct {p0, v0}, Landroidx/lifecycle/q;->d(Landroidx/lifecycle/q$a;)V

    sget-object v0, Landroidx/lifecycle/e$a;->ON_START:Landroidx/lifecycle/e$a;

    invoke-direct {p0, v0}, Landroidx/lifecycle/q;->a(Landroidx/lifecycle/e$a;)V

    return-void
.end method

.method public onStop()V
    .registers 2

    invoke-super {p0}, Landroid/app/Fragment;->onStop()V

    sget-object v0, Landroidx/lifecycle/e$a;->ON_STOP:Landroidx/lifecycle/e$a;

    invoke-direct {p0, v0}, Landroidx/lifecycle/q;->a(Landroidx/lifecycle/e$a;)V

    return-void
.end method
