.class public final synthetic Landroidx/core/view/f;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/g;


# instance fields
.field public final synthetic c:Landroidx/core/view/g;

.field public final synthetic d:Landroidx/lifecycle/e$b;

.field public final synthetic f:Landroidx/core/view/h;


# direct methods
.method public synthetic constructor <init>(Landroidx/core/view/g;Landroidx/lifecycle/e$b;Landroidx/core/view/h;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/core/view/f;->c:Landroidx/core/view/g;

    iput-object p2, p0, Landroidx/core/view/f;->d:Landroidx/lifecycle/e$b;

    iput-object p3, p0, Landroidx/core/view/f;->f:Landroidx/core/view/h;

    return-void
.end method


# virtual methods
.method public final e(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 6

    iget-object v0, p0, Landroidx/core/view/f;->c:Landroidx/core/view/g;

    iget-object v1, p0, Landroidx/core/view/f;->d:Landroidx/lifecycle/e$b;

    iget-object v2, p0, Landroidx/core/view/f;->f:Landroidx/core/view/h;

    invoke-static {v0, v1, v2, p1, p2}, Landroidx/core/view/g;->a(Landroidx/core/view/g;Landroidx/lifecycle/e$b;Landroidx/core/view/h;Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V

    return-void
.end method
