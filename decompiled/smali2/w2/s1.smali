.class public Lw2/s1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lw2/l1;
.implements Lw2/s;
.implements Lw2/z1;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lw2/s1$b;,
        Lw2/s1$a;
    }
.end annotation


# static fields
.field private static final synthetic c:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;


# instance fields
.field private volatile synthetic _parentHandle:Ljava/lang/Object;

.field private volatile synthetic _state:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    const-class v0, Lw2/s1;

    const-class v1, Ljava/lang/Object;

    const-string v2, "_state"

    invoke-static {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;->newUpdater(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    move-result-object v0

    sput-object v0, Lw2/s1;->c:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    return-void
.end method

.method public constructor <init>(Z)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-eqz p1, :cond_a

    invoke-static {}, Lw2/t1;->c()Lw2/v0;

    move-result-object p1

    goto :goto_e

    :cond_a
    invoke-static {}, Lw2/t1;->d()Lw2/v0;

    move-result-object p1

    :goto_e
    iput-object p1, p0, Lw2/s1;->_state:Ljava/lang/Object;

    const/4 p1, 0x0

    iput-object p1, p0, Lw2/s1;->_parentHandle:Ljava/lang/Object;

    return-void
.end method

.method private final A(Ljava/lang/Object;Lw2/w1;Lw2/r1;)Z
    .registers 6

    new-instance v0, Lw2/s1$c;

    invoke-direct {v0, p3, p0, p1}, Lw2/s1$c;-><init>(Lkotlinx/coroutines/internal/o;Lw2/s1;Ljava/lang/Object;)V

    :goto_5
    invoke-virtual {p2}, Lkotlinx/coroutines/internal/o;->p()Lkotlinx/coroutines/internal/o;

    move-result-object p1

    invoke-virtual {p1, p3, p2, v0}, Lkotlinx/coroutines/internal/o;->w(Lkotlinx/coroutines/internal/o;Lkotlinx/coroutines/internal/o;Lkotlinx/coroutines/internal/o$a;)I

    move-result p1

    const/4 v1, 0x1

    if-eq p1, v1, :cond_15

    const/4 v1, 0x2

    if-eq p1, v1, :cond_14

    goto :goto_5

    :cond_14
    const/4 v1, 0x0

    :cond_15
    return v1
.end method

.method private final B(Ljava/lang/Throwable;Ljava/util/List;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            "Ljava/util/List<",
            "+",
            "Ljava/lang/Throwable;",
            ">;)V"
        }
    .end annotation

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-gt v0, v1, :cond_8

    return-void

    :cond_8
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    new-instance v1, Ljava/util/IdentityHashMap;

    invoke-direct {v1, v0}, Ljava/util/IdentityHashMap;-><init>(I)V

    invoke-static {v1}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p2

    :cond_19
    :goto_19
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_37

    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Throwable;

    if-eq v1, p1, :cond_19

    if-eq v1, p1, :cond_19

    instance-of v2, v1, Ljava/util/concurrent/CancellationException;

    if-nez v2, :cond_19

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_19

    invoke-static {p1, v1}, Lg2/a;->a(Ljava/lang/Throwable;Ljava/lang/Throwable;)V

    goto :goto_19

    :cond_37
    return-void
.end method

.method private final F(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 8

    :cond_0
    invoke-virtual {p0}, Lw2/s1;->U()Ljava/lang/Object;

    move-result-object v0

    instance-of v1, v0, Lw2/g1;

    if-eqz v1, :cond_2d

    instance-of v1, v0, Lw2/s1$b;

    if-eqz v1, :cond_16

    move-object v1, v0

    check-cast v1, Lw2/s1$b;

    invoke-virtual {v1}, Lw2/s1$b;->g()Z

    move-result v1

    if-eqz v1, :cond_16

    goto :goto_2d

    :cond_16
    new-instance v1, Lw2/v;

    invoke-direct {p0, p1}, Lw2/s1;->L(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x2

    const/4 v5, 0x0

    invoke-direct {v1, v2, v3, v4, v5}, Lw2/v;-><init>(Ljava/lang/Throwable;ZILkotlin/jvm/internal/g;)V

    invoke-direct {p0, v0, v1}, Lw2/s1;->v0(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {}, Lw2/t1;->b()Lkotlinx/coroutines/internal/b0;

    move-result-object v1

    if-eq v0, v1, :cond_0

    return-object v0

    :cond_2d
    :goto_2d
    invoke-static {}, Lw2/t1;->a()Lkotlinx/coroutines/internal/b0;

    move-result-object p1

    return-object p1
.end method

.method private final G(Ljava/lang/Throwable;)Z
    .registers 6

    invoke-virtual {p0}, Lw2/s1;->Z()Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    instance-of v0, p1, Ljava/util/concurrent/CancellationException;

    invoke-virtual {p0}, Lw2/s1;->T()Lw2/q;

    move-result-object v2

    if-eqz v2, :cond_20

    sget-object v3, Lw2/x1;->c:Lw2/x1;

    if-ne v2, v3, :cond_15

    goto :goto_20

    :cond_15
    invoke-interface {v2, p1}, Lw2/q;->d(Ljava/lang/Throwable;)Z

    move-result p1

    if-nez p1, :cond_1f

    if-eqz v0, :cond_1e

    goto :goto_1f

    :cond_1e
    const/4 v1, 0x0

    :cond_1f
    :goto_1f
    return v1

    :cond_20
    :goto_20
    return v0
.end method

.method private final J(Lw2/g1;Ljava/lang/Object;)V
    .registers 6

    invoke-virtual {p0}, Lw2/s1;->T()Lw2/q;

    move-result-object v0

    if-eqz v0, :cond_e

    invoke-interface {v0}, Lw2/u0;->a()V

    sget-object v0, Lw2/x1;->c:Lw2/x1;

    invoke-virtual {p0, v0}, Lw2/s1;->n0(Lw2/q;)V

    :cond_e
    instance-of v0, p2, Lw2/v;

    const/4 v1, 0x0

    if-eqz v0, :cond_16

    check-cast p2, Lw2/v;

    goto :goto_17

    :cond_16
    move-object p2, v1

    :goto_17
    if-eqz p2, :cond_1b

    iget-object v1, p2, Lw2/v;->a:Ljava/lang/Throwable;

    :cond_1b
    instance-of p2, p1, Lw2/r1;

    if-eqz p2, :cond_49

    :try_start_1f
    move-object p2, p1

    check-cast p2, Lw2/r1;

    invoke-virtual {p2, v1}, Lw2/x;->x(Ljava/lang/Throwable;)V
    :try_end_25
    .catchall {:try_start_1f .. :try_end_25} :catchall_26

    goto :goto_52

    :catchall_26
    move-exception p2

    new-instance v0, Lw2/y;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Exception in completion handler "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p1, " for "

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1, p2}, Lw2/y;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-virtual {p0, v0}, Lw2/s1;->W(Ljava/lang/Throwable;)V

    goto :goto_52

    :cond_49
    invoke-interface {p1}, Lw2/g1;->e()Lw2/w1;

    move-result-object p1

    if-eqz p1, :cond_52

    invoke-direct {p0, p1, v1}, Lw2/s1;->g0(Lw2/w1;Ljava/lang/Throwable;)V

    :cond_52
    :goto_52
    return-void
.end method

.method private final K(Lw2/s1$b;Lw2/r;Ljava/lang/Object;)V
    .registers 4

    invoke-direct {p0, p2}, Lw2/s1;->e0(Lkotlinx/coroutines/internal/o;)Lw2/r;

    move-result-object p2

    if-eqz p2, :cond_d

    invoke-direct {p0, p1, p2, p3}, Lw2/s1;->x0(Lw2/s1$b;Lw2/r;Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_d

    return-void

    :cond_d
    invoke-direct {p0, p1, p3}, Lw2/s1;->M(Lw2/s1$b;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {p0, p1}, Lw2/s1;->C(Ljava/lang/Object;)V

    return-void
.end method

.method private final L(Ljava/lang/Object;)Ljava/lang/Throwable;
    .registers 4

    if-nez p1, :cond_4

    const/4 v0, 0x1

    goto :goto_6

    :cond_4
    instance-of v0, p1, Ljava/lang/Throwable;

    :goto_6
    if-eqz v0, :cond_18

    check-cast p1, Ljava/lang/Throwable;

    if-nez p1, :cond_20

    const/4 p1, 0x0

    new-instance v0, Lw2/m1;

    invoke-static {p0}, Lw2/s1;->y(Lw2/s1;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p1, p0}, Lw2/m1;-><init>(Ljava/lang/String;Ljava/lang/Throwable;Lw2/l1;)V

    move-object p1, v0

    goto :goto_20

    :cond_18
    if-eqz p1, :cond_21

    check-cast p1, Lw2/z1;

    invoke-interface {p1}, Lw2/z1;->s()Ljava/util/concurrent/CancellationException;

    move-result-object p1

    :cond_20
    :goto_20
    return-object p1

    :cond_21
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob"

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private final M(Lw2/s1$b;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 8

    instance-of v0, p2, Lw2/v;

    const/4 v1, 0x0

    if-eqz v0, :cond_9

    move-object v0, p2

    check-cast v0, Lw2/v;

    goto :goto_a

    :cond_9
    move-object v0, v1

    :goto_a
    if-eqz v0, :cond_f

    iget-object v0, v0, Lw2/v;->a:Ljava/lang/Throwable;

    goto :goto_10

    :cond_f
    move-object v0, v1

    :goto_10
    monitor-enter p1

    :try_start_11
    invoke-virtual {p1}, Lw2/s1$b;->f()Z

    move-result v2

    invoke-virtual {p1, v0}, Lw2/s1$b;->i(Ljava/lang/Throwable;)Ljava/util/List;

    move-result-object v3

    invoke-direct {p0, p1, v3}, Lw2/s1;->P(Lw2/s1$b;Ljava/util/List;)Ljava/lang/Throwable;

    move-result-object v4

    if-eqz v4, :cond_22

    invoke-direct {p0, v4, v3}, Lw2/s1;->B(Ljava/lang/Throwable;Ljava/util/List;)V
    :try_end_22
    .catchall {:try_start_11 .. :try_end_22} :catchall_67

    :cond_22
    monitor-exit p1

    const/4 v3, 0x0

    if-nez v4, :cond_27

    goto :goto_30

    :cond_27
    if-ne v4, v0, :cond_2a

    goto :goto_30

    :cond_2a
    new-instance p2, Lw2/v;

    const/4 v0, 0x2

    invoke-direct {p2, v4, v3, v0, v1}, Lw2/v;-><init>(Ljava/lang/Throwable;ZILkotlin/jvm/internal/g;)V

    :goto_30
    if-eqz v4, :cond_52

    invoke-direct {p0, v4}, Lw2/s1;->G(Ljava/lang/Throwable;)Z

    move-result v0

    if-nez v0, :cond_3e

    invoke-virtual {p0, v4}, Lw2/s1;->V(Ljava/lang/Throwable;)Z

    move-result v0

    if-eqz v0, :cond_3f

    :cond_3e
    const/4 v3, 0x1

    :cond_3f
    if-eqz v3, :cond_52

    if-eqz p2, :cond_4a

    move-object v0, p2

    check-cast v0, Lw2/v;

    invoke-virtual {v0}, Lw2/v;->b()Z

    goto :goto_52

    :cond_4a
    new-instance p1, Ljava/lang/NullPointerException;

    const-string p2, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally"

    invoke-direct {p1, p2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_52
    :goto_52
    if-nez v2, :cond_57

    invoke-virtual {p0, v4}, Lw2/s1;->h0(Ljava/lang/Throwable;)V

    :cond_57
    invoke-virtual {p0, p2}, Lw2/s1;->i0(Ljava/lang/Object;)V

    sget-object v0, Lw2/s1;->c:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {p2}, Lw2/t1;->g(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v0, p0, p1, v1}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    invoke-direct {p0, p1, p2}, Lw2/s1;->J(Lw2/g1;Ljava/lang/Object;)V

    return-object p2

    :catchall_67
    move-exception p2

    monitor-exit p1

    throw p2
.end method

.method private final N(Lw2/g1;)Lw2/r;
    .registers 4

    instance-of v0, p1, Lw2/r;

    const/4 v1, 0x0

    if-eqz v0, :cond_9

    move-object v0, p1

    check-cast v0, Lw2/r;

    goto :goto_a

    :cond_9
    move-object v0, v1

    :goto_a
    if-nez v0, :cond_17

    invoke-interface {p1}, Lw2/g1;->e()Lw2/w1;

    move-result-object p1

    if-eqz p1, :cond_18

    invoke-direct {p0, p1}, Lw2/s1;->e0(Lkotlinx/coroutines/internal/o;)Lw2/r;

    move-result-object v1

    goto :goto_18

    :cond_17
    move-object v1, v0

    :cond_18
    :goto_18
    return-object v1
.end method

.method private final O(Ljava/lang/Object;)Ljava/lang/Throwable;
    .registers 4

    instance-of v0, p1, Lw2/v;

    const/4 v1, 0x0

    if-eqz v0, :cond_8

    check-cast p1, Lw2/v;

    goto :goto_9

    :cond_8
    move-object p1, v1

    :goto_9
    if-eqz p1, :cond_d

    iget-object v1, p1, Lw2/v;->a:Ljava/lang/Throwable;

    :cond_d
    return-object v1
.end method

.method private final P(Lw2/s1$b;Ljava/util/List;)Ljava/lang/Throwable;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lw2/s1$b;",
            "Ljava/util/List<",
            "+",
            "Ljava/lang/Throwable;",
            ">;)",
            "Ljava/lang/Throwable;"
        }
    .end annotation

    invoke-interface {p2}, Ljava/util/List;->isEmpty()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_18

    invoke-virtual {p1}, Lw2/s1$b;->f()Z

    move-result p1

    if-eqz p1, :cond_17

    new-instance p1, Lw2/m1;

    invoke-static {p0}, Lw2/s1;->y(Lw2/s1;)Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2, v1, p0}, Lw2/m1;-><init>(Ljava/lang/String;Ljava/lang/Throwable;Lw2/l1;)V

    return-object p1

    :cond_17
    return-object v1

    :cond_18
    invoke-interface {p2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_1c
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_30

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v2, v0

    check-cast v2, Ljava/lang/Throwable;

    instance-of v2, v2, Ljava/util/concurrent/CancellationException;

    xor-int/lit8 v2, v2, 0x1

    if-eqz v2, :cond_1c

    move-object v1, v0

    :cond_30
    check-cast v1, Ljava/lang/Throwable;

    if-eqz v1, :cond_35

    return-object v1

    :cond_35
    const/4 p1, 0x0

    invoke-interface {p2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Throwable;

    return-object p1
.end method

.method private final S(Lw2/g1;)Lw2/w1;
    .registers 5

    invoke-interface {p1}, Lw2/g1;->e()Lw2/w1;

    move-result-object v0

    if-nez v0, :cond_36

    instance-of v0, p1, Lw2/v0;

    if-eqz v0, :cond_10

    new-instance v0, Lw2/w1;

    invoke-direct {v0}, Lw2/w1;-><init>()V

    goto :goto_36

    :cond_10
    instance-of v0, p1, Lw2/r1;

    if-eqz v0, :cond_1b

    check-cast p1, Lw2/r1;

    invoke-direct {p0, p1}, Lw2/s1;->l0(Lw2/r1;)V

    const/4 v0, 0x0

    goto :goto_36

    :cond_1b
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "State should have list: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_36
    :goto_36
    return-object v0
.end method

.method private final a0(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 8

    const/4 v0, 0x0

    move-object v1, v0

    :cond_2
    invoke-virtual {p0}, Lw2/s1;->U()Ljava/lang/Object;

    move-result-object v2

    instance-of v3, v2, Lw2/s1$b;

    if-eqz v3, :cond_51

    monitor-enter v2

    :try_start_b
    move-object v3, v2

    check-cast v3, Lw2/s1$b;

    invoke-virtual {v3}, Lw2/s1$b;->h()Z

    move-result v3

    if-eqz v3, :cond_1a

    invoke-static {}, Lw2/t1;->f()Lkotlinx/coroutines/internal/b0;

    move-result-object p1
    :try_end_18
    .catchall {:try_start_b .. :try_end_18} :catchall_4e

    monitor-exit v2

    return-object p1

    :cond_1a
    :try_start_1a
    move-object v3, v2

    check-cast v3, Lw2/s1$b;

    invoke-virtual {v3}, Lw2/s1$b;->f()Z

    move-result v3

    if-nez p1, :cond_25

    if-nez v3, :cond_31

    :cond_25
    if-nez v1, :cond_2b

    invoke-direct {p0, p1}, Lw2/s1;->L(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v1

    :cond_2b
    move-object p1, v2

    check-cast p1, Lw2/s1$b;

    invoke-virtual {p1, v1}, Lw2/s1$b;->a(Ljava/lang/Throwable;)V

    :cond_31
    move-object p1, v2

    check-cast p1, Lw2/s1$b;

    invoke-virtual {p1}, Lw2/s1$b;->d()Ljava/lang/Throwable;

    move-result-object p1
    :try_end_38
    .catchall {:try_start_1a .. :try_end_38} :catchall_4e

    xor-int/lit8 v1, v3, 0x1

    if-eqz v1, :cond_3d

    move-object v0, p1

    :cond_3d
    monitor-exit v2

    if-eqz v0, :cond_49

    check-cast v2, Lw2/s1$b;

    invoke-virtual {v2}, Lw2/s1$b;->e()Lw2/w1;

    move-result-object p1

    invoke-direct {p0, p1, v0}, Lw2/s1;->f0(Lw2/w1;Ljava/lang/Throwable;)V

    :cond_49
    invoke-static {}, Lw2/t1;->a()Lkotlinx/coroutines/internal/b0;

    move-result-object p1

    return-object p1

    :catchall_4e
    move-exception p1

    monitor-exit v2

    throw p1

    :cond_51
    instance-of v3, v2, Lw2/g1;

    if-eqz v3, :cond_a2

    if-nez v1, :cond_5b

    invoke-direct {p0, p1}, Lw2/s1;->L(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v1

    :cond_5b
    move-object v3, v2

    check-cast v3, Lw2/g1;

    invoke-interface {v3}, Lw2/g1;->isActive()Z

    move-result v4

    if-eqz v4, :cond_6f

    invoke-direct {p0, v3, v1}, Lw2/s1;->u0(Lw2/g1;Ljava/lang/Throwable;)Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-static {}, Lw2/t1;->a()Lkotlinx/coroutines/internal/b0;

    move-result-object p1

    return-object p1

    :cond_6f
    new-instance v3, Lw2/v;

    const/4 v4, 0x0

    const/4 v5, 0x2

    invoke-direct {v3, v1, v4, v5, v0}, Lw2/v;-><init>(Ljava/lang/Throwable;ZILkotlin/jvm/internal/g;)V

    invoke-direct {p0, v2, v3}, Lw2/s1;->v0(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-static {}, Lw2/t1;->a()Lkotlinx/coroutines/internal/b0;

    move-result-object v4

    if-eq v3, v4, :cond_87

    invoke-static {}, Lw2/t1;->b()Lkotlinx/coroutines/internal/b0;

    move-result-object v2

    if-eq v3, v2, :cond_2

    return-object v3

    :cond_87
    new-instance p1, Ljava/lang/IllegalStateException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Cannot happen in "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_a2
    invoke-static {}, Lw2/t1;->f()Lkotlinx/coroutines/internal/b0;

    move-result-object p1

    return-object p1
.end method

.method private final c0(Lp2/l;Z)Lw2/r1;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;Z)",
            "Lw2/r1;"
        }
    .end annotation

    const/4 v0, 0x0

    if-eqz p2, :cond_12

    instance-of p2, p1, Lw2/n1;

    if-eqz p2, :cond_a

    move-object v0, p1

    check-cast v0, Lw2/n1;

    :cond_a
    if-nez v0, :cond_21

    new-instance v0, Lw2/j1;

    invoke-direct {v0, p1}, Lw2/j1;-><init>(Lp2/l;)V

    goto :goto_21

    :cond_12
    instance-of p2, p1, Lw2/r1;

    if-eqz p2, :cond_19

    move-object v0, p1

    check-cast v0, Lw2/r1;

    :cond_19
    if-eqz v0, :cond_1c

    goto :goto_21

    :cond_1c
    new-instance v0, Lw2/k1;

    invoke-direct {v0, p1}, Lw2/k1;-><init>(Lp2/l;)V

    :cond_21
    :goto_21
    invoke-virtual {v0, p0}, Lw2/r1;->z(Lw2/s1;)V

    return-object v0
.end method

.method private final e0(Lkotlinx/coroutines/internal/o;)Lw2/r;
    .registers 3

    :goto_0
    invoke-virtual {p1}, Lkotlinx/coroutines/internal/o;->s()Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-virtual {p1}, Lkotlinx/coroutines/internal/o;->p()Lkotlinx/coroutines/internal/o;

    move-result-object p1

    goto :goto_0

    :cond_b
    invoke-virtual {p1}, Lkotlinx/coroutines/internal/o;->o()Lkotlinx/coroutines/internal/o;

    move-result-object p1

    invoke-virtual {p1}, Lkotlinx/coroutines/internal/o;->s()Z

    move-result v0

    if-nez v0, :cond_b

    instance-of v0, p1, Lw2/r;

    if-eqz v0, :cond_1c

    check-cast p1, Lw2/r;

    return-object p1

    :cond_1c
    instance-of v0, p1, Lw2/w1;

    if-eqz v0, :cond_b

    const/4 p1, 0x0

    return-object p1
.end method

.method private final f0(Lw2/w1;Ljava/lang/Throwable;)V
    .registers 9

    invoke-virtual {p0, p2}, Lw2/s1;->h0(Ljava/lang/Throwable;)V

    invoke-virtual {p1}, Lkotlinx/coroutines/internal/o;->n()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lkotlinx/coroutines/internal/o;

    const/4 v1, 0x0

    :goto_a
    invoke-static {v0, p1}, Lkotlin/jvm/internal/k;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_47

    instance-of v2, v0, Lw2/n1;

    if-eqz v2, :cond_42

    move-object v2, v0

    check-cast v2, Lw2/r1;

    :try_start_17
    invoke-virtual {v2, p2}, Lw2/x;->x(Ljava/lang/Throwable;)V
    :try_end_1a
    .catchall {:try_start_17 .. :try_end_1a} :catchall_1b

    goto :goto_42

    :catchall_1b
    move-exception v3

    if-eqz v1, :cond_22

    invoke-static {v1, v3}, Lg2/a;->a(Ljava/lang/Throwable;Ljava/lang/Throwable;)V

    goto :goto_42

    :cond_22
    new-instance v1, Lw2/y;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Exception in completion handler "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " for "

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v3}, Lw2/y;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    sget-object v2, Lg2/q;->a:Lg2/q;

    :cond_42
    :goto_42
    invoke-virtual {v0}, Lkotlinx/coroutines/internal/o;->o()Lkotlinx/coroutines/internal/o;

    move-result-object v0

    goto :goto_a

    :cond_47
    if-eqz v1, :cond_4c

    invoke-virtual {p0, v1}, Lw2/s1;->W(Ljava/lang/Throwable;)V

    :cond_4c
    invoke-direct {p0, p2}, Lw2/s1;->G(Ljava/lang/Throwable;)Z

    return-void
.end method

.method private final g0(Lw2/w1;Ljava/lang/Throwable;)V
    .registers 9

    invoke-virtual {p1}, Lkotlinx/coroutines/internal/o;->n()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lkotlinx/coroutines/internal/o;

    const/4 v1, 0x0

    :goto_7
    invoke-static {v0, p1}, Lkotlin/jvm/internal/k;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_44

    instance-of v2, v0, Lw2/r1;

    if-eqz v2, :cond_3f

    move-object v2, v0

    check-cast v2, Lw2/r1;

    :try_start_14
    invoke-virtual {v2, p2}, Lw2/x;->x(Ljava/lang/Throwable;)V
    :try_end_17
    .catchall {:try_start_14 .. :try_end_17} :catchall_18

    goto :goto_3f

    :catchall_18
    move-exception v3

    if-eqz v1, :cond_1f

    invoke-static {v1, v3}, Lg2/a;->a(Ljava/lang/Throwable;Ljava/lang/Throwable;)V

    goto :goto_3f

    :cond_1f
    new-instance v1, Lw2/y;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Exception in completion handler "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " for "

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v3}, Lw2/y;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    sget-object v2, Lg2/q;->a:Lg2/q;

    :cond_3f
    :goto_3f
    invoke-virtual {v0}, Lkotlinx/coroutines/internal/o;->o()Lkotlinx/coroutines/internal/o;

    move-result-object v0

    goto :goto_7

    :cond_44
    if-eqz v1, :cond_49

    invoke-virtual {p0, v1}, Lw2/s1;->W(Ljava/lang/Throwable;)V

    :cond_49
    return-void
.end method

.method private final k0(Lw2/v0;)V
    .registers 4

    new-instance v0, Lw2/w1;

    invoke-direct {v0}, Lw2/w1;-><init>()V

    invoke-virtual {p1}, Lw2/v0;->isActive()Z

    move-result v1

    if-eqz v1, :cond_c

    goto :goto_12

    :cond_c
    new-instance v1, Lw2/f1;

    invoke-direct {v1, v0}, Lw2/f1;-><init>(Lw2/w1;)V

    move-object v0, v1

    :goto_12
    sget-object v1, Lw2/s1;->c:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {v1, p0, p1, v0}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    return-void
.end method

.method private final l0(Lw2/r1;)V
    .registers 4

    new-instance v0, Lw2/w1;

    invoke-direct {v0}, Lw2/w1;-><init>()V

    invoke-virtual {p1, v0}, Lkotlinx/coroutines/internal/o;->j(Lkotlinx/coroutines/internal/o;)Z

    invoke-virtual {p1}, Lkotlinx/coroutines/internal/o;->o()Lkotlinx/coroutines/internal/o;

    move-result-object v0

    sget-object v1, Lw2/s1;->c:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {v1, p0, p1, v0}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    return-void
.end method

.method private final o0(Ljava/lang/Object;)I
    .registers 6

    instance-of v0, p1, Lw2/v0;

    const/4 v1, -0x1

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-eqz v0, :cond_22

    move-object v0, p1

    check-cast v0, Lw2/v0;

    invoke-virtual {v0}, Lw2/v0;->isActive()Z

    move-result v0

    if-eqz v0, :cond_11

    return v3

    :cond_11
    sget-object v0, Lw2/s1;->c:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {}, Lw2/t1;->c()Lw2/v0;

    move-result-object v3

    invoke-static {v0, p0, p1, v3}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_1e

    return v1

    :cond_1e
    invoke-virtual {p0}, Lw2/s1;->j0()V

    return v2

    :cond_22
    instance-of v0, p1, Lw2/f1;

    if-eqz v0, :cond_3a

    sget-object v0, Lw2/s1;->c:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    move-object v3, p1

    check-cast v3, Lw2/f1;

    invoke-virtual {v3}, Lw2/f1;->e()Lw2/w1;

    move-result-object v3

    invoke-static {v0, p0, p1, v3}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_36

    return v1

    :cond_36
    invoke-virtual {p0}, Lw2/s1;->j0()V

    return v2

    :cond_3a
    return v3
.end method

.method private final p0(Ljava/lang/Object;)Ljava/lang/String;
    .registers 4

    instance-of v0, p1, Lw2/s1$b;

    const-string v1, "Active"

    if-eqz v0, :cond_1a

    check-cast p1, Lw2/s1$b;

    invoke-virtual {p1}, Lw2/s1$b;->f()Z

    move-result v0

    if-eqz v0, :cond_11

    const-string v1, "Cancelling"

    goto :goto_33

    :cond_11
    invoke-virtual {p1}, Lw2/s1$b;->g()Z

    move-result p1

    if-eqz p1, :cond_33

    const-string v1, "Completing"

    goto :goto_33

    :cond_1a
    instance-of v0, p1, Lw2/g1;

    if-eqz v0, :cond_2a

    check-cast p1, Lw2/g1;

    invoke-interface {p1}, Lw2/g1;->isActive()Z

    move-result p1

    if-eqz p1, :cond_27

    goto :goto_33

    :cond_27
    const-string v1, "New"

    goto :goto_33

    :cond_2a
    instance-of p1, p1, Lw2/v;

    if-eqz p1, :cond_31

    const-string v1, "Cancelled"

    goto :goto_33

    :cond_31
    const-string v1, "Completed"

    :cond_33
    :goto_33
    return-object v1
.end method

.method public static synthetic r0(Lw2/s1;Ljava/lang/Throwable;Ljava/lang/String;ILjava/lang/Object;)Ljava/util/concurrent/CancellationException;
    .registers 5

    if-nez p4, :cond_c

    and-int/lit8 p3, p3, 0x1

    if-eqz p3, :cond_7

    const/4 p2, 0x0

    :cond_7
    invoke-virtual {p0, p1, p2}, Lw2/s1;->q0(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;

    move-result-object p0

    return-object p0

    :cond_c
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: toCancellationException"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private final t0(Lw2/g1;Ljava/lang/Object;)Z
    .registers 5

    sget-object v0, Lw2/s1;->c:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {p2}, Lw2/t1;->g(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v0, p0, p1, v1}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_e

    const/4 p1, 0x0

    return p1

    :cond_e
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lw2/s1;->h0(Ljava/lang/Throwable;)V

    invoke-virtual {p0, p2}, Lw2/s1;->i0(Ljava/lang/Object;)V

    invoke-direct {p0, p1, p2}, Lw2/s1;->J(Lw2/g1;Ljava/lang/Object;)V

    const/4 p1, 0x1

    return p1
.end method

.method private final u0(Lw2/g1;Ljava/lang/Throwable;)Z
    .registers 7

    invoke-direct {p0, p1}, Lw2/s1;->S(Lw2/g1;)Lw2/w1;

    move-result-object v0

    const/4 v1, 0x0

    if-nez v0, :cond_8

    return v1

    :cond_8
    new-instance v2, Lw2/s1$b;

    invoke-direct {v2, v0, v1, p2}, Lw2/s1$b;-><init>(Lw2/w1;ZLjava/lang/Throwable;)V

    sget-object v3, Lw2/s1;->c:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {v3, p0, p1, v2}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_16

    return v1

    :cond_16
    invoke-direct {p0, v0, p2}, Lw2/s1;->f0(Lw2/w1;Ljava/lang/Throwable;)V

    const/4 p1, 0x1

    return p1
.end method

.method private final v0(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 4

    instance-of v0, p1, Lw2/g1;

    if-nez v0, :cond_9

    invoke-static {}, Lw2/t1;->a()Lkotlinx/coroutines/internal/b0;

    move-result-object p1

    return-object p1

    :cond_9
    instance-of v0, p1, Lw2/v0;

    if-nez v0, :cond_11

    instance-of v0, p1, Lw2/r1;

    if-eqz v0, :cond_27

    :cond_11
    instance-of v0, p1, Lw2/r;

    if-nez v0, :cond_27

    instance-of v0, p2, Lw2/v;

    if-nez v0, :cond_27

    check-cast p1, Lw2/g1;

    invoke-direct {p0, p1, p2}, Lw2/s1;->t0(Lw2/g1;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_22

    return-object p2

    :cond_22
    invoke-static {}, Lw2/t1;->b()Lkotlinx/coroutines/internal/b0;

    move-result-object p1

    return-object p1

    :cond_27
    check-cast p1, Lw2/g1;

    invoke-direct {p0, p1, p2}, Lw2/s1;->w0(Lw2/g1;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method private final w0(Lw2/g1;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 11

    invoke-direct {p0, p1}, Lw2/s1;->S(Lw2/g1;)Lw2/w1;

    move-result-object v0

    if-nez v0, :cond_b

    invoke-static {}, Lw2/t1;->b()Lkotlinx/coroutines/internal/b0;

    move-result-object p1

    return-object p1

    :cond_b
    instance-of v1, p1, Lw2/s1$b;

    const/4 v2, 0x0

    if-eqz v1, :cond_14

    move-object v1, p1

    check-cast v1, Lw2/s1$b;

    goto :goto_15

    :cond_14
    move-object v1, v2

    :goto_15
    const/4 v3, 0x0

    if-nez v1, :cond_1d

    new-instance v1, Lw2/s1$b;

    invoke-direct {v1, v0, v3, v2}, Lw2/s1$b;-><init>(Lw2/w1;ZLjava/lang/Throwable;)V

    :cond_1d
    new-instance v4, Lkotlin/jvm/internal/q;

    invoke-direct {v4}, Lkotlin/jvm/internal/q;-><init>()V

    monitor-enter v1

    :try_start_23
    invoke-virtual {v1}, Lw2/s1$b;->g()Z

    move-result v5

    if-eqz v5, :cond_2f

    invoke-static {}, Lw2/t1;->a()Lkotlinx/coroutines/internal/b0;

    move-result-object p1
    :try_end_2d
    .catchall {:try_start_23 .. :try_end_2d} :catchall_8b

    monitor-exit v1

    return-object p1

    :cond_2f
    const/4 v5, 0x1

    const/4 v5, 0x1

    :try_start_31
    invoke-virtual {v1, v5}, Lw2/s1$b;->j(Z)V

    if-eq v1, p1, :cond_44

    sget-object v6, Lw2/s1;->c:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {v6, p0, p1, v1}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_44

    invoke-static {}, Lw2/t1;->b()Lkotlinx/coroutines/internal/b0;

    move-result-object p1
    :try_end_42
    .catchall {:try_start_31 .. :try_end_42} :catchall_8b

    monitor-exit v1

    return-object p1

    :cond_44
    :try_start_44
    invoke-virtual {v1}, Lw2/s1$b;->f()Z

    move-result v6

    instance-of v7, p2, Lw2/v;

    if-eqz v7, :cond_50

    move-object v7, p2

    check-cast v7, Lw2/v;

    goto :goto_51

    :cond_50
    move-object v7, v2

    :goto_51
    if-eqz v7, :cond_58

    iget-object v7, v7, Lw2/v;->a:Ljava/lang/Throwable;

    invoke-virtual {v1, v7}, Lw2/s1$b;->a(Ljava/lang/Throwable;)V

    :cond_58
    invoke-virtual {v1}, Lw2/s1$b;->d()Ljava/lang/Throwable;

    move-result-object v7

    if-nez v6, :cond_5f

    const/4 v3, 0x1

    :cond_5f
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_6a

    move-object v2, v7

    :cond_6a
    iput-object v2, v4, Lkotlin/jvm/internal/q;->c:Ljava/lang/Object;

    sget-object v3, Lg2/q;->a:Lg2/q;
    :try_end_6e
    .catchall {:try_start_44 .. :try_end_6e} :catchall_8b

    monitor-exit v1

    move-object v3, v2

    check-cast v3, Ljava/lang/Throwable;

    if-eqz v2, :cond_77

    invoke-direct {p0, v0, v2}, Lw2/s1;->f0(Lw2/w1;Ljava/lang/Throwable;)V

    :cond_77
    invoke-direct {p0, p1}, Lw2/s1;->N(Lw2/g1;)Lw2/r;

    move-result-object p1

    if-eqz p1, :cond_86

    invoke-direct {p0, v1, p1, p2}, Lw2/s1;->x0(Lw2/s1$b;Lw2/r;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_86

    sget-object p1, Lw2/t1;->b:Lkotlinx/coroutines/internal/b0;

    return-object p1

    :cond_86
    invoke-direct {p0, v1, p2}, Lw2/s1;->M(Lw2/s1$b;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :catchall_8b
    move-exception p1

    monitor-exit v1

    throw p1
.end method

.method private final x0(Lw2/s1$b;Lw2/r;Ljava/lang/Object;)Z
    .registers 10

    :cond_0
    iget-object v0, p2, Lw2/r;->h:Lw2/s;

    const/4 v1, 0x0

    const/4 v2, 0x0

    new-instance v3, Lw2/s1$a;

    invoke-direct {v3, p0, p1, p2, p3}, Lw2/s1$a;-><init>(Lw2/s1;Lw2/s1$b;Lw2/r;Ljava/lang/Object;)V

    const/4 v4, 0x1

    const/4 v5, 0x0

    invoke-static/range {v0 .. v5}, Lw2/l1$a;->d(Lw2/l1;ZZLp2/l;ILjava/lang/Object;)Lw2/u0;

    move-result-object v0

    sget-object v1, Lw2/x1;->c:Lw2/x1;

    if-eq v0, v1, :cond_15

    const/4 p1, 0x1

    return p1

    :cond_15
    invoke-direct {p0, p2}, Lw2/s1;->e0(Lkotlinx/coroutines/internal/o;)Lw2/r;

    move-result-object p2

    if-nez p2, :cond_0

    const/4 p1, 0x0

    return p1
.end method

.method public static final synthetic y(Lw2/s1;)Ljava/lang/String;
    .registers 1

    invoke-virtual {p0}, Lw2/s1;->H()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic z(Lw2/s1;Lw2/s1$b;Lw2/r;Ljava/lang/Object;)V
    .registers 4

    invoke-direct {p0, p1, p2, p3}, Lw2/s1;->K(Lw2/s1$b;Lw2/r;Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method protected C(Ljava/lang/Object;)V
    .registers 2

    return-void
.end method

.method public final D(Ljava/lang/Object;)Z
    .registers 5

    invoke-static {}, Lw2/t1;->a()Lkotlinx/coroutines/internal/b0;

    move-result-object v0

    invoke-virtual {p0}, Lw2/s1;->R()Z

    move-result v1

    const/4 v2, 0x1

    if-eqz v1, :cond_14

    invoke-direct {p0, p1}, Lw2/s1;->F(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lw2/t1;->b:Lkotlinx/coroutines/internal/b0;

    if-ne v0, v1, :cond_14

    return v2

    :cond_14
    invoke-static {}, Lw2/t1;->a()Lkotlinx/coroutines/internal/b0;

    move-result-object v1

    if-ne v0, v1, :cond_1e

    invoke-direct {p0, p1}, Lw2/s1;->a0(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :cond_1e
    invoke-static {}, Lw2/t1;->a()Lkotlinx/coroutines/internal/b0;

    move-result-object p1

    if-ne v0, p1, :cond_25

    goto :goto_35

    :cond_25
    sget-object p1, Lw2/t1;->b:Lkotlinx/coroutines/internal/b0;

    if-ne v0, p1, :cond_2a

    goto :goto_35

    :cond_2a
    invoke-static {}, Lw2/t1;->f()Lkotlinx/coroutines/internal/b0;

    move-result-object p1

    if-ne v0, p1, :cond_32

    const/4 v2, 0x0

    goto :goto_35

    :cond_32
    invoke-virtual {p0, v0}, Lw2/s1;->C(Ljava/lang/Object;)V

    :goto_35
    return v2
.end method

.method public E(Ljava/lang/Throwable;)V
    .registers 2

    invoke-virtual {p0, p1}, Lw2/s1;->D(Ljava/lang/Object;)Z

    return-void
.end method

.method protected H()Ljava/lang/String;
    .registers 2

    const-string v0, "Job was cancelled"

    return-object v0
.end method

.method public I(Ljava/lang/Throwable;)Z
    .registers 4

    instance-of v0, p1, Ljava/util/concurrent/CancellationException;

    const/4 v1, 0x1

    if-eqz v0, :cond_6

    return v1

    :cond_6
    invoke-virtual {p0, p1}, Lw2/s1;->D(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_13

    invoke-virtual {p0}, Lw2/s1;->Q()Z

    move-result p1

    if-eqz p1, :cond_13

    goto :goto_14

    :cond_13
    const/4 v1, 0x0

    :goto_14
    return v1
.end method

.method public Q()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method

.method public R()Z
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method public final T()Lw2/q;
    .registers 2

    iget-object v0, p0, Lw2/s1;->_parentHandle:Ljava/lang/Object;

    check-cast v0, Lw2/q;

    return-object v0
.end method

.method public final U()Ljava/lang/Object;
    .registers 3

    :goto_0
    iget-object v0, p0, Lw2/s1;->_state:Ljava/lang/Object;

    instance-of v1, v0, Lkotlinx/coroutines/internal/w;

    if-nez v1, :cond_7

    return-object v0

    :cond_7
    check-cast v0, Lkotlinx/coroutines/internal/w;

    invoke-virtual {v0, p0}, Lkotlinx/coroutines/internal/w;->c(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method protected V(Ljava/lang/Throwable;)Z
    .registers 2

    const/4 p1, 0x0

    return p1
.end method

.method public W(Ljava/lang/Throwable;)V
    .registers 2

    throw p1
.end method

.method protected final X(Lw2/l1;)V
    .registers 3

    if-nez p1, :cond_8

    sget-object p1, Lw2/x1;->c:Lw2/x1;

    invoke-virtual {p0, p1}, Lw2/s1;->n0(Lw2/q;)V

    return-void

    :cond_8
    invoke-interface {p1}, Lw2/l1;->start()Z

    invoke-interface {p1, p0}, Lw2/l1;->l(Lw2/s;)Lw2/q;

    move-result-object p1

    invoke-virtual {p0, p1}, Lw2/s1;->n0(Lw2/q;)V

    invoke-virtual {p0}, Lw2/s1;->Y()Z

    move-result v0

    if-eqz v0, :cond_20

    invoke-interface {p1}, Lw2/u0;->a()V

    sget-object p1, Lw2/x1;->c:Lw2/x1;

    invoke-virtual {p0, p1}, Lw2/s1;->n0(Lw2/q;)V

    :cond_20
    return-void
.end method

.method public final Y()Z
    .registers 2

    invoke-virtual {p0}, Lw2/s1;->U()Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lw2/g1;

    xor-int/lit8 v0, v0, 0x1

    return v0
.end method

.method protected Z()Z
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method public a(Li2/g$c;)Li2/g$b;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E::",
            "Li2/g$b;",
            ">(",
            "Li2/g$c<",
            "TE;>;)TE;"
        }
    .end annotation

    invoke-static {p0, p1}, Lw2/l1$a;->c(Lw2/l1;Li2/g$c;)Li2/g$b;

    move-result-object p1

    return-object p1
.end method

.method public final b0(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 5

    :cond_0
    invoke-virtual {p0}, Lw2/s1;->U()Ljava/lang/Object;

    move-result-object v0

    invoke-direct {p0, v0, p1}, Lw2/s1;->v0(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {}, Lw2/t1;->a()Lkotlinx/coroutines/internal/b0;

    move-result-object v1

    if-eq v0, v1, :cond_15

    invoke-static {}, Lw2/t1;->b()Lkotlinx/coroutines/internal/b0;

    move-result-object v1

    if-eq v0, v1, :cond_0

    return-object v0

    :cond_15
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Job "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " is already complete or completing, but is being completed with "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p1}, Lw2/s1;->O(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object p1

    invoke-direct {v0, v1, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0
.end method

.method public d0()Ljava/lang/String;
    .registers 2

    invoke-static {p0}, Lw2/k0;->a(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public f(Li2/g;)Li2/g;
    .registers 2

    invoke-static {p0, p1}, Lw2/l1$a;->f(Lw2/l1;Li2/g;)Li2/g;

    move-result-object p1

    return-object p1
.end method

.method public final getKey()Li2/g$c;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Li2/g$c<",
            "*>;"
        }
    .end annotation

    sget-object v0, Lw2/l1;->e:Lw2/l1$b;

    return-object v0
.end method

.method public final h()Ljava/util/concurrent/CancellationException;
    .registers 5

    invoke-virtual {p0}, Lw2/s1;->U()Ljava/lang/Object;

    move-result-object v0

    instance-of v1, v0, Lw2/s1$b;

    const-string v2, "Job is still new or active: "

    if-eqz v1, :cond_47

    check-cast v0, Lw2/s1$b;

    invoke-virtual {v0}, Lw2/s1$b;->d()Ljava/lang/Throwable;

    move-result-object v0

    if-eqz v0, :cond_2e

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lw2/k0;->a(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " is cancelling"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lw2/s1;->q0(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;

    move-result-object v0

    if-eqz v0, :cond_2e

    goto :goto_74

    :cond_2e
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_47
    instance-of v1, v0, Lw2/g1;

    if-nez v1, :cond_75

    instance-of v1, v0, Lw2/v;

    const/4 v2, 0x0

    if-eqz v1, :cond_5a

    check-cast v0, Lw2/v;

    iget-object v0, v0, Lw2/v;->a:Ljava/lang/Throwable;

    const/4 v1, 0x1

    invoke-static {p0, v0, v2, v1, v2}, Lw2/s1;->r0(Lw2/s1;Ljava/lang/Throwable;Ljava/lang/String;ILjava/lang/Object;)Ljava/util/concurrent/CancellationException;

    move-result-object v0

    goto :goto_74

    :cond_5a
    new-instance v0, Lw2/m1;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lw2/k0;->a(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " has completed normally"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, v2, p0}, Lw2/m1;-><init>(Ljava/lang/String;Ljava/lang/Throwable;Lw2/l1;)V

    :goto_74
    return-object v0

    :cond_75
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected h0(Ljava/lang/Throwable;)V
    .registers 2

    return-void
.end method

.method protected i0(Ljava/lang/Object;)V
    .registers 2

    return-void
.end method

.method public isActive()Z
    .registers 3

    invoke-virtual {p0}, Lw2/s1;->U()Ljava/lang/Object;

    move-result-object v0

    instance-of v1, v0, Lw2/g1;

    if-eqz v1, :cond_12

    check-cast v0, Lw2/g1;

    invoke-interface {v0}, Lw2/g1;->isActive()Z

    move-result v0

    if-eqz v0, :cond_12

    const/4 v0, 0x1

    goto :goto_13

    :cond_12
    const/4 v0, 0x0

    :goto_13
    return v0
.end method

.method public final j(ZZLp2/l;)Lw2/u0;
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ZZ",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;)",
            "Lw2/u0;"
        }
    .end annotation

    invoke-direct {p0, p3, p1}, Lw2/s1;->c0(Lp2/l;Z)Lw2/r1;

    move-result-object v0

    :cond_4
    :goto_4
    invoke-virtual {p0}, Lw2/s1;->U()Ljava/lang/Object;

    move-result-object v1

    instance-of v2, v1, Lw2/v0;

    if-eqz v2, :cond_22

    move-object v2, v1

    check-cast v2, Lw2/v0;

    invoke-virtual {v2}, Lw2/v0;->isActive()Z

    move-result v3

    if-eqz v3, :cond_1e

    sget-object v2, Lw2/s1;->c:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {v2, p0, v1, v0}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    return-object v0

    :cond_1e
    invoke-direct {p0, v2}, Lw2/s1;->k0(Lw2/v0;)V

    goto :goto_4

    :cond_22
    instance-of v2, v1, Lw2/g1;

    const/4 v3, 0x0

    if-eqz v2, :cond_82

    move-object v2, v1

    check-cast v2, Lw2/g1;

    invoke-interface {v2}, Lw2/g1;->e()Lw2/w1;

    move-result-object v2

    if-nez v2, :cond_40

    if-eqz v1, :cond_38

    check-cast v1, Lw2/r1;

    invoke-direct {p0, v1}, Lw2/s1;->l0(Lw2/r1;)V

    goto :goto_4

    :cond_38
    new-instance p1, Ljava/lang/NullPointerException;

    const-string p2, "null cannot be cast to non-null type kotlinx.coroutines.JobNode"

    invoke-direct {p1, p2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_40
    sget-object v4, Lw2/x1;->c:Lw2/x1;

    if-eqz p1, :cond_73

    instance-of v5, v1, Lw2/s1$b;

    if-eqz v5, :cond_73

    monitor-enter v1

    :try_start_49
    move-object v3, v1

    check-cast v3, Lw2/s1$b;

    invoke-virtual {v3}, Lw2/s1$b;->d()Ljava/lang/Throwable;

    move-result-object v3

    if-eqz v3, :cond_5f

    instance-of v5, p3, Lw2/r;

    if-eqz v5, :cond_6c

    move-object v5, v1

    check-cast v5, Lw2/s1$b;

    invoke-virtual {v5}, Lw2/s1$b;->g()Z

    move-result v5

    if-nez v5, :cond_6c

    :cond_5f
    invoke-direct {p0, v1, v2, v0}, Lw2/s1;->A(Ljava/lang/Object;Lw2/w1;Lw2/r1;)Z

    move-result v4
    :try_end_63
    .catchall {:try_start_49 .. :try_end_63} :catchall_70

    if-nez v4, :cond_67

    monitor-exit v1

    goto :goto_4

    :cond_67
    if-nez v3, :cond_6b

    monitor-exit v1

    return-object v0

    :cond_6b
    move-object v4, v0

    :cond_6c
    :try_start_6c
    sget-object v5, Lg2/q;->a:Lg2/q;
    :try_end_6e
    .catchall {:try_start_6c .. :try_end_6e} :catchall_70

    monitor-exit v1

    goto :goto_73

    :catchall_70
    move-exception p1

    monitor-exit v1

    throw p1

    :cond_73
    :goto_73
    if-eqz v3, :cond_7b

    if-eqz p2, :cond_7a

    invoke-interface {p3, v3}, Lp2/l;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_7a
    return-object v4

    :cond_7b
    invoke-direct {p0, v1, v2, v0}, Lw2/s1;->A(Ljava/lang/Object;Lw2/w1;Lw2/r1;)Z

    move-result v1

    if-eqz v1, :cond_4

    return-object v0

    :cond_82
    if-eqz p2, :cond_93

    instance-of p1, v1, Lw2/v;

    if-eqz p1, :cond_8b

    check-cast v1, Lw2/v;

    goto :goto_8c

    :cond_8b
    move-object v1, v3

    :goto_8c
    if-eqz v1, :cond_90

    iget-object v3, v1, Lw2/v;->a:Ljava/lang/Throwable;

    :cond_90
    invoke-interface {p3, v3}, Lp2/l;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_93
    sget-object p1, Lw2/x1;->c:Lw2/x1;

    return-object p1
.end method

.method protected j0()V
    .registers 1

    return-void
.end method

.method public k(Li2/g$c;)Li2/g;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/g$c<",
            "*>;)",
            "Li2/g;"
        }
    .end annotation

    invoke-static {p0, p1}, Lw2/l1$a;->e(Lw2/l1;Li2/g$c;)Li2/g;

    move-result-object p1

    return-object p1
.end method

.method public final l(Lw2/s;)Lw2/q;
    .registers 8

    new-instance v3, Lw2/r;

    invoke-direct {v3, p1}, Lw2/r;-><init>(Lw2/s;)V

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v4, 0x2

    const/4 v5, 0x0

    move-object v0, p0

    invoke-static/range {v0 .. v5}, Lw2/l1$a;->d(Lw2/l1;ZZLp2/l;ILjava/lang/Object;)Lw2/u0;

    move-result-object p1

    check-cast p1, Lw2/q;

    return-object p1
.end method

.method public final m0(Lw2/r1;)V
    .registers 5

    :cond_0
    invoke-virtual {p0}, Lw2/s1;->U()Ljava/lang/Object;

    move-result-object v0

    instance-of v1, v0, Lw2/r1;

    if-eqz v1, :cond_18

    if-eq v0, p1, :cond_b

    return-void

    :cond_b
    sget-object v1, Lw2/s1;->c:Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;

    invoke-static {}, Lw2/t1;->c()Lw2/v0;

    move-result-object v2

    invoke-static {v1, p0, v0, v2}, Landroidx/concurrent/futures/b;->a(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    :cond_18
    instance-of v1, v0, Lw2/g1;

    if-eqz v1, :cond_27

    check-cast v0, Lw2/g1;

    invoke-interface {v0}, Lw2/g1;->e()Lw2/w1;

    move-result-object v0

    if-eqz v0, :cond_27

    invoke-virtual {p1}, Lkotlinx/coroutines/internal/o;->t()Z

    :cond_27
    return-void
.end method

.method public final n0(Lw2/q;)V
    .registers 2

    iput-object p1, p0, Lw2/s1;->_parentHandle:Ljava/lang/Object;

    return-void
.end method

.method protected final q0(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;
    .registers 4

    instance-of v0, p1, Ljava/util/concurrent/CancellationException;

    if-eqz v0, :cond_8

    move-object v0, p1

    check-cast v0, Ljava/util/concurrent/CancellationException;

    goto :goto_9

    :cond_8
    const/4 v0, 0x0

    :goto_9
    if-nez v0, :cond_16

    new-instance v0, Lw2/m1;

    if-nez p2, :cond_13

    invoke-static {p0}, Lw2/s1;->y(Lw2/s1;)Ljava/lang/String;

    move-result-object p2

    :cond_13
    invoke-direct {v0, p2, p1, p0}, Lw2/m1;-><init>(Ljava/lang/String;Ljava/lang/Throwable;Lw2/l1;)V

    :cond_16
    return-object v0
.end method

.method public s()Ljava/util/concurrent/CancellationException;
    .registers 6

    invoke-virtual {p0}, Lw2/s1;->U()Ljava/lang/Object;

    move-result-object v0

    instance-of v1, v0, Lw2/s1$b;

    const/4 v2, 0x0

    if-eqz v1, :cond_11

    move-object v1, v0

    check-cast v1, Lw2/s1$b;

    invoke-virtual {v1}, Lw2/s1$b;->d()Ljava/lang/Throwable;

    move-result-object v1

    goto :goto_20

    :cond_11
    instance-of v1, v0, Lw2/v;

    if-eqz v1, :cond_1b

    move-object v1, v0

    check-cast v1, Lw2/v;

    iget-object v1, v1, Lw2/v;->a:Ljava/lang/Throwable;

    goto :goto_20

    :cond_1b
    instance-of v1, v0, Lw2/g1;

    if-nez v1, :cond_44

    move-object v1, v2

    :goto_20
    instance-of v3, v1, Ljava/util/concurrent/CancellationException;

    if-eqz v3, :cond_27

    move-object v2, v1

    check-cast v2, Ljava/util/concurrent/CancellationException;

    :cond_27
    if-nez v2, :cond_43

    new-instance v2, Lw2/m1;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Parent job is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-direct {p0, v0}, Lw2/s1;->p0(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0, v1, p0}, Lw2/m1;-><init>(Ljava/lang/String;Ljava/lang/Throwable;Lw2/l1;)V

    :cond_43
    return-object v2

    :cond_44
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Cannot be cancelling child in this state: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public final s0()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lw2/s1;->d0()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x7b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lw2/s1;->U()Ljava/lang/Object;

    move-result-object v1

    invoke-direct {p0, v1}, Lw2/s1;->p0(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final start()Z
    .registers 3

    :goto_0
    invoke-virtual {p0}, Lw2/s1;->U()Ljava/lang/Object;

    move-result-object v0

    invoke-direct {p0, v0}, Lw2/s1;->o0(Ljava/lang/Object;)I

    move-result v0

    if-eqz v0, :cond_f

    const/4 v1, 0x1

    if-eq v0, v1, :cond_e

    goto :goto_0

    :cond_e
    return v1

    :cond_f
    const/4 v0, 0x0

    return v0
.end method

.method public t(Ljava/util/concurrent/CancellationException;)V
    .registers 4

    if-nez p1, :cond_d

    const/4 p1, 0x0

    new-instance v0, Lw2/m1;

    invoke-static {p0}, Lw2/s1;->y(Lw2/s1;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p1, p0}, Lw2/m1;-><init>(Ljava/lang/String;Ljava/lang/Throwable;Lw2/l1;)V

    move-object p1, v0

    :cond_d
    invoke-virtual {p0, p1}, Lw2/s1;->E(Ljava/lang/Throwable;)V

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lw2/s1;->s0()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x40

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-static {p0}, Lw2/k0;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final v(Lw2/z1;)V
    .registers 2

    invoke-virtual {p0, p1}, Lw2/s1;->D(Ljava/lang/Object;)Z

    return-void
.end method

.method public x(Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<R:",
            "Ljava/lang/Object;",
            ">(TR;",
            "Lp2/p<",
            "-TR;-",
            "Li2/g$b;",
            "+TR;>;)TR;"
        }
    .end annotation

    invoke-static {p0, p1, p2}, Lw2/l1$a;->b(Lw2/l1;Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method
