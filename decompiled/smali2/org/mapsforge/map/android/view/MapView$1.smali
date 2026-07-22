.class Lorg/mapsforge/map/android/view/MapView$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/mapsforge/map/android/view/MapView;->onChange()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/mapsforge/map/android/view/MapView;


# direct methods
.method constructor <init>(Lorg/mapsforge/map/android/view/MapView;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/android/view/MapView$1;->this$0:Lorg/mapsforge/map/android/view/MapView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView$1;->this$0:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Landroid/view/View;->requestLayout()V

    return-void
.end method
