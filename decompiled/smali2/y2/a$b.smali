.class Ly2/a$b;
.super Ly2/o;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ly2/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ly2/o<",
        "TE;>;"
    }
.end annotation


# instance fields
.field public final g:Ly2/a$a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ly2/a$a<",
            "TE;>;"
        }
    .end annotation
.end field

.field public final h:Lw2/k;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lw2/k<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ly2/a$a;Lw2/k;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ly2/a$a<",
            "TE;>;",
            "Lw2/k<",
            "-",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ly2/o;-><init>()V

    iput-object p1, p0, Ly2/a$b;->g:Ly2/a$a;

    iput-object p2, p0, Ly2/a$b;->h:Lw2/k;

    return-void
.end method


# virtual methods
.method public f(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)V"
        }
    .end annotation

    iget-object v0, p0, Ly2/a$b;->g:Ly2/a$a;

    invoke-virtual {v0, p1}, Ly2/a$a;->d(Ljava/lang/Object;)V

    iget-object p1, p0, Ly2/a$b;->h:Lw2/k;

    sget-object v0, Lw2/m;->a:Lkotlinx/coroutines/internal/b0;

    invoke-interface {p1, v0}, Lw2/k;->w(Ljava/lang/Object;)V

    return-void
.end method

.method public g(Ljava/lang/Object;Lkotlinx/coroutines/internal/o$b;)Lkotlinx/coroutines/internal/b0;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;",
            "Lkotlinx/coroutines/internal/o$b;",
            ")",
            "Lkotlinx/coroutines/internal/b0;"
        }
    .end annotation

    iget-object p2, p0, Ly2/a$b;->h:Lw2/k;

    sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {p0, p1}, Ly2/a$b;->z(Ljava/lang/Object;)Lp2/l;

    move-result-object p1

    const/4 v1, 0x0

    invoke-interface {p2, v0, v1, p1}, Lw2/k;->e(Ljava/lang/Object;Ljava/lang/Object;Lp2/l;)Ljava/lang/Object;

    move-result-object p1

    if-nez p1, :cond_10

    return-object v1

    :cond_10
    sget-object p1, Lw2/m;->a:Lkotlinx/coroutines/internal/b0;

    return-object p1
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ReceiveHasNext@"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p0}, Lw2/k0;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public y(Ly2/j;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ly2/j<",
            "*>;)V"
        }
    .end annotation

    iget-object v0, p1, Ly2/j;->g:Ljava/lang/Throwable;

    if-nez v0, :cond_f

    iget-object v0, p0, Ly2/a$b;->h:Lw2/k;

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-static {v0, v1, v3, v2, v3}, Lw2/k$a;->a(Lw2/k;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_19

    :cond_f
    iget-object v0, p0, Ly2/a$b;->h:Lw2/k;

    invoke-virtual {p1}, Ly2/j;->D()Ljava/lang/Throwable;

    move-result-object v1

    invoke-interface {v0, v1}, Lw2/k;->m(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v0

    :goto_19
    if-eqz v0, :cond_25

    iget-object v1, p0, Ly2/a$b;->g:Ly2/a$a;

    invoke-virtual {v1, p1}, Ly2/a$a;->d(Ljava/lang/Object;)V

    iget-object p1, p0, Ly2/a$b;->h:Lw2/k;

    invoke-interface {p1, v0}, Lw2/k;->w(Ljava/lang/Object;)V

    :cond_25
    return-void
.end method

.method public z(Ljava/lang/Object;)Lp2/l;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)",
            "Lp2/l<",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Ly2/a$b;->g:Ly2/a$a;

    iget-object v0, v0, Ly2/a$a;->a:Ly2/a;

    iget-object v0, v0, Ly2/c;->b:Lp2/l;

    if-eqz v0, :cond_13

    iget-object v1, p0, Ly2/a$b;->h:Lw2/k;

    invoke-interface {v1}, Li2/d;->getContext()Li2/g;

    move-result-object v1

    invoke-static {v0, p1, v1}, Lkotlinx/coroutines/internal/v;->a(Lp2/l;Ljava/lang/Object;Li2/g;)Lp2/l;

    move-result-object p1

    goto :goto_14

    :cond_13
    const/4 p1, 0x0

    :goto_14
    return-object p1
.end method
