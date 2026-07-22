.class public Lorg/mapsforge/map/android/graphics/AndroidSvgBitmap;
.super Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;
.source "SourceFile"


# static fields
.field public static DEFAULT_SIZE:F = 400.0f


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method public constructor <init>(Ljava/io/InputStream;IFIII)V
    .registers 7

    invoke-direct {p0, p2}, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;-><init>(I)V

    invoke-static/range {p1 .. p6}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmap;->getResourceBitmapImpl(Ljava/io/InputStream;IFIII)Landroid/graphics/Bitmap;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    return-void
.end method

.method public static getResourceBitmap(Ljava/io/InputStream;FFIII)Landroid/graphics/Bitmap;
    .registers 14

    :try_start_0
    invoke-static {p0}, Lc0/g;->h(Ljava/io/InputStream;)Lc0/g;

    move-result-object p0

    invoke-virtual {p0}, Lc0/g;->k()Landroid/graphics/Picture;

    move-result-object p0

    float-to-double v0, p1

    invoke-virtual {p0}, Landroid/graphics/Picture;->getHeight()I

    move-result p1

    invoke-virtual {p0}, Landroid/graphics/Picture;->getWidth()I

    move-result v2

    mul-int p1, p1, v2

    int-to-float p1, p1

    div-float/2addr p1, p2

    float-to-double p1, p1

    invoke-static {p1, p2}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide p1

    div-double/2addr v0, p1

    invoke-virtual {p0}, Landroid/graphics/Picture;->getWidth()I

    move-result p1

    int-to-float v2, p1

    invoke-virtual {p0}, Landroid/graphics/Picture;->getHeight()I

    move-result p1

    int-to-float v3, p1

    double-to-float v4, v0

    move v5, p3

    move v6, p4

    move v7, p5

    invoke-static/range {v2 .. v7}, Lorg/mapsforge/core/graphics/GraphicUtils;->imageSize(FFFIII)[F

    move-result-object p1

    const/4 p2, 0x0

    aget p3, p1, p2

    float-to-double p3, p3

    invoke-static {p3, p4}, Ljava/lang/Math;->ceil(D)D

    move-result-wide p3

    double-to-int p3, p3

    const/4 p4, 0x1

    aget p5, p1, p4

    float-to-double v0, p5

    invoke-static {v0, v1}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v0

    double-to-int p5, v0

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    invoke-static {p3, p5, v0}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object p3

    new-instance p5, Landroid/graphics/Canvas;

    invoke-direct {p5, p3}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    new-instance v0, Landroid/graphics/RectF;

    aget p2, p1, p2

    aget p1, p1, p4

    const/4 p4, 0x0

    invoke-direct {v0, p4, p4, p2, p1}, Landroid/graphics/RectF;-><init>(FFFF)V

    invoke-virtual {p5, p0, v0}, Landroid/graphics/Canvas;->drawPicture(Landroid/graphics/Picture;Landroid/graphics/RectF;)V
    :try_end_57
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_57} :catch_58

    return-object p3

    :catch_58
    move-exception p0

    new-instance p1, Ljava/io/IOException;

    invoke-direct {p1, p0}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    throw p1
.end method

.method private static getResourceBitmapImpl(Ljava/io/InputStream;IFIII)Landroid/graphics/Bitmap;
    .registers 15

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;->RESOURCE_BITMAPS:Ljava/util/Map;

    monitor-enter v0

    :try_start_3
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/util/Pair;

    const/4 v2, 0x1

    if-eqz v1, :cond_31

    new-instance p0, Landroid/util/Pair;

    iget-object p2, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    iget-object p3, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast p3, Ljava/lang/Integer;

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p3

    add-int/2addr p3, v2

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    invoke-direct {p0, p2, p3}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {v0, p1, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object p0, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast p0, Landroid/graphics/Bitmap;

    monitor-exit v0

    return-object p0

    :cond_31
    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->get(I)Landroid/graphics/Bitmap;

    move-result-object v1

    if-nez v1, :cond_45

    sget v5, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmap;->DEFAULT_SIZE:F

    move-object v3, p0

    move v4, p2

    move v6, p3

    move v7, p4

    move v8, p5

    invoke-static/range {v3 .. v8}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmap;->getResourceBitmap(Ljava/io/InputStream;FFIII)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-static {p1, v1}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->put(ILandroid/graphics/Bitmap;)V

    :cond_45
    new-instance p0, Landroid/util/Pair;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-direct {p0, v1, p2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {v0, p1, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit v0

    return-object v1

    :catchall_57
    move-exception p0

    monitor-exit v0
    :try_end_59
    .catchall {:try_start_3 .. :try_end_59} :catchall_57

    throw p0
.end method
