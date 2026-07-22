.class public Lorg/mapsforge/core/model/Rectangle;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field public final bottom:D

.field public final left:D

.field public final right:D

.field public final top:D


# direct methods
.method public constructor <init>(DDDD)V
    .registers 10

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    cmpl-double v0, p1, p5

    if-gtz v0, :cond_33

    cmpl-double v0, p3, p7

    if-gtz v0, :cond_14

    iput-wide p1, p0, Lorg/mapsforge/core/model/Rectangle;->left:D

    iput-wide p3, p0, Lorg/mapsforge/core/model/Rectangle;->top:D

    iput-wide p5, p0, Lorg/mapsforge/core/model/Rectangle;->right:D

    iput-wide p7, p0, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    return-void

    :cond_14
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p5, "top: "

    invoke-virtual {p2, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, p3, p4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string p3, ", bottom: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, p7, p8}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_33
    new-instance p3, Ljava/lang/IllegalArgumentException;

    new-instance p4, Ljava/lang/StringBuilder;

    invoke-direct {p4}, Ljava/lang/StringBuilder;-><init>()V

    const-string p7, "left: "

    invoke-virtual {p4, p7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p4, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string p1, ", right: "

    invoke-virtual {p4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p4, p5, p6}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {p4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p3, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p3
.end method


# virtual methods
.method public contains(Lorg/mapsforge/core/model/Point;)Z
    .registers 7

    iget-wide v0, p0, Lorg/mapsforge/core/model/Rectangle;->left:D

    iget-wide v2, p1, Lorg/mapsforge/core/model/Point;->x:D

    cmpg-double v4, v0, v2

    if-gtz v4, :cond_1e

    iget-wide v0, p0, Lorg/mapsforge/core/model/Rectangle;->right:D

    cmpl-double v4, v0, v2

    if-ltz v4, :cond_1e

    iget-wide v0, p0, Lorg/mapsforge/core/model/Rectangle;->top:D

    iget-wide v2, p1, Lorg/mapsforge/core/model/Point;->y:D

    cmpg-double p1, v0, v2

    if-gtz p1, :cond_1e

    iget-wide v0, p0, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    cmpl-double p1, v0, v2

    if-ltz p1, :cond_1e

    const/4 p1, 0x1

    goto :goto_1f

    :cond_1e
    const/4 p1, 0x0

    :goto_1f
    return p1
.end method

.method public enlarge(DDDD)Lorg/mapsforge/core/model/Rectangle;
    .registers 20

    move-object v0, p0

    new-instance v10, Lorg/mapsforge/core/model/Rectangle;

    iget-wide v1, v0, Lorg/mapsforge/core/model/Rectangle;->left:D

    sub-double v2, v1, p1

    iget-wide v4, v0, Lorg/mapsforge/core/model/Rectangle;->top:D

    sub-double/2addr v4, p3

    iget-wide v6, v0, Lorg/mapsforge/core/model/Rectangle;->right:D

    add-double v6, v6, p5

    iget-wide v8, v0, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    add-double v8, v8, p7

    move-object v1, v10

    invoke-direct/range {v1 .. v9}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    return-object v10
.end method

.method public envelope(D)Lorg/mapsforge/core/model/Rectangle;
    .registers 13

    new-instance v9, Lorg/mapsforge/core/model/Rectangle;

    iget-wide v0, p0, Lorg/mapsforge/core/model/Rectangle;->left:D

    sub-double v1, v0, p1

    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->top:D

    sub-double/2addr v3, p1

    iget-wide v5, p0, Lorg/mapsforge/core/model/Rectangle;->right:D

    add-double/2addr v5, p1

    iget-wide v7, p0, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    add-double/2addr v7, p1

    move-object v0, v9

    invoke-direct/range {v0 .. v8}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    return-object v9
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 9

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/core/model/Rectangle;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/core/model/Rectangle;

    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->left:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    iget-wide v5, p1, Lorg/mapsforge/core/model/Rectangle;->left:D

    invoke-static {v5, v6}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    cmp-long v1, v3, v5

    if-eqz v1, :cond_1d

    return v2

    :cond_1d
    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->top:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    iget-wide v5, p1, Lorg/mapsforge/core/model/Rectangle;->top:D

    invoke-static {v5, v6}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    cmp-long v1, v3, v5

    if-eqz v1, :cond_2e

    return v2

    :cond_2e
    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->right:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    iget-wide v5, p1, Lorg/mapsforge/core/model/Rectangle;->right:D

    invoke-static {v5, v6}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    cmp-long v1, v3, v5

    if-eqz v1, :cond_3f

    return v2

    :cond_3f
    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    iget-wide v5, p1, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    invoke-static {v5, v6}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    cmp-long p1, v3, v5

    if-eqz p1, :cond_50

    return v2

    :cond_50
    return v0
.end method

.method public getCenter()Lorg/mapsforge/core/model/Point;
    .registers 6

    new-instance v0, Lorg/mapsforge/core/model/Point;

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Rectangle;->getCenterX()D

    move-result-wide v1

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Rectangle;->getCenterY()D

    move-result-wide v3

    invoke-direct {v0, v1, v2, v3, v4}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object v0
.end method

.method public getCenterX()D
    .registers 5

    iget-wide v0, p0, Lorg/mapsforge/core/model/Rectangle;->left:D

    iget-wide v2, p0, Lorg/mapsforge/core/model/Rectangle;->right:D

    add-double/2addr v0, v2

    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    div-double/2addr v0, v2

    return-wide v0
.end method

.method public getCenterY()D
    .registers 5

    iget-wide v0, p0, Lorg/mapsforge/core/model/Rectangle;->top:D

    iget-wide v2, p0, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    add-double/2addr v0, v2

    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    div-double/2addr v0, v2

    return-wide v0
.end method

.method public getHeight()D
    .registers 5

    iget-wide v0, p0, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    iget-wide v2, p0, Lorg/mapsforge/core/model/Rectangle;->top:D

    sub-double/2addr v0, v2

    return-wide v0
.end method

.method public getWidth()D
    .registers 5

    iget-wide v0, p0, Lorg/mapsforge/core/model/Rectangle;->right:D

    iget-wide v2, p0, Lorg/mapsforge/core/model/Rectangle;->left:D

    sub-double/2addr v0, v2

    return-wide v0
.end method

.method public hashCode()I
    .registers 8

    iget-wide v0, p0, Lorg/mapsforge/core/model/Rectangle;->left:D

    invoke-static {v0, v1}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v0

    const/16 v2, 0x20

    ushr-long v3, v0, v2

    xor-long/2addr v0, v3

    long-to-int v1, v0

    const/16 v0, 0x1f

    add-int/2addr v1, v0

    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->top:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    mul-int/lit8 v1, v1, 0x1f

    ushr-long v5, v3, v2

    xor-long/2addr v3, v5

    long-to-int v4, v3

    add-int/2addr v1, v4

    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->right:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    mul-int/lit8 v1, v1, 0x1f

    ushr-long v5, v3, v2

    xor-long/2addr v3, v5

    long-to-int v4, v3

    add-int/2addr v1, v4

    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    mul-int/lit8 v1, v1, 0x1f

    ushr-long v5, v3, v2

    xor-long v2, v3, v5

    long-to-int v0, v2

    add-int/2addr v1, v0

    return v1
.end method

.method public intersects(Lorg/mapsforge/core/model/Rectangle;)Z
    .registers 8

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    iget-wide v1, p0, Lorg/mapsforge/core/model/Rectangle;->left:D

    iget-wide v3, p1, Lorg/mapsforge/core/model/Rectangle;->right:D

    cmpg-double v5, v1, v3

    if-gtz v5, :cond_25

    iget-wide v1, p1, Lorg/mapsforge/core/model/Rectangle;->left:D

    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->right:D

    cmpg-double v5, v1, v3

    if-gtz v5, :cond_25

    iget-wide v1, p0, Lorg/mapsforge/core/model/Rectangle;->top:D

    iget-wide v3, p1, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    cmpg-double v5, v1, v3

    if-gtz v5, :cond_25

    iget-wide v1, p1, Lorg/mapsforge/core/model/Rectangle;->top:D

    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    cmpg-double p1, v1, v3

    if-gtz p1, :cond_25

    goto :goto_26

    :cond_25
    const/4 v0, 0x0

    :goto_26
    return v0
.end method

.method public intersectsCircle(DDD)Z
    .registers 15

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Rectangle;->getWidth()D

    move-result-wide v0

    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    div-double/2addr v0, v2

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Rectangle;->getHeight()D

    move-result-wide v4

    div-double/2addr v4, v2

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Rectangle;->getCenterX()D

    move-result-wide v2

    sub-double/2addr p1, v2

    invoke-static {p1, p2}, Ljava/lang/Math;->abs(D)D

    move-result-wide p1

    invoke-virtual {p0}, Lorg/mapsforge/core/model/Rectangle;->getCenterY()D

    move-result-wide v2

    sub-double/2addr p3, v2

    invoke-static {p3, p4}, Ljava/lang/Math;->abs(D)D

    move-result-wide p3

    add-double v2, v0, p5

    const/4 v6, 0x0

    cmpl-double v7, p1, v2

    if-lez v7, :cond_26

    return v6

    :cond_26
    add-double v2, v4, p5

    cmpl-double v7, p3, v2

    if-lez v7, :cond_2d

    return v6

    :cond_2d
    const/4 v2, 0x1

    cmpg-double v3, p1, v0

    if-gtz v3, :cond_33

    return v2

    :cond_33
    cmpg-double v3, p3, v4

    if-gtz v3, :cond_38

    return v2

    :cond_38
    sub-double/2addr p1, v0

    sub-double/2addr p3, v4

    mul-double p1, p1, p1

    mul-double p3, p3, p3

    add-double/2addr p1, p3

    mul-double p5, p5, p5

    cmpg-double p3, p1, p5

    if-gtz p3, :cond_46

    const/4 v6, 0x1

    :cond_46
    return v6
.end method

.method public shift(Lorg/mapsforge/core/model/Point;)Lorg/mapsforge/core/model/Rectangle;
    .registers 20

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    iget-wide v2, v1, Lorg/mapsforge/core/model/Point;->x:D

    const-wide/16 v4, 0x0

    cmpl-double v6, v2, v4

    if-nez v6, :cond_13

    iget-wide v6, v1, Lorg/mapsforge/core/model/Point;->y:D

    cmpl-double v8, v6, v4

    if-nez v8, :cond_13

    return-object v0

    :cond_13
    new-instance v4, Lorg/mapsforge/core/model/Rectangle;

    iget-wide v5, v0, Lorg/mapsforge/core/model/Rectangle;->left:D

    add-double v10, v5, v2

    iget-wide v5, v0, Lorg/mapsforge/core/model/Rectangle;->top:D

    iget-wide v7, v1, Lorg/mapsforge/core/model/Point;->y:D

    add-double v12, v5, v7

    iget-wide v5, v0, Lorg/mapsforge/core/model/Rectangle;->right:D

    add-double v14, v5, v2

    iget-wide v1, v0, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    add-double v16, v1, v7

    move-object v9, v4

    invoke-direct/range {v9 .. v17}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    return-object v4
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "left="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/core/model/Rectangle;->left:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v1, ", top="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/core/model/Rectangle;->top:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v1, ", right="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/core/model/Rectangle;->right:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v1, ", bottom="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
