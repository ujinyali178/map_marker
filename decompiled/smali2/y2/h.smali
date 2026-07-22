.class public final Ly2/h;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static final a(ILy2/e;Lp2/l;)Ly2/f;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(I",
            "Ly2/e;",
            "Lp2/l<",
            "-TE;",
            "Lg2/q;",
            ">;)",
            "Ly2/f<",
            "TE;>;"
        }
    .end annotation

    const/4 v0, -0x2

    const/4 v1, 0x1

    if-eq p0, v0, :cond_51

    const/4 v0, -0x1

    if-eq p0, v0, :cond_37

    if-eqz p0, :cond_27

    const v0, 0x7fffffff

    if-eq p0, v0, :cond_21

    if-ne p0, v1, :cond_1a

    sget-object v0, Ly2/e;->d:Ly2/e;

    if-ne p1, v0, :cond_1a

    new-instance p0, Ly2/m;

    invoke-direct {p0, p2}, Ly2/m;-><init>(Lp2/l;)V

    goto :goto_60

    :cond_1a
    new-instance v0, Ly2/d;

    invoke-direct {v0, p0, p1, p2}, Ly2/d;-><init>(ILy2/e;Lp2/l;)V

    move-object p0, v0

    goto :goto_60

    :cond_21
    new-instance p0, Ly2/n;

    invoke-direct {p0, p2}, Ly2/n;-><init>(Lp2/l;)V

    goto :goto_60

    :cond_27
    sget-object p0, Ly2/e;->c:Ly2/e;

    if-ne p1, p0, :cond_31

    new-instance p0, Ly2/r;

    invoke-direct {p0, p2}, Ly2/r;-><init>(Lp2/l;)V

    goto :goto_60

    :cond_31
    new-instance p0, Ly2/d;

    invoke-direct {p0, v1, p1, p2}, Ly2/d;-><init>(ILy2/e;Lp2/l;)V

    goto :goto_60

    :cond_37
    sget-object p0, Ly2/e;->c:Ly2/e;

    if-ne p1, p0, :cond_3c

    goto :goto_3d

    :cond_3c
    const/4 v1, 0x0

    :goto_3d
    if-eqz v1, :cond_45

    new-instance p0, Ly2/m;

    invoke-direct {p0, p2}, Ly2/m;-><init>(Lp2/l;)V

    goto :goto_60

    :cond_45
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string p1, "CONFLATED capacity cannot be used with non-default onBufferOverflow"

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_51
    new-instance p0, Ly2/d;

    sget-object v0, Ly2/e;->c:Ly2/e;

    if-ne p1, v0, :cond_5d

    sget-object v0, Ly2/f;->a:Ly2/f$a;

    invoke-virtual {v0}, Ly2/f$a;->a()I

    move-result v1

    :cond_5d
    invoke-direct {p0, v1, p1, p2}, Ly2/d;-><init>(ILy2/e;Lp2/l;)V

    :goto_60
    return-object p0
.end method

.method public static synthetic b(ILy2/e;Lp2/l;ILjava/lang/Object;)Ly2/f;
    .registers 5

    and-int/lit8 p4, p3, 0x1

    if-eqz p4, :cond_5

    const/4 p0, 0x0

    :cond_5
    and-int/lit8 p4, p3, 0x2

    if-eqz p4, :cond_b

    sget-object p1, Ly2/e;->c:Ly2/e;

    :cond_b
    and-int/lit8 p3, p3, 0x4

    if-eqz p3, :cond_10

    const/4 p2, 0x0

    :cond_10
    invoke-static {p0, p1, p2}, Ly2/h;->a(ILy2/e;Lp2/l;)Ly2/f;

    move-result-object p0

    return-object p0
.end method
