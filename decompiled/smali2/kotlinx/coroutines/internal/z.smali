.class public Lkotlinx/coroutines/internal/z;
.super Lw2/a;
.source "SourceFile"

# interfaces
.implements Lkotlin/coroutines/jvm/internal/e;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lw2/a<",
        "TT;>;",
        "Lkotlin/coroutines/jvm/internal/e;"
    }
.end annotation


# instance fields
.field public final f:Li2/d;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Li2/d<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Li2/g;Li2/d;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/g;",
            "Li2/d<",
            "-TT;>;)V"
        }
    .end annotation

    const/4 v0, 0x1

    invoke-direct {p0, p1, v0, v0}, Lw2/a;-><init>(Li2/g;ZZ)V

    iput-object p2, p0, Lkotlinx/coroutines/internal/z;->f:Li2/d;

    return-void
.end method


# virtual methods
.method protected C(Ljava/lang/Object;)V
    .registers 5

    iget-object v0, p0, Lkotlinx/coroutines/internal/z;->f:Li2/d;

    invoke-static {v0}, Lj2/b;->b(Li2/d;)Li2/d;

    move-result-object v0

    iget-object v1, p0, Lkotlinx/coroutines/internal/z;->f:Li2/d;

    invoke-static {p1, v1}, Lw2/z;->a(Ljava/lang/Object;Li2/d;)Ljava/lang/Object;

    move-result-object p1

    const/4 v1, 0x0

    const/4 v2, 0x2

    invoke-static {v0, p1, v1, v2, v1}, Lkotlinx/coroutines/internal/g;->c(Li2/d;Ljava/lang/Object;Lp2/l;ILjava/lang/Object;)V

    return-void
.end method

.method public final C0()Lw2/l1;
    .registers 2

    invoke-virtual {p0}, Lw2/s1;->T()Lw2/q;

    move-result-object v0

    if-eqz v0, :cond_b

    invoke-interface {v0}, Lw2/q;->getParent()Lw2/l1;

    move-result-object v0

    goto :goto_c

    :cond_b
    const/4 v0, 0x0

    :goto_c
    return-object v0
.end method

.method protected final Z()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method

.method public final getCallerFrame()Lkotlin/coroutines/jvm/internal/e;
    .registers 3

    iget-object v0, p0, Lkotlinx/coroutines/internal/z;->f:Li2/d;

    instance-of v1, v0, Lkotlin/coroutines/jvm/internal/e;

    if-eqz v1, :cond_9

    check-cast v0, Lkotlin/coroutines/jvm/internal/e;

    goto :goto_a

    :cond_9
    const/4 v0, 0x0

    :goto_a
    return-object v0
.end method

.method protected y0(Ljava/lang/Object;)V
    .registers 3

    iget-object v0, p0, Lkotlinx/coroutines/internal/z;->f:Li2/d;

    invoke-static {p1, v0}, Lw2/z;->a(Ljava/lang/Object;Li2/d;)Ljava/lang/Object;

    move-result-object p1

    invoke-interface {v0, p1}, Li2/d;->resumeWith(Ljava/lang/Object;)V

    return-void
.end method
