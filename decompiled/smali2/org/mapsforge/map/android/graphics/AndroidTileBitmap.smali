.class public Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;
.super Lorg/mapsforge/map/android/graphics/AndroidBitmap;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/core/graphics/TileBitmap;


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;

.field private static reusableTileBitmaps:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "Ljava/util/Set<",
            "Ljava/lang/ref/SoftReference<",
            "Landroid/graphics/Bitmap;",
            ">;>;>;"
        }
    .end annotation
.end field

.field private static tileInstances:Ljava/util/concurrent/atomic/AtomicInteger;


# instance fields
.field private expiration:J

.field private timestamp:J


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->LOGGER:Ljava/util/logging/Logger;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->reusableTileBitmaps:Ljava/util/Map;

    return-void
.end method

.method constructor <init>(IZ)V
    .registers 5

    invoke-direct {p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;-><init>()V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->expiration:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->timestamp:J

    invoke-static {p1, p2}, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->getTileBitmapFromReusableSet(IZ)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    if-nez v0, :cond_22

    if-eqz p2, :cond_1a

    sget-object p2, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    goto :goto_1c

    :cond_1a
    sget-object p2, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->NON_TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    :goto_1c
    invoke-static {p1, p1, p2}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->createAndroidBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    :cond_22
    return-void
.end method

.method constructor <init>(Ljava/io/InputStream;IZ)V
    .registers 7

    invoke-direct {p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;-><init>()V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->expiration:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->timestamp:J

    const/4 v0, 0x0

    :try_start_e
    invoke-direct {p0, p2, p3}, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->createTileBitmapFactoryOptions(IZ)Landroid/graphics/BitmapFactory$Options;

    move-result-object p2

    invoke-static {p1, v0, p2}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object p2

    iput-object p2, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getWidth()I
    :try_end_1b
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_1b} :catch_1c

    return-void

    :catch_1c
    move-exception p2

    sget-object p3, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->LOGGER:Ljava/util/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "TILEBITMAP ERROR "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p3, v1}, Ljava/util/logging/Logger;->info(Ljava/lang/String;)V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    invoke-static {p1}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    invoke-virtual {p0}, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->destroy()V

    new-instance p1, Lorg/mapsforge/core/graphics/CorruptedInputStreamException;

    const-string p3, "Corrupted bitmap input stream"

    invoke-direct {p1, p3, p2}, Lorg/mapsforge/core/graphics/CorruptedInputStreamException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw p1
.end method

.method private static composeHash(IZ)I
    .registers 2

    if-eqz p1, :cond_5

    const/high16 p1, 0x10000000

    add-int/2addr p0, p1

    :cond_5
    return p0
.end method

.method private createTileBitmapFactoryOptions(IZ)Landroid/graphics/BitmapFactory$Options;
    .registers 5

    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    if-eqz p2, :cond_a

    sget-object v1, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    goto :goto_c

    :cond_a
    sget-object v1, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->NON_TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    :goto_c
    iput-object v1, v0, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    invoke-static {p1, p2}, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->getTileBitmapFromReusableSet(IZ)Landroid/graphics/Bitmap;

    move-result-object v1

    if-eqz v1, :cond_1f

    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inMutable:Z

    iput v1, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    invoke-static {p1, p2}, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->getTileBitmapFromReusableSet(IZ)Landroid/graphics/Bitmap;

    move-result-object p1

    iput-object p1, v0, Landroid/graphics/BitmapFactory$Options;->inBitmap:Landroid/graphics/Bitmap;

    :cond_1f
    return-object v0
.end method

.method private static getTileBitmapFromReusableSet(IZ)Landroid/graphics/Bitmap;
    .registers 6

    invoke-static {p0, p1}, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->composeHash(IZ)I

    move-result p0

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->reusableTileBitmaps:Ljava/util/Map;

    monitor-enter v0

    :try_start_7
    sget-object v1, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->reusableTileBitmaps:Ljava/util/Map;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/util/Set;

    const/4 v1, 0x0

    if-nez p0, :cond_18

    monitor-exit v0

    return-object v1

    :cond_18
    invoke-interface {p0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_1c
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_45

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/SoftReference;

    invoke-virtual {v2}, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/graphics/Bitmap;

    if-eqz v2, :cond_41

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->isMutable()Z

    move-result v3

    if-eqz v3, :cond_41

    if-eqz p1, :cond_3c

    const/4 p1, 0x0

    invoke-virtual {v2, p1}, Landroid/graphics/Bitmap;->eraseColor(I)V

    :cond_3c
    invoke-interface {p0}, Ljava/util/Iterator;->remove()V

    move-object v1, v2

    goto :goto_45

    :cond_41
    invoke-interface {p0}, Ljava/util/Iterator;->remove()V

    goto :goto_1c

    :cond_45
    :goto_45
    monitor-exit v0

    return-object v1

    :catchall_47
    move-exception p0

    monitor-exit v0
    :try_end_49
    .catchall {:try_start_7 .. :try_end_49} :catchall_47

    throw p0
.end method


# virtual methods
.method protected destroy()V
    .registers 1

    invoke-super {p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->destroy()V

    return-void
.end method

.method protected destroyBitmap()V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_4d

    invoke-virtual {p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->getHeight()I

    move-result v0

    sget-object v1, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->reusableTileBitmaps:Ljava/util/Map;

    monitor-enter v1

    :try_start_b
    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->hasAlpha()Z

    move-result v2

    invoke-static {v0, v2}, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->composeHash(IZ)I

    move-result v0

    sget-object v2, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->reusableTileBitmaps:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2f

    sget-object v2, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->reusableTileBitmaps:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4}, Ljava/util/HashSet;-><init>()V

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2f
    sget-object v2, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->reusableTileBitmaps:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    new-instance v2, Ljava/lang/ref/SoftReference;

    iget-object v3, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {v2, v3}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    monitor-exit v1
    :try_end_46
    .catchall {:try_start_b .. :try_end_46} :catchall_4a

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    goto :goto_4d

    :catchall_4a
    move-exception v0

    :try_start_4b
    monitor-exit v1
    :try_end_4c
    .catchall {:try_start_4b .. :try_end_4c} :catchall_4a

    throw v0

    :cond_4d
    :goto_4d
    return-void
.end method

.method public getTimestamp()J
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->timestamp:J

    return-wide v0
.end method

.method public isExpired()Z
    .registers 7

    iget-wide v0, p0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->expiration:J

    const/4 v2, 0x0

    const-wide/16 v3, 0x0

    cmp-long v5, v0, v3

    if-nez v5, :cond_a

    return v2

    :cond_a
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    cmp-long v5, v0, v3

    if-gtz v5, :cond_13

    const/4 v2, 0x1

    :cond_13
    return v2
.end method

.method public setExpiration(J)V
    .registers 3

    iput-wide p1, p0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->expiration:J

    return-void
.end method

.method public setTimestamp(J)V
    .registers 3

    iput-wide p1, p0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;->timestamp:J

    return-void
.end method
