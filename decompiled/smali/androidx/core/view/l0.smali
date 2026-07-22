.class public final Landroidx/core/view/l0;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/view/l0$d;,
        Landroidx/core/view/l0$e;,
        Landroidx/core/view/l0$c;,
        Landroidx/core/view/l0$b;,
        Landroidx/core/view/l0$a;
    }
.end annotation


# instance fields
.field private final a:Landroidx/core/view/l0$e;


# direct methods
.method public constructor <init>(Landroid/view/Window;Landroid/view/View;)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroidx/core/view/l;

    invoke-direct {v0, p2}, Landroidx/core/view/l;-><init>(Landroid/view/View;)V

    sget p2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1e

    if-lt p2, v1, :cond_16

    new-instance p2, Landroidx/core/view/l0$d;

    invoke-direct {p2, p1, p0, v0}, Landroidx/core/view/l0$d;-><init>(Landroid/view/Window;Landroidx/core/view/l0;Landroidx/core/view/l;)V

    :goto_13
    iput-object p2, p0, Landroidx/core/view/l0;->a:Landroidx/core/view/l0$e;

    goto :goto_30

    :cond_16
    const/16 v1, 0x1a

    if-lt p2, v1, :cond_20

    new-instance p2, Landroidx/core/view/l0$c;

    invoke-direct {p2, p1, v0}, Landroidx/core/view/l0$c;-><init>(Landroid/view/Window;Landroidx/core/view/l;)V

    goto :goto_13

    :cond_20
    const/16 v1, 0x17

    if-lt p2, v1, :cond_2a

    new-instance p2, Landroidx/core/view/l0$b;

    invoke-direct {p2, p1, v0}, Landroidx/core/view/l0$b;-><init>(Landroid/view/Window;Landroidx/core/view/l;)V

    goto :goto_13

    :cond_2a
    new-instance p2, Landroidx/core/view/l0$a;

    invoke-direct {p2, p1, v0}, Landroidx/core/view/l0$a;-><init>(Landroid/view/Window;Landroidx/core/view/l;)V

    goto :goto_13

    :goto_30
    return-void
.end method


# virtual methods
.method public a(Z)V
    .registers 3

    iget-object v0, p0, Landroidx/core/view/l0;->a:Landroidx/core/view/l0$e;

    invoke-virtual {v0, p1}, Landroidx/core/view/l0$e;->a(Z)V

    return-void
.end method

.method public b(Z)V
    .registers 3

    iget-object v0, p0, Landroidx/core/view/l0;->a:Landroidx/core/view/l0$e;

    invoke-virtual {v0, p1}, Landroidx/core/view/l0$e;->b(Z)V

    return-void
.end method
