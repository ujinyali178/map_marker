.class public final La3/c;
.super Lkotlin/coroutines/jvm/internal/d;
.source "SourceFile"

# interfaces
.implements Lz2/c;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lkotlin/coroutines/jvm/internal/d;",
        "Lz2/c<",
        "TT;>;"
    }
.end annotation


# instance fields
.field public final c:Lz2/c;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lz2/c<",
            "TT;>;"
        }
    .end annotation
.end field

.field public final d:Li2/g;

.field public final f:I

.field private g:Li2/g;

.field private h:Li2/d;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Li2/d<",
            "-",
            "Lg2/q;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lz2/c;Li2/g;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lz2/c<",
            "-TT;>;",
            "Li2/g;",
            ")V"
        }
    .end annotation

    sget-object v0, La3/b;->c:La3/b;

    sget-object v1, Li2/h;->c:Li2/h;

    invoke-direct {p0, v0, v1}, Lkotlin/coroutines/jvm/internal/d;-><init>(Li2/d;Li2/g;)V

    iput-object p1, p0, La3/c;->c:Lz2/c;

    iput-object p2, p0, La3/c;->d:Li2/g;

    const/4 p1, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    sget-object v0, La3/c$a;->c:La3/c$a;

    invoke-interface {p2, p1, v0}, Li2/g;->x(Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result p1

    iput p1, p0, La3/c;->f:I

    return-void
.end method

.method private final a(Li2/g;Li2/g;Ljava/lang/Object;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/g;",
            "Li2/g;",
            "TT;)V"
        }
    .end annotation

    instance-of v0, p2, La3/a;

    if-eqz v0, :cond_9

    check-cast p2, La3/a;

    invoke-direct {p0, p2, p3}, La3/c;->f(La3/a;Ljava/lang/Object;)V

    :cond_9
    invoke-static {p0, p1}, La3/e;->a(La3/c;Li2/g;)V

    return-void
.end method

.method private final d(Li2/d;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/d<",
            "-",
            "Lg2/q;",
            ">;TT;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    invoke-interface {p1}, Li2/d;->getContext()Li2/g;

    move-result-object v0

    invoke-static {v0}, Lw2/p1;->e(Li2/g;)V

    iget-object v1, p0, La3/c;->g:Li2/g;

    if-eq v1, v0, :cond_10

    invoke-direct {p0, v0, v1, p2}, La3/c;->a(Li2/g;Li2/g;Ljava/lang/Object;)V

    iput-object v0, p0, La3/c;->g:Li2/g;

    :cond_10
    iput-object p1, p0, La3/c;->h:Li2/d;

    invoke-static {}, La3/d;->a()Lp2/q;

    move-result-object p1

    iget-object v0, p0, La3/c;->c:Lz2/c;

    invoke-interface {p1, v0, p2, p0}, Lp2/q;->c(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object p2

    invoke-static {p1, p2}, Lkotlin/jvm/internal/k;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p2

    if-nez p2, :cond_29

    const/4 p2, 0x0

    iput-object p2, p0, La3/c;->h:Li2/d;

    :cond_29
    return-object p1
.end method

.method private final f(La3/a;Ljava/lang/Object;)V
    .registers 6

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\n            Flow exception transparency is violated:\n                Previous \'emit\' call has thrown exception "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object p1, p1, La3/a;->c:Ljava/lang/Throwable;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p1, ", but then emission attempt of value \'"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p1, "\' has been detected.\n                Emissions from \'catch\' blocks are prohibited in order to avoid unspecified behaviour, \'Flow.catch\' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            "

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lv2/d;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public emit(Ljava/lang/Object;Li2/d;)Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Li2/d<",
            "-",
            "Lg2/q;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    :try_start_0
    invoke-direct {p0, p2, p1}, La3/c;->d(Li2/d;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1
    :try_end_4
    .catchall {:try_start_0 .. :try_end_4} :catchall_17

    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object v0

    if-ne p1, v0, :cond_d

    invoke-static {p2}, Lkotlin/coroutines/jvm/internal/h;->c(Li2/d;)V

    :cond_d
    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object p2

    if-ne p1, p2, :cond_14

    return-object p1

    :cond_14
    sget-object p1, Lg2/q;->a:Lg2/q;

    return-object p1

    :catchall_17
    move-exception p1

    new-instance v0, La3/a;

    invoke-interface {p2}, Li2/d;->getContext()Li2/g;

    move-result-object p2

    invoke-direct {v0, p1, p2}, La3/a;-><init>(Ljava/lang/Throwable;Li2/g;)V

    iput-object v0, p0, La3/c;->g:Li2/g;

    throw p1
.end method

.method public getCallerFrame()Lkotlin/coroutines/jvm/internal/e;
    .registers 3

    iget-object v0, p0, La3/c;->h:Li2/d;

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

    iget-object v0, p0, La3/c;->g:Li2/g;

    if-nez v0, :cond_6

    sget-object v0, Li2/h;->c:Li2/h;

    :cond_6
    return-object v0
.end method

.method public getStackTraceElement()Ljava/lang/StackTraceElement;
    .registers 2

    const/4 v0, 0x0

    return-object v0
.end method

.method public invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 5

    invoke-static {p1}, Lg2/k;->b(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v0

    if-eqz v0, :cond_11

    new-instance v1, La3/a;

    invoke-virtual {p0}, La3/c;->getContext()Li2/g;

    move-result-object v2

    invoke-direct {v1, v0, v2}, La3/a;-><init>(Ljava/lang/Throwable;Li2/g;)V

    iput-object v1, p0, La3/c;->g:Li2/g;

    :cond_11
    iget-object v0, p0, La3/c;->h:Li2/d;

    if-eqz v0, :cond_18

    invoke-interface {v0, p1}, Li2/d;->resumeWith(Ljava/lang/Object;)V

    :cond_18
    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public releaseIntercepted()V
    .registers 1

    invoke-super {p0}, Lkotlin/coroutines/jvm/internal/d;->releaseIntercepted()V

    return-void
.end method
