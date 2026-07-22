.class public final Landroidx/core/location/m;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/location/m$b;,
        Landroidx/core/location/m$a;,
        Landroidx/core/location/m$c;
    }
.end annotation


# instance fields
.field final a:I

.field final b:J

.field final c:J

.field final d:J

.field final e:I

.field final f:F

.field final g:J


# direct methods
.method constructor <init>(JIJIJFJ)V
    .registers 12

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide p1, p0, Landroidx/core/location/m;->b:J

    iput p3, p0, Landroidx/core/location/m;->a:I

    iput-wide p7, p0, Landroidx/core/location/m;->c:J

    iput-wide p4, p0, Landroidx/core/location/m;->d:J

    iput p6, p0, Landroidx/core/location/m;->e:I

    iput p9, p0, Landroidx/core/location/m;->f:F

    iput-wide p10, p0, Landroidx/core/location/m;->g:J

    return-void
.end method


# virtual methods
.method public a()J
    .registers 3

    iget-wide v0, p0, Landroidx/core/location/m;->d:J

    return-wide v0
.end method

.method public b()J
    .registers 3

    iget-wide v0, p0, Landroidx/core/location/m;->b:J

    return-wide v0
.end method

.method public c()J
    .registers 3

    iget-wide v0, p0, Landroidx/core/location/m;->g:J

    return-wide v0
.end method

.method public d()I
    .registers 2

    iget v0, p0, Landroidx/core/location/m;->e:I

    return v0
.end method

.method public e()F
    .registers 2

    iget v0, p0, Landroidx/core/location/m;->f:F

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 9

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Landroidx/core/location/m;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Landroidx/core/location/m;

    iget v1, p0, Landroidx/core/location/m;->a:I

    iget v3, p1, Landroidx/core/location/m;->a:I

    if-ne v1, v3, :cond_43

    iget-wide v3, p0, Landroidx/core/location/m;->b:J

    iget-wide v5, p1, Landroidx/core/location/m;->b:J

    cmp-long v1, v3, v5

    if-nez v1, :cond_43

    iget-wide v3, p0, Landroidx/core/location/m;->c:J

    iget-wide v5, p1, Landroidx/core/location/m;->c:J

    cmp-long v1, v3, v5

    if-nez v1, :cond_43

    iget-wide v3, p0, Landroidx/core/location/m;->d:J

    iget-wide v5, p1, Landroidx/core/location/m;->d:J

    cmp-long v1, v3, v5

    if-nez v1, :cond_43

    iget v1, p0, Landroidx/core/location/m;->e:I

    iget v3, p1, Landroidx/core/location/m;->e:I

    if-ne v1, v3, :cond_43

    iget v1, p1, Landroidx/core/location/m;->f:F

    iget v3, p0, Landroidx/core/location/m;->f:F

    invoke-static {v1, v3}, Ljava/lang/Float;->compare(FF)I

    move-result v1

    if-nez v1, :cond_43

    iget-wide v3, p0, Landroidx/core/location/m;->g:J

    iget-wide v5, p1, Landroidx/core/location/m;->g:J

    cmp-long p1, v3, v5

    if-nez p1, :cond_43

    goto :goto_44

    :cond_43
    const/4 v0, 0x0

    :goto_44
    return v0
.end method

.method public f()J
    .registers 6

    iget-wide v0, p0, Landroidx/core/location/m;->c:J

    const-wide/16 v2, -0x1

    cmp-long v4, v0, v2

    if-nez v4, :cond_a

    iget-wide v0, p0, Landroidx/core/location/m;->b:J

    :cond_a
    return-wide v0
.end method

.method public g()I
    .registers 2

    iget v0, p0, Landroidx/core/location/m;->a:I

    return v0
.end method

.method public h()Landroid/location/LocationRequest;
    .registers 2

    invoke-static {p0}, Landroidx/core/location/m$b;->a(Landroidx/core/location/m;)Landroid/location/LocationRequest;

    move-result-object v0

    return-object v0
.end method

.method public hashCode()I
    .registers 7

    iget v0, p0, Landroidx/core/location/m;->a:I

    mul-int/lit8 v0, v0, 0x1f

    iget-wide v1, p0, Landroidx/core/location/m;->b:J

    const/16 v3, 0x20

    ushr-long v4, v1, v3

    xor-long/2addr v1, v4

    long-to-int v2, v1

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-wide v1, p0, Landroidx/core/location/m;->c:J

    ushr-long v3, v1, v3

    xor-long/2addr v1, v3

    long-to-int v2, v1

    add-int/2addr v0, v2

    return v0
.end method

.method public i(Ljava/lang/String;)Landroid/location/LocationRequest;
    .registers 4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1f

    if-lt v0, v1, :cond_b

    invoke-virtual {p0}, Landroidx/core/location/m;->h()Landroid/location/LocationRequest;

    move-result-object p1

    return-object p1

    :cond_b
    invoke-static {p0, p1}, Landroidx/core/location/m$a;->a(Landroidx/core/location/m;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/location/LocationRequest;

    return-object p1
.end method

.method public toString()Ljava/lang/String;
    .registers 7

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Request["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Landroidx/core/location/m;->b:J

    const-wide v3, 0x7fffffffffffffffL

    cmp-long v5, v1, v3

    if-eqz v5, :cond_37

    const-string v1, "@"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Landroidx/core/location/m;->b:J

    invoke-static {v1, v2, v0}, Landroidx/core/util/f;->b(JLjava/lang/StringBuilder;)V

    iget v1, p0, Landroidx/core/location/m;->a:I

    const/16 v2, 0x64

    if-eq v1, v2, :cond_34

    const/16 v2, 0x66

    if-eq v1, v2, :cond_31

    const/16 v2, 0x68

    if-eq v1, v2, :cond_2e

    goto :goto_3c

    :cond_2e
    const-string v1, " LOW_POWER"

    goto :goto_39

    :cond_31
    const-string v1, " BALANCED"

    goto :goto_39

    :cond_34
    const-string v1, " HIGH_ACCURACY"

    goto :goto_39

    :cond_37
    const-string v1, "PASSIVE"

    :goto_39
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :goto_3c
    iget-wide v1, p0, Landroidx/core/location/m;->d:J

    cmp-long v5, v1, v3

    if-eqz v5, :cond_4c

    const-string v1, ", duration="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Landroidx/core/location/m;->d:J

    invoke-static {v1, v2, v0}, Landroidx/core/util/f;->b(JLjava/lang/StringBuilder;)V

    :cond_4c
    iget v1, p0, Landroidx/core/location/m;->e:I

    const v2, 0x7fffffff

    if-eq v1, v2, :cond_5d

    const-string v1, ", maxUpdates="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Landroidx/core/location/m;->e:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    :cond_5d
    iget-wide v1, p0, Landroidx/core/location/m;->c:J

    const-wide/16 v3, -0x1

    cmp-long v5, v1, v3

    if-eqz v5, :cond_75

    iget-wide v3, p0, Landroidx/core/location/m;->b:J

    cmp-long v5, v1, v3

    if-gez v5, :cond_75

    const-string v1, ", minUpdateInterval="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Landroidx/core/location/m;->c:J

    invoke-static {v1, v2, v0}, Landroidx/core/util/f;->b(JLjava/lang/StringBuilder;)V

    :cond_75
    iget v1, p0, Landroidx/core/location/m;->f:F

    float-to-double v1, v1

    const-wide/16 v3, 0x0

    cmpl-double v5, v1, v3

    if-lez v5, :cond_88

    const-string v1, ", minUpdateDistance="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Landroidx/core/location/m;->f:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    :cond_88
    iget-wide v1, p0, Landroidx/core/location/m;->g:J

    const-wide/16 v3, 0x2

    div-long/2addr v1, v3

    iget-wide v3, p0, Landroidx/core/location/m;->b:J

    cmp-long v5, v1, v3

    if-lez v5, :cond_9d

    const-string v1, ", maxUpdateDelay="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Landroidx/core/location/m;->g:J

    invoke-static {v1, v2, v0}, Landroidx/core/util/f;->b(JLjava/lang/StringBuilder;)V

    :cond_9d
    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
