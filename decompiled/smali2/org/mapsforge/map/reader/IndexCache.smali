.class Lorg/mapsforge/map/reader/IndexCache;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final INDEX_ENTRIES_PER_BLOCK:I = 0x80

.field private static final SIZE_OF_INDEX_BLOCK:I = 0x280


# instance fields
.field private final fileChannel:Ljava/nio/channels/FileChannel;

.field private final map:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Lorg/mapsforge/map/reader/IndexCacheEntryKey;",
            "[B>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Ljava/nio/channels/FileChannel;I)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/reader/IndexCache;->fileChannel:Ljava/nio/channels/FileChannel;

    new-instance p1, Lorg/mapsforge/core/util/LRUCache;

    invoke-direct {p1, p2}, Lorg/mapsforge/core/util/LRUCache;-><init>(I)V

    iput-object p1, p0, Lorg/mapsforge/map/reader/IndexCache;->map:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method destroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/reader/IndexCache;->map:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    return-void
.end method

.method getIndexEntry(Lorg/mapsforge/map/reader/header/SubFileParameter;J)J
    .registers 13

    iget-wide v0, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->numberOfBlocks:J

    cmp-long v2, p2, v0

    if-gez v2, :cond_6e

    const-wide/16 v0, 0x80

    div-long v2, p2, v0

    new-instance v4, Lorg/mapsforge/map/reader/IndexCacheEntryKey;

    invoke-direct {v4, p1, v2, v3}, Lorg/mapsforge/map/reader/IndexCacheEntryKey;-><init>(Lorg/mapsforge/map/reader/header/SubFileParameter;J)V

    iget-object v5, p0, Lorg/mapsforge/map/reader/IndexCache;->map:Ljava/util/Map;

    invoke-interface {v5, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [B

    if-nez v5, :cond_63

    iget-wide v5, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->indexStartAddress:J

    const-wide/16 v7, 0x280

    mul-long v2, v2, v7

    add-long/2addr v5, v2

    iget-wide v2, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->indexEndAddress:J

    sub-long/2addr v2, v5

    long-to-int p1, v2

    const/16 v2, 0x280

    invoke-static {v2, p1}, Ljava/lang/Math;->min(II)I

    move-result p1

    new-array v2, p1, [B

    const/4 v3, 0x0

    invoke-static {v2, v3, p1}, Ljava/nio/ByteBuffer;->wrap([BII)Ljava/nio/ByteBuffer;

    move-result-object v3

    iget-object v7, p0, Lorg/mapsforge/map/reader/IndexCache;->fileChannel:Ljava/nio/channels/FileChannel;

    monitor-enter v7

    :try_start_34
    iget-object v8, p0, Lorg/mapsforge/map/reader/IndexCache;->fileChannel:Ljava/nio/channels/FileChannel;

    invoke-virtual {v8, v5, v6}, Ljava/nio/channels/FileChannel;->position(J)Ljava/nio/channels/FileChannel;

    iget-object v5, p0, Lorg/mapsforge/map/reader/IndexCache;->fileChannel:Ljava/nio/channels/FileChannel;

    invoke-virtual {v5, v3}, Ljava/nio/channels/FileChannel;->read(Ljava/nio/ByteBuffer;)I

    move-result v3

    if-ne v3, p1, :cond_49

    monitor-exit v7
    :try_end_42
    .catchall {:try_start_34 .. :try_end_42} :catchall_60

    iget-object p1, p0, Lorg/mapsforge/map/reader/IndexCache;->map:Ljava/util/Map;

    invoke-interface {p1, v4, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v5, v2

    goto :goto_63

    :cond_49
    :try_start_49
    new-instance p2, Ljava/io/IOException;

    new-instance p3, Ljava/lang/StringBuilder;

    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "could not read index block with size: "

    invoke-virtual {p3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p2

    :catchall_60
    move-exception p1

    monitor-exit v7
    :try_end_62
    .catchall {:try_start_49 .. :try_end_62} :catchall_60

    throw p1

    :cond_63
    :goto_63
    rem-long/2addr p2, v0

    const-wide/16 v0, 0x5

    mul-long p2, p2, v0

    long-to-int p1, p2

    invoke-static {v5, p1}, Lorg/mapsforge/map/reader/Deserializer;->getFiveBytesLong([BI)J

    move-result-wide p1

    return-wide p1

    :cond_6e
    new-instance p1, Ljava/io/IOException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "invalid block number: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
