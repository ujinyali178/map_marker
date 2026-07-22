.class public Lorg/mapsforge/map/android/layers/MyLocationOverlay;
.super Lorg/mapsforge/map/layer/Layer;
.source "SourceFile"


# instance fields
.field private final circle:Lorg/mapsforge/map/layer/overlay/Circle;

.field private final marker:Lorg/mapsforge/map/layer/overlay/Marker;


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/layer/overlay/Marker;)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lorg/mapsforge/map/android/layers/MyLocationOverlay;-><init>(Lorg/mapsforge/map/layer/overlay/Marker;Lorg/mapsforge/map/layer/overlay/Circle;)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/layer/overlay/Marker;Lorg/mapsforge/map/layer/overlay/Circle;)V
    .registers 3

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/android/layers/MyLocationOverlay;->marker:Lorg/mapsforge/map/layer/overlay/Marker;

    iput-object p2, p0, Lorg/mapsforge/map/android/layers/MyLocationOverlay;->circle:Lorg/mapsforge/map/layer/overlay/Circle;

    return-void
.end method


# virtual methods
.method public declared-synchronized draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    .registers 6

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/android/layers/MyLocationOverlay;->circle:Lorg/mapsforge/map/layer/overlay/Circle;

    if-eqz v0, :cond_8

    invoke-virtual {v0, p1, p2, p3, p4}, Lorg/mapsforge/map/layer/overlay/Circle;->draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V

    :cond_8
    iget-object v0, p0, Lorg/mapsforge/map/android/layers/MyLocationOverlay;->marker:Lorg/mapsforge/map/layer/overlay/Marker;

    invoke-virtual {v0, p1, p2, p3, p4}, Lorg/mapsforge/map/layer/overlay/Marker;->draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    :try_end_d
    .catchall {:try_start_1 .. :try_end_d} :catchall_f

    monitor-exit p0

    return-void

    :catchall_f
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method protected onAdd()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/layers/MyLocationOverlay;->circle:Lorg/mapsforge/map/layer/overlay/Circle;

    if-eqz v0, :cond_9

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/layer/Layer;->setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V

    :cond_9
    iget-object v0, p0, Lorg/mapsforge/map/android/layers/MyLocationOverlay;->marker:Lorg/mapsforge/map/layer/overlay/Marker;

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/layer/Layer;->setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V

    return-void
.end method

.method public onDestroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/layers/MyLocationOverlay;->marker:Lorg/mapsforge/map/layer/overlay/Marker;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/overlay/Marker;->onDestroy()V

    return-void
.end method

.method public setPosition(DDF)V
    .registers 7

    monitor-enter p0

    :try_start_1
    new-instance v0, Lorg/mapsforge/core/model/LatLong;

    invoke-direct {v0, p1, p2, p3, p4}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    iget-object p1, p0, Lorg/mapsforge/map/android/layers/MyLocationOverlay;->marker:Lorg/mapsforge/map/layer/overlay/Marker;

    invoke-virtual {p1, v0}, Lorg/mapsforge/map/layer/overlay/Marker;->setLatLong(Lorg/mapsforge/core/model/LatLong;)V

    iget-object p1, p0, Lorg/mapsforge/map/android/layers/MyLocationOverlay;->circle:Lorg/mapsforge/map/layer/overlay/Circle;

    if-eqz p1, :cond_17

    invoke-virtual {p1, v0}, Lorg/mapsforge/map/layer/overlay/Circle;->setLatLong(Lorg/mapsforge/core/model/LatLong;)V

    iget-object p1, p0, Lorg/mapsforge/map/android/layers/MyLocationOverlay;->circle:Lorg/mapsforge/map/layer/overlay/Circle;

    invoke-virtual {p1, p5}, Lorg/mapsforge/map/layer/overlay/Circle;->setRadius(F)V

    :cond_17
    invoke-virtual {p0}, Lorg/mapsforge/map/layer/Layer;->requestRedraw()V

    monitor-exit p0

    return-void

    :catchall_1c
    move-exception p1

    monitor-exit p0
    :try_end_1e
    .catchall {:try_start_1 .. :try_end_1e} :catchall_1c

    throw p1
.end method
