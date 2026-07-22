.class public final Lcom/google/android/gms/internal/auth/zzdo;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static zza(Lcom/google/android/gms/internal/auth/zzdj;)Lcom/google/android/gms/internal/auth/zzdj;
    .registers 2

    instance-of v0, p0, Lcom/google/android/gms/internal/auth/zzdm;

    if-nez v0, :cond_19

    instance-of v0, p0, Lcom/google/android/gms/internal/auth/zzdk;

    if-eqz v0, :cond_9

    goto :goto_19

    :cond_9
    instance-of v0, p0, Ljava/io/Serializable;

    if-eqz v0, :cond_13

    new-instance v0, Lcom/google/android/gms/internal/auth/zzdk;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/auth/zzdk;-><init>(Lcom/google/android/gms/internal/auth/zzdj;)V

    goto :goto_18

    :cond_13
    new-instance v0, Lcom/google/android/gms/internal/auth/zzdm;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/auth/zzdm;-><init>(Lcom/google/android/gms/internal/auth/zzdj;)V

    :goto_18
    return-object v0

    :cond_19
    :goto_19
    return-object p0
.end method

.method public static zzb(Ljava/lang/Object;)Lcom/google/android/gms/internal/auth/zzdj;
    .registers 2

    new-instance v0, Lcom/google/android/gms/internal/auth/zzdn;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/auth/zzdn;-><init>(Ljava/lang/Object;)V

    return-object v0
.end method
