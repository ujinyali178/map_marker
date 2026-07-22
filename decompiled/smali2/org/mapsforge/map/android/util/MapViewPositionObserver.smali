.class public Lorg/mapsforge/map/android/util/MapViewPositionObserver;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/model/common/Observer;


# instance fields
.field private final observable:Lorg/mapsforge/map/model/IMapViewPosition;

.field private final observer:Lorg/mapsforge/map/model/IMapViewPosition;


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/model/IMapViewPosition;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->observable:Lorg/mapsforge/map/model/IMapViewPosition;

    iput-object p2, p0, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->observer:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {p1, p0}, Lorg/mapsforge/map/model/IMapViewPosition;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-void
.end method


# virtual methods
.method public onChange()V
    .registers 1

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->setCenter()V

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->setZoom()V

    return-void
.end method

.method public removeObserver()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->observable:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0, p0}, Lorg/mapsforge/map/model/IMapViewPosition;->removeObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-void
.end method

.method protected setCenter()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->observable:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0}, Lorg/mapsforge/map/model/IMapViewPosition;->getCenter()Lorg/mapsforge/core/model/LatLong;

    move-result-object v0

    iget-object v1, p0, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->observer:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v1}, Lorg/mapsforge/map/model/IMapViewPosition;->getCenter()Lorg/mapsforge/core/model/LatLong;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/mapsforge/core/model/LatLong;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1d

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->observer:Lorg/mapsforge/map/model/IMapViewPosition;

    iget-object v1, p0, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->observable:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v1}, Lorg/mapsforge/map/model/IMapViewPosition;->getCenter()Lorg/mapsforge/core/model/LatLong;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/mapsforge/map/model/IMapViewPosition;->setCenter(Lorg/mapsforge/core/model/LatLong;)V

    :cond_1d
    return-void
.end method

.method protected setZoom()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->observable:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0}, Lorg/mapsforge/map/model/IMapViewPosition;->getZoomLevel()B

    move-result v0

    iget-object v1, p0, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->observer:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v1}, Lorg/mapsforge/map/model/IMapViewPosition;->getZoomLevel()B

    move-result v1

    if-eq v0, v1, :cond_19

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->observer:Lorg/mapsforge/map/model/IMapViewPosition;

    iget-object v1, p0, Lorg/mapsforge/map/android/util/MapViewPositionObserver;->observable:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v1}, Lorg/mapsforge/map/model/IMapViewPosition;->getZoomLevel()B

    move-result v1

    invoke-interface {v0, v1}, Lorg/mapsforge/map/model/IMapViewPosition;->setZoomLevel(B)V

    :cond_19
    return-void
.end method
