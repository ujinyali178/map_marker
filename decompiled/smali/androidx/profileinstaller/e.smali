.class Landroidx/profileinstaller/e;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method static a(I)I
    .registers 1

    add-int/lit8 p0, p0, 0x8

    add-int/lit8 p0, p0, -0x1

    and-int/lit8 p0, p0, -0x8

    div-int/lit8 p0, p0, 0x8

    return p0
.end method

.method static b([B)[B
    .registers 4

    new-instance v0, Ljava/util/zip/Deflater;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/zip/Deflater;-><init>(I)V

    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    :try_start_b
    new-instance v2, Ljava/util/zip/DeflaterOutputStream;

    invoke-direct {v2, v1, v0}, Ljava/util/zip/DeflaterOutputStream;-><init>(Ljava/io/OutputStream;Ljava/util/zip/Deflater;)V
    :try_end_10
    .catchall {:try_start_b .. :try_end_10} :catchall_28

    :try_start_10
    invoke-virtual {v2, p0}, Ljava/io/OutputStream;->write([B)V
    :try_end_13
    .catchall {:try_start_10 .. :try_end_13} :catchall_1e

    :try_start_13
    invoke-virtual {v2}, Ljava/util/zip/DeflaterOutputStream;->close()V
    :try_end_16
    .catchall {:try_start_13 .. :try_end_16} :catchall_28

    invoke-virtual {v0}, Ljava/util/zip/Deflater;->end()V

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object p0

    return-object p0

    :catchall_1e
    move-exception p0

    :try_start_1f
    invoke-virtual {v2}, Ljava/util/zip/DeflaterOutputStream;->close()V
    :try_end_22
    .catchall {:try_start_1f .. :try_end_22} :catchall_23

    goto :goto_27

    :catchall_23
    move-exception v1

    :try_start_24
    invoke-virtual {p0, v1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    :goto_27
    throw p0
    :try_end_28
    .catchall {:try_start_24 .. :try_end_28} :catchall_28

    :catchall_28
    move-exception p0

    invoke-virtual {v0}, Ljava/util/zip/Deflater;->end()V

    throw p0
.end method

.method static c(Ljava/lang/String;)Ljava/lang/RuntimeException;
    .registers 2

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0, p0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method static d(Ljava/io/InputStream;I)[B
    .registers 5

    new-array v0, p1, [B

    const/4 v1, 0x0

    :goto_3
    if-ge v1, p1, :cond_25

    sub-int v2, p1, v1

    invoke-virtual {p0, v0, v1, v2}, Ljava/io/InputStream;->read([BII)I

    move-result v2

    if-ltz v2, :cond_f

    add-int/2addr v1, v2

    goto :goto_3

    :cond_f
    new-instance p0, Ljava/lang/StringBuilder;

    invoke-direct {p0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "Not enough bytes to read: "

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Landroidx/profileinstaller/e;->c(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object p0

    throw p0

    :cond_25
    return-object v0
.end method

.method static e(Ljava/io/InputStream;II)[B
    .registers 11

    new-instance v0, Ljava/util/zip/Inflater;

    invoke-direct {v0}, Ljava/util/zip/Inflater;-><init>()V

    :try_start_5
    new-array v1, p2, [B

    const/16 v2, 0x800

    new-array v2, v2, [B

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    :goto_e
    invoke-virtual {v0}, Ljava/util/zip/Inflater;->finished()Z

    move-result v6

    if-nez v6, :cond_53

    invoke-virtual {v0}, Ljava/util/zip/Inflater;->needsDictionary()Z

    move-result v6

    if-nez v6, :cond_53

    if-ge v4, p1, :cond_53

    invoke-virtual {p0, v2}, Ljava/io/InputStream;->read([B)I

    move-result v6

    if-ltz v6, :cond_38

    invoke-virtual {v0, v2, v3, v6}, Ljava/util/zip/Inflater;->setInput([BII)V
    :try_end_25
    .catchall {:try_start_5 .. :try_end_25} :catchall_84

    sub-int v7, p2, v5

    :try_start_27
    invoke-virtual {v0, v1, v5, v7}, Ljava/util/zip/Inflater;->inflate([BII)I

    move-result v7
    :try_end_2b
    .catch Ljava/util/zip/DataFormatException; {:try_start_27 .. :try_end_2b} :catch_2e
    .catchall {:try_start_27 .. :try_end_2b} :catchall_84

    add-int/2addr v5, v7

    add-int/2addr v4, v6

    goto :goto_e

    :catch_2e
    move-exception p0

    :try_start_2f
    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Landroidx/profileinstaller/e;->c(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object p0

    throw p0

    :cond_38
    new-instance p0, Ljava/lang/StringBuilder;

    invoke-direct {p0}, Ljava/lang/StringBuilder;-><init>()V

    const-string p2, "Invalid zip data. Stream ended after $totalBytesRead bytes. Expected "

    invoke-virtual {p0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " bytes"

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Landroidx/profileinstaller/e;->c(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object p0

    throw p0

    :cond_53
    if-ne v4, p1, :cond_66

    invoke-virtual {v0}, Ljava/util/zip/Inflater;->finished()Z

    move-result p0
    :try_end_59
    .catchall {:try_start_2f .. :try_end_59} :catchall_84

    if-eqz p0, :cond_5f

    invoke-virtual {v0}, Ljava/util/zip/Inflater;->end()V

    return-object v1

    :cond_5f
    :try_start_5f
    const-string p0, "Inflater did not finish"

    invoke-static {p0}, Landroidx/profileinstaller/e;->c(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object p0

    throw p0

    :cond_66
    new-instance p0, Ljava/lang/StringBuilder;

    invoke-direct {p0}, Ljava/lang/StringBuilder;-><init>()V

    const-string p2, "Didn\'t read enough bytes during decompression. expected="

    invoke-virtual {p0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " actual="

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Landroidx/profileinstaller/e;->c(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object p0

    throw p0
    :try_end_84
    .catchall {:try_start_5f .. :try_end_84} :catchall_84

    :catchall_84
    move-exception p0

    invoke-virtual {v0}, Ljava/util/zip/Inflater;->end()V

    throw p0
.end method

.method static f(Ljava/io/InputStream;I)Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/String;

    invoke-static {p0, p1}, Landroidx/profileinstaller/e;->d(Ljava/io/InputStream;I)[B

    move-result-object p0

    sget-object p1, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v0, p0, p1}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    return-object v0
.end method

.method static g(Ljava/io/InputStream;I)J
    .registers 8

    invoke-static {p0, p1}, Landroidx/profileinstaller/e;->d(Ljava/io/InputStream;I)[B

    move-result-object p0

    const-wide/16 v0, 0x0

    const/4 v2, 0x0

    :goto_7
    if-ge v2, p1, :cond_15

    aget-byte v3, p0, v2

    and-int/lit16 v3, v3, 0xff

    int-to-long v3, v3

    mul-int/lit8 v5, v2, 0x8

    shl-long/2addr v3, v5

    add-long/2addr v0, v3

    add-int/lit8 v2, v2, 0x1

    goto :goto_7

    :cond_15
    return-wide v0
.end method

.method static h(Ljava/io/InputStream;)I
    .registers 3

    const/4 v0, 0x2

    invoke-static {p0, v0}, Landroidx/profileinstaller/e;->g(Ljava/io/InputStream;I)J

    move-result-wide v0

    long-to-int p0, v0

    return p0
.end method

.method static i(Ljava/io/InputStream;)J
    .registers 3

    const/4 v0, 0x4

    invoke-static {p0, v0}, Landroidx/profileinstaller/e;->g(Ljava/io/InputStream;I)J

    move-result-wide v0

    return-wide v0
.end method

.method static j(Ljava/io/InputStream;)I
    .registers 3

    const/4 v0, 0x1

    invoke-static {p0, v0}, Landroidx/profileinstaller/e;->g(Ljava/io/InputStream;I)J

    move-result-wide v0

    long-to-int p0, v0

    return p0
.end method

.method static k(Ljava/lang/String;)I
    .registers 2

    sget-object v0, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {p0, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p0

    array-length p0, p0

    return p0
.end method

.method static l(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .registers 5

    const/16 v0, 0x200

    new-array v0, v0, [B

    :goto_4
    invoke-virtual {p0, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    if-lez v1, :cond_f

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2, v1}, Ljava/io/OutputStream;->write([BII)V

    goto :goto_4

    :cond_f
    return-void
.end method

.method static m(Ljava/io/OutputStream;[B)V
    .registers 4

    array-length v0, p1

    int-to-long v0, v0

    invoke-static {p0, v0, v1}, Landroidx/profileinstaller/e;->q(Ljava/io/OutputStream;J)V

    invoke-static {p1}, Landroidx/profileinstaller/e;->b([B)[B

    move-result-object p1

    array-length v0, p1

    int-to-long v0, v0

    invoke-static {p0, v0, v1}, Landroidx/profileinstaller/e;->q(Ljava/io/OutputStream;J)V

    invoke-virtual {p0, p1}, Ljava/io/OutputStream;->write([B)V

    return-void
.end method

.method static n(Ljava/io/OutputStream;Ljava/lang/String;)V
    .registers 3

    sget-object v0, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {p1, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p1

    invoke-virtual {p0, p1}, Ljava/io/OutputStream;->write([B)V

    return-void
.end method

.method static o(Ljava/io/OutputStream;JI)V
    .registers 10

    new-array v0, p3, [B

    const/4 v1, 0x0

    :goto_3
    if-ge v1, p3, :cond_13

    mul-int/lit8 v2, v1, 0x8

    shr-long v2, p1, v2

    const-wide/16 v4, 0xff

    and-long/2addr v2, v4

    long-to-int v3, v2

    int-to-byte v2, v3

    aput-byte v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_13
    invoke-virtual {p0, v0}, Ljava/io/OutputStream;->write([B)V

    return-void
.end method

.method static p(Ljava/io/OutputStream;I)V
    .registers 4

    int-to-long v0, p1

    const/4 p1, 0x2

    invoke-static {p0, v0, v1, p1}, Landroidx/profileinstaller/e;->o(Ljava/io/OutputStream;JI)V

    return-void
.end method

.method static q(Ljava/io/OutputStream;J)V
    .registers 4

    const/4 v0, 0x4

    invoke-static {p0, p1, p2, v0}, Landroidx/profileinstaller/e;->o(Ljava/io/OutputStream;JI)V

    return-void
.end method

.method static r(Ljava/io/OutputStream;I)V
    .registers 4

    int-to-long v0, p1

    const/4 p1, 0x1

    invoke-static {p0, v0, v1, p1}, Landroidx/profileinstaller/e;->o(Ljava/io/OutputStream;JI)V

    return-void
.end method
