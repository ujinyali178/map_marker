.class public Lorg/mapsforge/map/util/MapViewProjection;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final INVALID_MAP_VIEW_DIMENSIONS:Ljava/lang/String; = "invalid MapView dimensions"


# instance fields
.field private final mapView:Lorg/mapsforge/map/view/MapView;


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/view/MapView;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    return-void
.end method


# virtual methods
.method public fromPixels(DD)Lorg/mapsforge/core/model/LatLong;
    .registers 16

    iget-object v0, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v0}, Lorg/mapsforge/map/view/MapView;->getWidth()I

    move-result v0

    const/4 v1, 0x0

    if-lez v0, :cond_65

    iget-object v0, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v0}, Lorg/mapsforge/map/view/MapView;->getHeight()I

    move-result v0

    if-gtz v0, :cond_12

    goto :goto_65

    :cond_12
    iget-object v0, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v0}, Lorg/mapsforge/map/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/FrameBufferModel;->getMapPosition()Lorg/mapsforge/core/model/MapPosition;

    move-result-object v0

    if-nez v0, :cond_21

    return-object v1

    :cond_21
    iget-object v2, v0, Lorg/mapsforge/core/model/MapPosition;->latLong:Lorg/mapsforge/core/model/LatLong;

    iget-byte v0, v0, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    iget-object v3, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v3}, Lorg/mapsforge/map/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v3

    iget-object v3, v3, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v3}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v3

    invoke-static {v0, v3}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v3

    iget-wide v5, v2, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v5, v6, v3, v4}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v5

    iget-wide v7, v2, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v7, v8, v3, v4}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v7

    iget-object v0, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v0}, Lorg/mapsforge/map/view/MapView;->getWidth()I

    move-result v0

    shr-int/lit8 v0, v0, 0x1

    int-to-double v9, v0

    sub-double/2addr v5, v9

    iget-object v0, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v0}, Lorg/mapsforge/map/view/MapView;->getHeight()I

    move-result v0

    shr-int/lit8 v0, v0, 0x1

    int-to-double v9, v0

    sub-double/2addr v7, v9

    :try_start_55
    new-instance v0, Lorg/mapsforge/core/model/LatLong;

    add-double/2addr v7, p3

    invoke-static {v7, v8, v3, v4}, Lorg/mapsforge/core/util/MercatorProjection;->pixelYToLatitude(DJ)D

    move-result-wide p3

    add-double/2addr v5, p1

    invoke-static {v5, v6, v3, v4}, Lorg/mapsforge/core/util/MercatorProjection;->pixelXToLongitude(DJ)D

    move-result-wide p1

    invoke-direct {v0, p3, p4, p1, p2}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V
    :try_end_64
    .catch Ljava/lang/Exception; {:try_start_55 .. :try_end_64} :catch_65

    return-object v0

    :catch_65
    :cond_65
    :goto_65
    return-object v1
.end method

.method public getLatitudeSpan()D
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v0}, Lorg/mapsforge/map/view/MapView;->getWidth()I

    move-result v0

    if-lez v0, :cond_2b

    iget-object v0, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v0}, Lorg/mapsforge/map/view/MapView;->getHeight()I

    move-result v0

    if-lez v0, :cond_2b

    const-wide/16 v0, 0x0

    invoke-virtual {p0, v0, v1, v0, v1}, Lorg/mapsforge/map/util/MapViewProjection;->fromPixels(DD)Lorg/mapsforge/core/model/LatLong;

    move-result-object v2

    iget-object v3, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v3}, Lorg/mapsforge/map/view/MapView;->getHeight()I

    move-result v3

    int-to-double v3, v3

    invoke-virtual {p0, v0, v1, v3, v4}, Lorg/mapsforge/map/util/MapViewProjection;->fromPixels(DD)Lorg/mapsforge/core/model/LatLong;

    move-result-object v0

    iget-wide v1, v2, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v3, v0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    sub-double/2addr v1, v3

    invoke-static {v1, v2}, Ljava/lang/Math;->abs(D)D

    move-result-wide v0

    return-wide v0

    :cond_2b
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "invalid MapView dimensions"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getLongitudeSpan()D
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v0}, Lorg/mapsforge/map/view/MapView;->getWidth()I

    move-result v0

    if-lez v0, :cond_2b

    iget-object v0, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v0}, Lorg/mapsforge/map/view/MapView;->getHeight()I

    move-result v0

    if-lez v0, :cond_2b

    const-wide/16 v0, 0x0

    invoke-virtual {p0, v0, v1, v0, v1}, Lorg/mapsforge/map/util/MapViewProjection;->fromPixels(DD)Lorg/mapsforge/core/model/LatLong;

    move-result-object v2

    iget-object v3, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v3}, Lorg/mapsforge/map/view/MapView;->getWidth()I

    move-result v3

    int-to-double v3, v3

    invoke-virtual {p0, v3, v4, v0, v1}, Lorg/mapsforge/map/util/MapViewProjection;->fromPixels(DD)Lorg/mapsforge/core/model/LatLong;

    move-result-object v0

    iget-wide v1, v2, Lorg/mapsforge/core/model/LatLong;->longitude:D

    iget-wide v3, v0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    sub-double/2addr v1, v3

    invoke-static {v1, v2}, Ljava/lang/Math;->abs(D)D

    move-result-wide v0

    return-wide v0

    :cond_2b
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "invalid MapView dimensions"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public toPixels(Lorg/mapsforge/core/model/LatLong;)Lorg/mapsforge/core/model/Point;
    .registers 11

    const/4 v0, 0x0

    if-eqz p1, :cond_6e

    iget-object v1, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v1}, Lorg/mapsforge/map/view/MapView;->getWidth()I

    move-result v1

    if-lez v1, :cond_6e

    iget-object v1, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v1}, Lorg/mapsforge/map/view/MapView;->getHeight()I

    move-result v1

    if-gtz v1, :cond_14

    goto :goto_6e

    :cond_14
    iget-object v1, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v1}, Lorg/mapsforge/map/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v1

    iget-object v1, v1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v1}, Lorg/mapsforge/map/model/IMapViewPosition;->getMapPosition()Lorg/mapsforge/core/model/MapPosition;

    move-result-object v1

    if-nez v1, :cond_23

    return-object v0

    :cond_23
    iget-object v0, v1, Lorg/mapsforge/core/model/MapPosition;->latLong:Lorg/mapsforge/core/model/LatLong;

    iget-byte v1, v1, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    iget-object v2, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v2}, Lorg/mapsforge/map/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v2

    iget-object v2, v2, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v2

    invoke-static {v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v1

    iget-wide v3, v0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v3, v4, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v3

    iget-wide v5, v0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v5, v6, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v5

    iget-object v0, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v0}, Lorg/mapsforge/map/view/MapView;->getWidth()I

    move-result v0

    shr-int/lit8 v0, v0, 0x1

    int-to-double v7, v0

    sub-double/2addr v3, v7

    iget-object v0, p0, Lorg/mapsforge/map/util/MapViewProjection;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v0}, Lorg/mapsforge/map/view/MapView;->getHeight()I

    move-result v0

    shr-int/lit8 v0, v0, 0x1

    int-to-double v7, v0

    sub-double/2addr v5, v7

    new-instance v0, Lorg/mapsforge/core/model/Point;

    iget-wide v7, p1, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v7, v8, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v7

    sub-double/2addr v7, v3

    double-to-int v3, v7

    int-to-double v3, v3

    iget-wide v7, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v7, v8, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v1

    sub-double/2addr v1, v5

    double-to-int p1, v1

    int-to-double v1, p1

    invoke-direct {v0, v3, v4, v1, v2}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    :cond_6e
    :goto_6e
    return-object v0
.end method
