.class public Lorg/mapsforge/map/rendertheme/RenderContext;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final LAYERS:B = 0xbt

.field private static final STROKE_INCREASE:D = 1.5

.field private static final STROKE_MIN_ZOOM_LEVEL:B = 0xct


# instance fields
.field public final canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

.field private drawingLayers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;",
            ">;>;"
        }
    .end annotation
.end field

.field public final labels:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/core/mapelements/MapElementContainer;",
            ">;"
        }
    .end annotation
.end field

.field public final renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

.field public final rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

.field public final ways:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/util/List<",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;",
            ">;>;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/layer/renderer/RendererJob;Lorg/mapsforge/map/layer/renderer/CanvasRasterer;)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;

    iput-object p2, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    iget-object p2, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    invoke-virtual {p2}, Ljava/util/concurrent/FutureTask;->get()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    iput-object p2, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    iget v0, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->textScale:F

    iget-object v1, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v1, v1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-virtual {p2, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->scaleTextSize(FB)V

    invoke-direct {p0}, Lorg/mapsforge/map/rendertheme/RenderContext;->createWayLists()Ljava/util/List;

    move-result-object p2

    iput-object p2, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->ways:Ljava/util/List;

    iget-object p1, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte p1, p1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {p0, p1}, Lorg/mapsforge/map/rendertheme/RenderContext;->setScaleStrokeWidth(B)V

    return-void
.end method

.method private createWayLists()Ljava/util/List;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/util/List<",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;",
            ">;>;>;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    const/16 v1, 0xb

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v1}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->getLevels()I

    move-result v1

    const/16 v2, 0xa

    :goto_f
    if-ltz v2, :cond_2d

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3, v1}, Ljava/util/ArrayList;-><init>(I)V

    add-int/lit8 v4, v1, -0x1

    :goto_18
    if-ltz v4, :cond_26

    new-instance v5, Ljava/util/ArrayList;

    const/4 v6, 0x0

    invoke-direct {v5, v6}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {v3, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v4, v4, -0x1

    goto :goto_18

    :cond_26
    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, -0x1

    int-to-byte v2, v2

    goto :goto_f

    :cond_2d
    return-object v0
.end method

.method private setScaleStrokeWidth(B)V
    .registers 7

    add-int/lit8 p1, p1, -0xc

    const/4 v0, 0x0

    invoke-static {p1, v0}, Ljava/lang/Math;->max(II)I

    move-result p1

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    int-to-double v1, p1

    const-wide/high16 v3, 0x3ff8000000000000L    # 1.5

    invoke-static {v3, v4, v1, v2}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v1

    double-to-float p1, v1

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v1, v1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-virtual {v0, p1, v1}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->scaleStrokeWidth(FB)V

    return-void
.end method


# virtual methods
.method public addToCurrentDrawingLayer(ILorg/mapsforge/map/layer/renderer/ShapePaintContainer;)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->drawingLayers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/List;

    invoke-interface {p1, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public destroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->canvasRasterer:Lorg/mapsforge/map/layer/renderer/CanvasRasterer;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/renderer/CanvasRasterer;->destroy()V

    return-void
.end method

.method public otherTile(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/renderer/RendererJob;
    .registers 11

    new-instance v8, Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v2, v0, Lorg/mapsforge/map/layer/renderer/RendererJob;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    iget-object v3, v0, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    iget-object v4, v0, Lorg/mapsforge/map/layer/renderer/RendererJob;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget v5, v0, Lorg/mapsforge/map/layer/renderer/RendererJob;->textScale:F

    iget-boolean v6, v0, Lorg/mapsforge/map/layer/queue/Job;->hasAlpha:Z

    iget-boolean v7, v0, Lorg/mapsforge/map/layer/renderer/RendererJob;->labelsOnly:Z

    move-object v0, v8

    move-object v1, p1

    invoke-direct/range {v0 .. v7}, Lorg/mapsforge/map/layer/renderer/RendererJob;-><init>(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;Lorg/mapsforge/map/model/DisplayModel;FZZ)V

    return-object v8
.end method

.method public setDrawingLayers(B)V
    .registers 3

    if-gez p1, :cond_4

    const/4 p1, 0x0

    goto :goto_a

    :cond_4
    const/16 v0, 0xb

    if-lt p1, v0, :cond_a

    const/16 p1, 0xa

    :cond_a
    :goto_a
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->ways:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/List;

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/RenderContext;->drawingLayers:Ljava/util/List;

    return-void
.end method
