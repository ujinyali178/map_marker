.class final Lorg/mapsforge/map/reader/header/OptionalFields;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final HEADER_BITMASK_COMMENT:I = 0x8

.field private static final HEADER_BITMASK_CREATED_BY:I = 0x4

.field private static final HEADER_BITMASK_DEBUG:I = 0x80

.field private static final HEADER_BITMASK_LANGUAGES_PREFERENCE:I = 0x10

.field private static final HEADER_BITMASK_START_POSITION:I = 0x40

.field private static final HEADER_BITMASK_START_ZOOM_LEVEL:I = 0x20

.field private static final START_ZOOM_LEVEL_MAX:I = 0x16


# instance fields
.field comment:Ljava/lang/String;

.field createdBy:Ljava/lang/String;

.field final hasComment:Z

.field final hasCreatedBy:Z

.field final hasLanguagesPreference:Z

.field final hasStartPosition:Z

.field final hasStartZoomLevel:Z

.field final isDebugFile:Z

.field languagesPreference:Ljava/lang/String;

.field startPosition:Lorg/mapsforge/core/model/LatLong;

.field startZoomLevel:Ljava/lang/Byte;


# direct methods
.method private constructor <init>(B)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    and-int/lit16 v0, p1, 0x80

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz v0, :cond_b

    const/4 v0, 0x1

    goto :goto_c

    :cond_b
    const/4 v0, 0x0

    :goto_c
    iput-boolean v0, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->isDebugFile:Z

    and-int/lit8 v0, p1, 0x40

    if-eqz v0, :cond_14

    const/4 v0, 0x1

    goto :goto_15

    :cond_14
    const/4 v0, 0x0

    :goto_15
    iput-boolean v0, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->hasStartPosition:Z

    and-int/lit8 v0, p1, 0x20

    if-eqz v0, :cond_1d

    const/4 v0, 0x1

    goto :goto_1e

    :cond_1d
    const/4 v0, 0x0

    :goto_1e
    iput-boolean v0, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->hasStartZoomLevel:Z

    and-int/lit8 v0, p1, 0x10

    if-eqz v0, :cond_26

    const/4 v0, 0x1

    goto :goto_27

    :cond_26
    const/4 v0, 0x0

    :goto_27
    iput-boolean v0, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->hasLanguagesPreference:Z

    and-int/lit8 v0, p1, 0x8

    if-eqz v0, :cond_2f

    const/4 v0, 0x1

    goto :goto_30

    :cond_2f
    const/4 v0, 0x0

    :goto_30
    iput-boolean v0, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->hasComment:Z

    and-int/lit8 p1, p1, 0x4

    if-eqz p1, :cond_37

    goto :goto_38

    :cond_37
    const/4 v1, 0x0

    :goto_38
    iput-boolean v1, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->hasCreatedBy:Z

    return-void
.end method

.method private readLanguagesPreference(Lorg/mapsforge/map/reader/ReadBuffer;)V
    .registers 3

    iget-boolean v0, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->hasLanguagesPreference:Z

    if-eqz v0, :cond_a

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString()Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->languagesPreference:Ljava/lang/String;

    :cond_a
    return-void
.end method

.method private readMapStartPosition(Lorg/mapsforge/map/reader/ReadBuffer;)V
    .registers 6

    iget-boolean v0, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->hasStartPosition:Z

    if-eqz v0, :cond_27

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readInt()I

    move-result v0

    invoke-static {v0}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v0

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readInt()I

    move-result p1

    invoke-static {p1}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v2

    :try_start_14
    new-instance p1, Lorg/mapsforge/core/model/LatLong;

    invoke-direct {p1, v0, v1, v2, v3}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    iput-object p1, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->startPosition:Lorg/mapsforge/core/model/LatLong;
    :try_end_1b
    .catch Ljava/lang/IllegalArgumentException; {:try_start_14 .. :try_end_1b} :catch_1c

    goto :goto_27

    :catch_1c
    move-exception p1

    new-instance v0, Lorg/mapsforge/map/reader/header/MapFileException;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_27
    :goto_27
    return-void
.end method

.method private readMapStartZoomLevel(Lorg/mapsforge/map/reader/ReadBuffer;)V
    .registers 5

    iget-boolean v0, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->hasStartZoomLevel:Z

    if-eqz v0, :cond_2c

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readByte()B

    move-result p1

    if-ltz p1, :cond_15

    const/16 v0, 0x16

    if-gt p1, v0, :cond_15

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->startZoomLevel:Ljava/lang/Byte;

    goto :goto_2c

    :cond_15
    new-instance v0, Lorg/mapsforge/map/reader/header/MapFileException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid map start zoom level: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Lorg/mapsforge/map/reader/header/MapFileException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2c
    :goto_2c
    return-void
.end method

.method private readOptionalFields(Lorg/mapsforge/map/reader/ReadBuffer;)V
    .registers 3

    invoke-direct {p0, p1}, Lorg/mapsforge/map/reader/header/OptionalFields;->readMapStartPosition(Lorg/mapsforge/map/reader/ReadBuffer;)V

    invoke-direct {p0, p1}, Lorg/mapsforge/map/reader/header/OptionalFields;->readMapStartZoomLevel(Lorg/mapsforge/map/reader/ReadBuffer;)V

    invoke-direct {p0, p1}, Lorg/mapsforge/map/reader/header/OptionalFields;->readLanguagesPreference(Lorg/mapsforge/map/reader/ReadBuffer;)V

    iget-boolean v0, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->hasComment:Z

    if-eqz v0, :cond_13

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->comment:Ljava/lang/String;

    :cond_13
    iget-boolean v0, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->hasCreatedBy:Z

    if-eqz v0, :cond_1d

    invoke-virtual {p1}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString()Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/reader/header/OptionalFields;->createdBy:Ljava/lang/String;

    :cond_1d
    return-void
.end method

.method static readOptionalFields(Lorg/mapsforge/map/reader/ReadBuffer;Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;)V
    .registers 4

    new-instance v0, Lorg/mapsforge/map/reader/header/OptionalFields;

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readByte()B

    move-result v1

    invoke-direct {v0, v1}, Lorg/mapsforge/map/reader/header/OptionalFields;-><init>(B)V

    iput-object v0, p1, Lorg/mapsforge/map/reader/header/MapFileInfoBuilder;->optionalFields:Lorg/mapsforge/map/reader/header/OptionalFields;

    invoke-direct {v0, p0}, Lorg/mapsforge/map/reader/header/OptionalFields;->readOptionalFields(Lorg/mapsforge/map/reader/ReadBuffer;)V

    return-void
.end method
