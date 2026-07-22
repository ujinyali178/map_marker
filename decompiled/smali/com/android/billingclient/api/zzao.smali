.class final Lcom/android/billingclient/api/zzao;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/ServiceConnection;


# instance fields
.field final synthetic zza:Lcom/android/billingclient/api/BillingClientImpl;

.field private final zzb:Ljava/lang/Object;

.field private zzc:Z

.field private zzd:Lcom/android/billingclient/api/BillingClientStateListener;


# direct methods
.method synthetic constructor <init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingClientStateListener;Lcom/android/billingclient/api/zzan;)V
    .registers 4

    iput-object p1, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance p1, Ljava/lang/Object;

    invoke-direct {p1}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzao;->zzb:Ljava/lang/Object;

    const/4 p1, 0x0

    iput-boolean p1, p0, Lcom/android/billingclient/api/zzao;->zzc:Z

    iput-object p2, p0, Lcom/android/billingclient/api/zzao;->zzd:Lcom/android/billingclient/api/BillingClientStateListener;

    return-void
.end method

.method private final zzd(Lcom/android/billingclient/api/BillingResult;)V
    .registers 4

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zzb:Ljava/lang/Object;

    monitor-enter v0

    :try_start_3
    iget-object v1, p0, Lcom/android/billingclient/api/zzao;->zzd:Lcom/android/billingclient/api/BillingClientStateListener;

    if-eqz v1, :cond_a

    invoke-interface {v1, p1}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V

    :cond_a
    monitor-exit v0

    return-void

    :catchall_c
    move-exception p1

    monitor-exit v0
    :try_end_e
    .catchall {:try_start_3 .. :try_end_e} :catchall_c

    throw p1
.end method


# virtual methods
.method public final onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .registers 9

    const-string p1, "BillingClient"

    const-string v0, "Billing service connected."

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {p2}, Lcom/google/android/gms/internal/play_billing/zzl;->zzr(Landroid/os/IBinder;)Lcom/google/android/gms/internal/play_billing/zzm;

    move-result-object p2

    invoke-static {p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzJ(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzm;)V

    new-instance v1, Lcom/android/billingclient/api/zzal;

    invoke-direct {v1, p0}, Lcom/android/billingclient/api/zzal;-><init>(Lcom/android/billingclient/api/zzao;)V

    new-instance v4, Lcom/android/billingclient/api/zzam;

    invoke-direct {v4, p0}, Lcom/android/billingclient/api/zzam;-><init>(Lcom/android/billingclient/api/zzao;)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zze(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/os/Handler;

    move-result-object v5

    const-wide/16 v2, 0x7530

    invoke-static/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzt(Lcom/android/billingclient/api/BillingClientImpl;Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_3f

    iget-object p1, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzi(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/BillingResult;

    move-result-object p2

    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzh(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzbi;

    move-result-object p1

    const/16 v0, 0x19

    const/4 v1, 0x6

    invoke-static {v0, v1, p2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-direct {p0, p2}, Lcom/android/billingclient/api/zzao;->zzd(Lcom/android/billingclient/api/BillingResult;)V

    :cond_3f
    return-void
.end method

.method public final onServiceDisconnected(Landroid/content/ComponentName;)V
    .registers 3

    const-string p1, "BillingClient"

    const-string v0, "Billing service disconnected."

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {p1}, Lcom/android/billingclient/api/BillingClientImpl;->zzh(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzbi;

    move-result-object p1

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zziz;->zzw()Lcom/google/android/gms/internal/play_billing/zziz;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zzc(Lcom/google/android/gms/internal/play_billing/zziz;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    const/4 v0, 0x0

    invoke-static {p1, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzJ(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzm;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    const/4 v0, 0x0

    invoke-static {p1, v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzu(Lcom/android/billingclient/api/BillingClientImpl;I)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzao;->zzb:Ljava/lang/Object;

    monitor-enter p1

    :try_start_23
    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zzd:Lcom/android/billingclient/api/BillingClientStateListener;

    if-eqz v0, :cond_2a

    invoke-interface {v0}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingServiceDisconnected()V

    :cond_2a
    monitor-exit p1

    return-void

    :catchall_2c
    move-exception v0

    monitor-exit p1
    :try_end_2e
    .catchall {:try_start_23 .. :try_end_2e} :catchall_2c

    throw v0
.end method

.method final synthetic zza()Ljava/lang/Object;
    .registers 15

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zzb:Ljava/lang/Object;

    monitor-enter v0

    :try_start_3
    iget-boolean v1, p0, Lcom/android/billingclient/api/zzao;->zzc:Z

    const/4 v2, 0x0

    if-eqz v1, :cond_b

    monitor-exit v0

    goto/16 :goto_222

    :cond_b
    monitor-exit v0
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_223

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1d

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "accountName"

    invoke-virtual {v0, v1, v2}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1e

    :cond_1d
    move-object v0, v2

    :goto_1e
    const/4 v1, 0x6

    const/4 v3, 0x3

    const/4 v4, 0x0

    :try_start_21
    iget-object v5, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzb(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5
    :try_end_2b
    .catch Ljava/lang/Exception; {:try_start_21 .. :try_end_2b} :catch_1ec

    const/16 v6, 0x15

    const/16 v7, 0x15

    const/4 v8, 0x3

    :goto_30
    if-lt v7, v3, :cond_69

    if-nez v0, :cond_41

    :try_start_34
    iget-object v9, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v9}, Lcom/android/billingclient/api/BillingClientImpl;->zzj(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/google/android/gms/internal/play_billing/zzm;

    move-result-object v9

    const-string v10, "subs"

    invoke-interface {v9, v7, v5, v10}, Lcom/google/android/gms/internal/play_billing/zzm;->zzv(ILjava/lang/String;Ljava/lang/String;)I

    move-result v8

    goto :goto_4d

    :cond_41
    iget-object v9, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v9}, Lcom/android/billingclient/api/BillingClientImpl;->zzj(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/google/android/gms/internal/play_billing/zzm;

    move-result-object v9

    const-string v10, "subs"

    invoke-interface {v9, v7, v5, v10, v0}, Lcom/google/android/gms/internal/play_billing/zzm;->zzc(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)I

    move-result v8

    :goto_4d
    if-nez v8, :cond_66

    const-string v9, "BillingClient"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "highestLevelSupportedForSubs: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v10, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_6a

    :cond_66
    add-int/lit8 v7, v7, -0x1

    goto :goto_30

    :cond_69
    const/4 v7, 0x0

    :goto_6a
    iget-object v9, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    const/4 v10, 0x5

    const/4 v11, 0x1

    if-lt v7, v10, :cond_72

    const/4 v10, 0x1

    goto :goto_73

    :cond_72
    const/4 v10, 0x0

    :goto_73
    invoke-static {v9, v10}, Lcom/android/billingclient/api/BillingClientImpl;->zzK(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v9, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    if-lt v7, v3, :cond_7c

    const/4 v10, 0x1

    goto :goto_7d

    :cond_7c
    const/4 v10, 0x0

    :goto_7d
    invoke-static {v9, v10}, Lcom/android/billingclient/api/BillingClientImpl;->zzL(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    const/16 v9, 0x9

    if-ge v7, v3, :cond_8e

    const-string v7, "BillingClient"

    const-string v10, "In-app billing API does not support subscription on this device."

    invoke-static {v7, v10}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v7, 0x9

    goto :goto_8f

    :cond_8e
    const/4 v7, 0x1

    :goto_8f
    const/16 v10, 0x15

    :goto_91
    if-lt v10, v3, :cond_d5

    if-nez v0, :cond_a2

    iget-object v12, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v12}, Lcom/android/billingclient/api/BillingClientImpl;->zzj(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/google/android/gms/internal/play_billing/zzm;

    move-result-object v12

    const-string v13, "inapp"

    invoke-interface {v12, v10, v5, v13}, Lcom/google/android/gms/internal/play_billing/zzm;->zzv(ILjava/lang/String;Ljava/lang/String;)I

    move-result v8

    goto :goto_ae

    :cond_a2
    iget-object v12, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v12}, Lcom/android/billingclient/api/BillingClientImpl;->zzj(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/google/android/gms/internal/play_billing/zzm;

    move-result-object v12

    const-string v13, "inapp"

    invoke-interface {v12, v10, v5, v13, v0}, Lcom/google/android/gms/internal/play_billing/zzm;->zzc(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)I

    move-result v8

    :goto_ae
    if-nez v8, :cond_d2

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0, v10}, Lcom/android/billingclient/api/BillingClientImpl;->zzv(Lcom/android/billingclient/api/BillingClientImpl;I)V

    const-string v0, "BillingClient"

    iget-object v5, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v5}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "mHighestLevelSupportedForInApp: "

    invoke-virtual {v10, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v10, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v0, v5}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_d5

    :cond_d2
    add-int/lit8 v10, v10, -0x1

    goto :goto_91

    :cond_d5
    :goto_d5
    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    if-lt v5, v6, :cond_e0

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_e1

    :cond_e0
    const/4 v5, 0x0

    :goto_e1
    invoke-static {v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzF(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    const/16 v6, 0x14

    if-lt v5, v6, :cond_f1

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_f2

    :cond_f1
    const/4 v5, 0x0

    :goto_f2
    invoke-static {v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzE(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    const/16 v6, 0x13

    if-lt v5, v6, :cond_102

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_103

    :cond_102
    const/4 v5, 0x0

    :goto_103
    invoke-static {v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzD(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    const/16 v6, 0x12

    if-lt v5, v6, :cond_113

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_114

    :cond_113
    const/4 v5, 0x0

    :goto_114
    invoke-static {v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzC(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    const/16 v6, 0x11

    if-lt v5, v6, :cond_124

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_125

    :cond_124
    const/4 v5, 0x0

    :goto_125
    invoke-static {v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzB(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    const/16 v6, 0x10

    if-lt v5, v6, :cond_135

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_136

    :cond_135
    const/4 v5, 0x0

    :goto_136
    invoke-static {v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzA(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    const/16 v6, 0xf

    if-lt v5, v6, :cond_146

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_147

    :cond_146
    const/4 v5, 0x0

    :goto_147
    invoke-static {v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzz(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    const/16 v6, 0xe

    if-lt v5, v6, :cond_157

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_158

    :cond_157
    const/4 v5, 0x0

    :goto_158
    invoke-static {v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzy(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    const/16 v6, 0xc

    if-lt v5, v6, :cond_168

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_169

    :cond_168
    const/4 v5, 0x0

    :goto_169
    invoke-static {v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzx(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    const/16 v6, 0xa

    if-lt v5, v6, :cond_179

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_17a

    :cond_179
    const/4 v5, 0x0

    :goto_17a
    invoke-static {v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzw(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    if-lt v5, v9, :cond_188

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_189

    :cond_188
    const/4 v5, 0x0

    :goto_189
    invoke-static {v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzI(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    const/16 v6, 0x8

    if-lt v5, v6, :cond_199

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_19a

    :cond_199
    const/4 v5, 0x0

    :goto_19a
    invoke-static {v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzH(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v5

    if-lt v5, v1, :cond_1a6

    goto :goto_1a7

    :cond_1a6
    const/4 v11, 0x0

    :goto_1a7
    invoke-static {v0, v11}, Lcom/android/billingclient/api/BillingClientImpl;->zzG(Lcom/android/billingclient/api/BillingClientImpl;Z)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zza(Lcom/android/billingclient/api/BillingClientImpl;)I

    move-result v0

    if-ge v0, v3, :cond_1bb

    const-string v0, "BillingClient"

    const-string v3, "In-app billing API version 3 is not supported on this device."

    invoke-static {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v7, 0x24

    :cond_1bb
    if-nez v8, :cond_1de

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    const/4 v3, 0x2

    invoke-static {v0, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzu(Lcom/android/billingclient/api/BillingClientImpl;I)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzf(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzh;

    move-result-object v0

    if-eqz v0, :cond_201

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzf(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzh;

    move-result-object v0

    iget-object v3, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzb(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    invoke-virtual {v0, v4}, Lcom/android/billingclient/api/zzh;->zzf(Z)V

    goto :goto_201

    :cond_1de
    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0, v4}, Lcom/android/billingclient/api/BillingClientImpl;->zzu(Lcom/android/billingclient/api/BillingClientImpl;I)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzJ(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzm;)V
    :try_end_1e8
    .catch Ljava/lang/Exception; {:try_start_34 .. :try_end_1e8} :catch_1e9

    goto :goto_201

    :catch_1e9
    move-exception v0

    move v3, v8

    goto :goto_1ed

    :catch_1ec
    move-exception v0

    :goto_1ed
    const-string v5, "BillingClient"

    const-string v6, "Exception while checking if billing is supported; try to reconnect"

    invoke-static {v5, v6, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0, v4}, Lcom/android/billingclient/api/BillingClientImpl;->zzu(Lcom/android/billingclient/api/BillingClientImpl;I)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzJ(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzm;)V

    const/16 v7, 0x2a

    move v8, v3

    :cond_201
    :goto_201
    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzh(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzbi;

    move-result-object v0

    if-nez v8, :cond_216

    invoke-static {v1}, Lcom/android/billingclient/api/zzbh;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzic;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zzb(Lcom/google/android/gms/internal/play_billing/zzic;)V

    sget-object v0, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, v0}, Lcom/android/billingclient/api/zzao;->zzd(Lcom/android/billingclient/api/BillingResult;)V

    goto :goto_222

    :cond_216
    sget-object v3, Lcom/android/billingclient/api/zzbk;->zza:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v7, v1, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-direct {p0, v3}, Lcom/android/billingclient/api/zzao;->zzd(Lcom/android/billingclient/api/BillingResult;)V

    :goto_222
    return-object v2

    :catchall_223
    move-exception v1

    :try_start_224
    monitor-exit v0
    :try_end_225
    .catchall {:try_start_224 .. :try_end_225} :catchall_223

    throw v1
.end method

.method final synthetic zzb()V
    .registers 5

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzu(Lcom/android/billingclient/api/BillingClientImpl;I)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzJ(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzm;)V

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zza:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v0}, Lcom/android/billingclient/api/BillingClientImpl;->zzh(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzbi;

    move-result-object v0

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzn:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0x18

    const/4 v3, 0x6

    invoke-static {v2, v3, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-direct {p0, v1}, Lcom/android/billingclient/api/zzao;->zzd(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method final zzc()V
    .registers 3

    iget-object v0, p0, Lcom/android/billingclient/api/zzao;->zzb:Ljava/lang/Object;

    monitor-enter v0

    const/4 v1, 0x0

    :try_start_4
    iput-object v1, p0, Lcom/android/billingclient/api/zzao;->zzd:Lcom/android/billingclient/api/BillingClientStateListener;

    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/android/billingclient/api/zzao;->zzc:Z

    monitor-exit v0

    return-void

    :catchall_b
    move-exception v1

    monitor-exit v0
    :try_end_d
    .catchall {:try_start_4 .. :try_end_d} :catchall_b

    throw v1
.end method
