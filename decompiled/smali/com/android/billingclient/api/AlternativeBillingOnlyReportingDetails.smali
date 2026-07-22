.class public final Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final zza:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string p1, "externalTransactionToken"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;->zza:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getExternalTransactionToken()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;->zza:Ljava/lang/String;

    return-object v0
.end method
