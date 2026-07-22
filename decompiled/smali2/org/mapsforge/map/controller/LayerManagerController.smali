.class public final Lorg/mapsforge/map/controller/LayerManagerController;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/model/common/Observer;


# instance fields
.field private final layerManager:Lorg/mapsforge/map/layer/LayerManager;


# direct methods
.method private constructor <init>(Lorg/mapsforge/map/layer/LayerManager;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/controller/LayerManagerController;->layerManager:Lorg/mapsforge/map/layer/LayerManager;

    return-void
.end method

.method public static create(Lorg/mapsforge/map/layer/LayerManager;Lorg/mapsforge/map/model/Model;)Lorg/mapsforge/map/controller/LayerManagerController;
    .registers 3

    new-instance v0, Lorg/mapsforge/map/controller/LayerManagerController;

    invoke-direct {v0, p0}, Lorg/mapsforge/map/controller/LayerManagerController;-><init>(Lorg/mapsforge/map/layer/LayerManager;)V

    iget-object p0, p1, Lorg/mapsforge/map/model/Model;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/model/common/Observable;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    iget-object p0, p1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {p0, v0}, Lorg/mapsforge/map/model/IMapViewPosition;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-object v0
.end method


# virtual methods
.method public onChange()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/controller/LayerManagerController;->layerManager:Lorg/mapsforge/map/layer/LayerManager;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/LayerManager;->redrawLayers()V

    return-void
.end method
