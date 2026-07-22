.class public final Lorg/mapsforge/core/model/LineSegment;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static BOTTOM:I = 0x4

.field private static INSIDE:I = 0x0

.field private static LEFT:I = 0x1

.field private static RIGHT:I = 0x2

.field private static TOP:I = 0x8


# instance fields
.field public final end:Lorg/mapsforge/core/model/Point;

.field public final start:Lorg/mapsforge/core/model/Point;


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iput-object p2, p0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;D)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    new-instance v0, Lorg/mapsforge/core/model/LineSegment;

    invoke-direct {v0, p1, p2}, Lorg/mapsforge/core/model/LineSegment;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)V

    invoke-virtual {v0, p3, p4}, Lorg/mapsforge/core/model/LineSegment;->pointAlongLineSegment(D)Lorg/mapsforge/core/model/Point;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    return-void
.end method

.method private static code(Lorg/mapsforge/core/model/Rectangle;Lorg/mapsforge/core/model/Point;)I
    .registers 8

    sget v0, Lorg/mapsforge/core/model/LineSegment;->INSIDE:I

    iget-wide v1, p1, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->left:D

    cmpg-double v5, v1, v3

    if-gez v5, :cond_e

    sget v1, Lorg/mapsforge/core/model/LineSegment;->LEFT:I

    :goto_c
    or-int/2addr v0, v1

    goto :goto_17

    :cond_e
    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->right:D

    cmpl-double v5, v1, v3

    if-lez v5, :cond_17

    sget v1, Lorg/mapsforge/core/model/LineSegment;->RIGHT:I

    goto :goto_c

    :cond_17
    :goto_17
    iget-wide v1, p1, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v3, p0, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    cmpl-double p1, v1, v3

    if-lez p1, :cond_23

    sget p0, Lorg/mapsforge/core/model/LineSegment;->BOTTOM:I

    :goto_21
    or-int/2addr v0, p0

    goto :goto_2c

    :cond_23
    iget-wide p0, p0, Lorg/mapsforge/core/model/Rectangle;->top:D

    cmpg-double v3, v1, p0

    if-gez v3, :cond_2c

    sget p0, Lorg/mapsforge/core/model/LineSegment;->TOP:I

    goto :goto_21

    :cond_2c
    :goto_2c
    return v0
.end method


# virtual methods
.method public angleTo(Lorg/mapsforge/core/model/LineSegment;)D
    .registers 11

    iget-object v0, p0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-wide v1, v0, Lorg/mapsforge/core/model/Point;->y:D

    iget-object v3, p0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-wide v4, v3, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v1, v4

    iget-wide v4, v0, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v6, v3, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v4, v6

    invoke-static {v1, v2, v4, v5}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide v0

    iget-object v2, p1, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-wide v3, v2, Lorg/mapsforge/core/model/Point;->y:D

    iget-object p1, p1, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-wide v5, p1, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v3, v5

    iget-wide v5, v2, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v7, p1, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v5, v7

    invoke-static {v3, v4, v5, v6}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide v2

    sub-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide v0

    const-wide v2, 0x4076800000000000L    # 360.0

    const-wide v4, -0x3f99800000000000L    # -180.0

    cmpg-double p1, v0, v4

    if-gtz p1, :cond_38

    add-double/2addr v0, v2

    :cond_38
    const-wide v4, 0x4066800000000000L    # 180.0

    cmpl-double p1, v0, v4

    if-ltz p1, :cond_42

    sub-double/2addr v0, v2

    :cond_42
    return-wide v0
.end method

.method public clipToRectangle(Lorg/mapsforge/core/model/Rectangle;)Lorg/mapsforge/core/model/LineSegment;
    .registers 19

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    iget-object v2, v0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-object v3, v0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    invoke-static {v1, v2}, Lorg/mapsforge/core/model/LineSegment;->code(Lorg/mapsforge/core/model/Rectangle;Lorg/mapsforge/core/model/Point;)I

    move-result v4

    :goto_c
    invoke-static {v1, v3}, Lorg/mapsforge/core/model/LineSegment;->code(Lorg/mapsforge/core/model/Rectangle;Lorg/mapsforge/core/model/Point;)I

    move-result v5

    :goto_10
    or-int v6, v4, v5

    if-nez v6, :cond_1a

    new-instance v1, Lorg/mapsforge/core/model/LineSegment;

    invoke-direct {v1, v2, v3}, Lorg/mapsforge/core/model/LineSegment;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)V

    return-object v1

    :cond_1a
    and-int v6, v4, v5

    if-eqz v6, :cond_20

    const/4 v1, 0x0

    return-object v1

    :cond_20
    if-eqz v4, :cond_24

    move v6, v4

    goto :goto_25

    :cond_24
    move v6, v5

    :goto_25
    sget v7, Lorg/mapsforge/core/model/LineSegment;->TOP:I

    and-int/2addr v7, v6

    if-eqz v7, :cond_3f

    iget-wide v7, v2, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v9, v3, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v9, v7

    iget-wide v11, v1, Lorg/mapsforge/core/model/Rectangle;->top:D

    :goto_31
    iget-wide v13, v2, Lorg/mapsforge/core/model/Point;->y:D

    sub-double v15, v11, v13

    mul-double v9, v9, v15

    move-wide v15, v11

    iget-wide v11, v3, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v11, v13

    div-double/2addr v9, v11

    add-double/2addr v7, v9

    move-wide v11, v15

    goto :goto_74

    :cond_3f
    sget v7, Lorg/mapsforge/core/model/LineSegment;->BOTTOM:I

    and-int/2addr v7, v6

    if-eqz v7, :cond_4c

    iget-wide v7, v2, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v9, v3, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v9, v7

    iget-wide v11, v1, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    goto :goto_31

    :cond_4c
    sget v7, Lorg/mapsforge/core/model/LineSegment;->RIGHT:I

    and-int/2addr v7, v6

    if-eqz v7, :cond_67

    iget-wide v7, v2, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v9, v3, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v9, v7

    iget-wide v11, v1, Lorg/mapsforge/core/model/Rectangle;->right:D

    :goto_58
    iget-wide v13, v2, Lorg/mapsforge/core/model/Point;->x:D

    sub-double v15, v11, v13

    mul-double v9, v9, v15

    move-wide v15, v11

    iget-wide v11, v3, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v11, v13

    div-double/2addr v9, v11

    add-double v11, v7, v9

    move-wide v7, v15

    goto :goto_74

    :cond_67
    sget v7, Lorg/mapsforge/core/model/LineSegment;->LEFT:I

    and-int/2addr v7, v6

    if-eqz v7, :cond_86

    iget-wide v7, v2, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v9, v3, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v9, v7

    iget-wide v11, v1, Lorg/mapsforge/core/model/Rectangle;->left:D

    goto :goto_58

    :goto_74
    if-ne v6, v4, :cond_80

    new-instance v2, Lorg/mapsforge/core/model/Point;

    invoke-direct {v2, v7, v8, v11, v12}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    invoke-static {v1, v2}, Lorg/mapsforge/core/model/LineSegment;->code(Lorg/mapsforge/core/model/Rectangle;Lorg/mapsforge/core/model/Point;)I

    move-result v4

    goto :goto_10

    :cond_80
    new-instance v3, Lorg/mapsforge/core/model/Point;

    invoke-direct {v3, v7, v8, v11, v12}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    goto :goto_c

    :cond_86
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Should not get here"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/core/model/LineSegment;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/core/model/LineSegment;

    iget-object v1, p1, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-object v3, p0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    invoke-virtual {v1, v3}, Lorg/mapsforge/core/model/Point;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_21

    iget-object p1, p1, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-object v1, p0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    invoke-virtual {p1, v1}, Lorg/mapsforge/core/model/Point;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_21

    return v0

    :cond_21
    return v2
.end method

.method public hashCode()I
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    invoke-virtual {v0}, Lorg/mapsforge/core/model/Point;->hashCode()I

    move-result v0

    const/16 v1, 0x1f

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    invoke-virtual {v1}, Lorg/mapsforge/core/model/Point;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public intersectsRectangle(Lorg/mapsforge/core/model/Rectangle;Z)Z
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    invoke-static {p1, v0}, Lorg/mapsforge/core/model/LineSegment;->code(Lorg/mapsforge/core/model/Rectangle;Lorg/mapsforge/core/model/Point;)I

    move-result v0

    iget-object v1, p0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    invoke-static {p1, v1}, Lorg/mapsforge/core/model/LineSegment;->code(Lorg/mapsforge/core/model/Rectangle;Lorg/mapsforge/core/model/Point;)I

    move-result p1

    or-int v1, v0, p1

    if-nez v1, :cond_12

    const/4 p1, 0x1

    return p1

    :cond_12
    and-int/2addr p1, v0

    if-eqz p1, :cond_17

    const/4 p1, 0x0

    return p1

    :cond_17
    return p2
.end method

.method public length()D
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-object v1, p0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    invoke-virtual {v0, v1}, Lorg/mapsforge/core/model/Point;->distance(Lorg/mapsforge/core/model/Point;)D

    move-result-wide v0

    return-wide v0
.end method

.method public pointAlongLineSegment(D)Lorg/mapsforge/core/model/Point;
    .registers 13

    iget-object v0, p0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-wide v1, v0, Lorg/mapsforge/core/model/Point;->x:D

    iget-object v3, p0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-wide v4, v3, Lorg/mapsforge/core/model/Point;->x:D

    cmpl-double v6, v1, v4

    if-nez v6, :cond_22

    iget-wide v6, v0, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v8, v3, Lorg/mapsforge/core/model/Point;->y:D

    cmpl-double v0, v6, v8

    if-lez v0, :cond_1b

    new-instance v0, Lorg/mapsforge/core/model/Point;

    add-double/2addr v8, p1

    invoke-direct {v0, v4, v5, v8, v9}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object v0

    :cond_1b
    new-instance v0, Lorg/mapsforge/core/model/Point;

    add-double/2addr v6, p1

    invoke-direct {v0, v1, v2, v6, v7}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object v0

    :cond_22
    iget-wide v6, v3, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v8, v0, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v6, v8

    sub-double/2addr v4, v1

    div-double/2addr v6, v4

    mul-double p1, p1, p1

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    mul-double v2, v6, v6

    add-double/2addr v2, v0

    div-double/2addr p1, v2

    invoke-static {p1, p2}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide p1

    iget-object v0, p0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-wide v0, v0, Lorg/mapsforge/core/model/Point;->x:D

    iget-object v2, p0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-wide v3, v2, Lorg/mapsforge/core/model/Point;->x:D

    cmpg-double v5, v0, v3

    if-gez v5, :cond_45

    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    mul-double p1, p1, v0

    :cond_45
    new-instance v0, Lorg/mapsforge/core/model/Point;

    add-double/2addr v3, p1

    iget-wide v1, v2, Lorg/mapsforge/core/model/Point;->y:D

    mul-double v6, v6, p1

    add-double/2addr v1, v6

    invoke-direct {v0, v3, v4, v1, v2}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object v0
.end method

.method public reverse()Lorg/mapsforge/core/model/LineSegment;
    .registers 4

    new-instance v0, Lorg/mapsforge/core/model/LineSegment;

    iget-object v1, p0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-object v2, p0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/core/model/LineSegment;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)V

    return-object v0
.end method

.method public subSegment(DD)Lorg/mapsforge/core/model/LineSegment;
    .registers 6

    invoke-virtual {p0, p1, p2}, Lorg/mapsforge/core/model/LineSegment;->pointAlongLineSegment(D)Lorg/mapsforge/core/model/Point;

    move-result-object v0

    add-double/2addr p1, p3

    invoke-virtual {p0, p1, p2}, Lorg/mapsforge/core/model/LineSegment;->pointAlongLineSegment(D)Lorg/mapsforge/core/model/Point;

    move-result-object p1

    new-instance p2, Lorg/mapsforge/core/model/LineSegment;

    invoke-direct {p2, v0, p1}, Lorg/mapsforge/core/model/LineSegment;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)V

    return-object p2
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
