.class La2/g0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/app/Application$ActivityLifecycleCallbacks;
.implements La2/e$b;


# instance fields
.field private c:Lcom/android/billingclient/api/BillingClient;

.field private final d:La2/a;

.field private f:Landroid/app/Activity;

.field private final g:Landroid/content/Context;

.field final h:La2/e$d;

.field private final i:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Lcom/android/billingclient/api/ProductDetails;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Landroid/app/Activity;Landroid/content/Context;La2/e$d;La2/a;)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, La2/g0;->i:Ljava/util/HashMap;

    iput-object p4, p0, La2/g0;->d:La2/a;

    iput-object p2, p0, La2/g0;->g:Landroid/content/Context;

    iput-object p1, p0, La2/g0;->f:Landroid/app/Activity;

    iput-object p3, p0, La2/g0;->h:La2/e$d;

    return-void
.end method

.method private static synthetic A(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)V
    .registers 3

    invoke-static {p1, p2}, La2/i0;->a(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)La2/e$g;

    move-result-object p1

    invoke-interface {p0, p1}, La2/e$a0;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic B(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V
    .registers 3

    invoke-static {p1, p2}, La2/i0;->b(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)La2/e$i;

    move-result-object p1

    invoke-interface {p0, p1}, La2/e$a0;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic C(La2/e$a0;Lcom/android/billingclient/api/BillingResult;)V
    .registers 2

    invoke-static {p1}, La2/i0;->c(Lcom/android/billingclient/api/BillingResult;)La2/e$k;

    move-result-object p1

    invoke-interface {p0, p1}, La2/e$a0;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private synthetic D(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V
    .registers 5

    invoke-virtual {p0, p3}, La2/g0;->K(Ljava/util/List;)V

    new-instance v0, La2/e$o$a;

    invoke-direct {v0}, La2/e$o$a;-><init>()V

    invoke-static {p2}, La2/i0;->c(Lcom/android/billingclient/api/BillingResult;)La2/e$k;

    move-result-object p2

    invoke-virtual {v0, p2}, La2/e$o$a;->b(La2/e$k;)La2/e$o$a;

    move-result-object p2

    invoke-static {p3}, La2/i0;->h(Ljava/util/List;)Ljava/util/List;

    move-result-object p3

    invoke-virtual {p2, p3}, La2/e$o$a;->c(Ljava/util/List;)La2/e$o$a;

    move-result-object p2

    invoke-virtual {p2}, La2/e$o$a;->a()La2/e$o;

    move-result-object p2

    invoke-interface {p1, p2}, La2/e$a0;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic E(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V
    .registers 4

    new-instance v0, La2/e$s$a;

    invoke-direct {v0}, La2/e$s$a;-><init>()V

    invoke-static {p1}, La2/i0;->c(Lcom/android/billingclient/api/BillingResult;)La2/e$k;

    move-result-object p1

    invoke-virtual {v0, p1}, La2/e$s$a;->b(La2/e$k;)La2/e$s$a;

    move-result-object p1

    invoke-static {p2}, La2/i0;->k(Ljava/util/List;)Ljava/util/List;

    move-result-object p2

    invoke-virtual {p1, p2}, La2/e$s$a;->c(Ljava/util/List;)La2/e$s$a;

    move-result-object p1

    invoke-virtual {p1}, La2/e$s$a;->a()La2/e$s;

    move-result-object p1

    invoke-interface {p0, p1}, La2/e$a0;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic F(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V
    .registers 4

    new-instance v0, La2/e$u$a;

    invoke-direct {v0}, La2/e$u$a;-><init>()V

    invoke-static {p1}, La2/i0;->c(Lcom/android/billingclient/api/BillingResult;)La2/e$k;

    move-result-object p1

    invoke-virtual {v0, p1}, La2/e$u$a;->b(La2/e$k;)La2/e$u$a;

    move-result-object p1

    invoke-static {p2}, La2/i0;->l(Ljava/util/List;)Ljava/util/List;

    move-result-object p2

    invoke-virtual {p1, p2}, La2/e$u$a;->c(Ljava/util/List;)La2/e$u$a;

    move-result-object p1

    invoke-virtual {p1}, La2/e$u$a;->a()La2/e$u;

    move-result-object p1

    invoke-interface {p0, p1}, La2/e$a0;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic G(La2/e$a0;Lcom/android/billingclient/api/BillingResult;)V
    .registers 2

    invoke-static {p1}, La2/i0;->c(Lcom/android/billingclient/api/BillingResult;)La2/e$k;

    move-result-object p1

    invoke-interface {p0, p1}, La2/e$a0;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private J(Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams$Builder;I)V
    .registers 3

    invoke-virtual {p1, p2}, Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams$Builder;->setReplaceProrationMode(I)Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams$Builder;

    return-void
.end method

.method public static synthetic n(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V
    .registers 3

    invoke-static {p0, p1, p2}, La2/g0;->E(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void
.end method

.method public static synthetic o(La2/e$a0;Lcom/android/billingclient/api/BillingResult;)V
    .registers 2

    invoke-static {p0, p1}, La2/g0;->C(La2/e$a0;Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method public static synthetic p(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V
    .registers 3

    invoke-static {p0, p1, p2}, La2/g0;->F(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void
.end method

.method public static synthetic q(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V
    .registers 3

    invoke-static {p0, p1, p2}, La2/g0;->B(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    return-void
.end method

.method public static synthetic r(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)V
    .registers 3

    invoke-static {p0, p1, p2}, La2/g0;->A(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)V

    return-void
.end method

.method public static synthetic s(La2/e$a0;Lcom/android/billingclient/api/BillingResult;)V
    .registers 2

    invoke-static {p0, p1}, La2/g0;->G(La2/e$a0;Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method public static synthetic t(La2/e$a0;Lcom/android/billingclient/api/BillingResult;)V
    .registers 2

    invoke-static {p0, p1}, La2/g0;->y(La2/e$a0;Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method public static synthetic u(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V
    .registers 3

    invoke-static {p0, p1, p2}, La2/g0;->z(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic v(La2/g0;La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V
    .registers 4

    invoke-direct {p0, p1, p2, p3}, La2/g0;->D(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void
.end method

.method private w()V
    .registers 2

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-eqz v0, :cond_a

    invoke-virtual {v0}, Lcom/android/billingclient/api/BillingClient;->endConnection()V

    const/4 v0, 0x0

    iput-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    :cond_a
    return-void
.end method

.method private x()La2/e$a;
    .registers 5

    new-instance v0, La2/e$a;

    const-string v1, "UNAVAILABLE"

    const-string v2, "BillingClient is unset. Try reconnecting."

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-object v0
.end method

.method private static synthetic y(La2/e$a0;Lcom/android/billingclient/api/BillingResult;)V
    .registers 2

    invoke-static {p1}, La2/i0;->c(Lcom/android/billingclient/api/BillingResult;)La2/e$k;

    move-result-object p1

    invoke-interface {p0, p1}, La2/e$a0;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic z(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V
    .registers 3

    invoke-static {p1}, La2/i0;->c(Lcom/android/billingclient/api/BillingResult;)La2/e$k;

    move-result-object p1

    invoke-interface {p0, p1}, La2/e$a0;->a(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method H()V
    .registers 1

    invoke-direct {p0}, La2/g0;->w()V

    return-void
.end method

.method I(Landroid/app/Activity;)V
    .registers 2

    iput-object p1, p0, La2/g0;->f:Landroid/app/Activity;

    return-void
.end method

.method protected K(Ljava/util/List;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/android/billingclient/api/ProductDetails;",
            ">;)V"
        }
    .end annotation

    if-nez p1, :cond_3

    return-void

    :cond_3
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_7
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1d

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/billingclient/api/ProductDetails;

    iget-object v1, p0, La2/g0;->i:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/android/billingclient/api/ProductDetails;->getProductId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_7

    :cond_1d
    return-void
.end method

.method public a(La2/e$p;La2/e$a0;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La2/e$p;",
            "La2/e$a0<",
            "La2/e$s;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-nez v0, :cond_c

    invoke-direct {p0}, La2/g0;->x()La2/e$a;

    move-result-object p1

    invoke-interface {p2, p1}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    return-void

    :cond_c
    :try_start_c
    invoke-static {}, Lcom/android/billingclient/api/QueryPurchaseHistoryParams;->newBuilder()Lcom/android/billingclient/api/QueryPurchaseHistoryParams$Builder;

    move-result-object v1

    invoke-static {p1}, La2/i0;->w(La2/e$p;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Lcom/android/billingclient/api/QueryPurchaseHistoryParams$Builder;->setProductType(Ljava/lang/String;)Lcom/android/billingclient/api/QueryPurchaseHistoryParams$Builder;

    move-result-object p1

    invoke-virtual {p1}, Lcom/android/billingclient/api/QueryPurchaseHistoryParams$Builder;->build()Lcom/android/billingclient/api/QueryPurchaseHistoryParams;

    move-result-object p1

    new-instance v1, La2/f0;

    invoke-direct {v1, p2}, La2/f0;-><init>(La2/e$a0;)V

    invoke-virtual {v0, p1, v1}, Lcom/android/billingclient/api/BillingClient;->queryPurchaseHistoryAsync(Lcom/android/billingclient/api/QueryPurchaseHistoryParams;Lcom/android/billingclient/api/PurchaseHistoryResponseListener;)V
    :try_end_24
    .catch Ljava/lang/RuntimeException; {:try_start_c .. :try_end_24} :catch_25

    goto :goto_38

    :catch_25
    move-exception p1

    new-instance v0, La2/e$a;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object p1

    const-string v2, "error"

    invoke-direct {v0, v2, v1, p1}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p2, v0}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    :goto_38
    return-void
.end method

.method public b(Ljava/util/List;La2/e$a0;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "La2/e$v;",
            ">;",
            "La2/e$a0<",
            "La2/e$o;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-nez v0, :cond_c

    invoke-direct {p0}, La2/g0;->x()La2/e$a;

    move-result-object p1

    invoke-interface {p2, p1}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    return-void

    :cond_c
    :try_start_c
    invoke-static {}, Lcom/android/billingclient/api/QueryProductDetailsParams;->newBuilder()Lcom/android/billingclient/api/QueryProductDetailsParams$Builder;

    move-result-object v0

    invoke-static {p1}, La2/i0;->v(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/android/billingclient/api/QueryProductDetailsParams$Builder;->setProductList(Ljava/util/List;)Lcom/android/billingclient/api/QueryProductDetailsParams$Builder;

    move-result-object p1

    invoke-virtual {p1}, Lcom/android/billingclient/api/QueryProductDetailsParams$Builder;->build()Lcom/android/billingclient/api/QueryProductDetailsParams;

    move-result-object p1

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    new-instance v1, La2/y;

    invoke-direct {v1, p0, p2}, La2/y;-><init>(La2/g0;La2/e$a0;)V

    invoke-virtual {v0, p1, v1}, Lcom/android/billingclient/api/BillingClient;->queryProductDetailsAsync(Lcom/android/billingclient/api/QueryProductDetailsParams;Lcom/android/billingclient/api/ProductDetailsResponseListener;)V
    :try_end_26
    .catch Ljava/lang/RuntimeException; {:try_start_c .. :try_end_26} :catch_27

    goto :goto_3a

    :catch_27
    move-exception p1

    new-instance v0, La2/e$a;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object p1

    const-string v2, "error"

    invoke-direct {v0, v2, v1, p1}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p2, v0}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    :goto_3a
    return-void
.end method

.method public c(Ljava/lang/String;)Ljava/lang/Boolean;
    .registers 3

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-eqz v0, :cond_16

    invoke-virtual {v0, p1}, Lcom/android/billingclient/api/BillingClient;->isFeatureSupported(Ljava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result p1

    if-nez p1, :cond_10

    const/4 p1, 0x1

    goto :goto_11

    :cond_10
    const/4 p1, 0x0

    :goto_11
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    return-object p1

    :cond_16
    invoke-direct {p0}, La2/g0;->x()La2/e$a;

    move-result-object p1

    throw p1
.end method

.method public d(Ljava/lang/Long;La2/e$h;La2/e$a0;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Long;",
            "La2/e$h;",
            "La2/e$a0<",
            "La2/e$k;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-nez v0, :cond_10

    iget-object v0, p0, La2/g0;->d:La2/a;

    iget-object v1, p0, La2/g0;->g:Landroid/content/Context;

    iget-object v2, p0, La2/g0;->h:La2/e$d;

    invoke-interface {v0, v1, v2, p2}, La2/a;->a(Landroid/content/Context;La2/e$d;La2/e$h;)Lcom/android/billingclient/api/BillingClient;

    move-result-object p2

    iput-object p2, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    :cond_10
    :try_start_10
    iget-object p2, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    new-instance v0, La2/g0$a;

    invoke-direct {v0, p0, p3, p1}, La2/g0$a;-><init>(La2/g0;La2/e$a0;Ljava/lang/Long;)V

    invoke-virtual {p2, v0}, Lcom/android/billingclient/api/BillingClient;->startConnection(Lcom/android/billingclient/api/BillingClientStateListener;)V
    :try_end_1a
    .catch Ljava/lang/RuntimeException; {:try_start_10 .. :try_end_1a} :catch_1b

    goto :goto_2e

    :catch_1b
    move-exception p1

    new-instance p2, La2/e$a;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object p1

    const-string v1, "error"

    invoke-direct {p2, v1, v0, p1}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p3, p2}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    :goto_2e
    return-void
.end method

.method public e(La2/e$p;La2/e$a0;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La2/e$p;",
            "La2/e$a0<",
            "La2/e$u;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-nez v0, :cond_c

    invoke-direct {p0}, La2/g0;->x()La2/e$a;

    move-result-object p1

    invoke-interface {p2, p1}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    return-void

    :cond_c
    :try_start_c
    invoke-static {}, Lcom/android/billingclient/api/QueryPurchasesParams;->newBuilder()Lcom/android/billingclient/api/QueryPurchasesParams$Builder;

    move-result-object v0

    invoke-static {p1}, La2/i0;->w(La2/e$p;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/android/billingclient/api/QueryPurchasesParams$Builder;->setProductType(Ljava/lang/String;)Lcom/android/billingclient/api/QueryPurchasesParams$Builder;

    iget-object p1, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    invoke-virtual {v0}, Lcom/android/billingclient/api/QueryPurchasesParams$Builder;->build()Lcom/android/billingclient/api/QueryPurchasesParams;

    move-result-object v0

    new-instance v1, La2/x;

    invoke-direct {v1, p2}, La2/x;-><init>(La2/e$a0;)V

    invoke-virtual {p1, v0, v1}, Lcom/android/billingclient/api/BillingClient;->queryPurchasesAsync(Lcom/android/billingclient/api/QueryPurchasesParams;Lcom/android/billingclient/api/PurchasesResponseListener;)V
    :try_end_25
    .catch Ljava/lang/RuntimeException; {:try_start_c .. :try_end_25} :catch_26

    goto :goto_39

    :catch_26
    move-exception p1

    new-instance v0, La2/e$a;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object p1

    const-string v2, "error"

    invoke-direct {v0, v2, v1, p1}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p2, v0}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    :goto_39
    return-void
.end method

.method public f(La2/e$a0;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La2/e$a0<",
            "La2/e$k;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-nez v0, :cond_c

    invoke-direct {p0}, La2/g0;->x()La2/e$a;

    move-result-object v0

    invoke-interface {p1, v0}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    return-void

    :cond_c
    :try_start_c
    new-instance v1, La2/b0;

    invoke-direct {v1, p1}, La2/b0;-><init>(La2/e$a0;)V

    invoke-virtual {v0, v1}, Lcom/android/billingclient/api/BillingClient;->isAlternativeBillingOnlyAvailableAsync(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;)V
    :try_end_14
    .catch Ljava/lang/RuntimeException; {:try_start_c .. :try_end_14} :catch_15

    goto :goto_28

    :catch_15
    move-exception v0

    new-instance v1, La2/e$a;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v0

    const-string v3, "error"

    invoke-direct {v1, v3, v2, v0}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p1, v1}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    :goto_28
    return-void
.end method

.method public g(Ljava/lang/String;La2/e$a0;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "La2/e$a0<",
            "La2/e$k;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-nez v0, :cond_c

    invoke-direct {p0}, La2/g0;->x()La2/e$a;

    move-result-object p1

    invoke-interface {p2, p1}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    return-void

    :cond_c
    :try_start_c
    new-instance v0, La2/c0;

    invoke-direct {v0, p2}, La2/c0;-><init>(La2/e$a0;)V

    invoke-static {}, Lcom/android/billingclient/api/ConsumeParams;->newBuilder()Lcom/android/billingclient/api/ConsumeParams$Builder;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/android/billingclient/api/ConsumeParams$Builder;->setPurchaseToken(Ljava/lang/String;)Lcom/android/billingclient/api/ConsumeParams$Builder;

    move-result-object p1

    invoke-virtual {p1}, Lcom/android/billingclient/api/ConsumeParams$Builder;->build()Lcom/android/billingclient/api/ConsumeParams;

    move-result-object p1

    iget-object v1, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    invoke-virtual {v1, p1, v0}, Lcom/android/billingclient/api/BillingClient;->consumeAsync(Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)V
    :try_end_22
    .catch Ljava/lang/RuntimeException; {:try_start_c .. :try_end_22} :catch_23

    goto :goto_36

    :catch_23
    move-exception p1

    new-instance v0, La2/e$a;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object p1

    const-string v2, "error"

    invoke-direct {v0, v2, v1, p1}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p2, v0}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    :goto_36
    return-void
.end method

.method public h(La2/e$a0;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La2/e$a0<",
            "La2/e$i;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-nez v0, :cond_c

    invoke-direct {p0}, La2/g0;->x()La2/e$a;

    move-result-object v0

    invoke-interface {p1, v0}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    return-void

    :cond_c
    :try_start_c
    invoke-static {}, Lcom/android/billingclient/api/GetBillingConfigParams;->newBuilder()Lcom/android/billingclient/api/GetBillingConfigParams$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/android/billingclient/api/GetBillingConfigParams$Builder;->build()Lcom/android/billingclient/api/GetBillingConfigParams;

    move-result-object v1

    new-instance v2, La2/e0;

    invoke-direct {v2, p1}, La2/e0;-><init>(La2/e$a0;)V

    invoke-virtual {v0, v1, v2}, Lcom/android/billingclient/api/BillingClient;->getBillingConfigAsync(Lcom/android/billingclient/api/GetBillingConfigParams;Lcom/android/billingclient/api/BillingConfigResponseListener;)V
    :try_end_1c
    .catch Ljava/lang/RuntimeException; {:try_start_c .. :try_end_1c} :catch_1d

    goto :goto_30

    :catch_1d
    move-exception v0

    new-instance v1, La2/e$a;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v0

    const-string v3, "error"

    invoke-direct {v1, v3, v2, v0}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p1, v1}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    :goto_30
    return-void
.end method

.method public i(La2/e$j;)La2/e$k;
    .registers 12

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-eqz v0, :cond_1ab

    iget-object v0, p0, La2/g0;->i:Ljava/util/HashMap;

    invoke-virtual {p1}, La2/e$j;->f()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/billingclient/api/ProductDetails;

    const-string v1, " are not available. It might because products were not fetched prior to the call. Please fetch the products first. An example of how to fetch the products could be found here: "

    const-string v2, "https://github.com/flutter/packages/blob/main/packages/in_app_purchase/in_app_purchase/README.md#loading-products-for-sale"

    const-string v3, "Details for product "

    const/4 v4, 0x0

    if-eqz v0, :cond_18a

    invoke-virtual {v0}, Lcom/android/billingclient/api/ProductDetails;->getSubscriptionOfferDetails()Ljava/util/List;

    move-result-object v5

    if-eqz v5, :cond_79

    const/4 v6, 0x0

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_24
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_45

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;

    invoke-virtual {p1}, La2/e$j;->d()Ljava/lang/String;

    move-result-object v8

    if-eqz v8, :cond_24

    invoke-virtual {p1}, La2/e$j;->d()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7}, Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;->getOfferToken()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_24

    const/4 v6, 0x1

    :cond_45
    if-eqz v6, :cond_48

    goto :goto_79

    :cond_48
    new-instance v0, La2/e$a;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Offer token "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, La2/e$j;->d()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " for product "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, La2/e$j;->f()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, " is not valid. Make sure to only pass offer tokens that belong to the product. To obtain offer tokens for a product, fetch the products. An example of how to fetch the products could be found here: "

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v1, "INVALID_OFFER_TOKEN"

    invoke-direct {v0, v1, p1, v4}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    throw v0

    :cond_79
    :goto_79
    invoke-virtual {p1}, La2/e$j;->e()Ljava/lang/String;

    move-result-object v5

    if-nez v5, :cond_98

    invoke-virtual {p1}, La2/e$j;->g()Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    const-wide/16 v7, 0x0

    cmp-long v9, v5, v7

    if-nez v9, :cond_8e

    goto :goto_98

    :cond_8e
    new-instance p1, La2/e$a;

    const-string v0, "IN_APP_PURCHASE_REQUIRE_OLD_PRODUCT"

    const-string v1, "launchBillingFlow failed because oldProduct is null. You must provide a valid oldProduct in order to use a proration mode."

    invoke-direct {p1, v0, v1, v4}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    throw p1

    :cond_98
    :goto_98
    invoke-virtual {p1}, La2/e$j;->e()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_cc

    iget-object v5, p0, La2/g0;->i:Ljava/util/HashMap;

    invoke-virtual {p1}, La2/e$j;->e()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_ab

    goto :goto_cc

    :cond_ab
    new-instance v0, La2/e$a;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, La2/e$j;->e()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v1, "IN_APP_PURCHASE_INVALID_OLD_PRODUCT"

    invoke-direct {v0, v1, p1, v4}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    throw v0

    :cond_cc
    :goto_cc
    iget-object v1, p0, La2/g0;->f:Landroid/app/Activity;

    if-eqz v1, :cond_16a

    invoke-static {}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->newBuilder()Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$Builder;->setProductDetails(Lcom/android/billingclient/api/ProductDetails;)Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$Builder;

    invoke-virtual {p1}, La2/e$j;->d()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_e4

    invoke-virtual {p1}, La2/e$j;->d()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$Builder;->setOfferToken(Ljava/lang/String;)Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$Builder;

    :cond_e4
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {v1}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams$Builder;->build()Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-static {}, Lcom/android/billingclient/api/BillingFlowParams;->newBuilder()Lcom/android/billingclient/api/BillingFlowParams$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/android/billingclient/api/BillingFlowParams$Builder;->setProductDetailsParamsList(Ljava/util/List;)Lcom/android/billingclient/api/BillingFlowParams$Builder;

    move-result-object v0

    invoke-virtual {p1}, La2/e$j;->b()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_10f

    invoke-virtual {p1}, La2/e$j;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_10f

    invoke-virtual {p1}, La2/e$j;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/billingclient/api/BillingFlowParams$Builder;->setObfuscatedAccountId(Ljava/lang/String;)Lcom/android/billingclient/api/BillingFlowParams$Builder;

    :cond_10f
    invoke-virtual {p1}, La2/e$j;->c()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_126

    invoke-virtual {p1}, La2/e$j;->c()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_126

    invoke-virtual {p1}, La2/e$j;->c()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/billingclient/api/BillingFlowParams$Builder;->setObfuscatedProfileId(Ljava/lang/String;)Lcom/android/billingclient/api/BillingFlowParams$Builder;

    :cond_126
    invoke-static {}, Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams;->newBuilder()Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams$Builder;

    move-result-object v1

    invoke-virtual {p1}, La2/e$j;->e()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_159

    invoke-virtual {p1}, La2/e$j;->e()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_159

    invoke-virtual {p1}, La2/e$j;->h()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_159

    invoke-virtual {p1}, La2/e$j;->h()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams$Builder;->setOldPurchaseToken(Ljava/lang/String;)Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams$Builder;

    invoke-virtual {p1}, La2/e$j;->g()Ljava/lang/Long;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Long;->intValue()I

    move-result p1

    invoke-direct {p0, v1, p1}, La2/g0;->J(Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams$Builder;I)V

    invoke-virtual {v1}, Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams$Builder;->build()Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/android/billingclient/api/BillingFlowParams$Builder;->setSubscriptionUpdateParams(Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams;)Lcom/android/billingclient/api/BillingFlowParams$Builder;

    :cond_159
    iget-object p1, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    iget-object v1, p0, La2/g0;->f:Landroid/app/Activity;

    invoke-virtual {v0}, Lcom/android/billingclient/api/BillingFlowParams$Builder;->build()Lcom/android/billingclient/api/BillingFlowParams;

    move-result-object v0

    invoke-virtual {p1, v1, v0}, Lcom/android/billingclient/api/BillingClient;->launchBillingFlow(Landroid/app/Activity;Lcom/android/billingclient/api/BillingFlowParams;)Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    invoke-static {p1}, La2/i0;->c(Lcom/android/billingclient/api/BillingResult;)La2/e$k;

    move-result-object p1

    return-object p1

    :cond_16a
    new-instance v0, La2/e$a;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, La2/e$j;->f()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, " are not available. This method must be run with the app in foreground."

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v1, "ACTIVITY_UNAVAILABLE"

    invoke-direct {v0, v1, p1, v4}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    throw v0

    :cond_18a
    new-instance v0, La2/e$a;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, La2/e$j;->f()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v1, "NOT_FOUND"

    invoke-direct {v0, v1, p1, v4}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    throw v0

    :cond_1ab
    invoke-direct {p0}, La2/g0;->x()La2/e$a;

    move-result-object p1

    throw p1
.end method

.method public isReady()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-eqz v0, :cond_d

    invoke-virtual {v0}, Lcom/android/billingclient/api/BillingClient;->isReady()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0

    :cond_d
    invoke-direct {p0}, La2/g0;->x()La2/e$a;

    move-result-object v0

    throw v0
.end method

.method public j(La2/e$a0;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La2/e$a0<",
            "La2/e$g;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-nez v0, :cond_c

    invoke-direct {p0}, La2/g0;->x()La2/e$a;

    move-result-object v0

    invoke-interface {p1, v0}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    return-void

    :cond_c
    :try_start_c
    new-instance v1, La2/a0;

    invoke-direct {v1, p1}, La2/a0;-><init>(La2/e$a0;)V

    invoke-virtual {v0, v1}, Lcom/android/billingclient/api/BillingClient;->createAlternativeBillingOnlyReportingDetailsAsync(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)V
    :try_end_14
    .catch Ljava/lang/RuntimeException; {:try_start_c .. :try_end_14} :catch_15

    goto :goto_28

    :catch_15
    move-exception v0

    new-instance v1, La2/e$a;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v0

    const-string v3, "error"

    invoke-direct {v1, v3, v2, v0}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p1, v1}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    :goto_28
    return-void
.end method

.method public k(Ljava/lang/String;La2/e$a0;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "La2/e$a0<",
            "La2/e$k;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-nez v0, :cond_c

    invoke-direct {p0}, La2/g0;->x()La2/e$a;

    move-result-object p1

    invoke-interface {p2, p1}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    return-void

    :cond_c
    :try_start_c
    invoke-static {}, Lcom/android/billingclient/api/AcknowledgePurchaseParams;->newBuilder()Lcom/android/billingclient/api/AcknowledgePurchaseParams$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/android/billingclient/api/AcknowledgePurchaseParams$Builder;->setPurchaseToken(Ljava/lang/String;)Lcom/android/billingclient/api/AcknowledgePurchaseParams$Builder;

    move-result-object p1

    invoke-virtual {p1}, Lcom/android/billingclient/api/AcknowledgePurchaseParams$Builder;->build()Lcom/android/billingclient/api/AcknowledgePurchaseParams;

    move-result-object p1

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    new-instance v1, La2/d0;

    invoke-direct {v1, p2}, La2/d0;-><init>(La2/e$a0;)V

    invoke-virtual {v0, p1, v1}, Lcom/android/billingclient/api/BillingClient;->acknowledgePurchase(Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V
    :try_end_22
    .catch Ljava/lang/RuntimeException; {:try_start_c .. :try_end_22} :catch_23

    goto :goto_36

    :catch_23
    move-exception p1

    new-instance v0, La2/e$a;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object p1

    const-string v2, "error"

    invoke-direct {v0, v2, v1, p1}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p2, v0}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    :goto_36
    return-void
.end method

.method public l(La2/e$a0;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La2/e$a0<",
            "La2/e$k;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, La2/g0;->c:Lcom/android/billingclient/api/BillingClient;

    if-nez v0, :cond_c

    invoke-direct {p0}, La2/g0;->x()La2/e$a;

    move-result-object v0

    :goto_8
    invoke-interface {p1, v0}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    return-void

    :cond_c
    iget-object v1, p0, La2/g0;->f:Landroid/app/Activity;

    if-nez v1, :cond_1b

    new-instance v0, La2/e$a;

    const/4 v1, 0x0

    const-string v2, "ACTIVITY_UNAVAILABLE"

    const-string v3, "Not attempting to show dialog"

    invoke-direct {v0, v2, v3, v1}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_8

    :cond_1b
    :try_start_1b
    new-instance v2, La2/z;

    invoke-direct {v2, p1}, La2/z;-><init>(La2/e$a0;)V

    invoke-virtual {v0, v1, v2}, Lcom/android/billingclient/api/BillingClient;->showAlternativeBillingOnlyInformationDialog(Landroid/app/Activity;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;)Lcom/android/billingclient/api/BillingResult;
    :try_end_23
    .catch Ljava/lang/RuntimeException; {:try_start_1b .. :try_end_23} :catch_24

    goto :goto_37

    :catch_24
    move-exception v0

    new-instance v1, La2/e$a;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v0

    const-string v3, "error"

    invoke-direct {v1, v3, v2, v0}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p1, v1}, La2/e$a0;->b(Ljava/lang/Throwable;)V

    :goto_37
    return-void
.end method

.method public m()V
    .registers 1

    invoke-direct {p0}, La2/g0;->w()V

    return-void
.end method

.method public onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .registers 3

    return-void
.end method

.method public onActivityDestroyed(Landroid/app/Activity;)V
    .registers 3

    iget-object v0, p0, La2/g0;->f:Landroid/app/Activity;

    if-ne v0, p1, :cond_10

    iget-object p1, p0, La2/g0;->g:Landroid/content/Context;

    if-eqz p1, :cond_10

    check-cast p1, Landroid/app/Application;

    invoke-virtual {p1, p0}, Landroid/app/Application;->unregisterActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    invoke-direct {p0}, La2/g0;->w()V

    :cond_10
    return-void
.end method

.method public onActivityPaused(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivityResumed(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .registers 3

    return-void
.end method

.method public onActivityStarted(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivityStopped(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method
