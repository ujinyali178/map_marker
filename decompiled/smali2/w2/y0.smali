.class public abstract Lw2/y0;
.super Lw2/w0;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lw2/w0;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract F()Ljava/lang/Thread;
.end method

.method protected G(JLw2/x0$a;)V
    .registers 5

    sget-object v0, Lw2/l0;->k:Lw2/l0;

    invoke-virtual {v0, p1, p2, p3}, Lw2/x0;->S(JLw2/x0$a;)V

    return-void
.end method

.method protected final H()V
    .registers 3

    invoke-virtual {p0}, Lw2/y0;->F()Ljava/lang/Thread;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    if-eq v1, v0, :cond_10

    invoke-static {}, Lw2/c;->a()Lw2/b;

    invoke-static {v0}, Ljava/util/concurrent/locks/LockSupport;->unpark(Ljava/lang/Thread;)V

    :cond_10
    return-void
.end method
