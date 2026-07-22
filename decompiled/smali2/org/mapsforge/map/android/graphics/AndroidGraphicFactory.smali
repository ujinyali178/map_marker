.class public final Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/core/graphics/GraphicFactory;


# static fields
.field public static final DEBUG_BITMAPS:Z = false

.field public static INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory; = null

.field public static final KEEP_RESOURCE_BITMAPS:Z = true

.field public static final MONO_ALPHA_BITMAP:Landroid/graphics/Bitmap$Config;

.field public static final NON_TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

.field public static final TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;


# instance fields
.field private final application:Landroid/app/Application;

.field private svgCacheDir:Ljava/io/File;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;-><init>(Landroid/app/Application;)V

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    sget-object v0, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->NON_TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    sget-object v0, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    sget-object v0, Landroid/graphics/Bitmap$Config;->ALPHA_8:Landroid/graphics/Bitmap$Config;

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->MONO_ALPHA_BITMAP:Landroid/graphics/Bitmap$Config;

    return-void
.end method

.method private constructor <init>(Landroid/app/Application;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->application:Landroid/app/Application;

    if-eqz p1, :cond_14

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object p1

    invoke-virtual {p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object p1

    iget p1, p1, Landroid/util/DisplayMetrics;->scaledDensity:F

    invoke-static {p1}, Lorg/mapsforge/map/model/DisplayModel;->setDeviceScaleFactor(F)V

    :cond_14
    return-void
.end method

.method public static clearResourceFileCache()V
    .registers 0

    invoke-static {}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->clear()V

    return-void
.end method

.method public static clearResourceMemoryCache()V
    .registers 0

    invoke-static {}, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;->clearResourceBitmaps()V

    return-void
.end method

.method public static convertToAndroidBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .registers 7

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1c

    if-ge v0, v1, :cond_11

    instance-of v0, p0, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v0, :cond_11

    check-cast p0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object p0

    goto :goto_33

    :cond_11
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    sget-object v2, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    invoke-static {v0, v1, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v2

    new-instance v3, Landroid/graphics/Canvas;

    invoke-direct {v3, v2}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {p0, v5, v5, v0, v1}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    invoke-virtual {p0, v3}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    invoke-virtual {p0, v4}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    move-object p0, v2

    :goto_33
    return-object p0
.end method

.method public static convertToBitmap(Landroid/graphics/drawable/Drawable;)Lorg/mapsforge/core/graphics/Bitmap;
    .registers 2

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;

    invoke-static {p0}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->convertToAndroidBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object p0

    invoke-direct {v0, p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;-><init>(Landroid/graphics/Bitmap;)V

    return-object v0
.end method

.method public static convertToBitmap(Landroid/graphics/drawable/Drawable;Landroid/graphics/Paint;)Lorg/mapsforge/core/graphics/Bitmap;
    .registers 4

    invoke-static {p0}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->convertToAndroidBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object p0

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Landroid/graphics/Bitmap;->copy(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;

    move-result-object p0

    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, p0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1, v1, p1}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    new-instance p1, Lorg/mapsforge/map/android/graphics/AndroidBitmap;

    invoke-direct {p1, p0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;-><init>(Landroid/graphics/Bitmap;)V

    return-object p1
.end method

.method public static createGraphicContext(Landroid/graphics/Canvas;)Lorg/mapsforge/core/graphics/Canvas;
    .registers 2

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;

    invoke-direct {v0, p0}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;-><init>(Landroid/graphics/Canvas;)V

    return-object v0
.end method

.method public static createInstance(Landroid/app/Application;)V
    .registers 2

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    invoke-direct {v0, p0}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;-><init>(Landroid/app/Application;)V

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    return-void
.end method

.method public static getBitmap(Lorg/mapsforge/core/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .registers 1

    check-cast p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;

    iget-object p0, p0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    return-object p0
.end method

.method public static getBytesPerPixel(Landroid/graphics/Bitmap$Config;)I
    .registers 3

    sget-object v0, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    if-ne p0, v0, :cond_6

    const/4 p0, 0x4

    return p0

    :cond_6
    sget-object v0, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    const/4 v1, 0x2

    if-ne p0, v0, :cond_c

    return v1

    :cond_c
    sget-object v0, Landroid/graphics/Bitmap$Config;->ARGB_4444:Landroid/graphics/Bitmap$Config;

    if-ne p0, v0, :cond_11

    return v1

    :cond_11
    sget-object p0, Landroid/graphics/Bitmap$Config;->ALPHA_8:Landroid/graphics/Bitmap$Config;

    const/4 p0, 0x1

    return p0
.end method

.method public static getCanvas(Lorg/mapsforge/core/graphics/Canvas;)Landroid/graphics/Canvas;
    .registers 1

    check-cast p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;

    iget-object p0, p0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;->canvas:Landroid/graphics/Canvas;

    return-object p0
.end method

.method static getColor(Lorg/mapsforge/core/graphics/Color;)I
    .registers 4

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory$1;->$SwitchMap$org$mapsforge$core$graphics$Color:[I

    invoke-virtual {p0}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_34

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown color: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_22
    const/4 p0, -0x1

    return p0

    :pswitch_24
    const/4 p0, 0x0

    return p0

    :pswitch_26
    const/high16 p0, -0x10000

    return p0

    :pswitch_29
    const p0, -0xff0100

    return p0

    :pswitch_2d
    const p0, -0xffff01

    return p0

    :pswitch_31
    const/high16 p0, -0x1000000

    return p0

    :pswitch_data_34
    .packed-switch 0x1
        :pswitch_31
        :pswitch_2d
        :pswitch_29
        :pswitch_26
        :pswitch_24
        :pswitch_22
    .end packed-switch
.end method

.method static getMatrix(Lorg/mapsforge/core/graphics/Matrix;)Landroid/graphics/Matrix;
    .registers 1

    check-cast p0, Lorg/mapsforge/map/android/graphics/AndroidMatrix;

    iget-object p0, p0, Lorg/mapsforge/map/android/graphics/AndroidMatrix;->matrix:Landroid/graphics/Matrix;

    return-object p0
.end method

.method public static getPaint(Lorg/mapsforge/core/graphics/Paint;)Landroid/graphics/Paint;
    .registers 1

    check-cast p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;

    iget-object p0, p0, Lorg/mapsforge/map/android/graphics/AndroidPaint;->paint:Landroid/graphics/Paint;

    return-object p0
.end method

.method static getPath(Lorg/mapsforge/core/graphics/Path;)Landroid/graphics/Path;
    .registers 1

    check-cast p0, Lorg/mapsforge/map/android/graphics/AndroidPath;

    iget-object p0, p0, Lorg/mapsforge/map/android/graphics/AndroidPath;->path:Landroid/graphics/Path;

    return-object p0
.end method


# virtual methods
.method public createBitmap(II)Lorg/mapsforge/core/graphics/Bitmap;
    .registers 5

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;

    sget-object v1, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    invoke-direct {v0, p1, p2, v1}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;-><init>(IILandroid/graphics/Bitmap$Config;)V

    return-object v0
.end method

.method public createBitmap(IIZ)Lorg/mapsforge/core/graphics/Bitmap;
    .registers 5

    if-eqz p3, :cond_a

    new-instance p3, Lorg/mapsforge/map/android/graphics/AndroidBitmap;

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    invoke-direct {p3, p1, p2, v0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;-><init>(IILandroid/graphics/Bitmap$Config;)V

    return-object p3

    :cond_a
    new-instance p3, Lorg/mapsforge/map/android/graphics/AndroidBitmap;

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->NON_TRANSPARENT_BITMAP:Landroid/graphics/Bitmap$Config;

    invoke-direct {p3, p1, p2, v0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;-><init>(IILandroid/graphics/Bitmap$Config;)V

    return-object p3
.end method

.method public createCanvas()Lorg/mapsforge/core/graphics/Canvas;
    .registers 2

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas;

    invoke-direct {v0}, Lorg/mapsforge/map/android/graphics/AndroidCanvas;-><init>()V

    return-object v0
.end method

.method public createColor(IIII)I
    .registers 5

    invoke-static {p1, p2, p3, p4}, Landroid/graphics/Color;->argb(IIII)I

    move-result p1

    return p1
.end method

.method public createColor(Lorg/mapsforge/core/graphics/Color;)I
    .registers 2

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->getColor(Lorg/mapsforge/core/graphics/Color;)I

    move-result p1

    return p1
.end method

.method public createMatrix()Lorg/mapsforge/core/graphics/Matrix;
    .registers 2

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidMatrix;

    invoke-direct {v0}, Lorg/mapsforge/map/android/graphics/AndroidMatrix;-><init>()V

    return-object v0
.end method

.method public bridge synthetic createMonoBitmap(II[BILorg/mapsforge/core/model/BoundingBox;)Lorg/mapsforge/core/graphics/HillshadingBitmap;
    .registers 6

    invoke-virtual/range {p0 .. p5}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->createMonoBitmap(II[BILorg/mapsforge/core/model/BoundingBox;)Lorg/mapsforge/map/android/graphics/AndroidHillshadingBitmap;

    move-result-object p1

    return-object p1
.end method

.method public createMonoBitmap(II[BILorg/mapsforge/core/model/BoundingBox;)Lorg/mapsforge/map/android/graphics/AndroidHillshadingBitmap;
    .registers 8

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidHillshadingBitmap;

    mul-int/lit8 v1, p4, 0x2

    add-int/2addr p1, v1

    add-int/2addr p2, v1

    invoke-direct {v0, p1, p2, p4, p5}, Lorg/mapsforge/map/android/graphics/AndroidHillshadingBitmap;-><init>(IIILorg/mapsforge/core/model/BoundingBox;)V

    if-eqz p3, :cond_14

    invoke-static {p3}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object p1

    iget-object p2, v0, Lorg/mapsforge/map/android/graphics/AndroidBitmap;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {p2, p1}, Landroid/graphics/Bitmap;->copyPixelsFromBuffer(Ljava/nio/Buffer;)V

    :cond_14
    return-object v0
.end method

.method public createPaint()Lorg/mapsforge/core/graphics/Paint;
    .registers 2

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidPaint;

    invoke-direct {v0}, Lorg/mapsforge/map/android/graphics/AndroidPaint;-><init>()V

    return-object v0
.end method

.method public createPaint(Lorg/mapsforge/core/graphics/Paint;)Lorg/mapsforge/core/graphics/Paint;
    .registers 3

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidPaint;

    invoke-direct {v0, p1}, Lorg/mapsforge/map/android/graphics/AndroidPaint;-><init>(Lorg/mapsforge/core/graphics/Paint;)V

    return-object v0
.end method

.method public createPath()Lorg/mapsforge/core/graphics/Path;
    .registers 2

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidPath;

    invoke-direct {v0}, Lorg/mapsforge/map/android/graphics/AndroidPath;-><init>()V

    return-object v0
.end method

.method public createPointTextContainer(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/mapelements/SymbolContainer;Lorg/mapsforge/core/graphics/Position;I)Lorg/mapsforge/core/mapelements/PointTextContainer;
    .registers 21

    new-instance v10, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;

    move-object v0, v10

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    move-object/from16 v5, p5

    move-object/from16 v6, p6

    move-object/from16 v7, p7

    move-object/from16 v8, p8

    move/from16 v9, p9

    invoke-direct/range {v0 .. v9}, Lorg/mapsforge/map/android/graphics/AndroidPointTextContainer;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/mapelements/SymbolContainer;Lorg/mapsforge/core/graphics/Position;I)V

    return-object v10
.end method

.method public createResourceBitmap(Ljava/io/InputStream;FIIII)Lorg/mapsforge/core/graphics/ResourceBitmap;
    .registers 15

    new-instance v7, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;

    move-object v0, v7

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    move v6, p6

    invoke-direct/range {v0 .. v6}, Lorg/mapsforge/map/android/graphics/AndroidResourceBitmap;-><init>(Ljava/io/InputStream;FIIII)V

    return-object v7
.end method

.method public createTileBitmap(IZ)Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 4

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;

    invoke-direct {v0, p1, p2}, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;-><init>(IZ)V

    return-object v0
.end method

.method public createTileBitmap(Ljava/io/InputStream;IZ)Lorg/mapsforge/core/graphics/TileBitmap;
    .registers 5

    new-instance v0, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;

    invoke-direct {v0, p1, p2, p3}, Lorg/mapsforge/map/android/graphics/AndroidTileBitmap;-><init>(Ljava/io/InputStream;IZ)V

    return-object v0
.end method

.method public deleteFile(Ljava/lang/String;)Z
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->svgCacheDir:Ljava/io/File;

    if-eqz v0, :cond_10

    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->svgCacheDir:Ljava/io/File;

    invoke-direct {v0, v1, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    move-result p1

    return p1

    :cond_10
    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->application:Landroid/app/Application;

    invoke-virtual {v0, p1}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    move-result p1

    return p1
.end method

.method public fileList()[Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->svgCacheDir:Ljava/io/File;

    if-eqz v0, :cond_9

    invoke-virtual {v0}, Ljava/io/File;->list()[Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_9
    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->application:Landroid/app/Application;

    invoke-virtual {v0}, Landroid/content/Context;->fileList()[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->svgCacheDir:Ljava/io/File;

    if-eqz v0, :cond_11

    new-instance v0, Ljava/io/FileInputStream;

    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->svgCacheDir:Ljava/io/File;

    invoke-direct {v1, v2, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    return-object v0

    :cond_11
    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->application:Landroid/app/Application;

    invoke-virtual {v0, p1}, Landroid/content/Context;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object p1

    return-object p1
.end method

.method public openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->svgCacheDir:Ljava/io/File;

    if-eqz v0, :cond_19

    new-instance v0, Ljava/io/FileOutputStream;

    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->svgCacheDir:Ljava/io/File;

    invoke-direct {v1, v2, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const p1, 0x8000

    if-ne p2, p1, :cond_14

    const/4 p1, 0x1

    goto :goto_15

    :cond_14
    const/4 p1, 0x0

    :goto_15
    invoke-direct {v0, v1, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    return-object v0

    :cond_19
    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->application:Landroid/app/Application;

    invoke-virtual {v0, p1, p2}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object p1

    return-object p1
.end method

.method public platformSpecificSources(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    .registers 5

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_d

    const-string p1, ""

    :cond_d
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    :try_start_17
    iget-object p2, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->application:Landroid/app/Application;

    invoke-virtual {p2}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object p2

    invoke-virtual {p2, p1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object p1
    :try_end_21
    .catch Ljava/io/IOException; {:try_start_17 .. :try_end_21} :catch_22

    return-object p1

    :catch_22
    new-instance p2, Ljava/io/FileNotFoundException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "invalid resource: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw p2
.end method

.method public renderSvg(Ljava/io/InputStream;FIIII)Lorg/mapsforge/core/graphics/ResourceBitmap;
    .registers 15

    new-instance v7, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmap;

    move-object v0, v7

    move-object v1, p1

    move v2, p6

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-direct/range {v0 .. v6}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmap;-><init>(Ljava/io/InputStream;IFIII)V

    return-object v7
.end method

.method public setSvgCacheDir(Ljava/io/File;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->svgCacheDir:Ljava/io/File;

    return-void
.end method
