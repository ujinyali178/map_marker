.class public final Lcom/google/android/gms/internal/location/zzdf;
.super Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;
.source "SourceFile"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/google/android/gms/internal/location/zzdf;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final zza:I

.field private final zzb:Lcom/google/android/gms/internal/location/zzdd;

.field private final zzc:Lcom/google/android/gms/location/zzu;

.field private final zzd:Lcom/google/android/gms/location/zzr;

.field private final zze:Landroid/app/PendingIntent;

.field private final zzf:Lcom/google/android/gms/internal/location/zzk;

.field private final zzg:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/android/gms/internal/location/zzdg;

    invoke-direct {v0}, Lcom/google/android/gms/internal/location/zzdg;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/location/zzdf;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method constructor <init>(ILcom/google/android/gms/internal/location/zzdd;Landroid/os/IBinder;Landroid/os/IBinder;Landroid/app/PendingIntent;Landroid/os/IBinder;Ljava/lang/String;)V
    .registers 8

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/location/zzdf;->zza:I

    iput-object p2, p0, Lcom/google/android/gms/internal/location/zzdf;->zzb:Lcom/google/android/gms/internal/location/zzdd;

    const/4 p1, 0x0

    if-eqz p3, :cond_f

    invoke-static {p3}, Lcom/google/android/gms/location/zzt;->zzb(Landroid/os/IBinder;)Lcom/google/android/gms/location/zzu;

    move-result-object p2

    goto :goto_10

    :cond_f
    move-object p2, p1

    :goto_10
    iput-object p2, p0, Lcom/google/android/gms/internal/location/zzdf;->zzc:Lcom/google/android/gms/location/zzu;

    iput-object p5, p0, Lcom/google/android/gms/internal/location/zzdf;->zze:Landroid/app/PendingIntent;

    if-eqz p4, :cond_1b

    invoke-static {p4}, Lcom/google/android/gms/location/zzq;->zzb(Landroid/os/IBinder;)Lcom/google/android/gms/location/zzr;

    move-result-object p2

    goto :goto_1c

    :cond_1b
    move-object p2, p1

    :goto_1c
    iput-object p2, p0, Lcom/google/android/gms/internal/location/zzdf;->zzd:Lcom/google/android/gms/location/zzr;

    if-eqz p6, :cond_32

    const-string p1, "com.google.android.gms.location.internal.IFusedLocationProviderCallback"

    invoke-interface {p6, p1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object p1

    instance-of p2, p1, Lcom/google/android/gms/internal/location/zzk;

    if-eqz p2, :cond_2d

    check-cast p1, Lcom/google/android/gms/internal/location/zzk;

    goto :goto_32

    :cond_2d
    new-instance p1, Lcom/google/android/gms/internal/location/zzi;

    invoke-direct {p1, p6}, Lcom/google/android/gms/internal/location/zzi;-><init>(Landroid/os/IBinder;)V

    :cond_32
    :goto_32
    iput-object p1, p0, Lcom/google/android/gms/internal/location/zzdf;->zzf:Lcom/google/android/gms/internal/location/zzk;

    iput-object p7, p0, Lcom/google/android/gms/internal/location/zzdf;->zzg:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public final writeToParcel(Landroid/os/Parcel;I)V
    .registers 8

    invoke-static {p1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->beginObjectHeader(Landroid/os/Parcel;)I

    move-result v0

    iget v1, p0, Lcom/google/android/gms/internal/location/zzdf;->zza:I

    const/4 v2, 0x1

    invoke-static {p1, v2, v1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeInt(Landroid/os/Parcel;II)V

    iget-object v1, p0, Lcom/google/android/gms/internal/location/zzdf;->zzb:Lcom/google/android/gms/internal/location/zzdd;

    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-static {p1, v2, v1, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeParcelable(Landroid/os/Parcel;ILandroid/os/Parcelable;IZ)V

    iget-object v1, p0, Lcom/google/android/gms/internal/location/zzdf;->zzc:Lcom/google/android/gms/location/zzu;

    const/4 v2, 0x0

    if-nez v1, :cond_18

    move-object v1, v2

    goto :goto_1c

    :cond_18
    invoke-interface {v1}, Landroid/os/IInterface;->asBinder()Landroid/os/IBinder;

    move-result-object v1

    :goto_1c
    const/4 v4, 0x3

    invoke-static {p1, v4, v1, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeIBinder(Landroid/os/Parcel;ILandroid/os/IBinder;Z)V

    const/4 v1, 0x4

    iget-object v4, p0, Lcom/google/android/gms/internal/location/zzdf;->zze:Landroid/app/PendingIntent;

    invoke-static {p1, v1, v4, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeParcelable(Landroid/os/Parcel;ILandroid/os/Parcelable;IZ)V

    iget-object p2, p0, Lcom/google/android/gms/internal/location/zzdf;->zzd:Lcom/google/android/gms/location/zzr;

    if-nez p2, :cond_2c

    move-object p2, v2

    goto :goto_30

    :cond_2c
    invoke-interface {p2}, Landroid/os/IInterface;->asBinder()Landroid/os/IBinder;

    move-result-object p2

    :goto_30
    const/4 v1, 0x5

    invoke-static {p1, v1, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeIBinder(Landroid/os/Parcel;ILandroid/os/IBinder;Z)V

    iget-object p2, p0, Lcom/google/android/gms/internal/location/zzdf;->zzf:Lcom/google/android/gms/internal/location/zzk;

    if-nez p2, :cond_39

    goto :goto_3d

    :cond_39
    invoke-interface {p2}, Landroid/os/IInterface;->asBinder()Landroid/os/IBinder;

    move-result-object v2

    :goto_3d
    const/4 p2, 0x6

    invoke-static {p1, p2, v2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeIBinder(Landroid/os/Parcel;ILandroid/os/IBinder;Z)V

    const/16 p2, 0x8

    iget-object v1, p0, Lcom/google/android/gms/internal/location/zzdf;->zzg:Ljava/lang/String;

    invoke-static {p1, p2, v1, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->finishObjectHeader(Landroid/os/Parcel;I)V

    return-void
.end method
