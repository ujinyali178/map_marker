.class public Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;
.super Lorg/mapsforge/map/android/graphics/AndroidBitmap;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/core/graphics/ResourceBitmap;


# static fields
.field protected static final LOGGER:Ljava/util/logging/Logger;

.field protected static final RESOURCE_BITMAPS:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "Landroid/util/Pair<",
            "Landroid/graphics/Bitmap;",
            "Ljava/lang/Integer;",
            ">;>;"
        }
    .end annotation
.end field

.field protected static rBitmaps:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field protected static rInstances:Ljava/util/concurrent/atomic/AtomicInteger;


# instance fields
.field private final hash:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;->LOGGER:Ljava/util/logging/Logger;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;->RESOURCE_BITMAPS:Ljava/util/Map;

    return-void
.end method

.method protected constructor <init>(I)V
    .registers 2

    invoke-direct {p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;-><init>()V

    iput p1, p0, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;->hash:I

    return-void
.end method

.method constructor <init>(Ljava/io/InputStream;FIIII)V
    .registers 7

    invoke-direct {p0, p6}, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;-><init>(I)V

    invoke-static/range {p1 .. p6}, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;->getResourceBitmap(Ljava/io/InputStream;FIIII)Landroid/graphics/Bitmap;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    return-void
.end method

.method public static clearResourceBitmaps()V
    .registers 3

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;->RESOURCE_BITMAPS:Ljava/util/Map;

    monitor-enter v0

    :try_start_3
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1f

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/util/Pair;

    iget-object v2, v2, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->recycle()V

    goto :goto_b

    :cond_1f
    sget-object v1, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;->RESOURCE_BITMAPS:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->clear()V

    monitor-exit v0

    return-void

    :catchall_26
    move-exception v1

    monitor-exit v0
    :try_end_28
    .catchall {:try_start_3 .. :try_end_28} :catchall_26

    throw v1
.end method

.method private static getResourceBitmap(Ljava/io/InputStream;FIIII)Landroid/graphics/Bitmap;
    .registers 15

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;->RESOURCE_BITMAPS:Ljava/util/Map;

    monitor-enter v0

    :try_start_3
    invoke-static {p5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/util/Pair;

    const/4 v2, 0x1

    if-eqz v1, :cond_31

    new-instance p0, Landroid/util/Pair;

    iget-object p1, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    iget-object p2, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast p2, Ljava/lang/Integer;

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result p2

    add-int/2addr p2, v2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-direct {p0, p1, p2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-static {p5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {v0, p1, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object p0, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast p0, Landroid/graphics/Bitmap;

    monitor-exit v0

    return-object p0

    :cond_31
    const/4 v1, 0x0

    sget-object v3, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    invoke-static {v3}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->createBitmapFactoryOptions(Landroid/graphics/Bitmap$Config;)Landroid/graphics/BitmapFactory$Options;

    move-result-object v3

    invoke-static {p0, v1, v3}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object p0

    if-eqz p0, :cond_7f

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    int-to-float v3, v1

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    int-to-float v4, v1

    move v5, p1

    move v6, p2

    move v7, p3

    move v8, p4

    invoke-static/range {v3 .. v8}, Lorg/mapsforge/core/graphics/GraphicUtils;->imageSize(FFFIII)[F

    move-result-object p1

    const/4 p2, 0x0

    aget p3, p1, p2

    float-to-int p3, p3

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result p4

    if-ne p3, p4, :cond_63

    aget p3, p1, v2

    float-to-int p3, p3

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result p4

    if-eq p3, p4, :cond_6d

    :cond_63
    aget p2, p1, p2

    float-to-int p2, p2

    aget p1, p1, v2

    float-to-int p1, p1

    invoke-static {p0, p2, p1, v2}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object p0

    :cond_6d
    new-instance p1, Landroid/util/Pair;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-direct {p1, p0, p2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-static {p5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-interface {v0, p2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit v0

    return-object p0

    :cond_7f
    new-instance p0, Ljava/io/IOException;

    const-string p1, "BitmapFactory failed to decodeStream"

    invoke-direct {p0, p1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p0

    :catchall_87
    move-exception p0

    monitor-exit v0
    :try_end_89
    .catchall {:try_start_3 .. :try_end_89} :catchall_87

    throw p0
.end method

.method private static removeBitmap(I)Z
    .registers 1

    const/4 p0, 0x0

    return p0
.end method


# virtual methods
.method protected destroyBitmap()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_14

    iget v0, p0, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;->hash:I

    invoke-static {v0}, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;->removeBitmap(I)Z

    move-result v0

    if-eqz v0, :cond_11

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    :cond_11
    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    :cond_14
    return-void
.end method
