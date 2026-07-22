.class public Lw2/o1;
.super Lw2/s1;
.source "SourceFile"

# interfaces
.implements Lw2/t;


# instance fields
.field private final d:Z


# direct methods
.method public constructor <init>(Lw2/l1;)V
    .registers 3

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lw2/s1;-><init>(Z)V

    invoke-virtual {p0, p1}, Lw2/s1;->X(Lw2/l1;)V

    invoke-direct {p0}, Lw2/o1;->y0()Z

    move-result p1

    iput-boolean p1, p0, Lw2/o1;->d:Z

    return-void
.end method

.method private final y0()Z
    .registers 5

    invoke-virtual {p0}, Lw2/s1;->T()Lw2/q;

    move-result-object v0

    instance-of v1, v0, Lw2/r;

    const/4 v2, 0x0

    if-eqz v1, :cond_c

    check-cast v0, Lw2/r;

    goto :goto_d

    :cond_c
    move-object v0, v2

    :goto_d
    const/4 v1, 0x0

    if-eqz v0, :cond_33

    invoke-virtual {v0}, Lw2/r1;->y()Lw2/s1;

    move-result-object v0

    if-nez v0, :cond_17

    goto :goto_33

    :cond_17
    invoke-virtual {v0}, Lw2/s1;->Q()Z

    move-result v3

    if-eqz v3, :cond_1f

    const/4 v0, 0x1

    return v0

    :cond_1f
    invoke-virtual {v0}, Lw2/s1;->T()Lw2/q;

    move-result-object v0

    instance-of v3, v0, Lw2/r;

    if-eqz v3, :cond_2a

    check-cast v0, Lw2/r;

    goto :goto_2b

    :cond_2a
    move-object v0, v2

    :goto_2b
    if-eqz v0, :cond_33

    invoke-virtual {v0}, Lw2/r1;->y()Lw2/s1;

    move-result-object v0

    if-nez v0, :cond_17

    :cond_33
    :goto_33
    return v1
.end method


# virtual methods
.method public Q()Z
    .registers 2

    iget-boolean v0, p0, Lw2/o1;->d:Z

    return v0
.end method

.method public R()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method
