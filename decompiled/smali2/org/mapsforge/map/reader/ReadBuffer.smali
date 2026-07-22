.class public Lorg/mapsforge/map/reader/ReadBuffer;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final CHARSET_UTF8:Ljava/lang/String; = "UTF-8"

.field private static final LOGGER:Ljava/util/logging/Logger;


# instance fields
.field private bufferData:[B

.field private bufferPosition:I

.field private bufferWrapper:Ljava/nio/ByteBuffer;

.field private final inputChannel:Ljava/nio/channels/FileChannel;

.field private final tagIds:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/reader/ReadBuffer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/reader/ReadBuffer;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method constructor <init>(Ljava/nio/channels/FileChannel;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->tagIds:Ljava/util/List;

    iput-object p1, p0, Lorg/mapsforge/map/reader/ReadBuffer;->inputChannel:Ljava/nio/channels/FileChannel;

    return-void
.end method


# virtual methods
.method getBufferPosition()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    return v0
.end method

.method getBufferSize()I
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferData:[B

    array-length v0, v0

    return v0
.end method

.method public readByte()B
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferData:[B

    iget v1, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    aget-byte v0, v0, v1

    return v0
.end method

.method public readFloat()F
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readInt()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v0

    return v0
.end method

.method public readFromFile(I)Z
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferData:[B

    const/4 v1, 0x0

    if-eqz v0, :cond_8

    array-length v0, v0

    if-ge v0, p1, :cond_2d

    :cond_8
    sget v0, Lorg/mapsforge/core/util/Parameters;->MAXIMUM_BUFFER_SIZE:I

    if-le p1, v0, :cond_23

    sget-object v0, Lorg/mapsforge/map/reader/ReadBuffer;->LOGGER:Ljava/util/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "invalid read length: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return v1

    :cond_23
    new-array v0, p1, [B

    iput-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferData:[B

    invoke-static {v0, v1, p1}, Ljava/nio/ByteBuffer;->wrap([BII)Ljava/nio/ByteBuffer;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferWrapper:Ljava/nio/ByteBuffer;

    :cond_2d
    iput v1, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    iget-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferWrapper:Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    iget-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->inputChannel:Ljava/nio/channels/FileChannel;

    iget-object v2, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferWrapper:Ljava/nio/ByteBuffer;

    invoke-virtual {v0, v2}, Ljava/nio/channels/FileChannel;->read(Ljava/nio/ByteBuffer;)I

    move-result v0

    if-ne v0, p1, :cond_3f

    const/4 v1, 0x1

    :cond_3f
    return v1
.end method

.method public readFromFile(JI)Z
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferData:[B

    const/4 v1, 0x0

    if-eqz v0, :cond_8

    array-length v0, v0

    if-ge v0, p3, :cond_2d

    :cond_8
    sget v0, Lorg/mapsforge/core/util/Parameters;->MAXIMUM_BUFFER_SIZE:I

    if-le p3, v0, :cond_23

    sget-object p1, Lorg/mapsforge/map/reader/ReadBuffer;->LOGGER:Ljava/util/logging/Logger;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "invalid read length: "

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    return v1

    :cond_23
    new-array v0, p3, [B

    iput-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferData:[B

    invoke-static {v0, v1, p3}, Ljava/nio/ByteBuffer;->wrap([BII)Ljava/nio/ByteBuffer;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferWrapper:Ljava/nio/ByteBuffer;

    :cond_2d
    iput v1, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    iget-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferWrapper:Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    iget-object v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->inputChannel:Ljava/nio/channels/FileChannel;

    monitor-enter v0

    :try_start_37
    iget-object v2, p0, Lorg/mapsforge/map/reader/ReadBuffer;->inputChannel:Ljava/nio/channels/FileChannel;

    invoke-virtual {v2, p1, p2}, Ljava/nio/channels/FileChannel;->position(J)Ljava/nio/channels/FileChannel;

    iget-object p1, p0, Lorg/mapsforge/map/reader/ReadBuffer;->inputChannel:Ljava/nio/channels/FileChannel;

    iget-object p2, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferWrapper:Ljava/nio/ByteBuffer;

    invoke-virtual {p1, p2}, Ljava/nio/channels/FileChannel;->read(Ljava/nio/ByteBuffer;)I

    move-result p1

    if-ne p1, p3, :cond_47

    const/4 v1, 0x1

    :cond_47
    monitor-exit v0

    return v1

    :catchall_49
    move-exception p1

    monitor-exit v0
    :try_end_4b
    .catchall {:try_start_37 .. :try_end_4b} :catchall_49

    throw p1
.end method

.method public readInt()I
    .registers 3

    iget v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    add-int/lit8 v0, v0, 0x4

    iput v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    iget-object v1, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferData:[B

    add-int/lit8 v0, v0, -0x4

    invoke-static {v1, v0}, Lorg/mapsforge/map/reader/Deserializer;->getInt([BI)I

    move-result v0

    return v0
.end method

.method public readLong()J
    .registers 3

    iget v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    add-int/lit8 v0, v0, 0x8

    iput v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    iget-object v1, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferData:[B

    add-int/lit8 v0, v0, -0x8

    invoke-static {v1, v0}, Lorg/mapsforge/map/reader/Deserializer;->getLong([BI)J

    move-result-wide v0

    return-wide v0
.end method

.method public readShort()I
    .registers 3

    iget v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    add-int/lit8 v0, v0, 0x2

    iput v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    iget-object v1, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferData:[B

    add-int/lit8 v0, v0, -0x2

    invoke-static {v1, v0}, Lorg/mapsforge/map/reader/Deserializer;->getShort([BI)I

    move-result v0

    return v0
.end method

.method public readSignedInt()I
    .registers 6

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    iget-object v2, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferData:[B

    iget v3, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    aget-byte v2, v2, v3

    and-int/lit16 v4, v2, 0x80

    if-eqz v4, :cond_18

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    and-int/lit8 v2, v2, 0x7f

    shl-int/2addr v2, v1

    or-int/2addr v0, v2

    add-int/lit8 v1, v1, 0x7

    int-to-byte v1, v1

    goto :goto_2

    :cond_18
    and-int/lit8 v4, v2, 0x40

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    and-int/lit8 v2, v2, 0x3f

    shl-int v1, v2, v1

    or-int/2addr v0, v1

    if-eqz v4, :cond_26

    neg-int v0, v0

    :cond_26
    return v0
.end method

.method readTags([Lorg/mapsforge/core/model/Tag;B)Ljava/util/List;
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lorg/mapsforge/core/model/Tag;",
            "B)",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iget-object v1, p0, Lorg/mapsforge/map/reader/ReadBuffer;->tagIds:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    array-length v1, p1

    :goto_b
    if-eqz p2, :cond_3b

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readUnsignedInt()I

    move-result v2

    if-ltz v2, :cond_23

    if-lt v2, v1, :cond_16

    goto :goto_23

    :cond_16
    iget-object v3, p0, Lorg/mapsforge/map/reader/ReadBuffer;->tagIds:Ljava/util/List;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 p2, p2, -0x1

    int-to-byte p2, p2

    goto :goto_b

    :cond_23
    :goto_23
    sget-object p1, Lorg/mapsforge/map/reader/ReadBuffer;->LOGGER:Ljava/util/logging/Logger;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "invalid tag ID: "

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    const/4 p1, 0x0

    return-object p1

    :cond_3b
    iget-object p2, p0, Lorg/mapsforge/map/reader/ReadBuffer;->tagIds:Ljava/util/List;

    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p2

    :goto_41
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_e3

    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    aget-object v1, p1, v1

    iget-object v2, v1, Lorg/mapsforge/core/model/Tag;->value:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v3, 0x2

    if-ne v2, v3, :cond_de

    iget-object v2, v1, Lorg/mapsforge/core/model/Tag;->value:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x25

    if-ne v2, v3, :cond_de

    iget-object v2, v1, Lorg/mapsforge/core/model/Tag;->value:Ljava/lang/String;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x62

    if-ne v4, v5, :cond_7b

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readByte()B

    move-result v2

    :goto_76
    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_d6

    :cond_7b
    invoke-virtual {v2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x69

    if-ne v4, v5, :cond_ac

    iget-object v2, v1, Lorg/mapsforge/core/model/Tag;->key:Ljava/lang/String;

    const-string v3, ":colour"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_a7

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "#"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readInt()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_d6

    :cond_a7
    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readInt()I

    move-result v2

    goto :goto_76

    :cond_ac
    invoke-virtual {v2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x66

    if-ne v4, v5, :cond_bd

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readFloat()F

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v2

    goto :goto_d6

    :cond_bd
    invoke-virtual {v2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x68

    if-ne v4, v5, :cond_ca

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readShort()I

    move-result v2

    goto :goto_76

    :cond_ca
    invoke-virtual {v2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0x73

    if-ne v3, v4, :cond_d6

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString()Ljava/lang/String;

    move-result-object v2

    :cond_d6
    :goto_d6
    new-instance v3, Lorg/mapsforge/core/model/Tag;

    iget-object v1, v1, Lorg/mapsforge/core/model/Tag;->key:Ljava/lang/String;

    invoke-direct {v3, v1, v2}, Lorg/mapsforge/core/model/Tag;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v3

    :cond_de
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_41

    :cond_e3
    return-object v0
.end method

.method public readUTF8EncodedString()Ljava/lang/String;
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/reader/ReadBuffer;->readUnsignedInt()I

    move-result v0

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/reader/ReadBuffer;->readUTF8EncodedString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public readUTF8EncodedString(I)Ljava/lang/String;
    .registers 6

    if-lez p1, :cond_1e

    iget v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    add-int v1, v0, p1

    iget-object v2, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferData:[B

    array-length v3, v2

    if-gt v1, v3, :cond_1e

    add-int/2addr v0, p1

    iput v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    :try_start_e
    new-instance v1, Ljava/lang/String;

    sub-int/2addr v0, p1

    const-string v3, "UTF-8"

    invoke-direct {v1, v2, v0, p1, v3}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
    :try_end_16
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_e .. :try_end_16} :catch_17

    return-object v1

    :catch_17
    move-exception p1

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v0

    :cond_1e
    sget-object v0, Lorg/mapsforge/map/reader/ReadBuffer;->LOGGER:Ljava/util/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid string length: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    const/4 p1, 0x0

    return-object p1
.end method

.method public readUnsignedInt()I
    .registers 6

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    iget-object v2, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferData:[B

    iget v3, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    aget-byte v2, v2, v3

    and-int/lit16 v4, v2, 0x80

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    if-eqz v4, :cond_18

    and-int/lit8 v2, v2, 0x7f

    shl-int/2addr v2, v1

    or-int/2addr v0, v2

    add-int/lit8 v1, v1, 0x7

    int-to-byte v1, v1

    goto :goto_2

    :cond_18
    shl-int v1, v2, v1

    or-int/2addr v0, v1

    return v0
.end method

.method setBufferPosition(I)V
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    return-void
.end method

.method skipBytes(I)V
    .registers 3

    iget v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    add-int/2addr v0, p1

    iput v0, p0, Lorg/mapsforge/map/reader/ReadBuffer;->bufferPosition:I

    return-void
.end method
