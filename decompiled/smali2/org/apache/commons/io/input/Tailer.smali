.class public Lorg/apache/commons/io/input/Tailer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static final DEFAULT_BUFSIZE:I = 0x1000

.field private static final DEFAULT_CHARSET:Ljava/nio/charset/Charset;

.field private static final DEFAULT_DELAY_MILLIS:I = 0x3e8

.field private static final RAF_MODE:Ljava/lang/String; = "r"


# instance fields
.field private final cset:Ljava/nio/charset/Charset;

.field private final delayMillis:J

.field private final end:Z

.field private final file:Ljava/io/File;

.field private final inbuf:[B

.field private final listener:Lorg/apache/commons/io/input/TailerListener;

.field private final reOpen:Z

.field private volatile run:Z


# direct methods
.method static constructor <clinit>()V
    .registers 1

    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/io/input/Tailer;->DEFAULT_CHARSET:Ljava/nio/charset/Charset;

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Ljava/nio/charset/Charset;Lorg/apache/commons/io/input/TailerListener;JZZI)V
    .registers 10

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/apache/commons/io/input/Tailer;->run:Z

    iput-object p1, p0, Lorg/apache/commons/io/input/Tailer;->file:Ljava/io/File;

    iput-wide p4, p0, Lorg/apache/commons/io/input/Tailer;->delayMillis:J

    iput-boolean p6, p0, Lorg/apache/commons/io/input/Tailer;->end:Z

    new-array p1, p8, [B

    iput-object p1, p0, Lorg/apache/commons/io/input/Tailer;->inbuf:[B

    iput-object p3, p0, Lorg/apache/commons/io/input/Tailer;->listener:Lorg/apache/commons/io/input/TailerListener;

    invoke-interface {p3, p0}, Lorg/apache/commons/io/input/TailerListener;->init(Lorg/apache/commons/io/input/Tailer;)V

    iput-boolean p7, p0, Lorg/apache/commons/io/input/Tailer;->reOpen:Z

    iput-object p2, p0, Lorg/apache/commons/io/input/Tailer;->cset:Ljava/nio/charset/Charset;

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;)V
    .registers 5

    const-wide/16 v0, 0x3e8

    invoke-direct {p0, p1, p2, v0, v1}, Lorg/apache/commons/io/input/Tailer;-><init>(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;J)V

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;J)V
    .registers 11

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-wide v3, p3

    invoke-direct/range {v0 .. v5}, Lorg/apache/commons/io/input/Tailer;-><init>(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZ)V

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZ)V
    .registers 13

    const/16 v6, 0x1000

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-wide v3, p3

    move v5, p5

    invoke-direct/range {v0 .. v6}, Lorg/apache/commons/io/input/Tailer;-><init>(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZI)V

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZI)V
    .registers 15

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-wide v3, p3

    move v5, p5

    move v7, p6

    invoke-direct/range {v0 .. v7}, Lorg/apache/commons/io/input/Tailer;-><init>(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZZI)V

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZZ)V
    .registers 15

    const/16 v7, 0x1000

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-wide v3, p3

    move v5, p5

    move v6, p6

    invoke-direct/range {v0 .. v7}, Lorg/apache/commons/io/input/Tailer;-><init>(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZZI)V

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZZI)V
    .registers 17

    sget-object v2, Lorg/apache/commons/io/input/Tailer;->DEFAULT_CHARSET:Ljava/nio/charset/Charset;

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-wide v4, p3

    move v6, p5

    move v7, p6

    move/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lorg/apache/commons/io/input/Tailer;-><init>(Ljava/io/File;Ljava/nio/charset/Charset;Lorg/apache/commons/io/input/TailerListener;JZZI)V

    return-void
.end method

.method public static create(Ljava/io/File;Ljava/nio/charset/Charset;Lorg/apache/commons/io/input/TailerListener;JZZI)Lorg/apache/commons/io/input/Tailer;
    .registers 18

    new-instance v9, Lorg/apache/commons/io/input/Tailer;

    move-object v0, v9

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-wide v4, p3

    move v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lorg/apache/commons/io/input/Tailer;-><init>(Ljava/io/File;Ljava/nio/charset/Charset;Lorg/apache/commons/io/input/TailerListener;JZZI)V

    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, v9}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/Thread;->setDaemon(Z)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    return-object v9
.end method

.method public static create(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;)Lorg/apache/commons/io/input/Tailer;
    .registers 5

    const-wide/16 v0, 0x3e8

    const/4 v2, 0x0

    invoke-static {p0, p1, v0, v1, v2}, Lorg/apache/commons/io/input/Tailer;->create(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZ)Lorg/apache/commons/io/input/Tailer;

    move-result-object p0

    return-object p0
.end method

.method public static create(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;J)Lorg/apache/commons/io/input/Tailer;
    .registers 5

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, p3, v0}, Lorg/apache/commons/io/input/Tailer;->create(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZ)Lorg/apache/commons/io/input/Tailer;

    move-result-object p0

    return-object p0
.end method

.method public static create(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZ)Lorg/apache/commons/io/input/Tailer;
    .registers 11

    const/16 v5, 0x1000

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move v4, p4

    invoke-static/range {v0 .. v5}, Lorg/apache/commons/io/input/Tailer;->create(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZI)Lorg/apache/commons/io/input/Tailer;

    move-result-object p0

    return-object p0
.end method

.method public static create(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZI)Lorg/apache/commons/io/input/Tailer;
    .registers 13

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move v4, p4

    move v6, p5

    invoke-static/range {v0 .. v6}, Lorg/apache/commons/io/input/Tailer;->create(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZZI)Lorg/apache/commons/io/input/Tailer;

    move-result-object p0

    return-object p0
.end method

.method public static create(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZZ)Lorg/apache/commons/io/input/Tailer;
    .registers 13

    const/16 v6, 0x1000

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move v4, p4

    move v5, p5

    invoke-static/range {v0 .. v6}, Lorg/apache/commons/io/input/Tailer;->create(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZZI)Lorg/apache/commons/io/input/Tailer;

    move-result-object p0

    return-object p0
.end method

.method public static create(Ljava/io/File;Lorg/apache/commons/io/input/TailerListener;JZZI)Lorg/apache/commons/io/input/Tailer;
    .registers 15

    sget-object v1, Lorg/apache/commons/io/input/Tailer;->DEFAULT_CHARSET:Ljava/nio/charset/Charset;

    move-object v0, p0

    move-object v2, p1

    move-wide v3, p2

    move v5, p4

    move v6, p5

    move v7, p6

    invoke-static/range {v0 .. v7}, Lorg/apache/commons/io/input/Tailer;->create(Ljava/io/File;Ljava/nio/charset/Charset;Lorg/apache/commons/io/input/TailerListener;JZZI)Lorg/apache/commons/io/input/Tailer;

    move-result-object p0

    return-object p0
.end method

.method private readLines(Ljava/io/RandomAccessFile;)J
    .registers 15

    new-instance v0, Ljava/io/ByteArrayOutputStream;

    const/16 v1, 0x40

    invoke-direct {v0, v1}, Ljava/io/ByteArrayOutputStream;-><init>(I)V

    :try_start_7
    invoke-virtual {p1}, Ljava/io/RandomAccessFile;->getFilePointer()J

    move-result-wide v1

    const/4 v3, 0x0

    move-wide v4, v1

    const/4 v6, 0x0

    :goto_e
    invoke-virtual {p0}, Lorg/apache/commons/io/input/Tailer;->getRun()Z

    move-result v7

    if-eqz v7, :cond_71

    iget-object v7, p0, Lorg/apache/commons/io/input/Tailer;->inbuf:[B

    invoke-virtual {p1, v7}, Ljava/io/RandomAccessFile;->read([B)I

    move-result v7

    const/4 v8, -0x1

    if-eq v7, v8, :cond_71

    const/4 v8, 0x0

    :goto_1e
    if-ge v8, v7, :cond_6c

    iget-object v9, p0, Lorg/apache/commons/io/input/Tailer;->inbuf:[B

    aget-byte v9, v9, v8

    const/16 v10, 0xa

    const-wide/16 v11, 0x1

    if-eq v9, v10, :cond_52

    const/16 v10, 0xd

    if-eq v9, v10, :cond_4b

    if-eqz v6, :cond_47

    iget-object v1, p0, Lorg/apache/commons/io/input/Tailer;->listener:Lorg/apache/commons/io/input/TailerListener;

    new-instance v2, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v6

    iget-object v10, p0, Lorg/apache/commons/io/input/Tailer;->cset:Ljava/nio/charset/Charset;

    invoke-direct {v2, v6, v10}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-interface {v1, v2}, Lorg/apache/commons/io/input/TailerListener;->handle(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->reset()V

    int-to-long v1, v8

    add-long/2addr v1, v4

    add-long/2addr v1, v11

    const/4 v6, 0x0

    :cond_47
    invoke-virtual {v0, v9}, Ljava/io/ByteArrayOutputStream;->write(I)V

    goto :goto_69

    :cond_4b
    if-eqz v6, :cond_50

    invoke-virtual {v0, v10}, Ljava/io/ByteArrayOutputStream;->write(I)V

    :cond_50
    const/4 v6, 0x1

    goto :goto_69

    :cond_52
    iget-object v1, p0, Lorg/apache/commons/io/input/Tailer;->listener:Lorg/apache/commons/io/input/TailerListener;

    new-instance v2, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v6

    iget-object v9, p0, Lorg/apache/commons/io/input/Tailer;->cset:Ljava/nio/charset/Charset;

    invoke-direct {v2, v6, v9}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-interface {v1, v2}, Lorg/apache/commons/io/input/TailerListener;->handle(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->reset()V

    int-to-long v1, v8

    add-long/2addr v1, v4

    add-long/2addr v1, v11

    const/4 v6, 0x0

    :goto_69
    add-int/lit8 v8, v8, 0x1

    goto :goto_1e

    :cond_6c
    invoke-virtual {p1}, Ljava/io/RandomAccessFile;->getFilePointer()J

    move-result-wide v4

    goto :goto_e

    :cond_71
    invoke-virtual {p1, v1, v2}, Ljava/io/RandomAccessFile;->seek(J)V

    iget-object p1, p0, Lorg/apache/commons/io/input/Tailer;->listener:Lorg/apache/commons/io/input/TailerListener;

    instance-of v3, p1, Lorg/apache/commons/io/input/TailerListenerAdapter;

    if-eqz v3, :cond_7f

    check-cast p1, Lorg/apache/commons/io/input/TailerListenerAdapter;

    invoke-virtual {p1}, Lorg/apache/commons/io/input/TailerListenerAdapter;->endOfFileReached()V
    :try_end_7f
    .catchall {:try_start_7 .. :try_end_7f} :catchall_83

    :cond_7f
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V

    return-wide v1

    :catchall_83
    move-exception p1

    :try_start_84
    throw p1
    :try_end_85
    .catchall {:try_start_84 .. :try_end_85} :catchall_85

    :catchall_85
    move-exception v1

    :try_start_86
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_89
    .catchall {:try_start_86 .. :try_end_89} :catchall_8a

    goto :goto_8e

    :catchall_8a
    move-exception v0

    invoke-virtual {p1, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    :goto_8e
    throw v1
.end method


# virtual methods
.method public getDelay()J
    .registers 3

    iget-wide v0, p0, Lorg/apache/commons/io/input/Tailer;->delayMillis:J

    return-wide v0
.end method

.method public getFile()Ljava/io/File;
    .registers 2

    iget-object v0, p0, Lorg/apache/commons/io/input/Tailer;->file:Ljava/io/File;

    return-object v0
.end method

.method protected getRun()Z
    .registers 2

    iget-boolean v0, p0, Lorg/apache/commons/io/input/Tailer;->run:Z

    return v0
.end method

.method public run()V
    .registers 15

    const-wide/16 v0, 0x0

    const/4 v2, 0x0

    move-wide v3, v0

    move-wide v5, v3

    :goto_5
    :try_start_5
    invoke-virtual {p0}, Lorg/apache/commons/io/input/Tailer;->getRun()Z

    move-result v7
    :try_end_9
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_9} :catch_fa
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_9} :catch_e4
    .catchall {:try_start_5 .. :try_end_9} :catchall_e2

    const-string v8, "r"

    if-eqz v7, :cond_3c

    if-nez v2, :cond_3c

    :try_start_f
    new-instance v7, Ljava/io/RandomAccessFile;

    iget-object v9, p0, Lorg/apache/commons/io/input/Tailer;->file:Ljava/io/File;

    invoke-direct {v7, v9, v8}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_16
    .catch Ljava/io/FileNotFoundException; {:try_start_f .. :try_end_16} :catch_18
    .catch Ljava/lang/InterruptedException; {:try_start_f .. :try_end_16} :catch_fa
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_16} :catch_e4
    .catchall {:try_start_f .. :try_end_16} :catchall_e2

    move-object v2, v7

    goto :goto_1d

    :catch_18
    :try_start_18
    iget-object v7, p0, Lorg/apache/commons/io/input/Tailer;->listener:Lorg/apache/commons/io/input/TailerListener;

    invoke-interface {v7}, Lorg/apache/commons/io/input/TailerListener;->fileNotFound()V

    :goto_1d
    if-nez v2, :cond_25

    iget-wide v7, p0, Lorg/apache/commons/io/input/Tailer;->delayMillis:J

    invoke-static {v7, v8}, Ljava/lang/Thread;->sleep(J)V

    goto :goto_5

    :cond_25
    iget-boolean v3, p0, Lorg/apache/commons/io/input/Tailer;->end:Z

    if-eqz v3, :cond_31

    iget-object v3, p0, Lorg/apache/commons/io/input/Tailer;->file:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->length()J

    move-result-wide v3

    move-wide v5, v3

    goto :goto_32

    :cond_31
    move-wide v5, v0

    :goto_32
    iget-object v3, p0, Lorg/apache/commons/io/input/Tailer;->file:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->lastModified()J

    move-result-wide v3

    invoke-virtual {v2, v5, v6}, Ljava/io/RandomAccessFile;->seek(J)V

    goto :goto_5

    :cond_3c
    :goto_3c
    invoke-virtual {p0}, Lorg/apache/commons/io/input/Tailer;->getRun()Z

    move-result v7

    if-eqz v7, :cond_da

    iget-object v7, p0, Lorg/apache/commons/io/input/Tailer;->file:Ljava/io/File;

    invoke-static {v7, v3, v4}, Lorg/apache/commons/io/FileUtils;->isFileNewer(Ljava/io/File;J)Z

    move-result v7

    iget-object v9, p0, Lorg/apache/commons/io/input/Tailer;->file:Ljava/io/File;

    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v9

    cmp-long v11, v9, v5

    if-gez v11, :cond_9b

    iget-object v7, p0, Lorg/apache/commons/io/input/Tailer;->listener:Lorg/apache/commons/io/input/TailerListener;

    invoke-interface {v7}, Lorg/apache/commons/io/input/TailerListener;->fileRotated()V
    :try_end_57
    .catch Ljava/lang/InterruptedException; {:try_start_18 .. :try_end_57} :catch_fa
    .catch Ljava/lang/Exception; {:try_start_18 .. :try_end_57} :catch_e4
    .catchall {:try_start_18 .. :try_end_57} :catchall_e2

    :try_start_57
    new-instance v7, Ljava/io/RandomAccessFile;

    iget-object v9, p0, Lorg/apache/commons/io/input/Tailer;->file:Ljava/io/File;

    invoke-direct {v7, v9, v8}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_5e
    .catchall {:try_start_57 .. :try_end_5e} :catchall_75

    :try_start_5e
    invoke-direct {p0, v2}, Lorg/apache/commons/io/input/Tailer;->readLines(Ljava/io/RandomAccessFile;)J
    :try_end_61
    .catch Ljava/io/IOException; {:try_start_5e .. :try_end_61} :catch_64
    .catchall {:try_start_5e .. :try_end_61} :catchall_62

    goto :goto_6a

    :catchall_62
    move-exception v9

    goto :goto_77

    :catch_64
    move-exception v9

    :try_start_65
    iget-object v10, p0, Lorg/apache/commons/io/input/Tailer;->listener:Lorg/apache/commons/io/input/TailerListener;

    invoke-interface {v10, v9}, Lorg/apache/commons/io/input/TailerListener;->handle(Ljava/lang/Exception;)V
    :try_end_6a
    .catchall {:try_start_65 .. :try_end_6a} :catchall_62

    :goto_6a
    if-eqz v2, :cond_72

    :try_start_6c
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_6f
    .catch Ljava/io/FileNotFoundException; {:try_start_6c .. :try_end_6f} :catch_70
    .catch Ljava/lang/InterruptedException; {:try_start_6c .. :try_end_6f} :catch_8b
    .catch Ljava/lang/Exception; {:try_start_6c .. :try_end_6f} :catch_88
    .catchall {:try_start_6c .. :try_end_6f} :catchall_84

    goto :goto_72

    :catch_70
    move-wide v5, v0

    goto :goto_8f

    :cond_72
    :goto_72
    move-wide v5, v0

    :goto_73
    move-object v2, v7

    goto :goto_3c

    :catchall_75
    move-exception v9

    move-object v7, v2

    :goto_77
    :try_start_77
    throw v9
    :try_end_78
    .catchall {:try_start_77 .. :try_end_78} :catchall_78

    :catchall_78
    move-exception v10

    if-eqz v2, :cond_83

    :try_start_7b
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_7e
    .catchall {:try_start_7b .. :try_end_7e} :catchall_7f

    goto :goto_83

    :catchall_7f
    move-exception v2

    :try_start_80
    invoke-virtual {v9, v2}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    :cond_83
    :goto_83
    throw v10
    :try_end_84
    .catch Ljava/io/FileNotFoundException; {:try_start_80 .. :try_end_84} :catch_8f
    .catch Ljava/lang/InterruptedException; {:try_start_80 .. :try_end_84} :catch_8b
    .catch Ljava/lang/Exception; {:try_start_80 .. :try_end_84} :catch_88
    .catchall {:try_start_80 .. :try_end_84} :catchall_84

    :catchall_84
    move-exception v0

    move-object v2, v7

    goto/16 :goto_110

    :catch_88
    move-exception v0

    move-object v2, v7

    goto :goto_e5

    :catch_8b
    move-exception v0

    move-object v2, v7

    goto/16 :goto_fb

    :catch_8f
    :goto_8f
    move-object v2, v7

    :try_start_90
    iget-object v7, p0, Lorg/apache/commons/io/input/Tailer;->listener:Lorg/apache/commons/io/input/TailerListener;

    invoke-interface {v7}, Lorg/apache/commons/io/input/TailerListener;->fileNotFound()V

    iget-wide v9, p0, Lorg/apache/commons/io/input/Tailer;->delayMillis:J

    invoke-static {v9, v10}, Ljava/lang/Thread;->sleep(J)V

    goto :goto_3c

    :cond_9b
    if-lez v11, :cond_ab

    invoke-direct {p0, v2}, Lorg/apache/commons/io/input/Tailer;->readLines(Ljava/io/RandomAccessFile;)J

    move-result-wide v3

    iget-object v5, p0, Lorg/apache/commons/io/input/Tailer;->file:Ljava/io/File;

    :goto_a3
    invoke-virtual {v5}, Ljava/io/File;->lastModified()J

    move-result-wide v5

    move-wide v12, v3

    move-wide v3, v5

    move-wide v5, v12

    goto :goto_b7

    :cond_ab
    if-eqz v7, :cond_b7

    invoke-virtual {v2, v0, v1}, Ljava/io/RandomAccessFile;->seek(J)V

    invoke-direct {p0, v2}, Lorg/apache/commons/io/input/Tailer;->readLines(Ljava/io/RandomAccessFile;)J

    move-result-wide v3

    iget-object v5, p0, Lorg/apache/commons/io/input/Tailer;->file:Ljava/io/File;

    goto :goto_a3

    :cond_b7
    :goto_b7
    iget-boolean v7, p0, Lorg/apache/commons/io/input/Tailer;->reOpen:Z

    if-eqz v7, :cond_c0

    if-eqz v2, :cond_c0

    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V

    :cond_c0
    iget-wide v9, p0, Lorg/apache/commons/io/input/Tailer;->delayMillis:J

    invoke-static {v9, v10}, Ljava/lang/Thread;->sleep(J)V

    invoke-virtual {p0}, Lorg/apache/commons/io/input/Tailer;->getRun()Z

    move-result v7

    if-eqz v7, :cond_3c

    iget-boolean v7, p0, Lorg/apache/commons/io/input/Tailer;->reOpen:Z

    if-eqz v7, :cond_3c

    new-instance v7, Ljava/io/RandomAccessFile;

    iget-object v9, p0, Lorg/apache/commons/io/input/Tailer;->file:Ljava/io/File;

    invoke-direct {v7, v9, v8}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_d6
    .catch Ljava/lang/InterruptedException; {:try_start_90 .. :try_end_d6} :catch_fa
    .catch Ljava/lang/Exception; {:try_start_90 .. :try_end_d6} :catch_e4
    .catchall {:try_start_90 .. :try_end_d6} :catchall_e2

    :try_start_d6
    invoke-virtual {v7, v5, v6}, Ljava/io/RandomAccessFile;->seek(J)V
    :try_end_d9
    .catch Ljava/lang/InterruptedException; {:try_start_d6 .. :try_end_d9} :catch_8b
    .catch Ljava/lang/Exception; {:try_start_d6 .. :try_end_d9} :catch_88
    .catchall {:try_start_d6 .. :try_end_d9} :catchall_84

    goto :goto_73

    :cond_da
    if-eqz v2, :cond_f6

    :try_start_dc
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_df
    .catch Ljava/io/IOException; {:try_start_dc .. :try_end_df} :catch_e0

    goto :goto_f6

    :catch_e0
    move-exception v0

    goto :goto_f1

    :catchall_e2
    move-exception v0

    goto :goto_110

    :catch_e4
    move-exception v0

    :goto_e5
    :try_start_e5
    iget-object v1, p0, Lorg/apache/commons/io/input/Tailer;->listener:Lorg/apache/commons/io/input/TailerListener;

    invoke-interface {v1, v0}, Lorg/apache/commons/io/input/TailerListener;->handle(Ljava/lang/Exception;)V
    :try_end_ea
    .catchall {:try_start_e5 .. :try_end_ea} :catchall_e2

    if-eqz v2, :cond_f6

    :try_start_ec
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_ef
    .catch Ljava/io/IOException; {:try_start_ec .. :try_end_ef} :catch_f0

    goto :goto_f6

    :catch_f0
    move-exception v0

    :goto_f1
    iget-object v1, p0, Lorg/apache/commons/io/input/Tailer;->listener:Lorg/apache/commons/io/input/TailerListener;

    invoke-interface {v1, v0}, Lorg/apache/commons/io/input/TailerListener;->handle(Ljava/lang/Exception;)V

    :cond_f6
    :goto_f6
    invoke-virtual {p0}, Lorg/apache/commons/io/input/Tailer;->stop()V

    goto :goto_10f

    :catch_fa
    move-exception v0

    :goto_fb
    :try_start_fb
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->interrupt()V

    iget-object v1, p0, Lorg/apache/commons/io/input/Tailer;->listener:Lorg/apache/commons/io/input/TailerListener;

    invoke-interface {v1, v0}, Lorg/apache/commons/io/input/TailerListener;->handle(Ljava/lang/Exception;)V
    :try_end_107
    .catchall {:try_start_fb .. :try_end_107} :catchall_e2

    if-eqz v2, :cond_f6

    :try_start_109
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_10c
    .catch Ljava/io/IOException; {:try_start_109 .. :try_end_10c} :catch_10d

    goto :goto_f6

    :catch_10d
    move-exception v0

    goto :goto_f1

    :goto_10f
    return-void

    :goto_110
    if-eqz v2, :cond_11c

    :try_start_112
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_115
    .catch Ljava/io/IOException; {:try_start_112 .. :try_end_115} :catch_116

    goto :goto_11c

    :catch_116
    move-exception v1

    iget-object v2, p0, Lorg/apache/commons/io/input/Tailer;->listener:Lorg/apache/commons/io/input/TailerListener;

    invoke-interface {v2, v1}, Lorg/apache/commons/io/input/TailerListener;->handle(Ljava/lang/Exception;)V

    :cond_11c
    :goto_11c
    invoke-virtual {p0}, Lorg/apache/commons/io/input/Tailer;->stop()V

    throw v0
.end method

.method public stop()V
    .registers 2

    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/apache/commons/io/input/Tailer;->run:Z

    return-void
.end method
