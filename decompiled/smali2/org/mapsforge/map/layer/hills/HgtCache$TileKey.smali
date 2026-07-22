.class public final Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/layer/hills/HgtCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1c
    name = "TileKey"
.end annotation


# instance fields
.field final east:I

.field final north:I


# direct methods
.method constructor <init>(II)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;->east:I

    iput p1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;->north:I

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    const/4 v1, 0x0

    if-eqz p1, :cond_21

    const-class v2, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_10

    goto :goto_21

    :cond_10
    check-cast p1, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;

    iget v2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;->north:I

    iget v3, p1, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;->north:I

    if-ne v2, v3, :cond_1f

    iget v2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;->east:I

    iget p1, p1, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;->east:I

    if-ne v2, p1, :cond_1f

    goto :goto_20

    :cond_1f
    const/4 v0, 0x0

    :goto_20
    return v0

    :cond_21
    :goto_21
    return v1
.end method

.method public hashCode()I
    .registers 3

    iget v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;->north:I

    mul-int/lit8 v0, v0, 0x1f

    iget v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;->east:I

    add-int/2addr v0, v1

    return v0
.end method
