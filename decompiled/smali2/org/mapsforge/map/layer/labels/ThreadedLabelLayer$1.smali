.class Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;->getData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;

.field final synthetic val$lowerRight:Lorg/mapsforge/core/model/Tile;

.field final synthetic val$upperLeft:Lorg/mapsforge/core/model/Tile;


# direct methods
.method constructor <init>(Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)V
    .registers 4

    iput-object p1, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;->this$0:Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;

    iput-object p2, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;->val$upperLeft:Lorg/mapsforge/core/model/Tile;

    iput-object p3, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;->val$lowerRight:Lorg/mapsforge/core/model/Tile;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;->this$0:Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;

    iget-object v0, v0, Lorg/mapsforge/map/layer/labels/LabelLayer;->labelStore:Lorg/mapsforge/map/layer/labels/LabelStore;

    iget-object v1, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;->val$upperLeft:Lorg/mapsforge/core/model/Tile;

    iget-object v2, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;->val$lowerRight:Lorg/mapsforge/core/model/Tile;

    invoke-interface {v0, v1, v2}, Lorg/mapsforge/map/layer/labels/LabelStore;->getVisibleItems(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;->this$0:Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;

    invoke-static {v0}, Lorg/mapsforge/map/util/LayerUtil;->collisionFreeOrdered(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, v1, Lorg/mapsforge/map/layer/labels/LabelLayer;->elementsToDraw:Ljava/util/List;

    iget-object v0, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;->this$0:Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;

    iget-object v0, v0, Lorg/mapsforge/map/layer/labels/LabelLayer;->elementsToDraw:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    iget-object v0, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;->this$0:Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;

    iget-object v1, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;->val$upperLeft:Lorg/mapsforge/core/model/Tile;

    iput-object v1, v0, Lorg/mapsforge/map/layer/labels/LabelLayer;->upperLeft:Lorg/mapsforge/core/model/Tile;

    iget-object v1, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;->val$lowerRight:Lorg/mapsforge/core/model/Tile;

    iput-object v1, v0, Lorg/mapsforge/map/layer/labels/LabelLayer;->lowerRight:Lorg/mapsforge/core/model/Tile;

    iget-object v1, v0, Lorg/mapsforge/map/layer/labels/LabelLayer;->labelStore:Lorg/mapsforge/map/layer/labels/LabelStore;

    invoke-interface {v1}, Lorg/mapsforge/map/layer/labels/LabelStore;->getVersion()I

    move-result v1

    iput v1, v0, Lorg/mapsforge/map/layer/labels/LabelLayer;->lastLabelStoreVersion:I

    iget-object v0, p0, Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer$1;->this$0:Lorg/mapsforge/map/layer/labels/ThreadedLabelLayer;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/Layer;->requestRedraw()V

    return-void
.end method
