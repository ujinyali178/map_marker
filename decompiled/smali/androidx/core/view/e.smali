.class public final synthetic Landroidx/core/view/e;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/g;


# instance fields
.field public final synthetic c:Landroidx/core/view/g;

.field public final synthetic d:Landroidx/core/view/h;


# direct methods
.method public synthetic constructor <init>(Landroidx/core/view/g;Landroidx/core/view/h;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/core/view/e;->c:Landroidx/core/view/g;

    iput-object p2, p0, Landroidx/core/view/e;->d:Landroidx/core/view/h;

    return-void
.end method


# virtual methods
.method public final e(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 5

    iget-object v0, p0, Landroidx/core/view/e;->c:Landroidx/core/view/g;

    iget-object v1, p0, Landroidx/core/view/e;->d:Landroidx/core/view/h;

    invoke-static {v0, v1, p1, p2}, Landroidx/core/view/g;->b(Landroidx/core/view/g;Landroidx/core/view/h;Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V

    return-void
.end method
