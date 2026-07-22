.class public abstract Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/download/tilesource/TileSource;


# static fields
.field private static final TIMEOUT_CONNECT:I = 0x1388

.field private static final TIMEOUT_READ:I = 0x2710


# instance fields
.field protected apiKey:Ljava/lang/String;

.field protected authorization:Ljava/lang/String;

.field protected defaultTimeToLive:J

.field protected followRedirects:Z

.field protected final hostNames:[Ljava/lang/String;

.field protected keyName:Ljava/lang/String;

.field protected final port:I

.field protected final random:Ljava/util/Random;

.field protected referer:Ljava/lang/String;

.field protected timeoutConnect:I

.field protected timeoutRead:I

.field protected userAgent:Ljava/lang/String;


# direct methods
.method protected constructor <init>([Ljava/lang/String;I)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-wide/32 v0, 0x5265c00

    iput-wide v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->defaultTimeToLive:J

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->followRedirects:Z

    const-string v0, "key"

    iput-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->keyName:Ljava/lang/String;

    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->random:Ljava/util/Random;

    const/16 v0, 0x1388

    iput v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->timeoutConnect:I

    const/16 v0, 0x2710

    iput v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->timeoutRead:I

    if-eqz p1, :cond_5d

    array-length v0, p1

    if-eqz v0, :cond_5d

    if-ltz p2, :cond_46

    const v0, 0xffff

    if-gt p2, v0, :cond_46

    array-length v0, p1

    const/4 v1, 0x0

    :goto_2c
    if-ge v1, v0, :cond_41

    aget-object v2, p1, v1

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_39

    add-int/lit8 v1, v1, 0x1

    goto :goto_2c

    :cond_39
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "empty host name in host name list"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_41
    iput-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->hostNames:[Ljava/lang/String;

    iput p2, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->port:I

    return-void

    :cond_46
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "invalid port number: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_5d
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "no host names specified"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->hostNames:[Ljava/lang/String;

    iget-object v3, p1, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->hostNames:[Ljava/lang/String;

    invoke-static {v1, v3}, Ljava/util/Arrays;->equals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_17

    return v2

    :cond_17
    iget v1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->port:I

    iget p1, p1, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->port:I

    if-eq v1, p1, :cond_1e

    return v2

    :cond_1e
    return v0
.end method

.method public getApiKey()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->apiKey:Ljava/lang/String;

    return-object v0
.end method

.method public getAuthorization()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->authorization:Ljava/lang/String;

    return-object v0
.end method

.method public getDefaultTimeToLive()J
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->defaultTimeToLive:J

    return-wide v0
.end method

.method protected getHostName()Ljava/lang/String;
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->hostNames:[Ljava/lang/String;

    iget-object v1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->random:Ljava/util/Random;

    array-length v2, v0

    invoke-virtual {v1, v2}, Ljava/util/Random;->nextInt(I)I

    move-result v1

    aget-object v0, v0, v1

    return-object v0
.end method

.method public getKeyName()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->keyName:Ljava/lang/String;

    return-object v0
.end method

.method public getReferer()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->referer:Ljava/lang/String;

    return-object v0
.end method

.method public getTimeoutConnect()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->timeoutConnect:I

    return v0
.end method

.method public getTimeoutRead()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->timeoutRead:I

    return v0
.end method

.method public getUserAgent()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->hostNames:[Ljava/lang/String;

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([Ljava/lang/Object;)I

    move-result v0

    const/16 v1, 0x1f

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget v1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->port:I

    add-int/2addr v0, v1

    return v0
.end method

.method public isFollowRedirects()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->followRedirects:Z

    return v0
.end method

.method public setApiKey(Ljava/lang/String;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->apiKey:Ljava/lang/String;

    return-void
.end method

.method public setAuthorization(Ljava/lang/String;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->authorization:Ljava/lang/String;

    return-void
.end method

.method public setFollowRedirects(Z)V
    .registers 2

    iput-boolean p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->followRedirects:Z

    return-void
.end method

.method public setKeyName(Ljava/lang/String;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->keyName:Ljava/lang/String;

    return-void
.end method

.method public setReferer(Ljava/lang/String;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->referer:Ljava/lang/String;

    return-void
.end method

.method public setTimeoutConnect(I)V
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->timeoutConnect:I

    return-void
.end method

.method public setTimeoutRead(I)V
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->timeoutRead:I

    return-void
.end method

.method public setUserAgent(Ljava/lang/String;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/download/tilesource/AbstractTileSource;->userAgent:Ljava/lang/String;

    return-void
.end method
