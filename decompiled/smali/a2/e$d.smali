.class public La2/e$d;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "d"
.end annotation


# instance fields
.field private final a:Lu1/d;


# direct methods
.method public constructor <init>(Lu1/d;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, La2/e$d;->a:Lu1/d;

    return-void
.end method

.method public static synthetic a(La2/e$b0;Ljava/lang/Object;)V
    .registers 2

    invoke-static {p0, p1}, La2/e$d;->e(La2/e$b0;Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic b(La2/e$b0;Ljava/lang/Object;)V
    .registers 2

    invoke-static {p0, p1}, La2/e$d;->g(La2/e$b0;Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic c(La2/e$b0;Ljava/lang/Object;)V
    .registers 2

    invoke-static {p0, p1}, La2/e$d;->f(La2/e$b0;Ljava/lang/Object;)V

    return-void
.end method

.method static d()Lu1/j;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lu1/j<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    sget-object v0, La2/e$e;->d:La2/e$e;

    return-object v0
.end method

.method private static synthetic e(La2/e$b0;Ljava/lang/Object;)V
    .registers 6

    instance-of v0, p1, Ljava/util/List;

    if-eqz v0, :cond_2e

    check-cast p1, Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_2a

    new-instance v0, La2/e$a;

    const/4 v2, 0x0

    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const/4 v3, 0x2

    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    invoke-direct {v0, v2, v1, p1}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p0, v0}, La2/e$b0;->b(Ljava/lang/Throwable;)V

    goto :goto_37

    :cond_2a
    invoke-interface {p0}, La2/e$b0;->a()V

    goto :goto_37

    :cond_2e
    const-string p1, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseCallbackApi.onBillingServiceDisconnected"

    invoke-static {p1}, La2/e;->a(Ljava/lang/String;)La2/e$a;

    move-result-object p1

    invoke-interface {p0, p1}, La2/e$b0;->b(Ljava/lang/Throwable;)V

    :goto_37
    return-void
.end method

.method private static synthetic f(La2/e$b0;Ljava/lang/Object;)V
    .registers 6

    instance-of v0, p1, Ljava/util/List;

    if-eqz v0, :cond_2e

    check-cast p1, Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_2a

    new-instance v0, La2/e$a;

    const/4 v2, 0x0

    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const/4 v3, 0x2

    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    invoke-direct {v0, v2, v1, p1}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p0, v0}, La2/e$b0;->b(Ljava/lang/Throwable;)V

    goto :goto_37

    :cond_2a
    invoke-interface {p0}, La2/e$b0;->a()V

    goto :goto_37

    :cond_2e
    const-string p1, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseCallbackApi.onPurchasesUpdated"

    invoke-static {p1}, La2/e;->a(Ljava/lang/String;)La2/e$a;

    move-result-object p1

    invoke-interface {p0, p1}, La2/e$b0;->b(Ljava/lang/Throwable;)V

    :goto_37
    return-void
.end method

.method private static synthetic g(La2/e$b0;Ljava/lang/Object;)V
    .registers 6

    instance-of v0, p1, Ljava/util/List;

    if-eqz v0, :cond_2e

    check-cast p1, Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_2a

    new-instance v0, La2/e$a;

    const/4 v2, 0x0

    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const/4 v3, 0x2

    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    invoke-direct {v0, v2, v1, p1}, La2/e$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-interface {p0, v0}, La2/e$b0;->b(Ljava/lang/Throwable;)V

    goto :goto_37

    :cond_2a
    invoke-interface {p0}, La2/e$b0;->a()V

    goto :goto_37

    :cond_2e
    const-string p1, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseCallbackApi.userSelectedalternativeBilling"

    invoke-static {p1}, La2/e;->a(Ljava/lang/String;)La2/e$a;

    move-result-object p1

    invoke-interface {p0, p1}, La2/e$b0;->b(Ljava/lang/Throwable;)V

    :goto_37
    return-void
.end method


# virtual methods
.method public h(Ljava/lang/Long;La2/e$b0;)V
    .registers 7

    new-instance v0, Lu1/b;

    iget-object v1, p0, La2/e$d;->a:Lu1/d;

    invoke-static {}, La2/e$d;->d()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseCallbackApi.onBillingServiceDisconnected"

    invoke-direct {v0, v1, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    new-instance v1, Ljava/util/ArrayList;

    invoke-static {p1}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object p1

    invoke-direct {v1, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    new-instance p1, La2/v;

    invoke-direct {p1, p2}, La2/v;-><init>(La2/e$b0;)V

    invoke-virtual {v0, v1, p1}, Lu1/b;->d(Ljava/lang/Object;Lu1/b$e;)V

    return-void
.end method

.method public i(La2/e$u;La2/e$b0;)V
    .registers 7

    new-instance v0, Lu1/b;

    iget-object v1, p0, La2/e$d;->a:Lu1/d;

    invoke-static {}, La2/e$d;->d()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseCallbackApi.onPurchasesUpdated"

    invoke-direct {v0, v1, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    new-instance v1, Ljava/util/ArrayList;

    invoke-static {p1}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object p1

    invoke-direct {v1, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    new-instance p1, La2/u;

    invoke-direct {p1, p2}, La2/u;-><init>(La2/e$b0;)V

    invoke-virtual {v0, v1, p1}, Lu1/b;->d(Ljava/lang/Object;Lu1/b$e;)V

    return-void
.end method

.method public j(La2/e$y;La2/e$b0;)V
    .registers 7

    new-instance v0, Lu1/b;

    iget-object v1, p0, La2/e$d;->a:Lu1/d;

    invoke-static {}, La2/e$d;->d()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseCallbackApi.userSelectedalternativeBilling"

    invoke-direct {v0, v1, v3, v2}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;)V

    new-instance v1, Ljava/util/ArrayList;

    invoke-static {p1}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object p1

    invoke-direct {v1, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    new-instance p1, La2/w;

    invoke-direct {p1, p2}, La2/w;-><init>(La2/e$b0;)V

    invoke-virtual {v0, v1, p1}, Lu1/b;->d(Ljava/lang/Object;Lu1/b$e;)V

    return-void
.end method
