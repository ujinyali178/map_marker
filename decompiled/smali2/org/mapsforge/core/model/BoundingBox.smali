.class public Lorg/mapsforge/core/model/BoundingBox;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field public final maxLatitude:D

.field public final maxLongitude:D

.field public final minLatitude:D

.field public final minLongitude:D


# direct methods
.method public constructor <init>(DDDD)V
    .registers 11

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1, p2}, Lorg/mapsforge/core/util/LatLongUtils;->validateLatitude(D)D

    invoke-static {p3, p4}, Lorg/mapsforge/core/util/LatLongUtils;->validateLongitude(D)D

    invoke-static {p5, p6}, Lorg/mapsforge/core/util/LatLongUtils;->validateLatitude(D)D

    invoke-static {p7, p8}, Lorg/mapsforge/core/util/LatLongUtils;->validateLongitude(D)D

    const/16 v0, 0x20

    cmpl-double v1, p1, p5

    if-gtz v1, :cond_3f

    cmpl-double v1, p3, p7

    if-gtz v1, :cond_22

    iput-wide p1, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    iput-wide p3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    iput-wide p5, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    iput-wide p7, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    return-void

    :cond_22
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p5, "invalid longitude range: "

    invoke-virtual {p2, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, p3, p4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {p2, p7, p8}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_3f
    new-instance p3, Ljava/lang/IllegalArgumentException;

    new-instance p4, Ljava/lang/StringBuilder;

    invoke-direct {p4}, Ljava/lang/StringBuilder;-><init>()V

    const-string p7, "invalid latitude range: "

    invoke-virtual {p4, p7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p4, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {p4, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {p4, p5, p6}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {p4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p3, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p3
.end method

.method public constructor <init>(Ljava/util/List;)V
    .registers 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/LatLong;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    const-wide/high16 v0, -0x10000000000000L    # Double.NEGATIVE_INFINITY

    const-wide/high16 v2, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    move-wide v4, v2

    move-wide v6, v4

    move-wide v2, v0

    :goto_e
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_2f

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lorg/mapsforge/core/model/LatLong;

    iget-wide v9, v8, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v11, v8, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v4, v5, v9, v10}, Ljava/lang/Math;->min(DD)D

    move-result-wide v4

    invoke-static {v6, v7, v11, v12}, Ljava/lang/Math;->min(DD)D

    move-result-wide v6

    invoke-static {v0, v1, v9, v10}, Ljava/lang/Math;->max(DD)D

    move-result-wide v0

    invoke-static {v2, v3, v11, v12}, Ljava/lang/Math;->max(DD)D

    move-result-wide v2

    goto :goto_e

    :cond_2f
    iput-wide v4, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    iput-wide v6, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    iput-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    iput-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lorg/mapsforge/core/model/BoundingBox;
    .registers 11

    const/4 v0, 0x4

    invoke-static {p0, v0}, Lorg/mapsforge/core/util/LatLongUtils;->parseCoordinateString(Ljava/lang/String;I)[D

    move-result-object p0

    new-instance v9, Lorg/mapsforge/core/model/BoundingBox;

    const/4 v0, 0x0

    aget-wide v1, p0, v0

    const/4 v0, 0x1

    aget-wide v3, p0, v0

    const/4 v0, 0x2

    aget-wide v5, p0, v0

    const/4 v0, 0x3

    aget-wide v7, p0, v0

    move-object v0, v9

    invoke-direct/range {v0 .. v8}, Lorg/mapsforge/core/model/BoundingBox;-><init>(DDDD)V

    return-object v9
.end method


# virtual methods
.method public contains(DD)Z
    .registers 8

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    cmpg-double v2, v0, p1

    if-gtz v2, :cond_1a

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    cmpl-double v2, v0, p1

    if-ltz v2, :cond_1a

    iget-wide p1, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    cmpg-double v0, p1, p3

    if-gtz v0, :cond_1a

    iget-wide p1, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    cmpl-double v0, p1, p3

    if-ltz v0, :cond_1a

    const/4 p1, 0x1

    goto :goto_1b

    :cond_1a
    const/4 p1, 0x0

    :goto_1b
    return p1
.end method

.method public contains(Lorg/mapsforge/core/model/LatLong;)Z
    .registers 6

    iget-wide v0, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v2, p1, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-virtual {p0, v0, v1, v2, v3}, Lorg/mapsforge/core/model/BoundingBox;->contains(DD)Z

    move-result p1

    return p1
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 9

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/core/model/BoundingBox;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/core/model/BoundingBox;

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    iget-wide v5, p1, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {v5, v6}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    cmp-long v1, v3, v5

    if-eqz v1, :cond_1d

    return v2

    :cond_1d
    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    iget-wide v5, p1, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-static {v5, v6}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    cmp-long v1, v3, v5

    if-eqz v1, :cond_2e

    return v2

    :cond_2e
    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    iget-wide v5, p1, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {v5, v6}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    cmp-long v1, v3, v5

    if-eqz v1, :cond_3f

    return v2

    :cond_3f
    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    iget-wide v5, p1, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-static {v5, v6}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    cmp-long p1, v3, v5

    if-eqz p1, :cond_50

    return v2

    :cond_50
    return v0
.end method

.method public extendBoundingBox(Lorg/mapsforge/core/model/BoundingBox;)Lorg/mapsforge/core/model/BoundingBox;
    .registers 14

    new-instance v9, Lorg/mapsforge/core/model/BoundingBox;

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    iget-wide v2, p1, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(DD)D

    move-result-wide v1

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    iget-wide v5, p1, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-static {v3, v4, v5, v6}, Ljava/lang/Math;->min(DD)D

    move-result-wide v3

    iget-wide v5, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    iget-wide v7, p1, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {v5, v6, v7, v8}, Ljava/lang/Math;->max(DD)D

    move-result-wide v5

    iget-wide v7, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    iget-wide v10, p1, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-static {v7, v8, v10, v11}, Ljava/lang/Math;->max(DD)D

    move-result-wide v7

    move-object v0, v9

    invoke-direct/range {v0 .. v8}, Lorg/mapsforge/core/model/BoundingBox;-><init>(DDDD)V

    return-object v9
.end method

.method public extendCoordinates(DD)Lorg/mapsforge/core/model/BoundingBox;
    .registers 23

    move-object/from16 v0, p0

    move-wide/from16 v1, p1

    move-wide/from16 v3, p3

    invoke-virtual/range {p0 .. p4}, Lorg/mapsforge/core/model/BoundingBox;->contains(DD)Z

    move-result v5

    if-eqz v5, :cond_d

    return-object v0

    :cond_d
    const-wide v5, -0x3faabcba4e5ab62aL    # -85.05112877980659

    iget-wide v7, v0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {v7, v8, v1, v2}, Ljava/lang/Math;->min(DD)D

    move-result-wide v7

    invoke-static {v5, v6, v7, v8}, Ljava/lang/Math;->max(DD)D

    move-result-wide v10

    const-wide v5, -0x3f99800000000000L    # -180.0

    iget-wide v7, v0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-static {v7, v8, v3, v4}, Ljava/lang/Math;->min(DD)D

    move-result-wide v7

    invoke-static {v5, v6, v7, v8}, Ljava/lang/Math;->max(DD)D

    move-result-wide v12

    const-wide v5, 0x40554345b1a549d6L    # 85.05112877980659

    iget-wide v7, v0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {v7, v8, v1, v2}, Ljava/lang/Math;->max(DD)D

    move-result-wide v1

    invoke-static {v5, v6, v1, v2}, Ljava/lang/Math;->min(DD)D

    move-result-wide v14

    const-wide v1, 0x4066800000000000L    # 180.0

    iget-wide v5, v0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-static {v5, v6, v3, v4}, Ljava/lang/Math;->max(DD)D

    move-result-wide v3

    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->min(DD)D

    move-result-wide v16

    new-instance v1, Lorg/mapsforge/core/model/BoundingBox;

    move-object v9, v1

    invoke-direct/range {v9 .. v17}, Lorg/mapsforge/core/model/BoundingBox;-><init>(DDDD)V

    return-object v1
.end method

.method public extendCoordinates(Lorg/mapsforge/core/model/LatLong;)Lorg/mapsforge/core/model/BoundingBox;
    .registers 6

    iget-wide v0, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v2, p1, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-virtual {p0, v0, v1, v2, v3}, Lorg/mapsforge/core/model/BoundingBox;->extendCoordinates(DD)Lorg/mapsforge/core/model/BoundingBox;

    move-result-object p1

    return-object p1
.end method

.method public extendDegrees(DD)Lorg/mapsforge/core/model/BoundingBox;
    .registers 19

    move-object v0, p0

    const-wide/16 v1, 0x0

    cmpl-double v3, p1, v1

    if-nez v3, :cond_c

    cmpl-double v3, p3, v1

    if-nez v3, :cond_c

    return-object v0

    :cond_c
    cmpg-double v3, p1, v1

    if-ltz v3, :cond_4d

    cmpg-double v3, p3, v1

    if-ltz v3, :cond_4d

    const-wide v1, -0x3faabcba4e5ab62aL    # -85.05112877980659

    iget-wide v3, v0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    sub-double/2addr v3, p1

    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->max(DD)D

    move-result-wide v6

    const-wide v1, -0x3f99800000000000L    # -180.0

    iget-wide v3, v0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    sub-double v3, v3, p3

    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->max(DD)D

    move-result-wide v8

    const-wide v1, 0x40554345b1a549d6L    # 85.05112877980659

    iget-wide v3, v0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    add-double/2addr v3, p1

    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->min(DD)D

    move-result-wide v10

    const-wide v1, 0x4066800000000000L    # 180.0

    iget-wide v3, v0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    add-double v3, v3, p3

    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->min(DD)D

    move-result-wide v12

    new-instance v1, Lorg/mapsforge/core/model/BoundingBox;

    move-object v5, v1

    invoke-direct/range {v5 .. v13}, Lorg/mapsforge/core/model/BoundingBox;-><init>(DDDD)V

    return-object v1

    :cond_4d
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "BoundingBox extend operation does not accept negative values"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public extendMargin(F)Lorg/mapsforge/core/model/BoundingBox;
    .registers 21

    move-object/from16 v0, p0

    move/from16 v1, p1

    const/high16 v2, 0x3f800000    # 1.0f

    cmpl-float v2, v1, v2

    if-nez v2, :cond_b

    return-object v0

    :cond_b
    const/4 v2, 0x0

    cmpg-float v2, v1, v2

    if-lez v2, :cond_64

    invoke-virtual/range {p0 .. p0}, Lorg/mapsforge/core/model/BoundingBox;->getLatitudeSpan()D

    move-result-wide v2

    float-to-double v4, v1

    mul-double v2, v2, v4

    invoke-virtual/range {p0 .. p0}, Lorg/mapsforge/core/model/BoundingBox;->getLatitudeSpan()D

    move-result-wide v6

    sub-double/2addr v2, v6

    const-wide/high16 v6, 0x3fe0000000000000L    # 0.5

    mul-double v2, v2, v6

    invoke-virtual/range {p0 .. p0}, Lorg/mapsforge/core/model/BoundingBox;->getLongitudeSpan()D

    move-result-wide v8

    mul-double v8, v8, v4

    invoke-virtual/range {p0 .. p0}, Lorg/mapsforge/core/model/BoundingBox;->getLongitudeSpan()D

    move-result-wide v4

    sub-double/2addr v8, v4

    mul-double v8, v8, v6

    const-wide v4, -0x3faabcba4e5ab62aL    # -85.05112877980659

    iget-wide v6, v0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    sub-double/2addr v6, v2

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->max(DD)D

    move-result-wide v11

    const-wide v4, -0x3f99800000000000L    # -180.0

    iget-wide v6, v0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    sub-double/2addr v6, v8

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->max(DD)D

    move-result-wide v13

    const-wide v4, 0x40554345b1a549d6L    # 85.05112877980659

    iget-wide v6, v0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    add-double/2addr v6, v2

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->min(DD)D

    move-result-wide v15

    const-wide v1, 0x4066800000000000L    # 180.0

    iget-wide v3, v0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    add-double/2addr v3, v8

    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->min(DD)D

    move-result-wide v17

    new-instance v1, Lorg/mapsforge/core/model/BoundingBox;

    move-object v10, v1

    invoke-direct/range {v10 .. v18}, Lorg/mapsforge/core/model/BoundingBox;-><init>(DDDD)V

    return-object v1

    :cond_64
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "BoundingBox extend operation does not accept negative or zero values"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public extendMeters(I)Lorg/mapsforge/core/model/BoundingBox;
    .registers 21

    move-object/from16 v0, p0

    move/from16 v1, p1

    if-nez v1, :cond_7

    return-object v0

    :cond_7
    if-ltz v1, :cond_58

    invoke-static/range {p1 .. p1}, Lorg/mapsforge/core/util/LatLongUtils;->latitudeDistance(I)D

    move-result-wide v2

    iget-wide v4, v0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {v4, v5}, Ljava/lang/Math;->abs(D)D

    move-result-wide v4

    iget-wide v6, v0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {v6, v7}, Ljava/lang/Math;->abs(D)D

    move-result-wide v6

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->max(DD)D

    move-result-wide v4

    invoke-static {v1, v4, v5}, Lorg/mapsforge/core/util/LatLongUtils;->longitudeDistance(ID)D

    move-result-wide v4

    const-wide v6, -0x3faabcba4e5ab62aL    # -85.05112877980659

    iget-wide v8, v0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    sub-double/2addr v8, v2

    invoke-static {v6, v7, v8, v9}, Ljava/lang/Math;->max(DD)D

    move-result-wide v11

    const-wide v6, -0x3f99800000000000L    # -180.0

    iget-wide v8, v0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    sub-double/2addr v8, v4

    invoke-static {v6, v7, v8, v9}, Ljava/lang/Math;->max(DD)D

    move-result-wide v13

    const-wide v6, 0x40554345b1a549d6L    # 85.05112877980659

    iget-wide v8, v0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    add-double/2addr v8, v2

    invoke-static {v6, v7, v8, v9}, Ljava/lang/Math;->min(DD)D

    move-result-wide v15

    const-wide v1, 0x4066800000000000L    # 180.0

    iget-wide v6, v0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    add-double/2addr v6, v4

    invoke-static {v1, v2, v6, v7}, Ljava/lang/Math;->min(DD)D

    move-result-wide v17

    new-instance v1, Lorg/mapsforge/core/model/BoundingBox;

    move-object v10, v1

    invoke-direct/range {v10 .. v18}, Lorg/mapsforge/core/model/BoundingBox;-><init>(DDDD)V

    return-object v1

    :cond_58
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "BoundingBox extend operation does not accept negative values"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public getCenterPoint()Lorg/mapsforge/core/model/LatLong;
    .registers 9

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    iget-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    sub-double/2addr v0, v2

    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    div-double/2addr v0, v2

    iget-wide v4, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    iget-wide v6, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    sub-double/2addr v4, v6

    div-double/2addr v4, v2

    new-instance v2, Lorg/mapsforge/core/model/LatLong;

    iget-wide v6, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    add-double/2addr v6, v0

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    add-double/2addr v0, v4

    invoke-direct {v2, v6, v7, v0, v1}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    return-object v2
.end method

.method public getLatitudeSpan()D
    .registers 5

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    iget-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    sub-double/2addr v0, v2

    return-wide v0
.end method

.method public getLongitudeSpan()D
    .registers 5

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    iget-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    sub-double/2addr v0, v2

    return-wide v0
.end method

.method public getPositionRelativeToTile(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/core/model/Rectangle;
    .registers 13

    new-instance v0, Lorg/mapsforge/core/model/LatLong;

    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-direct {v0, v1, v2, v3, v4}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    invoke-static {v0, p1}, Lorg/mapsforge/core/util/MercatorProjection;->getPixelRelativeToTile(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/core/model/Point;

    move-result-object v0

    new-instance v1, Lorg/mapsforge/core/model/LatLong;

    iget-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    iget-wide v4, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-direct {v1, v2, v3, v4, v5}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    invoke-static {v1, p1}, Lorg/mapsforge/core/util/MercatorProjection;->getPixelRelativeToTile(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/core/model/Point;

    move-result-object p1

    new-instance v10, Lorg/mapsforge/core/model/Rectangle;

    iget-wide v2, v0, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v4, v0, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v6, p1, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v8, p1, Lorg/mapsforge/core/model/Point;->y:D

    move-object v1, v10

    invoke-direct/range {v1 .. v9}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    return-object v10
.end method

.method public hashCode()I
    .registers 8

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {v0, v1}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v0

    const/16 v2, 0x20

    ushr-long v3, v0, v2

    xor-long/2addr v0, v3

    long-to-int v1, v0

    const/16 v0, 0x1f

    add-int/2addr v1, v0

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    mul-int/lit8 v1, v1, 0x1f

    ushr-long v5, v3, v2

    xor-long/2addr v3, v5

    long-to-int v4, v3

    add-int/2addr v1, v4

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    mul-int/lit8 v1, v1, 0x1f

    ushr-long v5, v3, v2

    xor-long/2addr v3, v5

    long-to-int v4, v3

    add-int/2addr v1, v4

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    mul-int/lit8 v1, v1, 0x1f

    ushr-long v5, v3, v2

    xor-long v2, v3, v5

    long-to-int v0, v2

    add-int/2addr v1, v0

    return v1
.end method

.method public intersects(Lorg/mapsforge/core/model/BoundingBox;)Z
    .registers 8

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    iget-wide v3, p1, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    cmpl-double v5, v1, v3

    if-ltz v5, :cond_25

    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    iget-wide v3, p1, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    cmpl-double v5, v1, v3

    if-ltz v5, :cond_25

    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    iget-wide v3, p1, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    cmpg-double v5, v1, v3

    if-gtz v5, :cond_25

    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    iget-wide v3, p1, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    cmpg-double p1, v1, v3

    if-gtz p1, :cond_25

    goto :goto_26

    :cond_25
    const/4 v0, 0x0

    :goto_26
    return v0
.end method

.method public intersectsArea([[Lorg/mapsforge/core/model/LatLong;)Z
    .registers 20

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    array-length v2, v1

    const/4 v3, 0x0

    if-eqz v2, :cond_78

    aget-object v2, v1, v3

    array-length v2, v2

    if-nez v2, :cond_f

    goto/16 :goto_78

    :cond_f
    array-length v2, v1

    const/4 v4, 0x0

    :goto_11
    if-ge v4, v2, :cond_29

    aget-object v5, v1, v4

    array-length v6, v5

    const/4 v7, 0x0

    :goto_17
    if-ge v7, v6, :cond_26

    aget-object v8, v5, v7

    invoke-virtual {v0, v8}, Lorg/mapsforge/core/model/BoundingBox;->contains(Lorg/mapsforge/core/model/LatLong;)Z

    move-result v8

    if-eqz v8, :cond_23

    const/4 v1, 0x1

    return v1

    :cond_23
    add-int/lit8 v7, v7, 0x1

    goto :goto_17

    :cond_26
    add-int/lit8 v4, v4, 0x1

    goto :goto_11

    :cond_29
    aget-object v2, v1, v3

    aget-object v2, v2, v3

    iget-wide v4, v2, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v6, v2, Lorg/mapsforge/core/model/LatLong;->longitude:D

    array-length v2, v1

    move-wide v9, v4

    move-wide v13, v9

    move-wide v11, v6

    move-wide v15, v11

    const/4 v4, 0x0

    :goto_37
    if-ge v4, v2, :cond_6d

    aget-object v5, v1, v4

    array-length v6, v5

    move-wide v7, v15

    const/4 v15, 0x0

    :goto_3e
    if-ge v15, v6, :cond_64

    aget-object v3, v5, v15

    move/from16 v17, v2

    iget-wide v1, v3, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v9, v10, v1, v2}, Ljava/lang/Math;->min(DD)D

    move-result-wide v9

    iget-wide v1, v3, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v13, v14, v1, v2}, Ljava/lang/Math;->max(DD)D

    move-result-wide v13

    iget-wide v1, v3, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v11, v12, v1, v2}, Ljava/lang/Math;->min(DD)D

    move-result-wide v11

    iget-wide v1, v3, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v7, v8, v1, v2}, Ljava/lang/Math;->max(DD)D

    move-result-wide v7

    add-int/lit8 v15, v15, 0x1

    move-object/from16 v1, p1

    move/from16 v2, v17

    const/4 v3, 0x0

    goto :goto_3e

    :cond_64
    move/from16 v17, v2

    add-int/lit8 v4, v4, 0x1

    move-object/from16 v1, p1

    move-wide v15, v7

    const/4 v3, 0x0

    goto :goto_37

    :cond_6d
    new-instance v1, Lorg/mapsforge/core/model/BoundingBox;

    move-object v8, v1

    invoke-direct/range {v8 .. v16}, Lorg/mapsforge/core/model/BoundingBox;-><init>(DDDD)V

    invoke-virtual {v0, v1}, Lorg/mapsforge/core/model/BoundingBox;->intersects(Lorg/mapsforge/core/model/BoundingBox;)Z

    move-result v1

    return v1

    :cond_78
    :goto_78
    const/4 v1, 0x0

    return v1
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "minLatitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v1, ", minLongitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v1, ", maxLatitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v1, ", maxLongitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
