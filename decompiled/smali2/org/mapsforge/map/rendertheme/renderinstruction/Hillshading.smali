.class public Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;


# instance fields
.field private always:Z

.field private final layer:B

.field private final level:I

.field private final magnitude:F

.field private final maxZoom:B

.field private final minZoom:B


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method public constructor <init>(BBSBZILorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 8

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean p5, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->always:Z

    iput p6, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->level:I

    iput-byte p4, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->layer:B

    iput-byte p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->minZoom:B

    iput-byte p2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->maxZoom:B

    int-to-float p1, p3

    iput p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->magnitude:F

    return-void
.end method


# virtual methods
.method public render(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/hills/HillsRenderConfig;)V
    .registers 64

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    const/4 v3, 0x0

    if-nez p2, :cond_22

    iget-boolean v0, v1, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->always:Z

    if-eqz v0, :cond_21

    iget-byte v0, v1, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->layer:B

    invoke-virtual {v2, v0}, Lorg/mapsforge/map/rendertheme/RenderContext;->setDrawingLayers(B)V

    new-instance v0, Lorg/mapsforge/map/layer/renderer/HillshadingContainer;

    iget v4, v1, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->magnitude:F

    invoke-direct {v0, v3, v4, v3, v3}, Lorg/mapsforge/map/layer/renderer/HillshadingContainer;-><init>(Lorg/mapsforge/core/graphics/HillshadingBitmap;FLorg/mapsforge/core/model/Rectangle;Lorg/mapsforge/core/model/Rectangle;)V

    iget v4, v1, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->level:I

    new-instance v5, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;

    invoke-direct {v5, v0, v3}, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;-><init>(Lorg/mapsforge/map/layer/renderer/ShapeContainer;Lorg/mapsforge/core/graphics/Paint;)V

    invoke-virtual {v2, v4, v5}, Lorg/mapsforge/map/rendertheme/RenderContext;->addToCurrentDrawingLayer(ILorg/mapsforge/map/layer/renderer/ShapePaintContainer;)V

    :cond_21
    return-void

    :cond_22
    const/4 v0, 0x0

    iget v4, v1, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->magnitude:F

    invoke-virtual/range {p2 .. p2}, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->getMaginuteScaleFactor()F

    move-result v5

    mul-float v4, v4, v5

    invoke-static {v0, v4}, Ljava/lang/Math;->max(FF)F

    move-result v0

    const/high16 v4, 0x437f0000    # 255.0f

    invoke-static {v0, v4}, Ljava/lang/Math;->min(FF)F

    move-result v0

    div-float v11, v0, v4

    iget-object v0, v2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v12, v0, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v0, v12, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget-byte v4, v1, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->maxZoom:B

    if-gt v0, v4, :cond_207

    iget-byte v4, v1, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->minZoom:B

    if-ge v0, v4, :cond_47

    goto/16 :goto_207

    :cond_47
    invoke-virtual {v12}, Lorg/mapsforge/core/model/Tile;->getOrigin()Lorg/mapsforge/core/model/Point;

    move-result-object v13

    iget-wide v4, v13, Lorg/mapsforge/core/model/Point;->y:D

    double-to-long v4, v4

    long-to-double v4, v4

    iget-wide v6, v12, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-static {v4, v5, v6, v7}, Lorg/mapsforge/core/util/MercatorProjection;->pixelYToLatitude(DJ)D

    move-result-wide v14

    iget-wide v4, v13, Lorg/mapsforge/core/model/Point;->x:D

    double-to-long v4, v4

    long-to-double v4, v4

    iget-wide v6, v12, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-static {v4, v5, v6, v7}, Lorg/mapsforge/core/util/MercatorProjection;->pixelXToLongitude(DJ)D

    move-result-wide v16

    iget-wide v4, v13, Lorg/mapsforge/core/model/Point;->y:D

    double-to-long v4, v4

    iget v0, v12, Lorg/mapsforge/core/model/Tile;->tileSize:I

    int-to-long v6, v0

    add-long/2addr v4, v6

    long-to-double v4, v4

    iget-wide v6, v12, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-static {v4, v5, v6, v7}, Lorg/mapsforge/core/util/MercatorProjection;->pixelYToLatitude(DJ)D

    move-result-wide v18

    iget-wide v4, v13, Lorg/mapsforge/core/model/Point;->x:D

    double-to-long v4, v4

    iget v0, v12, Lorg/mapsforge/core/model/Tile;->tileSize:I

    int-to-long v6, v0

    add-long/2addr v4, v6

    long-to-double v4, v4

    iget-wide v6, v12, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-static {v4, v5, v6, v7}, Lorg/mapsforge/core/util/MercatorProjection;->pixelXToLongitude(DJ)D

    move-result-wide v4

    sub-double v6, v14, v18

    sub-double v8, v4, v16

    iget v0, v12, Lorg/mapsforge/core/model/Tile;->tileSize:I

    move-wide/from16 v20, v4

    int-to-double v3, v0

    div-double v22, v3, v6

    int-to-double v3, v0

    div-double v24, v3, v8

    cmpg-double v0, v20, v16

    if-gez v0, :cond_94

    iget-wide v3, v12, Lorg/mapsforge/core/model/Tile;->mapSize:J

    long-to-double v3, v3

    add-double v4, v20, v3

    move-wide/from16 v20, v4

    :cond_94
    invoke-static/range {v16 .. v17}, Ljava/lang/Math;->floor(D)D

    move-result-wide v3

    double-to-int v0, v3

    move v3, v0

    :goto_9a
    int-to-double v9, v3

    cmpg-double v0, v9, v20

    if-gtz v0, :cond_207

    invoke-static/range {v18 .. v19}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    double-to-int v0, v4

    move v5, v0

    :goto_a5
    int-to-double v7, v5

    cmpg-double v0, v7, v14

    if-gtz v0, :cond_1fd

    add-int/lit8 v6, v3, 0x1

    add-int/lit8 v4, v5, 0x1

    move v2, v4

    move-object/from16 v4, p2

    move/from16 v26, v11

    move v11, v6

    move v6, v3

    move-wide/from16 v27, v7

    move-wide/from16 v7, v22

    move-wide/from16 v29, v9

    move-wide/from16 v9, v24

    :try_start_bd
    invoke-virtual/range {v4 .. v10}, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->getShadingTile(IIDD)Lorg/mapsforge/core/graphics/HillshadingBitmap;

    move-result-object v0
    :try_end_c1
    .catch Ljava/lang/Exception; {:try_start_bd .. :try_end_c1} :catch_c2

    goto :goto_d0

    :catch_c2
    move-exception v0

    move-object v4, v0

    sget-object v0, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->LOGGER:Ljava/util/logging/Logger;

    sget-object v5, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    invoke-virtual {v4}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6, v4}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 v0, 0x0

    :goto_d0
    if-nez v0, :cond_e2

    iget-boolean v4, v1, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->always:Z

    if-nez v4, :cond_e2

    move v5, v2

    move/from16 v38, v3

    move-wide/from16 v27, v14

    move/from16 v4, v26

    const/4 v7, 0x0

    move-object/from16 v2, p1

    goto/16 :goto_1f4

    :cond_e2
    if-eqz v0, :cond_f5

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/HillshadingBitmap;->getPadding()I

    move-result v5

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result v6

    mul-int/lit8 v7, v5, 0x2

    sub-int/2addr v6, v7

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result v8

    sub-int/2addr v8, v7

    goto :goto_f8

    :cond_f5
    const/4 v5, 0x0

    const/4 v6, 0x1

    const/4 v8, 0x1

    :goto_f8
    int-to-double v9, v5

    move/from16 v31, v5

    int-to-double v4, v6

    add-double v32, v9, v4

    move-object/from16 v34, v0

    int-to-double v0, v8

    add-double v35, v9, v0

    iget v7, v12, Lorg/mapsforge/core/model/Tile;->tileSize:I

    move/from16 v38, v3

    move-wide/from16 v39, v4

    int-to-double v3, v7

    move-wide/from16 v41, v3

    int-to-double v3, v7

    move-wide/from16 v43, v3

    int-to-double v3, v2

    const-wide/16 v45, 0x0

    cmpl-double v5, v3, v14

    if-lez v5, :cond_123

    sub-double/2addr v3, v14

    move/from16 v37, v6

    const/4 v5, 0x1

    const/4 v5, 0x1

    int-to-double v6, v5

    div-double/2addr v3, v6

    mul-double v3, v3, v0

    add-double/2addr v3, v9

    move-wide/from16 v50, v3

    goto :goto_13a

    :cond_123
    move/from16 v37, v6

    cmpl-double v6, v14, v3

    if-lez v6, :cond_138

    div-double v6, v45, v0

    add-double/2addr v3, v6

    iget-wide v6, v12, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-static {v3, v4, v6, v7}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v3

    iget-wide v6, v13, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v3, v6

    move-wide/from16 v50, v9

    goto :goto_13c

    :cond_138
    move-wide/from16 v50, v9

    :goto_13a
    move-wide/from16 v3, v45

    :goto_13c
    cmpg-double v6, v27, v18

    if-gez v6, :cond_151

    add-int v6, v31, v8

    int-to-double v6, v6

    sub-double v27, v18, v27

    move-wide/from16 v35, v6

    const/4 v5, 0x1

    const/4 v5, 0x1

    int-to-double v6, v5

    div-double v27, v27, v6

    mul-double v27, v27, v0

    sub-double v35, v35, v27

    goto :goto_167

    :cond_151
    cmpg-double v6, v18, v27

    if-gez v6, :cond_167

    div-double v6, v45, v0

    add-double v7, v27, v6

    iget-wide v5, v12, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-static {v7, v8, v5, v6}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v5

    iget-wide v7, v13, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v5, v7

    move-wide/from16 v59, v5

    move-wide/from16 v54, v35

    goto :goto_16b

    :cond_167
    :goto_167
    move-wide/from16 v54, v35

    move-wide/from16 v59, v43

    :goto_16b
    cmpg-double v5, v29, v16

    if-gez v5, :cond_17a

    sub-double v5, v16, v29

    move-wide/from16 v27, v14

    const/4 v7, 0x1

    int-to-double v14, v7

    div-double/2addr v5, v14

    mul-double v5, v5, v39

    add-double/2addr v9, v5

    goto :goto_190

    :cond_17a
    move-wide/from16 v27, v14

    cmpg-double v5, v16, v29

    if-gez v5, :cond_190

    div-double v5, v45, v39

    add-double v5, v29, v5

    iget-wide v14, v12, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-static {v5, v6, v14, v15}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v5

    iget-wide v14, v13, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v5, v14

    move-wide/from16 v48, v9

    goto :goto_194

    :cond_190
    :goto_190
    move-wide/from16 v48, v9

    move-wide/from16 v5, v45

    :goto_194
    int-to-double v8, v11

    cmpl-double v10, v8, v20

    if-lez v10, :cond_1a6

    add-int v0, v31, v37

    int-to-double v0, v0

    sub-double v8, v8, v20

    const/4 v7, 0x1

    int-to-double v10, v7

    div-double/2addr v8, v10

    mul-double v7, v39, v8

    sub-double v32, v0, v7

    goto :goto_1bc

    :cond_1a6
    cmpl-double v7, v20, v8

    if-lez v7, :cond_1bc

    div-double v45, v45, v0

    add-double v8, v8, v45

    iget-wide v0, v12, Lorg/mapsforge/core/model/Tile;->mapSize:J

    invoke-static {v8, v9, v0, v1}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v0

    iget-wide v7, v13, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v0, v7

    move-wide/from16 v57, v0

    move-wide/from16 v52, v32

    goto :goto_1c0

    :cond_1bc
    :goto_1bc
    move-wide/from16 v52, v32

    move-wide/from16 v57, v41

    :goto_1c0
    if-nez v34, :cond_1c4

    const/4 v0, 0x0

    goto :goto_1cb

    :cond_1c4
    new-instance v0, Lorg/mapsforge/core/model/Rectangle;

    move-object/from16 v47, v0

    invoke-direct/range {v47 .. v55}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    :goto_1cb
    new-instance v1, Lorg/mapsforge/core/model/Rectangle;

    move-object/from16 v52, v1

    move-wide/from16 v53, v5

    move-wide/from16 v55, v3

    invoke-direct/range {v52 .. v60}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    new-instance v3, Lorg/mapsforge/map/layer/renderer/HillshadingContainer;

    move/from16 v4, v26

    move-object/from16 v5, v34

    invoke-direct {v3, v5, v4, v0, v1}, Lorg/mapsforge/map/layer/renderer/HillshadingContainer;-><init>(Lorg/mapsforge/core/graphics/HillshadingBitmap;FLorg/mapsforge/core/model/Rectangle;Lorg/mapsforge/core/model/Rectangle;)V

    move-object/from16 v1, p0

    iget-byte v0, v1, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->layer:B

    move v5, v2

    move-object/from16 v2, p1

    invoke-virtual {v2, v0}, Lorg/mapsforge/map/rendertheme/RenderContext;->setDrawingLayers(B)V

    iget v0, v1, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->level:I

    new-instance v6, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;

    const/4 v7, 0x0

    invoke-direct {v6, v3, v7}, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;-><init>(Lorg/mapsforge/map/layer/renderer/ShapeContainer;Lorg/mapsforge/core/graphics/Paint;)V

    invoke-virtual {v2, v0, v6}, Lorg/mapsforge/map/rendertheme/RenderContext;->addToCurrentDrawingLayer(ILorg/mapsforge/map/layer/renderer/ShapePaintContainer;)V

    :goto_1f4
    move v11, v4

    move-wide/from16 v14, v27

    move-wide/from16 v9, v29

    move/from16 v3, v38

    goto/16 :goto_a5

    :cond_1fd
    move/from16 v38, v3

    move v4, v11

    move-wide/from16 v27, v14

    const/4 v7, 0x0

    add-int/lit8 v3, v38, 0x1

    goto/16 :goto_9a

    :cond_207
    :goto_207
    return-void
.end method
