.class public final Lorg/mapsforge/core/graphics/GraphicUtils;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static filterColor(ILorg/mapsforge/core/graphics/Filter;)I
    .registers 9

    sget-object v0, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    if-ne p1, v0, :cond_5

    return p0

    :cond_5
    ushr-int/lit8 v0, p0, 0x18

    shr-int/lit8 v1, p0, 0x10

    and-int/lit16 v1, v1, 0xff

    shr-int/lit8 v2, p0, 0x8

    and-int/lit16 v2, v2, 0xff

    and-int/lit16 p0, p0, 0xff

    sget-object v3, Lorg/mapsforge/core/graphics/GraphicUtils$1;->$SwitchMap$org$mapsforge$core$graphics$Filter:[I

    invoke-virtual {p1}, Ljava/lang/Enum;->ordinal()I

    move-result p1

    aget p1, v3, p1

    const/4 v3, 0x1

    const v4, 0x3d9374bc    # 0.072f

    const v5, 0x3f370a3d    # 0.715f

    const v6, 0x3e5a1cac    # 0.213f

    if-eq p1, v3, :cond_42

    const/4 v3, 0x2

    if-eq p1, v3, :cond_33

    const/4 v3, 0x3

    if-eq p1, v3, :cond_2c

    goto :goto_50

    :cond_2c
    rsub-int v1, v1, 0xff

    rsub-int v2, v2, 0xff

    rsub-int p0, p0, 0xff

    goto :goto_50

    :cond_33
    int-to-float p1, v1

    mul-float p1, p1, v6

    int-to-float v1, v2

    mul-float v1, v1, v5

    add-float/2addr p1, v1

    int-to-float p0, p0

    mul-float p0, p0, v4

    add-float/2addr p1, p0

    float-to-int p0, p1

    rsub-int v1, p0, 0xff

    goto :goto_4e

    :cond_42
    int-to-float p1, v1

    mul-float p1, p1, v6

    int-to-float v1, v2

    mul-float v1, v1, v5

    add-float/2addr p1, v1

    int-to-float p0, p0

    mul-float p0, p0, v4

    add-float/2addr p1, p0

    float-to-int v1, p1

    :goto_4e
    move p0, v1

    move v2, p0

    :goto_50
    shl-int/lit8 p1, v0, 0x18

    shl-int/lit8 v0, v1, 0x10

    or-int/2addr p1, v0

    shl-int/lit8 v0, v2, 0x8

    or-int/2addr p1, v0

    or-int/2addr p0, p1

    return p0
.end method

.method public static getAlpha(I)I
    .registers 1

    shr-int/lit8 p0, p0, 0x18

    and-int/lit16 p0, p0, 0xff

    return p0
.end method

.method public static imageSize(FFFIII)[F
    .registers 7

    mul-float v0, p0, p2

    mul-float p2, p2, p1

    div-float/2addr p0, p1

    if-eqz p3, :cond_c

    if-eqz p4, :cond_c

    int-to-float v0, p3

    int-to-float p2, p4

    goto :goto_1b

    :cond_c
    if-nez p3, :cond_14

    if-eqz p4, :cond_14

    int-to-float p2, p4

    mul-float v0, p2, p0

    goto :goto_1b

    :cond_14
    if-eqz p3, :cond_1b

    if-nez p4, :cond_1b

    int-to-float v0, p3

    div-float p2, v0, p0

    :cond_1b
    :goto_1b
    const/16 p0, 0x64

    if-eq p5, p0, :cond_27

    int-to-float p0, p5

    const/high16 p1, 0x42c80000    # 100.0f

    div-float/2addr p0, p1

    mul-float v0, v0, p0

    mul-float p2, p2, p0

    :cond_27
    const/4 p0, 0x2

    new-array p0, p0, [F

    const/4 p1, 0x0

    aput v0, p0, p1

    const/4 p1, 0x1

    aput p2, p0, p1

    return-object p0
.end method
