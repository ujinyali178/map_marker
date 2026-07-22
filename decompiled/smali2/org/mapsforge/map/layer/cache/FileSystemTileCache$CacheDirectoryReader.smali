.class Lorg/mapsforge/map/layer/cache/FileSystemTileCache$CacheDirectoryReader;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/layer/cache/FileSystemTileCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CacheDirectoryReader"
.end annotation


# instance fields
.field final synthetic this$0:Lorg/mapsforge/map/layer/cache/FileSystemTileCache;


# direct methods
.method private constructor <init>(Lorg/mapsforge/map/layer/cache/FileSystemTileCache;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/cache/FileSystemTileCache$CacheDirectoryReader;->this$0:Lorg/mapsforge/map/layer/cache/FileSystemTileCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lorg/mapsforge/map/layer/cache/FileSystemTileCache;Lorg/mapsforge/map/layer/cache/FileSystemTileCache$1;)V
    .registers 3

    invoke-direct {p0, p1}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache$CacheDirectoryReader;-><init>(Lorg/mapsforge/map/layer/cache/FileSystemTileCache;)V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 19

    move-object/from16 v1, p0

    iget-object v0, v1, Lorg/mapsforge/map/layer/cache/FileSystemTileCache$CacheDirectoryReader;->this$0:Lorg/mapsforge/map/layer/cache/FileSystemTileCache;

    # getter for: Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->cacheDirectory:Ljava/io/File;
    invoke-static {v0}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->access$000(Lorg/mapsforge/map/layer/cache/FileSystemTileCache;)Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v0

    if-eqz v0, :cond_d1

    array-length v2, v0

    const/4 v3, 0x0

    const/4 v4, 0x0

    :goto_11
    if-ge v4, v2, :cond_d1

    aget-object v5, v0, v4

    invoke-virtual {v5}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v6

    if-eqz v6, :cond_c5

    array-length v7, v6

    const/4 v8, 0x0

    :goto_1d
    if-ge v8, v7, :cond_c5

    aget-object v9, v6, v8

    invoke-virtual {v9}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v10

    if-eqz v10, :cond_b9

    array-length v11, v10

    const/4 v12, 0x0

    :goto_29
    if-ge v12, v11, :cond_b9

    aget-object v13, v10, v12

    # invokes: Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->isValidFile(Ljava/io/File;)Z
    invoke-static {v13}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->access$100(Ljava/io/File;)Z

    move-result v14

    if-eqz v14, :cond_ad

    invoke-virtual {v13}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v14

    const-string v15, ".tile"

    invoke-virtual {v14, v15}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_ad

    invoke-virtual {v13}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v14, v15}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v14

    invoke-virtual {v5}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v15

    move-object/from16 v16, v0

    invoke-virtual {v9}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v0

    move/from16 v17, v2

    invoke-virtual {v13}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v3, v14}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-static {v15, v0, v2}, Lorg/mapsforge/map/layer/queue/Job;->composeKey(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :try_start_5f
    iget-object v2, v1, Lorg/mapsforge/map/layer/cache/FileSystemTileCache$CacheDirectoryReader;->this$0:Lorg/mapsforge/map/layer/cache/FileSystemTileCache;

    # getter for: Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    invoke-static {v2}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->access$200(Lorg/mapsforge/map/layer/cache/FileSystemTileCache;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->lock()V

    iget-object v2, v1, Lorg/mapsforge/map/layer/cache/FileSystemTileCache$CacheDirectoryReader;->this$0:Lorg/mapsforge/map/layer/cache/FileSystemTileCache;

    # getter for: Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lruCache:Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;
    invoke-static {v2}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->access$300(Lorg/mapsforge/map/layer/cache/FileSystemTileCache;)Lorg/mapsforge/map/layer/cache/FileWorkingSetCache;

    move-result-object v2

    invoke-virtual {v2, v0, v13}, Ljava/util/AbstractMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_90

    # getter for: Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->LOGGER:Ljava/util/logging/Logger;
    invoke-static {}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->access$400()Ljava/util/logging/Logger;

    move-result-object v2

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "overwriting cached entry: "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v13, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V
    :try_end_90
    .catchall {:try_start_5f .. :try_end_90} :catchall_9e

    :cond_90
    iget-object v0, v1, Lorg/mapsforge/map/layer/cache/FileSystemTileCache$CacheDirectoryReader;->this$0:Lorg/mapsforge/map/layer/cache/FileSystemTileCache;

    # getter for: Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    invoke-static {v0}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->access$200(Lorg/mapsforge/map/layer/cache/FileSystemTileCache;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    goto :goto_b1

    :catchall_9e
    move-exception v0

    iget-object v2, v1, Lorg/mapsforge/map/layer/cache/FileSystemTileCache$CacheDirectoryReader;->this$0:Lorg/mapsforge/map/layer/cache/FileSystemTileCache;

    # getter for: Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    invoke-static {v2}, Lorg/mapsforge/map/layer/cache/FileSystemTileCache;->access$200(Lorg/mapsforge/map/layer/cache/FileSystemTileCache;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    throw v0

    :cond_ad
    move-object/from16 v16, v0

    move/from16 v17, v2

    :goto_b1
    add-int/lit8 v12, v12, 0x1

    move-object/from16 v0, v16

    move/from16 v2, v17

    goto/16 :goto_29

    :cond_b9
    move-object/from16 v16, v0

    move/from16 v17, v2

    add-int/lit8 v8, v8, 0x1

    move-object/from16 v0, v16

    move/from16 v2, v17

    goto/16 :goto_1d

    :cond_c5
    move-object/from16 v16, v0

    move/from16 v17, v2

    add-int/lit8 v4, v4, 0x1

    move-object/from16 v0, v16

    move/from16 v2, v17

    goto/16 :goto_11

    :cond_d1
    return-void
.end method
