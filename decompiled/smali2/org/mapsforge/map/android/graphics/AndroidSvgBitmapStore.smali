.class public Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore$SvgStorer;
    }
.end annotation


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;

.field private static final SVG_PREFIX:Ljava/lang/String; = "svg-"

.field private static final SVG_SUFFIX:Ljava/lang/String; = ".png"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(I)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->createFileName(I)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method static synthetic access$100()Ljava/util/logging/Logger;
    .registers 1

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->LOGGER:Ljava/util/logging/Logger;

    return-object v0
.end method

.method public static clear()V
    .registers 5

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->fileList()[Ljava/lang/String;

    move-result-object v0

    array-length v1, v0

    const/4 v2, 0x0

    :goto_8
    if-ge v2, v1, :cond_24

    aget-object v3, v0, v2

    const-string v4, "svg-"

    invoke-virtual {v3, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_21

    const-string v4, ".png"

    invoke-virtual {v3, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_21

    sget-object v4, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    invoke-virtual {v4, v3}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->deleteFile(Ljava/lang/String;)Z

    :cond_21
    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    :cond_24
    return-void
.end method

.method private static createFileName(I)Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "svg-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p0, ".png"

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static get(I)Landroid/graphics/Bitmap;
    .registers 4

    invoke-static {p0}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->createFileName(I)Ljava/lang/String;

    move-result-object p0

    const/4 v0, 0x0

    :try_start_5
    sget-object v1, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    invoke-virtual {v1, p0}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object p0
    :try_end_b
    .catch Ljava/io/FileNotFoundException; {:try_start_5 .. :try_end_b} :catch_1d
    .catchall {:try_start_5 .. :try_end_b} :catchall_15

    :try_start_b
    invoke-static {p0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v0
    :try_end_f
    .catch Ljava/io/FileNotFoundException; {:try_start_b .. :try_end_f} :catch_1e
    .catchall {:try_start_b .. :try_end_f} :catchall_13

    invoke-static {p0}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    return-object v0

    :catchall_13
    move-exception v0

    goto :goto_19

    :catchall_15
    move-exception p0

    move-object v2, v0

    move-object v0, p0

    move-object p0, v2

    :goto_19
    invoke-static {p0}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    throw v0

    :catch_1d
    move-object p0, v0

    :catch_1e
    invoke-static {p0}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    return-object v0
.end method

.method public static put(ILandroid/graphics/Bitmap;)V
    .registers 4

    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore$SvgStorer;

    invoke-direct {v1, p0, p1}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore$SvgStorer;-><init>(ILandroid/graphics/Bitmap;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    return-void
.end method
