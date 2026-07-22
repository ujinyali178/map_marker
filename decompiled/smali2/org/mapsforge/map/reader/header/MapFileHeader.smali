.class public Lorg/mapsforge/map/reader/header/MapFileHeader;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final BASE_ZOOM_LEVEL_MAX:I = 0x14

.field private static final HEADER_SIZE_MIN:I = 0x46

.field private static final SIGNATURE_LENGTH_INDEX:B = 0x10t

.field private static final SPACE:C = ' '


# instance fields
.field private mapFileInfo:Lorg/mapsforge/map/reader/header/MapFileInfo;

.field private subFileParameters:[Lorg/mapsforge/map/reader/header/SubFileParameter;

.field private zoomLevelMaximum:B

.field private zoomLevelMinimum:B


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private readSubFileParameters(Lorg/mapsforge/map/reader/ReadBuffer;JLorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V
    .registers 16

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readByte()B

    move-result v0

    const/4 v1, 0x1

    if-lt v0, v1, :cond_138

    iput-byte v0, p4, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->numberOfSubFiles:B

    new-array v2, v0, [Lorg/mapsforge/map/reader/header/SubFileParameter;

    const/16 v3, 0x7f

    iput-byte v3, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->zoomLevelMinimum:B

    const/16 v3, -0x80

    iput-byte v3, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->zoomLevelMaximum:B

    const/4 v3, 0x0

    const/4 v4, 0x0

    :goto_15
    if-ge v4, v0, :cond_11b

    new-instance v5, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;

    invoke-direct {v5}, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;-><init>()V

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readByte()B

    move-result v6

    if-ltz v6, :cond_104

    const/16 v7, 0x14

    if-gt v6, v7, :cond_104

    iput-byte v6, v5, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->baseZoomLevel:B

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readByte()B

    move-result v6

    if-ltz v6, :cond_ed

    const/16 v7, 0x16

    if-gt v6, v7, :cond_ed

    iput-byte v6, v5, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->zoomLevelMin:B

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readByte()B

    move-result v8

    if-ltz v8, :cond_d6

    if-gt v8, v7, :cond_d6

    iput-byte v8, v5, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->zoomLevelMax:B

    if-gt v6, v8, :cond_b7

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readLong()J

    move-result-wide v6

    const-wide/16 v8, 0x46

    cmp-long v10, v6, v8

    if-ltz v10, :cond_a0

    cmp-long v8, v6, p2

    if-gez v8, :cond_a0

    iput-wide v6, v5, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->startAddress:J

    iget-object v8, p4, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->optionalFields:Lorg/mapsforge/map/reader/header/OptionalFields;

    iget-boolean v8, v8, Lorg/mapsforge/map/reader/header/OptionalFields;->isDebugFile:Z

    if-eqz v8, :cond_59

    const-wide/16 v8, 0x10

    add-long/2addr v6, v8

    :cond_59
    iput-wide v6, v5, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->indexStartAddress:J

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readLong()J

    move-result-wide v6

    const-wide/16 v8, 0x1

    cmp-long v10, v6, v8

    if-ltz v10, :cond_89

    iput-wide v6, v5, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->subFileSize:J

    iget-object v6, p4, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    iput-object v6, v5, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->boundingBox:Lorg/mapsforge/core/model/BoundingBox;

    invoke-virtual {v5}, Lorg/mapsforge/map/reader/header/SubFileParameterBuilder;->build()Lorg/mapsforge/map/reader/header/SubFileParameter;

    move-result-object v5

    aput-object v5, v2, v4

    iget-byte v6, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->zoomLevelMinimum:B

    iget-byte v7, v5, Lorg/mapsforge/map/reader/header/SubFileParameter;->zoomLevelMin:B

    if-le v6, v7, :cond_7b

    iput-byte v7, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->zoomLevelMinimum:B

    iput-byte v7, p4, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->zoomLevelMin:B

    :cond_7b
    iget-byte v6, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->zoomLevelMaximum:B

    iget-byte v5, v5, Lorg/mapsforge/map/reader/header/SubFileParameter;->zoomLevelMax:B

    if-ge v6, v5, :cond_85

    iput-byte v5, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->zoomLevelMaximum:B

    iput-byte v5, p4, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->zoomLevelMax:B

    :cond_85
    add-int/lit8 v4, v4, 0x1

    int-to-byte v4, v4

    goto :goto_15

    :cond_89
    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "invalid sub-file size: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_a0
    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "invalid start address: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_b7
    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "invalid zoom level range: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const/16 p3, 0x20

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_d6
    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "invalid maximum zoom level: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_ed
    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "invalid minimum zoom level: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_104
    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "invalid base zoom level: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_11b
    iget-byte p1, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->zoomLevelMaximum:B

    add-int/2addr p1, v1

    new-array p1, p1, [Lorg/mapsforge/map/reader/header/SubFileParameter;

    iput-object p1, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->subFileParameters:[Lorg/mapsforge/map/reader/header/SubFileParameter;

    :goto_122
    if-ge v3, v0, :cond_137

    aget-object p1, v2, v3

    iget-byte p2, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->zoomLevelMin:B

    :goto_128
    iget-byte p3, p1, Lorg/mapsforge/map/reader/header/SubFileParameter;->zoomLevelMax:B

    if-gt p2, p3, :cond_134

    iget-object p3, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->subFileParameters:[Lorg/mapsforge/map/reader/header/SubFileParameter;

    aput-object p1, p3, p2

    add-int/lit8 p2, p2, 0x1

    int-to-byte p2, p2

    goto :goto_128

    :cond_134
    add-int/lit8 v3, v3, 0x1

    goto :goto_122

    :cond_137
    return-void

    :cond_138
    new-instance p1, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "invalid number of sub-files: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw p1
.end method


# virtual methods
.method public getMapFileInfo()Lorg/mapsforge/map/reader/header/MapFileInfo;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->mapFileInfo:Lorg/mapsforge/map/reader/header/MapFileInfo;

    return-object v0
.end method

.method public getQueryZoomLevel(B)B
    .registers 3

    iget-byte v0, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->zoomLevelMaximum:B

    if-le p1, v0, :cond_5

    return v0

    :cond_5
    iget-byte v0, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->zoomLevelMinimum:B

    if-ge p1, v0, :cond_a

    return v0

    :cond_a
    return p1
.end method

.method public getSubFileParameter(I)Lorg/mapsforge/map/reader/header/SubFileParameter;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->subFileParameters:[Lorg/mapsforge/map/reader/header/SubFileParameter;

    aget-object p1, v0, p1

    return-object p1
.end method

.method public readHeader(Lorg/mapsforge/map/reader/ReadBuffer;J)V
    .registers 5

    invoke-static {p1}, Lorg/mapsforge/map/reader/header/RequiredFields;->readMagicByte(Lorg/mapsforge/map/reader/ReadBuffer;)V

    invoke-static {p1}, Lorg/mapsforge/map/reader/header/RequiredFields;->readRemainingHeader(Lorg/mapsforge/map/reader/ReadBuffer;)V

    new-instance v0, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;

    invoke-direct {v0}, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;-><init>()V

    invoke-static {p1, v0}, Lorg/mapsforge/map/reader/header/RequiredFields;->readFileVersion(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V

    invoke-static {p1, p2, p3, v0}, Lorg/mapsforge/map/reader/header/RequiredFields;->readFileSize(Lorg/mapsforge/map/reader/ReadBuffer;JLorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V

    invoke-static {p1, v0}, Lorg/mapsforge/map/reader/header/RequiredFields;->readMapDate(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V

    invoke-static {p1, v0}, Lorg/mapsforge/map/reader/header/RequiredFields;->readBoundingBox(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V

    invoke-static {p1, v0}, Lorg/mapsforge/map/reader/header/RequiredFields;->readTilePixelSize(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V

    invoke-static {p1, v0}, Lorg/mapsforge/map/reader/header/RequiredFields;->readProjectionName(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V

    invoke-static {p1, v0}, Lorg/mapsforge/map/reader/header/OptionalFields;->readOptionalFields(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V

    invoke-static {p1, v0}, Lorg/mapsforge/map/reader/header/RequiredFields;->readPoiTags(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V

    invoke-static {p1, v0}, Lorg/mapsforge/map/reader/header/RequiredFields;->readWayTags(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V

    invoke-direct {p0, p1, p2, p3, v0}, Lorg/mapsforge/map/reader/header/MapFileHeader;->readSubFileParameters(Lorg/mapsforge/map/reader/ReadBuffer;JLorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V

    invoke-virtual {v0}, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->build()Lorg/mapsforge/map/reader/header/MapFileInfo;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/reader/header/MapFileHeader;->mapFileInfo:Lorg/mapsforge/map/reader/header/MapFileInfo;

    return-void
.end method
