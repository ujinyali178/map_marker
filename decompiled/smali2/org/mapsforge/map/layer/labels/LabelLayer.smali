.class public Lorg/mapsforge/map/layer/labels/LabelLayer;
.super Lorg/mapsforge/map/layer/Layer;
.source "SourceFile"


# instance fields
.field protected elementsToDraw:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/core/mapelements/MapElementContainer;",
            ">;"
        }
    .end annotation
.end field

.field protected final labelStore:Lorg/mapsforge/map/layer/labels/LabelStore;

.field protected lastLabelStoreVersion:I

.field protected lowerRight:Lorg/mapsforge/core/model/Tile;

.field protected final matrix:Lorg/mapsforge/core/graphics/Matrix;

.field protected upperLeft:Lorg/mapsforge/core/model/Tile;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/layer/labels/LabelStore;)V
    .registers 3

    invoke-direct {p0}, Lorg/mapsforge/map/layer/Layer;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->labelStore:Lorg/mapsforge/map/layer/labels/LabelStore;

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createMatrix()Lorg/mapsforge/core/graphics/Matrix;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    const/4 p1, -0x1

    iput p1, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->lastLabelStoreVersion:I

    return-void
.end method


# virtual methods
.method protected draw(Lorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->elementsToDraw:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1e

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/core/mapelements/MapElementContainer;

    iget-object v2, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->matrix:Lorg/mapsforge/core/graphics/Matrix;

    iget-object v3, p0, Lorg/mapsforge/map/layer/Layer;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v3}, Lorg/mapsforge/map/model/DisplayModel;->getFilter()Lorg/mapsforge/core/graphics/Filter;

    move-result-object v3

    invoke-virtual {v1, p1, p2, v2, v3}, Lorg/mapsforge/core/mapelements/MapElementContainer;->draw(Lorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Matrix;Lorg/mapsforge/core/graphics/Filter;)V

    goto :goto_6

    :cond_1e
    return-void
.end method

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

    if-eq p2, v1, :cond_4d

    :cond_2e
    iput-object v0, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->upperLeft:Lorg/mapsforge/core/model/Tile;

    iput-object p1, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->lowerRight:Lorg/mapsforge/core/model/Tile;

    iget-object p1, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->labelStore:Lorg/mapsforge/map/layer/labels/LabelStore;

    invoke-interface {p1}, Lorg/mapsforge/map/layer/labels/LabelStore;->getVersion()I

    move-result p1

    iput p1, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->lastLabelStoreVersion:I

    iget-object p1, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->labelStore:Lorg/mapsforge/map/layer/labels/LabelStore;

    iget-object p2, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->upperLeft:Lorg/mapsforge/core/model/Tile;

    iget-object v0, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->lowerRight:Lorg/mapsforge/core/model/Tile;

    invoke-interface {p1, p2, v0}, Lorg/mapsforge/map/layer/labels/LabelStore;->getVisibleItems(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Ljava/util/List;

    move-result-object p1

    invoke-static {p1}, Lorg/mapsforge/map/util/LayerUtil;->collisionFreeOrdered(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/layer/labels/LabelLayer;->elementsToDraw:Ljava/util/List;

    invoke-static {p1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    :cond_4d
    invoke-virtual {p0, p3, p4}, Lorg/mapsforge/map/layer/labels/LabelLayer;->draw(Lorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;)V

    return-void
.end method
