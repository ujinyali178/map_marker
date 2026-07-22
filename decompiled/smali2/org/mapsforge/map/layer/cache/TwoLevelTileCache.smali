.class public Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/cache/TileCache;


# instance fields
.field private final firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

.field private final secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

.field private final workingSet:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Lorg/mapsforge/map/layer/queue/Job;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/layer/cache/TileCache;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    iput-object p2, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    new-instance p1, Ljava/util/HashSet;

    invoke-direct {p1}, Ljava/util/HashSet;-><init>()V

    invoke-static {p1}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->workingSet:Ljava/util/Set;

    return-void
.end method


# virtual methods
.method public addObserver(Lorg/mapsforge/map/model/common/Observer;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/model/common/ObservableInterface;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/model/common/ObservableInterface;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-void
.end method

.method public containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/layer/cache/TileCache;->containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z

    move-result v0

    if-nez v0, :cond_13

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/layer/cache/TileCache;->containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z

    move-result p1

    if-eqz p1, :cond_11

    goto :goto_13

    :cond_11
    const/4 p1, 0x0

    goto :goto_14

    :cond_13
    :goto_13
    const/4 p1, 0x1

    :goto_14
    return p1
.end method

.method public destroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0}, Lorg/mapsforge/map/layer/cache/TileCache;->destroy()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0}, Lorg/mapsforge/map/layer/cache/TileCache;->destroy()V

    return-void
.end method

.method public get(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/layer/cache/TileCache;->get(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object v0

    if-eqz v0, :cond_9

    return-object v0

    :cond_9
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/layer/cache/TileCache;->get(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object v0

    if-eqz v0, :cond_17

    iget-object v1, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v1, p1, v0}, Lorg/mapsforge/map/layer/cache/TileCache;->put(Lorg/mapsforge/map/layer/queue/Job;Lorg/mapsforge/core/graphics/TileBitmap;)V

    return-object v0

    :cond_17
    const/4 p1, 0x0

    return-object p1
.end method

.method public getCapacity()I
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0}, Lorg/mapsforge/map/layer/cache/TileCache;->getCapacity()I

    move-result v0

    iget-object v1, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v1}, Lorg/mapsforge/map/layer/cache/TileCache;->getCapacity()I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method public getCapacityFirstLevel()I
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0}, Lorg/mapsforge/map/layer/cache/TileCache;->getCapacity()I

    move-result v0

    return v0
.end method

.method public getImmediately(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/layer/cache/TileCache;->get(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object p1

    return-object p1
.end method

.method public purge()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0}, Lorg/mapsforge/map/layer/cache/TileCache;->purge()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0}, Lorg/mapsforge/map/layer/cache/TileCache;->purge()V

    return-void
.end method

.method public put(Lorg/mapsforge/map/layer/queue/Job;Lorg/mapsforge/core/graphics/TileBitmap;)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->workingSet:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0, p1, p2}, Lorg/mapsforge/map/layer/cache/TileCache;->put(Lorg/mapsforge/map/layer/queue/Job;Lorg/mapsforge/core/graphics/TileBitmap;)V

    :cond_d
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0, p1, p2}, Lorg/mapsforge/map/layer/cache/TileCache;->put(Lorg/mapsforge/map/layer/queue/Job;Lorg/mapsforge/core/graphics/TileBitmap;)V

    return-void
.end method

.method public removeObserver(Lorg/mapsforge/map/model/common/Observer;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/model/common/ObservableInterface;->removeObserver(Lorg/mapsforge/map/model/common/Observer;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/model/common/ObservableInterface;->removeObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-void
.end method

.method public setWorkingSet(Ljava/util/Set;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set<",
            "Lorg/mapsforge/map/layer/queue/Job;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->workingSet:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->workingSet:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    iget-object p1, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->workingSet:Ljava/util/Set;

    invoke-interface {p1, v0}, Lorg/mapsforge/map/layer/cache/TileCache;->setWorkingSet(Ljava/util/Set;)V

    iget-object p1, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->workingSet:Ljava/util/Set;

    invoke-interface {p1, v0}, Lorg/mapsforge/map/layer/cache/TileCache;->setWorkingSet(Ljava/util/Set;)V

    iget-object p1, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->workingSet:Ljava/util/Set;

    monitor-enter p1

    :try_start_1b
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->workingSet:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_21
    :goto_21
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_4b

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/layer/queue/Job;

    iget-object v2, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v2, v1}, Lorg/mapsforge/map/layer/cache/TileCache;->containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z

    move-result v2

    if-nez v2, :cond_21

    iget-object v2, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v2, v1}, Lorg/mapsforge/map/layer/cache/TileCache;->containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z

    move-result v2

    if-eqz v2, :cond_21

    iget-object v2, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->secondLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v2, v1}, Lorg/mapsforge/map/layer/cache/TileCache;->get(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object v2

    if-eqz v2, :cond_21

    iget-object v3, p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;->firstLevelTileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v3, v1, v2}, Lorg/mapsforge/map/layer/cache/TileCache;->put(Lorg/mapsforge/map/layer/queue/Job;Lorg/mapsforge/core/graphics/TileBitmap;)V

    goto :goto_21

    :cond_4b
    monitor-exit p1

    return-void

    :catchall_4d
    move-exception v0

    monitor-exit p1
    :try_end_4f
    .catchall {:try_start_1b .. :try_end_4f} :catchall_4d

    throw v0
.end method
