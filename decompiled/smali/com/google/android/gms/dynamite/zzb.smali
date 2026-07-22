.class public final Lcom/google/android/gms/dynamite/zzb;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static zza:Ljava/lang/ClassLoader;

.field private static zzb:Ljava/lang/Thread;


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method public static declared-synchronized zza()Ljava/lang/ClassLoader;
    .registers 11

    const-class v0, Lcom/google/android/gms/dynamite/zzb;

    monitor-enter v0

    :try_start_3
    sget-object v1, Lcom/google/android/gms/dynamite/zzb;->zza:Ljava/lang/ClassLoader;

    if-nez v1, :cond_d1

    sget-object v1, Lcom/google/android/gms/dynamite/zzb;->zzb:Ljava/lang/Thread;

    const/4 v2, 0x0

    if-nez v1, :cond_a6

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getThreadGroup()Ljava/lang/ThreadGroup;

    move-result-object v1

    if-nez v1, :cond_1d

    move-object v1, v2

    goto/16 :goto_9f

    :cond_1d
    const-class v3, Ljava/lang/Void;

    monitor-enter v3
    :try_end_20
    .catchall {:try_start_3 .. :try_end_20} :catchall_d5

    :try_start_20
    invoke-virtual {v1}, Ljava/lang/ThreadGroup;->activeGroupCount()I

    move-result v4

    new-array v5, v4, [Ljava/lang/ThreadGroup;

    invoke-virtual {v1, v5}, Ljava/lang/ThreadGroup;->enumerate([Ljava/lang/ThreadGroup;)I

    const/4 v6, 0x0

    const/4 v7, 0x0

    :goto_2b
    if-ge v7, v4, :cond_3f

    aget-object v8, v5, v7

    const-string v9, "dynamiteLoader"

    invoke-virtual {v8}, Ljava/lang/ThreadGroup;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3c

    goto :goto_40

    :cond_3c
    add-int/lit8 v7, v7, 0x1

    goto :goto_2b

    :cond_3f
    move-object v8, v2

    :goto_40
    if-nez v8, :cond_49

    new-instance v8, Ljava/lang/ThreadGroup;

    const-string v4, "dynamiteLoader"

    invoke-direct {v8, v1, v4}, Ljava/lang/ThreadGroup;-><init>(Ljava/lang/ThreadGroup;Ljava/lang/String;)V

    :cond_49
    invoke-virtual {v8}, Ljava/lang/ThreadGroup;->activeCount()I

    move-result v1

    new-array v4, v1, [Ljava/lang/Thread;

    invoke-virtual {v8, v4}, Ljava/lang/ThreadGroup;->enumerate([Ljava/lang/Thread;)I

    :goto_52
    if-ge v6, v1, :cond_66

    aget-object v5, v4, v6

    const-string v7, "GmsDynamite"

    invoke-virtual {v5}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7
    :try_end_60
    .catch Ljava/lang/SecurityException; {:try_start_20 .. :try_end_60} :catch_80
    .catchall {:try_start_20 .. :try_end_60} :catchall_7e

    if-eqz v7, :cond_63

    goto :goto_67

    :cond_63
    add-int/lit8 v6, v6, 0x1

    goto :goto_52

    :cond_66
    move-object v5, v2

    :goto_67
    if-nez v5, :cond_9d

    :try_start_69
    new-instance v1, Lcom/google/android/gms/dynamite/zza;

    const-string v4, "GmsDynamite"

    invoke-direct {v1, v8, v4}, Lcom/google/android/gms/dynamite/zza;-><init>(Ljava/lang/ThreadGroup;Ljava/lang/String;)V
    :try_end_70
    .catch Ljava/lang/SecurityException; {:try_start_69 .. :try_end_70} :catch_7b
    .catchall {:try_start_69 .. :try_end_70} :catchall_7e

    :try_start_70
    invoke-virtual {v1, v2}, Ljava/lang/Thread;->setContextClassLoader(Ljava/lang/ClassLoader;)V

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V
    :try_end_76
    .catch Ljava/lang/SecurityException; {:try_start_70 .. :try_end_76} :catch_78
    .catchall {:try_start_70 .. :try_end_76} :catchall_7e

    move-object v5, v1

    goto :goto_9d

    :catch_78
    move-exception v4

    move-object v5, v1

    goto :goto_83

    :catch_7b
    move-exception v1

    move-object v4, v1

    goto :goto_83

    :catchall_7e
    move-exception v1

    goto :goto_a4

    :catch_80
    move-exception v1

    move-object v4, v1

    move-object v5, v2

    :goto_83
    :try_start_83
    const-string v1, "DynamiteLoaderV2CL"

    invoke-virtual {v4}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v4

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Failed to enumerate thread/threadgroup "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_9d
    :goto_9d
    monitor-exit v3
    :try_end_9e
    .catchall {:try_start_83 .. :try_end_9e} :catchall_7e

    move-object v1, v5

    :goto_9f
    :try_start_9f
    sput-object v1, Lcom/google/android/gms/dynamite/zzb;->zzb:Ljava/lang/Thread;
    :try_end_a1
    .catchall {:try_start_9f .. :try_end_a1} :catchall_d5

    if-nez v1, :cond_a6

    goto :goto_cc

    :goto_a4
    :try_start_a4
    monitor-exit v3
    :try_end_a5
    .catchall {:try_start_a4 .. :try_end_a5} :catchall_7e

    :try_start_a5
    throw v1

    :cond_a6
    monitor-enter v1
    :try_end_a7
    .catchall {:try_start_a5 .. :try_end_a7} :catchall_d5

    :try_start_a7
    sget-object v3, Lcom/google/android/gms/dynamite/zzb;->zzb:Ljava/lang/Thread;

    invoke-virtual {v3}, Ljava/lang/Thread;->getContextClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2
    :try_end_ad
    .catch Ljava/lang/SecurityException; {:try_start_a7 .. :try_end_ad} :catch_b0
    .catchall {:try_start_a7 .. :try_end_ad} :catchall_ae

    goto :goto_cb

    :catchall_ae
    move-exception v2

    goto :goto_cf

    :catch_b0
    move-exception v3

    :try_start_b1
    const-string v4, "DynamiteLoaderV2CL"

    invoke-virtual {v3}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v3

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Failed to get thread context classloader "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v4, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :goto_cb
    monitor-exit v1
    :try_end_cc
    .catchall {:try_start_b1 .. :try_end_cc} :catchall_ae

    :goto_cc
    :try_start_cc
    sput-object v2, Lcom/google/android/gms/dynamite/zzb;->zza:Ljava/lang/ClassLoader;
    :try_end_ce
    .catchall {:try_start_cc .. :try_end_ce} :catchall_d5

    goto :goto_d1

    :goto_cf
    :try_start_cf
    monitor-exit v1
    :try_end_d0
    .catchall {:try_start_cf .. :try_end_d0} :catchall_ae

    :try_start_d0
    throw v2

    :cond_d1
    :goto_d1
    sget-object v1, Lcom/google/android/gms/dynamite/zzb;->zza:Ljava/lang/ClassLoader;
    :try_end_d3
    .catchall {:try_start_d0 .. :try_end_d3} :catchall_d5

    monitor-exit v0

    return-object v1

    :catchall_d5
    move-exception v1

    monitor-exit v0

    throw v1
.end method
