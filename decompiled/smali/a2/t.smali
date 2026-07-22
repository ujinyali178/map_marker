.class public final synthetic La2/t;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a()Lu1/j;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lu1/j<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    sget-object v0, La2/e$c;->d:La2/e$c;

    return-object v0
.end method

.method public static synthetic b(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    :try_start_5
    invoke-interface {p0}, La2/e$b;->isReady()Ljava/lang/Boolean;

    move-result-object p0

    const/4 v0, 0x0

    invoke-virtual {p1, v0, p0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V
    :try_end_d
    .catchall {:try_start_5 .. :try_end_d} :catchall_e

    goto :goto_13

    :catchall_e
    move-exception p0

    invoke-static {p0}, La2/e;->b(Ljava/lang/Throwable;)Ljava/util/ArrayList;

    move-result-object p1

    :goto_13
    invoke-interface {p2, p1}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic c(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 7

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast p1, Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Number;

    invoke-static {}, La2/e$h;->values()[La2/e$h;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {p1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    aget-object p1, v2, p1

    new-instance v2, La2/t$b;

    invoke-direct {v2, v0, p2}, La2/t$b;-><init>(Ljava/util/ArrayList;Lu1/b$e;)V

    if-nez v1, :cond_28

    const/4 p2, 0x0

    goto :goto_30

    :cond_28
    invoke-virtual {v1}, Ljava/lang/Number;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p2

    :goto_30
    invoke-interface {p0, p2, p1, v2}, La2/e$b;->d(Ljava/lang/Long;La2/e$h;La2/e$a0;)V

    return-void
.end method

.method public static synthetic d(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 5

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast p1, Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    :try_start_e
    invoke-interface {p0, p1}, La2/e$b;->c(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object p0

    invoke-virtual {v0, v1, p0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V
    :try_end_15
    .catchall {:try_start_e .. :try_end_15} :catchall_16

    goto :goto_1b

    :catchall_16
    move-exception p0

    invoke-static {p0}, La2/e;->b(Ljava/lang/Throwable;)Ljava/util/ArrayList;

    move-result-object v0

    :goto_1b
    invoke-interface {p2, v0}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic e(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    new-instance v0, La2/t$i;

    invoke-direct {v0, p1, p2}, La2/t$i;-><init>(Ljava/util/ArrayList;Lu1/b$e;)V

    invoke-interface {p0, v0}, La2/e$b;->f(La2/e$a0;)V

    return-void
.end method

.method public static synthetic f(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    new-instance v0, La2/t$j;

    invoke-direct {v0, p1, p2}, La2/t$j;-><init>(Ljava/util/ArrayList;Lu1/b$e;)V

    invoke-interface {p0, v0}, La2/e$b;->l(La2/e$a0;)V

    return-void
.end method

.method public static synthetic g(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    new-instance v0, La2/t$a;

    invoke-direct {v0, p1, p2}, La2/t$a;-><init>(Ljava/util/ArrayList;Lu1/b$e;)V

    invoke-interface {p0, v0}, La2/e$b;->j(La2/e$a0;)V

    return-void
.end method

.method public static synthetic h(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    :try_start_5
    invoke-interface {p0}, La2/e$b;->m()V

    const/4 p0, 0x0

    const/4 v0, 0x0

    invoke-virtual {p1, p0, v0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V
    :try_end_d
    .catchall {:try_start_5 .. :try_end_d} :catchall_e

    goto :goto_13

    :catchall_e
    move-exception p0

    invoke-static {p0}, La2/e;->b(Ljava/lang/Throwable;)Ljava/util/ArrayList;

    move-result-object p1

    :goto_13
    invoke-interface {p2, p1}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic i(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    new-instance v0, La2/t$c;

    invoke-direct {v0, p1, p2}, La2/t$c;-><init>(Ljava/util/ArrayList;Lu1/b$e;)V

    invoke-interface {p0, v0}, La2/e$b;->h(La2/e$a0;)V

    return-void
.end method

.method public static synthetic j(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 5

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast p1, Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, La2/e$j;

    :try_start_e
    invoke-interface {p0, p1}, La2/e$b;->i(La2/e$j;)La2/e$k;

    move-result-object p0

    invoke-virtual {v0, v1, p0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V
    :try_end_15
    .catchall {:try_start_e .. :try_end_15} :catchall_16

    goto :goto_1b

    :catchall_16
    move-exception p0

    invoke-static {p0}, La2/e;->b(Ljava/lang/Throwable;)Ljava/util/ArrayList;

    move-result-object v0

    :goto_1b
    invoke-interface {p2, v0}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic k(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 5

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast p1, Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    new-instance v1, La2/t$d;

    invoke-direct {v1, v0, p2}, La2/t$d;-><init>(Ljava/util/ArrayList;Lu1/b$e;)V

    invoke-interface {p0, p1, v1}, La2/e$b;->k(Ljava/lang/String;La2/e$a0;)V

    return-void
.end method

.method public static synthetic l(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 5

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast p1, Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    new-instance v1, La2/t$e;

    invoke-direct {v1, v0, p2}, La2/t$e;-><init>(Ljava/util/ArrayList;Lu1/b$e;)V

    invoke-interface {p0, p1, v1}, La2/e$b;->g(Ljava/lang/String;La2/e$a0;)V

    return-void
.end method

.method public static synthetic m(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 6

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {}, La2/e$p;->values()[La2/e$p;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    aget-object p1, v1, p1

    new-instance v1, La2/t$f;

    invoke-direct {v1, v0, p2}, La2/t$f;-><init>(Ljava/util/ArrayList;Lu1/b$e;)V

    invoke-interface {p0, p1, v1}, La2/e$b;->e(La2/e$p;La2/e$a0;)V

    return-void
.end method

.method public static synthetic n(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 6

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {}, La2/e$p;->values()[La2/e$p;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    aget-object p1, v1, p1

    new-instance v1, La2/t$g;

    invoke-direct {v1, v0, p2}, La2/t$g;-><init>(Ljava/util/ArrayList;Lu1/b$e;)V

    invoke-interface {p0, p1, v1}, La2/e$b;->a(La2/e$p;La2/e$a0;)V

    return-void
.end method

.method public static synthetic o(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 5

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast p1, Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/List;

    new-instance v1, La2/t$h;

    invoke-direct {v1, v0, p2}, La2/t$h;-><init>(Ljava/util/ArrayList;Lu1/b$e;)V

    invoke-interface {p0, p1, v1}, La2/e$b;->b(Ljava/util/List;La2/e$a0;)V

    return-void
.end method

.method public static p(Lu1/d;La2/e$b;)V
    .registers 6

    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v1

    const-string v2, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.isReady"

    invoke-direct {v0, p0, v2, v1}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    const/4 v1, 0x0

    if-eqz p1, :cond_17

    new-instance v2, La2/f;

    invoke-direct {v2, p1}, La2/f;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_1a

    :cond_17
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_1a
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.startConnection"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_30

    new-instance v2, La2/o;

    invoke-direct {v2, p1}, La2/o;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_33

    :cond_30
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_33
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.endConnection"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_49

    new-instance v2, La2/p;

    invoke-direct {v2, p1}, La2/p;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_4c

    :cond_49
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_4c
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.getBillingConfigAsync"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_62

    new-instance v2, La2/q;

    invoke-direct {v2, p1}, La2/q;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_65

    :cond_62
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_65
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.launchBillingFlow"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_7b

    new-instance v2, La2/r;

    invoke-direct {v2, p1}, La2/r;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_7e

    :cond_7b
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_7e
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.acknowledgePurchase"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_94

    new-instance v2, La2/s;

    invoke-direct {v2, p1}, La2/s;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_97

    :cond_94
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_97
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.consumeAsync"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_ad

    new-instance v2, La2/g;

    invoke-direct {v2, p1}, La2/g;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_b0

    :cond_ad
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_b0
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.queryPurchasesAsync"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_c6

    new-instance v2, La2/h;

    invoke-direct {v2, p1}, La2/h;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_c9

    :cond_c6
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_c9
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.queryPurchaseHistoryAsync"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_df

    new-instance v2, La2/i;

    invoke-direct {v2, p1}, La2/i;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_e2

    :cond_df
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_e2
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.queryProductDetailsAsync"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_f8

    new-instance v2, La2/j;

    invoke-direct {v2, p1}, La2/j;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_fb

    :cond_f8
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_fb
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.isFeatureSupported"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_111

    new-instance v2, La2/k;

    invoke-direct {v2, p1}, La2/k;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_114

    :cond_111
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_114
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.isAlternativeBillingOnlyAvailableAsync"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_12a

    new-instance v2, La2/l;

    invoke-direct {v2, p1}, La2/l;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_12d

    :cond_12a
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_12d
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.showAlternativeBillingOnlyInformationDialog"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_143

    new-instance v2, La2/m;

    invoke-direct {v2, p1}, La2/m;-><init>(La2/e$b;)V

    invoke-virtual {v0, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_146

    :cond_143
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_146
    new-instance v0, Lu1/b;

    invoke-static {}, La2/t;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseApi.createAlternativeBillingOnlyReportingDetailsAsync"

    invoke-direct {v0, p0, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    if-eqz p1, :cond_15c

    new-instance p0, La2/n;

    invoke-direct {p0, p1}, La2/n;-><init>(La2/e$b;)V

    invoke-virtual {v0, p0}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_15f

    :cond_15c
    invoke-virtual {v0, v1}, Lu1/b;->e(Lu1/b$d;)V

    :goto_15f
    return-void
.end method
