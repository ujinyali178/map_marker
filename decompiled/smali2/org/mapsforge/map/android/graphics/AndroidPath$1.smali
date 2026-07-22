.class synthetic Lorg/mapsforge/map/android/graphics/AndroidPath$1;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/android/graphics/AndroidPath;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$org$mapsforge$core$graphics$FillRule:[I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    invoke-static {}, Lorg/mapsforge/core/graphics/FillRule;->values()[Lorg/mapsforge/core/graphics/FillRule;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lorg/mapsforge/map/android/graphics/AndroidPath$1;->$SwitchMap$org$mapsforge$core$graphics$FillRule:[I

    :try_start_9
    sget-object v1, Lorg/mapsforge/core/graphics/FillRule;->EVEN_ODD:Lorg/mapsforge/core/graphics/FillRule;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_12
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_12} :catch_12

    :catch_12
    :try_start_12
    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidPath$1;->$SwitchMap$org$mapsforge$core$graphics$FillRule:[I

    sget-object v1, Lorg/mapsforge/core/graphics/FillRule;->NON_ZERO:Lorg/mapsforge/core/graphics/FillRule;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_12 .. :try_end_1d} :catch_1d

    :catch_1d
    return-void
.end method
