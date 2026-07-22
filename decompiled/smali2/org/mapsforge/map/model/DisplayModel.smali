.class public Lorg/mapsforge/map/model/DisplayModel;
.super Lorg/mapsforge/map/model/common/Observable;
.source "SourceFile"


# static fields
.field private static final DEFAULT_BACKGROUND_COLOR:I = -0x111112

.field private static final DEFAULT_MAX_TEXT_WIDTH:I = 0xb3

.field private static final DEFAULT_MAX_TEXT_WIDTH_FACTOR:F = 0.7f

.field private static final DEFAULT_TILE_SIZE:I = 0x100

.field private static defaultUserScaleFactor:F = 1.0f

.field private static deviceScaleFactor:F = 1.0f


# instance fields
.field private backgroundColor:I

.field private filter:Lorg/mapsforge/core/graphics/Filter;

.field private fixedTileSize:I

.field private maxTextWidth:I

.field private maxTextWidthFactor:F

.field private themeCallback:Lorg/mapsforge/map/rendertheme/ThemeCallback;

.field private tileSize:I

.field private tileSizeMultiple:I

.field private userScaleFactor:F


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Lorg/mapsforge/map/model/common/Observable;-><init>()V

    const v0, -0x111112

    iput v0, p0, Lorg/mapsforge/map/model/DisplayModel;->backgroundColor:I

    sget-object v0, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    iput-object v0, p0, Lorg/mapsforge/map/model/DisplayModel;->filter:Lorg/mapsforge/core/graphics/Filter;

    const/16 v0, 0xb3

    iput v0, p0, Lorg/mapsforge/map/model/DisplayModel;->maxTextWidth:I

    const v0, 0x3f333333    # 0.7f

    iput v0, p0, Lorg/mapsforge/map/model/DisplayModel;->maxTextWidthFactor:F

    const/16 v0, 0x100

    iput v0, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSize:I

    const/16 v0, 0x40

    iput v0, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSizeMultiple:I

    sget v0, Lorg/mapsforge/map/model/DisplayModel;->defaultUserScaleFactor:F

    iput v0, p0, Lorg/mapsforge/map/model/DisplayModel;->userScaleFactor:F

    invoke-direct {p0}, Lorg/mapsforge/map/model/DisplayModel;->setTileSize()V

    return-void
.end method

.method public static declared-synchronized getDefaultUserScaleFactor()F
    .registers 2

    const-class v0, Lorg/mapsforge/map/model/DisplayModel;

    monitor-enter v0

    :try_start_3
    sget v1, Lorg/mapsforge/map/model/DisplayModel;->defaultUserScaleFactor:F
    :try_end_5
    .catchall {:try_start_3 .. :try_end_5} :catchall_7

    monitor-exit v0

    return v1

    :catchall_7
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized getDeviceScaleFactor()F
    .registers 2

    const-class v0, Lorg/mapsforge/map/model/DisplayModel;

    monitor-enter v0

    :try_start_3
    sget v1, Lorg/mapsforge/map/model/DisplayModel;->deviceScaleFactor:F
    :try_end_5
    .catchall {:try_start_3 .. :try_end_5} :catchall_7

    monitor-exit v0

    return v1

    :catchall_7
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized setDefaultUserScaleFactor(F)V
    .registers 2

    const-class v0, Lorg/mapsforge/map/model/DisplayModel;

    monitor-enter v0

    :try_start_3
    sput p0, Lorg/mapsforge/map/model/DisplayModel;->defaultUserScaleFactor:F
    :try_end_5
    .catchall {:try_start_3 .. :try_end_5} :catchall_7

    monitor-exit v0

    return-void

    :catchall_7
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method public static declared-synchronized setDeviceScaleFactor(F)V
    .registers 2

    const-class v0, Lorg/mapsforge/map/model/DisplayModel;

    monitor-enter v0

    :try_start_3
    sput p0, Lorg/mapsforge/map/model/DisplayModel;->deviceScaleFactor:F
    :try_end_5
    .catchall {:try_start_3 .. :try_end_5} :catchall_7

    monitor-exit v0

    return-void

    :catchall_7
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method private setMaxTextWidth()V
    .registers 3

    iget v0, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSize:I

    int-to-float v0, v0

    iget v1, p0, Lorg/mapsforge/map/model/DisplayModel;->maxTextWidthFactor:F

    mul-float v0, v0, v1

    float-to-int v0, v0

    iput v0, p0, Lorg/mapsforge/map/model/DisplayModel;->maxTextWidth:I

    return-void
.end method

.method private setTileSize()V
    .registers 4

    iget v0, p0, Lorg/mapsforge/map/model/DisplayModel;->fixedTileSize:I

    if-nez v0, :cond_1e

    const/high16 v0, 0x43800000    # 256.0f

    sget v1, Lorg/mapsforge/map/model/DisplayModel;->deviceScaleFactor:F

    mul-float v1, v1, v0

    iget v0, p0, Lorg/mapsforge/map/model/DisplayModel;->userScaleFactor:F

    mul-float v1, v1, v0

    iget v0, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSizeMultiple:I

    int-to-float v2, v0

    div-float/2addr v1, v2

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    iget v2, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSizeMultiple:I

    mul-int v1, v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    :cond_1e
    iput v0, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSize:I

    invoke-direct {p0}, Lorg/mapsforge/map/model/DisplayModel;->setMaxTextWidth()V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/map/model/DisplayModel;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/map/model/DisplayModel;

    iget v1, p0, Lorg/mapsforge/map/model/DisplayModel;->backgroundColor:I

    iget v3, p1, Lorg/mapsforge/map/model/DisplayModel;->backgroundColor:I

    if-eq v1, v3, :cond_13

    return v2

    :cond_13
    iget-object v1, p0, Lorg/mapsforge/map/model/DisplayModel;->filter:Lorg/mapsforge/core/graphics/Filter;

    iget-object v3, p1, Lorg/mapsforge/map/model/DisplayModel;->filter:Lorg/mapsforge/core/graphics/Filter;

    if-eq v1, v3, :cond_1a

    return v2

    :cond_1a
    iget v1, p0, Lorg/mapsforge/map/model/DisplayModel;->fixedTileSize:I

    iget v3, p1, Lorg/mapsforge/map/model/DisplayModel;->fixedTileSize:I

    if-eq v1, v3, :cond_21

    return v2

    :cond_21
    iget v1, p0, Lorg/mapsforge/map/model/DisplayModel;->maxTextWidth:I

    iget v3, p1, Lorg/mapsforge/map/model/DisplayModel;->maxTextWidth:I

    if-eq v1, v3, :cond_28

    return v2

    :cond_28
    iget v1, p0, Lorg/mapsforge/map/model/DisplayModel;->maxTextWidthFactor:F

    invoke-static {v1}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v1

    iget v3, p1, Lorg/mapsforge/map/model/DisplayModel;->maxTextWidthFactor:F

    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    if-eq v1, v3, :cond_37

    return v2

    :cond_37
    iget v1, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSize:I

    iget v3, p1, Lorg/mapsforge/map/model/DisplayModel;->tileSize:I

    if-eq v1, v3, :cond_3e

    return v2

    :cond_3e
    iget v1, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSizeMultiple:I

    iget v3, p1, Lorg/mapsforge/map/model/DisplayModel;->tileSizeMultiple:I

    if-eq v1, v3, :cond_45

    return v2

    :cond_45
    iget v1, p0, Lorg/mapsforge/map/model/DisplayModel;->userScaleFactor:F

    invoke-static {v1}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v1

    iget p1, p1, Lorg/mapsforge/map/model/DisplayModel;->userScaleFactor:F

    invoke-static {p1}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result p1

    if-eq v1, p1, :cond_54

    return v2

    :cond_54
    return v0
.end method

.method public declared-synchronized getBackgroundColor()I
    .registers 2

    monitor-enter p0

    :try_start_1
    iget v0, p0, Lorg/mapsforge/map/model/DisplayModel;->backgroundColor:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getFilter()Lorg/mapsforge/core/graphics/Filter;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/model/DisplayModel;->filter:Lorg/mapsforge/core/graphics/Filter;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getMaxTextWidth()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/model/DisplayModel;->maxTextWidth:I

    return v0
.end method

.method public declared-synchronized getScaleFactor()F
    .registers 3

    monitor-enter p0

    :try_start_1
    sget v0, Lorg/mapsforge/map/model/DisplayModel;->deviceScaleFactor:F

    iget v1, p0, Lorg/mapsforge/map/model/DisplayModel;->userScaleFactor:F
    :try_end_5
    .catchall {:try_start_1 .. :try_end_5} :catchall_9

    mul-float v0, v0, v1

    monitor-exit p0

    return v0

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getThemeCallback()Lorg/mapsforge/map/rendertheme/ThemeCallback;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/model/DisplayModel;->themeCallback:Lorg/mapsforge/map/rendertheme/ThemeCallback;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getTileSize()I
    .registers 2

    monitor-enter p0

    :try_start_1
    iget v0, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSize:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getTileSizeMultiple()I
    .registers 2

    monitor-enter p0

    :try_start_1
    iget v0, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSizeMultiple:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUserScaleFactor()F
    .registers 2

    monitor-enter p0

    :try_start_1
    iget v0, p0, Lorg/mapsforge/map/model/DisplayModel;->userScaleFactor:F
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public hashCode()I
    .registers 4

    iget v0, p0, Lorg/mapsforge/map/model/DisplayModel;->backgroundColor:I

    const/16 v1, 0x1f

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lorg/mapsforge/map/model/DisplayModel;->filter:Lorg/mapsforge/core/graphics/Filter;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lorg/mapsforge/map/model/DisplayModel;->fixedTileSize:I

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lorg/mapsforge/map/model/DisplayModel;->maxTextWidth:I

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lorg/mapsforge/map/model/DisplayModel;->maxTextWidthFactor:F

    invoke-static {v2}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSize:I

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSizeMultiple:I

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v1, p0, Lorg/mapsforge/map/model/DisplayModel;->userScaleFactor:F

    invoke-static {v1}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public declared-synchronized setBackgroundColor(I)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput p1, p0, Lorg/mapsforge/map/model/DisplayModel;->backgroundColor:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setFilter(Lorg/mapsforge/core/graphics/Filter;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/model/DisplayModel;->filter:Lorg/mapsforge/core/graphics/Filter;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public setFixedTileSize(I)V
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/model/DisplayModel;->fixedTileSize:I

    invoke-direct {p0}, Lorg/mapsforge/map/model/DisplayModel;->setTileSize()V

    return-void
.end method

.method public setMaxTextWidthFactor(F)V
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/model/DisplayModel;->maxTextWidthFactor:F

    invoke-direct {p0}, Lorg/mapsforge/map/model/DisplayModel;->setMaxTextWidth()V

    return-void
.end method

.method public declared-synchronized setThemeCallback(Lorg/mapsforge/map/rendertheme/ThemeCallback;)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Lorg/mapsforge/map/model/DisplayModel;->themeCallback:Lorg/mapsforge/map/rendertheme/ThemeCallback;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-void

    :catchall_5
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setTileSizeMultiple(I)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput p1, p0, Lorg/mapsforge/map/model/DisplayModel;->tileSizeMultiple:I

    invoke-direct {p0}, Lorg/mapsforge/map/model/DisplayModel;->setTileSize()V
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    monitor-exit p0

    return-void

    :catchall_8
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setUserScaleFactor(F)V
    .registers 2

    monitor-enter p0

    :try_start_1
    iput p1, p0, Lorg/mapsforge/map/model/DisplayModel;->userScaleFactor:F

    invoke-direct {p0}, Lorg/mapsforge/map/model/DisplayModel;->setTileSize()V
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    monitor-exit p0

    return-void

    :catchall_8
    move-exception p1

    monitor-exit p0

    throw p1
.end method
