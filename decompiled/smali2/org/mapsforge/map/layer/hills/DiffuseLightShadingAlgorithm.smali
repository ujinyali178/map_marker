.class public Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;

.field private static final halfPi:D = 1.5707963267948966


# instance fields
.field private a:D

.field private final ast2:D

.field private final heightAngle:F

.field private final neutral:D


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    const/high16 v0, 0x42480000    # 50.0f

    invoke-direct {p0, v0}, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;-><init>(F)V

    return-void
.end method

.method public constructor <init>(F)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->heightAngle:F

    invoke-static {p1}, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->heightAngleToRelativeHeight(F)D

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->a:D

    mul-double v0, v0, v0

    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    add-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->ast2:D

    const-wide/16 v0, 0x0

    invoke-virtual {p0, v0, v1, v0, v1}, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->calculateRaw(DD)D

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->neutral:D

    return-void
.end method

.method private convert(Ljava/nio/MappedByteBuffer;IIILorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)[B
    .registers 28

    move-object/from16 v0, p1

    move/from16 v1, p2

    move/from16 v2, p3

    new-array v3, v2, [S

    mul-int/lit8 v4, p4, 0x2

    add-int v5, v1, v4

    mul-int v6, v5, v5

    new-array v6, v6, [B

    mul-int v5, v5, p4

    add-int v5, v5, p4

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    :goto_17
    if-ge v8, v2, :cond_25

    invoke-static {v0, v9}, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->readNext(Ljava/nio/ByteBuffer;S)S

    move-result v9

    add-int/lit8 v11, v10, 0x1

    aput-short v9, v3, v10

    add-int/lit8 v8, v8, 0x1

    move v10, v11

    goto :goto_17

    :cond_25
    invoke-virtual/range {p5 .. p5}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->southLat()D

    move-result-wide v8

    mul-int/lit16 v11, v1, 0xaa

    int-to-long v11, v11

    invoke-static {v8, v9, v11, v12}, Lorg/mapsforge/core/util/MercatorProjection;->calculateGroundResolution(DJ)D

    move-result-wide v8

    invoke-virtual/range {p5 .. p5}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->northLat()D

    move-result-wide v13

    invoke-static {v13, v14, v11, v12}, Lorg/mapsforge/core/util/MercatorProjection;->calculateGroundResolution(DJ)D

    move-result-wide v11

    mul-int/lit8 v13, v1, 0x2

    int-to-double v13, v13

    div-double/2addr v8, v13

    div-double/2addr v11, v13

    const/4 v14, 0x1

    :goto_3e
    if-gt v14, v1, :cond_bd

    if-lt v10, v2, :cond_43

    const/4 v10, 0x0

    :cond_43
    aget-short v15, v3, v10

    invoke-static {v0, v15}, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->readNext(Ljava/nio/ByteBuffer;S)S

    move-result v16

    add-int/lit8 v17, v10, 0x1

    aput-short v16, v3, v10

    move v10, v4

    move/from16 p4, v5

    int-to-double v4, v14

    mul-double v4, v4, v8

    sub-int v13, v1, v14

    move-wide/from16 v18, v8

    int-to-double v7, v13

    mul-double v7, v7, v11

    add-double/2addr v4, v7

    move/from16 v7, p4

    const/4 v8, 0x1

    :goto_5e
    if-gt v8, v1, :cond_a8

    aget-short v9, v3, v17

    invoke-static {v0, v9}, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->readNext(Ljava/nio/ByteBuffer;S)S

    move-result v13

    add-int/lit8 v20, v17, 0x1

    aput-short v13, v3, v17

    sub-int v17, v13, v9

    sub-int v21, v16, v15

    add-int v0, v17, v21

    neg-int v0, v0

    sub-int v15, v9, v15

    sub-int v16, v13, v16

    add-int v15, v15, v16

    neg-int v15, v15

    int-to-double v0, v0

    div-double/2addr v0, v4

    move-object/from16 v16, v3

    int-to-double v2, v15

    div-double/2addr v2, v4

    move-object/from16 v15, p0

    invoke-virtual {v15, v0, v1, v2, v3}, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->calculate(DD)I

    move-result v0

    add-int/lit8 v0, v0, 0x7f

    const/4 v1, 0x0

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    const/16 v2, 0xff

    invoke-static {v2, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    and-int/2addr v0, v2

    add-int/lit8 v2, v7, 0x1

    int-to-byte v0, v0

    aput-byte v0, v6, v7

    add-int/lit8 v8, v8, 0x1

    move-object/from16 v0, p1

    move/from16 v1, p2

    move v7, v2

    move v15, v9

    move-object/from16 v3, v16

    move/from16 v17, v20

    move/from16 v2, p3

    move/from16 v16, v13

    goto :goto_5e

    :cond_a8
    move-object/from16 v15, p0

    move-object/from16 v16, v3

    const/4 v1, 0x0

    add-int v5, v7, v10

    add-int/lit8 v14, v14, 0x1

    move-object/from16 v0, p1

    move/from16 v1, p2

    move/from16 v2, p3

    move v4, v10

    move/from16 v10, v17

    move-wide/from16 v8, v18

    goto :goto_3e

    :cond_bd
    move-object/from16 v15, p0

    return-object v6
.end method

.method static heightAngleToRelativeHeight(F)D
    .registers 5

    float-to-double v0, p0

    const-wide v2, 0x4066800000000000L    # 180.0

    div-double/2addr v0, v2

    const-wide v2, 0x400921fb54442d18L    # Math.PI

    mul-double v0, v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->tan(D)D

    move-result-wide v0

    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    invoke-static {v2, v3}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v2

    mul-double v0, v0, v2

    return-wide v0
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
.method calculate(DD)I
    .registers 9

    invoke-virtual {p0, p1, p2, p3, p4}, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->calculateRaw(DD)D

    move-result-wide p1

    iget-wide p3, p0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->neutral:D

    sub-double/2addr p1, p3

    const-wide/16 v0, 0x0

    cmpg-double v2, p1, v0

    if-gez v2, :cond_18

    const-wide/high16 v0, 0x4060000000000000L    # 128.0

    div-double/2addr p1, p3

    :goto_10
    mul-double p1, p1, v0

    invoke-static {p1, p2}, Ljava/lang/Math;->round(D)J

    move-result-wide p1

    long-to-int p2, p1

    return p2

    :cond_18
    cmpl-double v2, p1, v0

    if-lez v2, :cond_26

    const-wide v0, 0x405fc00000000000L    # 127.0

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    sub-double/2addr v2, p3

    div-double/2addr p1, v2

    goto :goto_10

    :cond_26
    const/4 p1, 0x0

    return p1
.end method

.method calculateRaw(DD)D
    .registers 9

    add-double v0, p3, p1

    iget-wide v2, p0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->a:D

    add-double/2addr v0, v2

    iget-wide v2, p0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->ast2:D

    mul-double p1, p1, p1

    mul-double p3, p3, p3

    add-double/2addr p1, p3

    const-wide/high16 p3, 0x3ff0000000000000L    # 1.0

    add-double/2addr p1, p3

    invoke-static {p1, p2}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide p1

    mul-double v2, v2, p1

    div-double/2addr v0, v2

    const-wide/16 p1, 0x0

    invoke-static {p1, p2, v0, v1}, Ljava/lang/Math;->max(DD)D

    move-result-wide p1

    return-wide p1
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 8

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    const/4 v1, 0x0

    if-eqz p1, :cond_21

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_12

    goto :goto_21

    :cond_12
    check-cast p1, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;

    iget-wide v2, p1, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->a:D

    iget-wide v4, p0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->a:D

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Double;->compare(DD)I

    move-result p1

    if-nez p1, :cond_1f

    goto :goto_20

    :cond_1f
    const/4 v0, 0x0

    :goto_20
    return v0

    :cond_21
    :goto_21
    return v1
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

.method public getLightHeight()D
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->a:D

    return-wide v0
.end method

.method public hashCode()I
    .registers 5

    iget-wide v0, p0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->a:D

    invoke-static {v0, v1}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v0

    const/16 v2, 0x20

    ushr-long v2, v0, v2

    xor-long/2addr v0, v2

    long-to-int v1, v0

    return v1
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "DiffuseLightShadingAlgorithm{heightAngle="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->heightAngle:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public transformToByteBuffer(Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;I)Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;
    .registers 19

    invoke-virtual/range {p0 .. p1}, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->getAxisLenght(Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)I

    move-result v0

    add-int/lit8 v4, v0, 0x1

    const/4 v7, 0x0

    :try_start_7
    invoke-virtual/range {p1 .. p1}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->getFile()Ljava/io/File;

    move-result-object v1

    new-instance v8, Ljava/io/FileInputStream;

    invoke-direct {v8, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_10
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_10} :catch_57
    .catchall {:try_start_7 .. :try_end_10} :catchall_53

    :try_start_10
    invoke-virtual {v8}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v15
    :try_end_14
    .catch Ljava/io/IOException; {:try_start_10 .. :try_end_14} :catch_50
    .catchall {:try_start_10 .. :try_end_14} :catchall_4d

    :try_start_14
    sget-object v10, Ljava/nio/channels/FileChannel$MapMode;->READ_ONLY:Ljava/nio/channels/FileChannel$MapMode;

    const-wide/16 v11, 0x0

    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v13

    move-object v9, v15

    invoke-virtual/range {v9 .. v14}, Ljava/nio/channels/FileChannel;->map(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;

    move-result-object v2

    sget-object v1, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {v2, v1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    move-object/from16 v1, p0

    move v3, v0

    move/from16 v5, p2

    move-object/from16 v6, p1

    invoke-direct/range {v1 .. v6}, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->convert(Ljava/nio/MappedByteBuffer;IIILorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)[B

    move-result-object v1

    new-instance v2, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;

    move/from16 v3, p2

    invoke-direct {v2, v1, v0, v0, v3}, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;-><init>([BIII)V
    :try_end_38
    .catch Ljava/io/IOException; {:try_start_14 .. :try_end_38} :catch_4b
    .catchall {:try_start_14 .. :try_end_38} :catchall_7c

    :try_start_38
    invoke-virtual {v15}, Ljava/nio/channels/spi/AbstractInterruptibleChannel;->close()V
    :try_end_3b
    .catch Ljava/io/IOException; {:try_start_38 .. :try_end_3b} :catch_3c

    goto :goto_41

    :catch_3c
    move-exception v0

    move-object v1, v0

    invoke-virtual {v1}, Ljava/lang/Throwable;->printStackTrace()V

    :goto_41
    :try_start_41
    invoke-virtual {v8}, Ljava/io/FileInputStream;->close()V
    :try_end_44
    .catch Ljava/io/IOException; {:try_start_41 .. :try_end_44} :catch_45

    goto :goto_4a

    :catch_45
    move-exception v0

    move-object v1, v0

    invoke-virtual {v1}, Ljava/lang/Throwable;->printStackTrace()V

    :goto_4a
    return-object v2

    :catch_4b
    move-exception v0

    goto :goto_5a

    :catchall_4d
    move-exception v0

    move-object v1, v0

    goto :goto_7f

    :catch_50
    move-exception v0

    move-object v15, v7

    goto :goto_5a

    :catchall_53
    move-exception v0

    move-object v1, v0

    move-object v8, v7

    goto :goto_7f

    :catch_57
    move-exception v0

    move-object v8, v7

    move-object v15, v8

    :goto_5a
    :try_start_5a
    sget-object v1, Lorg/mapsforge/map/layer/hills/DiffuseLightShadingAlgorithm;->LOGGER:Ljava/util/logging/Logger;

    sget-object v2, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v0}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_65
    .catchall {:try_start_5a .. :try_end_65} :catchall_7c

    if-eqz v15, :cond_70

    :try_start_67
    invoke-virtual {v15}, Ljava/nio/channels/spi/AbstractInterruptibleChannel;->close()V
    :try_end_6a
    .catch Ljava/io/IOException; {:try_start_67 .. :try_end_6a} :catch_6b

    goto :goto_70

    :catch_6b
    move-exception v0

    move-object v1, v0

    invoke-virtual {v1}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_70
    :goto_70
    if-eqz v8, :cond_7b

    :try_start_72
    invoke-virtual {v8}, Ljava/io/FileInputStream;->close()V
    :try_end_75
    .catch Ljava/io/IOException; {:try_start_72 .. :try_end_75} :catch_76

    goto :goto_7b

    :catch_76
    move-exception v0

    move-object v1, v0

    invoke-virtual {v1}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_7b
    :goto_7b
    return-object v7

    :catchall_7c
    move-exception v0

    move-object v1, v0

    move-object v7, v15

    :goto_7f
    if-eqz v7, :cond_8a

    :try_start_81
    invoke-virtual {v7}, Ljava/nio/channels/spi/AbstractInterruptibleChannel;->close()V
    :try_end_84
    .catch Ljava/io/IOException; {:try_start_81 .. :try_end_84} :catch_85

    goto :goto_8a

    :catch_85
    move-exception v0

    move-object v2, v0

    invoke-virtual {v2}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_8a
    :goto_8a
    if-eqz v8, :cond_95

    :try_start_8c
    invoke-virtual {v8}, Ljava/io/FileInputStream;->close()V
    :try_end_8f
    .catch Ljava/io/IOException; {:try_start_8c .. :try_end_8f} :catch_90

    goto :goto_95

    :catch_90
    move-exception v0

    move-object v2, v0

    invoke-virtual {v2}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_95
    :goto_95
    throw v1
.end method
