.class final Lw2/s0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/concurrent/Executor;


# instance fields
.field public final c:Lw2/c0;


# virtual methods
.method public execute(Ljava/lang/Runnable;)V
    .registers 4

    iget-object v0, p0, Lw2/s0;->c:Lw2/c0;

    sget-object v1, Li2/h;->c:Li2/h;

    invoke-virtual {v0, v1, p1}, Lw2/c0;->g(Li2/g;Ljava/lang/Runnable;)V

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lw2/s0;->c:Lw2/c0;

    invoke-virtual {v0}, Lw2/c0;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
