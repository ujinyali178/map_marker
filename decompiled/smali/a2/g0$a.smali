.class La2/g0$a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/android/billingclient/api/BillingClientStateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La2/g0;->d(Ljava/lang/Long;La2/e$h;La2/e$a0;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private a:Z

.field final synthetic b:La2/e$a0;

.field final synthetic c:Ljava/lang/Long;

.field final synthetic d:La2/g0;


# direct methods
.method constructor <init>(La2/g0;La2/e$a0;Ljava/lang/Long;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    iput-object p1, p0, La2/g0$a;->d:La2/g0;

    iput-object p2, p0, La2/g0$a;->b:La2/e$a0;

    iput-object p3, p0, La2/g0$a;->c:Ljava/lang/Long;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 p1, 0x0

    iput-boolean p1, p0, La2/g0$a;->a:Z

    return-void
.end method


# virtual methods
.method public onBillingServiceDisconnected()V
    .registers 4

    iget-object v0, p0, La2/g0$a;->d:La2/g0;

    iget-object v0, v0, La2/g0;->h:La2/e$d;

    iget-object v1, p0, La2/g0$a;->c:Ljava/lang/Long;

    new-instance v2, La2/g0$a$a;

    invoke-direct {v2, p0}, La2/g0$a$a;-><init>(La2/g0$a;)V

    invoke-virtual {v0, v1, v2}, La2/e$d;->h(Ljava/lang/Long;La2/e$b0;)V

    return-void
.end method

.method public onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V
    .registers 3

    iget-boolean v0, p0, La2/g0$a;->a:Z

    if-eqz v0, :cond_c

    const-string p1, "InAppPurchasePlugin"

    const-string v0, "Tried to call onBillingSetupFinished multiple times."

    invoke-static {p1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_c
    const/4 v0, 0x1

    iput-boolean v0, p0, La2/g0$a;->a:Z

    iget-object v0, p0, La2/g0$a;->b:La2/e$a0;

    invoke-static {p1}, La2/i0;->c(Lcom/android/billingclient/api/BillingResult;)La2/e$k;

    move-result-object p1

    invoke-interface {v0, p1}, La2/e$a0;->a(Ljava/lang/Object;)V

    return-void
.end method
