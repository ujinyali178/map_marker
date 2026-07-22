.class public final Landroidx/core/os/j;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/os/j$a;
    }
.end annotation


# direct methods
.method public static a(Landroid/os/Handler;)Ljava/util/concurrent/Executor;
    .registers 2

    new-instance v0, Landroidx/core/os/j$a;

    invoke-direct {v0, p0}, Landroidx/core/os/j$a;-><init>(Landroid/os/Handler;)V

    return-object v0
.end method
