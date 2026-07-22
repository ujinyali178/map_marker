.class public Lorg/apache/commons/io/input/WindowsLineEndingInputStream;
.super Ljava/io/InputStream;
.source "SourceFile"


# instance fields
.field private final ensureLineFeedAtEndOfFile:Z

.field private eofSeen:Z

.field private injectSlashN:Z

.field private slashNSeen:Z

.field private slashRSeen:Z

.field private final target:Ljava/io/InputStream;


# direct methods
.method public constructor <init>(Ljava/io/InputStream;Z)V
    .registers 4

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->slashRSeen:Z

    iput-boolean v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->slashNSeen:Z

    iput-boolean v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->injectSlashN:Z

    iput-boolean v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->eofSeen:Z

    iput-object p1, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->target:Ljava/io/InputStream;

    iput-boolean p2, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->ensureLineFeedAtEndOfFile:Z

    return-void
.end method

.method private eofGame()I
    .registers 5

    iget-boolean v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->ensureLineFeedAtEndOfFile:Z

    const/4 v1, -0x1

    if-nez v0, :cond_6

    return v1

    :cond_6
    iget-boolean v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->slashNSeen:Z

    const/4 v2, 0x1

    if-nez v0, :cond_14

    iget-boolean v3, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->slashRSeen:Z

    if-nez v3, :cond_14

    iput-boolean v2, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->slashRSeen:Z

    const/16 v0, 0xd

    return v0

    :cond_14
    if-nez v0, :cond_1e

    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->slashRSeen:Z

    iput-boolean v2, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->slashNSeen:Z

    const/16 v0, 0xa

    return v0

    :cond_1e
    return v1
.end method

.method private readWithUpdate()I
    .registers 5

    iget-object v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->target:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v3, -0x1

    if-ne v0, v3, :cond_d

    const/4 v3, 0x1

    goto :goto_e

    :cond_d
    const/4 v3, 0x0

    :goto_e
    iput-boolean v3, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->eofSeen:Z

    if-eqz v3, :cond_13

    return v0

    :cond_13
    const/16 v3, 0xd

    if-ne v0, v3, :cond_19

    const/4 v3, 0x1

    goto :goto_1a

    :cond_19
    const/4 v3, 0x0

    :goto_1a
    iput-boolean v3, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->slashRSeen:Z

    const/16 v3, 0xa

    if-ne v0, v3, :cond_21

    goto :goto_22

    :cond_21
    const/4 v1, 0x0

    :goto_22
    iput-boolean v1, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->slashNSeen:Z

    return v0
.end method


# virtual methods
.method public close()V
    .registers 2

    invoke-super {p0}, Ljava/io/InputStream;->close()V

    iget-object v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->target:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    return-void
.end method

.method public declared-synchronized mark(I)V
    .registers 3

    monitor-enter p0

    :try_start_1
    new-instance p1, Ljava/lang/UnsupportedOperationException;

    const-string v0, "Mark not supported"

    invoke-direct {p1, v0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p1
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_9

    :catchall_9
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public read()I
    .registers 5

    iget-boolean v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->eofSeen:Z

    if-eqz v0, :cond_9

    invoke-direct {p0}, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->eofGame()I

    move-result v0

    return v0

    :cond_9
    iget-boolean v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->injectSlashN:Z

    const/16 v1, 0xa

    if-eqz v0, :cond_13

    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->injectSlashN:Z

    return v1

    :cond_13
    iget-boolean v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->slashRSeen:Z

    invoke-direct {p0}, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->readWithUpdate()I

    move-result v2

    iget-boolean v3, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->eofSeen:Z

    if-eqz v3, :cond_22

    invoke-direct {p0}, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->eofGame()I

    move-result v0

    return v0

    :cond_22
    if-ne v2, v1, :cond_2c

    if-nez v0, :cond_2c

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/apache/commons/io/input/WindowsLineEndingInputStream;->injectSlashN:Z

    const/16 v0, 0xd

    return v0

    :cond_2c
    return v2
.end method
