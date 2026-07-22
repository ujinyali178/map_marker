.class public Lorg/mapsforge/core/model/LineString;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final segments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/LineSegment;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public LineString()V
    .registers 1

    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 7

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/core/model/LineString;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/core/model/LineString;

    iget-object v1, p1, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    iget-object v3, p0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-eq v1, v3, :cond_1b

    return v2

    :cond_1b
    const/4 v1, 0x0

    :goto_1c
    iget-object v3, p0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ge v1, v3, :cond_3c

    iget-object v3, p0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/core/model/LineSegment;

    iget-object v4, p1, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/mapsforge/core/model/LineSegment;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_39

    return v2

    :cond_39
    add-int/lit8 v1, v1, 0x1

    goto :goto_1c

    :cond_3c
    return v0
.end method

.method public extractPart(DD)Lorg/mapsforge/core/model/LineString;
    .registers 14

    new-instance v0, Lorg/mapsforge/core/model/LineString;

    invoke-direct {v0}, Lorg/mapsforge/core/model/LineString;-><init>()V

    const/4 v1, 0x0

    :goto_6
    iget-object v2, p0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_8c

    iget-object v2, p0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/core/model/LineSegment;

    invoke-virtual {v2}, Lorg/mapsforge/core/model/LineSegment;->length()D

    move-result-wide v3

    cmpg-double v5, v3, p1

    if-gez v5, :cond_1f

    goto :goto_6e

    :cond_1f
    const-wide/16 v5, 0x0

    const/4 v7, 0x0

    cmpl-double v8, p1, v5

    if-ltz v8, :cond_2b

    invoke-virtual {v2, p1, p2}, Lorg/mapsforge/core/model/LineSegment;->pointAlongLineSegment(D)Lorg/mapsforge/core/model/Point;

    move-result-object v5

    goto :goto_2c

    :cond_2b
    move-object v5, v7

    :goto_2c
    cmpg-double v6, p3, v3

    if-gez v6, :cond_34

    invoke-virtual {v2, p3, p4}, Lorg/mapsforge/core/model/LineSegment;->pointAlongLineSegment(D)Lorg/mapsforge/core/model/Point;

    move-result-object v7

    :cond_34
    if-eqz v5, :cond_45

    if-nez v7, :cond_45

    iget-object v3, v0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    new-instance v4, Lorg/mapsforge/core/model/LineSegment;

    iget-object v2, v2, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    invoke-direct {v4, v5, v2}, Lorg/mapsforge/core/model/LineSegment;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)V

    :goto_41
    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_6b

    :cond_45
    if-nez v5, :cond_4f

    if-nez v7, :cond_4f

    iget-object v3, v0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_6b

    :cond_4f
    if-nez v5, :cond_5d

    if-eqz v7, :cond_5d

    iget-object v3, v0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    new-instance v4, Lorg/mapsforge/core/model/LineSegment;

    iget-object v2, v2, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    invoke-direct {v4, v2, v7}, Lorg/mapsforge/core/model/LineSegment;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)V

    goto :goto_41

    :cond_5d
    if-eqz v5, :cond_6b

    if-eqz v7, :cond_6b

    iget-object v2, v0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    new-instance v3, Lorg/mapsforge/core/model/LineSegment;

    invoke-direct {v3, v5, v7}, Lorg/mapsforge/core/model/LineSegment;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_6b
    :goto_6b
    if-eqz v7, :cond_6e

    goto :goto_8c

    :cond_6e
    :goto_6e
    iget-object v2, p0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/core/model/LineSegment;

    invoke-virtual {v2}, Lorg/mapsforge/core/model/LineSegment;->length()D

    move-result-wide v2

    sub-double/2addr p1, v2

    iget-object v2, p0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/core/model/LineSegment;

    invoke-virtual {v2}, Lorg/mapsforge/core/model/LineSegment;->length()D

    move-result-wide v2

    sub-double/2addr p3, v2

    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_6

    :cond_8c
    :goto_8c
    return-object v0
.end method

.method public getBounds()Lorg/mapsforge/core/model/Rectangle;
    .registers 15

    iget-object v0, p0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    const-wide/16 v1, 0x1

    const-wide v3, 0x7fefffffffffffffL    # Double.MAX_VALUE

    move-wide v10, v1

    move-wide v12, v10

    move-wide v6, v3

    move-wide v8, v6

    :goto_11
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_5e

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/core/model/LineSegment;

    iget-object v2, v1, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-wide v2, v2, Lorg/mapsforge/core/model/Point;->x:D

    iget-object v4, v1, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-wide v4, v4, Lorg/mapsforge/core/model/Point;->x:D

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->min(DD)D

    move-result-wide v2

    invoke-static {v6, v7, v2, v3}, Ljava/lang/Math;->min(DD)D

    move-result-wide v6

    iget-object v2, v1, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-wide v2, v2, Lorg/mapsforge/core/model/Point;->y:D

    iget-object v4, v1, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-wide v4, v4, Lorg/mapsforge/core/model/Point;->y:D

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->min(DD)D

    move-result-wide v2

    invoke-static {v8, v9, v2, v3}, Ljava/lang/Math;->min(DD)D

    move-result-wide v8

    iget-object v2, v1, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-wide v2, v2, Lorg/mapsforge/core/model/Point;->x:D

    iget-object v4, v1, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-wide v4, v4, Lorg/mapsforge/core/model/Point;->x:D

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->max(DD)D

    move-result-wide v2

    invoke-static {v10, v11, v2, v3}, Ljava/lang/Math;->max(DD)D

    move-result-wide v10

    iget-object v2, v1, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-wide v2, v2, Lorg/mapsforge/core/model/Point;->y:D

    iget-object v1, v1, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-wide v4, v1, Lorg/mapsforge/core/model/Point;->y:D

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->max(DD)D

    move-result-wide v1

    invoke-static {v12, v13, v1, v2}, Ljava/lang/Math;->max(DD)D

    move-result-wide v12

    goto :goto_11

    :cond_5e
    new-instance v0, Lorg/mapsforge/core/model/Rectangle;

    move-object v5, v0

    invoke-direct/range {v5 .. v13}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    return-object v0
.end method

.method public interpolate(D)Lorg/mapsforge/core/model/Point;
    .registers 9

    const/4 v0, 0x0

    const-wide/16 v1, 0x0

    cmpg-double v3, p1, v1

    if-gez v3, :cond_8

    return-object v0

    :cond_8
    iget-object v1, p0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_e
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_29

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/core/model/LineSegment;

    invoke-virtual {v2}, Lorg/mapsforge/core/model/LineSegment;->length()D

    move-result-wide v3

    cmpg-double v5, p1, v3

    if-gtz v5, :cond_27

    invoke-virtual {v2, p1, p2}, Lorg/mapsforge/core/model/LineSegment;->pointAlongLineSegment(D)Lorg/mapsforge/core/model/Point;

    move-result-object p1

    return-object p1

    :cond_27
    sub-double/2addr p1, v3

    goto :goto_e

    :cond_29
    return-object v0
.end method

.method public length()D
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    const-wide/16 v1, 0x0

    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/core/model/LineSegment;

    invoke-virtual {v3}, Lorg/mapsforge/core/model/LineSegment;->length()D

    move-result-wide v3

    add-double/2addr v1, v3

    goto :goto_8

    :cond_1a
    return-wide v1
.end method
