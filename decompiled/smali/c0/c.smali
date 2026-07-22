.class Lc0/c;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:I

.field private b:J


# direct methods
.method constructor <init>(JI)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide p1, p0, Lc0/c;->b:J

    iput p3, p0, Lc0/c;->a:I

    return-void
.end method

.method static b(Ljava/lang/String;II)Lc0/c;
    .registers 13

    const/4 v0, 0x0

    if-lt p1, p2, :cond_4

    return-object v0

    :cond_4
    const-wide/16 v1, 0x0

    move v3, p1

    :goto_7
    if-ge v3, p2, :cond_4a

    invoke-virtual {p0, v3}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x30

    const-wide/16 v6, 0x10

    if-lt v4, v5, :cond_1e

    const/16 v5, 0x39

    if-gt v4, v5, :cond_1e

    mul-long v1, v1, v6

    add-int/lit8 v4, v4, -0x30

    int-to-long v4, v4

    add-long/2addr v1, v4

    goto :goto_3d

    :cond_1e
    const-wide/16 v8, 0xa

    const/16 v5, 0x41

    if-lt v4, v5, :cond_30

    const/16 v5, 0x46

    if-gt v4, v5, :cond_30

    mul-long v1, v1, v6

    add-int/lit8 v4, v4, -0x41

    :goto_2c
    int-to-long v4, v4

    add-long/2addr v1, v4

    add-long/2addr v1, v8

    goto :goto_3d

    :cond_30
    const/16 v5, 0x61

    if-lt v4, v5, :cond_4a

    const/16 v5, 0x66

    if-gt v4, v5, :cond_4a

    mul-long v1, v1, v6

    add-int/lit8 v4, v4, -0x61

    goto :goto_2c

    :goto_3d
    const-wide v4, 0xffffffffL

    cmp-long v6, v1, v4

    if-lez v6, :cond_47

    return-object v0

    :cond_47
    add-int/lit8 v3, v3, 0x1

    goto :goto_7

    :cond_4a
    if-ne v3, p1, :cond_4d

    return-object v0

    :cond_4d
    new-instance p0, Lc0/c;

    invoke-direct {p0, v1, v2, v3}, Lc0/c;-><init>(JI)V

    return-object p0
.end method

.method static c(Ljava/lang/String;IIZ)Lc0/c;
    .registers 11

    const/4 v0, 0x0

    if-lt p1, p2, :cond_4

    return-object v0

    :cond_4
    const/4 v1, 0x0

    if-eqz p3, :cond_17

    invoke-virtual {p0, p1}, Ljava/lang/String;->charAt(I)C

    move-result p3

    const/16 v2, 0x2b

    if-eq p3, v2, :cond_15

    const/16 v2, 0x2d

    if-eq p3, v2, :cond_14

    goto :goto_17

    :cond_14
    const/4 v1, 0x1

    :cond_15
    add-int/lit8 p1, p1, 0x1

    :cond_17
    :goto_17
    const-wide/16 v2, 0x0

    move p3, p1

    :goto_1a
    if-ge p3, p2, :cond_46

    invoke-virtual {p0, p3}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x30

    if-lt v4, v5, :cond_46

    const/16 v5, 0x39

    if-gt v4, v5, :cond_46

    const-wide/16 v5, 0xa

    mul-long v2, v2, v5

    add-int/lit8 v4, v4, -0x30

    int-to-long v4, v4

    if-eqz v1, :cond_3a

    sub-long/2addr v2, v4

    const-wide/32 v4, -0x80000000

    cmp-long v6, v2, v4

    if-gez v6, :cond_43

    return-object v0

    :cond_3a
    add-long/2addr v2, v4

    const-wide/32 v4, 0x7fffffff

    cmp-long v6, v2, v4

    if-lez v6, :cond_43

    return-object v0

    :cond_43
    add-int/lit8 p3, p3, 0x1

    goto :goto_1a

    :cond_46
    if-ne p3, p1, :cond_49

    return-object v0

    :cond_49
    new-instance p0, Lc0/c;

    invoke-direct {p0, v2, v3, p3}, Lc0/c;-><init>(JI)V

    return-object p0
.end method


# virtual methods
.method a()I
    .registers 2

    iget v0, p0, Lc0/c;->a:I

    return v0
.end method

.method public d()I
    .registers 3

    iget-wide v0, p0, Lc0/c;->b:J

    long-to-int v1, v0

    return v1
.end method
