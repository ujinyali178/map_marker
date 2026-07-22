.class public Lorg/mapsforge/map/layer/cache/TileStore;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/cache/TileCache;


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;


# instance fields
.field private final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field private final rootDirectory:Ljava/io/File;

.field private final suffix:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/layer/cache/TileStore;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/layer/cache/TileStore;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Ljava/lang/String;Lorg/mapsforge/core/graphics/GraphicFactory;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/cache/TileStore;->rootDirectory:Ljava/io/File;

    iput-object p3, p0, Lorg/mapsforge/map/layer/cache/TileStore;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iput-object p2, p0, Lorg/mapsforge/map/layer/cache/TileStore;->suffix:Ljava/lang/String;

    if-eqz p1, :cond_18

    invoke-virtual {p1}, Ljava/io/File;->isDirectory()Z

    move-result p2

    if-eqz p2, :cond_18

    invoke-virtual {p1}, Ljava/io/File;->canRead()Z

    move-result p1

    if-eqz p1, :cond_18

    return-void

    :cond_18
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "Root directory must be readable"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method


# virtual methods
.method public addObserver(Lorg/mapsforge/map/model/common/Observer;)V
    .registers 2

    return-void
.end method

.method public declared-synchronized containsKey(Lorg/mapsforge/map/layer/queue/Job;)Z
    .registers 2

    monitor-enter p0

    :try_start_1
    invoke-virtual {p0, p1}, Lorg/mapsforge/map/layer/cache/TileStore;->findFile(Lorg/mapsforge/map/layer/queue/Job;)Ljava/io/File;

    move-result-object p1
    :try_end_5
    .catchall {:try_start_1 .. :try_end_5} :catchall_c

    if-eqz p1, :cond_9

    const/4 p1, 0x1

    goto :goto_a

    :cond_9
    const/4 p1, 0x0

    :goto_a
    monitor-exit p0

    return p1

    :catchall_c
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized destroy()V
    .registers 1

    monitor-enter p0

    monitor-exit p0

    return-void
.end method

.method protected findFile(Lorg/mapsforge/map/layer/queue/Job;)Ljava/io/File;
    .registers 8

    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lorg/mapsforge/map/layer/cache/TileStore;->rootDirectory:Ljava/io/File;

    iget-object v2, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v2, v2, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-static {v2}, Ljava/lang/Byte;->toString(B)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->isDirectory()Z

    move-result v1

    const-string v2, "Failed to find directory "

    const/4 v3, 0x0

    if-eqz v1, :cond_b3

    invoke-virtual {v0}, Ljava/io/File;->canRead()Z

    move-result v1

    if-nez v1, :cond_20

    goto/16 :goto_b3

    :cond_20
    new-instance v1, Ljava/io/File;

    iget-object v4, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget v4, v4, Lorg/mapsforge/core/model/Tile;->tileX:I

    int-to-long v4, v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v0, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_9d

    invoke-virtual {v1}, Ljava/io/File;->canRead()Z

    move-result v0

    if-nez v0, :cond_3b

    goto :goto_9d

    :cond_3b
    new-instance v0, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object p1, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget p1, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    int-to-long v4, p1

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object p1, p0, Lorg/mapsforge/map/layer/cache/TileStore;->suffix:Ljava/lang/String;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, v1, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->isFile()Z

    move-result p1

    if-eqz p1, :cond_82

    invoke-virtual {v0}, Ljava/io/File;->canRead()Z

    move-result p1

    if-nez p1, :cond_67

    goto :goto_82

    :cond_67
    sget-object p1, Lorg/mapsforge/map/layer/cache/TileStore;->LOGGER:Ljava/util/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Found file "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/util/logging/Logger;->info(Ljava/lang/String;)V

    return-object v0

    :cond_82
    :goto_82
    sget-object p1, Lorg/mapsforge/map/layer/cache/TileStore;->LOGGER:Ljava/util/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to find file "

    :goto_8b
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_99
    invoke-virtual {p1, v0}, Ljava/util/logging/Logger;->info(Ljava/lang/String;)V

    return-object v3

    :cond_9d
    :goto_9d
    sget-object p1, Lorg/mapsforge/map/layer/cache/TileStore;->LOGGER:Ljava/util/logging/Logger;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_99

    :cond_b3
    :goto_b3
    sget-object p1, Lorg/mapsforge/map/layer/cache/TileStore;->LOGGER:Ljava/util/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    goto :goto_8b
.end method

.method public declared-synchronized get(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 7

    monitor-enter p0

    :try_start_1
    invoke-virtual {p0, p1}, Lorg/mapsforge/map/layer/cache/TileStore;->findFile(Lorg/mapsforge/map/layer/queue/Job;)Ljava/io/File;

    move-result-object v0
    :try_end_5
    .catchall {:try_start_1 .. :try_end_5} :catchall_4f

    const/4 v1, 0x0

    if-nez v0, :cond_a

    monitor-exit p0

    return-object v1

    :cond_a
    :try_start_a
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, v0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_f
    .catch Lorg/mapsforge/core/graphics/CorruptedInputStreamException; {:try_start_a .. :try_end_f} :catch_49
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_f} :catch_43
    .catchall {:try_start_a .. :try_end_f} :catchall_3e

    :try_start_f
    iget-object v0, p0, Lorg/mapsforge/map/layer/cache/TileStore;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v3, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget v3, v3, Lorg/mapsforge/core/model/Tile;->tileSize:I

    iget-boolean v4, p1, Lorg/mapsforge/map/layer/queue/Job;->hasAlpha:Z

    invoke-interface {v0, v2, v3, v4}, Lorg/mapsforge/core/graphics/GraphicFactory;->createTileBitmap(Ljava/io/InputStream;IZ)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object v0

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result v3

    iget-object v4, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget v4, v4, Lorg/mapsforge/core/model/Tile;->tileSize:I

    if-ne v3, v4, :cond_2f

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result v3

    iget-object v4, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget v4, v4, Lorg/mapsforge/core/model/Tile;->tileSize:I

    if-eq v3, v4, :cond_36

    :cond_2f
    iget-object p1, p1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget p1, p1, Lorg/mapsforge/core/model/Tile;->tileSize:I

    invoke-interface {v0, p1, p1}, Lorg/mapsforge/core/graphics/Bitmap;->scaleTo(II)V
    :try_end_36
    .catch Lorg/mapsforge/core/graphics/CorruptedInputStreamException; {:try_start_f .. :try_end_36} :catch_4a
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_36} :catch_44
    .catchall {:try_start_f .. :try_end_36} :catchall_3b

    :cond_36
    :try_start_36
    invoke-static {v2}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V
    :try_end_39
    .catchall {:try_start_36 .. :try_end_39} :catchall_4f

    monitor-exit p0

    return-object v0

    :catchall_3b
    move-exception p1

    move-object v1, v2

    goto :goto_3f

    :catchall_3e
    move-exception p1

    :goto_3f
    :try_start_3f
    invoke-static {v1}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    throw p1

    :catch_43
    move-object v2, v1

    :catch_44
    invoke-static {v2}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V
    :try_end_47
    .catchall {:try_start_3f .. :try_end_47} :catchall_4f

    monitor-exit p0

    return-object v1

    :catch_49
    move-object v2, v1

    :catch_4a
    :try_start_4a
    invoke-static {v2}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V
    :try_end_4d
    .catchall {:try_start_4a .. :try_end_4d} :catchall_4f

    monitor-exit p0

    return-object v1

    :catchall_4f
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getCapacity()I
    .registers 2

    monitor-enter p0

    monitor-exit p0

    const v0, 0x7fffffff

    return v0
.end method

.method public declared-synchronized getCapacityFirstLevel()I
    .registers 2

    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Lorg/mapsforge/map/layer/cache/TileStore;->getCapacity()I

    move-result v0
    :try_end_5
    .catchall {:try_start_1 .. :try_end_5} :catchall_7

    monitor-exit p0

    return v0

    :catchall_7
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getImmediately(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 2

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/layer/cache/TileStore;->get(Lorg/mapsforge/map/layer/queue/Job;)Lorg/mapsforge/core/graphics/TileBitmap;

    move-result-object p1

    return-object p1
.end method

.method public declared-synchronized purge()V
    .registers 1

    monitor-enter p0

    monitor-exit p0

    return-void
.end method

.method public declared-synchronized put(Lorg/mapsforge/map/layer/queue/Job;Lorg/mapsforge/core/graphics/TileBitmap;)V
    .registers 3

    monitor-enter p0

    monitor-exit p0

    return-void
.end method

.method public removeObserver(Lorg/mapsforge/map/model/common/Observer;)V
    .registers 2

    return-void
.end method

.method public setWorkingSet(Ljava/util/Set;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set<",
            "Lorg/mapsforge/map/layer/queue/Job;",
            ">;)V"
        }
    .end annotation

    return-void
.end method
