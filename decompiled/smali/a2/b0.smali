.class public final synthetic La2/b0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;


# instance fields
.field public final synthetic a:La2/e$a0;


# direct methods
.method public synthetic constructor <init>(La2/e$a0;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, La2/b0;->a:La2/e$a0;

    return-void
.end method


# virtual methods
.method public final onAlternativeBillingOnlyAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;)V
    .registers 3

    iget-object v0, p0, La2/b0;->a:La2/e$a0;

    invoke-static {v0, p1}, La2/g0;->o(La2/e$a0;Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method
