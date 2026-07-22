.class Lc0/k$i;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "i"
.end annotation


# instance fields
.field a:Ljava/lang/String;

.field b:I

.field c:I

.field private d:Lc0/d;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lc0/k$i;->b:I

    iput v0, p0, Lc0/k$i;->c:I

    new-instance v0, Lc0/d;

    invoke-direct {v0}, Lc0/d;-><init>()V

    iput-object v0, p0, Lc0/k$i;->d:Lc0/d;

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lc0/k$i;->a:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result p1

    iput p1, p0, Lc0/k$i;->c:I

    return-void
.end method


# virtual methods
.method A()V
    .registers 3

    :goto_0
    iget v0, p0, Lc0/k$i;->b:I

    iget v1, p0, Lc0/k$i;->c:I

    if-ge v0, v1, :cond_1a

    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    invoke-virtual {p0, v0}, Lc0/k$i;->k(I)Z

    move-result v0

    if-nez v0, :cond_13

    goto :goto_1a

    :cond_13
    iget v0, p0, Lc0/k$i;->b:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lc0/k$i;->b:I

    goto :goto_0

    :cond_1a
    :goto_1a
    return-void
.end method

.method a()I
    .registers 4

    iget v0, p0, Lc0/k$i;->b:I

    iget v1, p0, Lc0/k$i;->c:I

    const/4 v2, -0x1

    if-ne v0, v1, :cond_8

    return v2

    :cond_8
    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lc0/k$i;->b:I

    if-ge v0, v1, :cond_15

    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    return v0

    :cond_15
    return v2
.end method

.method b()Ljava/lang/String;
    .registers 4

    iget v0, p0, Lc0/k$i;->b:I

    :goto_2
    invoke-virtual {p0}, Lc0/k$i;->h()Z

    move-result v1

    if-nez v1, :cond_1d

    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    iget v2, p0, Lc0/k$i;->b:I

    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v1

    invoke-virtual {p0, v1}, Lc0/k$i;->k(I)Z

    move-result v1

    if-nez v1, :cond_1d

    iget v1, p0, Lc0/k$i;->b:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lc0/k$i;->b:I

    goto :goto_2

    :cond_1d
    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    iget v2, p0, Lc0/k$i;->b:I

    invoke-virtual {v1, v0, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    iput v0, p0, Lc0/k$i;->b:I

    return-object v1
.end method

.method c(Ljava/lang/Object;)Ljava/lang/Boolean;
    .registers 2

    if-nez p1, :cond_4

    const/4 p1, 0x0

    return-object p1

    :cond_4
    invoke-virtual {p0}, Lc0/k$i;->z()Z

    invoke-virtual {p0}, Lc0/k$i;->m()Ljava/lang/Boolean;

    move-result-object p1

    return-object p1
.end method

.method d(F)F
    .registers 2

    invoke-static {p1}, Ljava/lang/Float;->isNaN(F)Z

    move-result p1

    if-eqz p1, :cond_9

    const/high16 p1, 0x7fc00000    # Float.NaN

    return p1

    :cond_9
    invoke-virtual {p0}, Lc0/k$i;->z()Z

    invoke-virtual {p0}, Lc0/k$i;->n()F

    move-result p1

    return p1
.end method

.method e(Ljava/lang/Boolean;)F
    .registers 2

    if-nez p1, :cond_5

    const/high16 p1, 0x7fc00000    # Float.NaN

    return p1

    :cond_5
    invoke-virtual {p0}, Lc0/k$i;->z()Z

    invoke-virtual {p0}, Lc0/k$i;->n()F

    move-result p1

    return p1
.end method

.method f(C)Z
    .registers 5

    iget v0, p0, Lc0/k$i;->b:I

    iget v1, p0, Lc0/k$i;->c:I

    const/4 v2, 0x1

    if-ge v0, v1, :cond_11

    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-ne v0, p1, :cond_11

    const/4 p1, 0x1

    goto :goto_12

    :cond_11
    const/4 p1, 0x0

    :goto_12
    if-eqz p1, :cond_19

    iget v0, p0, Lc0/k$i;->b:I

    add-int/2addr v0, v2

    iput v0, p0, Lc0/k$i;->b:I

    :cond_19
    return p1
.end method

.method g(Ljava/lang/String;)Z
    .registers 6

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    iget v1, p0, Lc0/k$i;->b:I

    iget v2, p0, Lc0/k$i;->c:I

    sub-int/2addr v2, v0

    if-gt v1, v2, :cond_1b

    iget-object v2, p0, Lc0/k$i;->a:Ljava/lang/String;

    add-int v3, v1, v0

    invoke-virtual {v2, v1, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_1b

    const/4 p1, 0x1

    goto :goto_1c

    :cond_1b
    const/4 p1, 0x0

    :goto_1c
    if-eqz p1, :cond_23

    iget v1, p0, Lc0/k$i;->b:I

    add-int/2addr v1, v0

    iput v1, p0, Lc0/k$i;->b:I

    :cond_23
    return p1
.end method

.method h()Z
    .registers 3

    iget v0, p0, Lc0/k$i;->b:I

    iget v1, p0, Lc0/k$i;->c:I

    if-ne v0, v1, :cond_8

    const/4 v0, 0x1

    goto :goto_9

    :cond_8
    const/4 v0, 0x0

    :goto_9
    return v0
.end method

.method i()Z
    .registers 4

    iget v0, p0, Lc0/k$i;->b:I

    iget v1, p0, Lc0/k$i;->c:I

    const/4 v2, 0x0

    if-ne v0, v1, :cond_8

    return v2

    :cond_8
    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x61

    if-lt v0, v1, :cond_16

    const/16 v1, 0x7a

    if-le v0, v1, :cond_1e

    :cond_16
    const/16 v1, 0x41

    if-lt v0, v1, :cond_1f

    const/16 v1, 0x5a

    if-gt v0, v1, :cond_1f

    :cond_1e
    const/4 v2, 0x1

    :cond_1f
    return v2
.end method

.method j(I)Z
    .registers 3

    const/16 v0, 0xa

    if-eq p1, v0, :cond_b

    const/16 v0, 0xd

    if-ne p1, v0, :cond_9

    goto :goto_b

    :cond_9
    const/4 p1, 0x0

    goto :goto_c

    :cond_b
    :goto_b
    const/4 p1, 0x1

    :goto_c
    return p1
.end method

.method k(I)Z
    .registers 3

    const/16 v0, 0x20

    if-eq p1, v0, :cond_13

    const/16 v0, 0xa

    if-eq p1, v0, :cond_13

    const/16 v0, 0xd

    if-eq p1, v0, :cond_13

    const/16 v0, 0x9

    if-ne p1, v0, :cond_11

    goto :goto_13

    :cond_11
    const/4 p1, 0x0

    goto :goto_14

    :cond_13
    :goto_13
    const/4 p1, 0x1

    :goto_14
    return p1
.end method

.method l()Ljava/lang/Integer;
    .registers 4

    iget v0, p0, Lc0/k$i;->b:I

    iget v1, p0, Lc0/k$i;->c:I

    if-ne v0, v1, :cond_8

    const/4 v0, 0x0

    return-object v0

    :cond_8
    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    add-int/lit8 v2, v0, 0x1

    iput v2, p0, Lc0/k$i;->b:I

    invoke-virtual {v1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method m()Ljava/lang/Boolean;
    .registers 5

    iget v0, p0, Lc0/k$i;->b:I

    iget v1, p0, Lc0/k$i;->c:I

    const/4 v2, 0x0

    if-ne v0, v1, :cond_8

    return-object v2

    :cond_8
    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x30

    const/16 v3, 0x31

    if-eq v0, v1, :cond_18

    if-ne v0, v3, :cond_17

    goto :goto_18

    :cond_17
    return-object v2

    :cond_18
    :goto_18
    iget v1, p0, Lc0/k$i;->b:I

    const/4 v2, 0x1

    add-int/2addr v1, v2

    iput v1, p0, Lc0/k$i;->b:I

    if-ne v0, v3, :cond_21

    goto :goto_22

    :cond_21
    const/4 v2, 0x0

    :goto_22
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method n()F
    .registers 5

    iget-object v0, p0, Lc0/k$i;->d:Lc0/d;

    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    iget v2, p0, Lc0/k$i;->b:I

    iget v3, p0, Lc0/k$i;->c:I

    invoke-virtual {v0, v1, v2, v3}, Lc0/d;->b(Ljava/lang/String;II)F

    move-result v0

    invoke-static {v0}, Ljava/lang/Float;->isNaN(F)Z

    move-result v1

    if-nez v1, :cond_1a

    iget-object v1, p0, Lc0/k$i;->d:Lc0/d;

    invoke-virtual {v1}, Lc0/d;->a()I

    move-result v1

    iput v1, p0, Lc0/k$i;->b:I

    :cond_1a
    return v0
.end method

.method o()Ljava/lang/String;
    .registers 6

    invoke-virtual {p0}, Lc0/k$i;->h()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_8

    return-object v1

    :cond_8
    iget v0, p0, Lc0/k$i;->b:I

    iget-object v2, p0, Lc0/k$i;->a:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    :goto_10
    const/16 v3, 0x61

    if-lt v2, v3, :cond_18

    const/16 v3, 0x7a

    if-le v2, v3, :cond_20

    :cond_18
    const/16 v3, 0x41

    if-lt v2, v3, :cond_25

    const/16 v3, 0x5a

    if-gt v2, v3, :cond_25

    :cond_20
    invoke-virtual {p0}, Lc0/k$i;->a()I

    move-result v2

    goto :goto_10

    :cond_25
    iget v3, p0, Lc0/k$i;->b:I

    :goto_27
    invoke-virtual {p0, v2}, Lc0/k$i;->k(I)Z

    move-result v4

    if-eqz v4, :cond_32

    invoke-virtual {p0}, Lc0/k$i;->a()I

    move-result v2

    goto :goto_27

    :cond_32
    const/16 v4, 0x28

    if-ne v2, v4, :cond_43

    iget v1, p0, Lc0/k$i;->b:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lc0/k$i;->b:I

    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    invoke-virtual {v1, v0, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_43
    iput v0, p0, Lc0/k$i;->b:I

    return-object v1
.end method

.method p()Lc0/g$p;
    .registers 4

    invoke-virtual {p0}, Lc0/k$i;->n()F

    move-result v0

    invoke-static {v0}, Ljava/lang/Float;->isNaN(F)Z

    move-result v1

    if-eqz v1, :cond_c

    const/4 v0, 0x0

    return-object v0

    :cond_c
    invoke-virtual {p0}, Lc0/k$i;->v()Lc0/g$d1;

    move-result-object v1

    if-nez v1, :cond_1a

    new-instance v1, Lc0/g$p;

    sget-object v2, Lc0/g$d1;->c:Lc0/g$d1;

    invoke-direct {v1, v0, v2}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    return-object v1

    :cond_1a
    new-instance v2, Lc0/g$p;

    invoke-direct {v2, v0, v1}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    return-object v2
.end method

.method q()Ljava/lang/String;
    .registers 6

    invoke-virtual {p0}, Lc0/k$i;->h()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_8

    return-object v1

    :cond_8
    iget v0, p0, Lc0/k$i;->b:I

    iget-object v2, p0, Lc0/k$i;->a:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x27

    if-eq v2, v3, :cond_19

    const/16 v3, 0x22

    if-eq v2, v3, :cond_19

    return-object v1

    :cond_19
    :goto_19
    invoke-virtual {p0}, Lc0/k$i;->a()I

    move-result v3

    const/4 v4, -0x1

    if-eq v3, v4, :cond_23

    if-eq v3, v2, :cond_23

    goto :goto_19

    :cond_23
    if-ne v3, v4, :cond_28

    iput v0, p0, Lc0/k$i;->b:I

    return-object v1

    :cond_28
    iget v1, p0, Lc0/k$i;->b:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lc0/k$i;->b:I

    iget-object v2, p0, Lc0/k$i;->a:Ljava/lang/String;

    add-int/lit8 v0, v0, 0x1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v2, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method r()Ljava/lang/String;
    .registers 3

    const/16 v0, 0x20

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lc0/k$i;->t(CZ)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method s(C)Ljava/lang/String;
    .registers 3

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lc0/k$i;->t(CZ)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method t(CZ)Ljava/lang/String;
    .registers 6

    invoke-virtual {p0}, Lc0/k$i;->h()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_8

    return-object v1

    :cond_8
    iget-object v0, p0, Lc0/k$i;->a:Ljava/lang/String;

    iget v2, p0, Lc0/k$i;->b:I

    invoke-virtual {v0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-nez p2, :cond_18

    invoke-virtual {p0, v0}, Lc0/k$i;->k(I)Z

    move-result v2

    if-nez v2, :cond_1a

    :cond_18
    if-ne v0, p1, :cond_1b

    :cond_1a
    return-object v1

    :cond_1b
    iget v0, p0, Lc0/k$i;->b:I

    :cond_1d
    invoke-virtual {p0}, Lc0/k$i;->a()I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_2f

    if-ne v1, p1, :cond_27

    goto :goto_2f

    :cond_27
    if-nez p2, :cond_1d

    invoke-virtual {p0, v1}, Lc0/k$i;->k(I)Z

    move-result v1

    if-eqz v1, :cond_1d

    :cond_2f
    :goto_2f
    iget-object p1, p0, Lc0/k$i;->a:Ljava/lang/String;

    iget p2, p0, Lc0/k$i;->b:I

    invoke-virtual {p1, v0, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method u(C)Ljava/lang/String;
    .registers 3

    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lc0/k$i;->t(CZ)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method v()Lc0/g$d1;
    .registers 5

    invoke-virtual {p0}, Lc0/k$i;->h()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_8

    return-object v1

    :cond_8
    iget-object v0, p0, Lc0/k$i;->a:Ljava/lang/String;

    iget v2, p0, Lc0/k$i;->b:I

    invoke-virtual {v0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v2, 0x25

    if-ne v0, v2, :cond_1d

    iget v0, p0, Lc0/k$i;->b:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lc0/k$i;->b:I

    sget-object v0, Lc0/g$d1;->l:Lc0/g$d1;

    return-object v0

    :cond_1d
    iget v0, p0, Lc0/k$i;->b:I

    iget v2, p0, Lc0/k$i;->c:I

    add-int/lit8 v2, v2, -0x2

    if-le v0, v2, :cond_26

    return-object v1

    :cond_26
    :try_start_26
    iget-object v2, p0, Lc0/k$i;->a:Ljava/lang/String;

    add-int/lit8 v3, v0, 0x2

    invoke-virtual {v2, v0, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v0, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lc0/g$d1;->valueOf(Ljava/lang/String;)Lc0/g$d1;

    move-result-object v0

    iget v2, p0, Lc0/k$i;->b:I

    add-int/lit8 v2, v2, 0x2

    iput v2, p0, Lc0/k$i;->b:I
    :try_end_3e
    .catch Ljava/lang/IllegalArgumentException; {:try_start_26 .. :try_end_3e} :catch_3f

    return-object v0

    :catch_3f
    return-object v1
.end method

.method w()Ljava/lang/String;
    .registers 8

    invoke-virtual {p0}, Lc0/k$i;->h()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_8

    return-object v1

    :cond_8
    iget v0, p0, Lc0/k$i;->b:I

    iget-object v2, p0, Lc0/k$i;->a:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x7a

    const/16 v4, 0x5a

    const/16 v5, 0x61

    const/16 v6, 0x41

    if-lt v2, v6, :cond_1c

    if-le v2, v4, :cond_20

    :cond_1c
    if-lt v2, v5, :cond_36

    if-gt v2, v3, :cond_36

    :cond_20
    :goto_20
    invoke-virtual {p0}, Lc0/k$i;->a()I

    move-result v1

    if-lt v1, v6, :cond_28

    if-le v1, v4, :cond_20

    :cond_28
    if-lt v1, v5, :cond_2d

    if-gt v1, v3, :cond_2d

    goto :goto_20

    :cond_2d
    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    iget v2, p0, Lc0/k$i;->b:I

    invoke-virtual {v1, v0, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_36
    iput v0, p0, Lc0/k$i;->b:I

    return-object v1
.end method

.method x()F
    .registers 5

    invoke-virtual {p0}, Lc0/k$i;->z()Z

    iget-object v0, p0, Lc0/k$i;->d:Lc0/d;

    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    iget v2, p0, Lc0/k$i;->b:I

    iget v3, p0, Lc0/k$i;->c:I

    invoke-virtual {v0, v1, v2, v3}, Lc0/d;->b(Ljava/lang/String;II)F

    move-result v0

    invoke-static {v0}, Ljava/lang/Float;->isNaN(F)Z

    move-result v1

    if-nez v1, :cond_1d

    iget-object v1, p0, Lc0/k$i;->d:Lc0/d;

    invoke-virtual {v1}, Lc0/d;->a()I

    move-result v1

    iput v1, p0, Lc0/k$i;->b:I

    :cond_1d
    return v0
.end method

.method y()Ljava/lang/String;
    .registers 3

    invoke-virtual {p0}, Lc0/k$i;->h()Z

    move-result v0

    if-eqz v0, :cond_8

    const/4 v0, 0x0

    return-object v0

    :cond_8
    iget v0, p0, Lc0/k$i;->b:I

    iget v1, p0, Lc0/k$i;->c:I

    iput v1, p0, Lc0/k$i;->b:I

    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method z()Z
    .registers 4

    invoke-virtual {p0}, Lc0/k$i;->A()V

    iget v0, p0, Lc0/k$i;->b:I

    iget v1, p0, Lc0/k$i;->c:I

    const/4 v2, 0x0

    if-ne v0, v1, :cond_b

    return v2

    :cond_b
    iget-object v1, p0, Lc0/k$i;->a:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x2c

    if-eq v0, v1, :cond_16

    return v2

    :cond_16
    iget v0, p0, Lc0/k$i;->b:I

    const/4 v1, 0x1

    add-int/2addr v0, v1

    iput v0, p0, Lc0/k$i;->b:I

    invoke-virtual {p0}, Lc0/k$i;->A()V

    return v1
.end method
