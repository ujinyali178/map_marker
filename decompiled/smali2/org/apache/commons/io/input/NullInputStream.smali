.class public Lorg/apache/commons/io/input/NullInputStream;
.super Ljava/io/InputStream;
.source "SourceFile"


# instance fields
.field private eof:Z

.field private mark:J

.field private final markSupported:Z

.field private position:J

.field private readlimit:J

.field private final size:J

.field private final throwEofException:Z


# direct methods
.method public constructor <init>(J)V
    .registers 5

    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v0, v1}, Lorg/apache/commons/io/input/NullInputStream;-><init>(JZZ)V

    return-void
.end method

.method public constructor <init>(JZZ)V
    .registers 7

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->mark:J

    iput-wide p1, p0, Lorg/apache/commons/io/input/NullInputStream;->size:J

    iput-boolean p3, p0, Lorg/apache/commons/io/input/NullInputStream;->markSupported:Z

    iput-boolean p4, p0, Lorg/apache/commons/io/input/NullInputStream;->throwEofException:Z

    return-void
.end method

.method private doEndOfFile()I
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/apache/commons/io/input/NullInputStream;->eof:Z

    iget-boolean v0, p0, Lorg/apache/commons/io/input/NullInputStream;->throwEofException:Z

    if-nez v0, :cond_9

    const/4 v0, -0x1

    return v0

    :cond_9
    new-instance v0, Ljava/io/EOFException;

    invoke-direct {v0}, Ljava/io/EOFException;-><init>()V

    throw v0
.end method


# virtual methods
.method public available()I
    .registers 6

    iget-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->size:J

    iget-wide v2, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-gtz v4, :cond_d

    const/4 v0, 0x0

    return v0

    :cond_d
    const-wide/32 v2, 0x7fffffff

    cmp-long v4, v0, v2

    if-lez v4, :cond_18

    const v0, 0x7fffffff

    return v0

    :cond_18
    long-to-int v1, v0

    return v1
.end method

.method public close()V
    .registers 3

    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/apache/commons/io/input/NullInputStream;->eof:Z

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->mark:J

    return-void
.end method

.method public getPosition()J
    .registers 3

    iget-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    return-wide v0
.end method

.method public getSize()J
    .registers 3

    iget-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->size:J

    return-wide v0
.end method

.method public declared-synchronized mark(I)V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lorg/apache/commons/io/input/NullInputStream;->markSupported:Z

    if-eqz v0, :cond_e

    iget-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    iput-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->mark:J

    int-to-long v0, p1

    iput-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->readlimit:J
    :try_end_c
    .catchall {:try_start_1 .. :try_end_c} :catchall_16

    monitor-exit p0

    return-void

    :cond_e
    :try_start_e
    new-instance p1, Ljava/lang/UnsupportedOperationException;

    const-string v0, "Mark not supported"

    invoke-direct {p1, v0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p1
    :try_end_16
    .catchall {:try_start_e .. :try_end_16} :catchall_16

    :catchall_16
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public markSupported()Z
    .registers 2

    iget-boolean v0, p0, Lorg/apache/commons/io/input/NullInputStream;->markSupported:Z

    return v0
.end method

.method protected processByte()I
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method protected processBytes([BII)V
    .registers 4

    return-void
.end method

.method public read()I
    .registers 6

    iget-boolean v0, p0, Lorg/apache/commons/io/input/NullInputStream;->eof:Z

    if-nez v0, :cond_1b

    iget-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    iget-wide v2, p0, Lorg/apache/commons/io/input/NullInputStream;->size:J

    cmp-long v4, v0, v2

    if-nez v4, :cond_11

    invoke-direct {p0}, Lorg/apache/commons/io/input/NullInputStream;->doEndOfFile()I

    move-result v0

    return v0

    :cond_11
    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    invoke-virtual {p0}, Lorg/apache/commons/io/input/NullInputStream;->processByte()I

    move-result v0

    return v0

    :cond_1b
    new-instance v0, Ljava/io/IOException;

    const-string v1, "Read after end of file"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public read([B)I
    .registers 4

    array-length v0, p1

    const/4 v1, 0x0

    invoke-virtual {p0, p1, v1, v0}, Lorg/apache/commons/io/input/NullInputStream;->read([BII)I

    move-result p1

    return p1
.end method

.method public read([BII)I
    .registers 10

    iget-boolean v0, p0, Lorg/apache/commons/io/input/NullInputStream;->eof:Z

    if-nez v0, :cond_22

    iget-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    iget-wide v2, p0, Lorg/apache/commons/io/input/NullInputStream;->size:J

    cmp-long v4, v0, v2

    if-nez v4, :cond_11

    invoke-direct {p0}, Lorg/apache/commons/io/input/NullInputStream;->doEndOfFile()I

    move-result p1

    return p1

    :cond_11
    int-to-long v4, p3

    add-long/2addr v0, v4

    iput-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    cmp-long v4, v0, v2

    if-lez v4, :cond_1e

    sub-long/2addr v0, v2

    long-to-int v1, v0

    sub-int/2addr p3, v1

    iput-wide v2, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    :cond_1e
    invoke-virtual {p0, p1, p2, p3}, Lorg/apache/commons/io/input/NullInputStream;->processBytes([BII)V

    return p3

    :cond_22
    new-instance p1, Ljava/io/IOException;

    const-string p2, "Read after end of file"

    invoke-direct {p1, p2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public declared-synchronized reset()V
    .registers 8

    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lorg/apache/commons/io/input/NullInputStream;->markSupported:Z

    if-eqz v0, :cond_4d

    iget-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->mark:J

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-ltz v4, :cond_45

    iget-wide v2, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    iget-wide v4, p0, Lorg/apache/commons/io/input/NullInputStream;->readlimit:J

    add-long/2addr v4, v0

    cmp-long v6, v2, v4

    if-gtz v6, :cond_1d

    iput-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/apache/commons/io/input/NullInputStream;->eof:Z
    :try_end_1b
    .catchall {:try_start_1 .. :try_end_1b} :catchall_55

    monitor-exit p0

    return-void

    :cond_1d
    :try_start_1d
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Marked position ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v2, p0, Lorg/apache/commons/io/input/NullInputStream;->mark:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v2, "] is no longer valid - passed the read limit ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v2, p0, Lorg/apache/commons/io/input/NullInputStream;->readlimit:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_45
    new-instance v0, Ljava/io/IOException;

    const-string v1, "No position has been marked"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_4d
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Mark not supported"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_55
    .catchall {:try_start_1d .. :try_end_55} :catchall_55

    :catchall_55
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public skip(J)J
    .registers 8

    iget-boolean v0, p0, Lorg/apache/commons/io/input/NullInputStream;->eof:Z

    if-nez v0, :cond_1e

    iget-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    iget-wide v2, p0, Lorg/apache/commons/io/input/NullInputStream;->size:J

    cmp-long v4, v0, v2

    if-nez v4, :cond_12

    invoke-direct {p0}, Lorg/apache/commons/io/input/NullInputStream;->doEndOfFile()I

    move-result p1

    int-to-long p1, p1

    return-wide p1

    :cond_12
    add-long/2addr v0, p1

    iput-wide v0, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    cmp-long v4, v0, v2

    if-lez v4, :cond_1d

    sub-long/2addr v0, v2

    sub-long/2addr p1, v0

    iput-wide v2, p0, Lorg/apache/commons/io/input/NullInputStream;->position:J

    :cond_1d
    return-wide p1

    :cond_1e
    new-instance p1, Ljava/io/IOException;

    const-string p2, "Skip after end of file"

    invoke-direct {p1, p2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
