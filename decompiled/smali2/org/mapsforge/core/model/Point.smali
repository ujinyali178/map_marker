.class public Lorg/mapsforge/core/model/Point;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Comparable;
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable<",
        "Lorg/mapsforge/core/model/Point;",
        ">;",
        "Ljava/io/Serializable;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field public final x:D

.field public final y:D


# direct methods
.method public constructor <init>(DD)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide p1, p0, Lorg/mapsforge/core/model/Point;->x:D

    iput-wide p3, p0, Lorg/mapsforge/core/model/Point;->y:D

    return-void
.end method


# virtual methods
.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .registers 2

    check-cast p1, Lorg/mapsforge/core/model/Point;

    invoke-virtual {p0, p1}, Lorg/mapsforge/core/model/Point;->compareTo(Lorg/mapsforge/core/model/Point;)I

    move-result p1

    return p1
.end method

.method public compareTo(Lorg/mapsforge/core/model/Point;)I
    .registers 9

    iget-wide v0, p0, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v2, p1, Lorg/mapsforge/core/model/Point;->x:D

    const/4 v4, 0x1

    cmpl-double v5, v0, v2

    if-lez v5, :cond_a

    return v4

    :cond_a
    const/4 v5, -0x1

    cmpg-double v6, v0, v2

    if-gez v6, :cond_10

    return v5

    :cond_10
    iget-wide v0, p0, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v2, p1, Lorg/mapsforge/core/model/Point;->y:D

    cmpl-double p1, v0, v2

    if-lez p1, :cond_19

    return v4

    :cond_19
    cmpg-double p1, v0, v2

    if-gez p1, :cond_1e

    return v5

    :cond_1e
    const/4 p1, 0x0

    return p1
.end method

.method public distance(Lorg/mapsforge/core/model/Point;)D
    .registers 8

    iget-wide v0, p0, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v2, p1, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v0, v2

    iget-wide v2, p0, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v4, p1, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v2, v4

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide v0

    return-wide v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 9

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/core/model/Point;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/core/model/Point;

    iget-wide v3, p0, Lorg/mapsforge/core/model/Point;->x:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    iget-wide v5, p1, Lorg/mapsforge/core/model/Point;->x:D

    invoke-static {v5, v6}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    cmp-long v1, v3, v5

    if-eqz v1, :cond_1d

    return v2

    :cond_1d
    iget-wide v3, p0, Lorg/mapsforge/core/model/Point;->y:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    iget-wide v5, p1, Lorg/mapsforge/core/model/Point;->y:D

    invoke-static {v5, v6}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    cmp-long p1, v3, v5

    if-eqz p1, :cond_2e

    return v2

    :cond_2e
    return v0
.end method

.method public hashCode()I
    .registers 8

    iget-wide v0, p0, Lorg/mapsforge/core/model/Point;->x:D

    invoke-static {v0, v1}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v0

    const/16 v2, 0x20

    ushr-long v3, v0, v2

    xor-long/2addr v0, v3

    long-to-int v1, v0

    const/16 v0, 0x1f

    add-int/2addr v1, v0

    iget-wide v3, p0, Lorg/mapsforge/core/model/Point;->y:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    mul-int/lit8 v1, v1, 0x1f

    ushr-long v5, v3, v2

    xor-long v2, v3, v5

    long-to-int v0, v2

    add-int/2addr v1, v0

    return v1
.end method

.method public offset(DD)Lorg/mapsforge/core/model/Point;
    .registers 8

    const-wide/16 v0, 0x0

    cmpl-double v2, v0, p1

    if-nez v2, :cond_b

    cmpl-double v2, v0, p3

    if-nez v2, :cond_b

    return-object p0

    :cond_b
    new-instance v0, Lorg/mapsforge/core/model/Point;

    iget-wide v1, p0, Lorg/mapsforge/core/model/Point;->x:D

    add-double/2addr v1, p1

    iget-wide p1, p0, Lorg/mapsforge/core/model/Point;->y:D

    add-double/2addr p1, p3

    invoke-direct {v0, v1, v2, p1, p2}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "x="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/core/model/Point;->x:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v1, ", y="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/core/model/Point;->y:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
