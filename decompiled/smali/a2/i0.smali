.class La2/i0;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method static a(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)La2/e$g;
    .registers 3

    new-instance v0, La2/e$g$a;

    invoke-direct {v0}, La2/e$g$a;-><init>()V

    invoke-static {p0}, La2/i0;->c(Lcom/android/billingclient/api/BillingResult;)La2/e$k;

    move-result-object p0

    invoke-virtual {v0, p0}, La2/e$g$a;->b(La2/e$k;)La2/e$g$a;

    move-result-object p0

    if-nez p1, :cond_12

    const-string p1, ""

    goto :goto_16

    :cond_12
    invoke-virtual {p1}, Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;->getExternalTransactionToken()Ljava/lang/String;

    move-result-object p1

    :goto_16
    invoke-virtual {p0, p1}, La2/e$g$a;->c(Ljava/lang/String;)La2/e$g$a;

    move-result-object p0

    invoke-virtual {p0}, La2/e$g$a;->a()La2/e$g;

    move-result-object p0

    return-object p0
.end method

.method static b(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)La2/e$i;
    .registers 3

    new-instance v0, La2/e$i$a;

    invoke-direct {v0}, La2/e$i$a;-><init>()V

    invoke-static {p0}, La2/i0;->c(Lcom/android/billingclient/api/BillingResult;)La2/e$k;

    move-result-object p0

    invoke-virtual {v0, p0}, La2/e$i$a;->b(La2/e$k;)La2/e$i$a;

    move-result-object p0

    if-nez p1, :cond_12

    const-string p1, ""

    goto :goto_16

    :cond_12
    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingConfig;->getCountryCode()Ljava/lang/String;

    move-result-object p1

    :goto_16
    invoke-virtual {p0, p1}, La2/e$i$a;->c(Ljava/lang/String;)La2/e$i$a;

    move-result-object p0

    invoke-virtual {p0}, La2/e$i$a;->a()La2/e$i;

    move-result-object p0

    return-object p0
.end method

.method static c(Lcom/android/billingclient/api/BillingResult;)La2/e$k;
    .registers 4

    new-instance v0, La2/e$k$a;

    invoke-direct {v0}, La2/e$k$a;-><init>()V

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v1

    int-to-long v1, v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$k$a;->c(Ljava/lang/Long;)La2/e$k$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingResult;->getDebugMessage()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, La2/e$k$a;->b(Ljava/lang/String;)La2/e$k$a;

    move-result-object p0

    invoke-virtual {p0}, La2/e$k$a;->a()La2/e$k;

    move-result-object p0

    return-object p0
.end method

.method static d(Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;)La2/e$l;
    .registers 4

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    new-instance v0, La2/e$l$a;

    invoke-direct {v0}, La2/e$l$a;-><init>()V

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->getPriceAmountMicros()J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$l$a;->c(Ljava/lang/Long;)La2/e$l$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->getPriceCurrencyCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$l$a;->d(Ljava/lang/String;)La2/e$l$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;->getFormattedPrice()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, La2/e$l$a;->b(Ljava/lang/String;)La2/e$l$a;

    move-result-object p0

    invoke-virtual {p0}, La2/e$l$a;->a()La2/e$l;

    move-result-object p0

    return-object p0
.end method

.method static e(Lcom/android/billingclient/api/ProductDetails$PricingPhase;)La2/e$m;
    .registers 4

    new-instance v0, La2/e$m$a;

    invoke-direct {v0}, La2/e$m$a;-><init>()V

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$PricingPhase;->getFormattedPrice()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$m$a;->d(Ljava/lang/String;)La2/e$m$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$PricingPhase;->getPriceCurrencyCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$m$a;->f(Ljava/lang/String;)La2/e$m$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$PricingPhase;->getPriceAmountMicros()J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$m$a;->e(Ljava/lang/Long;)La2/e$m$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$PricingPhase;->getBillingCycleCount()I

    move-result v1

    int-to-long v1, v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$m$a;->b(Ljava/lang/Long;)La2/e$m$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$PricingPhase;->getBillingPeriod()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$m$a;->c(Ljava/lang/String;)La2/e$m$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$PricingPhase;->getRecurrenceMode()I

    move-result p0

    invoke-static {p0}, La2/i0;->t(I)La2/e$w;

    move-result-object p0

    invoke-virtual {v0, p0}, La2/e$m$a;->g(La2/e$w;)La2/e$m$a;

    move-result-object p0

    invoke-virtual {p0}, La2/e$m$a;->a()La2/e$m;

    move-result-object p0

    return-object p0
.end method

.method static f(Lcom/android/billingclient/api/ProductDetails$PricingPhases;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/billingclient/api/ProductDetails$PricingPhases;",
            ")",
            "Ljava/util/List<",
            "La2/e$m;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$PricingPhases;->getPricingPhaseList()Ljava/util/List;

    move-result-object p0

    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_d
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_21

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/billingclient/api/ProductDetails$PricingPhase;

    invoke-static {v1}, La2/i0;->e(Lcom/android/billingclient/api/ProductDetails$PricingPhase;)La2/e$m;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_d

    :cond_21
    return-object v0
.end method

.method static g(Lcom/android/billingclient/api/ProductDetails;)La2/e$n;
    .registers 3

    new-instance v0, La2/e$n$a;

    invoke-direct {v0}, La2/e$n$a;-><init>()V

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$n$a;->h(Ljava/lang/String;)La2/e$n$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails;->getDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$n$a;->b(Ljava/lang/String;)La2/e$n$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails;->getProductId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$n$a;->e(Ljava/lang/String;)La2/e$n$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails;->getProductType()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, La2/i0;->r(Ljava/lang/String;)La2/e$p;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$n$a;->f(La2/e$p;)La2/e$n$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$n$a;->c(Ljava/lang/String;)La2/e$n$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails;->getOneTimePurchaseOfferDetails()Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;

    move-result-object v1

    invoke-static {v1}, La2/i0;->d(Lcom/android/billingclient/api/ProductDetails$OneTimePurchaseOfferDetails;)La2/e$l;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$n$a;->d(La2/e$l;)La2/e$n$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails;->getSubscriptionOfferDetails()Ljava/util/List;

    move-result-object p0

    invoke-static {p0}, La2/i0;->n(Ljava/util/List;)Ljava/util/List;

    move-result-object p0

    invoke-virtual {v0, p0}, La2/e$n$a;->g(Ljava/util/List;)La2/e$n$a;

    move-result-object p0

    invoke-virtual {p0}, La2/e$n$a;->a()La2/e$n;

    move-result-object p0

    return-object p0
.end method

.method static h(Ljava/util/List;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/android/billingclient/api/ProductDetails;",
            ">;)",
            "Ljava/util/List<",
            "La2/e$n;",
            ">;"
        }
    .end annotation

    if-nez p0, :cond_7

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object p0

    return-object p0

    :cond_7
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_10
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_24

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/billingclient/api/ProductDetails;

    invoke-static {v1}, La2/i0;->g(Lcom/android/billingclient/api/ProductDetails;)La2/e$n;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_10

    :cond_24
    return-object v0
.end method

.method static i(Lcom/android/billingclient/api/Purchase;)La2/e$q;
    .registers 4

    new-instance v0, La2/e$q$a;

    invoke-direct {v0}, La2/e$q$a;-><init>()V

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->getOrderId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$q$a;->f(Ljava/lang/String;)La2/e$q$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$q$a;->h(Ljava/lang/String;)La2/e$q$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->getPurchaseTime()J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$q$a;->k(Ljava/lang/Long;)La2/e$q$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->getPurchaseToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$q$a;->l(Ljava/lang/String;)La2/e$q$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->getSignature()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$q$a;->n(Ljava/lang/String;)La2/e$q$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->getProducts()Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$q$a;->i(Ljava/util/List;)La2/e$q$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->isAutoRenewing()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$q$a;->e(Ljava/lang/Boolean;)La2/e$q$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->getOriginalJson()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$q$a;->g(Ljava/lang/String;)La2/e$q$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->getDeveloperPayload()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$q$a;->c(Ljava/lang/String;)La2/e$q$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->isAcknowledged()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$q$a;->d(Ljava/lang/Boolean;)La2/e$q$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->getPurchaseState()I

    move-result v1

    invoke-static {v1}, La2/i0;->s(I)La2/e$t;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$q$a;->j(La2/e$t;)La2/e$q$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->getQuantity()I

    move-result v1

    int-to-long v1, v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$q$a;->m(Ljava/lang/Long;)La2/e$q$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/Purchase;->getAccountIdentifiers()Lcom/android/billingclient/api/AccountIdentifiers;

    move-result-object p0

    if-eqz p0, :cond_9c

    new-instance v1, La2/e$f$a;

    invoke-direct {v1}, La2/e$f$a;-><init>()V

    invoke-virtual {p0}, Lcom/android/billingclient/api/AccountIdentifiers;->getObfuscatedAccountId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, La2/e$f$a;->b(Ljava/lang/String;)La2/e$f$a;

    move-result-object v1

    invoke-virtual {p0}, Lcom/android/billingclient/api/AccountIdentifiers;->getObfuscatedProfileId()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v1, p0}, La2/e$f$a;->c(Ljava/lang/String;)La2/e$f$a;

    move-result-object p0

    invoke-virtual {p0}, La2/e$f$a;->a()La2/e$f;

    move-result-object p0

    invoke-virtual {v0, p0}, La2/e$q$a;->b(La2/e$f;)La2/e$q$a;

    :cond_9c
    invoke-virtual {v0}, La2/e$q$a;->a()La2/e$q;

    move-result-object p0

    return-object p0
.end method

.method static j(Lcom/android/billingclient/api/PurchaseHistoryRecord;)La2/e$r;
    .registers 4

    new-instance v0, La2/e$r$a;

    invoke-direct {v0}, La2/e$r$a;-><init>()V

    invoke-virtual {p0}, Lcom/android/billingclient/api/PurchaseHistoryRecord;->getPurchaseTime()J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$r$a;->e(Ljava/lang/Long;)La2/e$r$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/PurchaseHistoryRecord;->getPurchaseToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$r$a;->f(Ljava/lang/String;)La2/e$r$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/PurchaseHistoryRecord;->getSignature()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$r$a;->h(Ljava/lang/String;)La2/e$r$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/PurchaseHistoryRecord;->getProducts()Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$r$a;->d(Ljava/util/List;)La2/e$r$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/PurchaseHistoryRecord;->getDeveloperPayload()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$r$a;->b(Ljava/lang/String;)La2/e$r$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/PurchaseHistoryRecord;->getOriginalJson()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$r$a;->c(Ljava/lang/String;)La2/e$r$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/PurchaseHistoryRecord;->getQuantity()I

    move-result p0

    int-to-long v1, p0

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p0

    invoke-virtual {v0, p0}, La2/e$r$a;->g(Ljava/lang/Long;)La2/e$r$a;

    move-result-object p0

    invoke-virtual {p0}, La2/e$r$a;->a()La2/e$r;

    move-result-object p0

    return-object p0
.end method

.method static k(Ljava/util/List;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/android/billingclient/api/PurchaseHistoryRecord;",
            ">;)",
            "Ljava/util/List<",
            "La2/e$r;",
            ">;"
        }
    .end annotation

    if-nez p0, :cond_7

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object p0

    return-object p0

    :cond_7
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_10
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_24

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/billingclient/api/PurchaseHistoryRecord;

    invoke-static {v1}, La2/i0;->j(Lcom/android/billingclient/api/PurchaseHistoryRecord;)La2/e$r;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_10

    :cond_24
    return-object v0
.end method

.method static l(Ljava/util/List;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/android/billingclient/api/Purchase;",
            ">;)",
            "Ljava/util/List<",
            "La2/e$q;",
            ">;"
        }
    .end annotation

    if-nez p0, :cond_7

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object p0

    return-object p0

    :cond_7
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_10
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_24

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/billingclient/api/Purchase;

    invoke-static {v1}, La2/i0;->i(Lcom/android/billingclient/api/Purchase;)La2/e$q;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_10

    :cond_24
    return-object v0
.end method

.method static m(Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;)La2/e$x;
    .registers 3

    new-instance v0, La2/e$x$a;

    invoke-direct {v0}, La2/e$x$a;-><init>()V

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;->getOfferId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$x$a;->c(Ljava/lang/String;)La2/e$x$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;->getBasePlanId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$x$a;->b(Ljava/lang/String;)La2/e$x$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;->getOfferTags()Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$x$a;->d(Ljava/util/List;)La2/e$x$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;->getOfferToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$x$a;->e(Ljava/lang/String;)La2/e$x$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;->getPricingPhases()Lcom/android/billingclient/api/ProductDetails$PricingPhases;

    move-result-object p0

    invoke-static {p0}, La2/i0;->f(Lcom/android/billingclient/api/ProductDetails$PricingPhases;)Ljava/util/List;

    move-result-object p0

    invoke-virtual {v0, p0}, La2/e$x$a;->f(Ljava/util/List;)La2/e$x$a;

    move-result-object p0

    invoke-virtual {p0}, La2/e$x$a;->a()La2/e$x;

    move-result-object p0

    return-object p0
.end method

.method static n(Ljava/util/List;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;",
            ">;)",
            "Ljava/util/List<",
            "La2/e$x;",
            ">;"
        }
    .end annotation

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_d
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_21

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;

    invoke-static {v1}, La2/i0;->m(Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;)La2/e$x;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_d

    :cond_21
    return-object v0
.end method

.method static o(Lcom/android/billingclient/api/UserChoiceDetails;)La2/e$y;
    .registers 3

    new-instance v0, La2/e$y$a;

    invoke-direct {v0}, La2/e$y$a;-><init>()V

    invoke-virtual {p0}, Lcom/android/billingclient/api/UserChoiceDetails;->getExternalTransactionToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$y$a;->b(Ljava/lang/String;)La2/e$y$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/UserChoiceDetails;->getOriginalExternalTransactionId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$y$a;->c(Ljava/lang/String;)La2/e$y$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/UserChoiceDetails;->getProducts()Ljava/util/List;

    move-result-object p0

    invoke-static {p0}, La2/i0;->q(Ljava/util/List;)Ljava/util/List;

    move-result-object p0

    invoke-virtual {v0, p0}, La2/e$y$a;->d(Ljava/util/List;)La2/e$y$a;

    move-result-object p0

    invoke-virtual {p0}, La2/e$y$a;->a()La2/e$y;

    move-result-object p0

    return-object p0
.end method

.method static p(Lcom/android/billingclient/api/UserChoiceDetails$Product;)La2/e$z;
    .registers 3

    new-instance v0, La2/e$z$a;

    invoke-direct {v0}, La2/e$z$a;-><init>()V

    invoke-virtual {p0}, Lcom/android/billingclient/api/UserChoiceDetails$Product;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$z$a;->b(Ljava/lang/String;)La2/e$z$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/UserChoiceDetails$Product;->getOfferToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La2/e$z$a;->c(Ljava/lang/String;)La2/e$z$a;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/billingclient/api/UserChoiceDetails$Product;->getType()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, La2/i0;->r(Ljava/lang/String;)La2/e$p;

    move-result-object p0

    invoke-virtual {v0, p0}, La2/e$z$a;->d(La2/e$p;)La2/e$z$a;

    move-result-object p0

    invoke-virtual {p0}, La2/e$z$a;->a()La2/e$z;

    move-result-object p0

    return-object p0
.end method

.method static q(Ljava/util/List;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/android/billingclient/api/UserChoiceDetails$Product;",
            ">;)",
            "Ljava/util/List<",
            "La2/e$z;",
            ">;"
        }
    .end annotation

    invoke-interface {p0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object p0

    return-object p0

    :cond_b
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_14
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_28

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/billingclient/api/UserChoiceDetails$Product;

    invoke-static {v1}, La2/i0;->p(Lcom/android/billingclient/api/UserChoiceDetails$Product;)La2/e$z;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_14

    :cond_28
    return-object v0
.end method

.method static r(Ljava/lang/String;)La2/e$p;
    .registers 4

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    const v1, 0x360a33

    const/4 v2, 0x2

    if-eq v0, v1, :cond_1a

    const v1, 0x5fb1edc

    if-eq v0, v1, :cond_10

    goto :goto_24

    :cond_10
    const-string v0, "inapp"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_24

    const/4 p0, 0x0

    goto :goto_25

    :cond_1a
    const-string v0, "subs"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_24

    const/4 p0, 0x2

    goto :goto_25

    :cond_24
    :goto_24
    const/4 p0, -0x1

    :goto_25
    if-eq p0, v2, :cond_2a

    sget-object p0, La2/e$p;->d:La2/e$p;

    return-object p0

    :cond_2a
    sget-object p0, La2/e$p;->f:La2/e$p;

    return-object p0
.end method

.method static s(I)La2/e$t;
    .registers 2

    if-eqz p0, :cond_11

    const/4 v0, 0x1

    if-eq p0, v0, :cond_e

    const/4 v0, 0x2

    if-eq p0, v0, :cond_b

    sget-object p0, La2/e$t;->d:La2/e$t;

    return-object p0

    :cond_b
    sget-object p0, La2/e$t;->g:La2/e$t;

    return-object p0

    :cond_e
    sget-object p0, La2/e$t;->f:La2/e$t;

    return-object p0

    :cond_11
    sget-object p0, La2/e$t;->d:La2/e$t;

    return-object p0
.end method

.method static t(I)La2/e$w;
    .registers 2

    const/4 v0, 0x1

    if-eq p0, v0, :cond_12

    const/4 v0, 0x2

    if-eq p0, v0, :cond_f

    const/4 v0, 0x3

    if-eq p0, v0, :cond_c

    sget-object p0, La2/e$w;->g:La2/e$w;

    return-object p0

    :cond_c
    sget-object p0, La2/e$w;->g:La2/e$w;

    return-object p0

    :cond_f
    sget-object p0, La2/e$w;->d:La2/e$w;

    return-object p0

    :cond_12
    sget-object p0, La2/e$w;->f:La2/e$w;

    return-object p0
.end method

.method static u(La2/e$v;)Lcom/android/billingclient/api/QueryProductDetailsParams$Product;
    .registers 3

    invoke-static {}, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;->newBuilder()Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;

    move-result-object v0

    invoke-virtual {p0}, La2/e$v;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;->setProductId(Ljava/lang/String;)Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;

    move-result-object v0

    invoke-virtual {p0}, La2/e$v;->c()La2/e$p;

    move-result-object p0

    invoke-static {p0}, La2/i0;->w(La2/e$p;)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;->setProductType(Ljava/lang/String;)Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;

    move-result-object p0

    invoke-virtual {p0}, Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;->build()Lcom/android/billingclient/api/QueryProductDetailsParams$Product;

    move-result-object p0

    return-object p0
.end method

.method static v(Ljava/util/List;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "La2/e$v;",
            ">;)",
            "Ljava/util/List<",
            "Lcom/android/billingclient/api/QueryProductDetailsParams$Product;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_9
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1d

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, La2/e$v;

    invoke-static {v1}, La2/i0;->u(La2/e$v;)Lcom/android/billingclient/api/QueryProductDetailsParams$Product;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_9

    :cond_1d
    return-object v0
.end method

.method static w(La2/e$p;)Ljava/lang/String;
    .registers 4

    sget-object v0, La2/i0$a;->a:[I

    invoke-virtual {p0}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_2b

    const/4 v1, 0x2

    if-ne v0, v1, :cond_11

    const-string p0, "subs"

    return-object p0

    :cond_11
    new-instance v0, La2/e$a;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown product type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    const/4 v1, 0x0

    const-string v2, "UNKNOWN_TYPE"

    invoke-direct {v0, v2, p0, v1}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    throw v0

    :cond_2b
    const-string p0, "inapp"

    return-object p0
.end method
