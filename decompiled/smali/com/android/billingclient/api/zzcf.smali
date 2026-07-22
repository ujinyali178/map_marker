.class final Lcom/android/billingclient/api/zzcf;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final zza:Lcom/android/billingclient/api/BillingResult;

.field private final zzb:I


# direct methods
.method constructor <init>(Lcom/android/billingclient/api/BillingResult;I)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzcf;->zza:Lcom/android/billingclient/api/BillingResult;

    iput p2, p0, Lcom/android/billingclient/api/zzcf;->zzb:I

    return-void
.end method


# virtual methods
.method final zza()Lcom/android/billingclient/api/BillingResult;
    .registers 2

    iget-object v0, p0, Lcom/android/billingclient/api/zzcf;->zza:Lcom/android/billingclient/api/BillingResult;

    return-object v0
.end method

.method final zzb()I
    .registers 2

    iget v0, p0, Lcom/android/billingclient/api/zzcf;->zzb:I

    return v0
.end method
