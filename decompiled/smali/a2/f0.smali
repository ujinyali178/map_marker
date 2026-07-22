.class public final synthetic La2/f0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/android/billingclient/api/PurchaseHistoryResponseListener;


# instance fields
.field public final synthetic a:La2/e$a0;


# direct methods
.method public synthetic constructor <init>(La2/e$a0;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, La2/f0;->a:La2/e$a0;

    return-void
.end method


# virtual methods
.method public final onPurchaseHistoryResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V
    .registers 4

    iget-object v0, p0, La2/f0;->a:La2/e$a0;

    invoke-static {v0, p1, p2}, La2/g0;->n(La2/e$a0;Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void
.end method
