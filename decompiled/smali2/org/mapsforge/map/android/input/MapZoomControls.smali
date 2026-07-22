.class public Lorg/mapsforge/map/android/input/MapZoomControls;
.super Landroid/widget/LinearLayout;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/model/common/Observer;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/android/input/MapZoomControls$Orientation;
    }
.end annotation


# static fields
.field private static final DEFAULT_HORIZONTAL_MARGIN:I = 0x5

.field private static final DEFAULT_VERTICAL_MARGIN:I = 0x0

.field private static final DEFAULT_ZOOM_CONTROLS_GRAVITY:I = 0x55

.field private static final DEFAULT_ZOOM_LEVEL_MAX:B = 0x16t

.field private static final DEFAULT_ZOOM_LEVEL_MIN:B = 0x0t

.field private static final DEFAULT_ZOOM_SPEED:J = 0x1f4L

.field private static final MSG_ZOOM_CONTROLS_HIDE:I

.field private static final ZOOM_CONTROLS_TIMEOUT:J


# instance fields
.field private autoHide:Z

.field private final buttonZoomIn:Landroid/widget/ZoomButton;

.field private final buttonZoomOut:Landroid/widget/ZoomButton;

.field private final mapView:Lorg/mapsforge/map/android/view/MapView;

.field private showMapZoomControls:Z

.field private zoomControlsGravity:I

.field private final zoomControlsHideHandler:Landroid/os/Handler;

.field private zoomLevelMax:B

.field private zoomLevelMin:B


# direct methods
.method static constructor <clinit>()V
    .registers 2

    invoke-static {}, Landroid/view/ViewConfiguration;->getZoomControlsTimeout()J

    move-result-wide v0

    sput-wide v0, Lorg/mapsforge/map/android/input/MapZoomControls;->ZOOM_CONTROLS_TIMEOUT:J

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lorg/mapsforge/map/android/view/MapView;)V
    .registers 6

    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object p2, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->mapView:Lorg/mapsforge/map/android/view/MapView;

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->autoHide:Z

    const/4 v1, 0x5

    invoke-virtual {p0, v1}, Lorg/mapsforge/map/android/input/MapZoomControls;->setMarginHorizontal(I)V

    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lorg/mapsforge/map/android/input/MapZoomControls;->setMarginVertical(I)V

    iput-boolean v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->showMapZoomControls:Z

    const/16 v2, 0x16

    iput-byte v2, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomLevelMax:B

    iput-byte v1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomLevelMin:B

    const/16 v2, 0x8

    invoke-virtual {p0, v2}, Landroid/view/View;->setVisibility(I)V

    const/16 v2, 0x55

    iput v2, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomControlsGravity:I

    new-instance v2, Lorg/mapsforge/map/android/input/MapZoomControls$1;

    invoke-direct {v2, p0}, Lorg/mapsforge/map/android/input/MapZoomControls$1;-><init>(Lorg/mapsforge/map/android/input/MapZoomControls;)V

    iput-object v2, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomControlsHideHandler:Landroid/os/Handler;

    new-instance v2, Landroid/widget/ZoomControls;

    invoke-direct {v2, p1}, Landroid/widget/ZoomControls;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/ZoomButton;

    iput-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->buttonZoomIn:Landroid/widget/ZoomButton;

    invoke-virtual {v2, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ZoomButton;

    iput-object v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->buttonZoomOut:Landroid/widget/ZoomButton;

    invoke-virtual {v2}, Landroid/view/ViewGroup;->removeAllViews()V

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->getOrientation()I

    move-result v2

    invoke-virtual {p0, v2}, Landroid/widget/LinearLayout;->setOrientation(I)V

    invoke-virtual {p0, v1}, Lorg/mapsforge/map/android/input/MapZoomControls;->setZoomInFirst(Z)V

    const-wide/16 v1, 0x1f4

    invoke-virtual {p0, v1, v2}, Lorg/mapsforge/map/android/input/MapZoomControls;->setZoomSpeed(J)V

    new-instance v1, Lorg/mapsforge/map/android/input/MapZoomControls$2;

    invoke-direct {v1, p0, p2}, Lorg/mapsforge/map/android/input/MapZoomControls$2;-><init>(Lorg/mapsforge/map/android/input/MapZoomControls;Lorg/mapsforge/map/android/view/MapView;)V

    invoke-virtual {p1, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    new-instance p1, Lorg/mapsforge/map/android/input/MapZoomControls$3;

    invoke-direct {p1, p0, p2}, Lorg/mapsforge/map/android/input/MapZoomControls$3;-><init>(Lorg/mapsforge/map/android/input/MapZoomControls;Lorg/mapsforge/map/android/view/MapView;)V

    invoke-virtual {v0, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-virtual {p2}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object p1

    iget-object p1, p1, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {p1, p0}, Lorg/mapsforge/map/model/IMapViewPosition;->addObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-void
.end method

.method static synthetic access$000(Lorg/mapsforge/map/android/input/MapZoomControls;)Lorg/mapsforge/map/android/view/MapView;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->mapView:Lorg/mapsforge/map/android/view/MapView;

    return-object p0
.end method

.method static synthetic access$100(Lorg/mapsforge/map/android/input/MapZoomControls;I)V
    .registers 2

    invoke-direct {p0, p1}, Lorg/mapsforge/map/android/input/MapZoomControls;->changeZoomControls(I)V

    return-void
.end method

.method private changeZoomControls(I)V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->buttonZoomIn:Landroid/widget/ZoomButton;

    iget-byte v1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomLevelMax:B

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-ge p1, v1, :cond_a

    const/4 v1, 0x1

    goto :goto_b

    :cond_a
    const/4 v1, 0x0

    :goto_b
    invoke-virtual {v0, v1}, Landroid/widget/ZoomButton;->setEnabled(Z)V

    iget-object v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->buttonZoomOut:Landroid/widget/ZoomButton;

    iget-byte v1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomLevelMin:B

    if-le p1, v1, :cond_15

    goto :goto_16

    :cond_15
    const/4 v2, 0x0

    :goto_16
    invoke-virtual {v0, v2}, Landroid/widget/ZoomButton;->setEnabled(Z)V

    return-void
.end method

.method private fade(IFF)V
    .registers 5

    new-instance v0, Landroid/view/animation/AlphaAnimation;

    invoke-direct {v0, p2, p3}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    const-wide/16 p2, 0x1f4

    invoke-virtual {v0, p2, p3}, Landroid/view/animation/Animation;->setDuration(J)V

    invoke-virtual {p0, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    invoke-virtual {p0, p1}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method

.method private showZoomControls()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomControlsHideHandler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    invoke-virtual {p0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_f

    invoke-virtual {p0}, Lorg/mapsforge/map/android/input/MapZoomControls;->show()V

    :cond_f
    return-void
.end method

.method private showZoomControlsWithTimeout()V
    .registers 5

    invoke-direct {p0}, Lorg/mapsforge/map/android/input/MapZoomControls;->showZoomControls()V

    iget-object v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomControlsHideHandler:Landroid/os/Handler;

    sget-wide v1, Lorg/mapsforge/map/android/input/MapZoomControls;->ZOOM_CONTROLS_TIMEOUT:J

    const/4 v3, 0x0

    invoke-virtual {v0, v3, v1, v2}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    return-void
.end method


# virtual methods
.method public destroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0, p0}, Lorg/mapsforge/map/model/IMapViewPosition;->removeObserver(Lorg/mapsforge/map/model/common/Observer;)V

    return-void
.end method

.method public getZoomControlsGravity()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomControlsGravity:I

    return v0
.end method

.method public getZoomLevelMax()B
    .registers 2

    iget-byte v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomLevelMax:B

    return v0
.end method

.method public getZoomLevelMin()B
    .registers 2

    iget-byte v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomLevelMin:B

    return v0
.end method

.method public hide()V
    .registers 4

    const/16 v0, 0x8

    const/high16 v1, 0x3f800000    # 1.0f

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lorg/mapsforge/map/android/input/MapZoomControls;->fade(IFF)V

    return-void
.end method

.method public isAutoHide()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->autoHide:Z

    return v0
.end method

.method public isShowMapZoomControls()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->showMapZoomControls:Z

    return v0
.end method

.method public onChange()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0}, Lorg/mapsforge/map/model/IMapViewPosition;->getZoomLevel()B

    move-result v0

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/android/input/MapZoomControls;->onZoomLevelChange(I)V

    return-void
.end method

.method public onMapViewTouchEvent(Landroid/view/MotionEvent;)V
    .registers 4

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_8

    return-void

    :cond_8
    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->showMapZoomControls:Z

    if-eqz v0, :cond_23

    iget-boolean v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->autoHide:Z

    if-eqz v0, :cond_23

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result p1

    if-eqz p1, :cond_20

    if-eq p1, v1, :cond_1c

    const/4 v0, 0x3

    if-eq p1, v0, :cond_1c

    goto :goto_23

    :cond_1c
    invoke-direct {p0}, Lorg/mapsforge/map/android/input/MapZoomControls;->showZoomControlsWithTimeout()V

    goto :goto_23

    :cond_20
    invoke-direct {p0}, Lorg/mapsforge/map/android/input/MapZoomControls;->showZoomControls()V

    :cond_23
    :goto_23
    return-void
.end method

.method public onZoomLevelChange(I)V
    .registers 4

    invoke-static {}, Lorg/mapsforge/map/android/util/AndroidUtil;->currentThreadIsUiThread()Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-direct {p0, p1}, Lorg/mapsforge/map/android/input/MapZoomControls;->changeZoomControls(I)V

    goto :goto_14

    :cond_a
    iget-object v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->mapView:Lorg/mapsforge/map/android/view/MapView;

    new-instance v1, Lorg/mapsforge/map/android/input/MapZoomControls$4;

    invoke-direct {v1, p0, p1}, Lorg/mapsforge/map/android/input/MapZoomControls$4;-><init>(Lorg/mapsforge/map/android/input/MapZoomControls;I)V

    invoke-virtual {v0, v1}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    :goto_14
    return-void
.end method

.method public setAutoHide(Z)V
    .registers 2

    iput-boolean p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->autoHide:Z

    if-nez p1, :cond_7

    invoke-direct {p0}, Lorg/mapsforge/map/android/input/MapZoomControls;->showZoomControls()V

    :cond_7
    return-void
.end method

.method public setMarginHorizontal(I)V
    .registers 4

    invoke-virtual {p0}, Landroid/view/View;->getPaddingTop()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getPaddingBottom()I

    move-result v1

    invoke-virtual {p0, p1, v0, p1, v1}, Landroid/view/View;->setPadding(IIII)V

    iget-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p1}, Landroid/view/View;->requestLayout()V

    return-void
.end method

.method public setMarginVertical(I)V
    .registers 4

    invoke-virtual {p0}, Landroid/view/View;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getPaddingRight()I

    move-result v1

    invoke-virtual {p0, v0, p1, v1, p1}, Landroid/view/View;->setPadding(IIII)V

    iget-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p1}, Landroid/view/View;->requestLayout()V

    return-void
.end method

.method public setShowMapZoomControls(Z)V
    .registers 2

    iput-boolean p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->showMapZoomControls:Z

    return-void
.end method

.method public setZoomControlsGravity(I)V
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomControlsGravity:I

    iget-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p1}, Landroid/view/View;->requestLayout()V

    return-void
.end method

.method public setZoomControlsOrientation(Lorg/mapsforge/map/android/input/MapZoomControls$Orientation;)V
    .registers 3

    iget v0, p1, Lorg/mapsforge/map/android/input/MapZoomControls$Orientation;->layoutOrientation:I

    invoke-virtual {p0, v0}, Landroid/widget/LinearLayout;->setOrientation(I)V

    iget-boolean p1, p1, Lorg/mapsforge/map/android/input/MapZoomControls$Orientation;->zoomInFirst:Z

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/android/input/MapZoomControls;->setZoomInFirst(Z)V

    return-void
.end method

.method public setZoomInFirst(Z)V
    .registers 4

    invoke-virtual {p0}, Landroid/view/ViewGroup;->removeAllViews()V

    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v1, -0x2

    invoke-direct {v0, v1, v1}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    if-eqz p1, :cond_13

    iget-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->buttonZoomIn:Landroid/widget/ZoomButton;

    invoke-virtual {p0, p1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    iget-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->buttonZoomOut:Landroid/widget/ZoomButton;

    goto :goto_1a

    :cond_13
    iget-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->buttonZoomOut:Landroid/widget/ZoomButton;

    invoke-virtual {p0, p1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    iget-object p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->buttonZoomIn:Landroid/widget/ZoomButton;

    :goto_1a
    invoke-virtual {p0, p1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    return-void
.end method

.method public setZoomInResource(I)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->buttonZoomIn:Landroid/widget/ZoomButton;

    invoke-virtual {v0, p1}, Landroid/view/View;->setBackgroundResource(I)V

    return-void
.end method

.method public setZoomLevelMax(B)V
    .registers 3

    iget-byte v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomLevelMin:B

    if-lt p1, v0, :cond_7

    iput-byte p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomLevelMax:B

    return-void

    :cond_7
    new-instance p1, Ljava/lang/IllegalArgumentException;

    invoke-direct {p1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw p1
.end method

.method public setZoomLevelMin(B)V
    .registers 3

    iget-byte v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomLevelMax:B

    if-gt p1, v0, :cond_7

    iput-byte p1, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->zoomLevelMin:B

    return-void

    :cond_7
    new-instance p1, Ljava/lang/IllegalArgumentException;

    invoke-direct {p1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw p1
.end method

.method public setZoomOutResource(I)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->buttonZoomOut:Landroid/widget/ZoomButton;

    invoke-virtual {v0, p1}, Landroid/view/View;->setBackgroundResource(I)V

    return-void
.end method

.method public setZoomSpeed(J)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->buttonZoomIn:Landroid/widget/ZoomButton;

    invoke-virtual {v0, p1, p2}, Landroid/widget/ZoomButton;->setZoomSpeed(J)V

    iget-object v0, p0, Lorg/mapsforge/map/android/input/MapZoomControls;->buttonZoomOut:Landroid/widget/ZoomButton;

    invoke-virtual {v0, p1, p2}, Landroid/widget/ZoomButton;->setZoomSpeed(J)V

    return-void
.end method

.method public show()V
    .registers 4

    const/4 v0, 0x0

    const/4 v1, 0x0

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-direct {p0, v0, v1, v2}, Lorg/mapsforge/map/android/input/MapZoomControls;->fade(IFF)V

    return-void
.end method
