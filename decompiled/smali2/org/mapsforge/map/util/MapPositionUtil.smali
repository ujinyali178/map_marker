.class public final Lorg/mapsforge/map/util/MapPositionUtil;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method public static getBoundingBox(Lorg/mapsforge/core/model/MapPosition;Lorg/mapsforge/core/model/Dimension;I)Lorg/mapsforge/core/model/BoundingBox;
    .registers 26

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    iget-byte v2, v0, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    move/from16 v3, p2

    invoke-static {v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v2

    iget-object v4, v0, Lorg/mapsforge/core/model/MapPosition;->latLong:Lorg/mapsforge/core/model/LatLong;

    iget-wide v4, v4, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v4, v5, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v4

    iget-object v0, v0, Lorg/mapsforge/core/model/MapPosition;->latLong:Lorg/mapsforge/core/model/LatLong;

    iget-wide v6, v0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v6, v7, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v6

    iget v0, v1, Lorg/mapsforge/core/model/Dimension;->width:I

    div-int/lit8 v0, v0, 0x2

    iget v1, v1, Lorg/mapsforge/core/model/Dimension;->height:I

    div-int/lit8 v1, v1, 0x2

    int-to-double v8, v0

    sub-double v10, v4, v8

    const-wide/16 v12, 0x0

    invoke-static {v12, v13, v10, v11}, Ljava/lang/Math;->max(DD)D

    move-result-wide v10

    int-to-double v0, v1

    sub-double v14, v6, v0

    invoke-static {v12, v13, v14, v15}, Ljava/lang/Math;->max(DD)D

    move-result-wide v12

    long-to-double v14, v2

    add-double/2addr v4, v8

    invoke-static {v14, v15, v4, v5}, Ljava/lang/Math;->min(DD)D

    move-result-wide v4

    add-double/2addr v6, v0

    invoke-static {v14, v15, v6, v7}, Ljava/lang/Math;->min(DD)D

    move-result-wide v0

    invoke-static {v0, v1, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->pixelYToLatitude(DJ)D

    move-result-wide v15

    invoke-static {v10, v11, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->pixelXToLongitude(DJ)D

    move-result-wide v17

    invoke-static {v12, v13, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->pixelYToLatitude(DJ)D

    move-result-wide v19

    invoke-static {v4, v5, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->pixelXToLongitude(DJ)D

    move-result-wide v21

    new-instance v0, Lorg/mapsforge/core/model/BoundingBox;

    move-object v14, v0

    invoke-direct/range {v14 .. v22}, Lorg/mapsforge/core/model/BoundingBox;-><init>(DDDD)V

    return-object v0
.end method

.method public static getTopLeftPoint(Lorg/mapsforge/core/model/MapPosition;Lorg/mapsforge/core/model/Dimension;I)Lorg/mapsforge/core/model/Point;
    .registers 11

    iget-object v0, p0, Lorg/mapsforge/core/model/MapPosition;->latLong:Lorg/mapsforge/core/model/LatLong;

    iget v1, p1, Lorg/mapsforge/core/model/Dimension;->width:I

    div-int/lit8 v1, v1, 0x2

    iget p1, p1, Lorg/mapsforge/core/model/Dimension;->height:I

    div-int/lit8 p1, p1, 0x2

    iget-byte p0, p0, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    invoke-static {p0, p2}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v2

    iget-wide v4, v0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v4, v5, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Math;->round(D)J

    move-result-wide v4

    long-to-double v4, v4

    iget-wide v6, v0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v6, v7, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Math;->round(D)J

    move-result-wide v2

    long-to-double v2, v2

    new-instance p0, Lorg/mapsforge/core/model/Point;

    double-to-long v4, v4

    int-to-long v0, v1

    sub-long/2addr v4, v0

    long-to-double v0, v4

    double-to-long v2, v2

    int-to-long p1, p1

    sub-long/2addr v2, p1

    long-to-double p1, v2

    invoke-direct {p0, v0, v1, p1, p2}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    return-object p0
.end method
