.class Landroidx/fragment/app/w$e;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/fragment/app/m0;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/fragment/app/w;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroidx/fragment/app/w;


# direct methods
.method constructor <init>(Landroidx/fragment/app/w;)V
    .registers 2

    iput-object p1, p0, Landroidx/fragment/app/w$e;->a:Landroidx/fragment/app/w;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/ViewGroup;)Landroidx/fragment/app/l0;
    .registers 3

    new-instance v0, Landroidx/fragment/app/d;

    invoke-direct {v0, p1}, Landroidx/fragment/app/d;-><init>(Landroid/view/ViewGroup;)V

    return-object v0
.end method
