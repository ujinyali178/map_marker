.class public Lw2/l;
.super Lw2/q0;
.source "SourceFile"

# interfaces
.implements Lw2/k;
.implements Lkotlin/coroutines/jvm/internal/e;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lw2/q0<",
        "TT;>;",
        "Lw2/k<",
        "TT;>;",
        "Lkotlin/coroutines/jvm/internal/e;"
    }
.end annotation


# static fields
.field private static final synthetic j:Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;

.field private static final synthetic k:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;


# instance fields
.field private volatile synthetic _decision:I

.field private volatile synthetic _state:Ljava/lang/Object;

.field private final g:Li2/d;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Li2/d<",
            "TT;>;"
        }
    .end annotation
.end field

.field private final h:Li2/g;

.field private i:Lw2/u0;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    const-class v0, Lw2/l;

    const-string v1, "_decision"

    invoke-static {v0, v1}, Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;->newUpdater(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;

    move-result-object v0

    sput-object v0, Lw2/l;->j:Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;

    const-class v0, Lw2/l;

    const-class v1, Ljava/lang/Object;

    const-string v2, "_state"

    invoke-static {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;->newUpdater(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    move-result-object v0

    sput-object v0, Lw2/l;->k:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    return-void
.end method

.method public constructor <init>(Li2/d;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/d<",
            "-TT;>;I)V"
        }
    .end annotation

    invoke-direct {p0, p2}, Lw2/q0;-><init>(I)V

    iput-object p1, p0, Lw2/l;->g:Li2/d;

    invoke-interface {p1}, Li2/d;->getContext()Li2/g;

    move-result-object p1

    iput-object p1, p0, Lw2/l;->h:Li2/g;

    const/4 p1, 0x0

    iput p1, p0, Lw2/l;->_decision:I

    sget-object p1, Lw2/d;->c:Lw2/d;

    iput-object p1, p0, Lw2/l;->_state:Ljava/lang/Object;

    return-void
.end method

.method private final A()Z
    .registers 2

    iget v0, p0, Lw2/q0;->f:I

    invoke-static {v0}, Lw2/r0;->c(I)Z

    move-result v0

    if-eqz v0, :cond_14

    iget-object v0, p0, Lw2/l;->g:Li2/d;

    check-cast v0, Lkotlinx/coroutines/internal/f;

    invoke-virtual {v0}, Lkotlinx/coroutines/internal/f;->o()Z

    move-result v0

    if-eqz v0, :cond_14

    const/4 v0, 0x1

    goto :goto_15

    :cond_14
    const/4 v0, 0x0

    :goto_15
    return v0
.end method

.method private final B(Lp2/l;)Lw2/i;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;)",
            "Lw2/i;"
        }
    .end annotation

    instance-of v0, p1, Lw2/i;

    if-eqz v0, :cond_7

    check-cast p1, Lw2/i;

    goto :goto_d

    :cond_7
    new-instance v0, Lw2/i1;

    invoke-direct {v0, p1}, Lw2/i1;-><init>(Lp2/l;)V

    move-object p1, v0

    :goto_d
    return-object p1
.end method

.method private final C(Lp2/l;Ljava/lang/Object;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "It\'s prohibited to register multiple handlers, tried to register "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p1, ", already has "

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private final F()V
    .registers 3

    iget-object v0, p0, Lw2/l;->g:Li2/d;

    instance-of v1, v0, Lkotlinx/coroutines/internal/f;

    if-eqz v1, :cond_9

    check-cast v0, Lkotlinx/coroutines/internal/f;

    goto :goto_a

    :cond_9
    const/4 v0, 0x0

    :goto_a
    if-eqz v0, :cond_19

    invoke-virtual {v0, p0}, Lkotlinx/coroutines/internal/f;->r(Lw2/k;)Ljava/lang/Throwable;

    move-result-object v0

    if-nez v0, :cond_13

    goto :goto_19

    :cond_13
    invoke-virtual {p0}, Lw2/l;->r()V

    invoke-virtual {p0, v0}, Lw2/l;->p(Ljava/lang/Throwable;)Z

    :cond_19
    :goto_19
    return-void
.end method

.method private final H(Ljava/lang/Object;ILp2/l;)V
    .registers 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "I",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;)V"
        }
    .end annotation

    :cond_0
    iget-object v0, p0, Lw2/l;->_state:Ljava/lang/Object;

    instance-of v1, v0, Lw2/y1;

    if-eqz v1, :cond_21

    move-object v3, v0

    check-cast v3, Lw2/y1;

    const/4 v7, 0x0

    move-object v2, p0

    move-object v4, p1

    move v5, p2

    move-object v6, p3

    invoke-direct/range {v2 .. v7}, Lw2/l;->J(Lw2/y1;Ljava/lang/Object;ILp2/l;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    sget-object v2, Lw2/l;->k:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {v2, p0, v0, v1}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lw2/l;->s()V

    invoke-direct {p0, p2}, Lw2/l;->t(I)V

    return-void

    :cond_21
    instance-of p2, v0, Lw2/o;

    if-eqz p2, :cond_35

    check-cast v0, Lw2/o;

    invoke-virtual {v0}, Lw2/o;->c()Z

    move-result p2

    if-eqz p2, :cond_35

    if-eqz p3, :cond_34

    iget-object p1, v0, Lw2/v;->a:Ljava/lang/Throwable;

    invoke-virtual {p0, p3, p1}, Lw2/l;->o(Lp2/l;Ljava/lang/Throwable;)V

    :cond_34
    return-void

    :cond_35
    invoke-direct {p0, p1}, Lw2/l;->j(Ljava/lang/Object;)Ljava/lang/Void;

    new-instance p1, Lg2/d;

    invoke-direct {p1}, Lg2/d;-><init>()V

    throw p1
.end method

.method static synthetic I(Lw2/l;Ljava/lang/Object;ILp2/l;ILjava/lang/Object;)V
    .registers 6

    if-nez p5, :cond_b

    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_7

    const/4 p3, 0x0

    :cond_7
    invoke-direct {p0, p1, p2, p3}, Lw2/l;->H(Ljava/lang/Object;ILp2/l;)V

    return-void

    :cond_b
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: resumeImpl"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private final J(Lw2/y1;Ljava/lang/Object;ILp2/l;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lw2/y1;",
            "Ljava/lang/Object;",
            "I",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;",
            "Ljava/lang/Object;",
            ")",
            "Ljava/lang/Object;"
        }
    .end annotation

    instance-of v0, p2, Lw2/v;

    if-eqz v0, :cond_5

    goto :goto_31

    :cond_5
    invoke-static {p3}, Lw2/r0;->b(I)Z

    move-result p3

    if-nez p3, :cond_e

    if-nez p5, :cond_e

    goto :goto_31

    :cond_e
    if-nez p4, :cond_1a

    instance-of p3, p1, Lw2/i;

    if-eqz p3, :cond_18

    instance-of p3, p1, Lw2/e;

    if-eqz p3, :cond_1a

    :cond_18
    if-eqz p5, :cond_31

    :cond_1a
    new-instance p3, Lw2/u;

    instance-of v0, p1, Lw2/i;

    if-eqz v0, :cond_23

    check-cast p1, Lw2/i;

    goto :goto_24

    :cond_23
    const/4 p1, 0x0

    :goto_24
    move-object v2, p1

    const/4 v5, 0x0

    const/16 v6, 0x10

    const/4 v7, 0x0

    move-object v0, p3

    move-object v1, p2

    move-object v3, p4

    move-object v4, p5

    invoke-direct/range {v0 .. v7}, Lw2/u;-><init>(Ljava/lang/Object;Lw2/i;Lp2/l;Ljava/lang/Object;Ljava/lang/Throwable;ILkotlin/jvm/internal/g;)V

    move-object p2, p3

    :cond_31
    :goto_31
    return-object p2
.end method

.method private final K()Z
    .registers 5

    :cond_0
    iget v0, p0, Lw2/l;->_decision:I

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
    sget-object v0, Lw2/l;->j:Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;

    const/4 v3, 0x2

    invoke-virtual {v0, p0, v1, v3}, Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;->compareAndSet(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_0

    return v2
.end method

.method private final L(Ljava/lang/Object;Ljava/lang/Object;Lp2/l;)Lkotlinx/coroutines/internal/b0;
    .registers 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;)",
            "Lkotlinx/coroutines/internal/b0;"
        }
    .end annotation

    :cond_0
    iget-object v0, p0, Lw2/l;->_state:Ljava/lang/Object;

    instance-of v1, v0, Lw2/y1;

    if-eqz v1, :cond_21

    move-object v3, v0

    check-cast v3, Lw2/y1;

    iget v5, p0, Lw2/q0;->f:I

    move-object v2, p0

    move-object v4, p1

    move-object v6, p3

    move-object v7, p2

    invoke-direct/range {v2 .. v7}, Lw2/l;->J(Lw2/y1;Ljava/lang/Object;ILp2/l;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    sget-object v2, Lw2/l;->k:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {v2, p0, v0, v1}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lw2/l;->s()V

    sget-object p1, Lw2/m;->a:Lkotlinx/coroutines/internal/b0;

    return-object p1

    :cond_21
    instance-of p1, v0, Lw2/u;

    const/4 p3, 0x0

    if-eqz p1, :cond_30

    if-eqz p2, :cond_30

    check-cast v0, Lw2/u;

    iget-object p1, v0, Lw2/u;->d:Ljava/lang/Object;

    if-ne p1, p2, :cond_30

    sget-object p3, Lw2/m;->a:Lkotlinx/coroutines/internal/b0;

    :cond_30
    return-object p3
.end method

.method private final M()Z
    .registers 4

    :cond_0
    iget v0, p0, Lw2/l;->_decision:I

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
    sget-object v0, Lw2/l;->j:Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;

    const/4 v2, 0x1

    invoke-virtual {v0, p0, v1, v2}, Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;->compareAndSet(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_0

    return v2
.end method

.method private final j(Ljava/lang/Object;)Ljava/lang/Void;
    .registers 5

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Already resumed, but proposed with update "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private final k(Lp2/l;Ljava/lang/Throwable;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    :try_start_0
    invoke-interface {p1, p2}, Lp2/l;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_3
    .catchall {:try_start_0 .. :try_end_3} :catchall_4

    goto :goto_22

    :catchall_4
    move-exception p1

    invoke-virtual {p0}, Lw2/l;->getContext()Li2/g;

    move-result-object p2

    new-instance v0, Lw2/y;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Exception in invokeOnCancellation handler for "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lw2/y;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-static {p2, v0}, Lw2/f0;->a(Li2/g;Ljava/lang/Throwable;)V

    :goto_22
    return-void
.end method

.method private final q(Ljava/lang/Throwable;)Z
    .registers 3

    invoke-direct {p0}, Lw2/l;->A()Z

    move-result v0

    if-nez v0, :cond_8

    const/4 p1, 0x0

    return p1

    :cond_8
    iget-object v0, p0, Lw2/l;->g:Li2/d;

    check-cast v0, Lkotlinx/coroutines/internal/f;

    invoke-virtual {v0, p1}, Lkotlinx/coroutines/internal/f;->p(Ljava/lang/Throwable;)Z

    move-result p1

    return p1
.end method

.method private final s()V
    .registers 2

    invoke-direct {p0}, Lw2/l;->A()Z

    move-result v0

    if-nez v0, :cond_9

    invoke-virtual {p0}, Lw2/l;->r()V

    :cond_9
    return-void
.end method

.method private final t(I)V
    .registers 3

    invoke-direct {p0}, Lw2/l;->K()Z

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    invoke-static {p0, p1}, Lw2/r0;->a(Lw2/q0;I)V

    return-void
.end method

.method private final y()Ljava/lang/String;
    .registers 3

    invoke-virtual {p0}, Lw2/l;->x()Ljava/lang/Object;

    move-result-object v0

    instance-of v1, v0, Lw2/y1;

    if-eqz v1, :cond_b

    const-string v0, "Active"

    goto :goto_14

    :cond_b
    instance-of v0, v0, Lw2/o;

    if-eqz v0, :cond_12

    const-string v0, "Cancelled"

    goto :goto_14

    :cond_12
    const-string v0, "Completed"

    :goto_14
    return-object v0
.end method

.method private final z()Lw2/u0;
    .registers 8

    invoke-virtual {p0}, Lw2/l;->getContext()Li2/g;

    move-result-object v0

    sget-object v1, Lw2/l1;->e:Lw2/l1$b;

    invoke-interface {v0, v1}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Lw2/l1;

    if-nez v1, :cond_11

    const/4 v0, 0x0

    return-object v0

    :cond_11
    const/4 v2, 0x1

    const/4 v3, 0x0

    new-instance v4, Lw2/p;

    invoke-direct {v4, p0}, Lw2/p;-><init>(Lw2/l;)V

    const/4 v5, 0x2

    const/4 v6, 0x0

    invoke-static/range {v1 .. v6}, Lw2/l1$a;->d(Lw2/l1;ZZLp2/l;ILjava/lang/Object;)Lw2/u0;

    move-result-object v0

    iput-object v0, p0, Lw2/l;->i:Lw2/u0;

    return-object v0
.end method


# virtual methods
.method protected D()Ljava/lang/String;
    .registers 2

    const-string v0, "CancellableContinuation"

    return-object v0
.end method

.method public final E(Ljava/lang/Throwable;)V
    .registers 3

    invoke-direct {p0, p1}, Lw2/l;->q(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    invoke-virtual {p0, p1}, Lw2/l;->p(Ljava/lang/Throwable;)Z

    invoke-direct {p0}, Lw2/l;->s()V

    return-void
.end method

.method public final G()Z
    .registers 4

    iget-object v0, p0, Lw2/l;->_state:Ljava/lang/Object;

    instance-of v1, v0, Lw2/u;

    const/4 v2, 0x0

    if-eqz v1, :cond_11

    check-cast v0, Lw2/u;

    iget-object v0, v0, Lw2/u;->d:Ljava/lang/Object;

    if-eqz v0, :cond_11

    invoke-virtual {p0}, Lw2/l;->r()V

    return v2

    :cond_11
    iput v2, p0, Lw2/l;->_decision:I

    sget-object v0, Lw2/d;->c:Lw2/d;

    iput-object v0, p0, Lw2/l;->_state:Ljava/lang/Object;

    const/4 v0, 0x1

    return v0
.end method

.method public a(Ljava/lang/Object;Ljava/lang/Throwable;)V
    .registers 13

    :cond_0
    iget-object p1, p0, Lw2/l;->_state:Ljava/lang/Object;

    instance-of v0, p1, Lw2/y1;

    if-nez v0, :cond_56

    instance-of v0, p1, Lw2/v;

    if-eqz v0, :cond_b

    return-void

    :cond_b
    instance-of v0, p1, Lw2/u;

    if-eqz v0, :cond_3f

    move-object v0, p1

    check-cast v0, Lw2/u;

    invoke-virtual {v0}, Lw2/u;->c()Z

    move-result v1

    xor-int/lit8 v1, v1, 0x1

    if-eqz v1, :cond_33

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/16 v7, 0xf

    const/4 v8, 0x0

    move-object v1, v0

    move-object v6, p2

    invoke-static/range {v1 .. v8}, Lw2/u;->b(Lw2/u;Ljava/lang/Object;Lw2/i;Lp2/l;Ljava/lang/Object;Ljava/lang/Throwable;ILjava/lang/Object;)Lw2/u;

    move-result-object v1

    sget-object v2, Lw2/l;->k:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {v2, p0, p1, v1}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_0

    invoke-virtual {v0, p0, p2}, Lw2/u;->d(Lw2/l;Ljava/lang/Throwable;)V

    return-void

    :cond_33
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "Must be called at most once"

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_3f
    sget-object v8, Lw2/l;->k:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    new-instance v9, Lw2/u;

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/16 v6, 0xe

    const/4 v7, 0x0

    move-object v0, v9

    move-object v1, p1

    move-object v5, p2

    invoke-direct/range {v0 .. v7}, Lw2/u;-><init>(Ljava/lang/Object;Lw2/i;Lp2/l;Ljava/lang/Object;Ljava/lang/Throwable;ILkotlin/jvm/internal/g;)V

    invoke-static {v8, p0, p1, v9}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_0

    return-void

    :cond_56
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "Not completed"

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public b(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Ljava/lang/Object;",
            ")",
            "Ljava/lang/Object;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lw2/l;->L(Ljava/lang/Object;Ljava/lang/Object;Lp2/l;)Lkotlinx/coroutines/internal/b0;

    move-result-object p1

    return-object p1
.end method

.method public final c()Li2/d;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Li2/d<",
            "TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lw2/l;->g:Li2/d;

    return-object v0
.end method

.method public d(Ljava/lang/Object;)Ljava/lang/Throwable;
    .registers 2

    invoke-super {p0, p1}, Lw2/q0;->d(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object p1

    if-eqz p1, :cond_7

    goto :goto_8

    :cond_7
    const/4 p1, 0x0

    :goto_8
    return-object p1
.end method

.method public e(Ljava/lang/Object;Ljava/lang/Object;Lp2/l;)Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Ljava/lang/Object;",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    invoke-direct {p0, p1, p2, p3}, Lw2/l;->L(Ljava/lang/Object;Ljava/lang/Object;Lp2/l;)Lkotlinx/coroutines/internal/b0;

    move-result-object p1

    return-object p1
.end method

.method public f(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            ")TT;"
        }
    .end annotation

    instance-of v0, p1, Lw2/u;

    if-eqz v0, :cond_8

    check-cast p1, Lw2/u;

    iget-object p1, p1, Lw2/u;->a:Ljava/lang/Object;

    :cond_8
    return-object p1
.end method

.method public g(Ljava/lang/Object;Lp2/l;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;)V"
        }
    .end annotation

    iget v0, p0, Lw2/q0;->f:I

    invoke-direct {p0, p1, v0, p2}, Lw2/l;->H(Ljava/lang/Object;ILp2/l;)V

    return-void
.end method

.method public getCallerFrame()Lkotlin/coroutines/jvm/internal/e;
    .registers 3

    iget-object v0, p0, Lw2/l;->g:Li2/d;

    instance-of v1, v0, Lkotlin/coroutines/jvm/internal/e;

    if-eqz v1, :cond_9

    check-cast v0, Lkotlin/coroutines/jvm/internal/e;

    goto :goto_a

    :cond_9
    const/4 v0, 0x0

    :goto_a
    return-object v0
.end method

.method public getContext()Li2/g;
    .registers 2

    iget-object v0, p0, Lw2/l;->h:Li2/g;

    return-object v0
.end method

.method public i()Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0}, Lw2/l;->x()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final l(Lw2/i;Ljava/lang/Throwable;)V
    .registers 6

    :try_start_0
    invoke-virtual {p1, p2}, Lw2/j;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_0 .. :try_end_3} :catchall_4

    goto :goto_22

    :catchall_4
    move-exception p1

    invoke-virtual {p0}, Lw2/l;->getContext()Li2/g;

    move-result-object p2

    new-instance v0, Lw2/y;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Exception in invokeOnCancellation handler for "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lw2/y;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-static {p2, v0}, Lw2/f0;->a(Li2/g;Ljava/lang/Throwable;)V

    :goto_22
    return-void
.end method

.method public m(Ljava/lang/Throwable;)Ljava/lang/Object;
    .registers 6

    new-instance v0, Lw2/v;

    const/4 v1, 0x0

    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-direct {v0, p1, v1, v2, v3}, Lw2/v;-><init>(Ljava/lang/Throwable;ZILkotlin/jvm/internal/g;)V

    invoke-direct {p0, v0, v3, v3}, Lw2/l;->L(Ljava/lang/Object;Ljava/lang/Object;Lp2/l;)Lkotlinx/coroutines/internal/b0;

    move-result-object p1

    return-object p1
.end method

.method public n(Lp2/l;)V
    .registers 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p1}, Lw2/l;->B(Lp2/l;)Lw2/i;

    move-result-object v8

    :cond_4
    :goto_4
    iget-object v9, p0, Lw2/l;->_state:Ljava/lang/Object;

    instance-of v0, v9, Lw2/d;

    if-eqz v0, :cond_13

    sget-object v0, Lw2/l;->k:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {v0, p0, v9, v8}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    return-void

    :cond_13
    instance-of v0, v9, Lw2/i;

    if-eqz v0, :cond_1b

    invoke-direct {p0, p1, v9}, Lw2/l;->C(Lp2/l;Ljava/lang/Object;)V

    goto :goto_4

    :cond_1b
    instance-of v0, v9, Lw2/v;

    if-eqz v0, :cond_3c

    move-object v1, v9

    check-cast v1, Lw2/v;

    invoke-virtual {v1}, Lw2/v;->b()Z

    move-result v2

    if-nez v2, :cond_2b

    invoke-direct {p0, p1, v9}, Lw2/l;->C(Lp2/l;Ljava/lang/Object;)V

    :cond_2b
    instance-of v2, v9, Lw2/o;

    if-eqz v2, :cond_3b

    const/4 v2, 0x0

    if-eqz v0, :cond_33

    goto :goto_34

    :cond_33
    move-object v1, v2

    :goto_34
    if-eqz v1, :cond_38

    iget-object v2, v1, Lw2/v;->a:Ljava/lang/Throwable;

    :cond_38
    invoke-direct {p0, p1, v2}, Lw2/l;->k(Lp2/l;Ljava/lang/Throwable;)V

    :cond_3b
    return-void

    :cond_3c
    instance-of v0, v9, Lw2/u;

    if-eqz v0, :cond_70

    move-object v0, v9

    check-cast v0, Lw2/u;

    iget-object v1, v0, Lw2/u;->b:Lw2/i;

    if-eqz v1, :cond_4a

    invoke-direct {p0, p1, v9}, Lw2/l;->C(Lp2/l;Ljava/lang/Object;)V

    :cond_4a
    instance-of v1, v8, Lw2/e;

    if-eqz v1, :cond_4f

    return-void

    :cond_4f
    invoke-virtual {v0}, Lw2/u;->c()Z

    move-result v1

    if-eqz v1, :cond_5b

    iget-object v0, v0, Lw2/u;->e:Ljava/lang/Throwable;

    invoke-direct {p0, p1, v0}, Lw2/l;->k(Lp2/l;Ljava/lang/Throwable;)V

    return-void

    :cond_5b
    const/4 v1, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/16 v6, 0x1d

    const/4 v7, 0x0

    move-object v2, v8

    invoke-static/range {v0 .. v7}, Lw2/u;->b(Lw2/u;Ljava/lang/Object;Lw2/i;Lp2/l;Ljava/lang/Object;Ljava/lang/Throwable;ILjava/lang/Object;)Lw2/u;

    move-result-object v0

    sget-object v1, Lw2/l;->k:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {v1, p0, v9, v0}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    return-void

    :cond_70
    instance-of v0, v8, Lw2/e;

    if-eqz v0, :cond_75

    return-void

    :cond_75
    new-instance v10, Lw2/u;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/16 v6, 0x1c

    const/4 v7, 0x0

    move-object v0, v10

    move-object v1, v9

    move-object v2, v8

    invoke-direct/range {v0 .. v7}, Lw2/u;-><init>(Ljava/lang/Object;Lw2/i;Lp2/l;Ljava/lang/Object;Ljava/lang/Throwable;ILkotlin/jvm/internal/g;)V

    sget-object v0, Lw2/l;->k:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {v0, p0, v9, v10}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    return-void
.end method

.method public final o(Lp2/l;Ljava/lang/Throwable;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    :try_start_0
    invoke-interface {p1, p2}, Lp2/l;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_3
    .catchall {:try_start_0 .. :try_end_3} :catchall_4

    goto :goto_22

    :catchall_4
    move-exception p1

    invoke-virtual {p0}, Lw2/l;->getContext()Li2/g;

    move-result-object p2

    new-instance v0, Lw2/y;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Exception in resume onCancellation handler for "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lw2/y;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-static {p2, v0}, Lw2/f0;->a(Li2/g;Ljava/lang/Throwable;)V

    :goto_22
    return-void
.end method

.method public p(Ljava/lang/Throwable;)Z
    .registers 6

    :cond_0
    iget-object v0, p0, Lw2/l;->_state:Ljava/lang/Object;

    instance-of v1, v0, Lw2/y1;

    if-nez v1, :cond_8

    const/4 p1, 0x0

    return p1

    :cond_8
    new-instance v1, Lw2/o;

    instance-of v2, v0, Lw2/i;

    invoke-direct {v1, p0, p1, v2}, Lw2/o;-><init>(Li2/d;Ljava/lang/Throwable;Z)V

    sget-object v3, Lw2/l;->k:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {v3, p0, v0, v1}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    if-eqz v2, :cond_1c

    check-cast v0, Lw2/i;

    goto :goto_1d

    :cond_1c
    const/4 v0, 0x0

    :goto_1d
    if-eqz v0, :cond_22

    invoke-virtual {p0, v0, p1}, Lw2/l;->l(Lw2/i;Ljava/lang/Throwable;)V

    :cond_22
    invoke-direct {p0}, Lw2/l;->s()V

    iget p1, p0, Lw2/q0;->f:I

    invoke-direct {p0, p1}, Lw2/l;->t(I)V

    const/4 p1, 0x1

    return p1
.end method

.method public final r()V
    .registers 2

    iget-object v0, p0, Lw2/l;->i:Lw2/u0;

    if-nez v0, :cond_5

    return-void

    :cond_5
    invoke-interface {v0}, Lw2/u0;->a()V

    sget-object v0, Lw2/x1;->c:Lw2/x1;

    iput-object v0, p0, Lw2/l;->i:Lw2/u0;

    return-void
.end method

.method public resumeWith(Ljava/lang/Object;)V
    .registers 8

    invoke-static {p1, p0}, Lw2/z;->c(Ljava/lang/Object;Lw2/k;)Ljava/lang/Object;

    move-result-object v1

    iget v2, p0, Lw2/q0;->f:I

    const/4 v3, 0x0

    const/4 v4, 0x4

    const/4 v5, 0x0

    move-object v0, p0

    invoke-static/range {v0 .. v5}, Lw2/l;->I(Lw2/l;Ljava/lang/Object;ILp2/l;ILjava/lang/Object;)V

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lw2/l;->D()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x28

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lw2/l;->g:Li2/d;

    invoke-static {v1}, Lw2/k0;->c(Li2/d;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "){"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-direct {p0}, Lw2/l;->y()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "}@"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p0}, Lw2/k0;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public u(Lw2/l1;)Ljava/lang/Throwable;
    .registers 2

    invoke-interface {p1}, Lw2/l1;->h()Ljava/util/concurrent/CancellationException;

    move-result-object p1

    return-object p1
.end method

.method public final v()Ljava/lang/Object;
    .registers 4

    invoke-direct {p0}, Lw2/l;->A()Z

    move-result v0

    invoke-direct {p0}, Lw2/l;->M()Z

    move-result v1

    if-eqz v1, :cond_1b

    iget-object v1, p0, Lw2/l;->i:Lw2/u0;

    if-nez v1, :cond_11

    invoke-direct {p0}, Lw2/l;->z()Lw2/u0;

    :cond_11
    if-eqz v0, :cond_16

    invoke-direct {p0}, Lw2/l;->F()V

    :cond_16
    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_1b
    if-eqz v0, :cond_20

    invoke-direct {p0}, Lw2/l;->F()V

    :cond_20
    invoke-virtual {p0}, Lw2/l;->x()Ljava/lang/Object;

    move-result-object v0

    instance-of v1, v0, Lw2/v;

    if-nez v1, :cond_52

    iget v1, p0, Lw2/q0;->f:I

    invoke-static {v1}, Lw2/r0;->b(I)Z

    move-result v1

    if-eqz v1, :cond_4d

    invoke-virtual {p0}, Lw2/l;->getContext()Li2/g;

    move-result-object v1

    sget-object v2, Lw2/l1;->e:Lw2/l1$b;

    invoke-interface {v1, v2}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object v1

    check-cast v1, Lw2/l1;

    if-eqz v1, :cond_4d

    invoke-interface {v1}, Lw2/l1;->isActive()Z

    move-result v2

    if-eqz v2, :cond_45

    goto :goto_4d

    :cond_45
    invoke-interface {v1}, Lw2/l1;->h()Ljava/util/concurrent/CancellationException;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lw2/l;->a(Ljava/lang/Object;Ljava/lang/Throwable;)V

    throw v1

    :cond_4d
    :goto_4d
    invoke-virtual {p0, v0}, Lw2/l;->f(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_52
    check-cast v0, Lw2/v;

    iget-object v0, v0, Lw2/v;->a:Ljava/lang/Throwable;

    throw v0
.end method

.method public w(Ljava/lang/Object;)V
    .registers 2

    iget p1, p0, Lw2/q0;->f:I

    invoke-direct {p0, p1}, Lw2/l;->t(I)V

    return-void
.end method

.method public final x()Ljava/lang/Object;
    .registers 2

    iget-object v0, p0, Lw2/l;->_state:Ljava/lang/Object;

    return-object v0
.end method
