.class public Lorg/mapsforge/map/scalebar/MetricUnitAdapter;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;


# static fields
.field public static final INSTANCE:Lorg/mapsforge/map/scalebar/MetricUnitAdapter;

.field public static final ONE_KILOMETER:I = 0x3e8

.field public static final SCALE_BAR_VALUES:[I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lorg/mapsforge/map/scalebar/MetricUnitAdapter;

    invoke-direct {v0}, Lorg/mapsforge/map/scalebar/MetricUnitAdapter;-><init>()V

    sput-object v0, Lorg/mapsforge/map/scalebar/MetricUnitAdapter;->INSTANCE:Lorg/mapsforge/map/scalebar/MetricUnitAdapter;

    const/16 v0, 0x16

    new-array v0, v0, [I

    fill-array-data v0, :array_12

    sput-object v0, Lorg/mapsforge/map/scalebar/MetricUnitAdapter;->SCALE_BAR_VALUES:[I

    return-void

    nop

    :array_12
    .array-data 4
        0x989680
        0x4c4b40
        0x1e8480
        0xf4240
        0x7a120
        0x30d40
        0x186a0
        0xc350
        0x4e20
        0x2710
        0x1388
        0x7d0
        0x3e8
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

    sget-object v0, Lorg/mapsforge/map/scalebar/MetricUnitAdapter;->SCALE_BAR_VALUES:[I

    return-object v0
.end method

.method public getScaleText(I)Ljava/lang/String;
    .registers 4

    const/16 v0, 0x3e8

    if-ge p1, v0, :cond_16

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " m"

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_16
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    div-int/2addr p1, v0

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " km"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method
