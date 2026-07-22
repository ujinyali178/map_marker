.class public final Lw2/p0;
.super Lkotlinx/coroutines/internal/z;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lkotlinx/coroutines/internal/z<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final synthetic g:Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;


# instance fields
.field private volatile synthetic _decision:I


# direct methods
.method static constructor <clinit>()V
    .registers 2

    const-class v0, Lw2/p0;

    const-string v1, "_decision"

    invoke-static {v0, v1}, Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;->newUpdater(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;

    move-result-object v0

    sput-object v0, Lw2/p0;->g:Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;

    return-void
.end method

.method public constructor <init>(Li2/g;Li2/d;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/g;",
            "Li2/d<",
            "-TT;>;)V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Lkotlinx/coroutines/internal/z;-><init>(Li2/g;Li2/d;)V

    const/4 p1, 0x0

    iput p1, p0, Lw2/p0;->_decision:I

    return-void
.end method

.method private final E0()Z
    .registers 5

    :cond_0
    iget v0, p0, Lw2/p0;->_decision:I

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_15

    if-ne v0, v2, :cond_9

    return v1

    :cond_9
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Already resumed"

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_15
    sget-object v0, Lw2/p0;->g:Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;

    const/4 v3, 0x2

    invoke-virtual {v0, p0, v1, v3}, Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;->compareAndSet(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_0

    return v2
.end method

.method private final F0()Z
    .registers 4

    :cond_0
    iget v0, p0, Lw2/p0;->_decision:I

    const/4 v1, 0x0

    if-eqz v0, :cond_15

    const/4 v2, 0x2

    if-ne v0, v2, :cond_9

    return v1

    :cond_9
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Already suspended"

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_15
    sget-object v0, Lw2/p0;->g:Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;

    const/4 v2, 0x1

    invoke-virtual {v0, p0, v1, v2}, Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;->compareAndSet(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_0

    return v2
.end method


# virtual methods
.method protected C(Ljava/lang/Object;)V
    .registers 2

    invoke-virtual {p0, p1}, Lw2/p0;->y0(Ljava/lang/Object;)V

    return-void
.end method

.method public final D0()Ljava/lang/Object;
    .registers 3

    invoke-direct {p0}, Lw2/p0;->F0()Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_b
    invoke-virtual {p0}, Lw2/s1;->U()Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lw2/t1;->h(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    instance-of v1, v0, Lw2/v;

    if-nez v1, :cond_18

    return-object v0

    :cond_18
    check-cast v0, Lw2/v;

    iget-object v0, v0, Lw2/v;->a:Ljava/lang/Throwable;

    throw v0
.end method

.method protected y0(Ljava/lang/Object;)V
    .registers 5

    invoke-direct {p0}, Lw2/p0;->E0()Z

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-object v0, p0, Lkotlinx/coroutines/internal/z;->f:Li2/d;

    invoke-static {v0}, Lj2/b;->b(Li2/d;)Li2/d;

    move-result-object v0

    iget-object v1, p0, Lkotlinx/coroutines/internal/z;->f:Li2/d;

    invoke-static {p1, v1}, Lw2/z;->a(Ljava/lang/Object;Li2/d;)Ljava/lang/Object;

    move-result-object p1

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-static {v0, p1, v2, v1, v2}, Lkotlinx/coroutines/internal/g;->c(Li2/d;Ljava/lang/Object;Lp2/l;ILjava/lang/Object;)V

    return-void
.end method
