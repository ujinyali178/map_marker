.class public Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;
.super Lorg/mapsforge/map/scalebar/MapScaleBar;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;
    }
.end annotation


# static fields
.field private static final BITMAP_HEIGHT:I = 0x28

.field private static final BITMAP_WIDTH:I = 0x78

.field private static final DEFAULT_HORIZONTAL_MARGIN:I = 0x5

.field private static final DEFAULT_VERTICAL_MARGIN:I = 0x0

.field private static final SCALE_BAR_MARGIN:I = 0xa

.field private static final STROKE_EXTERNAL:F = 4.0f

.field private static final STROKE_INTERNAL:F = 2.0f

.field private static final TEXT_MARGIN:I = 0x1


# instance fields
.field private final paintScaleBar:Lorg/mapsforge/core/graphics/Paint;

.field private final paintScaleBarStroke:Lorg/mapsforge/core/graphics/Paint;

.field private final paintScaleText:Lorg/mapsforge/core/graphics/Paint;

.field private final paintScaleTextStroke:Lorg/mapsforge/core/graphics/Paint;

.field private scaleBarMode:Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;

.field private secondaryDistanceUnitAdapter:Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/model/MapViewDimension;Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 11

    invoke-virtual {p4}, Lorg/mapsforge/map/model/DisplayModel;->getScaleFactor()F

    move-result v5

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v5}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;-><init>(Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/model/MapViewDimension;Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;F)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/model/MapViewDimension;Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;F)V
    .registers 15

    const/high16 v0, 0x42f00000    # 120.0f

    mul-float v0, v0, p5

    float-to-int v6, v0

    const/high16 v0, 0x42200000    # 40.0f

    mul-float v0, v0, p5

    float-to-int v7, v0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p4

    move-object v5, p3

    move v8, p5

    invoke-direct/range {v1 .. v8}, Lorg/mapsforge/map/scalebar/MapScaleBar;-><init>(Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/model/MapViewDimension;Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/core/graphics/GraphicFactory;IIF)V

    const/high16 p1, 0x40a00000    # 5.0f

    mul-float p1, p1, p5

    float-to-int p1, p1

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/scalebar/MapScaleBar;->setMarginHorizontal(I)V

    const/4 p1, 0x0

    mul-float p5, p5, p1

    float-to-int p2, p5

    invoke-virtual {p0, p2}, Lorg/mapsforge/map/scalebar/MapScaleBar;->setMarginVertical(I)V

    sget-object p2, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;->BOTH:Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;

    iput-object p2, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->scaleBarMode:Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;

    sget-object p2, Lorg/mapsforge/map/scalebar/ImperialUnitAdapter;->INSTANCE:Lorg/mapsforge/map/scalebar/ImperialUnitAdapter;

    iput-object p2, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->secondaryDistanceUnitAdapter:Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;

    sget-object p2, Lorg/mapsforge/core/graphics/Color;->BLACK:Lorg/mapsforge/core/graphics/Color;

    sget-object p3, Lorg/mapsforge/core/graphics/Style;->FILL:Lorg/mapsforge/core/graphics/Style;

    const/high16 p4, 0x40000000    # 2.0f

    invoke-direct {p0, p2, p4, p3}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->createScaleBarPaint(Lorg/mapsforge/core/graphics/Color;FLorg/mapsforge/core/graphics/Style;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object p5

    iput-object p5, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleBar:Lorg/mapsforge/core/graphics/Paint;

    sget-object p5, Lorg/mapsforge/core/graphics/Color;->WHITE:Lorg/mapsforge/core/graphics/Color;

    sget-object v0, Lorg/mapsforge/core/graphics/Style;->STROKE:Lorg/mapsforge/core/graphics/Style;

    const/high16 v1, 0x40800000    # 4.0f

    invoke-direct {p0, p5, v1, v0}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->createScaleBarPaint(Lorg/mapsforge/core/graphics/Color;FLorg/mapsforge/core/graphics/Style;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object v1

    iput-object v1, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleBarStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-direct {p0, p2, p1, p3}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->createTextPaint(Lorg/mapsforge/core/graphics/Color;FLorg/mapsforge/core/graphics/Style;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleText:Lorg/mapsforge/core/graphics/Paint;

    invoke-direct {p0, p5, p4, v0}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->createTextPaint(Lorg/mapsforge/core/graphics/Color;FLorg/mapsforge/core/graphics/Style;)Lorg/mapsforge/core/graphics/Paint;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleTextStroke:Lorg/mapsforge/core/graphics/Paint;

    return-void
.end method

.method private createScaleBarPaint(Lorg/mapsforge/core/graphics/Color;FLorg/mapsforge/core/graphics/Style;)Lorg/mapsforge/core/graphics/Paint;
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    invoke-interface {v0, p1}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    iget p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scale:F

    mul-float p2, p2, p1

    invoke-interface {v0, p2}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    invoke-interface {v0, p3}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    sget-object p1, Lorg/mapsforge/core/graphics/Cap;->SQUARE:Lorg/mapsforge/core/graphics/Cap;

    invoke-interface {v0, p1}, Lorg/mapsforge/core/graphics/Paint;->setStrokeCap(Lorg/mapsforge/core/graphics/Cap;)V

    return-object v0
.end method

.method private createTextPaint(Lorg/mapsforge/core/graphics/Color;FLorg/mapsforge/core/graphics/Style;)Lorg/mapsforge/core/graphics/Paint;
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPaint()Lorg/mapsforge/core/graphics/Paint;

    move-result-object v0

    invoke-interface {v0, p1}, Lorg/mapsforge/core/graphics/Paint;->setColor(Lorg/mapsforge/core/graphics/Color;)V

    iget p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scale:F

    mul-float p2, p2, p1

    invoke-interface {v0, p2}, Lorg/mapsforge/core/graphics/Paint;->setStrokeWidth(F)V

    invoke-interface {v0, p3}, Lorg/mapsforge/core/graphics/Paint;->setStyle(Lorg/mapsforge/core/graphics/Style;)V

    sget-object p1, Lorg/mapsforge/core/graphics/FontFamily;->DEFAULT:Lorg/mapsforge/core/graphics/FontFamily;

    sget-object p2, Lorg/mapsforge/core/graphics/FontStyle;->BOLD:Lorg/mapsforge/core/graphics/FontStyle;

    invoke-interface {v0, p1, p2}, Lorg/mapsforge/core/graphics/Paint;->setTypeface(Lorg/mapsforge/core/graphics/FontFamily;Lorg/mapsforge/core/graphics/FontStyle;)V

    iget p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scale:F

    const/high16 p2, 0x41400000    # 12.0f

    mul-float p1, p1, p2

    invoke-interface {v0, p1}, Lorg/mapsforge/core/graphics/Paint;->setTextSize(F)V

    return-object v0
.end method

.method private drawScaleBar(Lorg/mapsforge/core/graphics/Canvas;IILorg/mapsforge/core/graphics/Paint;F)V
    .registers 25

    move/from16 v0, p2

    move/from16 v1, p3

    invoke-static/range {p2 .. p3}, Ljava/lang/Math;->max(II)I

    move-result v2

    sget-object v3, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$1;->$SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition:[I

    move-object/from16 v4, p0

    iget-object v5, v4, Lorg/mapsforge/map/scalebar/MapScaleBar;->scaleBarPosition:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    invoke-virtual {v5}, Ljava/lang/Enum;->ordinal()I

    move-result v5

    aget v3, v3, v5

    const/high16 v5, 0x40800000    # 4.0f

    const/high16 v6, 0x41200000    # 10.0f

    const/high16 v7, 0x3f000000    # 0.5f

    packed-switch v3, :pswitch_data_420

    goto/16 :goto_41f

    :pswitch_1f
    if-nez v1, :cond_1e6

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float v1, p5, v5

    mul-float v1, v1, v7

    sub-float/2addr v0, v1

    int-to-float v2, v2

    sub-float/2addr v0, v2

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v9

    mul-float v0, p5, v6

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v3

    int-to-float v3, v3

    sub-float/2addr v3, v1

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v12

    move-object/from16 v8, p1

    move-object/from16 v13, p4

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v3

    int-to-float v3, v3

    sub-float/2addr v3, v1

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v3

    int-to-float v3, v3

    sub-float/2addr v3, v1

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v3

    int-to-float v3, v3

    mul-float v3, v3, v7

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v12

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v3

    int-to-float v3, v3

    sub-float/2addr v3, v1

    sub-float/2addr v3, v2

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v1

    sub-float/2addr v0, v2

    goto/16 :goto_14b

    :pswitch_8a
    if-nez v1, :cond_395

    mul-float v0, p5, v5

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v9

    mul-float v1, p5, v6

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v10

    int-to-float v2, v2

    add-float/2addr v2, v0

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v12

    move-object/from16 v8, p1

    move-object/from16 v13, p4

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v14

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v15

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v16

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v17

    move-object/from16 v13, p1

    move-object/from16 v18, p4

    invoke-interface/range {v13 .. v18}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v7

    goto/16 :goto_2fb

    :pswitch_de
    if-nez v1, :cond_395

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    sub-int/2addr v0, v2

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v9

    mul-float v0, p5, v6

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v1

    add-int/2addr v1, v2

    int-to-float v1, v1

    mul-float v1, v1, v7

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v12

    move-object/from16 v8, p1

    move-object/from16 v13, p4

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v1

    sub-int/2addr v1, v2

    int-to-float v1, v1

    mul-float v1, v1, v7

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v1

    sub-int/2addr v1, v2

    int-to-float v1, v1

    mul-float v1, v1, v7

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v1

    int-to-float v1, v1

    mul-float v1, v1, v7

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v12

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v1

    add-int/2addr v1, v2

    int-to-float v1, v1

    mul-float v1, v1, v7

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    add-int/2addr v0, v2

    int-to-float v0, v0

    mul-float v0, v0, v7

    :goto_14b
    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v7

    goto/16 :goto_418

    :pswitch_158
    if-nez v1, :cond_1e6

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float v1, p5, v5

    mul-float v1, v1, v7

    sub-float/2addr v0, v1

    int-to-float v2, v2

    sub-float/2addr v0, v2

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v3, p5, v6

    sub-float/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v12

    move-object/from16 v8, p1

    move-object/from16 v13, p4

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v12

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v1

    sub-float/2addr v0, v2

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v1

    sub-float/2addr v0, v2

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v3

    goto/16 :goto_418

    :cond_1e6
    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v3

    int-to-float v3, v3

    mul-float v5, v5, p5

    mul-float v5, v5, v7

    sub-float/2addr v3, v5

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v3

    int-to-float v3, v3

    mul-float v3, v3, v7

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v3

    int-to-float v3, v3

    sub-float/2addr v3, v5

    int-to-float v2, v2

    sub-float/2addr v3, v2

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v2

    int-to-float v2, v2

    mul-float v2, v2, v7

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v12

    move-object/from16 v8, p1

    move-object/from16 v13, p4

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v2

    int-to-float v2, v2

    sub-float/2addr v2, v5

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v9

    mul-float v2, p5, v6

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v3

    int-to-float v3, v3

    sub-float/2addr v3, v5

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v3

    int-to-float v3, v3

    sub-float/2addr v3, v2

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v12

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v3

    int-to-float v3, v3

    sub-float/2addr v3, v5

    int-to-float v0, v0

    sub-float/2addr v3, v0

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v3

    int-to-float v3, v3

    sub-float/2addr v3, v5

    sub-float/2addr v3, v0

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v12

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v5

    int-to-float v1, v1

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v5

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v11

    goto/16 :goto_412

    :pswitch_291
    if-nez v1, :cond_395

    mul-float v0, p5, v5

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v1

    int-to-float v1, v1

    mul-float v3, p5, v6

    sub-float/2addr v1, v3

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v10

    int-to-float v1, v2

    add-float/2addr v1, v0

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v2

    int-to-float v2, v2

    sub-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v12

    move-object/from16 v8, p1

    move-object/from16 v13, p4

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v14

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v2

    int-to-float v2, v2

    mul-float v2, v2, v7

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v15

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v16

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v17

    move-object/from16 v13, p1

    move-object/from16 v18, p4

    invoke-interface/range {v13 .. v18}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v3

    :goto_2fb
    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v12

    move-object/from16 v13, p4

    goto/16 :goto_41c

    :pswitch_303
    if-nez v1, :cond_395

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    sub-int/2addr v0, v2

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v1, p5, v6

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    add-int/2addr v0, v2

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v12

    move-object/from16 v8, p1

    move-object/from16 v13, p4

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    sub-int/2addr v0, v2

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    sub-int/2addr v0, v2

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v12

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    add-int/2addr v0, v2

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    add-int/2addr v0, v2

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v1

    goto/16 :goto_418

    :cond_395
    mul-float v3, p5, v5

    mul-float v3, v3, v7

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v5

    int-to-float v5, v5

    mul-float v5, v5, v7

    invoke-static {v5}, Ljava/lang/Math;->round(F)I

    move-result v10

    int-to-float v2, v2

    add-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v2

    int-to-float v2, v2

    mul-float v2, v2, v7

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v12

    move-object/from16 v8, p1

    move-object/from16 v13, p4

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v14

    mul-float v2, p5, v6

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v15

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v16

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v5

    int-to-float v5, v5

    sub-float/2addr v5, v2

    invoke-static {v5}, Ljava/lang/Math;->round(F)I

    move-result v17

    move-object/from16 v13, p1

    move-object/from16 v18, p4

    invoke-interface/range {v13 .. v18}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    int-to-float v0, v0

    add-float/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v11

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v12

    move-object/from16 v13, p4

    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    int-to-float v0, v1

    add-float/2addr v3, v0

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v9

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v7

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v11

    :goto_412
    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr v0, v2

    :goto_418
    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v12

    :goto_41c
    invoke-interface/range {v8 .. v13}, Lorg/mapsforge/core/graphics/GraphicContext;->drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V

    :goto_41f
    return-void

    :pswitch_data_420
    .packed-switch 0x1
        :pswitch_303
        :pswitch_291
        :pswitch_158
        :pswitch_de
        :pswitch_8a
        :pswitch_1f
    .end packed-switch
.end method

.method private drawScaleText(Lorg/mapsforge/core/graphics/Canvas;Ljava/lang/String;Ljava/lang/String;Lorg/mapsforge/core/graphics/Paint;F)V
    .registers 11

    sget-object v0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$1;->$SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition:[I

    iget-object v1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scaleBarPosition:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/high16 v1, 0x41200000    # 10.0f

    const/high16 v2, 0x3f800000    # 1.0f

    const/high16 v3, 0x40800000    # 4.0f

    const/high16 v4, 0x3f000000    # 0.5f

    packed-switch v0, :pswitch_data_16a

    goto/16 :goto_169

    :pswitch_17
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9f

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result p3

    int-to-float p3, p3

    mul-float v3, v3, p5

    sub-float/2addr p3, v3

    mul-float v2, v2, p5

    sub-float/2addr p3, v2

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleTextStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, p2}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr p3, v0

    goto :goto_3d

    :pswitch_31
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_131

    mul-float v3, v3, p5

    mul-float v2, v2, p5

    add-float p3, v3, v2

    :goto_3d
    invoke-static {p3}, Ljava/lang/Math;->round(F)I

    move-result p3

    mul-float p5, p5, v1

    mul-float v3, v3, v4

    add-float/2addr p5, v3

    add-float/2addr p5, v2

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleTextStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, p2}, Lorg/mapsforge/core/graphics/Paint;->getTextHeight(Ljava/lang/String;)I

    move-result v0

    int-to-float v0, v0

    add-float/2addr p5, v0

    invoke-static {p5}, Ljava/lang/Math;->round(F)I

    move-result p5

    goto/16 :goto_12d

    :pswitch_55
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_131

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result p3

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleTextStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, p2}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result v0

    sub-int/2addr p3, v0

    int-to-float p3, p3

    mul-float p3, p3, v4

    invoke-static {p3}, Ljava/lang/Math;->round(F)I

    move-result p3

    mul-float v1, v1, p5

    mul-float v3, v3, p5

    mul-float v3, v3, v4

    add-float/2addr v1, v3

    mul-float p5, p5, v2

    add-float/2addr v1, p5

    iget-object p5, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleTextStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p5, p2}, Lorg/mapsforge/core/graphics/Paint;->getTextHeight(Ljava/lang/String;)I

    move-result p5

    int-to-float p5, p5

    add-float/2addr v1, p5

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result p5

    goto/16 :goto_12d

    :pswitch_85
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9f

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result p3

    int-to-float p3, p3

    mul-float v3, v3, p5

    sub-float/2addr p3, v3

    mul-float v2, v2, p5

    sub-float/2addr p3, v2

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleTextStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, p2}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr p3, v0

    goto :goto_f0

    :cond_9f
    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float v3, v3, p5

    sub-float/2addr v0, v3

    mul-float p5, p5, v2

    sub-float/2addr v0, p5

    iget-object v1, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleTextStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v1, p2}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result v1

    int-to-float v1, v1

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v1

    int-to-float v1, v1

    mul-float v1, v1, v4

    mul-float v2, v3, v4

    sub-float/2addr v1, v2

    sub-float/2addr v1, p5

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    invoke-interface {p1, p2, v0, v1, p4}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result p2

    int-to-float p2, p2

    sub-float/2addr p2, v3

    sub-float/2addr p2, p5

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleTextStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, p3}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result v0

    int-to-float v0, v0

    sub-float/2addr p2, v0

    invoke-static {p2}, Ljava/lang/Math;->round(F)I

    move-result p2

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v4

    add-float/2addr v0, v2

    goto :goto_159

    :pswitch_e4
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_131

    mul-float v3, v3, p5

    mul-float v2, v2, p5

    add-float p3, v3, v2

    :goto_f0
    invoke-static {p3}, Ljava/lang/Math;->round(F)I

    move-result p3

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float p5, p5, v1

    sub-float/2addr v0, p5

    mul-float v3, v3, v4

    sub-float/2addr v0, v3

    sub-float/2addr v0, v2

    goto :goto_129

    :pswitch_101
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_131

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->getWidth()I

    move-result p3

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleTextStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, p2}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result v0

    sub-int/2addr p3, v0

    int-to-float p3, p3

    mul-float p3, p3, v4

    invoke-static {p3}, Ljava/lang/Math;->round(F)I

    move-result p3

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v1, v1, p5

    sub-float/2addr v0, v1

    mul-float v3, v3, p5

    mul-float v3, v3, v4

    sub-float/2addr v0, v3

    mul-float p5, p5, v2

    sub-float/2addr v0, p5

    :goto_129
    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result p5

    :goto_12d
    invoke-interface {p1, p2, p3, p5, p4}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    goto :goto_169

    :cond_131
    mul-float v3, v3, p5

    mul-float p5, p5, v2

    add-float v0, v3, p5

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v1

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v2

    int-to-float v2, v2

    mul-float v2, v2, v4

    mul-float v3, v3, v4

    sub-float/2addr v2, v3

    sub-float/2addr v2, p5

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    invoke-interface {p1, p2, v1, v2, p4}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result p2

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float v0, v0, v4

    add-float/2addr v0, v3

    :goto_159
    add-float/2addr v0, p5

    iget-object p5, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleTextStroke:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p5, p3}, Lorg/mapsforge/core/graphics/Paint;->getTextHeight(Ljava/lang/String;)I

    move-result p5

    int-to-float p5, p5

    add-float/2addr v0, p5

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result p5

    invoke-interface {p1, p3, p2, p5, p4}, Lorg/mapsforge/core/graphics/GraphicContext;->drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V

    :goto_169
    return-void

    :pswitch_data_16a
    .packed-switch 0x1
        :pswitch_101
        :pswitch_e4
        :pswitch_85
        :pswitch_55
        :pswitch_31
        :pswitch_17
    .end packed-switch
.end method


# virtual methods
.method public getScaleBarMode()Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->scaleBarMode:Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;

    return-object v0
.end method

.method public getSecondaryDistanceUnitAdapter()Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->secondaryDistanceUnitAdapter:Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;

    return-object v0
.end method

.method protected redraw(Lorg/mapsforge/core/graphics/Canvas;)V
    .registers 11

    sget-object v0, Lorg/mapsforge/core/graphics/Color;->TRANSPARENT:Lorg/mapsforge/core/graphics/Color;

    invoke-interface {p1, v0}, Lorg/mapsforge/core/graphics/GraphicContext;->fillColor(Lorg/mapsforge/core/graphics/Color;)V

    invoke-virtual {p0}, Lorg/mapsforge/map/scalebar/MapScaleBar;->calculateScaleBarLengthAndValue()Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;

    move-result-object v6

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->scaleBarMode:Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;

    sget-object v7, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;->BOTH:Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;

    if-ne v0, v7, :cond_16

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->secondaryDistanceUnitAdapter:Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/scalebar/MapScaleBar;->calculateScaleBarLengthAndValue(Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;)Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;

    move-result-object v0

    goto :goto_1c

    :cond_16
    new-instance v0, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;

    const/4 v1, 0x0

    invoke-direct {v0, v1, v1}, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;-><init>(II)V

    :goto_1c
    move-object v8, v0

    iget v2, v6, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;->scaleBarLength:I

    iget v3, v8, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;->scaleBarLength:I

    iget-object v4, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleBarStroke:Lorg/mapsforge/core/graphics/Paint;

    iget v5, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scale:F

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->drawScaleBar(Lorg/mapsforge/core/graphics/Canvas;IILorg/mapsforge/core/graphics/Paint;F)V

    iget v2, v6, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;->scaleBarLength:I

    iget v3, v8, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;->scaleBarLength:I

    iget-object v4, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleBar:Lorg/mapsforge/core/graphics/Paint;

    iget v5, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scale:F

    invoke-direct/range {v0 .. v5}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->drawScaleBar(Lorg/mapsforge/core/graphics/Canvas;IILorg/mapsforge/core/graphics/Paint;F)V

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->distanceUnitAdapter:Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;

    iget v1, v6, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;->scaleBarValue:I

    invoke-interface {v0, v1}, Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;->getScaleText(I)Ljava/lang/String;

    move-result-object v6

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->scaleBarMode:Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;

    if-ne v0, v7, :cond_4a

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->secondaryDistanceUnitAdapter:Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;

    iget v1, v8, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;->scaleBarValue:I

    invoke-interface {v0, v1}, Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;->getScaleText(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_4c

    :cond_4a
    const-string v0, ""

    :goto_4c
    move-object v7, v0

    iget-object v4, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleTextStroke:Lorg/mapsforge/core/graphics/Paint;

    iget v5, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scale:F

    move-object v0, p0

    move-object v1, p1

    move-object v2, v6

    move-object v3, v7

    invoke-direct/range {v0 .. v5}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->drawScaleText(Lorg/mapsforge/core/graphics/Canvas;Ljava/lang/String;Ljava/lang/String;Lorg/mapsforge/core/graphics/Paint;F)V

    iget-object v4, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->paintScaleText:Lorg/mapsforge/core/graphics/Paint;

    iget v5, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scale:F

    invoke-direct/range {v0 .. v5}, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->drawScaleText(Lorg/mapsforge/core/graphics/Canvas;Ljava/lang/String;Ljava/lang/String;Lorg/mapsforge/core/graphics/Paint;F)V

    return-void
.end method

.method public setScaleBarMode(Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->scaleBarMode:Lorg/mapsforge/map/scalebar/DefaultMapScaleBar$ScaleBarMode;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->redrawNeeded:Z

    return-void
.end method

.method public setSecondaryDistanceUnitAdapter(Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;)V
    .registers 3

    if-eqz p1, :cond_8

    iput-object p1, p0, Lorg/mapsforge/map/scalebar/DefaultMapScaleBar;->secondaryDistanceUnitAdapter:Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->redrawNeeded:Z

    return-void

    :cond_8
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "adapter must not be null"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
