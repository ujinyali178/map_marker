.class Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/android/graphics/AndroidCanvas;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "HilshadingTemps"
.end annotation


# instance fields
.field private final adr:Landroid/graphics/Rect;

.field private final asr:Landroid/graphics/Rect;

.field private neutralShadingPixel:Landroid/graphics/Bitmap;

.field private scaleTemp:Landroid/graphics/Bitmap;

.field private final shadePaint:Landroid/graphics/Paint;

.field private shiftTemp:Landroid/graphics/Bitmap;

.field private final tmpCanvas:Landroid/graphics/Canvas;

.field private tmpMatrix:Landroid/graphics/Matrix;


# direct methods
.method private constructor <init>()V
    .registers 9

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/graphics/Rect;

    const/4 v1, 0x0

    invoke-direct {v0, v1, v1, v1, v1}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->asr:Landroid/graphics/Rect;

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0, v1, v1, v1, v1}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->adr:Landroid/graphics/Rect;

    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0}, Landroid/graphics/Canvas;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->tmpCanvas:Landroid/graphics/Canvas;

    sget-object v2, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    const/4 v0, 0x1

    new-array v5, v0, [B

    const/16 v3, 0x7f

    aput-byte v3, v5, v1

    const/4 v3, 0x1

    const/4 v4, 0x1

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v7}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->createMonoBitmap(II[BILorg/mapsforge/core/model/BoundingBox;)Lorg/mapsforge/map/android/graphics/AndroidHillshadingBitmap;

    move-result-object v1

    iget-object v1, v1, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    iput-object v1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->neutralShadingPixel:Landroid/graphics/Bitmap;

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->shadePaint:Landroid/graphics/Paint;

    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    return-void
.end method

.method synthetic constructor <init>(Lorg/mapsforge/map/android/graphics/AndroidCanvas$1;)V
    .registers 2

    invoke-direct {p0}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;-><init>()V

    return-void
.end method

.method private internalUseBitmap(Landroid/graphics/Bitmap;IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    .registers 6

    if-nez p1, :cond_c

    :goto_2
    invoke-static {p2, p3, p4}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object p1

    iget-object p2, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->tmpCanvas:Landroid/graphics/Canvas;

    invoke-virtual {p2, p1}, Landroid/graphics/Canvas;->setBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_39

    :cond_c
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    if-lt v0, p2, :cond_35

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    if-lt v0, p3, :cond_35

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_23

    goto :goto_35

    :cond_23
    iget-object p2, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->tmpCanvas:Landroid/graphics/Canvas;

    invoke-virtual {p2, p1}, Landroid/graphics/Canvas;->setBitmap(Landroid/graphics/Bitmap;)V

    iget-object p2, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->tmpCanvas:Landroid/graphics/Canvas;

    const/4 p3, 0x0

    invoke-static {p3, p3, p3, p3}, Landroid/graphics/Color;->argb(IIII)I

    move-result p3

    sget-object p4, Landroid/graphics/PorterDuff$Mode;->SRC:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {p2, p3, p4}, Landroid/graphics/Canvas;->drawColor(ILandroid/graphics/PorterDuff$Mode;)V

    goto :goto_39

    :cond_35
    :goto_35
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->recycle()V

    goto :goto_2

    :goto_39
    return-object p1
.end method


# virtual methods
.method useAdr(IIII)Landroid/graphics/Rect;
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->adr:Landroid/graphics/Rect;

    iput p1, v0, Landroid/graphics/Rect;->left:I

    iput p2, v0, Landroid/graphics/Rect;->top:I

    iput p3, v0, Landroid/graphics/Rect;->right:I

    iput p4, v0, Landroid/graphics/Rect;->bottom:I

    return-object v0
.end method

.method useAlphaPaint(I)Landroid/graphics/Paint;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->shadePaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setAlpha(I)V

    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->shadePaint:Landroid/graphics/Paint;

    return-object p1
.end method

.method useAsr(IIII)Landroid/graphics/Rect;
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->asr:Landroid/graphics/Rect;

    iput p1, v0, Landroid/graphics/Rect;->left:I

    iput p2, v0, Landroid/graphics/Rect;->top:I

    iput p3, v0, Landroid/graphics/Rect;->right:I

    iput p4, v0, Landroid/graphics/Rect;->bottom:I

    return-object v0
.end method

.method useCanvas()Landroid/graphics/Canvas;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->tmpCanvas:Landroid/graphics/Canvas;

    return-object v0
.end method

.method useMatrix()Landroid/graphics/Matrix;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->tmpMatrix:Landroid/graphics/Matrix;

    if-nez v0, :cond_b

    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->tmpMatrix:Landroid/graphics/Matrix;

    :cond_b
    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->tmpMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0}, Landroid/graphics/Matrix;->reset()V

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->tmpMatrix:Landroid/graphics/Matrix;

    return-object v0
.end method

.method useNeutralShadingPixel()Landroid/graphics/Bitmap;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->neutralShadingPixel:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method useScaleBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->scaleTemp:Landroid/graphics/Bitmap;

    invoke-direct {p0, v0, p1, p2, p3}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->internalUseBitmap(Landroid/graphics/Bitmap;IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->scaleTemp:Landroid/graphics/Bitmap;

    return-object p1
.end method

.method useShiftBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->shiftTemp:Landroid/graphics/Bitmap;

    invoke-direct {p0, v0, p1, p2, p3}, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->internalUseBitmap(Landroid/graphics/Bitmap;IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$HilshadingTemps;->shiftTemp:Landroid/graphics/Bitmap;

    return-object p1
.end method
