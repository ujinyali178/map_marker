.class public final Lorg/mapsforge/core/util/LatLongUtils;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final CONVERSION_FACTOR:D = 1000000.0

.field private static final DELIMITER:Ljava/lang/String; = ","

.field public static final EQUATORIAL_RADIUS:D = 6378137.0

.field public static final INVERSE_FLATTENING:D = 298.257223563

.field public static final LATITUDE_MAX:D = 90.0

.field public static final LATITUDE_MIN:D = -90.0

.field public static final LONGITUDE_MAX:D = 180.0

.field public static final LONGITUDE_MIN:D = -180.0

.field public static final POLAR_RADIUS:D = 6356752.3142


# direct methods
.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method public static contains(Ljava/util/List;Lorg/mapsforge/core/model/LatLong;)Z
    .registers 16
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/LatLong;",
            ">;",
            "Lorg/mapsforge/core/model/LatLong;",
            ")Z"
        }
    .end annotation

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    const/4 v2, 0x0

    move v3, v0

    const/4 v0, 0x0

    const/4 v4, 0x0

    :goto_a
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v5

    if-ge v0, v5, :cond_7c

    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lorg/mapsforge/core/model/LatLong;

    iget-wide v5, v5, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v7, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    cmpl-double v9, v5, v7

    if-lez v9, :cond_21

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_22

    :cond_21
    const/4 v5, 0x0

    :goto_22
    invoke-interface {p0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lorg/mapsforge/core/model/LatLong;

    iget-wide v6, v6, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v8, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    cmpl-double v10, v6, v8

    if-lez v10, :cond_32

    const/4 v6, 0x1

    goto :goto_33

    :cond_32
    const/4 v6, 0x0

    :goto_33
    if-eq v5, v6, :cond_76

    iget-wide v5, p1, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-interface {p0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lorg/mapsforge/core/model/LatLong;

    iget-wide v7, v7, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lorg/mapsforge/core/model/LatLong;

    iget-wide v9, v9, Lorg/mapsforge/core/model/LatLong;->longitude:D

    sub-double/2addr v7, v9

    iget-wide v9, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lorg/mapsforge/core/model/LatLong;

    iget-wide v11, v11, Lorg/mapsforge/core/model/LatLong;->latitude:D

    sub-double/2addr v9, v11

    mul-double v7, v7, v9

    invoke-interface {p0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/core/model/LatLong;

    iget-wide v9, v3, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/core/model/LatLong;

    iget-wide v11, v3, Lorg/mapsforge/core/model/LatLong;->latitude:D

    sub-double/2addr v9, v11

    div-double/2addr v7, v9

    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/core/model/LatLong;

    iget-wide v9, v3, Lorg/mapsforge/core/model/LatLong;->longitude:D

    add-double/2addr v7, v9

    cmpg-double v3, v5, v7

    if-gez v3, :cond_76

    xor-int/lit8 v4, v4, 0x1

    :cond_76
    add-int/lit8 v3, v0, 0x1

    move v13, v3

    move v3, v0

    move v0, v13

    goto :goto_a

    :cond_7c
    return v4
.end method

.method public static contains([Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/LatLong;)Z
    .registers 20

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    array-length v2, v0

    const/4 v3, 0x1

    sub-int/2addr v2, v3

    move v5, v2

    const/4 v2, 0x0

    const/4 v6, 0x0

    :goto_a
    array-length v7, v0

    if-ge v2, v7, :cond_43

    aget-object v7, v0, v2

    iget-wide v8, v7, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v10, v1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    cmpl-double v12, v8, v10

    if-lez v12, :cond_19

    const/4 v12, 0x1

    goto :goto_1a

    :cond_19
    const/4 v12, 0x0

    :goto_1a
    aget-object v5, v0, v5

    iget-wide v13, v5, Lorg/mapsforge/core/model/LatLong;->latitude:D

    cmpl-double v15, v13, v10

    if-lez v15, :cond_24

    const/4 v15, 0x1

    goto :goto_25

    :cond_24
    const/4 v15, 0x0

    :goto_25
    if-eq v12, v15, :cond_3d

    iget-wide v3, v1, Lorg/mapsforge/core/model/LatLong;->longitude:D

    move-wide/from16 v16, v13

    iget-wide v12, v5, Lorg/mapsforge/core/model/LatLong;->longitude:D

    iget-wide v14, v7, Lorg/mapsforge/core/model/LatLong;->longitude:D

    sub-double/2addr v12, v14

    sub-double/2addr v10, v8

    mul-double v12, v12, v10

    sub-double v7, v16, v8

    div-double/2addr v12, v7

    add-double/2addr v12, v14

    cmpg-double v7, v3, v12

    if-gez v7, :cond_3d

    xor-int/lit8 v6, v6, 0x1

    :cond_3d
    add-int/lit8 v3, v2, 0x1

    move v5, v2

    move v2, v3

    const/4 v3, 0x1

    goto :goto_a

    :cond_43
    return v6
.end method

.method public static degreesToMicrodegrees(D)I
    .registers 4

    const-wide v0, 0x412e848000000000L    # 1000000.0

    mul-double p0, p0, v0

    double-to-int p0, p0

    return p0
.end method

.method public static destinationPoint(Lorg/mapsforge/core/model/LatLong;DF)Lorg/mapsforge/core/model/LatLong;
    .registers 16

    float-to-double v0, p3

    invoke-static {v0, v1}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v0

    const-wide v2, 0x415854a640000000L    # 6378137.0

    div-double/2addr p1, v2

    iget-wide v2, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v2, v3}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v2

    iget-wide v4, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v4, v5}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v4

    invoke-static {v2, v3}, Ljava/lang/Math;->sin(D)D

    move-result-wide v6

    invoke-static {p1, p2}, Ljava/lang/Math;->cos(D)D

    move-result-wide v8

    mul-double v6, v6, v8

    invoke-static {v2, v3}, Ljava/lang/Math;->cos(D)D

    move-result-wide v8

    invoke-static {p1, p2}, Ljava/lang/Math;->sin(D)D

    move-result-wide v10

    mul-double v8, v8, v10

    invoke-static {v0, v1}, Ljava/lang/Math;->cos(D)D

    move-result-wide v10

    mul-double v8, v8, v10

    add-double/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->asin(D)D

    move-result-wide v6

    invoke-static {v0, v1}, Ljava/lang/Math;->sin(D)D

    move-result-wide v0

    invoke-static {p1, p2}, Ljava/lang/Math;->sin(D)D

    move-result-wide v8

    mul-double v0, v0, v8

    invoke-static {v2, v3}, Ljava/lang/Math;->cos(D)D

    move-result-wide v8

    mul-double v0, v0, v8

    invoke-static {p1, p2}, Ljava/lang/Math;->cos(D)D

    move-result-wide p0

    invoke-static {v2, v3}, Ljava/lang/Math;->sin(D)D

    move-result-wide p2

    invoke-static {v6, v7}, Ljava/lang/Math;->sin(D)D

    move-result-wide v2

    mul-double p2, p2, v2

    sub-double/2addr p0, p2

    invoke-static {v0, v1, p0, p1}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide p0

    add-double/2addr v4, p0

    new-instance p0, Lorg/mapsforge/core/model/LatLong;

    invoke-static {v6, v7}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide p1

    invoke-static {v4, v5}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide v0

    invoke-direct {p0, p1, p2, v0, v1}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    return-object p0
.end method

.method public static distance(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/LatLong;)D
    .registers 6

    iget-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    iget-wide v2, p1, Lorg/mapsforge/core/model/LatLong;->longitude:D

    sub-double/2addr v0, v2

    iget-wide v2, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide p0, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    sub-double/2addr v2, p0

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide p0

    return-wide p0
.end method

.method public static distanceSegmentPoint(DDDDDD)D
    .registers 12

    invoke-static/range {p0 .. p11}, Lorg/mapsforge/core/util/LatLongUtils;->nearestSegmentPoint(DDDDDD)Lorg/mapsforge/core/model/Point;

    move-result-object p0

    iget-wide p1, p0, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr p1, p8

    iget-wide p3, p0, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr p3, p10

    invoke-static {p1, p2, p3, p4}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide p0

    return-wide p0
.end method

.method public static fromString(Ljava/lang/String;)Lorg/mapsforge/core/model/LatLong;
    .registers 6

    const/4 v0, 0x2

    invoke-static {p0, v0}, Lorg/mapsforge/core/util/LatLongUtils;->parseCoordinateString(Ljava/lang/String;I)[D

    move-result-object p0

    new-instance v0, Lorg/mapsforge/core/model/LatLong;

    const/4 v1, 0x0

    aget-wide v1, p0, v1

    const/4 v3, 0x1

    aget-wide v3, p0, v3

    invoke-direct {v0, v1, v2, v3, v4}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    return-object v0
.end method

.method public static isClosedWay([Lorg/mapsforge/core/model/LatLong;)Z
    .registers 7

    const/4 v0, 0x0

    aget-object v1, p0, v0

    array-length v2, p0

    const/4 v3, 0x1

    sub-int/2addr v2, v3

    aget-object p0, p0, v2

    invoke-virtual {v1, p0}, Lorg/mapsforge/core/model/LatLong;->distance(Lorg/mapsforge/core/model/LatLong;)D

    move-result-wide v1

    const-wide v4, 0x3e112e0be826d695L    # 1.0E-9

    cmpg-double p0, v1, v4

    if-gez p0, :cond_16

    const/4 v0, 0x1

    :cond_16
    return v0
.end method

.method public static latitudeDistance(I)D
    .registers 5

    mul-int/lit16 p0, p0, 0x168

    int-to-double v0, p0

    const-wide v2, 0x41831bf8457c1093L    # 4.007501668557849E7

    div-double/2addr v0, v2

    return-wide v0
.end method

.method public static longitudeDistance(ID)D
    .registers 7

    mul-int/lit16 p0, p0, 0x168

    int-to-double v0, p0

    invoke-static {p1, p2}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide p0

    invoke-static {p0, p1}, Ljava/lang/Math;->cos(D)D

    move-result-wide p0

    const-wide v2, 0x41831bf8457c1093L    # 4.007501668557849E7

    mul-double p0, p0, v2

    div-double/2addr v0, p0

    return-wide v0
.end method

.method public static microdegreesToDegrees(I)D
    .registers 5

    int-to-double v0, p0

    const-wide v2, 0x412e848000000000L    # 1000000.0

    div-double/2addr v0, v2

    return-wide v0
.end method

.method public static nearestSegmentPoint(DDDDDD)Lorg/mapsforge/core/model/Point;
    .registers 32

    move-wide/from16 v0, p0

    move-wide/from16 v2, p2

    move-wide/from16 v4, p4

    move-wide/from16 v6, p6

    sub-double v8, v4, v0

    sub-double v10, v6, v2

    mul-double v12, v8, v8

    mul-double v14, v10, v10

    add-double/2addr v12, v14

    const-wide/16 v14, 0x0

    cmpl-double v16, v12, v14

    if-nez v16, :cond_1d

    new-instance v4, Lorg/mapsforge/core/model/Point;

    invoke-direct {v4, v0, v1, v2, v3}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object v4

    :cond_1d
    sub-double v16, p8, v0

    mul-double v16, v16, v8

    sub-double v18, p10, v2

    mul-double v18, v18, v10

    add-double v16, v16, v18

    div-double v16, v16, v12

    cmpg-double v12, v16, v14

    if-gez v12, :cond_33

    new-instance v4, Lorg/mapsforge/core/model/Point;

    invoke-direct {v4, v0, v1, v2, v3}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object v4

    :cond_33
    const-wide/high16 v12, 0x3ff0000000000000L    # 1.0

    cmpl-double v14, v16, v12

    if-lez v14, :cond_3f

    new-instance v0, Lorg/mapsforge/core/model/Point;

    invoke-direct {v0, v4, v5, v6, v7}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object v0

    :cond_3f
    new-instance v4, Lorg/mapsforge/core/model/Point;

    mul-double v8, v8, v16

    add-double/2addr v0, v8

    mul-double v16, v16, v10

    add-double v2, v2, v16

    invoke-direct {v4, v0, v1, v2, v3}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object v4
.end method

.method public static parseCoordinateString(Ljava/lang/String;I)[D
    .registers 6

    new-instance v0, Ljava/util/StringTokenizer;

    const-string v1, ","

    const/4 v2, 0x1

    invoke-direct {v0, p0, v1, v2}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, p1}, Ljava/util/ArrayList;-><init>(I)V

    :goto_d
    invoke-virtual {v0}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v3

    if-eqz v3, :cond_20

    invoke-virtual {v0}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v3

    xor-int/lit8 v2, v2, 0x1

    if-eqz v2, :cond_1c

    goto :goto_d

    :cond_1c
    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_d

    :cond_20
    if-nez v2, :cond_54

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-ne v0, p1, :cond_3d

    new-array p0, p1, [D

    const/4 v0, 0x0

    :goto_2b
    if-ge v0, p1, :cond_3c

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v2

    aput-wide v2, p0, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_2b

    :cond_3c
    return-object p0

    :cond_3d
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "invalid number of coordinate values: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_54
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "invalid coordinate delimiter: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public static sphericalDistance(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/LatLong;)D
    .registers 10

    iget-wide v0, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v2, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    sub-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v0

    iget-wide v2, p1, Lorg/mapsforge/core/model/LatLong;->longitude:D

    iget-wide v4, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    sub-double/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v2

    const-wide/high16 v4, 0x4000000000000000L    # 2.0

    div-double/2addr v0, v4

    invoke-static {v0, v1}, Ljava/lang/Math;->sin(D)D

    move-result-wide v6

    invoke-static {v0, v1}, Ljava/lang/Math;->sin(D)D

    move-result-wide v0

    mul-double v6, v6, v0

    iget-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v0, v1}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Math;->cos(D)D

    move-result-wide v0

    iget-wide p0, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {p0, p1}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide p0

    invoke-static {p0, p1}, Ljava/lang/Math;->cos(D)D

    move-result-wide p0

    mul-double v0, v0, p0

    div-double/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Math;->sin(D)D

    move-result-wide p0

    mul-double v0, v0, p0

    invoke-static {v2, v3}, Ljava/lang/Math;->sin(D)D

    move-result-wide p0

    mul-double v0, v0, p0

    add-double/2addr v6, v0

    invoke-static {v6, v7}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide p0

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    sub-double/2addr v0, v6

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    invoke-static {p0, p1, v0, v1}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide p0

    mul-double p0, p0, v4

    const-wide v0, 0x415854a640000000L    # 6378137.0

    mul-double p0, p0, v0

    return-wide p0
.end method

.method public static validateLatitude(D)D
    .registers 5

    invoke-static {p0, p1}, Ljava/lang/Double;->isNaN(D)Z

    move-result v0

    if-nez v0, :cond_19

    const-wide v0, -0x3fa9800000000000L    # -90.0

    cmpg-double v2, p0, v0

    if-ltz v2, :cond_19

    const-wide v0, 0x4056800000000000L    # 90.0

    cmpl-double v2, p0, v0

    if-gtz v2, :cond_19

    return-wide p0

    :cond_19
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid latitude: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0, p1}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static validateLongitude(D)D
    .registers 5

    invoke-static {p0, p1}, Ljava/lang/Double;->isNaN(D)Z

    move-result v0

    if-nez v0, :cond_19

    const-wide v0, -0x3f99800000000000L    # -180.0

    cmpg-double v2, p0, v0

    if-ltz v2, :cond_19

    const-wide v0, 0x4066800000000000L    # 180.0

    cmpl-double v2, p0, v0

    if-gtz v2, :cond_19

    return-wide p0

    :cond_19
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid longitude: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0, p1}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static vincentyDistance(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/LatLong;)D
    .registers 42

    invoke-virtual/range {p1 .. p1}, Lorg/mapsforge/core/model/LatLong;->getLongitude()D

    move-result-wide v0

    invoke-virtual/range {p0 .. p0}, Lorg/mapsforge/core/model/LatLong;->getLongitude()D

    move-result-wide v2

    sub-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v0

    invoke-virtual/range {p0 .. p0}, Lorg/mapsforge/core/model/LatLong;->getLatitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Math;->tan(D)D

    move-result-wide v2

    const-wide v4, 0x3fefe488a57b0c1fL    # 0.9966471893352525

    mul-double v2, v2, v4

    invoke-static {v2, v3}, Ljava/lang/Math;->atan(D)D

    move-result-wide v2

    invoke-virtual/range {p1 .. p1}, Lorg/mapsforge/core/model/LatLong;->getLatitude()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Math;->tan(D)D

    move-result-wide v6

    mul-double v4, v4, v6

    invoke-static {v4, v5}, Ljava/lang/Math;->atan(D)D

    move-result-wide v4

    invoke-static {v2, v3}, Ljava/lang/Math;->sin(D)D

    move-result-wide v6

    invoke-static {v2, v3}, Ljava/lang/Math;->cos(D)D

    move-result-wide v2

    invoke-static {v4, v5}, Ljava/lang/Math;->sin(D)D

    move-result-wide v8

    invoke-static {v4, v5}, Ljava/lang/Math;->cos(D)D

    move-result-wide v4

    const-wide/high16 v10, 0x4059000000000000L    # 100.0

    move-wide v12, v0

    :goto_49
    invoke-static {v12, v13}, Ljava/lang/Math;->sin(D)D

    move-result-wide v14

    invoke-static {v12, v13}, Ljava/lang/Math;->cos(D)D

    move-result-wide v16

    mul-double v18, v4, v14

    mul-double v18, v18, v18

    mul-double v20, v2, v8

    mul-double v22, v6, v4

    mul-double v22, v22, v16

    sub-double v20, v20, v22

    mul-double v20, v20, v20

    add-double v18, v18, v20

    move-wide/from16 p0, v10

    invoke-static/range {v18 .. v19}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v10

    const-wide/16 v18, 0x0

    cmpl-double v20, v10, v18

    if-nez v20, :cond_6e

    return-wide v18

    :cond_6e
    mul-double v20, v6, v8

    mul-double v22, v2, v4

    mul-double v16, v16, v22

    move-wide/from16 v24, v2

    add-double v2, v20, v16

    invoke-static {v10, v11, v2, v3}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide v16

    mul-double v22, v22, v14

    div-double v22, v22, v10

    mul-double v14, v22, v22

    const-wide/high16 v20, 0x3ff0000000000000L    # 1.0

    sub-double v14, v20, v14

    move-wide/from16 v26, v4

    const-wide/high16 v4, 0x4000000000000000L    # 2.0

    cmpl-double v28, v14, v18

    if-eqz v28, :cond_97

    mul-double v28, v6, v4

    mul-double v28, v28, v8

    div-double v28, v28, v14

    sub-double v28, v2, v28

    goto :goto_99

    :cond_97
    move-wide/from16 v28, v18

    :goto_99
    const-wide v30, 0x3f2b775a84f3e128L    # 2.0955066654671753E-4

    mul-double v30, v30, v14

    const-wide/high16 v32, 0x4008000000000000L    # 3.0

    mul-double v32, v32, v14

    const-wide/high16 v34, 0x4010000000000000L    # 4.0

    sub-double v32, v34, v32

    const-wide v36, 0x3f6b775a84f3e128L    # 0.0033528106647474805

    mul-double v32, v32, v36

    add-double v32, v32, v34

    mul-double v30, v30, v32

    sub-double v32, v20, v30

    mul-double v32, v32, v36

    mul-double v32, v32, v22

    mul-double v22, v30, v10

    mul-double v30, v30, v2

    const-wide/high16 v36, -0x4010000000000000L    # -1.0

    mul-double v38, v28, v4

    mul-double v38, v38, v28

    add-double v38, v38, v36

    mul-double v30, v30, v38

    add-double v30, v28, v30

    mul-double v22, v22, v30

    add-double v22, v16, v22

    mul-double v32, v32, v22

    add-double v32, v0, v32

    sub-double v12, v32, v12

    invoke-static {v12, v13}, Ljava/lang/Math;->abs(D)D

    move-result-wide v12

    const-wide v22, 0x3d719799812dea11L    # 1.0E-12

    cmpl-double v30, v12, v22

    move-wide/from16 v12, p0

    if-lez v30, :cond_f2

    sub-double v12, v12, v20

    cmpl-double v22, v12, v18

    if-gtz v22, :cond_e9

    goto :goto_f2

    :cond_e9
    move-wide v10, v12

    move-wide/from16 v2, v24

    move-wide/from16 v4, v26

    move-wide/from16 v12, v32

    goto/16 :goto_49

    :cond_f2
    :goto_f2
    cmpl-double v0, v12, v18

    if-nez v0, :cond_f7

    return-wide v18

    :cond_f7
    const-wide v0, 0x415854a640000000L    # 6378137.0

    invoke-static {v0, v1, v4, v5}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    const-wide v6, 0x41583fc4141bda51L    # 6356752.3142

    invoke-static {v6, v7, v4, v5}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v8

    sub-double/2addr v0, v8

    mul-double v14, v14, v0

    invoke-static {v6, v7, v4, v5}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    div-double/2addr v14, v0

    const-wide/high16 v0, 0x40d0000000000000L    # 16384.0

    div-double v0, v14, v0

    const-wide/high16 v4, 0x40b0000000000000L    # 4096.0

    const-wide/high16 v8, -0x3f78000000000000L    # -768.0

    const-wide/high16 v12, 0x4074000000000000L    # 320.0

    const-wide v18, 0x4065e00000000000L    # 175.0

    mul-double v18, v18, v14

    sub-double v12, v12, v18

    mul-double v12, v12, v14

    add-double/2addr v12, v8

    mul-double v12, v12, v14

    add-double/2addr v12, v4

    mul-double v0, v0, v12

    add-double v0, v0, v20

    const-wide/high16 v4, 0x4090000000000000L    # 1024.0

    div-double v4, v14, v4

    const-wide/high16 v8, 0x4070000000000000L    # 256.0

    const-wide/high16 v12, -0x3fa0000000000000L    # -128.0

    const-wide v18, 0x4052800000000000L    # 74.0

    const-wide v20, 0x4047800000000000L    # 47.0

    mul-double v20, v20, v14

    sub-double v18, v18, v20

    mul-double v18, v18, v14

    add-double v18, v18, v12

    mul-double v14, v14, v18

    add-double/2addr v14, v8

    mul-double v4, v4, v14

    mul-double v8, v4, v10

    div-double v12, v4, v34

    mul-double v2, v2, v38

    const-wide/high16 v14, 0x4018000000000000L    # 6.0

    div-double/2addr v4, v14

    mul-double v4, v4, v28

    mul-double v14, v10, v34

    mul-double v14, v14, v10

    const-wide/high16 v10, -0x3ff8000000000000L    # -3.0

    add-double/2addr v14, v10

    mul-double v4, v4, v14

    mul-double v34, v34, v28

    mul-double v34, v34, v28

    add-double v34, v34, v10

    mul-double v4, v4, v34

    sub-double/2addr v2, v4

    mul-double v12, v12, v2

    add-double v28, v28, v12

    mul-double v8, v8, v28

    mul-double v0, v0, v6

    sub-double v16, v16, v8

    mul-double v0, v0, v16

    return-wide v0
.end method

.method public static zoomForBounds(Lorg/mapsforge/core/model/Dimension;Lorg/mapsforge/core/model/BoundingBox;I)B
    .registers 12

    const/4 v0, 0x0

    invoke-static {v0, p2}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v1

    iget-wide v3, p1, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-static {v3, v4, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v3

    iget-wide v5, p1, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-static {v5, v6, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v5

    sub-double/2addr v3, v5

    invoke-static {v3, v4}, Ljava/lang/Math;->abs(D)D

    move-result-wide v3

    iget p2, p0, Lorg/mapsforge/core/model/Dimension;->width:I

    int-to-double v5, p2

    div-double/2addr v3, v5

    invoke-static {v3, v4}, Ljava/lang/Math;->log(D)D

    move-result-wide v3

    neg-double v3, v3

    const-wide/high16 v5, 0x4000000000000000L    # 2.0

    invoke-static {v5, v6}, Ljava/lang/Math;->log(D)D

    move-result-wide v7

    div-double/2addr v3, v7

    iget-wide v7, p1, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {v7, v8, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v7

    iget-wide p1, p1, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {p1, p2, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide p1

    sub-double/2addr v7, p1

    invoke-static {v7, v8}, Ljava/lang/Math;->abs(D)D

    move-result-wide p1

    iget p0, p0, Lorg/mapsforge/core/model/Dimension;->height:I

    int-to-double v1, p0

    div-double/2addr p1, v1

    invoke-static {p1, p2}, Ljava/lang/Math;->log(D)D

    move-result-wide p0

    neg-double p0, p0

    invoke-static {v5, v6}, Ljava/lang/Math;->log(D)D

    move-result-wide v1

    div-double/2addr p0, v1

    invoke-static {v3, v4, p0, p1}, Ljava/lang/Math;->min(DD)D

    move-result-wide p0

    invoke-static {p0, p1}, Ljava/lang/Math;->floor(D)D

    move-result-wide p0

    const-wide/16 v1, 0x0

    cmpg-double p2, p0, v1

    if-gez p2, :cond_54

    return v0

    :cond_54
    const-wide v0, 0x405fc00000000000L    # 127.0

    cmpl-double p2, p0, v0

    if-lez p2, :cond_60

    const/16 p0, 0x7f

    return p0

    :cond_60
    double-to-int p0, p0

    int-to-byte p0, p0

    return p0
.end method
