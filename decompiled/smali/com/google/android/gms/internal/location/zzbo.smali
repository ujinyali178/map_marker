.class final Lcom/google/android/gms/internal/location/zzbo;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/common/api/internal/RemoteCall;
.implements Lcom/google/android/gms/internal/location/zzcs;


# instance fields
.field final synthetic zza:Lcom/google/android/gms/internal/location/zzbp;

.field private final zzb:Lcom/google/android/gms/internal/location/zzbn;

.field private zzc:Lcom/google/android/gms/common/api/internal/ListenerHolder;

.field private zzd:Z


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/location/zzbp;Lcom/google/android/gms/common/api/internal/ListenerHolder;Lcom/google/android/gms/internal/location/zzbn;)V
    .registers 4

    iput-object p1, p0, Lcom/google/android/gms/internal/location/zzbo;->zza:Lcom/google/android/gms/internal/location/zzbp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/google/android/gms/internal/location/zzbo;->zzd:Z

    iput-object p2, p0, Lcom/google/android/gms/internal/location/zzbo;->zzc:Lcom/google/android/gms/common/api/internal/ListenerHolder;

    iput-object p3, p0, Lcom/google/android/gms/internal/location/zzbo;->zzb:Lcom/google/android/gms/internal/location/zzbn;

    return-void
.end method


# virtual methods
.method public final bridge synthetic accept(Ljava/lang/Object;Ljava/lang/Object;)V
    .registers 6

    check-cast p1, Lcom/google/android/gms/internal/location/zzda;

    check-cast p2, Lcom/google/android/gms/tasks/TaskCompletionSource;

    monitor-enter p0

    :try_start_5
    iget-object v0, p0, Lcom/google/android/gms/internal/location/zzbo;->zzc:Lcom/google/android/gms/common/api/internal/ListenerHolder;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/ListenerHolder;->getListenerKey()Lcom/google/android/gms/common/api/internal/ListenerHolder$ListenerKey;

    move-result-object v0

    iget-boolean v1, p0, Lcom/google/android/gms/internal/location/zzbo;->zzd:Z

    iget-object v2, p0, Lcom/google/android/gms/internal/location/zzbo;->zzc:Lcom/google/android/gms/common/api/internal/ListenerHolder;

    invoke-virtual {v2}, Lcom/google/android/gms/common/api/internal/ListenerHolder;->clear()V

    monitor-exit p0
    :try_end_13
    .catchall {:try_start_5 .. :try_end_13} :catchall_21

    if-nez v0, :cond_1b

    sget-object p1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {p2, p1}, Lcom/google/android/gms/tasks/TaskCompletionSource;->setResult(Ljava/lang/Object;)V

    return-void

    :cond_1b
    iget-object v2, p0, Lcom/google/android/gms/internal/location/zzbo;->zzb:Lcom/google/android/gms/internal/location/zzbn;

    invoke-interface {v2, p1, v0, v1, p2}, Lcom/google/android/gms/internal/location/zzbn;->zza(Lcom/google/android/gms/internal/location/zzda;Lcom/google/android/gms/common/api/internal/ListenerHolder$ListenerKey;ZLcom/google/android/gms/tasks/TaskCompletionSource;)V

    return-void

    :catchall_21
    move-exception p1

    :try_start_22
    monitor-exit p0
    :try_end_23
    .catchall {:try_start_22 .. :try_end_23} :catchall_21

    throw p1
.end method

.method public final declared-synchronized zza()Lcom/google/android/gms/common/api/internal/ListenerHolder;
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/google/android/gms/internal/location/zzbo;->zzc:Lcom/google/android/gms/common/api/internal/ListenerHolder;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final zzb()V
    .registers 4

    monitor-enter p0

    const/4 v0, 0x0

    :try_start_2
    iput-boolean v0, p0, Lcom/google/android/gms/internal/location/zzbo;->zzd:Z

    iget-object v0, p0, Lcom/google/android/gms/internal/location/zzbo;->zzc:Lcom/google/android/gms/common/api/internal/ListenerHolder;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/ListenerHolder;->getListenerKey()Lcom/google/android/gms/common/api/internal/ListenerHolder$ListenerKey;

    move-result-object v0

    monitor-exit p0
    :try_end_b
    .catchall {:try_start_2 .. :try_end_b} :catchall_15

    if-eqz v0, :cond_14

    iget-object v1, p0, Lcom/google/android/gms/internal/location/zzbo;->zza:Lcom/google/android/gms/internal/location/zzbp;

    const/16 v2, 0x989

    invoke-virtual {v1, v0, v2}, Lcom/google/android/gms/common/api/GoogleApi;->doUnregisterEventListener(Lcom/google/android/gms/common/api/internal/ListenerHolder$ListenerKey;I)Lcom/google/android/gms/tasks/Task;

    :cond_14
    return-void

    :catchall_15
    move-exception v0

    :try_start_16
    monitor-exit p0
    :try_end_17
    .catchall {:try_start_16 .. :try_end_17} :catchall_15

    throw v0
.end method

.method public final declared-synchronized zzc(Lcom/google/android/gms/common/api/internal/ListenerHolder;)V
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/google/android/gms/internal/location/zzbo;->zzc:Lcom/google/android/gms/common/api/internal/ListenerHolder;

    if-eq v0, p1, :cond_c

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/ListenerHolder;->clear()V

    iput-object p1, p0, Lcom/google/android/gms/internal/location/zzbo;->zzc:Lcom/google/android/gms/common/api/internal/ListenerHolder;
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_e

    monitor-exit p0

    return-void

    :cond_c
    monitor-exit p0

    return-void

    :catchall_e
    move-exception p1

    monitor-exit p0

    throw p1
.end method
