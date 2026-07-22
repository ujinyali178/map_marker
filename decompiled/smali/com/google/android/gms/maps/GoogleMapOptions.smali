.class public final Lcom/google/android/gms/maps/GoogleMapOptions;
.super Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/common/internal/ReflectedParcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/google/android/gms/maps/GoogleMapOptions;",
            ">;"
        }
    .end annotation
.end field

.field private static final zza:Ljava/lang/Integer;


# instance fields
.field private zzb:Ljava/lang/Boolean;

.field private zzc:Ljava/lang/Boolean;

.field private zzd:I

.field private zze:Lcom/google/android/gms/maps/model/CameraPosition;

.field private zzf:Ljava/lang/Boolean;

.field private zzg:Ljava/lang/Boolean;

.field private zzh:Ljava/lang/Boolean;

.field private zzi:Ljava/lang/Boolean;

.field private zzj:Ljava/lang/Boolean;

.field private zzk:Ljava/lang/Boolean;

.field private zzl:Ljava/lang/Boolean;

.field private zzm:Ljava/lang/Boolean;

.field private zzn:Ljava/lang/Boolean;

.field private zzo:Ljava/lang/Float;

.field private zzp:Ljava/lang/Float;

.field private zzq:Lcom/google/android/gms/maps/model/LatLngBounds;

.field private zzr:Ljava/lang/Boolean;

.field private zzs:Ljava/lang/Integer;

.field private zzt:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 4

    new-instance v0, Lcom/google/android/gms/maps/zzac;

    invoke-direct {v0}, Lcom/google/android/gms/maps/zzac;-><init>()V

    sput-object v0, Lcom/google/android/gms/maps/GoogleMapOptions;->CREATOR:Landroid/os/Parcelable$Creator;

    const/16 v0, 0xff

    const/16 v1, 0xec

    const/16 v2, 0xe9

    const/16 v3, 0xe1

    invoke-static {v0, v1, v2, v3}, Landroid/graphics/Color;->argb(IIII)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zza:Ljava/lang/Integer;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzd:I

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzo:Ljava/lang/Float;

    iput-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzp:Ljava/lang/Float;

    iput-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzq:Lcom/google/android/gms/maps/model/LatLngBounds;

    iput-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzs:Ljava/lang/Integer;

    iput-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzt:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(BBILcom/google/android/gms/maps/model/CameraPosition;BBBBBBBBBLjava/lang/Float;Ljava/lang/Float;Lcom/google/android/gms/maps/model/LatLngBounds;BLjava/lang/Integer;Ljava/lang/String;)V
    .registers 22

    move-object v0, p0

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;-><init>()V

    const/4 v1, -0x1

    iput v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzd:I

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzo:Ljava/lang/Float;

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzp:Ljava/lang/Float;

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzq:Lcom/google/android/gms/maps/model/LatLngBounds;

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzs:Ljava/lang/Integer;

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzt:Ljava/lang/String;

    invoke-static {p1}, Lcom/google/android/gms/maps/internal/zza;->zzb(B)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzb:Ljava/lang/Boolean;

    invoke-static {p2}, Lcom/google/android/gms/maps/internal/zza;->zzb(B)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzc:Ljava/lang/Boolean;

    move v1, p3

    iput v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzd:I

    move-object v1, p4

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zze:Lcom/google/android/gms/maps/model/CameraPosition;

    invoke-static {p5}, Lcom/google/android/gms/maps/internal/zza;->zzb(B)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzf:Ljava/lang/Boolean;

    invoke-static {p6}, Lcom/google/android/gms/maps/internal/zza;->zzb(B)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzg:Ljava/lang/Boolean;

    invoke-static {p7}, Lcom/google/android/gms/maps/internal/zza;->zzb(B)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzh:Ljava/lang/Boolean;

    invoke-static {p8}, Lcom/google/android/gms/maps/internal/zza;->zzb(B)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzi:Ljava/lang/Boolean;

    invoke-static {p9}, Lcom/google/android/gms/maps/internal/zza;->zzb(B)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzj:Ljava/lang/Boolean;

    invoke-static {p10}, Lcom/google/android/gms/maps/internal/zza;->zzb(B)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzk:Ljava/lang/Boolean;

    invoke-static {p11}, Lcom/google/android/gms/maps/internal/zza;->zzb(B)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzl:Ljava/lang/Boolean;

    invoke-static {p12}, Lcom/google/android/gms/maps/internal/zza;->zzb(B)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzm:Ljava/lang/Boolean;

    invoke-static {p13}, Lcom/google/android/gms/maps/internal/zza;->zzb(B)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzn:Ljava/lang/Boolean;

    move-object/from16 v1, p14

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzo:Ljava/lang/Float;

    move-object/from16 v1, p15

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzp:Ljava/lang/Float;

    move-object/from16 v1, p16

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzq:Lcom/google/android/gms/maps/model/LatLngBounds;

    invoke-static/range {p17 .. p17}, Lcom/google/android/gms/maps/internal/zza;->zzb(B)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzr:Ljava/lang/Boolean;

    move-object/from16 v1, p18

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzs:Ljava/lang/Integer;

    move-object/from16 v1, p19

    iput-object v1, v0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzt:Ljava/lang/String;

    return-void
.end method

.method public static createFromAttributes(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 8

    if-eqz p0, :cond_140

    if-nez p1, :cond_6

    goto/16 :goto_140

    :cond_6
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/maps/R$styleable;->MapAttrs:[I

    invoke-virtual {v0, p1, v1}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/maps/GoogleMapOptions;

    invoke-direct {v1}, Lcom/google/android/gms/maps/GoogleMapOptions;-><init>()V

    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_mapType:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_25

    const/4 v3, -0x1

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->mapType(I)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_25
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_zOrderOnTop:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    const/4 v4, 0x0

    if-eqz v3, :cond_35

    invoke-virtual {v0, v2, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->zOrderOnTop(Z)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_35
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_useViewLifecycle:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_44

    invoke-virtual {v0, v2, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->useViewLifecycleInFragment(Z)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_44
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_uiCompass:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    const/4 v5, 0x1

    const/4 v5, 0x1

    if-eqz v3, :cond_55

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->compassEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_55
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_uiRotateGestures:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_64

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->rotateGesturesEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_64
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_uiScrollGesturesDuringRotateOrZoom:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_73

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->scrollGesturesEnabledDuringRotateOrZoom(Z)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_73
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_uiScrollGestures:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_82

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->scrollGesturesEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_82
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_uiTiltGestures:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_91

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->tiltGesturesEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_91
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_uiZoomGestures:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_a0

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->zoomGesturesEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_a0
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_uiZoomControls:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_af

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->zoomControlsEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_af
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_liteMode:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_be

    invoke-virtual {v0, v2, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->liteMode(Z)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_be
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_uiMapToolbar:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_cd

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->mapToolbarEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_cd
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_ambientEnabled:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_dc

    invoke-virtual {v0, v2, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->ambientEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_dc
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_cameraMinZoomPreference:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_ed

    const/high16 v3, -0x800000    # Float.NEGATIVE_INFINITY

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v3

    invoke-virtual {v1, v3}, Lcom/google/android/gms/maps/GoogleMapOptions;->minZoomPreference(F)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_ed
    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v2

    if-eqz v2, :cond_fe

    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_cameraMaxZoomPreference:I

    const/high16 v3, 0x7f800000    # Float.POSITIVE_INFINITY

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->maxZoomPreference(F)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_fe
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_backgroundColor:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_117

    sget-object v3, Lcom/google/android/gms/maps/GoogleMapOptions;->zza:Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->backgroundColor(Ljava/lang/Integer;)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_117
    sget v2, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_mapId:I

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_12e

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_12e

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_12e

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->mapId(Ljava/lang/String;)Lcom/google/android/gms/maps/GoogleMapOptions;

    :cond_12e
    invoke-static {p0, p1}, Lcom/google/android/gms/maps/GoogleMapOptions;->zzb(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/google/android/gms/maps/model/LatLngBounds;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/maps/GoogleMapOptions;->latLngBoundsForCameraTarget(Lcom/google/android/gms/maps/model/LatLngBounds;)Lcom/google/android/gms/maps/GoogleMapOptions;

    invoke-static {p0, p1}, Lcom/google/android/gms/maps/GoogleMapOptions;->zza(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/google/android/gms/maps/model/CameraPosition;

    move-result-object p0

    invoke-virtual {v1, p0}, Lcom/google/android/gms/maps/GoogleMapOptions;->camera(Lcom/google/android/gms/maps/model/CameraPosition;)Lcom/google/android/gms/maps/GoogleMapOptions;

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    return-object v1

    :cond_140
    :goto_140
    const/4 p0, 0x0

    return-object p0
.end method

.method public static zza(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/google/android/gms/maps/model/CameraPosition;
    .registers 8

    if-eqz p0, :cond_6f

    if-nez p1, :cond_5

    goto :goto_6f

    :cond_5
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object p0

    sget-object v0, Lcom/google/android/gms/maps/R$styleable;->MapAttrs:[I

    invoke-virtual {p0, p1, v0}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object p0

    sget p1, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_cameraTargetLat:I

    invoke-virtual {p0, p1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_1d

    invoke-virtual {p0, p1, v1}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result p1

    goto :goto_1e

    :cond_1d
    const/4 p1, 0x0

    :goto_1e
    sget v0, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_cameraTargetLng:I

    invoke-virtual {p0, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v2

    if-eqz v2, :cond_2b

    invoke-virtual {p0, v0, v1}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v0

    goto :goto_2c

    :cond_2b
    const/4 v0, 0x0

    :goto_2c
    float-to-double v2, p1

    float-to-double v4, v0

    new-instance p1, Lcom/google/android/gms/maps/model/LatLng;

    invoke-direct {p1, v2, v3, v4, v5}, Lcom/google/android/gms/maps/model/LatLng;-><init>(DD)V

    invoke-static {}, Lcom/google/android/gms/maps/model/CameraPosition;->builder()Lcom/google/android/gms/maps/model/CameraPosition$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/gms/maps/model/CameraPosition$Builder;->target(Lcom/google/android/gms/maps/model/LatLng;)Lcom/google/android/gms/maps/model/CameraPosition$Builder;

    sget p1, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_cameraZoom:I

    invoke-virtual {p0, p1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v2

    if-eqz v2, :cond_49

    invoke-virtual {p0, p1, v1}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result p1

    invoke-virtual {v0, p1}, Lcom/google/android/gms/maps/model/CameraPosition$Builder;->zoom(F)Lcom/google/android/gms/maps/model/CameraPosition$Builder;

    :cond_49
    sget p1, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_cameraBearing:I

    invoke-virtual {p0, p1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v2

    if-eqz v2, :cond_58

    invoke-virtual {p0, p1, v1}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result p1

    invoke-virtual {v0, p1}, Lcom/google/android/gms/maps/model/CameraPosition$Builder;->bearing(F)Lcom/google/android/gms/maps/model/CameraPosition$Builder;

    :cond_58
    sget p1, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_cameraTilt:I

    invoke-virtual {p0, p1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v2

    if-eqz v2, :cond_67

    invoke-virtual {p0, p1, v1}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result p1

    invoke-virtual {v0, p1}, Lcom/google/android/gms/maps/model/CameraPosition$Builder;->tilt(F)Lcom/google/android/gms/maps/model/CameraPosition$Builder;

    :cond_67
    invoke-virtual {p0}, Landroid/content/res/TypedArray;->recycle()V

    invoke-virtual {v0}, Lcom/google/android/gms/maps/model/CameraPosition$Builder;->build()Lcom/google/android/gms/maps/model/CameraPosition;

    move-result-object p0

    return-object p0

    :cond_6f
    :goto_6f
    const/4 p0, 0x0

    return-object p0
.end method

.method public static zzb(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/google/android/gms/maps/model/LatLngBounds;
    .registers 8

    const/4 v0, 0x0

    if-eqz p0, :cond_89

    if-nez p1, :cond_7

    goto/16 :goto_89

    :cond_7
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object p0

    sget-object v1, Lcom/google/android/gms/maps/R$styleable;->MapAttrs:[I

    invoke-virtual {p0, p1, v1}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object p0

    sget p1, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_latLngBoundsSouthWestLatitude:I

    invoke-virtual {p0, p1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v1

    const/4 v2, 0x0

    if-eqz v1, :cond_23

    invoke-virtual {p0, p1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result p1

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    goto :goto_24

    :cond_23
    move-object p1, v0

    :goto_24
    sget v1, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_latLngBoundsSouthWestLongitude:I

    invoke-virtual {p0, v1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_35

    invoke-virtual {p0, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    goto :goto_36

    :cond_35
    move-object v1, v0

    :goto_36
    sget v3, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_latLngBoundsNorthEastLatitude:I

    invoke-virtual {p0, v3}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v4

    if-eqz v4, :cond_47

    invoke-virtual {p0, v3, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    goto :goto_48

    :cond_47
    move-object v3, v0

    :goto_48
    sget v4, Lcom/google/android/gms/maps/R$styleable;->MapAttrs_latLngBoundsNorthEastLongitude:I

    invoke-virtual {p0, v4}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v5

    if-eqz v5, :cond_59

    invoke-virtual {p0, v4, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    goto :goto_5a

    :cond_59
    move-object v2, v0

    :goto_5a
    invoke-virtual {p0}, Landroid/content/res/TypedArray;->recycle()V

    if-eqz p1, :cond_89

    if-eqz v1, :cond_89

    if-eqz v3, :cond_89

    if-nez v2, :cond_66

    goto :goto_89

    :cond_66
    new-instance p0, Lcom/google/android/gms/maps/model/LatLng;

    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result p1

    float-to-double v4, p1

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result p1

    float-to-double v0, p1

    invoke-direct {p0, v4, v5, v0, v1}, Lcom/google/android/gms/maps/model/LatLng;-><init>(DD)V

    new-instance p1, Lcom/google/android/gms/maps/model/LatLng;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v0

    float-to-double v0, v0

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    float-to-double v2, v2

    invoke-direct {p1, v0, v1, v2, v3}, Lcom/google/android/gms/maps/model/LatLng;-><init>(DD)V

    new-instance v0, Lcom/google/android/gms/maps/model/LatLngBounds;

    invoke-direct {v0, p0, p1}, Lcom/google/android/gms/maps/model/LatLngBounds;-><init>(Lcom/google/android/gms/maps/model/LatLng;Lcom/google/android/gms/maps/model/LatLng;)V

    :cond_89
    :goto_89
    return-object v0
.end method


# virtual methods
.method public ambientEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzn:Ljava/lang/Boolean;

    return-object p0
.end method

.method public backgroundColor(Ljava/lang/Integer;)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzs:Ljava/lang/Integer;

    return-object p0
.end method

.method public camera(Lcom/google/android/gms/maps/model/CameraPosition;)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zze:Lcom/google/android/gms/maps/model/CameraPosition;

    return-object p0
.end method

.method public compassEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzg:Ljava/lang/Boolean;

    return-object p0
.end method

.method public getAmbientEnabled()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzn:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getBackgroundColor()Ljava/lang/Integer;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzs:Ljava/lang/Integer;

    return-object v0
.end method

.method public getCamera()Lcom/google/android/gms/maps/model/CameraPosition;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zze:Lcom/google/android/gms/maps/model/CameraPosition;

    return-object v0
.end method

.method public getCompassEnabled()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzg:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getLatLngBoundsForCameraTarget()Lcom/google/android/gms/maps/model/LatLngBounds;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzq:Lcom/google/android/gms/maps/model/LatLngBounds;

    return-object v0
.end method

.method public getLiteMode()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzl:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getMapId()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzt:Ljava/lang/String;

    return-object v0
.end method

.method public getMapToolbarEnabled()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzm:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getMapType()I
    .registers 2

    iget v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzd:I

    return v0
.end method

.method public getMaxZoomPreference()Ljava/lang/Float;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzp:Ljava/lang/Float;

    return-object v0
.end method

.method public getMinZoomPreference()Ljava/lang/Float;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzo:Ljava/lang/Float;

    return-object v0
.end method

.method public getRotateGesturesEnabled()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzk:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getScrollGesturesEnabled()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzh:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getScrollGesturesEnabledDuringRotateOrZoom()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzr:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getTiltGesturesEnabled()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzj:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getUseViewLifecycleInFragment()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzc:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getZOrderOnTop()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzb:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getZoomControlsEnabled()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzf:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getZoomGesturesEnabled()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzi:Ljava/lang/Boolean;

    return-object v0
.end method

.method public latLngBoundsForCameraTarget(Lcom/google/android/gms/maps/model/LatLngBounds;)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzq:Lcom/google/android/gms/maps/model/LatLngBounds;

    return-object p0
.end method

.method public liteMode(Z)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzl:Ljava/lang/Boolean;

    return-object p0
.end method

.method public mapId(Ljava/lang/String;)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzt:Ljava/lang/String;

    return-object p0
.end method

.method public mapToolbarEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzm:Ljava/lang/Boolean;

    return-object p0
.end method

.method public mapType(I)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    iput p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzd:I

    return-object p0
.end method

.method public maxZoomPreference(F)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzp:Ljava/lang/Float;

    return-object p0
.end method

.method public minZoomPreference(F)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzo:Ljava/lang/Float;

    return-object p0
.end method

.method public rotateGesturesEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzk:Ljava/lang/Boolean;

    return-object p0
.end method

.method public scrollGesturesEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzh:Ljava/lang/Boolean;

    return-object p0
.end method

.method public scrollGesturesEnabledDuringRotateOrZoom(Z)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzr:Ljava/lang/Boolean;

    return-object p0
.end method

.method public tiltGesturesEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzj:Ljava/lang/Boolean;

    return-object p0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    invoke-static {p0}, Lcom/google/android/gms/common/internal/Objects;->toStringHelper(Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzd:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "MapType"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzl:Ljava/lang/Boolean;

    const-string v2, "LiteMode"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zze:Lcom/google/android/gms/maps/model/CameraPosition;

    const-string v2, "Camera"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzg:Ljava/lang/Boolean;

    const-string v2, "CompassEnabled"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzf:Ljava/lang/Boolean;

    const-string v2, "ZoomControlsEnabled"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzh:Ljava/lang/Boolean;

    const-string v2, "ScrollGesturesEnabled"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzi:Ljava/lang/Boolean;

    const-string v2, "ZoomGesturesEnabled"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzj:Ljava/lang/Boolean;

    const-string v2, "TiltGesturesEnabled"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzk:Ljava/lang/Boolean;

    const-string v2, "RotateGesturesEnabled"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzr:Ljava/lang/Boolean;

    const-string v2, "ScrollGesturesEnabledDuringRotateOrZoom"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzm:Ljava/lang/Boolean;

    const-string v2, "MapToolbarEnabled"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzn:Ljava/lang/Boolean;

    const-string v2, "AmbientEnabled"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzo:Ljava/lang/Float;

    const-string v2, "MinZoomPreference"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzp:Ljava/lang/Float;

    const-string v2, "MaxZoomPreference"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzs:Ljava/lang/Integer;

    const-string v2, "BackgroundColor"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzq:Lcom/google/android/gms/maps/model/LatLngBounds;

    const-string v2, "LatLngBoundsForCameraTarget"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzb:Ljava/lang/Boolean;

    const-string v2, "ZOrderOnTop"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzc:Ljava/lang/Boolean;

    const-string v2, "UseViewLifecycleInFragment"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/common/internal/Objects$ToStringHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/common/internal/Objects$ToStringHelper;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public useViewLifecycleInFragment(Z)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzc:Ljava/lang/Boolean;

    return-object p0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 7

    invoke-static {p1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->beginObjectHeader(Landroid/os/Parcel;)I

    move-result v0

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzb:Ljava/lang/Boolean;

    invoke-static {v1}, Lcom/google/android/gms/maps/internal/zza;->zza(Ljava/lang/Boolean;)B

    move-result v1

    const/4 v2, 0x2

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByte(Landroid/os/Parcel;IB)V

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzc:Ljava/lang/Boolean;

    invoke-static {v1}, Lcom/google/android/gms/maps/internal/zza;->zza(Ljava/lang/Boolean;)B

    move-result v1

    const/4 v2, 0x3

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByte(Landroid/os/Parcel;IB)V

    invoke-virtual {p0}, Lcom/google/android/gms/maps/GoogleMapOptions;->getMapType()I

    move-result v1

    const/4 v2, 0x4

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeInt(Landroid/os/Parcel;II)V

    invoke-virtual {p0}, Lcom/google/android/gms/maps/GoogleMapOptions;->getCamera()Lcom/google/android/gms/maps/model/CameraPosition;

    move-result-object v1

    const/4 v2, 0x5

    const/4 v3, 0x0

    invoke-static {p1, v2, v1, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeParcelable(Landroid/os/Parcel;ILandroid/os/Parcelable;IZ)V

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzf:Ljava/lang/Boolean;

    invoke-static {v1}, Lcom/google/android/gms/maps/internal/zza;->zza(Ljava/lang/Boolean;)B

    move-result v1

    const/4 v2, 0x6

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByte(Landroid/os/Parcel;IB)V

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzg:Ljava/lang/Boolean;

    invoke-static {v1}, Lcom/google/android/gms/maps/internal/zza;->zza(Ljava/lang/Boolean;)B

    move-result v1

    const/4 v2, 0x7

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByte(Landroid/os/Parcel;IB)V

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzh:Ljava/lang/Boolean;

    invoke-static {v1}, Lcom/google/android/gms/maps/internal/zza;->zza(Ljava/lang/Boolean;)B

    move-result v1

    const/16 v2, 0x8

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByte(Landroid/os/Parcel;IB)V

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzi:Ljava/lang/Boolean;

    invoke-static {v1}, Lcom/google/android/gms/maps/internal/zza;->zza(Ljava/lang/Boolean;)B

    move-result v1

    const/16 v2, 0x9

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByte(Landroid/os/Parcel;IB)V

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzj:Ljava/lang/Boolean;

    invoke-static {v1}, Lcom/google/android/gms/maps/internal/zza;->zza(Ljava/lang/Boolean;)B

    move-result v1

    const/16 v2, 0xa

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByte(Landroid/os/Parcel;IB)V

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzk:Ljava/lang/Boolean;

    invoke-static {v1}, Lcom/google/android/gms/maps/internal/zza;->zza(Ljava/lang/Boolean;)B

    move-result v1

    const/16 v2, 0xb

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByte(Landroid/os/Parcel;IB)V

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzl:Ljava/lang/Boolean;

    invoke-static {v1}, Lcom/google/android/gms/maps/internal/zza;->zza(Ljava/lang/Boolean;)B

    move-result v1

    const/16 v2, 0xc

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByte(Landroid/os/Parcel;IB)V

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzm:Ljava/lang/Boolean;

    invoke-static {v1}, Lcom/google/android/gms/maps/internal/zza;->zza(Ljava/lang/Boolean;)B

    move-result v1

    const/16 v2, 0xe

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByte(Landroid/os/Parcel;IB)V

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzn:Ljava/lang/Boolean;

    invoke-static {v1}, Lcom/google/android/gms/maps/internal/zza;->zza(Ljava/lang/Boolean;)B

    move-result v1

    const/16 v2, 0xf

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByte(Landroid/os/Parcel;IB)V

    invoke-virtual {p0}, Lcom/google/android/gms/maps/GoogleMapOptions;->getMinZoomPreference()Ljava/lang/Float;

    move-result-object v1

    const/16 v2, 0x10

    invoke-static {p1, v2, v1, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeFloatObject(Landroid/os/Parcel;ILjava/lang/Float;Z)V

    invoke-virtual {p0}, Lcom/google/android/gms/maps/GoogleMapOptions;->getMaxZoomPreference()Ljava/lang/Float;

    move-result-object v1

    const/16 v2, 0x11

    invoke-static {p1, v2, v1, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeFloatObject(Landroid/os/Parcel;ILjava/lang/Float;Z)V

    invoke-virtual {p0}, Lcom/google/android/gms/maps/GoogleMapOptions;->getLatLngBoundsForCameraTarget()Lcom/google/android/gms/maps/model/LatLngBounds;

    move-result-object v1

    const/16 v2, 0x12

    invoke-static {p1, v2, v1, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeParcelable(Landroid/os/Parcel;ILandroid/os/Parcelable;IZ)V

    iget-object p2, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzr:Ljava/lang/Boolean;

    invoke-static {p2}, Lcom/google/android/gms/maps/internal/zza;->zza(Ljava/lang/Boolean;)B

    move-result p2

    const/16 v1, 0x13

    invoke-static {p1, v1, p2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByte(Landroid/os/Parcel;IB)V

    invoke-virtual {p0}, Lcom/google/android/gms/maps/GoogleMapOptions;->getBackgroundColor()Ljava/lang/Integer;

    move-result-object p2

    const/16 v1, 0x14

    invoke-static {p1, v1, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeIntegerObject(Landroid/os/Parcel;ILjava/lang/Integer;Z)V

    invoke-virtual {p0}, Lcom/google/android/gms/maps/GoogleMapOptions;->getMapId()Ljava/lang/String;

    move-result-object p2

    const/16 v1, 0x15

    invoke-static {p1, v1, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->finishObjectHeader(Landroid/os/Parcel;I)V

    return-void
.end method

.method public zOrderOnTop(Z)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzb:Ljava/lang/Boolean;

    return-object p0
.end method

.method public zoomControlsEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzf:Ljava/lang/Boolean;

    return-object p0
.end method

.method public zoomGesturesEnabled(Z)Lcom/google/android/gms/maps/GoogleMapOptions;
    .registers 2

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMapOptions;->zzi:Ljava/lang/Boolean;

    return-object p0
.end method
