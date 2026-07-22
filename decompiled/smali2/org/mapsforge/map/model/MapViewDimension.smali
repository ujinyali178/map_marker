.class public Lorg/mapsforge/map/model/MapViewDimension;
.super Lorg/mapsforge/map/model/common/Observable;
.source "SourceFile"


# instance fields
.field private dimension:Lorg/mapsforge/core/model/Dimension;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lorg/mapsforge/map/model/common/Observable;-><init>()V

    return-void
.end method


# virtual methods
.method public declared-synchronized getDimension()Lorg/mapsforge/core/model/Dimension;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewDimension;->dimension:Lorg/mapsforge/core/model/Dimension;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setDimension(Lorg/mapsforge/core/model/Dimension;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/model/MapViewDimension;->dimension:Lorg/mapsforge/core/model/Dimension;

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
