.class public Lorg/mapsforge/map/reader/MapFile;
.super Lorg/mapsforge/map/datastore/MapDataStore;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/reader/MapFile$Selector;
    }
.end annotation


# static fields
.field private static final BITMASK_INDEX_OFFSET:J = 0x7fffffffffL

.field private static final BITMASK_INDEX_WATER:J = 0x8000000000L

.field private static final DEFAULT_START_ZOOM_LEVEL:B = 0xct

.field private static final INDEX_CACHE_SIZE:I = 0x40

.field private static final INVALID_FIRST_WAY_OFFSET:Ljava/lang/String; = "invalid first way offset: "

.field private static final LOGGER:Ljava/util/logging/Logger;

.field private static final POI_FEATURE_ELEVATION:I = 0x20

.field private static final POI_FEATURE_HOUSE_NUMBER:I = 0x40

.field private static final POI_FEATURE_NAME:I = 0x80

.field private static final POI_LAYER_BITMASK:I = 0xf0

.field private static final POI_LAYER_SHIFT:I = 0x4

.field private static final POI_NUMBER_OF_TAGS_BITMASK:I = 0xf

.field private static final SIGNATURE_LENGTH_BLOCK:B = 0x20t

.field private static final SIGNATURE_LENGTH_POI:B = 0x20t

.field private static final SIGNATURE_LENGTH_WAY:B = 0x20t

.field private static final TAG_KEY_ELE:Ljava/lang/String; = "ele"

.field private static final TAG_KEY_HOUSE_NUMBER:Ljava/lang/String; = "addr:housenumber"

.field private static final TAG_KEY_NAME:Ljava/lang/String; = "name"

.field private static final TAG_KEY_REF:Ljava/lang/String; = "ref"

.field public static final TEST_MAP_FILE:Lorg/mapsforge/map/reader/MapFile;

.field private static final WAY_FEATURE_DATA_BLOCKS_BYTE:I = 0x8

.field private static final WAY_FEATURE_DOUBLE_DELTA_ENCODING:I = 0x4

.field private static final WAY_FEATURE_HOUSE_NUMBER:I = 0x40

.field private static final WAY_FEATURE_LABEL_POSITION:I = 0x10

.field private static final WAY_FEATURE_NAME:I = 0x80

.field private static final WAY_FEATURE_REF:I = 0x20

.field private static final WAY_LAYER_BITMASK:I = 0xf0

.field private static final WAY_LAYER_SHIFT:I = 0x4

.field private static final WAY_NUMBER_OF_TAGS_BITMASK:I = 0xf

.field public static wayFilterDistance:I

.field public static wayFilterEnabled:Z


# instance fields
.field private final databaseIndexCache:Lorg/mapsforge/map/reader/IndexCache;

.field private final fileSize:J

.field private final inputChannel:Ljava/nio/channels/FileChannel;

.field private final mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

.field private final timestamp:J

.field private zoomLevelMax:B

.field private zoomLevelMin:B


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/reader/MapFile;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v0, Lorg/mapsforge/map/reader/MapFile;

    invoke-direct {v0}, Lorg/mapsforge/map/reader/MapFile;-><init>()V

    sput-object v0, Lorg/mapsforge/map/reader/MapFile;->TEST_MAP_FILE:Lorg/mapsforge/map/reader/MapFile;

    const/4 v0, 0x1

    sput-boolean v0, Lorg/mapsforge/map/reader/MapFile;->wayFilterEnabled:Z

    const/16 v0, 0x14

    sput v0, Lorg/mapsforge/map/reader/MapFile;->wayFilterDistance:I

    return-void
.end method

.method private constructor <init>()V
    .registers 4

    invoke-direct {p0}, Lorg/mapsforge/map/datastore/MapDataStore;-><init>()V

    const/4 v0, 0x0

    iput-byte v0, p0, Lorg/mapsforge/map/reader/MapFile;->zoomLevelMin:B

    const/16 v0, 0x7f

    iput-byte v0, p0, Lorg/mapsforge/map/reader/MapFile;->zoomLevelMax:B

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/reader/MapFile;->databaseIndexCache:Lorg/mapsforge/map/reader/IndexCache;

    const-wide/16 v1, 0x0

    iput-wide v1, p0, Lorg/mapsforge/map/reader/MapFile;->fileSize:J

    iput-object v0, p0, Lorg/mapsforge/map/reader/MapFile;->inputChannel:Ljava/nio/channels/FileChannel;

    iput-object v0, p0, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/reader/MapFile;->timestamp:J

    return-void
.end method

.method public constructor <init>(Ljava/io/File;)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lorg/mapsforge/map/reader/MapFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Ljava/lang/String;)V
    .registers 7

    invoke-direct {p0, p2}, Lorg/mapsforge/map/datastore/MapDataStore;-><init>(Ljava/lang/String;)V

    const/4 p2, 0x0

    iput-byte p2, p0, Lorg/mapsforge/map/reader/MapFile;->zoomLevelMin:B

    const/16 p2, 0x7f

    iput-byte p2, p0, Lorg/mapsforge/map/reader/MapFile;->zoomLevelMax:B

    if-eqz p1, :cond_a1

    :try_start_c
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result p2

    if-eqz p2, :cond_7c

    invoke-virtual {p1}, Ljava/io/File;->isFile()Z

    move-result p2

    if-eqz p2, :cond_65

    invoke-virtual {p1}, Ljava/io/File;->canRead()Z

    move-result p2

    if-eqz p2, :cond_4e

    new-instance p2, Ljava/io/FileInputStream;

    invoke-direct {p2, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {p2}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object p2

    iput-object p2, p0, Lorg/mapsforge/map/reader/MapFile;->inputChannel:Ljava/nio/channels/FileChannel;

    invoke-virtual {p2}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/reader/MapFile;->fileSize:J

    new-instance v2, Lorg/mapsforge/map/reader/ReadBuffer;

    invoke-direct {v2, p2}, Lorg/mapsforge/map/reader/ReadBuffer;-><init>(Ljava/nio/channels/FileChannel;)V

    new-instance v3, Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-direct {v3}, Lorg/mapsforge/map/reader/header/MapFileHeader;-><init>()V

    iput-object v3, p0, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-virtual {v3, v2, v0, v1}, Lorg/mapsforge/map/reader/header/MapFileHeader;->readHeader(Lorg/mapsforge/map/reader/ReadBuffer;J)V

    new-instance v0, Lorg/mapsforge/map/reader/IndexCache;

    const/16 v1, 0x40

    invoke-direct {v0, p2, v1}, Lorg/mapsforge/map/reader/IndexCache;-><init>(Ljava/nio/channels/FileChannel;I)V

    iput-object v0, p0, Lorg/mapsforge/map/reader/MapFile;->databaseIndexCache:Lorg/mapsforge/map/reader/IndexCache;

    invoke-virtual {p1}, Ljava/io/File;->lastModified()J

    move-result-wide p1

    iput-wide p1, p0, Lorg/mapsforge/map/reader/MapFile;->timestamp:J

    return-void

    :cond_4e
    new-instance p2, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "cannot read file: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p2

    :cond_65
    new-instance p2, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "not a file: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p2

    :cond_7c
    new-instance p2, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "file does not exist: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p2
    :try_end_93
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_93} :catch_93

    :catch_93
    move-exception p1

    invoke-direct {p0}, Lorg/mapsforge/map/reader/MapFile;->closeFileChannel()V

    new-instance p2, Lorg/mapsforge/map/reader/header/MapFileException;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p2

    :cond_a1
    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    const-string p2, "mapFile must not be null"

    invoke-direct {p1, p2}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public constructor <init>(Ljava/io/FileInputStream;JLjava/lang/String;)V
    .registers 8

    invoke-direct {p0, p4}, Lorg/mapsforge/map/datastore/MapDataStore;-><init>(Ljava/lang/String;)V

    const/4 p4, 0x0

    iput-byte p4, p0, Lorg/mapsforge/map/reader/MapFile;->zoomLevelMin:B

    const/16 p4, 0x7f

    iput-byte p4, p0, Lorg/mapsforge/map/reader/MapFile;->zoomLevelMax:B

    if-eqz p1, :cond_41

    :try_start_c
    invoke-virtual {p1}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/reader/MapFile;->inputChannel:Ljava/nio/channels/FileChannel;

    invoke-virtual {p1}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/reader/MapFile;->fileSize:J

    new-instance p4, Lorg/mapsforge/map/reader/ReadBuffer;

    invoke-direct {p4, p1}, Lorg/mapsforge/map/reader/ReadBuffer;-><init>(Ljava/nio/channels/FileChannel;)V

    new-instance v2, Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-direct {v2}, Lorg/mapsforge/map/reader/header/MapFileHeader;-><init>()V

    iput-object v2, p0, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-virtual {v2, p4, v0, v1}, Lorg/mapsforge/map/reader/header/MapFileHeader;->readHeader(Lorg/mapsforge/map/reader/ReadBuffer;J)V

    new-instance p4, Lorg/mapsforge/map/reader/IndexCache;

    const/16 v0, 0x40

    invoke-direct {p4, p1, v0}, Lorg/mapsforge/map/reader/IndexCache;-><init>(Ljava/nio/channels/FileChannel;I)V

    iput-object p4, p0, Lorg/mapsforge/map/reader/MapFile;->databaseIndexCache:Lorg/mapsforge/map/reader/IndexCache;

    iput-wide p2, p0, Lorg/mapsforge/map/reader/MapFile;->timestamp:J
    :try_end_32
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_32} :catch_33

    return-void

    :catch_33
    move-exception p1

    invoke-direct {p0}, Lorg/mapsforge/map/reader/MapFile;->closeFileChannel()V

    new-instance p2, Lorg/mapsforge/map/reader/header/MapFileException;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p2

    :cond_41
    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    const-string p2, "mapFileInputStream must not be null"

    invoke-direct {p1, p2}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lorg/mapsforge/map/reader/MapFile;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v0, p2}, Lorg/mapsforge/map/reader/MapFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Ljava/nio/channels/FileChannel;JLjava/lang/String;)V
    .registers 8

    invoke-direct {p0, p4}, Lorg/mapsforge/map/datastore/MapDataStore;-><init>(Ljava/lang/String;)V

    const/4 p4, 0x0

    iput-byte p4, p0, Lorg/mapsforge/map/reader/MapFile;->zoomLevelMin:B

    const/16 p4, 0x7f

    iput-byte p4, p0, Lorg/mapsforge/map/reader/MapFile;->zoomLevelMax:B

    if-eqz p1, :cond_3d

    :try_start_c
    iput-object p1, p0, Lorg/mapsforge/map/reader/MapFile;->inputChannel:Ljava/nio/channels/FileChannel;

    invoke-virtual {p1}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/reader/MapFile;->fileSize:J

    new-instance p4, Lorg/mapsforge/map/reader/ReadBuffer;

    invoke-direct {p4, p1}, Lorg/mapsforge/map/reader/ReadBuffer;-><init>(Ljava/nio/channels/FileChannel;)V

    new-instance v2, Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-direct {v2}, Lorg/mapsforge/map/reader/header/MapFileHeader;-><init>()V

    iput-object v2, p0, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-virtual {v2, p4, v0, v1}, Lorg/mapsforge/map/reader/header/MapFileHeader;->readHeader(Lorg/mapsforge/map/reader/ReadBuffer;J)V

    new-instance p4, Lorg/mapsforge/map/reader/IndexCache;

    const/16 v0, 0x40

    invoke-direct {p4, p1, v0}, Lorg/mapsforge/map/reader/IndexCache;-><init>(Ljava/nio/channels/FileChannel;I)V

    iput-object p4, p0, Lorg/mapsforge/map/reader/MapFile;->databaseIndexCache:Lorg/mapsforge/map/reader/IndexCache;

    iput-wide p2, p0, Lorg/mapsforge/map/reader/MapFile;->timestamp:J
    :try_end_2e
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_2e} :catch_2f

    return-void

    :catch_2f
    move-exception p1

    invoke-direct {p0}, Lorg/mapsforge/map/reader/MapFile;->closeFileChannel()V

    new-instance p2, Lorg/mapsforge/map/reader/header/MapFileException;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p2

    :cond_3d
    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    const-string p2, "mapFileChannel must not be null"

    invoke-direct {p1, p2}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private closeFileChannel()V
    .registers 5

    :try_start_0
    iget-object v0, p0, Lorg/mapsforge/map/reader/MapFile;->databaseIndexCache:Lorg/mapsforge/map/reader/IndexCache;

    if-eqz v0, :cond_7

    invoke-virtual {v0}, Lorg/mapsforge/map/reader/IndexCache;->destroy()V

    :cond_7
    iget-object v0, p0, Lorg/mapsforge/map/reader/MapFile;->inputChannel:Ljava/nio/channels/FileChannel;

    if-eqz v0, :cond_1b

    invoke-virtual {v0}, Ljava/nio/channels/spi/AbstractInterruptibleChannel;->close()V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_e} :catch_f

    goto :goto_1b

    :catch_f
    move-exception v0

    sget-object v1, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    sget-object v2, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v0}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_1b
    :goto_1b
    return-void
.end method

.method private decodeWayNodesDoubleDelta([Lorg/mapsforge/core/model/LatLong;DDLorg/mapsforge/map/reader/ReadBuffer;)V
    .registers 26

    move-object/from16 v0, p1

    invoke-virtual/range {p6 .. p6}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result v1

    invoke-static {v1}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v1

    add-double v1, p2, v1

    invoke-virtual/range {p6 .. p6}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result v3

    invoke-static {v3}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v3

    add-double v3, p4, v3

    new-instance v5, Lorg/mapsforge/core/model/LatLong;

    invoke-direct {v5, v1, v2, v3, v4}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    const/4 v6, 0x0

    aput-object v5, v0, v6

    const/4 v5, 0x1

    const/4 v5, 0x1

    const-wide/16 v6, 0x0

    move-wide v8, v6

    :goto_23
    array-length v10, v0

    if-ge v5, v10, :cond_6a

    invoke-virtual/range {p6 .. p6}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result v10

    invoke-static {v10}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v10

    invoke-virtual/range {p6 .. p6}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result v12

    invoke-static {v12}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v12

    add-double/2addr v6, v10

    add-double/2addr v8, v12

    add-double/2addr v1, v6

    add-double/2addr v3, v8

    const-wide v10, 0x3f50624dd2f1a9fcL    # 0.001

    const-wide v12, 0x4066800000000000L    # 180.0

    const-wide v14, -0x3f99800000000000L    # -180.0

    cmpg-double v16, v3, v14

    if-gez v16, :cond_55

    sub-double v16, v14, v3

    cmpg-double v18, v16, v10

    if-gez v18, :cond_55

    move-wide v3, v14

    goto :goto_60

    :cond_55
    cmpl-double v14, v3, v12

    if-lez v14, :cond_60

    sub-double v14, v3, v12

    cmpg-double v16, v14, v10

    if-gez v16, :cond_60

    move-wide v3, v12

    :cond_60
    :goto_60
    new-instance v10, Lorg/mapsforge/core/model/LatLong;

    invoke-direct {v10, v1, v2, v3, v4}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    aput-object v10, v0, v5

    add-int/lit8 v5, v5, 0x1

    goto :goto_23

    :cond_6a
    return-void
.end method

.method private decodeWayNodesSingleDelta([Lorg/mapsforge/core/model/LatLong;DDLorg/mapsforge/map/reader/ReadBuffer;)V
    .registers 22

    move-object/from16 v0, p1

    invoke-virtual/range {p6 .. p6}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result v1

    invoke-static {v1}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v1

    add-double v1, p2, v1

    invoke-virtual/range {p6 .. p6}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result v3

    invoke-static {v3}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v3

    add-double v3, p4, v3

    new-instance v5, Lorg/mapsforge/core/model/LatLong;

    invoke-direct {v5, v1, v2, v3, v4}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    const/4 v6, 0x0

    aput-object v5, v0, v6

    const/4 v5, 0x1

    const/4 v5, 0x1

    :goto_20
    array-length v6, v0

    if-ge v5, v6, :cond_65

    invoke-virtual/range {p6 .. p6}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result v6

    invoke-static {v6}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v6

    add-double/2addr v1, v6

    invoke-virtual/range {p6 .. p6}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result v6

    invoke-static {v6}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v6

    add-double/2addr v3, v6

    const-wide v6, 0x3f50624dd2f1a9fcL    # 0.001

    const-wide v8, 0x4066800000000000L    # 180.0

    const-wide v10, -0x3f99800000000000L    # -180.0

    cmpg-double v12, v3, v10

    if-gez v12, :cond_50

    sub-double v12, v10, v3

    cmpg-double v14, v12, v6

    if-gez v14, :cond_50

    move-wide v3, v10

    goto :goto_5b

    :cond_50
    cmpl-double v10, v3, v8

    if-lez v10, :cond_5b

    sub-double v10, v3, v8

    cmpg-double v12, v10, v6

    if-gez v12, :cond_5b

    move-wide v3, v8

    :cond_5b
    :goto_5b
    new-instance v6, Lorg/mapsforge/core/model/LatLong;

    invoke-direct {v6, v1, v2, v3, v4}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    aput-object v6, v0, v5

    add-int/lit8 v5, v5, 0x1

    goto :goto_20

    :cond_65
    return-void
.end method

.method private processBlock(Lorg/mapsforge/map/reader/QueryParameters;Lorg/mapsforge/map/reader/header/SubFileParameter;Lorg/mapsforge/core/model/BoundingBox;DDLorg/mapsforge/map/reader/MapFile$Selector;Lorg/mapsforge/map/reader/ReadBuffer;)Lorg/mapsforge/map/datastore/PoiWayBundle;
    .registers 26

    move-object/from16 v11, p0

    move-object/from16 v9, p1

    move-object/from16 v0, p2

    move-object/from16 v10, p9

    invoke-direct {v11, v10}, Lorg/mapsforge/map/reader/MapFile;->processBlockSignature(Lorg/mapsforge/map/reader/ReadBuffer;)Z

    move-result v1

    const/4 v12, 0x0

    if-nez v1, :cond_10

    return-object v12

    :cond_10
    invoke-direct {v11, v0, v10}, Lorg/mapsforge/map/reader/MapFile;->readZoomTable(Lorg/mapsforge/map/reader/header/SubFileParameter;Lorg/mapsforge/map/reader/ReadBuffer;)[[I

    move-result-object v1

    iget v2, v9, Lorg/mapsforge/map/reader/QueryParameters;->queryZoomLevel:I

    iget-byte v3, v0, Lorg/mapsforge/map/reader/header/SubFileParameter;->zoomLevelMin:B

    sub-int/2addr v2, v3

    aget-object v1, v1, v2

    const/4 v2, 0x0

    aget v5, v1, v2

    const/4 v3, 0x1

    aget v13, v1, v3

    invoke-virtual/range {p9 .. p9}, Lorg/mapsforge/map/reader/ReadBuffer;->readUnsignedInt()I

    move-result v1

    const-string v4, "invalid first way offset: "

    if-gez v1, :cond_3e

    sget-object v0, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_3a
    invoke-virtual {v0, v1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v12

    :cond_3e
    invoke-virtual/range {p9 .. p9}, Lorg/mapsforge/map/reader/ReadBuffer;->getBufferPosition()I

    move-result v6

    add-int v14, v1, v6

    invoke-virtual/range {p9 .. p9}, Lorg/mapsforge/map/reader/ReadBuffer;->getBufferSize()I

    move-result v1

    if-le v14, v1, :cond_5c

    sget-object v0, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v14}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    :goto_57
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_3a

    :cond_5c
    iget v1, v9, Lorg/mapsforge/map/reader/QueryParameters;->queryZoomLevel:I

    iget-byte v0, v0, Lorg/mapsforge/map/reader/header/SubFileParameter;->baseZoomLevel:B

    if-le v1, v0, :cond_64

    const/4 v15, 0x1

    goto :goto_65

    :cond_64
    const/4 v15, 0x0

    :goto_65
    move-object/from16 v0, p0

    move-wide/from16 v1, p4

    move-wide/from16 v3, p6

    move-object/from16 v6, p3

    move v7, v15

    move-object/from16 v8, p9

    invoke-direct/range {v0 .. v8}, Lorg/mapsforge/map/reader/MapFile;->processPOIs(DDILorg/mapsforge/core/model/BoundingBox;ZLorg/mapsforge/map/reader/ReadBuffer;)Ljava/util/List;

    move-result-object v7

    if-nez v7, :cond_77

    return-object v12

    :cond_77
    sget-object v0, Lorg/mapsforge/map/reader/MapFile$Selector;->POIS:Lorg/mapsforge/map/reader/MapFile$Selector;

    move-object/from16 v8, p8

    if-ne v0, v8, :cond_83

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    move-object v13, v7

    goto :goto_b8

    :cond_83
    invoke-virtual/range {p9 .. p9}, Lorg/mapsforge/map/reader/ReadBuffer;->getBufferPosition()I

    move-result v0

    if-le v0, v14, :cond_9d

    sget-object v0, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid buffer position: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual/range {p9 .. p9}, Lorg/mapsforge/map/reader/ReadBuffer;->getBufferPosition()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    goto :goto_57

    :cond_9d
    invoke-virtual {v10, v14}, Lorg/mapsforge/map/reader/ReadBuffer;->setBufferPosition(I)V

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v13

    move-object/from16 v3, p3

    move v4, v15

    move-wide/from16 v5, p4

    move-object v13, v7

    move-wide/from16 v7, p6

    move-object/from16 v9, p8

    move-object/from16 v10, p9

    invoke-direct/range {v0 .. v10}, Lorg/mapsforge/map/reader/MapFile;->processWays(Lorg/mapsforge/map/reader/QueryParameters;ILorg/mapsforge/core/model/BoundingBox;ZDDLorg/mapsforge/map/reader/MapFile$Selector;Lorg/mapsforge/map/reader/ReadBuffer;)Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_b8

    return-object v12

    :cond_b8
    :goto_b8
    new-instance v1, Lorg/mapsforge/map/datastore/PoiWayBundle;

    invoke-direct {v1, v13, v0}, Lorg/mapsforge/map/datastore/PoiWayBundle;-><init>(Ljava/util/List;Ljava/util/List;)V

    return-object v1
.end method

.method private processBlockSignature(Lorg/mapsforge/map/reader/ReadBuffer;)Z
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-virtual {v0}, Lorg/mapsforge/map/reader/header/MapFileHeader;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v0

    iget-boolean v0, v0, Lorg/mapsforge/map/reader/header/MapFileInfo;->debugFile:Z

    if-eqz v0, :cond_30

    const/16 v0, 0x20

    invoke-virtual {p1, v0}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString(I)Ljava/lang/String;

    move-result-object p1

    const-string v0, "###TileStart"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_30

    sget-object v0, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid block signature: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    const/4 p1, 0x0

    return p1

    :cond_30
    const/4 p1, 0x1

    return p1
.end method

.method private processBlocks(Lorg/mapsforge/map/reader/QueryParameters;Lorg/mapsforge/map/reader/header/SubFileParameter;Lorg/mapsforge/core/model/BoundingBox;Lorg/mapsforge/map/reader/MapFile$Selector;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 29

    move-object/from16 v11, p0

    move-object/from16 v12, p1

    move-object/from16 v13, p2

    new-instance v14, Lorg/mapsforge/map/datastore/MapReadResult;

    invoke-direct {v14}, Lorg/mapsforge/map/datastore/MapReadResult;-><init>()V

    iget-wide v0, v12, Lorg/mapsforge/map/reader/QueryParameters;->fromBlockY:J

    const/4 v15, 0x1

    move-wide/from16 v16, v0

    const/4 v0, 0x1

    :goto_11
    iget-wide v1, v12, Lorg/mapsforge/map/reader/QueryParameters;->toBlockY:J

    cmp-long v3, v16, v1

    if-gtz v3, :cond_187

    iget-wide v1, v12, Lorg/mapsforge/map/reader/QueryParameters;->fromBlockX:J

    move-wide/from16 v18, v1

    :goto_1b
    iget-wide v1, v12, Lorg/mapsforge/map/reader/QueryParameters;->toBlockX:J

    const-wide/16 v20, 0x1

    cmp-long v3, v18, v1

    if-gtz v3, :cond_183

    iget-wide v1, v13, Lorg/mapsforge/map/reader/header/SubFileParameter;->blocksWidth:J

    mul-long v1, v1, v16

    add-long v1, v1, v18

    iget-object v3, v11, Lorg/mapsforge/map/reader/MapFile;->databaseIndexCache:Lorg/mapsforge/map/reader/IndexCache;

    invoke-virtual {v3, v13, v1, v2}, Lorg/mapsforge/map/reader/IndexCache;->getIndexEntry(Lorg/mapsforge/map/reader/header/SubFileParameter;J)J

    move-result-wide v3

    if-eqz v0, :cond_42

    const-wide v5, 0x8000000000L

    and-long/2addr v5, v3

    const-wide/16 v7, 0x0

    cmp-long v9, v5, v7

    if-eqz v9, :cond_40

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_41

    :cond_40
    const/4 v5, 0x0

    :goto_41
    and-int/2addr v0, v5

    :cond_42
    move/from16 v22, v0

    const-wide v5, 0x7fffffffffL

    and-long/2addr v3, v5

    const/4 v0, 0x0

    cmp-long v7, v3, v20

    if-ltz v7, :cond_156

    iget-wide v7, v13, Lorg/mapsforge/map/reader/header/SubFileParameter;->subFileSize:J

    cmp-long v9, v3, v7

    if-lez v9, :cond_57

    goto/16 :goto_156

    :cond_57
    add-long v1, v1, v20

    iget-wide v9, v13, Lorg/mapsforge/map/reader/header/SubFileParameter;->numberOfBlocks:J

    cmp-long v23, v1, v9

    if-nez v23, :cond_60

    goto :goto_9b

    :cond_60
    iget-object v7, v11, Lorg/mapsforge/map/reader/MapFile;->databaseIndexCache:Lorg/mapsforge/map/reader/IndexCache;

    invoke-virtual {v7, v13, v1, v2}, Lorg/mapsforge/map/reader/IndexCache;->getIndexEntry(Lorg/mapsforge/map/reader/header/SubFileParameter;J)J

    move-result-wide v1

    and-long v7, v1, v5

    iget-wide v1, v13, Lorg/mapsforge/map/reader/header/SubFileParameter;->subFileSize:J

    cmp-long v5, v7, v1

    if-lez v5, :cond_9b

    sget-object v1, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "invalid next block pointer: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v7, v8}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "sub-file size: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v3, v13, Lorg/mapsforge/map/reader/header/SubFileParameter;->subFileSize:J

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v0

    :cond_9b
    :goto_9b
    sub-long/2addr v7, v3

    long-to-int v1, v7

    if-gez v1, :cond_b6

    sget-object v2, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "current block size must not be negative: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v0

    :cond_b6
    if-nez v1, :cond_ba

    goto/16 :goto_150

    :cond_ba
    sget v2, Lorg/mapsforge/core/util/Parameters;->MAXIMUM_BUFFER_SIZE:I

    if-le v1, v2, :cond_d6

    sget-object v0, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "current block size too large: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    goto/16 :goto_150

    :cond_d6
    int-to-long v5, v1

    add-long/2addr v5, v3

    iget-wide v7, v11, Lorg/mapsforge/map/reader/MapFile;->fileSize:J

    cmp-long v2, v5, v7

    if-lez v2, :cond_f5

    sget-object v2, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "current block largher than file size: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v0

    :cond_f5
    new-instance v10, Lorg/mapsforge/map/reader/ReadBuffer;

    iget-object v2, v11, Lorg/mapsforge/map/reader/MapFile;->inputChannel:Ljava/nio/channels/FileChannel;

    invoke-direct {v10, v2}, Lorg/mapsforge/map/reader/ReadBuffer;-><init>(Ljava/nio/channels/FileChannel;)V

    iget-wide v5, v13, Lorg/mapsforge/map/reader/header/SubFileParameter;->startAddress:J

    add-long/2addr v5, v3

    invoke-virtual {v10, v5, v6, v1}, Lorg/mapsforge/map/reader/ReadBuffer;->readFromFile(JI)Z

    move-result v2

    if-nez v2, :cond_11c

    sget-object v2, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "reading current block has failed: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v0

    :cond_11c
    iget-wide v0, v13, Lorg/mapsforge/map/reader/header/SubFileParameter;->boundaryTileTop:J

    add-long v0, v0, v16

    iget-byte v2, v13, Lorg/mapsforge/map/reader/header/SubFileParameter;->baseZoomLevel:B

    invoke-static {v0, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->tileYToLatitude(JB)D

    move-result-wide v5

    iget-wide v0, v13, Lorg/mapsforge/map/reader/header/SubFileParameter;->boundaryTileLeft:J

    add-long v0, v0, v18

    iget-byte v2, v13, Lorg/mapsforge/map/reader/header/SubFileParameter;->baseZoomLevel:B

    invoke-static {v0, v1, v2}, Lorg/mapsforge/core/util/MercatorProjection;->tileXToLongitude(JB)D

    move-result-wide v7

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v9, p4

    :try_start_13a
    invoke-direct/range {v1 .. v10}, Lorg/mapsforge/map/reader/MapFile;->processBlock(Lorg/mapsforge/map/reader/QueryParameters;Lorg/mapsforge/map/reader/header/SubFileParameter;Lorg/mapsforge/core/model/BoundingBox;DDLorg/mapsforge/map/reader/MapFile$Selector;Lorg/mapsforge/map/reader/ReadBuffer;)Lorg/mapsforge/map/datastore/PoiWayBundle;

    move-result-object v0

    if-eqz v0, :cond_150

    invoke-virtual {v14, v0}, Lorg/mapsforge/map/datastore/MapReadResult;->add(Lorg/mapsforge/map/datastore/PoiWayBundle;)V
    :try_end_143
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_13a .. :try_end_143} :catch_144

    goto :goto_150

    :catch_144
    move-exception v0

    sget-object v1, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    sget-object v2, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v0}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_150
    :goto_150
    add-long v18, v18, v20

    move/from16 v0, v22

    goto/16 :goto_1b

    :cond_156
    :goto_156
    sget-object v1, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "invalid current block pointer: "

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "subFileSize: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v3, v13, Lorg/mapsforge/map/reader/header/SubFileParameter;->subFileSize:J

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v0

    :cond_183
    add-long v16, v16, v20

    goto/16 :goto_11

    :cond_187
    return-object v14
.end method

.method private processPOIs(DDILorg/mapsforge/core/model/BoundingBox;ZLorg/mapsforge/map/reader/ReadBuffer;)Ljava/util/List;
    .registers 25
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(DDI",
            "Lorg/mapsforge/core/model/BoundingBox;",
            "Z",
            "Lorg/mapsforge/map/reader/ReadBuffer;",
            ")",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/datastore/PointOfInterest;",
            ">;"
        }
    .end annotation

    move-object/from16 v0, p0

    move-object/from16 v1, p8

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iget-object v3, v0, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-virtual {v3}, Lorg/mapsforge/map/reader/header/MapFileHeader;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v3

    iget-object v3, v3, Lorg/mapsforge/map/reader/header/MapFileInfo;->poiTags:[Lorg/mapsforge/core/model/Tag;

    move/from16 v4, p5

    :goto_13
    if-eqz v4, :cond_d9

    iget-object v5, v0, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-virtual {v5}, Lorg/mapsforge/map/reader/header/MapFileHeader;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v5

    iget-boolean v5, v5, Lorg/mapsforge/map/reader/header/MapFileInfo;->debugFile:Z

    const/4 v6, 0x0

    if-eqz v5, :cond_45

    const/16 v5, 0x20

    invoke-virtual {v1, v5}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString(I)Ljava/lang/String;

    move-result-object v5

    const-string v7, "***POIStart"

    invoke-virtual {v5, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_45

    sget-object v1, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "invalid POI signature: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v6

    :cond_45
    invoke-virtual/range {p8 .. p8}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result v5

    invoke-static {v5}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v7

    add-double v7, p1, v7

    invoke-virtual/range {p8 .. p8}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result v5

    invoke-static {v5}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v9

    add-double v9, p3, v9

    invoke-virtual/range {p8 .. p8}, Lorg/mapsforge/map/reader/ReadBuffer;->readByte()B

    move-result v5

    and-int/lit16 v11, v5, 0xf0

    ushr-int/lit8 v11, v11, 0x4

    int-to-byte v11, v11

    and-int/lit8 v5, v5, 0xf

    int-to-byte v5, v5

    invoke-virtual {v1, v3, v5}, Lorg/mapsforge/map/reader/ReadBuffer;->readTags([Lorg/mapsforge/core/model/Tag;B)Ljava/util/List;

    move-result-object v5

    if-nez v5, :cond_6c

    return-object v6

    :cond_6c
    invoke-virtual/range {p8 .. p8}, Lorg/mapsforge/map/reader/ReadBuffer;->readByte()B

    move-result v6

    and-int/lit16 v12, v6, 0x80

    const/4 v13, 0x1

    const/4 v14, 0x0

    if-eqz v12, :cond_78

    const/4 v12, 0x1

    goto :goto_79

    :cond_78
    const/4 v12, 0x0

    :goto_79
    and-int/lit8 v15, v6, 0x40

    if-eqz v15, :cond_7f

    const/4 v15, 0x1

    goto :goto_80

    :cond_7f
    const/4 v15, 0x0

    :goto_80
    and-int/lit8 v6, v6, 0x20

    if-eqz v6, :cond_85

    goto :goto_86

    :cond_85
    const/4 v13, 0x0

    :goto_86
    if-eqz v12, :cond_9a

    new-instance v6, Lorg/mapsforge/core/model/Tag;

    invoke-virtual/range {p8 .. p8}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v0, v12}, Lorg/mapsforge/map/datastore/MapDataStore;->extractLocalized(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    const-string v14, "name"

    invoke-direct {v6, v14, v12}, Lorg/mapsforge/core/model/Tag;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v5, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_9a
    if-eqz v15, :cond_aa

    new-instance v6, Lorg/mapsforge/core/model/Tag;

    invoke-virtual/range {p8 .. p8}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString()Ljava/lang/String;

    move-result-object v12

    const-string v14, "addr:housenumber"

    invoke-direct {v6, v14, v12}, Lorg/mapsforge/core/model/Tag;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v5, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_aa
    if-eqz v13, :cond_be

    new-instance v6, Lorg/mapsforge/core/model/Tag;

    invoke-virtual/range {p8 .. p8}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v12

    const-string v13, "ele"

    invoke-direct {v6, v13, v12}, Lorg/mapsforge/core/model/Tag;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v5, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_be
    new-instance v6, Lorg/mapsforge/core/model/LatLong;

    invoke-direct {v6, v7, v8, v9, v10}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    move-object/from16 v7, p6

    if-eqz p7, :cond_cd

    invoke-virtual {v7, v6}, Lorg/mapsforge/core/model/BoundingBox;->contains(Lorg/mapsforge/core/model/LatLong;)Z

    move-result v8

    if-eqz v8, :cond_d5

    :cond_cd
    new-instance v8, Lorg/mapsforge/map/datastore/PointOfInterest;

    invoke-direct {v8, v11, v5, v6}, Lorg/mapsforge/map/datastore/PointOfInterest;-><init>(BLjava/util/List;Lorg/mapsforge/core/model/LatLong;)V

    invoke-interface {v2, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_d5
    add-int/lit8 v4, v4, -0x1

    goto/16 :goto_13

    :cond_d9
    return-object v2
.end method

.method private processWayDataBlock(DDZLorg/mapsforge/map/reader/ReadBuffer;)[[Lorg/mapsforge/core/model/LatLong;
    .registers 21

    invoke-virtual/range {p6 .. p6}, Lorg/mapsforge/map/reader/ReadBuffer;->readUnsignedInt()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-lt v0, v2, :cond_4b

    const/16 v2, 0x7fff

    if-le v0, v2, :cond_d

    goto :goto_4b

    :cond_d
    new-array v3, v0, [[Lorg/mapsforge/core/model/LatLong;

    const/4 v4, 0x0

    :goto_10
    if-ge v4, v0, :cond_4a

    invoke-virtual/range {p6 .. p6}, Lorg/mapsforge/map/reader/ReadBuffer;->readUnsignedInt()I

    move-result v5

    const/4 v6, 0x2

    if-lt v5, v6, :cond_33

    if-le v5, v2, :cond_1c

    goto :goto_33

    :cond_1c
    new-array v5, v5, [Lorg/mapsforge/core/model/LatLong;

    move-object v7, p0

    move-object v8, v5

    move-wide v9, p1

    move-wide/from16 v11, p3

    move-object/from16 v13, p6

    if-eqz p5, :cond_2b

    invoke-direct/range {v7 .. v13}, Lorg/mapsforge/map/reader/MapFile;->decodeWayNodesDoubleDelta([Lorg/mapsforge/core/model/LatLong;DDLorg/mapsforge/map/reader/ReadBuffer;)V

    goto :goto_2e

    :cond_2b
    invoke-direct/range {v7 .. v13}, Lorg/mapsforge/map/reader/MapFile;->decodeWayNodesSingleDelta([Lorg/mapsforge/core/model/LatLong;DDLorg/mapsforge/map/reader/ReadBuffer;)V

    :goto_2e
    aput-object v5, v3, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_10

    :cond_33
    :goto_33
    sget-object v0, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "invalid number of way nodes: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v1

    :cond_4a
    return-object v3

    :cond_4b
    :goto_4b
    sget-object v2, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "invalid number of way coordinate blocks: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v1
.end method

.method private processWays(Lorg/mapsforge/map/reader/QueryParameters;ILorg/mapsforge/core/model/BoundingBox;ZDDLorg/mapsforge/map/reader/MapFile$Selector;Lorg/mapsforge/map/reader/ReadBuffer;)Ljava/util/List;
    .registers 38
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/reader/QueryParameters;",
            "I",
            "Lorg/mapsforge/core/model/BoundingBox;",
            "ZDD",
            "Lorg/mapsforge/map/reader/MapFile$Selector;",
            "Lorg/mapsforge/map/reader/ReadBuffer;",
            ")",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/datastore/Way;",
            ">;"
        }
    .end annotation

    move-object/from16 v7, p0

    move-object/from16 v8, p1

    move-object/from16 v9, p10

    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, v7, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-virtual {v0}, Lorg/mapsforge/map/reader/header/MapFileHeader;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v0

    iget-object v11, v0, Lorg/mapsforge/map/reader/header/MapFileInfo;->wayTags:[Lorg/mapsforge/core/model/Tag;

    sget v0, Lorg/mapsforge/map/reader/MapFile;->wayFilterDistance:I

    move-object/from16 v1, p3

    invoke-virtual {v1, v0}, Lorg/mapsforge/core/model/BoundingBox;->extendMeters(I)Lorg/mapsforge/core/model/BoundingBox;

    move-result-object v12

    move/from16 v13, p2

    :goto_1d
    if-eqz v13, :cond_1a4

    iget-object v0, v7, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-virtual {v0}, Lorg/mapsforge/map/reader/header/MapFileHeader;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v0

    iget-boolean v0, v0, Lorg/mapsforge/map/reader/header/MapFileInfo;->debugFile:Z

    const/4 v14, 0x0

    if-eqz v0, :cond_4f

    const/16 v0, 0x20

    invoke-virtual {v9, v0}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString(I)Ljava/lang/String;

    move-result-object v0

    const-string v1, "---WayStart"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4f

    sget-object v1, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "invalid way signature: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v14

    :cond_4f
    invoke-virtual/range {p10 .. p10}, Lorg/mapsforge/map/reader/ReadBuffer;->readUnsignedInt()I

    move-result v0

    if-gez v0, :cond_6c

    sget-object v1, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "invalid way data size: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v14

    :cond_6c
    iget-boolean v1, v8, Lorg/mapsforge/map/reader/QueryParameters;->useTileBitmask:Z

    if-eqz v1, :cond_82

    invoke-virtual/range {p10 .. p10}, Lorg/mapsforge/map/reader/ReadBuffer;->readShort()I

    move-result v1

    iget v2, v8, Lorg/mapsforge/map/reader/QueryParameters;->queryTileBitmask:I

    and-int/2addr v1, v2

    if-nez v1, :cond_86

    add-int/lit8 v0, v0, -0x2

    invoke-virtual {v9, v0}, Lorg/mapsforge/map/reader/ReadBuffer;->skipBytes(I)V

    :cond_7e
    move-object/from16 v2, p9

    goto/16 :goto_1a0

    :cond_82
    const/4 v0, 0x2

    invoke-virtual {v9, v0}, Lorg/mapsforge/map/reader/ReadBuffer;->skipBytes(I)V

    :cond_86
    invoke-virtual/range {p10 .. p10}, Lorg/mapsforge/map/reader/ReadBuffer;->readByte()B

    move-result v0

    and-int/lit16 v1, v0, 0xf0

    ushr-int/lit8 v1, v1, 0x4

    int-to-byte v15, v1

    and-int/lit8 v0, v0, 0xf

    int-to-byte v0, v0

    invoke-virtual {v9, v11, v0}, Lorg/mapsforge/map/reader/ReadBuffer;->readTags([Lorg/mapsforge/core/model/Tag;B)Ljava/util/List;

    move-result-object v6

    if-nez v6, :cond_99

    return-object v14

    :cond_99
    invoke-virtual/range {p10 .. p10}, Lorg/mapsforge/map/reader/ReadBuffer;->readByte()B

    move-result v0

    and-int/lit16 v1, v0, 0x80

    const/4 v5, 0x1

    const/4 v5, 0x1

    const/16 v16, 0x0

    if-eqz v1, :cond_a8

    const/16 v17, 0x1

    goto :goto_aa

    :cond_a8
    const/16 v17, 0x0

    :goto_aa
    and-int/lit8 v1, v0, 0x40

    if-eqz v1, :cond_b1

    const/16 v18, 0x1

    goto :goto_b3

    :cond_b1
    const/16 v18, 0x0

    :goto_b3
    and-int/lit8 v1, v0, 0x20

    if-eqz v1, :cond_ba

    const/16 v19, 0x1

    goto :goto_bc

    :cond_ba
    const/16 v19, 0x0

    :goto_bc
    and-int/lit8 v1, v0, 0x10

    if-eqz v1, :cond_c2

    const/4 v1, 0x1

    goto :goto_c3

    :cond_c2
    const/4 v1, 0x0

    :goto_c3
    and-int/lit8 v2, v0, 0x8

    if-eqz v2, :cond_c9

    const/4 v2, 0x1

    goto :goto_ca

    :cond_c9
    const/4 v2, 0x0

    :goto_ca
    and-int/lit8 v0, v0, 0x4

    if-eqz v0, :cond_d1

    const/16 v20, 0x1

    goto :goto_d3

    :cond_d1
    const/16 v20, 0x0

    :goto_d3
    if-eqz v17, :cond_e7

    new-instance v0, Lorg/mapsforge/core/model/Tag;

    invoke-virtual/range {p10 .. p10}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v7, v3}, Lorg/mapsforge/map/datastore/MapDataStore;->extractLocalized(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "name"

    invoke-direct {v0, v4, v3}, Lorg/mapsforge/core/model/Tag;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_e7
    if-eqz v18, :cond_f7

    new-instance v0, Lorg/mapsforge/core/model/Tag;

    invoke-virtual/range {p10 .. p10}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "addr:housenumber"

    invoke-direct {v0, v4, v3}, Lorg/mapsforge/core/model/Tag;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_f7
    if-eqz v19, :cond_107

    new-instance v0, Lorg/mapsforge/core/model/Tag;

    invoke-virtual/range {p10 .. p10}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "ref"

    invoke-direct {v0, v4, v3}, Lorg/mapsforge/core/model/Tag;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_107
    if-eqz v1, :cond_110

    invoke-direct {v7, v9}, Lorg/mapsforge/map/reader/MapFile;->readOptionalLabelPosition(Lorg/mapsforge/map/reader/ReadBuffer;)[I

    move-result-object v0

    move-object/from16 v21, v0

    goto :goto_112

    :cond_110
    move-object/from16 v21, v14

    :goto_112
    invoke-direct {v7, v2, v9}, Lorg/mapsforge/map/reader/MapFile;->readOptionalWayDataBlocksByte(ZLorg/mapsforge/map/reader/ReadBuffer;)I

    move-result v3

    if-ge v3, v5, :cond_12f

    sget-object v0, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid number of way data blocks: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v14

    :cond_12f
    const/4 v4, 0x0

    :goto_130
    if-ge v4, v3, :cond_7e

    move-object/from16 v0, p0

    move-wide/from16 v1, p5

    move/from16 v22, v3

    move/from16 v23, v4

    move-wide/from16 v3, p7

    const/16 v24, 0x1

    move/from16 v5, v20

    move-object v14, v6

    move-object/from16 v6, p10

    invoke-direct/range {v0 .. v6}, Lorg/mapsforge/map/reader/MapFile;->processWayDataBlock(DDZLorg/mapsforge/map/reader/ReadBuffer;)[[Lorg/mapsforge/core/model/LatLong;

    move-result-object v0

    if-eqz v0, :cond_195

    if-eqz p4, :cond_156

    sget-boolean v1, Lorg/mapsforge/map/reader/MapFile;->wayFilterEnabled:Z

    if-eqz v1, :cond_156

    invoke-virtual {v12, v0}, Lorg/mapsforge/core/model/BoundingBox;->intersectsArea([[Lorg/mapsforge/core/model/LatLong;)Z

    move-result v1

    if-nez v1, :cond_156

    goto :goto_195

    :cond_156
    sget-object v1, Lorg/mapsforge/map/reader/MapFile$Selector;->ALL:Lorg/mapsforge/map/reader/MapFile$Selector;

    move-object/from16 v2, p9

    if-eq v1, v2, :cond_168

    if-nez v17, :cond_168

    if-nez v18, :cond_168

    if-nez v19, :cond_168

    invoke-virtual {v7, v14}, Lorg/mapsforge/map/datastore/MapDataStore;->wayAsLabelTagFilter(Ljava/util/List;)Z

    move-result v1

    if-eqz v1, :cond_197

    :cond_168
    if-eqz v21, :cond_18b

    new-instance v1, Lorg/mapsforge/core/model/LatLong;

    aget-object v3, v0, v16

    aget-object v3, v3, v16

    iget-wide v3, v3, Lorg/mapsforge/core/model/LatLong;->latitude:D

    aget v5, v21, v24

    invoke-static {v5}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v5

    add-double/2addr v3, v5

    aget-object v5, v0, v16

    aget-object v5, v5, v16

    iget-wide v5, v5, Lorg/mapsforge/core/model/LatLong;->longitude:D

    aget v25, v21, v16

    invoke-static/range {v25 .. v25}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v25

    add-double v5, v5, v25

    invoke-direct {v1, v3, v4, v5, v6}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    goto :goto_18c

    :cond_18b
    const/4 v1, 0x0

    :goto_18c
    new-instance v3, Lorg/mapsforge/map/datastore/Way;

    invoke-direct {v3, v15, v14, v0, v1}, Lorg/mapsforge/map/datastore/Way;-><init>(BLjava/util/List;[[Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/LatLong;)V

    invoke-interface {v10, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_197

    :cond_195
    :goto_195
    move-object/from16 v2, p9

    :cond_197
    :goto_197
    add-int/lit8 v4, v23, 0x1

    move-object v6, v14

    move/from16 v3, v22

    const/4 v5, 0x1

    const/4 v5, 0x1

    const/4 v14, 0x0

    goto :goto_130

    :goto_1a0
    add-int/lit8 v13, v13, -0x1

    goto/16 :goto_1d

    :cond_1a4
    return-object v10
.end method

.method private readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/reader/MapFile$Selector;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 8

    iget v0, p1, Lorg/mapsforge/core/model/Tile;->tileX:I

    iget v1, p2, Lorg/mapsforge/core/model/Tile;->tileX:I

    if-gt v0, v1, :cond_c

    iget v0, p1, Lorg/mapsforge/core/model/Tile;->tileY:I

    iget v1, p2, Lorg/mapsforge/core/model/Tile;->tileY:I

    if-le v0, v1, :cond_13

    :cond_c
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "upperLeft tile must be above and left of lowerRight tile"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    :cond_13
    const/4 v0, 0x0

    :try_start_14
    new-instance v1, Lorg/mapsforge/map/reader/QueryParameters;

    invoke-direct {v1}, Lorg/mapsforge/map/reader/QueryParameters;-><init>()V

    iget-object v2, p0, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    iget-byte v3, p1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-virtual {v2, v3}, Lorg/mapsforge/map/reader/header/MapFileHeader;->getQueryZoomLevel(B)B

    move-result v2

    iput v2, v1, Lorg/mapsforge/map/reader/QueryParameters;->queryZoomLevel:I

    iget-object v3, p0, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-virtual {v3, v2}, Lorg/mapsforge/map/reader/header/MapFileHeader;->getSubFileParameter(I)Lorg/mapsforge/map/reader/header/SubFileParameter;

    move-result-object v2

    if-nez v2, :cond_44

    sget-object p1, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "no sub-file for zoom level: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget p3, v1, Lorg/mapsforge/map/reader/QueryParameters;->queryZoomLevel:I

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return-object v0

    :cond_44
    invoke-virtual {v1, p1, p2, v2}, Lorg/mapsforge/map/reader/QueryParameters;->calculateBaseTiles(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/reader/header/SubFileParameter;)V

    invoke-virtual {v1, v2}, Lorg/mapsforge/map/reader/QueryParameters;->calculateBlocks(Lorg/mapsforge/map/reader/header/SubFileParameter;)V

    invoke-static {p1, p2}, Lorg/mapsforge/core/model/Tile;->getBoundingBox(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/core/model/BoundingBox;

    move-result-object p1

    invoke-direct {p0, v1, v2, p1, p3}, Lorg/mapsforge/map/reader/MapFile;->processBlocks(Lorg/mapsforge/map/reader/QueryParameters;Lorg/mapsforge/map/reader/header/SubFileParameter;Lorg/mapsforge/core/model/BoundingBox;Lorg/mapsforge/map/reader/MapFile$Selector;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1
    :try_end_52
    .catch Ljava/io/IOException; {:try_start_14 .. :try_end_52} :catch_53

    return-object p1

    :catch_53
    move-exception p1

    sget-object p2, Lorg/mapsforge/map/reader/MapFile;->LOGGER:Ljava/util/logging/Logger;

    sget-object p3, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, p3, v1, p1}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-object v0
.end method

.method private readOptionalLabelPosition(Lorg/mapsforge/map/reader/ReadBuffer;)[I
    .registers 5

    const/4 v0, 0x2

    new-array v0, v0, [I

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result v1

    const/4 v2, 0x1

    aput v1, v0, v2

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readSignedInt()I

    move-result p1

    const/4 v1, 0x0

    aput p1, v0, v1

    return-object v0
.end method

.method private readOptionalWayDataBlocksByte(ZLorg/mapsforge/map/reader/ReadBuffer;)I
    .registers 3

    if-eqz p1, :cond_7

    invoke-virtual {p2}, Lorg/mapsforge/map/reader/ReadBuffer;->readUnsignedInt()I

    move-result p1

    return p1

    :cond_7
    const/4 p1, 0x1

    return p1
.end method

.method private readZoomTable(Lorg/mapsforge/map/reader/header/SubFileParameter;Lorg/mapsforge/map/reader/ReadBuffer;)[[I
    .registers 10

    iget-byte v0, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->zoomLevelMax:B

    iget-byte p1, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->zoomLevelMin:B

    sub-int/2addr v0, p1

    const/4 p1, 0x1

    add-int/2addr v0, p1

    const/4 v1, 0x2

    new-array v2, v1, [I

    aput v1, v2, p1

    const/4 v1, 0x0

    aput v0, v2, v1

    sget-object v3, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {v3, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [[I

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    :goto_1a
    if-ge v3, v0, :cond_2f

    invoke-virtual {p2}, Lorg/mapsforge/map/reader/ReadBuffer;->readUnsignedInt()I

    move-result v6

    add-int/2addr v4, v6

    invoke-virtual {p2}, Lorg/mapsforge/map/reader/ReadBuffer;->readUnsignedInt()I

    move-result v6

    add-int/2addr v5, v6

    aget-object v6, v2, v3

    aput v4, v6, v1

    aput v5, v6, p1

    add-int/lit8 v3, v3, 0x1

    goto :goto_1a

    :cond_2f
    return-object v2
.end method


# virtual methods
.method public boundingBox()Lorg/mapsforge/core/model/BoundingBox;
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/MapFile;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/reader/header/MapFileInfo;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    return-object v0
.end method

.method public close()V
    .registers 1

    invoke-direct {p0}, Lorg/mapsforge/map/reader/MapFile;->closeFileChannel()V

    return-void
.end method

.method public getDataTimestamp(Lorg/mapsforge/core/model/Tile;)J
    .registers 4

    iget-wide v0, p0, Lorg/mapsforge/map/reader/MapFile;->timestamp:J

    return-wide v0
.end method

.method public getMapFileHeader()Lorg/mapsforge/map/reader/header/MapFileHeader;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    return-object v0
.end method

.method public getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/reader/MapFile;->mapFileHeader:Lorg/mapsforge/map/reader/header/MapFileHeader;

    invoke-virtual {v0}, Lorg/mapsforge/map/reader/header/MapFileHeader;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v0

    return-object v0
.end method

.method public getMapLanguages()[Ljava/lang/String;
    .registers 3

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/MapFile;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/reader/header/MapFileInfo;->languagesPreference:Ljava/lang/String;

    if-eqz v0, :cond_19

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_19

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_19
    const/4 v0, 0x0

    return-object v0
.end method

.method public readLabels(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 3

    sget-object v0, Lorg/mapsforge/map/reader/MapFile$Selector;->LABELS:Lorg/mapsforge/map/reader/MapFile$Selector;

    invoke-direct {p0, p1, p1, v0}, Lorg/mapsforge/map/reader/MapFile;->readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/reader/MapFile$Selector;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1
.end method

.method public readLabels(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 4

    sget-object v0, Lorg/mapsforge/map/reader/MapFile$Selector;->LABELS:Lorg/mapsforge/map/reader/MapFile$Selector;

    invoke-direct {p0, p1, p2, v0}, Lorg/mapsforge/map/reader/MapFile;->readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/reader/MapFile$Selector;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1
.end method

.method public readMapData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 3

    sget-object v0, Lorg/mapsforge/map/reader/MapFile$Selector;->ALL:Lorg/mapsforge/map/reader/MapFile$Selector;

    invoke-direct {p0, p1, p1, v0}, Lorg/mapsforge/map/reader/MapFile;->readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/reader/MapFile$Selector;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1
.end method

.method public readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 4

    sget-object v0, Lorg/mapsforge/map/reader/MapFile$Selector;->ALL:Lorg/mapsforge/map/reader/MapFile$Selector;

    invoke-direct {p0, p1, p2, v0}, Lorg/mapsforge/map/reader/MapFile;->readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/reader/MapFile$Selector;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1
.end method

.method public readPoiData(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 3

    sget-object v0, Lorg/mapsforge/map/reader/MapFile$Selector;->POIS:Lorg/mapsforge/map/reader/MapFile$Selector;

    invoke-direct {p0, p1, p1, v0}, Lorg/mapsforge/map/reader/MapFile;->readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/reader/MapFile$Selector;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1
.end method

.method public readPoiData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/datastore/MapReadResult;
    .registers 4

    sget-object v0, Lorg/mapsforge/map/reader/MapFile$Selector;->POIS:Lorg/mapsforge/map/reader/MapFile$Selector;

    invoke-direct {p0, p1, p2, v0}, Lorg/mapsforge/map/reader/MapFile;->readMapData(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/reader/MapFile$Selector;)Lorg/mapsforge/map/datastore/MapReadResult;

    move-result-object p1

    return-object p1
.end method

.method public restrictToZoomRange(BB)V
    .registers 3

    iput-byte p2, p0, Lorg/mapsforge/map/reader/MapFile;->zoomLevelMax:B

    iput-byte p1, p0, Lorg/mapsforge/map/reader/MapFile;->zoomLevelMin:B

    return-void
.end method

.method public startPosition()Lorg/mapsforge/core/model/LatLong;
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/MapFile;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/reader/header/MapFileInfo;->startPosition:Lorg/mapsforge/core/model/LatLong;

    if-eqz v0, :cond_f

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/MapFile;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/reader/header/MapFileInfo;->startPosition:Lorg/mapsforge/core/model/LatLong;

    return-object v0

    :cond_f
    invoke-virtual {p0}, Lorg/mapsforge/map/reader/MapFile;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/reader/header/MapFileInfo;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    invoke-virtual {v0}, Lorg/mapsforge/core/model/BoundingBox;->getCenterPoint()Lorg/mapsforge/core/model/LatLong;

    move-result-object v0

    return-object v0
.end method

.method public startZoomLevel()Ljava/lang/Byte;
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/MapFile;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/reader/header/MapFileInfo;->startZoomLevel:Ljava/lang/Byte;

    if-eqz v0, :cond_f

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/MapFile;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/reader/header/MapFileInfo;->startZoomLevel:Ljava/lang/Byte;

    return-object v0

    :cond_f
    const/16 v0, 0xc

    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    return-object v0
.end method

.method public supportsTile(Lorg/mapsforge/core/model/Tile;)Z
    .registers 4

    invoke-virtual {p1}, Lorg/mapsforge/core/model/Tile;->getBoundingBox()Lorg/mapsforge/core/model/BoundingBox;

    move-result-object v0

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/MapFile;->getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object v1

    iget-object v1, v1, Lorg/mapsforge/map/reader/header/MapFileInfo;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    invoke-virtual {v0, v1}, Lorg/mapsforge/core/model/BoundingBox;->intersects(Lorg/mapsforge/core/model/BoundingBox;)Z

    move-result v0

    if-eqz v0, :cond_1c

    iget-byte p1, p1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    iget-byte v0, p0, Lorg/mapsforge/map/reader/MapFile;->zoomLevelMin:B

    if-lt p1, v0, :cond_1c

    iget-byte v0, p0, Lorg/mapsforge/map/reader/MapFile;->zoomLevelMax:B

    if-gt p1, v0, :cond_1c

    const/4 p1, 0x1

    goto :goto_1d

    :cond_1c
    const/4 p1, 0x0

    :goto_1d
    return p1
.end method
