.class public final synthetic La2/b;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/android/billingclient/api/UserChoiceBillingListener;


# instance fields
.field public final synthetic a:La2/c;

.field public final synthetic b:La2/e$d;


# direct methods
.method public synthetic constructor <init>(La2/c;La2/e$d;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, La2/b;->a:La2/c;

    iput-object p2, p0, La2/b;->b:La2/e$d;

    return-void
.end method


# virtual methods
.method public final userSelectedAlternativeBilling(Lcom/android/billingclient/api/UserChoiceDetails;)V
    .registers 4

    iget-object v0, p0, La2/b;->a:La2/c;

    iget-object v1, p0, La2/b;->b:La2/e$d;

    invoke-static {v0, v1, p1}, La2/c;->b(La2/c;La2/e$d;Lcom/android/billingclient/api/UserChoiceDetails;)V

    return-void
.end method
