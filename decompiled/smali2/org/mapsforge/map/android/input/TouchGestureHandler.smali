.class public Lorg/mapsforge/map/android/input/TouchGestureHandler;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "SourceFile"

# interfaces
.implements Landroid/view/ScaleGestureDetector$OnScaleGestureListener;
.implements Ljava/lang/Runnable;


# instance fields
.field private doubleTapEnabled:Z

.field private flingLastX:I

.field private flingLastY:I

.field private final flinger:Landroid/widget/Scroller;

.field private focusX:F

.field private focusY:F

.field private final handler:Landroid/os/Handler;

.field private isInDoubleTap:Z

.field private isInScale:Z

.field private final mapView:Lorg/mapsforge/map/android/view/MapView;

.field private pivot:Lorg/mapsforge/core/model/LatLong;

.field private scaleEnabled:Z

.field private scaleFactorCumulative:F


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/android/view/MapView;)V
    .registers 4

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->doubleTapEnabled:Z

    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    iput-object v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->handler:Landroid/os/Handler;

    iput-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->scaleEnabled:Z

    iput-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    new-instance v0, Landroid/widget/Scroller;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object p1

    invoke-direct {v0, p1}, Landroid/widget/Scroller;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flinger:Landroid/widget/Scroller;

    return-void
.end method


# virtual methods
.method public destroy()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->handler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    return-void
.end method

.method public isDoubleTapEnabled()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->doubleTapEnabled:Z

    return v0
.end method

.method public isScaleEnabled()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->scaleEnabled:Z

    return v0
.end method

.method public onDoubleTapEvent(Landroid/view/MotionEvent;)Z
    .registers 16

    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->scaleEnabled:Z

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return v1

    :cond_6
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    const/4 v2, 0x1

    if-eqz v0, :cond_82

    if-eq v0, v2, :cond_10

    goto :goto_84

    :cond_10
    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->isInDoubleTap:Z

    if-eqz v0, :cond_84

    iget-object v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v0

    iget-object v3, v0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->doubleTapEnabled:Z

    if-eqz v0, :cond_7f

    invoke-interface {v3}, Lorg/mapsforge/map/model/IMapViewPosition;->getZoomLevel()B

    move-result v0

    invoke-interface {v3}, Lorg/mapsforge/map/model/IMapViewPosition;->getZoomLevelMax()B

    move-result v4

    if-ge v0, v4, :cond_7f

    iget-object v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/MapViewDimension;->getDimension()Lorg/mapsforge/core/model/Dimension;

    move-result-object v0

    invoke-virtual {v0}, Lorg/mapsforge/core/model/Dimension;->getCenter()Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iget-wide v4, v0, Lorg/mapsforge/core/model/Point;->x:D

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v6

    float-to-double v6, v6

    sub-double/2addr v4, v6

    int-to-double v6, v2

    const-wide/high16 v8, 0x4000000000000000L    # 2.0

    invoke-static {v8, v9, v6, v7}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v10

    div-double/2addr v4, v10

    iget-wide v10, v0, Lorg/mapsforge/core/model/Point;->y:D

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    float-to-double v12, v0

    sub-double/2addr v10, v12

    invoke-static {v8, v9, v6, v7}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v6

    div-double v6, v10, v6

    iget-object v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getMapViewProjection()Lorg/mapsforge/map/util/MapViewProjection;

    move-result-object v0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v8

    float-to-double v8, v8

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result p1

    float-to-double v10, p1

    invoke-virtual {v0, v8, v9, v10, v11}, Lorg/mapsforge/map/util/MapViewProjection;->fromPixels(DD)Lorg/mapsforge/core/model/LatLong;

    move-result-object p1

    if-eqz p1, :cond_7f

    iget-object v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->onMoveEvent()V

    iget-object v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->onZoomEvent()V

    invoke-interface {v3, p1}, Lorg/mapsforge/map/model/IMapViewPosition;->setPivot(Lorg/mapsforge/core/model/LatLong;)V

    const/4 v8, 0x1

    invoke-interface/range {v3 .. v8}, Lorg/mapsforge/map/model/IMapViewPosition;->moveCenterAndZoom(DDB)V

    :cond_7f
    iput-boolean v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->isInDoubleTap:Z

    return v2

    :cond_82
    iput-boolean v2, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->isInDoubleTap:Z

    :cond_84
    :goto_84
    return v1
.end method

.method public onDown(Landroid/view/MotionEvent;)Z
    .registers 3

    const/4 p1, 0x0

    iput-boolean p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->isInScale:Z

    iget-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flinger:Landroid/widget/Scroller;

    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/widget/Scroller;->forceFinished(Z)V

    return v0
.end method

.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .registers 16

    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->isInScale:Z

    const/4 v1, 0x0

    if-nez v0, :cond_37

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result p1

    const/4 v0, 0x1

    if-ne p1, v0, :cond_37

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result p1

    if-ne p1, v0, :cond_37

    iget-object v2, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flinger:Landroid/widget/Scroller;

    const/4 v3, 0x0

    const/4 v4, 0x0

    neg-float p1, p3

    float-to-int v5, p1

    neg-float p1, p4

    float-to-int v6, p1

    const/high16 v7, -0x80000000

    const v8, 0x7fffffff

    const/high16 v9, -0x80000000

    const v10, 0x7fffffff

    invoke-virtual/range {v2 .. v10}, Landroid/widget/Scroller;->fling(IIIIIIII)V

    iput v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flingLastY:I

    iput v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flingLastX:I

    iget-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->handler:Landroid/os/Handler;

    const/4 p2, 0x0

    invoke-virtual {p1, p2}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    iget-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->handler:Landroid/os/Handler;

    invoke-virtual {p1, p0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return v0

    :cond_37
    return v1
.end method

.method public onLongPress(Landroid/view/MotionEvent;)V
    .registers 7

    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->isInScale:Z

    if-nez v0, :cond_5f

    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->isInDoubleTap:Z

    if-nez v0, :cond_5f

    new-instance v0, Lorg/mapsforge/core/model/Point;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    float-to-double v1, v1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result p1

    float-to-double v3, p1

    invoke-direct {v0, v1, v2, v3, v4}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    iget-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p1}, Lorg/mapsforge/map/android/view/MapView;->getMapViewProjection()Lorg/mapsforge/map/util/MapViewProjection;

    move-result-object p1

    iget-wide v1, v0, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v3, v0, Lorg/mapsforge/core/model/Point;->y:D

    invoke-virtual {p1, v1, v2, v3, v4}, Lorg/mapsforge/map/util/MapViewProjection;->fromPixels(DD)Lorg/mapsforge/core/model/LatLong;

    move-result-object p1

    if-eqz p1, :cond_5f

    iget-object v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v1}, Lorg/mapsforge/map/android/view/MapView;->getLayerManager()Lorg/mapsforge/map/layer/LayerManager;

    move-result-object v1

    invoke-virtual {v1}, Lorg/mapsforge/map/layer/LayerManager;->getLayers()Lorg/mapsforge/map/layer/Layers;

    move-result-object v1

    invoke-virtual {v1}, Lorg/mapsforge/map/layer/Layers;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    :goto_37
    if-ltz v1, :cond_5f

    iget-object v2, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v2}, Lorg/mapsforge/map/android/view/MapView;->getLayerManager()Lorg/mapsforge/map/layer/LayerManager;

    move-result-object v2

    invoke-virtual {v2}, Lorg/mapsforge/map/layer/LayerManager;->getLayers()Lorg/mapsforge/map/layer/Layers;

    move-result-object v2

    invoke-virtual {v2, v1}, Lorg/mapsforge/map/layer/Layers;->get(I)Lorg/mapsforge/map/layer/Layer;

    move-result-object v2

    iget-object v3, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v3}, Lorg/mapsforge/map/android/view/MapView;->getMapViewProjection()Lorg/mapsforge/map/util/MapViewProjection;

    move-result-object v3

    invoke-virtual {v2}, Lorg/mapsforge/map/layer/Layer;->getPosition()Lorg/mapsforge/core/model/LatLong;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/mapsforge/map/util/MapViewProjection;->toPixels(Lorg/mapsforge/core/model/LatLong;)Lorg/mapsforge/core/model/Point;

    move-result-object v3

    invoke-virtual {v2, p1, v3, v0}, Lorg/mapsforge/map/layer/Layer;->onLongPress(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)Z

    move-result v2

    if-eqz v2, :cond_5c

    goto :goto_5f

    :cond_5c
    add-int/lit8 v1, v1, -0x1

    goto :goto_37

    :cond_5f
    :goto_5f
    return-void
.end method

.method public onScale(Landroid/view/ScaleGestureDetector;)Z
    .registers 4

    iget v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->scaleFactorCumulative:F

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getScaleFactor()F

    move-result p1

    mul-float v0, v0, p1

    iput v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->scaleFactorCumulative:F

    iget-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p1}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object p1

    iget-object p1, p1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    iget-object v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->pivot:Lorg/mapsforge/core/model/LatLong;

    invoke-interface {p1, v0}, Lorg/mapsforge/map/model/IMapViewPosition;->setPivot(Lorg/mapsforge/core/model/LatLong;)V

    iget-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p1}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object p1

    iget-object p1, p1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    iget v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->scaleFactorCumulative:F

    float-to-double v0, v0

    invoke-interface {p1, v0, v1}, Lorg/mapsforge/map/model/IMapViewPosition;->setScaleFactorAdjustment(D)V

    const/4 p1, 0x1

    return p1
.end method

.method public onScaleBegin(Landroid/view/ScaleGestureDetector;)Z
    .registers 7

    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->scaleEnabled:Z

    if-nez v0, :cond_6

    const/4 p1, 0x0

    return p1

    :cond_6
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->isInScale:Z

    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->scaleFactorCumulative:F

    iget-boolean v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->isInDoubleTap:Z

    if-eqz v1, :cond_18

    iget-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p1}, Lorg/mapsforge/map/android/view/MapView;->onZoomEvent()V

    const/4 p1, 0x0

    goto :goto_3e

    :cond_18
    iget-object v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v1}, Lorg/mapsforge/map/android/view/MapView;->onMoveEvent()V

    iget-object v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v1}, Lorg/mapsforge/map/android/view/MapView;->onZoomEvent()V

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusX()F

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->focusX:F

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusY()F

    move-result p1

    iput p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->focusY:F

    iget-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p1}, Lorg/mapsforge/map/android/view/MapView;->getMapViewProjection()Lorg/mapsforge/map/util/MapViewProjection;

    move-result-object p1

    iget v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->focusX:F

    float-to-double v1, v1

    iget v3, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->focusY:F

    float-to-double v3, v3

    invoke-virtual {p1, v1, v2, v3, v4}, Lorg/mapsforge/map/util/MapViewProjection;->fromPixels(DD)Lorg/mapsforge/core/model/LatLong;

    move-result-object p1

    :goto_3e
    iput-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->pivot:Lorg/mapsforge/core/model/LatLong;

    return v0
.end method

.method public onScaleEnd(Landroid/view/ScaleGestureDetector;)V
    .registers 20

    move-object/from16 v0, p0

    iget v1, v0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->scaleFactorCumulative:F

    float-to-double v1, v1

    invoke-static {v1, v2}, Ljava/lang/Math;->log(D)D

    move-result-wide v1

    const-wide/high16 v3, 0x4000000000000000L    # 2.0

    invoke-static {v3, v4}, Ljava/lang/Math;->log(D)D

    move-result-wide v5

    div-double/2addr v1, v5

    invoke-static {v1, v2}, Ljava/lang/Math;->abs(D)D

    move-result-wide v5

    const-wide/16 v7, 0x0

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    cmpl-double v11, v5, v9

    if-lez v11, :cond_29

    cmpg-double v5, v1, v7

    if-gez v5, :cond_25

    invoke-static {v1, v2}, Ljava/lang/Math;->floor(D)D

    move-result-wide v1

    goto :goto_29

    :cond_25
    invoke-static {v1, v2}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v1

    :cond_29
    :goto_29
    invoke-static {v1, v2}, Ljava/lang/Math;->round(D)J

    move-result-wide v1

    long-to-int v2, v1

    int-to-byte v1, v2

    move v14, v1

    iget-object v1, v0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v1}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v1

    iget-object v9, v1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    if-eqz v14, :cond_bd

    iget-object v1, v0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->pivot:Lorg/mapsforge/core/model/LatLong;

    if-eqz v1, :cond_bd

    iget-object v1, v0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v1}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v1

    iget-object v1, v1, Lorg/mapsforge/map/model/Model;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/MapViewDimension;->getDimension()Lorg/mapsforge/core/model/Dimension;

    move-result-object v1

    invoke-virtual {v1}, Lorg/mapsforge/core/model/Dimension;->getCenter()Lorg/mapsforge/core/model/Point;

    move-result-object v1

    if-lez v14, :cond_80

    const/4 v2, 0x1

    move-wide v5, v7

    :goto_52
    if-gt v2, v14, :cond_b2

    invoke-interface {v9}, Lorg/mapsforge/map/model/IMapViewPosition;->getZoomLevel()B

    move-result v10

    add-int/2addr v10, v2

    invoke-interface {v9}, Lorg/mapsforge/map/model/IMapViewPosition;->getZoomLevelMax()B

    move-result v11

    if-le v10, v11, :cond_60

    goto :goto_b2

    :cond_60
    iget-wide v10, v1, Lorg/mapsforge/core/model/Point;->x:D

    iget v12, v0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->focusX:F

    float-to-double v12, v12

    sub-double/2addr v10, v12

    int-to-double v12, v2

    invoke-static {v3, v4, v12, v13}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v15

    div-double/2addr v10, v15

    add-double/2addr v7, v10

    iget-wide v10, v1, Lorg/mapsforge/core/model/Point;->y:D

    iget v15, v0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->focusY:F

    move-wide/from16 v16, v7

    float-to-double v7, v15

    sub-double/2addr v10, v7

    invoke-static {v3, v4, v12, v13}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v7

    div-double/2addr v10, v7

    add-double/2addr v5, v10

    add-int/lit8 v2, v2, 0x1

    move-wide/from16 v7, v16

    goto :goto_52

    :cond_80
    const/4 v2, -0x1

    move-wide v5, v7

    :goto_82
    if-lt v2, v14, :cond_b2

    invoke-interface {v9}, Lorg/mapsforge/map/model/IMapViewPosition;->getZoomLevel()B

    move-result v10

    add-int/2addr v10, v2

    invoke-interface {v9}, Lorg/mapsforge/map/model/IMapViewPosition;->getZoomLevelMin()B

    move-result v11

    if-ge v10, v11, :cond_90

    goto :goto_b2

    :cond_90
    iget-wide v10, v1, Lorg/mapsforge/core/model/Point;->x:D

    iget v12, v0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->focusX:F

    float-to-double v12, v12

    sub-double/2addr v10, v12

    add-int/lit8 v12, v2, 0x1

    int-to-double v12, v12

    invoke-static {v3, v4, v12, v13}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v15

    div-double/2addr v10, v15

    sub-double/2addr v7, v10

    iget-wide v10, v1, Lorg/mapsforge/core/model/Point;->y:D

    iget v15, v0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->focusY:F

    move-wide/from16 v16, v7

    float-to-double v7, v15

    sub-double/2addr v10, v7

    invoke-static {v3, v4, v12, v13}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v7

    div-double/2addr v10, v7

    sub-double/2addr v5, v10

    add-int/lit8 v2, v2, -0x1

    move-wide/from16 v7, v16

    goto :goto_82

    :cond_b2
    :goto_b2
    move-wide v12, v5

    move-wide v10, v7

    iget-object v1, v0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->pivot:Lorg/mapsforge/core/model/LatLong;

    invoke-interface {v9, v1}, Lorg/mapsforge/map/model/IMapViewPosition;->setPivot(Lorg/mapsforge/core/model/LatLong;)V

    invoke-interface/range {v9 .. v14}, Lorg/mapsforge/map/model/IMapViewPosition;->moveCenterAndZoom(DDB)V

    goto :goto_c0

    :cond_bd
    invoke-interface {v9, v14}, Lorg/mapsforge/map/model/IMapViewPosition;->zoom(B)V

    :goto_c0
    const/4 v1, 0x0

    iput-boolean v1, v0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->isInDoubleTap:Z

    return-void
.end method

.method public onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .registers 13

    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->isInScale:Z

    if-nez v0, :cond_60

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_60

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v0

    if-ne v0, v1, :cond_60

    iget-object v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getLayerManager()Lorg/mapsforge/map/layer/LayerManager;

    move-result-object v0

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/LayerManager;->getLayers()Lorg/mapsforge/map/layer/Layers;

    move-result-object v0

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/Layers;->size()I

    move-result v0

    sub-int/2addr v0, v1

    :goto_20
    if-ltz v0, :cond_4a

    iget-object v2, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v2}, Lorg/mapsforge/map/android/view/MapView;->getLayerManager()Lorg/mapsforge/map/layer/LayerManager;

    move-result-object v2

    invoke-virtual {v2}, Lorg/mapsforge/map/layer/LayerManager;->getLayers()Lorg/mapsforge/map/layer/Layers;

    move-result-object v2

    invoke-virtual {v2, v0}, Lorg/mapsforge/map/layer/Layers;->get(I)Lorg/mapsforge/map/layer/Layer;

    move-result-object v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v6

    invoke-virtual {v2, v3, v4, v5, v6}, Lorg/mapsforge/map/layer/Layer;->onScroll(FFFF)Z

    move-result v2

    if-eqz v2, :cond_47

    return v1

    :cond_47
    add-int/lit8 v0, v0, -0x1

    goto :goto_20

    :cond_4a
    iget-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p1}, Lorg/mapsforge/map/android/view/MapView;->onMoveEvent()V

    iget-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p1}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object p1

    iget-object v2, p1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    neg-float p1, p3

    float-to-double v3, p1

    neg-float p1, p4

    float-to-double v5, p1

    const/4 v7, 0x0

    invoke-interface/range {v2 .. v7}, Lorg/mapsforge/map/model/IMapViewPosition;->moveCenter(DDZ)V

    return v1

    :cond_60
    const/4 p1, 0x0

    return p1
.end method

.method public onSingleTapConfirmed(Landroid/view/MotionEvent;)Z
    .registers 8

    new-instance v0, Lorg/mapsforge/core/model/Point;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    float-to-double v1, v1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result p1

    float-to-double v3, p1

    invoke-direct {v0, v1, v2, v3, v4}, Lorg/mapsforge/core/model/Point;-><init>(DD)V

    iget-object p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p1}, Lorg/mapsforge/map/android/view/MapView;->getMapViewProjection()Lorg/mapsforge/map/util/MapViewProjection;

    move-result-object p1

    iget-wide v1, v0, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v3, v0, Lorg/mapsforge/core/model/Point;->y:D

    invoke-virtual {p1, v1, v2, v3, v4}, Lorg/mapsforge/map/util/MapViewProjection;->fromPixels(DD)Lorg/mapsforge/core/model/LatLong;

    move-result-object p1

    if-eqz p1, :cond_57

    iget-object v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v1}, Lorg/mapsforge/map/android/view/MapView;->getLayerManager()Lorg/mapsforge/map/layer/LayerManager;

    move-result-object v1

    invoke-virtual {v1}, Lorg/mapsforge/map/layer/LayerManager;->getLayers()Lorg/mapsforge/map/layer/Layers;

    move-result-object v1

    invoke-virtual {v1}, Lorg/mapsforge/map/layer/Layers;->size()I

    move-result v1

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    :goto_2f
    if-ltz v1, :cond_57

    iget-object v3, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v3}, Lorg/mapsforge/map/android/view/MapView;->getLayerManager()Lorg/mapsforge/map/layer/LayerManager;

    move-result-object v3

    invoke-virtual {v3}, Lorg/mapsforge/map/layer/LayerManager;->getLayers()Lorg/mapsforge/map/layer/Layers;

    move-result-object v3

    invoke-virtual {v3, v1}, Lorg/mapsforge/map/layer/Layers;->get(I)Lorg/mapsforge/map/layer/Layer;

    move-result-object v3

    iget-object v4, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v4}, Lorg/mapsforge/map/android/view/MapView;->getMapViewProjection()Lorg/mapsforge/map/util/MapViewProjection;

    move-result-object v4

    invoke-virtual {v3}, Lorg/mapsforge/map/layer/Layer;->getPosition()Lorg/mapsforge/core/model/LatLong;

    move-result-object v5

    invoke-virtual {v4, v5}, Lorg/mapsforge/map/util/MapViewProjection;->toPixels(Lorg/mapsforge/core/model/LatLong;)Lorg/mapsforge/core/model/Point;

    move-result-object v4

    invoke-virtual {v3, p1, v4, v0}, Lorg/mapsforge/map/layer/Layer;->onTap(Lorg/mapsforge/core/model/LatLong;Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/model/Point;)Z

    move-result v3

    if-eqz v3, :cond_54

    return v2

    :cond_54
    add-int/lit8 v1, v1, -0x1

    goto :goto_2f

    :cond_57
    const/4 p1, 0x0

    return p1
.end method

.method public run()V
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flinger:Landroid/widget/Scroller;

    invoke-virtual {v0}, Landroid/widget/Scroller;->isFinished()Z

    move-result v0

    if-nez v0, :cond_12

    iget-object v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flinger:Landroid/widget/Scroller;

    invoke-virtual {v0}, Landroid/widget/Scroller;->computeScrollOffset()Z

    move-result v0

    if-eqz v0, :cond_12

    const/4 v0, 0x1

    goto :goto_13

    :cond_12
    const/4 v0, 0x0

    :goto_13
    iget-object v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v1}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v1

    iget-object v1, v1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    iget v2, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flingLastX:I

    iget-object v3, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flinger:Landroid/widget/Scroller;

    invoke-virtual {v3}, Landroid/widget/Scroller;->getCurrX()I

    move-result v3

    sub-int/2addr v2, v3

    int-to-double v2, v2

    iget v4, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flingLastY:I

    iget-object v5, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flinger:Landroid/widget/Scroller;

    invoke-virtual {v5}, Landroid/widget/Scroller;->getCurrY()I

    move-result v5

    sub-int/2addr v4, v5

    int-to-double v4, v4

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/mapsforge/map/model/IMapViewPosition;->moveCenter(DD)V

    iget-object v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flinger:Landroid/widget/Scroller;

    invoke-virtual {v1}, Landroid/widget/Scroller;->getCurrX()I

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flingLastX:I

    iget-object v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flinger:Landroid/widget/Scroller;

    invoke-virtual {v1}, Landroid/widget/Scroller;->getCurrY()I

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->flingLastY:I

    if-eqz v0, :cond_49

    iget-object v0, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->handler:Landroid/os/Handler;

    invoke-virtual {v0, p0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    :cond_49
    return-void
.end method

.method public setDoubleTapEnabled(Z)V
    .registers 2

    iput-boolean p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->doubleTapEnabled:Z

    return-void
.end method

.method public setScaleEnabled(Z)V
    .registers 2

    iput-boolean p1, p0, Lorg/mapsforge/map/android/input/TouchGestureHandler;->scaleEnabled:Z

    return-void
.end method
