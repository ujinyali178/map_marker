.class public Lorg/mapsforge/map/android/graphics/AndroidHillshadingBitmap;
.super Lorg/mapsforge/map/android/graphics/AndroidBitmap;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/core/graphics/HillshadingBitmap;


# instance fields
.field private final areaRect:Lorg/mapsforge/core/model/BoundingBox;

.field private final padding:I


# direct methods
.method public constructor <init>(IIILorg/mapsforge/core/model/BoundingBox;)V
    .registers 6

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->MONO_ALPHA_BITMAP:Landroid/graphics/Bitmap$Config;

    invoke-direct {p0, p1, p2, v0}, Lorg/mapsforge/map/android/graphics/AndroidBitmap;-><init>(IILandroid/graphics/Bitmap$Config;)V

    iput p3, p0, Lorg/mapsforge/map/android/graphics/AndroidHillshadingBitmap;->padding:I

    iput-object p4, p0, Lorg/mapsforge/map/android/graphics/AndroidHillshadingBitmap;->areaRect:Lorg/mapsforge/core/model/BoundingBox;

    return-void
.end method


# virtual methods
.method public getAreaRect()Lorg/mapsforge/core/model/BoundingBox;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidHillshadingBitmap;->areaRect:Lorg/mapsforge/core/model/BoundingBox;

    return-object v0
.end method

.method public getPadding()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/android/graphics/AndroidHillshadingBitmap;->padding:I

    return v0
.end method
