.class public Lorg/mapsforge/map/scalebar/NauticalUnitAdapter;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;


# static fields
.field public static final INSTANCE:Lorg/mapsforge/map/scalebar/NauticalUnitAdapter;

.field public static final ONE_MILE:I = 0x73c

.field public static final SCALE_BAR_VALUES:[I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lorg/mapsforge/map/scalebar/NauticalUnitAdapter;

    invoke-direct {v0}, Lorg/mapsforge/map/scalebar/NauticalUnitAdapter;-><init>()V

    sput-object v0, Lorg/mapsforge/map/scalebar/NauticalUnitAdapter;->INSTANCE:Lorg/mapsforge/map/scalebar/NauticalUnitAdapter;

    const/16 v0, 0x16

    new-array v0, v0, [I

    fill-array-data v0, :array_12

    sput-object v0, Lorg/mapsforge/map/scalebar/NauticalUnitAdapter;->SCALE_BAR_VALUES:[I

    return-void

    nop

    :array_12
    .array-data 4
        0x8d4be0
        0x3884c0
        0x1c4260
        0xe2130
        0x5a6e0
        0x2d370
        0x169b8
        0x90b0
        0x4858
        0x242c
        0xe78
        0x73c
        0x39e
        0x1f4
        0xc8
        0x64
        0x32
        0x14
        0xa
        0x5
        0x2
        0x1
    .end array-data
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getMeterRatio()D
    .registers 3

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    return-wide v0
.end method

.method public getScaleBarValues()[I
    .registers 2

    sget-object v0, Lorg/mapsforge/map/scalebar/NauticalUnitAdapter;->SCALE_BAR_VALUES:[I

    return-object v0
.end method

.method public getScaleText(I)Ljava/lang/String;
    .registers 3

    const/16 v0, 0x39e

    if-ge p1, v0, :cond_16

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " m"

    :goto_e
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_16
    if-ne p1, v0, :cond_1b

    const-string p1, "0.5 nmi"

    return-object p1

    :cond_1b
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    div-int/lit16 p1, p1, 0x73c

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " nmi"

    goto :goto_e
.end method
