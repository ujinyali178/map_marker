.class Lorg/mapsforge/map/reader/IndexCacheEntryKey;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final hashCodeValue:I

.field private final indexBlockNumber:J

.field private final subFileParameter:Lorg/mapsforge/map/reader/header/SubFileParameter;


# direct methods
.method constructor <init>(Lorg/mapsforge/map/reader/header/SubFileParameter;J)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/reader/IndexCacheEntryKey;->subFileParameter:Lorg/mapsforge/map/reader/header/SubFileParameter;

    iput-wide p2, p0, Lorg/mapsforge/map/reader/IndexCacheEntryKey;->indexBlockNumber:J

    invoke-direct {p0}, Lorg/mapsforge/map/reader/IndexCacheEntryKey;->calculateHashCode()I

    move-result p1

    iput p1, p0, Lorg/mapsforge/map/reader/IndexCacheEntryKey;->hashCodeValue:I

    return-void
.end method

.method private calculateHashCode()I
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/reader/IndexCacheEntryKey;->subFileParameter:Lorg/mapsforge/map/reader/header/SubFileParameter;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_a

    :cond_6
    invoke-virtual {v0}, Lorg/mapsforge/map/reader/header/SubFileParameter;->hashCode()I

    move-result v0

    :goto_a
    const/16 v1, 0xd9

    add-int/2addr v1, v0

    mul-int/lit8 v1, v1, 0x1f

    iget-wide v2, p0, Lorg/mapsforge/map/reader/IndexCacheEntryKey;->indexBlockNumber:J

    const/16 v0, 0x20

    ushr-long v4, v2, v0

    xor-long/2addr v2, v4

    long-to-int v0, v2

    add-int/2addr v1, v0

    return v1
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 9

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/map/reader/IndexCacheEntryKey;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/map/reader/IndexCacheEntryKey;

    iget-object v1, p0, Lorg/mapsforge/map/reader/IndexCacheEntryKey;->subFileParameter:Lorg/mapsforge/map/reader/header/SubFileParameter;

    if-nez v1, :cond_15

    iget-object v3, p1, Lorg/mapsforge/map/reader/IndexCacheEntryKey;->subFileParameter:Lorg/mapsforge/map/reader/header/SubFileParameter;

    if-eqz v3, :cond_15

    return v2

    :cond_15
    if-eqz v1, :cond_20

    iget-object v3, p1, Lorg/mapsforge/map/reader/IndexCacheEntryKey;->subFileParameter:Lorg/mapsforge/map/reader/header/SubFileParameter;

    invoke-virtual {v1, v3}, Lorg/mapsforge/map/reader/header/SubFileParameter;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_20

    return v2

    :cond_20
    iget-wide v3, p0, Lorg/mapsforge/map/reader/IndexCacheEntryKey;->indexBlockNumber:J

    iget-wide v5, p1, Lorg/mapsforge/map/reader/IndexCacheEntryKey;->indexBlockNumber:J

    cmp-long p1, v3, v5

    if-eqz p1, :cond_29

    return v2

    :cond_29
    return v0
.end method

.method public hashCode()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/reader/IndexCacheEntryKey;->hashCodeValue:I

    return v0
.end method
