.class public final synthetic Lcom/google/android/gms/internal/auth/zzcj;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static zza(Lcom/google/android/gms/internal/auth/zzck;)Ljava/lang/Object;
    .registers 3

    :try_start_0
    invoke-interface {p0}, Lcom/google/android/gms/internal/auth/zzck;->zza()Ljava/lang/Object;

    move-result-object p0
    :try_end_4
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_4} :catch_5

    goto :goto_10

    :catch_5
    invoke-static {}, Landroid/os/Binder;->clearCallingIdentity()J

    move-result-wide v0

    :try_start_9
    invoke-interface {p0}, Lcom/google/android/gms/internal/auth/zzck;->zza()Ljava/lang/Object;

    move-result-object p0
    :try_end_d
    .catchall {:try_start_9 .. :try_end_d} :catchall_11

    invoke-static {v0, v1}, Landroid/os/Binder;->restoreCallingIdentity(J)V

    :goto_10
    return-object p0

    :catchall_11
    move-exception p0

    invoke-static {v0, v1}, Landroid/os/Binder;->restoreCallingIdentity(J)V

    throw p0
.end method
