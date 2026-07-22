.class public final Lcom/android/billingclient/api/AlternativeChoiceDetails;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/billingclient/api/AlternativeChoiceDetails$Product;
    }
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field private final zza:Ljava/lang/String;

.field private final zzb:Lorg/json/JSONObject;

.field private final zzc:Ljava/util/List;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .registers 7

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/AlternativeChoiceDetails;->zza:Ljava/lang/String;

    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/android/billingclient/api/AlternativeChoiceDetails;->zzb:Lorg/json/JSONObject;

    const-string p1, "products"

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object p1

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    if-eqz p1, :cond_32

    const/4 v1, 0x0

    :goto_1a
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v1, v2, :cond_32

    invoke-virtual {p1, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_2f

    new-instance v3, Lcom/android/billingclient/api/AlternativeChoiceDetails$Product;

    const/4 v4, 0x0

    invoke-direct {v3, v2, v4}, Lcom/android/billingclient/api/AlternativeChoiceDetails$Product;-><init>(Lorg/json/JSONObject;Lcom/android/billingclient/api/zzc;)V

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_2f
    add-int/lit8 v1, v1, 0x1

    goto :goto_1a

    :cond_32
    iput-object v0, p0, Lcom/android/billingclient/api/AlternativeChoiceDetails;->zzc:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public getExternalTransactionToken()Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Lcom/android/billingclient/api/AlternativeChoiceDetails;->zzb:Lorg/json/JSONObject;

    const-string v1, "externalTransactionToken"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getOriginalExternalTransactionId()Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Lcom/android/billingclient/api/AlternativeChoiceDetails;->zzb:Lorg/json/JSONObject;

    const-string v1, "originalExternalTransactionId"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_f

    const/4 v0, 0x0

    :cond_f
    return-object v0
.end method

.method public getProducts()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/android/billingclient/api/AlternativeChoiceDetails$Product;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/android/billingclient/api/AlternativeChoiceDetails;->zzc:Ljava/util/List;

    return-object v0
.end method
