.class public Lorg/mapsforge/map/layer/hills/HillsRenderConfig;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private maginuteScaleFactor:F

.field private tileSource:Lorg/mapsforge/map/layer/hills/ShadeTileSource;


# direct methods
.method public constructor <init>(Ljava/io/File;Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/layer/hills/ShadeTileSource;Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->maginuteScaleFactor:F

    if-nez p3, :cond_e

    new-instance p3, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;

    invoke-direct {p3, p1, p4, p2}, Lorg/mapsforge/map/layer/hills/MemoryCachingHgtReaderTileSource;-><init>(Ljava/io/File;Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;Lorg/mapsforge/core/graphics/GraphicFactory;)V

    :cond_e
    iput-object p3, p0, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->tileSource:Lorg/mapsforge/map/layer/hills/ShadeTileSource;

    invoke-interface {p3, p1}, Lorg/mapsforge/map/layer/hills/ShadeTileSource;->setDemFolder(Ljava/io/File;)V

    iget-object p1, p0, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->tileSource:Lorg/mapsforge/map/layer/hills/ShadeTileSource;

    invoke-interface {p1, p4}, Lorg/mapsforge/map/layer/hills/ShadeTileSource;->setShadingAlgorithm(Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/layer/hills/ShadeTileSource;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->maginuteScaleFactor:F

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->tileSource:Lorg/mapsforge/map/layer/hills/ShadeTileSource;

    return-void
.end method


# virtual methods
.method public getMaginuteScaleFactor()F
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->maginuteScaleFactor:F

    return v0
.end method

.method public getShadingTile(IIDD)Lorg/mapsforge/core/graphics/HillshadingBitmap;
    .registers 15

    iget-object v7, p0, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->tileSource:Lorg/mapsforge/map/layer/hills/ShadeTileSource;

    if-nez v7, :cond_6

    const/4 p1, 0x0

    return-object p1

    :cond_6
    move-object v0, v7

    move v1, p1

    move v2, p2

    move-wide v3, p3

    move-wide v5, p5

    invoke-interface/range {v0 .. v6}, Lorg/mapsforge/map/layer/hills/ShadeTileSource;->getHillshadingBitmap(IIDD)Lorg/mapsforge/core/graphics/HillshadingBitmap;

    move-result-object v0

    if-nez v0, :cond_29

    invoke-static {p2}, Ljava/lang/Math;->abs(I)I

    move-result v1

    const/16 v2, 0xb2

    if-le v1, v2, :cond_29

    if-lez p2, :cond_1e

    add-int/lit16 p2, p2, -0xb4

    goto :goto_20

    :cond_1e
    add-int/lit16 p2, p2, 0xb4

    :goto_20
    move v2, p2

    move-object v0, v7

    move v1, p1

    move-wide v3, p3

    move-wide v5, p5

    invoke-interface/range {v0 .. v6}, Lorg/mapsforge/map/layer/hills/ShadeTileSource;->getHillshadingBitmap(IIDD)Lorg/mapsforge/core/graphics/HillshadingBitmap;

    move-result-object v0

    :cond_29
    return-object v0
.end method

.method public getTileSource()Lorg/mapsforge/map/layer/hills/ShadeTileSource;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->tileSource:Lorg/mapsforge/map/layer/hills/ShadeTileSource;

    return-object v0
.end method

.method public indexOnThread()Lorg/mapsforge/map/layer/hills/HillsRenderConfig;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->tileSource:Lorg/mapsforge/map/layer/hills/ShadeTileSource;

    if-eqz v0, :cond_8

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lorg/mapsforge/map/layer/hills/ShadeTileSource;->applyConfiguration(Z)V

    :cond_8
    return-object p0
.end method

.method public setMaginuteScaleFactor(F)V
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->maginuteScaleFactor:F

    return-void
.end method

.method public setTileSource(Lorg/mapsforge/map/layer/hills/ShadeTileSource;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/HillsRenderConfig;->tileSource:Lorg/mapsforge/map/layer/hills/ShadeTileSource;

    return-void
.end method
