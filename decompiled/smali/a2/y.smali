.class public final synthetic La2/y;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/android/billingclient/api/ProductDetailsResponseListener;


# instance fields
.field public final synthetic a:La2/g0;

.field public final synthetic b:La2/e$a0;


# direct methods
.method public synthetic constructor <init>(La2/g0;La2/e$a0;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, La2/y;->a:La2/g0;

    iput-object p2, p0, La2/y;->b:La2/e$a0;

    return-void
.end method


# virtual methods
.method public final onProductDetailsResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V
    .registers 5

    iget-object v0, p0, La2/y;->a:La2/g0;

    iget-object v1, p0, La2/y;->b:La2/e$a0;

    invoke-static {v0, v1, p1, p2}, La2/g0;->v(La2/g0;La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void
.end method
