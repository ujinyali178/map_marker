.class public final Landroidx/core/util/e;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:F

.field private final b:F


# direct methods
.method public constructor <init>(FF)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "width"

    invoke-static {p1, v0}, Landroidx/core/util/d;->b(FLjava/lang/String;)F

    move-result p1

    iput p1, p0, Landroidx/core/util/e;->a:F

    const-string p1, "height"

    invoke-static {p2, p1}, Landroidx/core/util/d;->b(FLjava/lang/String;)F

    move-result p1

    iput p1, p0, Landroidx/core/util/e;->b:F

    return-void
.end method


# virtual methods
.method public a()F
    .registers 2

    iget v0, p0, Landroidx/core/util/e;->b:F

    return v0
.end method

.method public b()F
    .registers 2

    iget v0, p0, Landroidx/core/util/e;->a:F

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Landroidx/core/util/e;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Landroidx/core/util/e;

    iget v1, p1, Landroidx/core/util/e;->a:F

    iget v3, p0, Landroidx/core/util/e;->a:F

    cmpl-float v1, v1, v3

    if-nez v1, :cond_1d

    iget p1, p1, Landroidx/core/util/e;->b:F

    iget v1, p0, Landroidx/core/util/e;->b:F

    cmpl-float p1, p1, v1

    if-nez p1, :cond_1d

    goto :goto_1e

    :cond_1d
    const/4 v0, 0x0

    :goto_1e
    return v0
.end method

.method public hashCode()I
    .registers 3

    iget v0, p0, Landroidx/core/util/e;->a:F

    invoke-static {v0}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v0

    iget v1, p0, Landroidx/core/util/e;->b:F

    invoke-static {v1}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v1

    xor-int/2addr v0, v1

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v1, p0, Landroidx/core/util/e;->a:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, "x"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Landroidx/core/util/e;->b:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
