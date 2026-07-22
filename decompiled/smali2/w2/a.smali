.class public abstract Lw2/a;
.super Lw2/s1;
.source "SourceFile"

# interfaces
.implements Li2/d;
.implements Lw2/g0;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lw2/s1;",
        "Li2/d<",
        "TT;>;",
        "Lw2/g0;"
    }
.end annotation


# instance fields
.field private final d:Li2/g;


# direct methods
.method public constructor <init>(Li2/g;ZZ)V
    .registers 4

    invoke-direct {p0, p3}, Lw2/s1;-><init>(Z)V

    if-eqz p2, :cond_10

    sget-object p2, Lw2/l1;->e:Lw2/l1$b;

    invoke-interface {p1, p2}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object p2

    check-cast p2, Lw2/l1;

    invoke-virtual {p0, p2}, Lw2/s1;->X(Lw2/l1;)V

    :cond_10
    invoke-interface {p1, p0}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object p1

    iput-object p1, p0, Lw2/a;->d:Li2/g;

    return-void
.end method


# virtual methods
.method protected A0(Ljava/lang/Object;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    return-void
.end method

.method public final B0(Lw2/i0;Ljava/lang/Object;Lp2/p;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<R:",
            "Ljava/lang/Object;",
            ">(",
            "Lw2/i0;",
            "TR;",
            "Lp2/p<",
            "-TR;-",
            "Li2/d<",
            "-TT;>;+",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    invoke-virtual {p1, p3, p2, p0}, Lw2/i0;->b(Lp2/p;Ljava/lang/Object;Li2/d;)V

    return-void
.end method

.method protected H()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lw2/k0;->a(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " was cancelled"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final W(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lw2/a;->d:Li2/g;

    invoke-static {v0, p1}, Lw2/f0;->a(Li2/g;Ljava/lang/Throwable;)V

    return-void
.end method

.method public d0()Ljava/lang/String;
    .registers 4

    iget-object v0, p0, Lw2/a;->d:Li2/g;

    invoke-static {v0}, Lw2/b0;->b(Li2/g;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_d

    invoke-super {p0}, Lw2/s1;->d0()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_d
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v2, 0x22

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "\":"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-super {p0}, Lw2/s1;->d0()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getContext()Li2/g;
    .registers 2

    iget-object v0, p0, Lw2/a;->d:Li2/g;

    return-object v0
.end method

.method protected final i0(Ljava/lang/Object;)V
    .registers 3

    instance-of v0, p1, Lw2/v;

    if-eqz v0, :cond_10

    check-cast p1, Lw2/v;

    iget-object v0, p1, Lw2/v;->a:Ljava/lang/Throwable;

    invoke-virtual {p1}, Lw2/v;->a()Z

    move-result p1

    invoke-virtual {p0, v0, p1}, Lw2/a;->z0(Ljava/lang/Throwable;Z)V

    goto :goto_13

    :cond_10
    invoke-virtual {p0, p1}, Lw2/a;->A0(Ljava/lang/Object;)V

    :goto_13
    return-void
.end method

.method public isActive()Z
    .registers 2

    invoke-super {p0}, Lw2/s1;->isActive()Z

    move-result v0

    return v0
.end method

.method public p()Li2/g;
    .registers 2

    iget-object v0, p0, Lw2/a;->d:Li2/g;

    return-object v0
.end method

.method public final resumeWith(Ljava/lang/Object;)V
    .registers 4

    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-static {p1, v0, v1, v0}, Lw2/z;->d(Ljava/lang/Object;Lp2/l;ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {p0, p1}, Lw2/s1;->b0(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    sget-object v0, Lw2/t1;->b:Lkotlinx/coroutines/internal/b0;

    if-ne p1, v0, :cond_f

    return-void

    :cond_f
    invoke-virtual {p0, p1}, Lw2/a;->y0(Ljava/lang/Object;)V

    return-void
.end method

.method protected y0(Ljava/lang/Object;)V
    .registers 2

    invoke-virtual {p0, p1}, Lw2/s1;->C(Ljava/lang/Object;)V

    return-void
.end method

.method protected z0(Ljava/lang/Throwable;Z)V
    .registers 3

    return-void
.end method
