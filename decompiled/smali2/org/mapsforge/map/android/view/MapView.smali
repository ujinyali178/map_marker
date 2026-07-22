.class public Lorg/mapsforge/map/android/view/MapView;
.super Landroid/view/ViewGroup;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/view/MapView;
.implements Lorg/mapsforge/map/model/common/Observer;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/android/view/MapView$LayoutParams;
    }
.end annotation


# static fields
.field private static final GRAPHIC_FACTORY:Lorg/mapsforge/core/graphics/GraphicFactory;


# instance fields
.field private final fpsCounter:Lorg/mapsforge/map/view/FpsCounter;

.field private final frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

.field private final frameBufferController:Lorg/mapsforge/map/controller/FrameBufferController;

.field private final gestureDetector:Landroid/view/GestureDetector;

.field private gestureDetectorExternal:Landroid/view/GestureDetector;

.field private final inputListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/map/view/InputListener;",
            ">;"
        }
    .end annotation
.end field

.field private final layerManager:Lorg/mapsforge/map/layer/LayerManager;

.field private final layoutHandler:Landroid/os/Handler;

.field private mapScaleBar:Lorg/mapsforge/map/scalebar/MapScaleBar;

.field private final mapViewProjection:Lorg/mapsforge/map/util/MapViewProjection;

.field private final mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

.field private final model:Lorg/mapsforge/map/model/Model;

.field private final scaleGestureDetector:Landroid/view/ScaleGestureDetector;

.field private final touchGestureHandler:Lorg/mapsforge/map/android/input/TouchGestureHandler;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    sput-object v0, Lorg/mapsforge/map/android/view/MapView;->GRAPHIC_FACTORY:Lorg/mapsforge/core/graphics/GraphicFactory;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lorg/mapsforge/map/android/view/MapView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 7

    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    new-instance p2, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {p2}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/android/view/MapView;->inputListeners:Ljava/util/List;

    new-instance p2, Landroid/os/Handler;

    invoke-direct {p2}, Landroid/os/Handler;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/android/view/MapView;->layoutHandler:Landroid/os/Handler;

    const/4 p2, 0x1

    invoke-virtual {p0, p2}, Landroid/view/View;->setClickable(Z)V

    const/high16 p2, 0x60000

    invoke-virtual {p0, p2}, Landroid/view/ViewGroup;->setDescendantFocusability(I)V

    const/4 p2, 0x0

    invoke-virtual {p0, p2}, Landroid/view/View;->setWillNotDraw(Z)V

    new-instance p2, Lorg/mapsforge/map/model/Model;

    invoke-direct {p2}, Lorg/mapsforge/map/model/Model;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/android/view/MapView;->model:Lorg/mapsforge/map/model/Model;

    new-instance v0, Lorg/mapsforge/map/view/FpsCounter;

    sget-object v1, Lorg/mapsforge/map/android/view/MapView;->GRAPHIC_FACTORY:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-object v2, p2, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/map/view/FpsCounter;-><init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V

    iput-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->fpsCounter:Lorg/mapsforge/map/view/FpsCounter;

    new-instance v0, Lorg/mapsforge/map/view/FrameBufferHA2;

    iget-object v2, p2, Lorg/mapsforge/map/model/Model;->frameBufferModel:Lorg/mapsforge/map/model/FrameBufferModel;

    iget-object v3, p2, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-direct {v0, v2, v3, v1}, Lorg/mapsforge/map/view/FrameBufferHA2;-><init>(Lorg/mapsforge/map/model/FrameBufferModel;Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/core/graphics/GraphicFactory;)V

    iput-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

    invoke-static {v0, p2}, Lorg/mapsforge/map/controller/FrameBufferController;->create(Lorg/mapsforge/map/view/FrameBuffer;Lorg/mapsforge/map/model/Model;)Lorg/mapsforge/map/controller/FrameBufferController;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->frameBufferController:Lorg/mapsforge/map/controller/FrameBufferController;

    new-instance v0, Lorg/mapsforge/map/layer/LayerManager;

    iget-object v2, p2, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-direct {v0, p0, v2, v1}, Lorg/mapsforge/map/layer/LayerManager;-><init>(Lorg/mapsforge/map/view/MapView;Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/core/graphics/GraphicFactory;)V

    iput-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->layerManager:Lorg/mapsforge/map/layer/LayerManager;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    invoke-static {v0, p2}, Lorg/mapsforge/map/controller/LayerManagerController;->create(Lorg/mapsforge/map/layer/LayerManager;Lorg/mapsforge/map/model/Model;)Lorg/mapsforge/map/controller/LayerManagerController;

    invoke-static {p0, p2}, Lorg/mapsforge/map/controller/MapViewController;->create(Lorg/mapsforge/map/view/MapView;Lorg/mapsforge/map/model/Model;)Lorg/mapsforge/map/controller/MapViewController;

    new-instance v0, Lorg/mapsforge/map/android/input/TouchGestureHandler;

    invoke-direct {v0, p0}, Lorg/mapsforge/map/android/input/TouchGestureHandler;-><init>(Lorg/mapsforge/map/android/view/MapView;)V

    iput-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->touchGestureHandler:Lorg/mapsforge/map/android/input/TouchGestureHandler;

    new-instance v2, Landroid/view/GestureDetector;

    invoke-direct {v2, p1, v0}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v2, p0, Lorg/mapsforge/map/android/view/MapView;->gestureDetector:Landroid/view/GestureDetector;

    new-instance v2, Landroid/view/ScaleGestureDetector;

    invoke-direct {v2, p1, v0}, Landroid/view/ScaleGestureDetector;-><init>(Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V

    iput-object v2, p0, Lorg/mapsforge/map/android/view/MapView;->scaleGestureDetector:Landroid/view/ScaleGestureDetector;

    new-instance v0, Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-direct {v0, p1, p0}, Lorg/mapsforge/map/android/input/MapZoomControls;-><init>(Landroid/content/Context;Lorg/mapsforge/map/android/view/MapView;)V

    iput-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    new-instance p1, Landroid/view/ViewGroup$LayoutParams;

    const/4 v2, -0x2

    invoke-direct {p1, v2, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v0, p1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance p1, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;

    iget-object v0, p2, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    iget-object v2, p2, Lorg/mapsforge/map/model/Model;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    iget-object v3, p2, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-direct {p1, v0, v2, v1, v3}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;-><init>(Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/model/MapViewDimension;Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V

    iput-object p1, p0, Lorg/mapsforge/map/android/view/MapView;->mapScaleBar:Lorg/mapsforge/map/scalebar/MapScaleBar;

    new-instance p1, Lorg/mapsforge/map/util/MapViewProjection;

    invoke-direct {p1, p0}, Lorg/mapsforge/map/util/MapViewProjection;-><init>(Lorg/mapsforge/map/view/MapView;)V

    iput-object p1, p0, Lorg/mapsforge/map/android/view/MapView;->mapViewProjection:Lorg/mapsforge/map/util/MapViewProjection;

    iget-object p1, p2, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {p1, p0}, Lorg/mapsforge/map/model/IMapViewPosition;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-void
.end method


# virtual methods
.method public addInputListener(Lorg/mapsforge/map/view/InputListener;)V
    .registers 5

    if-eqz p1, :cond_27

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->inputListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->inputListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void

    :cond_10
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "listener is already registered: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_27
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "listener must not be null"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public addLayer(Lorg/mapsforge/map/layer/Layer;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->layerManager:Lorg/mapsforge/map/layer/LayerManager;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/LayerManager;->getLayers()Lorg/mapsforge/map/layer/Layers;

    move-result-object v0

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/layer/Layers;->add(Lorg/mapsforge/map/layer/Layer;)V

    return-void
.end method

.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .registers 2

    instance-of p1, p1, Lorg/mapsforge/map/android/view/MapView$LayoutParams;

    return p1
.end method

.method public destroy()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->touchGestureHandler:Lorg/mapsforge/map/android/input/TouchGestureHandler;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/input/TouchGestureHandler;->destroy()V

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->layoutHandler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->layerManager:Lorg/mapsforge/map/layer/LayerManager;

    invoke-virtual {v0}, Lorg/mapsforge/map/util/PausableThread;->finish()V

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->frameBufferController:Lorg/mapsforge/map/controller/FrameBufferController;

    invoke-virtual {v0}, Lorg/mapsforge/map/controller/FrameBufferController;->destroy()V

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

    invoke-virtual {v0}, Lorg/mapsforge/map/view/FrameBuffer;->destroy()V

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->mapScaleBar:Lorg/mapsforge/map/scalebar/MapScaleBar;

    if-eqz v0, :cond_21

    invoke-virtual {v0}, Lorg/mapsforge/map/scalebar/MapScaleBar;->destroy()V

    :cond_21
    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/input/MapZoomControls;->destroy()V

    invoke-virtual {p0}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0}, Lorg/mapsforge/map/model/IMapViewPosition;->destroy()V

    return-void
.end method

.method public destroyAll()V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->layerManager:Lorg/mapsforge/map/layer/LayerManager;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/LayerManager;->getLayers()Lorg/mapsforge/map/layer/Layers;

    move-result-object v0

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/Layers;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_a
    :goto_a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_40

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/layer/Layer;

    iget-object v2, p0, Lorg/mapsforge/map/android/view/MapView;->layerManager:Lorg/mapsforge/map/layer/LayerManager;

    invoke-virtual {v2}, Lorg/mapsforge/map/layer/LayerManager;->getLayers()Lorg/mapsforge/map/layer/Layers;

    move-result-object v2

    invoke-virtual {v2, v1}, Lorg/mapsforge/map/layer/Layers;->remove(Lorg/mapsforge/map/layer/Layer;)Z

    invoke-virtual {v1}, Lorg/mapsforge/map/layer/Layer;->onDestroy()V

    instance-of v2, v1, Lorg/mapsforge/map/layer/TileLayer;

    if-eqz v2, :cond_30

    move-object v2, v1

    check-cast v2, Lorg/mapsforge/map/layer/TileLayer;

    invoke-virtual {v2}, Lorg/mapsforge/map/layer/TileLayer;->getTileCache()Lorg/mapsforge/map/layer/cache/TileCache;

    move-result-object v2

    invoke-interface {v2}, Lorg/mapsforge/map/layer/cache/TileCache;->destroy()V

    :cond_30
    instance-of v2, v1, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;

    if-eqz v2, :cond_a

    check-cast v1, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;

    invoke-virtual {v1}, Lorg/mapsforge/map/layer/renderer/TileRendererLayer;->getLabelStore()Lorg/mapsforge/map/layer/labels/LabelStore;

    move-result-object v1

    if-eqz v1, :cond_a

    invoke-interface {v1}, Lorg/mapsforge/map/layer/labels/LabelStore;->clear()V

    goto :goto_a

    :cond_40
    invoke-virtual {p0}, Lorg/mapsforge/map/android/view/MapView;->destroy()V

    return-void
.end method

.method protected generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .registers 5

    new-instance v0, Lorg/mapsforge/map/android/view/MapView$LayoutParams;

    sget-object v1, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->BOTTOM_CENTER:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    const/4 v2, -0x2

    const/4 v3, 0x0

    invoke-direct {v0, v2, v2, v3, v1}, Lorg/mapsforge/map/android/view/MapView$LayoutParams;-><init>(IILorg/mapsforge/core/model/LatLong;Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;)V

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .registers 4

    new-instance v0, Lorg/mapsforge/map/android/view/MapView$LayoutParams;

    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lorg/mapsforge/map/android/view/MapView$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .registers 3

    new-instance v0, Lorg/mapsforge/map/android/view/MapView$LayoutParams;

    invoke-direct {v0, p1}, Lorg/mapsforge/map/android/view/MapView$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    return-object v0
.end method

.method public getBoundingBox()Lorg/mapsforge/core/model/BoundingBox;
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->model:Lorg/mapsforge/map/model/Model;

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0}, Lorg/mapsforge/map/model/IMapViewPosition;->getMapPosition()Lorg/mapsforge/core/model/MapPosition;

    move-result-object v0

    invoke-virtual {p0}, Lorg/mapsforge/map/android/view/MapView;->getDimension()Lorg/mapsforge/core/model/Dimension;

    move-result-object v1

    iget-object v2, p0, Lorg/mapsforge/map/android/view/MapView;->model:Lorg/mapsforge/map/model/Model;

    iget-object v2, v2, Lorg/mapsforge/map/model/Model;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v2

    invoke-static {v0, v1, v2}, Lorg/mapsforge/map/util/MapPositionUtil;->getBoundingBox(Lorg/mapsforge/core/model/MapPosition;Lorg/mapsforge/core/model/Dimension;I)Lorg/mapsforge/core/model/BoundingBox;

    move-result-object v0

    return-object v0
.end method

.method public getDimension()Lorg/mapsforge/core/model/Dimension;
    .registers 4

    new-instance v0, Lorg/mapsforge/core/model/Dimension;

    invoke-virtual {p0}, Landroid/view/View;->getWidth()I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    move-result v2

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/core/model/Dimension;-><init>(II)V

    return-object v0
.end method

.method public getFpsCounter()Lorg/mapsforge/map/view/FpsCounter;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->fpsCounter:Lorg/mapsforge/map/view/FpsCounter;

    return-object v0
.end method

.method public getFrameBuffer()Lorg/mapsforge/map/view/FrameBuffer;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

    return-object v0
.end method

.method public getLayerManager()Lorg/mapsforge/map/layer/LayerManager;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->layerManager:Lorg/mapsforge/map/layer/LayerManager;

    return-object v0
.end method

.method public getMapScaleBar()Lorg/mapsforge/map/scalebar/MapScaleBar;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->mapScaleBar:Lorg/mapsforge/map/scalebar/MapScaleBar;

    return-object v0
.end method

.method public getMapViewProjection()Lorg/mapsforge/map/util/MapViewProjection;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->mapViewProjection:Lorg/mapsforge/map/util/MapViewProjection;

    return-object v0
.end method

.method public getMapZoomControls()Lorg/mapsforge/map/android/input/MapZoomControls;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    return-object v0
.end method

.method public getModel()Lorg/mapsforge/map/model/Model;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->model:Lorg/mapsforge/map/model/Model;

    return-object v0
.end method

.method public getTouchGestureHandler()Lorg/mapsforge/map/android/input/TouchGestureHandler;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->touchGestureHandler:Lorg/mapsforge/map/android/input/TouchGestureHandler;

    return-object v0
.end method

.method public onChange()V
    .registers 5

    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    const/4 v1, 0x0

    :goto_5
    if-ge v1, v0, :cond_21

    invoke-virtual {p0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    iget-object v3, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1e

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->layoutHandler:Landroid/os/Handler;

    new-instance v1, Lorg/mapsforge/map/android/view/MapView$1;

    invoke-direct {v1, p0}, Lorg/mapsforge/map/android/view/MapView$1;-><init>(Lorg/mapsforge/map/android/view/MapView;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_21

    :cond_1e
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_21
    :goto_21
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .registers 3

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->createGraphicContext(Landroid/graphics/Canvas;)Lorg/mapsforge/core/graphics/Canvas;

    move-result-object p1

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->frameBuffer:Lorg/mapsforge/map/view/FrameBuffer;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/view/FrameBuffer;->draw(Lorg/mapsforge/core/graphics/GraphicContext;)V

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->mapScaleBar:Lorg/mapsforge/map/scalebar/MapScaleBar;

    if-eqz v0, :cond_10

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/scalebar/MapScaleBar;->draw(Lorg/mapsforge/core/graphics/GraphicContext;)V

    :cond_10
    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->fpsCounter:Lorg/mapsforge/map/view/FpsCounter;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/view/FpsCounter;->draw(Lorg/mapsforge/core/graphics/GraphicContext;)V

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->destroy()V

    return-void
.end method

.method protected onLayout(ZIIII)V
    .registers 13

    iget-object p1, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-virtual {p1}, Landroid/view/View;->getVisibility()I

    move-result p1

    const/16 v0, 0x8

    if-eq p1, v0, :cond_45

    iget-object p1, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-virtual {p1}, Lorg/mapsforge/map/android/input/MapZoomControls;->getZoomControlsGravity()I

    move-result p1

    iget-object v1, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    iget-object v2, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v2

    and-int/lit8 v3, p1, 0x7

    const/4 v4, 0x1

    if-eq v3, v4, :cond_27

    const/4 v4, 0x3

    if-eq v3, v4, :cond_2c

    sub-int p2, p4, v1

    goto :goto_2c

    :cond_27
    sub-int/2addr p4, p2

    sub-int/2addr p4, v1

    div-int/lit8 p4, p4, 0x2

    add-int/2addr p2, p4

    :cond_2c
    :goto_2c
    and-int/lit8 p1, p1, 0x70

    const/16 p4, 0x10

    if-eq p1, p4, :cond_39

    const/16 p4, 0x30

    if-eq p1, p4, :cond_3e

    sub-int p3, p5, v2

    goto :goto_3e

    :cond_39
    sub-int/2addr p5, p3

    sub-int/2addr p5, v2

    div-int/lit8 p5, p5, 0x2

    add-int/2addr p3, p5

    :cond_3e
    :goto_3e
    iget-object p1, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    add-int/2addr v1, p2

    add-int/2addr v2, p3

    invoke-virtual {p1, p2, p3, v1, v2}, Landroid/view/View;->layout(IIII)V

    :cond_45
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result p1

    const/4 p2, 0x0

    :goto_4a
    if-ge p2, p1, :cond_c4

    invoke-virtual {p0, p2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object p3

    iget-object p4, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-virtual {p3, p4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p4

    if-eqz p4, :cond_59

    goto :goto_c1

    :cond_59
    invoke-virtual {p3}, Landroid/view/View;->getVisibility()I

    move-result p4

    if-eq p4, v0, :cond_c1

    invoke-virtual {p3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object p4

    invoke-virtual {p0, p4}, Lorg/mapsforge/map/android/view/MapView;->checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z

    move-result p4

    if-eqz p4, :cond_c1

    invoke-virtual {p3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object p4

    check-cast p4, Lorg/mapsforge/map/android/view/MapView$LayoutParams;

    invoke-virtual {p3}, Landroid/view/View;->getMeasuredWidth()I

    move-result p5

    invoke-virtual {p3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v1

    iget-object v2, p0, Lorg/mapsforge/map/android/view/MapView;->mapViewProjection:Lorg/mapsforge/map/util/MapViewProjection;

    iget-object v3, p4, Lorg/mapsforge/map/android/view/MapView$LayoutParams;->latLong:Lorg/mapsforge/core/model/LatLong;

    invoke-virtual {v2, v3}, Lorg/mapsforge/map/util/MapViewProjection;->toPixels(Lorg/mapsforge/core/model/LatLong;)Lorg/mapsforge/core/model/Point;

    move-result-object v2

    if-eqz v2, :cond_c1

    invoke-virtual {p0}, Landroid/view/View;->getPaddingLeft()I

    move-result v3

    iget-wide v4, v2, Lorg/mapsforge/core/model/Point;->x:D

    invoke-static {v4, v5}, Ljava/lang/Math;->round(D)J

    move-result-wide v4

    long-to-int v5, v4

    add-int/2addr v3, v5

    invoke-virtual {p0}, Landroid/view/View;->getPaddingTop()I

    move-result v4

    iget-wide v5, v2, Lorg/mapsforge/core/model/Point;->y:D

    invoke-static {v5, v6}, Ljava/lang/Math;->round(D)J

    move-result-wide v5

    long-to-int v2, v5

    add-int/2addr v4, v2

    sget-object v2, Lorg/mapsforge/map/android/view/MapView$2;->$SwitchMap$org$mapsforge$map$android$view$MapView$LayoutParams$Alignment:[I

    iget-object p4, p4, Lorg/mapsforge/map/android/view/MapView$LayoutParams;->alignment:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    invoke-virtual {p4}, Ljava/lang/Enum;->ordinal()I

    move-result p4

    aget p4, v2, p4

    packed-switch p4, :pswitch_data_c6

    goto :goto_bc

    :pswitch_a7
    sub-int/2addr v3, p5

    goto :goto_ac

    :pswitch_a9
    div-int/lit8 p4, p5, 0x2

    sub-int/2addr v3, p4

    :goto_ac
    :pswitch_ac
    sub-int/2addr v4, v1

    goto :goto_bc

    :pswitch_ae
    sub-int/2addr v3, p5

    goto :goto_b3

    :pswitch_b0
    div-int/lit8 p4, p5, 0x2

    sub-int/2addr v3, p4

    :goto_b3
    :pswitch_b3
    div-int/lit8 p4, v1, 0x2

    sub-int/2addr v4, p4

    goto :goto_bc

    :pswitch_b7
    sub-int/2addr v3, p5

    goto :goto_bc

    :pswitch_b9
    div-int/lit8 p4, p5, 0x2

    sub-int/2addr v3, p4

    :goto_bc
    add-int/2addr p5, v3

    add-int/2addr v1, v4

    invoke-virtual {p3, v3, v4, p5, v1}, Landroid/view/View;->layout(IIII)V

    :cond_c1
    :goto_c1
    add-int/lit8 p2, p2, 0x1

    goto :goto_4a

    :cond_c4
    return-void

    nop

    :pswitch_data_c6
    .packed-switch 0x2
        :pswitch_b9
        :pswitch_b7
        :pswitch_b3
        :pswitch_b0
        :pswitch_ae
        :pswitch_ac
        :pswitch_a9
        :pswitch_a7
    .end packed-switch
.end method

.method protected onMeasure(II)V
    .registers 3

    invoke-virtual {p0, p1, p2}, Landroid/view/ViewGroup;->measureChildren(II)V

    invoke-super {p0, p1, p2}, Landroid/view/ViewGroup;->onMeasure(II)V

    return-void
.end method

.method public onMoveEvent()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->inputListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/view/InputListener;

    invoke-interface {v1}, Lorg/mapsforge/map/view/InputListener;->onMoveEvent()V

    goto :goto_6

    :cond_16
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .registers 5

    iget-object p3, p0, Lorg/mapsforge/map/android/view/MapView;->model:Lorg/mapsforge/map/model/Model;

    iget-object p3, p3, Lorg/mapsforge/map/model/Model;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    new-instance p4, Lorg/mapsforge/core/model/Dimension;

    invoke-direct {p4, p1, p2}, Lorg/mapsforge/core/model/Dimension;-><init>(II)V

    invoke-virtual {p3, p4}, Lorg/mapsforge/map/model/MapViewDimension;->setDimension(Lorg/mapsforge/core/model/Dimension;)V

    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 4

    invoke-virtual {p0}, Landroid/view/View;->isClickable()Z

    move-result v0

    if-nez v0, :cond_8

    const/4 p1, 0x0

    return p1

    :cond_8
    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/android/input/MapZoomControls;->onMapViewTouchEvent(Landroid/view/MotionEvent;)V

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->gestureDetectorExternal:Landroid/view/GestureDetector;

    if-eqz v0, :cond_19

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_19

    const/4 p1, 0x1

    return p1

    :cond_19
    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->scaleGestureDetector:Landroid/view/ScaleGestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/ScaleGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    iget-object v1, p0, Lorg/mapsforge/map/android/view/MapView;->scaleGestureDetector:Landroid/view/ScaleGestureDetector;

    invoke-virtual {v1}, Landroid/view/ScaleGestureDetector;->isInProgress()Z

    move-result v1

    if-nez v1, :cond_2d

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->gestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    :cond_2d
    return v0
.end method

.method public onZoomEvent()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->inputListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/view/InputListener;

    invoke-interface {v1}, Lorg/mapsforge/map/view/InputListener;->onZoomEvent()V

    goto :goto_6

    :cond_16
    return-void
.end method

.method public removeInputListener(Lorg/mapsforge/map/view/InputListener;)V
    .registers 5

    if-eqz p1, :cond_27

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->inputListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->inputListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    return-void

    :cond_10
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "listener is not registered: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_27
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "listener must not be null"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public repaint()V
    .registers 3

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v1

    if-ne v0, v1, :cond_12

    invoke-virtual {p0}, Landroid/view/View;->invalidate()V

    goto :goto_15

    :cond_12
    invoke-virtual {p0}, Landroid/view/View;->postInvalidate()V

    :goto_15
    return-void
.end method

.method public setBuiltInZoomControls(Z)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/android/input/MapZoomControls;->setShowMapZoomControls(Z)V

    return-void
.end method

.method public setCenter(Lorg/mapsforge/core/model/LatLong;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->model:Lorg/mapsforge/map/model/Model;

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/model/IMapViewPosition;->setCenter(Lorg/mapsforge/core/model/LatLong;)V

    return-void
.end method

.method public setGestureDetector(Landroid/view/GestureDetector;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/android/view/MapView;->gestureDetectorExternal:Landroid/view/GestureDetector;

    return-void
.end method

.method public setMapScaleBar(Lorg/mapsforge/map/scalebar/MapScaleBar;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->mapScaleBar:Lorg/mapsforge/map/scalebar/MapScaleBar;

    if-eqz v0, :cond_7

    invoke-virtual {v0}, Lorg/mapsforge/map/scalebar/MapScaleBar;->destroy()V

    :cond_7
    iput-object p1, p0, Lorg/mapsforge/map/android/view/MapView;->mapScaleBar:Lorg/mapsforge/map/scalebar/MapScaleBar;

    return-void
.end method

.method public setZoomLevel(B)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->model:Lorg/mapsforge/map/model/Model;

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/model/IMapViewPosition;->setZoomLevel(B)V

    return-void
.end method

.method public setZoomLevelMax(B)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->model:Lorg/mapsforge/map/model/Model;

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/model/IMapViewPosition;->setZoomLevelMax(B)V

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/android/input/MapZoomControls;->setZoomLevelMax(B)V

    return-void
.end method

.method public setZoomLevelMin(B)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->model:Lorg/mapsforge/map/model/Model;

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0, p1}, Lorg/mapsforge/map/model/IMapViewPosition;->setZoomLevelMin(B)V

    iget-object v0, p0, Lorg/mapsforge/map/android/view/MapView;->mapZoomControls:Lorg/mapsforge/map/android/input/MapZoomControls;

    invoke-virtual {v0, p1}, Lorg/mapsforge/map/android/input/MapZoomControls;->setZoomLevelMin(B)V

    return-void
.end method
