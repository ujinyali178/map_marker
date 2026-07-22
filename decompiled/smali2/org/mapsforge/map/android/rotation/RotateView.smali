.class public Lorg/mapsforge/map/android/rotation/RotateView;
.super Landroid/view/ViewGroup;
.source "SourceFile"


# instance fields
.field private heading:F

.field private final matrix:Landroid/graphics/Matrix;

.field private final points:[F

.field private saveCount:I

.field private final smoothCanvas:Lorg/mapsforge/map/android/rotation/SmoothCanvas;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lorg/mapsforge/map/android/rotation/RotateView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 3

    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    const/4 p1, 0x0

    iput p1, p0, Lorg/mapsforge/map/android/rotation/RotateView;->heading:F

    new-instance p1, Landroid/graphics/Matrix;

    invoke-direct {p1}, Landroid/graphics/Matrix;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/android/rotation/RotateView;->matrix:Landroid/graphics/Matrix;

    const/4 p1, 0x2

    new-array p1, p1, [F

    iput-object p1, p0, Lorg/mapsforge/map/android/rotation/RotateView;->points:[F

    const/4 p1, -0x1

    iput p1, p0, Lorg/mapsforge/map/android/rotation/RotateView;->saveCount:I

    new-instance p1, Lorg/mapsforge/map/android/rotation/SmoothCanvas;

    invoke-direct {p1}, Lorg/mapsforge/map/android/rotation/SmoothCanvas;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/android/rotation/RotateView;->smoothCanvas:Lorg/mapsforge/map/android/rotation/SmoothCanvas;

    const/4 p1, 0x1

    const/4 p2, 0x0

    invoke-virtual {p0, p1, p2}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    return-void
.end method

.method private rotateEvent(Landroid/view/MotionEvent;FFF)Landroid/view/MotionEvent;
    .registers 6

    const/4 v0, 0x0

    cmpl-float v0, p2, v0

    if-nez v0, :cond_6

    return-object p1

    :cond_6
    iget-object v0, p0, Lorg/mapsforge/map/android/rotation/RotateView;->matrix:Landroid/graphics/Matrix;

    invoke-virtual {v0, p2, p3, p4}, Landroid/graphics/Matrix;->setRotate(FFF)V

    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object p1

    iget-object p2, p0, Lorg/mapsforge/map/android/rotation/RotateView;->matrix:Landroid/graphics/Matrix;

    invoke-virtual {p1, p2}, Landroid/view/MotionEvent;->transform(Landroid/graphics/Matrix;)V

    return-object p1
.end method


# virtual methods
.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .registers 6

    iget v0, p0, Lorg/mapsforge/map/android/rotation/RotateView;->heading:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_b

    invoke-super {p0, p1}, Landroid/view/ViewGroup;->dispatchDraw(Landroid/graphics/Canvas;)V

    return-void

    :cond_b
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v0

    iput v0, p0, Lorg/mapsforge/map/android/rotation/RotateView;->saveCount:I

    iget v0, p0, Lorg/mapsforge/map/android/rotation/RotateView;->heading:F

    neg-float v0, v0

    invoke-virtual {p0}, Landroid/view/View;->getWidth()I

    move-result v1

    int-to-float v1, v1

    const/high16 v2, 0x3f000000    # 0.5f

    mul-float v1, v1, v2

    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    move-result v3

    int-to-float v3, v3

    mul-float v3, v3, v2

    invoke-virtual {p1, v0, v1, v3}, Landroid/graphics/Canvas;->rotate(FFF)V

    iget-object v0, p0, Lorg/mapsforge/map/android/rotation/RotateView;->smoothCanvas:Lorg/mapsforge/map/android/rotation/SmoothCanvas;

    iput-object p1, v0, Lorg/mapsforge/map/android/rotation/SmoothCanvas;->delegate:Landroid/graphics/Canvas;

    invoke-super {p0, v0}, Landroid/view/ViewGroup;->dispatchDraw(Landroid/graphics/Canvas;)V

    iget v0, p0, Lorg/mapsforge/map/android/rotation/RotateView;->saveCount:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_38

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->restoreToCount(I)V

    iput v1, p0, Lorg/mapsforge/map/android/rotation/RotateView;->saveCount:I

    :cond_38
    return-void
.end method

.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 6

    iget v0, p0, Lorg/mapsforge/map/android/rotation/RotateView;->heading:F

    const/4 v1, 0x0

    cmpl-float v1, v0, v1

    if-nez v1, :cond_c

    invoke-super {p0, p1}, Landroid/view/ViewGroup;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1

    :cond_c
    invoke-virtual {p0}, Landroid/view/View;->getWidth()I

    move-result v1

    int-to-float v1, v1

    const/high16 v2, 0x3f000000    # 0.5f

    mul-float v1, v1, v2

    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    move-result v3

    int-to-float v3, v3

    mul-float v3, v3, v2

    invoke-direct {p0, p1, v0, v1, v3}, Lorg/mapsforge/map/android/rotation/RotateView;->rotateEvent(Landroid/view/MotionEvent;FFF)Landroid/view/MotionEvent;

    move-result-object v0

    :try_start_20
    invoke-super {p0, v0}, Landroid/view/ViewGroup;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1
    :try_end_24
    .catchall {:try_start_20 .. :try_end_24} :catchall_2a

    if-eq v0, p1, :cond_29

    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    :cond_29
    return v1

    :catchall_2a
    move-exception v1

    if-eq v0, p1, :cond_30

    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    :cond_30
    throw v1
.end method

.method public getHeading()F
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/android/rotation/RotateView;->heading:F

    return v0
.end method

.method protected onLayout(ZIIII)V
    .registers 10

    invoke-virtual {p0}, Landroid/view/View;->getWidth()I

    move-result p1

    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    move-result p2

    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result p3

    const/4 p4, 0x0

    :goto_d
    if-ge p4, p3, :cond_2b

    invoke-virtual {p0, p4}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object p5

    invoke-virtual {p5}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    invoke-virtual {p5}, Landroid/view/View;->getMeasuredHeight()I

    move-result v1

    sub-int v2, p1, v0

    div-int/lit8 v2, v2, 0x2

    sub-int v3, p2, v1

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v0, v2

    add-int/2addr v1, v3

    invoke-virtual {p5, v2, v3, v0, v1}, Landroid/view/View;->layout(IIII)V

    add-int/lit8 p4, p4, 0x1

    goto :goto_d

    :cond_2b
    return-void
.end method

.method protected onMeasure(II)V
    .registers 7

    invoke-virtual {p0}, Landroid/view/View;->getSuggestedMinimumWidth()I

    move-result v0

    invoke-static {v0, p1}, Landroid/view/View;->getDefaultSize(II)I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getSuggestedMinimumHeight()I

    move-result v1

    invoke-static {v1, p2}, Landroid/view/View;->getDefaultSize(II)I

    move-result v1

    int-to-double v2, v0

    int-to-double v0, v1

    invoke-static {v2, v3, v0, v1}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide v0

    double-to-int v0, v0

    const/high16 v1, 0x40000000    # 2.0f

    invoke-static {v0, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v1

    const/4 v2, 0x0

    :goto_22
    if-ge v2, v1, :cond_2e

    invoke-virtual {p0, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v0, v0}, Landroid/view/View;->measure(II)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_22

    :cond_2e
    invoke-super {p0, p1, p2}, Landroid/view/ViewGroup;->onMeasure(II)V

    return-void
.end method

.method public setHeading(F)V
    .registers 2

    iput p1, p0, Lorg/mapsforge/map/android/rotation/RotateView;->heading:F

    return-void
.end method
