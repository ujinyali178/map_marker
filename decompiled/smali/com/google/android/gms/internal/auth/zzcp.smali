.class public final Lcom/google/android/gms/internal/auth/zzcp;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static volatile zza:Lcom/google/android/gms/internal/auth/zzdh;


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static zza(Landroid/content/Context;)Lcom/google/android/gms/internal/auth/zzdh;
    .registers 15

    const-class v0, Lcom/google/android/gms/internal/auth/zzcp;

    monitor-enter v0

    :try_start_3
    sget-object v1, Lcom/google/android/gms/internal/auth/zzcp;->zza:Lcom/google/android/gms/internal/auth/zzdh;

    if-nez v1, :cond_174

    sget-object v1, Landroid/os/Build;->TYPE:Ljava/lang/String;

    sget-object v2, Landroid/os/Build;->TAGS:Ljava/lang/String;

    const-string v3, "eng"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1b

    const-string v3, "userdebug"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2c

    :cond_1b
    const-string v1, "dev-keys"

    invoke-virtual {v2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_33

    const-string v1, "test-keys"

    invoke-virtual {v2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2c

    goto :goto_33

    :cond_2c
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzdh;->zzc()Lcom/google/android/gms/internal/auth/zzdh;

    move-result-object p0

    :goto_30
    move-object v1, p0

    goto/16 :goto_16c

    :cond_33
    :goto_33
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzcc;->zzb()Z

    move-result v1

    if-eqz v1, :cond_43

    invoke-static {p0}, Landroidx/core/content/d;->a(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_43

    invoke-static {p0}, Landroidx/core/content/e;->a(Landroid/content/Context;)Landroid/content/Context;

    move-result-object p0

    :cond_43
    invoke-static {}, Landroid/os/StrictMode;->allowThreadDiskReads()Landroid/os/StrictMode$ThreadPolicy;

    move-result-object v1
    :try_end_47
    .catchall {:try_start_3 .. :try_end_47} :catchall_176

    :try_start_47
    invoke-static {}, Landroid/os/StrictMode;->allowThreadDiskWrites()Landroid/os/StrictMode$ThreadPolicy;
    :try_end_4a
    .catchall {:try_start_47 .. :try_end_4a} :catchall_16f

    const/4 v2, 0x0

    :try_start_4b
    new-instance v3, Ljava/io/File;

    const-string v4, "phenotype_hermetic"

    invoke-virtual {p0, v4, v2}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v4

    const-string v5, "overrides.txt"

    invoke-direct {v3, v4, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_58
    .catch Ljava/lang/RuntimeException; {:try_start_4b .. :try_end_58} :catch_68
    .catchall {:try_start_4b .. :try_end_58} :catchall_16f

    :try_start_58
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_63

    invoke-static {v3}, Lcom/google/android/gms/internal/auth/zzdh;->zzd(Ljava/lang/Object;)Lcom/google/android/gms/internal/auth/zzdh;

    move-result-object v3

    goto :goto_71

    :cond_63
    :goto_63
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzdh;->zzc()Lcom/google/android/gms/internal/auth/zzdh;

    move-result-object v3

    goto :goto_71

    :catch_68
    move-exception v3

    const-string v4, "HermeticFileOverrides"

    const-string v5, "no data dir"

    invoke-static {v4, v5, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_63

    :goto_71
    invoke-virtual {v3}, Lcom/google/android/gms/internal/auth/zzdh;->zzb()Z

    move-result v4

    if-eqz v4, :cond_163

    invoke-virtual {v3}, Lcom/google/android/gms/internal/auth/zzdh;->zza()Ljava/lang/Object;

    move-result-object v3
    :try_end_7b
    .catchall {:try_start_58 .. :try_end_7b} :catchall_16f

    :try_start_7b
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v5, Ljava/io/InputStreamReader;

    new-instance v6, Ljava/io/FileInputStream;

    move-object v7, v3

    check-cast v7, Ljava/io/File;

    invoke-direct {v6, v7}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v5, v6}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v4, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_8d
    .catch Ljava/io/IOException; {:try_start_7b .. :try_end_8d} :catch_15c
    .catchall {:try_start_7b .. :try_end_8d} :catchall_16f

    const/4 v5, 0x1

    const/4 v5, 0x1

    :try_start_8f
    new-instance v6, Landroidx/collection/g;

    invoke-direct {v6}, Landroidx/collection/g;-><init>()V

    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    :goto_99
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v8

    if-eqz v8, :cond_10d

    const-string v9, " "

    const/4 v10, 0x3

    invoke-virtual {v8, v9, v10}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v9

    array-length v11, v9

    if-eq v11, v10, :cond_c0

    const-string v9, "HermeticFileOverrides"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Invalid: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v9, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_99

    :cond_c0
    aget-object v8, v9, v2

    new-instance v10, Ljava/lang/String;

    invoke-direct {v10, v8}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    aget-object v8, v9, v5

    new-instance v11, Ljava/lang/String;

    invoke-direct {v11, v8}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    invoke-static {v11}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const/4 v11, 0x2

    aget-object v12, v9, v11

    invoke-interface {v7, v12}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    if-nez v12, :cond_f5

    aget-object v9, v9, v11

    new-instance v11, Ljava/lang/String;

    invoke-direct {v11, v9}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    invoke-static {v11}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v9

    const/16 v13, 0x400

    if-lt v9, v13, :cond_f2

    if-ne v12, v11, :cond_f5

    :cond_f2
    invoke-interface {v7, v11, v12}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_f5
    invoke-virtual {v6, v10}, Landroidx/collection/g;->containsKey(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_103

    new-instance v9, Landroidx/collection/g;

    invoke-direct {v9}, Landroidx/collection/g;-><init>()V

    invoke-virtual {v6, v10, v9}, Landroidx/collection/g;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_103
    invoke-virtual {v6, v10}, Landroidx/collection/g;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroidx/collection/g;

    invoke-virtual {v9, v8, v12}, Landroidx/collection/g;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_99

    :cond_10d
    const-string v7, "HermeticFileOverrides"

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p0

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Parsed "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " for Android package "

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {v7, p0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    new-instance p0, Lcom/google/android/gms/internal/auth/zzci;

    invoke-direct {p0, v6}, Lcom/google/android/gms/internal/auth/zzci;-><init>(Landroidx/collection/g;)V
    :try_end_138
    .catchall {:try_start_8f .. :try_end_138} :catchall_140

    :try_start_138
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_13b
    .catch Ljava/io/IOException; {:try_start_138 .. :try_end_13b} :catch_15c
    .catchall {:try_start_138 .. :try_end_13b} :catchall_16f

    :try_start_13b
    invoke-static {p0}, Lcom/google/android/gms/internal/auth/zzdh;->zzd(Ljava/lang/Object;)Lcom/google/android/gms/internal/auth/zzdh;

    move-result-object p0
    :try_end_13f
    .catchall {:try_start_13b .. :try_end_13f} :catchall_16f

    goto :goto_167

    :catchall_140
    move-exception p0

    :try_start_141
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_144
    .catchall {:try_start_141 .. :try_end_144} :catchall_145

    goto :goto_15b

    :catchall_145
    move-exception v3

    :try_start_146
    const-class v4, Ljava/lang/Throwable;

    const-string v6, "addSuppressed"

    new-array v7, v5, [Ljava/lang/Class;

    const-class v8, Ljava/lang/Throwable;

    aput-object v8, v7, v2

    invoke-virtual {v4, v6, v7}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    new-array v5, v5, [Ljava/lang/Object;

    aput-object v3, v5, v2

    invoke-virtual {v4, p0, v5}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_15b
    .catch Ljava/lang/Exception; {:try_start_146 .. :try_end_15b} :catch_15b
    .catchall {:try_start_146 .. :try_end_15b} :catchall_16f

    :catch_15b
    :goto_15b
    :try_start_15b
    throw p0
    :try_end_15c
    .catch Ljava/io/IOException; {:try_start_15b .. :try_end_15c} :catch_15c
    .catchall {:try_start_15b .. :try_end_15c} :catchall_16f

    :catch_15c
    move-exception p0

    :try_start_15d
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, p0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    :cond_163
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzdh;->zzc()Lcom/google/android/gms/internal/auth/zzdh;

    move-result-object p0
    :try_end_167
    .catchall {:try_start_15d .. :try_end_167} :catchall_16f

    :goto_167
    :try_start_167
    invoke-static {v1}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    goto/16 :goto_30

    :goto_16c
    sput-object v1, Lcom/google/android/gms/internal/auth/zzcp;->zza:Lcom/google/android/gms/internal/auth/zzdh;

    goto :goto_174

    :catchall_16f
    move-exception p0

    invoke-static {v1}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    throw p0

    :cond_174
    :goto_174
    monitor-exit v0

    return-object v1

    :catchall_176
    move-exception p0

    monitor-exit v0
    :try_end_178
    .catchall {:try_start_167 .. :try_end_178} :catchall_176

    throw p0
.end method
