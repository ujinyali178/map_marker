.class public Lorg/mapsforge/map/view/FpsCounter;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final ONE_SECOND:J


# instance fields
.field private final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field private fps:Ljava/lang/String;

.field private frameCounter:I

.field private lastTime:J

.field private final paintBack:Lorg/mapsforge/core/graphics/Paint;

.field private final paintFront:Lorg/mapsforge/core/graphics/Paint;

.field private visible:Z


# direct methods
.method static constructor <clinit>()V
    .registers 3

    sget-object v0, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/TimeUnit;->toNanos(J)J

    move-result-wide v0

    sput-wide v0, Lorg/mapsforge/map/view/FpsCounter;->ONE_SECOND:J

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/view/FpsCounter;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-static {p1, p2}, Lorg/mapsforge/map/view/FpsCounter;->createPaintBack(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/view/FpsCounter;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {p1, p2}, Lorg/mapsforge/map/view/FpsCounter;->createPaintFront(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/view/FpsCounter;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/view/FpsCounter;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iput-object p2, p0, Lorg/mapsforge/map/view/FpsCounter;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    iput-object p3, p0, Lorg/mapsforge/map/view/FpsCounter;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    return-void
.end method

.method private static createPaintBack(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;
    .registers 4

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p0

    sget-object v0, Lorg/mapsforge/core/graphics/Color;->WHITE:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {p0, v0}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object v0, Lorg/mapsforge/core/graphics/FontFamily;->DEFAULT:Lorg/mapsforge/core/graphics/FontFamily;

    sget-object v1, Lorg/mapsforge/core/graphics/FontStyle;->BOLD:Lorg/mapsforge/core/graphics/FontStyle;

    invoke-interface {p0, v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setTypeface(Lorg/mapsforge/core/graphics/FontFamily;Lorg/mapsforge/core/graphics/FontStyle;)V

    invoke-virtual {p1}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v0

    const/high16 v1, 0x41c80000    # 25.0f

    mul-float v0, v0, v1

    invoke-interface {p0, v0}, Lorg/mapsforge/core/graphics/Paint;->setTextSize(F)V

    invoke-virtual {p1}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result p1

    const/high16 v0, 0x40000000    # 2.0f

    mul-float p1, p1, v0

    invoke-interface {p0, p1}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    sget-object p1, Lorg/mapsforge/core/graphics/Style;->STROKE:Lorg/mapsforge/core/graphics/Style;

    invoke-interface {p0, p1}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    return-object p0
.end method

.method private static createPaintFront(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)Lorg/mapsforge/core/graphics/Paint;
    .registers 4

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object p0

    sget-object v0, Lorg/mapsforge/core/graphics/Color;->RED:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {p0, v0}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    sget-object v0, Lorg/mapsforge/core/graphics/FontFamily;->DEFAULT:Lorg/mapsforge/core/graphics/FontFamily;

    sget-object v1, Lorg/mapsforge/core/graphics/FontStyle;->BOLD:Lorg/mapsforge/core/graphics/FontStyle;

    invoke-interface {p0, v0, v1}, Lorg/mapsforge/core/graphics/Paint;->setTypeface(Lorg/mapsforge/core/graphics/FontFamily;Lorg/mapsforge/core/graphics/FontStyle;)V

    invoke-virtual {p1}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result p1

    const/high16 v0, 0x41c80000    # 25.0f

    mul-float p1, p1, v0

    invoke-interface {p0, p1}, Lorg/mapsforge/core/graphics/Paint;->setTextSize(F)V

    return-object p0
.end method


# virtual methods
.method public draw(Lorg/mapsforge/core/graphics/GraphicContext;)V
    .registers 10

    iget-boolean v0, p0, Lorg/mapsforge/map/view/FpsCounter;->visible:Z

    if-nez v0, :cond_5

    return-void

    :cond_5
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    iget-wide v2, p0, Lorg/mapsforge/map/view/FpsCounter;->lastTime:J

    sub-long v2, v0, v2

    sget-wide v4, Lorg/mapsforge/map/view/FpsCounter;->ONE_SECOND:J

    cmp-long v6, v2, v4

    if-lez v6, :cond_2a

    iget v6, p0, Lorg/mapsforge/map/view/FpsCounter;->frameCounter:I

    int-to-long v6, v6

    mul-long v6, v6, v4

    long-to-float v4, v6

    long-to-float v2, v2

    div-float/2addr v4, v2

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lorg/mapsforge/map/view/FpsCounter;->fps:Ljava/lang/String;

    iput-wide v0, p0, Lorg/mapsforge/map/view/FpsCounter;->lastTime:J

    const/4 v0, 0x0

    iput v0, p0, Lorg/mapsforge/map/view/FpsCounter;->frameCounter:I

    :cond_2a
    const/high16 v0, 0x41a00000    # 20.0f

    iget-object v1, p0, Lorg/mapsforge/map/view/FpsCounter;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v1

    mul-float v1, v1, v0

    float-to-int v0, v1

    const/high16 v1, 0x42200000    # 40.0f

    iget-object v2, p0, Lorg/mapsforge/map/view/FpsCounter;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v2

    mul-float v2, v2, v1

    float-to-int v1, v2

    iget-object v2, p0, Lorg/mapsforge/map/view/FpsCounter;->fps:Ljava/lang/String;

    iget-object v3, p0, Lorg/mapsforge/map/view/FpsCounter;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1, v2, v0, v1, v3}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    iget-object v2, p0, Lorg/mapsforge/map/view/FpsCounter;->fps:Ljava/lang/String;

    iget-object v3, p0, Lorg/mapsforge/map/view/FpsCounter;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1, v2, v0, v1, v3}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    iget p1, p0, Lorg/mapsforge/map/view/FpsCounter;->frameCounter:I

    add-int/lit8 p1, p1, 0x1

    iput p1, p0, Lorg/mapsforge/map/view/FpsCounter;->frameCounter:I

    return-void
.end method

.method public isVisible()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/view/FpsCounter;->visible:Z

    return v0
.end method

.method public setVisible(Z)V
    .registers 2

    iput-boolean p1, p0, Lorg/mapsforge/map/view/FpsCounter;->visible:Z

    return-void
.end method
