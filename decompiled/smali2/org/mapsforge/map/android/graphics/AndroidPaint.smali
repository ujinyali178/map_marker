.class Lorg/mapsforge/map/android/graphics/AndroidPaint;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/core/graphics/Paint;


# instance fields
.field final paint:Landroid/graphics/Paint;

.field private final rect:Landroid/graphics/Rect;

.field private shaderHeight:I

.field private shaderWidth:I


# direct methods
.method constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->rect:Landroid/graphics/Rect;

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    sget-boolean v1, Lorg/mapsforge/core/util/Parameters;->ANTI_ALIASING:Z

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    sget-object v1, Lorg/mapsforge/core/graphics/Cap;->ROUND:Lorg/mapsforge/core/graphics/Cap;

    invoke-static {v1}, Lorg/mapsforge/map/android/graphics/AndroidPaint;->getAndroidCap(Lorg/mapsforge/core/graphics/Cap;)Landroid/graphics/Paint$Cap;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    sget-object v1, Landroid/graphics/Paint$Join;->ROUND:Landroid/graphics/Paint$Join;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeJoin(Landroid/graphics/Paint$Join;)V

    sget-object v1, Lorg/mapsforge/core/graphics/Style;->FILL:Lorg/mapsforge/core/graphics/Style;

    invoke-static {v1}, Lorg/mapsforge/map/android/graphics/AndroidPaint;->getAndroidStyle(Lorg/mapsforge/core/graphics/Style;)Landroid/graphics/Paint$Style;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    return-void
.end method

.method constructor <init>(Lorg/mapsforge/core/graphics/Paint;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->rect:Landroid/graphics/Rect;

    new-instance v0, Landroid/graphics/Paint;

    check-cast p1, Lorg/mapsforge/map/android/graphics/AndroidPaint;

    iget-object p1, p1, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-direct {v0, p1}, Landroid/graphics/Paint;-><init>(Landroid/graphics/Paint;)V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    return-void
.end method

.method private static getAndroidAlign(Lorg/mapsforge/core/graphics/Align;)Landroid/graphics/Paint$Align;
    .registers 4

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Align:[I

    invoke-virtual {p0}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_2e

    const/4 v1, 0x2

    if-eq v0, v1, :cond_2b

    const/4 v1, 0x3

    if-ne v0, v1, :cond_14

    sget-object p0, Landroid/graphics/Paint$Align;->RIGHT:Landroid/graphics/Paint$Align;

    return-object p0

    :cond_14
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown align: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2b
    sget-object p0, Landroid/graphics/Paint$Align;->LEFT:Landroid/graphics/Paint$Align;

    return-object p0

    :cond_2e
    sget-object p0, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    return-object p0
.end method

.method private static getAndroidCap(Lorg/mapsforge/core/graphics/Cap;)Landroid/graphics/Paint$Cap;
    .registers 4

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Cap:[I

    invoke-virtual {p0}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_2e

    const/4 v1, 0x2

    if-eq v0, v1, :cond_2b

    const/4 v1, 0x3

    if-ne v0, v1, :cond_14

    sget-object p0, Landroid/graphics/Paint$Cap;->SQUARE:Landroid/graphics/Paint$Cap;

    return-object p0

    :cond_14
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown cap: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2b
    sget-object p0, Landroid/graphics/Paint$Cap;->ROUND:Landroid/graphics/Paint$Cap;

    return-object p0

    :cond_2e
    sget-object p0, Landroid/graphics/Paint$Cap;->BUTT:Landroid/graphics/Paint$Cap;

    return-object p0
.end method

.method private static getAndroidJoin(Lorg/mapsforge/core/graphics/Join;)Landroid/graphics/Paint$Join;
    .registers 4

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Join:[I

    invoke-virtual {p0}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_2e

    const/4 v1, 0x2

    if-eq v0, v1, :cond_2b

    const/4 v1, 0x3

    if-ne v0, v1, :cond_14

    sget-object p0, Landroid/graphics/Paint$Join;->MITER:Landroid/graphics/Paint$Join;

    return-object p0

    :cond_14
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown join: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2b
    sget-object p0, Landroid/graphics/Paint$Join;->ROUND:Landroid/graphics/Paint$Join;

    return-object p0

    :cond_2e
    sget-object p0, Landroid/graphics/Paint$Join;->BEVEL:Landroid/graphics/Paint$Join;

    return-object p0
.end method

.method private static getAndroidStyle(Lorg/mapsforge/core/graphics/Style;)Landroid/graphics/Paint$Style;
    .registers 4

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Style:[I

    invoke-virtual {p0}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_28

    const/4 v1, 0x2

    if-ne v0, v1, :cond_11

    sget-object p0, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    return-object p0

    :cond_11
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown style: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_28
    sget-object p0, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    return-object p0
.end method

.method private static getFontStyle(Lorg/mapsforge/core/graphics/FontStyle;)I
    .registers 4

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$FontStyle:[I

    invoke-virtual {p0}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_2e

    const/4 v1, 0x3

    const/4 v2, 0x2

    if-eq v0, v2, :cond_2e

    if-eq v0, v1, :cond_2d

    const/4 v1, 0x4

    if-ne v0, v1, :cond_16

    const/4 p0, 0x0

    return p0

    :cond_16
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown font style: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2d
    return v2

    :cond_2e
    return v1
.end method

.method private static getTypeface(Lorg/mapsforge/core/graphics/FontFamily;)Landroid/graphics/Typeface;
    .registers 4

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$FontFamily:[I

    invoke-virtual {p0}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_34

    const/4 v1, 0x2

    if-eq v0, v1, :cond_31

    const/4 v1, 0x3

    if-eq v0, v1, :cond_2e

    const/4 v1, 0x4

    if-ne v0, v1, :cond_17

    sget-object p0, Landroid/graphics/Typeface;->SERIF:Landroid/graphics/Typeface;

    return-object p0

    :cond_17
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown font family: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2e
    sget-object p0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    return-object p0

    :cond_31
    sget-object p0, Landroid/graphics/Typeface;->MONOSPACE:Landroid/graphics/Typeface;

    return-object p0

    :cond_34
    sget-object p0, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    return-object p0
.end method


# virtual methods
.method public getColor()I
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getColor()I

    move-result v0

    return v0
.end method

.method public getStrokeWidth()F
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v0

    return v0
.end method

.method public getTextHeight(Ljava/lang/String;)I
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->rect:Landroid/graphics/Rect;

    const/4 v3, 0x0

    invoke-virtual {v0, p1, v3, v1, v2}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->rect:Landroid/graphics/Rect;

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result p1

    return p1
.end method

.method public getTextWidth(Ljava/lang/String;)I
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result p1

    float-to-int p1, p1

    return p1
.end method

.method public isTransparent()Z
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getShader()Landroid/graphics/Shader;

    move-result-object v0

    if-nez v0, :cond_12

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getAlpha()I

    move-result v0

    if-nez v0, :cond_12

    const/4 v0, 0x1

    goto :goto_13

    :cond_12
    const/4 v0, 0x0

    :goto_13
    return v0
.end method

.method public setBitmapShader(Lorg/mapsforge/core/graphics/Bitmap;)V
    .registers 5

    if-nez p1, :cond_3

    return-void

    :cond_3
    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getBitmap(Lorg/mapsforge/core/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v0

    if-nez v0, :cond_a

    return-void

    :cond_a
    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result v1

    iput v1, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->shaderWidth:I

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result p1

    iput p1, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->shaderHeight:I

    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    sget-object v1, Lorg/mapsforge/core/graphics/Color;->WHITE:Lorg/mapsforge/core/graphics/Color;

    invoke-static {v1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getColor(Lorg/mapsforge/core/graphics/Color;)I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/graphics/Paint;->setColor(I)V

    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    new-instance v1, Landroid/graphics/BitmapShader;

    sget-object v2, Landroid/graphics/Shader$TileMode;->REPEAT:Landroid/graphics/Shader$TileMode;

    invoke-direct {v1, v0, v2, v2}, Landroid/graphics/BitmapShader;-><init>(Landroid/graphics/Bitmap;Landroid/graphics/Shader$TileMode;Landroid/graphics/Shader$TileMode;)V

    invoke-virtual {p1, v1}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    return-void
.end method

.method public setBitmapShaderShift(Lorg/mapsforge/core/model/Point;)V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getShader()Landroid/graphics/Shader;

    move-result-object v0

    if-eqz v0, :cond_23

    iget-wide v1, p1, Lorg/mapsforge/core/model/Point;->x:D

    neg-double v1, v1

    double-to-int v1, v1

    iget v2, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->shaderWidth:I

    rem-int/2addr v1, v2

    iget-wide v2, p1, Lorg/mapsforge/core/model/Point;->y:D

    neg-double v2, v2

    double-to-int p1, v2

    iget v2, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->shaderHeight:I

    rem-int/2addr p1, v2

    new-instance v2, Landroid/graphics/Matrix;

    invoke-direct {v2}, Landroid/graphics/Matrix;-><init>()V

    int-to-float v1, v1

    int-to-float p1, p1

    invoke-virtual {v2, v1, p1}, Landroid/graphics/Matrix;->setTranslate(FF)V

    invoke-virtual {v0, v2}, Landroid/graphics/Shader;->setLocalMatrix(Landroid/graphics/Matrix;)V

    :cond_23
    return-void
.end method

.method public setColor(I)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    return-void
.end method

.method public setColor(Lorg/mapsforge/core/graphics/Color;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getColor(Lorg/mapsforge/core/graphics/Color;)I

    move-result p1

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    return-void
.end method

.method public setDashPathEffect([F)V
    .registers 4

    new-instance v0, Landroid/graphics/DashPathEffect;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Landroid/graphics/DashPathEffect;-><init>([FF)V

    iget-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setPathEffect(Landroid/graphics/PathEffect;)Landroid/graphics/PathEffect;

    return-void
.end method

.method public setStrokeCap(Lorg/mapsforge/core/graphics/Cap;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidPaint;->getAndroidCap(Lorg/mapsforge/core/graphics/Cap;)Landroid/graphics/Paint$Cap;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    return-void
.end method

.method public setStrokeJoin(Lorg/mapsforge/core/graphics/Join;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidPaint;->getAndroidJoin(Lorg/mapsforge/core/graphics/Join;)Landroid/graphics/Paint$Join;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setStrokeJoin(Landroid/graphics/Paint$Join;)V

    return-void
.end method

.method public setStrokeWidth(F)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    return-void
.end method

.method public setStyle(Lorg/mapsforge/core/graphics/Style;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidPaint;->getAndroidStyle(Lorg/mapsforge/core/graphics/Style;)Landroid/graphics/Paint$Style;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    return-void
.end method

.method public setTextAlign(Lorg/mapsforge/core/graphics/Align;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidPaint;->getAndroidAlign(Lorg/mapsforge/core/graphics/Align;)Landroid/graphics/Paint$Align;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    return-void
.end method

.method public setTextSize(F)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setTextSize(F)V

    return-void
.end method

.method public setTypeface(Lorg/mapsforge/core/graphics/FontFamily;Lorg/mapsforge/core/graphics/FontStyle;)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidPaint;->getTypeface(Lorg/mapsforge/core/graphics/FontFamily;)Landroid/graphics/Typeface;

    move-result-object p1

    invoke-static {p2}, Lorg/mapsforge/map/android/graphics/AndroidPaint;->getFontStyle(Lorg/mapsforge/core/graphics/FontStyle;)I

    move-result p2

    invoke-static {p1, p2}, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    return-void
.end method
