.class public final Lcom/android/billingclient/api/zzbv;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private zza:Z


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/billingclient/api/zzbu;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final zza()Lcom/android/billingclient/api/zzbv;
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/billingclient/api/zzbv;->zza:Z

    return-object p0
.end method

.method public final zzb()Lcom/android/billingclient/api/zzbx;
    .registers 5

    iget-boolean v0, p0, Lcom/android/billingclient/api/zzbv;->zza:Z

    if-eqz v0, :cond_d

    new-instance v0, Lcom/android/billingclient/api/zzbx;

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3}, Lcom/android/billingclient/api/zzbx;-><init>(ZZLcom/android/billingclient/api/zzbw;)V

    return-object v0

    :cond_d
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Pending purchases for one-time products must be supported."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
