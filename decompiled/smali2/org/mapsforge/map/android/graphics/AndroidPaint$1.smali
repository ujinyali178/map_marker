.class synthetic Lorg/mapsforge/map/android/graphics/AndroidPaint$1;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/android/graphics/AndroidPaint;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$org$mapsforge$core$graphics$Align:[I

.field static final synthetic $SwitchMap$org$mapsforge$core$graphics$Cap:[I

.field static final synthetic $SwitchMap$org$mapsforge$core$graphics$FontFamily:[I

.field static final synthetic $SwitchMap$org$mapsforge$core$graphics$FontStyle:[I

.field static final synthetic $SwitchMap$org$mapsforge$core$graphics$Join:[I

.field static final synthetic $SwitchMap$org$mapsforge$core$graphics$Style:[I


# direct methods
.method static constructor <clinit>()V
    .registers 6

    invoke-static {}, Lorg/mapsforge/core/graphics/FontFamily;->values()[Lorg/mapsforge/core/graphics/FontFamily;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$FontFamily:[I

    const/4 v1, 0x1

    :try_start_a
    sget-object v2, Lorg/mapsforge/core/graphics/FontFamily;->DEFAULT:Lorg/mapsforge/core/graphics/FontFamily;

    invoke-virtual {v2}, Ljava/lang/Enum;->ordinal()I

    move-result v2

    aput v1, v0, v2
    :try_end_12
    .catch Ljava/lang/NoSuchFieldError; {:try_start_a .. :try_end_12} :catch_12

    :catch_12
    const/4 v0, 0x2

    :try_start_13
    sget-object v2, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$FontFamily:[I

    sget-object v3, Lorg/mapsforge/core/graphics/FontFamily;->MONOSPACE:Lorg/mapsforge/core/graphics/FontFamily;

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aput v0, v2, v3
    :try_end_1d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_13 .. :try_end_1d} :catch_1d

    :catch_1d
    const/4 v2, 0x3

    :try_start_1e
    sget-object v3, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$FontFamily:[I

    sget-object v4, Lorg/mapsforge/core/graphics/FontFamily;->SANS_SERIF:Lorg/mapsforge/core/graphics/FontFamily;

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aput v2, v3, v4
    :try_end_28
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1e .. :try_end_28} :catch_28

    :catch_28
    const/4 v3, 0x4

    :try_start_29
    sget-object v4, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$FontFamily:[I

    sget-object v5, Lorg/mapsforge/core/graphics/FontFamily;->SERIF:Lorg/mapsforge/core/graphics/FontFamily;

    invoke-virtual {v5}, Ljava/lang/Enum;->ordinal()I

    move-result v5

    aput v3, v4, v5
    :try_end_33
    .catch Ljava/lang/NoSuchFieldError; {:try_start_29 .. :try_end_33} :catch_33

    :catch_33
    invoke-static {}, Lorg/mapsforge/core/graphics/FontStyle;->values()[Lorg/mapsforge/core/graphics/FontStyle;

    move-result-object v4

    array-length v4, v4

    new-array v4, v4, [I

    sput-object v4, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$FontStyle:[I

    :try_start_3c
    sget-object v5, Lorg/mapsforge/core/graphics/FontStyle;->BOLD:Lorg/mapsforge/core/graphics/FontStyle;

    invoke-virtual {v5}, Ljava/lang/Enum;->ordinal()I

    move-result v5

    aput v1, v4, v5
    :try_end_44
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3c .. :try_end_44} :catch_44

    :catch_44
    :try_start_44
    sget-object v4, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$FontStyle:[I

    sget-object v5, Lorg/mapsforge/core/graphics/FontStyle;->BOLD_ITALIC:Lorg/mapsforge/core/graphics/FontStyle;

    invoke-virtual {v5}, Ljava/lang/Enum;->ordinal()I

    move-result v5

    aput v0, v4, v5
    :try_end_4e
    .catch Ljava/lang/NoSuchFieldError; {:try_start_44 .. :try_end_4e} :catch_4e

    :catch_4e
    :try_start_4e
    sget-object v4, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$FontStyle:[I

    sget-object v5, Lorg/mapsforge/core/graphics/FontStyle;->ITALIC:Lorg/mapsforge/core/graphics/FontStyle;

    invoke-virtual {v5}, Ljava/lang/Enum;->ordinal()I

    move-result v5

    aput v2, v4, v5
    :try_end_58
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4e .. :try_end_58} :catch_58

    :catch_58
    :try_start_58
    sget-object v4, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$FontStyle:[I

    sget-object v5, Lorg/mapsforge/core/graphics/FontStyle;->NORMAL:Lorg/mapsforge/core/graphics/FontStyle;

    invoke-virtual {v5}, Ljava/lang/Enum;->ordinal()I

    move-result v5

    aput v3, v4, v5
    :try_end_62
    .catch Ljava/lang/NoSuchFieldError; {:try_start_58 .. :try_end_62} :catch_62

    :catch_62
    invoke-static {}, Lorg/mapsforge/core/graphics/Style;->values()[Lorg/mapsforge/core/graphics/Style;

    move-result-object v3

    array-length v3, v3

    new-array v3, v3, [I

    sput-object v3, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Style:[I

    :try_start_6b
    sget-object v4, Lorg/mapsforge/core/graphics/Style;->FILL:Lorg/mapsforge/core/graphics/Style;

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aput v1, v3, v4
    :try_end_73
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6b .. :try_end_73} :catch_73

    :catch_73
    :try_start_73
    sget-object v3, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Style:[I

    sget-object v4, Lorg/mapsforge/core/graphics/Style;->STROKE:Lorg/mapsforge/core/graphics/Style;

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aput v0, v3, v4
    :try_end_7d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_73 .. :try_end_7d} :catch_7d

    :catch_7d
    invoke-static {}, Lorg/mapsforge/core/graphics/Join;->values()[Lorg/mapsforge/core/graphics/Join;

    move-result-object v3

    array-length v3, v3

    new-array v3, v3, [I

    sput-object v3, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Join:[I

    :try_start_86
    sget-object v4, Lorg/mapsforge/core/graphics/Join;->BEVEL:Lorg/mapsforge/core/graphics/Join;

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aput v1, v3, v4
    :try_end_8e
    .catch Ljava/lang/NoSuchFieldError; {:try_start_86 .. :try_end_8e} :catch_8e

    :catch_8e
    :try_start_8e
    sget-object v3, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Join:[I

    sget-object v4, Lorg/mapsforge/core/graphics/Join;->ROUND:Lorg/mapsforge/core/graphics/Join;

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aput v0, v3, v4
    :try_end_98
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8e .. :try_end_98} :catch_98

    :catch_98
    :try_start_98
    sget-object v3, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Join:[I

    sget-object v4, Lorg/mapsforge/core/graphics/Join;->MITER:Lorg/mapsforge/core/graphics/Join;

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aput v2, v3, v4
    :try_end_a2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_98 .. :try_end_a2} :catch_a2

    :catch_a2
    invoke-static {}, Lorg/mapsforge/core/graphics/Cap;->values()[Lorg/mapsforge/core/graphics/Cap;

    move-result-object v3

    array-length v3, v3

    new-array v3, v3, [I

    sput-object v3, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Cap:[I

    :try_start_ab
    sget-object v4, Lorg/mapsforge/core/graphics/Cap;->BUTT:Lorg/mapsforge/core/graphics/Cap;

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aput v1, v3, v4
    :try_end_b3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_ab .. :try_end_b3} :catch_b3

    :catch_b3
    :try_start_b3
    sget-object v3, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Cap:[I

    sget-object v4, Lorg/mapsforge/core/graphics/Cap;->ROUND:Lorg/mapsforge/core/graphics/Cap;

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aput v0, v3, v4
    :try_end_bd
    .catch Ljava/lang/NoSuchFieldError; {:try_start_b3 .. :try_end_bd} :catch_bd

    :catch_bd
    :try_start_bd
    sget-object v3, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Cap:[I

    sget-object v4, Lorg/mapsforge/core/graphics/Cap;->SQUARE:Lorg/mapsforge/core/graphics/Cap;

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aput v2, v3, v4
    :try_end_c7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_bd .. :try_end_c7} :catch_c7

    :catch_c7
    invoke-static {}, Lorg/mapsforge/core/graphics/Align;->values()[Lorg/mapsforge/core/graphics/Align;

    move-result-object v3

    array-length v3, v3

    new-array v3, v3, [I

    sput-object v3, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Align:[I

    :try_start_d0
    sget-object v4, Lorg/mapsforge/core/graphics/Align;->CENTER:Lorg/mapsforge/core/graphics/Align;

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aput v1, v3, v4
    :try_end_d8
    .catch Ljava/lang/NoSuchFieldError; {:try_start_d0 .. :try_end_d8} :catch_d8

    :catch_d8
    :try_start_d8
    sget-object v1, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Align:[I

    sget-object v3, Lorg/mapsforge/core/graphics/Align;->LEFT:Lorg/mapsforge/core/graphics/Align;

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aput v0, v1, v3
    :try_end_e2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_d8 .. :try_end_e2} :catch_e2

    :catch_e2
    :try_start_e2
    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidPaint$1;->$SwitchMap$org$mapsforge$core$graphics$Align:[I

    sget-object v1, Lorg/mapsforge/core/graphics/Align;->RIGHT:Lorg/mapsforge/core/graphics/Align;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aput v2, v0, v1
    :try_end_ec
    .catch Ljava/lang/NoSuchFieldError; {:try_start_e2 .. :try_end_ec} :catch_ec

    :catch_ec
    return-void
.end method
