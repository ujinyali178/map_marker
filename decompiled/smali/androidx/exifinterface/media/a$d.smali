.class Landroidx/exifinterface/media/a$d;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/exifinterface/media/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "d"
.end annotation


# instance fields
.field public final a:I

.field public final b:I

.field public final c:J

.field public final d:[B


# direct methods
.method constructor <init>(IIJ[B)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroidx/exifinterface/media/a$d;->a:I

    iput p2, p0, Landroidx/exifinterface/media/a$d;->b:I

    iput-wide p3, p0, Landroidx/exifinterface/media/a$d;->c:J

    iput-object p5, p0, Landroidx/exifinterface/media/a$d;->d:[B

    return-void
.end method

.method constructor <init>(II[B)V
    .registers 10

    const-wide/16 v3, -0x1

    move-object v0, p0

    move v1, p1

    move v2, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Landroidx/exifinterface/media/a$d;-><init>(IIJ[B)V

    return-void
.end method

.method public static a(Ljava/lang/String;)Landroidx/exifinterface/media/a$d;
    .registers 6

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_28

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x30

    if-lt v2, v3, :cond_28

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v4, 0x31

    if-gt v2, v4, :cond_28

    new-array v2, v1, [B

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result p0

    sub-int/2addr p0, v3

    int-to-byte p0, p0

    aput-byte p0, v2, v0

    new-instance p0, Landroidx/exifinterface/media/a$d;

    invoke-direct {p0, v1, v1, v2}, Landroidx/exifinterface/media/a$d;-><init>(II[B)V

    return-object p0

    :cond_28
    sget-object v0, Landroidx/exifinterface/media/a;->p0:Ljava/nio/charset/Charset;

    invoke-virtual {p0, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p0

    new-instance v0, Landroidx/exifinterface/media/a$d;

    array-length v2, p0

    invoke-direct {v0, v1, v2, p0}, Landroidx/exifinterface/media/a$d;-><init>(II[B)V

    return-object v0
.end method

.method public static b([DLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;
    .registers 7

    sget-object v0, Landroidx/exifinterface/media/a;->X:[I

    const/16 v1, 0xc

    aget v0, v0, v1

    array-length v2, p0

    mul-int v0, v0, v2

    new-array v0, v0, [B

    invoke-static {v0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    array-length p1, p0

    const/4 v2, 0x0

    :goto_14
    if-ge v2, p1, :cond_1e

    aget-wide v3, p0, v2

    invoke-virtual {v0, v3, v4}, Ljava/nio/ByteBuffer;->putDouble(D)Ljava/nio/ByteBuffer;

    add-int/lit8 v2, v2, 0x1

    goto :goto_14

    :cond_1e
    new-instance p1, Landroidx/exifinterface/media/a$d;

    array-length p0, p0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    invoke-direct {p1, v1, p0, v0}, Landroidx/exifinterface/media/a$d;-><init>(II[B)V

    return-object p1
.end method

.method public static c([ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;
    .registers 6

    sget-object v0, Landroidx/exifinterface/media/a;->X:[I

    const/16 v1, 0x9

    aget v0, v0, v1

    array-length v2, p0

    mul-int v0, v0, v2

    new-array v0, v0, [B

    invoke-static {v0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    array-length p1, p0

    const/4 v2, 0x0

    :goto_14
    if-ge v2, p1, :cond_1e

    aget v3, p0, v2

    invoke-virtual {v0, v3}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    add-int/lit8 v2, v2, 0x1

    goto :goto_14

    :cond_1e
    new-instance p1, Landroidx/exifinterface/media/a$d;

    array-length p0, p0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    invoke-direct {p1, v1, p0, v0}, Landroidx/exifinterface/media/a$d;-><init>(II[B)V

    return-object p1
.end method

.method public static d([Landroidx/exifinterface/media/a$f;Ljava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;
    .registers 8

    sget-object v0, Landroidx/exifinterface/media/a;->X:[I

    const/16 v1, 0xa

    aget v0, v0, v1

    array-length v2, p0

    mul-int v0, v0, v2

    new-array v0, v0, [B

    invoke-static {v0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    array-length p1, p0

    const/4 v2, 0x0

    :goto_14
    if-ge v2, p1, :cond_27

    aget-object v3, p0, v2

    iget-wide v4, v3, Landroidx/exifinterface/media/a$f;->a:J

    long-to-int v5, v4

    invoke-virtual {v0, v5}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    iget-wide v3, v3, Landroidx/exifinterface/media/a$f;->b:J

    long-to-int v4, v3

    invoke-virtual {v0, v4}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    add-int/lit8 v2, v2, 0x1

    goto :goto_14

    :cond_27
    new-instance p1, Landroidx/exifinterface/media/a$d;

    array-length p0, p0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    invoke-direct {p1, v1, p0, v0}, Landroidx/exifinterface/media/a$d;-><init>(II[B)V

    return-object p1
.end method

.method public static e(Ljava/lang/String;)Landroidx/exifinterface/media/a$d;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 p0, 0x0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    sget-object v0, Landroidx/exifinterface/media/a;->p0:Ljava/nio/charset/Charset;

    invoke-virtual {p0, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p0

    new-instance v0, Landroidx/exifinterface/media/a$d;

    array-length v1, p0

    const/4 v2, 0x2

    invoke-direct {v0, v2, v1, p0}, Landroidx/exifinterface/media/a$d;-><init>(II[B)V

    return-object v0
.end method

.method public static f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;
    .registers 5

    const/4 v0, 0x1

    new-array v0, v0, [J

    const/4 v1, 0x0

    aput-wide p0, v0, v1

    invoke-static {v0, p2}, Landroidx/exifinterface/media/a$d;->g([JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object p0

    return-object p0
.end method

.method public static g([JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;
    .registers 7

    sget-object v0, Landroidx/exifinterface/media/a;->X:[I

    const/4 v1, 0x4

    aget v0, v0, v1

    array-length v2, p0

    mul-int v0, v0, v2

    new-array v0, v0, [B

    invoke-static {v0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    array-length p1, p0

    const/4 v2, 0x0

    :goto_13
    if-ge v2, p1, :cond_1e

    aget-wide v3, p0, v2

    long-to-int v4, v3

    invoke-virtual {v0, v4}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    add-int/lit8 v2, v2, 0x1

    goto :goto_13

    :cond_1e
    new-instance p1, Landroidx/exifinterface/media/a$d;

    array-length p0, p0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    invoke-direct {p1, v1, p0, v0}, Landroidx/exifinterface/media/a$d;-><init>(II[B)V

    return-object p1
.end method

.method public static h(Landroidx/exifinterface/media/a$f;Ljava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;
    .registers 4

    const/4 v0, 0x1

    new-array v0, v0, [Landroidx/exifinterface/media/a$f;

    const/4 v1, 0x0

    aput-object p0, v0, v1

    invoke-static {v0, p1}, Landroidx/exifinterface/media/a$d;->i([Landroidx/exifinterface/media/a$f;Ljava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object p0

    return-object p0
.end method

.method public static i([Landroidx/exifinterface/media/a$f;Ljava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;
    .registers 8

    sget-object v0, Landroidx/exifinterface/media/a;->X:[I

    const/4 v1, 0x5

    aget v0, v0, v1

    array-length v2, p0

    mul-int v0, v0, v2

    new-array v0, v0, [B

    invoke-static {v0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    array-length p1, p0

    const/4 v2, 0x0

    :goto_13
    if-ge v2, p1, :cond_26

    aget-object v3, p0, v2

    iget-wide v4, v3, Landroidx/exifinterface/media/a$f;->a:J

    long-to-int v5, v4

    invoke-virtual {v0, v5}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    iget-wide v3, v3, Landroidx/exifinterface/media/a$f;->b:J

    long-to-int v4, v3

    invoke-virtual {v0, v4}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    add-int/lit8 v2, v2, 0x1

    goto :goto_13

    :cond_26
    new-instance p1, Landroidx/exifinterface/media/a$d;

    array-length p0, p0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    invoke-direct {p1, v1, p0, v0}, Landroidx/exifinterface/media/a$d;-><init>(II[B)V

    return-object p1
.end method

.method public static j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;
    .registers 4

    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    aput p0, v0, v1

    invoke-static {v0, p1}, Landroidx/exifinterface/media/a$d;->k([ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object p0

    return-object p0
.end method

.method public static k([ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;
    .registers 6

    sget-object v0, Landroidx/exifinterface/media/a;->X:[I

    const/4 v1, 0x3

    aget v0, v0, v1

    array-length v2, p0

    mul-int v0, v0, v2

    new-array v0, v0, [B

    invoke-static {v0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    array-length p1, p0

    const/4 v2, 0x0

    :goto_13
    if-ge v2, p1, :cond_1e

    aget v3, p0, v2

    int-to-short v3, v3

    invoke-virtual {v0, v3}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    add-int/lit8 v2, v2, 0x1

    goto :goto_13

    :cond_1e
    new-instance p1, Landroidx/exifinterface/media/a$d;

    array-length p0, p0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    invoke-direct {p1, v1, p0, v0}, Landroidx/exifinterface/media/a$d;-><init>(II[B)V

    return-object p1
.end method


# virtual methods
.method public l(Ljava/nio/ByteOrder;)D
    .registers 6

    invoke-virtual {p0, p1}, Landroidx/exifinterface/media/a$d;->o(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_6b

    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_11

    check-cast p1, Ljava/lang/String;

    invoke-static {p1}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    return-wide v0

    :cond_11
    instance-of v0, p1, [J

    const/4 v1, 0x0

    const-string v2, "There are more than one component"

    const/4 v3, 0x1

    if-eqz v0, :cond_28

    check-cast p1, [J

    array-length v0, p1

    if-ne v0, v3, :cond_22

    aget-wide v0, p1, v1

    long-to-double v0, v0

    return-wide v0

    :cond_22
    new-instance p1, Ljava/lang/NumberFormatException;

    invoke-direct {p1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_28
    instance-of v0, p1, [I

    if-eqz v0, :cond_3b

    check-cast p1, [I

    array-length v0, p1

    if-ne v0, v3, :cond_35

    aget p1, p1, v1

    int-to-double v0, p1

    return-wide v0

    :cond_35
    new-instance p1, Ljava/lang/NumberFormatException;

    invoke-direct {p1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_3b
    instance-of v0, p1, [D

    if-eqz v0, :cond_4d

    check-cast p1, [D

    array-length v0, p1

    if-ne v0, v3, :cond_47

    aget-wide v0, p1, v1

    return-wide v0

    :cond_47
    new-instance p1, Ljava/lang/NumberFormatException;

    invoke-direct {p1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_4d
    instance-of v0, p1, [Landroidx/exifinterface/media/a$f;

    if-eqz v0, :cond_63

    check-cast p1, [Landroidx/exifinterface/media/a$f;

    array-length v0, p1

    if-ne v0, v3, :cond_5d

    aget-object p1, p1, v1

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$f;->a()D

    move-result-wide v0

    return-wide v0

    :cond_5d
    new-instance p1, Ljava/lang/NumberFormatException;

    invoke-direct {p1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_63
    new-instance p1, Ljava/lang/NumberFormatException;

    const-string v0, "Couldn\'t find a double value"

    invoke-direct {p1, v0}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_6b
    new-instance p1, Ljava/lang/NumberFormatException;

    const-string v0, "NULL can\'t be converted to a double value"

    invoke-direct {p1, v0}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public m(Ljava/nio/ByteOrder;)I
    .registers 6

    invoke-virtual {p0, p1}, Landroidx/exifinterface/media/a$d;->o(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_42

    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_11

    check-cast p1, Ljava/lang/String;

    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result p1

    return p1

    :cond_11
    instance-of v0, p1, [J

    const/4 v1, 0x0

    const-string v2, "There are more than one component"

    const/4 v3, 0x1

    if-eqz v0, :cond_28

    check-cast p1, [J

    array-length v0, p1

    if-ne v0, v3, :cond_22

    aget-wide v0, p1, v1

    long-to-int p1, v0

    return p1

    :cond_22
    new-instance p1, Ljava/lang/NumberFormatException;

    invoke-direct {p1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_28
    instance-of v0, p1, [I

    if-eqz v0, :cond_3a

    check-cast p1, [I

    array-length v0, p1

    if-ne v0, v3, :cond_34

    aget p1, p1, v1

    return p1

    :cond_34
    new-instance p1, Ljava/lang/NumberFormatException;

    invoke-direct {p1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_3a
    new-instance p1, Ljava/lang/NumberFormatException;

    const-string v0, "Couldn\'t find a integer value"

    invoke-direct {p1, v0}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_42
    new-instance p1, Ljava/lang/NumberFormatException;

    const-string v0, "NULL can\'t be converted to a integer value"

    invoke-direct {p1, v0}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public n(Ljava/nio/ByteOrder;)Ljava/lang/String;
    .registers 9

    invoke-virtual {p0, p1}, Landroidx/exifinterface/media/a$d;->o(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object p1

    const/4 v0, 0x0

    if-nez p1, :cond_8

    return-object v0

    :cond_8
    instance-of v1, p1, Ljava/lang/String;

    if-eqz v1, :cond_f

    check-cast p1, Ljava/lang/String;

    return-object p1

    :cond_f
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    instance-of v2, p1, [J

    const-string v3, ","

    const/4 v4, 0x0

    if-eqz v2, :cond_33

    check-cast p1, [J

    :cond_1d
    :goto_1d
    array-length v0, p1

    if-ge v4, v0, :cond_2e

    aget-wide v5, p1, v4

    invoke-virtual {v1, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    array-length v0, p1

    if-eq v4, v0, :cond_1d

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1d

    :cond_2e
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_33
    instance-of v2, p1, [I

    if-eqz v2, :cond_4f

    check-cast p1, [I

    :cond_39
    :goto_39
    array-length v0, p1

    if-ge v4, v0, :cond_4a

    aget v0, p1, v4

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    array-length v0, p1

    if-eq v4, v0, :cond_39

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_39

    :cond_4a
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_4f
    instance-of v2, p1, [D

    if-eqz v2, :cond_6b

    check-cast p1, [D

    :cond_55
    :goto_55
    array-length v0, p1

    if-ge v4, v0, :cond_66

    aget-wide v5, p1, v4

    invoke-virtual {v1, v5, v6}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    array-length v0, p1

    if-eq v4, v0, :cond_55

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_55

    :cond_66
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_6b
    instance-of v2, p1, [Landroidx/exifinterface/media/a$f;

    if-eqz v2, :cond_95

    check-cast p1, [Landroidx/exifinterface/media/a$f;

    :cond_71
    :goto_71
    array-length v0, p1

    if-ge v4, v0, :cond_90

    aget-object v0, p1, v4

    iget-wide v5, v0, Landroidx/exifinterface/media/a$f;->a:J

    invoke-virtual {v1, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const/16 v0, 0x2f

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    aget-object v0, p1, v4

    iget-wide v5, v0, Landroidx/exifinterface/media/a$f;->b:J

    invoke-virtual {v1, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    array-length v0, p1

    if-eq v4, v0, :cond_71

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_71

    :cond_90
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_95
    return-object v0
.end method

.method o(Ljava/nio/ByteOrder;)Ljava/lang/Object;
    .registers 12

    const-string v0, "IOException occurred while closing InputStream"

    const-string v1, "ExifInterface"

    const/4 v2, 0x0

    :try_start_5
    new-instance v3, Landroidx/exifinterface/media/a$b;

    iget-object v4, p0, Landroidx/exifinterface/media/a$d;->d:[B

    invoke-direct {v3, v4}, Landroidx/exifinterface/media/a$b;-><init>([B)V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_c} :catch_186
    .catchall {:try_start_5 .. :try_end_c} :catchall_184

    :try_start_c
    invoke-virtual {v3, p1}, Landroidx/exifinterface/media/a$b;->c(Ljava/nio/ByteOrder;)V

    iget p1, p0, Landroidx/exifinterface/media/a$d;->a:I

    const/4 v4, 0x0

    const/4 v5, 0x1

    const/4 v5, 0x1

    packed-switch p1, :pswitch_data_1a6

    goto/16 :goto_179

    :pswitch_19
    iget p1, p0, Landroidx/exifinterface/media/a$d;->b:I

    new-array p1, p1, [D

    :goto_1d
    iget v5, p0, Landroidx/exifinterface/media/a$d;->b:I

    if-ge v4, v5, :cond_2a

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readDouble()D

    move-result-wide v5

    aput-wide v5, p1, v4
    :try_end_27
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_27} :catch_182
    .catchall {:try_start_c .. :try_end_27} :catchall_198

    add-int/lit8 v4, v4, 0x1

    goto :goto_1d

    :cond_2a
    :try_start_2a
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_2d
    .catch Ljava/io/IOException; {:try_start_2a .. :try_end_2d} :catch_2e

    goto :goto_32

    :catch_2e
    move-exception v2

    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_32
    return-object p1

    :pswitch_33
    :try_start_33
    iget p1, p0, Landroidx/exifinterface/media/a$d;->b:I

    new-array p1, p1, [D

    :goto_37
    iget v5, p0, Landroidx/exifinterface/media/a$d;->b:I

    if-ge v4, v5, :cond_45

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readFloat()F

    move-result v5

    float-to-double v5, v5

    aput-wide v5, p1, v4
    :try_end_42
    .catch Ljava/io/IOException; {:try_start_33 .. :try_end_42} :catch_182
    .catchall {:try_start_33 .. :try_end_42} :catchall_198

    add-int/lit8 v4, v4, 0x1

    goto :goto_37

    :cond_45
    :try_start_45
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_48
    .catch Ljava/io/IOException; {:try_start_45 .. :try_end_48} :catch_49

    goto :goto_4d

    :catch_49
    move-exception v2

    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_4d
    return-object p1

    :pswitch_4e
    :try_start_4e
    iget p1, p0, Landroidx/exifinterface/media/a$d;->b:I

    new-array p1, p1, [Landroidx/exifinterface/media/a$f;

    :goto_52
    iget v5, p0, Landroidx/exifinterface/media/a$d;->b:I

    if-ge v4, v5, :cond_6a

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v5

    int-to-long v5, v5

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v7

    int-to-long v7, v7

    new-instance v9, Landroidx/exifinterface/media/a$f;

    invoke-direct {v9, v5, v6, v7, v8}, Landroidx/exifinterface/media/a$f;-><init>(JJ)V

    aput-object v9, p1, v4
    :try_end_67
    .catch Ljava/io/IOException; {:try_start_4e .. :try_end_67} :catch_182
    .catchall {:try_start_4e .. :try_end_67} :catchall_198

    add-int/lit8 v4, v4, 0x1

    goto :goto_52

    :cond_6a
    :try_start_6a
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_6d
    .catch Ljava/io/IOException; {:try_start_6a .. :try_end_6d} :catch_6e

    goto :goto_72

    :catch_6e
    move-exception v2

    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_72
    return-object p1

    :pswitch_73
    :try_start_73
    iget p1, p0, Landroidx/exifinterface/media/a$d;->b:I

    new-array p1, p1, [I

    :goto_77
    iget v5, p0, Landroidx/exifinterface/media/a$d;->b:I

    if-ge v4, v5, :cond_84

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v5

    aput v5, p1, v4
    :try_end_81
    .catch Ljava/io/IOException; {:try_start_73 .. :try_end_81} :catch_182
    .catchall {:try_start_73 .. :try_end_81} :catchall_198

    add-int/lit8 v4, v4, 0x1

    goto :goto_77

    :cond_84
    :try_start_84
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_87
    .catch Ljava/io/IOException; {:try_start_84 .. :try_end_87} :catch_88

    goto :goto_8c

    :catch_88
    move-exception v2

    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_8c
    return-object p1

    :pswitch_8d
    :try_start_8d
    iget p1, p0, Landroidx/exifinterface/media/a$d;->b:I

    new-array p1, p1, [I

    :goto_91
    iget v5, p0, Landroidx/exifinterface/media/a$d;->b:I

    if-ge v4, v5, :cond_9e

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readShort()S

    move-result v5

    aput v5, p1, v4
    :try_end_9b
    .catch Ljava/io/IOException; {:try_start_8d .. :try_end_9b} :catch_182
    .catchall {:try_start_8d .. :try_end_9b} :catchall_198

    add-int/lit8 v4, v4, 0x1

    goto :goto_91

    :cond_9e
    :try_start_9e
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_a1
    .catch Ljava/io/IOException; {:try_start_9e .. :try_end_a1} :catch_a2

    goto :goto_a6

    :catch_a2
    move-exception v2

    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_a6
    return-object p1

    :pswitch_a7
    :try_start_a7
    iget p1, p0, Landroidx/exifinterface/media/a$d;->b:I

    new-array p1, p1, [Landroidx/exifinterface/media/a$f;

    :goto_ab
    iget v5, p0, Landroidx/exifinterface/media/a$d;->b:I

    if-ge v4, v5, :cond_c1

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->b()J

    move-result-wide v5

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->b()J

    move-result-wide v7

    new-instance v9, Landroidx/exifinterface/media/a$f;

    invoke-direct {v9, v5, v6, v7, v8}, Landroidx/exifinterface/media/a$f;-><init>(JJ)V

    aput-object v9, p1, v4
    :try_end_be
    .catch Ljava/io/IOException; {:try_start_a7 .. :try_end_be} :catch_182
    .catchall {:try_start_a7 .. :try_end_be} :catchall_198

    add-int/lit8 v4, v4, 0x1

    goto :goto_ab

    :cond_c1
    :try_start_c1
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_c4
    .catch Ljava/io/IOException; {:try_start_c1 .. :try_end_c4} :catch_c5

    goto :goto_c9

    :catch_c5
    move-exception v2

    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_c9
    return-object p1

    :pswitch_ca
    :try_start_ca
    iget p1, p0, Landroidx/exifinterface/media/a$d;->b:I

    new-array p1, p1, [J

    :goto_ce
    iget v5, p0, Landroidx/exifinterface/media/a$d;->b:I

    if-ge v4, v5, :cond_db

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->b()J

    move-result-wide v5

    aput-wide v5, p1, v4
    :try_end_d8
    .catch Ljava/io/IOException; {:try_start_ca .. :try_end_d8} :catch_182
    .catchall {:try_start_ca .. :try_end_d8} :catchall_198

    add-int/lit8 v4, v4, 0x1

    goto :goto_ce

    :cond_db
    :try_start_db
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_de
    .catch Ljava/io/IOException; {:try_start_db .. :try_end_de} :catch_df

    goto :goto_e3

    :catch_df
    move-exception v2

    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_e3
    return-object p1

    :pswitch_e4
    :try_start_e4
    iget p1, p0, Landroidx/exifinterface/media/a$d;->b:I

    new-array p1, p1, [I

    :goto_e8
    iget v5, p0, Landroidx/exifinterface/media/a$d;->b:I

    if-ge v4, v5, :cond_f5

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readUnsignedShort()I

    move-result v5

    aput v5, p1, v4
    :try_end_f2
    .catch Ljava/io/IOException; {:try_start_e4 .. :try_end_f2} :catch_182
    .catchall {:try_start_e4 .. :try_end_f2} :catchall_198

    add-int/lit8 v4, v4, 0x1

    goto :goto_e8

    :cond_f5
    :try_start_f5
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_f8
    .catch Ljava/io/IOException; {:try_start_f5 .. :try_end_f8} :catch_f9

    goto :goto_fd

    :catch_f9
    move-exception v2

    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_fd
    return-object p1

    :pswitch_fe
    :try_start_fe
    iget p1, p0, Landroidx/exifinterface/media/a$d;->b:I

    sget-object v6, Landroidx/exifinterface/media/a;->Y:[B

    array-length v6, v6

    if-lt p1, v6, :cond_11b

    const/4 p1, 0x0

    :goto_106
    sget-object v6, Landroidx/exifinterface/media/a;->Y:[B

    array-length v7, v6

    if-ge p1, v7, :cond_118

    iget-object v7, p0, Landroidx/exifinterface/media/a$d;->d:[B

    aget-byte v7, v7, p1

    aget-byte v8, v6, p1

    if-eq v7, v8, :cond_115

    const/4 v5, 0x0

    goto :goto_118

    :cond_115
    add-int/lit8 p1, p1, 0x1

    goto :goto_106

    :cond_118
    :goto_118
    if-eqz v5, :cond_11b

    array-length v4, v6

    :cond_11b
    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    :goto_120
    iget v5, p0, Landroidx/exifinterface/media/a$d;->b:I

    if-ge v4, v5, :cond_13c

    iget-object v5, p0, Landroidx/exifinterface/media/a$d;->d:[B

    aget-byte v5, v5, v4

    if-nez v5, :cond_12b

    goto :goto_13c

    :cond_12b
    const/16 v6, 0x20

    if-lt v5, v6, :cond_134

    int-to-char v5, v5

    invoke-virtual {p1, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_139

    :cond_134
    const/16 v5, 0x3f

    invoke-virtual {p1, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    :goto_139
    add-int/lit8 v4, v4, 0x1

    goto :goto_120

    :cond_13c
    :goto_13c
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1
    :try_end_140
    .catch Ljava/io/IOException; {:try_start_fe .. :try_end_140} :catch_182
    .catchall {:try_start_fe .. :try_end_140} :catchall_198

    :try_start_140
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_143
    .catch Ljava/io/IOException; {:try_start_140 .. :try_end_143} :catch_144

    goto :goto_148

    :catch_144
    move-exception v2

    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_148
    return-object p1

    :pswitch_149
    :try_start_149
    iget-object p1, p0, Landroidx/exifinterface/media/a$d;->d:[B

    array-length v6, p1

    if-ne v6, v5, :cond_169

    aget-byte v6, p1, v4

    if-ltz v6, :cond_169

    if-gt v6, v5, :cond_169

    new-instance p1, Ljava/lang/String;

    new-array v5, v5, [C

    add-int/lit8 v6, v6, 0x30

    int-to-char v6, v6

    aput-char v6, v5, v4

    invoke-direct {p1, v5}, Ljava/lang/String;-><init>([C)V
    :try_end_160
    .catch Ljava/io/IOException; {:try_start_149 .. :try_end_160} :catch_182
    .catchall {:try_start_149 .. :try_end_160} :catchall_198

    :try_start_160
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_163
    .catch Ljava/io/IOException; {:try_start_160 .. :try_end_163} :catch_164

    goto :goto_168

    :catch_164
    move-exception v2

    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_168
    return-object p1

    :cond_169
    :try_start_169
    new-instance v4, Ljava/lang/String;

    sget-object v5, Landroidx/exifinterface/media/a;->p0:Ljava/nio/charset/Charset;

    invoke-direct {v4, p1, v5}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V
    :try_end_170
    .catch Ljava/io/IOException; {:try_start_169 .. :try_end_170} :catch_182
    .catchall {:try_start_169 .. :try_end_170} :catchall_198

    :try_start_170
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_173
    .catch Ljava/io/IOException; {:try_start_170 .. :try_end_173} :catch_174

    goto :goto_178

    :catch_174
    move-exception p1

    invoke-static {v1, v0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_178
    return-object v4

    :goto_179
    :try_start_179
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_17c
    .catch Ljava/io/IOException; {:try_start_179 .. :try_end_17c} :catch_17d

    goto :goto_181

    :catch_17d
    move-exception p1

    invoke-static {v1, v0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_181
    return-object v2

    :catch_182
    move-exception p1

    goto :goto_188

    :catchall_184
    move-exception p1

    goto :goto_19a

    :catch_186
    move-exception p1

    move-object v3, v2

    :goto_188
    :try_start_188
    const-string v4, "IOException occurred during reading a value"

    invoke-static {v1, v4, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_18d
    .catchall {:try_start_188 .. :try_end_18d} :catchall_198

    if-eqz v3, :cond_197

    :try_start_18f
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_192
    .catch Ljava/io/IOException; {:try_start_18f .. :try_end_192} :catch_193

    goto :goto_197

    :catch_193
    move-exception p1

    invoke-static {v1, v0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_197
    :goto_197
    return-object v2

    :catchall_198
    move-exception p1

    move-object v2, v3

    :goto_19a
    if-eqz v2, :cond_1a4

    :try_start_19c
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_19f
    .catch Ljava/io/IOException; {:try_start_19c .. :try_end_19f} :catch_1a0

    goto :goto_1a4

    :catch_1a0
    move-exception v2

    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_1a4
    :goto_1a4
    throw p1

    nop

    :pswitch_data_1a6
    .packed-switch 0x1
        :pswitch_149
        :pswitch_fe
        :pswitch_e4
        :pswitch_ca
        :pswitch_a7
        :pswitch_149
        :pswitch_fe
        :pswitch_8d
        :pswitch_73
        :pswitch_4e
        :pswitch_33
        :pswitch_19
    .end packed-switch
.end method

.method public p()I
    .registers 3

    sget-object v0, Landroidx/exifinterface/media/a;->X:[I

    iget v1, p0, Landroidx/exifinterface/media/a$d;->a:I

    aget v0, v0, v1

    iget v1, p0, Landroidx/exifinterface/media/a$d;->b:I

    mul-int v0, v0, v1

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v1, Landroidx/exifinterface/media/a;->W:[Ljava/lang/String;

    iget v2, p0, Landroidx/exifinterface/media/a$d;->a:I

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", data length:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Landroidx/exifinterface/media/a$d;->d:[B

    array-length v1, v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
