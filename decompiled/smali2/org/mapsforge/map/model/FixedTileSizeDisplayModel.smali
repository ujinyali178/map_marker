.class public Lorg/mapsforge/map/model/FixedTileSizeDisplayModel;
.super Lorg/mapsforge/map/model/DisplayModel;
.source "SourceFile"


# instance fields
.field private final tileSize:I


# direct methods
.method public constructor <init>(I)V
    .registers 2

    invoke-direct {p0}, Lorg/mapsforge/map/model/DisplayModel;-><init>()V

    iput p1, p0, Lorg/mapsforge/map/model/FixedTileSizeDisplayModel;->tileSize:I

    return-void
.end method


# virtual methods
.method public getTileSize()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/model/FixedTileSizeDisplayModel;->tileSize:I

    return v0
.end method
