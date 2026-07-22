.class public Lorg/mapsforge/map/rendertheme/rule/RenderTheme;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final MATCHING_CACHE_SIZE:I = 0x400


# instance fields
.field private final baseStrokeWidth:F

.field private final baseTextSize:F

.field private final hasBackgroundOutside:Z

.field private hillShadings:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;",
            ">;"
        }
    .end annotation
.end field

.field private levels:I

.field private final mapBackground:I

.field private final mapBackgroundOutside:I

.field private final poiMatchingCache:Lorg/mapsforge/core/util/LRUCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/mapsforge/core/util/LRUCache<",
            "Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;",
            ">;>;"
        }
    .end annotation
.end field

.field private final rulesList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lorg/mapsforge/map/rendertheme/rule/Rule;",
            ">;"
        }
    .end annotation
.end field

.field private final strokeScales:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Byte;",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation
.end field

.field private final textScales:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Byte;",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation
.end field

.field private final wayMatchingCache:Lorg/mapsforge/core/util/LRUCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/mapsforge/core/util/LRUCache<",
            "Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->hillShadings:Ljava/util/ArrayList;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->strokeScales:Ljava/util/Map;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->textScales:Ljava/util/Map;

    iget v0, p1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->baseStrokeWidth:F

    iput v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->baseStrokeWidth:F

    iget v0, p1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->baseTextSize:F

    iput v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->baseTextSize:F

    iget-boolean v0, p1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->hasBackgroundOutside:Z

    iput-boolean v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->hasBackgroundOutside:Z

    iget v0, p1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->mapBackground:I

    iput v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->mapBackground:I

    iget p1, p1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeBuilder;->mapBackgroundOutside:I

    iput p1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->mapBackgroundOutside:I

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    new-instance p1, Lorg/mapsforge/core/util/LRUCache;

    const/16 v0, 0x400

    invoke-direct {p1, v0}, Lorg/mapsforge/core/util/LRUCache;-><init>(I)V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->poiMatchingCache:Lorg/mapsforge/core/util/LRUCache;

    new-instance p1, Lorg/mapsforge/core/util/LRUCache;

    invoke-direct {p1, v0}, Lorg/mapsforge/core/util/LRUCache;-><init>(I)V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->wayMatchingCache:Lorg/mapsforge/core/util/LRUCache;

    return-void
.end method

.method private declared-synchronized matchWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/rendertheme/rule/Closed;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 16

    monitor-enter p0

    :try_start_1
    new-instance v0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;

    invoke-virtual {p4}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getTags()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p4}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getUpperLeft()Lorg/mapsforge/core/model/Tile;

    move-result-object v2

    iget-byte v2, v2, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-direct {v0, v1, v2, p3}, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;-><init>(Ljava/util/List;BLorg/mapsforge/map/rendertheme/rule/Closed;)V

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->wayMatchingCache:Lorg/mapsforge/core/util/LRUCache;

    invoke-virtual {v1, v0}, Ljava/util/AbstractMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    const/4 v2, 0x0

    if-eqz v1, :cond_2f

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result p3

    :goto_1f
    if-ge v2, p3, :cond_2d

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;

    invoke-virtual {v0, p1, p2, p4}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->renderWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    :try_end_2a
    .catchall {:try_start_1 .. :try_end_2a} :catchall_5b

    add-int/lit8 v2, v2, 0x1

    goto :goto_1f

    :cond_2d
    monitor-exit p0

    return-void

    :cond_2f
    :try_start_2f
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v9

    const/4 v10, 0x0

    :goto_3b
    if-ge v10, v9, :cond_54

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v1, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {p4}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getUpperLeft()Lorg/mapsforge/core/model/Tile;

    move-result-object v4

    move-object v2, p1

    move-object v3, p4

    move-object v5, p3

    move-object v6, v8

    move-object v7, p2

    invoke-virtual/range {v1 .. v7}, Lorg/mapsforge/map/rendertheme/rule/Rule;->matchWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/layer/renderer/PolylineContainer;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/rendertheme/rule/Closed;Ljava/util/List;Lorg/mapsforge/map/rendertheme/RenderContext;)V

    add-int/lit8 v10, v10, 0x1

    goto :goto_3b

    :cond_54
    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->wayMatchingCache:Lorg/mapsforge/core/util/LRUCache;

    invoke-virtual {p1, v0, v8}, Ljava/util/AbstractMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_59
    .catchall {:try_start_2f .. :try_end_59} :catchall_5b

    monitor-exit p0

    return-void

    :catchall_5b
    move-exception p1

    monitor-exit p0

    throw p1
.end method


# virtual methods
.method addHillShadings(Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->hillShadings:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method addRule(Lorg/mapsforge/map/rendertheme/rule/Rule;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method complete()V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->trimToSize()V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->hillShadings:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->trimToSize()V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_11
    if-ge v1, v0, :cond_21

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {v2}, Lorg/mapsforge/map/rendertheme/rule/Rule;->onComplete()V

    add-int/lit8 v1, v1, 0x1

    goto :goto_11

    :cond_21
    return-void
.end method

.method public destroy()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->poiMatchingCache:Lorg/mapsforge/core/util/LRUCache;

    invoke-virtual {v0}, Ljava/util/AbstractMap;->clear()V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->wayMatchingCache:Lorg/mapsforge/core/util/LRUCache;

    invoke-virtual {v0}, Ljava/util/AbstractMap;->clear()V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_10
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_20

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {v1}, Lorg/mapsforge/map/rendertheme/rule/Rule;->destroy()V

    goto :goto_10

    :cond_20
    return-void
.end method

.method public getLevels()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->levels:I

    return v0
.end method

.method public getMapBackground()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->mapBackground:I

    return v0
.end method

.method public getMapBackgroundOutside()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->mapBackgroundOutside:I

    return v0
.end method

.method public hasMapBackgroundOutside()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->hasBackgroundOutside:Z

    return v0
.end method

.method public matchClosedWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 5

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/Closed;->YES:Lorg/mapsforge/map/rendertheme/rule/Closed;

    invoke-direct {p0, p1, p2, v0, p3}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->matchWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/rendertheme/rule/Closed;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    return-void
.end method

.method public matchHillShadings(Lorg/mapsforge/map/layer/renderer/StandardRenderer;Lorg/mapsforge/map/rendertheme/RenderContext;)V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->hillShadings:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_18

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;

    iget-object v2, p1, Lorg/mapsforge/map/layer/renderer/StandardRenderer;->hillsRenderConfig:Lorg/mapsforge/map/layer/hills/HillsRenderConfig;

    invoke-virtual {v1, p2, v2}, Lorg/mapsforge/map/rendertheme/renderinstruction/Hillshading;->render(Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/hills/HillsRenderConfig;)V

    goto :goto_6

    :cond_18
    return-void
.end method

.method public matchLinearWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V
    .registers 5

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/Closed;->NO:Lorg/mapsforge/map/rendertheme/rule/Closed;

    invoke-direct {p0, p1, p2, v0, p3}, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->matchWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/rendertheme/rule/Closed;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    return-void
.end method

.method public declared-synchronized matchNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/PointOfInterest;)V
    .registers 9

    monitor-enter p0

    :try_start_1
    new-instance v0, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;

    iget-object v1, p3, Lorg/mapsforge/map/datastore/PointOfInterest;->tags:Ljava/util/List;

    iget-object v2, p2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v2, v2, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v2, v2, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    sget-object v3, Lorg/mapsforge/map/rendertheme/rule/Closed;->NO:Lorg/mapsforge/map/rendertheme/rule/Closed;

    invoke-direct {v0, v1, v2, v3}, Lorg/mapsforge/map/rendertheme/rule/MatchingCacheKey;-><init>(Ljava/util/List;BLorg/mapsforge/map/rendertheme/rule/Closed;)V

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->poiMatchingCache:Lorg/mapsforge/core/util/LRUCache;

    invoke-virtual {v1, v0}, Ljava/util/AbstractMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    const/4 v2, 0x0

    if-eqz v1, :cond_2f

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    :goto_1f
    if-ge v2, v0, :cond_2d

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;

    invoke-virtual {v3, p1, p2, p3}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->renderNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/PointOfInterest;)V
    :try_end_2a
    .catchall {:try_start_1 .. :try_end_2a} :catchall_51

    add-int/lit8 v2, v2, 0x1

    goto :goto_1f

    :cond_2d
    monitor-exit p0

    return-void

    :cond_2f
    :try_start_2f
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    :goto_3a
    if-ge v2, v3, :cond_4a

    iget-object v4, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {v4, p1, p2, v1, p3}, Lorg/mapsforge/map/rendertheme/rule/Rule;->matchNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Ljava/util/List;Lorg/mapsforge/map/datastore/PointOfInterest;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_3a

    :cond_4a
    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->poiMatchingCache:Lorg/mapsforge/core/util/LRUCache;

    invoke-virtual {p1, v0, v1}, Ljava/util/AbstractMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_4f
    .catchall {:try_start_2f .. :try_end_4f} :catchall_51

    monitor-exit p0

    return-void

    :catchall_51
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized scaleStrokeWidth(FB)V
    .registers 7

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->strokeScales:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_21

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->strokeScales:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_51

    :cond_21
    const/4 v0, 0x0

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    :goto_28
    if-ge v0, v1, :cond_44

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/Rule;

    iget-byte v3, v2, Lorg/mapsforge/map/rendertheme/rule/Rule;->zoomMin:B

    if-gt v3, p2, :cond_41

    iget-byte v3, v2, Lorg/mapsforge/map/rendertheme/rule/Rule;->zoomMax:B

    if-lt v3, p2, :cond_41

    iget v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->baseStrokeWidth:F

    mul-float v3, v3, p1

    invoke-virtual {v2, v3, p2}, Lorg/mapsforge/map/rendertheme/rule/Rule;->scaleStrokeWidth(FB)V

    :cond_41
    add-int/lit8 v0, v0, 0x1

    goto :goto_28

    :cond_44
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->strokeScales:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p2

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    invoke-interface {v0, p2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_51
    .catchall {:try_start_1 .. :try_end_51} :catchall_53

    :cond_51
    monitor-exit p0

    return-void

    :catchall_53
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized scaleTextSize(FB)V
    .registers 7

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->textScales:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_21

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->textScales:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_51

    :cond_21
    const/4 v0, 0x0

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    :goto_28
    if-ge v0, v1, :cond_44

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/Rule;

    iget-byte v3, v2, Lorg/mapsforge/map/rendertheme/rule/Rule;->zoomMin:B

    if-gt v3, p2, :cond_41

    iget-byte v3, v2, Lorg/mapsforge/map/rendertheme/rule/Rule;->zoomMax:B

    if-lt v3, p2, :cond_41

    iget v3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->baseTextSize:F

    mul-float v3, v3, p1

    invoke-virtual {v2, v3, p2}, Lorg/mapsforge/map/rendertheme/rule/Rule;->scaleTextSize(FB)V

    :cond_41
    add-int/lit8 v0, v0, 0x1

    goto :goto_28

    :cond_44
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->textScales:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p2

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    invoke-interface {v0, p2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_51
    .catchall {:try_start_1 .. :try_end_51} :catchall_53

    :cond_51
    monitor-exit p0

    return-void

    :catchall_53
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method setLevels(I)V
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->levels:I

    return-void
.end method

.method public traverseRules(Lorg/mapsforge/map/rendertheme/rule/Rule$RuleVisitor;)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderTheme;->rulesList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/rendertheme/rule/Rule;->apply(Lorg/mapsforge/map/rendertheme/rule/Rule$RuleVisitor;)V

    goto :goto_6

    :cond_16
    return-void
.end method
