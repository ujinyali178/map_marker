.class Landroidx/fragment/app/l0$a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/fragment/app/l0;->a(Landroidx/fragment/app/l0$e$c;Landroidx/fragment/app/l0$e$b;Landroidx/fragment/app/d0;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic c:Landroidx/fragment/app/l0$d;

.field final synthetic d:Landroidx/fragment/app/l0;


# direct methods
.method constructor <init>(Landroidx/fragment/app/l0;Landroidx/fragment/app/l0$d;)V
    .registers 3

    iput-object p1, p0, Landroidx/fragment/app/l0$a;->d:Landroidx/fragment/app/l0;

    iput-object p2, p0, Landroidx/fragment/app/l0$a;->c:Landroidx/fragment/app/l0$d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/l0$a;->d:Landroidx/fragment/app/l0;

    iget-object v0, v0, Landroidx/fragment/app/l0;->b:Ljava/util/ArrayList;

    iget-object v1, p0, Landroidx/fragment/app/l0$a;->c:Landroidx/fragment/app/l0$d;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1d

    iget-object v0, p0, Landroidx/fragment/app/l0$a;->c:Landroidx/fragment/app/l0$d;

    invoke-virtual {v0}, Landroidx/fragment/app/l0$e;->e()Landroidx/fragment/app/l0$e$c;

    move-result-object v0

    iget-object v1, p0, Landroidx/fragment/app/l0$a;->c:Landroidx/fragment/app/l0$d;

    invoke-virtual {v1}, Landroidx/fragment/app/l0$e;->f()Landroidx/fragment/app/Fragment;

    move-result-object v1

    iget-object v1, v1, Landroidx/fragment/app/Fragment;->mView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroidx/fragment/app/l0$e$c;->a(Landroid/view/View;)V

    :cond_1d
    return-void
.end method
