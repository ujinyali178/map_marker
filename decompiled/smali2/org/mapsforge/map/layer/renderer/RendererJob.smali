.class public Lorg/mapsforge/map/layer/renderer/RendererJob;
.super Lorg/mapsforge/map/layer/queue/Job;
.source "SourceFile"


# instance fields
.field public final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field private final hashCodeValue:I

.field public labelsOnly:Z

.field public final mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

.field public final renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

.field public final textScale:F


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;Lorg/mapsforge/map/model/DisplayModel;FZZ)V
    .registers 8

    invoke-direct {p0, p1, p6}, Lorg/mapsforge/map/layer/queue/Job;-><init>(Lorg/mapsforge/core/model/Tile;Z)V

    if-eqz p2, :cond_38

    const/4 p1, 0x0

    cmpg-float p1, p5, p1

    if-lez p1, :cond_21

    invoke-static {p5}, Ljava/lang/Float;->isNaN(F)Z

    move-result p1

    if-nez p1, :cond_21

    iput-boolean p7, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->labelsOnly:Z

    iput-object p4, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iput-object p2, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    iput-object p3, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    iput p5, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->textScale:F

    invoke-direct {p0}, Lorg/mapsforge/map/layer/renderer/RendererJob;->calculateHashCode()I

    move-result p1

    iput p1, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->hashCodeValue:I

    return-void

    :cond_21
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "invalid textScale: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, p5}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_38
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "mapFile must not be null"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private calculateHashCode()I
    .registers 3

    invoke-super {p0}, Lorg/mapsforge/map/layer/queue/Job;->hashCode()I

    move-result v0

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget v1, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->textScale:F

    invoke-static {v1}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    if-eqz v1, :cond_21

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    :cond_21
    return v0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    invoke-super {p0, p1}, Lorg/mapsforge/map/layer/queue/Job;->equals(Ljava/lang/Object;)Z

    move-result v1

    const/4 v2, 0x0

    if-nez v1, :cond_c

    return v2

    :cond_c
    instance-of v1, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;

    if-nez v1, :cond_11

    return v2

    :cond_11
    check-cast p1, Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    iget-object v3, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    invoke-virtual {v1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1e

    return v2

    :cond_1e
    iget v1, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->textScale:F

    invoke-static {v1}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v1

    iget v3, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->textScale:F

    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    if-eq v1, v3, :cond_2d

    return v2

    :cond_2d
    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    if-nez v1, :cond_36

    iget-object v3, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    if-eqz v3, :cond_36

    return v2

    :cond_36
    if-eqz v1, :cond_41

    iget-object v3, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    invoke-virtual {v1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_41

    return v2

    :cond_41
    iget-boolean v1, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->labelsOnly:Z

    iget-boolean v3, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->labelsOnly:Z

    if-eq v1, v3, :cond_48

    return v2

    :cond_48
    iget-object v1, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget-object p1, p1, Lorg/mapsforge/map/layer/renderer/RendererJob;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1, p1}, Lorg/mapsforge/map/model/DisplayModel;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_53

    return v2

    :cond_53
    return v0
.end method

.method public hashCode()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->hashCodeValue:I

    return v0
.end method

.method public otherTile(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/renderer/RendererJob;
    .registers 11

    new-instance v8, Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v2, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->mapDataStore:Lorg/mapsforge/map/datastore/MapDataStore;

    iget-object v3, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->renderThemeFuture:Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;

    iget-object v4, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iget v5, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->textScale:F

    iget-boolean v6, p0, Lorg/mapsforge/map/layer/queue/Job;->hasAlpha:Z

    iget-boolean v7, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->labelsOnly:Z

    move-object v0, v8

    move-object v1, p1

    invoke-direct/range {v0 .. v7}, Lorg/mapsforge/map/layer/renderer/RendererJob;-><init>(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/datastore/MapDataStore;Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;Lorg/mapsforge/map/model/DisplayModel;FZZ)V

    return-object v8
.end method

.method public setRetrieveLabelsOnly()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/layer/renderer/RendererJob;->labelsOnly:Z

    return-void
.end method
