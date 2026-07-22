.class Landroidx/core/view/n$h;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/view/n;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "h"
.end annotation


# direct methods
.method public static a(Landroid/view/View;)Landroidx/core/view/e0;
    .registers 2

    invoke-static {p0}, Landroidx/core/view/p;->a(Landroid/view/View;)Landroid/view/WindowInsets;

    move-result-object v0

    if-nez v0, :cond_8

    const/4 p0, 0x0

    return-object p0

    :cond_8
    invoke-static {v0}, Landroidx/core/view/e0;->n(Landroid/view/WindowInsets;)Landroidx/core/view/e0;

    move-result-object v0

    invoke-virtual {v0, v0}, Landroidx/core/view/e0;->k(Landroidx/core/view/e0;)V

    invoke-virtual {p0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object p0

    invoke-virtual {v0, p0}, Landroidx/core/view/e0;->d(Landroid/view/View;)V

    return-object v0
.end method

.method static b(Landroid/view/View;)I
    .registers 1

    invoke-static {p0}, Landroidx/core/view/r;->a(Landroid/view/View;)I

    move-result p0

    return p0
.end method

.method static c(Landroid/view/View;I)V
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/view/o;->a(Landroid/view/View;I)V

    return-void
.end method

.method static d(Landroid/view/View;II)V
    .registers 3

    invoke-static {p0, p1, p2}, Landroidx/core/view/q;->a(Landroid/view/View;II)V

    return-void
.end method
