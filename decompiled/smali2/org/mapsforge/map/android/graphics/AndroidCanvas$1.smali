.class synthetic Lorg/mapsforge/map/android/graphics/AndroidCanvas$1;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/android/graphics/AndroidCanvas;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$org$mapsforge$core$graphics$Filter:[I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    invoke-static {}, Lorg/mapsforge/core/graphics/Filter;->values()[Lorg/mapsforge/core/graphics/Filter;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$1;->$SwitchMap$org$mapsforge$core$graphics$Filter:[I

    :try_start_9
    sget-object v1, Lorg/mapsforge/core/graphics/Filter;->GRAYSCALE:Lorg/mapsforge/core/graphics/Filter;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_12
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_12} :catch_12

    :catch_12
    :try_start_12
    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$1;->$SwitchMap$org$mapsforge$core$graphics$Filter:[I

    sget-object v1, Lorg/mapsforge/core/graphics/Filter;->GRAYSCALE_INVERT:Lorg/mapsforge/core/graphics/Filter;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_12 .. :try_end_1d} :catch_1d

    :catch_1d
    :try_start_1d
    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidCanvas$1;->$SwitchMap$org$mapsforge$core$graphics$Filter:[I

    sget-object v1, Lorg/mapsforge/core/graphics/Filter;->INVERT:Lorg/mapsforge/core/graphics/Filter;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_28
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1d .. :try_end_28} :catch_28

    :catch_28
    return-void
.end method
