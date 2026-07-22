.class public final synthetic Lcom/android/billingclient/api/zzcd;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/activity/result/b;


# instance fields
.field public final synthetic zza:Lcom/android/billingclient/api/ProxyBillingActivity;


# direct methods
.method public synthetic constructor <init>(Lcom/android/billingclient/api/ProxyBillingActivity;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzcd;->zza:Lcom/android/billingclient/api/ProxyBillingActivity;

    return-void
.end method


# virtual methods
.method public final onActivityResult(Ljava/lang/Object;)V
    .registers 3

    iget-object v0, p0, Lcom/android/billingclient/api/zzcd;->zza:Lcom/android/billingclient/api/ProxyBillingActivity;

    check-cast p1, Landroidx/activity/result/a;

    invoke-virtual {v0, p1}, Lcom/android/billingclient/api/ProxyBillingActivity;->onAlternativeBillingOnlyDialogResult(Landroidx/activity/result/a;)V

    return-void
.end method
