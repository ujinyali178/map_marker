.class Landroidx/core/view/l$b;
.super Landroidx/core/view/l$a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/view/l;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "b"
.end annotation


# instance fields
.field private b:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/view/View;)V
    .registers 2

    invoke-direct {p0, p1}, Landroidx/core/view/l$a;-><init>(Landroid/view/View;)V

    iput-object p1, p0, Landroidx/core/view/l$b;->b:Landroid/view/View;

    return-void
.end method
