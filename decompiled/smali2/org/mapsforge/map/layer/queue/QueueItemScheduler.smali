.class final Lorg/mapsforge/map/layer/queue/QueueItemScheduler;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static final PENALTY_PER_ZOOM_LEVEL:D = 10.0


# direct methods
.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method private static calculatePriority(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/MapPosition;I)D
    .registers 14

    iget v0, p0, Lorg/mapsforge/core/model/Tile;->tileY:I

    int-to-long v0, v0

    iget-byte v2, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v0, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->tileYToLatitude(JB)D

    move-result-wide v0

    iget v2, p0, Lorg/mapsforge/core/model/Tile;->tileX:I

    int-to-long v2, v2

    iget-byte v4, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v2, v3, v4}, Lorg/mapsforge/core/util/MercatorProjection;->tileXToLongitude(JB)D

    move-result-wide v2

    div-int/lit8 v4, p2, 0x2

    iget-byte v5, p1, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    invoke-static {v5, p2}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v5

    invoke-static {v2, v3, v5, v6}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v2

    int-to-double v7, v4

    add-double/2addr v2, v7

    invoke-static {v0, v1, v5, v6}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v0

    add-double/2addr v0, v7

    iget-object v4, p1, Lorg/mapsforge/core/model/MapPosition;->latLong:Lorg/mapsforge/core/model/LatLong;

    iget-wide v7, v4, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v7, v8, v5, v6}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v7

    iget-wide v9, v4, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v9, v10, v5, v6}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v4

    sub-double/2addr v2, v7

    sub-double/2addr v0, v4

    invoke-static {v2, v3, v0, v1}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide v0

    iget-byte p0, p0, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget-byte p1, p1, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    sub-int/2addr p0, p1

    invoke-static {p0}, Ljava/lang/Math;->abs(I)I

    move-result p0

    int-to-double p1, p2

    const-wide/high16 v2, 0x4024000000000000L    # 10.0

    mul-double p1, p1, v2

    int-to-double v2, p0

    mul-double p1, p1, v2

    add-double/2addr v0, p1

    return-wide v0
.end method

.method static schedule(Ljava/util/Collection;Lorg/mapsforge/core/model/MapPosition;I)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lorg/mapsforge/map/layer/queue/Job;",
            ">(",
            "Ljava/util/Collection<",
            "Lorg/mapsforge/map/layer/queue/QueueItem<",
            "TT;>;>;",
            "Lorg/mapsforge/core/model/MapPosition;",
            "I)V"
        }
    .end annotation

    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_4
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1c

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/map/layer/queue/QueueItem;

    iget-object v1, v0, Lorg/mapsforge/map/layer/queue/QueueItem;->object:Lorg/mapsforge/map/layer/queue/Job;

    iget-object v1, v1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-static {v1, p1, p2}, Lorg/mapsforge/map/layer/queue/QueueItemScheduler;->calculatePriority(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/MapPosition;I)D

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Lorg/mapsforge/map/layer/queue/QueueItem;->setPriority(D)V

    goto :goto_4

    :cond_1c
    return-void
.end method
