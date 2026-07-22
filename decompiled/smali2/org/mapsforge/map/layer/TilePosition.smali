.class public Lorg/mapsforge/map/layer/TilePosition;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final point:Lorg/mapsforge/core/model/Point;

.field public final tile:Lorg/mapsforge/core/model/Tile;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/core/model/Point;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/TilePosition;->tile:Lorg/mapsforge/core/model/Tile;

    iput-object p2, p0, Lorg/mapsforge/map/layer/TilePosition;->point:Lorg/mapsforge/core/model/Point;

    return-void
.end method
