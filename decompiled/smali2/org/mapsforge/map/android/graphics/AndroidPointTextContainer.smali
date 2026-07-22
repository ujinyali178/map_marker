.class public Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;
.super Lorg/mapsforge/core/mapelements/PointTextContainer;
.source "SourceFile"


# instance fields
.field private backLayout:Landroid/text/StaticLayout;

.field private frontLayout:Landroid/text/StaticLayout;


# direct methods
.method constructor <init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/mapelements/SymbolContainer;Lorg/mapsforge/core/graphics/Position;I)V
    .registers 21

    move-object v0, p0

    invoke-direct/range {p0 .. p9}, Lorg/mapsforge/core/mapelements/PointTextContainer;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/mapelements/SymbolContainer;Lorg/mapsforge/core/graphics/Position;I)V

    iget v1, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->textWidth:I

    iget v2, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->maxTextWidth:I

    if-le v1, v2, :cond_a1

    new-instance v1, Landroid/text/TextPaint;

    iget-object v2, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {v2}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getPaint(Lorg/mapsforge/core/graphics/Paint;)Landroid/graphics/Paint;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/text/TextPaint;-><init>(Landroid/graphics/Paint;)V

    iget-object v2, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    const/4 v3, 0x0

    if-eqz v2, :cond_26

    new-instance v2, Landroid/text/TextPaint;

    iget-object v4, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {v4}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getPaint(Lorg/mapsforge/core/graphics/Paint;)Landroid/graphics/Paint;

    move-result-object v4

    invoke-direct {v2, v4}, Landroid/text/TextPaint;-><init>(Landroid/graphics/Paint;)V

    goto :goto_27

    :cond_26
    move-object v2, v3

    :goto_27
    sget-object v4, Landroid/text/Layout$Alignment;->ALIGN_CENTER:Landroid/text/Layout$Alignment;

    sget-object v5, Lorg/mapsforge/core/graphics/Position;->LEFT:Lorg/mapsforge/core/graphics/Position;

    iget-object v6, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->position:Lorg/mapsforge/core/graphics/Position;

    if-eq v5, v6, :cond_47

    sget-object v5, Lorg/mapsforge/core/graphics/Position;->BELOW_LEFT:Lorg/mapsforge/core/graphics/Position;

    if-eq v5, v6, :cond_47

    sget-object v5, Lorg/mapsforge/core/graphics/Position;->ABOVE_LEFT:Lorg/mapsforge/core/graphics/Position;

    if-ne v5, v6, :cond_38

    goto :goto_47

    :cond_38
    sget-object v5, Lorg/mapsforge/core/graphics/Position;->RIGHT:Lorg/mapsforge/core/graphics/Position;

    if-eq v5, v6, :cond_44

    sget-object v5, Lorg/mapsforge/core/graphics/Position;->BELOW_RIGHT:Lorg/mapsforge/core/graphics/Position;

    if-eq v5, v6, :cond_44

    sget-object v5, Lorg/mapsforge/core/graphics/Position;->ABOVE_RIGHT:Lorg/mapsforge/core/graphics/Position;

    if-ne v5, v6, :cond_49

    :cond_44
    sget-object v4, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    goto :goto_49

    :cond_47
    :goto_47
    sget-object v4, Landroid/text/Layout$Alignment;->ALIGN_OPPOSITE:Landroid/text/Layout$Alignment;

    :cond_49
    :goto_49
    sget-object v5, Landroid/graphics/Paint$Align;->LEFT:Landroid/graphics/Paint$Align;

    invoke-virtual {v1, v5}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    iget-object v5, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    if-eqz v5, :cond_57

    sget-object v5, Landroid/graphics/Paint$Align;->LEFT:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v5}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    :cond_57
    new-instance v5, Landroid/text/StaticLayout;

    iget-object v6, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->text:Ljava/lang/String;

    iget v7, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->maxTextWidth:I

    const/high16 v8, 0x3f800000    # 1.0f

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object p1, v5

    move-object p2, v6

    move-object p3, v1

    move p4, v7

    move-object/from16 p5, v4

    move/from16 p6, v8

    move/from16 p7, v9

    move/from16 p8, v10

    invoke-direct/range {p1 .. p8}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    iput-object v5, v0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->frontLayout:Landroid/text/StaticLayout;

    iput-object v3, v0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->backLayout:Landroid/text/StaticLayout;

    iget-object v1, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    if-eqz v1, :cond_93

    new-instance v1, Landroid/text/StaticLayout;

    iget-object v3, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->text:Ljava/lang/String;

    iget v5, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->maxTextWidth:I

    const/high16 v6, 0x3f800000    # 1.0f

    const/4 v7, 0x0

    const/4 v8, 0x0

    move-object p1, v1

    move-object p2, v3

    move-object p3, v2

    move p4, v5

    move-object/from16 p5, v4

    move/from16 p6, v6

    move/from16 p7, v7

    move/from16 p8, v8

    invoke-direct/range {p1 .. p8}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    iput-object v1, v0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->backLayout:Landroid/text/StaticLayout;

    :cond_93
    iget-object v1, v0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->frontLayout:Landroid/text/StaticLayout;

    invoke-virtual {v1}, Landroid/text/Layout;->getWidth()I

    move-result v1

    int-to-float v1, v1

    iget-object v2, v0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->frontLayout:Landroid/text/StaticLayout;

    invoke-virtual {v2}, Landroid/text/Layout;->getHeight()I

    move-result v2

    goto :goto_a4

    :cond_a1
    int-to-float v1, v1

    iget v2, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->textHeight:I

    :goto_a4
    int-to-float v2, v2

    sget-object v3, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer$1;->$SwitchMap$org$mapsforge$core$graphics$Position:[I

    iget-object v4, v0, Lorg/mapsforge/core/mapelements/PointTextContainer;->position:Lorg/mapsforge/core/graphics/Position;

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aget v3, v3, v4

    const/high16 v4, 0x40000000    # 2.0f

    packed-switch v3, :pswitch_data_17a

    goto/16 :goto_178

    :pswitch_b6
    new-instance v3, Lorg/mapsforge/core/model/Rectangle;

    const-wide/16 v5, 0x0

    neg-float v7, v2

    div-float/2addr v7, v4

    float-to-double v7, v7

    float-to-double v9, v1

    div-float/2addr v2, v4

    float-to-double v1, v2

    move-object p1, v3

    move-wide p2, v5

    move-wide p4, v7

    move-wide/from16 p6, v9

    move-wide/from16 p8, v1

    invoke-direct/range {p1 .. p9}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    goto/16 :goto_176

    :pswitch_cc
    new-instance v3, Lorg/mapsforge/core/model/Rectangle;

    neg-float v1, v1

    float-to-double v5, v1

    neg-float v1, v2

    div-float/2addr v1, v4

    float-to-double v7, v1

    const-wide/16 v9, 0x0

    div-float/2addr v2, v4

    float-to-double v1, v2

    move-object p1, v3

    move-wide p2, v5

    move-wide p4, v7

    move-wide/from16 p6, v9

    move-wide/from16 p8, v1

    invoke-direct/range {p1 .. p9}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    goto/16 :goto_176

    :pswitch_e3
    new-instance v3, Lorg/mapsforge/core/model/Rectangle;

    const-wide/16 v4, 0x0

    neg-float v2, v2

    float-to-double v6, v2

    float-to-double v1, v1

    const-wide/16 v8, 0x0

    move-object p1, v3

    move-wide p2, v4

    move-wide p4, v6

    move-wide/from16 p6, v1

    move-wide/from16 p8, v8

    invoke-direct/range {p1 .. p9}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    goto/16 :goto_176

    :pswitch_f8
    new-instance v3, Lorg/mapsforge/core/model/Rectangle;

    neg-float v1, v1

    float-to-double v4, v1

    neg-float v1, v2

    float-to-double v1, v1

    const-wide/16 v6, 0x0

    const-wide/16 v8, 0x0

    move-object p1, v3

    move-wide p2, v4

    move-wide p4, v1

    move-wide/from16 p6, v6

    move-wide/from16 p8, v8

    invoke-direct/range {p1 .. p9}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    goto/16 :goto_176

    :pswitch_10e
    new-instance v3, Lorg/mapsforge/core/model/Rectangle;

    neg-float v5, v1

    div-float/2addr v5, v4

    float-to-double v5, v5

    neg-float v2, v2

    float-to-double v7, v2

    div-float/2addr v1, v4

    float-to-double v1, v1

    const-wide/16 v9, 0x0

    move-object p1, v3

    move-wide p2, v5

    move-wide p4, v7

    move-wide/from16 p6, v1

    move-wide/from16 p8, v9

    invoke-direct/range {p1 .. p9}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    goto :goto_176

    :pswitch_124
    new-instance v3, Lorg/mapsforge/core/model/Rectangle;

    const-wide/16 v4, 0x0

    const-wide/16 v6, 0x0

    float-to-double v8, v1

    float-to-double v1, v2

    move-object p1, v3

    move-wide p2, v4

    move-wide p4, v6

    move-wide/from16 p6, v8

    move-wide/from16 p8, v1

    invoke-direct/range {p1 .. p9}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    goto :goto_176

    :pswitch_137
    new-instance v3, Lorg/mapsforge/core/model/Rectangle;

    neg-float v1, v1

    float-to-double v4, v1

    const-wide/16 v6, 0x0

    const-wide/16 v8, 0x0

    float-to-double v1, v2

    move-object p1, v3

    move-wide p2, v4

    move-wide p4, v6

    move-wide/from16 p6, v8

    move-wide/from16 p8, v1

    invoke-direct/range {p1 .. p9}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    goto :goto_176

    :pswitch_14b
    new-instance v3, Lorg/mapsforge/core/model/Rectangle;

    neg-float v5, v1

    div-float/2addr v5, v4

    float-to-double v5, v5

    const-wide/16 v7, 0x0

    div-float/2addr v1, v4

    float-to-double v9, v1

    float-to-double v1, v2

    move-object p1, v3

    move-wide p2, v5

    move-wide p4, v7

    move-wide/from16 p6, v9

    move-wide/from16 p8, v1

    invoke-direct/range {p1 .. p9}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    goto :goto_176

    :pswitch_160
    new-instance v3, Lorg/mapsforge/core/model/Rectangle;

    neg-float v5, v1

    div-float/2addr v5, v4

    float-to-double v5, v5

    neg-float v7, v2

    div-float/2addr v7, v4

    float-to-double v7, v7

    div-float/2addr v1, v4

    float-to-double v9, v1

    div-float/2addr v2, v4

    float-to-double v1, v2

    move-object p1, v3

    move-wide p2, v5

    move-wide p4, v7

    move-wide/from16 p6, v9

    move-wide/from16 p8, v1

    invoke-direct/range {p1 .. p9}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    :goto_176
    iput-object v3, v0, Lorg/mapsforge/core/mapelements/MapElementContainer;->boundary:Lorg/mapsforge/core/model/Rectangle;

    :goto_178
    return-void

    nop

    :pswitch_data_17a
    .packed-switch 0x1
        :pswitch_160
        :pswitch_14b
        :pswitch_137
        :pswitch_124
        :pswitch_10e
        :pswitch_f8
        :pswitch_e3
        :pswitch_cc
        :pswitch_b6
    .end packed-switch
.end method


# virtual methods
.method public draw(Lorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Matrix;Lorg/mapsforge/core/graphics/Filter;)V
    .registers 11

    iget-boolean p3, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->isVisible:Z

    if-nez p3, :cond_5

    return-void

    :cond_5
    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getCanvas(Lorg/mapsforge/core/graphics/Canvas;)Landroid/graphics/Canvas;

    move-result-object p1

    iget p3, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->textWidth:I

    iget v0, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->maxTextWidth:I

    if-le p3, v0, :cond_88

    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    iget-object p3, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->xy:Lorg/mapsforge/core/model/Point;

    iget-wide v0, p3, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v2, p2, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v0, v2

    iget-object v2, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->boundary:Lorg/mapsforge/core/model/Rectangle;

    iget-wide v3, v2, Lorg/mapsforge/core/model/Rectangle;->left:D

    add-double/2addr v0, v3

    double-to-float v0, v0

    iget-wide v3, p3, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide p2, p2, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v3, p2

    iget-wide p2, v2, Lorg/mapsforge/core/model/Rectangle;->top:D

    add-double/2addr v3, p2

    double-to-float p2, v3

    invoke-virtual {p1, v0, p2}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object p2, p0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->backLayout:Landroid/text/StaticLayout;

    if-eqz p2, :cond_58

    invoke-virtual {p2}, Landroid/text/Layout;->getPaint()Landroid/text/TextPaint;

    move-result-object p2

    invoke-virtual {p2}, Landroid/graphics/Paint;->getColor()I

    move-result p2

    sget-object p3, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    if-eq p4, p3, :cond_48

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->backLayout:Landroid/text/StaticLayout;

    invoke-virtual {v0}, Landroid/text/Layout;->getPaint()Landroid/text/TextPaint;

    move-result-object v0

    invoke-static {p2, p4}, Lorg/mapsforge/core/graphics/GraphicUtils;->filterColor(ILorg/mapsforge/core/graphics/Filter;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    :cond_48
    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->backLayout:Landroid/text/StaticLayout;

    invoke-virtual {v0, p1}, Landroid/text/Layout;->draw(Landroid/graphics/Canvas;)V

    if-eq p4, p3, :cond_58

    iget-object p3, p0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->backLayout:Landroid/text/StaticLayout;

    invoke-virtual {p3}, Landroid/text/Layout;->getPaint()Landroid/text/TextPaint;

    move-result-object p3

    invoke-virtual {p3, p2}, Landroid/graphics/Paint;->setColor(I)V

    :cond_58
    iget-object p2, p0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->frontLayout:Landroid/text/StaticLayout;

    invoke-virtual {p2}, Landroid/text/Layout;->getPaint()Landroid/text/TextPaint;

    move-result-object p2

    invoke-virtual {p2}, Landroid/graphics/Paint;->getColor()I

    move-result p2

    sget-object p3, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    if-eq p4, p3, :cond_73

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->frontLayout:Landroid/text/StaticLayout;

    invoke-virtual {v0}, Landroid/text/Layout;->getPaint()Landroid/text/TextPaint;

    move-result-object v0

    invoke-static {p2, p4}, Lorg/mapsforge/core/graphics/GraphicUtils;->filterColor(ILorg/mapsforge/core/graphics/Filter;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    :cond_73
    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->frontLayout:Landroid/text/StaticLayout;

    invoke-virtual {v0, p1}, Landroid/text/Layout;->draw(Landroid/graphics/Canvas;)V

    if-eq p4, p3, :cond_83

    iget-object p3, p0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;->frontLayout:Landroid/text/StaticLayout;

    invoke-virtual {p3}, Landroid/text/Layout;->getPaint()Landroid/text/TextPaint;

    move-result-object p3

    invoke-virtual {p3, p2}, Landroid/graphics/Paint;->setColor(I)V

    :cond_83
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    goto/16 :goto_10d

    :cond_88
    const/4 p3, 0x0

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer$1;->$SwitchMap$org$mapsforge$core$graphics$Position:[I

    iget-object v1, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->position:Lorg/mapsforge/core/graphics/Position;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_ac

    const/4 v1, 0x2

    if-eq v0, v1, :cond_a8

    const/4 v1, 0x3

    if-eq v0, v1, :cond_a8

    const/4 v1, 0x4

    if-eq v0, v1, :cond_a8

    const/16 v1, 0x8

    if-eq v0, v1, :cond_ac

    const/16 v1, 0x9

    if-eq v0, v1, :cond_ac

    goto :goto_b2

    :cond_a8
    iget p3, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->textHeight:I

    int-to-float p3, p3

    goto :goto_b2

    :cond_ac
    iget p3, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->textHeight:I

    int-to-float p3, p3

    const/high16 v0, 0x40000000    # 2.0f

    div-float/2addr p3, v0

    :goto_b2
    iget-object v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->xy:Lorg/mapsforge/core/model/Point;

    iget-wide v1, v0, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v3, p2, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v1, v3

    double-to-float v1, v1

    iget-wide v2, v0, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v4, p2, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v2, v4

    double-to-float p2, v2

    add-float/2addr p2, p3

    iget-object p3, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    if-eqz p3, :cond_e8

    invoke-interface {p3}, Lorg/mapsforge/core/graphics/Paint;->getColor()I

    move-result p3

    sget-object v0, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    if-eq p4, v0, :cond_d6

    iget-object v2, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {p3, p4}, Lorg/mapsforge/core/graphics/GraphicUtils;->filterColor(ILorg/mapsforge/core/graphics/Filter;)I

    move-result v3

    invoke-interface {v2, v3}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    :cond_d6
    iget-object v2, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->text:Ljava/lang/String;

    iget-object v3, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {v3}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getPaint(Lorg/mapsforge/core/graphics/Paint;)Landroid/graphics/Paint;

    move-result-object v3

    invoke-virtual {p1, v2, v1, p2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    if-eq p4, v0, :cond_e8

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, p3}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    :cond_e8
    iget-object p3, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p3}, Lorg/mapsforge/core/graphics/Paint;->getColor()I

    move-result p3

    sget-object v0, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    if-eq p4, v0, :cond_fb

    iget-object v2, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {p3, p4}, Lorg/mapsforge/core/graphics/GraphicUtils;->filterColor(ILorg/mapsforge/core/graphics/Filter;)I

    move-result v3

    invoke-interface {v2, v3}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    :cond_fb
    iget-object v2, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->text:Ljava/lang/String;

    iget-object v3, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {v3}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getPaint(Lorg/mapsforge/core/graphics/Paint;)Landroid/graphics/Paint;

    move-result-object v3

    invoke-virtual {p1, v2, v1, p2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    if-eq p4, v0, :cond_10d

    iget-object p1, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1, p3}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    :cond_10d
    :goto_10d
    return-void
.end method
