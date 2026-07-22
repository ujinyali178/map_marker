.class final Lcom/google/android/gms/internal/auth/zzad;
.super Lcom/google/android/gms/internal/auth/zzah;
.source "SourceFile"


# instance fields
.field final synthetic zza:Lcom/google/android/gms/internal/auth/zzae;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/auth/zzae;)V
    .registers 2

    iput-object p1, p0, Lcom/google/android/gms/internal/auth/zzad;->zza:Lcom/google/android/gms/internal/auth/zzae;

    invoke-direct {p0}, Lcom/google/android/gms/internal/auth/zzah;-><init>()V

    return-void
.end method


# virtual methods
.method public final zzb(Landroid/accounts/Account;)V
    .registers 5

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzad;->zza:Lcom/google/android/gms/internal/auth/zzae;

    new-instance v1, Lcom/google/android/gms/internal/auth/zzai;

    if-eqz p1, :cond_9

    sget-object v2, Lcom/google/android/gms/common/api/Status;->RESULT_SUCCESS:Lcom/google/android/gms/common/api/Status;

    goto :goto_d

    :cond_9
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzal;->zza()Lcom/google/android/gms/common/api/Status;

    move-result-object v2

    :goto_d
    invoke-direct {v1, v2, p1}, Lcom/google/android/gms/internal/auth/zzai;-><init>(Lcom/google/android/gms/common/api/Status;Landroid/accounts/Account;)V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/internal/BasePendingResult;->setResult(Lcom/google/android/gms/common/api/Result;)V

    return-void
.end method
