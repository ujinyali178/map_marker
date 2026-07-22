.class public Lorg/mapsforge/map/layer/renderer/StandardRenderer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/rendertheme/RenderCallback;


# static fields
.field private static final DEFAULT_START_ZOOM_LEVEL:Ljava/lang/Byte;

.field private static final TAG_NATURAL_WATER:Lorg/mapsforge/core/model/Tag;

.field private static final ZOOM_MAX:B = 0x16t


# instance fields
.field public final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field public final hillsRenderConfig:Lorg/mapsforge/map/layer/hills/HillsRenderConfig;

.field public final mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

.field private final renderLabels:Z


# direct methods
.method static constructor <clinit>()V
    .registers 3

    const/16 v0, 0xc

    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->DEFAULT_START_ZOOM_LEVEL:Ljava/lang/Byte;

    new-instance v0, Lorg/mapsforge/core/model/Tag;

    const-string v1, "natural"

    const-string v2, "water"

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/core/model/Tag;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->TAG_NATURAL_WATER:Lorg/mapsforge/core/model/Tag;

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/core/graphics/GraphicFactory;Z)V
    .registers 5

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lorg/mapsforge/map/layer/renderer/StandardRenderer;-><init>(Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/core/graphics/GraphicFactory;ZLorg/mapsforge/map/layer/hills/HillsRenderConfig;)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/core/graphics/GraphicFactory;ZLorg/mapsforge/map/layer/hills/HillsRenderConfig;)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    iput-object p2, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iput-boolean p3, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->renderLabels:Z

    iput-object p4, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->hillsRenderConfig:Lorg/mapsforge/map/layer/hills/HillsRenderConfig;

    return-void
.end method

.method private static getTilePixelCoordinates(I)[Lorg/mapsforge/core/model/Point;
    .registers 8

    const/4 v0, 0x5

    new-array v0, v0, [Lorg/mapsforge/core/model/Point;

    new-instance v1, Lorg/mapsforge/core/model/Point;

    const-wide/16 v2, 0x0

    invoke-direct {v1, v2, v3, v2, v3}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    const/4 v4, 0x0

    aput-object v1, v0, v4

    new-instance v1, Lorg/mapsforge/core/model/Point;

    int-to-double v5, p0

    invoke-direct {v1, v5, v6, v2, v3}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    const/4 p0, 0x1

    aput-object v1, v0, p0

    new-instance p0, Lorg/mapsforge/core/model/Point;

    invoke-direct {p0, v5, v6, v5, v6}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    const/4 v1, 0x2

    aput-object p0, v0, v1

    new-instance p0, Lorg/mapsforge/core/model/Point;

    invoke-direct {p0, v2, v3, v5, v6}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    const/4 v1, 0x3

    aput-object p0, v0, v1

    aget-object p0, v0, v4

    const/4 v1, 0x4

    aput-object p0, v0, v1

    return-object v0
.end method


# virtual methods
.method public getStartPosition()Lorg/mapsforge/core/model/LatLong;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    if-eqz v0, :cond_9

    invoke-virtual {v0}, Lorg/mapsforge/map/datastore/MapDataStore;->startPosition()Lorg/mapsforge/core/model/LatLong;

    move-result-object v0

    return-object v0

    :cond_9
    const/4 v0, 0x0

    return-object v0
.end method

.method public getStartZoomLevel()Ljava/lang/Byte;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    if-eqz v0, :cond_11

    invoke-virtual {v0}, Lorg/mapsforge/map/datastore/MapDataStore;->startZoomLevel()Ljava/lang/Byte;

    move-result-object v0

    if-eqz v0, :cond_11

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v0}, Lorg/mapsforge/map/datastore/MapDataStore;->startZoomLevel()Ljava/lang/Byte;

    move-result-object v0

    return-object v0

    :cond_11
    sget-object v0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->DEFAULT_START_ZOOM_LEVEL:Ljava/lang/Byte;

    return-object v0
.end method

.method public getZoomLevelMax()B
    .registers 2

    const/16 v0, 0x16

    return v0
.end method

.method protected processReadMapData(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/MapReadResult;)V
    .registers 7

    if-nez p2, :cond_3

    return-void

    :cond_3
    iget-object v0, p2, Lorg/mapsforge/map/datastore/MapReadResult;->pointOfInterests:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_9
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_19

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/datastore/PointOfInterest;

    invoke-virtual {p0, p1, v1}, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->renderPointOfInterest(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/PointOfInterest;)V

    goto :goto_9

    :cond_19
    iget-object v0, p2, Lorg/mapsforge/map/datastore/MapReadResult;->ways:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1f
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_38

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/datastore/Way;

    new-instance v2, Lorg/mapsforge/map/layer/renderer/PolylineContainer;

    iget-object v3, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v3, v3, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-direct {v2, v1, v3, v3}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;-><init>(Lorg/mapsforge/map/datastore/Way;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)V

    invoke-virtual {p0, p1, v2}, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->renderWay(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    goto :goto_1f

    :cond_38
    iget-boolean p2, p2, Lorg/mapsforge/map/datastore/MapReadResult;->isWater:Z

    if-eqz p2, :cond_3f

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->renderWaterBackground(Lorg/mapsforge/map/rendertheme/RenderContext;)V

    :cond_3f
    return-void
.end method

.method public renderArea(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;ILorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 7

    new-instance v0, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;

    invoke-direct {v0, p5, p3}, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;-><init>(Lorg/mapsforge/map/layer/renderer/ShapeContainer;Lorg/mapsforge/core/graphics/Paint;)V

    invoke-virtual {p1, p4, v0}, Lorg/mapsforge/map/rendertheme/RenderContext;->addToCurrentDrawingLayer(ILorg/mapsforge/map/layer/renderer/ShapePaintContainer;)V

    new-instance p3, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;

    invoke-direct {p3, p5, p2}, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;-><init>(Lorg/mapsforge/map/layer/renderer/ShapeContainer;Lorg/mapsforge/core/graphics/Paint;)V

    invoke-virtual {p1, p4, p3}, Lorg/mapsforge/map/rendertheme/RenderContext;->addToCurrentDrawingLayer(ILorg/mapsforge/map/layer/renderer/ShapePaintContainer;)V

    return-void
.end method

.method public renderAreaCaption(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;FFLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Position;ILorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 28

    move-object/from16 v0, p0

    iget-boolean v1, v0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->renderLabels:Z

    if-eqz v1, :cond_30

    invoke-virtual/range {p11 .. p11}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getCenterAbsolute()Lorg/mapsforge/core/model/Point;

    move-result-object v1

    move/from16 v2, p5

    float-to-double v2, v2

    move/from16 v4, p6

    float-to-double v4, v4

    invoke-virtual {v1, v2, v3, v4, v5}, Lorg/mapsforge/core/model/Point;->offset(DD)Lorg/mapsforge/core/model/Point;

    move-result-object v7

    move-object/from16 v1, p1

    iget-object v1, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;

    iget-object v6, v0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    const/4 v13, 0x0

    move-object/from16 v8, p2

    move/from16 v9, p3

    move-object/from16 v10, p4

    move-object/from16 v11, p7

    move-object/from16 v12, p8

    move-object/from16 v14, p9

    move/from16 v15, p10

    invoke-interface/range {v6 .. v15}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPointTextContainer(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/mapelements/SymbolContainer;Lorg/mapsforge/core/graphics/Position;I)Lorg/mapsforge/core/mapelements/PointTextContainer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_30
    return-void
.end method

.method public renderAreaSymbol(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Display;ILorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 7

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->renderLabels:Z

    if-eqz v0, :cond_12

    invoke-virtual {p5}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getCenterAbsolute()Lorg/mapsforge/core/model/Point;

    move-result-object p5

    iget-object p1, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;

    new-instance v0, Lorg/mapsforge/core/mapelements/SymbolContainer;

    invoke-direct {v0, p5, p2, p3, p4}, Lorg/mapsforge/core/mapelements/SymbolContainer;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILorg/mapsforge/core/graphics/Bitmap;)V

    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_12
    return-void
.end method

.method renderBitmap(Lorg/mapsforge/map/rendertheme/RenderContext;)Z
    .registers 3

    iget-object v0, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v0}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->hasMapBackgroundOutside()Z

    move-result v0

    if-eqz v0, :cond_17

    iget-object v0, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    iget-object p1, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object p1, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/datastore/MapDataStore;->supportsTile(Lorg/mapsforge/core/model/Tile;)Z

    move-result p1

    if-eqz p1, :cond_15

    goto :goto_17

    :cond_15
    const/4 p1, 0x0

    goto :goto_18

    :cond_17
    :goto_17
    const/4 p1, 0x1

    :goto_18
    return p1
.end method

.method protected renderPointOfInterest(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/PointOfInterest;)V
    .registers 4

    iget-byte v0, p2, Lorg/mapsforge/map/datastore/PointOfInterest;->layer:B

    invoke-virtual {p1, v0}, Lorg/mapsforge/map/rendertheme/RenderContext;->setDrawingLayers(B)V

    iget-object v0, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v0, p0, p1, p2}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->matchNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/PointOfInterest;)V

    return-void
.end method

.method public renderPointOfInterestCaption(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;FFLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Position;ILorg/mapsforge/map/datastore/PointOfInterest;)V
    .registers 25

    move-object v0, p0

    move-object v1, p1

    iget-boolean v2, v0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->renderLabels:Z

    if-eqz v2, :cond_37

    move-object/from16 v2, p11

    iget-object v2, v2, Lorg/mapsforge/map/datastore/PointOfInterest;->position:Lorg/mapsforge/core/model/LatLong;

    iget-object v3, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v3, v3, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-wide v3, v3, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-static {v2, v3, v4}, Lorg/mapsforge/core/util/MercatorProjection;->getPixelAbsolute(Lorg/mapsforge/core/model/LatLong;J)Lorg/mapsforge/core/model/Point;

    move-result-object v2

    iget-object v1, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;

    iget-object v3, v0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    move/from16 v4, p5

    float-to-double v4, v4

    move/from16 v6, p6

    float-to-double v6, v6

    invoke-virtual {v2, v4, v5, v6, v7}, Lorg/mapsforge/core/model/Point;->offset(DD)Lorg/mapsforge/core/model/Point;

    move-result-object v4

    const/4 v10, 0x0

    move-object v5, p2

    move/from16 v6, p3

    move-object/from16 v7, p4

    move-object/from16 v8, p7

    move-object/from16 v9, p8

    move-object/from16 v11, p9

    move/from16 v12, p10

    invoke-interface/range {v3 .. v12}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPointTextContainer(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/mapelements/SymbolContainer;Lorg/mapsforge/core/graphics/Position;I)Lorg/mapsforge/core/mapelements/PointTextContainer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_37
    return-void
.end method

.method public renderPointOfInterestCircle(Lorg/mapsforge/map/rendertheme/RenderContext;FLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;ILorg/mapsforge/map/datastore/PointOfInterest;)V
    .registers 9

    iget-object p6, p6, Lorg/mapsforge/map/datastore/PointOfInterest;->position:Lorg/mapsforge/core/model/LatLong;

    iget-object v0, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v0, v0, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-static {p6, v0}, Lorg/mapsforge/core/util/MercatorProjection;->getPixelRelativeToTile(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/core/model/Point;

    move-result-object p6

    new-instance v0, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;

    new-instance v1, Lorg/mapsforge/map/layer/renderer/CircleContainer;

    invoke-direct {v1, p6, p2}, Lorg/mapsforge/map/layer/renderer/CircleContainer;-><init>(Lorg/mapsforge/core/model/Point;F)V

    invoke-direct {v0, v1, p4}, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;-><init>(Lorg/mapsforge/map/layer/renderer/ShapeContainer;Lorg/mapsforge/core/graphics/Paint;)V

    invoke-virtual {p1, p5, v0}, Lorg/mapsforge/map/rendertheme/RenderContext;->addToCurrentDrawingLayer(ILorg/mapsforge/map/layer/renderer/ShapePaintContainer;)V

    new-instance p4, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;

    new-instance v0, Lorg/mapsforge/map/layer/renderer/CircleContainer;

    invoke-direct {v0, p6, p2}, Lorg/mapsforge/map/layer/renderer/CircleContainer;-><init>(Lorg/mapsforge/core/model/Point;F)V

    invoke-direct {p4, v0, p3}, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;-><init>(Lorg/mapsforge/map/layer/renderer/ShapeContainer;Lorg/mapsforge/core/graphics/Paint;)V

    invoke-virtual {p1, p5, p4}, Lorg/mapsforge/map/rendertheme/RenderContext;->addToCurrentDrawingLayer(ILorg/mapsforge/map/layer/renderer/ShapePaintContainer;)V

    return-void
.end method

.method public renderPointOfInterestSymbol(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Display;ILorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/map/datastore/PointOfInterest;)V
    .registers 8

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->renderLabels:Z

    if-eqz v0, :cond_1a

    iget-object p5, p5, Lorg/mapsforge/map/datastore/PointOfInterest;->position:Lorg/mapsforge/core/model/LatLong;

    iget-object v0, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v0, v0, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-wide v0, v0, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-static {p5, v0, v1}, Lorg/mapsforge/core/util/MercatorProjection;->getPixelAbsolute(Lorg/mapsforge/core/model/LatLong;J)Lorg/mapsforge/core/model/Point;

    move-result-object p5

    iget-object p1, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;

    new-instance v0, Lorg/mapsforge/core/mapelements/SymbolContainer;

    invoke-direct {v0, p5, p2, p3, p4}, Lorg/mapsforge/core/mapelements/SymbolContainer;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILorg/mapsforge/core/graphics/Bitmap;)V

    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_1a
    return-void
.end method

.method protected renderWaterBackground(Lorg/mapsforge/map/rendertheme/RenderContext;)V
    .registers 10

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lorg/mapsforge/map/rendertheme/RenderContext;->setDrawingLayers(B)V

    iget-object v1, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget v1, v1, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-static {v1}, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->getTilePixelCoordinates(I)[Lorg/mapsforge/core/model/Point;

    move-result-object v1

    iget-object v2, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v2, v2, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    invoke-virtual {v2}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v2

    :goto_16
    array-length v3, v1

    if-ge v0, v3, :cond_28

    aget-object v3, v1, v0

    iget-wide v4, v2, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v6, v2, Lorg/mapsforge/core/model/Point;->y:D

    invoke-virtual {v3, v4, v5, v6, v7}, Lorg/mapsforge/core/model/Point;->offset(DD)Lorg/mapsforge/core/model/Point;

    move-result-object v3

    aput-object v3, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_16

    :cond_28
    new-instance v0, Lorg/mapsforge/map/layer/renderer/PolylineContainer;

    iget-object v2, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v2, v2, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    sget-object v3, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->TAG_NATURAL_WATER:Lorg/mapsforge/core/model/Tag;

    invoke-static {v3}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-direct {v0, v1, v2, v2, v3}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;-><init>([Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Ljava/util/List;)V

    iget-object v1, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v1, p0, p1, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->matchClosedWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    return-void
.end method

.method public renderWay(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Paint;FILorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 7

    new-instance v0, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;

    invoke-direct {v0, p5, p2, p3}, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;-><init>(Lorg/mapsforge/map/layer/renderer/ShapeContainer;Lorg/mapsforge/core/graphics/Paint;F)V

    invoke-virtual {p1, p4, v0}, Lorg/mapsforge/map/rendertheme/RenderContext;->addToCurrentDrawingLayer(ILorg/mapsforge/map/layer/renderer/ShapePaintContainer;)V

    return-void
.end method

.method protected renderWay(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 4

    invoke-virtual {p2}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getLayer()B

    move-result v0

    invoke-virtual {p1, v0}, Lorg/mapsforge/map/rendertheme/RenderContext;->setDrawingLayers(B)V

    invoke-virtual {p2}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->isClosedWay()Z

    move-result v0

    if-eqz v0, :cond_13

    iget-object v0, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v0, p0, p1, p2}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->matchClosedWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    goto :goto_18

    :cond_13
    iget-object v0, p1, Lorg/mapsforge/map/rendertheme/RenderContext;->renderTheme:Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    invoke-virtual {v0, p0, p1, p2}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->matchLinearWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    :goto_18
    return-void
.end method

.method public renderWaySymbol(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Display;ILorg/mapsforge/core/graphics/Bitmap;FZZFFZLorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 25

    move-object v0, p0

    iget-boolean v1, v0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->renderLabels:Z

    if-eqz v1, :cond_20

    invoke-virtual/range {p11 .. p11}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getCoordinatesAbsolute()[[Lorg/mapsforge/core/model/Point;

    move-result-object v11

    move-object v1, p1

    iget-object v12, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;

    move-object/from16 v2, p4

    move-object v3, p2

    move/from16 v4, p3

    move/from16 v5, p5

    move/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    move/from16 v9, p9

    move/from16 v10, p10

    invoke-static/range {v2 .. v12}, Lorg/mapsforge/map/layer/renderer/WayDecorator;->renderSymbol(Lorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/core/graphics/Display;IFZZFFZ[[Lorg/mapsforge/core/model/Point;Ljava/util/List;)V

    :cond_20
    return-void
.end method

.method public renderWayText(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;FLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;ZFFZLorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 30

    move-object/from16 v0, p0

    iget-boolean v1, v0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->renderLabels:Z

    if-eqz v1, :cond_31

    iget-object v2, v0, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-virtual/range {p12 .. p12}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getUpperLeft()Lorg/mapsforge/core/model/Tile;

    move-result-object v3

    invoke-virtual/range {p12 .. p12}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getLowerRight()Lorg/mapsforge/core/model/Tile;

    move-result-object v4

    invoke-virtual/range {p12 .. p12}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getCoordinatesAbsolute()[[Lorg/mapsforge/core/model/Point;

    move-result-object v15

    move-object/from16 v1, p1

    iget-object v1, v1, Lorg/mapsforge/map/rendertheme/RenderContext;->labels:Ljava/util/List;

    move-object/from16 v5, p4

    move-object/from16 v6, p2

    move/from16 v7, p3

    move/from16 v8, p5

    move-object/from16 v9, p6

    move-object/from16 v10, p7

    move/from16 v11, p8

    move/from16 v12, p9

    move/from16 v13, p10

    move/from16 v14, p11

    move-object/from16 v16, v1

    invoke-static/range {v2 .. v16}, Lorg/mapsforge/map/layer/renderer/WayDecorator;->renderText(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Ljava/lang/String;Lorg/mapsforge/core/graphics/Display;IFLorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;ZFFZ[[Lorg/mapsforge/core/model/Point;Ljava/util/List;)V

    :cond_31
    return-void
.end method
