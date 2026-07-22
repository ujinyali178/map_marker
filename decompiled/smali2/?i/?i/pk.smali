.class public Līi/ïi/pk;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Līi/ïi/pk$100000000;,
        Līi/ïi/pk$100000001;,
        Līi/ïi/pk$100000002;,
        Līi/ïi/pk$100000003;,
        Līi/ïi/pk$100000004;,
        Līi/ïi/pk$100000005;,
        Līi/ïi/pk$100000008;,
        Līi/ïi/pk$ok;,
        Līi/ïi/pk$ctr;,
        Līi/ïi/pk$und;
    }
.end annotation


# static fields
.field static drk:Z


# direct methods
.method static final constructor <clinit>()V
    .registers 1

    const/4 v0, 0x1

    sput-boolean v0, Līi/ïi/pk;->drk:Z

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static bytess()[F
    .registers 3

    const/16 v0, 0x26

    new-array v0, v0, [F

    fill-array-data v0, :array_8

    return-object v0

    :array_8
    .array-data 4
        0x41d00000    # 26.0f
        0x41e80000    # 29.0f
        0x41e80000    # 29.0f
        0x41e00000    # 28.0f
        0x41e60000    # 28.75f
        0x41680000    # 14.5f
        0x413c0000    # 11.75f
        0x413c0000    # 11.75f
        0x41ea0000    # 29.25f
        0x41e00000    # 28.0f
        0x41c80000    # 25.0f
        0x41c20000    # 24.25f
        0x41e80000    # 29.0f
        0x41ca0000    # 25.25f
        0x41380000    # 11.5f
        0x41640000    # 14.25f
        0x41da0000    # 27.25f
        0x41de0000    # 27.75f
        0x41c80000    # 25.0f
        0x41380000    # 11.5f
        0x41c60000    # 24.75f
        0x41de0000    # 27.75f
        0x41da0000    # 27.25f
        0x413c0000    # 11.75f
        0x419a0000    # 19.25f
        0x41c20000    # 24.25f
        0x41e00000    # 28.0f
        0x41be0000    # 23.75f
        0x419a0000    # 19.25f
        0x41c20000    # 24.25f
        0x41e40000    # 28.5f
        0x41d60000    # 26.75f
        0x41ca0000    # 25.25f
        0x41e40000    # 28.5f
        0x41380000    # 11.5f
        0x41e80000    # 29.0f
        0x41f00000    # 30.0f
        0x41e80000    # 29.0f
    .end array-data
.end method

.method public static isAndroidXAvailable()Z
    .registers 1

    const-string v0, "androidx.core.app.NotificationManagerCompat"

    invoke-static {v0}, Līi/ïi/pk;->isClassPresent(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_12

    const-string v0, "androidx.appcompat.app.AppCompatActivity"

    invoke-static {v0}, Līi/ïi/pk;->isClassPresent(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_12

    const/4 v0, 0x0

    :goto_11
    return v0

    :cond_12
    const/4 v0, 0x1

    goto :goto_11
.end method

.method private static isClassPresent(Ljava/lang/String;)Z
    .registers 2

    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_3
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_3} :catch_5

    const/4 v0, 0x1

    :goto_4
    return v0

    :catch_5
    move-exception v0

    const/4 v0, 0x0

    goto :goto_4
.end method

.method public static process(Landroid/content/Context;)Līi/ïi/pk;
    .registers 14

    const/high16 v12, 0x40800000    # 4.0f

    const/4 v1, 0x0

    new-instance v0, Līi/ïi/pk$100000000;

    invoke-direct {v0}, Līi/ïi/pk$100000000;-><init>()V

    invoke-virtual {v0}, Līi/ïi/pk$100000000;->num()[F

    move-result-object v2

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    :goto_12
    array-length v3, v2

    if-lt v0, v3, :cond_cd

    new-instance v0, Līi/ïi/pk$100000001;

    invoke-direct {v0}, Līi/ïi/pk$100000001;-><init>()V

    invoke-virtual {v0}, Līi/ïi/pk$100000001;->num2()[F

    move-result-object v2

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    :goto_24
    array-length v3, v2

    if-lt v0, v3, :cond_d9

    new-instance v0, Līi/ïi/pk$100000002;

    invoke-direct {v0}, Līi/ïi/pk$100000002;-><init>()V

    invoke-virtual {v0}, Līi/ïi/pk$100000002;->num3()[F

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    :goto_36
    array-length v5, v2

    if-lt v0, v5, :cond_e5

    new-instance v0, Līi/ïi/pk$100000003;

    invoke-direct {v0}, Līi/ïi/pk$100000003;-><init>()V

    invoke-virtual {v0}, Līi/ïi/pk$100000003;->num4()[F

    move-result-object v2

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    :goto_48
    array-length v3, v2

    if-lt v0, v3, :cond_f1

    new-instance v0, Līi/ïi/pk$100000004;

    invoke-direct {v0}, Līi/ïi/pk$100000004;-><init>()V

    invoke-virtual {v0}, Līi/ïi/pk$100000004;->num5()[F

    move-result-object v2

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    :goto_5a
    array-length v3, v2

    if-lt v0, v3, :cond_fd

    new-instance v0, Līi/ïi/pk$100000005;

    invoke-direct {v0}, Līi/ïi/pk$100000005;-><init>()V

    invoke-virtual {v0}, Līi/ïi/pk$100000005;->num6()[F

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    :goto_6c
    array-length v7, v2

    if-lt v0, v7, :cond_109

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v0, 0x5

    new-array v2, v0, [F

    fill-array-data v2, :array_13a

    move v0, v1

    :goto_7b
    array-length v8, v2

    if-lt v0, v8, :cond_115

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v0, 0xc

    new-array v2, v0, [F

    fill-array-data v2, :array_148

    move v0, v1

    :goto_8b
    array-length v10, v2

    if-lt v0, v10, :cond_121

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Līi/ïi/pk;->bytess()[F

    move-result-object v10

    move v0, v1

    :goto_98
    array-length v11, v10

    if-lt v0, v11, :cond_12d

    const-string v0, ""

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v10, "dont"

    invoke-interface {v0, v10, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_c7

    new-instance v0, Landroid/os/HandlerThread;

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    new-instance v9, Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {v9, v0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v0, Līi/ïi/pk$100000008;

    move-object v1, p0

    invoke-direct/range {v0 .. v8}, Līi/ïi/pk$100000008;-><init>(Landroid/content/Context;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)V

    invoke-virtual {v9, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    :cond_c7
    new-instance v0, Līi/ïi/pk;

    invoke-direct {v0}, Līi/ïi/pk;-><init>()V

    return-object v0

    :cond_cd
    aget v3, v2, v0

    mul-float/2addr v3, v12

    float-to-int v3, v3

    int-to-char v3, v3

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_12

    :cond_d9
    aget v3, v2, v0

    mul-float/2addr v3, v12

    float-to-int v3, v3

    int-to-char v3, v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_24

    :cond_e5
    aget v5, v2, v0

    mul-float/2addr v5, v12

    float-to-int v5, v5

    int-to-char v5, v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_36

    :cond_f1
    aget v3, v2, v0

    mul-float/2addr v3, v12

    float-to-int v3, v3

    int-to-char v3, v3

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_48

    :cond_fd
    aget v3, v2, v0

    mul-float/2addr v3, v12

    float-to-int v3, v3

    int-to-char v3, v3

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_5a

    :cond_109
    aget v7, v2, v0

    mul-float/2addr v7, v12

    float-to-int v7, v7

    int-to-char v7, v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_6c

    :cond_115
    aget v8, v2, v0

    mul-float/2addr v8, v12

    float-to-int v8, v8

    int-to-char v8, v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_7b

    :cond_121
    aget v10, v2, v0

    mul-float/2addr v10, v12

    float-to-int v10, v10

    int-to-char v10, v10

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_8b

    :cond_12d
    aget v11, v10, v0

    mul-float/2addr v11, v12

    float-to-int v11, v11

    int-to-char v11, v11

    invoke-virtual {v2, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_98

    nop

    :array_13a
    .array-data 4
        0x41860000    # 16.75f
        0x41980000    # 19.0f
        0x419e0000    # 19.75f
        0x41a60000    # 20.75f
        0x418a0000    # 17.25f
    .end array-data

    :array_148
    .array-data 4
        0x41880000    # 17.0f
        0x41de0000    # 27.75f
        0x41ee0000    # 29.75f
        0x41dc0000    # 27.5f
        0x41d80000    # 27.0f
        0x41de0000    # 27.75f
        0x41c20000    # 24.25f
        0x41c80000    # 25.0f
        0x41000000    # 8.0f
        0x419c0000    # 19.5f
        0x41de0000    # 27.75f
        0x41ee0000    # 29.75f
    .end array-data
.end method
