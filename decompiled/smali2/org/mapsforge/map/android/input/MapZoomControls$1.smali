.class Lorg/mapsforge/map/android/input/MapZoomControls$1;
.super Landroid/os/Handler;
.source "SourceFile"


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


# direct methods
.method constructor <init>(Lorg/mapsforge/map/android/input/MapZoomControls;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls$1;->this$0:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 2

    iget-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls$1;->this$0:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-virtual {p1}, Lorg/mapsforge/map/android/input/MapZoomControls;->hide()V

    return-void
.end method
