.class final Lorg/mapsforge/map/reader/header/RequiredFields;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final BINARY_OSM_MAGIC_BYTE:Ljava/lang/String; = "mapsforge binary OSM"

.field private static final HEADER_SIZE_MAX:I = 0xf4240

.field private static final HEADER_SIZE_MIN:I = 0x46

.field private static final MERCATOR:Ljava/lang/String; = "Mercator"

.field private static final SUPPORTED_FILE_VERSION_MAX:I = 0x5

.field private static final SUPPORTED_FILE_VERSION_MIN:I = 0x3


# direct methods
.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method static readBoundingBox(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V
    .registers 12

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readInt()I

    move-result v0

    invoke-static {v0}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v2

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readInt()I

    move-result v0

    invoke-static {v0}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v4

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readInt()I

    move-result v0

    invoke-static {v0}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v6

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readInt()I

    move-result p0

    invoke-static {p0}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v8

    :try_start_20
    new-instance p0, Lorg/mapsforge/core/model/BoundingBox;

    move-object v1, p0

    invoke-direct/range {v1 .. v9}, Lorg/mapsforge/core/model/BoundingBox;-><init>(DDDD)V

    iput-object p0, p1, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;
    :try_end_28
    .catch Ljava/lang/IllegalArgumentException; {:try_start_20 .. :try_end_28} :catch_29

    return-void

    :catch_29
    move-exception p0

    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method static readFileSize(Lorg/mapsforge/map/reader/ReadBuffer;JLorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V
    .registers 6

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readLong()J

    move-result-wide v0

    cmp-long p0, v0, p1

    if-nez p0, :cond_b

    iput-wide p1, p3, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->fileSize:J

    return-void

    :cond_b
    new-instance p0, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    const-string p2, "invalid file size: "

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method static readFileVersion(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V
    .registers 4

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readInt()I

    move-result p0

    const/4 v0, 0x3

    if-lt p0, v0, :cond_d

    const/4 v0, 0x5

    if-gt p0, v0, :cond_d

    iput p0, p1, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->fileVersion:I

    return-void

    :cond_d
    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "unsupported file version: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method static readMagicByte(Lorg/mapsforge/map/reader/ReadBuffer;)V
    .registers 4

    const/16 v0, 0x18

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/reader/ReadBuffer;->readFromFile(I)Z

    move-result v0

    if-eqz v0, :cond_2e

    const/16 v0, 0x14

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString(I)Ljava/lang/String;

    move-result-object p0

    const-string v0, "mapsforge binary OSM"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_17

    return-void

    :cond_17
    new-instance v0, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid magic byte: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2e
    new-instance p0, Lorg/mapsforge/map/reader/header/MapFileException;

    const-string v0, "reading magic byte has failed"

    invoke-direct {p0, v0}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method static readMapDate(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V
    .registers 6

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readLong()J

    move-result-wide v0

    const-wide v2, 0x1176592e000L

    cmp-long p0, v0, v2

    if-ltz p0, :cond_10

    iput-wide v0, p1, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->mapDate:J

    return-void

    :cond_10
    new-instance p0, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid map date: "

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method static readPoiTags(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V
    .registers 7

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readShort()I

    move-result v0

    if-ltz v0, :cond_35

    new-array v1, v0, [Lorg/mapsforge/core/model/Tag;

    const/4 v2, 0x0

    :goto_9
    if-ge v2, v0, :cond_32

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_1b

    new-instance v4, Lorg/mapsforge/core/model/Tag;

    invoke-direct {v4, v3}, Lorg/mapsforge/core/model/Tag;-><init>(Ljava/lang/String;)V

    aput-object v4, v1, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_9

    :cond_1b
    new-instance p0, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "POI tag must not be null: "

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_32
    iput-object v1, p1, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->poiTags:[Lorg/mapsforge/core/model/Tag;

    return-void

    :cond_35
    new-instance p0, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "invalid number of POI tags: "

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method static readProjectionName(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V
    .registers 4

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString()Ljava/lang/String;

    move-result-object p0

    const-string v0, "Mercator"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    iput-object p0, p1, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->projectionName:Ljava/lang/String;

    return-void

    :cond_f
    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "unsupported projection: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method static readRemainingHeader(Lorg/mapsforge/map/reader/ReadBuffer;)V
    .registers 4

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readInt()I

    move-result v0

    const/16 v1, 0x46

    if-lt v0, v1, :cond_2b

    const v1, 0xf4240

    if-gt v0, v1, :cond_2b

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/reader/ReadBuffer;->readFromFile(I)Z

    move-result p0

    if-eqz p0, :cond_14

    return-void

    :cond_14
    new-instance p0, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "reading header data has failed: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_2b
    new-instance p0, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid remaining header size: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method static readTilePixelSize(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readShort()I

    move-result p0

    iput p0, p1, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->tilePixelSize:I

    return-void
.end method

.method static readWayTags(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V
    .registers 7

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readShort()I

    move-result v0

    if-ltz v0, :cond_35

    new-array v1, v0, [Lorg/mapsforge/core/model/Tag;

    const/4 v2, 0x0

    :goto_9
    if-ge v2, v0, :cond_32

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_1b

    new-instance v4, Lorg/mapsforge/core/model/Tag;

    invoke-direct {v4, v3}, Lorg/mapsforge/core/model/Tag;-><init>(Ljava/lang/String;)V

    aput-object v4, v1, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_9

    :cond_1b
    new-instance p0, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "way tag must not be null: "

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_32
    iput-object v1, p1, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->wayTags:[Lorg/mapsforge/core/model/Tag;

    return-void

    :cond_35
    new-instance p0, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "invalid number of way tags: "

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p0
.end method
