.class public abstract Lcom/google/android/gms/internal/maps/zzao;
.super Lcom/google/android/gms/internal/maps/zzb;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/internal/maps/zzap;


# direct methods
.method public constructor <init>()V
    .registers 2

    const-string v0, "com.google.android.gms.maps.model.internal.ITileProviderDelegate"

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/maps/zzb;-><init>(Ljava/lang/String;)V

    return-void
.end method

.method public static zzc(Landroid/os/IBinder;)Lcom/google/android/gms/internal/maps/zzap;
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const-string v0, "com.google.android.gms.maps.model.internal.ITileProviderDelegate"

    invoke-interface {p0, v0}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    instance-of v1, v0, Lcom/google/android/gms/internal/maps/zzap;

    if-eqz v1, :cond_11

    check-cast v0, Lcom/google/android/gms/internal/maps/zzap;

    return-object v0

    :cond_11
    new-instance v0, Lcom/google/android/gms/internal/maps/zzan;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/maps/zzan;-><init>(Landroid/os/IBinder;)V

    return-object v0
.end method


# virtual methods
.method protected final zza(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 8

    const/4 p4, 0x0

    const/4 v0, 0x1

    if-ne p1, v0, :cond_27

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result p1

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    invoke-static {p2}, Lcom/google/android/gms/internal/maps/zzc;->zzc(Landroid/os/Parcel;)V

    invoke-interface {p0, p1, v1, v2}, Lcom/google/android/gms/internal/maps/zzap;->zzb(III)Lcom/google/android/gms/maps/model/Tile;

    move-result-object p1

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    if-nez p1, :cond_20

    invoke-virtual {p3, p4}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_26

    :cond_20
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    invoke-interface {p1, p3, v0}, Landroid/os/Parcelable;->writeToParcel(Landroid/os/Parcel;I)V

    :goto_26
    return v0

    :cond_27
    return p4
.end method
