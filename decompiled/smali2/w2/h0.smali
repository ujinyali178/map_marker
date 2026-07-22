.class public final Lw2/h0;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static final a(Li2/g;)Lw2/g0;
    .registers 4

    new-instance v0, Lkotlinx/coroutines/internal/e;

    sget-object v1, Lw2/l1;->e:Lw2/l1$b;

    invoke-interface {p0, v1}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object v1

    if-eqz v1, :cond_b

    goto :goto_15

    :cond_b
    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-static {v2, v1, v2}, Lw2/p1;->b(Lw2/l1;ILjava/lang/Object;)Lw2/t;

    move-result-object v1

    invoke-interface {p0, v1}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object p0

    :goto_15
    invoke-direct {v0, p0}, Lkotlinx/coroutines/internal/e;-><init>(Li2/g;)V

    return-object v0
.end method
