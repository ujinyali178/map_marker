.class public Lorg/mapsforge/map/android/graphics/AndroidBitmap;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/core/graphics/Bitmap;


# static fields
.field private static final BITMAP_INSTANCES:Ljava/util/concurrent/atomic/AtomicInteger;

.field private static final BITMAP_LIST:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/map/android/graphics/AndroidBitmap;",
            ">;"
        }
    .end annotation
.end field

.field private static final LOGGER:Ljava/util/logging/Logger;

.field private static final REUSABLE_BITMAPS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/ref/SoftReference<",
            "Landroid/graphics/Bitmap;",
            ">;>;"
        }
    .end annotation
.end field


# instance fields
.field protected bitmap:Landroid/graphics/Bitmap;

.field private refCount:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->LOGGER:Ljava/util/logging/Logger;

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->REUSABLE_BITMAPS:Ljava/util/Set;

    const/4 v0, 0x0

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->BITMAP_LIST:Ljava/util/List;

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->BITMAP_INSTANCES:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method

.method protected constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->refCount:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method

.method constructor <init>(IILandroid/graphics/Bitmap$Config;)V
    .registers 5

    invoke-direct {p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;-><init>()V

    invoke-virtual {p0, p1, p2, p3}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->getBitmapFromReusableSet(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    if-nez v0, :cond_11

    invoke-static {p1, p2, p3}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->createAndroidBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    :cond_11
    return-void
.end method

.method public constructor <init>(Landroid/graphics/Bitmap;)V
    .registers 3

    invoke-direct {p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;-><init>()V

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-nez v0, :cond_c

    iput-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    return-void

    :cond_c
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "bitmap is already recycled"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method protected static createAndroidBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    .registers 3

    invoke-static {p0, p1, p2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method protected static final createBitmapFactoryOptions(Landroid/graphics/Bitmap$Config;)Landroid/graphics/BitmapFactory$Options;
    .registers 2

    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    iput-object p0, v0, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    return-object v0
.end method


# virtual methods
.method protected final canUseBitmap(Landroid/graphics/Bitmap;II)Z
    .registers 5

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    if-ne v0, p2, :cond_e

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result p1

    if-ne p1, p3, :cond_e

    const/4 p1, 0x1

    return p1

    :cond_e
    const/4 p1, 0x0

    return p1
.end method

.method public compress(Ljava/io/OutputStream;)V
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    sget-object v1, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p1}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    move-result p1

    if-eqz p1, :cond_c

    return-void

    :cond_c
    new-instance p1, Ljava/io/IOException;

    const-string v0, "Failed to write bitmap to output stream"

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public decrementRefCount()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->refCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    move-result v0

    if-gez v0, :cond_b

    invoke-virtual {p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->destroy()V

    :cond_b
    return-void
.end method

.method protected destroy()V
    .registers 1

    invoke-virtual {p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->destroyBitmap()V

    return-void
.end method

.method protected destroyBitmap()V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_19

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->REUSABLE_BITMAPS:Ljava/util/Set;

    monitor-enter v0

    :try_start_7
    new-instance v1, Ljava/lang/ref/SoftReference;

    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {v1, v2}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    monitor-exit v0
    :try_end_12
    .catchall {:try_start_7 .. :try_end_12} :catchall_16

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    goto :goto_19

    :catchall_16
    move-exception v1

    :try_start_17
    monitor-exit v0
    :try_end_18
    .catchall {:try_start_17 .. :try_end_18} :catchall_16

    throw v1

    :cond_19
    :goto_19
    return-void
.end method

.method protected final getBitmapFromReusableSet(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    .registers 8

    sget-object p3, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->REUSABLE_BITMAPS:Ljava/util/Set;

    const/4 v0, 0x0

    if-eqz p3, :cond_3e

    invoke-interface {p3}, Ljava/util/Set;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3e

    monitor-enter p3

    :try_start_c
    invoke-interface {p3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_10
    :goto_10
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_39

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/SoftReference;

    invoke-virtual {v2}, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/graphics/Bitmap;

    if-eqz v2, :cond_35

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->isMutable()Z

    move-result v3

    if-eqz v3, :cond_35

    invoke-virtual {p0, v2, p1, p2}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->canUseBitmap(Landroid/graphics/Bitmap;II)Z

    move-result v3

    if-eqz v3, :cond_10

    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    move-object v0, v2

    goto :goto_39

    :cond_35
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_10

    :cond_39
    :goto_39
    monitor-exit p3

    goto :goto_3e

    :catchall_3b
    move-exception p1

    monitor-exit p3
    :try_end_3d
    .catchall {:try_start_c .. :try_end_3d} :catchall_3b

    throw p1

    :cond_3e
    :goto_3e
    return-object v0
.end method

.method public getHeight()I
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    return v0
.end method

.method public getWidth()I
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    return v0
.end method

.method public incrementRefCount()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->refCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    return-void
.end method

.method public isDestroyed()Z
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    if-nez v0, :cond_6

    const/4 v0, 0x1

    goto :goto_7

    :cond_6
    const/4 v0, 0x0

    :goto_7
    return v0
.end method

.method public scaleTo(II)V
    .registers 5

    invoke-virtual {p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->getWidth()I

    move-result v0

    if-ne v0, p1, :cond_c

    invoke-virtual {p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->getHeight()I

    move-result v0

    if-eq v0, p2, :cond_18

    :cond_c
    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    const/4 v1, 0x1

    invoke-static {v0, p1, p2, v1}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object p1

    invoke-virtual {p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->destroy()V

    iput-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    :cond_18
    return-void
.end method

.method public setBackgroundColor(I)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0, p1}, Landroid/graphics/Bitmap;->eraseColor(I)V

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_10

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->hasAlpha()Z

    move-result v0

    if-eqz v0, :cond_d

    const-string v0, " has alpha"

    goto :goto_12

    :cond_d
    const-string v0, " no alpha"

    goto :goto_12

    :cond_10
    const-string v0, " is recycled"

    :goto_12
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, " rC "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->refCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
