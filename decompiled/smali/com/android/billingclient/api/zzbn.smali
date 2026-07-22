.class final Lcom/android/billingclient/api/zzbn;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/android/billingclient/api/zzbi;


# instance fields
.field private final zza:Lcom/google/android/gms/internal/play_billing/zzio;

.field private final zzb:Lcom/android/billingclient/api/zzbp;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/play_billing/zzio;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/android/billingclient/api/zzbp;

    invoke-direct {v0, p1}, Lcom/android/billingclient/api/zzbp;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/android/billingclient/api/zzbn;->zzb:Lcom/android/billingclient/api/zzbp;

    iput-object p2, p0, Lcom/android/billingclient/api/zzbn;->zza:Lcom/google/android/gms/internal/play_billing/zzio;

    return-void
.end method


# virtual methods
.method public final zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V
    .registers 4

    if-nez p1, :cond_3

    return-void

    :cond_3
    :try_start_3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zziv;->zzv()Lcom/google/android/gms/internal/play_billing/zziu;

    move-result-object v0

    iget-object v1, p0, Lcom/android/billingclient/api/zzbn;->zza:Lcom/google/android/gms/internal/play_billing/zzio;

    if-eqz v1, :cond_e

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zziu;->zzk(Lcom/google/android/gms/internal/play_billing/zzio;)Lcom/google/android/gms/internal/play_billing/zziu;

    :cond_e
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zziu;->zzi(Lcom/google/android/gms/internal/play_billing/zzhy;)Lcom/google/android/gms/internal/play_billing/zziu;

    iget-object p1, p0, Lcom/android/billingclient/api/zzbn;->zzb:Lcom/android/billingclient/api/zzbp;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzet;->zzc()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zziv;

    invoke-virtual {p1, v0}, Lcom/android/billingclient/api/zzbp;->zza(Lcom/google/android/gms/internal/play_billing/zziv;)V
    :try_end_1c
    .catchall {:try_start_3 .. :try_end_1c} :catchall_1d

    return-void

    :catchall_1d
    const-string p1, "BillingLogger"

    const-string v0, "Unable to log."

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final zzb(Lcom/google/android/gms/internal/play_billing/zzic;)V
    .registers 4

    if-nez p1, :cond_3

    return-void

    :cond_3
    :try_start_3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zziv;->zzv()Lcom/google/android/gms/internal/play_billing/zziu;

    move-result-object v0

    iget-object v1, p0, Lcom/android/billingclient/api/zzbn;->zza:Lcom/google/android/gms/internal/play_billing/zzio;

    if-eqz v1, :cond_e

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zziu;->zzk(Lcom/google/android/gms/internal/play_billing/zzio;)Lcom/google/android/gms/internal/play_billing/zziu;

    :cond_e
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zziu;->zzj(Lcom/google/android/gms/internal/play_billing/zzic;)Lcom/google/android/gms/internal/play_billing/zziu;

    iget-object p1, p0, Lcom/android/billingclient/api/zzbn;->zzb:Lcom/android/billingclient/api/zzbp;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzet;->zzc()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zziv;

    invoke-virtual {p1, v0}, Lcom/android/billingclient/api/zzbp;->zza(Lcom/google/android/gms/internal/play_billing/zziv;)V
    :try_end_1c
    .catchall {:try_start_3 .. :try_end_1c} :catchall_1d

    return-void

    :catchall_1d
    const-string p1, "BillingLogger"

    const-string v0, "Unable to log."

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final zzc(Lcom/google/android/gms/internal/play_billing/zziz;)V
    .registers 4

    if-nez p1, :cond_3

    return-void

    :cond_3
    :try_start_3
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zziv;->zzv()Lcom/google/android/gms/internal/play_billing/zziu;

    move-result-object v0

    iget-object v1, p0, Lcom/android/billingclient/api/zzbn;->zza:Lcom/google/android/gms/internal/play_billing/zzio;

    if-eqz v1, :cond_e

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zziu;->zzk(Lcom/google/android/gms/internal/play_billing/zzio;)Lcom/google/android/gms/internal/play_billing/zziu;

    :cond_e
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zziu;->zzl(Lcom/google/android/gms/internal/play_billing/zziz;)Lcom/google/android/gms/internal/play_billing/zziu;

    iget-object p1, p0, Lcom/android/billingclient/api/zzbn;->zzb:Lcom/android/billingclient/api/zzbp;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzet;->zzc()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zziv;

    invoke-virtual {p1, v0}, Lcom/android/billingclient/api/zzbp;->zza(Lcom/google/android/gms/internal/play_billing/zziv;)V
    :try_end_1c
    .catchall {:try_start_3 .. :try_end_1c} :catchall_1d

    return-void

    :catchall_1d
    const-string p1, "BillingLogger"

    const-string v0, "Unable to log."

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
