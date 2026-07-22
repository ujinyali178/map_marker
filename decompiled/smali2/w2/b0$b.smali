.class final Lw2/b0$b;
.super Lkotlin/jvm/internal/l;
.source "SourceFile"

# interfaces
.implements Lp2/p;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lw2/b0;->a(Li2/g;Li2/g;Z)Li2/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/l;",
        "Lp2/p<",
        "Li2/g;",
        "Li2/g$b;",
        "Li2/g;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic c:Lkotlin/jvm/internal/q;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/internal/q<",
            "Li2/g;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic d:Z


# direct methods
.method constructor <init>(Lkotlin/jvm/internal/q;Z)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/internal/q<",
            "Li2/g;",
            ">;Z)V"
        }
    .end annotation

    iput-object p1, p0, Lw2/b0$b;->c:Lkotlin/jvm/internal/q;

    iput-boolean p2, p0, Lw2/b0$b;->d:Z

    const/4 p1, 0x2

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/l;-><init>(I)V

    return-void
.end method


# virtual methods
.method public final a(Li2/g;Li2/g$b;)Li2/g;
    .registers 7

    instance-of v0, p2, Lw2/a0;

    if-nez v0, :cond_9

    invoke-interface {p1, p2}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object p1

    return-object p1

    :cond_9
    iget-object v0, p0, Lw2/b0$b;->c:Lkotlin/jvm/internal/q;

    iget-object v0, v0, Lkotlin/jvm/internal/q;->c:Ljava/lang/Object;

    check-cast v0, Li2/g;

    invoke-interface {p2}, Li2/g$b;->getKey()Li2/g$c;

    move-result-object v1

    invoke-interface {v0, v1}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object v0

    if-nez v0, :cond_28

    iget-boolean v0, p0, Lw2/b0$b;->d:Z

    check-cast p2, Lw2/a0;

    if-eqz v0, :cond_23

    invoke-interface {p2}, Lw2/a0;->q()Lw2/a0;

    move-result-object p2

    :cond_23
    invoke-interface {p1, p2}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object p1

    return-object p1

    :cond_28
    iget-object v1, p0, Lw2/b0$b;->c:Lkotlin/jvm/internal/q;

    iget-object v2, v1, Lkotlin/jvm/internal/q;->c:Ljava/lang/Object;

    check-cast v2, Li2/g;

    invoke-interface {p2}, Li2/g$b;->getKey()Li2/g$c;

    move-result-object v3

    invoke-interface {v2, v3}, Li2/g;->k(Li2/g$c;)Li2/g;

    move-result-object v2

    iput-object v2, v1, Lkotlin/jvm/internal/q;->c:Ljava/lang/Object;

    check-cast p2, Lw2/a0;

    invoke-interface {p2, v0}, Lw2/a0;->r(Li2/g$b;)Li2/g;

    move-result-object p2

    invoke-interface {p1, p2}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3

    check-cast p1, Li2/g;

    check-cast p2, Li2/g$b;

    invoke-virtual {p0, p1, p2}, Lw2/b0$b;->a(Li2/g;Li2/g$b;)Li2/g;

    move-result-object p1

    return-object p1
.end method
