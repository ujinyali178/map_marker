.class final Ly2/a$a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ly2/g;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ly2/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ly2/g<",
        "TE;>;"
    }
.end annotation


# instance fields
.field public final a:Ly2/a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ly2/a<",
            "TE;>;"
        }
    .end annotation
.end field

.field private b:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Ly2/a;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ly2/a<",
            "TE;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Ly2/a$a;->a:Ly2/a;

    sget-object p1, Ly2/b;->d:Lkotlinx/coroutines/internal/b0;

    iput-object p1, p0, Ly2/a$a;->b:Ljava/lang/Object;

    return-void
.end method

.method private final b(Ljava/lang/Object;)Z
    .registers 3

    instance-of v0, p1, Ly2/j;

    if-eqz v0, :cond_15

    check-cast p1, Ly2/j;

    iget-object v0, p1, Ly2/j;->g:Ljava/lang/Throwable;

    if-nez v0, :cond_c

    const/4 p1, 0x0

    return p1

    :cond_c
    invoke-virtual {p1}, Ly2/j;->D()Ljava/lang/Throwable;

    move-result-object p1

    invoke-static {p1}, Lkotlinx/coroutines/internal/a0;->a(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object p1

    throw p1

    :cond_15
    const/4 p1, 0x1

    return p1
.end method

.method private final c(Li2/d;)Ljava/lang/Object;
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/d<",
            "-",
            "Ljava/lang/Boolean;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    invoke-static {p1}, Lj2/b;->b(Li2/d;)Li2/d;

    move-result-object v0

    invoke-static {v0}, Lw2/n;->a(Li2/d;)Lw2/l;

    move-result-object v0

    new-instance v1, Ly2/a$b;

    invoke-direct {v1, p0, v0}, Ly2/a$b;-><init>(Ly2/a$a;Lw2/k;)V

    :cond_d
    iget-object v2, p0, Ly2/a$a;->a:Ly2/a;

    invoke-static {v2, v1}, Ly2/a;->n(Ly2/a;Ly2/o;)Z

    move-result v2

    if-eqz v2, :cond_1b

    iget-object v2, p0, Ly2/a$a;->a:Ly2/a;

    invoke-static {v2, v0, v1}, Ly2/a;->o(Ly2/a;Lw2/k;Ly2/o;)V

    goto :goto_64

    :cond_1b
    iget-object v2, p0, Ly2/a$a;->a:Ly2/a;

    invoke-virtual {v2}, Ly2/a;->v()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p0, v2}, Ly2/a$a;->d(Ljava/lang/Object;)V

    instance-of v3, v2, Ly2/j;

    if-eqz v3, :cond_48

    check-cast v2, Ly2/j;

    iget-object v1, v2, Ly2/j;->g:Ljava/lang/Throwable;

    if-nez v1, :cond_36

    sget-object v1, Lg2/k;->c:Lg2/k$a;

    const/4 v1, 0x0

    invoke-static {v1}, Lkotlin/coroutines/jvm/internal/b;->a(Z)Ljava/lang/Boolean;

    move-result-object v1

    goto :goto_40

    :cond_36
    sget-object v1, Lg2/k;->c:Lg2/k$a;

    invoke-virtual {v2}, Ly2/j;->D()Ljava/lang/Throwable;

    move-result-object v1

    invoke-static {v1}, Lg2/l;->a(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v1

    :goto_40
    invoke-static {v1}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v0, v1}, Li2/d;->resumeWith(Ljava/lang/Object;)V

    goto :goto_64

    :cond_48
    sget-object v3, Ly2/b;->d:Lkotlinx/coroutines/internal/b0;

    if-eq v2, v3, :cond_d

    const/4 v1, 0x1

    invoke-static {v1}, Lkotlin/coroutines/jvm/internal/b;->a(Z)Ljava/lang/Boolean;

    move-result-object v1

    iget-object v3, p0, Ly2/a$a;->a:Ly2/a;

    iget-object v3, v3, Ly2/c;->b:Lp2/l;

    if-eqz v3, :cond_60

    invoke-interface {v0}, Li2/d;->getContext()Li2/g;

    move-result-object v4

    invoke-static {v3, v2, v4}, Lkotlinx/coroutines/internal/v;->a(Lp2/l;Ljava/lang/Object;Li2/g;)Lp2/l;

    move-result-object v2

    goto :goto_61

    :cond_60
    const/4 v2, 0x0

    :goto_61
    invoke-interface {v0, v1, v2}, Lw2/k;->g(Ljava/lang/Object;Lp2/l;)V

    :goto_64
    invoke-virtual {v0}, Lw2/l;->v()Ljava/lang/Object;

    move-result-object v0

    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object v1

    if-ne v0, v1, :cond_71

    invoke-static {p1}, Lkotlin/coroutines/jvm/internal/h;->c(Li2/d;)V

    :cond_71
    return-object v0
.end method


# virtual methods
.method public a(Li2/d;)Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/d<",
            "-",
            "Ljava/lang/Boolean;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    iget-object v0, p0, Ly2/a$a;->b:Ljava/lang/Object;

    sget-object v1, Ly2/b;->d:Lkotlinx/coroutines/internal/b0;

    if-eq v0, v1, :cond_f

    :goto_6
    invoke-direct {p0, v0}, Ly2/a$a;->b(Ljava/lang/Object;)Z

    move-result p1

    invoke-static {p1}, Lkotlin/coroutines/jvm/internal/b;->a(Z)Ljava/lang/Boolean;

    move-result-object p1

    return-object p1

    :cond_f
    iget-object v0, p0, Ly2/a$a;->a:Ly2/a;

    invoke-virtual {v0}, Ly2/a;->v()Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Ly2/a$a;->b:Ljava/lang/Object;

    if-eq v0, v1, :cond_1a

    goto :goto_6

    :cond_1a
    invoke-direct {p0, p1}, Ly2/a$a;->c(Li2/d;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final d(Ljava/lang/Object;)V
    .registers 2

    iput-object p1, p0, Ly2/a$a;->b:Ljava/lang/Object;

    return-void
.end method

.method public next()Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TE;"
        }
    .end annotation

    iget-object v0, p0, Ly2/a$a;->b:Ljava/lang/Object;

    instance-of v1, v0, Ly2/j;

    if-nez v1, :cond_15

    sget-object v1, Ly2/b;->d:Lkotlinx/coroutines/internal/b0;

    if-eq v0, v1, :cond_d

    iput-object v1, p0, Ly2/a$a;->b:Ljava/lang/Object;

    return-object v0

    :cond_d
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "\'hasNext\' should be called prior to \'next\' invocation"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_15
    check-cast v0, Ly2/j;

    invoke-virtual {v0}, Ly2/j;->D()Ljava/lang/Throwable;

    move-result-object v0

    invoke-static {v0}, Lkotlinx/coroutines/internal/a0;->a(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object v0

    throw v0
.end method
