.class public abstract Lcom/google/android/gms/internal/play_billing/zzl;
.super Lcom/google/android/gms/internal/play_billing/zzq;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzm;


# direct methods
.method public static zzr(Landroid/os/IBinder;)Lcom/google/android/gms/internal/play_billing/zzm;
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const-string v0, "com.android.vending.billing.IInAppBillingService"

    invoke-interface {p0, v0}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    instance-of v1, v0, Lcom/google/android/gms/internal/play_billing/zzm;

    if-eqz v1, :cond_11

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzm;

    return-object v0

    :cond_11
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzk;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/play_billing/zzk;-><init>(Landroid/os/IBinder;)V

    return-object v0
.end method
