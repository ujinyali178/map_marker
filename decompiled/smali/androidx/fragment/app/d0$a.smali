.class Landroidx/fragment/app/d0$a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnAttachStateChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/fragment/app/d0;->f()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic c:Landroid/view/View;

.field final synthetic d:Landroidx/fragment/app/d0;


# direct methods
.method constructor <init>(Landroidx/fragment/app/d0;Landroid/view/View;)V
    .registers 3

    iput-object p1, p0, Landroidx/fragment/app/d0$a;->d:Landroidx/fragment/app/d0;

    iput-object p2, p0, Landroidx/fragment/app/d0$a;->c:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onViewAttachedToWindow(Landroid/view/View;)V
    .registers 2

    iget-object p1, p0, Landroidx/fragment/app/d0$a;->c:Landroid/view/View;

    invoke-virtual {p1, p0}, Landroid/view/View;->removeOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    iget-object p1, p0, Landroidx/fragment/app/d0$a;->c:Landroid/view/View;

    invoke-static {p1}, Landroidx/core/view/n;->n(Landroid/view/View;)V

    return-void
.end method

.method public onViewDetachedFromWindow(Landroid/view/View;)V
    .registers 2

    return-void
.end method
