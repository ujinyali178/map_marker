.class public Lorg/mapsforge/core/model/LatLong;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable<",
        "Lorg/mapsforge/core/model/LatLong;",
        ">;"
    }
.end annotation


# static fields
.field private static final WKT_POINT_PATTERN:Ljava/util/regex/Pattern;


# instance fields
.field public final latitude:D

.field public final longitude:D


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-string v0, ".*POINT\\s?\\(([\\d\\.]+)\\s([\\d\\.]+)\\).*"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/core/model/LatLong;->WKT_POINT_PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>(DD)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1, p2}, Lorg/mapsforge/core/util/LatLongUtils;->validateLatitude(D)D

    move-result-wide p1

    iput-wide p1, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {p3, p4}, Lorg/mapsforge/core/util/LatLongUtils;->validateLongitude(D)D

    move-result-wide p1

    iput-wide p1, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lorg/mapsforge/core/model/LatLong;->WKT_POINT_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object p1

    invoke-virtual {p1}, Ljava/util/regex/Matcher;->matches()Z

    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    invoke-static {v0, v1}, Lorg/mapsforge/core/util/LatLongUtils;->validateLongitude(D)D

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    const/4 v0, 0x2

    invoke-virtual {p1, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    invoke-static {v0, v1}, Lorg/mapsforge/core/util/LatLongUtils;->validateLatitude(D)D

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    return-void
.end method

.method public static fromMicroDegrees(II)Lorg/mapsforge/core/model/LatLong;
    .registers 5

    new-instance v0, Lorg/mapsforge/core/model/LatLong;

    invoke-static {p0}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide v1

    invoke-static {p1}, Lorg/mapsforge/core/util/LatLongUtils;->microdegreesToDegrees(I)D

    move-result-wide p0

    invoke-direct {v0, v1, v2, p0, p1}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    return-object v0
.end method

.method public static fromString(Ljava/lang/String;)Lorg/mapsforge/core/model/LatLong;
    .registers 5

    const-string v0, "[,;:\\s]"

    invoke-virtual {p0, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object p0

    array-length v0, p0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1e

    const/4 v0, 0x0

    aget-object v0, p0, v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    const/4 v2, 0x1

    aget-object p0, p0, v2

    invoke-static {p0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v2

    new-instance p0, Lorg/mapsforge/core/model/LatLong;

    invoke-direct {p0, v0, v1, v2, v3}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    return-object p0

    :cond_1e
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string v0, "cannot read coordinate, not a valid format"

    invoke-direct {p0, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method


# virtual methods
.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .registers 2

    check-cast p1, Lorg/mapsforge/core/model/LatLong;

    invoke-virtual {p0, p1}, Lorg/mapsforge/core/model/LatLong;->compareTo(Lorg/mapsforge/core/model/LatLong;)I

    move-result p1

    return p1
.end method

.method public compareTo(Lorg/mapsforge/core/model/LatLong;)I
    .registers 10

    iget-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v2, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    cmpl-double v4, v0, v2

    if-gtz v4, :cond_1e

    iget-wide v4, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    iget-wide v6, p1, Lorg/mapsforge/core/model/LatLong;->longitude:D

    cmpl-double p1, v4, v6

    if-lez p1, :cond_11

    goto :goto_1e

    :cond_11
    cmpg-double p1, v0, v2

    if-ltz p1, :cond_1c

    cmpg-double p1, v4, v6

    if-gez p1, :cond_1a

    goto :goto_1c

    :cond_1a
    const/4 p1, 0x0

    return p1

    :cond_1c
    :goto_1c
    const/4 p1, -0x1

    return p1

    :cond_1e
    :goto_1e
    const/4 p1, 0x1

    return p1
.end method

.method public destinationPoint(DF)Lorg/mapsforge/core/model/LatLong;
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lorg/mapsforge/core/util/LatLongUtils;->destinationPoint(Lorg/mapsforge/core/model/LatLong;DF)Lorg/mapsforge/core/model/LatLong;

    move-result-object p1

    return-object p1
.end method

.method public distance(Lorg/mapsforge/core/model/LatLong;)D
    .registers 4

    invoke-static {p0, p1}, Lorg/mapsforge/core/util/LatLongUtils;->distance(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/LatLong;)D

    move-result-wide v0

    return-wide v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 9

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/core/model/LatLong;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/core/model/LatLong;

    iget-wide v3, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v5, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    cmpl-double v1, v3, v5

    if-eqz v1, :cond_15

    return v2

    :cond_15
    iget-wide v3, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    iget-wide v5, p1, Lorg/mapsforge/core/model/LatLong;->longitude:D

    cmpl-double p1, v3, v5

    if-eqz p1, :cond_1e

    return v2

    :cond_1e
    return v0
.end method

.method public getLatitude()D
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    return-wide v0
.end method

.method public getLatitudeE6()I
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v0, v1}, Lorg/mapsforge/core/util/LatLongUtils;->degreesToMicrodegrees(D)I

    move-result v0

    return v0
.end method

.method public getLongitude()D
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    return-wide v0
.end method

.method public getLongitudeE6()I
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v0, v1}, Lorg/mapsforge/core/util/LatLongUtils;->degreesToMicrodegrees(D)I

    move-result v0

    return v0
.end method

.method public hashCode()I
    .registers 8

    iget-wide v0, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-static {v0, v1}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v0

    const/16 v2, 0x20

    ushr-long v3, v0, v2

    xor-long/2addr v0, v3

    long-to-int v1, v0

    const/16 v0, 0x1f

    add-int/2addr v1, v0

    iget-wide v3, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    mul-int/lit8 v1, v1, 0x1f

    ushr-long v5, v3, v2

    xor-long v2, v3, v5

    long-to-int v0, v2

    add-int/2addr v1, v0

    return v1
.end method

.method public sphericalDistance(Lorg/mapsforge/core/model/LatLong;)D
    .registers 4

    invoke-static {p0, p1}, Lorg/mapsforge/core/util/LatLongUtils;->sphericalDistance(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/LatLong;)D

    move-result-wide v0

    return-wide v0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "latitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v1, ", longitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public vincentyDistance(Lorg/mapsforge/core/model/LatLong;)D
    .registers 4

    invoke-static {p0, p1}, Lorg/mapsforge/core/util/LatLongUtils;->vincentyDistance(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/LatLong;)D

    move-result-wide v0

    return-wide v0
.end method
