.class public Lorg/mapsforge/map/model/Model;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/model/common/Persistable;


# instance fields
.field public final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field public final frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

.field public final mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

.field public final mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;


# direct methods
.method public constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lorg/mapsforge/map/model/DisplayModel;

    invoke-direct {v0}, Lorg/mapsforge/map/model/DisplayModel;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    new-instance v1, Lorg/mapsforge/map/model/FrameBufferModel;

    invoke-direct {v1}, Lorg/mapsforge/map/model/FrameBufferModel;-><init>()V

    iput-object v1, p0, Lorg/mapsforge/map/model/Model;->frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

    new-instance v1, Lorg/mapsforge/map/model/MapViewDimension;

    invoke-direct {v1}, Lorg/mapsforge/map/model/MapViewDimension;-><init>()V

    iput-object v1, p0, Lorg/mapsforge/map/model/Model;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    new-instance v1, Lorg/mapsforge/map/model/MapViewPosition;

    invoke-direct {v1, v0}, Lorg/mapsforge/map/model/MapViewPosition;-><init>(Lorg/mapsforge/map/model/DisplayModel;)V

    iput-object v1, p0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    return-void
.end method


# virtual methods
.method public init(Lorg/mapsforge/map/model/common/PreferencesFacade;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/model/IMapViewPosition;->init(Lorg/mapsforge/map/model/common/PreferencesFacade;)V

    return-void
.end method

.method public save(Lorg/mapsforge/map/model/common/PreferencesFacade;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/model/IMapViewPosition;->save(Lorg/mapsforge/map/model/common/PreferencesFacade;)V

    return-void
.end method
