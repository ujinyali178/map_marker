.class public Lorg/mapsforge/map/scalebar/ImperialUnitAdapter;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;


# static fields
.field public static final INSTANCE:Lorg/mapsforge/map/scalebar/ImperialUnitAdapter;

.field public static final METER_FOOT_RATIO:D = 0.3048

.field public static final ONE_MILE:I = 0x14a0

.field public static final SCALE_BAR_VALUES:[I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lorg/mapsforge/map/scalebar/ImperialUnitAdapter;

    invoke-direct {v0}, Lorg/mapsforge/map/scalebar/ImperialUnitAdapter;-><init>()V

    sput-object v0, Lorg/mapsforge/map/scalebar/ImperialUnitAdapter;->INSTANCE:Lorg/mapsforge/map/scalebar/ImperialUnitAdapter;

    const/16 v0, 0x17

    new-array v0, v0, [I

    fill-array-data v0, :array_12

    sput-object v0, Lorg/mapsforge/map/scalebar/ImperialUnitAdapter;->SCALE_BAR_VALUES:[I

    return-void

    nop

    :array_12
    .array-data 4
        0x192d500
        0xa12200
        0x509100
        0x284880
        0x101d00
        0x80e80
        0x40740
        0x19c80
        0xce40
        0x6720
        0x2940
        0x14a0
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

    const-wide v0, 0x3fd381d7dbf487fdL    # 0.3048

    return-wide v0
.end method

.method public getScaleBarValues()[I
    .registers 2

    sget-object v0, Lorg/mapsforge/map/scalebar/ImperialUnitAdapter;->SCALE_BAR_VALUES:[I

    return-object v0
.end method

.method public getScaleText(I)Ljava/lang/String;
    .registers 4

    const/16 v0, 0x14a0

    if-ge p1, v0, :cond_16

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " ft"

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_16
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    div-int/2addr p1, v0

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " mi"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method
