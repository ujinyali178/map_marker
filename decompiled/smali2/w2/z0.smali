.class public final Lw2/z0;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static final a()Lw2/w0;
    .registers 2

    new-instance v0, Lw2/f;

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-direct {v0, v1}, Lw2/f;-><init>(Ljava/lang/Thread;)V

    return-object v0
.end method
