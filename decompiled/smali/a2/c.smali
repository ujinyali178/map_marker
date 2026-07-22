.class final La2/c;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements La2/a;


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static synthetic b(La2/c;La2/e$d;Lcom/android/billingclient/api/UserChoiceDetails;)V
    .registers 3

    invoke-direct {p0, p1, p2}, La2/c;->d(La2/e$d;Lcom/android/billingclient/api/UserChoiceDetails;)V

    return-void
.end method

.method private synthetic d(La2/e$d;Lcom/android/billingclient/api/UserChoiceDetails;)V
    .registers 4

    invoke-static {p2}, La2/i0;->o(Lcom/android/billingclient/api/UserChoiceDetails;)La2/e$y;

    move-result-object p2

    new-instance v0, La2/c$a;

    invoke-direct {v0, p0}, La2/c$a;-><init>(La2/c;)V

    invoke-virtual {p1, p2, v0}, La2/e$d;->j(La2/e$y;La2/e$b0;)V

    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;La2/e$d;La2/e$h;)Lcom/android/billingclient/api/BillingClient;
    .registers 6

    invoke-static {p1}, Lcom/android/billingclient/api/BillingClient;->newBuilder(Landroid/content/Context;)Lcom/android/billingclient/api/BillingClient$Builder;

    move-result-object p1

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingClient$Builder;->enablePendingPurchases()Lcom/android/billingclient/api/BillingClient$Builder;

    move-result-object p1

    sget-object v0, La2/c$b;->a:[I

    invoke-virtual {p3}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_3d

    const/4 v1, 0x2

    if-eq v0, v1, :cond_35

    const/4 v1, 0x3

    if-eq v0, v1, :cond_40

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Unknown BillingChoiceMode "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p3, ", Defaulting to PLAY_BILLING_ONLY"

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    const-string v0, "BillingClientFactoryImpl"

    invoke-static {v0, p3}, Lg1/b;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_40

    :cond_35
    invoke-virtual {p0, p2}, La2/c;->c(La2/e$d;)Lcom/android/billingclient/api/UserChoiceBillingListener;

    move-result-object p3

    invoke-virtual {p1, p3}, Lcom/android/billingclient/api/BillingClient$Builder;->enableUserChoiceBilling(Lcom/android/billingclient/api/UserChoiceBillingListener;)Lcom/android/billingclient/api/BillingClient$Builder;

    goto :goto_40

    :cond_3d
    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingClient$Builder;->enableAlternativeBillingOnly()Lcom/android/billingclient/api/BillingClient$Builder;

    :cond_40
    :goto_40
    new-instance p3, La2/h0;

    invoke-direct {p3, p2}, La2/h0;-><init>(La2/e$d;)V

    invoke-virtual {p1, p3}, Lcom/android/billingclient/api/BillingClient$Builder;->setListener(Lcom/android/billingclient/api/PurchasesUpdatedListener;)Lcom/android/billingclient/api/BillingClient$Builder;

    move-result-object p1

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingClient$Builder;->build()Lcom/android/billingclient/api/BillingClient;

    move-result-object p1

    return-object p1
.end method

.method c(La2/e$d;)Lcom/android/billingclient/api/UserChoiceBillingListener;
    .registers 3

    new-instance v0, La2/b;

    invoke-direct {v0, p0, p1}, La2/b;-><init>(La2/c;La2/e$d;)V

    return-object v0
.end method
