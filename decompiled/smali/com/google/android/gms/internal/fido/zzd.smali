.class public abstract Lcom/google/android/gms/internal/fido/zzd;
.super Lcom/google/android/gms/internal/fido/zzb;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/internal/fido/zze;


# direct methods
.method public constructor <init>()V
    .registers 2

    const-string v0, "com.google.android.gms.fido.fido2.api.IBooleanCallback"

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/fido/zzb;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected final zza(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 7

    const/4 p4, 0x0

    const/4 v0, 0x1

    if-eq p1, v0, :cond_17

    const/4 v1, 0x2

    if-eq p1, v1, :cond_8

    return p4

    :cond_8
    sget-object p1, Lcom/google/android/gms/common/api/Status;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/fido/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/api/Status;

    invoke-static {p2}, Lcom/google/android/gms/internal/fido/zzc;->zzc(Landroid/os/Parcel;)V

    invoke-interface {p0, p1}, Lcom/google/android/gms/internal/fido/zze;->zzc(Lcom/google/android/gms/common/api/Status;)V

    goto :goto_26

    :cond_17
    sget p1, Lcom/google/android/gms/internal/fido/zzc;->zza:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result p1

    invoke-static {p2}, Lcom/google/android/gms/internal/fido/zzc;->zzc(Landroid/os/Parcel;)V

    if-eqz p1, :cond_23

    const/4 p4, 0x1

    :cond_23
    invoke-interface {p0, p4}, Lcom/google/android/gms/internal/fido/zze;->zzb(Z)V

    :goto_26
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    return v0
.end method
