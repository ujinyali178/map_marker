.class public Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RawShadingResult"
.end annotation


# instance fields
.field public final bytes:[B

.field public final height:I

.field public final padding:I

.field public final width:I


# direct methods
.method public constructor <init>([BIII)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->bytes:[B

    iput p2, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->width:I

    iput p3, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->height:I

    iput p4, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->padding:I

    return-void
.end method


# virtual methods
.method public fillPadding()V
    .registers 16

    iget v0, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->padding:I

    const/4 v1, 0x1

    if-ge v0, v1, :cond_6

    return-void

    :cond_6
    sget-object v0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->EAST:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->fillPadding(Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;)V

    sget-object v0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->WEST:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->fillPadding(Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;)V

    sget-object v0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->NORTH:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->fillPadding(Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;)V

    sget-object v0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->SOUTH:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->fillPadding(Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;)V

    iget v0, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->padding:I

    mul-int/lit8 v2, v0, 0x2

    iget v3, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->width:I

    add-int/2addr v2, v3

    add-int/2addr v3, v0

    iget v4, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->height:I

    add-int/2addr v4, v0

    iget-object v5, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->bytes:[B

    mul-int v6, v2, v0

    add-int/2addr v6, v0

    aget-byte v6, v5, v6

    mul-int v7, v2, v0

    add-int/2addr v7, v3

    sub-int/2addr v7, v1

    aget-byte v1, v5, v7

    add-int/lit8 v7, v4, -0x1

    mul-int v7, v7, v2

    add-int/2addr v0, v7

    aget-byte v0, v5, v0

    add-int/lit8 v8, v3, -0x1

    add-int/2addr v7, v8

    aget-byte v5, v5, v7

    mul-int v4, v4, v2

    add-int v7, v4, v3

    const/4 v8, 0x0

    const/4 v9, 0x0

    :goto_44
    iget v10, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->padding:I

    if-ge v9, v10, :cond_66

    mul-int v10, v2, v9

    const/4 v11, 0x0

    :goto_4b
    iget v12, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->padding:I

    if-ge v11, v12, :cond_63

    iget-object v12, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->bytes:[B

    add-int v13, v11, v10

    aput-byte v6, v12, v13

    add-int v14, v13, v3

    aput-byte v1, v12, v14

    add-int v14, v13, v4

    aput-byte v0, v12, v14

    add-int/2addr v13, v7

    aput-byte v5, v12, v13

    add-int/lit8 v11, v11, 0x1

    goto :goto_4b

    :cond_63
    add-int/lit8 v9, v9, 0x1

    goto :goto_44

    :cond_66
    return-void
.end method

.method fillPadding(Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;)V
    .registers 14

    iget v0, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->padding:I

    mul-int/lit8 v1, v0, 0x2

    iget v2, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->width:I

    add-int/2addr v1, v2

    iget-boolean v3, p1, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->vertical:Z

    const/4 v4, 0x0

    if-eqz v3, :cond_26

    add-int v3, v2, v0

    iget v5, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->height:I

    sget-object v6, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->WEST:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    if-ne p1, v6, :cond_19

    mul-int p1, v0, v1

    add-int v2, p1, v0

    goto :goto_1f

    :cond_19
    mul-int p1, v0, v1

    add-int/2addr p1, v0

    add-int/2addr p1, v2

    add-int/lit8 v2, p1, -0x1

    :goto_1f
    const/4 v6, 0x0

    move v11, v2

    move v2, v0

    move v0, v5

    move v5, v3

    move v3, v11

    goto :goto_3f

    :cond_26
    mul-int/lit8 v3, v0, 0x2

    sget-object v5, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->NORTH:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    if-ne p1, v5, :cond_31

    mul-int v1, v1, v0

    add-int/2addr v1, v0

    move p1, v0

    goto :goto_39

    :cond_31
    iget p1, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->height:I

    add-int/2addr p1, v0

    mul-int p1, p1, v1

    add-int/2addr p1, v0

    sub-int v1, p1, v1

    :goto_39
    neg-int v5, v2

    const/4 v6, 0x1

    move v11, v3

    move v3, v1

    move v1, v5

    move v5, v11

    :goto_3f
    const/4 v7, 0x0

    :goto_40
    if-ge v7, v0, :cond_56

    const/4 v8, 0x0

    :goto_43
    if-ge v8, v2, :cond_51

    iget-object v9, p0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->bytes:[B

    aget-byte v10, v9, v3

    aput-byte v10, v9, p1

    add-int/lit8 p1, p1, 0x1

    add-int/2addr v3, v6

    add-int/lit8 v8, v8, 0x1

    goto :goto_43

    :cond_51
    add-int/2addr p1, v5

    add-int/2addr v3, v1

    add-int/lit8 v7, v7, 0x1

    goto :goto_40

    :cond_56
    return-void
.end method
