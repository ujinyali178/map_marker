.class public Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/hills/ShadeTileSource;


# instance fields
.field private algorithm:Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;

.field private configurationChangePending:Z

.field private currentCache:Lorg/mapsforge/map/layer/hills/HgtCache;

.field private demFolder:Ljava/io/File;

.field private enableInterpolationOverlap:Z

.field private final graphicsFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field private mainCacheSize:I

.field private neighborCacheSize:I


# direct methods
.method public constructor <init>(Ljava/io/File;Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 4

    invoke-direct {p0, p3}, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;)V

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->demFolder:Ljava/io/File;

    iput-object p2, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->algorithm:Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x4

    iput v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->mainCacheSize:I

    iput v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->neighborCacheSize:I

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->enableInterpolationOverlap:Z

    iput-boolean v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->configurationChangePending:Z

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->graphicsFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    return-void
.end method

.method private latestCache()Lorg/mapsforge/map/layer/hills/HgtCache;
    .registers 10

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->currentCache:Lorg/mapsforge/map/layer/hills/HgtCache;

    if-eqz v0, :cond_9

    iget-boolean v1, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->configurationChangePending:Z

    if-nez v1, :cond_9

    return-object v0

    :cond_9
    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->demFolder:Ljava/io/File;

    if-eqz v1, :cond_4f

    iget-object v2, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->algorithm:Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;

    if-nez v2, :cond_12

    goto :goto_4f

    :cond_12
    if-eqz v0, :cond_3a

    iget-boolean v2, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->enableInterpolationOverlap:Z

    iget-boolean v3, v0, Lorg/mapsforge/map/layer/hills/HgtCache;->interpolatorOverlap:Z

    if-ne v2, v3, :cond_3a

    iget v2, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->mainCacheSize:I

    iget v3, v0, Lorg/mapsforge/map/layer/hills/HgtCache;->mainCacheSize:I

    if-ne v2, v3, :cond_3a

    iget v2, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->neighborCacheSize:I

    iget v3, v0, Lorg/mapsforge/map/layer/hills/HgtCache;->neighborCacheSize:I

    if-ne v2, v3, :cond_3a

    iget-object v2, v0, Lorg/mapsforge/map/layer/hills/HgtCache;->demFolder:Ljava/io/File;

    invoke-virtual {v1, v2}, Ljava/io/File;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3a

    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->algorithm:Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;

    iget-object v2, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->currentCache:Lorg/mapsforge/map/layer/hills/HgtCache;

    iget-object v2, v2, Lorg/mapsforge/map/layer/hills/HgtCache;->algorithm:Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;

    invoke-virtual {v1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_4e

    :cond_3a
    new-instance v0, Lorg/mapsforge/map/layer/hills/HgtCache;

    iget-object v3, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->demFolder:Ljava/io/File;

    iget-boolean v4, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->enableInterpolationOverlap:Z

    iget-object v5, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->graphicsFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v6, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->algorithm:Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;

    iget v7, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->mainCacheSize:I

    iget v8, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->neighborCacheSize:I

    move-object v2, v0

    invoke-direct/range {v2 .. v8}, Lorg/mapsforge/map/layer/hills/HgtCache;-><init>(Ljava/io/File;ZLorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;II)V

    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->currentCache:Lorg/mapsforge/map/layer/hills/HgtCache;

    :cond_4e
    return-object v0

    :cond_4f
    :goto_4f
    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->currentCache:Lorg/mapsforge/map/layer/hills/HgtCache;

    return-object v0
.end method


# virtual methods
.method public applyConfiguration(Z)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->currentCache:Lorg/mapsforge/map/layer/hills/HgtCache;

    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->latestCache()Lorg/mapsforge/map/layer/hills/HgtCache;

    move-result-object v1

    if-eqz p1, :cond_f

    if-eqz v1, :cond_f

    if-eq v1, v0, :cond_f

    invoke-virtual {v1}, Lorg/mapsforge/map/layer/hills/HgtCache;->indexOnThread()V

    :cond_f
    return-void
.end method

.method public getAlgorithm()Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->algorithm:Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;

    return-object v0
.end method

.method public getDemFolder()Ljava/io/File;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->demFolder:Ljava/io/File;

    return-object v0
.end method

.method public getHillshadingBitmap(IIDD)Lorg/mapsforge/core/graphics/HillshadingBitmap;
    .registers 14

    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->latestCache()Lorg/mapsforge/map/layer/hills/HgtCache;

    move-result-object v0

    if-nez v0, :cond_8

    const/4 p1, 0x0

    return-object p1

    :cond_8
    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->currentCache:Lorg/mapsforge/map/layer/hills/HgtCache;

    move v1, p1

    move v2, p2

    move-wide v3, p3

    move-wide v5, p5

    invoke-virtual/range {v0 .. v6}, Lorg/mapsforge/map/layer/hills/HgtCache;->getHillshadingBitmap(IIDD)Lorg/mapsforge/core/graphics/HillshadingBitmap;

    move-result-object p1

    return-object p1
.end method

.method public getMainCacheSize()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->mainCacheSize:I

    return v0
.end method

.method public getNeighborCacheSize()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->neighborCacheSize:I

    return v0
.end method

.method public isEnableInterpolationOverlap()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->enableInterpolationOverlap:Z

    return v0
.end method

.method public prepareOnThread()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->currentCache:Lorg/mapsforge/map/layer/hills/HgtCache;

    if-eqz v0, :cond_7

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/hills/HgtCache;->indexOnThread()V

    :cond_7
    return-void
.end method

.method public setDemFolder(Ljava/io/File;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->demFolder:Ljava/io/File;

    return-void
.end method

.method public setEnableInterpolationOverlap(Z)V
    .registers 2

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->enableInterpolationOverlap:Z

    return-void
.end method

.method public setMainCacheSize(I)V
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->mainCacheSize:I

    return-void
.end method

.method public setNeighborCacheSize(I)V
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->neighborCacheSize:I

    return-void
.end method

.method public setShadingAlgorithm(Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;->algorithm:Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;

    return-void
.end method
