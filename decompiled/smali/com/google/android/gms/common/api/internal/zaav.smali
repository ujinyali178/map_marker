.class abstract Lcom/google/android/gms/common/api/internal/zaav;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic zab:Lcom/google/android/gms/common/api/internal/zaaw;


# direct methods
.method synthetic constructor <init>(Lcom/google/android/gms/common/api/internal/zaaw;Lcom/google/android/gms/common/api/internal/zaau;)V
    .registers 3

    iput-object p1, p0, Lcom/google/android/gms/common/api/internal/zaav;->zab:Lcom/google/android/gms/common/api/internal/zaaw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaav;->zab:Lcom/google/android/gms/common/api/internal/zaaw;

    invoke-static {v0}, Lcom/google/android/gms/common/api/internal/zaaw;->zap(Lcom/google/android/gms/common/api/internal/zaaw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_9
    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    move-result v0
    :try_end_d
    .catch Ljava/lang/RuntimeException; {:try_start_9 .. :try_end_d} :catch_1f
    .catchall {:try_start_9 .. :try_end_d} :catchall_1d

    if-eqz v0, :cond_19

    :goto_f
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaav;->zab:Lcom/google/android/gms/common/api/internal/zaaw;

    invoke-static {v0}, Lcom/google/android/gms/common/api/internal/zaaw;->zap(Lcom/google/android/gms/common/api/internal/zaaw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-void

    :cond_19
    :try_start_19
    invoke-virtual {p0}, Lcom/google/android/gms/common/api/internal/zaav;->zaa()V
    :try_end_1c
    .catch Ljava/lang/RuntimeException; {:try_start_19 .. :try_end_1c} :catch_1f
    .catchall {:try_start_19 .. :try_end_1c} :catchall_1d

    goto :goto_f

    :catchall_1d
    move-exception v0

    goto :goto_2a

    :catch_1f
    move-exception v0

    :try_start_20
    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zaav;->zab:Lcom/google/android/gms/common/api/internal/zaaw;

    invoke-static {v1}, Lcom/google/android/gms/common/api/internal/zaaw;->zak(Lcom/google/android/gms/common/api/internal/zaaw;)Lcom/google/android/gms/common/api/internal/zabi;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/gms/common/api/internal/zabi;->zam(Ljava/lang/RuntimeException;)V
    :try_end_29
    .catchall {:try_start_20 .. :try_end_29} :catchall_1d

    goto :goto_f

    :goto_2a
    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zaav;->zab:Lcom/google/android/gms/common/api/internal/zaaw;

    invoke-static {v1}, Lcom/google/android/gms/common/api/internal/zaaw;->zap(Lcom/google/android/gms/common/api/internal/zaaw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method protected abstract zaa()V
.end method
