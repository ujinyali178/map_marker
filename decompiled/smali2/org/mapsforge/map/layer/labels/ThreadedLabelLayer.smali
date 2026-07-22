.class public Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;
.super Lorg/mapsforge/map/layer/labels/LabelLayer;
.source "SourceFile"


# instance fields
.field executorService:Ljava/util/concurrent/ExecutorService;

.field future:Ljava/util/concurrent/Future;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Future<",
            "*>;"
        }
    .end annotation
.end field

.field requestedLowerRight:Lorg/mapsforge/core/model/Tile;

.field requestedUpperLeft:Lorg/mapsforge/core/model/Tile;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/layer/labels/LabelStore;)V
    .registers 3

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/layer/labels/LabelLayer;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/layer/labels/LabelStore;)V

    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;->executorService:Ljava/util/concurrent/ExecutorService;

    return-void
.end method


# virtual methods
.method public draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v0

    invoke-static {p1, p2, v0}, Lorg/mapsforge/map/util/LayerUtil;->getUpperLeft(Lorg/mapsforge/core/model/BoundingBox;BI)Lorg/mapsforge/core/model/Tile;

    move-result-object v0

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v1

    invoke-static {p1, p2, v1}, Lorg/mapsforge/map/util/LayerUtil;->getLowerRight(Lorg/mapsforge/core/model/BoundingBox;BI)Lorg/mapsforge/core/model/Tile;

    move-result-object p1

    iget-object p2, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->upperLeft:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v0, p2}, Lorg/mapsforge/core/model/Tile;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_2e

    iget-object p2, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->lowerRight:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {p1, p2}, Lorg/mapsforge/core/model/Tile;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_2e

    iget p2, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->lastLabelStoreVersion:I

    iget-object v1, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->labelStore:Lorg/mapsforge/map/layer/labels/LabelStore;

    invoke-interface {v1}, Lorg/mapsforge/map/layer/labels/LabelStore;->getVersion()I

    move-result v1

    if-eq p2, v1, :cond_31

    :cond_2e
    invoke-virtual {p0, v0, p1}, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;->getData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)V

    :cond_31
    iget-object p2, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->upperLeft:Lorg/mapsforge/core/model/Tile;

    if-eqz p2, :cond_40

    iget-object v1, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->lowerRight:Lorg/mapsforge/core/model/Tile;

    invoke-static {p2, v1, v0, p1}, Lorg/mapsforge/core/model/Tile;->tileAreasOverlap(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Z

    move-result p1

    if-eqz p1, :cond_40

    invoke-virtual {p0, p3, p4}, Lorg/mapsforge/map/layer/labels/LabelLayer;->draw(Lorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V

    :cond_40
    return-void
.end method

.method protected getData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)V
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;->requestedUpperLeft:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {p1, v0}, Lorg/mapsforge/core/model/Tile;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_11

    iget-object v0, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;->requestedLowerRight:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {p2, v0}, Lorg/mapsforge/core/model/Tile;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_11

    return-void

    :cond_11
    iput-object p1, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;->requestedUpperLeft:Lorg/mapsforge/core/model/Tile;

    iput-object p2, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;->requestedLowerRight:Lorg/mapsforge/core/model/Tile;

    iget-object v0, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;->future:Ljava/util/concurrent/Future;

    if-eqz v0, :cond_1d

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/concurrent/Future;->cancel(Z)Z

    :cond_1d
    iget-object v0, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;->executorService:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;

    invoke-direct {v1, p0, p1, p2}, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;-><init>(Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;->future:Ljava/util/concurrent/Future;

    return-void
.end method

.method public onDestroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;->executorService:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    return-void
.end method
