.class public final Lw2/f0;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static final a(Li2/g;Ljava/lang/Throwable;)V
    .registers 3

    :try_start_0
    sget-object v0, Lw2/d0;->b:Lw2/d0$a;

    invoke-interface {p0, v0}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object v0

    check-cast v0, Lw2/d0;

    if-eqz v0, :cond_e

    invoke-interface {v0, p0, p1}, Lw2/d0;->u(Li2/g;Ljava/lang/Throwable;)V
    :try_end_d
    .catchall {:try_start_0 .. :try_end_d} :catchall_12

    return-void

    :cond_e
    invoke-static {p0, p1}, Lw2/e0;->a(Li2/g;Ljava/lang/Throwable;)V

    return-void

    :catchall_12
    move-exception v0

    invoke-static {p1, v0}, Lw2/f0;->b(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object p1

    invoke-static {p0, p1}, Lw2/e0;->a(Li2/g;Ljava/lang/Throwable;)V

    return-void
.end method

.method public static final b(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    .registers 4

    if-ne p0, p1, :cond_3

    return-object p0

    :cond_3
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Exception while trying to handle coroutine exception"

    invoke-direct {v0, v1, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-static {v0, p0}, Lg2/a;->a(Ljava/lang/Throwable;Ljava/lang/Throwable;)V

    return-object v0
.end method
