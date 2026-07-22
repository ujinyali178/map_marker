.class Lorg/mapsforge/map/android/graphics/AndroidMatrix;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/core/graphics/Matrix;


# instance fields
.field final matrix:Landroid/graphics/Matrix;


# direct methods
.method constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidMatrix;->matrix:Landroid/graphics/Matrix;

    return-void
.end method


# virtual methods
.method public reset()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidMatrix;->matrix:Landroid/graphics/Matrix;

    invoke-virtual {v0}, Landroid/graphics/Matrix;->reset()V

    return-void
.end method

.method public rotate(F)V
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidMatrix;->matrix:Landroid/graphics/Matrix;

    float-to-double v1, p1

    invoke-static {v1, v2}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide v1

    double-to-float p1, v1

    invoke-virtual {v0, p1}, Landroid/graphics/Matrix;->preRotate(F)Z

    return-void
.end method

.method public rotate(FFF)V
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidMatrix;->matrix:Landroid/graphics/Matrix;

    float-to-double v1, p1

    invoke-static {v1, v2}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide v1

    double-to-float p1, v1

    invoke-virtual {v0, p1, p2, p3}, Landroid/graphics/Matrix;->preRotate(FFF)Z

    return-void
.end method

.method public scale(FF)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidMatrix;->matrix:Landroid/graphics/Matrix;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/Matrix;->preScale(FF)Z

    return-void
.end method

.method public scale(FFFF)V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidMatrix;->matrix:Landroid/graphics/Matrix;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/graphics/Matrix;->preScale(FFFF)Z

    return-void
.end method

.method public translate(FF)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidMatrix;->matrix:Landroid/graphics/Matrix;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/Matrix;->preTranslate(FF)Z

    return-void
.end method
