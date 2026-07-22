.class public abstract Lorg/mapsforge/map/layer/Layer;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private assignedRedrawer:Lorg/mapsforge/map/layer/Redrawer;

.field protected displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field private visible:Z


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/layer/Layer;->visible:Z

    return-void
.end method


# virtual methods
.method final declared-synchronized assign(Lorg/mapsforge/map/layer/Redrawer;)V
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layer;->assignedRedrawer:Lorg/mapsforge/map/layer/Redrawer;

    if-nez v0, :cond_c

    iput-object p1, p0, Lorg/mapsforge/map/layer/Layer;->assignedRedrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/Layer;->onAdd()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_14

    monitor-exit p0

    return-void

    :cond_c
    :try_start_c
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "layer already assigned"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
    :try_end_14
    .catchall {:try_start_c .. :try_end_14} :catchall_14

    :catchall_14
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public abstract draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
.end method

.method public declared-synchronized getDisplayModel()Lorg/mapsforge/map/model/DisplayModel;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getPosition()Lorg/mapsforge/core/model/LatLong;
    .registers 2

    const/4 v0, 0x0

    return-object v0
.end method

.method public final isVisible()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/Layer;->visible:Z

    return v0
.end method

.method protected onAdd()V
    .registers 1

    return-void
.end method

.method public onDestroy()V
    .registers 1

    return-void
.end method

.method public onLongPress(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)Z
    .registers 4

    const/4 p1, 0x0

    return p1
.end method

.method protected onRemove()V
    .registers 1

    return-void
.end method

.method public onScroll(FFFF)Z
    .registers 5

    const/4 p1, 0x0

    return p1
.end method

.method public onTap(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)Z
    .registers 4

    const/4 p1, 0x0

    return p1
.end method

.method public final declared-synchronized requestRedraw()V
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layer;->assignedRedrawer:Lorg/mapsforge/map/layer/Redrawer;

    if-eqz v0, :cond_8

    invoke-interface {v0}, Lorg/mapsforge/map/layer/Redrawer;->redrawLayers()V
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_a

    :cond_8
    monitor-exit p0

    return-void

    :catchall_a
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public final setVisible(Z)V
    .registers 3

    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lorg/mapsforge/map/layer/Layer;->setVisible(ZZ)V

    return-void
.end method

.method public setVisible(ZZ)V
    .registers 3

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/Layer;->visible:Z

    if-eqz p2, :cond_7

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/Layer;->requestRedraw()V

    :cond_7
    return-void
.end method

.method final declared-synchronized unassign()V
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layer;->assignedRedrawer:Lorg/mapsforge/map/layer/Redrawer;

    if-eqz v0, :cond_d

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/layer/Layer;->assignedRedrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/Layer;->onRemove()V
    :try_end_b
    .catchall {:try_start_1 .. :try_end_b} :catchall_15

    monitor-exit p0

    return-void

    :cond_d
    :try_start_d
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "layer is not assigned"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_15
    .catchall {:try_start_d .. :try_end_15} :catchall_15

    :catchall_15
    move-exception v0

    monitor-exit p0

    throw v0
.end method
