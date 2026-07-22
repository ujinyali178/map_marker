.class public final synthetic Landroidx/core/location/l;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic c:Landroidx/core/location/c$d;

.field public final synthetic d:Ljava/lang/String;

.field public final synthetic f:I

.field public final synthetic g:Landroid/os/Bundle;


# direct methods
.method public synthetic constructor <init>(Landroidx/core/location/c$d;Ljava/lang/String;ILandroid/os/Bundle;)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/core/location/l;->c:Landroidx/core/location/c$d;

    iput-object p2, p0, Landroidx/core/location/l;->d:Ljava/lang/String;

    iput p3, p0, Landroidx/core/location/l;->f:I

    iput-object p4, p0, Landroidx/core/location/l;->g:Landroid/os/Bundle;

    return-void
.end method


# virtual methods
.method public final run()V
    .registers 5

    iget-object v0, p0, Landroidx/core/location/l;->c:Landroidx/core/location/c$d;

    iget-object v1, p0, Landroidx/core/location/l;->d:Ljava/lang/String;

    iget v2, p0, Landroidx/core/location/l;->f:I

    iget-object v3, p0, Landroidx/core/location/l;->g:Landroid/os/Bundle;

    invoke-static {v0, v1, v2, v3}, Landroidx/core/location/c$d;->b(Landroidx/core/location/c$d;Ljava/lang/String;ILandroid/os/Bundle;)V

    return-void
.end method
