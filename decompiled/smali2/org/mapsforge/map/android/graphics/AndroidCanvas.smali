.class Lorg/mapsforge/map/android/graphics/AndroidCanvas;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/core/graphics/Canvas;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;
    }
.end annotation


# static fields
.field private static final INVERT_MATRIX:[F


# instance fields
.field private final bitmapPaint:Landroid/graphics/Paint;

.field canvas:Landroid/graphics/Canvas;

.field private grayscaleFilter:Landroid/graphics/ColorFilter;

.field private grayscaleInvertFilter:Landroid/graphics/ColorFilter;

.field private hillshadingTemps:Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;

.field private invertFilter:Landroid/graphics/ColorFilter;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const/16 v0, 0x14

    new-array v0, v0, [F

    fill-array-data v0, :array_a

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->INVERT_MATRIX:[F

    return-void

    :array_a
    .array-data 4
        -0x40800000    # -1.0f
        0x0
        0x0
        0x0
        0x437f0000    # 255.0f
        0x0
        -0x40800000    # -1.0f
        0x0
        0x0
        0x437f0000    # 255.0f
        0x0
        0x0
        -0x40800000    # -1.0f
        0x0
        0x437f0000    # 255.0f
        0x0
        0x0
        0x0
        0x3f800000    # 1.0f
        0x0
    .end array-data
.end method

.method constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    const/4 v1, 0x0

    iput-object v1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->hillshadingTemps:Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;

    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1}, Landroid/graphics/Canvas;-><init>()V

    iput-object v1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    invoke-direct {p0}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->createFilters()V

    return-void
.end method

.method constructor <init>(Landroid/graphics/Canvas;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->hillshadingTemps:Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;

    iput-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-direct {p0}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->createFilters()V

    return-void
.end method

.method private applyFilter(Lorg/mapsforge/core/graphics/Filter;)V
    .registers 3

    sget-object v0, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    if-ne p1, v0, :cond_5

    return-void

    :cond_5
    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$1;->$SwitchMap$org$mapsforge$core$graphics$Filter:[I

    invoke-virtual {p1}, Ljava/lang/Enum;->ordinal()I

    move-result p1

    aget p1, v0, p1

    const/4 v0, 0x1

    if-eq p1, v0, :cond_21

    const/4 v0, 0x2

    if-eq p1, v0, :cond_1c

    const/4 v0, 0x3

    if-eq p1, v0, :cond_17

    goto :goto_28

    :cond_17
    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->invertFilter:Landroid/graphics/ColorFilter;

    goto :goto_25

    :cond_1c
    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->grayscaleInvertFilter:Landroid/graphics/ColorFilter;

    goto :goto_25

    :cond_21
    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->grayscaleFilter:Landroid/graphics/ColorFilter;

    :goto_25
    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    :goto_28
    return-void
.end method

.method private createFilters()V
    .registers 4

    new-instance v0, Landroid/graphics/ColorMatrix;

    invoke-direct {v0}, Landroid/graphics/ColorMatrix;-><init>()V

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/ColorMatrix;->setSaturation(F)V

    new-instance v2, Landroid/graphics/ColorMatrixColorFilter;

    invoke-direct {v2, v0}, Landroid/graphics/ColorMatrixColorFilter;-><init>(Landroid/graphics/ColorMatrix;)V

    iput-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->grayscaleFilter:Landroid/graphics/ColorFilter;

    new-instance v0, Landroid/graphics/ColorMatrix;

    invoke-direct {v0}, Landroid/graphics/ColorMatrix;-><init>()V

    invoke-virtual {v0, v1}, Landroid/graphics/ColorMatrix;->setSaturation(F)V

    new-instance v1, Landroid/graphics/ColorMatrix;

    sget-object v2, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->INVERT_MATRIX:[F

    invoke-direct {v1, v2}, Landroid/graphics/ColorMatrix;-><init>([F)V

    invoke-virtual {v0, v1}, Landroid/graphics/ColorMatrix;->postConcat(Landroid/graphics/ColorMatrix;)V

    new-instance v1, Landroid/graphics/ColorMatrixColorFilter;

    invoke-direct {v1, v0}, Landroid/graphics/ColorMatrixColorFilter;-><init>(Landroid/graphics/ColorMatrix;)V

    iput-object v1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->grayscaleInvertFilter:Landroid/graphics/ColorFilter;

    new-instance v0, Landroid/graphics/ColorMatrixColorFilter;

    invoke-direct {v0, v2}, Landroid/graphics/ColorMatrixColorFilter;-><init>([F)V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->invertFilter:Landroid/graphics/ColorFilter;

    return-void
.end method

.method private setClipInternal(IIIILandroid/graphics/Region$Op;)V
    .registers 12

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    int-to-float v1, p1

    int-to-float v2, p2

    add-int/2addr p1, p3

    int-to-float v3, p1

    add-int/2addr p2, p4

    int-to-float v4, p2

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->clipRect(FFFFLandroid/graphics/Region$Op;)Z

    return-void
.end method


# virtual methods
.method public destroy()V
    .registers 2

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    return-void
.end method

.method public drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;II)V
    .registers 7

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getBitmap(Lorg/mapsforge/core/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object p1

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->MONO_ALPHA_BITMAP:Landroid/graphics/Bitmap$Config;

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1c

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    const/4 v1, 0x0

    invoke-static {v1, v1, v1, v1}, Landroid/graphics/Color;->argb(IIII)I

    move-result v1

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->drawColor(ILandroid/graphics/PorterDuff$Mode;)V

    :cond_1c
    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    int-to-float p2, p2

    int-to-float p3, p3

    iget-object v1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1, p2, p3, v1}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    return-void
.end method

.method public drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;IIFLorg/mapsforge/core/graphics/Filter;)V
    .registers 10

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getAlpha()I

    move-result v0

    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v1, p4, v1

    if-eqz v1, :cond_16

    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    const/high16 v3, 0x437f0000    # 255.0f

    mul-float p4, p4, v3

    float-to-int p4, p4

    invoke-virtual {v2, p4}, Landroid/graphics/Paint;->setAlpha(I)V

    :cond_16
    invoke-direct {p0, p5}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->applyFilter(Lorg/mapsforge/core/graphics/Filter;)V

    iget-object p4, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getBitmap(Lorg/mapsforge/core/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object p1

    int-to-float p2, p2

    int-to-float p3, p3

    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p4, p1, p2, p3, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    sget-object p1, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    if-eq p5, p1, :cond_30

    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    const/4 p2, 0x0

    invoke-virtual {p1, p2}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    :cond_30
    if-eqz v1, :cond_37

    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setAlpha(I)V

    :cond_37
    return-void
.end method

.method public drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;IIIIIIII)V
    .registers 12

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getBitmap(Lorg/mapsforge/core/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object p1

    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1, p2, p3, p4, p5}, Landroid/graphics/Rect;-><init>(IIII)V

    new-instance p2, Landroid/graphics/Rect;

    invoke-direct {p2, p6, p7, p8, p9}, Landroid/graphics/Rect;-><init>(IIII)V

    iget-object p3, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1, v1, p2, p3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;IIIIIIIIFLorg/mapsforge/core/graphics/Filter;)V
    .registers 16

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getAlpha()I

    move-result v0

    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v1, p10, v1

    if-eqz v1, :cond_16

    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    const/high16 v3, 0x437f0000    # 255.0f

    mul-float p10, p10, v3

    float-to-int p10, p10

    invoke-virtual {v2, p10}, Landroid/graphics/Paint;->setAlpha(I)V

    :cond_16
    invoke-direct {p0, p11}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->applyFilter(Lorg/mapsforge/core/graphics/Filter;)V

    iget-object p10, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getBitmap(Lorg/mapsforge/core/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object p1

    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2, p2, p3, p4, p5}, Landroid/graphics/Rect;-><init>(IIII)V

    new-instance p2, Landroid/graphics/Rect;

    invoke-direct {p2, p6, p7, p8, p9}, Landroid/graphics/Rect;-><init>(IIII)V

    iget-object p3, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p10, p1, v2, p2, p3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    sget-object p1, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    if-eq p11, p1, :cond_38

    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    const/4 p2, 0x0

    invoke-virtual {p1, p2}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    :cond_38
    if-eqz v1, :cond_3f

    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setAlpha(I)V

    :cond_3f
    return-void
.end method

.method public drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/core/graphics/Matrix;)V
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getBitmap(Lorg/mapsforge/core/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object p1

    invoke-static {p2}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getMatrix(Lorg/mapsforge/core/graphics/Matrix;)Landroid/graphics/Matrix;

    move-result-object p2

    iget-object v1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1, p2, v1}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/core/graphics/Matrix;FLorg/mapsforge/core/graphics/Filter;)V
    .registers 9

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getAlpha()I

    move-result v0

    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v1, p3, v1

    if-eqz v1, :cond_16

    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    const/high16 v3, 0x437f0000    # 255.0f

    mul-float p3, p3, v3

    float-to-int p3, p3

    invoke-virtual {v2, p3}, Landroid/graphics/Paint;->setAlpha(I)V

    :cond_16
    invoke-direct {p0, p4}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->applyFilter(Lorg/mapsforge/core/graphics/Filter;)V

    iget-object p3, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getBitmap(Lorg/mapsforge/core/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object p1

    invoke-static {p2}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getMatrix(Lorg/mapsforge/core/graphics/Matrix;)Landroid/graphics/Matrix;

    move-result-object p2

    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p3, p1, p2, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    sget-object p1, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    if-eq p4, p1, :cond_32

    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    const/4 p2, 0x0

    invoke-virtual {p1, p2}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    :cond_32
    if-eqz v1, :cond_39

    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setAlpha(I)V

    :cond_39
    return-void
.end method

.method public drawCircle(IIILorg/mapsforge/core/graphics/Paint;)V
    .registers 6

    invoke-interface {p4}, Lorg/mapsforge/core/graphics/Paint;->isTransparent()Z

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    int-to-float p1, p1

    int-to-float p2, p2

    int-to-float p3, p3

    invoke-static {p4}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getPaint(Lorg/mapsforge/core/graphics/Paint;)Landroid/graphics/Paint;

    move-result-object p4

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    return-void
.end method

.method public drawLine(IIIILorg/mapsforge/core/graphics/Paint;)V
    .registers 13

    invoke-interface {p5}, Lorg/mapsforge/core/graphics/Paint;->isTransparent()Z

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-object v1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    int-to-float v2, p1

    int-to-float v3, p2

    int-to-float v4, p3

    int-to-float v5, p4

    invoke-static {p5}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getPaint(Lorg/mapsforge/core/graphics/Paint;)Landroid/graphics/Paint;

    move-result-object v6

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    return-void
.end method

.method public drawPath(Lorg/mapsforge/core/graphics/Path;Lorg/mapsforge/core/graphics/Paint;)V
    .registers 4

    invoke-interface {p2}, Lorg/mapsforge/core/graphics/Paint;->isTransparent()Z

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getPath(Lorg/mapsforge/core/graphics/Path;)Landroid/graphics/Path;

    move-result-object p1

    invoke-static {p2}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getPaint(Lorg/mapsforge/core/graphics/Paint;)Landroid/graphics/Paint;

    move-result-object p2

    invoke-virtual {v0, p1, p2}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    return-void
.end method

.method public drawPathText(Ljava/lang/String;Lorg/mapsforge/core/graphics/Path;Lorg/mapsforge/core/graphics/Paint;)V
    .registers 11

    if-eqz p1, :cond_2b

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_d

    goto :goto_2b

    :cond_d
    invoke-interface {p3}, Lorg/mapsforge/core/graphics/Paint;->isTransparent()Z

    move-result v0

    if-eqz v0, :cond_14

    return-void

    :cond_14
    invoke-static {p3}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getPaint(Lorg/mapsforge/core/graphics/Paint;)Landroid/graphics/Paint;

    move-result-object v6

    iget-object v1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-static {p2}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getPath(Lorg/mapsforge/core/graphics/Path;)Landroid/graphics/Path;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v6}, Landroid/graphics/Paint;->getTextSize()F

    move-result p2

    const/high16 p3, 0x40800000    # 4.0f

    div-float v5, p2, p3

    move-object v2, p1

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawTextOnPath(Ljava/lang/String;Landroid/graphics/Path;FFLandroid/graphics/Paint;)V

    :cond_2b
    :goto_2b
    return-void
.end method

.method public drawText(Ljava/lang/String;IILorg/mapsforge/core/graphics/Paint;)V
    .registers 6

    if-eqz p1, :cond_1f

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_d

    goto :goto_1f

    :cond_d
    invoke-interface {p4}, Lorg/mapsforge/core/graphics/Paint;->isTransparent()Z

    move-result v0

    if-eqz v0, :cond_14

    return-void

    :cond_14
    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    int-to-float p2, p2

    int-to-float p3, p3

    invoke-static {p4}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getPaint(Lorg/mapsforge/core/graphics/Paint;)Landroid/graphics/Paint;

    move-result-object p4

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    :cond_1f
    :goto_1f
    return-void
.end method

.method public drawTextRotated(Ljava/lang/String;IIIILorg/mapsforge/core/graphics/Paint;)V
    .registers 14

    if-eqz p1, :cond_30

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_d

    goto :goto_30

    :cond_d
    invoke-interface {p6}, Lorg/mapsforge/core/graphics/Paint;->isTransparent()Z

    move-result v0

    if-eqz v0, :cond_14

    return-void

    :cond_14
    new-instance v3, Landroid/graphics/Path;

    invoke-direct {v3}, Landroid/graphics/Path;-><init>()V

    int-to-float p2, p2

    int-to-float p3, p3

    invoke-virtual {v3, p2, p3}, Landroid/graphics/Path;->moveTo(FF)V

    int-to-float p2, p4

    int-to-float p3, p5

    invoke-virtual {v3, p2, p3}, Landroid/graphics/Path;->lineTo(FF)V

    iget-object v1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    const/4 v4, 0x0

    const/high16 v5, 0x40400000    # 3.0f

    invoke-static {p6}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getPaint(Lorg/mapsforge/core/graphics/Paint;)Landroid/graphics/Paint;

    move-result-object v6

    move-object v2, p1

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawTextOnPath(Ljava/lang/String;Landroid/graphics/Path;FFLandroid/graphics/Paint;)V

    :cond_30
    :goto_30
    return-void
.end method

.method public fillColor(I)V
    .registers 4

    shr-int/lit8 v0, p1, 0x18

    and-int/lit16 v0, v0, 0xff

    iget-object v1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    if-nez v0, :cond_b

    sget-object v0, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    goto :goto_d

    :cond_b
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->SRC_OVER:Landroid/graphics/PorterDuff$Mode;

    :goto_d
    invoke-virtual {v1, p1, v0}, Landroid/graphics/Canvas;->drawColor(ILandroid/graphics/PorterDuff$Mode;)V

    return-void
.end method

.method public fillColor(Lorg/mapsforge/core/graphics/Color;)V
    .registers 2

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getColor(Lorg/mapsforge/core/graphics/Color;)I

    move-result p1

    invoke-virtual {p0, p1}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->fillColor(I)V

    return-void
.end method

.method public getDimension()Lorg/mapsforge/core/model/Dimension;
    .registers 4

    new-instance v0, Lorg/mapsforge/core/model/Dimension;

    invoke-virtual {p0}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->getWidth()I

    move-result v1

    invoke-virtual {p0}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->getHeight()I

    move-result v2

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/core/model/Dimension;-><init>(II)V

    return-object v0
.end method

.method public getHeight()I
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {v0}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    return v0
.end method

.method public getWidth()I
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {v0}, Landroid/graphics/Canvas;->getWidth()I

    move-result v0

    return v0
.end method

.method public isAntiAlias()Z
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->isAntiAlias()Z

    move-result v0

    return v0
.end method

.method public isFilterBitmap()Z
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->isFilterBitmap()Z

    move-result v0

    return v0
.end method

.method public resetClip()V
    .registers 9

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-ge v0, v1, :cond_19

    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {p0}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->getWidth()I

    move-result v0

    int-to-float v5, v0

    invoke-virtual {p0}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->getHeight()I

    move-result v0

    int-to-float v6, v0

    sget-object v7, Landroid/graphics/Region$Op;->REPLACE:Landroid/graphics/Region$Op;

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->clipRect(FFFFLandroid/graphics/Region$Op;)Z

    :cond_19
    return-void
.end method

.method public setAntiAlias(Z)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    return-void
.end method

.method public setBitmap(Lorg/mapsforge/core/graphics/Bitmap;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getBitmap(Lorg/mapsforge/core/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/graphics/Canvas;->setBitmap(Landroid/graphics/Bitmap;)V

    return-void
.end method

.method public setClip(IIII)V
    .registers 11

    const/4 v5, 0x0

    move-object v0, p0

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-virtual/range {v0 .. v5}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->setClip(IIIIZ)V

    return-void
.end method

.method public setClip(IIIIZ)V
    .registers 12

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_10

    if-eqz p5, :cond_1a

    iget-object p5, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    add-int/2addr p3, p1

    add-int/2addr p4, p2

    invoke-virtual {p5, p1, p2, p3, p4}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    goto :goto_1a

    :cond_10
    sget-object v5, Landroid/graphics/Region$Op;->REPLACE:Landroid/graphics/Region$Op;

    move-object v0, p0

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-direct/range {v0 .. v5}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->setClipInternal(IIIILandroid/graphics/Region$Op;)V

    :cond_1a
    :goto_1a
    return-void
.end method

.method public setClipDifference(IIII)V
    .registers 12

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_e

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    add-int/2addr p3, p1

    add-int/2addr p4, p2

    invoke-static {v0, p1, p2, p3, p4}, Lorg/mapsforge/map/android/graphics/a;->a(Landroid/graphics/Canvas;IIII)Z

    goto :goto_18

    :cond_e
    sget-object v6, Landroid/graphics/Region$Op;->DIFFERENCE:Landroid/graphics/Region$Op;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v1 .. v6}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->setClipInternal(IIIILandroid/graphics/Region$Op;)V

    :goto_18
    return-void
.end method

.method public setFilterBitmap(Z)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    return-void
.end method

.method public shadeBitmap(Lorg/mapsforge/core/graphics/Bitmap;Lorg/mapsforge/core/model/Rectangle;Lorg/mapsforge/core/model/Rectangle;F)V
    .registers 33

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    iget-object v3, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {v3}, Landroid/graphics/Canvas;->save()I

    iget-object v3, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->hillshadingTemps:Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;

    const/4 v4, 0x0

    if-nez v3, :cond_17

    new-instance v3, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;

    invoke-direct {v3, v4}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;-><init>(Lorg/mapsforge/map/android/graphics/AndroidCanvas$1;)V

    iput-object v3, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->hillshadingTemps:Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;

    :cond_17
    iget-object v3, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->hillshadingTemps:Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;

    const/high16 v5, 0x437f0000    # 255.0f

    mul-float v5, v5, p4

    float-to-int v5, v5

    invoke-virtual {v3, v5}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->useAlphaPaint(I)Landroid/graphics/Paint;

    move-result-object v5

    const/16 v6, 0x1a

    const/4 v7, 0x0

    if-nez p1, :cond_7c

    if-eqz v2, :cond_52

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v1, v6, :cond_3f

    iget-object v1, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    iget-wide v3, v2, Lorg/mapsforge/core/model/Rectangle;->left:D

    double-to-float v3, v3

    iget-wide v8, v2, Lorg/mapsforge/core/model/Rectangle;->top:D

    double-to-float v4, v8

    iget-wide v8, v2, Lorg/mapsforge/core/model/Rectangle;->right:D

    double-to-float v6, v8

    iget-wide v8, v2, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    double-to-float v2, v8

    invoke-virtual {v1, v3, v4, v6, v2}, Landroid/graphics/Canvas;->clipRect(FFFF)Z

    goto :goto_52

    :cond_3f
    iget-object v8, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    iget-wide v3, v2, Lorg/mapsforge/core/model/Rectangle;->left:D

    double-to-float v9, v3

    iget-wide v3, v2, Lorg/mapsforge/core/model/Rectangle;->top:D

    double-to-float v10, v3

    iget-wide v3, v2, Lorg/mapsforge/core/model/Rectangle;->right:D

    double-to-float v11, v3

    iget-wide v1, v2, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    double-to-float v12, v1

    sget-object v13, Landroid/graphics/Region$Op;->REPLACE:Landroid/graphics/Region$Op;

    invoke-virtual/range {v8 .. v13}, Landroid/graphics/Canvas;->clipRect(FFFFLandroid/graphics/Region$Op;)Z

    :cond_52
    :goto_52
    iget-object v1, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    iget-object v2, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->hillshadingTemps:Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;

    invoke-virtual {v2}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->useNeutralShadingPixel()Landroid/graphics/Bitmap;

    move-result-object v2

    iget-object v3, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->hillshadingTemps:Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;

    const/4 v4, 0x1

    invoke-virtual {v3, v7, v7, v4, v4}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->useAsr(IIII)Landroid/graphics/Rect;

    move-result-object v3

    iget-object v4, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->hillshadingTemps:Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;

    iget-object v6, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {v6}, Landroid/graphics/Canvas;->getWidth()I

    move-result v6

    iget-object v8, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {v8}, Landroid/graphics/Canvas;->getHeight()I

    move-result v8

    invoke-virtual {v4, v7, v7, v6, v8}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->useAdr(IIII)Landroid/graphics/Rect;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    :goto_76
    iget-object v1, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {v1}, Landroid/graphics/Canvas;->restore()V

    return-void

    :cond_7c
    invoke-static/range {p1 .. p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getBitmap(Lorg/mapsforge/core/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v8

    invoke-virtual/range {p3 .. p3}, Lorg/mapsforge/core/model/Rectangle;->getWidth()D

    move-result-wide v9

    invoke-virtual/range {p2 .. p2}, Lorg/mapsforge/core/model/Rectangle;->getWidth()D

    move-result-wide v11

    div-double/2addr v9, v11

    invoke-virtual/range {p3 .. p3}, Lorg/mapsforge/core/model/Rectangle;->getHeight()D

    move-result-wide v11

    invoke-virtual/range {p2 .. p2}, Lorg/mapsforge/core/model/Rectangle;->getHeight()D

    move-result-wide v13

    div-double/2addr v11, v13

    const-wide/high16 v13, 0x3ff0000000000000L    # 1.0

    cmpg-double v15, v9, v13

    if-gez v15, :cond_f0

    cmpg-double v15, v11, v13

    if-gez v15, :cond_f0

    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v4, v6, :cond_b2

    iget-object v4, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    iget-wide v6, v2, Lorg/mapsforge/core/model/Rectangle;->left:D

    double-to-float v6, v6

    iget-wide v13, v2, Lorg/mapsforge/core/model/Rectangle;->top:D

    double-to-float v7, v13

    iget-wide v13, v2, Lorg/mapsforge/core/model/Rectangle;->right:D

    double-to-float v13, v13

    iget-wide v14, v2, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    double-to-float v14, v14

    invoke-virtual {v4, v6, v7, v13, v14}, Landroid/graphics/Canvas;->clipRect(FFFF)Z

    goto :goto_cd

    :cond_b2
    iget-object v15, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    iget-wide v6, v2, Lorg/mapsforge/core/model/Rectangle;->left:D

    double-to-float v4, v6

    iget-wide v6, v2, Lorg/mapsforge/core/model/Rectangle;->top:D

    double-to-float v6, v6

    iget-wide v13, v2, Lorg/mapsforge/core/model/Rectangle;->right:D

    double-to-float v7, v13

    iget-wide v13, v2, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    double-to-float v13, v13

    sget-object v20, Landroid/graphics/Region$Op;->REPLACE:Landroid/graphics/Region$Op;

    move/from16 v16, v4

    move/from16 v17, v6

    move/from16 v18, v7

    move/from16 v19, v13

    invoke-virtual/range {v15 .. v20}, Landroid/graphics/Canvas;->clipRect(FFFFLandroid/graphics/Region$Op;)Z

    :goto_cd
    invoke-virtual {v3}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->useMatrix()Landroid/graphics/Matrix;

    move-result-object v3

    iget-wide v6, v2, Lorg/mapsforge/core/model/Rectangle;->left:D

    double-to-float v4, v6

    iget-wide v6, v2, Lorg/mapsforge/core/model/Rectangle;->top:D

    double-to-float v2, v6

    invoke-virtual {v3, v4, v2}, Landroid/graphics/Matrix;->preTranslate(FF)Z

    double-to-float v2, v9

    double-to-float v4, v11

    invoke-virtual {v3, v2, v4}, Landroid/graphics/Matrix;->preScale(FF)Z

    iget-wide v6, v1, Lorg/mapsforge/core/model/Rectangle;->left:D

    neg-double v6, v6

    double-to-float v2, v6

    iget-wide v6, v1, Lorg/mapsforge/core/model/Rectangle;->top:D

    neg-double v6, v6

    double-to-float v1, v6

    invoke-virtual {v3, v2, v1}, Landroid/graphics/Matrix;->preTranslate(FF)Z

    iget-object v1, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {v1, v8, v3, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    goto :goto_76

    :cond_f0
    move-object/from16 p4, v5

    iget-wide v4, v1, Lorg/mapsforge/core/model/Rectangle;->left:D

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v15

    sub-double/2addr v4, v15

    add-double/2addr v4, v13

    iget-wide v6, v1, Lorg/mapsforge/core/model/Rectangle;->left:D

    invoke-static {v6, v7, v4, v5}, Ljava/lang/Math;->min(DD)D

    move-result-wide v4

    mul-double v6, v9, v4

    iget-wide v13, v1, Lorg/mapsforge/core/model/Rectangle;->right:D

    invoke-static {v13, v14}, Ljava/lang/Math;->floor(D)D

    move-result-wide v13

    const-wide/high16 v19, 0x4000000000000000L    # 2.0

    add-double v13, v13, v19

    move-object/from16 v21, v3

    iget-wide v2, v1, Lorg/mapsforge/core/model/Rectangle;->right:D

    sub-double/2addr v13, v2

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result v2

    int-to-double v2, v2

    move-wide/from16 v22, v4

    iget-wide v4, v1, Lorg/mapsforge/core/model/Rectangle;->right:D

    sub-double/2addr v2, v4

    invoke-static {v2, v3, v13, v14}, Ljava/lang/Math;->min(DD)D

    move-result-wide v2

    mul-double v4, v9, v2

    add-double/2addr v4, v6

    iget-wide v13, v1, Lorg/mapsforge/core/model/Rectangle;->right:D

    move-wide/from16 v24, v6

    iget-wide v6, v1, Lorg/mapsforge/core/model/Rectangle;->left:D

    sub-double/2addr v13, v6

    mul-double v13, v13, v9

    add-double/2addr v4, v13

    invoke-static {v4, v5}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v4

    double-to-int v4, v4

    iget-wide v5, v1, Lorg/mapsforge/core/model/Rectangle;->top:D

    invoke-static {v5, v6}, Ljava/lang/Math;->floor(D)D

    move-result-wide v9

    sub-double/2addr v5, v9

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    add-double/2addr v5, v9

    iget-wide v9, v1, Lorg/mapsforge/core/model/Rectangle;->top:D

    invoke-static {v9, v10, v5, v6}, Ljava/lang/Math;->min(DD)D

    move-result-wide v5

    mul-double v9, v11, v5

    iget-wide v13, v1, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    invoke-static {v13, v14}, Ljava/lang/Math;->floor(D)D

    move-result-wide v13

    add-double v13, v13, v19

    move-object/from16 v17, v8

    iget-wide v7, v1, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    sub-double/2addr v13, v7

    invoke-interface/range {p1 .. p1}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result v7

    int-to-double v7, v7

    move-wide/from16 v18, v2

    iget-wide v2, v1, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    sub-double/2addr v7, v2

    invoke-static {v7, v8, v13, v14}, Ljava/lang/Math;->min(DD)D

    move-result-wide v2

    mul-double v7, v11, v2

    add-double/2addr v7, v9

    iget-wide v13, v1, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    move-wide/from16 v26, v9

    iget-wide v9, v1, Lorg/mapsforge/core/model/Rectangle;->top:D

    sub-double/2addr v13, v9

    mul-double v13, v13, v11

    add-double/2addr v7, v13

    invoke-static {v7, v8}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v7

    double-to-int v7, v7

    iget-wide v8, v1, Lorg/mapsforge/core/model/Rectangle;->left:D

    sub-double v8, v8, v22

    invoke-static {v8, v9}, Ljava/lang/Math;->round(D)J

    move-result-wide v8

    long-to-int v9, v8

    iget-wide v10, v1, Lorg/mapsforge/core/model/Rectangle;->top:D

    sub-double/2addr v10, v5

    invoke-static {v10, v11}, Ljava/lang/Math;->round(D)J

    move-result-wide v5

    long-to-int v6, v5

    iget-wide v10, v1, Lorg/mapsforge/core/model/Rectangle;->right:D

    add-double v10, v10, v18

    invoke-static {v10, v11}, Ljava/lang/Math;->round(D)J

    move-result-wide v10

    long-to-int v5, v10

    iget-wide v10, v1, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    add-double/2addr v10, v2

    invoke-static {v10, v11}, Ljava/lang/Math;->round(D)J

    move-result-wide v1

    long-to-int v2, v1

    invoke-virtual/range {v21 .. v21}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->useCanvas()Landroid/graphics/Canvas;

    move-result-object v1

    if-nez v9, :cond_1b3

    if-nez v6, :cond_1b3

    add-int/lit8 v5, v5, 0x1

    invoke-virtual/range {v17 .. v17}, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v3

    invoke-static {v5, v2, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/graphics/Canvas;->setBitmap(Landroid/graphics/Bitmap;)V

    const/high16 v8, 0x3f800000    # 1.0f

    const/4 v10, 0x0

    move-object/from16 v11, v17

    const/4 v12, 0x0

    invoke-virtual {v1, v11, v8, v10, v12}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    add-int/lit8 v9, v9, 0x1

    goto :goto_1b6

    :cond_1b3
    move-object/from16 v11, v17

    move-object v3, v11

    :goto_1b6
    move-object/from16 v8, v21

    invoke-virtual {v8, v9, v6, v5, v2}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->useAsr(IIII)Landroid/graphics/Rect;

    move-result-object v2

    const/4 v5, 0x0

    invoke-virtual {v8, v5, v5, v4, v7}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->useAdr(IIII)Landroid/graphics/Rect;

    move-result-object v5

    invoke-virtual {v11}, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v6

    invoke-virtual {v8, v4, v7, v6}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->useScaleBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/graphics/Canvas;->setBitmap(Landroid/graphics/Bitmap;)V

    iget-object v6, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->bitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v1, v3, v2, v5, v6}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    iget-object v1, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    move-object/from16 v2, p3

    iget-wide v5, v2, Lorg/mapsforge/core/model/Rectangle;->left:D

    double-to-float v3, v5

    iget-wide v5, v2, Lorg/mapsforge/core/model/Rectangle;->top:D

    double-to-float v5, v5

    iget-wide v6, v2, Lorg/mapsforge/core/model/Rectangle;->right:D

    double-to-float v6, v6

    iget-wide v7, v2, Lorg/mapsforge/core/model/Rectangle;->bottom:D

    double-to-float v7, v7

    invoke-virtual {v1, v3, v5, v6, v7}, Landroid/graphics/Canvas;->clipRect(FFFF)Z

    iget-wide v5, v2, Lorg/mapsforge/core/model/Rectangle;->left:D

    sub-double v5, v5, v24

    invoke-static {v5, v6}, Ljava/lang/Math;->round(D)J

    move-result-wide v5

    long-to-int v1, v5

    iget-wide v2, v2, Lorg/mapsforge/core/model/Rectangle;->top:D

    sub-double v2, v2, v26

    invoke-static {v2, v3}, Ljava/lang/Math;->round(D)J

    move-result-wide v2

    long-to-int v3, v2

    iget-object v2, v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    int-to-float v1, v1

    int-to-float v3, v3

    move-object/from16 v5, p4

    invoke-virtual {v2, v4, v1, v3, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_76
.end method
