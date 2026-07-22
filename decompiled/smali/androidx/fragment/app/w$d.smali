.class Landroidx/fragment/app/w$d;
.super Landroidx/fragment/app/n;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/fragment/app/w;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Landroidx/fragment/app/w;


# direct methods
.method constructor <init>(Landroidx/fragment/app/w;)V
    .registers 2

    iput-object p1, p0, Landroidx/fragment/app/w$d;->b:Landroidx/fragment/app/w;

    invoke-direct {p0}, Landroidx/fragment/app/n;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/ClassLoader;Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    .registers 5

    iget-object p1, p0, Landroidx/fragment/app/w$d;->b:Landroidx/fragment/app/w;

    invoke-virtual {p1}, Landroidx/fragment/app/w;->v0()Landroidx/fragment/app/o;

    move-result-object p1

    iget-object v0, p0, Landroidx/fragment/app/w$d;->b:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->v0()Landroidx/fragment/app/o;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/o;->f()Landroid/content/Context;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroidx/fragment/app/k;->b(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroidx/fragment/app/Fragment;

    move-result-object p1

    return-object p1
.end method
