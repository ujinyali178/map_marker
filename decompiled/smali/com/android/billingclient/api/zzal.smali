.class public final synthetic Lcom/android/billingclient/api/zzal;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/concurrent/Callable;


# instance fields
.field public final synthetic zza:Lcom/android/billingclient/api/zzao;


# direct methods
.method public synthetic constructor <init>(Lcom/android/billingclient/api/zzao;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzal;->zza:Lcom/android/billingclient/api/zzao;

    return-void
.end method


# virtual methods
.method public final call()Ljava/lang/Object;
    .registers 2

    iget-object v0, p0, Lcom/android/billingclient/api/zzal;->zza:Lcom/android/billingclient/api/zzao;

    invoke-virtual {v0}, Lcom/android/billingclient/api/zzao;->zza()Ljava/lang/Object;

    const/4 v0, 0x0

    return-object v0
.end method
