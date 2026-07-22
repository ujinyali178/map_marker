.class public final Lorg/mapsforge/core/util/MercatorProjection;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final DUMMY_TILE_SIZE:I = 0x100

.field public static final EARTH_CIRCUMFERENCE:D = 4.0075016686E7

.field public static final LATITUDE_MAX:D = 85.05112877980659

.field public static final LATITUDE_MIN:D = -85.05112877980659


# direct methods
.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method public static calculateGroundResolution(DJ)D
    .registers 6

    const-wide v0, 0x3f91df46a2529d39L    # 0.017453292519943295

    mul-double p0, p0, v0

    invoke-static {p0, p1}, Ljava/lang/Math;->cos(D)D

    move-result-wide p0

    const-wide v0, 0x41831bf8457ced91L    # 4.0075016686E7

    mul-double p0, p0, v0

    long-to-double p2, p2

    div-double/2addr p0, p2

    return-wide p0
.end method

.method public static calculateGroundResolutionWithScaleFactor(DDI)D
    .registers 7

    invoke-static {p2, p3, p4}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSizeWithScaleFactor(DI)J

    move-result-wide p2

    const-wide v0, 0x3f91df46a2529d39L    # 0.017453292519943295

    mul-double p0, p0, v0

    invoke-static {p0, p1}, Ljava/lang/Math;->cos(D)D

    move-result-wide p0

    const-wide v0, 0x41831bf8457ced91L    # 4.0075016686E7

    mul-double p0, p0, v0

    long-to-double p2, p2

    div-double/2addr p0, p2

    return-wide p0
.end method

.method public static fromPixels(DDJ)Lorg/mapsforge/core/model/LatLong;
    .registers 7

    new-instance v0, Lorg/mapsforge/core/model/LatLong;

    invoke-static {p2, p3, p4, p5}, Lorg/mapsforge/core/util/MercatorProjection;->pixelYToLatitude(DJ)D

    move-result-wide p2

    invoke-static {p0, p1, p4, p5}, Lorg/mapsforge/core/util/MercatorProjection;->pixelXToLongitude(DJ)D

    move-result-wide p0

    invoke-direct {v0, p2, p3, p0, p1}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    return-object v0
.end method

.method public static fromPixelsWithScaleFactor(DDDI)Lorg/mapsforge/core/model/LatLong;
    .registers 8

    new-instance v0, Lorg/mapsforge/core/model/LatLong;

    invoke-static {p2, p3, p4, p5, p6}, Lorg/mapsforge/core/util/MercatorProjection;->pixelYToLatitudeWithScaleFactor(DDI)D

    move-result-wide p2

    invoke-static {p0, p1, p4, p5, p6}, Lorg/mapsforge/core/util/MercatorProjection;->pixelXToLongitudeWithScaleFactor(DDI)D

    move-result-wide p0

    invoke-direct {v0, p2, p3, p0, p1}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    return-object v0
.end method

.method public static getMapSize(BI)J
    .registers 4

    if-ltz p0, :cond_6

    int-to-long v0, p1

    shl-long p0, v0, p0

    return-wide p0

    :cond_6
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "zoom level must not be negative: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public static getMapSizeWithScaleFactor(DI)J
    .registers 7

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    cmpg-double v2, p0, v0

    if-ltz v2, :cond_15

    int-to-double v0, p2

    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    invoke-static {p0, p1}, Lorg/mapsforge/core/util/MercatorProjection;->scaleFactorToZoomLevel(D)D

    move-result-wide p0

    invoke-static {v2, v3, p0, p1}, Ljava/lang/Math;->pow(DD)D

    move-result-wide p0

    mul-double v0, v0, p0

    double-to-long p0, v0

    return-wide p0

    :cond_15
    new-instance p2, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "scale factor must not < 1 "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p2, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p2
.end method

.method public static getPixel(Lorg/mapsforge/core/model/LatLong;J)Lorg/mapsforge/core/model/Point;
    .registers 7

    iget-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v0, v1, p1, p2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v0

    iget-wide v2, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v2, v3, p1, p2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide p0

    new-instance p2, Lorg/mapsforge/core/model/Point;

    invoke-direct {p2, v0, v1, p0, p1}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object p2
.end method

.method public static getPixelAbsolute(Lorg/mapsforge/core/model/LatLong;J)Lorg/mapsforge/core/model/Point;
    .registers 10

    const-wide/16 v3, 0x0

    const-wide/16 v5, 0x0

    move-object v0, p0

    move-wide v1, p1

    invoke-static/range {v0 .. v6}, Lorg/mapsforge/core/util/MercatorProjection;->getPixelRelative(Lorg/mapsforge/core/model/LatLong;JDD)Lorg/mapsforge/core/model/Point;

    move-result-object p0

    return-object p0
.end method

.method public static getPixelRelative(Lorg/mapsforge/core/model/LatLong;JDD)Lorg/mapsforge/core/model/Point;
    .registers 9

    iget-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v0, v1, p1, p2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v0

    sub-double/2addr v0, p3

    iget-wide p3, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {p3, p4, p1, p2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide p0

    sub-double/2addr p0, p5

    new-instance p2, Lorg/mapsforge/core/model/Point;

    invoke-direct {p2, v0, v1, p0, p1}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object p2
.end method

.method public static getPixelRelative(Lorg/mapsforge/core/model/LatLong;JLorg/mapsforge/core/model/Point;)Lorg/mapsforge/core/model/Point;
    .registers 11

    iget-wide v3, p3, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v5, p3, Lorg/mapsforge/core/model/Point;->y:D

    move-object v0, p0

    move-wide v1, p1

    invoke-static/range {v0 .. v6}, Lorg/mapsforge/core/util/MercatorProjection;->getPixelRelative(Lorg/mapsforge/core/model/LatLong;JDD)Lorg/mapsforge/core/model/Point;

    move-result-object p0

    return-object p0
.end method

.method public static getPixelRelativeToTile(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/core/model/Point;
    .registers 4

    iget-wide v0, p1, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-virtual {p1}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object p1

    invoke-static {p0, v0, v1, p1}, Lorg/mapsforge/core/util/MercatorProjection;->getPixelRelative(Lorg/mapsforge/core/model/LatLong;JLorg/mapsforge/core/model/Point;)Lorg/mapsforge/core/model/Point;

    move-result-object p0

    return-object p0
.end method

.method public static getPixelWithScaleFactor(Lorg/mapsforge/core/model/LatLong;DI)Lorg/mapsforge/core/model/Point;
    .registers 8

    iget-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v0, v1, p1, p2, p3}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelXWithScaleFactor(DDI)D

    move-result-wide v0

    iget-wide v2, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v2, v3, p1, p2, p3}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelYWithScaleFactor(DDI)D

    move-result-wide p0

    new-instance p2, Lorg/mapsforge/core/model/Point;

    invoke-direct {p2, v0, v1, p0, p1}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object p2
.end method

.method public static latitudeToPixelY(DBI)D
    .registers 8

    const-wide v0, 0x3f91df46a2529d39L    # 0.017453292519943295

    mul-double p0, p0, v0

    invoke-static {p0, p1}, Ljava/lang/Math;->sin(D)D

    move-result-wide p0

    invoke-static {p2, p3}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide p2

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    add-double v2, p0, v0

    sub-double/2addr v0, p0

    div-double/2addr v2, v0

    invoke-static {v2, v3}, Ljava/lang/Math;->log(D)D

    move-result-wide p0

    const-wide v0, 0x402921fb54442d18L    # 12.566370614359172

    div-double/2addr p0, v0

    const-wide/high16 v0, 0x3fe0000000000000L    # 0.5

    sub-double/2addr v0, p0

    long-to-double p0, p2

    mul-double v0, v0, p0

    const-wide/16 p2, 0x0

    invoke-static {p2, p3, v0, v1}, Ljava/lang/Math;->max(DD)D

    move-result-wide p2

    invoke-static {p2, p3, p0, p1}, Ljava/lang/Math;->min(DD)D

    move-result-wide p0

    return-wide p0
.end method

.method public static latitudeToPixelY(DJ)D
    .registers 8

    const-wide v0, 0x3f91df46a2529d39L    # 0.017453292519943295

    mul-double p0, p0, v0

    invoke-static {p0, p1}, Ljava/lang/Math;->sin(D)D

    move-result-wide p0

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    add-double v2, p0, v0

    sub-double/2addr v0, p0

    div-double/2addr v2, v0

    invoke-static {v2, v3}, Ljava/lang/Math;->log(D)D

    move-result-wide p0

    const-wide v0, 0x402921fb54442d18L    # 12.566370614359172

    div-double/2addr p0, v0

    const-wide/high16 v0, 0x3fe0000000000000L    # 0.5

    sub-double/2addr v0, p0

    long-to-double p0, p2

    mul-double v0, v0, p0

    const-wide/16 p2, 0x0

    invoke-static {p2, p3, v0, v1}, Ljava/lang/Math;->max(DD)D

    move-result-wide p2

    invoke-static {p2, p3, p0, p1}, Ljava/lang/Math;->min(DD)D

    move-result-wide p0

    return-wide p0
.end method

.method public static latitudeToPixelYWithScaleFactor(DDI)D
    .registers 9

    const-wide v0, 0x3f91df46a2529d39L    # 0.017453292519943295

    mul-double p0, p0, v0

    invoke-static {p0, p1}, Ljava/lang/Math;->sin(D)D

    move-result-wide p0

    invoke-static {p2, p3, p4}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSizeWithScaleFactor(DI)J

    move-result-wide p2

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    add-double v2, p0, v0

    sub-double/2addr v0, p0

    div-double/2addr v2, v0

    invoke-static {v2, v3}, Ljava/lang/Math;->log(D)D

    move-result-wide p0

    const-wide v0, 0x402921fb54442d18L    # 12.566370614359172

    div-double/2addr p0, v0

    const-wide/high16 v0, 0x3fe0000000000000L    # 0.5

    sub-double/2addr v0, p0

    long-to-double p0, p2

    mul-double v0, v0, p0

    const-wide/16 p2, 0x0

    invoke-static {p2, p3, v0, v1}, Ljava/lang/Math;->max(DD)D

    move-result-wide p2

    invoke-static {p2, p3, p0, p1}, Ljava/lang/Math;->min(DD)D

    move-result-wide p0

    return-wide p0
.end method

.method public static latitudeToTileY(DB)I
    .registers 4

    const/16 v0, 0x100

    invoke-static {p0, p1, p2, v0}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DBI)D

    move-result-wide p0

    invoke-static {p0, p1, p2, v0}, Lorg/mapsforge/core/util/MercatorProjection;->pixelYToTileY(DBI)I

    move-result p0

    return p0
.end method

.method public static latitudeToTileYWithScaleFactor(DD)I
    .registers 5

    const/16 v0, 0x100

    invoke-static {p0, p1, p2, p3, v0}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelYWithScaleFactor(DDI)D

    move-result-wide p0

    invoke-static {p0, p1, p2, p3, v0}, Lorg/mapsforge/core/util/MercatorProjection;->pixelYToTileYWithScaleFactor(DDI)I

    move-result p0

    return p0
.end method

.method public static longitudeToPixelX(DBI)D
    .registers 6

    invoke-static {p2, p3}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide p2

    const-wide v0, 0x4066800000000000L    # 180.0

    add-double/2addr p0, v0

    const-wide v0, 0x4076800000000000L    # 360.0

    div-double/2addr p0, v0

    long-to-double p2, p2

    mul-double p0, p0, p2

    return-wide p0
.end method

.method public static longitudeToPixelX(DJ)D
    .registers 6

    const-wide v0, 0x4066800000000000L    # 180.0

    add-double/2addr p0, v0

    const-wide v0, 0x4076800000000000L    # 360.0

    div-double/2addr p0, v0

    long-to-double p2, p2

    mul-double p0, p0, p2

    return-wide p0
.end method

.method public static longitudeToPixelXWithScaleFactor(DDI)D
    .registers 7

    invoke-static {p2, p3, p4}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSizeWithScaleFactor(DI)J

    move-result-wide p2

    const-wide v0, 0x4066800000000000L    # 180.0

    add-double/2addr p0, v0

    const-wide v0, 0x4076800000000000L    # 360.0

    div-double/2addr p0, v0

    long-to-double p2, p2

    mul-double p0, p0, p2

    return-wide p0
.end method

.method public static longitudeToTileX(DB)I
    .registers 4

    const/16 v0, 0x100

    invoke-static {p0, p1, p2, v0}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DBI)D

    move-result-wide p0

    invoke-static {p0, p1, p2, v0}, Lorg/mapsforge/core/util/MercatorProjection;->pixelXToTileX(DBI)I

    move-result p0

    return p0
.end method

.method public static longitudeToTileXWithScaleFactor(DD)I
    .registers 5

    const/16 v0, 0x100

    invoke-static {p0, p1, p2, p3, v0}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelXWithScaleFactor(DDI)D

    move-result-wide p0

    invoke-static {p0, p1, p2, p3, v0}, Lorg/mapsforge/core/util/MercatorProjection;->pixelXToTileXWithScaleFactor(DDI)I

    move-result p0

    return p0
.end method

.method public static metersToPixels(FDJ)D
    .registers 7

    float-to-double v0, p0

    invoke-static {p1, p2, p3, p4}, Lorg/mapsforge/core/util/MercatorProjection;->calculateGroundResolution(DJ)D

    move-result-wide p0

    div-double/2addr v0, p0

    return-wide v0
.end method

.method public static metersToPixelsWithScaleFactor(FDDI)D
    .registers 8

    float-to-double v0, p0

    invoke-static {p1, p2, p3, p4, p5}, Lorg/mapsforge/core/util/MercatorProjection;->calculateGroundResolutionWithScaleFactor(DDI)D

    move-result-wide p0

    div-double/2addr v0, p0

    return-wide v0
.end method

.method public static pixelXToLongitude(DJ)D
    .registers 7

    const-wide/16 v0, 0x0

    cmpg-double v2, p0, v0

    if-ltz v2, :cond_17

    long-to-double v0, p2

    cmpl-double v2, p0, v0

    if-gtz v2, :cond_17

    const-wide p2, 0x4076800000000000L    # 360.0

    div-double/2addr p0, v0

    const-wide/high16 v0, 0x3fe0000000000000L    # 0.5

    sub-double/2addr p0, v0

    mul-double p0, p0, p2

    return-wide p0

    :cond_17
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid pixelX coordinate "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string p2, ": "

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0, p1}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static pixelXToLongitudeWithScaleFactor(DDI)D
    .registers 9

    invoke-static {p2, p3, p4}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSizeWithScaleFactor(DI)J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmpg-double p4, p0, v2

    if-ltz p4, :cond_1b

    long-to-double v0, v0

    cmpl-double p4, p0, v0

    if-gtz p4, :cond_1b

    const-wide p2, 0x4076800000000000L    # 360.0

    div-double/2addr p0, v0

    const-wide/high16 v0, 0x3fe0000000000000L    # 0.5

    sub-double/2addr p0, v0

    mul-double p0, p0, p2

    return-wide p0

    :cond_1b
    new-instance p4, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "invalid pixelX coordinate at scale "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2, p3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string p2, ": "

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p4, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p4
.end method

.method public static pixelXToTileX(DBI)I
    .registers 6

    int-to-double v0, p3

    div-double/2addr p0, v0

    const-wide/16 v0, 0x0

    invoke-static {p0, p1, v0, v1}, Ljava/lang/Math;->max(DD)D

    move-result-wide p0

    int-to-double p2, p2

    const-wide/high16 v0, 0x4000000000000000L    # 2.0

    invoke-static {v0, v1, p2, p3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide p2

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    sub-double/2addr p2, v0

    invoke-static {p0, p1, p2, p3}, Ljava/lang/Math;->min(DD)D

    move-result-wide p0

    double-to-int p0, p0

    return p0
.end method

.method public static pixelXToTileXWithScaleFactor(DDI)I
    .registers 7

    int-to-double v0, p4

    div-double/2addr p0, v0

    const-wide/16 v0, 0x0

    invoke-static {p0, p1, v0, v1}, Ljava/lang/Math;->max(DD)D

    move-result-wide p0

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    sub-double/2addr p2, v0

    invoke-static {p0, p1, p2, p3}, Ljava/lang/Math;->min(DD)D

    move-result-wide p0

    double-to-int p0, p0

    return p0
.end method

.method public static pixelYToLatitude(DJ)D
    .registers 8

    const-wide/16 v0, 0x0

    cmpg-double v2, p0, v0

    if-ltz v2, :cond_33

    long-to-double v0, p2

    cmpl-double v2, p0, v0

    if-gtz v2, :cond_33

    const-wide/high16 p2, 0x3fe0000000000000L    # 0.5

    div-double/2addr p0, v0

    sub-double/2addr p2, p0

    const-wide p0, 0x4056800000000000L    # 90.0

    const-wide v0, 0x4076800000000000L    # 360.0

    neg-double p2, p2

    const-wide v2, 0x401921fb54442d18L    # 6.283185307179586

    mul-double p2, p2, v2

    invoke-static {p2, p3}, Ljava/lang/Math;->exp(D)D

    move-result-wide p2

    invoke-static {p2, p3}, Ljava/lang/Math;->atan(D)D

    move-result-wide p2

    mul-double p2, p2, v0

    const-wide v0, 0x400921fb54442d18L    # Math.PI

    div-double/2addr p2, v0

    sub-double/2addr p0, p2

    return-wide p0

    :cond_33
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid pixelY coordinate "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string p2, ": "

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0, p1}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static pixelYToLatitudeWithScaleFactor(DDI)D
    .registers 9

    invoke-static {p2, p3, p4}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSizeWithScaleFactor(DI)J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmpg-double p4, p0, v2

    if-ltz p4, :cond_37

    long-to-double v0, v0

    cmpl-double p4, p0, v0

    if-gtz p4, :cond_37

    const-wide/high16 p2, 0x3fe0000000000000L    # 0.5

    div-double/2addr p0, v0

    sub-double/2addr p2, p0

    const-wide p0, 0x4056800000000000L    # 90.0

    const-wide v0, 0x4076800000000000L    # 360.0

    neg-double p2, p2

    const-wide v2, 0x401921fb54442d18L    # 6.283185307179586

    mul-double p2, p2, v2

    invoke-static {p2, p3}, Ljava/lang/Math;->exp(D)D

    move-result-wide p2

    invoke-static {p2, p3}, Ljava/lang/Math;->atan(D)D

    move-result-wide p2

    mul-double p2, p2, v0

    const-wide v0, 0x400921fb54442d18L    # Math.PI

    div-double/2addr p2, v0

    sub-double/2addr p0, p2

    return-wide p0

    :cond_37
    new-instance p4, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "invalid pixelY coordinate at scale "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2, p3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string p2, ": "

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p4, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p4
.end method

.method public static pixelYToTileY(DBI)I
    .registers 6

    int-to-double v0, p3

    div-double/2addr p0, v0

    const-wide/16 v0, 0x0

    invoke-static {p0, p1, v0, v1}, Ljava/lang/Math;->max(DD)D

    move-result-wide p0

    int-to-double p2, p2

    const-wide/high16 v0, 0x4000000000000000L    # 2.0

    invoke-static {v0, v1, p2, p3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide p2

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    sub-double/2addr p2, v0

    invoke-static {p0, p1, p2, p3}, Ljava/lang/Math;->min(DD)D

    move-result-wide p0

    double-to-int p0, p0

    return p0
.end method

.method public static pixelYToTileYWithScaleFactor(DDI)I
    .registers 7

    int-to-double v0, p4

    div-double/2addr p0, v0

    const-wide/16 v0, 0x0

    invoke-static {p0, p1, v0, v1}, Ljava/lang/Math;->max(DD)D

    move-result-wide p0

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    sub-double/2addr p2, v0

    invoke-static {p0, p1, p2, p3}, Ljava/lang/Math;->min(DD)D

    move-result-wide p0

    double-to-int p0, p0

    return p0
.end method

.method public static scaleFactorToZoomLevel(D)D
    .registers 4

    invoke-static {p0, p1}, Ljava/lang/Math;->log(D)D

    move-result-wide p0

    const-wide/high16 v0, 0x4000000000000000L    # 2.0

    invoke-static {v0, v1}, Ljava/lang/Math;->log(D)D

    move-result-wide v0

    div-double/2addr p0, v0

    return-wide p0
.end method

.method public static tileToPixel(JI)J
    .registers 5

    int-to-long v0, p2

    mul-long p0, p0, v0

    return-wide p0
.end method

.method public static tileXToLongitude(JB)D
    .registers 5

    const-wide/16 v0, 0x100

    mul-long p0, p0, v0

    long-to-double p0, p0

    const/16 v0, 0x100

    invoke-static {p2, v0}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v0

    invoke-static {p0, p1, v0, v1}, Lorg/mapsforge/core/util/MercatorProjection;->pixelXToLongitude(DJ)D

    move-result-wide p0

    return-wide p0
.end method

.method public static tileXToLongitudeWithScaleFactor(JD)D
    .registers 6

    const-wide/16 v0, 0x100

    mul-long p0, p0, v0

    long-to-double p0, p0

    const/16 v0, 0x100

    invoke-static {p0, p1, p2, p3, v0}, Lorg/mapsforge/core/util/MercatorProjection;->pixelXToLongitudeWithScaleFactor(DDI)D

    move-result-wide p0

    return-wide p0
.end method

.method public static tileYToLatitude(JB)D
    .registers 5

    const-wide/16 v0, 0x100

    mul-long p0, p0, v0

    long-to-double p0, p0

    const/16 v0, 0x100

    invoke-static {p2, v0}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v0

    invoke-static {p0, p1, v0, v1}, Lorg/mapsforge/core/util/MercatorProjection;->pixelYToLatitude(DJ)D

    move-result-wide p0

    return-wide p0
.end method

.method public static tileYToLatitudeWithScaleFactor(JD)D
    .registers 6

    const-wide/16 v0, 0x100

    mul-long p0, p0, v0

    long-to-double p0, p0

    const/16 v0, 0x100

    invoke-static {p0, p1, p2, p3, v0}, Lorg/mapsforge/core/util/MercatorProjection;->pixelYToLatitudeWithScaleFactor(DDI)D

    move-result-wide p0

    return-wide p0
.end method

.method public static zoomLevelToScaleFactor(B)D
    .registers 5

    int-to-double v0, p0

    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    invoke-static {v2, v3, v0, v1}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    return-wide v0
.end method
