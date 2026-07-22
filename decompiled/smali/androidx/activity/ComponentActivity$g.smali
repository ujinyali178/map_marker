.class Landroidx/activity/ComponentActivity$g;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/activity/ComponentActivity$f;
.implements Landroid/view/ViewTreeObserver$OnDrawListener;
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/activity/ComponentActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "g"
.end annotation


# instance fields
.field final c:J

.field d:Ljava/lang/Runnable;

.field f:Z

.field final synthetic g:Landroidx/activity/ComponentActivity;


# direct methods
.method constructor <init>(Landroidx/activity/ComponentActivity;)V
    .registers 6

    iput-object p1, p0, Landroidx/activity/ComponentActivity$g;->g:Landroidx/activity/ComponentActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    const-wide/16 v2, 0x2710

    add-long/2addr v0, v2

    iput-wide v0, p0, Landroidx/activity/ComponentActivity$g;->c:J

    const/4 p1, 0x0

    iput-boolean p1, p0, Landroidx/activity/ComponentActivity$g;->f:Z

    return-void
.end method

.method public static synthetic a(Landroidx/activity/ComponentActivity$g;)V
    .registers 1

    invoke-direct {p0}, Landroidx/activity/ComponentActivity$g;->c()V

    return-void
.end method

.method private synthetic c()V
    .registers 2

    iget-object v0, p0, Landroidx/activity/ComponentActivity$g;->d:Ljava/lang/Runnable;

    if-eqz v0, :cond_a

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/activity/ComponentActivity$g;->d:Ljava/lang/Runnable;

    :cond_a
    return-void
.end method


# virtual methods
.method public b()V
    .registers 2

    iget-object v0, p0, Landroidx/activity/ComponentActivity$g;->g:Landroidx/activity/ComponentActivity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    iget-object v0, p0, Landroidx/activity/ComponentActivity$g;->g:Landroidx/activity/ComponentActivity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnDrawListener(Landroid/view/ViewTreeObserver$OnDrawListener;)V

    return-void
.end method

.method public e(Landroid/view/View;)V
    .registers 3

    iget-boolean v0, p0, Landroidx/activity/ComponentActivity$g;->f:Z

    if-nez v0, :cond_e

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/activity/ComponentActivity$g;->f:Z

    invoke-virtual {p1}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object p1

    invoke-virtual {p1, p0}, Landroid/view/ViewTreeObserver;->addOnDrawListener(Landroid/view/ViewTreeObserver$OnDrawListener;)V

    :cond_e
    return-void
.end method

.method public execute(Ljava/lang/Runnable;)V
    .registers 4

    iput-object p1, p0, Landroidx/activity/ComponentActivity$g;->d:Ljava/lang/Runnable;

    iget-object p1, p0, Landroidx/activity/ComponentActivity$g;->g:Landroidx/activity/ComponentActivity;

    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p1

    invoke-virtual {p1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p1

    iget-boolean v0, p0, Landroidx/activity/ComponentActivity$g;->f:Z

    if-eqz v0, :cond_22

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_1e

    invoke-virtual {p1}, Landroid/view/View;->invalidate()V

    goto :goto_2a

    :cond_1e
    invoke-virtual {p1}, Landroid/view/View;->postInvalidate()V

    goto :goto_2a

    :cond_22
    new-instance v0, Landroidx/activity/f;

    invoke-direct {v0, p0}, Landroidx/activity/f;-><init>(Landroidx/activity/ComponentActivity$g;)V

    invoke-virtual {p1, v0}, Landroid/view/View;->postOnAnimation(Ljava/lang/Runnable;)V

    :goto_2a
    return-void
.end method

.method public onDraw()V
    .registers 7

    iget-object v0, p0, Landroidx/activity/ComponentActivity$g;->d:Ljava/lang/Runnable;

    const/4 v1, 0x0

    if-eqz v0, :cond_16

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/activity/ComponentActivity$g;->d:Ljava/lang/Runnable;

    iget-object v0, p0, Landroidx/activity/ComponentActivity$g;->g:Landroidx/activity/ComponentActivity;

    iget-object v0, v0, Landroidx/activity/ComponentActivity;->mFullyDrawnReporter:Landroidx/activity/j;

    invoke-virtual {v0}, Landroidx/activity/j;->c()Z

    move-result v0

    if-eqz v0, :cond_2f

    goto :goto_20

    :cond_16
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v2

    iget-wide v4, p0, Landroidx/activity/ComponentActivity$g;->c:J

    cmp-long v0, v2, v4

    if-lez v0, :cond_2f

    :goto_20
    iput-boolean v1, p0, Landroidx/activity/ComponentActivity$g;->f:Z

    iget-object v0, p0, Landroidx/activity/ComponentActivity$g;->g:Landroidx/activity/ComponentActivity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    :cond_2f
    return-void
.end method

.method public run()V
    .registers 2

    iget-object v0, p0, Landroidx/activity/ComponentActivity$g;->g:Landroidx/activity/ComponentActivity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnDrawListener(Landroid/view/ViewTreeObserver$OnDrawListener;)V

    return-void
.end method
