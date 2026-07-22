.class Landroidx/profileinstaller/o$b;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/profileinstaller/o;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "b"
.end annotation


# instance fields
.field final a:I

.field final b:I

.field final c:J

.field final d:J


# direct methods
.method constructor <init>(IIJJ)V
    .registers 7

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroidx/profileinstaller/o$b;->a:I

    iput p2, p0, Landroidx/profileinstaller/o$b;->b:I

    iput-wide p3, p0, Landroidx/profileinstaller/o$b;->c:J

    iput-wide p5, p0, Landroidx/profileinstaller/o$b;->d:J

    return-void
.end method

.method static a(Ljava/io/File;)Landroidx/profileinstaller/o$b;
    .registers 10

    new-instance v0, Ljava/io/DataInputStream;

    new-instance v1, Ljava/io/FileInputStream;

    invoke-direct {v1, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v0, v1}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    :try_start_a
    new-instance p0, Landroidx/profileinstaller/o$b;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v3

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v4

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readLong()J

    move-result-wide v5

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readLong()J

    move-result-wide v7

    move-object v2, p0

    invoke-direct/range {v2 .. v8}, Landroidx/profileinstaller/o$b;-><init>(IIJJ)V
    :try_end_20
    .catchall {:try_start_a .. :try_end_20} :catchall_24

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    return-object p0

    :catchall_24
    move-exception p0

    :try_start_25
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_28
    .catchall {:try_start_25 .. :try_end_28} :catchall_29

    goto :goto_2d

    :catchall_29
    move-exception v0

    invoke-virtual {p0, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    :goto_2d
    throw p0
.end method


# virtual methods
.method b(Ljava/io/File;)V
    .registers 5

    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    new-instance v0, Ljava/io/DataOutputStream;

    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v0, v1}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    :try_start_d
    iget p1, p0, Landroidx/profileinstaller/o$b;->a:I

    invoke-virtual {v0, p1}, Ljava/io/DataOutputStream;->writeInt(I)V

    iget p1, p0, Landroidx/profileinstaller/o$b;->b:I

    invoke-virtual {v0, p1}, Ljava/io/DataOutputStream;->writeInt(I)V

    iget-wide v1, p0, Landroidx/profileinstaller/o$b;->c:J

    invoke-virtual {v0, v1, v2}, Ljava/io/DataOutputStream;->writeLong(J)V

    iget-wide v1, p0, Landroidx/profileinstaller/o$b;->d:J

    invoke-virtual {v0, v1, v2}, Ljava/io/DataOutputStream;->writeLong(J)V
    :try_end_21
    .catchall {:try_start_d .. :try_end_21} :catchall_25

    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    return-void

    :catchall_25
    move-exception p1

    :try_start_26
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_29
    .catchall {:try_start_26 .. :try_end_29} :catchall_2a

    goto :goto_2e

    :catchall_2a
    move-exception v0

    invoke-virtual {p1, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    :goto_2e
    throw p1
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 9

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    const/4 v1, 0x0

    if-eqz p1, :cond_2d

    instance-of v2, p1, Landroidx/profileinstaller/o$b;

    if-nez v2, :cond_c

    goto :goto_2d

    :cond_c
    check-cast p1, Landroidx/profileinstaller/o$b;

    iget v2, p0, Landroidx/profileinstaller/o$b;->b:I

    iget v3, p1, Landroidx/profileinstaller/o$b;->b:I

    if-ne v2, v3, :cond_2b

    iget-wide v2, p0, Landroidx/profileinstaller/o$b;->c:J

    iget-wide v4, p1, Landroidx/profileinstaller/o$b;->c:J

    cmp-long v6, v2, v4

    if-nez v6, :cond_2b

    iget v2, p0, Landroidx/profileinstaller/o$b;->a:I

    iget v3, p1, Landroidx/profileinstaller/o$b;->a:I

    if-ne v2, v3, :cond_2b

    iget-wide v2, p0, Landroidx/profileinstaller/o$b;->d:J

    iget-wide v4, p1, Landroidx/profileinstaller/o$b;->d:J

    cmp-long p1, v2, v4

    if-nez p1, :cond_2b

    goto :goto_2c

    :cond_2b
    const/4 v0, 0x0

    :goto_2c
    return v0

    :cond_2d
    :goto_2d
    return v1
.end method

.method public hashCode()I
    .registers 4

    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/Object;

    iget v1, p0, Landroidx/profileinstaller/o$b;->b:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    iget-wide v1, p0, Landroidx/profileinstaller/o$b;->c:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const/4 v2, 0x1

    aput-object v1, v0, v2

    iget v1, p0, Landroidx/profileinstaller/o$b;->a:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const/4 v2, 0x2

    aput-object v1, v0, v2

    iget-wide v1, p0, Landroidx/profileinstaller/o$b;->d:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const/4 v2, 0x3

    aput-object v1, v0, v2

    invoke-static {v0}, Ljava/util/Objects;->hash([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method
