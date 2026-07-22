.class Landroidx/core/view/l$a;
.super Landroidx/core/view/l$c;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/view/l;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation


# instance fields
.field private final a:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/view/View;)V
    .registers 2

    invoke-direct {p0}, Landroidx/core/view/l$c;-><init>()V

    iput-object p1, p0, Landroidx/core/view/l$a;->a:Landroid/view/View;

    return-void
.end method
