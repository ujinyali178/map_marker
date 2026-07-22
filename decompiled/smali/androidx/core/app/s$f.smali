.class public abstract Landroidx/core/app/s$f;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/app/s;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "f"
.end annotation


# instance fields
.field protected a:Landroidx/core/app/s$d;

.field b:Ljava/lang/CharSequence;

.field c:Ljava/lang/CharSequence;

.field d:Z


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/core/app/s$f;->d:Z

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Bundle;)V
    .registers 4

    iget-boolean v0, p0, Landroidx/core/app/s$f;->d:Z

    if-eqz v0, :cond_b

    iget-object v0, p0, Landroidx/core/app/s$f;->c:Ljava/lang/CharSequence;

    const-string v1, "android.summaryText"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putCharSequence(Ljava/lang/String;Ljava/lang/CharSequence;)V

    :cond_b
    iget-object v0, p0, Landroidx/core/app/s$f;->b:Ljava/lang/CharSequence;

    if-eqz v0, :cond_14

    const-string v1, "android.title.big"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putCharSequence(Ljava/lang/String;Ljava/lang/CharSequence;)V

    :cond_14
    invoke-virtual {p0}, Landroidx/core/app/s$f;->c()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1f

    const-string v1, "androidx.core.app.extra.COMPAT_TEMPLATE"

    invoke-virtual {p1, v1, v0}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1f
    return-void
.end method

.method public abstract b(Landroidx/core/app/r;)V
.end method

.method protected abstract c()Ljava/lang/String;
.end method

.method public d(Landroidx/core/app/r;)Landroid/widget/RemoteViews;
    .registers 2

    const/4 p1, 0x0

    return-object p1
.end method

.method public e(Landroidx/core/app/r;)Landroid/widget/RemoteViews;
    .registers 2

    const/4 p1, 0x0

    return-object p1
.end method

.method public f(Landroidx/core/app/r;)Landroid/widget/RemoteViews;
    .registers 2

    const/4 p1, 0x0

    return-object p1
.end method

.method public g(Landroidx/core/app/s$d;)V
    .registers 3

    iget-object v0, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    if-eq v0, p1, :cond_b

    iput-object p1, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    if-eqz p1, :cond_b

    invoke-virtual {p1, p0}, Landroidx/core/app/s$d;->p(Landroidx/core/app/s$f;)Landroidx/core/app/s$d;

    :cond_b
    return-void
.end method
