.class public Lorg/mapsforge/map/model/FrameBufferModel;
.super Lorg/mapsforge/map/model/common/Observable;
.source "SourceFile"


# instance fields
.field private dimension:Lorg/mapsforge/core/model/Dimension;

.field private mapPosition:Lorg/mapsforge/core/model/MapPosition;

.field private overdrawFactor:D


# direct methods
.method public constructor <init>()V
    .registers 3

    invoke-direct {p0}, Lorg/mapsforge/map/model/common/Observable;-><init>()V

    const-wide v0, 0x3ff3333333333333L    # 1.2

    iput-wide v0, p0, Lorg/mapsforge/map/model/FrameBufferModel;->overdrawFactor:D

    return-void
.end method


# virtual methods
.method public declared-synchronized getDimension()Lorg/mapsforge/core/model/Dimension;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/model/FrameBufferModel;->dimension:Lorg/mapsforge/core/model/Dimension;
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
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/model/FrameBufferModel;->mapPosition:Lorg/mapsforge/core/model/MapPosition;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getOverdrawFactor()D
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-wide v0, p0, Lorg/mapsforge/map/model/FrameBufferModel;->overdrawFactor:D
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-wide v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setDimension(Lorg/mapsforge/core/model/Dimension;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/model/FrameBufferModel;->dimension:Lorg/mapsforge/core/model/Dimension;

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
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/model/FrameBufferModel;->mapPosition:Lorg/mapsforge/core/model/MapPosition;

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

.method public setOverdrawFactor(D)V
    .registers 6

    const-wide/16 v0, 0x0

    cmpg-double v2, p1, v0

    if-lez v2, :cond_11

    monitor-enter p0

    :try_start_7
    iput-wide p1, p0, Lorg/mapsforge/map/model/FrameBufferModel;->overdrawFactor:D

    monitor-exit p0
    :try_end_a
    .catchall {:try_start_7 .. :try_end_a} :catchall_e

    invoke-virtual {p0}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V

    return-void

    :catchall_e
    move-exception p1

    :try_start_f
    monitor-exit p0
    :try_end_10
    .catchall {:try_start_f .. :try_end_10} :catchall_e

    throw p1

    :cond_11
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "overdrawFactor must be > 0: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
