.class final Lcom/android/billingclient/api/zzcg;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method static zza(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Lcom/android/billingclient/api/zzcf;
    .registers 10

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzj:Lcom/android/billingclient/api/BillingResult;

    const/4 v0, 0x0

    const/4 v1, 0x1

    const-string v2, "BillingClient"

    if-nez p0, :cond_1d

    new-array p0, v1, [Ljava/lang/Object;

    aput-object p2, p0, v0

    const-string p2, "%s got null owned items list"

    invoke-static {p2, p0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-static {v2, p0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    new-instance p0, Lcom/android/billingclient/api/zzcf;

    const/16 p2, 0x36

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/zzcf;-><init>(Lcom/android/billingclient/api/BillingResult;I)V

    return-object p0

    :cond_1d
    invoke-static {p0, v2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v3

    invoke-static {p0, v2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzg(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lcom/android/billingclient/api/BillingResult;->newBuilder()Lcom/android/billingclient/api/BillingResult$Builder;

    move-result-object v5

    invoke-virtual {v5, v3}, Lcom/android/billingclient/api/BillingResult$Builder;->setResponseCode(I)Lcom/android/billingclient/api/BillingResult$Builder;

    invoke-virtual {v5, v4}, Lcom/android/billingclient/api/BillingResult$Builder;->setDebugMessage(Ljava/lang/String;)Lcom/android/billingclient/api/BillingResult$Builder;

    invoke-virtual {v5}, Lcom/android/billingclient/api/BillingResult$Builder;->build()Lcom/android/billingclient/api/BillingResult;

    move-result-object v4

    if-eqz v3, :cond_51

    const/4 p0, 0x2

    new-array p0, p0, [Ljava/lang/Object;

    aput-object p2, p0, v0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    aput-object p1, p0, v1

    const-string p1, "%s failed. Response code: %s"

    invoke-static {p1, p0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-static {v2, p0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    new-instance p0, Lcom/android/billingclient/api/zzcf;

    const/16 p1, 0x17

    invoke-direct {p0, v4, p1}, Lcom/android/billingclient/api/zzcf;-><init>(Lcom/android/billingclient/api/BillingResult;I)V

    return-object p0

    :cond_51
    const-string v3, "INAPP_PURCHASE_ITEM_LIST"

    invoke-virtual {p0, v3}, Landroid/os/BaseBundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_c3

    const-string v4, "INAPP_PURCHASE_DATA_LIST"

    invoke-virtual {p0, v4}, Landroid/os/BaseBundle;->containsKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_c3

    const-string v5, "INAPP_DATA_SIGNATURE_LIST"

    invoke-virtual {p0, v5}, Landroid/os/BaseBundle;->containsKey(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_6a

    goto :goto_c3

    :cond_6a
    invoke-virtual {p0, v3}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {p0, v4}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {p0, v5}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object p0

    if-nez v3, :cond_8d

    new-array p0, v1, [Ljava/lang/Object;

    aput-object p2, p0, v0

    const-string p2, "Bundle returned from %s contains null SKUs list."

    invoke-static {p2, p0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-static {v2, p0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    new-instance p0, Lcom/android/billingclient/api/zzcf;

    const/16 p2, 0x38

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/zzcf;-><init>(Lcom/android/billingclient/api/BillingResult;I)V

    return-object p0

    :cond_8d
    if-nez v4, :cond_a4

    new-array p0, v1, [Ljava/lang/Object;

    aput-object p2, p0, v0

    const-string p2, "Bundle returned from %s contains null purchases list."

    invoke-static {p2, p0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-static {v2, p0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    new-instance p0, Lcom/android/billingclient/api/zzcf;

    const/16 p2, 0x39

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/zzcf;-><init>(Lcom/android/billingclient/api/BillingResult;I)V

    return-object p0

    :cond_a4
    if-nez p0, :cond_bb

    new-array p0, v1, [Ljava/lang/Object;

    aput-object p2, p0, v0

    const-string p2, "Bundle returned from %s contains null signatures list."

    invoke-static {p2, p0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-static {v2, p0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    new-instance p0, Lcom/android/billingclient/api/zzcf;

    const/16 p2, 0x3a

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/zzcf;-><init>(Lcom/android/billingclient/api/BillingResult;I)V

    return-object p0

    :cond_bb
    new-instance p0, Lcom/android/billingclient/api/zzcf;

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {p0, p1, v1}, Lcom/android/billingclient/api/zzcf;-><init>(Lcom/android/billingclient/api/BillingResult;I)V

    return-object p0

    :cond_c3
    :goto_c3
    new-array p0, v1, [Ljava/lang/Object;

    aput-object p2, p0, v0

    const-string p2, "Bundle returned from %s doesn\'t contain required fields."

    invoke-static {p2, p0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-static {v2, p0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    new-instance p0, Lcom/android/billingclient/api/zzcf;

    const/16 p2, 0x37

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/zzcf;-><init>(Lcom/android/billingclient/api/BillingResult;I)V

    return-object p0
.end method
