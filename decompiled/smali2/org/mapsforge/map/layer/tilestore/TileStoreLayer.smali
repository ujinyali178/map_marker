.class public Lorg/mapsforge/map/layer/tilestore/TileStoreLayer;
.super Lorg/mapsforge/map/layer/TileLayer;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/mapsforge/map/layer/TileLayer<",
        "Lorg/mapsforge/map/layer/queue/Job;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/core/graphics/GraphicFactory;Z)V
    .registers 11

    invoke-interface {p3}, Lorg/mapsforge/core/graphics/GraphicFactory;->createMatrix()Lorg/mapsforge/core/graphics/Matrix;

    move-result-object v3

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v4, p4

    invoke-direct/range {v0 .. v5}, Lorg/mapsforge/map/layer/TileLayer;-><init>(Lorg/mapsforge/map/layer/cache/TileCache;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/core/graphics/Matrix;ZZ)V

    return-void
.end method


# virtual methods
.method protected createJob(Lorg/mapsforge/core/model/Tile;)Lorg/mapsforge/map/layer/queue/Job;
    .registers 4

    new-instance v0, Lorg/mapsforge/map/layer/queue/Job;

    iget-boolean v1, p0, Lorg/mapsforge/map/layer/TileLayer;->isTransparent:Z

    invoke-direct {v0, p1, v1}, Lorg/mapsforge/map/layer/queue/Job;-><init>(Lorg/mapsforge/core/model/Tile;Z)V

    return-object v0
.end method

.method protected isTileStale(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/graphics/TileBitmap;)Z
    .registers 3

    const/4 p1, 0x0

    return p1
.end method
