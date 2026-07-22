.class public abstract Lcom/google/android/gms/auth/account/zza;
.super Lcom/google/android/gms/internal/auth/zzb;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/auth/account/zzb;


# direct methods
.method public constructor <init>()V
    .registers 2

    const-string v0, "com.google.android.gms.auth.account.IWorkAccountCallback"

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/auth/zzb;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected final zza(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 6

    const/4 p3, 0x1

    if-eq p1, p3, :cond_18

    const/4 p4, 0x2

    const/4 v0, 0x0

    if-eq p1, p4, :cond_8

    return v0

    :cond_8
    sget p1, Lcom/google/android/gms/internal/auth/zzc;->zza:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result p1

    invoke-static {p2}, Lcom/google/android/gms/internal/auth/zzc;->zzb(Landroid/os/Parcel;)V

    if-eqz p1, :cond_14

    const/4 v0, 0x1

    :cond_14
    invoke-interface {p0, v0}, Lcom/google/android/gms/auth/account/zzb;->zzc(Z)V

    goto :goto_26

    :cond_18
    sget-object p1, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/auth/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Landroid/accounts/Account;

    invoke-static {p2}, Lcom/google/android/gms/internal/auth/zzc;->zzb(Landroid/os/Parcel;)V

    invoke-interface {p0, p1}, Lcom/google/android/gms/auth/account/zzb;->zzb(Landroid/accounts/Account;)V

    :goto_26
    return p3
.end method
