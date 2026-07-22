.class public Lc0/g;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lc0/g$w;,
        Lc0/g$x;,
        Lc0/g$c0;,
        Lc0/g$s;,
        Lc0/g$f1;,
        Lc0/g$o;,
        Lc0/g$y;,
        Lc0/g$e;,
        Lc0/g$q0;,
        Lc0/g$m0;,
        Lc0/g$d0;,
        Lc0/g$j;,
        Lc0/g$r;,
        Lc0/g$t0;,
        Lc0/g$s0;,
        Lc0/g$z0;,
        Lc0/g$u0;,
        Lc0/g$c1;,
        Lc0/g$v0;,
        Lc0/g$w0;,
        Lc0/g$a1;,
        Lc0/g$y0;,
        Lc0/g$x0;,
        Lc0/g$b1;,
        Lc0/g$a0;,
        Lc0/g$z;,
        Lc0/g$q;,
        Lc0/g$i;,
        Lc0/g$d;,
        Lc0/g$b0;,
        Lc0/g$v;,
        Lc0/g$e1;,
        Lc0/g$l;,
        Lc0/g$h;,
        Lc0/g$t;,
        Lc0/g$m;,
        Lc0/g$f0;,
        Lc0/g$r0;,
        Lc0/g$p0;,
        Lc0/g$n;,
        Lc0/g$h0;,
        Lc0/g$j0;,
        Lc0/g$i0;,
        Lc0/g$g0;,
        Lc0/g$k0;,
        Lc0/g$l0;,
        Lc0/g$n0;,
        Lc0/g$c;,
        Lc0/g$p;,
        Lc0/g$u;,
        Lc0/g$g;,
        Lc0/g$f;,
        Lc0/g$o0;,
        Lc0/g$e0;,
        Lc0/g$b;,
        Lc0/g$k;,
        Lc0/g$d1;
    }
.end annotation


# static fields
.field private static g:Z = true


# instance fields
.field private a:Lc0/g$f0;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:F

.field private e:Lc0/b$r;

.field private f:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Lc0/g$l0;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lc0/g;->a:Lc0/g$f0;

    const-string v0, ""

    iput-object v0, p0, Lc0/g;->b:Ljava/lang/String;

    iput-object v0, p0, Lc0/g;->c:Ljava/lang/String;

    const/high16 v0, 0x42c00000    # 96.0f

    iput v0, p0, Lc0/g;->d:F

    new-instance v0, Lc0/b$r;

    invoke-direct {v0}, Lc0/b$r;-><init>()V

    iput-object v0, p0, Lc0/g;->e:Lc0/b$r;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lc0/g;->f:Ljava/util/Map;

    return-void
.end method

.method private c(Ljava/lang/String;)Ljava/lang/String;
    .registers 5

    const-string v0, "\""

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    const/4 v2, 0x1

    if-eqz v1, :cond_1f

    invoke-virtual {p1, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1f

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    sub-int/2addr v1, v2

    invoke-virtual {p1, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    const-string v1, "\\\""

    :goto_1a
    invoke-virtual {p1, v1, v0}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p1

    goto :goto_39

    :cond_1f
    const-string v0, "\'"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_39

    invoke-virtual {p1, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_39

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    sub-int/2addr v1, v2

    invoke-virtual {p1, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    const-string v1, "\\\'"

    goto :goto_1a

    :cond_39
    :goto_39
    const-string v0, "\\\n"

    const-string v1, ""

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p1

    const-string v0, "\\A"

    const-string v1, "\n"

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method private e(Lc0/g$j0;Ljava/lang/String;)Lc0/g$l0;
    .registers 6

    move-object v0, p1

    check-cast v0, Lc0/g$l0;

    iget-object v1, v0, Lc0/g$l0;->c:Ljava/lang/String;

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_c

    return-object v0

    :cond_c
    invoke-interface {p1}, Lc0/g$j0;->a()Ljava/util/List;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_14
    :goto_14
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3e

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lc0/g$n0;

    instance-of v1, v0, Lc0/g$l0;

    if-nez v1, :cond_25

    goto :goto_14

    :cond_25
    move-object v1, v0

    check-cast v1, Lc0/g$l0;

    iget-object v2, v1, Lc0/g$l0;->c:Ljava/lang/String;

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_31

    return-object v1

    :cond_31
    instance-of v1, v0, Lc0/g$j0;

    if-eqz v1, :cond_14

    check-cast v0, Lc0/g$j0;

    invoke-direct {p0, v0, p2}, Lc0/g;->e(Lc0/g$j0;Ljava/lang/String;)Lc0/g$l0;

    move-result-object v0

    if-eqz v0, :cond_14

    return-object v0

    :cond_3e
    const/4 p1, 0x0

    return-object p1
.end method

.method static g()Lc0/i;
    .registers 1

    const/4 v0, 0x0

    return-object v0
.end method

.method public static h(Ljava/io/InputStream;)Lc0/g;
    .registers 3

    new-instance v0, Lc0/k;

    invoke-direct {v0}, Lc0/k;-><init>()V

    sget-boolean v1, Lc0/g;->g:Z

    invoke-virtual {v0, p0, v1}, Lc0/k;->z(Ljava/io/InputStream;Z)Lc0/g;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method a(Lc0/b$r;)V
    .registers 3

    iget-object v0, p0, Lc0/g;->e:Lc0/b$r;

    invoke-virtual {v0, p1}, Lc0/b$r;->b(Lc0/b$r;)V

    return-void
.end method

.method b()V
    .registers 3

    iget-object v0, p0, Lc0/g;->e:Lc0/b$r;

    sget-object v1, Lc0/b$u;->d:Lc0/b$u;

    invoke-virtual {v0, v1}, Lc0/b$r;->e(Lc0/b$u;)V

    return-void
.end method

.method d()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lc0/b$p;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lc0/g;->e:Lc0/b$r;

    invoke-virtual {v0}, Lc0/b$r;->c()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method f(Ljava/lang/String;)Lc0/g$l0;
    .registers 4

    if-eqz p1, :cond_33

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_33

    :cond_9
    iget-object v0, p0, Lc0/g;->a:Lc0/g$f0;

    iget-object v0, v0, Lc0/g$l0;->c:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    iget-object p1, p0, Lc0/g;->a:Lc0/g$f0;

    return-object p1

    :cond_16
    iget-object v0, p0, Lc0/g;->f:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_27

    iget-object v0, p0, Lc0/g;->f:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lc0/g$l0;

    return-object p1

    :cond_27
    iget-object v0, p0, Lc0/g;->a:Lc0/g$f0;

    invoke-direct {p0, v0, p1}, Lc0/g;->e(Lc0/g$j0;Ljava/lang/String;)Lc0/g$l0;

    move-result-object v0

    iget-object v1, p0, Lc0/g;->f:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-object v0

    :cond_33
    :goto_33
    const/4 p1, 0x0

    return-object p1
.end method

.method i()Lc0/g$f0;
    .registers 2

    iget-object v0, p0, Lc0/g;->a:Lc0/g$f0;

    return-object v0
.end method

.method j()Z
    .registers 2

    iget-object v0, p0, Lc0/g;->e:Lc0/b$r;

    invoke-virtual {v0}, Lc0/b$r;->d()Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    return v0
.end method

.method public k()Landroid/graphics/Picture;
    .registers 2

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lc0/g;->m(Lc0/f;)Landroid/graphics/Picture;

    move-result-object v0

    return-object v0
.end method

.method public l(IILc0/f;)Landroid/graphics/Picture;
    .registers 7

    new-instance v0, Landroid/graphics/Picture;

    invoke-direct {v0}, Landroid/graphics/Picture;-><init>()V

    invoke-virtual {v0, p1, p2}, Landroid/graphics/Picture;->beginRecording(II)Landroid/graphics/Canvas;

    move-result-object v1

    if-eqz p3, :cond_f

    iget-object v2, p3, Lc0/f;->f:Lc0/g$b;

    if-nez v2, :cond_23

    :cond_f
    if-nez p3, :cond_17

    new-instance p3, Lc0/f;

    invoke-direct {p3}, Lc0/f;-><init>()V

    goto :goto_1d

    :cond_17
    new-instance v2, Lc0/f;

    invoke-direct {v2, p3}, Lc0/f;-><init>(Lc0/f;)V

    move-object p3, v2

    :goto_1d
    int-to-float p1, p1

    int-to-float p2, p2

    const/4 v2, 0x0

    invoke-virtual {p3, v2, v2, p1, p2}, Lc0/f;->g(FFFF)Lc0/f;

    :cond_23
    new-instance p1, Lc0/h;

    iget p2, p0, Lc0/g;->d:F

    invoke-direct {p1, v1, p2}, Lc0/h;-><init>(Landroid/graphics/Canvas;F)V

    invoke-virtual {p1, p0, p3}, Lc0/h;->G0(Lc0/g;Lc0/f;)V

    invoke-virtual {v0}, Landroid/graphics/Picture;->endRecording()V

    return-object v0
.end method

.method public m(Lc0/f;)Landroid/graphics/Picture;
    .registers 7

    if-eqz p1, :cond_b

    invoke-virtual {p1}, Lc0/f;->e()Z

    move-result v0

    if-eqz v0, :cond_b

    iget-object v0, p1, Lc0/f;->d:Lc0/g$b;

    goto :goto_f

    :cond_b
    iget-object v0, p0, Lc0/g;->a:Lc0/g$f0;

    iget-object v0, v0, Lc0/g$r0;->p:Lc0/g$b;

    :goto_f
    if-eqz p1, :cond_34

    invoke-virtual {p1}, Lc0/f;->f()Z

    move-result v1

    if-eqz v1, :cond_34

    iget-object v0, p1, Lc0/f;->f:Lc0/g$b;

    invoke-virtual {v0}, Lc0/g$b;->b()F

    move-result v0

    iget-object v1, p1, Lc0/f;->f:Lc0/g$b;

    invoke-virtual {v1}, Lc0/g$b;->c()F

    move-result v1

    float-to-double v2, v0

    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    double-to-int v0, v2

    float-to-double v1, v1

    invoke-static {v1, v2}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v1

    double-to-int v1, v1

    invoke-virtual {p0, v0, v1, p1}, Lc0/g;->l(IILc0/f;)Landroid/graphics/Picture;

    move-result-object p1

    return-object p1

    :cond_34
    iget-object v1, p0, Lc0/g;->a:Lc0/g$f0;

    iget-object v2, v1, Lc0/g$f0;->s:Lc0/g$p;

    if-eqz v2, :cond_69

    iget-object v3, v2, Lc0/g$p;->d:Lc0/g$d1;

    sget-object v4, Lc0/g$d1;->l:Lc0/g$d1;

    if-eq v3, v4, :cond_69

    iget-object v3, v1, Lc0/g$f0;->t:Lc0/g$p;

    if-eqz v3, :cond_69

    iget-object v3, v3, Lc0/g$p;->d:Lc0/g$d1;

    if-eq v3, v4, :cond_69

    iget v0, p0, Lc0/g;->d:F

    invoke-virtual {v2, v0}, Lc0/g$p;->b(F)F

    move-result v0

    iget-object v1, p0, Lc0/g;->a:Lc0/g$f0;

    iget-object v1, v1, Lc0/g$f0;->t:Lc0/g$p;

    iget v2, p0, Lc0/g;->d:F

    invoke-virtual {v1, v2}, Lc0/g$p;->b(F)F

    move-result v1

    float-to-double v2, v0

    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    double-to-int v0, v2

    float-to-double v1, v1

    invoke-static {v1, v2}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v1

    double-to-int v1, v1

    invoke-virtual {p0, v0, v1, p1}, Lc0/g;->l(IILc0/f;)Landroid/graphics/Picture;

    move-result-object p1

    return-object p1

    :cond_69
    if-eqz v2, :cond_8b

    if-eqz v0, :cond_8b

    iget v1, p0, Lc0/g;->d:F

    invoke-virtual {v2, v1}, Lc0/g$p;->b(F)F

    move-result v1

    iget v2, v0, Lc0/g$b;->d:F

    mul-float v2, v2, v1

    iget v0, v0, Lc0/g$b;->c:F

    div-float/2addr v2, v0

    float-to-double v0, v1

    invoke-static {v0, v1}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v0

    double-to-int v0, v0

    float-to-double v1, v2

    invoke-static {v1, v2}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v1

    double-to-int v1, v1

    invoke-virtual {p0, v0, v1, p1}, Lc0/g;->l(IILc0/f;)Landroid/graphics/Picture;

    move-result-object p1

    return-object p1

    :cond_8b
    iget-object v1, v1, Lc0/g$f0;->t:Lc0/g$p;

    if-eqz v1, :cond_af

    if-eqz v0, :cond_af

    iget v2, p0, Lc0/g;->d:F

    invoke-virtual {v1, v2}, Lc0/g$p;->b(F)F

    move-result v1

    iget v2, v0, Lc0/g$b;->c:F

    mul-float v2, v2, v1

    iget v0, v0, Lc0/g$b;->d:F

    div-float/2addr v2, v0

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    double-to-int v0, v2

    float-to-double v1, v1

    invoke-static {v1, v2}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v1

    double-to-int v1, v1

    invoke-virtual {p0, v0, v1, p1}, Lc0/g;->l(IILc0/f;)Landroid/graphics/Picture;

    move-result-object p1

    return-object p1

    :cond_af
    const/16 v0, 0x200

    invoke-virtual {p0, v0, v0, p1}, Lc0/g;->l(IILc0/f;)Landroid/graphics/Picture;

    move-result-object p1

    return-object p1
.end method

.method n(Ljava/lang/String;)Lc0/g$n0;
    .registers 5

    const/4 v0, 0x0

    if-nez p1, :cond_4

    return-object v0

    :cond_4
    invoke-direct {p0, p1}, Lc0/g;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x1

    if-le v1, v2, :cond_20

    const-string v1, "#"

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_20

    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Lc0/g;->f(Ljava/lang/String;)Lc0/g$l0;

    move-result-object p1

    return-object p1

    :cond_20
    return-object v0
.end method

.method o(Ljava/lang/String;)V
    .registers 2

    iput-object p1, p0, Lc0/g;->c:Ljava/lang/String;

    return-void
.end method

.method p(Lc0/g$f0;)V
    .registers 2

    iput-object p1, p0, Lc0/g;->a:Lc0/g$f0;

    return-void
.end method

.method q(Ljava/lang/String;)V
    .registers 2

    iput-object p1, p0, Lc0/g;->b:Ljava/lang/String;

    return-void
.end method
