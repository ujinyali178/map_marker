.class public final Lw2/e1;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static final a(Ljava/util/concurrent/Executor;)Lw2/c0;
    .registers 2

    instance-of v0, p0, Lw2/s0;

    if-eqz v0, :cond_8

    move-object v0, p0

    check-cast v0, Lw2/s0;

    goto :goto_9

    :cond_8
    const/4 v0, 0x0

    :goto_9
    if-eqz v0, :cond_f

    iget-object v0, v0, Lw2/s0;->c:Lw2/c0;

    if-nez v0, :cond_14

    :cond_f
    new-instance v0, Lw2/d1;

    invoke-direct {v0, p0}, Lw2/d1;-><init>(Ljava/util/concurrent/Executor;)V

    :cond_14
    return-object v0
.end method
