.class public Lorg/mapsforge/map/layer/cache/InMemoryTileCache;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/cache/TileCache;


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;


# instance fields
.field private lruCache:Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

.field private observable:Lorg/mapsforge/map/model/common/Observable;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method public constructor <init>(I)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

    invoke-direct {v0, p1}, Lorg/mapsforge/map/layer/cache/BitmapLRUCache;-><init>(I)V

    iput-object v0, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

    new-instance p1, Lorg/mapsforge/map/model/common/Observable;

    invoke-direct {p1}, Lorg/mapsforge/map/model/common/Observable;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->observable:Lorg/mapsforge/map/model/common/Observable;

    return-void
.end method


# virtual methods
.method public addObserver(Lorg/mapsforge/map/model/common/Observer;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->observable:Lorg/mapsforge/map/model/common/Observable;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/model/common/Observable;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-void
.end method

.method public declared-synchronized containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

    invoke-virtual {v0, p1}, Ljava/util/AbstractMap;->containsKey(Ljava/lang/Object;)Z

    move-result p1
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_9

    monitor-exit p0

    return p1

    :catchall_9
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized destroy()V
    .registers 2

    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->purge()V
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_6

    monitor-exit p0

    return-void

    :catchall_6
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized get(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

    invoke-virtual {v0, p1}, Ljava/util/AbstractMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/core/graphics/TileBitmap;

    if-eqz p1, :cond_e

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Bitmap;->incrementRefCount()V
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_10

    :cond_e
    monitor-exit p0

    return-object p1

    :catchall_10
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getCapacity()I
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

    iget v0, v0, Lorg/mapsforge/core/util/LRUCache;->capacity:I
    :try_end_5
    .catchall {:try_start_1 .. :try_end_5} :catchall_7

    monitor-exit p0

    return v0

    :catchall_7
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getCapacityFirstLevel()I
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->getCapacity()I

    move-result v0

    return v0
.end method

.method public getImmediately(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 2

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->get(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object p1

    return-object p1
.end method

.method public purge()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

    invoke-virtual {v0}, Ljava/util/AbstractMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/core/graphics/TileBitmap;

    invoke-interface {v1}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    goto :goto_a

    :cond_1a
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

    invoke-virtual {v0}, Ljava/util/AbstractMap;->clear()V

    return-void
.end method

.method public declared-synchronized put(Lorg/mapsforge/map/layer/queue/Job;Lorg/mapsforge/core/graphics/TileBitmap;)V
    .registers 6

    monitor-enter p0

    if-eqz p1, :cond_42

    if-eqz p2, :cond_3a

    :try_start_5
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

    invoke-virtual {v0, p1}, Ljava/util/AbstractMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/core/graphics/TileBitmap;

    if-eqz v0, :cond_12

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    :cond_12
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

    invoke-virtual {v0, p1, p2}, Ljava/util/AbstractMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_30

    sget-object v0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->LOGGER:Ljava/util/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "overwriting cached entry: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    :cond_30
    invoke-interface {p2}, Lorg/mapsforge/core/graphics/Bitmap;->incrementRefCount()V

    iget-object p1, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->observable:Lorg/mapsforge/map/model/common/Observable;

    invoke-virtual {p1}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V
    :try_end_38
    .catchall {:try_start_5 .. :try_end_38} :catchall_4a

    monitor-exit p0

    return-void

    :cond_3a
    :try_start_3a
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "bitmap must not be null"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_42
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "key must not be null"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
    :try_end_4a
    .catchall {:try_start_3a .. :try_end_4a} :catchall_4a

    :catchall_4a
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public removeObserver(Lorg/mapsforge/map/model/common/Observer;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->observable:Lorg/mapsforge/map/model/common/Observable;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/model/common/Observable;->removeObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-void
.end method

.method public declared-synchronized setCapacity(I)V
    .registers 3

    monitor-enter p0

    :try_start_1
    new-instance v0, Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

    invoke-direct {v0, p1}, Lorg/mapsforge/map/layer/cache/BitmapLRUCache;-><init>(I)V

    iget-object p1, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

    invoke-virtual {v0, p1}, Ljava/util/AbstractMap;->putAll(Ljava/util/Map;)V

    iput-object v0, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/BitmapLRUCache;
    :try_end_d
    .catchall {:try_start_1 .. :try_end_d} :catchall_f

    monitor-exit p0

    return-void

    :catchall_f
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setWorkingSet(Ljava/util/Set;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set<",
            "Lorg/mapsforge/map/layer/queue/Job;",
            ">;)V"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/BitmapLRUCache;

    invoke-virtual {v0, p1}, Lorg/mapsforge/core/util/WorkingSetCache;->setWorkingSet(Ljava/util/Set;)V
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    monitor-exit p0

    return-void

    :catchall_8
    move-exception p1

    monitor-exit p0

    throw p1
.end method
