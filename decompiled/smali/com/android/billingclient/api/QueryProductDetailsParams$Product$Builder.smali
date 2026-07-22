.class public Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/billingclient/api/QueryProductDetailsParams$Product;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private zza:Ljava/lang/String;

.field private zzb:Ljava/lang/String;


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/billingclient/api/zzci;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static bridge synthetic zza(Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;)Ljava/lang/String;
    .registers 1

    iget-object p0, p0, Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;->zza:Ljava/lang/String;

    return-object p0
.end method

.method static bridge synthetic zzb(Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;)Ljava/lang/String;
    .registers 1

    iget-object p0, p0, Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;->zzb:Ljava/lang/String;

    return-object p0
.end method


# virtual methods
.method public build()Lcom/android/billingclient/api/QueryProductDetailsParams$Product;
    .registers 3

    iget-object v0, p0, Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;->zzb:Ljava/lang/String;

    const-string v1, "first_party"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_29

    iget-object v0, p0, Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;->zza:Ljava/lang/String;

    if-eqz v0, :cond_21

    iget-object v0, p0, Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;->zzb:Ljava/lang/String;

    if-eqz v0, :cond_19

    new-instance v0, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;-><init>(Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;Lcom/android/billingclient/api/zzcj;)V

    return-object v0

    :cond_19
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Product type must be provided."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_21
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Product id must be provided."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_29
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Serialized doc id must be provided for first party products."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setProductId(Ljava/lang/String;)Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;
    .registers 2

    iput-object p1, p0, Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;->zza:Ljava/lang/String;

    return-object p0
.end method

.method public setProductType(Ljava/lang/String;)Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;
    .registers 2

    iput-object p1, p0, Lcom/android/billingclient/api/QueryProductDetailsParams$Product$Builder;->zzb:Ljava/lang/String;

    return-object p0
.end method
