.class public final Lorg/mapsforge/map/android/util/AndroidUtil;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/android/util/AndroidUtil;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/android/util/AndroidUtil;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createExternalStorageTileCache(Landroid/content/Context;Ljava/lang/String;II)Lorg/mapsforge/map/layer/cache/TileCache;
    .registers 5

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, p3, v0}, Lorg/mapsforge/map/android/util/AndroidUtil;->createExternalStorageTileCache(Landroid/content/Context;Ljava/lang/String;IIZ)Lorg/mapsforge/map/layer/cache/TileCache;

    move-result-object p0

    return-object p0
.end method

.method public static createExternalStorageTileCache(Landroid/content/Context;Ljava/lang/String;IIZ)Lorg/mapsforge/map/layer/cache/TileCache;
    .registers 5

    invoke-virtual {p0}, Landroid/content/Context;->getExternalCacheDir()Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1, p2, p3, p4}, Lorg/mapsforge/map/android/util/AndroidUtil;->createExternalStorageTileCache(Ljava/io/File;Ljava/lang/String;IIZ)Lorg/mapsforge/map/layer/cache/TileCache;

    move-result-object p0

    return-object p0
.end method

.method public static createExternalStorageTileCache(Ljava/io/File;Ljava/lang/String;IIZ)Lorg/mapsforge/map/layer/cache/TileCache;
    .registers 8

    sget-object v0, Lorg/mapsforge/map/android/util/AndroidUtil;->LOGGER:Ljava/util/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "TILECACHE INMEMORY SIZE: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/logging/Logger;->info(Ljava/lang/String;)V

    new-instance v1, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;

    invoke-direct {v1, p2}, Lorg/mapsforge/map/layer/cache/InMemoryTileCache;-><init>(I)V

    if-eqz p0, :cond_85

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object p0, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    new-instance p1, Ljava/io/File;

    invoke-direct {p1, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_4a

    invoke-virtual {p1}, Ljava/io/File;->mkdirs()Z

    move-result v2

    if-eqz v2, :cond_85

    :cond_4a
    invoke-static {p0, p2, p3}, Lorg/mapsforge/map/android/util/AndroidUtil;->estimateSizeOfFileSystemCache(Ljava/lang/String;II)I

    move-result p0

    invoke-virtual {p1}, Ljava/io/File;->canWrite()Z

    move-result p2

    if-eqz p2, :cond_85

    if-lez p0, :cond_85

    :try_start_56
    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "TILECACHE FILE SIZE: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object p3

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {v0, p2}, Ljava/util/logging/Logger;->info(Ljava/lang/String;)V

    new-instance p2, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;

    sget-object p3, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    invoke-direct {p2, p0, p1, p3, p4}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;-><init>(ILjava/io/File;Lorg/mapsforge/core/graphics/GraphicFactory;Z)V

    new-instance p0, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;

    invoke-direct {p0, v1, p2}, Lorg/mapsforge/map/layer/cache/TwoLevelTileCache;-><init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/layer/cache/TileCache;)V
    :try_end_7a
    .catch Ljava/lang/IllegalArgumentException; {:try_start_56 .. :try_end_7a} :catch_7b

    return-object p0

    :catch_7b
    move-exception p0

    sget-object p1, Lorg/mapsforge/map/android/util/AndroidUtil;->LOGGER:Ljava/util/logging/Logger;

    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p1, p0}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    :cond_85
    return-object v1
.end method

.method public static createTileCache(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;IFDZ)Lorg/mapsforge/map/layer/cache/TileCache;
    .registers 8

    invoke-static {p0, p3, p5, p6, p4}, Lorg/mapsforge/map/android/util/AndroidUtil;->getMinimumCacheSize(Landroid/content/Context;IDF)I

    move-result p0

    invoke-static {p1, p2, p0, p3, p7}, Lorg/mapsforge/map/android/util/AndroidUtil;->createExternalStorageTileCache(Ljava/io/File;Ljava/lang/String;IIZ)Lorg/mapsforge/map/layer/cache/TileCache;

    move-result-object p0

    return-object p0
.end method

.method public static createTileCache(Landroid/content/Context;Ljava/lang/String;IFD)Lorg/mapsforge/map/layer/cache/TileCache;
    .registers 13

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move-wide v4, p4

    invoke-static/range {v0 .. v6}, Lorg/mapsforge/map/android/util/AndroidUtil;->createTileCache(Landroid/content/Context;Ljava/lang/String;IFDZ)Lorg/mapsforge/map/layer/cache/TileCache;

    move-result-object p0

    return-object p0
.end method

.method public static createTileCache(Landroid/content/Context;Ljava/lang/String;IFDZ)Lorg/mapsforge/map/layer/cache/TileCache;
    .registers 7

    invoke-static {p0, p2, p4, p5, p3}, Lorg/mapsforge/map/android/util/AndroidUtil;->getMinimumCacheSize(Landroid/content/Context;IDF)I

    move-result p3

    invoke-static {p0, p1, p3, p2, p6}, Lorg/mapsforge/map/android/util/AndroidUtil;->createExternalStorageTileCache(Landroid/content/Context;Ljava/lang/String;IIZ)Lorg/mapsforge/map/layer/cache/TileCache;

    move-result-object p0

    return-object p0
.end method

.method public static createTileCache(Landroid/content/Context;Ljava/lang/String;IIID)Lorg/mapsforge/map/layer/cache/TileCache;
    .registers 15

    const/4 v7, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move-wide v5, p5

    invoke-static/range {v0 .. v7}, Lorg/mapsforge/map/android/util/AndroidUtil;->createTileCache(Landroid/content/Context;Ljava/lang/String;IIIDZ)Lorg/mapsforge/map/layer/cache/TileCache;

    move-result-object p0

    return-object p0
.end method

.method public static createTileCache(Landroid/content/Context;Ljava/lang/String;IIIDZ)Lorg/mapsforge/map/layer/cache/TileCache;
    .registers 8

    invoke-static {p2, p5, p6, p3, p4}, Lorg/mapsforge/map/android/util/AndroidUtil;->getMinimumCacheSize(IDII)I

    move-result p3

    invoke-static {p0, p1, p3, p2, p7}, Lorg/mapsforge/map/android/util/AndroidUtil;->createExternalStorageTileCache(Landroid/content/Context;Ljava/lang/String;IIZ)Lorg/mapsforge/map/layer/cache/TileCache;

    move-result-object p0

    return-object p0
.end method

.method public static createTileCache(Ljava/io/File;Ljava/lang/String;IIIDZ)Lorg/mapsforge/map/layer/cache/TileCache;
    .registers 8

    invoke-static {p2, p5, p6, p3, p4}, Lorg/mapsforge/map/android/util/AndroidUtil;->getMinimumCacheSize(IDII)I

    move-result p3

    invoke-static {p0, p1, p3, p2, p7}, Lorg/mapsforge/map/android/util/AndroidUtil;->createExternalStorageTileCache(Ljava/io/File;Ljava/lang/String;IIZ)Lorg/mapsforge/map/layer/cache/TileCache;

    move-result-object p0

    return-object p0
.end method

.method public static createTileRendererLayer(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/rendertheme/XmlRenderTheme;)Lorg/mapsforge/map/layer/renderer/TileRendererLayer;
    .registers 6

    new-instance v0, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;

    sget-object v1, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    invoke-direct {v0, p0, p2, p1, v1}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;-><init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/core/graphics/GraphicFactory;)V

    invoke-virtual {v0, p3}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->setXmlRenderTheme(Lorg/mapsforge/map/rendertheme/XmlRenderTheme;)V

    return-object v0
.end method

.method public static createTileRendererLayer(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/rendertheme/XmlRenderTheme;ZZZ)Lorg/mapsforge/map/layer/renderer/TileRendererLayer;
    .registers 16

    new-instance v8, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;

    sget-object v7, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    move-object v0, v8

    move-object v1, p0

    move-object v2, p2

    move-object v3, p1

    move v4, p4

    move v5, p5

    move v6, p6

    invoke-direct/range {v0 .. v7}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;-><init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/model/IMapViewPosition;ZZZLorg/mapsforge/core/graphics/GraphicFactory;)V

    invoke-virtual {v8, p3}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->setXmlRenderTheme(Lorg/mapsforge/map/rendertheme/XmlRenderTheme;)V

    return-object v8
.end method

.method public static createTileRendererLayer(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/rendertheme/XmlRenderTheme;ZZZLorg/mapsforge/map/layer/hills/HillsRenderConfig;)Lorg/mapsforge/map/layer/renderer/TileRendererLayer;
    .registers 18

    new-instance v9, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;

    sget-object v7, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    move-object v0, v9

    move-object v1, p0

    move-object v2, p2

    move-object v3, p1

    move v4, p4

    move v5, p5

    move/from16 v6, p6

    move-object/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;-><init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/model/IMapViewPosition;ZZZLorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/layer/hills/HillsRenderConfig;)V

    move-object v0, p3

    invoke-virtual {v9, p3}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->setXmlRenderTheme(Lorg/mapsforge/map/rendertheme/XmlRenderTheme;)V

    return-object v9
.end method

.method public static currentThreadIsUiThread()Z
    .registers 2

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    if-ne v0, v1, :cond_10

    const/4 v0, 0x1

    goto :goto_11

    :cond_10
    const/4 v0, 0x0

    :goto_11
    return v0
.end method

.method public static estimateSizeOfFileSystemCache(Ljava/lang/String;II)I
    .registers 7

    mul-int/lit8 v0, p2, 0x4

    mul-int v0, v0, p2

    invoke-static {p0, v0}, Lorg/mapsforge/map/android/util/AndroidUtil;->getAvailableCacheSlots(Ljava/lang/String;I)J

    move-result-wide v0

    const-wide/16 v2, 0x7d0

    invoke-static {v2, v3, v0, v1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    long-to-int p0, v0

    if-le p1, p0, :cond_12

    const/4 p0, 0x0

    :cond_12
    return p0
.end method

.method public static getAvailableCacheSlots(Ljava/lang/String;I)J
    .registers 4

    new-instance v0, Landroid/os/StatFs;

    invoke-direct {v0, p0}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/os/StatFs;->getAvailableBytes()J

    move-result-wide v0

    int-to-long p0, p1

    div-long/2addr v0, p0

    return-wide v0
.end method

.method public static getMinimumCacheSize(IDII)I
    .registers 6

    new-instance v0, Lorg/mapsforge/core/model/Dimension;

    invoke-direct {v0, p3, p4}, Lorg/mapsforge/core/model/Dimension;-><init>(II)V

    invoke-static {v0, p1, p2}, Lorg/mapsforge/map/controller/FrameBufferController;->calculateFrameBufferDimension(Lorg/mapsforge/core/model/Dimension;D)Lorg/mapsforge/core/model/Dimension;

    move-result-object p1

    iget p2, p1, Lorg/mapsforge/core/model/Dimension;->height:I

    div-int/2addr p2, p0

    add-int/lit8 p2, p2, 0x2

    iget p1, p1, Lorg/mapsforge/core/model/Dimension;->width:I

    div-int/2addr p1, p0

    add-int/lit8 p1, p1, 0x2

    mul-int p2, p2, p1

    const/4 p0, 0x4

    invoke-static {p0, p2}, Ljava/lang/Math;->max(II)I

    move-result p0

    return p0
.end method

.method public static getMinimumCacheSize(Landroid/content/Context;IDF)I
    .registers 7

    const-string v0, "window"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Landroid/view/WindowManager;

    invoke-interface {p0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object p0

    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    invoke-virtual {p0, v0}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    iget p0, v0, Landroid/graphics/Point;->y:I

    iget v0, v0, Landroid/graphics/Point;->x:I

    new-instance v1, Lorg/mapsforge/core/model/Dimension;

    invoke-direct {v1, v0, p0}, Lorg/mapsforge/core/model/Dimension;-><init>(II)V

    invoke-static {v1, p2, p3}, Lorg/mapsforge/map/controller/FrameBufferController;->calculateFrameBufferDimension(Lorg/mapsforge/core/model/Dimension;D)Lorg/mapsforge/core/model/Dimension;

    move-result-object p0

    const/high16 p2, 0x40800000    # 4.0f

    iget p3, p0, Lorg/mapsforge/core/model/Dimension;->height:I

    div-int/2addr p3, p1

    add-int/lit8 p3, p3, 0x2

    int-to-float p3, p3

    mul-float p4, p4, p3

    iget p0, p0, Lorg/mapsforge/core/model/Dimension;->width:I

    div-int/2addr p0, p1

    add-int/lit8 p0, p0, 0x2

    int-to-float p0, p0

    mul-float p4, p4, p0

    invoke-static {p2, p4}, Ljava/lang/Math;->max(FF)F

    move-result p0

    float-to-int p0, p0

    return p0
.end method

.method public static restartActivity(Landroid/app/Activity;)V
    .registers 1

    invoke-virtual {p0}, Landroid/app/Activity;->recreate()V

    return-void
.end method

.method public static setMapScaleBar(Lorg/mapsforge/map/android/view/MapView;Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;)V
    .registers 8

    if-nez p1, :cond_9

    if-nez p2, :cond_9

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/android/view/MapView;->setMapScaleBar(Lorg/mapsforge/map/scalebar/MapScaleBar;)V

    goto :goto_45

    :cond_9
    invoke-virtual {p0}, Lorg/mapsforge/map/android/view/MapView;->getMapScaleBar()Lorg/mapsforge/map/scalebar/MapScaleBar;

    move-result-object v0

    if-nez v0, :cond_2b

    new-instance v0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;

    invoke-virtual {p0}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v1

    iget-object v1, v1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-virtual {p0}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v2

    iget-object v2, v2, Lorg/mapsforge/map/model/Model;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    sget-object v3, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    invoke-virtual {p0}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v4

    iget-object v4, v4, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-direct {v0, v1, v2, v3, v4}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;-><init>(Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/model/MapViewDimension;Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/android/view/MapView;->setMapScaleBar(Lorg/mapsforge/map/scalebar/MapScaleBar;)V

    :cond_2b
    instance-of p0, v0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;

    if-eqz p0, :cond_42

    move-object p0, v0

    check-cast p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;

    if-eqz p2, :cond_3d

    sget-object v1, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;->BOTH:Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;

    invoke-virtual {p0, v1}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->setScaleBarMode(Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;)V

    invoke-virtual {p0, p2}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->setSecondaryDistanceUnitAdapter(Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;)V

    goto :goto_42

    :cond_3d
    sget-object p2, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;->SINGLE:Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;

    invoke-virtual {p0, p2}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->setScaleBarMode(Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;)V

    :cond_42
    :goto_42
    invoke-virtual {v0, p1}, Lorg/mapsforge/map/scalebar/MapScaleBar;->setDistanceUnitAdapter(Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;)V

    :goto_45
    return-void
.end method
