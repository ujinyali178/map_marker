.class final Lcom/android/billingclient/api/zzak;
.super Landroid/os/ResultReceiver;
.source "SourceFile"


# instance fields
.field final synthetic zza:Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;

.field final synthetic zzb:Lcom/android/billingclient/api/BillingClientImpl;


# direct methods
.method constructor <init>(Lcom/android/billingclient/api/BillingClientImpl;Landroid/os/Handler;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;)V
    .registers 4

    iput-object p1, p0, Lcom/android/billingclient/api/zzak;->zzb:Lcom/android/billingclient/api/BillingClientImpl;

    iput-object p3, p0, Lcom/android/billingclient/api/zzak;->zza:Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;

    invoke-direct {p0, p2}, Landroid/os/ResultReceiver;-><init>(Landroid/os/Handler;)V

    return-void
.end method


# virtual methods
.method public final onReceiveResult(ILandroid/os/Bundle;)V
    .registers 9

    invoke-static {}, Lcom/android/billingclient/api/BillingResult;->newBuilder()Lcom/android/billingclient/api/BillingResult$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/android/billingclient/api/BillingResult$Builder;->setResponseCode(I)Lcom/android/billingclient/api/BillingResult$Builder;

    if-eqz p1, :cond_83

    const/16 p1, 0x10

    if-nez p2, :cond_24

    iget-object p2, p0, Lcom/android/billingclient/api/zzak;->zzb:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzh(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzbi;

    move-result-object p2

    const/16 v0, 0x49

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, p1, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object p1

    invoke-interface {p2, p1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    iget-object p1, p0, Lcom/android/billingclient/api/zzak;->zza:Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;

    invoke-interface {p1, v1}, Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;->onAlternativeBillingOnlyInformationDialogResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    :cond_24
    const-string v1, "BillingClient"

    invoke-static {p2, v1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzg(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/billingclient/api/BillingResult$Builder;->setDebugMessage(Ljava/lang/String;)Lcom/android/billingclient/api/BillingResult$Builder;

    const-string v1, "INTERNAL_LOG_ERROR_REASON"

    invoke-virtual {p2, v1}, Landroid/os/BaseBundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iget-object v2, p0, Lcom/android/billingclient/api/zzak;->zzb:Lcom/android/billingclient/api/BillingClientImpl;

    invoke-static {v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzh(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzbi;

    move-result-object v2

    if-eqz v1, :cond_40

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzih;->zza(I)I

    move-result v1

    goto :goto_42

    :cond_40
    const/16 v1, 0x17

    :goto_42
    invoke-virtual {v0}, Lcom/android/billingclient/api/BillingResult$Builder;->build()Lcom/android/billingclient/api/BillingResult;

    move-result-object v3

    const-string v4, "INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS"

    invoke-virtual {p2, v4}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    :try_start_4c
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzii;->zzv()Lcom/google/android/gms/internal/play_billing/zzie;

    move-result-object v4

    invoke-virtual {v3}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/google/android/gms/internal/play_billing/zzie;->zzk(I)Lcom/google/android/gms/internal/play_billing/zzie;

    invoke-virtual {v3}, Lcom/android/billingclient/api/BillingResult;->getDebugMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Lcom/google/android/gms/internal/play_billing/zzie;->zzj(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzie;

    invoke-virtual {v4, v1}, Lcom/google/android/gms/internal/play_billing/zzie;->zzl(I)Lcom/google/android/gms/internal/play_billing/zzie;

    if-eqz p2, :cond_66

    invoke-virtual {v4, p2}, Lcom/google/android/gms/internal/play_billing/zzie;->zzi(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzie;

    :cond_66
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhy;->zzv()Lcom/google/android/gms/internal/play_billing/zzhx;

    move-result-object p2

    invoke-virtual {p2, v4}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzi(Lcom/google/android/gms/internal/play_billing/zzie;)Lcom/google/android/gms/internal/play_billing/zzhx;

    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzk(I)Lcom/google/android/gms/internal/play_billing/zzhx;

    invoke-virtual {p2}, Lcom/google/android/gms/internal/play_billing/zzet;->zzc()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzhy;
    :try_end_76
    .catch Ljava/lang/Exception; {:try_start_4c .. :try_end_76} :catch_77

    goto :goto_80

    :catch_77
    move-exception p1

    const-string p2, "BillingLogger"

    const-string v1, "Unable to create logging payload"

    invoke-static {p2, v1, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 p1, 0x0

    :goto_80
    invoke-interface {v2, p1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    :cond_83
    iget-object p1, p0, Lcom/android/billingclient/api/zzak;->zza:Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;

    invoke-virtual {v0}, Lcom/android/billingclient/api/BillingResult$Builder;->build()Lcom/android/billingclient/api/BillingResult;

    move-result-object p2

    invoke-interface {p1, p2}, Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;->onAlternativeBillingOnlyInformationDialogResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method
