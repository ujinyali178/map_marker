.class Landroidx/fragment/app/w$g;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/fragment/app/a0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/fragment/app/w;->n(Landroidx/fragment/app/o;Landroidx/fragment/app/k;Landroidx/fragment/app/Fragment;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic c:Landroidx/fragment/app/Fragment;

.field final synthetic d:Landroidx/fragment/app/w;


# direct methods
.method constructor <init>(Landroidx/fragment/app/w;Landroidx/fragment/app/Fragment;)V
    .registers 3

    iput-object p1, p0, Landroidx/fragment/app/w$g;->d:Landroidx/fragment/app/w;

    iput-object p2, p0, Landroidx/fragment/app/w$g;->c:Landroidx/fragment/app/Fragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroidx/fragment/app/w;Landroidx/fragment/app/Fragment;)V
    .registers 3

    iget-object p1, p0, Landroidx/fragment/app/w$g;->c:Landroidx/fragment/app/Fragment;

    invoke-virtual {p1, p2}, Landroidx/fragment/app/Fragment;->onAttachFragment(Landroidx/fragment/app/Fragment;)V

    return-void
.end method
