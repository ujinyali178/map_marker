.class public Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;


# instance fields
.field public final linearity:D

.field private lookup:[B

.field private lookupOffset:I

.field public final scale:D


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method public constructor <init>()V
    .registers 5

    const-wide v0, 0x3fb999999999999aL    # 0.1

    const-wide v2, 0x3fe54fdf3b645a1dL    # 0.666

    invoke-direct {p0, v0, v1, v2, v3}, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;-><init>(DD)V

    return-void
.end method

.method public constructor <init>(DD)V
    .registers 9

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, 0x0

    invoke-static {v0, v1, p1, p2}, Ljava/lang/Math;->max(DD)D

    move-result-wide p1

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    invoke-static {v2, v3, p1, p2}, Ljava/lang/Math;->min(DD)D

    move-result-wide p1

    iput-wide p1, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->linearity:D

    invoke-static {v0, v1, p3, p4}, Ljava/lang/Math;->max(DD)D

    move-result-wide p1

    iput-wide p1, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->scale:D

    return-void
.end method

.method private convert(Ljava/nio/MappedByteBuffer;III)[B
    .registers 24

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, p2

    move/from16 v3, p3

    new-array v4, v3, [S

    mul-int/lit8 v5, p4, 0x2

    add-int v6, v2, v5

    mul-int v7, v6, v6

    new-array v7, v7, [B

    iget-object v8, v0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->lookup:[B

    if-nez v8, :cond_1b

    invoke-direct/range {p0 .. p0}, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->fillLookup()V

    iget-object v8, v0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->lookup:[B

    :cond_1b
    mul-int v6, v6, p4

    add-int v6, v6, p4

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    :goto_23
    if-ge v10, v3, :cond_31

    invoke-static {v1, v11}, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->readNext(Ljava/nio/ByteBuffer;S)S

    move-result v11

    add-int/lit8 v13, v12, 0x1

    aput-short v11, v4, v12

    add-int/lit8 v10, v10, 0x1

    move v12, v13

    goto :goto_23

    :cond_31
    const/4 v11, 0x1

    :goto_32
    if-gt v11, v2, :cond_84

    if-lt v12, v3, :cond_37

    const/4 v12, 0x0

    :cond_37
    aget-short v13, v4, v12

    invoke-static {v1, v13}, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->readNext(Ljava/nio/ByteBuffer;S)S

    move-result v14

    add-int/lit8 v15, v12, 0x1

    aput-short v14, v4, v12

    move v12, v15

    const/4 v15, 0x1

    :goto_43
    if-gt v15, v2, :cond_80

    aget-short v10, v4, v12

    invoke-static {v1, v10}, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->readNext(Ljava/nio/ByteBuffer;S)S

    move-result v16

    add-int/lit8 v17, v12, 0x1

    aput-short v16, v4, v12

    sub-int v12, v16, v10

    sub-int v18, v14, v13

    add-int v12, v12, v18

    neg-int v12, v12

    sub-int v13, v10, v13

    sub-int v14, v16, v14

    add-int/2addr v13, v14

    neg-int v13, v13

    invoke-direct {v0, v8, v12}, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->exaggerate([BI)B

    move-result v12

    invoke-direct {v0, v8, v13}, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->exaggerate([BI)B

    move-result v13

    add-int/2addr v12, v13

    add-int/lit8 v12, v12, 0x7f

    invoke-static {v9, v12}, Ljava/lang/Math;->max(II)I

    move-result v12

    const/16 v13, 0xff

    invoke-static {v13, v12}, Ljava/lang/Math;->min(II)I

    move-result v12

    and-int/2addr v12, v13

    add-int/lit8 v13, v6, 0x1

    int-to-byte v12, v12

    aput-byte v12, v7, v6

    add-int/lit8 v15, v15, 0x1

    move v6, v13

    move/from16 v14, v16

    move/from16 v12, v17

    move v13, v10

    goto :goto_43

    :cond_80
    add-int/2addr v6, v5

    add-int/lit8 v11, v11, 0x1

    goto :goto_32

    :cond_84
    return-object v7
.end method

.method private exaggerate([BI)B
    .registers 5

    array-length v0, p1

    add-int/lit8 v0, v0, -0x1

    iget v1, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->lookupOffset:I

    add-int/2addr p2, v1

    invoke-static {v0, p2}, Ljava/lang/Math;->min(II)I

    move-result p2

    const/4 v0, 0x0

    invoke-static {v0, p2}, Ljava/lang/Math;->max(II)I

    move-result p2

    aget-byte p1, p1, p2

    return p1
.end method

.method private fillLookup()V
    .registers 11

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    const/16 v2, -0x400

    const-wide v3, 0x405fc00000000000L    # 127.0

    const-wide/high16 v5, -0x3fa0000000000000L    # -128.0

    if-le v1, v2, :cond_23

    int-to-double v7, v1

    invoke-virtual {p0, v7, v8}, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->exaggerate(D)D

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Math;->round(D)J

    move-result-wide v7

    long-to-double v7, v7

    cmpg-double v2, v7, v5

    if-lez v2, :cond_23

    cmpl-double v2, v7, v3

    if-ltz v2, :cond_20

    goto :goto_23

    :cond_20
    add-int/lit8 v1, v1, -0x1

    goto :goto_2

    :cond_23
    :goto_23
    const/4 v2, 0x0

    :goto_24
    const/16 v7, 0x400

    if-ge v2, v7, :cond_3e

    int-to-double v7, v2

    invoke-virtual {p0, v7, v8}, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->exaggerate(D)D

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Math;->round(D)J

    move-result-wide v7

    long-to-double v7, v7

    cmpg-double v9, v7, v5

    if-lez v9, :cond_3e

    cmpl-double v9, v7, v3

    if-ltz v9, :cond_3b

    goto :goto_3e

    :cond_3b
    add-int/lit8 v2, v2, 0x1

    goto :goto_24

    :cond_3e
    :goto_3e
    add-int/lit8 v2, v2, 0x1

    sub-int/2addr v2, v1

    new-array v3, v2, [B

    move v4, v1

    :goto_44
    if-ge v0, v2, :cond_58

    int-to-double v5, v4

    invoke-virtual {p0, v5, v6}, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->exaggerate(D)D

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Math;->round(D)J

    move-result-wide v5

    long-to-int v6, v5

    int-to-byte v5, v6

    aput-byte v5, v3, v0

    add-int/lit8 v4, v4, 0x1

    add-int/lit8 v0, v0, 0x1

    goto :goto_44

    :cond_58
    iput-object v3, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->lookup:[B

    neg-int v0, v1

    iput v0, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->lookupOffset:I

    return-void
.end method

.method private static readNext(Ljava/nio/ByteBuffer;S)S
    .registers 3

    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->getShort()S

    move-result p0

    const/16 v0, -0x8000

    if-ne p0, v0, :cond_9

    return p1

    :cond_9
    return p0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 8

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    const/4 v1, 0x0

    if-eqz p1, :cond_2c

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_12

    goto :goto_2c

    :cond_12
    check-cast p1, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;

    iget-wide v2, p1, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->linearity:D

    iget-wide v4, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->linearity:D

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Double;->compare(DD)I

    move-result v2

    if-eqz v2, :cond_1f

    return v1

    :cond_1f
    iget-wide v2, p1, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->scale:D

    iget-wide v4, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->scale:D

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Double;->compare(DD)I

    move-result p1

    if-nez p1, :cond_2a

    goto :goto_2b

    :cond_2a
    const/4 v0, 0x0

    :goto_2b
    return v0

    :cond_2c
    :goto_2c
    return v1
.end method

.method protected exaggerate(D)D
    .registers 9

    iget-wide v0, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->scale:D

    mul-double p1, p1, v0

    const-wide v0, 0x405fc00000000000L    # 127.0

    invoke-static {v0, v1, p1, p2}, Ljava/lang/Math;->min(DD)D

    move-result-wide p1

    const-wide/high16 v0, -0x3fa0000000000000L    # -128.0

    invoke-static {v0, v1, p1, p2}, Ljava/lang/Math;->max(DD)D

    move-result-wide p1

    const-wide v0, 0x3ff921fb54442d18L    # 1.5707963267948966

    mul-double v2, p1, v0

    const-wide/high16 v4, 0x4060000000000000L    # 128.0

    div-double/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Math;->sin(D)D

    move-result-wide v2

    mul-double v2, v2, v0

    invoke-static {v2, v3}, Ljava/lang/Math;->sin(D)D

    move-result-wide v2

    mul-double v2, v2, v0

    invoke-static {v2, v3}, Ljava/lang/Math;->sin(D)D

    move-result-wide v0

    mul-double v0, v0, v4

    iget-wide v2, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->linearity:D

    const-wide/high16 v4, 0x3ff0000000000000L    # 1.0

    sub-double/2addr v4, v2

    mul-double v0, v0, v4

    mul-double p1, p1, v2

    add-double/2addr v0, p1

    return-wide v0
.end method

.method public getAxisLenght(Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)I
    .registers 7

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->getSize()J

    move-result-wide v0

    const-wide/16 v2, 0x2

    div-long v2, v0, v2

    long-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    double-to-int p1, v2

    mul-int v2, p1, p1

    mul-int/lit8 v2, v2, 0x2

    int-to-long v2, v2

    cmp-long v4, v2, v0

    if-eqz v4, :cond_1d

    const/4 p1, 0x0

    return p1

    :cond_1d
    add-int/lit8 p1, p1, -0x1

    return p1
.end method

.method public hashCode()I
    .registers 8

    iget-wide v0, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->linearity:D

    invoke-static {v0, v1}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v0

    const/16 v2, 0x20

    ushr-long v3, v0, v2

    xor-long/2addr v0, v3

    long-to-int v1, v0

    iget-wide v3, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->scale:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    mul-int/lit8 v1, v1, 0x1f

    ushr-long v5, v3, v2

    xor-long v2, v3, v5

    long-to-int v0, v2

    add-int/2addr v1, v0

    return v1
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "SimpleShadingAlgorithm{linearity="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->linearity:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v1, ", scale="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->scale:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public transformToByteBuffer(Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;I)Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;
    .registers 14

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->getAxisLenght(Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)I

    move-result v0

    add-int/lit8 v1, v0, 0x1

    const/4 v2, 0x0

    :try_start_7
    invoke-virtual {p1}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->getFile()Ljava/io/File;

    move-result-object p1

    new-instance v3, Ljava/io/FileInputStream;

    invoke-direct {v3, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_10
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_10} :catch_4a
    .catchall {:try_start_7 .. :try_end_10} :catchall_47

    :try_start_10
    invoke-virtual {v3}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v10
    :try_end_14
    .catch Ljava/io/IOException; {:try_start_10 .. :try_end_14} :catch_44
    .catchall {:try_start_10 .. :try_end_14} :catchall_42

    :try_start_14
    sget-object v5, Ljava/nio/channels/FileChannel$MapMode;->READ_ONLY:Ljava/nio/channels/FileChannel$MapMode;

    const-wide/16 v6, 0x0

    invoke-virtual {p1}, Ljava/io/File;->length()J

    move-result-wide v8

    move-object v4, v10

    invoke-virtual/range {v4 .. v9}, Ljava/nio/channels/FileChannel;->map(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;

    move-result-object p1

    sget-object v4, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {p1, v4}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    invoke-direct {p0, p1, v0, v1, p2}, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->convert(Ljava/nio/MappedByteBuffer;III)[B

    move-result-object p1

    new-instance v1, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;

    invoke-direct {v1, p1, v0, v0, p2}, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;-><init>([BIII)V
    :try_end_2f
    .catch Ljava/io/IOException; {:try_start_14 .. :try_end_2f} :catch_40
    .catchall {:try_start_14 .. :try_end_2f} :catchall_6d

    :try_start_2f
    invoke-virtual {v10}, Ljava/nio/channels/spi/AbstractInterruptibleChannel;->close()V
    :try_end_32
    .catch Ljava/io/IOException; {:try_start_2f .. :try_end_32} :catch_33

    goto :goto_37

    :catch_33
    move-exception p1

    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    :goto_37
    :try_start_37
    invoke-virtual {v3}, Ljava/io/FileInputStream;->close()V
    :try_end_3a
    .catch Ljava/io/IOException; {:try_start_37 .. :try_end_3a} :catch_3b

    goto :goto_3f

    :catch_3b
    move-exception p1

    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    :goto_3f
    return-object v1

    :catch_40
    move-exception p1

    goto :goto_4d

    :catchall_42
    move-exception p1

    goto :goto_6f

    :catch_44
    move-exception p1

    move-object v10, v2

    goto :goto_4d

    :catchall_47
    move-exception p1

    move-object v3, v2

    goto :goto_6f

    :catch_4a
    move-exception p1

    move-object v3, v2

    move-object v10, v3

    :goto_4d
    :try_start_4d
    sget-object p2, Lorg/mapsforge/map/layer/hills/SimpleShadingAlgorithm;->LOGGER:Ljava/util/logging/Logger;

    sget-object v0, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v0, v1, p1}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_58
    .catchall {:try_start_4d .. :try_end_58} :catchall_6d

    if-eqz v10, :cond_62

    :try_start_5a
    invoke-virtual {v10}, Ljava/nio/channels/spi/AbstractInterruptibleChannel;->close()V
    :try_end_5d
    .catch Ljava/io/IOException; {:try_start_5a .. :try_end_5d} :catch_5e

    goto :goto_62

    :catch_5e
    move-exception p1

    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_62
    :goto_62
    if-eqz v3, :cond_6c

    :try_start_64
    invoke-virtual {v3}, Ljava/io/FileInputStream;->close()V
    :try_end_67
    .catch Ljava/io/IOException; {:try_start_64 .. :try_end_67} :catch_68

    goto :goto_6c

    :catch_68
    move-exception p1

    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_6c
    :goto_6c
    return-object v2

    :catchall_6d
    move-exception p1

    move-object v2, v10

    :goto_6f
    if-eqz v2, :cond_79

    :try_start_71
    invoke-virtual {v2}, Ljava/nio/channels/spi/AbstractInterruptibleChannel;->close()V
    :try_end_74
    .catch Ljava/io/IOException; {:try_start_71 .. :try_end_74} :catch_75

    goto :goto_79

    :catch_75
    move-exception p2

    invoke-virtual {p2}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_79
    :goto_79
    if-eqz v3, :cond_83

    :try_start_7b
    invoke-virtual {v3}, Ljava/io/FileInputStream;->close()V
    :try_end_7e
    .catch Ljava/io/IOException; {:try_start_7b .. :try_end_7e} :catch_7f

    goto :goto_83

    :catch_7f
    move-exception p2

    invoke-virtual {p2}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_83
    :goto_83
    throw p1
.end method
