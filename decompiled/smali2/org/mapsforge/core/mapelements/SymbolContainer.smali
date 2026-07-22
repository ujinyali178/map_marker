.class public Lorg/mapsforge/core/mapelements/SymbolContainer;
.super Lorg/mapsforge/core/mapelements/MapElementContainer;
.source "SourceFile"


# instance fields
.field final alignCenter:Z

.field public symbol:Lorg/mapsforge/core/graphics/Bitmap;

.field public final theta:F


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILorg/mapsforge/core/graphics/Bitmap;)V
    .registers 12

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v6}, Lorg/mapsforge/core/mapelements/SymbolContainer;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILorg/mapsforge/core/graphics/Bitmap;FZ)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILorg/mapsforge/core/graphics/Bitmap;FZ)V
    .registers 30

    move-object/from16 v0, p0

    move/from16 v1, p6

    invoke-direct/range {p0 .. p3}, Lorg/mapsforge/core/mapelements/MapElementContainer;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;I)V

    move-object/from16 v2, p4

    iput-object v2, v0, Lorg/mapsforge/core/mapelements/SymbolContainer;->symbol:Lorg/mapsforge/core/graphics/Bitmap;

    move/from16 v3, p5

    iput v3, v0, Lorg/mapsforge/core/mapelements/SymbolContainer;->theta:F

    iput-boolean v1, v0, Lorg/mapsforge/core/mapelements/SymbolContainer;->alignCenter:Z

    if-eqz v1, :cond_2e

    invoke-interface/range {p4 .. p4}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result v1

    int-to-double v1, v1

    const-wide/high16 v3, 0x4000000000000000L    # 2.0

    div-double v10, v1, v3

    iget-object v1, v0, Lorg/mapsforge/core/mapelements/SymbolContainer;->symbol:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v1}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result v1

    int-to-double v1, v1

    div-double v12, v1, v3

    new-instance v1, Lorg/mapsforge/core/model/Rectangle;

    neg-double v6, v10

    neg-double v8, v12

    move-object v5, v1

    invoke-direct/range {v5 .. v13}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    goto :goto_48

    :cond_2e
    new-instance v1, Lorg/mapsforge/core/model/Rectangle;

    const-wide/16 v15, 0x0

    const-wide/16 v17, 0x0

    invoke-interface/range {p4 .. p4}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result v2

    int-to-double v2, v2

    iget-object v4, v0, Lorg/mapsforge/core/mapelements/SymbolContainer;->symbol:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v4}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result v4

    int-to-double v4, v4

    move-object v14, v1

    move-wide/from16 v19, v2

    move-wide/from16 v21, v4

    invoke-direct/range {v14 .. v22}, Lorg/mapsforge/core/model/Rectangle;-><init>(DDDD)V

    :goto_48
    iput-object v1, v0, Lorg/mapsforge/core/mapelements/MapElementContainer;->boundary:Lorg/mapsforge/core/model/Rectangle;

    iget-object v1, v0, Lorg/mapsforge/core/mapelements/SymbolContainer;->symbol:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v1}, Lorg/mapsforge/core/graphics/Bitmap;->incrementRefCount()V

    return-void
.end method


# virtual methods
.method public draw(Lorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Matrix;Lorg/mapsforge/core/graphics/Filter;)V
    .registers 13

    invoke-interface {p3}, Lorg/mapsforge/core/graphics/Matrix;->reset()V

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->xy:Lorg/mapsforge/core/model/Point;

    iget-wide v1, v0, Lorg/mapsforge/core/model/Point;->x:D

    iget-wide v3, p2, Lorg/mapsforge/core/model/Point;->x:D

    sub-double/2addr v1, v3

    iget-object v3, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->boundary:Lorg/mapsforge/core/model/Rectangle;

    iget-wide v4, v3, Lorg/mapsforge/core/model/Rectangle;->left:D

    add-double/2addr v1, v4

    double-to-int v1, v1

    int-to-float v1, v1

    iget-wide v4, v0, Lorg/mapsforge/core/model/Point;->y:D

    iget-wide v6, p2, Lorg/mapsforge/core/model/Point;->y:D

    sub-double/2addr v4, v6

    iget-wide v2, v3, Lorg/mapsforge/core/model/Rectangle;->top:D

    add-double/2addr v4, v2

    double-to-int p2, v4

    int-to-float p2, p2

    invoke-interface {p3, v1, p2}, Lorg/mapsforge/core/graphics/Matrix;->translate(FF)V

    iget p2, p0, Lorg/mapsforge/core/mapelements/SymbolContainer;->theta:F

    const/4 v0, 0x0

    cmpl-float v0, p2, v0

    if-eqz v0, :cond_37

    iget-boolean v0, p0, Lorg/mapsforge/core/mapelements/SymbolContainer;->alignCenter:Z

    if-eqz v0, :cond_37

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->boundary:Lorg/mapsforge/core/model/Rectangle;

    iget-wide v1, v0, Lorg/mapsforge/core/model/Rectangle;->left:D

    neg-double v1, v1

    double-to-float v1, v1

    iget-wide v2, v0, Lorg/mapsforge/core/model/Rectangle;->top:D

    neg-double v2, v2

    double-to-float v0, v2

    invoke-interface {p3, p2, v1, v0}, Lorg/mapsforge/core/graphics/Matrix;->rotate(FFF)V

    goto :goto_3a

    :cond_37
    invoke-interface {p3, p2}, Lorg/mapsforge/core/graphics/Matrix;->rotate(F)V

    :goto_3a
    iget-object p2, p0, Lorg/mapsforge/core/mapelements/SymbolContainer;->symbol:Lorg/mapsforge/core/graphics/Bitmap;

    const/high16 v0, 0x3f800000    # 1.0f

    invoke-interface {p1, p2, p3, v0, p4}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/core/graphics/Matrix;FLorg/mapsforge/core/graphics/Filter;)V

    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 4

    invoke-super {p0, p1}, Lorg/mapsforge/core/mapelements/MapElementContainer;->equals(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_8

    return v1

    :cond_8
    instance-of v0, p1, Lorg/mapsforge/core/mapelements/SymbolContainer;

    if-nez v0, :cond_d

    return v1

    :cond_d
    check-cast p1, Lorg/mapsforge/core/mapelements/SymbolContainer;

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/SymbolContainer;->symbol:Lorg/mapsforge/core/graphics/Bitmap;

    iget-object p1, p1, Lorg/mapsforge/core/mapelements/SymbolContainer;->symbol:Lorg/mapsforge/core/graphics/Bitmap;

    if-eq v0, p1, :cond_16

    return v1

    :cond_16
    const/4 p1, 0x1

    return p1
.end method

.method public hashCode()I
    .registers 3

    invoke-super {p0}, Lorg/mapsforge/core/mapelements/MapElementContainer;->hashCode()I

    move-result v0

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lorg/mapsforge/core/mapelements/SymbolContainer;->symbol:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method
