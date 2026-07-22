.class public Lorg/apache/commons/io/ByteOrderMark;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field public static final UTF_16BE:Lorg/apache/commons/io/ByteOrderMark;

.field public static final UTF_16LE:Lorg/apache/commons/io/ByteOrderMark;

.field public static final UTF_32BE:Lorg/apache/commons/io/ByteOrderMark;

.field public static final UTF_32LE:Lorg/apache/commons/io/ByteOrderMark;

.field public static final UTF_8:Lorg/apache/commons/io/ByteOrderMark;

.field public static final UTF_BOM:C = '\ufeff'

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private final bytes:[I

.field private final charsetName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 4

    new-instance v0, Lorg/apache/commons/io/ByteOrderMark;

    const/4 v1, 0x3

    new-array v1, v1, [I

    fill-array-data v1, :array_4a

    const-string v2, "UTF-8"

    invoke-direct {v0, v2, v1}, Lorg/apache/commons/io/ByteOrderMark;-><init>(Ljava/lang/String;[I)V

    sput-object v0, Lorg/apache/commons/io/ByteOrderMark;->UTF_8:Lorg/apache/commons/io/ByteOrderMark;

    new-instance v0, Lorg/apache/commons/io/ByteOrderMark;

    const/4 v1, 0x2

    new-array v2, v1, [I

    fill-array-data v2, :array_54

    const-string v3, "UTF-16BE"

    invoke-direct {v0, v3, v2}, Lorg/apache/commons/io/ByteOrderMark;-><init>(Ljava/lang/String;[I)V

    sput-object v0, Lorg/apache/commons/io/ByteOrderMark;->UTF_16BE:Lorg/apache/commons/io/ByteOrderMark;

    new-instance v0, Lorg/apache/commons/io/ByteOrderMark;

    new-array v1, v1, [I

    fill-array-data v1, :array_5c

    const-string v2, "UTF-16LE"

    invoke-direct {v0, v2, v1}, Lorg/apache/commons/io/ByteOrderMark;-><init>(Ljava/lang/String;[I)V

    sput-object v0, Lorg/apache/commons/io/ByteOrderMark;->UTF_16LE:Lorg/apache/commons/io/ByteOrderMark;

    new-instance v0, Lorg/apache/commons/io/ByteOrderMark;

    const/4 v1, 0x4

    new-array v2, v1, [I

    fill-array-data v2, :array_64

    const-string v3, "UTF-32BE"

    invoke-direct {v0, v3, v2}, Lorg/apache/commons/io/ByteOrderMark;-><init>(Ljava/lang/String;[I)V

    sput-object v0, Lorg/apache/commons/io/ByteOrderMark;->UTF_32BE:Lorg/apache/commons/io/ByteOrderMark;

    new-instance v0, Lorg/apache/commons/io/ByteOrderMark;

    new-array v1, v1, [I

    fill-array-data v1, :array_70

    const-string v2, "UTF-32LE"

    invoke-direct {v0, v2, v1}, Lorg/apache/commons/io/ByteOrderMark;-><init>(Ljava/lang/String;[I)V

    sput-object v0, Lorg/apache/commons/io/ByteOrderMark;->UTF_32LE:Lorg/apache/commons/io/ByteOrderMark;

    return-void

    :array_4a
    .array-data 4
        0xef
        0xbb
        0xbf
    .end array-data

    :array_54
    .array-data 4
        0xfe
        0xff
    .end array-data

    :array_5c
    .array-data 4
        0xff
        0xfe
    .end array-data

    :array_64
    .array-data 4
        0x0
        0x0
        0xfe
        0xff
    .end array-data

    :array_70
    .array-data 4
        0xff
        0xfe
        0x0
        0x0
    .end array-data
.end method

.method public varargs constructor <init>(Ljava/lang/String;[I)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-eqz p1, :cond_25

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_25

    if-eqz p2, :cond_1d

    array-length v0, p2

    if-eqz v0, :cond_1d

    iput-object p1, p0, Lorg/apache/commons/io/ByteOrderMark;->charsetName:Ljava/lang/String;

    array-length p1, p2

    new-array p1, p1, [I

    iput-object p1, p0, Lorg/apache/commons/io/ByteOrderMark;->bytes:[I

    array-length v0, p2

    const/4 v1, 0x0

    invoke-static {p2, v1, p1, v1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-void

    :cond_1d
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "No bytes specified"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_25
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "No charsetName specified"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    instance-of v0, p1, Lorg/apache/commons/io/ByteOrderMark;

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return v1

    :cond_6
    check-cast p1, Lorg/apache/commons/io/ByteOrderMark;

    iget-object v0, p0, Lorg/apache/commons/io/ByteOrderMark;->bytes:[I

    array-length v0, v0

    invoke-virtual {p1}, Lorg/apache/commons/io/ByteOrderMark;->length()I

    move-result v2

    if-eq v0, v2, :cond_12

    return v1

    :cond_12
    const/4 v0, 0x0

    :goto_13
    iget-object v2, p0, Lorg/apache/commons/io/ByteOrderMark;->bytes:[I

    array-length v3, v2

    if-ge v0, v3, :cond_24

    aget v2, v2, v0

    invoke-virtual {p1, v0}, Lorg/apache/commons/io/ByteOrderMark;->get(I)I

    move-result v3

    if-eq v2, v3, :cond_21

    return v1

    :cond_21
    add-int/lit8 v0, v0, 0x1

    goto :goto_13

    :cond_24
    const/4 p1, 0x1

    return p1
.end method

.method public get(I)I
    .registers 3

    iget-object v0, p0, Lorg/apache/commons/io/ByteOrderMark;->bytes:[I

    aget p1, v0, p1

    return p1
.end method

.method public getBytes()[B
    .registers 5

    iget-object v0, p0, Lorg/apache/commons/io/ByteOrderMark;->bytes:[I

    array-length v0, v0

    new-array v0, v0, [B

    const/4 v1, 0x0

    :goto_6
    iget-object v2, p0, Lorg/apache/commons/io/ByteOrderMark;->bytes:[I

    array-length v3, v2

    if-ge v1, v3, :cond_13

    aget v2, v2, v1

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    :cond_13
    return-object v0
.end method

.method public getCharsetName()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/apache/commons/io/ByteOrderMark;->charsetName:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .registers 6

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    iget-object v1, p0, Lorg/apache/commons/io/ByteOrderMark;->bytes:[I

    array-length v2, v1

    const/4 v3, 0x0

    :goto_c
    if-ge v3, v2, :cond_14

    aget v4, v1, v3

    add-int/2addr v0, v4

    add-int/lit8 v3, v3, 0x1

    goto :goto_c

    :cond_14
    return v0
.end method

.method public length()I
    .registers 2

    iget-object v0, p0, Lorg/apache/commons/io/ByteOrderMark;->bytes:[I

    array-length v0, v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x5b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lorg/apache/commons/io/ByteOrderMark;->charsetName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ": "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v1, 0x0

    :goto_20
    iget-object v2, p0, Lorg/apache/commons/io/ByteOrderMark;->bytes:[I

    array-length v2, v2

    if-ge v1, v2, :cond_45

    if-lez v1, :cond_2c

    const-string v2, ","

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_2c
    const-string v2, "0x"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lorg/apache/commons/io/ByteOrderMark;->bytes:[I

    aget v2, v2, v1

    and-int/lit16 v2, v2, 0xff

    invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v1, v1, 0x1

    goto :goto_20

    :cond_45
    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
