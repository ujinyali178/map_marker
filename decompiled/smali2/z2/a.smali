.class public abstract Lz2/a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lz2/b;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lz2/b<",
        "TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lz2/c;Li2/d;)Ljava/lang/Object;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lz2/c<",
            "-TT;>;",
            "Li2/d<",
            "-",
            "Lg2/q;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    instance-of v0, p2, Lz2/a$a;

    if-eqz v0, :cond_13

    move-object v0, p2

    check-cast v0, Lz2/a$a;

    iget v1, v0, Lz2/a$a;->g:I

    const/high16 v2, -0x80000000

    and-int v3, v1, v2

    if-eqz v3, :cond_13

    sub-int/2addr v1, v2

    iput v1, v0, Lz2/a$a;->g:I

    goto :goto_18

    :cond_13
    new-instance v0, Lz2/a$a;

    invoke-direct {v0, p0, p2}, Lz2/a$a;-><init>(Lz2/a;Li2/d;)V

    :goto_18
    iget-object p2, v0, Lz2/a$a;->d:Ljava/lang/Object;

    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object v1

    iget v2, v0, Lz2/a$a;->g:I

    const/4 v3, 0x1

    if-eqz v2, :cond_37

    if-ne v2, v3, :cond_2f

    iget-object p1, v0, Lz2/a$a;->c:Ljava/lang/Object;

    check-cast p1, La3/c;

    :try_start_29
    invoke-static {p2}, Lg2/l;->b(Ljava/lang/Object;)V
    :try_end_2c
    .catchall {:try_start_29 .. :try_end_2c} :catchall_2d

    goto :goto_4f

    :catchall_2d
    move-exception p2

    goto :goto_59

    :cond_2f
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_37
    invoke-static {p2}, Lg2/l;->b(Ljava/lang/Object;)V

    new-instance p2, La3/c;

    invoke-interface {v0}, Li2/d;->getContext()Li2/g;

    move-result-object v2

    invoke-direct {p2, p1, v2}, La3/c;-><init>(Lz2/c;Li2/g;)V

    :try_start_43
    iput-object p2, v0, Lz2/a$a;->c:Ljava/lang/Object;

    iput v3, v0, Lz2/a$a;->g:I

    invoke-virtual {p0, p2, v0}, Lz2/a;->b(Lz2/c;Li2/d;)Ljava/lang/Object;

    move-result-object p1
    :try_end_4b
    .catchall {:try_start_43 .. :try_end_4b} :catchall_55

    if-ne p1, v1, :cond_4e

    return-object v1

    :cond_4e
    move-object p1, p2

    :goto_4f
    invoke-virtual {p1}, La3/c;->releaseIntercepted()V

    sget-object p1, Lg2/q;->a:Lg2/q;

    return-object p1

    :catchall_55
    move-exception p1

    move-object v4, p2

    move-object p2, p1

    move-object p1, v4

    :goto_59
    invoke-virtual {p1}, La3/c;->releaseIntercepted()V

    throw p2
.end method

.method public abstract b(Lz2/c;Li2/d;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lz2/c<",
            "-TT;>;",
            "Li2/d<",
            "-",
            "Lg2/q;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation
.end method
