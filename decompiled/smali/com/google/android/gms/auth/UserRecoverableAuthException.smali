.class public Lcom/google/android/gms/auth/UserRecoverableAuthException;
.super Lcom/google/android/gms/auth/GoogleAuthException;
.source "SourceFile"


# instance fields
.field private final zza:Landroid/content/Intent;

.field private final zzb:Landroid/app/PendingIntent;

.field private final zzc:Lcom/google/android/gms/auth/zzn;


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/content/Intent;)V
    .registers 5

    sget-object v0, Lcom/google/android/gms/auth/zzn;->zza:Lcom/google/android/gms/auth/zzn;

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v1, v0}, Lcom/google/android/gms/auth/UserRecoverableAuthException;-><init>(Ljava/lang/String;Landroid/content/Intent;Landroid/app/PendingIntent;Lcom/google/android/gms/auth/zzn;)V

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Landroid/content/Intent;Landroid/app/PendingIntent;Lcom/google/android/gms/auth/zzn;)V
    .registers 5

    invoke-direct {p0, p1}, Lcom/google/android/gms/auth/GoogleAuthException;-><init>(Ljava/lang/String;)V

    iput-object p3, p0, Lcom/google/android/gms/auth/UserRecoverableAuthException;->zzb:Landroid/app/PendingIntent;

    iput-object p2, p0, Lcom/google/android/gms/auth/UserRecoverableAuthException;->zza:Landroid/content/Intent;

    invoke-static {p4}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/auth/zzn;

    iput-object p1, p0, Lcom/google/android/gms/auth/UserRecoverableAuthException;->zzc:Lcom/google/android/gms/auth/zzn;

    return-void
.end method

.method public static zza(Ljava/lang/String;Landroid/content/Intent;Landroid/app/PendingIntent;)Lcom/google/android/gms/auth/UserRecoverableAuthException;
    .registers 5

    invoke-static {p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {p2}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v0, Lcom/google/android/gms/auth/UserRecoverableAuthException;

    sget-object v1, Lcom/google/android/gms/auth/zzn;->zzb:Lcom/google/android/gms/auth/zzn;

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/google/android/gms/auth/UserRecoverableAuthException;-><init>(Ljava/lang/String;Landroid/content/Intent;Landroid/app/PendingIntent;Lcom/google/android/gms/auth/zzn;)V

    return-object v0
.end method


# virtual methods
.method public getIntent()Landroid/content/Intent;
    .registers 4

    iget-object v0, p0, Lcom/google/android/gms/auth/UserRecoverableAuthException;->zza:Landroid/content/Intent;

    if-nez v0, :cond_25

    iget-object v0, p0, Lcom/google/android/gms/auth/UserRecoverableAuthException;->zzc:Lcom/google/android/gms/auth/zzn;

    invoke-virtual {v0}, Ljava/lang/Enum;->ordinal()I

    move-result v0

    const-string v1, "Auth"

    if-eqz v0, :cond_1e

    const/4 v2, 0x1

    if-eq v0, v2, :cond_18

    const/4 v2, 0x2

    if-eq v0, v2, :cond_15

    goto :goto_23

    :cond_15
    const-string v0, "this instantiation of UserRecoverableAuthException doesn\'t support an Intent."

    goto :goto_1a

    :cond_18
    const-string v0, "This shouldn\'t happen. Gms API throwing this exception should support the recovery Intent."

    :goto_1a
    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_23

    :cond_1e
    const-string v0, "Make sure that an intent was provided to class instantiation."

    invoke-static {v1, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :goto_23
    const/4 v0, 0x0

    return-object v0

    :cond_25
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1, v0}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    return-object v1
.end method
