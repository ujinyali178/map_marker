.class public Lorg/mapsforge/map/layer/Layers;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Iterable;
.implements Ljava/util/RandomAccess;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Iterable<",
        "Lorg/mapsforge/map/layer/Layer;",
        ">;",
        "Ljava/util/RandomAccess;"
    }
.end annotation


# instance fields
.field private final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field private final groupIndex:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final groupList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final layersList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/map/layer/Layer;",
            ">;"
        }
    .end annotation
.end field

.field private final redrawer:Lorg/mapsforge/map/layer/Redrawer;


# direct methods
.method constructor <init>(Lorg/mapsforge/map/layer/Redrawer;Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    iput-object p2, p0, Lorg/mapsforge/map/layer/Layers;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    new-instance p1, Ljava/util/HashMap;

    invoke-direct {p1}, Ljava/util/HashMap;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    new-instance p1, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {p1}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    return-void
.end method

.method private static checkIsNull(Ljava/util/Collection;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Lorg/mapsforge/map/layer/Layer;",
            ">;)V"
        }
    .end annotation

    if-eqz p0, :cond_17

    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_6
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_16

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/map/layer/Layer;

    invoke-static {v0}, Lorg/mapsforge/map/layer/Layers;->checkIsNull(Lorg/mapsforge/map/layer/Layer;)V

    goto :goto_6

    :cond_16
    return-void

    :cond_17
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string v0, "layers must not be null"

    invoke-direct {p0, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private static checkIsNull(Lorg/mapsforge/map/layer/Layer;)V
    .registers 2

    if-eqz p0, :cond_3

    return-void

    :cond_3
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string v0, "layer must not be null"

    invoke-direct {p0, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method


# virtual methods
.method public declared-synchronized add(ILorg/mapsforge/map/layer/Layer;)V
    .registers 4

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    invoke-virtual {p0, p1, p2, v0}, Lorg/mapsforge/map/layer/Layers;->add(ILorg/mapsforge/map/layer/Layer;Z)V
    :try_end_5
    .catchall {:try_start_2 .. :try_end_5} :catchall_7

    monitor-exit p0

    return-void

    :catchall_7
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized add(ILorg/mapsforge/map/layer/Layer;Z)V
    .registers 5

    monitor-enter p0

    :try_start_1
    invoke-static {p2}, Lorg/mapsforge/map/layer/Layers;->checkIsNull(Lorg/mapsforge/map/layer/Layer;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {p2, v0}, Lorg/mapsforge/map/layer/Layer;->setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0, p1, p2}, Ljava/util/List;->add(ILjava/lang/Object;)V

    iget-object p1, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-virtual {p2, p1}, Lorg/mapsforge/map/layer/Layer;->assign(Lorg/mapsforge/map/layer/Redrawer;)V

    if-eqz p3, :cond_1a

    iget-object p1, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-interface {p1}, Lorg/mapsforge/map/layer/Redrawer;->redrawLayers()V
    :try_end_1a
    .catchall {:try_start_1 .. :try_end_1a} :catchall_1c

    :cond_1a
    monitor-exit p0

    return-void

    :catchall_1c
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized add(Lorg/mapsforge/map/layer/Layer;)V
    .registers 3

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    invoke-virtual {p0, p1, v0}, Lorg/mapsforge/map/layer/Layers;->add(Lorg/mapsforge/map/layer/Layer;Z)V
    :try_end_5
    .catchall {:try_start_2 .. :try_end_5} :catchall_7

    monitor-exit p0

    return-void

    :catchall_7
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized add(Lorg/mapsforge/map/layer/Layer;I)V
    .registers 4

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    invoke-virtual {p0, p1, p2, v0}, Lorg/mapsforge/map/layer/Layers;->add(Lorg/mapsforge/map/layer/Layer;IZ)V
    :try_end_5
    .catchall {:try_start_2 .. :try_end_5} :catchall_7

    monitor-exit p0

    return-void

    :catchall_7
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized add(Lorg/mapsforge/map/layer/Layer;IZ)V
    .registers 6

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-interface {v0, p2}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result p2

    if-ltz p2, :cond_68

    add-int/lit8 p2, p2, 0x1

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ne p2, v0, :cond_1b

    invoke-virtual {p0, p1, p3}, Lorg/mapsforge/map/layer/Layers;->add(Lorg/mapsforge/map/layer/Layer;Z)V

    goto :goto_66

    :cond_1b
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    invoke-interface {v1, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {p0, v0, p1, p3}, Lorg/mapsforge/map/layer/Layers;->add(ILorg/mapsforge/map/layer/Layer;Z)V

    :goto_30
    iget-object p1, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result p1

    if-ge p2, p1, :cond_66

    iget-object p1, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    invoke-interface {p1, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    iget-object p3, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    add-int/lit8 p1, p1, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {p3, v0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_63
    .catchall {:try_start_1 .. :try_end_63} :catchall_70

    add-int/lit8 p2, p2, 0x1

    goto :goto_30

    :cond_66
    :goto_66
    monitor-exit p0

    return-void

    :cond_68
    :try_start_68
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "unknown layer group"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
    :try_end_70
    .catchall {:try_start_68 .. :try_end_70} :catchall_70

    :catchall_70
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized add(Lorg/mapsforge/map/layer/Layer;Z)V
    .registers 4

    monitor-enter p0

    :try_start_1
    invoke-static {p1}, Lorg/mapsforge/map/layer/Layers;->checkIsNull(Lorg/mapsforge/map/layer/Layer;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {p1, v0}, Lorg/mapsforge/map/layer/Layer;->setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-virtual {p1, v0}, Lorg/mapsforge/map/layer/Layer;->assign(Lorg/mapsforge/map/layer/Redrawer;)V

    if-eqz p2, :cond_1a

    iget-object p1, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-interface {p1}, Lorg/mapsforge/map/layer/Redrawer;->redrawLayers()V
    :try_end_1a
    .catchall {:try_start_1 .. :try_end_1a} :catchall_1c

    :cond_1a
    monitor-exit p0

    return-void

    :catchall_1c
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addAll(ILjava/util/Collection;)Z
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection<",
            "Lorg/mapsforge/map/layer/Layer;",
            ">;)Z"
        }
    .end annotation

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    invoke-virtual {p0, p1, p2, v0}, Lorg/mapsforge/map/layer/Layers;->addAll(ILjava/util/Collection;Z)Z

    move-result p1
    :try_end_6
    .catchall {:try_start_2 .. :try_end_6} :catchall_8

    monitor-exit p0

    return p1

    :catchall_8
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addAll(ILjava/util/Collection;Z)Z
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection<",
            "Lorg/mapsforge/map/layer/Layer;",
            ">;Z)Z"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    invoke-static {p2}, Lorg/mapsforge/map/layer/Layers;->checkIsNull(Ljava/util/Collection;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0, p1, p2}, Ljava/util/List;->addAll(ILjava/util/Collection;)Z

    move-result p1

    if-eqz p1, :cond_31

    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_10
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_27

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lorg/mapsforge/map/layer/Layer;

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {p2, v0}, Lorg/mapsforge/map/layer/Layer;->setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-virtual {p2, v0}, Lorg/mapsforge/map/layer/Layer;->assign(Lorg/mapsforge/map/layer/Redrawer;)V

    goto :goto_10

    :cond_27
    if-eqz p3, :cond_2e

    iget-object p1, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-interface {p1}, Lorg/mapsforge/map/layer/Redrawer;->redrawLayers()V
    :try_end_2e
    .catchall {:try_start_1 .. :try_end_2e} :catchall_33

    :cond_2e
    const/4 p1, 0x1

    :goto_2f
    monitor-exit p0

    return p1

    :cond_31
    const/4 p1, 0x0

    goto :goto_2f

    :catchall_33
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addAll(Ljava/util/Collection;)Z
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Lorg/mapsforge/map/layer/Layer;",
            ">;)Z"
        }
    .end annotation

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    invoke-virtual {p0, p1, v0}, Lorg/mapsforge/map/layer/Layers;->addAll(Ljava/util/Collection;Z)Z

    move-result p1
    :try_end_6
    .catchall {:try_start_2 .. :try_end_6} :catchall_8

    monitor-exit p0

    return p1

    :catchall_8
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addAll(Ljava/util/Collection;I)Z
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Lorg/mapsforge/map/layer/Layer;",
            ">;I)Z"
        }
    .end annotation

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    invoke-virtual {p0, p1, p2, v0}, Lorg/mapsforge/map/layer/Layers;->addAll(Ljava/util/Collection;IZ)Z

    move-result p1
    :try_end_6
    .catchall {:try_start_2 .. :try_end_6} :catchall_8

    monitor-exit p0

    return p1

    :catchall_8
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addAll(Ljava/util/Collection;IZ)Z
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Lorg/mapsforge/map/layer/Layer;",
            ">;IZ)Z"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-interface {v0, p2}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result p2

    if-ltz p2, :cond_73

    const/4 v0, 0x1

    add-int/2addr p2, v0

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ne p2, v1, :cond_1d

    invoke-virtual {p0, p1, p3}, Lorg/mapsforge/map/layer/Layers;->addAll(Ljava/util/Collection;Z)Z

    move-result p1
    :try_end_1b
    .catchall {:try_start_1 .. :try_end_1b} :catchall_7b

    monitor-exit p0

    return p1

    :cond_1d
    :try_start_1d
    iget-object v1, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    iget-object v2, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    invoke-interface {v2, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {p0, v1, p1, p3}, Lorg/mapsforge/map/layer/Layers;->addAll(ILjava/util/Collection;Z)Z

    move-result p3

    if-eqz p3, :cond_70

    :goto_35
    iget-object p3, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    invoke-interface {p3}, Ljava/util/List;->size()I

    move-result p3

    if-ge p2, p3, :cond_6e

    iget-object p3, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    invoke-interface {p3, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p3

    check-cast p3, Ljava/lang/Integer;

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p3

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v3, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    invoke-interface {v3, p3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p3

    check-cast p3, Ljava/lang/Integer;

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p3

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v3

    add-int/2addr p3, v3

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    invoke-interface {v1, v2, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_6b
    .catchall {:try_start_1d .. :try_end_6b} :catchall_7b

    add-int/lit8 p2, p2, 0x1

    goto :goto_35

    :cond_6e
    monitor-exit p0

    return v0

    :cond_70
    const/4 p1, 0x0

    monitor-exit p0

    return p1

    :cond_73
    :try_start_73
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "unknown layer group"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
    :try_end_7b
    .catchall {:try_start_73 .. :try_end_7b} :catchall_7b

    :catchall_7b
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addAll(Ljava/util/Collection;Z)Z
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Lorg/mapsforge/map/layer/Layer;",
            ">;Z)Z"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    invoke-static {p1}, Lorg/mapsforge/map/layer/Layers;->checkIsNull(Ljava/util/Collection;)V

    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/layer/Layer;

    iget-object v2, p0, Lorg/mapsforge/map/layer/Layers;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1, v2}, Lorg/mapsforge/map/layer/Layer;->setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V

    goto :goto_8

    :cond_1a
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    move-result v0

    if-eqz v0, :cond_42

    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_26
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_38

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/map/layer/Layer;

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/layer/Layer;->assign(Lorg/mapsforge/map/layer/Redrawer;)V

    goto :goto_26

    :cond_38
    if-eqz p2, :cond_3f

    iget-object p1, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-interface {p1}, Lorg/mapsforge/map/layer/Redrawer;->redrawLayers()V
    :try_end_3f
    .catchall {:try_start_1 .. :try_end_3f} :catchall_44

    :cond_3f
    const/4 p1, 0x1

    :goto_40
    monitor-exit p0

    return p1

    :cond_42
    const/4 p1, 0x0

    goto :goto_40

    :catchall_44
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addGroup(I)V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2b

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->groupList:Ljava/util/List;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_29
    .catchall {:try_start_1 .. :try_end_29} :catchall_33

    monitor-exit p0

    return-void

    :cond_2b
    :try_start_2b
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "group added twice"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
    :try_end_33
    .catchall {:try_start_2b .. :try_end_33} :catchall_33

    :catchall_33
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized clear()V
    .registers 2

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    invoke-virtual {p0, v0}, Lorg/mapsforge/map/layer/Layers;->clear(Z)V
    :try_end_5
    .catchall {:try_start_2 .. :try_end_5} :catchall_7

    monitor-exit p0

    return-void

    :catchall_7
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized clear(Z)V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_7
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_17

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/layer/Layer;

    invoke-virtual {v1}, Lorg/mapsforge/map/layer/Layer;->unassign()V

    goto :goto_7

    :cond_17
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    if-eqz p1, :cond_23

    iget-object p1, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-interface {p1}, Lorg/mapsforge/map/layer/Redrawer;->redrawLayers()V
    :try_end_23
    .catchall {:try_start_1 .. :try_end_23} :catchall_25

    :cond_23
    monitor-exit p0

    return-void

    :catchall_25
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized contains(Lorg/mapsforge/map/layer/Layer;)Z
    .registers 3

    monitor-enter p0

    :try_start_1
    invoke-static {p1}, Lorg/mapsforge/map/layer/Layers;->checkIsNull(Lorg/mapsforge/map/layer/Layer;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result p1
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    monitor-exit p0

    return p1

    :catchall_c
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized get(I)Lorg/mapsforge/map/layer/Layer;
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/map/layer/Layer;
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-object p1

    :catchall_b
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized indexOf(Lorg/mapsforge/map/layer/Layer;)I
    .registers 3

    monitor-enter p0

    :try_start_1
    invoke-static {p1}, Lorg/mapsforge/map/layer/Layers;->checkIsNull(Lorg/mapsforge/map/layer/Layer;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result p1
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    monitor-exit p0

    return p1

    :catchall_c
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized isEmpty()Z
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_9

    monitor-exit p0

    return v0

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized iterator()Ljava/util/Iterator;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator<",
            "Lorg/mapsforge/map/layer/Layer;",
            ">;"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_9

    monitor-exit p0

    return-object v0

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized remove(I)Lorg/mapsforge/map/layer/Layer;
    .registers 3

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    invoke-virtual {p0, p1, v0}, Lorg/mapsforge/map/layer/Layers;->remove(IZ)Lorg/mapsforge/map/layer/Layer;

    move-result-object p1
    :try_end_6
    .catchall {:try_start_2 .. :try_end_6} :catchall_8

    monitor-exit p0

    return-object p1

    :catchall_8
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized remove(IZ)Lorg/mapsforge/map/layer/Layer;
    .registers 8

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/map/layer/Layer;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/Layer;->unassign()V

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_16
    :goto_16
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3c

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    iget-object v3, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    invoke-interface {v3, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    if-le v3, p1, :cond_16

    iget-object v4, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    add-int/lit8 v3, v3, -0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v4, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_16

    :cond_3c
    if-eqz p2, :cond_43

    iget-object p1, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-interface {p1}, Lorg/mapsforge/map/layer/Redrawer;->redrawLayers()V
    :try_end_43
    .catchall {:try_start_1 .. :try_end_43} :catchall_45

    :cond_43
    monitor-exit p0

    return-object v0

    :catchall_45
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized remove(Lorg/mapsforge/map/layer/Layer;)Z
    .registers 3

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    invoke-virtual {p0, p1, v0}, Lorg/mapsforge/map/layer/Layers;->remove(Lorg/mapsforge/map/layer/Layer;Z)Z

    move-result p1
    :try_end_6
    .catchall {:try_start_2 .. :try_end_6} :catchall_8

    monitor-exit p0

    return p1

    :catchall_8
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized remove(Lorg/mapsforge/map/layer/Layer;Z)Z
    .registers 7

    monitor-enter p0

    :try_start_1
    invoke-static {p1}, Lorg/mapsforge/map/layer/Layers;->checkIsNull(Lorg/mapsforge/map/layer/Layer;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4f

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/Layer;->unassign()V

    iget-object p1, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    invoke-interface {p1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_1f
    :goto_1f
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_45

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    iget-object v2, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    if-le v2, v0, :cond_1f

    iget-object v3, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    add-int/lit8 v2, v2, -0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v3, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1f

    :cond_45
    if-eqz p2, :cond_4c

    iget-object p1, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-interface {p1}, Lorg/mapsforge/map/layer/Redrawer;->redrawLayers()V
    :try_end_4c
    .catchall {:try_start_1 .. :try_end_4c} :catchall_52

    :cond_4c
    monitor-exit p0

    const/4 p1, 0x1

    return p1

    :cond_4f
    const/4 p1, 0x0

    monitor-exit p0

    return p1

    :catchall_52
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized removeAll(Ljava/util/Collection;)Z
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Lorg/mapsforge/map/layer/Layer;",
            ">;)Z"
        }
    .end annotation

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    invoke-virtual {p0, p1, v0}, Lorg/mapsforge/map/layer/Layers;->removeAll(Ljava/util/Collection;Z)Z

    move-result p1
    :try_end_6
    .catchall {:try_start_2 .. :try_end_6} :catchall_8

    monitor-exit p0

    return p1

    :catchall_8
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized removeAll(Ljava/util/Collection;Z)Z
    .registers 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Lorg/mapsforge/map/layer/Layer;",
            ">;Z)Z"
        }
    .end annotation

    monitor-enter p0

    :try_start_1
    invoke-static {p1}, Lorg/mapsforge/map/layer/Layers;->checkIsNull(Ljava/util/Collection;)V

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v0

    new-array v1, v0, [I

    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    :goto_10
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_28

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lorg/mapsforge/map/layer/Layer;

    add-int/lit8 v6, v4, 0x1

    iget-object v7, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v7, v5}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v5

    aput v5, v1, v4

    move v4, v6

    goto :goto_10

    :cond_28
    iget-object v2, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    move-result v2

    if-eqz v2, :cond_85

    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_34
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_44

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/layer/Layer;

    invoke-virtual {v2}, Lorg/mapsforge/map/layer/Layer;->unassign()V

    goto :goto_34

    :cond_44
    :goto_44
    if-ge v3, v0, :cond_7b

    aget p1, v1, v3

    iget-object v2, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_52
    :goto_52
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_78

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    iget-object v5, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    invoke-interface {v5, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    if-le v5, p1, :cond_52

    iget-object v6, p0, Lorg/mapsforge/map/layer/Layers;->groupIndex:Ljava/util/Map;

    add-int/lit8 v5, v5, -0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v6, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_52

    :cond_78
    add-int/lit8 v3, v3, 0x1

    goto :goto_44

    :cond_7b
    if-eqz p2, :cond_82

    iget-object p1, p0, Lorg/mapsforge/map/layer/Layers;->redrawer:Lorg/mapsforge/map/layer/Redrawer;

    invoke-interface {p1}, Lorg/mapsforge/map/layer/Redrawer;->redrawLayers()V
    :try_end_82
    .catchall {:try_start_1 .. :try_end_82} :catchall_87

    :cond_82
    monitor-exit p0

    const/4 p1, 0x1

    return p1

    :cond_85
    monitor-exit p0

    return v3

    :catchall_87
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized size()I
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/layer/Layers;->layersList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_9

    monitor-exit p0

    return v0

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method
