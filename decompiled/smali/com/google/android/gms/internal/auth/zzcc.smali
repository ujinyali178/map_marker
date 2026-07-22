.class public final Lcom/google/android/gms/internal/auth/zzcc;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static zza:Landroid/os/UserManager;

.field private static volatile zzb:Z


# direct methods
.method static constructor <clinit>()V
    .registers 1

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzcc;->zzb()Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    sput-boolean v0, Lcom/google/android/gms/internal/auth/zzcc;->zzb:Z

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static zza(Landroid/content/Context;)Z
    .registers 9

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzcc;->zzb()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_5e

    sget-boolean v0, Lcom/google/android/gms/internal/auth/zzcc;->zzb:Z

    if-eqz v0, :cond_c

    goto :goto_5e

    :cond_c
    const-class v0, Lcom/google/android/gms/internal/auth/zzcc;

    monitor-enter v0

    :try_start_f
    sget-boolean v2, Lcom/google/android/gms/internal/auth/zzcc;->zzb:Z

    if-eqz v2, :cond_15

    monitor-exit v0

    goto :goto_5e

    :cond_15
    const/4 v2, 0x1

    const/4 v3, 0x1

    :goto_17
    const/4 v4, 0x2

    const/4 v5, 0x0

    if-gt v3, v4, :cond_4e

    sget-object v4, Lcom/google/android/gms/internal/auth/zzcc;->zza:Landroid/os/UserManager;

    if-nez v4, :cond_29

    const-class v4, Landroid/os/UserManager;

    invoke-static {p0, v4}, Landroidx/core/app/g;->a(Landroid/content/Context;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/os/UserManager;

    sput-object v4, Lcom/google/android/gms/internal/auth/zzcc;->zza:Landroid/os/UserManager;

    :cond_29
    sget-object v4, Lcom/google/android/gms/internal/auth/zzcc;->zza:Landroid/os/UserManager;
    :try_end_2b
    .catchall {:try_start_f .. :try_end_2b} :catchall_5b

    if-nez v4, :cond_2f

    const/4 p0, 0x1

    goto :goto_53

    :cond_2f
    :try_start_2f
    invoke-static {v4}, Lcom/google/android/gms/internal/auth/a;->a(Landroid/os/UserManager;)Z

    move-result v6

    if-nez v6, :cond_3f

    invoke-static {}, Landroid/os/Process;->myUserHandle()Landroid/os/UserHandle;

    move-result-object v6

    invoke-virtual {v4, v6}, Landroid/os/UserManager;->isUserRunning(Landroid/os/UserHandle;)Z

    move-result p0
    :try_end_3d
    .catch Ljava/lang/NullPointerException; {:try_start_2f .. :try_end_3d} :catch_41
    .catchall {:try_start_2f .. :try_end_3d} :catchall_5b

    if-nez p0, :cond_4e

    :cond_3f
    const/4 p0, 0x1

    goto :goto_4f

    :catch_41
    move-exception v4

    :try_start_42
    const-string v6, "DirectBootUtils"

    const-string v7, "Failed to check if user is unlocked."

    invoke-static {v6, v7, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    sput-object v5, Lcom/google/android/gms/internal/auth/zzcc;->zza:Landroid/os/UserManager;

    add-int/lit8 v3, v3, 0x1

    goto :goto_17

    :cond_4e
    const/4 p0, 0x0

    :goto_4f
    if-eqz p0, :cond_53

    sput-object v5, Lcom/google/android/gms/internal/auth/zzcc;->zza:Landroid/os/UserManager;

    :cond_53
    :goto_53
    if-eqz p0, :cond_57

    sput-boolean v2, Lcom/google/android/gms/internal/auth/zzcc;->zzb:Z

    :cond_57
    monitor-exit v0

    if-nez p0, :cond_5e

    return v2

    :catchall_5b
    move-exception p0

    monitor-exit v0
    :try_end_5d
    .catchall {:try_start_42 .. :try_end_5d} :catchall_5b

    throw p0

    :cond_5e
    :goto_5e
    return v1
.end method

.method public static zzb()Z
    .registers 2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x18

    if-lt v0, v1, :cond_8

    const/4 v0, 0x1

    return v0

    :cond_8
    const/4 v0, 0x0

    return v0
.end method
