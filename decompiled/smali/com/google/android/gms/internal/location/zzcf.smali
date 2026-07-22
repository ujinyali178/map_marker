.class public final synthetic Lcom/google/android/gms/internal/location/zzcf;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/tasks/OnTokenCanceledListener;


# instance fields
.field public final synthetic zza:Lcom/google/android/gms/common/internal/ICancelToken;


# direct methods
.method public synthetic constructor <init>(Lcom/google/android/gms/common/internal/ICancelToken;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/location/zzcf;->zza:Lcom/google/android/gms/common/internal/ICancelToken;

    return-void
.end method


# virtual methods
.method public final onCanceled()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/location/zzcf;->zza:Lcom/google/android/gms/common/internal/ICancelToken;

    sget v1, Lcom/google/android/gms/internal/location/zzda;->zze:I

    :try_start_4
    invoke-interface {v0}, Lcom/google/android/gms/common/internal/ICancelToken;->cancel()V
    :try_end_7
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_7} :catch_7

    :catch_7
    return-void
.end method
