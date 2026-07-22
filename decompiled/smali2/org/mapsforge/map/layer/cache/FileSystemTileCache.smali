.class public Lorg/mapsforge/map/layer/cache/FileSystemTileCache;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/cache/TileCache;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/layer/cache/FileSystemTileCache$CacheDirectoryReader;
    }
.end annotation


# static fields
.field static final FILE_EXTENSION:Ljava/lang/String; = ".tile"

.field private static final LOGGER:Ljava/util/logging/Logger;


# instance fields
.field private final cacheDirectory:Ljava/io/File;

.field private final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field private final lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

.field private lruCache:Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/mapsforge/map/layer/cache/FileWorkingSetCache<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final observable:Lorg/mapsforge/map/model/common/Observable;

.field private final persistent:Z


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method public constructor <init>(ILjava/io/File;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 5

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;-><init>(ILjava/io/File;Lorg/mapsforge/core/graphics/GraphicFactory;Z)V

    return-void
.end method

.method public constructor <init>(ILjava/io/File;Lorg/mapsforge/core/graphics/GraphicFactory;Z)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lorg/mapsforge/map/model/common/Observable;

    invoke-direct {v0}, Lorg/mapsforge/map/model/common/Observable;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->observable:Lorg/mapsforge/map/model/common/Observable;

    iput-boolean p4, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->persistent:Z

    new-instance v0, Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;

    invoke-direct {v0, p1}, Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;-><init>(I)V

    iput-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;

    new-instance p1, Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-direct {p1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-static {p2}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->isValidCacheDirectory(Ljava/io/File;)Z

    move-result p1

    const/4 v0, 0x0

    if-eqz p1, :cond_33

    iput-object p2, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->cacheDirectory:Ljava/io/File;

    if-eqz p4, :cond_35

    new-instance p1, Ljava/lang/Thread;

    new-instance p2, Lorg/mapsforge/map/layer/cache/FileSystemTileCache$CacheDirectoryReader;

    invoke-direct {p2, p0, v0}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache$CacheDirectoryReader;-><init>(Lorg/mapsforge/map/layer/cache/FileSystemTileCache;Lorg/mapsforge/map/layer/cache/FileSystemTileCache$1;)V

    invoke-direct {p1, p2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {p1}, Ljava/lang/Thread;->start()V

    goto :goto_35

    :cond_33
    iput-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->cacheDirectory:Ljava/io/File;

    :cond_35
    :goto_35
    iput-object p3, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    return-void
.end method

.method static synthetic access$000(Lorg/mapsforge/map/layer/cache/FileSystemTileCache;)Ljava/io/File;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->cacheDirectory:Ljava/io/File;

    return-object p0
.end method

.method static synthetic access$100(Ljava/io/File;)Z
    .registers 1

    invoke-static {p0}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->isValidFile(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method static synthetic access$200(Lorg/mapsforge/map/layer/cache/FileSystemTileCache;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    return-object p0
.end method

.method static synthetic access$300(Lorg/mapsforge/map/layer/cache/FileSystemTileCache;)Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;

    return-object p0
.end method

.method static synthetic access$400()Ljava/util/logging/Logger;
    .registers 1

    sget-object v0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->LOGGER:Ljava/util/logging/Logger;

    return-object v0
.end method

.method private static deleteDirectory(Ljava/io/File;)Z
    .registers 6

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return v0

    :cond_4
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v1

    if-eqz v1, :cond_25

    invoke-virtual {p0}, Ljava/io/File;->list()[Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_25

    const/4 v2, 0x0

    :goto_11
    array-length v3, v1

    if-ge v2, v3, :cond_25

    new-instance v3, Ljava/io/File;

    aget-object v4, v1, v2

    invoke-direct {v3, p0, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-static {v3}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->deleteDirectory(Ljava/io/File;)Z

    move-result v3

    if-nez v3, :cond_22

    return v0

    :cond_22
    add-int/lit8 v2, v2, 0x1

    goto :goto_11

    :cond_25
    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result p0

    return p0
.end method

.method private getOutputFile(Lorg/mapsforge/map/layer/queue/Job;)Ljava/io/File;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->cacheDirectory:Ljava/io/File;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/queue/Job;->getKey()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    sget-char v0, Ljava/io/File;->separatorChar:C

    invoke-virtual {p1, v0}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p1, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->isValidCacheDirectory(Ljava/io/File;)Z

    move-result v0

    if-eqz v0, :cond_47

    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, ".tile"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    return-object v0

    :cond_47
    const/4 p1, 0x0

    return-object p1
.end method

.method private static isValidCacheDirectory(Ljava/io/File;)Z
    .registers 2

    if-eqz p0, :cond_22

    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_e

    invoke-virtual {p0}, Ljava/io/File;->mkdirs()Z

    move-result v0

    if-eqz v0, :cond_22

    :cond_e
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_22

    invoke-virtual {p0}, Ljava/io/File;->canRead()Z

    move-result v0

    if-eqz v0, :cond_22

    invoke-virtual {p0}, Ljava/io/File;->canWrite()Z

    move-result p0

    if-eqz p0, :cond_22

    const/4 p0, 0x1

    goto :goto_23

    :cond_22
    const/4 p0, 0x0

    :goto_23
    return p0
.end method

.method private static isValidFile(Ljava/io/File;)Z
    .registers 2

    if-eqz p0, :cond_10

    invoke-virtual {p0}, Ljava/io/File;->isFile()Z

    move-result v0

    if-eqz v0, :cond_10

    invoke-virtual {p0}, Ljava/io/File;->canRead()Z

    move-result p0

    if-eqz p0, :cond_10

    const/4 p0, 0x1

    goto :goto_11

    :cond_10
    const/4 p0, 0x0

    :goto_11
    return p0
.end method

.method private remove(Lorg/mapsforge/map/layer/queue/Job;)V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->lock()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/queue/Job;->getKey()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/util/AbstractMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_12
    .catchall {:try_start_0 .. :try_end_12} :catchall_1c

    iget-object p1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {p1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object p1

    invoke-virtual {p1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    return-void

    :catchall_1c
    move-exception p1

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    throw p1
.end method

.method private storeData(Lorg/mapsforge/map/layer/queue/Job;Lorg/mapsforge/core/graphics/TileBitmap;)V
    .registers 6

    const/4 v0, 0x0

    :try_start_1
    invoke-direct {p0, p1}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->getOutputFile(Lorg/mapsforge/map/layer/queue/Job;)Ljava/io/File;

    move-result-object v1
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_5} :catch_62
    .catchall {:try_start_1 .. :try_end_5} :catchall_60

    if-nez v1, :cond_b

    invoke-static {v0}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    return-void

    :cond_b
    :try_start_b
    new-instance v2, Ljava/io/FileOutputStream;

    invoke-direct {v2, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_10} :catch_62
    .catchall {:try_start_b .. :try_end_10} :catchall_60

    :try_start_10
    invoke-interface {p2, v2}, Lorg/mapsforge/core/graphics/Bitmap;->compress(Ljava/io/OutputStream;)V
    :try_end_13
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_13} :catch_5d
    .catchall {:try_start_10 .. :try_end_13} :catchall_5a

    :try_start_13
    iget-object p2, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {p2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object p2

    invoke-virtual {p2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->lock()V

    iget-object p2, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/queue/Job;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0, v1}, Ljava/util/AbstractMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    if-eqz p2, :cond_42

    sget-object p2, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->LOGGER:Ljava/util/logging/Logger;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "overwriting cached entry: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/queue/Job;->getKey()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p2, p1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V
    :try_end_42
    .catchall {:try_start_13 .. :try_end_42} :catchall_4f

    :cond_42
    :try_start_42
    iget-object p1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {p1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object p1

    invoke-virtual {p1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V
    :try_end_4b
    .catch Ljava/lang/Exception; {:try_start_42 .. :try_end_4b} :catch_5d
    .catchall {:try_start_42 .. :try_end_4b} :catchall_5a

    invoke-static {v2}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    goto :goto_8c

    :catchall_4f
    move-exception p1

    :try_start_50
    iget-object p2, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {p2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object p2

    invoke-virtual {p2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    throw p1
    :try_end_5a
    .catch Ljava/lang/Exception; {:try_start_50 .. :try_end_5a} :catch_5d
    .catchall {:try_start_50 .. :try_end_5a} :catchall_5a

    :catchall_5a
    move-exception p1

    move-object v0, v2

    goto :goto_98

    :catch_5d
    move-exception p1

    move-object v0, v2

    goto :goto_63

    :catchall_60
    move-exception p1

    goto :goto_98

    :catch_62
    move-exception p1

    :goto_63
    :try_start_63
    sget-object p2, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->LOGGER:Ljava/util/logging/Logger;

    sget-object v1, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    const-string v2, "Disabling filesystem cache"

    invoke-virtual {p2, v1, v2, p1}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->destroy()V
    :try_end_6f
    .catchall {:try_start_63 .. :try_end_6f} :catchall_60

    :try_start_6f
    iget-object p1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {p1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object p1

    invoke-virtual {p1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->lock()V

    new-instance p1, Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;

    const/4 p2, 0x0

    invoke-direct {p1, p2}, Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;-><init>(I)V

    iput-object p1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;
    :try_end_80
    .catchall {:try_start_6f .. :try_end_80} :catchall_8d

    :try_start_80
    iget-object p1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {p1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object p1

    invoke-virtual {p1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V
    :try_end_89
    .catchall {:try_start_80 .. :try_end_89} :catchall_60

    invoke-static {v0}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    :goto_8c
    return-void

    :catchall_8d
    move-exception p1

    :try_start_8e
    iget-object p2, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {p2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object p2

    invoke-virtual {p2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    throw p1
    :try_end_98
    .catchall {:try_start_8e .. :try_end_98} :catchall_60

    :goto_98
    invoke-static {v0}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    throw p1
.end method


# virtual methods
.method public addObserver(Lorg/mapsforge/map/model/common/Observer;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->observable:Lorg/mapsforge/map/model/common/Observable;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/model/common/Observable;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-void
.end method

.method public containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z
    .registers 3

    :try_start_0
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->lock()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/queue/Job;->getKey()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/util/AbstractMap;->containsKey(Ljava/lang/Object;)Z

    move-result p1
    :try_end_13
    .catchall {:try_start_0 .. :try_end_13} :catchall_1d

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    return p1

    :catchall_1d
    move-exception p1

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    throw p1
.end method

.method public destroy()V
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->persistent:Z

    if-nez v0, :cond_7

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->purge()V

    :cond_7
    return-void
.end method

.method public get(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 11

    :try_start_0
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->lock()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/queue/Job;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/AbstractMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/io/File;
    :try_end_15
    .catchall {:try_start_0 .. :try_end_15} :catchall_8f

    iget-object v1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    const/4 v1, 0x0

    if-nez v0, :cond_22

    return-object v1

    :cond_22
    :try_start_22
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, v0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_27
    .catch Lorg/mapsforge/core/graphics/CorruptedInputStreamException; {:try_start_22 .. :try_end_27} :catch_58
    .catch Ljava/io/IOException; {:try_start_22 .. :try_end_27} :catch_44
    .catchall {:try_start_22 .. :try_end_27} :catchall_42

    :try_start_27
    iget-object v3, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v4, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget v4, v4, Lorg/mapsforge/core/model/Tile;->tileSize:I

    iget-boolean v5, p1, Lorg/mapsforge/map/layer/queue/Job;->hasAlpha:Z

    invoke-interface {v3, v2, v4, v5}, Lorg/mapsforge/core/graphics/GraphicFactory;->createTileBitmap(Ljava/io/InputStream;IZ)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object v3

    invoke-virtual {v0}, Ljava/io/File;->lastModified()J

    move-result-wide v4

    invoke-interface {v3, v4, v5}, Lorg/mapsforge/core/graphics/TileBitmap;->setTimestamp(J)V
    :try_end_3a
    .catch Lorg/mapsforge/core/graphics/CorruptedInputStreamException; {:try_start_27 .. :try_end_3a} :catch_40
    .catch Ljava/io/IOException; {:try_start_27 .. :try_end_3a} :catch_3e
    .catchall {:try_start_27 .. :try_end_3a} :catchall_89

    invoke-static {v2}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    return-object v3

    :catch_3e
    move-exception v0

    goto :goto_46

    :catch_40
    move-exception v3

    goto :goto_5a

    :catchall_42
    move-exception p1

    goto :goto_8b

    :catch_44
    move-exception v0

    move-object v2, v1

    :goto_46
    :try_start_46
    invoke-direct {p0, p1}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->remove(Lorg/mapsforge/map/layer/queue/Job;)V

    sget-object p1, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->LOGGER:Ljava/util/logging/Logger;

    sget-object v3, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4, v0}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_54
    .catchall {:try_start_46 .. :try_end_54} :catchall_89

    invoke-static {v2}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    return-object v1

    :catch_58
    move-exception v3

    move-object v2, v1

    :goto_5a
    :try_start_5a
    invoke-direct {p0, p1}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->remove(Lorg/mapsforge/map/layer/queue/Job;)V

    sget-object v4, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->LOGGER:Ljava/util/logging/Logger;

    sget-object v5, Ljava/util/logging/Level;->WARNING:Ljava/util/logging/Level;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "input stream from file system cache invalid "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/queue/Job;->getKey()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, " "

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v7

    invoke-virtual {v6, v7, v8}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v4, v5, p1, v3}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_85
    .catchall {:try_start_5a .. :try_end_85} :catchall_89

    invoke-static {v2}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    return-object v1

    :catchall_89
    move-exception p1

    move-object v1, v2

    :goto_8b
    invoke-static {v1}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    throw p1

    :catchall_8f
    move-exception p1

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    throw p1
.end method

.method public getCapacity()I
    .registers 3

    :try_start_0
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->lock()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;

    iget v0, v0, Lorg/mapsforge/core/util/LRUCache;->capacity:I
    :try_end_d
    .catchall {:try_start_0 .. :try_end_d} :catchall_17

    iget-object v1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    return v0

    :catchall_17
    move-exception v0

    iget-object v1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    throw v0
.end method

.method public getCapacityFirstLevel()I
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->getCapacity()I

    move-result v0

    return v0
.end method

.method public getImmediately(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 2

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->get(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object p1

    return-object p1
.end method

.method public isPersistent()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->persistent:Z

    return v0
.end method

.method public purge()V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->lock()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;

    invoke-virtual {v0}, Ljava/util/AbstractMap;->clear()V
    :try_end_e
    .catchall {:try_start_0 .. :try_end_e} :catchall_1d

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->cacheDirectory:Ljava/io/File;

    invoke-static {v0}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->deleteDirectory(Ljava/io/File;)Z

    return-void

    :catchall_1d
    move-exception v0

    iget-object v1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    throw v0
.end method

.method public put(Lorg/mapsforge/map/layer/queue/Job;Lorg/mapsforge/core/graphics/TileBitmap;)V
    .registers 4

    if-eqz p1, :cond_1c

    if-eqz p2, :cond_14

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->getCapacity()I

    move-result v0

    if-nez v0, :cond_b

    return-void

    :cond_b
    invoke-direct {p0, p1, p2}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->storeData(Lorg/mapsforge/map/layer/queue/Job;Lorg/mapsforge/core/graphics/TileBitmap;)V

    iget-object p1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->observable:Lorg/mapsforge/map/model/common/Observable;

    invoke-virtual {p1}, Lorg/mapsforge/map/model/common/Observable;->notifyObservers()V

    return-void

    :cond_14
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "bitmap must not be null"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_1c
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "key must not be null"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public removeObserver(Lorg/mapsforge/map/model/common/Observer;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->observable:Lorg/mapsforge/map/model/common/Observable;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/model/common/Observable;->removeObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-void
.end method

.method public setWorkingSet(Ljava/util/Set;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set<",
            "Lorg/mapsforge/map/layer/queue/Job;",
            ">;)V"
        }
    .end annotation

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    monitor-enter p1

    :try_start_6
    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_a
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1e

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/layer/queue/Job;

    invoke-virtual {v2}, Lorg/mapsforge/map/layer/queue/Job;->getKey()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_a

    :cond_1e
    monitor-exit p1
    :try_end_1f
    .catchall {:try_start_6 .. :try_end_1f} :catchall_25

    iget-object p1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;

    invoke-virtual {p1, v0}, Lorg/mapsforge/core/util/WorkingSetCache;->setWorkingSet(Ljava/util/Set;)V

    return-void

    :catchall_25
    move-exception v0

    :try_start_26
    monitor-exit p1
    :try_end_27
    .catchall {:try_start_26 .. :try_end_27} :catchall_25

    throw v0
.end method
