.class public abstract Lcom/google/android/gms/maps/internal/zzaa;
.super Lcom/google/android/gms/internal/maps/zzb;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/maps/internal/zzab;


# direct methods
.method public constructor <init>()V
    .registers 2

    const-string v0, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener"

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/maps/zzb;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected final zza(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 6

    const/4 p4, 0x1

    if-eq p1, p4, :cond_17

    const/4 v0, 0x2

    if-eq p1, v0, :cond_8

    const/4 p1, 0x0

    return p1

    :cond_8
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object p1

    invoke-static {p1}, Lcom/google/android/gms/internal/maps/zzt;->zzb(Landroid/os/IBinder;)Lcom/google/android/gms/internal/maps/zzu;

    move-result-object p1

    invoke-static {p2}, Lcom/google/android/gms/internal/maps/zzc;->zzc(Landroid/os/Parcel;)V

    invoke-interface {p0, p1}, Lcom/google/android/gms/maps/internal/zzab;->zzc(Lcom/google/android/gms/internal/maps/zzu;)V

    goto :goto_1a

    :cond_17
    invoke-interface {p0}, Lcom/google/android/gms/maps/internal/zzab;->zzb()V

    :goto_1a
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    return p4
.end method
