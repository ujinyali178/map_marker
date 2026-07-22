.class public abstract Lcom/google/android/gms/maps/internal/zzag;
.super Lcom/google/android/gms/internal/maps/zzb;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/maps/internal/zzah;


# direct methods
.method public constructor <init>()V
    .registers 2

    const-string v0, "com.google.android.gms.maps.internal.IOnInfoWindowLongClickListener"

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/maps/zzb;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected final zza(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 5

    const/4 p4, 0x1

    if-ne p1, p4, :cond_15

    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object p1

    invoke-static {p1}, Lcom/google/android/gms/internal/maps/zzac;->zzb(Landroid/os/IBinder;)Lcom/google/android/gms/internal/maps/zzad;

    move-result-object p1

    invoke-static {p2}, Lcom/google/android/gms/internal/maps/zzc;->zzc(Landroid/os/Parcel;)V

    invoke-interface {p0, p1}, Lcom/google/android/gms/maps/internal/zzah;->zzb(Lcom/google/android/gms/internal/maps/zzad;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    return p4

    :cond_15
    const/4 p1, 0x0

    return p1
.end method
