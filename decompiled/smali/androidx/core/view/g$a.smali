.class Landroidx/core/view/g$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/view/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation


# instance fields
.field final a:Landroidx/lifecycle/e;

.field private b:Landroidx/lifecycle/g;


# direct methods
.method constructor <init>(Landroidx/lifecycle/e;Landroidx/lifecycle/g;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/core/view/g$a;->a:Landroidx/lifecycle/e;

    iput-object p2, p0, Landroidx/core/view/g$a;->b:Landroidx/lifecycle/g;

    invoke-virtual {p1, p2}, Landroidx/lifecycle/e;->a(Landroidx/lifecycle/h;)V

    return-void
.end method


# virtual methods
.method a()V
    .registers 3

    iget-object v0, p0, Landroidx/core/view/g$a;->a:Landroidx/lifecycle/e;

    iget-object v1, p0, Landroidx/core/view/g$a;->b:Landroidx/lifecycle/g;

    invoke-virtual {v0, v1}, Landroidx/lifecycle/e;->c(Landroidx/lifecycle/h;)V

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/core/view/g$a;->b:Landroidx/lifecycle/g;

    return-void
.end method
