.class Lorg/mapsforge/map/layer/hills/HgtCache$Lru;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/layer/hills/HgtCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Lru"
.end annotation


# instance fields
.field private final lru:Ljava/util/LinkedHashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashSet<",
            "Ljava/util/concurrent/Future<",
            "Lorg/mapsforge/core/graphics/HillshadingBitmap;",
            ">;>;"
        }
    .end annotation
.end field

.field private size:I


# direct methods
.method constructor <init>(I)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->size:I

    if-lez p1, :cond_d

    new-instance p1, Ljava/util/LinkedHashSet;

    invoke-direct {p1}, Ljava/util/LinkedHashSet;-><init>()V

    goto :goto_e

    :cond_d
    const/4 p1, 0x0

    :goto_e
    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->lru:Ljava/util/LinkedHashSet;

    return-void
.end method


# virtual methods
.method evict(Ljava/util/concurrent/Future;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/Future<",
            "Lorg/mapsforge/core/graphics/HillshadingBitmap;",
            ">;)V"
        }
    .end annotation

    iget v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->size:I

    if-lez v0, :cond_11

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->lru:Ljava/util/LinkedHashSet;

    monitor-enter v0

    :try_start_7
    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->lru:Ljava/util/LinkedHashSet;

    invoke-virtual {v1, p1}, Ljava/util/AbstractCollection;->add(Ljava/lang/Object;)Z

    monitor-exit v0

    goto :goto_11

    :catchall_e
    move-exception p1

    monitor-exit v0
    :try_end_10
    .catchall {:try_start_7 .. :try_end_10} :catchall_e

    throw p1

    :cond_11
    :goto_11
    return-void
.end method

.method public getSize()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->size:I

    return v0
.end method

.method markUsed(Ljava/util/concurrent/Future;)Ljava/util/concurrent/Future;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/Future<",
            "Lorg/mapsforge/core/graphics/HillshadingBitmap;",
            ">;)",
            "Ljava/util/concurrent/Future<",
            "Lorg/mapsforge/core/graphics/HillshadingBitmap;",
            ">;"
        }
    .end annotation

    iget v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->size:I

    if-lez v0, :cond_34

    if-eqz p1, :cond_34

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->lru:Ljava/util/LinkedHashSet;

    monitor-enter v0

    :try_start_9
    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->lru:Ljava/util/LinkedHashSet;

    invoke-virtual {v1, p1}, Ljava/util/AbstractCollection;->remove(Ljava/lang/Object;)Z

    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->lru:Ljava/util/LinkedHashSet;

    invoke-virtual {v1, p1}, Ljava/util/AbstractCollection;->add(Ljava/lang/Object;)Z

    iget-object p1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->lru:Ljava/util/LinkedHashSet;

    invoke-virtual {p1}, Ljava/util/AbstractCollection;->size()I

    move-result p1

    iget v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->size:I

    if-le p1, v1, :cond_2e

    iget-object p1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->lru:Ljava/util/LinkedHashSet;

    invoke-virtual {p1}, Ljava/util/AbstractCollection;->iterator()Ljava/util/Iterator;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/concurrent/Future;

    invoke-interface {p1}, Ljava/util/Iterator;->remove()V

    monitor-exit v0

    return-object v1

    :cond_2e
    const/4 p1, 0x0

    monitor-exit v0

    return-object p1

    :catchall_31
    move-exception p1

    monitor-exit v0
    :try_end_33
    .catchall {:try_start_9 .. :try_end_33} :catchall_31

    throw p1

    :cond_34
    return-object p1
.end method

.method public setSize(I)V
    .registers 5

    const/4 v0, 0x0

    invoke-static {v0, p1}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->size:I

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->lru:Ljava/util/LinkedHashSet;

    invoke-virtual {v0}, Ljava/util/AbstractCollection;->size()I

    move-result v0

    if-ge p1, v0, :cond_29

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->lru:Ljava/util/LinkedHashSet;

    monitor-enter v0

    :try_start_12
    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->lru:Ljava/util/LinkedHashSet;

    invoke-virtual {v1}, Ljava/util/AbstractCollection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_18
    iget-object v2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->lru:Ljava/util/LinkedHashSet;

    invoke-virtual {v2}, Ljava/util/AbstractCollection;->size()I

    move-result v2

    if-le v2, p1, :cond_24

    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_18

    :cond_24
    monitor-exit v0

    goto :goto_29

    :catchall_26
    move-exception p1

    monitor-exit v0
    :try_end_28
    .catchall {:try_start_12 .. :try_end_28} :catchall_26

    throw p1

    :cond_29
    :goto_29
    return-void
.end method
