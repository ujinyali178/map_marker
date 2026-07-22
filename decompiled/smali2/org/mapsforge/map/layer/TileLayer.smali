.class public abstract Lorg/mapsforge/map/layer/TileLayer;
.super Lorg/mapsforge/map/layer/Layer;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lorg/mapsforge/map/layer/queue/Job;",
        ">",
        "Lorg/mapsforge/map/layer/Layer;"
    }
.end annotation


# instance fields
.field private alpha:F

.field protected final hasJobQueue:Z

.field protected final isTransparent:Z

.field protected jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/mapsforge/map/layer/queue/JobQueue<",
            "TT;>;"
        }
    .end annotation
.end field

.field private final mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

.field private final matrix:Lorg/mapsforge/core/graphics/Matrix;

.field private parentTilesRendering:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

.field protected final tileCache:Lorg/mapsforge/map/layer/cache/TileCache;


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/core/graphics/Matrix;Z)V
    .registers 11

    const/4 v5, 0x1

    const/4 v5, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    invoke-direct/range {v0 .. v5}, Lorg/mapsforge/map/layer/TileLayer;-><init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/core/graphics/Matrix;ZZ)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/core/graphics/Matrix;ZZ)V
    .registers 7

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lorg/mapsforge/map/layer/TileLayer;->alpha:F

    sget-object v0, Lorg/mapsforge/core/util/Parameters;->PARENT_TILES_RENDERING:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    iput-object v0, p0, Lorg/mapsforge/map/layer/TileLayer;->parentTilesRendering:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    if-eqz p1, :cond_22

    if-eqz p2, :cond_1a

    iput-boolean p5, p0, Lorg/mapsforge/map/layer/TileLayer;->hasJobQueue:Z

    iput-object p1, p0, Lorg/mapsforge/map/layer/TileLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    iput-object p2, p0, Lorg/mapsforge/map/layer/TileLayer;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    iput-object p3, p0, Lorg/mapsforge/map/layer/TileLayer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    iput-boolean p4, p0, Lorg/mapsforge/map/layer/TileLayer;->isTransparent:Z

    return-void

    :cond_1a
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "mapViewPosition must not be null"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_22
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "tileCache must not be null"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private drawParentTileBitmap(Lorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Tile;)V
    .registers 21

    move-object/from16 v0, p0

    move-object/from16 v13, p1

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    const/4 v3, 0x4

    invoke-direct {v0, v2, v3}, Lorg/mapsforge/map/layer/TileLayer;->getCachedParentTile(Lorg/mapsforge/core/model/Tile;I)Lorg/mapsforge/core/model/Tile;

    move-result-object v3

    if-eqz v3, :cond_cc

    iget-object v4, v0, Lorg/mapsforge/map/layer/TileLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-virtual {v0, v3}, Lorg/mapsforge/map/layer/TileLayer;->createJob(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/queue/Job;

    move-result-object v5

    invoke-interface {v4, v5}, Lorg/mapsforge/map/layer/cache/TileCache;->getImmediately(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object v14

    if-eqz v14, :cond_cc

    iget-object v4, v0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v4}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v4

    invoke-virtual {v2, v3}, Lorg/mapsforge/core/model/Tile;->getShiftX(Lorg/mapsforge/core/model/Tile;)I

    move-result v5

    mul-int v5, v5, v4

    int-to-long v5, v5

    invoke-virtual {v2, v3}, Lorg/mapsforge/core/model/Tile;->getShiftY(Lorg/mapsforge/core/model/Tile;)I

    move-result v7

    mul-int v7, v7, v4

    int-to-long v7, v7

    iget-byte v2, v2, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget-byte v3, v3, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    sub-int/2addr v2, v3

    int-to-byte v2, v2

    const-wide/high16 v9, 0x4000000000000000L    # 2.0

    int-to-double v2, v2

    invoke-static {v9, v10, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v2

    double-to-float v2, v2

    iget-wide v9, v1, Lorg/mapsforge/core/model/Point;->x:D

    invoke-static {v9, v10}, Ljava/lang/Math;->round(D)J

    move-result-wide v9

    long-to-int v10, v9

    iget-wide v11, v1, Lorg/mapsforge/core/model/Point;->y:D

    invoke-static {v11, v12}, Ljava/lang/Math;->round(D)J

    move-result-wide v11

    long-to-int v9, v11

    iget-object v1, v0, Lorg/mapsforge/map/layer/TileLayer;->parentTilesRendering:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    sget-object v3, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;->SPEED:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    if-ne v1, v3, :cond_94

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/GraphicContext;->isAntiAlias()Z

    move-result v15

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/GraphicContext;->isFilterBitmap()Z

    move-result v12

    const/4 v1, 0x0

    invoke-interface {v13, v1}, Lorg/mapsforge/core/graphics/GraphicContext;->setAntiAlias(Z)V

    invoke-interface {v13, v1}, Lorg/mapsforge/core/graphics/GraphicContext;->setFilterBitmap(Z)V

    long-to-float v1, v5

    div-float/2addr v1, v2

    float-to-int v3, v1

    long-to-float v1, v7

    div-float/2addr v1, v2

    float-to-int v11, v1

    move/from16 p2, v12

    int-to-long v12, v4

    add-long/2addr v5, v12

    long-to-float v1, v5

    div-float/2addr v1, v2

    float-to-int v5, v1

    add-long/2addr v7, v12

    long-to-float v1, v7

    div-float/2addr v1, v2

    float-to-int v6, v1

    add-int v12, v10, v4

    add-int v13, v9, v4

    iget v8, v0, Lorg/mapsforge/map/layer/TileLayer;->alpha:F

    iget-object v1, v0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getFilter()Lorg/mapsforge/core/graphics/Filter;

    move-result-object v16

    move-object/from16 v1, p1

    move-object v2, v14

    move v4, v11

    move v7, v10

    move v11, v8

    move v8, v9

    move v9, v12

    move v10, v13

    move/from16 v13, p2

    move-object/from16 v12, v16

    invoke-interface/range {v1 .. v12}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;IIIIIIIIFLorg/mapsforge/core/graphics/Filter;)V

    invoke-interface {v1, v15}, Lorg/mapsforge/core/graphics/GraphicContext;->setAntiAlias(Z)V

    invoke-interface {v1, v13}, Lorg/mapsforge/core/graphics/GraphicContext;->setFilterBitmap(Z)V

    goto :goto_c9

    :cond_94
    move-object v1, v13

    iget-object v3, v0, Lorg/mapsforge/map/layer/TileLayer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    invoke-interface {v3}, Lorg/mapsforge/core/graphics/Matrix;->reset()V

    iget-object v3, v0, Lorg/mapsforge/map/layer/TileLayer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    int-to-long v11, v10

    sub-long/2addr v11, v5

    long-to-float v4, v11

    int-to-long v5, v9

    sub-long/2addr v5, v7

    long-to-float v5, v5

    invoke-interface {v3, v4, v5}, Lorg/mapsforge/core/graphics/Matrix;->translate(FF)V

    iget-object v3, v0, Lorg/mapsforge/map/layer/TileLayer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    invoke-interface {v3, v2, v2}, Lorg/mapsforge/core/graphics/Matrix;->scale(FF)V

    iget-object v2, v0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v2

    iget-object v3, v0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v3}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v3

    invoke-interface {v1, v10, v9, v2, v3}, Lorg/mapsforge/core/graphics/GraphicContext;->setClip(IIII)V

    iget-object v2, v0, Lorg/mapsforge/map/layer/TileLayer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    iget v3, v0, Lorg/mapsforge/map/layer/TileLayer;->alpha:F

    iget-object v4, v0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v4}, Lorg/mapsforge/map/model/DisplayModel;->getFilter()Lorg/mapsforge/core/graphics/Filter;

    move-result-object v4

    invoke-interface {v1, v14, v2, v3, v4}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/core/graphics/Matrix;FLorg/mapsforge/core/graphics/Filter;)V

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/GraphicContext;->resetClip()V

    :goto_c9
    invoke-interface {v14}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    :cond_cc
    return-void
.end method

.method private getCachedParentTile(Lorg/mapsforge/core/model/Tile;I)Lorg/mapsforge/core/model/Tile;
    .registers 5

    const/4 v0, 0x0

    if-nez p2, :cond_4

    return-object v0

    :cond_4
    invoke-virtual {p1}, Lorg/mapsforge/core/model/Tile;->getParent()Lorg/mapsforge/core/model/Tile;

    move-result-object p1

    if-nez p1, :cond_b

    return-object v0

    :cond_b
    iget-object v0, p0, Lorg/mapsforge/map/layer/TileLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/layer/TileLayer;->createJob(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/queue/Job;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/mapsforge/map/layer/cache/TileCache;->containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z

    move-result v0

    if-eqz v0, :cond_18

    return-object p1

    :cond_18
    add-int/lit8 p2, p2, -0x1

    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/layer/TileLayer;->getCachedParentTile(Lorg/mapsforge/core/model/Tile;I)Lorg/mapsforge/core/model/Tile;

    move-result-object p1

    return-object p1
.end method


# virtual methods
.method protected abstract createJob(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/queue/Job;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/core/model/Tile;",
            ")TT;"
        }
    .end annotation
.end method

.method public draw(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    .registers 14

    iget-object v0, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v0

    invoke-static {p1, p2, p4, v0}, Lorg/mapsforge/map/util/LayerUtil;->getTilePositions(Lorg/mapsforge/core/model/BoundingBox;BLorg/mapsforge/core/model/Point;I)Ljava/util/List;

    move-result-object p1

    invoke-interface {p3}, Lorg/mapsforge/core/graphics/GraphicContext;->resetClip()V

    iget-boolean p2, p0, Lorg/mapsforge/map/layer/TileLayer;->isTransparent:Z

    if-nez p2, :cond_1a

    iget-object p2, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {p2}, Lorg/mapsforge/map/model/DisplayModel;->getBackgroundColor()I

    move-result p2

    invoke-interface {p3, p2}, Lorg/mapsforge/core/graphics/GraphicContext;->fillColor(I)V

    :cond_1a
    new-instance p2, Ljava/util/HashSet;

    invoke-direct {p2}, Ljava/util/HashSet;-><init>()V

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p4

    :goto_23
    invoke-interface {p4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_39

    invoke-interface {p4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/map/layer/TilePosition;

    iget-object v0, v0, Lorg/mapsforge/map/layer/TilePosition;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/layer/TileLayer;->createJob(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/queue/Job;

    move-result-object v0

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_23

    :cond_39
    iget-object p4, p0, Lorg/mapsforge/map/layer/TileLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {p4, p2}, Lorg/mapsforge/map/layer/cache/TileCache;->setWorkingSet(Ljava/util/Set;)V

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result p2

    add-int/lit8 p2, p2, -0x1

    :goto_44
    if-ltz p2, :cond_b2

    invoke-interface {p1, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p4

    check-cast p4, Lorg/mapsforge/map/layer/TilePosition;

    iget-object v0, p4, Lorg/mapsforge/map/layer/TilePosition;->point:Lorg/mapsforge/core/model/Point;

    iget-object p4, p4, Lorg/mapsforge/map/layer/TilePosition;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {p0, p4}, Lorg/mapsforge/map/layer/TileLayer;->createJob(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/queue/Job;

    move-result-object v1

    iget-object v2, p0, Lorg/mapsforge/map/layer/TileLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v2, v1}, Lorg/mapsforge/map/layer/cache/TileCache;->getImmediately(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object v2

    if-nez v2, :cond_77

    iget-boolean v2, p0, Lorg/mapsforge/map/layer/TileLayer;->hasJobQueue:Z

    if-eqz v2, :cond_6d

    iget-object v2, p0, Lorg/mapsforge/map/layer/TileLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v2, v1}, Lorg/mapsforge/map/layer/cache/TileCache;->containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z

    move-result v2

    if-nez v2, :cond_6d

    iget-object v2, p0, Lorg/mapsforge/map/layer/TileLayer;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    invoke-virtual {v2, v1}, Lorg/mapsforge/map/layer/queue/JobQueue;->add(Lorg/mapsforge/map/layer/queue/Job;)V

    :cond_6d
    iget-object v1, p0, Lorg/mapsforge/map/layer/TileLayer;->parentTilesRendering:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    sget-object v2, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;->OFF:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    if-eq v1, v2, :cond_af

    invoke-direct {p0, p3, v0, p4}, Lorg/mapsforge/map/layer/TileLayer;->drawParentTileBitmap(Lorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Tile;)V

    goto :goto_af

    :cond_77
    invoke-virtual {p0, p4, v2}, Lorg/mapsforge/map/layer/TileLayer;->isTileStale(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/graphics/TileBitmap;)Z

    move-result p4

    if-eqz p4, :cond_8e

    iget-boolean p4, p0, Lorg/mapsforge/map/layer/TileLayer;->hasJobQueue:Z

    if-eqz p4, :cond_8e

    iget-object p4, p0, Lorg/mapsforge/map/layer/TileLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {p4, v1}, Lorg/mapsforge/map/layer/cache/TileCache;->containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z

    move-result p4

    if-nez p4, :cond_8e

    iget-object p4, p0, Lorg/mapsforge/map/layer/TileLayer;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    invoke-virtual {p4, v1}, Lorg/mapsforge/map/layer/queue/JobQueue;->add(Lorg/mapsforge/map/layer/queue/Job;)V

    :cond_8e
    invoke-virtual {p0, v1}, Lorg/mapsforge/map/layer/TileLayer;->retrieveLabelsOnly(Lorg/mapsforge/map/layer/queue/Job;)V

    iget-wide v3, v0, Lorg/mapsforge/core/model/Point;->x:D

    invoke-static {v3, v4}, Ljava/lang/Math;->round(D)J

    move-result-wide v3

    long-to-int v5, v3

    iget-wide v0, v0, Lorg/mapsforge/core/model/Point;->y:D

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    long-to-int v6, v0

    iget v7, p0, Lorg/mapsforge/map/layer/TileLayer;->alpha:F

    iget-object p4, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {p4}, Lorg/mapsforge/map/model/DisplayModel;->getFilter()Lorg/mapsforge/core/graphics/Filter;

    move-result-object v8

    move-object v3, p3

    move-object v4, v2

    invoke-interface/range {v3 .. v8}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;IIFLorg/mapsforge/core/graphics/Filter;)V

    invoke-interface {v2}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    :cond_af
    :goto_af
    add-int/lit8 p2, p2, -0x1

    goto :goto_44

    :cond_b2
    iget-boolean p1, p0, Lorg/mapsforge/map/layer/TileLayer;->hasJobQueue:Z

    if-eqz p1, :cond_bb

    iget-object p1, p0, Lorg/mapsforge/map/layer/TileLayer;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/queue/JobQueue;->notifyWorkers()V

    :cond_bb
    return-void
.end method

.method public getAlpha()F
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/layer/TileLayer;->alpha:F

    return v0
.end method

.method public getTileCache()Lorg/mapsforge/map/layer/cache/TileCache;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/TileLayer;->tileCache:Lorg/mapsforge/map/layer/cache/TileCache;

    return-object v0
.end method

.method protected abstract isTileStale(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/graphics/TileBitmap;)Z
.end method

.method protected retrieveLabelsOnly(Lorg/mapsforge/map/layer/queue/Job;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    return-void
.end method

.method public setAlpha(F)V
    .registers 3

    const/high16 v0, 0x3f800000    # 1.0f

    invoke-static {v0, p1}, Ljava/lang/Math;->min(FF)F

    move-result p1

    const/4 v0, 0x0

    invoke-static {v0, p1}, Ljava/lang/Math;->max(FF)F

    move-result p1

    iput p1, p0, Lorg/mapsforge/map/layer/TileLayer;->alpha:F

    return-void
.end method

.method public declared-synchronized setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 4

    monitor-enter p0

    :try_start_1
    invoke-super {p0, p1}, Lorg/mapsforge/map/layer/Layer;->setDisplayModel(Lorg/mapsforge/map/model/DisplayModel;)V

    if-eqz p1, :cond_16

    iget-boolean p1, p0, Lorg/mapsforge/map/layer/TileLayer;->hasJobQueue:Z

    if-eqz p1, :cond_16

    new-instance p1, Lorg/mapsforge/map/layer/queue/JobQueue;

    iget-object v0, p0, Lorg/mapsforge/map/layer/TileLayer;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    iget-object v1, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-direct {p1, v0, v1}, Lorg/mapsforge/map/layer/queue/JobQueue;-><init>(Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/model/DisplayModel;)V

    iput-object p1, p0, Lorg/mapsforge/map/layer/TileLayer;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;

    goto :goto_19

    :cond_16
    const/4 p1, 0x0

    iput-object p1, p0, Lorg/mapsforge/map/layer/TileLayer;->jobQueue:Lorg/mapsforge/map/layer/queue/JobQueue;
    :try_end_19
    .catchall {:try_start_1 .. :try_end_19} :catchall_1b

    :goto_19
    monitor-exit p0

    return-void

    :catchall_1b
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public setParentTilesRendering(Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/TileLayer;->parentTilesRendering:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    return-void
.end method
