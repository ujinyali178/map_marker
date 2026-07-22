.class Landroidx/fragment/app/Fragment$6;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/g;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/fragment/app/Fragment;->performCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic c:Landroidx/fragment/app/Fragment;


# direct methods
.method constructor <init>(Landroidx/fragment/app/Fragment;)V
    .registers 2

    iput-object p1, p0, Landroidx/fragment/app/Fragment$6;->c:Landroidx/fragment/app/Fragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public e(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 3

    sget-object p1, Landroidx/lifecycle/e$a;->ON_STOP:Landroidx/lifecycle/e$a;

    if-ne p2, p1, :cond_d

    iget-object p1, p0, Landroidx/fragment/app/Fragment$6;->c:Landroidx/fragment/app/Fragment;

    iget-object p1, p1, Landroidx/fragment/app/Fragment;->mView:Landroid/view/View;

    if-eqz p1, :cond_d

    invoke-static {p1}, Landroidx/fragment/app/Fragment$k;->a(Landroid/view/View;)V

    :cond_d
    return-void
.end method
