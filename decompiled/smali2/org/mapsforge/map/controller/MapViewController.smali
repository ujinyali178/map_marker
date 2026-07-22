.class public final Lorg/mapsforge/map/controller/MapViewController;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/model/common/Observer;


# instance fields
.field private final mapView:Lorg/mapsforge/map/view/MapView;


# direct methods
.method private constructor <init>(Lorg/mapsforge/map/view/MapView;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/controller/MapViewController;->mapView:Lorg/mapsforge/map/view/MapView;

    return-void
.end method

.method public static create(Lorg/mapsforge/map/view/MapView;Lorg/mapsforge/map/model/Model;)Lorg/mapsforge/map/controller/MapViewController;
    .registers 3

    new-instance v0, Lorg/mapsforge/map/controller/MapViewController;

    invoke-direct {v0, p0}, Lorg/mapsforge/map/controller/MapViewController;-><init>(Lorg/mapsforge/map/view/MapView;)V

    iget-object p0, p1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {p0, v0}, Lorg/mapsforge/map/model/IMapViewPosition;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-object v0
.end method


# virtual methods
.method public onChange()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/controller/MapViewController;->mapView:Lorg/mapsforge/map/view/MapView;

    invoke-interface {v0}, Lorg/mapsforge/map/view/MapView;->repaint()V

    return-void
.end method
