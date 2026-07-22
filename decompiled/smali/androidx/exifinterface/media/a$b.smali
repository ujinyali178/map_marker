.class Landroidx/exifinterface/media/a$b;
.super Ljava/io/InputStream;
.source "SourceFile"

# interfaces
.implements Ljava/io/DataInput;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/exifinterface/media/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "b"
.end annotation


# static fields
.field private static final h:Ljava/nio/ByteOrder;

.field private static final i:Ljava/nio/ByteOrder;


# instance fields
.field final c:Ljava/io/DataInputStream;

.field private d:Ljava/nio/ByteOrder;

.field f:I

.field private g:[B


# direct methods
.method static constructor <clinit>()V
    .registers 1

    sget-object v0, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    sput-object v0, Landroidx/exifinterface/media/a$b;->h:Ljava/nio/ByteOrder;

    sget-object v0, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    sput-object v0, Landroidx/exifinterface/media/a$b;->i:Ljava/nio/ByteOrder;

    return-void
.end method

.method constructor <init>(Ljava/io/InputStream;)V
    .registers 3

    sget-object v0, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    invoke-direct {p0, p1, v0}, Landroidx/exifinterface/media/a$b;-><init>(Ljava/io/InputStream;Ljava/nio/ByteOrder;)V

    return-void
.end method

.method constructor <init>(Ljava/io/InputStream;Ljava/nio/ByteOrder;)V
    .registers 4

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    sget-object v0, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    iput-object v0, p0, Landroidx/exifinterface/media/a$b;->d:Ljava/nio/ByteOrder;

    new-instance v0, Ljava/io/DataInputStream;

    invoke-direct {v0, p1}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    iput-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    const/4 p1, 0x0

    invoke-virtual {v0, p1}, Ljava/io/InputStream;->mark(I)V

    iput p1, p0, Landroidx/exifinterface/media/a$b;->f:I

    iput-object p2, p0, Landroidx/exifinterface/media/a$b;->d:Ljava/nio/ByteOrder;

    return-void
.end method

.method constructor <init>([B)V
    .registers 3

    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, p1}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    sget-object p1, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    invoke-direct {p0, v0, p1}, Landroidx/exifinterface/media/a$b;-><init>(Ljava/io/InputStream;Ljava/nio/ByteOrder;)V

    return-void
.end method


# virtual methods
.method public a()I
    .registers 2

    iget v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    return v0
.end method

.method public available()I
    .registers 2

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->available()I

    move-result v0

    return v0
.end method

.method public b()J
    .registers 5

    invoke-virtual {p0}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v0

    int-to-long v0, v0

    const-wide v2, 0xffffffffL

    and-long/2addr v0, v2

    return-wide v0
.end method

.method public c(Ljava/nio/ByteOrder;)V
    .registers 2

    iput-object p1, p0, Landroidx/exifinterface/media/a$b;->d:Ljava/nio/ByteOrder;

    return-void
.end method

.method public d(I)V
    .registers 8

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    if-ge v1, p1, :cond_48

    iget-object v2, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    sub-int v3, p1, v1

    int-to-long v4, v3

    invoke-virtual {v2, v4, v5}, Ljava/io/InputStream;->skip(J)J

    move-result-wide v4

    long-to-int v2, v4

    if-gtz v2, :cond_46

    iget-object v2, p0, Landroidx/exifinterface/media/a$b;->g:[B

    const/16 v4, 0x2000

    if-nez v2, :cond_1a

    new-array v2, v4, [B

    iput-object v2, p0, Landroidx/exifinterface/media/a$b;->g:[B

    :cond_1a
    invoke-static {v4, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    iget-object v3, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    iget-object v4, p0, Landroidx/exifinterface/media/a$b;->g:[B

    invoke-virtual {v3, v4, v0, v2}, Ljava/io/DataInputStream;->read([BII)I

    move-result v2

    const/4 v3, -0x1

    if-eq v2, v3, :cond_2a

    goto :goto_46

    :cond_2a
    new-instance v0, Ljava/io/EOFException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Reached EOF while skipping "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " bytes."

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/io/EOFException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_46
    :goto_46
    add-int/2addr v1, v2

    goto :goto_2

    :cond_48
    iget p1, p0, Landroidx/exifinterface/media/a$b;->f:I

    add-int/2addr p1, v1

    iput p1, p0, Landroidx/exifinterface/media/a$b;->f:I

    return-void
.end method

.method public mark(I)V
    .registers 3

    new-instance p1, Ljava/lang/UnsupportedOperationException;

    const-string v0, "Mark is currently unsupported"

    invoke-direct {p1, v0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public read()I
    .registers 2

    iget v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    return v0
.end method

.method public read([BII)I
    .registers 5

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/DataInputStream;->read([BII)I

    move-result p1

    iget p2, p0, Landroidx/exifinterface/media/a$b;->f:I

    add-int/2addr p2, p1

    iput p2, p0, Landroidx/exifinterface/media/a$b;->f:I

    return p1
.end method

.method public readBoolean()Z
    .registers 2

    iget v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v0

    return v0
.end method

.method public readByte()B
    .registers 2

    iget v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    if-ltz v0, :cond_10

    int-to-byte v0, v0

    return v0

    :cond_10
    new-instance v0, Ljava/io/EOFException;

    invoke-direct {v0}, Ljava/io/EOFException;-><init>()V

    throw v0
.end method

.method public readChar()C
    .registers 2

    iget v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    add-int/lit8 v0, v0, 0x2

    iput v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readChar()C

    move-result v0

    return v0
.end method

.method public readDouble()D
    .registers 3

    invoke-virtual {p0}, Landroidx/exifinterface/media/a$b;->readLong()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v0

    return-wide v0
.end method

.method public readFloat()F
    .registers 2

    invoke-virtual {p0}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v0

    return v0
.end method

.method public readFully([B)V
    .registers 4

    iget v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    array-length v1, p1

    add-int/2addr v0, v1

    iput v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0, p1}, Ljava/io/DataInputStream;->readFully([B)V

    return-void
.end method

.method public readFully([BII)V
    .registers 5

    iget v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    add-int/2addr v0, p3

    iput v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/DataInputStream;->readFully([BII)V

    return-void
.end method

.method public readInt()I
    .registers 7

    iget v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    add-int/lit8 v0, v0, 0x4

    iput v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    iget-object v1, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v1}, Ljava/io/InputStream;->read()I

    move-result v1

    iget-object v2, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v2}, Ljava/io/InputStream;->read()I

    move-result v2

    iget-object v3, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v3}, Ljava/io/InputStream;->read()I

    move-result v3

    or-int v4, v0, v1

    or-int/2addr v4, v2

    or-int/2addr v4, v3

    if-ltz v4, :cond_5b

    iget-object v4, p0, Landroidx/exifinterface/media/a$b;->d:Ljava/nio/ByteOrder;

    sget-object v5, Landroidx/exifinterface/media/a$b;->h:Ljava/nio/ByteOrder;

    if-ne v4, v5, :cond_34

    shl-int/lit8 v3, v3, 0x18

    shl-int/lit8 v2, v2, 0x10

    add-int/2addr v3, v2

    shl-int/lit8 v1, v1, 0x8

    add-int/2addr v3, v1

    add-int/2addr v3, v0

    return v3

    :cond_34
    sget-object v5, Landroidx/exifinterface/media/a$b;->i:Ljava/nio/ByteOrder;

    if-ne v4, v5, :cond_42

    shl-int/lit8 v0, v0, 0x18

    shl-int/lit8 v1, v1, 0x10

    add-int/2addr v0, v1

    shl-int/lit8 v1, v2, 0x8

    add-int/2addr v0, v1

    add-int/2addr v0, v3

    return v0

    :cond_42
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid byte order: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Landroidx/exifinterface/media/a$b;->d:Ljava/nio/ByteOrder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_5b
    new-instance v0, Ljava/io/EOFException;

    invoke-direct {v0}, Ljava/io/EOFException;-><init>()V

    throw v0
.end method

.method public readLine()Ljava/lang/String;
    .registers 3

    const-string v0, "ExifInterface"

    const-string v1, "Currently unsupported"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v0, 0x0

    return-object v0
.end method

.method public readLong()J
    .registers 20

    move-object/from16 v0, p0

    iget v1, v0, Landroidx/exifinterface/media/a$b;->f:I

    const/16 v2, 0x8

    add-int/2addr v1, v2

    iput v1, v0, Landroidx/exifinterface/media/a$b;->f:I

    iget-object v1, v0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v1}, Ljava/io/InputStream;->read()I

    move-result v1

    iget-object v3, v0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v3}, Ljava/io/InputStream;->read()I

    move-result v3

    iget-object v4, v0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v4}, Ljava/io/InputStream;->read()I

    move-result v4

    iget-object v5, v0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v5}, Ljava/io/InputStream;->read()I

    move-result v5

    iget-object v6, v0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v6}, Ljava/io/InputStream;->read()I

    move-result v6

    iget-object v7, v0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v7}, Ljava/io/InputStream;->read()I

    move-result v7

    iget-object v8, v0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v8}, Ljava/io/InputStream;->read()I

    move-result v8

    iget-object v9, v0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v9}, Ljava/io/InputStream;->read()I

    move-result v9

    or-int v10, v1, v3

    or-int/2addr v10, v4

    or-int/2addr v10, v5

    or-int/2addr v10, v6

    or-int/2addr v10, v7

    or-int/2addr v10, v8

    or-int/2addr v10, v9

    if-ltz v10, :cond_af

    iget-object v10, v0, Landroidx/exifinterface/media/a$b;->d:Ljava/nio/ByteOrder;

    sget-object v11, Landroidx/exifinterface/media/a$b;->h:Ljava/nio/ByteOrder;

    const/16 v12, 0x10

    const/16 v13, 0x18

    const/16 v14, 0x20

    const/16 v15, 0x28

    const/16 v16, 0x30

    const/16 v17, 0x38

    if-ne v10, v11, :cond_74

    int-to-long v9, v9

    shl-long v9, v9, v17

    move/from16 v18, v3

    int-to-long v2, v8

    shl-long v2, v2, v16

    add-long/2addr v9, v2

    int-to-long v2, v7

    shl-long/2addr v2, v15

    add-long/2addr v9, v2

    int-to-long v2, v6

    shl-long/2addr v2, v14

    add-long/2addr v9, v2

    int-to-long v2, v5

    shl-long/2addr v2, v13

    add-long/2addr v9, v2

    int-to-long v2, v4

    shl-long/2addr v2, v12

    add-long/2addr v9, v2

    move/from16 v2, v18

    int-to-long v2, v2

    const/16 v4, 0x8

    shl-long/2addr v2, v4

    add-long/2addr v9, v2

    int-to-long v1, v1

    add-long/2addr v9, v1

    return-wide v9

    :cond_74
    move v2, v3

    sget-object v3, Landroidx/exifinterface/media/a$b;->i:Ljava/nio/ByteOrder;

    if-ne v10, v3, :cond_96

    int-to-long v11, v1

    shl-long v11, v11, v17

    int-to-long v1, v2

    shl-long v1, v1, v16

    add-long/2addr v11, v1

    int-to-long v1, v4

    shl-long/2addr v1, v15

    add-long/2addr v11, v1

    int-to-long v1, v5

    shl-long/2addr v1, v14

    add-long/2addr v11, v1

    int-to-long v1, v6

    shl-long/2addr v1, v13

    add-long/2addr v11, v1

    int-to-long v1, v7

    const/16 v4, 0x10

    shl-long/2addr v1, v4

    add-long/2addr v11, v1

    int-to-long v1, v8

    const/16 v3, 0x8

    shl-long/2addr v1, v3

    add-long/2addr v11, v1

    int-to-long v1, v9

    add-long/2addr v11, v1

    return-wide v11

    :cond_96
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid byte order: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, v0, Landroidx/exifinterface/media/a$b;->d:Ljava/nio/ByteOrder;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_af
    new-instance v1, Ljava/io/EOFException;

    invoke-direct {v1}, Ljava/io/EOFException;-><init>()V

    throw v1
.end method

.method public readShort()S
    .registers 5

    iget v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    add-int/lit8 v0, v0, 0x2

    iput v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    iget-object v1, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v1}, Ljava/io/InputStream;->read()I

    move-result v1

    or-int v2, v0, v1

    if-ltz v2, :cond_43

    iget-object v2, p0, Landroidx/exifinterface/media/a$b;->d:Ljava/nio/ByteOrder;

    sget-object v3, Landroidx/exifinterface/media/a$b;->h:Ljava/nio/ByteOrder;

    if-ne v2, v3, :cond_21

    shl-int/lit8 v1, v1, 0x8

    add-int/2addr v1, v0

    int-to-short v0, v1

    return v0

    :cond_21
    sget-object v3, Landroidx/exifinterface/media/a$b;->i:Ljava/nio/ByteOrder;

    if-ne v2, v3, :cond_2a

    shl-int/lit8 v0, v0, 0x8

    add-int/2addr v0, v1

    int-to-short v0, v0

    return v0

    :cond_2a
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid byte order: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Landroidx/exifinterface/media/a$b;->d:Ljava/nio/ByteOrder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_43
    new-instance v0, Ljava/io/EOFException;

    invoke-direct {v0}, Ljava/io/EOFException;-><init>()V

    throw v0
.end method

.method public readUTF()Ljava/lang/String;
    .registers 2

    iget v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    add-int/lit8 v0, v0, 0x2

    iput v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readUTF()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public readUnsignedByte()I
    .registers 2

    iget v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readUnsignedByte()I

    move-result v0

    return v0
.end method

.method public readUnsignedShort()I
    .registers 5

    iget v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    add-int/lit8 v0, v0, 0x2

    iput v0, p0, Landroidx/exifinterface/media/a$b;->f:I

    iget-object v0, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    iget-object v1, p0, Landroidx/exifinterface/media/a$b;->c:Ljava/io/DataInputStream;

    invoke-virtual {v1}, Ljava/io/InputStream;->read()I

    move-result v1

    or-int v2, v0, v1

    if-ltz v2, :cond_41

    iget-object v2, p0, Landroidx/exifinterface/media/a$b;->d:Ljava/nio/ByteOrder;

    sget-object v3, Landroidx/exifinterface/media/a$b;->h:Ljava/nio/ByteOrder;

    if-ne v2, v3, :cond_20

    shl-int/lit8 v1, v1, 0x8

    add-int/2addr v1, v0

    return v1

    :cond_20
    sget-object v3, Landroidx/exifinterface/media/a$b;->i:Ljava/nio/ByteOrder;

    if-ne v2, v3, :cond_28

    shl-int/lit8 v0, v0, 0x8

    add-int/2addr v0, v1

    return v0

    :cond_28
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid byte order: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Landroidx/exifinterface/media/a$b;->d:Ljava/nio/ByteOrder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_41
    new-instance v0, Ljava/io/EOFException;

    invoke-direct {v0}, Ljava/io/EOFException;-><init>()V

    throw v0
.end method

.method public reset()V
    .registers 3

    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Reset is currently unsupported"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public skipBytes(I)I
    .registers 3

    new-instance p1, Ljava/lang/UnsupportedOperationException;

    const-string v0, "skipBytes is currently unsupported"

    invoke-direct {p1, v0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
