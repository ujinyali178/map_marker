.class La2/h0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/android/billingclient/api/PurchasesUpdatedListener;


# instance fields
.field private final a:La2/e$d;


# direct methods
.method constructor <init>(La2/e$d;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, La2/h0;->a:La2/e$d;

    return-void
.end method


# virtual methods
.method public onPurchasesUpdated(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/billingclient/api/BillingResult;",
            "Ljava/util/List<",
            "Lcom/android/billingclient/api/Purchase;",
            ">;)V"
        }
    .end annotation

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

    iget-object p2, p0, La2/h0;->a:La2/e$d;

    invoke-virtual {p1}, La2/e$u$a;->a()La2/e$u;

    move-result-object p1

    new-instance v0, La2/h0$a;

    invoke-direct {v0, p0}, La2/h0$a;-><init>(La2/h0;)V

    invoke-virtual {p2, p1, v0}, La2/e$d;->i(La2/e$u;La2/e$b0;)V

    return-void
.end method
