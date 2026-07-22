.class public final Lcom/google/android/gms/internal/play_billing/zzcb;
.super Lcom/google/android/gms/internal/play_billing/zzbw;
.source "SourceFile"


# static fields
.field private static final zza:Z

.field private static final zzb:Z

.field private static final zzc:Lcom/google/android/gms/internal/play_billing/zzbv;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzcb$zza;->zza()Z

    move-result v0

    sput-boolean v0, Lcom/google/android/gms/internal/play_billing/zzcb;->zza:Z

    sget-object v0, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    const/4 v1, 0x1

    if-eqz v0, :cond_15

    const-string v2, "robolectric"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_14

    goto :goto_15

    :cond_14
    const/4 v1, 0x0

    :cond_15
    :goto_15
    sput-boolean v1, Lcom/google/android/gms/internal/play_billing/zzcb;->zzb:Z

    const-class v0, Landroid/util/Log;

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzcb$1;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzcb$1;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzcb;->zzc:Lcom/google/android/gms/internal/play_billing/zzbv;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzbw;-><init>()V

    return-void
.end method

.method static zzp()Ljava/lang/Class;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class<",
            "*>;"
        }
    .end annotation

    invoke-static {}, Ldalvik/system/VMStack;->getStackClass2()Ljava/lang/Class;

    move-result-object v0

    return-object v0
.end method

.method static zzq()Ljava/lang/String;
    .registers 1

    :try_start_0
    invoke-static {}, Ldalvik/system/VMStack;->getStackClass2()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0
    :try_end_8
    .catchall {:try_start_0 .. :try_end_8} :catchall_9

    return-object v0

    :catchall_9
    const/4 v0, 0x0

    return-object v0
.end method

.method static bridge synthetic zzr()Z
    .registers 1

    sget-boolean v0, Lcom/google/android/gms/internal/play_billing/zzcb;->zzb:Z

    return v0
.end method

.method static bridge synthetic zzs()Z
    .registers 1

    sget-boolean v0, Lcom/google/android/gms/internal/play_billing/zzcb;->zza:Z

    return v0
.end method

.method static zzt()Z
    .registers 4

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "dalvik.system.VMStack"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    const-string v2, "getStackClass2"

    new-array v3, v0, [Ljava/lang/Class;

    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzcb;->zzq()Ljava/lang/String;

    move-result-object v1

    const-class v2, Lcom/google/android/gms/internal/play_billing/zzcb$zza;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0
    :try_end_1c
    .catchall {:try_start_1 .. :try_end_1c} :catchall_1c

    :catchall_1c
    return v0
.end method


# virtual methods
.method protected zze(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzbf;
    .registers 2

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzce;->zzb(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzbf;

    move-result-object p1

    return-object p1
.end method

.method protected zzh()Lcom/google/android/gms/internal/play_billing/zzbv;
    .registers 2

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzcb;->zzc:Lcom/google/android/gms/internal/play_billing/zzbv;

    return-object v0
.end method

.method protected zzj()Lcom/google/android/gms/internal/play_billing/zzcl;
    .registers 2

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzcf;->zzb()Lcom/google/android/gms/internal/play_billing/zzcf;

    move-result-object v0

    return-object v0
.end method

.method protected zzm()Ljava/lang/String;
    .registers 2

    const-string v0, "platform: Android"

    return-object v0
.end method
