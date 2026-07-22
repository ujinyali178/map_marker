.class public Lorg/mapsforge/map/model/MapViewPosition;
.super Lorg/mapsforge/map/model/common/Observable;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/model/IMapViewPosition;
.implements Lorg/mapsforge/map/model/common/Persistable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/model/MapViewPosition$Animator;
    }
.end annotation


# static fields
.field private static final LATITUDE:Ljava/lang/String; = "latitude"

.field private static final LATITUDE_MAX:Ljava/lang/String; = "latitudeMax"

.field private static final LATITUDE_MIN:Ljava/lang/String; = "latitudeMin"

.field private static final LONGITUDE:Ljava/lang/String; = "longitude"

.field private static final LONGITUDE_MAX:Ljava/lang/String; = "longitudeMax"

.field private static final LONGITUDE_MIN:Ljava/lang/String; = "longitudeMin"

.field private static final ZOOM_LEVEL:Ljava/lang/String; = "zoomLevel"

.field private static final ZOOM_LEVEL_MAX:Ljava/lang/String; = "zoomLevelMax"

.field private static final ZOOM_LEVEL_MIN:Ljava/lang/String; = "zoomLevelMin"


# instance fields
.field private final animator:Lorg/mapsforge/map/model/MapViewPosition$Animator;

.field private final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field private latitude:D

.field private longitude:D

.field private mapLimit:Lorg/mapsforge/core/model/BoundingBox;

.field private pivot:Lorg/mapsforge/core/model/LatLong;

.field private scaleFactor:D

.field private zoomLevel:B

.field private zoomLevelMax:B

.field private zoomLevelMin:B


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 3

    invoke-direct {p0}, Lorg/mapsforge/map/model/common/Observable;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    const/16 p1, 0x7f

    iput-byte p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMax:B

    new-instance p1, Lorg/mapsforge/map/model/MapViewPosition$Animator;

    const/4 v0, 0x0

    invoke-direct {p1, p0, v0}, Lorg/mapsforge/map/model/MapViewPosition$Animator;-><init>(Lorg/mapsforge/map/model/MapViewPosition;Lorg/mapsforge/map/model/MapViewPosition$1;)V

    iput-object p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->animator:Lorg/mapsforge/map/model/MapViewPosition$Animator;

    invoke-virtual {p1}, Ljava/lang/Thread;->start()V

    return-void
.end method

.method static synthetic access$000(Lorg/mapsforge/map/model/MapViewPosition;)D
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->longitude:D

    return-wide v0
.end method

.method static synthetic access$100(Lorg/mapsforge/map/model/MapViewPosition;)D
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->latitude:D

    return-wide v0
.end method

.method static synthetic access$200(Lorg/mapsforge/map/model/MapViewPosition;)B
    .registers 1

    iget-byte p0, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B

    return p0
.end method

.method static synthetic access$300(Lorg/mapsforge/map/model/MapViewPosition;)Lorg/mapsforge/map/model/DisplayModel;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/model/MapViewPosition;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    return-object p0
.end method

.method private static varargs isNan([D)Z
    .registers 6

    array-length v0, p0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_3
    if-ge v2, v0, :cond_12

    aget-wide v3, p0, v2

    invoke-static {v3, v4}, Ljava/lang/Double;->isNaN(D)Z

    move-result v3

    if-eqz v3, :cond_f

    const/4 p0, 0x1

    return p0

    :cond_f
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    :cond_12
    return v1
.end method

.method private setCenterInternal(DD)V
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->mapLimit:Lorg/mapsforge/core/model/BoundingBox;

    if-nez v0, :cond_9

    iput-wide p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->latitude:D

    iput-wide p3, p0, Lorg/mapsforge/map/model/MapViewPosition;->longitude:D

    goto :goto_2b

    :cond_9
    iget-wide v0, v0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-static {p1, p2, v0, v1}, Ljava/lang/Math;->min(DD)D

    move-result-wide p1

    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->mapLimit:Lorg/mapsforge/core/model/BoundingBox;

    iget-wide v0, v0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-static {p1, p2, v0, v1}, Ljava/lang/Math;->max(DD)D

    move-result-wide p1

    iput-wide p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->latitude:D

    iget-object p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->mapLimit:Lorg/mapsforge/core/model/BoundingBox;

    iget-wide p1, p1, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-static {p3, p4, p1, p2}, Ljava/lang/Math;->min(DD)D

    move-result-wide p1

    iget-object p3, p0, Lorg/mapsforge/map/model/MapViewPosition;->mapLimit:Lorg/mapsforge/core/model/BoundingBox;

    iget-wide p3, p3, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-static {p1, p2, p3, p4}, Ljava/lang/Math;->max(DD)D

    move-result-wide p1

    iput-wide p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->longitude:D

    :goto_2b
    return-void
.end method

.method private setZoomLevelInternal(IZ)V
    .registers 9

    iget-byte v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMax:B

    invoke-static {p1, v0}, Ljava/lang/Math;->min(II)I

    move-result p1

    iget-byte v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMin:B

    invoke-static {p1, v0}, Ljava/lang/Math;->max(II)I

    move-result p1

    int-to-byte p1, p1

    iput-byte p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B

    const-wide/high16 v0, 0x4000000000000000L    # 2.0

    if-eqz p2, :cond_24

    iget-object p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->animator:Lorg/mapsforge/map/model/MapViewPosition$Animator;

    invoke-virtual {p0}, Lorg/mapsforge/map/model/MapViewPosition;->getScaleFactor()D

    move-result-wide v2

    iget-byte p2, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B

    int-to-double v4, p2

    invoke-static {v0, v1, v4, v5}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    invoke-virtual {p1, v2, v3, v0, v1}, Lorg/mapsforge/map/model/MapViewPosition$Animator;->startAnimationZoom(DD)V

    goto :goto_30

    :cond_24
    int-to-double p1, p1

    invoke-static {v0, v1, p1, p2}, Ljava/lang/Math;->pow(DD)D

    move-result-wide p1

    invoke-virtual {p0, p1, p2}, Lorg/mapsforge/map/model/MapViewPosition;->setScaleFactor(D)V

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/model/MapViewPosition;->setPivot(Lorg/mapsforge/core/model/LatLong;)V

    :goto_30
    return-void
.end method


# virtual methods
.method public animateTo(Lorg/mapsforge/core/model/LatLong;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->animator:Lorg/mapsforge/map/model/MapViewPosition$Animator;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/model/MapViewPosition$Animator;->startAnimationMove(Lorg/mapsforge/core/model/LatLong;)V

    return-void
.end method

.method public animationInProgress()Z
    .registers 6

    iget-wide v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->scaleFactor:D

    iget-byte v2, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B

    invoke-static {v2}, Lorg/mapsforge/core/util/MercatorProjection;->zoomLevelToScaleFactor(B)D

    move-result-wide v2

    cmpl-double v4, v0, v2

    if-eqz v4, :cond_e

    const/4 v0, 0x1

    goto :goto_f

    :cond_e
    const/4 v0, 0x0

    :goto_f
    return v0
.end method

.method public destroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->animator:Lorg/mapsforge/map/model/MapViewPosition$Animator;

    invoke-virtual {v0}, Lorg/mapsforge/map/util/PausableThread;->finish()V

    return-void
.end method

.method public declared-synchronized getCenter()Lorg/mapsforge/core/model/LatLong;
    .registers 6

    monitor-enter p0

    :try_start_1
    new-instance v0, Lorg/mapsforge/core/model/LatLong;

    iget-wide v1, p0, Lorg/mapsforge/map/model/MapViewPosition;->latitude:D

    iget-wide v3, p0, Lorg/mapsforge/map/model/MapViewPosition;->longitude:D

    invoke-direct {v0, v1, v2, v3, v4}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    monitor-exit p0

    return-object v0

    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getMapLimit()Lorg/mapsforge/core/model/BoundingBox;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->mapLimit:Lorg/mapsforge/core/model/BoundingBox;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getMapPosition()Lorg/mapsforge/core/model/MapPosition;
    .registers 4

    monitor-enter p0

    :try_start_1
    new-instance v0, Lorg/mapsforge/core/model/MapPosition;

    invoke-virtual {p0}, Lorg/mapsforge/map/model/MapViewPosition;->getCenter()Lorg/mapsforge/core/model/LatLong;

    move-result-object v1

    iget-byte v2, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/core/model/MapPosition;-><init>(Lorg/mapsforge/core/model/LatLong;B)V
    :try_end_c
    .catchall {:try_start_1 .. :try_end_c} :catchall_e

    monitor-exit p0

    return-object v0

    :catchall_e
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPivot()Lorg/mapsforge/core/model/LatLong;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->pivot:Lorg/mapsforge/core/model/LatLong;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPivotXY(B)Lorg/mapsforge/core/model/Point;
    .registers 5

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->pivot:Lorg/mapsforge/core/model/LatLong;

    if-eqz v0, :cond_15

    iget-object v1, p0, Lorg/mapsforge/map/model/MapViewPosition;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v1

    invoke-static {p1, v1}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v1

    invoke-static {v0, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->getPixel(Lorg/mapsforge/core/model/LatLong;J)Lorg/mapsforge/core/model/Point;

    move-result-object p1
    :try_end_13
    .catchall {:try_start_1 .. :try_end_13} :catchall_18

    monitor-exit p0

    return-object p1

    :cond_15
    const/4 p1, 0x0

    monitor-exit p0

    return-object p1

    :catchall_18
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getScaleFactor()D
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-wide v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->scaleFactor:D
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-wide v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getZoomLevel()B
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-byte v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getZoomLevelMax()B
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-byte v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMax:B
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getZoomLevelMin()B
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-byte v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMin:B
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized init(Lorg/mapsforge/map/model/common/PreferencesFacade;)V
    .registers 14

    monitor-enter p0

    :try_start_1
    const-string v0, "latitude"

    const-wide/16 v1, 0x0

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->getDouble(Ljava/lang/String;D)D

    move-result-wide v3

    iput-wide v3, p0, Lorg/mapsforge/map/model/MapViewPosition;->latitude:D

    const-string v0, "longitude"

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->longitude:D

    const-string v0, "latitudeMax"

    const-wide/high16 v1, 0x7ff8000000000000L    # Double.NaN

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->getDouble(Ljava/lang/String;D)D

    move-result-wide v8

    const-string v0, "latitudeMin"

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->getDouble(Ljava/lang/String;D)D

    move-result-wide v4

    const-string v0, "longitudeMax"

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->getDouble(Ljava/lang/String;D)D

    move-result-wide v10

    const-string v0, "longitudeMin"

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->getDouble(Ljava/lang/String;D)D

    move-result-wide v6

    const/4 v0, 0x4

    new-array v0, v0, [D

    const/4 v1, 0x0

    aput-wide v8, v0, v1

    const/4 v2, 0x1

    aput-wide v4, v0, v2

    const/4 v2, 0x2

    aput-wide v10, v0, v2

    const/4 v2, 0x3

    aput-wide v6, v0, v2

    invoke-static {v0}, Lorg/mapsforge/map/model/MapViewPosition;->isNan([D)Z

    move-result v0

    if-eqz v0, :cond_46

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->mapLimit:Lorg/mapsforge/core/model/BoundingBox;

    goto :goto_4e

    :cond_46
    new-instance v0, Lorg/mapsforge/core/model/BoundingBox;

    move-object v3, v0

    invoke-direct/range {v3 .. v11}, Lorg/mapsforge/core/model/BoundingBox;-><init>(DDDD)V

    iput-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->mapLimit:Lorg/mapsforge/core/model/BoundingBox;

    :goto_4e
    const-string v0, "zoomLevel"

    invoke-interface {p1, v0, v1}, Lorg/mapsforge/map/model/common/PreferencesFacade;->getByte(Ljava/lang/String;B)B

    move-result v0

    iput-byte v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B

    const-string v0, "zoomLevelMax"

    const/16 v2, 0x7f

    invoke-interface {p1, v0, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->getByte(Ljava/lang/String;B)B

    move-result v0

    iput-byte v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMax:B

    const-string v0, "zoomLevelMin"

    invoke-interface {p1, v0, v1}, Lorg/mapsforge/map/model/common/PreferencesFacade;->getByte(Ljava/lang/String;B)B

    move-result p1

    iput-byte p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMin:B

    const-wide/high16 v0, 0x4000000000000000L    # 2.0

    iget-byte p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B

    int-to-double v2, p1

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->scaleFactor:D
    :try_end_73
    .catchall {:try_start_1 .. :try_end_73} :catchall_75

    monitor-exit p0

    return-void

    :catchall_75
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public moveCenter(DD)V
    .registers 12

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-wide v1, p1

    move-wide v3, p3

    invoke-virtual/range {v0 .. v6}, Lorg/mapsforge/map/model/MapViewPosition;->moveCenterAndZoom(DDBZ)V

    return-void
.end method

.method public moveCenter(DDZ)V
    .registers 13

    const/4 v5, 0x0

    move-object v0, p0

    move-wide v1, p1

    move-wide v3, p3

    move v6, p5

    invoke-virtual/range {v0 .. v6}, Lorg/mapsforge/map/model/MapViewPosition;->moveCenterAndZoom(DDBZ)V

    return-void
.end method

.method public moveCenterAndZoom(DDB)V
    .registers 13

    const/4 v6, 0x1

    move-object v0, p0

    move-wide v1, p1

    move-wide v3, p3

    move v5, p5

    invoke-virtual/range {v0 .. v6}, Lorg/mapsforge/map/model/MapViewPosition;->moveCenterAndZoom(DDBZ)V

    return-void
.end method

.method public moveCenterAndZoom(DDBZ)V
    .registers 13

    monitor-enter p0

    :try_start_1
    iget-byte v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B

    iget-object v1, p0, Lorg/mapsforge/map/model/MapViewPosition;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v1

    invoke-static {v0, v1}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v0

    iget-wide v2, p0, Lorg/mapsforge/map/model/MapViewPosition;->longitude:D

    invoke-static {v2, v3, v0, v1}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v2

    sub-double/2addr v2, p1

    iget-wide p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->latitude:D

    invoke-static {p1, p2, v0, v1}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide p1

    sub-double/2addr p1, p3

    const-wide/16 p3, 0x0

    invoke-static {p3, p4, v2, v3}, Ljava/lang/Math;->max(DD)D

    move-result-wide v2

    long-to-double v4, v0

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->min(DD)D

    move-result-wide v2

    invoke-static {p3, p4, p1, p2}, Ljava/lang/Math;->max(DD)D

    move-result-wide p1

    invoke-static {p1, p2, v4, v5}, Ljava/lang/Math;->min(DD)D

    move-result-wide p1

    invoke-static {p1, p2, v0, v1}, Lorg/mapsforge/core/util/MercatorProjection;->pixelYToLatitude(DJ)D

    move-result-wide p1

    invoke-static {v2, v3, v0, v1}, Lorg/mapsforge/core/util/MercatorProjection;->pixelXToLongitude(DJ)D

    move-result-wide p3

    invoke-direct {p0, p1, p2, p3, p4}, Lorg/mapsforge/map/model/MapViewPosition;->setCenterInternal(DD)V

    iget-byte p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B

    add-int/2addr p1, p5

    invoke-direct {p0, p1, p6}, Lorg/mapsforge/map/model/MapViewPosition;->setZoomLevelInternal(IZ)V

    monitor-exit p0
    :try_end_40
    .catchall {:try_start_1 .. :try_end_40} :catchall_44

    invoke-virtual {p0}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V

    return-void

    :catchall_44
    move-exception p1

    :try_start_45
    monitor-exit p0
    :try_end_46
    .catchall {:try_start_45 .. :try_end_46} :catchall_44

    throw p1
.end method

.method public declared-synchronized save(Lorg/mapsforge/map/model/common/PreferencesFacade;)V
    .registers 6

    monitor-enter p0

    :try_start_1
    const-string v0, "latitude"

    iget-wide v1, p0, Lorg/mapsforge/map/model/MapViewPosition;->latitude:D

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->putDouble(Ljava/lang/String;D)V

    const-string v0, "longitude"

    iget-wide v1, p0, Lorg/mapsforge/map/model/MapViewPosition;->longitude:D

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->putDouble(Ljava/lang/String;D)V

    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->mapLimit:Lorg/mapsforge/core/model/BoundingBox;

    if-nez v0, :cond_2a

    const-string v0, "latitudeMax"

    const-wide/high16 v1, 0x7ff8000000000000L    # Double.NaN

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->putDouble(Ljava/lang/String;D)V

    const-string v0, "latitudeMin"

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->putDouble(Ljava/lang/String;D)V

    const-string v0, "longitudeMax"

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->putDouble(Ljava/lang/String;D)V

    const-string v0, "longitudeMin"

    :goto_26
    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->putDouble(Ljava/lang/String;D)V

    goto :goto_4a

    :cond_2a
    const-string v1, "latitudeMax"

    iget-wide v2, v0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-interface {p1, v1, v2, v3}, Lorg/mapsforge/map/model/common/PreferencesFacade;->putDouble(Ljava/lang/String;D)V

    const-string v0, "latitudeMin"

    iget-object v1, p0, Lorg/mapsforge/map/model/MapViewPosition;->mapLimit:Lorg/mapsforge/core/model/BoundingBox;

    iget-wide v1, v1, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->putDouble(Ljava/lang/String;D)V

    const-string v0, "longitudeMax"

    iget-object v1, p0, Lorg/mapsforge/map/model/MapViewPosition;->mapLimit:Lorg/mapsforge/core/model/BoundingBox;

    iget-wide v1, v1, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-interface {p1, v0, v1, v2}, Lorg/mapsforge/map/model/common/PreferencesFacade;->putDouble(Ljava/lang/String;D)V

    const-string v0, "longitudeMin"

    iget-object v1, p0, Lorg/mapsforge/map/model/MapViewPosition;->mapLimit:Lorg/mapsforge/core/model/BoundingBox;

    iget-wide v1, v1, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    goto :goto_26

    :goto_4a
    const-string v0, "zoomLevel"

    iget-byte v1, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B

    invoke-interface {p1, v0, v1}, Lorg/mapsforge/map/model/common/PreferencesFacade;->putByte(Ljava/lang/String;B)V

    const-string v0, "zoomLevelMax"

    iget-byte v1, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMax:B

    invoke-interface {p1, v0, v1}, Lorg/mapsforge/map/model/common/PreferencesFacade;->putByte(Ljava/lang/String;B)V

    const-string v0, "zoomLevelMin"

    iget-byte v1, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMin:B

    invoke-interface {p1, v0, v1}, Lorg/mapsforge/map/model/common/PreferencesFacade;->putByte(Ljava/lang/String;B)V
    :try_end_5f
    .catchall {:try_start_1 .. :try_end_5f} :catchall_61

    monitor-exit p0

    return-void

    :catchall_61
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public setCenter(Lorg/mapsforge/core/model/LatLong;)V
    .registers 6

    monitor-enter p0

    :try_start_1
    iget-wide v0, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v2, p1, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-direct {p0, v0, v1, v2, v3}, Lorg/mapsforge/map/model/MapViewPosition;->setCenterInternal(DD)V

    monitor-exit p0
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_d

    invoke-virtual {p0}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V

    return-void

    :catchall_d
    move-exception p1

    :try_start_e
    monitor-exit p0
    :try_end_f
    .catchall {:try_start_e .. :try_end_f} :catchall_d

    throw p1
.end method

.method public setMapLimit(Lorg/mapsforge/core/model/BoundingBox;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->mapLimit:Lorg/mapsforge/core/model/BoundingBox;

    monitor-exit p0
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_8

    invoke-virtual {p0}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V

    return-void

    :catchall_8
    move-exception p1

    :try_start_9
    monitor-exit p0
    :try_end_a
    .catchall {:try_start_9 .. :try_end_a} :catchall_8

    throw p1
.end method

.method public setMapPosition(Lorg/mapsforge/core/model/MapPosition;)V
    .registers 3

    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lorg/mapsforge/map/model/MapViewPosition;->setMapPosition(Lorg/mapsforge/core/model/MapPosition;Z)V

    return-void
.end method

.method public setMapPosition(Lorg/mapsforge/core/model/MapPosition;Z)V
    .registers 8

    monitor-enter p0

    :try_start_1
    iget-object v0, p1, Lorg/mapsforge/core/model/MapPosition;->latLong:Lorg/mapsforge/core/model/LatLong;

    iget-wide v1, v0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v3, v0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-direct {p0, v1, v2, v3, v4}, Lorg/mapsforge/map/model/MapViewPosition;->setCenterInternal(DD)V

    iget-byte p1, p1, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/model/MapViewPosition;->setZoomLevelInternal(IZ)V

    monitor-exit p0
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_14

    invoke-virtual {p0}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V

    return-void

    :catchall_14
    move-exception p1

    :try_start_15
    monitor-exit p0
    :try_end_16
    .catchall {:try_start_15 .. :try_end_16} :catchall_14

    throw p1
.end method

.method public setPivot(Lorg/mapsforge/core/model/LatLong;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->pivot:Lorg/mapsforge/core/model/LatLong;

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_5

    throw p1
.end method

.method public setScaleFactor(D)V
    .registers 3

    monitor-enter p0

    :try_start_1
    iput-wide p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->scaleFactor:D

    monitor-exit p0
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_8

    invoke-virtual {p0}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V

    return-void

    :catchall_8
    move-exception p1

    :try_start_9
    monitor-exit p0
    :try_end_a
    .catchall {:try_start_9 .. :try_end_a} :catchall_8

    throw p1
.end method

.method public setScaleFactorAdjustment(D)V
    .registers 7

    monitor-enter p0

    const-wide/high16 v0, 0x4000000000000000L    # 2.0

    :try_start_3
    iget-byte v2, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B

    int-to-double v2, v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    mul-double v0, v0, p1

    invoke-virtual {p0, v0, v1}, Lorg/mapsforge/map/model/MapViewPosition;->setScaleFactor(D)V

    monitor-exit p0
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_14

    invoke-virtual {p0}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V

    return-void

    :catchall_14
    move-exception p1

    :try_start_15
    monitor-exit p0
    :try_end_16
    .catchall {:try_start_15 .. :try_end_16} :catchall_14

    throw p1
.end method

.method public setZoomLevel(B)V
    .registers 3

    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lorg/mapsforge/map/model/MapViewPosition;->setZoomLevel(BZ)V

    return-void
.end method

.method public setZoomLevel(BZ)V
    .registers 5

    if-ltz p1, :cond_e

    monitor-enter p0

    :try_start_3
    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/model/MapViewPosition;->setZoomLevelInternal(IZ)V

    monitor-exit p0
    :try_end_7
    .catchall {:try_start_3 .. :try_end_7} :catchall_b

    invoke-virtual {p0}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V

    return-void

    :catchall_b
    move-exception p1

    :try_start_c
    monitor-exit p0
    :try_end_d
    .catchall {:try_start_c .. :try_end_d} :catchall_b

    throw p1

    :cond_e
    new-instance p2, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "zoomLevel must not be negative: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p2
.end method

.method public setZoomLevelMax(B)V
    .registers 5

    if-ltz p1, :cond_28

    monitor-enter p0

    :try_start_3
    iget-byte v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMin:B

    if-lt p1, v0, :cond_e

    iput-byte p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMax:B

    monitor-exit p0
    :try_end_a
    .catchall {:try_start_3 .. :try_end_a} :catchall_25

    invoke-virtual {p0}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V

    return-void

    :cond_e
    :try_start_e
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "zoomLevelMax must be >= zoomLevelMin: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :catchall_25
    move-exception p1

    monitor-exit p0
    :try_end_27
    .catchall {:try_start_e .. :try_end_27} :catchall_25

    throw p1

    :cond_28
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "zoomLevelMax must not be negative: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setZoomLevelMin(B)V
    .registers 5

    if-ltz p1, :cond_28

    monitor-enter p0

    :try_start_3
    iget-byte v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMax:B

    if-gt p1, v0, :cond_e

    iput-byte p1, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevelMin:B

    monitor-exit p0
    :try_end_a
    .catchall {:try_start_3 .. :try_end_a} :catchall_25

    invoke-virtual {p0}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V

    return-void

    :cond_e
    :try_start_e
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "zoomLevelMin must be <= zoomLevelMax: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :catchall_25
    move-exception p1

    monitor-exit p0
    :try_end_27
    .catchall {:try_start_e .. :try_end_27} :catchall_25

    throw p1

    :cond_28
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "zoomLevelMin must not be negative: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public zoom(B)V
    .registers 3

    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lorg/mapsforge/map/model/MapViewPosition;->zoom(BZ)V

    return-void
.end method

.method public zoom(BZ)V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-byte v0, p0, Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B

    add-int/2addr v0, p1

    invoke-direct {p0, v0, p2}, Lorg/mapsforge/map/model/MapViewPosition;->setZoomLevelInternal(IZ)V

    monitor-exit p0
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_c

    invoke-virtual {p0}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V

    return-void

    :catchall_c
    move-exception p1

    :try_start_d
    monitor-exit p0
    :try_end_e
    .catchall {:try_start_d .. :try_end_e} :catchall_c

    throw p1
.end method

.method public zoomIn()V
    .registers 2

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/model/MapViewPosition;->zoomIn(Z)V

    return-void
.end method

.method public zoomIn(Z)V
    .registers 3

    const/4 v0, 0x1

    invoke-virtual {p0, v0, p1}, Lorg/mapsforge/map/model/MapViewPosition;->zoom(BZ)V

    return-void
.end method

.method public zoomOut()V
    .registers 2

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/model/MapViewPosition;->zoomOut(Z)V

    return-void
.end method

.method public zoomOut(Z)V
    .registers 3

    const/4 v0, -0x1

    invoke-virtual {p0, v0, p1}, Lorg/mapsforge/map/model/MapViewPosition;->zoom(BZ)V

    return-void
.end method
