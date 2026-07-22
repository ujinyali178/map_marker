.class Landroidx/fragment/app/w$b;
.super Landroidx/activity/l;
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
.field final synthetic d:Landroidx/fragment/app/w;


# direct methods
.method constructor <init>(Landroidx/fragment/app/w;Z)V
    .registers 3

    iput-object p1, p0, Landroidx/fragment/app/w$b;->d:Landroidx/fragment/app/w;

    invoke-direct {p0, p2}, Landroidx/activity/l;-><init>(Z)V

    return-void
.end method


# virtual methods
.method public b()V
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/w$b;->d:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->E0()V

    return-void
.end method
