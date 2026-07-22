.class public final Landroidx/core/view/l;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/view/l$b;,
        Landroidx/core/view/l$c;,
        Landroidx/core/view/l$a;
    }
.end annotation


# instance fields
.field private final a:Landroidx/core/view/l$c;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1e

    if-lt v0, v1, :cond_11

    new-instance v0, Landroidx/core/view/l$b;

    invoke-direct {v0, p1}, Landroidx/core/view/l$b;-><init>(Landroid/view/View;)V

    :goto_e
    iput-object v0, p0, Landroidx/core/view/l;->a:Landroidx/core/view/l$c;

    goto :goto_17

    :cond_11
    new-instance v0, Landroidx/core/view/l$a;

    invoke-direct {v0, p1}, Landroidx/core/view/l$a;-><init>(Landroid/view/View;)V

    goto :goto_e

    :goto_17
    return-void
.end method
