.class Lorg/mapsforge/map/view/FrameBufferBitmap;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;,
        Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;
    }
.end annotation


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;


# instance fields
.field private bitmap:Lorg/mapsforge/core/graphics/Bitmap;

.field private bitmapRequest:Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;

.field private final bitmapRequestSync:Ljava/lang/Object;

.field private final frameLock:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/view/FrameBufferBitmap;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/view/FrameBufferBitmap;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iput-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmapRequest:Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmapRequestSync:Ljava/lang/Object;

    new-instance v0, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    invoke-direct {v0}, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->frameLock:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    return-void
.end method

.method static synthetic access$000()Ljava/util/logging/Logger;
    .registers 1

    sget-object v0, Lorg/mapsforge/map/view/FrameBufferBitmap;->LOGGER:Ljava/util/logging/Logger;

    return-object v0
.end method

.method private createBitmapIfRequested()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmapRequestSync:Ljava/lang/Object;

    monitor-enter v0

    :try_start_3
    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmapRequest:Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;

    if-eqz v1, :cond_15

    invoke-direct {p0}, Lorg/mapsforge/map/view/FrameBufferBitmap;->destroyBitmap()V

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmapRequest:Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;

    invoke-virtual {v1}, Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;->create()Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v1

    iput-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    const/4 v1, 0x0

    iput-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmapRequest:Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;

    :cond_15
    monitor-exit v0

    return-void

    :catchall_17
    move-exception v1

    monitor-exit v0
    :try_end_19
    .catchall {:try_start_3 .. :try_end_19} :catchall_17

    throw v1
.end method

.method private destroyBitmap()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v0, :cond_a

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    :cond_a
    return-void
.end method

.method static swap(Lorg/mapsforge/map/view/FrameBufferBitmap;Lorg/mapsforge/map/view/FrameBufferBitmap;)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iget-object v1, p1, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iput-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iput-object v0, p1, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmapRequest:Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;

    iget-object v1, p1, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmapRequest:Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;

    iput-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmapRequest:Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;

    iput-object v0, p1, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmapRequest:Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;

    return-void
.end method


# virtual methods
.method create(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/core/model/Dimension;IZ)V
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmapRequestSync:Ljava/lang/Object;

    monitor-enter v0

    :try_start_3
    new-instance v1, Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;

    invoke-direct {v1, p1, p2, p3, p4}, Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/core/model/Dimension;IZ)V

    iput-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmapRequest:Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;

    monitor-exit v0

    return-void

    :catchall_c
    move-exception p1

    monitor-exit v0
    :try_end_e
    .catchall {:try_start_3 .. :try_end_e} :catchall_c

    throw p1
.end method

.method destroy()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->frameLock:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    monitor-enter v0

    :try_start_3
    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v1, :cond_f

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->frameLock:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    invoke-virtual {v1}, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->waitDisabled()V

    invoke-direct {p0}, Lorg/mapsforge/map/view/FrameBufferBitmap;->destroyBitmap()V

    :cond_f
    monitor-exit v0

    return-void

    :catchall_11
    move-exception v1

    monitor-exit v0
    :try_end_13
    .catchall {:try_start_3 .. :try_end_13} :catchall_11

    throw v1
.end method

.method lock()Lorg/mapsforge/core/graphics/Bitmap;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->frameLock:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    monitor-enter v0

    :try_start_3
    invoke-direct {p0}, Lorg/mapsforge/map/view/FrameBufferBitmap;->createBitmapIfRequested()V

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    if-eqz v1, :cond_f

    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->frameLock:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    invoke-virtual {v1}, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->enable()V

    :cond_f
    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->bitmap:Lorg/mapsforge/core/graphics/Bitmap;

    monitor-exit v0

    return-object v1

    :catchall_13
    move-exception v1

    monitor-exit v0
    :try_end_15
    .catchall {:try_start_3 .. :try_end_15} :catchall_13

    throw v1
.end method

.method release()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->frameLock:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    monitor-enter v0

    :try_start_3
    iget-object v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap;->frameLock:Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;

    invoke-virtual {v1}, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->disable()V

    monitor-exit v0

    return-void

    :catchall_a
    move-exception v1

    monitor-exit v0
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_a

    throw v1
.end method
