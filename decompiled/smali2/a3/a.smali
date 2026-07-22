.class public final La3/a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Li2/g;


# instance fields
.field public final c:Ljava/lang/Throwable;

.field private final synthetic d:Li2/g;


# direct methods
.method public constructor <init>(Ljava/lang/Throwable;Li2/g;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, La3/a;->c:Ljava/lang/Throwable;

    iput-object p2, p0, La3/a;->d:Li2/g;

    return-void
.end method


# virtual methods
.method public a(Li2/g$c;)Li2/g$b;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E::",
            "Li2/g$b;",
            ">(",
            "Li2/g$c<",
            "TE;>;)TE;"
        }
    .end annotation

    iget-object v0, p0, La3/a;->d:Li2/g;

    invoke-interface {v0, p1}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object p1

    return-object p1
.end method

.method public f(Li2/g;)Li2/g;
    .registers 3

    iget-object v0, p0, La3/a;->d:Li2/g;

    invoke-interface {v0, p1}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object p1

    return-object p1
.end method

.method public k(Li2/g$c;)Li2/g;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/g$c<",
            "*>;)",
            "Li2/g;"
        }
    .end annotation

    iget-object v0, p0, La3/a;->d:Li2/g;

    invoke-interface {v0, p1}, Li2/g;->k(Li2/g$c;)Li2/g;

    move-result-object p1

    return-object p1
.end method

.method public x(Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;
    .registers 4
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

    iget-object v0, p0, La3/a;->d:Li2/g;

    invoke-interface {v0, p1, p2}, Li2/g;->x(Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method
