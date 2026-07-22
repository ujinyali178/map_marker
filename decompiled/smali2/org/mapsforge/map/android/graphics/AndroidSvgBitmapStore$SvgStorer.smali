.class Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore$SvgStorer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SvgStorer"
.end annotation


# instance fields
.field private bitmap:Landroid/graphics/Bitmap;

.field private hash:I


# direct methods
.method public constructor <init>(ILandroid/graphics/Bitmap;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore$SvgStorer;->hash:I

    iput-object p2, p0, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore$SvgStorer;->bitmap:Landroid/graphics/Bitmap;

    return-void
.end method


# virtual methods
.method public run()V
    .registers 6

    iget v0, p0, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore$SvgStorer;->hash:I

    # invokes: Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->createFileName(I)Ljava/lang/String;
    invoke-static {v0}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->access$000(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    :try_start_7
    sget-object v2, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->INSTANCE:Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v1

    iget-object v2, p0, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore$SvgStorer;->bitmap:Landroid/graphics/Bitmap;

    sget-object v4, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    invoke-virtual {v2, v4, v3, v1}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    move-result v2

    if-nez v2, :cond_30

    # getter for: Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->LOGGER:Ljava/util/logging/Logger;
    invoke-static {}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->access$100()Ljava/util/logging/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "SVG Failed to write svg bitmap "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V
    :try_end_30
    .catch Ljava/lang/IllegalStateException; {:try_start_7 .. :try_end_30} :catch_4f
    .catch Ljava/io/FileNotFoundException; {:try_start_7 .. :try_end_30} :catch_36
    .catchall {:try_start_7 .. :try_end_30} :catchall_34

    :cond_30
    :goto_30
    invoke-static {v1}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    goto :goto_65

    :catchall_34
    move-exception v0

    goto :goto_66

    :catch_36
    :try_start_36
    # getter for: Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->LOGGER:Ljava/util/logging/Logger;
    invoke-static {}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->access$100()Ljava/util/logging/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "SVG Failed to create file for svg bitmap "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_4b
    invoke-virtual {v2, v0}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    goto :goto_30

    :catch_4f
    # getter for: Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->LOGGER:Ljava/util/logging/Logger;
    invoke-static {}, Lorg/mapsforge/map/android/graphics/AndroidSvgBitmapStore;->access$100()Ljava/util/logging/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "SVG Failed to stream bitmap to file "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0
    :try_end_64
    .catchall {:try_start_36 .. :try_end_64} :catchall_34

    goto :goto_4b

    :goto_65
    return-void

    :goto_66
    invoke-static {v1}, Lorg/mapsforge/core/util/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    throw v0
.end method
