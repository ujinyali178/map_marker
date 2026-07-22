.class Lorg/mapsforge/map/android/input/MapZoomControls$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/mapsforge/map/android/input/MapZoomControls;-><init>(Landroid/content/Context;Lorg/mapsforge/map/android/view/MapView;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/mapsforge/map/android/input/MapZoomControls;

.field final synthetic val$mapView:Lorg/mapsforge/map/android/view/MapView;


# direct methods
.method constructor <init>(Lorg/mapsforge/map/android/input/MapZoomControls;Lorg/mapsforge/map/android/view/MapView;)V
    .registers 3

    iput-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls$2;->this$0:Lorg/mapsforge/map/android/input/MapZoomControls;

    iput-object p2, p0, Lorg/mapsforge/map/android/input/MapZoomControls$2;->val$mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .registers 2

    iget-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls$2;->val$mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p1}, Lorg/mapsforge/map/android/view/MapView;->onZoomEvent()V

    iget-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls$2;->this$0:Lorg/mapsforge/map/android/input/MapZoomControls;

    # getter for: Lorg/mapsforge/map/android/input/MapZoomControls;->mapView:Lorg/mapsforge/map/android/view/MapView;
    invoke-static {p1}, Lorg/mapsforge/map/android/input/MapZoomControls;->access$000(Lorg/mapsforge/map/android/input/MapZoomControls;)Lorg/mapsforge/map/android/view/MapView;

    move-result-object p1

    invoke-virtual {p1}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object p1

    iget-object p1, p1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {p1}, Lorg/mapsforge/map/model/IMapViewPosition;->zoomIn()V

    return-void
.end method
